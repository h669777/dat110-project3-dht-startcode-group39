package no.hvl.dat110.util;

/**
 * exercise/demo purpose in dat110
 * @author tdoy
 *
 */

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash { 
	
	
	public static BigInteger hashOf(String entity) {	
		
		BigInteger hashint = null;
		
		// Task: Hash a given string using MD5 and return the result as a BigInteger.
		try {
			// we use MD5 with 128 bits digest
			MessageDigest md5 = MessageDigest.getInstance("MD5");

			// compute the hash of the input 'entity'
			byte[] hash = md5.digest(entity.getBytes());

			// convert the hash into hex format
			String hashString = toHex(hash);

			// convert the hex into BigInteger
			hashint = new BigInteger(hashString,16);

		} catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

		// return the BigInteger
        return hashint;
	}
	
	public static BigInteger addressSize() {
		
		// Task: compute the address size of MD5
		
		// compute the number of bits = bitSize()
		int numBits = bitSize();
		
		// compute the address size = 2 ^ number of bits
        // return the address size
		return new BigInteger("2").pow(numBits);
	}
	
	public static int bitSize() {

		
		// find the digest length
		int digestlen = 16;
		
		return digestlen*8;
	}
	
	public static String toHex(byte[] digest) {
		StringBuilder strbuilder = new StringBuilder();
		for(byte b : digest) {
			strbuilder.append(String.format("%02x", b&0xff));
		}
		return strbuilder.toString();
	}

}
