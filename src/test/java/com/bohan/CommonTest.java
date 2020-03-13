package com.bohan;

import com.bohan.entity.User;
import com.bohan.utils.JwtUtils;
import org.junit.Test;

public class CommonTest {

    @Test
    public void testGeneJwt(){
        User user = new User();
        user.setId(999);
        user.setHeadImg("www.xdclass.next");
        user.setName("bohan");

        String token = JwtUtils.geneJsonWebToken(user);
        System.out.println(token);
    }
}
