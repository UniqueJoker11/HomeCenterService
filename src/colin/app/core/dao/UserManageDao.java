package colin.app.core.dao;

import colin.app.common.bean.Page;
import colin.app.core.dao.common.CommonDao;
import colin.app.core.pojo.UserEntity;
import colin.app.core.pojo.UserEntity;
import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by joker on 14-9-13.
 */
@Repository
public class UserManageDao extends CommonDao<UserEntity> {
    /**
     * 分页数据查找
     *
     * @param paramsMap
     */
    @Override
    public Page<UserEntity> searchObjPageInfo(Map<String, Object> paramsMap) {
        //初始化设置当前的分页大小
        int pageSize = 10;
        //设定当前的其实页数
        int currentPage = 1;
        if (paramsMap.get("pageSize") != null && !paramsMap.get("pageSize").toString().equals("")) {
            pageSize = Integer.valueOf(paramsMap.get("pageSize").toString());
        }
        if (paramsMap.get("currentPage") != null && !paramsMap.get("currentPage").toString().equals("")) {
            currentPage = Integer.valueOf(paramsMap.get("currentPage").toString());
        }
        //获取到当前页的所有内容
        List<UserEntity> currentList=this.getOrderObjects(UserEntity.class,paramsMap,null,currentPage,pageSize);

        Criteria criteria = this.getCurrentSession().createCriteria(UserEntity.class);
        //获取到当前的所有对象数量
        List<UserEntity> aticleList = super.getHibernateTemplate().loadAll(UserEntity.class);
        //初始化当前的分页对象
        Page<UserEntity> pageResult = new Page<UserEntity>();
        //查询出所有的记录和计算出所有的分页数
        pageResult.setTotalRecord(aticleList.size());
        int allPageSize = 0;
        if (aticleList.size() % pageSize != 0) {
            allPageSize = aticleList.size() / pageSize + 1;
        } else {
            allPageSize = aticleList.size() / pageSize;
        }
        pageResult.setPageSize(pageSize);
        pageResult.setTotalPage(allPageSize);
        //此处查询可以查询处当前页的数据，还需要所有的数据行和总记录数
        pageResult.setCurrentPage(currentPage);
        pageResult.setResultList(currentList);
        return pageResult;
    }
}
