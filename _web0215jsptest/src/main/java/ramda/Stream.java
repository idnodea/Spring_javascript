package ramda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Stream {

	
		public static void main(String[] args) {
			List<Integer>list
			= Arrays.asList(1,2,3,4,5);
//			int x = (int) list.stream().count();
			
			list
			.stream()
//			.filter((i)->{return i%2==0;})
			.filter(i->i%2==0)
//			.map(i->i*2)
			.map(i->"요소는"+i+"입니다.")
			.limit(3)
//			.forEach(i->System.out.println(i));
			.forEach(System.out::println);
			
//			System.out.println(x);
			
//			list.stream().filter(i->i%2==0)
//			.forEach(i->System.out.println(i));
			
//			=new ArrayList<Integer>();
//			list.add(1);list.add(2);
//			list.add(3);list.add(41);list.add(5);
//			for(Integer i : list) {
//				if(i%2==0) {
//					System.out.println(i);
//				}
//			}
		}
}
