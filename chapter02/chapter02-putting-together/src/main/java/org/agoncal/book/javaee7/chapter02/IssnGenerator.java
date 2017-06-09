package org.agoncal.book.javaee7.chapter02;

import javax.inject.Inject;
import java.util.Random;
import java.util.logging.Logger;

@EightDigits
public class IssnGenerator implements NumberGenerator {

    private final Logger logger;

    @Inject
    public IssnGenerator(Logger logger) {
        this.logger = logger;
    }

    @Loggable
    @Override
    public String generateNumber() {
        String issn = "8-" + Math.abs(new Random().nextInt());
        logger.info("Сгенерирован ISSN : " + issn);
        return issn;
    }
}