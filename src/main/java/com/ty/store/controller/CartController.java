package com.ty.store.controller;


import com.ty.store.service.ICartService;
import com.ty.store.util.JsonResult;
import com.ty.store.vo.CartVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@Controller
@RequestMapping("carts")
@Slf4j
public class CartController extends BaseController{
    @Autowired
    private ICartService cartService;

    @RequestMapping("add_to_cart")
    public JsonResult<Void> addToCart(Integer pid, Integer amount, HttpSession session) {
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        cartService.addToCart(uid, pid, amount, username);
        log.info("pid:{}--amount:{}",pid,amount);
        return new JsonResult<Void>(OK);
    }

    @GetMapping({"", "/"})
    public JsonResult<List<CartVO>> getVOByUid(HttpSession session) {
        // 从Session中获取uid
        Integer uid = getUidFromSession(session);
        // 调用业务对象执行查询数据
        List<CartVO> data = cartService.getVOByUid(uid);
        // 返回成功与数据
        return new JsonResult<List<CartVO>>(OK, data);
    }

    @RequestMapping("{cid}/num/add")
    public JsonResult<Integer> addNum(@PathVariable("cid") Integer cid, HttpSession session) {
        // 从Session中获取uid和username
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        // 调用业务对象执行增加数量
        Integer data = cartService.addNum(cid, uid, username);
        // 返回成功
        return new JsonResult<Integer>(OK, data);
    }
}