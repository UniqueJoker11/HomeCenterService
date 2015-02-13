package colin.app.core.pojo;

import javax.persistence.*;

/**
 * Created by joker on 15-2-3.
 */
@Entity
@Table(name="logger")
public class LoggerEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "loggerid")
    private int loggerid;
    private String loggerContent;
    private String createTime;
    private String accessClass;
    private String accessUser;
    private String tag;

    public int getLoggerid() {
        return loggerid;
    }

    public void setLoggerid(int loggerid) {
        this.loggerid = loggerid;
    }

    public String getLoggerContent() {
        return loggerContent;
    }

    public void setLoggerContent(String loggerContent) {
        this.loggerContent = loggerContent;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getAccessClass() {
        return accessClass;
    }

    public void setAccessClass(String accessClass) {
        this.accessClass = accessClass;
    }

    public String getAccessUser() {
        return accessUser;
    }

    public void setAccessUser(String accessUser) {
        this.accessUser = accessUser;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
