package com.supereasy;

import java.util.*;
import java.io.*;

public class OptimalParking {

	public static void main(String[] args) throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(reader.readLine());
		int data[], min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		while(t != 0) {
			reader.readLine();
			data = Arrays.asList(reader.readLine().trim().split(" ")).stream().mapToInt(s -> Integer.parseInt(s)).toArray();
			for(int d: data) {
				if(d < min) min = d;
				if(d > max) max = d;
			}
			writer.write(2 *(max - min) + "");
			writer.newLine();
			min = Integer.MAX_VALUE; max = Integer.MIN_VALUE;
			t--;
		}
		writer.close();
	}

}
