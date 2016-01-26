import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class DuplicateItems {

	public static void main(String[] args) {

		List<String> list = new ArrayList<String>();
		list.add("One");
		list.add("One");
		list.add("two");
		list.add("two");
		list.add("three");

		

		Iterator iterator = list.iterator();
		iterator.next();
		iterator.remove();
		iterator.next();
		iterator.remove();

		
		Set<String> set = new HashSet<String>(list);
		for (String individualValue : set) {
			System.out.println(individualValue);
		}
	}

}
