package org.ecom.cart.test.util;

import static org.junit.Assert.assertEquals;

import org.ecom.cart.util.CartConstants;
import org.ecom.cart.util.CommonUtils;
import org.junit.Test;

/**
 * Unit test for {@link CommonUtils}.
 * @author Neel
 */
public class CommonUtilsTest {
	
	@Test
	public void roundToScaleTwo() {
		assertEquals(8.50d, CommonUtils.round(8.5d, 2), CartConstants.DELTA_PRECISION);
		
		assertEquals(8.00d, CommonUtils.round(8d, 2), CartConstants.DELTA_PRECISION);
		assertEquals(8.01d, CommonUtils.round(8.01d, 2), CartConstants.DELTA_PRECISION);
		assertEquals(8.00d, CommonUtils.round(8.001d, 2), CartConstants.DELTA_PRECISION);
		assertEquals(8.00d, CommonUtils.round(8.000001d, 2), CartConstants.DELTA_PRECISION);
		assertEquals(8.00d, CommonUtils.round(8.001d, 2), CartConstants.DELTA_PRECISION);
		assertEquals(8.00d, CommonUtils.round(8.002d, 2), CartConstants.DELTA_PRECISION);
		assertEquals(8.00d, CommonUtils.round(8.003d, 2), CartConstants.DELTA_PRECISION);
		assertEquals(8.00d, CommonUtils.round(8.004d, 2), CartConstants.DELTA_PRECISION);
		assertEquals(8.00d, CommonUtils.round(8.0044d, 2), CartConstants.DELTA_PRECISION);
		assertEquals(8.00d, CommonUtils.round(8.0046d, 2), CartConstants.DELTA_PRECISION);
		assertEquals(8.01d, CommonUtils.round(8.005d, 2), CartConstants.DELTA_PRECISION);
		assertEquals(8.01d, CommonUtils.round(8.0054d, 2), CartConstants.DELTA_PRECISION);
		assertEquals(8.01d, CommonUtils.round(8.006d, 2), CartConstants.DELTA_PRECISION);
		assertEquals(8.01d, CommonUtils.round(8.007d, 2), CartConstants.DELTA_PRECISION);
		assertEquals(8.01d, CommonUtils.round(8.008d, 2), CartConstants.DELTA_PRECISION);
		assertEquals(8.01d, CommonUtils.round(8.009d, 2), CartConstants.DELTA_PRECISION);
	}
	
	@Test
	public void roundToScaleZero() {
		assertEquals(9d, CommonUtils.round(8.509d, 0), CartConstants.DELTA_PRECISION);
		assertEquals(8d, CommonUtils.round(8.409d, 0), CartConstants.DELTA_PRECISION);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void roundToScaleNegative() {
		assertEquals(8.51d, CommonUtils.round(8.509d, -1), CartConstants.DELTA_PRECISION);
	}
	
	@Test
	public void nearestDecimalFive() {
		assertEquals(1.00d, CommonUtils.nearestDecimalFive(1d), CartConstants.DELTA_PRECISION);
		assertEquals(1.00d, CommonUtils.nearestDecimalFive(1.0d), CartConstants.DELTA_PRECISION);
		assertEquals(1.00d, CommonUtils.nearestDecimalFive(1.00d), CartConstants.DELTA_PRECISION);
		assertEquals(1.00d, CommonUtils.nearestDecimalFive(1.01d), CartConstants.DELTA_PRECISION);
		assertEquals(1.00d, CommonUtils.nearestDecimalFive(1.02d), CartConstants.DELTA_PRECISION);
		assertEquals(1.00d, CommonUtils.nearestDecimalFive(1.0247d), CartConstants.DELTA_PRECISION);
		assertEquals(1.00d, CommonUtils.nearestDecimalFive(1.0248d), CartConstants.DELTA_PRECISION);
		assertEquals(1.00d, CommonUtils.nearestDecimalFive(1.0249d), CartConstants.DELTA_PRECISION);
		assertEquals(1.00d, CommonUtils.nearestDecimalFive(1.0250d), CartConstants.DELTA_PRECISION);
		assertEquals(1.05d, CommonUtils.nearestDecimalFive(1.0251d), CartConstants.DELTA_PRECISION);
		assertEquals(1.05d, CommonUtils.nearestDecimalFive(1.03d), CartConstants.DELTA_PRECISION);
		assertEquals(1.05d, CommonUtils.nearestDecimalFive(1.04d), CartConstants.DELTA_PRECISION);
		assertEquals(1.05d, CommonUtils.nearestDecimalFive(1.05d), CartConstants.DELTA_PRECISION);
		assertEquals(1.05d, CommonUtils.nearestDecimalFive(1.06d), CartConstants.DELTA_PRECISION);
		assertEquals(1.05d, CommonUtils.nearestDecimalFive(1.07d), CartConstants.DELTA_PRECISION);
		assertEquals(1.10d, CommonUtils.nearestDecimalFive(1.08d), CartConstants.DELTA_PRECISION);
		assertEquals(1.10d, CommonUtils.nearestDecimalFive(1.09d), CartConstants.DELTA_PRECISION);
		assertEquals(1.10d, CommonUtils.nearestDecimalFive(1.090000001d), CartConstants.DELTA_PRECISION);
	}
	
}