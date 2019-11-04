package com.twoDarray;

import java.util.*;
import java.io.*;


//10920
public class SpiralTap {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws Exception{
		String input, data[];
		while(!(input = reader.readLine()).equals("0 0")) {
			data = input.split(" ");
			long k = Long.parseLong(data[0]), p = Long.parseLong(data[1]), n = k;
			
			while(k > 1 && p <= (k-2)*(k-2)) k -= 2;
			
			Pair pair = solve(p, k);
			
			pair.k1 = n/2 + 1 + pair.k1;
			pair.k2 = n/2 + 1 + pair.k2;
			
			writer.write(String.format("Line = %d, column = %d.\n", pair.k1, pair.k2));
		}
		
		writer.close();
		reader.close();
	}
	
	static Pair solve(long p, long k) {
		
		long aux = k*k, k2 = k/2;
		
		if(p > aux-k) return Pair.createPair(k2 - (aux - p), k2);
		aux -= k - 1;
		if(p > aux-k) return Pair.createPair(-k2, k2 - (aux - p));
		aux -= k - 1;
		if(p > aux-k) return Pair.createPair((aux-p) - k2, -k2);
		aux -= k -1;
		return Pair.createPair(k2, (aux-p) - k2);
	}
	
	static class Pair {
		long k1;
		long k2;
		
		Pair(long k1, long k2) {
			this.k1 = k1;
			this.k2 = k2;
		}
		
		static Pair createPair(long k1, long k2) {
			return new Pair(k1, k2);
		}
	}
}
