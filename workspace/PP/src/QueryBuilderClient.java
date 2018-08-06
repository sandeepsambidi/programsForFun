
public class QueryBuilderClient {
	public static void main(String[] args) {
		BaseQueryBuilder baseQueryBuilder = QueryFactory.getQueryFactory().getQueryBuilder("read");
		baseQueryBuilder.addOrderBy();
		baseQueryBuilder.addWhere();
	}
}
