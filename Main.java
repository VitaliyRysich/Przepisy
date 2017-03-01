package com.javalesson.bazakotow;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	   // int [] tab= {0,1,2,3,4};
	    String str = "Hello";
        char [] tab = str.toCharArray();
        System.out.println(Arrays.toString(tab));
        for(int i= tab.length/2; i >= 0; i--)
        {
            char tmp = tab[i];
            tab[i] = tab[tab.length-1-i];
            tab[tab.length-1-i] = tmp;
        }
        System.out.println(Arrays.toString(tab));
        System.out.println(new String(tab));
    }
}
