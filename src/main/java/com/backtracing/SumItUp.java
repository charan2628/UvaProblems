package com.backtracing;

import java.util.*;
import java.io.*;

//Uva 574
public class SumItUp {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int total, list[], n, choosen[] = new int[15];
	static boolean flag;
	static Set<String> cache = new HashSet<>(15);
	
	public static void main(String[] args) throws Exception{
//		writer = new BufferedWriter(new FileWriter("output.txt"));
		String input, data[];
		while(!(input = reader.readLine()).equals("0 0")) {
			data = input.split(" ");
			total = Integer.parseInt(data[0]); n = Integer.parseInt(data[1]);
			list = new int[n];
			for(int i = 0; i < n; i++) {
				list[i] = Integer.parseInt(data[i+2]);
			}
			flag = true; cache.clear();
			writer.write(String.format("Sums of %d:\n", total));
			process(0, 0, 0);
			if(flag) {
				writer.write("NONE\n");
			}
		}
		writer.close();
		reader.close();
	}
	
	static void process(int currIndex, int sum, int index) throws Exception{
		if(total == sum) {
			flag = false;
			StringBuilder builder = new StringBuilder();
			for(int i = 0; i < index; i++) {
				if(i != 0) builder.append("+");
				builder.append(String.format("%d", choosen[i]));
			}
			String result = builder.toString();
			if(cache.add(result)) {
				writer.write(result);
				writer.newLine();
			}
		}
		
		if(currIndex == n || sum > total) return;
		choosen[index] = list[currIndex];
		process(currIndex+1, sum + list[currIndex], index+1);
		process(currIndex+1, sum, index);
	}
}
