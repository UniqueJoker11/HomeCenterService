package colin.app.service.inter;

import colin.app.core.pojo.WhisperEntity;

import java.util.List;
import java.util.Map;

/**
 * 悄悄话管理
 * Created by ASUS on 2015/4/23.
 */
public interface IWhisperManageService {
    /**
     * 添加悄悄话
     * @param params
     * @return
     */
    public boolean addWhisperInfo(Map<String,Object> params);

    /**
     * 删除悄悄话
     * @param params
     * @return
     */
    public boolean delWhisperInfo(Map<String,Object> params);

    /**
     * 更新悄悄话
     * @param params
     * @return
     */
    public boolean updateWhisperInfo(Map<String,Object> params);

    /**
     * @return
     */
    public List<WhisperEntity> getAllWhisperInfo();
}
