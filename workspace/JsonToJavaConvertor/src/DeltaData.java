
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class DeltaData {
	@SerializedName("delta")
	@Expose
	private String delta;
	@SerializedName("field1")
	@Expose
	private String field1;
	@SerializedName("filed2")
	@Expose
	private String filed2;

	public String getDelta() {
	return delta;
	}

	public void setDelta(String delta) {
	this.delta = delta;
	}

	public String getField1() {
	return field1;
	}

	public void setField1(String field1) {
	this.field1 = field1;
	}

	public String getFiled2() {
	return filed2;
	}

	public void setFiled2(String filed2) {
	this.filed2 = filed2;
	}

}
