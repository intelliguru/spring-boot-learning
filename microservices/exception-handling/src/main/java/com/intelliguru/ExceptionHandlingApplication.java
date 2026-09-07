package com.intelliguru;

import lombok.extern.slf4j.Slf4j;

import java.io.FileReader;
import java.io.IOException;


@Slf4j
public class ExceptionHandlingApplication {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 7;
        int result = searchInsert(nums, target);
    }



    public void checkUserAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Age must be 18+");
        }
    }



    public void readFile() throws IOException {
        FileReader reader = new FileReader("data.txt");
        log.info("File Reader: {}", reader);
    }

    public static int searchInsert(int[] nums, int target) {
        int index=0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i] == target){
                index = i;
            }


            for(int j = i; j<nums.length; j++){
                if(nums[j]+1  == target){
                    index = j+1;
                }
            }
        }
        return index;
    }



















}