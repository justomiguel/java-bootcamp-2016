package bootcamp.finalproject.entities;

import java.io.Serializable;

public class ItemCartId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private long cartId;
	private long productId;
	
	@Override
	public int hashCode() {
		return (int)(cartId + productId);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ItemCartId) {
			ItemCartId otherId = (ItemCartId) obj;
			return (otherId.cartId == this.cartId) && (otherId.productId == this.productId);
		}    
		return false;
	}
}

