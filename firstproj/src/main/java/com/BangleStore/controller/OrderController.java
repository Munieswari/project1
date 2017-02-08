package com.BangleStore.controller;

import com.BangleStore.model.Cart;
import com.BangleStore.model.UsersDetail;
import com.BangleStore.model.UserOrder;
import com.BangleStore.service.CartService;
import com.BangleStore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


/*
 * This controller is used to handle user order
 */
@Controller
public class OrderController {

    @Autowired
    private CartService cartService;

    @Autowired
    private OrderService orderService;
    /*
     * createOrder method is used to insert user order into the database.
     */
    @RequestMapping("/order/{cartId}")
    public String createOrder(@PathVariable("cartId") int cartId) {
    	UserOrder userOrder = new UserOrder();
        Cart cart=cartService.getCartById(cartId);
        System.out.println("cart:"+cart.getCartId());
        userOrder.setCart(cart);

        UsersDetail usersDetail = cart.getUsersDetail();
        userOrder.setUsersDetail(usersDetail);
        
        userOrder.setShippingAddress(usersDetail.getShippingAddress());

        orderService.addOrder(userOrder);

        return "redirect:/checkout?cartId="+cartId;
    }
}
