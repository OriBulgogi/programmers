package programmser_DFS_BFS;

public class target_number {
    int answer = 0;
	
	   public int solution(int[] numbers, int target) {
	        dfs(numbers, target, 0, 0); 
	        return answer;
	    }
	   public void dfs(int[] numbers, int target, int depth, int sum) {
		   if(depth == numbers.length) {
			   if(target==sum) answer++;
		   }else {
			   dfs(numbers, target, depth+1, sum +numbers[depth]);
			   dfs(numbers, target, depth+1, sum - numbers[depth]);
		   }
		   
	   }
	   public static void main(String[] args) {
		   target_number ta = new target_number();
		   int[] numbers = {4,1 ,2 ,1};
		   int target = 4;
		   System.out.println(ta.solution(numbers, target));
	}
	   
}
