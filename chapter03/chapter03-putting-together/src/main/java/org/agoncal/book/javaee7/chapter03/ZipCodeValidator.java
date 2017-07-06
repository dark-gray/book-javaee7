package org.agoncal.book.javaee7.chapter03;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ZipCodeValidator implements ConstraintValidator<ZipCode, String> {

    private ZipCodeChecker checker;
    private final Pattern zipPattern = Pattern.compile("\\d{5}(-\\d{5})?");

    // При внедрении через конструктор не работает интеграционный тест.
    @Inject
    public void setChecker(@USA ZipCodeChecker checker) {
        this.checker = checker;
    }

    @Override
    public void initialize(ZipCode zipCode) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null) {
            return true;
        }

        Matcher m = zipPattern.matcher(value);
        if (!m.matches()) {
            return false;
        }
        return checker.isZipCodeValid(value);
    }
}
