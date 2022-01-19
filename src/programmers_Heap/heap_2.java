package programmers_Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class heap_2 {
	public int solution(int[][] jobs) {
		int answer = 0;
		int time =0; //수행되고난 직후의 시간
		int jobsindex =0; //jobs 배열의 인덱스
		int count =0; //수행된 요청
		Arrays.sort(jobs, (o1,o2) -> o1[0] - o2[0]); //작업 들어온 시간 기준 정렬
        PriorityQueue<int[]> task_queue = new PriorityQueue<>((o1,o2) -> o1[1] - o2[1]);
        //jobs 는 작업시간순 정렬
        //task_queue 는 수행시간이 짧은 순서로 정렬
        //	1. 시간내의 작업 queue에 추가 - if(추가조건)
        //	2. queue내에서 가장 수행시간이 짧은것 수행  - if(큐가없을 경우) else if(가장짧은걸 뽑아온다) 
        //	3. 수행될 때 마다 시간내의 작업 queue에 추가 - 1. 항목에서 수정?
        //<조건 분기> 추가하는것것의 조건
        while(count < jobs.length) {
        	while( jobsindex < jobs.length && time >= jobs[jobsindex][0]) {
        		// 다중 연산시에 앞조건 먼저 비교 후 뒤의 조건을 검사한다 뒤의조건의 jobsindex outofbound 방지
        		task_queue.add(jobs[jobsindex]);
        		jobsindex++;
        	}
        	if(task_queue.isEmpty()) {
        		time = jobs[jobsindex][0]; //큐가 비엇을 때 다음으로 올 작업의 대기시간으로 변경
        								   
        	}else {
	        	time += task_queue.peek()[1];
	        	answer +=  time-task_queue.poll()[0];
	        	count++;
        	}
        }
        return answer/jobs.length;
    }
	public static void main(String[] args) {
		heap_2 he2 = new heap_2();
		int[][] jobs = {{0, 3}, {5, 9}, {10, 6}};
		System.out.println("answer : " + he2.solution(jobs));
	}
}
