package org.twowls.becache.api.store;

import org.twowls.becache.api.CacheException;

/**
 * Represents a cache store that provides additional features to layered cache.
 *
 * @author Dmitry Chubarov
 */
public interface ComplementaryCache extends IndexedCache {

    /**
     * Returns product of a merger of current cache and the {@code other} one.
     * @param other the other cache to merge, must not be {@code null}.
     * @return a new {@link IndexedCache} instance.
     * @throws CacheException if caches cannot be merged.
     */
    IndexedCache merge(IndexedCache other) throws CacheException;

}
