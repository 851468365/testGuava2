package org.example.collect;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multiset.Entry;

/**
 * @Description : todo
 * @Author : 自健
 * @Date: 2021/11/16
 */
public class TestMultiset {
	public static void main(String[] args) {
		HashMultiset<Object> hashMultiset = HashMultiset.create();
		hashMultiset.add("aaa");
		hashMultiset.add("aaa");
		hashMultiset.add("bbb");
		hashMultiset.add("ccc");
		System.out.println(hashMultiset.size());
		System.out.println(hashMultiset.count("aaa"));
		System.out.println(hashMultiset.elementSet().size());
		for (Object o : hashMultiset) {
			System.out.println(o);

		}

		for (Entry<Object> objectEntry : hashMultiset.entrySet()) {
			System.out.println(objectEntry.getElement() + "：" + objectEntry.getCount());
		}

		for (Object o : hashMultiset.elementSet()) {
			System.out.println(o);
		}
		
	}
}
