package java.jdk8;

import java.util.Arrays;
import java.util.Collections;
import java.util.IntSummaryStatistics;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
		Integer converted = converter.convert("123");
		System.out.println(converted);

		//Java 8 允许你使用 :: 关键字来传递方法或者构造函数引用
		Converter<String, Integer> converter1 = Integer::valueOf;
		Integer converted1 = converter1.convert("123");
		System.out.println(converted1);

		//可以直接在lambda表达式中访问外层的局部变量（隐性具有final语义,不能修改）
		int num = 1;
		Converter<Integer, String> stringConverter = (from) -> String.valueOf(from + num);
		String str = stringConverter.convert(2);
		System.out.println(str);

//		Collections.sort(list, (a, b) -> b.compareTo(a));

		ArrayList<String> list = new ArrayList<>(Arrays.asList("I","love","you","all"));
		list.sort((str1,str2)->str1.length()-str2.length());

		System.out.println(list);

		Collections.sort(list, (a, b) -> b.compareTo(a));
		System.out.println(list);

		// 将字符串换成大写并用逗号链接起来
		List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.","Canada");
		String G7Countries = G7.stream().map(x -> x.toUpperCase()).collect(Collectors.joining(", "));
		System.out.println(G7Countries);

		// 用所有不同的数字创建一个正方形列表
		List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
		List<Integer> distinct = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
		System.out.printf("Original List : %s,  Square Without duplicates : %s %n", numbers, distinct);

		//获取数字的个数、最小值、最大值、总和以及平均值
		List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
		IntSummaryStatistics stats = primes.stream().mapToInt((x) -> x).summaryStatistics();
		System.out.println("Highest prime number in List : " + stats.getMax());
		System.out.println("Lowest prime number in List : " + stats.getMin());
		System.out.println("Sum of all prime numbers : " + stats.getSum());
		System.out.println("Average of all prime numbers : " + stats.getAverage());

		// 为每个订单加上12%的税
		// 老方法：
		List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
		double total = 0;
		for (Integer cost : costBeforeTax) {
			double price = cost + .12*cost;
			total = total + price;
		}
		System.out.println("Total : " + total);

		// 新方法：
		List<Integer> costBeforeTax_1 = Arrays.asList(100, 200, 300, 400, 500);
		double bill = costBeforeTax_1.stream().map((cost) -> cost + .12*cost).reduce((sum, cost) -> sum + cost).get();
		System.out.println("Total : " + bill);
	}
}
