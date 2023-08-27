package com.vietdev.chatapplication.chat;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author VietDev
 * @date 28/08/2023
 * @role
 */
public class Test {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(5,4,1,5,7,2,7);
        System.out.println(integers.stream().max(Comparator.comparing(Integer::intValue)));
    }
}

