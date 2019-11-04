package com.bitmanipulation;

import java.util.*;
import java.io.*;

//11933
public class SplittingNumbers {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws Exception{
		String input;
		while(!(input = reader.readLine()).equals("0")) {
			process(Integer.parseInt(input));
		}
		writer.close();
		reader.close();
	}
	
	static void process(int n) throws IOException {
		int index = 0, a = 0, b = 0, choose = 0;
		
		while(n != 0) {
			int bit = n % 2;
			n /= 2;
			if(bit == 1) {
				if(choose % 2 == 0) {
					a += Math.pow(2, index);
				} else {
					b += Math.pow(2, index);
				}
				choose++;
			}
			index++;
		}
		
		writer.write(String.format("%d %d\n", a, b));
	}
}
