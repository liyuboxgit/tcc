package liyu.test.tcc.http_order.domain.domain.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Repository;

import liyu.test.tcc.http_order.domain.domain.entity.Order;
import liyu.test.tcc.http_order.domain.domain.entity.OrderLine;
import liyu.test.tcc.http_order.domain.infrastructure.dao.OrderDao;
import liyu.test.tcc.http_order.domain.infrastructure.dao.OrderLineDao;

/**
 * Created by changming.xie on 4/1/16.
 */
@Repository
public class OrderRepository {

    @Autowired
    OrderDao orderDao;

    @Autowired
    OrderLineDao orderLineDao;

    public void createOrder(Order order) {
        orderDao.insert(order);

        for (OrderLine orderLine : order.getOrderLines()) {
            orderLineDao.insert(orderLine);
        }
    }

    public void updateOrder(Order order) {
        order.updateVersion();
        int effectCount = orderDao.update(order);

        if (effectCount < 1) {
            throw new OptimisticLockingFailureException("update order failed");
        }
    }

    public Order findByMerchantOrderNo(String merchantOrderNo) {
        return orderDao.findByMerchantOrderNo(merchantOrderNo);
    }
}
