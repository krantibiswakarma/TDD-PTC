package com.ptc.university.mastermind;

import org.junit.Assert;
import org.junit.Test;

public class MasterMindTest {

    MasterMindProcessor processor = new MasterMindProcessor();

    @Test
    public void mastermindTest1() {
        processor.storeKey("RGVB");
        Assert.assertFalse(MasterMind.play("AAAA",processor, 0));
    }

    @Test
    public void mastermindTest2() {
        processor.storeKey("RGVB");
        Assert.assertTrue(MasterMind.play("RGVB",processor, 1));
    }
}
