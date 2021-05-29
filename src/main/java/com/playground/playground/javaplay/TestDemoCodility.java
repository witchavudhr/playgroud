package com.playground.playground.javaplay;

public class TestDemoCodility {
    public static void main(String args[])
    {
        int[] intArray = new int[] {1,3,6,4,1,2};
        int i = 0;
        int temp = 0;

        if(intArray[i] < intArray[i+1]) {
            temp = intArray[i];
        }

        while (i < intArray.length) {
            if(temp > intArray[i]) {
                temp = intArray[i];
                System.out.println(temp);
            }
            i++;
        }
        System.out.println("result : "+temp);
    }



}
