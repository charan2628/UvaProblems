package com.queues;

import java.util.*;
import java.io.*;

//Uva 10901
public class FerryLoadingIII {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int t, n, pos, currTime, result[];
	static Pair[] arrvTime;
	static Deque<Pair> left, right, ferry;
	
	public static void main(String[] args) throws Exception{
		int cases = Integer.parseInt(reader.readLine()), m;
		String data[];
		while(cases-- != 0) {
			data = reader.readLine().split(" ");
			n = Integer.parseInt(data[0]); t = Integer.parseInt(data[1]); m = Integer.parseInt(data[2]);
			left = new ArrayDeque<>(); right = new ArrayDeque<>(); ferry = new ArrayDeque<>(n);
			arrvTime = new Pair[m];
			result = new int[m];
			for(int i = 0; i < m; i ++) {
				data = reader.readLine().split(" ");
				Pair pair = Pair.createPair(i, Integer.parseInt(data[0]));
				if(data[1].equals("left")) {
					left.add(pair);
				} else {
					right.add(pair);
				}
			}
			process();
			if(cases != 0) {
				writer.newLine();
			}
		}
		writer.close();
		reader.close();
	}
	
	public static void process() throws Exception {
		pos = 0; currTime = 0; //pos = 0(left) || 1(right)
		while(!left.isEmpty() || !right.isEmpty() || !ferry.isEmpty()) {
			
			while(!ferry.isEmpty()) {
				result[ferry.pop().index] = currTime; //empty the ferry
			}
			
			if(pos == 0) { //left side
				if(right.peek() != null && left.peek() != null) {
					if(left.peek().arvTime <= currTime) {
						loadFerry(left, ferry);
					} else {
						if(left.peek().arvTime <= right.peek().arvTime) {
							currTime = left.peek().arvTime; //wait for cars to arrive
							loadFerry(left, ferry);
						} else {
							if(right.peek().arvTime > currTime) {
								currTime = right.peek().arvTime; //wait for cars to arrive
							}
						}
					}
				} else if(right.peek() == null) {
					if(left.peek() != null) {
						if(left.peek().arvTime <= currTime) {
							loadFerry(left, ferry);
						} else {
							currTime = left.peek().arvTime; //wait for cars to arrive
							loadFerry(left, ferry);
						}
					}
				} else {
					if(right.peek().arvTime > currTime) {
						currTime = right.peek().arvTime; //wait for cars to arrive
					} //else don't wait move to other side
				}
				pos = 1;
				currTime += t;
				continue;
			} else {
				if(right.peek() != null && left.peek() != null) {
					if(right.peek().arvTime <= currTime) {
						loadFerry(right, ferry);
					} else {
						if(right.peek().arvTime <= left.peek().arvTime) {
							currTime = right.peek().arvTime; //wait for cars to arrive
							loadFerry(right, ferry);
						} else {
							if(left.peek().arvTime > currTime) {
								currTime = left.peek().arvTime; //wait for cars to arrive
							}
						}
					}
				} else if (left.peek() == null) {
					if(right.peek() != null) {
						if(right.peek().arvTime <= currTime) {
							loadFerry(right, ferry);
						} else {
							currTime = right.peek().arvTime; //wait for cars to arrive
							loadFerry(right, ferry);
						}
					}
				} else {
					if(left.peek().arvTime > currTime) {
						currTime = left.peek().arvTime; //wait for cars to arrive
					}
				}
				pos = 0;
				currTime += t;
				continue;
			}
		}
		
		for(int i = 0; i < result.length; i++) {
			writer.write(String.format("%d\n", result[i]));
		}
	}

	public static void loadFerry(Deque<Pair> cars, Deque<Pair> ferry) { 
		while(ferry.size() < n) {
			if(cars.peek() != null && cars.peek().arvTime <= currTime) {
				ferry.offer(cars.poll());
			} else {
				break;
			}
		}
	}
	
	private static class Pair {
		int index;
		int arvTime;
		
		Pair(int a, int b) {
			this.index = a;
			this.arvTime = b;
		}
		
		static Pair createPair(int a, int b) {
			return new Pair(a, b);
		}
	}
}



