package programmers_stack_queue;

import java.util.LinkedList;
import java.util.Queue;

public class stack_queue_2 {
	class task_map{
		int location;
		int priorities;
		task_map(int location,int priorities){
			this.location = location;
			this.priorities = priorities;
		}
	}
	 public int solution(int[] priorities, int location) {
	        int answer = 0;
	        Queue<task_map> queue = new LinkedList<>();
	        for(int i =0; i<priorities.length; i++) {
		         queue.add(new task_map(i, priorities[i]));
	        }
	        int cnt = 0;
	        while(!queue.isEmpty()) {
	        	task_map j = queue.poll();
	        	 int flag = 0;
	        	for(task_map comp : queue) {
	        		if(j.priorities < comp.priorities) {
	        			flag = 1;
	        			break;
	        		}
	        	}
	        	if(flag == 1) {
	        		queue.add(j);	        		
	        	}else {
	        		cnt ++;
	        		if(j.location == location) {
		        		answer = cnt;
		        		return answer;
		        	}
	        	}
	        }
	        return answer;
	    }
	 public static void main(String[] args) {
		 stack_queue_2 st2 = new stack_queue_2();
		 int[] priorities = {2, 1, 3, 2};
		 int location = 0;
		 
		 System.out.println(st2.solution(priorities, location));
		
	}
}
