package liyu.test.tcc.http_order.domain.domain.factory;

import java.util.List;

import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import liyu.test.tcc.http_order.domain.domain.entity.Order;
import liyu.test.tcc.http_order.domain.domain.entity.OrderLine;
import liyu.test.tcc.http_order.domain.domain.repository.ProductRepository;

/**
 * Created by changming.xie on 4/1/16.
 */
@Component
public class OrderFactory {

    @Autowired
    ProductRepository productRepository;

    public Order buildOrder(long payerUserId, long payeeUserId, List<Pair<Long, Integer>> productQuantities) {

        Order order = new Order(payerUserId, payeeUserId);

        for (Pair<Long, Integer> pair : productQuantities) {
            long productId = pair.getLeft();
            order.addOrderLine(new OrderLine(productId, pair.getRight(), productRepository.findById(productId).getPrice()));
        }

        return order;
    }
}
