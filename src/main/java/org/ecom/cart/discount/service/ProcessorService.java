package org.ecom.cart.discount.service;

import java.util.List;

import org.ecom.cart.bean.vo.Item;
import org.ecom.cart.bean.vo.Receipt;
import org.ecom.cart.exception.DiscountProcessException;

public interface ProcessorService {
	Receipt processItems(List<Item> items) throws DiscountProcessException;
}
