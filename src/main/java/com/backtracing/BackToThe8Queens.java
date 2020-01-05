package com.backtracing;

import java.util.*;
import java.io.*;

//Uva 11085
public class BackToThe8Queens {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int pos[], row[], minMoves;
	
	public static void main(String[] args) throws Exception{
		String input, data[]; int count = 0;
		while((input = reader.readLine()) != null) {
			data = input.split(" ");
			pos = new int[8];
			for(int i = 0; i < 8; i++) {
				pos[i] = Integer.parseInt(data[i]);
			}
			minMoves = Integer.MAX_VALUE; row = new int[9];
			process(1);
			writer.write(String.format("Case %d: %d\n", ++count, minMoves));
		}
		writer.close();
		reader.close();
	}
	
	static void process(int c) throws Exception{
		if(c == 9) {
			int count = 0;
			for(int i = 1; i <= 8; i++) {
				if(pos[i-1] != row[i])
					count++;
			}
			if(count != 0 && count < minMoves) {
				minMoves = count;
			}
		}
		
		for(int i = 1; i <= 8; i++) {
			if(place(i, c)) {
				row[c] = i;
				process(c+1);
			}
		}
	}
	
	static boolean place(int r, int c) {
		for(int prev = c-1; prev >= 1; prev--) {
			if(row[prev] == r || Math.abs(row[prev] - r) == Math.abs(prev - c)) 
				return false;
		}
		return true;
	}
}
