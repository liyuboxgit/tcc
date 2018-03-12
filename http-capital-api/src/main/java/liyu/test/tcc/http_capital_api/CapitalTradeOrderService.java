package liyu.test.tcc.http_capital_api;

import liyu.test.tcc.api.TransactionContext;
import liyu.test.tcc.http_capital_api.dto.CapitalTradeOrderDto;

/**
 * Created by changming.xie on 4/1/16.
 */
public interface CapitalTradeOrderService {
    public String record(TransactionContext transactionContext, CapitalTradeOrderDto tradeOrderDto);
}
