package AutomationTesting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class JavaPractice {
	
	public static void Collection()
	{
		
		
		List<List<Integer>> Arr= Arrays.asList(Arrays.asList(1,2,3),Arrays.asList(4,5),Arrays.asList(6,7,8));
		List<Integer> Flat= Arr.stream().flatMap(List::stream).collect(Collectors.toList());
		System.out.println(Flat);
		System.out.println("Gop");
		
		
		
		
		
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		Collection();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}


	

}
