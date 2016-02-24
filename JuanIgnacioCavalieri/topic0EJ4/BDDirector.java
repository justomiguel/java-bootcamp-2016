package topic0EJ4;

public class BDDirector {
	private BDBuilder dbBuilder = null;
	
	public BDDirector(BDBuilder bdBuilder) {
		this.dbBuilder = bdBuilder;
	}

	public void constructBD() {
		dbBuilder.BuildURL();
		dbBuilder.BuildUser();
		dbBuilder.BuildPass();
	}

	public DB getDB () {
		return dbBuilder.GetDB();
	}
}
