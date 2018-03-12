package liyu.test.tcc.http_order.domain.infrastructure.dao;


import liyu.test.tcc.http_order.domain.domain.entity.OrderLine;

/**
 * Created by changming.xie on 4/1/16.
 */
public interface OrderLineDao {
    void insert(OrderLine orderLine);
}
