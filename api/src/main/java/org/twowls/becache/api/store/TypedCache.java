package org.twowls.becache.api.store;

import org.twowls.becache.api.CacheException;
import org.twowls.becache.api.Cacheable;

/**
 * Represents a cache that contains zero or more objects of particular type.
 * @author Dmitry Chubarov
 */
public interface TypedCache<C extends Cacheable> {

    /**
     * @return total object count in this cache store.
     * @throws CacheException if cache is inconsistent or error occurred.
     */
    int count() throws CacheException;

    /**
     * Checks whether this cache contains a {@link Cacheable} equivalent to given object.
     * @param obj a pattern object to check.
     * @return {@code true} is cache contains such object, otherwise {@code false}.
     * @throws CacheException if cache is inconsistent or error occurred.
     */
    boolean contains(C obj) throws CacheException;

    ScanContext<C> scan(ScanPredicate<C> predicate, Object... params) throws CacheException;

    ScanContext<C> scan() throws CacheException;

}
