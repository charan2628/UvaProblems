package com.oneDarray;

import java.util.*;
import java.io.*;

//10050
public class Hartals {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws Exception{
		int t = Integer.parseInt(reader.readLine()), n, p, hartalParams[];
		while(t-- != 0) {
			n = Integer.parseInt(reader.readLine());
			p = Integer.parseInt(reader.readLine());
			hartalParams = new int[p];
			while(p-- != 0) {
				hartalParams[p] = Integer.parseInt(reader.readLine());
			}
			writer.write(String.format("%d\n", workingDays(hartalParams, n)));
		}
		writer.close();
		reader.close();
	}
	
	static int workingDays(int hartalParams[], int n) {
		int holidays = 0, day, start = Integer.MAX_VALUE;
		for(int i = 0; i < hartalParams.length; i++) {
			if(hartalParams[i] < start)
				start = hartalParams[i];
		}
		for(int i = start; i <= n; i++) {
			day = i%7;
			if(day == 6 || day == 0)
				continue;
			for(int hartal: hartalParams)
				if(i%hartal == 0) {
					holidays++;
					break;
				}
		}
		return holidays;
	}
}
