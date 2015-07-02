package colin.app.service.impl;

import colin.app.core.pojo.FriendWebsiteEntity;
import colin.app.service.inter.IFriendWebsiteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by DELL on 2015/7/2.
 */
@Service
public class FriendWebsiteSerivce implements IFriendWebsiteService{
    /**
     * 查询友情连接网站
     */
    @Override
    public List<FriendWebsiteEntity> searchAllFriendWebsite() {
        return null;
    }

    /**
     * 添加友情链接网站
     *
     * @param params
     */
    @Override
    public boolean addFriendWebsite(Map<String, Object> params) {
        return false;
    }

    /**
     * 删除友情链接网站
     *
     * @param websiteId
     */
    @Override
    public boolean delFriendWebsite(String websiteId) {
        return false;
    }

    /**
     * 更新友情链接网站
     *
     * @param params
     * @return
     */
    @Override
    public boolean updateFriendWebsite(Map<String, Object> params) {
        return false;
    }
}
