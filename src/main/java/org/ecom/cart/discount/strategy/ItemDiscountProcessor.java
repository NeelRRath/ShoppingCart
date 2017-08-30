package org.ecom.cart.discount.strategy;

import java.util.Map;

import org.ecom.cart.bean.vo.Category;
import org.ecom.cart.bean.vo.Item;
import org.ecom.cart.bean.vo.ReceiptItem;
import org.ecom.cart.exception.DiscountProcessException;
import org.ecom.cart.exception.FileProcessingException;
import org.ecom.cart.manager.file.FileManager;
import org.ecom.cart.util.CartConstants;

public class ItemDiscountProcessor implements  DiscountProcessor<Item, ReceiptItem> {
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
	public ReceiptItem process(Item item) throws DiscountProcessException {
		if(!isEnabled()){
			return null;
		}
		try {
			//ReceiptItem item = new ReceiptItem(item, discount)
			Map<String,Category > catMap = getFileManager().readCategoryFromFile(CartConstants.CATEGORY_FILE_PATH);
			Category category = catMap.get(item.getItemCategoryID());
			Double discountAmount = 0d;
			Double discountPercentage = 0d;
			if(null != category){
				discountPercentage = category.getDiscPerc();
				discountAmount = item.getGrossTotal() * discountPercentage/100d;
			}
			return new ReceiptItem(item,discountAmount,discountPercentage);
		} catch (FileProcessingException e) {
			throw new DiscountProcessException(e.getMessage());
		}
	}

}
