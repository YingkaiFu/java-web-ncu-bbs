package com.ncu.strong.bbs.controller;

import com.ncu.strong.bbs.po.Setion;
import com.ncu.strong.bbs.service.SetionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(value={"/setion"})
public class SetionController {

    @Autowired
    private SetionService setionService;

    @Autowired
    private HttpSession session;

    /**
     * 获取所有分区
     * @return
     */
    @GetMapping(value={"/getAllSetions"})
    public List getAllSetions(){
        return setionService.findAllSetions();
    }

    /**
     * 通过id获取分区
     * @param id
     * @return
     */
    @PostMapping(value={"/getSetionById"})
    public Setion getSetionById(@RequestBody Integer id){
        return setionService.getSetionById(id);
    }

    /**
     * 新增分区
     * @param setion
     * @return
     */
    @PostMapping(value={"/addSetion"})
    public String addSetion(@RequestBody Setion setion){

        if(session.getAttribute("admin") != null) {
            if (setionService.getSetionByName(setion.getName()) != null) {
                return "该分区已存在，请重新输入";
            }
            if (setionService.addSetion(setion) == 1) {
                return "添加成功";
            }
            return "添加失败";
        }
        return "没有权限";
    }

    /**
     * 删除分区
     * @param id
     * @return
     */
    @PostMapping(value={"/deleteSetion"})
    public String deleteSetion(@RequestBody Integer id){
        if(session.getAttribute("admin") != null) {
            if (setionService.deleteSetion(id) == 1) {
                return "成功删除";
            }
            return "删除失败";
        }
        return "没有权限";
    }

    /**
     * 更新分区
     * @param setion
     * @return
     */
    @PostMapping(value={"/updateSetion"})
    public String updateSetion(@RequestBody Setion setion){
        if(session.getAttribute("admin") != null) {
            if (setionService.updateSetion(setion) == 1) {
                return "修改成功";
            }
            return "修改失败";
        }
        return "没有权限";

    }

    /**
     * 通过分区名获取分区信息
     * @param name
     * @return
     */
    @PostMapping(value={"/getSetionByName"})
    public Setion getSetionByName(@RequestBody String name){

        return setionService.getSetionByName(name);
    }


}
