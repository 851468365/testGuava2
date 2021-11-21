package com.example.demo;

import java.util.Collection;
import java.util.Map.Entry;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.HashMultiset;

/**
 * @Description : todo
 * @Author : 自健
 * @Date: 2021/11/16
 */
public class TestMultiMap {
	public static void main(String[] args) {
		HashMultimap<Object, Object> hashMultimap = HashMultimap.create();
		hashMultimap.put("aa","11");
		hashMultimap.put("aa","10");
		hashMultimap.put("aa","12");
		hashMultimap.put("bb","22");
		hashMultimap.put("cc","33");

		for (Entry<Object, Object> entry : hashMultimap.entries()) {
			System.out.println(entry.getKey()+":"+entry.getValue());
		}

		for (Entry<Object, Collection<Object>> entry : hashMultimap.asMap().entrySet()) {
			System.out.println(entry.getKey()+":"+entry.getValue());
		}

	}
}
