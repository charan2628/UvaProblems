package com.iterative;

import java.util.*;
import java.io.*;

//Uva 11236
public class GroceryStore {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

	static final long MAX = 2000000000;

	public static void main(String[] args) throws Exception{
		process();
		writer.close();
		reader.close();
	}

	private static void process() throws Exception{
		for(long i = 1; i <= 2000; i++) {
			if(i*i*i*i > MAX) break;
			for(long j = i; j <= 2000-i; j++) {
				if(i*j*j*j > MAX) break;
				for(long k = j; k <= 2000-i-j; k++) {
					if(i*j*k*k > MAX) break;

					long sum = i+j+k, multi = i*j*k;
					if(multi <= 1000000) continue;
					long sum_10_6 = sum*1000000, multi_10_6 = multi - 1000000;
					if(sum_10_6 % multi_10_6 != 0) continue;
					long l = sum_10_6 / multi_10_6;
					if(l < k) continue;
					sum += l; multi *= l;
					if(sum > 2000) continue;
					if(multi > MAX) continue;
					writer.write(String.format("%.2f %.2f %.2f %.2f\n", ((double)i)/100, ((double)j)/100, ((double)k)/100, ((double)l)/100));
				}
			}
		}
	}

}
