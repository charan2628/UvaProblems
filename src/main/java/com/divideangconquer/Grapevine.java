package com.divideangconquer;

import java.io.*;
import java.util.*;

//Uva 12192
public class Grapevine {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int x, y, low, upper;
	static int[][] properties;
	
	public static void main(String[] args) throws Exception{
//		writer = new BufferedWriter(new FileWriter("output.txt"));
		String input, data[];
		int q;
		while(!(input = reader.readLine()).equals("0 0")) {
			data = input.split(" ");
			x = Integer.parseInt(data[0]);y = Integer.parseInt(data[1]);
			properties = new int[x][];
			for(int i = 0; i < x; i++) {
				data = reader.readLine().split(" ");
				properties[i] = Arrays.asList(data).stream().mapToInt(Integer::parseInt).toArray();
			}
			q = Integer.parseInt(reader.readLine());
			while(q-- != 0) {
				data = reader.readLine().split(" ");
				low = Integer.parseInt(data[0]);upper = Integer.parseInt(data[1]);
				process();
			}
			writer.write("-\n");
		}
		writer.close();
		reader.close();
	}
	
	static void process() throws Exception{
		int bestSize = 0;
		for(int row = 0; row < x; row++) {
			int col = Arrays.binarySearch(properties[row], low);
			if(col < 0) {
				col = Math.abs(col) - 1;
				if(col == y) continue;
			} else {
				col = getLowestIndex(properties[row], low, col);
			}
			for(int size = bestSize; size < x; size++) {
				if((row+size) >= x || (col+size) >= y || properties[row+size][col+size] > upper) {
					break;
				}
				if(size+1 > bestSize) {
					bestSize = size+1;
				}
			}
		}
		writer.write(String.format("%d\n", bestSize));
	}
	
	private static int getLowestIndex(int[] a, int key, int idx) {
		for(int i = idx-1; i >= 0; i--) {
			if(a[i] == key) {
				idx--;
			}
		}
		return idx;
	}
}
