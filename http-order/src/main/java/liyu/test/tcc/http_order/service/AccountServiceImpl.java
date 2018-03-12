package liyu.test.tcc.http_order.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import liyu.test.tcc.http_capital_api.CapitalAccountService;
import liyu.test.tcc.http_redpacket_api.RedPacketAccountService;

/**
 * Created by twinkle.zhou on 16/11/11.
 */
@Service("accountService")
public class AccountServiceImpl {

    @Autowired
    RedPacketAccountService redPacketAccountService;

    @Autowired
    CapitalAccountService capitalAccountService;


    public BigDecimal getRedPacketAccountByUserId(long userId){
        return redPacketAccountService.getRedPacketAccountByUserId(userId);
    }

    public BigDecimal getCapitalAccountByUserId(long userId){
        return capitalAccountService.getCapitalAccountByUserId(userId);
    }
}
