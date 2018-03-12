package liyu.test.tcc.http_order.domain.infrastructure.dao;


import liyu.test.tcc.http_order.domain.domain.entity.Shop;

/**
 * Created by changming.xie on 4/1/16.
 */
public interface ShopDao {
    Shop findById(long id);
}
