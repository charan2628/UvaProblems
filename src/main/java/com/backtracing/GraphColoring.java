package com.backtracing;

import java.util.*;
import java.io.*;

//UVa 193
public class GraphColoring {
	
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int k, n, max, count;
	static BitSet black, maxBlack;
	static List<List<Integer>> edgeList;

	public static void main(String[] args) throws Exception{
//		writer = new BufferedWriter(new FileWriter("output2.txt"));
		String data[];
		int t = Integer.parseInt(reader.readLine()); boolean start = true;
		while(t-- != 0) {
			if(!start) {
				reader.readLine();
			}
			data = reader.readLine().split("\\s+");
			n = Integer.parseInt(data[0]); k = Integer.parseInt(data[1]); max = Integer.MIN_VALUE; count = Integer.MIN_VALUE;
			black = new BitSet(n+1); maxBlack = new BitSet(n+1);
			edgeList = new ArrayList<>(n+1);
			for(int i = 0; i <= n; i++) {
				edgeList.add(new ArrayList<>());
			}
			for(int i = 0; i < k; i++) {
				data = reader.readLine().split(" ");
				int n1 = Integer.parseInt(data[0]), n2 = Integer.parseInt(data[1]);
				edgeList.get(n1).add(n2);
				edgeList.get(n2).add(n1);
			}
			process(1);
			writer.write(String.format("%d\n", count));
			start = true;
			for(int i = 1; i <= n; i++) {
				if(maxBlack.get(i)) {
					if(!start) {
						writer.write(" ");
					}
					writer.write(String.format("%d", i));
					start = false;
				}
			}
			writer.newLine();
		}
		writer.close();
		reader.close();
	}
	
	static void process(int currNode) throws Exception{
		if(currNode > n) {
//			for(int i = 1; i <= n; i++) {
//				if(black.get(i)) {
//					System.out.print(i + " ");
//				}
//			}
//			System.out.print(" cardiality: " + black.cardinality() + "\n");
			if(black.cardinality() > count) {
//				int temp = 0;
//				for(int i = 1; i <= n; i++) {
//					if(black.get(i)) {
//						temp += i;
//					}
//				}
//				if(temp > max) {
//					max = temp;
//					maxBlack = (BitSet)black.clone();
//					count = black.cardinality();
//				}
				count = black.cardinality();
				maxBlack = (BitSet)black.clone();
			}
			return;
		}
		
		if(canBeBlack(currNode)) {
			black.set(currNode);
			process(currNode+1);
			black.set(currNode, false);
		}
		process(currNode+1);
		black.clear(currNode);
		
	}

	static boolean canBeBlack(int node) {
		List<Integer> adjNodes = edgeList.get(node);
		for(int eachNode: adjNodes) {
			if(black.get(eachNode)) {
				return false;
			}
		}
		return true;
	}
}
