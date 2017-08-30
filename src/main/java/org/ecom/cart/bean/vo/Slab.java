package org.ecom.cart.bean.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The slab bean: it represents total Discount slab for a item list.
 * 
 * It implements {@link Serializable} in order to make easier the transformation
 * into a JSON, XML or other serializable data type.
 * 
 * @author neel
 * 
 */
@XmlRootElement(name = "Slab", namespace = "")
@XmlAccessorType(XmlAccessType.FIELD)
public class Slab implements Serializable {

	private static final long serialVersionUID = -2629384241406382686L;
	@XmlElement(name = "discPerc")
	private Double discPerc;
	@XmlElement(name = "RangeMin")
	private Double RangeMin;
	@XmlElement(name = "RangeMax")
	private Double RangeMax;

	public Slab(Double discPerc, Double rangeMin, Double rangeMax) {
		super();
		this.discPerc = discPerc;
		RangeMin = rangeMin;
		RangeMax = rangeMax;
	}

	public Slab() {
		super();
	}

	public Double getDiscPerc() {
		return discPerc;
	}

	public void setDiscPerc(Double discPerc) {
		this.discPerc = discPerc;
	}

	public Double getRangeMin() {
		return RangeMin;
	}

	public void setRangeMin(Double RangeMin) {
		this.RangeMin = RangeMin;
	}

	public Double getRangeMax() {
		return RangeMax;
	}

	public void setRangeMax(Double RangeMax) {
		this.RangeMax = RangeMax;
	}

	@Override
	public String toString() {
		return "ClassPojo [discPerc = " + discPerc + ", RangeMin = " + RangeMin + ", RangeMax = " + RangeMax + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((RangeMax == null) ? 0 : RangeMax.hashCode());
		result = prime * result + ((RangeMin == null) ? 0 : RangeMin.hashCode());
		result = prime * result + ((discPerc == null) ? 0 : discPerc.hashCode());
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
		Slab other = (Slab) obj;
		if (RangeMax == null) {
			if (other.RangeMax != null)
				return false;
		} else if (!RangeMax.equals(other.RangeMax))
			return false;
		if (RangeMin == null) {
			if (other.RangeMin != null)
				return false;
		} else if (!RangeMin.equals(other.RangeMin))
			return false;
		if (discPerc == null) {
			if (other.discPerc != null)
				return false;
		} else if (!discPerc.equals(other.discPerc))
			return false;
		return true;
	}

}
