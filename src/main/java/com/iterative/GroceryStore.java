package com.iterative;

import java.util.*;
import java.io.*;

//Uva 11236
public class GroceryStore {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static final long MAX = 2000;
	
	public static void main(String[] args) throws Exception{
		process();
		writer.close();
		reader.close();
	}
	
	private static void process() throws Exception{
		for(long i = 1; i < 2000; i++) {
			if(i*i*i*i > MAX) break;
			for(long j = i; j < 2000 - i; j++) {
				if(i*(j*j*j) > MAX) break; 
				for(long k = j; k < 2000- j - 1; k++) {
					if(i*j*(k*k) > MAX) break;
					
					long sum = i + j + k, multi = i * j * k;
					if(multi <= 1000000) continue;
					
					long multi_1 = multi - 1000000;
					
					if(sum % multi_1 != 0) continue;
					
					long l = sum / multi;
					
					if(l < k) continue;
					sum += l; multi *= l;
					if(sum > MAX) continue;
					if(multi > MAX) continue;
					writer.write(String.format("%.2f %.2f %.2f %.2f\n", ((double)i)/100, ((double)j)/100, ((double)k)/100, ((double)l)/100));
				}
			}
		}
	}
}
