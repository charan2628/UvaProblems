package com.treeset;

import java.io.*;
import java.util.*;

//uva 11849
public class CD {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws Exception{
		String data, input[];
		int m, n;
		HashSet<Integer> cds = new HashSet<>();
		while(!(data = reader.readLine()).equals("0 0")) {
			cds.clear();
			input = data.split(" ");
			m = Integer.parseInt(input[0]); n = Integer.parseInt(input[1]);
			for(int i = 0; i < m; i++) {
				cds.add(Integer.valueOf(reader.readLine()));
			}
			for(int i = 0; i < n; i++) {
				cds.add(Integer.valueOf(reader.readLine()));
			}
			writer.write(String.format("%d\n", ((m+n) - cds.size())));
		}
		writer.close();
		reader.close();
	}
}
