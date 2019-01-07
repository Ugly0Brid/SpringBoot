package com.example.demo.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.service.UserService;
import com.example.demo.domain.User;

import org.slf4j.Logger;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    private Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "getUser/", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult GetUser(int id) {
        logger.info("查询用户");
        try {
            return JsonResult.successResult(2000, "成功", 0, userService.Sel(id));
        } catch (Exception e) {
            return JsonResult.errorResult(5000, "获取数据失败", null);
        }
    }

    @RequestMapping(value = "getUserAll/", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult GetUserAll(int pageNum, int pageSize) {
        try {
            List<User> userList = userService.SelAll(pageNum, pageSize);
            return JsonResult.successResult(2000, "成功", userService.GetTotal(), userList);
        } catch (Exception e) {
            return JsonResult.errorResult(5000, "获取数据失败", null);
        }
    }

    @RequestMapping(value = "addUser/", method = RequestMethod.GET)
    public JsonResult AddUser(User user) {
        try {
            boolean result = userService.AddUser(user);
            if (result) {
                return JsonResult.successResult(2000, "增加成功", 0, null);
            } else {
                return JsonResult.successResult(2000, "增加失败", 0, null);
            }

        } catch (Exception e) {
            return JsonResult.errorResult(5000, "增加数据失败", null);
        }
    }

    @RequestMapping(value = "deleteUser/", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult DeleteUser(int id) {
        try {
            boolean result = userService.DelUserById(id);
            if (result) {
                return JsonResult.successResult(2000, "删除数据成功", 0, "成功");
            } else {
                return JsonResult.successResult(2000, "删除数据失败", 0, "失败");
            }
        } catch (Exception e) {
            return JsonResult.errorResult(5000, "删除数据数据失败", null);
        }

    }


}

