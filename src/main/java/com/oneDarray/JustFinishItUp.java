package com.oneDarray;

import java.util.*;
import java.io.*;

//11093
public class JustFinishItUp {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws Exception{
		int t = Integer.parseInt(reader.readLine()), petrol[], petrolNeeded[], c = 0;
		while(t-- != 0) {
			reader.readLine();
			petrol = Arrays.asList(reader.readLine().split(" ")).stream().mapToInt(s -> Integer.parseInt(s)).toArray();
			petrolNeeded = Arrays.asList(reader.readLine().split(" ")).stream().mapToInt(s -> Integer.parseInt(s)).toArray();
			isItPossible(petrol, petrolNeeded, ++c);
		}
		writer.close();
		reader.close();
	}
	
	static void isItPossible(int[] petrol, int[] petrolNeeded, int c) throws Exception{
		int n = petrol.length, runner = 0, tank = 0;
		OUTER: for(int i = 0; i < n; i++) {
			if(petrol[i] >= petrolNeeded[i]) {
				tank = 0;
				runner = i;
				do {
					tank += petrol[runner];
					if(tank < petrolNeeded[runner])
						continue OUTER;
					tank -= petrolNeeded[runner];
					runner++;
					runner = runner%n;
				} while(runner != i);
				writer.write(String.format("Case %d: Possible from station %d\n", c, ++i));
				return;
			}
		}
		writer.write(String.format("Case %d: Not possible\n", c));
	}
}
