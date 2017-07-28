package org.twowls.becache.api.store;

import org.twowls.becache.api.Cacheable;

import static java.util.Objects.requireNonNull;

/**
 * <p>TODO add documentation...</p>
 * @author Dmitry Chubarov
 */
public final class Selector<C extends Cacheable> {

    private final Class<C> cls;
    private int limit;

    private Selector(Class<C> cls) {
        this.cls = requireNonNull(cls);
    }

    public Class<C> getCls() {
        return cls;
    }

    public int getLimit() {
        return limit;
    }

    public Selector<C> limit(int limit) {
        this.limit = limit;
        return this;
    }

    public static <C extends Cacheable> Selector<C> of(Class<C> cls) {
        return new Selector<>(cls);
    }
}
