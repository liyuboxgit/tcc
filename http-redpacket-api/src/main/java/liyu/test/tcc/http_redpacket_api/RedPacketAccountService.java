package liyu.test.tcc.http_redpacket_api;

import java.math.BigDecimal;

/**
 * Created by twinkle.zhou on 16/11/11.
 */
public interface RedPacketAccountService {
    BigDecimal getRedPacketAccountByUserId(long userId);
}
