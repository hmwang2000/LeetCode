package george.amazon;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsSort {

	public static void main(String[] args) {
		String[] input = { "you", "are", "my", "super", "star" };
		List<String> list = (List<String>) Arrays.asList(input);
		int i;
		for (i = 0; i < input.length; i++) {
			System.out.println(list);
		}

		Collections.sort(list);
		int j;
		for (j = 0; j < input.length; j++) {
			System.out.println(list);
		}

	}

}

