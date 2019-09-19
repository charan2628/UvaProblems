package com.easy;

import java.util.*;
import java.io.*;

//10114
public class LoansomeCarBuyer {
	
	static int dur;
	static double down, amt, currVal, monthly;

	public static void main(String[] args) throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		double input[], input2[];
		List<Pair<Double, Double>> depre;
		while(true) {
			input = Arrays.asList(reader.readLine().trim().split(" ")).stream().mapToDouble(s -> Double.parseDouble(s)).toArray();
			dur = (int)input[0];
			if(dur < 0) break;
			down = input[1]; amt = input[2]; currVal = amt + down; monthly = amt/dur;
			depre = new ArrayList<>();
			while(input[3]-- > 0) {
				input2 = Arrays.asList(reader.readLine().trim().split(" ")).stream().mapToDouble(s -> Double.parseDouble(s)).toArray();
				depre.add(Pair.createPair(input2[0], input2[1]));
			}
			int months = depreciate(depre);
			writer.write(months == 1 ? String.format("%d month\n", months) : String.format("%d months\n", months));
		}
		writer.close();
	}
	
	static int depreciate(List<Pair<Double, Double>> data) {
		int runner = 0;
		double owns = 0, depre = 0;
		for(Pair<Double, Double> pair: data) {
			if(runner != pair.first.intValue()) {
				int diff = pair.first.intValue() - runner;
				while(diff-- != 0) {
					owns = amt - monthly*runner;
					currVal -= currVal*depre;
					if(currVal > owns) {
						return runner;
					}
					runner++;
				}
			}
			depre = pair.second;
			owns = amt - monthly*runner;
			currVal -= currVal*depre;
			if(currVal > owns) {
				return runner;
			}
			runner++;
		}
		while(owns > currVal) {
			owns = amt - monthly*runner;
			currVal -= currVal*depre;
			runner++;
		}
		return --runner;
	}
	
	static class Pair<K, V> {
		K first;
		V second;
		
		Pair(K k, V v) {
			this.first = k;
			this.second = v;
		}
		
		static <K, V> Pair<K, V> createPair(K k, V v) {
			return new Pair<>(k, v);
		}
	}
}
