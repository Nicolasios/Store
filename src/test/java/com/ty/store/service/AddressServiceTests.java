package com.ty.store.service;


import com.ty.store.entity.Address;
import com.ty.store.service.ex.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AddressServiceTests {
    @Autowired
    private IAddressService iAddressService;

    @Test
    public void addNewAddress(){
        try {
            Integer uid = 18;
            String username = "管理员";
            Address address = new Address();
            address.setName("张三");
            address.setPhone("17858805555");
            address.setAddress("雁塔区小寨华旗");
            iAddressService.addNewAddress(uid,username,address);
        }
        catch (ServiceException e){
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void getByUid() {
        Integer uid = 7;
        List<Address> list =iAddressService.getByUid(uid);
        System.out.println("count=" + list.size());
        for (Address item : list) {
            System.out.println(item);
        }
    }
    @Test
    public void setDefault() {
        try {
            Integer aid = 13;
            Integer uid = 7;
            String username = "系统管理员";
            iAddressService.setDefault(aid, uid, username);
            System.out.println("OK.");
        } catch (ServiceException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void delete() {
        try {
            Integer aid = 13;
            Integer uid = 7;
            String username = "明明";
            iAddressService.delete(aid, uid, username);
            System.out.println("OK.");
        } catch (ServiceException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }
}
