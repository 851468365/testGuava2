package com.example.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;

/**
 * @Description : todo
 * @Author : 自健
 * @Date: 2021/11/14
 */
public class TestStringJoiner {
	public static void main(String[] args) {
		StringJoiner stringJoiner = new StringJoiner(":");
		stringJoiner.add("姓名").add("张飞");
		System.out.println(stringJoiner.toString());



		StringJoiner stringJoiner2 = new StringJoiner(":","[","]");
		stringJoiner2.add("姓名").add("张飞");
		System.out.println(stringJoiner2.toString());



		HashMap<String, Object> map = new HashMap<>();
		map.put("name", "zhaoyun");
		map.put("age", 18);
		String join = Joiner.on(",").withKeyValueSeparator(":").join(map);
		System.out.println(join);

		List<String> strings = Splitter.on(":").splitToList("姓名:张飞");
		System.out.println(strings);

		Map<String, String> split1 = Splitter.on(",").withKeyValueSeparator("&").split("name:zhaoyun,age:18");
		System.out.println(split1);



		String test = ",,  3434,434,34,,哈哈,, ";
		String[] split = test.split(",");
		for (String s : split) {
			System.out.println(s);
		}
		System.out.println("--------");



	}
}
