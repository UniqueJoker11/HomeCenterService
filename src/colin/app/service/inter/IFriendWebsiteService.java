package colin.app.service.inter;

import colin.app.core.pojo.FriendWebsiteEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by DELL on 2015/7/2.
 */
public interface IFriendWebsiteService {
    /**
     * 查询友情连接网站
     */
    public List<FriendWebsiteEntity> searchAllFriendWebsite();
    /**
     * 添加友情链接网站
     */
    public boolean addFriendWebsite(Map<String,Object> params);
    /**
     * 删除友情链接网站
     */
    public boolean delFriendWebsite(String websiteId);

    /**
     * 更新友情链接网站
     * @param params
     * @return
     */
    public boolean updateFriendWebsite(Map<String,Object> params);
}
