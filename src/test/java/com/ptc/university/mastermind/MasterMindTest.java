package com.ptc.university.mastermind;

import org.junit.Assert;
import org.junit.Test;

public class MasterMindTest {

	MasterMind masterMind = new MasterMind();

	@Test
	public void storeSecretKey() {
		Assert.assertEquals(masterMind.SUCCESSFULLY_STORED,masterMind.storeKey("RGYV"));
	}

	@Test
	public void storeLessSecretKeyLength() {
		Assert.assertEquals(masterMind.INVALID_KEY_LENGTH,masterMind.storeKey("RGY"));
	}

	@Test
	public void storeMoreSecretKeyLength() {
		Assert.assertEquals(masterMind.INVALID_KEY_LENGTH,masterMind.storeKey("RGYVP"));
	}

	@Test
	public void storeRepeatedSecretKey() {
		Assert.assertEquals(masterMind.REPEATED_KEY,masterMind.storeKey("RGYR"));
	}

	@Test
	public void storeInvalidSecretKey() {
		Assert.assertEquals(masterMind.INVALID_COLORS,masterMind.storeKey("RGYZ"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void storeSecretKeyException() {
		masterMind.storeKey("");
	}

}
