package com.ncu.strong.bbs.service;

import com.ncu.strong.bbs.po.Setion;

import java.util.List;

public interface SetionService {

    /**
     * 获取所有分区
     * @return
     */
    List findAllSetions();

    /**
     * 通过id获取分区
     * @param Id
     * @return
     */
    Setion getSetionById(Integer Id);

    /**
     * 添加分区
     * @param setion
     * @return
     */
    int addSetion(Setion setion);

    /**
     * 删除分区
     * @param id
     * @return
     */
    int deleteSetion(Integer id);

    /**
     * 更新分区
     * @param setion
     * @return
     */
    int updateSetion(Setion setion);

    /**
     * 通过分区名获取分区
     * @param name
     * @return
     */
    Setion getSetionByName(String name);
}
