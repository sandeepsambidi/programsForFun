
/**
 * Created by kh1964 on 6/21/17.
 */

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class DownloadResponseOfObject {

    @SerializedName("records")
    @Expose
    private List<Object> records = null;
    @SerializedName("_metadata")
    @Expose
    private Metadata metadata;
    @SerializedName("delta_context")
    @Expose
    private DeltaContext deltaContext;
    @SerializedName("opstatus")
    @Expose
    private Integer opstatus;
    @SerializedName("httpStatusCode")
    @Expose
    private Integer httpStatusCode;

    public List<Object> getRecords() {
        return records;
    }

    public void setRecords(List<Object> records) {
        this.records = records;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
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
