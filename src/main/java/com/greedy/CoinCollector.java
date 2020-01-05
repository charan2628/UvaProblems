package com.greedy;

import java.util.*;
import java.io.*;

//11264
public class CoinCollector {
	
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

	static int n, coins[];
	
	public static void main(String[] args) throws Exception{
//		writer = new BufferedWriter(new FileWriter("output.txt"));
		int t = Integer.parseInt(reader.readLine());
		while(t-- != 0) {
			n = Integer.parseInt(reader.readLine());
			coins = Arrays.asList(reader.readLine().split("\\s+")).stream().mapToInt(Integer::parseInt).toArray();
			process();
		}
		writer.close();
		reader.close();
	}
	
	static void process() throws Exception{
		if(n == 1) {
			writer.write(String.format("%d\n", 1));
			return;
		}
		
		int types = 0, sum = 0;
		for(int i = 0; i < n-1; i++) {
			if(sum + coins[i] < coins[i+1]) {
				types++;
				sum += coins[i];
			}
		}
		
		writer.write(String.format("%d\n", ++types));
	}
}
