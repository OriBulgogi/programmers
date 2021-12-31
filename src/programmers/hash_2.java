package programmers;

import java.util.HashMap;
import java.util.Map;

public class hash_2 {

	public boolean solution(String[] phone_book) {
	        Map<String, Integer> map = new HashMap<>();
	        
	        for(int i= 0; i<phone_book.length; i++)
	            map.put(phone_book[i], i);
	        //phone_book[i].substring(beginIndex, endIndex) """"endIndex-1"""" ex)"ABCD" (0,3) = AB
	        for(int i=0; i<phone_book.length; i++)
	        	for(int j=0; j<phone_book[i].length(); j++)
	        		if(map.containsKey(phone_book[i].substring(0, j))) //substring end
	        			return false;
	    return true;
    }
	
	public static void main(String[] args) {
		hash_2 h = new hash_2();
		String[] phone_book = {"123","456","789"};
		System.out.println(h.solution(phone_book));
		
	}
}
