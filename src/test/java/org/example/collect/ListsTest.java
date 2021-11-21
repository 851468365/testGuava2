package org.example.collect;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import org.example.Apple;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListsTest {

    @Test
    public void testLists(){
        //[b, c]
        ArrayList<String> list = Lists.newArrayList("b", "c");

        //[a, b, c]
        List<String> list2 = Lists.asList("a", new String[]{"b", "c"});

        // 获取多个list的笛卡尔集
        //[[a, 1], [a, 2], [b, 1], [b, 2], [c, 1], [c, 2]]
        List<List<String>> list3 = Lists.cartesianProduct(list2, Lists.newArrayList("1", "2"));

        //将字符串转成字符集合
        //[A, B, C]
        ImmutableList<Character> list4 = Lists.charactersOf("ABC");

        //将字符串转成字符集合
        //[A, B, C]
        List<Character> list5 = Lists.charactersOf(new StringBuffer("ABC"));

        //将list按指定大小分隔成多个list
        //[[1, 2], [3, 4], [5]]
        ArrayList<String> numList = Lists.newArrayList("1", "2", "3", "4", "5");
        List<List<String>> list6 = Lists.partition(numList, 2);

        //反转list
        //[5, 4, 3, 2, 1]
        List<String> list7 = Lists.reverse(numList);

        // 数据转换
        //[元素：1, 元素：2, 元素：3, 元素：4, 元素：5]
        List<Object> list8 = Lists.transform(numList, new Function<String, Object>() {
            @Override
            public Object apply(String input) {
                return "元素：" + input;
            }
        });
        //在Java 8中的实现为
        List<String> list9 = numList.stream().map(s -> "元素：" + s).collect(Collectors.toList());
        String str = numList.stream().filter(s -> s.equals("2")).findFirst().get();


        List<Apple> appleList = Lists.newArrayList(new Apple(1, "red"), new Apple(2, "red"), new Apple(3, "green"), new Apple(4, "green"));
        /**
         * 1:{"color":"red","id":1}
         * 2:{"color":"red","id":2}
         * 3:{"color":"green","id":3}
         * 4:{"color":"green","id":4}
         */
        Map<Integer, Apple> appleMap = appleList.stream().collect(Collectors.toMap(Apple::getId, apple -> apple));

        /**
         * red:[{"color":"red","id":1},{"color":"red","id":2}]
         * green:[{"color":"green","id":3},{"color":"green","id":4}]
         */
        Map<String, List<Apple>> groupsByColor =appleList.stream().collect(Collectors.groupingBy(Apple::getColor));


        System.out.println(list);
        System.out.println(list2);
        System.out.println(list3);
        System.out.println(list4);
        System.out.println(list5);
        System.out.println(list6);
        System.out.println(list7);
        System.out.println(list8);
        System.out.println(list9);
        System.out.println(str);
        System.out.println(JSONObject.toJSONString(appleMap));

        for (Map.Entry<Integer, Apple> entry : appleMap.entrySet()) {
            System.out.println(entry.getKey() + ":" + JSON.toJSONString(entry.getValue()));
        }

        for (Map.Entry<String, List<Apple>> entry : groupsByColor.entrySet()) {
            System.out.println(entry.getKey() + ":" + JSON.toJSONString(entry.getValue()));
        }


    }


}
