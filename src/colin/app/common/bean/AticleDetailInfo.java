package colin.app.common.bean;

/**
 * Created by ASUS on 2015/4/7.
 */
public class AticleDetailInfo {
    private int aticleId;
    private int preAticleId;
    private int nextAticleId;
    private String aticleTitle;
    private String aticleAuthor;
    private String aticleCreateDate;
    private String aticleContent;
    private String aticleCategory;
    private String keyWords;
    private String prevTitle;
    private String nextTitle;

    public String getAticleTitle() {
        return aticleTitle;
    }

    public void setAticleTitle(String aticleTitle) {
        this.aticleTitle = aticleTitle;
    }

    public String getAticleAuthor() {
        return aticleAuthor;
    }

    public void setAticleAuthor(String aticleAuthor) {
        this.aticleAuthor = aticleAuthor;
    }

    public String getAticleCreateDate() {
        return aticleCreateDate;
    }

    public void setAticleCreateDate(String aticleCreateDate) {
        this.aticleCreateDate = aticleCreateDate;
    }

    public String getAticleContent() {
        return aticleContent;
    }

    public void setAticleContent(String aticleContent) {
        this.aticleContent = aticleContent;
    }

    public String getAticleCategory() {
        return aticleCategory;
    }

    public void setAticleCategory(String aticleCategory) {
        this.aticleCategory = aticleCategory;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    public String getPrevTitle() {
        return prevTitle;
    }

    public void setPrevTitle(String prevTitle) {
        this.prevTitle = prevTitle;
    }

    public String getNextTitle() {
        return nextTitle;
    }

    public void setNextTitle(String nextTitle) {
        this.nextTitle = nextTitle;
    }

    public int getAticleId() {
        return aticleId;
    }

    public void setAticleId(int aticleId) {
        this.aticleId = aticleId;
    }

    public int getPreAticleId() {
        return preAticleId;
    }

    public void setPreAticleId(int preAticleId) {
        this.preAticleId = preAticleId;
    }

    public int getNextAticleId() {
        return nextAticleId;
    }

    public void setNextAticleId(int nextAticleId) {
        this.nextAticleId = nextAticleId;
    }
}
