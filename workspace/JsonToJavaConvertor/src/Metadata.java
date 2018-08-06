
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Metadata {

    @SerializedName("recordCount")
    @Expose
    private Integer recordCount;
    @SerializedName("updatedRecords")
    @Expose
    private Integer updatedRecords;
    @SerializedName("deletedRecords")
    @Expose
    private Integer deletedRecords;

    public Integer getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(Integer recordCount) {
        this.recordCount = recordCount;
    }

    public Integer getUpdatedRecords() {
        return updatedRecords;
    }

    public void setUpdatedRecords(Integer updatedRecords) {
        this.updatedRecords = updatedRecords;
    }

    public Integer getDeletedRecords() {
        return deletedRecords;
    }

    public void setDeletedRecords(Integer deletedRecords) {
        this.deletedRecords = deletedRecords;
    }

}
