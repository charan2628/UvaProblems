package com.treemap;

import java.io.*;
import java.util.*;

//uva 11286
public class Conformity {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static Map<String, Integer> mapping;
	static int max = 0;
	
	public static void main(String[] args) throws Exception{
		String input, data[];
		int t;
		while(!(input = reader.readLine()).equals("0")) {
			t = Integer.parseInt(input); max = 0;
			mapping = new HashMap<>();
			while(t-- != 0) {
				data = reader.readLine().split(" ");
				Arrays.sort(data);
				String combo = String.join("", data);
				mapping.compute(combo, (k, v) -> v == null? 1 : ++v);
				max = Math.max(mapping.get(combo), max);
			}
			process();
		}
		reader.close();
		writer.close();
	}
	
	static void process() throws Exception{
		int count = 0;
		for(String combo: mapping.keySet()) {
			if(mapping.get(combo) == max)
				count += mapping.get(combo);
		}
		writer.write(String.format("%d\n", count));
	}
}
