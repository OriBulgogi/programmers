package programmers_stack_queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class stack_queue_1 {

	public int[] solution(int[] progresses, int[] speeds) {
		Queue<Integer> deadline = new LinkedList<>();
		List<Integer> answer_list = new ArrayList<>();

		for(int i=0; i<progresses.length; i++) {        	
			if(((100-progresses[i]) % speeds[i]) == 0){
				deadline.add((100-progresses[i]) / speeds[i]); 
			}else {
				deadline.add(((100-progresses[i]) / speeds[i])+1) ;
			}
		}
		int pop_value = deadline.poll();
		int pop_num = 1;
		
		while(!deadline.isEmpty()) {
			int comp_value = deadline.poll();
			if(pop_value >= comp_value) {
				pop_num++;
			}else {
				answer_list.add(pop_num);
				pop_num =1;
				pop_value = comp_value;
			}
		}
		answer_list.add(pop_num);
		

		int[] answer = new int[answer_list.size()];
		for(int i =0; i<answer.length; i++ ) {
			answer[i] = answer_list.get(i);
		}
		return answer;
	}

	public static void main(String[] args) {
		stack_queue_1 st = new stack_queue_1();
//		int[] progresses= {95, 90, 99, 99, 80, 99};
//		int[] speeds = {1, 1, 1, 1, 1, 1};
//		System.out.println(Arrays.toString(st.solution(progresses, speeds)));
//		
		int[] progresses= {93, 30, 55};
		int[] speeds = {1, 30, 5};
		System.out.println(Arrays.toString(st.solution(progresses, speeds)));

	}
}
