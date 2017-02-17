package com.ptc.university.mastermind;

import org.junit.Assert;
import org.junit.Test;

public class MasterMindProcessorTest {

	MasterMindProcessor masterMindProcessor = new MasterMindProcessor();

	@Test
	public void storeSecretKey() {
		Assert.assertEquals(masterMindProcessor.SUCCESSFULLY_STORED, masterMindProcessor.storeKey("RGYV"));
	}

	@Test
	public void storeLessSecretKeyLength() {
		Assert.assertEquals(masterMindProcessor.INVALID_KEY_LENGTH, masterMindProcessor.storeKey("RGY"));
	}

	@Test
	public void storeMoreSecretKeyLength() {
		Assert.assertEquals(masterMindProcessor.INVALID_KEY_LENGTH, masterMindProcessor.storeKey("RGYVP"));
	}

	@Test
	public void storeRepeatedSecretKey() {
		Assert.assertEquals(masterMindProcessor.REPEATED_KEY, masterMindProcessor.storeKey("RRGB"));
	}

	@Test
	public void storeInvalidSecretKey() {
		Assert.assertEquals(masterMindProcessor.INVALID_COLORS, masterMindProcessor.storeKey("RGYZ"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void storeSecretKeyException() {
		masterMindProcessor.storeKey("");
	}

	@Test
	public void processInput() {
		masterMindProcessor.storeKey("RGVB");
		Assert.assertFalse(masterMindProcessor.process("RVGB"));
	}

}
