package colin.app.core.pojo;

import javax.persistence.*;

/**
 * Created by joker on 14-9-26.
 */
@Entity
@Table(name = "aticle")
public class AticleEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "aticleId")
    private int aticleId;
    private String aticleName;
    private String aticleDigest;
    private String aticleContent;
    private String aticleReadNum;
    private String aticleCrTime;
    private String aticleCrUser;

    public String getAticleCrTime() {
        return aticleCrTime;
    }

    public void setAticleCrTime(String aticleCrTime) {
        this.aticleCrTime = aticleCrTime;
    }

    public String getAticleDigest() {
        return aticleDigest;
    }

    public void setAticleDigest(String aticleDigest) {
        this.aticleDigest = aticleDigest;
    }

    public int getAticleId() {
        return aticleId;
    }

    public void setAticleId(int aticleId) {
        this.aticleId = aticleId;
    }

    public String getAticleName() {
        return aticleName;
    }

    public void setAticleName(String aticleName) {
        this.aticleName = aticleName;
    }

    public String getAticleContent() {
        return aticleContent;
    }

    public void setAticleContent(String aticleContent) {
        this.aticleContent = aticleContent;
    }

    public String getAticleReadNum() {
        return aticleReadNum;
    }

    public void setAticleReadNum(String aticleReadNum) {
        this.aticleReadNum = aticleReadNum;
    }

    public String getAticleCrUser() {
        return aticleCrUser;
    }

    public void setAticleCrUser(String aticleCrUser) {
        this.aticleCrUser = aticleCrUser;
    }
}
