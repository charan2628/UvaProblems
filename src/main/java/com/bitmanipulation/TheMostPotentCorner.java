package com.bitmanipulation;

import java.io.*;
import java.util.*;

//10264
public class TheMostPotentCorner {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	static int corners[], potency[], n;
	
	public static void main(String[] args) throws Exception{
		
		String input;
		
		while((input = reader.readLine()) != null) {
			n = Integer.parseInt(input);
			corners = new int[1 << n];
			potency = new int[1 << n];
			
			for(int i = 0; i < (1 << n); i++) {
				corners[i] = Integer.parseInt(reader.readLine());
			}
			
			calcPotency();
			writer.write(String.format("%d\n", maxSum()));
		}
		
		writer.close();
	}
	
	static void calcPotency() {
		for(int i = 0; i < potency.length; i++) {
			int sum = 0;
			for(int j = 0; j < n; j++) {
				int neighbour = i ^ (1 << j);
				sum += corners[neighbour];
			}
			potency[i] = sum;
		}
	}
	
	static int maxSum() {
		int max1 = Integer.MIN_VALUE;
		
		for(int i = 0; i < potency.length; i++) {
			for(int j = 0; j < n; j++) {
				max1 = Math.max(max1, potency[i] + potency[i ^ (1 << j)]);
			}
		}
		
		return max1;
	}
}
