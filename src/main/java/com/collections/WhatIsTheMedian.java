package com.collections;

import java.io.*;
import java.util.*;

//10107
public class WhatIsTheMedian {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int arr[] = new int[10001], i = -1;
	
	public static void main(String[] args) throws Exception{
		String input;
		int num;
		while((input = reader.readLine()) != null) {
			num = Integer.parseInt(input.trim());
			addElem(num);
			writer.write(String.format("%d\n", median()));
		}
		
		writer.close();
		reader.close();
		
//		arr[0] = 3; //arr[1] = 3;
//		i = 0;
//		addElem(2);
//		System.out.println(Arrays.toString(arr));
	}
	
	static void addElem(int elem) {
		for(int j = 0; j <= i; j++) {
			if(elem < arr[j]) {
				for(int k = i; k >= j; k--) {
					arr[k+1] = arr[k]; 
				}
				arr[j] = elem;
				i++;
				return;
			}
		}
		arr[++i] = elem;
	}
	
	static int median() {
		if(i == 0) return arr[0];
		if(i % 2 != 0) {
			return (arr[i/2] + arr[i/2 + 1])/2;
		}
		return arr[i/2];
	}
}
