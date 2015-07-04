package colin.app.core.dao;

import colin.app.common.bean.Page;
import colin.app.core.dao.common.CommonDao;
import colin.app.core.pojo.AticleEntity;
import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by joker on 14-9-26.
 */
@Repository
public class AticleManageDao extends CommonDao<AticleEntity> {
    /**
     * 返回文章的分页查询数据
     *
     * @param paramsMap
     */
    @Override
    public Page<AticleEntity> searchObjPageInfo(Map<String, Object> paramsMap) {
        return this.searchSynthesizeAticleInfo(paramsMap);
    }

    /**
     * 分页获取文章信息以及相应的评论信息
     *
     * @param params
     * @return
     */
    private Page<AticleEntity> searchSynthesizeAticleInfo(Map<String, Object> params) {
        //初始化设置当前的分页大小
        int pageSize = 3;
        //设定当前的其实页数
        int currentPage = 1;
        if (params != null) {
            if (params.get("pageSize") != null && !params.get("pageSize").toString().equals("")) {
                pageSize = Integer.valueOf(params.get("pageSize").toString());
            }
            if (params.get("currentPage") != null && !params.get("currentPage").toString().equals("")) {
                currentPage = Integer.valueOf(params.get("currentPage").toString());
            }
        }
        //获取到所有的文章实体对象，统计文章数量
        //获取到当前的所有对象数量
        List<AticleEntity> allAticleList = super.getHibernateTemplate().loadAll(AticleEntity.class);
        //文章的总数量
        int totalSize=allAticleList.size();
        //疯转当前页的文章实体数量
        List<AticleEntity> currentPageAticleList=new LinkedList<>();
        if(currentPage*pageSize<totalSize){
            for(int i=(currentPage-1)*pageSize;i<currentPage*pageSize;i++){
                currentPageAticleList.add(allAticleList.get(i));
            }
        }else{
            for(int i=(currentPage-1)*pageSize;i<totalSize;i++){
                currentPageAticleList.add(allAticleList.get(i));
            }
        }
        //初始化当前的分页对象
        Page<AticleEntity> pageResult = new Page<AticleEntity>();
        //总页数
        int allPageSize = 0;
        if (totalSize % pageSize != 0) {
            allPageSize = totalSize / pageSize + 1;
        } else {
            allPageSize = totalSize / pageSize;
        }
        //查询出所有的记录和计算出所有的分页数
        pageResult.setTotalRecord(totalSize);
        //设置分页数量
        pageResult.setPageSize(pageSize);
        //设置总页数
        pageResult.setTotalPage(allPageSize);
        //此处查询可以查询处当前页的数据，还需要所有的数据行和总记录数
        pageResult.setCurrentPage(currentPage);
        //返回当前页的文章数据
        pageResult.setResultList(currentPageAticleList);
        return pageResult;
    }
}
