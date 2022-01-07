package programmers_stack_queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class stack_queue_4 {

	public int[] solution(int[] prices) {
		int[] answer = new int[prices.length];
		Stack<Integer> stack = new Stack<>();
		for(int i=prices.length-1; i >= 0; i--) {
			stack.push(prices[i]);
		}
		
		for(int i=0; i< answer.length-1; i++) {
			int cur = stack.pop();
			while(!stack.isEmpty()) {
				
			}
		}
		return answer;
	}
	public static void main(String[] args) {
		stack_queue_4 st = new stack_queue_4();
		int[] prices = {1, 2, 3, 2, 3};
		st.solution(prices);
	}
}
