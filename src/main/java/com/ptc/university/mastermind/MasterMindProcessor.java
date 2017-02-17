package com.ptc.university.mastermind;

import com.sun.deploy.security.ruleset.Rule;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class MasterMindProcessor
{
    private byte[] secretKey;
    public String VALIDATION_ERROR;

    private int SECRET_KEY_LENGTH = 4;
    private List<Character> ALLOWED_COLORS = Arrays.asList('B','R','G','Y','P','V');

    public String SUCCESSFULLY_STORED = "Stored Successfully";
    public String INVALID_KEY_LENGTH = "Invalid Input Length. Only 4 characters are accepted.";
    public String INVALID_COLORS = "Input contains Invalid colors";
    public String REPEATED_KEY = "Repeated characters in Input";


    public String storeKey(String key) {
        if(!validate(key)){
            return VALIDATION_ERROR;
        }

        secretKey = key.getBytes();
        return SUCCESSFULLY_STORED;
    }

    public boolean validate(String key){
        if(StringUtils.isEmpty(key)) {
            throw new IllegalArgumentException("Input is Empty");
        }else if(SECRET_KEY_LENGTH != key.length()) {
            VALIDATION_ERROR = INVALID_KEY_LENGTH;
            return false;
        } else if (!(checkUnique(key))){
            VALIDATION_ERROR = REPEATED_KEY;
            return false;
        } else if(!containAllowedColors(key)){
            VALIDATION_ERROR = INVALID_COLORS;
            return false;
        }
        return true;
    }

    public boolean checkUnique(String str){

        HashSet hashSet = new HashSet(str.length());

        for(char c : str.toCharArray()){
            if(!hashSet.add(Character.toUpperCase(c)))
                return false;
        }
        return true;
    }

    private boolean containAllowedColors(String key){
        for(char c : key.toCharArray()){
            if(!ALLOWED_COLORS.contains(c)){
                return false;
            }
        }
        return true;
    }

    private String getSecretKey(){
        return new String(this.secretKey);
    }
    public String process(String inputCodes) {

        String rulesValidation = validateWithRules(inputCodes);

        if(!Rules.VALID.equals(rulesValidation)) {
            return rulesValidation;
        }

        String secretCode = getSecretKey();

        int blackCount = 0;
        int whiteCount = 0;
        String output = "";

        char[] charArray = inputCodes.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            int indexOfChar = secretCode.indexOf(charArray[i]);
            if (indexOfChar == -1){
            }
            else if (indexOfChar==i){
                blackCount++;
            }
            else{
                whiteCount++;
            }
        }
        output = output + StringUtils.repeat("B", blackCount);
        output = output + StringUtils.repeat("W", whiteCount);

        updateRulesMap(inputCodes, output);
        return output;
    }

    private String validateWithRules(String input) {
        if(Rules.RESULTS_MAP.containsKey(input)) {
            return Rules.REPEAT;
        }

        return Rules.VALID;
    }

    private void updateRulesMap(String inputCodes, String output) {
        Rules.RESULTS_MAP.put(inputCodes, output);
    }

}
