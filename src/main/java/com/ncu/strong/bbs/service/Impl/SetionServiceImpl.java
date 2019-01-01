package com.ncu.strong.bbs.service.Impl;

import com.ncu.strong.bbs.dao.SetionMapper;
import com.ncu.strong.bbs.po.Setion;
import com.ncu.strong.bbs.service.SetionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class SetionServiceImpl implements SetionService {

    @Autowired
    private SetionMapper setionDao;

    /**
     * 获取所有分区
     * @return
     */
    @Override
    public List findAllSetions() {
        return setionDao.selectAllSetion();
    }

    /**
     * 通过id获取分区
     * @param Id
     * @return
     */
    @Override
    public Setion getSetionById(Integer Id) {
       return setionDao.selectBySetionId(Id);
    }

    /**
     * 新增分区
     * @param setion
     * @return
     */
    @Override
    public int addSetion(Setion setion){
        if(setionDao.insert(setion) == 1){
            return 1;
        }
        return 0;
    }

    /**
     * 删除分区
     * @param id
     * @return
     */
    @Override
    public int deleteSetion(Integer id){
        if(setionDao.deleteByPrimaryKey(id) == 1){
            return 1;
        }
        return 0;
    }

    /**
     * 更新分区
     * @param setion
     * @return
     */
    @Override
    public int updateSetion(Setion setion){
        if(setionDao.updateByPrimaryKeySelective(setion) == 1){
            return 1;
        }
        return 0;
    }

    /**
     * 根据分区名获取分区
     * @param name
     * @return
     */
    @Override
    public Setion  getSetionByName(String name){
        return setionDao.selectByName(name);
    }
}
