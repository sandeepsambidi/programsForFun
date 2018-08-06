
public abstract class BaseQueryBuilder {
	public BaseQueryBuilder() {
		// TODO Auto-generated constructor stub
	}
	
	abstract void addWhere();
	
	void addOrderBy(){
		System.out.println("In order by: BaseQueryBuilder");
	}
}
