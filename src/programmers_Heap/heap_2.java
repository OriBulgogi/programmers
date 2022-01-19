package programmers_Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class heap_2 {
	public int solution(int[][] jobs) {
		int answer = 0;
		int time =0; //����ǰ� ������ �ð�
		int jobsindex =0; //jobs �迭�� �ε���
		int count =0; //����� ��û
		Arrays.sort(jobs, (o1,o2) -> o1[0] - o2[0]); //�۾� ���� �ð� ���� ����
        PriorityQueue<int[]> task_queue = new PriorityQueue<>((o1,o2) -> o1[1] - o2[1]);
        //jobs �� �۾��ð��� ����
        //task_queue �� ����ð��� ª�� ������ ����
        //	1. �ð����� �۾� queue�� �߰� - if(�߰�����)
        //	2. queue������ ���� ����ð��� ª���� ����  - if(ť������ ���) else if(����ª���� �̾ƿ´�) 
        //	3. ����� �� ���� �ð����� �۾� queue�� �߰� - 1. �׸񿡼� ����?
        //<���� �б�> �߰��ϴ°Ͱ��� ����
        while(count < jobs.length) {
        	while( jobsindex < jobs.length && time >= jobs[jobsindex][0]) {
        		// ���� ����ÿ� ������ ���� �� �� ���� ������ �˻��Ѵ� ���������� jobsindex outofbound ����
        		task_queue.add(jobs[jobsindex]);
        		jobsindex++;
        	}
        	if(task_queue.isEmpty()) {
        		time = jobs[jobsindex][0]; //ť�� ����� �� �������� �� �۾��� ���ð����� ����
        								   
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
