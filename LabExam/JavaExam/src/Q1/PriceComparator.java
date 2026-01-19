package Q1;

import java.util.*;

public class PriceComparator implements Comparator<Merchandise>{

	@Override
	public int compare(Merchandise item1, Merchandise item2) {
		
		return (int)item2.getPrice()-(int)item1.getPrice();
	}

}
