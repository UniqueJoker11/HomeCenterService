package colin.app.action;

import colin.app.service.inter.IFriendWebsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by DELL on 2015/7/2.
 */
@Component
public class FriendWebsiteManageAction {
    @Autowired
    private IFriendWebsiteService friendWebsiteService;
}
