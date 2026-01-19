package Q1;

import java.util.Comparator;

public class ItemIdComparator implements Comparator<Merchandise>{

	@Override
	public int compare(Merchandise item1, Merchandise item2) {
		// TODO Auto-generated method stub
		return item1.getItemId().compareTo(item2.getItemId());
	}

}
