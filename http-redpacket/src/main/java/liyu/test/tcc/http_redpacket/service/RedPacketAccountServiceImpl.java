package liyu.test.tcc.http_redpacket.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;

import liyu.test.tcc.http_redpacket_api.RedPacketAccountService;
import liyu.test.tcc.http_redpacket_domain.domain.repository.RedPacketAccountRepository;

/**
 * Created by twinkle.zhou on 16/11/11.
 */
public class RedPacketAccountServiceImpl implements RedPacketAccountService {

    @Autowired
    RedPacketAccountRepository redPacketAccountRepository;

    public BigDecimal getRedPacketAccountByUserId(long userId) {
        return redPacketAccountRepository.findByUserId(userId).getBalanceAmount();
    }
}
