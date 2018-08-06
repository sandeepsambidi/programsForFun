
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ObjectsInOSDownloadResponse {
    @SerializedName("records")
    @Expose
    private List<Object> records = null;
    @SerializedName("_metadata")
    @Expose
    private Metadata metadata;
    @SerializedName("opstatus")
    @Expose
    private Integer opstatus;
    @SerializedName("httpStatusCode")
    @Expose
    private Integer httpStatusCode;
    @SerializedName("name")
    @Expose
    private String name;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

