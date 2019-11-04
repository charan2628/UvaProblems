package com.linkedlist;

import java.util.*;
import java.io.*;

//11988
public class BrokenKeyboard {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws Exception{
		String input;
		while((input = reader.readLine()) != null) {
			process(input.split(""));
		}
		
		writer.close();
		reader.close();
	}
	
	static void process(String[] data) throws IOException {
		LinkedList<String> list = new LinkedList<>();
		boolean flag = false; int index = 0;
		for(String character: data) {
			if(character.equals("[")) {
				flag = true;
				index = 0;
			} else if(character.equals("]")) {
				flag = false;
			} else if(flag){
				list.add(index, character);
				index++;
			} else {
				list.offer(character);
			}
		}
		
		StringBuilder builder = new StringBuilder();
		for(String character: list) {
			builder.append(character);
		}
		
		writer.write(String.format("%s\n", builder.toString()));
	}
}
