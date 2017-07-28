package org.twowls.becache.api.store;

import org.twowls.becache.api.CacheException;
import org.twowls.becache.api.Cacheable;

import java.util.Collection;

/**
 * <p>TODO add documentation...</p>
 *
 * @author Dmitry Chubarov
 */
public interface IndexedCache extends TypedCache<Cacheable>, AutoCloseable {

    <C extends Cacheable> TypedCache<C> select(Selector<C> selector) throws CacheException;

    /**
     * Returns a collection containing all types of objects actually stored in this cache.
     * @return a {@code Collection} of types, possibly empty.
     */
    Collection<Class<? extends Cacheable>> listTypes() throws CacheException;

    /**
     * Closes this cache.
     * @throws CacheException if this cache failed to close.
     */
    @Override
    void close() throws CacheException;
}
