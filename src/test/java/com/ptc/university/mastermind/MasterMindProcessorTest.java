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
	public void processInput1() {
		masterMindProcessor.storeKey("RBYG");
		Assert.assertEquals("BBBB", masterMindProcessor.process("RBYG"));
	}

	@Test
	public void processInput2() {
		masterMindProcessor.storeKey("RBYG");
		Assert.assertEquals("BBWW", masterMindProcessor.process("RYBG"));
	}

	@Test
	public void processInput3() {
		masterMindProcessor.storeKey("RBYG");
		Assert.assertEquals("WWWW", masterMindProcessor.process("YRGB"));
	}

	@Test
	public void processInput4() {
		masterMindProcessor.storeKey("RBYG");
		Assert.assertEquals("BWWW", masterMindProcessor.process("YRBG"));
	}

	@Test
	public void processInput5() {
		masterMindProcessor.storeKey("RBYG");
		Assert.assertEquals("BBB", masterMindProcessor.process("RBYV"));
	}

	@Test
	public void processInput6() {
		masterMindProcessor.storeKey("RBYG");
		Assert.assertEquals("WWW", masterMindProcessor.process("BYRV"));
	}

	@Test
	public void processInput7() {
		masterMindProcessor.storeKey("RBYG");
		Assert.assertEquals("BB", masterMindProcessor.process("RBVP"));
	}

	@Test
	public void processInput8() {
		masterMindProcessor.storeKey("RBYG");
		Assert.assertEquals("WW", masterMindProcessor.process("BRPV"));
	}

}
