package org.ecom.cart.manager.receipt.impl;

import java.util.List;

import org.ecom.cart.bean.vo.Item;
import org.ecom.cart.bean.vo.Receipt;
import org.ecom.cart.discount.service.ProcessorService;
import org.ecom.cart.exception.DiscountProcessException;
import org.ecom.cart.manager.receipt.ReceiptManager;

/**
 * useful methods for calculating the discount on the item/receipt passed.
 * 
 * TODO: is Singleton annotation really needed??
 * 
 * @author neel
 * 
 */

public class ReceiptManagerImpl implements ReceiptManager {

	private ProcessorService processorService;

	public ProcessorService getProcessorService() {
		return processorService;
	}

	public void setProcessorService(ProcessorService processorService) {
		this.processorService = processorService;
	}

	@Override
	public Receipt calculate(List<Item> items) throws DiscountProcessException {
		Receipt receipt = null;
		try {
			receipt = getProcessorService().processItems(items);
		} catch (Exception e) {
			throw new DiscountProcessException(e.getMessage());
		}
		return receipt;
	}

}