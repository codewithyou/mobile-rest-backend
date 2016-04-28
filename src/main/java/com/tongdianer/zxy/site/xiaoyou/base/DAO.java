package com.tongdianer.zxy.site.xiaoyou.base;

import java.util.List;

/**
 * Created by andy on 16-4-28.
 */
public interface DAO {


    /**
     * 保存对象
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    public Object insert(String str, Object obj) throws Exception;

    /**
     * 修改对象
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    public Object update(String str, Object obj) throws Exception;

    /**
     * 删除对象
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    public Object delete(String str, Object obj) throws Exception;

    /**
     * 查找对象
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    public <T> T getOne(String str, Object obj) throws Exception;

    public <T> List<T> getList(String key, Object parameter);


}
