package org.agoncal.book.javaee7.chapter02;

import javax.annotation.Priority;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.interceptor.Interceptor;
import java.util.logging.Logger;

/**
 * Created by a.morozov on 09.06.2017.
 */
@Decorator
public class NumberGeneratorDecorator implements NumberGenerator {

    @Inject
    Logger logger;

    @Inject @Any
    @Delegate
    private NumberGenerator numberGenerator;

    public String generateNumber() {
        System.out.println("NumberGeneratorDecorator was called!!!!!!!\n");
        logger.info("NumberGeneratorDecorator was called!!!!!!!");
        return numberGenerator.generateNumber();
    }
}
