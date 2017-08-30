package org.ecom.cart.bean.vo;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "FlatDiscountSlabs", namespace = "")
@XmlAccessorType(XmlAccessType.FIELD)
public class FlatDiscountSlabs implements Serializable {
	private static final long serialVersionUID = -2626384231406382686L;
	@XmlElement(name = "Slab")
	private List<Slab> Slab;

	public List<Slab> getSlab() {
		return Slab;
	}

	public void setSlab(List<Slab> slab) {
		Slab = slab;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
