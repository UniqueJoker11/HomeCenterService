package colin.template.vo;

import java.util.List;

/**
 * Created by ASUS on 2015/2/16.
 */
public class PojoVo {
    private String tableName;
    private String className;
    private List<PojoFieldVo> fieldVoList;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<PojoFieldVo> getFieldVoList() {
        return fieldVoList;
    }

    public void setFieldVoList(List<PojoFieldVo> fieldVoList) {
        this.fieldVoList = fieldVoList;
    }
}
