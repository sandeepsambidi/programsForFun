
import java.util.Map;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DeltaContext {

    @SerializedName("objs")
    @Expose
    private Map<String, DeltaData> objs;

    public Map<String,DeltaData> getObjs() {
        return objs;
    }

    public void setObjs(Map<String,DeltaData> objs) {
        this.objs = objs;
    }
    
    @Override
    public String toString() {
    	return objs.toString();
    	//return super.toString();
    }
}
