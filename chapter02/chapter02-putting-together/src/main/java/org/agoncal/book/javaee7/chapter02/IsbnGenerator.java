package org.agoncal.book.javaee7.chapter02;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import java.util.Random;
import java.util.logging.Logger;

@Default
@ThirteenDigits
public class IsbnGenerator implements NumberGenerator {

    private final Logger logger;

    @Inject
    public IsbnGenerator(Logger logger) {
        this.logger = logger;
    }

    @Loggable
    @Override
    public String generateNumber() {
        String isbn = "13-84356-" + Math.abs(new Random().nextInt());
        logger.info("Сгенерирован ISBN : " + isbn);
        return isbn;
    }
}