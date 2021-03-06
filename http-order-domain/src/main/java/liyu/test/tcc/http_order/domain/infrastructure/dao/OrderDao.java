package liyu.test.tcc.http_order.domain.infrastructure.dao;

import liyu.test.tcc.http_order.domain.domain.entity.Order;

/**
 * Created by changming.xie on 4/1/16.
 */
public interface OrderDao {

    public int insert(Order order);

    public int update(Order order);

    Order findByMerchantOrderNo(String merchantOrderNo);
}
