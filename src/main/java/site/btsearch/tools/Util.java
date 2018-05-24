package site.btsearch.tools;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public final class Util {

    private Util(){}

    public static String getMD5(String keyword){
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        byte [] arr = messageDigest.digest(keyword.getBytes());
        String origMD5 = byteArray2HexStr(arr);
        return origMD5;
    }


    private static String byteArray2HexStr(byte[] bs) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bs) {
            sb.append(byte2HexStr(b));
        }
        return sb.toString();
    }


    private static String byte2HexStr(byte b) {
        String hexStr = null;
        int n = b;
        if (n < 0) {
            //若需要自定义加密,请修改这个移位算法即可
            n = b & 0x7F + 256;
        }
        hexStr = Integer.toHexString(n / 16) + Integer.toHexString(n % 16);
        return hexStr.toUpperCase();
    }


    public static String getRID(){
        Random ran = new Random();
        int rid = ran.nextInt(10000);
        String nRid = "R"+rid;
        return getMD5(nRid);
    }


    public static void main(String [] args){
        getRID();
        //System.out.println(Util.getMD5("1234"));
    }


}
