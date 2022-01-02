package programmers;

import java.util.HashMap;
import java.util.Set;

public class hash_3 {
	public int solution(String[][] clothes) {

		int answer =1;
		HashMap<String,Integer> map = new HashMap<>();
		for(int i =0; i<clothes.length; i++) {
			map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0)+1);	
		}
		Set<String> keyset = map.keySet();
		
		for(String s : keyset) {
			answer *= map.get(s)+1;
		}
		
		return answer-1;
		
		
//		int answer =1;
//		HashMap<String,Integer> map = new HashMap<>();
//		for(int i=0; i<clothes.length; i++ ) {
//				map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0)+1);				
//		}
//		Set<String> keyset = map.keySet();
//		
//		for(String s : keyset) {
//			answer *= map.get(s)+1;
//		
//		}
//		return answer-1;
	}
	public static void main(String[] args) {
		
		hash_3 ha = new hash_3();
		String clothes[][] = {
				{"yellowhat", "headgear"},
				{"bluesunglasses", "eyewear"},
				{"green_turban", "headgear"}
				};
		System.out.println(ha.solution(clothes));
	}
}
