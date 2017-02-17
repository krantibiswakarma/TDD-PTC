package com.ptc.university.mastermind;

import org.junit.Assert;
import org.junit.Test;

public class MasterMindTest {

    MasterMindProcessor processor = new MasterMindProcessor();

    @Test
    public void mastermindTest1() {
        processor.storeKey("RGVB");
        Assert.assertFalse(MasterMind.play("AAAA",processor, new PassMeByRef()));
    }

    @Test
    public void mastermindTest2() {
        processor.storeKey("RGVB");
        Assert.assertTrue(MasterMind.play("RGVB",processor, new PassMeByRef()));
    }

    @Test
    public void mastermindTest3() {
        processor.storeKey("RGVB");
        PassMeByRef ref = new PassMeByRef();
        ref.theValue = 6;
        Assert.assertFalse(MasterMind.play("RGVB",processor, ref));
    }
}
