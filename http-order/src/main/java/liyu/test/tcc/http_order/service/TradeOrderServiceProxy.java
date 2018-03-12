package liyu.test.tcc.http_order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import liyu.test.tcc.api.Compensable;
import liyu.test.tcc.api.Propagation;
import liyu.test.tcc.api.TransactionContext;
import liyu.test.tcc.core.context.MethodTransactionContextEditor;
import liyu.test.tcc.http_capital_api.CapitalTradeOrderService;
import liyu.test.tcc.http_capital_api.dto.CapitalTradeOrderDto;
import liyu.test.tcc.http_redpacket_api.RedPacketTradeOrderService;
import liyu.test.tcc.http_redpacket_api.dto.RedPacketTradeOrderDto;

/**
 * Created by changming.xie on 4/19/17.
 */
@Component
public class TradeOrderServiceProxy {

    @Autowired
    CapitalTradeOrderService capitalTradeOrderService;

    @Autowired
    RedPacketTradeOrderService redPacketTradeOrderService;

    /*the propagation need set Propagation.SUPPORTS,otherwise the recover doesn't work,
      The default value is Propagation.REQUIRED, which means will begin new transaction when recover.
    */
    @Compensable(propagation = Propagation.SUPPORTS, confirmMethod = "record", cancelMethod = "record", transactionContextEditor = MethodTransactionContextEditor.class)
    public String record(TransactionContext transactionContext, CapitalTradeOrderDto tradeOrderDto) {
        return capitalTradeOrderService.record(transactionContext, tradeOrderDto);
    }

    @Compensable(propagation = Propagation.SUPPORTS, confirmMethod = "record", cancelMethod = "record", transactionContextEditor = MethodTransactionContextEditor.class)
    public String record(TransactionContext transactionContext, RedPacketTradeOrderDto tradeOrderDto) {
        return redPacketTradeOrderService.record(transactionContext, tradeOrderDto);
    }
}
