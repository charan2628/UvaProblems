package com.oneDarray;

import java.util.*;
import java.io.*;

//467
public class SynchingSignals {

	static BufferedReader reader = new  BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws Exception{
		String input;
		int data[], set = 0;
		while((input = reader.readLine()) != null) {
			data = Arrays.asList(input.trim().split(" ")).stream().mapToInt(s -> Integer.parseInt(s)).toArray();
			syncSignals(data, data.length, ++set);
		}
		writer.close();
		reader.close();
	}
	
	static void syncSignals(int[] signals, int n, int set) throws Exception{
		int min = Integer.MAX_VALUE, count = 0, minutes, seconds;
		boolean flags[] = new boolean[n];
		for(int i = 0; i < n; i++) {
			flags[i] = true;
			if(signals[i] < min) {
				min = signals[i];
			}
		}
		for(int i = min-5; i <= 60*60; i++) {
			for(int j = 0; j < n; j++) {
				int diff = i%(2*signals[j]);
				if(diff == 0) {
					flags[j] = true;
				} else if(diff < signals[j] && signals[j] - diff <= 5) {
					if(flags[j]) {
						flags[j] = false;
					}
				}
			}
			count = 0;
			for(int k = 0; k < n; k++) {
				if(flags[k])
					count++;
			}
			if(count == n) {
				minutes = i/60;
				seconds = i - minutes*60;
				writer.write(String.format("Set %d synchs again at %d minute(s) and %d second(s) after all turning green.\n", set, minutes, seconds));;
				return;
			}
		}
		writer.write(String.format("Set %d is unable to synch after one hour.\n", set));
	}
}
