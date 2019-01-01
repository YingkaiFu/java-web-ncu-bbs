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
    private SetionMapper setionMapper;

    /**
     * 获取所有分区
     * @return
     */
    @Override
    public List findAllSetions() {
        return setionMapper.selectAllSetions();
    }

    /**
     * 通过id获取分区
     * @param Id
     * @return
     */
    @Override
    public Setion getSetionById(Integer Id) {
       return setionMapper.selectBySetionId(Id);
    }

    /**
     * 新增分区
     * @param setion
     * @return
     */
    @Override
    public int addSetion(Setion setion){
        if(setionMapper.insert(setion) == 1){
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
        if(setionMapper.deleteByPrimaryKey(id) == 1){
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
        if(setionMapper.updateByPrimaryKeySelective(setion) == 1){
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
        return setionMapper.selectByName(name);
    }
}
