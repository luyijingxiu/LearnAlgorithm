package basic_class_08;

import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main2   {
    public static void main(String[] args) throws IOException {
        Map<Integer, String> map=new LinkedHashMap<>();
        map.put( 5, "a");
        map.put( 4, "b");
        map.put( 3, "c");
        map.put( 2, "d");
        map.put( 1, "e");
        
        map.get(2);
        for(int key: map.keySet()) {
        	System.out.println(key+" : "+map.get(key));
        }
    }


    public Map<Long,String> sort(Map<Long,String> map){
    	
    	Map<String,Long> rMap=new TreeMap<String,Long>(new Comparator<String>() {
    		
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
		});
    	for(Long key :map.keySet()) {
    		rMap.put(map.get(key),key);
    	}
    	
    	Map<Long, String> result=new HashMap<Long, String>();
    	for(String key :rMap.keySet()) {
    		result.put(rMap.get(key),key);
    	}
        return result;
    }
}

