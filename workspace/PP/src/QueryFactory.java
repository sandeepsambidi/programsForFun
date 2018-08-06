
public class QueryFactory {

	private static class FactoryCreator {
		private static final QueryFactory INSTANCE  = new QueryFactory();
	}
	
	public static QueryFactory getQueryFactory() {
		return FactoryCreator.INSTANCE;
	}
	
	BaseQueryBuilder getQueryBuilder(String builderName) {
		if(builderName.equals("read")) {
			return new ReadQueryBuilder();
		} else {
			return null;
		}
	}
}
