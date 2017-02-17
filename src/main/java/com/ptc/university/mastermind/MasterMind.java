package com.ptc.university.mastermind;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MasterMind {
    public static void main(String[] args) {
        Scanner scanner = new Scanner( System.in );
        MasterMindProcessor processor = new MasterMindProcessor();


        System.out.println("Enter the Secret Color codes :");
        String storeText = processor.storeKey(scanner.next());

        while(!processor.SUCCESSFULLY_STORED.equals(storeText)){
            System.out.println(storeText +". ReEnter the code :");
            storeText = processor.storeKey(scanner.next());
        }

        String input;
        int attempt = 1;

        System.out.println("Enter Colors in position order :");
        input = scanner.next();

        while(!play(input, processor, attempt)){
            System.out.println("Attempt :" + attempt);
            if(isMaxAttempt(attempt)) {
                System.out.println("You have exceeded the maximum number of attempts.");
                break;
            }
            System.out.println("Enter Colors in position order :");
            input = scanner.next();
        }

    }

    public static boolean isMaxAttempt(int attempts){
        return attempts == 6;
    }

    public static boolean play(String input, MasterMindProcessor processor, int attempt) {
        attempt++;
        if(!processor.validate(input)){
            System.out.println(processor.VALIDATION_ERROR);
            return false;
        } else {
            if(!processor.process(input)){
                return false;
            }
        }

        return true;
    }
}
