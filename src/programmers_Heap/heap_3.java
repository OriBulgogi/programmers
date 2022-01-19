package programmers_Heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class heap_3 {
	 public int[] solution(String[] operations) {
	        int[] answer = {0,0};
	        int count =0;
	        PriorityQueue<Integer> min_queue = new PriorityQueue<>();
	        PriorityQueue<Integer> max_queue = new PriorityQueue<>(Collections.reverseOrder());
	        
	        while(count <operations.length) {
	        	StringTokenizer stk = new StringTokenizer(operations[count]," ");
	        	
	        	while(stk.hasMoreTokens()) {
	        		String opt=stk.nextToken();
	        		int value = Integer.parseInt(stk.nextToken());
	        		System.out.println(opt+" " +value);
	        		if(min_queue.size() < 1 && opt.equals("D") ) {
	        			break;
	        		}
	        		if(opt.equals("I") ) {
	        			min_queue.add(value);
	        			max_queue.add(value);
	        			System.out.println(opt+" " +value);
	        			break;
	        		}
	        		if(value == -1) {
	        			int remove_value = min_queue.poll();
	        			max_queue.remove(remove_value);
	        		}else {
	        			int remove_value = max_queue.poll();
	        			min_queue.remove(remove_value);
	        		}
	        		
	        	}
	        	
		        count++;
	        }
	        if(!min_queue.isEmpty()) {
		        answer[0] = max_queue.poll();
		        answer[1] = min_queue.poll();
	        }
	        return answer;	        
	    }
	 public static void main(String[] args) {
		heap_3 he3 = new heap_3();
		String[] operations = {"I 7","I 5","I -5","D -1"};
		System.out.println(Arrays.toString(he3.solution(operations)));
	}
}
