package com.divideangconquer;

import java.util.*;
import java.io.*;

//183
public class BitMap {
	
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

	static int binaryMap[][], idx, charCount;
	static String[] decompositionMap;
	
	public static void main(String[] args) throws Exception{
		writer = new BufferedWriter(new FileWriter("output.txt"));
		StringBuilder builder;
		String data[], input;
		while(!(input = reader.readLine()).equals("#")) {
			data = input.split("\\s+");
			int r, c;
			try {
				r = Integer.parseInt(data[1]);
				c = Integer.parseInt(data[2]);
			} catch (IndexOutOfBoundsException e1) {
				System.out.println(input);
				throw e1;
			}
			builder = new StringBuilder(r*c);
			while(builder.length() < (r*c)) {
				builder.append(reader.readLine());
			}
			if(data[0].equals("B")) {
				writer.write(String.format("%s%4d%4d\n", "D" , r, c));
				binaryMap = new int[r][c]; charCount = 0;
				data = builder.toString().split("");
				for(int i = 0; i < r; i++) {
					for(int j = 0; j < c; j++) {
						try {
							binaryMap[i][j] = Integer.parseInt(data[i*c + j]);
						} catch (ArrayIndexOutOfBoundsException e) {
							System.out.println(i + " " + j);
							throw e;
						}
					}
				}
				binaryToDecomposition(0, r, 0, c);
			} else {
				writer.write(String.format("%s%4d%4d\n", "B" , r, c));
				idx = 0;
				decompositionMap = builder.toString().split(""); binaryMap = new int[r][c];
				decompositionToBinary(0, r, 0, c);
				
				for(int i = 0; i < r; i++) {
					for(int j = 0; j < c; j++) {
						if((i+j) > 0 && (i*c + j)%50 == 0) {
							writer.newLine();
						}
						writer.write(String.format("%d", binaryMap[i][j]));
					}
				}
			}
			writer.newLine();
		}
		writer.close();
		reader.close();
	}
	
	static void binaryToDecomposition(int rTop, int rBottom, int cLeft, int cRight) throws Exception{
		if(rTop == rBottom || cLeft == cRight) return;
		int zeroes = 0;
		for(int i = rTop; i < rBottom; i++) {
			for(int j = cLeft; j < cRight; j++) {
				if(binaryMap[i][j] == 0) zeroes++;
			}
		}
		
		if(charCount > 0 && charCount%50 == 0) {
			writer.newLine();
		}
		charCount++;
		
		if(zeroes == (rBottom - rTop)*(cRight - cLeft)) writer.write("0");
		else if(zeroes == 0) writer.write("1");
		else {
			writer.write("D");
			int rHalf = (rTop + rBottom + 1)/2;
			int cHalf = (cLeft + cRight + 1)/2;
			binaryToDecomposition(rTop, rHalf, cLeft, cHalf);
			binaryToDecomposition(rTop, rHalf, cHalf, cRight);
			binaryToDecomposition(rHalf, rBottom, cLeft, cHalf);
			binaryToDecomposition(rHalf, rBottom, cHalf, cRight);
		}
	}
	
	static void decompositionToBinary(int rTop, int rBottom, int cLeft, int cRight) throws Exception{
		if(rTop == rBottom || cLeft == cRight) return;
		String bit = decompositionMap[idx++];
		if(bit.equals("0")) {
			for(int i = rTop; i < rBottom; i++) {
				for(int j = cLeft; j < cRight; j++) {
					binaryMap[i][j] = 0;
				}
			}
		} else if(bit.equals("1")) {
			for(int i = rTop; i < rBottom; i++) {
				for(int j = cLeft; j < cRight; j++) {
					binaryMap[i][j] = 1;
				}
			}
		} else {
			int rHalf = (rTop + rBottom + 1)/2;
			int cHalf = (cLeft + cRight + 1)/2;
			decompositionToBinary(rTop, rHalf, cLeft, cHalf);
			decompositionToBinary(rTop, rHalf, cHalf, cRight);
			decompositionToBinary(rHalf, rBottom, cLeft, cHalf);
			decompositionToBinary(rHalf, rBottom, cHalf, cRight);
		}
	}
}

/**
B 3 4
001000011011
D 2 3
DD10111
#
*/