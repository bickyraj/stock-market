package com.bickyraj.demo;

import com.bickyraj.demo.pizza.*;
import com.bickyraj.demo.restaurant.Food;
import com.bickyraj.demo.restaurant.FoodCart;
import com.bickyraj.demo.restaurant.LaPizzaRestaurant;
import com.bickyraj.demo.restaurant.Restaurant;
import com.bickyraj.demo.restaurant.foods.momo.ChickenMomo;
import com.bickyraj.demo.restaurant.foods.momo.momodecorators.Cheese;
import com.bickyraj.demo.restaurant.foods.ramen.PlainRamen;
import com.bickyraj.demo.restaurant.foods.ramen.ramendecorators.ChickenRamen;
import com.bickyraj.demo.restaurant.foods.ramen.ramendecorators.SpicyRamen;

public class Main {
    public static void main(String[] args) {
        String testString = "abasdfsfagstestestada";
        int counter = 0;
        while(counter < testString.length()) {
            for (int i = counter; i < testString.length(); i++) {
                for (int j = i; j < i + 1; j++) {
                    char[] subString = new char[j];
                    for (int k = 0; k < j; k++) {
                        subString[k] = testString.charAt(k);
                    }
                    System.out.println(String.valueOf(subString));
                    System.out.println(longestPalindrome(String.valueOf(subString)));
                }
            }
            counter++;
        }

    }

    public static boolean longestPalindrome(String s) {
        char[] sArr = s.toCharArray();
        char[] tmp = new char[sArr.length];
        for (int i = 0; i < sArr.length; i++) {
            tmp[i] = sArr[sArr.length - 1 - i];
        }

        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i] != sArr[i]) {
                return false;
            }
        }

        return true;
    }
}
