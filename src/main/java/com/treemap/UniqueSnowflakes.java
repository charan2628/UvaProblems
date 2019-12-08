package com.treemap;

import java.io.*;
import java.util.*;

public class UniqueSnowflakes {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws Exception{
		int t = Integer.parseInt(reader.readLine()), n = 0;
		HashMap<Integer, Integer> snowflakes;
		while(t-- != 0) {
			int maxCount = 0, startIndex = 0;
			n = Integer.parseInt(reader.readLine());
			snowflakes = new HashMap<>(n);
			for(int i = 1; i <= n; i++) {
				int key = Integer.parseInt(reader.readLine().trim());
				if(snowflakes.containsKey(key)) {
					if(snowflakes.get(key) > startIndex) {
						maxCount = Math.max(maxCount, i - startIndex - 1);
						startIndex = snowflakes.get(key);
						snowflakes.put(key, i);
					} else {
						snowflakes.put(key, i);
					}
				} else {
					snowflakes.put(key, i);
				}
			}
			maxCount = Math.max(maxCount, n - startIndex);
			writer.write(String.format("%d\n", maxCount));
		}
		writer.close();
		reader.close();
	}
}
