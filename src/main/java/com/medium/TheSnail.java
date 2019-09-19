package com.medium;

import java.io.*;
import java.util.*;

//573
public class TheSnail {

	static BufferedReader reader = new  BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws Exception{
		int data[];
		while(true) {
			data = Arrays.asList(reader.readLine().trim().split(" ")).stream().mapToInt(s -> Integer.parseInt(s)).toArray();
			if(data[0] == 0) {
				break;
			}
			find(data);
		}
		writer.close();
		reader.close();
	}
	
	static void find(int[] data) throws Exception{
		double h = data[0], u = data[1], d = data[2], f = ((double)data[3])/100, pos = 0, currU = u;
		int day = 1;
		while(true) {
			if(currU <= 0) {
				currU = 0;
			} else {
				currU = u - ((day - 1)*u*f);				
			}
			pos += currU;
			if(pos > h) {
				break;
			}
			pos -= d;
			if(pos < 0) {
				break;
			}
			day++;
		}
		if(pos <= 0) {
			writer.write(String.format("failure on day %d\n", day));
		} else {
			writer.write(String.format("success on day %d\n", day));
		}
	}
}

/*
 * 6 3 1 10
10 2 1 50
50 5 3 14
50 6 4 1
50 6 3 1
1 1 1 1
0 0 0 0
*/