package org.ecom.cart.test.bean;

import static org.junit.Assert.assertEquals;

import org.ecom.cart.bean.vo.Receipt;
import org.ecom.cart.test.helper.ReceiptHelper;
import org.ecom.cart.util.CartConstants;
import org.junit.Test;

/**
 * Unit test for {@link Receipt}.
 * @author Neel
 */
public class ReceiptTest {

	@Test
	public void grossTotalOnEmptyReceiptShouldBeZero() {
		Receipt receipt = ReceiptHelper.getEmptyReceipt();
		assertEquals(0d, receipt.getGrossTotal(), CartConstants.DELTA_PRECISION);
	}
	
	@Test
	public void discountOnEmptyReceiptShouldBeZero() {
		Receipt receipt = ReceiptHelper.getEmptyReceipt();
		assertEquals(0d, receipt.getDiscount(), CartConstants.DELTA_PRECISION);
	}
	
	@Test
	public void totalOnEmptyReceiptShouldBeZero() {
		Receipt receipt = ReceiptHelper.getEmptyReceipt();
		assertEquals(0d, receipt.getTotal(), CartConstants.DELTA_PRECISION);
	}
	
	@Test
	public void totalDiscountOnEmptyReceiptShouldBeZero() {
		Receipt receipt = ReceiptHelper.getEmptyReceipt();
		assertEquals(0d, receipt.getTotalDiscount(), CartConstants.DELTA_PRECISION);
	}

	@Test
	public void shouldReturnGrossTotal() {
		Receipt receiptWithDiscount = ReceiptHelper.getBigAmountReceiptWithDiscount();
		assertEquals(66.6d, receiptWithDiscount.getGrossTotal(), CartConstants.DELTA_PRECISION);
		
		Receipt receiptNoDiscount = ReceiptHelper.getBigAmountReceipt();
		assertEquals(66.6d, receiptNoDiscount.getGrossTotal(), CartConstants.DELTA_PRECISION);
	}
	
	@Test
	public void shouldReturnDiscount() {
		Receipt receiptWithDiscount = ReceiptHelper.getBigAmountReceiptWithDiscount();
		assertEquals(5d, receiptWithDiscount.getDiscount(), CartConstants.DELTA_PRECISION);
		
		Receipt receiptNoDiscount = ReceiptHelper.getBigAmountReceipt();
		assertEquals(0d, receiptNoDiscount.getDiscount(), CartConstants.DELTA_PRECISION);
	}
	
	@Test
	public void shouldReturnTotal() {
		Receipt receiptWithDiscount = ReceiptHelper.getBigAmountReceiptWithDiscount();
		assertEquals(61.6d, receiptWithDiscount.getTotal(), CartConstants.DELTA_PRECISION);
		
		Receipt receiptNoDiscount = ReceiptHelper.getBigAmountReceipt();
		assertEquals(66.6d, receiptNoDiscount.getTotal(), CartConstants.DELTA_PRECISION);
	}
	
	@Test
	public void shouldReturnTotalDiscount() {
		Receipt receiptWithDiscount = ReceiptHelper.getBigAmountReceiptWithDiscount();
		assertEquals(5d, receiptWithDiscount.getTotalDiscount(), CartConstants.DELTA_PRECISION);
		
		Receipt receiptNoDiscount = ReceiptHelper.getBigAmountReceipt();
		assertEquals(0d, receiptNoDiscount.getTotalDiscount(), CartConstants.DELTA_PRECISION);
	}
	
}