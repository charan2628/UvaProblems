package com.treeset;

import java.io.*;
import java.util.*;

//uva 11136
public class HoaxorWhat {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws Exception{
		String data, input[];
		long promotionDays, amountPaid;
		TreeMap<Integer, Integer> bills = new TreeMap<>();
		while(!(data = reader.readLine()).equals("0")) {
			promotionDays = Integer.parseInt(data); amountPaid = 0;
			bills.clear();
			while(promotionDays-- != 0) {
				input = reader.readLine().split(" ");
				for(int i = 1; i < input.length; i++) {
					bills.compute(Integer.valueOf(input[i]), (k, v) -> {
						if(v == null) return 1;
						return ++v;
					});
				}
				Pair min_max = maxAndmin(bills);
				amountPaid += (min_max.max - min_max.min);
			}
			writer.write(String.format("%d\n", amountPaid));
		}
		writer.close();
		reader.close();
	}
	
	static Pair maxAndmin(TreeMap<Integer, Integer> bills) {
		Integer max = bills.lastKey(), min = bills.firstKey();
		bills.compute(max, (k, v) -> {
			if(v == 1) return null;
			else return --v;
		});
		bills.compute(min, (k, v) -> {
			if(v == 1) return null;
			else return --v;
		});
		return new Pair(max, min);
	}
	
	static class Pair {
		long max;
		long min;
		
		Pair(long max, long min) {
			this.max = max;
			this.min = min;
		}
	}
}
