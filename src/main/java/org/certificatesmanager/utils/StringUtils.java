package org.certificatesmanager.utils;

public class StringUtils {

	public static String toHexString(byte[] source){
		StringBuffer str = new StringBuffer();		
		int i=0;
		while(i<source.length){
			byte2hex(source[i], str);
			if(i<source.length-1){
				str.append(":");
			}
			i++;
		}
		return str.toString();		
	}
	
	private static void byte2hex(byte b, StringBuffer buf) {
		char[] hexChars = { '0', '1', '2', '3', '4', '5', '6', '7', '8',
				'9', 'A', 'B', 'C', 'D', 'E', 'F' };
		int high = ((b & 0xf0) >> 4);
		int low = (b & 0x0f);
		buf.append(hexChars[high]);
        buf.append(hexChars[low]);
    }

}
