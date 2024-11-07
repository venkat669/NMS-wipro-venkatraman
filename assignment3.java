//"EDGE CASE AND SPECIAL CHARACTERS HANDLING"


import java.util.Scanner;

class assignment3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter Hostname: ");
        String host_name = sc.next();
        
        System.out.print("Enter IP Address: ");
        String ip = sc.next();
        
        boolean isError = false;
        
        // Validate hostname
        if (host_name.isEmpty() || !isValidName(host_name)) {
            System.out.println("ERROR! Enter a Valid Hostname.");
            isError = true;
        }
        
        // Validate IP address
        if (!isValidIp(ip)) {
            System.out.println("Enter a valid IP in either IPv4 or IPv6 format");
            isError = true;
        }
        
        // If no error, confirm connection
        if (!isError) {
            System.out.println(host_name + " is connected to " + ip);
        }
        
        sc.close();
    }
    
    // Check if the hostname is valid, including length and special characters
    public static boolean isValidName(String host_name) {
        // Length check for long hostname
        if (host_name.length() > 253) {
            return false;
        }
        // Allow alphanumeric, dots, hyphens, and optional underscore
        return host_name.matches("[A-Za-z0-9._-]+");
    }
    
    // Determine IP type and validate accordingly
    public static boolean isValidIp(String ip) {
        String[] ip_arr;
        
        if (ip.contains(".")) {
            // Split for IPv4 and validate
            ip_arr = ip.split("\\.");
            return checkIPv4(ip_arr);
        } else if (ip.contains(":")) {
            // Split for IPv6 and validate
            ip_arr = ip.split(":");
            return checkIPv6(ip_arr);
        }
        return false; // Not a valid IP format
    }
    
    // IPv4 validation with leading zero check
    public static boolean checkIPv4(String[] ip_arr) {
        if (ip_arr.length != 4) return false;
        
        for (String segment : ip_arr) {
            try {
                if (segment.length() > 1 && segment.startsWith("0")) return false; // No leading zeros allowed
                int num = Integer.parseInt(segment);
                if (num < 0 || num > 255) return false; // Range check
            } catch (NumberFormatException e) {
                return false; // Not a valid integer
            }
        }
        return true;
    }
    
    // IPv6 validation for valid hexadecimal segments
    public static boolean checkIPv6(String[] ip_arr) {
        if (ip_arr.length != 8) return false;
        
        for (String segment : ip_arr) {
            if (!segment.matches("[0-9a-fA-F]{1,4}")) {
                return false; // Check each segment for valid hex
            }
        }
        return true;
    }
}
