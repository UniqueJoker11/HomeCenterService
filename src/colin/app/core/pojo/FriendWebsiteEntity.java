package colin.app.core.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by DELL on 2015/7/2.
 */
@Entity
@Table(name="friendwebsite")
public class FriendWebsiteEntity {
    @Id
    private String friendWebsiteId;
    private String friendWebsiteUrl;
    private String friendWebsiteName;

    public String getFriendWebsiteId() {
        return friendWebsiteId;
    }

    public void setFriendWebsiteId(String friendWebsiteId) {
        this.friendWebsiteId = friendWebsiteId;
    }

    public String getFriendWebsiteUrl() {
        return friendWebsiteUrl;
    }

    public void setFriendWebsiteUrl(String friendWebsiteUrl) {
        this.friendWebsiteUrl = friendWebsiteUrl;
    }

    public String getFriendWebsiteName() {
        return friendWebsiteName;
    }

    public void setFriendWebsiteName(String friendWebsiteName) {
        this.friendWebsiteName = friendWebsiteName;
    }
}
