package liyu.test.tcc.core.utils;

import liyu.test.tcc.api.Propagation;
import liyu.test.tcc.api.TransactionContext;

/**
 * Created by changming.xie on 2/23/17.
 */
public class TransactionUtils {

    public static boolean isLegalTransactionContext(boolean isTransactionActive, Propagation propagation, TransactionContext transactionContext) {

        if (propagation.equals(Propagation.MANDATORY) && !isTransactionActive && transactionContext == null) {
            return false;
        }

        return true;
    }
}
