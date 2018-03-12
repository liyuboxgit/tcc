package liyu.test.tcc.http_redpacket_api;

import liyu.test.tcc.api.TransactionContext;
import liyu.test.tcc.http_redpacket_api.dto.RedPacketTradeOrderDto;

/**
 * Created by changming.xie on 4/1/16.
 */
public interface RedPacketTradeOrderService {

    public String record(TransactionContext transactionContext, RedPacketTradeOrderDto tradeOrderDto);
}
