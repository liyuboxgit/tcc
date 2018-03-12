package liyu.test.tcc.http_capital_domain.infrastructure.dao;


import liyu.test.tcc.http_capital_domain.domain.entity.TradeOrder;

/**
 * Created by twinkle.zhou on 16/11/14.
 */
public interface TradeOrderDao {

    int insert(TradeOrder tradeOrder);

    int update(TradeOrder tradeOrder);

    TradeOrder findByMerchantOrderNo(String merchantOrderNo);
}
