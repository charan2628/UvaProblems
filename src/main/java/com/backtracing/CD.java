package com.backtracing;

import java.util.*;
import java.io.*;

public class CD {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

	static int n, t, tracks[], bestDiff;
	static List<Integer> bestTracks;

	public static void main(String[] args) throws Exception{
		String input, data[];
		while((input = reader.readLine()) != null) {
			data = input.split(" ");
			n = Integer.parseInt(data[0]); t = Integer.parseInt(data[1]);
			bestDiff = Integer.MAX_VALUE;
			tracks = new int[t];
			for(int i = 0; i < t; i++) {
				tracks[i] = Integer.parseInt(data[i+2]);
			}
			process(0, new ArrayList<>(), 0);
			for(int track: bestTracks)
				writer.write(String.format("%d ", track));
			writer.write(String.format("sum:%d\n", (n- bestDiff)));
		}
		writer.close();
		reader.close();
	}

	static void process(int idx, List<Integer> tempTracks, int sum) throws Exception {
		if(sum > n)
			return;
		if((n - sum) < bestDiff) {
			bestDiff = n - sum;
			bestTracks = new ArrayList<>(tempTracks);
		}
		if(idx >= t)
			return;
		tempTracks.add(tracks[idx]);
		process(idx+1, tempTracks, sum+tracks[idx]);
		tempTracks.remove(new Integer(tracks[idx]));
		process(idx+1, tempTracks, sum);
	}
}
