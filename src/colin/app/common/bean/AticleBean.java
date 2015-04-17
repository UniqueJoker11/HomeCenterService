package colin.app.common.bean;

/**
 * Created by ASUS on 2015/3/26.
 * 后台显示文章的一览列表
 */
public class AticleBean {
    private int aticleId;
    private String aticleTitle;
    private String aticleAuthor;
    private int aticleCommentNum;
    private int aticleBrowserNum;
    private String aticleCreateDate;
    private String aticleDigest;
    private String aticleCategory;
    private String aticleCoverImg;

    public int getAticleId() {
        return aticleId;
    }

    public void setAticleId(int aticleId) {
        this.aticleId = aticleId;
    }

    public String getAticleTitle() {
        return aticleTitle;
    }

    public void setAticleTitle(String aticleTitle) {
        this.aticleTitle = aticleTitle;
    }

    public int getAticleCommentNum() {
        return aticleCommentNum;
    }

    public void setAticleCommentNum(int aticleCommentNum) {
        this.aticleCommentNum = aticleCommentNum;
    }

    public int getAticleBrowserNum() {
        return aticleBrowserNum;
    }

    public void setAticleBrowserNum(int aticleBrowserNum) {
        this.aticleBrowserNum = aticleBrowserNum;
    }

    public String getAticleCreateDate() {
        return aticleCreateDate;
    }

    public void setAticleCreateDate(String aticleCreateDate) {
        this.aticleCreateDate = aticleCreateDate;
    }

    public String getAticleAuthor() {
        return aticleAuthor;
    }

    public void setAticleAuthor(String aticleAuthor) {
        this.aticleAuthor = aticleAuthor;
    }

    public String getAticleDigest() {
        return aticleDigest;
    }

    public void setAticleDigest(String aticleDigest) {
        this.aticleDigest = aticleDigest;
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
}
