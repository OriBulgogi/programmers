package programmers_hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;


public class hash_4 {
    public int[] solution(String[] genres, int[] plays) {
        
        ArrayList<String> genreList = new ArrayList<>();
        ArrayList<Integer> List = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i =0; i<genres.length; i++) {
        	map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);	
        }
        
        for(String key : map.keySet()) {
        	genreList.add(key);
        }
        Collections.sort(genreList, (o1, o2) -> map.get(o2) - map.get(o1));
        
        
        for(int i =0; i<genreList.size(); i++) {
        	int max =0;
        	int first_idx = -1;
        	int second_idx = -1;
        	for(int j=0; j<genres.length; j++) {
        		if(genres[j].equals(genreList.get(i)) && max < plays[j]) {
        			max = plays[j];
        			first_idx = j;
        		}
        	} 
        	max =0;
        	for(int j=0; j<genres.length; j++) {
        		if(first_idx != j) { 
	        		if(genres[j].equals(genreList.get(i))  && max < plays[j] ) {
	        			max = plays[j];
	        			second_idx = j;
	        		}
        		}
        	}
        	List.add(first_idx);
        	if(second_idx >= 0) List.add(second_idx);
        }
        int[] answer = new int[List.size()];
        for(int i =0; i<answer.length; i++) {
        	answer[i]= List.get(i);
        	
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }
 
    public static void main(String[] args) {
		hash_4 ha = new hash_4();
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 600, 150, 800, 2500};
		System.out.println(ha.solution(genres, plays));
	}
}
