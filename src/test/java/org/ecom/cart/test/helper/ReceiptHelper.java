package org.ecom.cart.test.helper;

import java.util.ArrayList;
import java.util.List;

import org.ecom.cart.bean.vo.Receipt;
import org.ecom.cart.bean.vo.ReceiptItem;

/**
 * Helper class for running the tests.
 * 
 * @author neel
 * 
 */
public final class ReceiptHelper {

	private ReceiptHelper() {
	}

	public static Receipt getEmptyReceipt() {
		List<ReceiptItem> items = new ArrayList<ReceiptItem>();

		return new Receipt(items);
	}

	public static Receipt getSmallAmountReceipt() {
		List<ReceiptItem> items = new ArrayList<ReceiptItem>();
		items.add(ReceiptItemHelper.getPasta());

		return new Receipt(items);
	}

	public static Receipt getBigAmountReceipt() {
		List<ReceiptItem> items = new ArrayList<ReceiptItem>();
		items.add(ReceiptItemHelper.getPasta());
		items.add(ReceiptItemHelper.getBook());

		return new Receipt(items);
	}

	public static Receipt getBigAmountReceiptWithDiscount() {
		List<ReceiptItem> items = new ArrayList<ReceiptItem>();
		items.add(ReceiptItemHelper.getPasta());
		items.add(ReceiptItemHelper.getBook());

		return new Receipt(items, 5d, 5d);
	}

}