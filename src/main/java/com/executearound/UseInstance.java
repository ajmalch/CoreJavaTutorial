package com.executearound;

/**
 * Created by AjmalCholassery on 6/17/15.
 */
@FunctionalInterface
public interface UseInstance<T,X extends Throwable> {
    void accept(T instance) throws X;
}
