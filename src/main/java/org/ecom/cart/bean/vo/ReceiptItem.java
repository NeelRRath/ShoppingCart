package org.ecom.cart.bean.vo;

import java.io.Serializable;

import org.ecom.cart.util.CommonUtils;

/**
 * The item of the bill/receipt bean: is represented as an {@link Item} 
 * with a discount amount applied on.
 * 
 * It implements {@link Serializable} in order to make easier
 * the transformation into a JSON, XML or other serializable data type.
 * 
 * @author neel
 *
 */
public class ReceiptItem implements Serializable {
	
	private static final long serialVersionUID = -8161109734816482230L;
	
	private Item item;				// the item
	private Double discount;
	private Double discountPercentage;// the discount for each item

	public ReceiptItem(Item item, Double discount, Double discountPercentage) {
		super();
		this.item = item;
		this.discount = discount;
		this.discountPercentage = discountPercentage;
	}
	public ReceiptItem(Item item) {
		this(item,0d, 0d);
	}

	public Item getItem() {
		return item;
	}
	
	public Double getDiscount() {
		return discount;
	}
	public Double getDiscountPercentage() {
		return discountPercentage;
	}
	
	
	public Double getFinalPrice() {
		if (item.getGrossTotal() <= 0) {
			return new Double(0);
		}
		return CommonUtils.round(item.getGrossTotal() - discount); 
	}
	
	public String print() {
		//return  item.getItemName() + "  |  "+ item.getUnitPrice() + "  |  " + item.getQuantity() +"  |  "+ item.getGrossTotal() +"  |  "+ getDiscount()+"  |  "+ getFinalPrice();
		
		return String.format("%25s%16.2f%16d%16.2f%20.2f%20.2f", item.getItemName() ,
			item.getUnitPrice() , + item.getQuantity() , item.getGrossTotal() , getDiscount(), getFinalPrice());
		
	}
	
}