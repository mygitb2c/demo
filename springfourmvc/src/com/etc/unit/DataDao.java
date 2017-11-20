package com.etc.unit;

import java.io.UnsupportedEncodingException;

public class DataDao {

	public static String encoding(String str) throws UnsupportedEncodingException {
		String nstr=new String(str.getBytes("iso8859-1"), "utf-8");
		if(str.length()>nstr.length()) {
			str=nstr;
		}	
		return str;
	}
	
}
