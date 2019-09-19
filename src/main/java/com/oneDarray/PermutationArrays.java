package com.oneDarray;

import java.io.*;
import java.util.*;

//482
public class PermutationArrays {
	
	static BufferedReader reader = new  BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception{
		int n = Integer.parseInt(reader.readLine()), index[];
		String real[], values[];
		while(n-- != 0) {
			reader.readLine();
			index = Arrays.asList(reader.readLine().split(" ")).stream().mapToInt(s -> Integer.parseInt(s)).toArray();
			values = reader.readLine().split(" ");
			real = new String[values.length];
			for(int i = 0; i < values.length; i++) {
				real[index[i] - 1] = values[i];
			}
			for(int i = 0; i < values.length; i++) {
				writer.write(String.format("%s\n", real[i]));
			}
			if(n != 0) {
				writer.newLine();				
			}
		}
		writer.close();
		reader.close();
	}
}
