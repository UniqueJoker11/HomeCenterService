package colin.app.service.inter;

import colin.app.common.bean.Page;
import colin.app.core.pojo.MasterEntity;

import java.util.Map;

/**
 * Created by ASUS on 2015/4/21.
 * 博主信息管理接口
 */
public interface IMasterManageService {
    /**
     * 添加新的博主信息
     * @param params
     * @return
     */
    public boolean addMasterInfo(Map<String,Object> params);

    /**
     * 更新博主信息
     * @param parmas
     * @return
     */
    public boolean updateMasterInfo(Map<String,Object> parmas);

    /**
     * 删除博主信息
     * @param params
     * @return
     */
    public boolean deleateMasterInfo(Map<String,Object> params);

    /**
     * 查找博主信息
     * @param searchParams
     * @return
     */
    public Map<String,Object> searchMasterInfo(Map<String,Object> searchParams);
}
