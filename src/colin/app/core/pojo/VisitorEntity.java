package colin.app.core.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by DELL on 2015/7/1.
 */
@Entity
@Table(name="visitor")
public class VisitorEntity {
    /**
     * 用户Id
     */
    @Id
    private String visitorId;
    /**
     * 用户注册姓名
     */
    private String visitorName;
    /**
     * 用户访问密码
     * */
    private String visitorPsw;
    /**
     * 用户称呼
     */
    private String visitorCallname;
    /**
     * 用户等级
     */
    private String visitorLevel;
    /**
     * 用户积分
     */
    private int visitorIntegral;
    /**
     * 是否在线
     */
    private int isOnline;
    /**
     * 注册时间
     */
    private String registerTime;
    /**
     * 上一次登录时间
     */
    private String lastLoginTime;

    public String getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(String visitorId) {
        this.visitorId = visitorId;
    }

    public String getVisitorName() {
        return visitorName;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    public String getVisitorPsw() {
        return visitorPsw;
    }

    public void setVisitorPsw(String visitorPsw) {
        this.visitorPsw = visitorPsw;
    }

    public String getVisitorCallname() {
        return visitorCallname;
    }

    public void setVisitorCallname(String visitorCallname) {
        this.visitorCallname = visitorCallname;
    }

    public String getVisitorLevel() {
        return visitorLevel;
    }

    public void setVisitorLevel(String visitorLevel) {
        this.visitorLevel = visitorLevel;
    }

    public int getVisitorIntegral() {
        return visitorIntegral;
    }

    public void setVisitorIntegral(int visitorIntegral) {
        this.visitorIntegral = visitorIntegral;
    }

    public int getIsOnline() {
        return isOnline;
    }

    public void setIsOnline(int isOnline) {
        this.isOnline = isOnline;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
}
