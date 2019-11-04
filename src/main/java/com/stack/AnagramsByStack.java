package com.stack;

import java.util.*;
import java.io.*;

//Uva 732
public class AnagramsByStack {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	static String target, source;
	
	public static void main(String[] args) throws Exception{
		String input;
		while((input = reader.readLine()) != null) {
			if(input.equals("")) continue;
			source = input;
			target = reader.readLine();
			while(target.equals("")) 
				target = reader.readLine();
			writer.write("[\n");
			if(source.length() == target.length())
				dfs(source, "", "", "", 0);
			writer.write("]\n");
		}
		writer.close();
		reader.close();
	}
	
	static void dfs(String s, String t, String stack, String pattern, int path) throws Exception{
		if(path == source.length()*2) {
			if(t.equals(target)) {
				writer.write(String.format("%s\n", pattern));
				return;
			}
		}
		if(s.length() > 0) {
			dfs(s.substring(1, s.length()), t, stack + s.charAt(0), pattern + ((path == 0) ? "i": " i"), path+1);
		}
		if(stack.length() > 0) {
			if(stack.charAt(stack.length() - 1) != target.charAt(t.length())) {
				return;
			}
			dfs(s, t + stack.charAt(stack.length() - 1), stack.substring(0, stack.length()-1), pattern + " o", path+1);
		}
	}
}
