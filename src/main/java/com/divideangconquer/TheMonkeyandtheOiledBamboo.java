package com.divideangconquer;

import java.util.*;
import java.io.*;

//12032
public class TheMonkeyandtheOiledBamboo {
	
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

	static int n, rungs[];
	
	public static void main(String[] args) throws Exception{
//		writer = new BufferedWriter(new FileWriter("output.txt"));
		int t = Integer.parseInt(reader.readLine());
		for(int i = 1; i <= t; i++) {
			n = Integer.parseInt(reader.readLine());
			rungs = Arrays.asList(reader.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
			writer.write(String.format("Case %d: %d\n", i, process()));
		}
		writer.close();
		reader.close();
	}
	
	static long process() throws Exception{
		long lo = 1, hi = 100000000L, mid, minmalStrength = 0;
		while(lo <= hi) {
			mid = (lo + hi)/2;
			if(canClimb(mid)) {
				minmalStrength = mid;
				hi = mid-1;
			} else {
				lo = mid+1;
			}
		}
		return minmalStrength;
	}

	static boolean canClimb(long strenghtFactor) {
		int rung = 0;
		for(int i = 0; i < n; i++) {
			if(i == 0) {
				rung = rungs[i];
			} else {
				rung = rungs[i] - rungs[i-1]; 
			}
			if(strenghtFactor < rung) return false;
			if(strenghtFactor == rung) strenghtFactor -= 1;
		}
		return true;
	}
}
