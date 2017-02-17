package com.ptc.university.mastermind;

import com.sun.org.apache.xerces.internal.xs.StringList;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MasterMind
{
    private byte[] secterKey;
    private String VALIDATION_ERROR;

    private int SECRET_KEY_LENGTH = 4;
    private List<Character> ALLOWED_COLORS = Arrays.asList('B','R','G','Y','P','V');

    public String SUCCESSFULLY_STORED = "Stored Successfully";
    public String INVALID_KEY_LENGTH = "Invalid Key Length. Only 4 characters are accepted.";
    public String INVALID_COLORS = "Key contains Invalid colors";
    public String REPEATED_KEY = "Repeated Key";


    public String storeKey(String key) {
        if(!validate(key)){
            return VALIDATION_ERROR;
        }

        secterKey = key.getBytes();
        return SUCCESSFULLY_STORED;
    }

    private boolean validate(String key){
        if(StringUtils.isEmpty(key)) {
            throw new IllegalArgumentException("Key is Empty");
        }else if(SECRET_KEY_LENGTH != key.length()) {
            VALIDATION_ERROR = INVALID_KEY_LENGTH;
            return false;
        } else if (!(checkForUnique(key))){
            VALIDATION_ERROR = REPEATED_KEY;
            return false;
        } else if(!containAllowedColors(key)){
            VALIDATION_ERROR = INVALID_COLORS;
            return false;
        }
        return true;
    }

    private boolean checkForUnique(String str){
        boolean containsUnique = false;
        for(char c : str.toCharArray()){
            if(str.indexOf(c) == str.lastIndexOf(c)){
                containsUnique = true;
            } else {
                containsUnique = false;
            }
        }
    return containsUnique;
    }

    private boolean containAllowedColors(String key){
        for(char c : key.toCharArray()){
            if(!ALLOWED_COLORS.contains(c)){
                return false;
            }
        }
        return true;
    }

}
