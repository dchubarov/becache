package org.twowls.becache.api.store;

import org.twowls.becache.api.Cacheable;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static java.util.Objects.requireNonNull;

/**
 * <p>TODO add documentation...</p>
 * @param <C>
 * @author Dmitry Chubarov
 */
public interface ScanContext<C extends Cacheable> extends Iterable<C> {

    /**
     * Retrieves an indexed parameter's value.
     * @param index the parameter index.
     * @return parameter value or {@code null} if no parameter exists.
     */
    Object getParam(int index);

    default C one() {
        C ret = null;
        for (C obj : this) {
            if (ret != null) {
                throw new IllegalStateException("More than one object in this scan context.");
            }
            ret = obj;
        }
        return ret;
    }

    default Optional<C> first() {
        return stream().findFirst();
    }

    /**
     * Retrieves all objects from this scan context into a {@code List}.
     * @return a new {@code List} instance.
     */
    default List<C> asList() {
        List<C> destination = new ArrayList<>();
        toCollection(destination);
        return destination;
    }

    /**
     * Transfers all objects from this scan context into a {@code Collection}.
     * @param destination the destination collection, must not be {@code null}.
     */
    default void toCollection(Collection<? super C> destination) {
        requireNonNull(destination);
        forEach(destination::add);
    }

    /**
     * Transfers all objects from this scan context into a {@code Map}.
     * @param destination the destination map, must not be {@code null}.
     * @param keyFn a function that extracts map keys from objects, must not be {@code null}.
     * @param <K> the type of map key.
     */
    default <K> void toMap(Map<K, ? super C> destination, Function<C, K> keyFn) {
        requireNonNull(destination);
        requireNonNull(keyFn);
        forEach(o -> destination.put(keyFn.apply(o), o));
    }

    /**
     * Creates a {@code Stream} representing this scan context.
     * @return a new {@code Stream} instance.
     */
    default Stream<C> stream() {
        return StreamSupport.stream(spliterator(), false);
    }
}
