package com.backtracing;

import java.util.*;
import java.io.*;

//Uva 10576
public class Y2KAccountingBug {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static long s, d, maxTotal;
	
	public static void main(String[] args) throws Exception{
		String input, data[];
		while((input = reader.readLine()) != null) {
			data = input.split(" ");
			s = Integer.parseInt(data[0]); d = Integer.parseInt(data[1]);
			maxTotal = Integer.MIN_VALUE;
			process(0, 0, 0, new ArrayList<>());
			if(maxTotal > 0) {
				writer.write(String.format("%d\n", maxTotal));
			} else {
				writer.write("Deficit\n");
			}
		}
		writer.close();
		reader.close();
	}
	
	static void process(int month, long total, long lastfive, List<Long> bills) throws Exception{
		if(month == 12) {
			if(lastfive < 0 && total > 0 && total > maxTotal)
				maxTotal = total;
			return;
		}
		
		if(month >= 5) {
			if(lastfive > 0) {
				return;
			}
		}
		
		lastfive = 0;
		if(month >= 4) {
			for(int i = month; i > month-4; i--) {
				lastfive += bills.get(i-1);
			}
		}
		
		bills.add(s);
		process(month+1, total+s, lastfive+s, bills);
		bills.remove(bills.size() - 1);
		bills.add(-d);
		process(month+1, total-d, lastfive-d, bills);
		bills.remove(bills.size() - 1);
	}
}
