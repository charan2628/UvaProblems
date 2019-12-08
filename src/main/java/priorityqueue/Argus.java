package priorityqueue;

import java.io.*;
import java.util.*;

//uva 1203
public class Argus {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static PriorityQueue<Registration> argus = new PriorityQueue<>((t1, t2) ->  {
		if(t1.callAt == t2.callAt) {
			return t1.id - t2.id;
		}
		return t1.callAt - t2.callAt;
	});
	static int k;
	
	public static void main(String[] args) throws Exception{
		String data, input[];
		while(true) {
			while(!(data = reader.readLine()).equals("#")) {
				input = data.split("\\s+");
				argus.add(new Registration(Integer.parseInt(input[1]), Integer.parseInt(input[2]), Integer.parseInt(input[2])));
			}
			k = Integer.parseInt(reader.readLine());
			process();
			break;
		}
		writer.close();
		reader.close();
	}
	
	static void process() throws Exception{
		Registration reg;
		for(int i = 0; i < k; i++) {
			reg = argus.poll();
			writer.write(String.format("%s\n", reg.id));
			reg.callAt += reg.period;
			argus.add(reg);
		}
	}
	
	static class Registration {
		int id;
		int period;
		int callAt;
		
		public Registration(int id, int period, int callAt) {
			super();
			this.id = id;
			this.period = period;
			this.callAt = callAt;
		}
	}
}
