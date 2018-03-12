package liyu.test.tcc.http_redpacket_domain.domain.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import liyu.test.tcc.http_redpacket_domain.domain.entity.RedPacketAccount;
import liyu.test.tcc.http_redpacket_domain.exception.InsufficientBalanceException;
import liyu.test.tcc.http_redpacket_domain.infrastructure.dao.RedPacketAccountDao;

/**
 * Created by changming.xie on 4/2/16.
 */
@Repository
public class RedPacketAccountRepository {

    @Autowired
    RedPacketAccountDao redPacketAccountDao;

    public RedPacketAccount findByUserId(long userId) {

        return redPacketAccountDao.findByUserId(userId);
    }

    public void save(RedPacketAccount redPacketAccount) {
        int effectCount = redPacketAccountDao.update(redPacketAccount);
        if (effectCount < 1) {
            throw new InsufficientBalanceException();
        }
    }
}
