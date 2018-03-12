package liyu.test.tcc.http_redpacket_domain.infrastructure.dao;

import liyu.test.tcc.http_redpacket_domain.domain.entity.RedPacketAccount;

/**
 * Created by changming.xie on 4/2/16.
 */
public interface RedPacketAccountDao {

    RedPacketAccount findByUserId(long userId);

    int update(RedPacketAccount redPacketAccount);
}
