package programmers_stack_queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class stack_queue_4 {

	public int[] solution(int[] prices) {
		int[] answer = new int[prices.length];
		//배열 반복문으로 solution (최초풀이)
		/*
		int leng = prices.length;
		for(int i=0; i<leng; i++) {
			for(int j =i+1; j<leng; j++) {
				answer[i] ++;
				if(prices[i] > prices[j]) {
					break;
				}
			}
		}
		*/
		//stack class solution 
		//stack에 아직 가격이 떨어지지않은 index를 저장 하고 순차적으로 비교하다가 떨어지는 시점에 pop
		//
		Stack<Integer> stack = new Stack<>();
		
		int i =0;
		stack.push(i); //시작하는 index를 push하고 시작한다
		for(i =1; i < prices.length; i++) {
			while(!stack.empty() && prices[i] < prices[stack.peek()]) { //가격이 떨어지면
				int start_index = stack.pop(); 
				answer[start_index] = i - start_index;
			}
			stack.push(i); //다음 인덱스의 가격이 안떨어지면
		}
		System.out.println(Arrays.toString(answer));
		System.out.println(stack);
		while(!stack.empty()) {
			int start_index = stack.pop();
			answer[start_index] = i -start_index-1;
		}
		return answer;
	}
	
	public static void main(String[] args) {
		stack_queue_4 st = new stack_queue_4();
		int[] prices = {3, 4, 3, 2, 3,3,4,5,2,3,8,1,2,3,2};
		st.solution(prices);
	}
}
