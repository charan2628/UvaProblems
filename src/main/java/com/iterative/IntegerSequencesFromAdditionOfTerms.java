package com.iterative;

import java.util.*;
import java.io.*;

//Uva 927
public class IntegerSequencesFromAdditionOfTerms {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int d, k, a[];
	
	public static void main(String[] args) throws Exception{
		int t = Integer.parseInt(reader.readLine());
		String input[];
		while(t-- != 0) {
			input = reader.readLine().split(" ");
			a = new int[Integer.parseInt(input[0]) + 1];
			for(int i = 0; i < a.length; i++) {
				a[i] = Integer.parseInt(input[i+1]);
			}
			d = Integer.parseInt(reader.readLine());
			k = Integer.parseInt(reader.readLine());
			process();
		}
		writer.close();
		reader.close();
	}
	
	private static void process() throws Exception{
		long sum = 0; int n = 0;
		for(int i = 1; i <= 1000000; i++) {
			sum += d*i;
			if(k <= sum) {
				n = i;
				break;
			}
		}
		writer.write(String.format("%d\n", solvePoly(n)));
	}
	
	private static long solvePoly(int n) {
		long sum = 0;
		for(int i = 0; i < a.length; i++) {
			sum += a[i] * pow(n, i);
		}
		return sum;
	}
	
	private static long pow(long b, long exp) {
		long result = 1;
		for(int i = 0; i < exp; i++)
			result *= b;
		return result;
	}
}
