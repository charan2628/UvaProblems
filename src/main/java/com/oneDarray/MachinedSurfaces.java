package com.oneDarray;

import java.util.*;
import java.io.*;

//414
public class MachinedSurfaces {
	
	static BufferedReader reader = new  BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception{
		String read;
		int bs[], n, min = Integer.MAX_VALUE, tmp;
		while(!(read = reader.readLine()).equals("0")) {
			n = Integer.parseInt(read);
			bs = new int[n];
			while(n-- != 0) {
				read = reader.readLine();
				tmp = countSpaces(read);
				bs[n] = tmp;
				if(tmp < min) 
					min = tmp;
			}
			writer.write(String.format("%d\n", calculateVoid(bs, min)));
			min = Integer.MAX_VALUE;
		}
		writer.close();
		reader.close();
	}
	
	static int countSpaces(String row) {
		int n = row.length(), count = 0;
		String[] xs = row.split("\\s+");
		for(int i = 0; i < xs.length; i++) {
			count += xs[i].length();
		}
		return Math.abs(count - n);
	}
	
	static int calculateVoid(int[] rows, int min) {
		int count = 0;
		for(int i = 0; i < rows.length; i++) {
			count += rows[i] - min;
		}
		return count;
	}
}
