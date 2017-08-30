package org.ecom.cart.bean.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * The item bean: it represents a single line of an order.
 * 
 * It implements {@link Serializable} in order to make easier the transformation
 * into a JSON, XML or other serializable data type.
 * 
 * @author neel
 * 
 */
@XmlRootElement(name = "item")
@XmlAccessorType(XmlAccessType.FIELD)
public class Item implements Serializable {

	private static final long serialVersionUID = -2629384241406382686L;
	@XmlElement(name = "itemName")
	private String itemName;
	@XmlElement(name = "itemID")
	private String itemID;
	@XmlElement(name = "unitPrice")
	private Double unitPrice;
	@XmlElement(name = "quantity")
	private Long quantity;
	@XmlElement(name = "itemCategoryID")
	private String itemCategoryID;
	
	@XmlTransient
	private Double grossTotal;

	public Item() {
		super();
	}

	public Item(String itemName, String itemID, Double unitPrice, Long quantity, String itemCategoryID) {
		super();
		this.itemName = itemName;
		this.itemID = itemID;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.itemCategoryID = itemCategoryID;
	}

	public Double getGrossTotal() {
		return (unitPrice * quantity);
	}

	public void setGrossTotal(Double grossTotal) {
		this.grossTotal = grossTotal;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemID() {
		return itemID;
	}

	public void setItemID(String itemID) {
		this.itemID = itemID;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public String getItemCategoryID() {
		return itemCategoryID;
	}

	public void setItemCategoryID(String itemCategoryID) {
		this.itemCategoryID = itemCategoryID;
	}

	@Override
	public String toString() {
		return "ClassPojo [itemName = " + itemName + ", itemID = " + itemID + ", unitPrice = " + unitPrice + ", quantity = " + quantity + ", itemCategoryID = " + itemCategoryID + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemCategoryID == null) ? 0 : itemCategoryID.hashCode());
		result = prime * result + ((itemID == null) ? 0 : itemID.hashCode());
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		result = prime * result + ((unitPrice == null) ? 0 : unitPrice.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (itemCategoryID == null) {
			if (other.itemCategoryID != null)
				return false;
		} else if (!itemCategoryID.equals(other.itemCategoryID))
			return false;
		if (itemID == null) {
			if (other.itemID != null)
				return false;
		} else if (!itemID.equals(other.itemID))
			return false;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		if (unitPrice == null) {
			if (other.unitPrice != null)
				return false;
		} else if (!unitPrice.equals(other.unitPrice))
			return false;
		return true;
	}

}