package programmers;

import java.util.HashMap;

public class hash_1 {
	public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        for(String player : participant) 
        	map.put(player, map.getOrDefault(player, 0) +1);
        
        for(String player : completion) 
        	map.put(player, map.get(player) -1);
        

        for (String key : map.keySet()) {
        	if(map.get(key) != 0) {
        		answer = key;
        	}
        }
        
        return answer;
    }
	public static void main(String[] args) {
		String[] part = {"lseo", "kiki", "eden","lseo"};
		String[] comp = {"eden", "kiki", "lseo"};
		hash_1 sol = new hash_1();
		System.out.println(sol.solution(part, comp));
	}
}
