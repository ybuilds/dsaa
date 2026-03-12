package in.ybuilds.misc;

import java.util.Scanner;

public class IpAddressUtils {
    public boolean isValidIp(String ip) {
        String[] octets = ip.split("\\.");

        if(octets.length != 4)
            return false;

        for(String octet : octets) {
            try {
                int value = Integer.parseInt(octet);
                if(value < 0 || value > 255)
                    return false;
            } catch(NumberFormatException e) {
                return false;
            }
        }
        return true;
    }

    public String getDefaultSubnet(Character cls) {
        switch (cls) {
            case 'A':
                return "255.0.0.0";
            case 'B':
                return "255.255.0.0";
            case 'C':
                return "255.255.255.0";
            default:
                return "Restricted IP";
        }
    }

    public String toDecimal(String ip) {
        StringBuilder sb = new StringBuilder();
        String[] octets = ip.split("\\.");

        for(String octet: octets) {
            int sum = 0;
            for(int i=octet.length()-1, j=0; i>=0; i--, j++)
                sum += (int) Math.pow(2, j) * (octet.charAt(i) - '0');
            sb.append(sum);
            sb.append(".");
        }

        return sb.toString();
    }

    public String getCustomSubnet(int ones) {
        StringBuilder sb = new StringBuilder();
        int zeroes=32-ones;

        for(int i=1; i<=ones; i++) {
            sb.append(1);
            if(i%8 == 0)
                sb.append(".");
        }

        for(int i=1; i<=zeroes; i++) {
            sb.append(0);
            if(i%8 == 0)
                sb.append(".");
        }

        return toDecimal(sb.toString());
    }

    public int getBorrowBits(String ip, int prefix) {
        Character cls = getClass(ip);
        int defaultBits = -1;

        switch (cls) {
            case 'A':
                defaultBits = 8;
                break;
            case 'B':
                defaultBits = 16;
                break;
            case 'C':
                defaultBits = 24;
                break;
            default:
                defaultBits = 0;
        }

        return Math.abs(defaultBits - prefix);
    }

    public Character getClass(String ip) {
        String[] octet = ip.split("\\.");
        int first = Integer.parseInt(octet[0]);

        if (first >= 0 && first <= 127)
            return 'A';
        else if (first >= 128 && first <= 191)
            return 'B';
        else if (first >= 192 && first <= 223)
            return 'C';
        else if (first >= 224 && first <= 239)
            return 'D';
        else if (first >= 240 && first <= 255)
            return 'E';
        else
            return '!';
    }

    public void toBinary(String ip) {
        StringBuilder sb = new StringBuilder();
        System.out.print("Binary IP: ");
        for(String str: ip.split("\\.")) {
            String octet = Integer.toBinaryString(Integer.parseInt(str));
            sb.append("0".repeat(8 - octet.length()));
            sb.append(octet);
            System.out.print(sb + ".");
            sb.delete(0, sb.length());
        }
        System.out.println();
    }

    public String getNetId(String ip, Character cls) {
        StringBuilder sb = new StringBuilder();
        String[] octets = ip.split("\\.");
        switch (cls) {
            case 'A':
                sb.append(octets[0]).append(".");
                sb.append("0.0.0.");
                break;
            case 'B':
                sb.append(octets[0]).append(".");
                sb.append(octets[1]).append(".");
                sb.append("0.0.");
                break;
            case 'C':
                sb.append(octets[0]).append(".");
                sb.append(octets[1]).append(".");
                sb.append(octets[2]).append(".");
                sb.append("0.");
                break;
            default:
                sb.append(ip).append(" NOT POSSIBLE");
        }

        return sb.toString();
    }

    public String getHostId(String ip, Character cls, int prefix) {
        if(prefix > 0)
            return "0".repeat(32-prefix);

        switch (cls) {
            case 'A':
                return "0.0.0";
            case 'B':
                return "0.0";
            case 'C':
                return "0";
            default:
                return "NOT POSSIBLE";
        }
    }

    public String getNthIp(String ip, int n) {
        String[] octets = ip.split("\\.");

        long value = 0;
        for (int i = 0; i < 4; i++) {
            value = value * 256 + Integer.parseInt(octets[i]);
        }

        value += (n - 1);

        long o1 = (value >> 24) & 255;
        long o2 = (value >> 16) & 255;
        long o3 = (value >> 8) & 255;
        long o4 = value & 255;

        return o1 + "." + o2 + "." + o3 + "." + o4;
    }

    public void createSubnets(String ip, int[] required) {
        String current = ip;

        for(int i = 0; i < required.length; i++) {

            int addresses = required[i];

            int prefix = 32 - (int)(Math.log(addresses) / Math.log(2));

            System.out.println("Subnet " + (i+1));
            System.out.println("Required addresses: " + addresses);
            System.out.println("Prefix: /" + prefix);

            System.out.println("Network ID: " + current);

            String lastIp = getNthIp(current, addresses);
            System.out.println("Broadcast: " + lastIp);

            String firstHost = getNthIp(current, 2);
            String lastHost = getNthIp(current, addresses - 1);

            System.out.println("First Host: " + firstHost);
            System.out.println("Last Host: " + lastHost);

            current = getNthIp(current, addresses + 1);

            System.out.println();
        }
    }

    public static void main(String[] args) {
        IpAddressUtils object = new IpAddressUtils();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter IP address: ");
        String ip = scanner.nextLine();

        System.out.print("Enter prefix, if any: ");
        int ones = scanner.nextInt();

        if (object.isValidIp(ip))
            System.out.println("VALID IP");
        else {
            System.out.println("INVALID IP! Exiting!");
            return;
        }

        object.toBinary(ip);

        Character cls = object.getClass(ip);
        System.out.println("Class of IP: " + cls);

        String defSubnet = object.getDefaultSubnet(cls);
        System.out.println("Default subnet: " + defSubnet);

        String cusSubnet = object.getCustomSubnet(ones);
        System.out.println("Custom subnet: " + cusSubnet);

        int borrow = object.getBorrowBits(ip, ones);
        System.out.println("Borrowed bits: " + borrow);
        System.out.println("Number of subnets: " + (int)Math.pow(2, borrow));

        int totalHosts = (int)Math.pow(2, 32-ones);
        System.out.println("Total number of host addresses: " + totalHosts);

        int usableHosts = totalHosts - 2;
        System.out.println("Total number of usable host addresses: " + usableHosts);

        String netId = object.getNetId(ip, cls);
        System.out.println("Net ID: " + netId);

        String hostId = object.getHostId(ip, cls, ones);
        System.out.println("Host ID: " + hostId);

        String tenthIp = object.getNthIp(ip, 10);
        String twentiethIp = object.getNthIp(ip, 20);
        System.out.println("10th IP: " + tenthIp);
        System.out.println("20th IP: " + twentiethIp);

        System.out.print("Create subsets? (0: No 1: Yes): ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.print("Enter number of subnets to be created: ");
            int n = scanner.nextInt();

            System.out.print("Enter the required addresses for each subnet: ");
            int[] required = new int[n];
            for(int i=0; i<n; i++)
                required[i] = scanner.nextInt();

            object.createSubnets(ip, required);
        } else
            System.out.println("BYE!");
    }
}
