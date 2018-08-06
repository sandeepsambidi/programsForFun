
public class ReadQueryBuilder extends BaseQueryBuilder{

	@Override
	void addWhere() {
		System.out.println("addWhere of : ReadQueryBuilder");
	}
	
	@Override
	void addOrderBy(){
		System.out.println("In order by: ReadQueryBuilder");
	}
	
	void addLike(){
		System.out.println("like in: ReadQueryBuilder");
	}

}
