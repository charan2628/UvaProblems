package com.iterative;

import java.util.*;
import java.io.*;

//Uva 10487
public class ClosetSums {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int a[], q[];
	
	public static void main(String[] args) throws Exception{
		String input;
		int counter = 0;
		
		while(!(input = reader.readLine().trim()).equals("0")) {
			int n = Integer.parseInt(input);
			a = new int[n];
			for(int i = 0; i < n; i++) {
				a[i] = Integer.parseInt(reader.readLine().trim());
			}
			int m = Integer.parseInt(reader.readLine().trim());
			q = new int[m];
			for(int i = 0; i < m; i++) {
				q[i] = Integer.parseInt(reader.readLine().trim());
			}
			writer.write(String.format("Case %d:\n", ++counter));
			process();
		}
		writer.close();
		reader.close();
	}
	
	private static void process() throws Exception{
		int closestSum = 0, diff = Integer.MAX_VALUE;
		
		for(int query: q) {
			closestSum = 0; diff = Integer.MAX_VALUE;
			for(int i = 0; i < a.length-1; i++) {
				for(int j = i+1; j < a.length; j++) {
					int sum = a[i] + a[j];
					if(Math.abs(sum - query) < diff) {
						diff = Math.abs(sum - query);
						closestSum = sum;
					}
				}
			}
			writer.write(String.format("Closest sum to %d is %d.\n", query, closestSum));
		}
	}
}
