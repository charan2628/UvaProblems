package com.oneDarray;

import java.io.*;
import java.util.*;

//12356
public class ArmyBuddies {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

	static int[] leftSoldier;
	static int[] rightSoldier;

	public static void main(String[] args) throws Exception{
		String input, data[];
		int s, b;
		while(!(input = reader.readLine()).equals("0 0")) {
			data = input.split(" ");
			s = Integer.parseInt(data[0]); b = Integer.parseInt(data[1]);
			leftSoldier = new int[s+2];
			rightSoldier = new int[s+2];
			for(int i = 1; i <= s; i++) {
				leftSoldier[i] = i-1;
				rightSoldier[i] = i+1;
			}
			leftSoldier[1] = -1;
			rightSoldier[s] = -1;
			while(b-- != 0) {
				data = reader.readLine().split(" ");
				process(Integer.parseInt(data[0]), Integer.parseInt(data[1]));
			}
			writer.write("-\n");
		}
		writer.close();
		reader.close();
	}
	
	static void process(int L, int R) throws Exception{
		if(rightSoldier[R] != -1) {
			leftSoldier[rightSoldier[R]] = leftSoldier[L];
		}
		if(leftSoldier[L] != -1) {
			writer.write(String.format("%d ", leftSoldier[L]));
		} else {
			writer.write("* ");
		}
		
		if(leftSoldier[L] != -1) {
			rightSoldier[leftSoldier[L]] = rightSoldier[R];
		}
		if(rightSoldier[R] != -1) {
			writer.write(String.format("%d\n", rightSoldier[R]));
		} else {
			writer.write("*\n");
		}
	}

//	static void process(int L, int R) throws Exception{
//		String sL, sR;
//		if(L == R) 
//			soldiers[L-1] = -1;
//		else {
//			soldiers[L-1] = R-L;
//			soldiers[R-1] = L-R;
//		}
//
//		int curr, pos, n = soldiers.length - 1;
//
//		if(L == 1)
//			sL = "*";
//		else {
//			pos = L - 2;
//			curr = soldiers[pos];
//			while(curr != 0) {
//				if (curr ==-1)
//					pos--;
//				else 
//					pos += (curr - 1);
//				if(pos < 0) break;
//				curr = soldiers[pos];
//			}
//			if(pos < 0)
//				sL = "*";
//			else 
//				sL = ""+(pos + 1);
//		}
//
//		if(R == n+1)
//			sR = "*";
//		else {
//			pos = R;
//			curr = soldiers[pos];
//			while(curr != 0) {
//				if(curr > 0) {
//					pos += curr + 1;
//					if(pos > n) break;
//					curr = soldiers[pos];
//				} else if(curr < 0) {
//					pos++;
//					if(pos > n) break;
//					curr = soldiers[pos];
//				}
//			}
//			if(pos > n)
//				sR = "*";
//			else
//				sR = "" + (pos + 1);
//		}
//
//		writer.write(String.format("%s %s\n", sL, sR));
//	}

	//	static void process(int L, int R) throws Exception{
	//		String sL = "*", sR = "*";
	//		for(int i = L-1; i < R; i++) {
	//			soldiers[i] = -1;
	//		}
	//		for(int i = L-1; i >= 0; i--) {
	//			if(soldiers[i] == 0) {
	//				sL = (i+1) + "";
	//				break;
	//			}
	//		}
	//		for(int i = R-1; i < soldiers.length; i++) {
	//			if(soldiers[i] == 0) {
	//				sR = (i+1) + "";
	//				break;
	//			}
	//		}
	//		writer.write(String.format("%s %s\n", sL, sR));
	//	}
}
