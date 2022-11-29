public class Standard implements IPackage {

	@Override
	public int getNbrLivreAutorise() {
		return 10;
	}

	@Override
	public int getBonus() {
		return 5;
	}
}