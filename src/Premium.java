public class Premium implements IPackage {

	@Override
	public int getNbrLivreAutorise() {
		return 20;
	}

	@Override
	public int getBonus() {
		return 10;
	}
}