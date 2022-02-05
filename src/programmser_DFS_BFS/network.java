package programmser_DFS_BFS;

public class network {
	
    public int solution(int n, int[][] computers) {
    	int answer = 0;
    	boolean[] visited = new boolean[n];
    	//i = �ѳ�Ʈ��ũ �׷� /  j= �׷쳻�� �� ���
    	for(int i= 0; i< n; i++) {
    		if(!visited[i]) { //�湮���ѳ��
    			dfs(i, computers, visited);
    			answer++;
    		}
    	}
        return answer;
    }
    public boolean[] dfs(int i, int[][]computers, boolean[] visited) {
    	visited[i] = true;
    	
    	for(int j =0; j< computers.length; j++) {
    		if(i != j && computers[i][j] == 1 && visited[j] == false) {
    			visited = dfs(j, computers, visited);
    		}
    	}
    	return visited;
    }
    public static void main(String[] args) {
		network net = new network();
		int n= 3;
		int[][] computers = {
				{1, 1, 0}, 
				{0, 1, 1}, 
				{0, 0, 1}
				};
		System.out.println(net.solution(n, computers));
	}
}
