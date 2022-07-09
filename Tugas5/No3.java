import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.w3c.dom.css.Counter;

public class No3 {
	public static void main(String[] args) {
		Map<String, String> indoEng = new HashMap<String, String>();
		indoEng.put("Microsoft", "Bill Gates");
		indoEng.put("Apple", "Steven Paul Jobs");
		indoEng.put("Linux", "Linux Benedict Trovalds");
		indoEng.put("Facebook", "Mark Zuckerberg");
		indoEng.put("Twitter", "Jack Dorsey");
		indoEng.put("Instagram", "Kevin Systrom");

		// cetak
		int number = 1;
		for (String i : indoEng.keySet()) {
			System.out.println(number + ". " + i.toUpperCase() + " dikembangkan oleh " + indoEng.get(i));
			number++;
		}

	}
}
