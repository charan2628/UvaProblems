package com.greedy;

import java.util.*;
import java.io.*;
import java.util.regex.*;

//12405
public class Scarecrow {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int fieldLength;
	static String field[];
	
	public static void main(String[] args) throws Exception{
//		writer = new BufferedWriter(new FileWriter("output.txt"));
		int t = Integer.parseInt(reader.readLine());
		for(int i = 0; i < t; i++) {
			fieldLength = Integer.parseInt(reader.readLine());
			field = reader.readLine().split("");
			writer.write(String.format("Case %d: %d\n", i+1, process()));
		}
		writer.close();
		reader.close();
	}
	
	static int process() throws Exception{
		int crows = 0;
		for(int i = 0; i < fieldLength; i++) {
			if(field[i].equals(".")) {
				for(int j = i; j < fieldLength && j < i+3; j++) {
					field[j] = "#";
				}
				crows++;
			}
		}
		return crows;
	}
}
