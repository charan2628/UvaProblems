package com.iterative;

import java.util.*;
import java.io.*;

//Uva 11565
public class SimpleEquations {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

	static int A, B, C;

	public static void main(String[] args) throws Exception{
		writer = new BufferedWriter(new FileWriter("output.txt"));
		int t = Integer.parseInt(reader.readLine()); String input[];
		while(t-- != 0) {
			input = reader.readLine().split(" ");
			A = Integer.parseInt(input[0]); B = Integer.parseInt(input[1]); C = Integer.parseInt(input[2]);
			process();
		}
		writer.close();
		reader.close();
	}

	static void process() throws Exception{
		for(int i = -22; i <= 22; i++) {
			if(i*i <= C) 
				for(int j = -100; j <= 100; j++) {
					if(i != j || (i*i + j*j) <= C)
						for(int k = -100; k <= 100; k++) {
							if(k != j && k != i && i + j + k == A && i*j*k == B && i*i + j*j + k*k == C) {
								writer.write(String.format("%d %d %d\n", i, j, k));
								return;
							}
						}
				}
		}
		writer.write("No solution.\n");
	}
}
