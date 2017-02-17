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
        PassMeByRef attempt = new PassMeByRef();

        System.out.println("Enter Colors in position order :");
        input = scanner.next();

        while(!play(input, processor, attempt)){

            System.out.println("Enter Colors in position order :");
            input = scanner.next();
        }

    }

    public static boolean isMaxAttempt(int attempts){
        return attempts == 6;
    }

    public static boolean play(String input, MasterMindProcessor processor, PassMeByRef attempt) {

        System.out.println("Attempt :" + attempt.theValue);
        if(isMaxAttempt(attempt.theValue)) {
            System.out.println("You have exceeded the maximum number of attempts.");
            return false;
        }


        attempt.theValue = attempt.theValue + 1;
        if(!processor.validate(input)){
            System.out.println(processor.VALIDATION_ERROR);
            return false;
        } else {
            if(!processor.process(input)){
                return false;
            }
            System.out.println("Congratulations! RGVBYou have guessed it Right");
        }

        return true;
    }
}

class PassMeByRef { public int theValue = 0; }
