package org.ecom.cart.discount.service;

import java.util.ArrayList;
import java.util.List;

import org.ecom.cart.bean.vo.Item;
import org.ecom.cart.bean.vo.Receipt;
import org.ecom.cart.bean.vo.ReceiptItem;
import org.ecom.cart.discount.strategy.DiscountProcessor;
import org.ecom.cart.exception.DiscountProcessException;

public class ProcessorServiceImpl implements ProcessorService {

	private DiscountProcessor<Item,ReceiptItem> itemDiscountProcessor;
	private DiscountProcessor<Receipt,Receipt> slabDiscountProcessor;
	

	public DiscountProcessor<Item, ReceiptItem> getItemDiscountProcessor() {
		return itemDiscountProcessor;
	}


	public void setItemDiscountProcessor(DiscountProcessor<Item, ReceiptItem> itemDiscountProcessor) {
		this.itemDiscountProcessor = itemDiscountProcessor;
	}


	public DiscountProcessor<Receipt, Receipt> getSlabDiscountProcessor() {
		return slabDiscountProcessor;
	}


	public void setSlabDiscountProcessor(DiscountProcessor<Receipt, Receipt> slabDiscountProcessor) {
		this.slabDiscountProcessor = slabDiscountProcessor;
	}


	@Override
	public Receipt processItems(List<Item> items) throws DiscountProcessException {
		List<ReceiptItem> itemlist =  new ArrayList<>();
		for(Item item : items){
			ReceiptItem ritem = getItemDiscountProcessor().process(item);
			if(null != ritem){
				itemlist.add(ritem);
			}
		}
		Receipt receipt = new Receipt(itemlist);
		getSlabDiscountProcessor().process(receipt);
		return receipt;
	}

}
