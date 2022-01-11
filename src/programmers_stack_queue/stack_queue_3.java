package programmers_stack_queue;

import java.util.LinkedList;
import java.util.Queue;

public class stack_queue_3 {
	class truck{
		int weight =0;
		int move = 1; 
		public truck(int weight) {
			this.weight = weight;
		}
		public void moving() {
			move ++; 
		}
	}
	public int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;
		Queue<truck> wait_queue = new LinkedList<>();
		Queue<truck> move_queue = new LinkedList<>();

		for(int i=0; i < truck_weights.length; i++ ) {
			wait_queue.add(new truck(truck_weights[i]));
		}
		
		int total_weight =0;
		while(!wait_queue.isEmpty() || !move_queue.isEmpty()) {
			answer ++;
			if (move_queue.isEmpty()) { //다리 비엇을 때
				move_queue.add(wait_queue.poll());
				total_weight = move_queue.peek().weight;
				continue;
			}
			for(truck t : move_queue) t.moving();
			
			if(bridge_length  < move_queue.peek().move) { //제일 앞차가 다리를 통과
				truck  t = move_queue.poll();
				total_weight -= t.weight;
				
			}
			if(!wait_queue.isEmpty() && weight >= total_weight + wait_queue.peek().weight) {
				truck t = wait_queue.poll();
				move_queue.add(t);
				total_weight += t.weight;
			}
		}
		return answer;
	}


	public static void main(String[] args) {
		stack_queue_3 st3 = new stack_queue_3();
		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = {7,4,5,6};
		System.out.println(st3.solution(bridge_length, weight, truck_weights));
	}
}
