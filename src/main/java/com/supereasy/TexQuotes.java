package com.supereasy;

import java.util.*;
import java.util.regex.*;
import java.io.*;

public class TexQuotes {

	public static void main(String[] args) throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(TexQuotes.class.getClassLoader().getResourceAsStream("texQuotes1.txt")));
		StringBuilder builder = new StringBuilder();
		String data;
		while((data = reader.readLine()) != null) {
			builder.append(data.trim());
			builder.append("\n");
		}
		builder.deleteCharAt(builder.length() - 1);
		Pattern pattern = Pattern.compile("\"");
		Matcher matcher = pattern.matcher(builder.toString());
		boolean isSecond = false;
		int i = 0;
		while(matcher.find()) {
			if(isSecond) {
				builder.replace(matcher.start() + i, matcher.end() + i, "''");
				isSecond = false;
			} else {
				builder.replace(matcher.start() + i, matcher.end() + i, "``");
				isSecond = true;
			}
			i++;
		}
		System.out.println(builder.toString());
	}
}
