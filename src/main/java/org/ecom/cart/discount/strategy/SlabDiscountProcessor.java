package org.ecom.cart.discount.strategy;

import java.util.List;

import org.ecom.cart.bean.vo.Receipt;
import org.ecom.cart.bean.vo.Slab;
import org.ecom.cart.exception.DiscountProcessException;
import org.ecom.cart.manager.file.FileManager;
import org.ecom.cart.util.CartConstants;

public class SlabDiscountProcessor implements DiscountProcessor<Receipt, Receipt> {
	private Boolean enabled;
	private FileManager fileManager;

	public FileManager getFileManager() {
		return fileManager;
	}

	public void setFileManager(FileManager fileManager) {
		this.fileManager = fileManager;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public boolean isEnabled() throws DiscountProcessException {
		return this.enabled;
	}

	@Override
	public Receipt process(Receipt recipt) throws DiscountProcessException {
		try {
			List<Slab> slabs = getFileManager().readSalbFromFile(CartConstants.SLAB_FILE_PATH);
			Double discountAmount = 0d;
			Double discountPercentage = 0d;
			for(Slab slab : slabs){
				if(recipt.getGrossTotal() >= slab.getRangeMin() && recipt.getGrossTotal() <= slab.getRangeMax()){
					discountPercentage = slab.getDiscPerc();
					discountAmount = slab.getDiscPerc()* recipt.getGrossTotal()/100d;
				}
			}
			recipt.setDiscount(discountAmount);
			recipt.setDiscountPercentage(discountPercentage);
		} catch (Exception e) {
			throw new DiscountProcessException(e.getMessage());
		}
		return recipt;
	}

}
