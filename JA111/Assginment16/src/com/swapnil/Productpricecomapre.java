package com.swapnil;
import java.util.Comparator;
public class Productpricecomapre implements Comparator<Product> {

	@Override
	public int compare(Product o1,Product o2) {
		// TODO Auto-generated method stub
		if(o1.getProductPrice()>o2.getProductPrice()) {
			return +1;
		}else if(o1.getProductPrice()<o2.getProductPrice()) {
			return -1;
		}else {
		return 0;
		}
	}
}
