package com.supereasy;

import java.util.*;
import java.io.*;

public class CombinationLock {
	
	static int currPos, degrees;;

	public static void main(String[] args) throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String read;
		while((read = reader.readLine().trim()) != "0 0 0 0") {
			int[] data = Arrays.asList(read.split(" ")).stream().mapToInt(s -> Integer.parseInt(s)).toArray();
			currPos = data[0];
			degrees = 0;
			degrees(data[1], 1);
			degrees(data[2], 2);
			degrees(data[3], 3);
			System.out.println(degrees);
		}
	}
	
	static void degrees(int n, int turn) {
		if(turn == 1) {
			if(currPos < n) {
				degrees += 720;
				degrees += ((40 +(currPos - n)) % 40) * 9;
			}
		} else if(turn == 2) {
			degrees += 360;
			degrees += ((40 + (n - currPos)) % 40) * 9;
		} else if(turn == 3) {
			degrees += ((40 +(currPos - n)) % 40) * 9;
		}
		currPos = n;
	}
}
