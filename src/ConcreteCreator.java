public class ConcreteCreator extends AbstractFactory {
	public IPackage getPackage(TypePackage typePackage) {

		if(typePackage.equals(TypePackage.Standard)) {
			return new Standard();
		}
		else if(typePackage.equals(TypePackage.Premium)) {
			return new Premium();
		}
		return null;
	}

}