package com.divideangconquer;

import java.io.*;
import java.util.*;

//Uva 11057
public class ExactSum {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int n, bookPrices[], pocketMoney;
	
	public static void main(String[] args) throws Exception{
		String input, data[]; boolean first = true;
		while((input = reader.readLine()) != null) {
			n = Integer.parseInt(input);
			data = reader.readLine().split(" ");
			bookPrices = Arrays.asList(data).stream().mapToInt(Integer::parseInt).toArray();
			pocketMoney = Integer.parseInt(reader.readLine());
			process();
			input = reader.readLine();
			writer.newLine();
		}
		writer.close();
		reader.close();
	}
	
	static void process() throws Exception{
		Arrays.sort(bookPrices);
		int maxPriceIndex = Arrays.binarySearch(bookPrices, pocketMoney);
		if(maxPriceIndex < 0) {
			maxPriceIndex = Math.abs(maxPriceIndex) - 1;
			if(maxPriceIndex == n) {
				maxPriceIndex--;
			}
		}
		int bestBook1Price = 0, bestBook2Price = 0, diff = Integer.MAX_VALUE; 
		for(int i = 0; i <= maxPriceIndex; i++) {
			int book1Price = bookPrices[i];
			int book2Price = pocketMoney - book1Price;
			if(book2Price <= 0) break;
			int indexBook2 = Arrays.binarySearch(bookPrices, 0, maxPriceIndex+1, book2Price);
			if(indexBook2 < 0) continue;
			int tempDiff = Math.abs(book1Price - book2Price);
			if(tempDiff < diff) {
				bestBook1Price = book1Price;
				bestBook2Price = book2Price;
				diff = tempDiff;
			}
		}
		writer.write(String.format("Peter should buy books whose prices are %d and %d.\n", bestBook1Price, bestBook2Price));
	}
}
