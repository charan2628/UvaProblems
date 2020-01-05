package com.backtracing;

import java.util.*;
import java.io.*;

//Uva 524
public class PrimeRingProblem {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int n, 
	primes[] = {0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1}, 
	ring[], taken[];
	
	public static void main(String[] args) throws Exception{
//		writer = new BufferedWriter(new FileWriter("output.txt"));
		String input;
		int case_num = 0; boolean start = true;
		while((input = reader.readLine()) != null) {
			if(!start) {
				writer.newLine();				
			}
			n = Integer.parseInt(input);
			ring = new int[n+1]; ring[1] = 1; taken = new int[n+1];
			writer.write(String.format("Case %s:\n", ++case_num));
			process(2);
			start = false;
		}
		writer.close();
		reader.close();
	}

	static void process(int circle) throws Exception{
		if (circle == n+1) {
			if(isPrime(ring[n], 1)) {
				writer.write(String.format("%d", ring[1]));
				for(int i = 2; i <= n; i++) {
					writer.write(String.format(" %d", ring[i]));
				}
				writer.newLine();
			}
		}
		for(int i = 2; i <= n; i++) {
			if(taken[i] != 1 && isPrime(ring[circle-1], i)) {
				taken[i] = 1;
				ring[circle] = i;
				process(circle+1);
				taken[i] = 0;
			}
		}
	}
	
	static boolean isPrime(int c1, int c2) {
		return primes[c1+c2] == 1;
	}
}
