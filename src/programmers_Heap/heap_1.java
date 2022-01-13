package programmers_Heap;

import java.util.PriorityQueue;

public class heap_1 {
	  public int solution(int[] scoville, int K) {
	        int answer = 0;
	        PriorityQueue<Integer> heap = new PriorityQueue<>();
	        for(int i : scoville ) {
	        	heap.add(i);
	        }
	        while(heap.peek() <= K && heap.size() > 1) {
	        	int first = heap.poll();
	        	int second = heap.poll();
	        	int result = first + (second*2);
	        	
	        	heap.add(result);
	        	answer ++;
	        }
	        if(heap.peek() < K) answer = -1;
	        
	        return answer;
	    }
	  public static void main(String[] args) {
		heap_1 he1 = new heap_1();
		int[] scovile = {1,2,3,4,9,10,12};
		he1.solution(scovile, 7);
	}
}
