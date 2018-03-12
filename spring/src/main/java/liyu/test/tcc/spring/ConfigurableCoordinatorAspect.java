package liyu.test.tcc.spring;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;

import liyu.test.tcc.core.interceptor.ResourceCoordinatorAspect;
import liyu.test.tcc.core.interceptor.ResourceCoordinatorInterceptor;
import liyu.test.tcc.core.support.TransactionConfigurator;

/**
 * Created by changmingxie on 11/8/15.
 */
@Aspect
public class ConfigurableCoordinatorAspect extends ResourceCoordinatorAspect implements Ordered {

    private TransactionConfigurator transactionConfigurator;

    public void init() {

        ResourceCoordinatorInterceptor resourceCoordinatorInterceptor = new ResourceCoordinatorInterceptor();
        resourceCoordinatorInterceptor.setTransactionManager(transactionConfigurator.getTransactionManager());
        this.setResourceCoordinatorInterceptor(resourceCoordinatorInterceptor);
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE + 1;
    }

    public void setTransactionConfigurator(TransactionConfigurator transactionConfigurator) {
        this.transactionConfigurator = transactionConfigurator;
    }
}
