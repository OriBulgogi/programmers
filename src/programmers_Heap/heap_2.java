package programmers_Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class heap_2 {
	class task implements Comparable<task>{
		int arrival_time;
		int task_time;
		task(int param[]){
			this.arrival_time = param[0];
			this.task_time = param[1];
		}
		@Override
		public int compareTo(task o) {
			// TODO Auto-generated method stub
			return this.arrival_time - o.arrival_time;
		}
	}
	public int solution(int[][] jobs) {
        //작업시간만큼 time++ => time에 따라서 우선순위큐에 작업추가
		int answer = 0;
		int time =0;
        PriorityQueue<task> origin_queue = new PriorityQueue<>();
        PriorityQueue<task> task_queue = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int[] i : jobs) origin_queue.add(new task(i));
        while(!origin_queue.isEmpty()) {
        	for(int i=origin_queue.peek().arrival_time; i <= time; i++) {
        		task_queue.add(origin_queue.poll());
        		if(origin_queue.isEmpty()) break;
        	}
        	
        	time += task_queue.peek().task_time;
        	answer += time-task_queue.poll().arrival_time;
        	System.out.println(time);
        }
        
        while(!task_queue.isEmpty()) {
        	time += task_queue.peek().task_time;
        	answer +=time-task_queue.poll().arrival_time;
        	System.out.println(time);
        }
        
        return answer/jobs.length;
    }
	public static void main(String[] args) {
		heap_2 he2 = new heap_2();
		int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
		System.out.println("answer : " + he2.solution(jobs));
	}
}
