package org.twowls.becache.api.multilayer;

import org.twowls.becache.api.CacheException;
import org.twowls.becache.api.Cacheable;
import org.twowls.becache.api.store.IndexedCache;

/**
 * <p>TODO add documentation...</p>
 * @author Dmitry Chubarov
 */
public interface LayeredCache {

    /**
     * Checks if this cache contains at least one object.
     * @return {@code true} if there are objects, otherwise {@code false}.
     */
    boolean hasData();

    /**
     * Checks if this cache contains at least one object that is not committed yet.
     * @return {@code true} if there are impending objects, otherwise {@code false}.
     */
    boolean hasImpendingData();

    boolean put(Cacheable obj) throws CacheException;

    void commit() throws CacheException;

    void discard() throws CacheException;

    IndexedCache view() throws CacheException;

    /**
     * Optimizes this cache's internal structure to improve performance and (or) reduce underlying storage.
     * @param hint a hint influencing optimization process.
     * @return a boolean value indicating whether cache has been changed as a result of optimization.
     * @throws CacheException if error occurred during optimization.
     * @throws UnsupportedOperationException if implementation of layered cache does not support optimization.
     */
    boolean optimize(String hint) throws CacheException, UnsupportedOperationException;

    void addEventListener(LayeredCacheEventListener listener);

    void removeEventListener(LayeredCacheEventListener listener);

}
