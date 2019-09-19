package com.oneDarray;

import java.util.*;
import java.io.*;

//10038
public class JollyJumpers {
	
	static BufferedReader reader = new  BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception{
		String input;
		int[] data;
		while((input = reader.readLine()) != null) {
			data = Arrays.asList(input.split(" ")).stream().mapToInt(s -> Integer.parseInt(s)).toArray();
			process(data);
		}
		writer.close();
	}
	
	static void process(int[] data) throws Exception{
		if (data.length == 2) {
			writer.write("Jolly\n");
			return;
		}
		int abs_sum = 0, abs;
		for(int i = 1; i < data.length - 1; i++) {
			abs = Math.abs(data[i] - data[i+1]);
			if(abs == 0) {
				writer.write("Not jolly\n");
				return;
			}
			abs_sum += abs;
		}
		int sum = (data[0]*(data[0] - 1)) / 2;
		if(abs_sum != sum) {
			writer.write("Not jolly\n");
			return;
		}
		writer.write("Jolly\n");
	}
}
