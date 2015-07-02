package colin.app.core.pojo;

import javax.persistence.*;
import java.util.UUID;

/**
 * Created by joker on 14-9-26.
 */
@Entity
@Table(name = "aticle")
public class AticleEntity {
    @Id
    private String aticleId;
    private String aticleName;
    private String aticleDigest;
    private String aticleContent;
    private String aticleReadNum;
    private String aticleCrTime;
    private String aticleCrUser;
    private String aticleCategory;
    private String aticleCoverImg;
    private String keyWords;

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

    public String getAticleId() {
        return aticleId;
    }

    public void setAticleId(String aticleId) {
        if (aticleId == null) {
            this.aticleId = UUID.randomUUID().toString();
        } else {
            this.aticleId = aticleId;
        }
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

    public String getAticleCategory() {
        return aticleCategory;
    }

    public void setAticleCategory(String aticleCategory) {
        this.aticleCategory = aticleCategory;
    }

    public String getAticleCoverImg() {
        return aticleCoverImg;
    }

    public void setAticleCoverImg(String aticleCoverImg) {
        this.aticleCoverImg = aticleCoverImg;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }
}
