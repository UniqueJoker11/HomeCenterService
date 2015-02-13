package colin.app.common;

import java.util.List;

/**
 * Created by joker on 14-9-13.
 */
public class ReturnContext {
    private boolean isSuccess;
    private String retsultMsg;
    private String fieldName;
    private List retsultData;

    public ReturnContext() {
    }

    public static ReturnContext createReturnContext() {
        return new ReturnContext();
    }

    public boolean isSuccess() {
        return getIsSuccess();
    }

    public void setSuccess(boolean isSuccess) {
        this.setIsSuccess(isSuccess);
    }

    public String getRetsultMsg() {
        return retsultMsg;
    }

    public void setRetsultMsg(String retsultMsg) {
        this.retsultMsg = retsultMsg;
    }

    public List getRetsultData() {
        return retsultData;
    }

    public void setRetsultData(List retsultData) {
        this.retsultData = retsultData;
    }

    public boolean getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }
}
