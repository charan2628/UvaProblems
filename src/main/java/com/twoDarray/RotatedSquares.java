package com.twoDarray;

import java.io.*;
import java.util.*;

public class RotatedSquares {
	
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static String[][] big, small;

	public static void main(String[] args) throws Exception{
		String input, data[];
		while(!(input = reader.readLine()).equals("0 0")) {
			data = input.split(" ");
			int m = Integer.parseInt(data[0]), s = Integer.parseInt(data[1]);
			big = new String[m][]; small = new String[s][];
			for(int i = 0; i < m; i++) {
				big[i] = reader.readLine().split("");
			}
			for(int i = 0; i < s; i++) {
				small[i] = reader.readLine().split("");
			}
			int count1 = count(), count2, count3, count4;
			small = rotate(small);
			count2 = count();
			small = rotate(small);
			count3 = count();
			small = rotate(small);
			count4 = count();
			
			writer.write(String.format("%d %d %d %d\n", count1, count2, count3, count4));
		}
		
		writer.close();
		reader.close();
	}
	
	static String[][] rotate(String arr[][]) {
		int n = arr.length; 
		String temp[][] = new String[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				temp[i][j] = arr[n-1-j][i];
			}
		}
		
		return temp;
	}
	
	static int count() {
		int m = big.length, n = small.length, count = 0;
		
		for(int i = 0; i <= m-n; i++) {
			OUTER: for(int j = 0; j <= m-n; j++) {
				if(big[i][j].equals(small[0][0])) {
					for(int k = 0; k < n; k++) {
						for(int l = 0; l < n; l++) {
							if(!big[i+k][j+l].equals(small[k][l])) {
								continue OUTER; 
							}
						}
					}
					count++;
				}
			}
		}
		
		return count;
	}
}
