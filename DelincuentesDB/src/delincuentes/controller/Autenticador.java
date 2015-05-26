package delincuentes.controller;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Autenticador {
	
	private static String algoritmo;
	private static String charset;

	public Autenticador() {
		algoritmo = "MD5";
		charset = "iso-8859-1";
	}
	
	public static String StringToMD5(String pass) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest md;
        md = MessageDigest.getInstance(algoritmo);
        byte[] md5hash = new byte[32];
        md.update(pass.getBytes(charset), 0, pass.length());
        md5hash = md.digest();
        return convertirToHex(md5hash);
	}
	
	private static String convertirToHex(byte[] data) {
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < data.length; i++) { 
            int halfbyte = (data[i] >>> 4) & 0x0F;
            int two_halfs = 0;
            do { 
                if ((0 <= halfbyte) && (halfbyte <= 9)) 
                    buf.append((char) ('0' + halfbyte));
                else 
                    buf.append((char) ('a' + (halfbyte - 10)));
                halfbyte = data[i] & 0x0F;
            } while(two_halfs++ < 1);
        } 
        return buf.toString();
	}
}
