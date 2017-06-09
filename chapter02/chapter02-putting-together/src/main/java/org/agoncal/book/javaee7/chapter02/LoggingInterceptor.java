package org.agoncal.book.javaee7.chapter02;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.util.logging.Logger;

@Interceptor
@Loggable
public class LoggingInterceptor {

    @Inject
    private Logger logger;

    @AroundInvoke
    public Object logMethod(InvocationContext ic) throws Exception {
        logger.info(ic.getTarget().getClass().getName() + " " + ic.getMethod().getName() + " --- Enter");
        try {
            return ic.proceed();
        } finally {
            logger.info(ic.getTarget().getClass().getName() + " " + ic.getMethod().getName() + " --- Exit");
        }
    }
}