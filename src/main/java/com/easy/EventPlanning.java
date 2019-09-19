package com.easy;

import java.util.*;
import java.io.*;

//11559
public class EventPlanning {
	
	static int p, budg, h, w, hCost;

	public static void main(String[] args) throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		String input;
		int data[], minCost = Integer.MAX_VALUE, currCost;
		while((input = reader.readLine()) != null) {
			data = Arrays.asList(input.split(" ")).stream().mapToInt(s -> Integer.parseInt(s)).toArray();
			p = data[0]; budg = data[1]; h = data[2]; w = data[3];
			while(h-- != 0) {
				hCost = Integer.parseInt(reader.readLine());
				data = Arrays.asList(reader.readLine().trim().split(" ")).stream().mapToInt(s -> Integer.parseInt(s)).toArray();
				currCost = canStay(hCost, data);
				if(minCost > currCost) {
					minCost = currCost;
				}
			}
			if(minCost == Integer.MAX_VALUE) {
				writer.write(String.format("%s\n", "stay home"));
			} else {
				writer.write(String.format("%d\n", minCost));
				minCost = Integer.MAX_VALUE;
			}
		}
		writer.close();
		reader.close();
	}
	
	static int canStay(int hCost, int[] data) {
		int cost = 0;
		for(int eachWeek: data) {
			if(p <= eachWeek) {
				cost = hCost*p;
				if(cost <= budg) {
					return cost;
				}
			}
		}
		return Integer.MAX_VALUE;
	}
}
