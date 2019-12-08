package com.queues;

import java.util.*;
import java.io.*;

//Uva 10172
public class TheLonesomeCargoDistributor {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n, s, q, stationCount;
	static Map<Integer, Deque<Integer>> map;

	public static void main(String[] args) throws Exception{
		String data[];
		int t = Integer.parseInt(reader.readLine());
		while(t-- != 0) {
			data = reader.readLine().split(" ");
			n = Integer.parseInt(data[0]); s = Integer.parseInt(data[1]); q = Integer.parseInt(data[2]);
			map = new HashMap<>(n);
			for(int i = 0; i < n; i++) {
				data = reader.readLine().split(" ");
				Deque<Integer> stationB = new ArrayDeque<>(q);
				stationCount += Integer.parseInt(data[0]);
				for(int j = 1; j < data.length; j++) {
					stationB.add(Integer.parseInt(data[j]));
				}
				map.put(i+1, stationB);
			}
			process();
		}
		writer.close();
	}

	static void process() throws Exception{
		Deque<Integer> carrier = new ArrayDeque<>(q); 
		int minutes = 0;
		while(true) {
			for(int i = 1; i <= n; i++) {
				Deque<Integer> stationB = map.get(i);
				while(true) {
					if(carrier.isEmpty()) break;
					if(carrier.peekFirst() == i) {
						carrier.pop();
						minutes++;
					}
					else if(stationB.size() == q){
						break;
					} else {
						stationB.offer(carrier.pop());						
						minutes++;
						stationCount++;
					}
				}
				while(true) {
					if(stationB.isEmpty() || carrier.size() == s) break;
					carrier.push(stationB.poll());
					minutes++;
					stationCount--;
				}
				if(stationCount == 0 & carrier.isEmpty()) {
					writer.write(String.format("%d\n", minutes));
					return;
				}
				minutes += 2;
			}
		}

	}
}
