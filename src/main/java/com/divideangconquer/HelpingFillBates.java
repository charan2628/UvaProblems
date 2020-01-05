package com.divideangconquer;

import java.io.*;
import java.util.*;

//Uva 10567
public class HelpingFillBates {
	
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

	static Map<String, List<Integer>> queue = new HashMap<>();
	static int index;
	
	public static void main(String[] args) throws Exception{
		String input, data[];
		data = reader.readLine().split("");
		index = 0;
		
		for(int i = 0; i < data.length; i++) {
			queue.compute(data[i], (cd, list) -> {
				if(list == null) {
					list = new ArrayList<>();
				}
				list.add(index());
				return list;
			});
		}
		
		int q = Integer.parseInt(reader.readLine());
		while(q-- != 0) {
			data = reader.readLine().split("");
			process(data);
		}
		
		writer.close();
		reader.close();	
	}

	static int index() {
		return index++;
	}
	
	static void process(String[] query) throws Exception{
		int runner = -1, start = -1;
		for(int i = 0; i < query.length; i++) {
			List<Integer> stateCandidates = queue.get(query[i]);
			int position = Collections.binarySearch(stateCandidates, runner), n = stateCandidates.size();
			if(position == -(n + 1)) {
				writer.write("Not matched\n");
				return;
			} else if (position < 0) {
				runner = stateCandidates.get(Math.abs(position) - 1);
				if(start == -1) start = runner;
			} else {
				if((position + 1) == n) {
					writer.write("Not matched\n");
					return;
				}
				runner = stateCandidates.get(position+1);
				if(start == -1) start = runner;
			}
		}
		writer.write(String.format("Matched %d %d\n", start, runner));
	}
}
