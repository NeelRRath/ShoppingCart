package org.ecom.cart.bean.vo;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Categories", namespace = "")
@XmlAccessorType(XmlAccessType.FIELD)
public class Categories implements Serializable {
	private static final long serialVersionUID = -2629384231406382686L;
	@XmlElement(name = "Category")
	private List<Category> Category;
	public List<Category> getCategory() {
		return Category;
	}
	public void setCategory(List<Category> category) {
		this.Category = category;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Category == null) ? 0 : Category.hashCode());
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
		Categories other = (Categories) obj;
		if (Category == null) {
			if (other.Category != null)
				return false;
		} else if (!Category.equals(other.Category))
			return false;
		return true;
	}
	
}
