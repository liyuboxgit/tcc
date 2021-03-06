package liyu.test.tcc.spring.support;

import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import liyu.test.tcc.core.support.BeanFactory;
import liyu.test.tcc.core.support.FactoryBuilder;

/**
 * Created by changmingxie on 11/22/15.
 */
public class SpringBeanFactory implements BeanFactory, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        FactoryBuilder.registerBeanFactory(this);
    }

    @Override
    public boolean isFactoryOf(Class clazz) {
        Map map = this.applicationContext.getBeansOfType(clazz);
        return map.size() > 0;
    }

    @Override
    public <T> T getBean(Class<T> var1) {
        return this.applicationContext.getBean(var1);
    }
}
