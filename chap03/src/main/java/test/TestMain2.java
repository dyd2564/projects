package test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Consumer;
import java.util.Set;import lombok.val;

public class TestMain2 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>(); 
		list.add("홍길동"); 
		list.add("이순신"); 
		list.add("김유신");
		list.add("임꺽정");
		
		list.forEach(t->System.out.println(t));
	}
}
