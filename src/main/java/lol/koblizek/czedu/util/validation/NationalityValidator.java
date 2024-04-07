package lol.koblizek.czedu.util.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class NationalityValidator implements ConstraintValidator<Nationality, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return getAvailableCountries().containsKey(value);
    }

    public static Map<String, String> getAvailableCountries() {
        Map<String, String> uwu = Arrays.stream(Locale.getAvailableLocales())
                .collect(Collectors.toMap(Locale::getCountry, Locale::getDisplayCountry));
        uwu.put("na", "Immigrant");
        return uwu;
    }
}
