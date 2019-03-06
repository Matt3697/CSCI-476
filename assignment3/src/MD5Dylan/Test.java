package MD5Dylan;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Test {
    public static String getMd5(String input) {
        try {
            // call getInstance method with hashing MD5
            MessageDigest m = MessageDigest.getInstance("MD5");
            // call digest() method  to calculate message digest
            byte[] messageDigest = m.digest(input.getBytes());
            // Convert the byte array into signum representation
            BigInteger n = new BigInteger(1, messageDigest);
            // Convert the message digest into hex value
            String hashtext = n.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}