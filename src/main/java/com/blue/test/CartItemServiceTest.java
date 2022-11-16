package com.blue.test;

import com.blue.pojo.CartItem;
import com.blue.service.CartItemService;
import com.blue.service.impl.CartItemServiceImpl;
import org.junit.jupiter.api.Test;

/**
 * @author shkstart
 * @create 2022-11-15 17:00
 */
public class CartItemServiceTest {
    private CartItemService cartItemService=new CartItemServiceImpl();
    @Test
    public void queryForCartItem(){
        for(CartItem cartItem:cartItemService.queryForCartItem(1)){
            System.out.println(cartItem);
        }
    }

}
