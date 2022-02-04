package programmser_DFS_BFS;

public class network {
	int answer = 0;
    public int solution(int n, int[][] computers) {
        dfs(n, computers, 0);
        return answer;
    }
    public void dfs(int n, int[][]computers, int depth) {
    	
    }
    public static void main(String[] args) {
		network net = new network();
		int n= 3;
		int[][] computers = {
				{1, 1, 0}, 
				{1, 1, 0}, 
				{0, 0, 1}
				};
		net.solution(n, computers);
	}
}
