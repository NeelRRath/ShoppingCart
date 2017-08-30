package org.ecom.cart.discount.strategy;

import org.ecom.cart.exception.DiscountProcessException;

public interface DiscountProcessor<T, E> {
	boolean isEnabled() throws DiscountProcessException;
	E process(T element) throws DiscountProcessException;
}
