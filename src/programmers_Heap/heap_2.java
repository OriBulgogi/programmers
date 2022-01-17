package programmers_Heap;

import java.util.Arrays;
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
			return this.task_time - o.task_time;
		}
	}
	public int solution(int[][] jobs) {
        //작업시간만큼 time++ => time에 따라서 우선순위큐에 작업추가
		int answer = 0;
		int time =0; //수행되고난 직후의 시간
		int jobsindex =0; //jobs 배열의 인덱스
		int count =0; //수행된 요청 갯수
		Arrays.sort(jobs, (o1,o2) -> o1[0] - o2[0]);
        PriorityQueue<int[]> origin_queue = new PriorityQueue<>();
        PriorityQueue<int[]> task_queue = new PriorityQueue<>((o1,o2) -> o1[1] - o2[1]);
        while(count < jobs.length) {
			while(jobsindex <jobs.length && jobs[jobsindex][0] <=time) {
				task_queue.add(jobs[jobsindex++]);
			}
			
			if(task_queue.isEmpty()) {
				time = jobs[jobsindex][0];
			}else {
				int[] temp = task_queue.poll();
				answer +=temp[1] + time - temp[0];
				time += temp[1];
				count++;
			}
		}

		return (int) Math.floor(answer / jobs.length);
        /*
        for(int[] i : jobs) origin_queue.add(i);
        
        while(!origin_queue.isEmpty()) {
        	for(int i=origin_queue.peek()[0]; i <= time; i++) {
        		task_queue.add(new task(origin_queue.poll()));
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
        */
    }
	public static void main(String[] args) {
		heap_2 he2 = new heap_2();
		int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
		System.out.println("answer : " + he2.solution(jobs));
	}
}
