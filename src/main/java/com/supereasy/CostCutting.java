package com.supereasy;

import java.util.*;
import java.io.*;

//11727
public class CostCutting {

	public static void main(String[] args) throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(reader.readLine()), data[], temp, c = 1;
		while(t-- != 0) {
			data = Arrays.asList(reader.readLine().trim().split(" ")).stream().mapToInt(s -> Integer.parseInt(s)).toArray();
			if(data[0] > data[2]) {
				temp = data[0];
				data[0] = data[2];
				data[2] = temp;
			}
			if(data[1] > data[2]) {
				temp = data[1];
				data[1] = data[2];
				data[2] = temp;
			}
			if(data[0] > data[1]) {
				temp = data[0];
				data[0] = data[1];
				data[1] = temp;
			}
			writer.write(String.format("Case %d: %d\n", c, data[1]));
			c++;
		}
		writer.close();
	}
	
	static void sort(int[] a) {
		int tmp;
		for(int i = 0; i < a.length; i++) {
			for(int j = 1; j < a.length - i; j++) {
				if(a[j] < a[j-1]) {
					tmp = a[j];
					a[j] = a[j-1];
					a[j-1] = tmp;
				}
			}
		}
	}
}
