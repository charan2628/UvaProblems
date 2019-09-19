package com.easy;

import java.util.*;
import java.io.*;

//11799
public class HorroDash {

	public static void main(String[] args) throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(reader.readLine()), data[], min, j = 0;
		while(j < t) {
			data = Arrays.asList(reader.readLine().trim().split(" ")).stream().mapToInt(s -> Integer.parseInt(s)).toArray();
			min = Integer.MIN_VALUE;
			for(int i = 1; i < data.length; i++) {
				if(min < data[i]) {
					min = data[i];
				}
			}
			writer.write(String.format("Case %d: %d\n", ++j, min));
		}
		writer.close();
	}
}
