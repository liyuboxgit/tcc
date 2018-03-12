package liyu.test.tcc.http_redpacket_domain.infrastructure.dao;


import liyu.test.tcc.http_redpacket_domain.domain.entity.TradeOrder;

/**
 * Created by twinkle.zhou on 16/11/14.
 */
public interface TradeOrderDao {

    void insert(TradeOrder tradeOrder);

    int update(TradeOrder tradeOrder);

    TradeOrder findByMerchantOrderNo(String merchantOrderNo);
}
