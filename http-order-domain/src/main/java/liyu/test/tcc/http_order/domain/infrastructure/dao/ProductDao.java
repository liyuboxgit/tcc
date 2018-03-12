package liyu.test.tcc.http_order.domain.infrastructure.dao;


import java.util.List;

import liyu.test.tcc.http_order.domain.domain.entity.Product;

/**
 * Created by twinkle.zhou on 16/11/10.
 */
public interface ProductDao {

    Product findById(long productId);

    List<Product> findByShopId(long shopId);
}
