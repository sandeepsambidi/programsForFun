import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DownloadResponseOfObjectService {

    @SerializedName("Objects")
    @Expose
    private List<ObjectsInOSDownloadResponse> objects = null;
    @SerializedName("delta_context")
    @Expose
    private DeltaContext deltaContext;
    @SerializedName("opstatus")
    @Expose
    private Integer opstatus;
    @SerializedName("httpStatusCode")
    @Expose
    private Integer httpStatusCode;

    public List<ObjectsInOSDownloadResponse> getObjects() {
        return objects;
    }

    public void setObjects(List<ObjectsInOSDownloadResponse> objects) {
        this.objects = objects;
    }

    public DeltaContext getDeltaContext() {
        return deltaContext;
    }

    public void setDeltaContext(DeltaContext deltaContext) {
        this.deltaContext = deltaContext;
    }

    public Integer getOpstatus() {
        return opstatus;
    }

    public void setOpstatus(Integer opstatus) {
        this.opstatus = opstatus;
    }

    public Integer getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(Integer httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

}
