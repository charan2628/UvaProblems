package com.iterative;

import java.util.*;
import java.io.*;

//Uva 1260
public class Sales {
	
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int n, a[];
	
	public static void main(String[] args) throws Exception{
		int t = Integer.parseInt(reader.readLine());
		String input[];
		
		while(t-- != 0) {
			n = Integer.parseInt(reader.readLine());
			a = new int[n];
			input = reader.readLine().split("\\s+");
			
			for(int i = 0; i < n; i++) {
				a[i] = Integer.parseInt(input[i]);
			}
			process();
		}
		writer.close();
		reader.close();
	}
	
	private static void process()  throws Exception{
		int sum = 0, count = 0;
		for(int i = 1; i < n; i++) {
			count = 0;
			for(int j = i-1; j >= 0; j--) {
				if(a[j] <= a[i]) {
					count++;
				}
			}
			sum += count;
		}
		writer.write(String.format("%d\n", sum));
	}
}
