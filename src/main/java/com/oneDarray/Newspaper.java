package com.oneDarray;

import java.io.*;
import java.util.*;

//11340
public class Newspaper {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static HashMap<String, Integer> wordsCost;
	static double cost;
	
	public static void main(String[] args) throws Exception{
		int t = Integer.parseInt(reader.readLine()), c, m;
		String data[];
		while(t-- != 0) {
			cost = 0;
			c = Integer.parseInt(reader.readLine());
			wordsCost = new HashMap<>(c);
			while(c-- != 0) {
				data = reader.readLine().split(" ");
				wordsCost.put(data[0], Integer.parseInt(data[1]));
			}
			m = Integer.parseInt(reader.readLine());
			while(m-- != 0) {
				data = reader.readLine().split("");
				checkCost(data);
			}
			writer.write(String.format("%.2f$\n", cost));
		}
		writer.close();
		reader.close();
	}
	
	static void checkCost(String data[]) {
		for(String character: data) {
			if(wordsCost.containsKey(character)) {
				cost += ((double) wordsCost.get(character) / 100);
			}
		}
	}
}
