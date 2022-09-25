package com.ndh.masterthesis.redditScraper.service.export;

import java.util.function.Predicate;

public class IdMatchingPredicate implements Predicate<Integer> {
    @Override
    public boolean test(Integer integer) {
        return false;
    }

    @Override
    public Predicate<Integer> and(Predicate<? super Integer> other) {
        return null;
    }

    @Override
    public Predicate<Integer> negate() {
        return null;
    }

    @Override
    public Predicate<Integer> or(Predicate<? super Integer> other) {
        return null;
    }
}
