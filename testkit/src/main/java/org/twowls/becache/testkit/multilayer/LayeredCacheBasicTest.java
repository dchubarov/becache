package org.twowls.becache.testkit.multilayer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.twowls.becache.api.CacheException;
import org.twowls.becache.api.multilayer.LayeredCache;
import org.twowls.becache.api.store.IndexedCache;
import org.twowls.becache.api.store.Selector;
import org.twowls.becache.testkit.model.Artwork;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * <p>TODO add documentation...</p>
 * @author Dmitry Chubarov
 */
public abstract class LayeredCacheBasicTest {

    private IndexedCache view1;
    private IndexedCache view2;

    protected abstract LayeredCache newLayeredCache();

    @BeforeEach
    void prepareCache() throws CacheException {
        LayeredCache lc = newLayeredCache();

        view1 = lc.view();
        view2 = lc.view();

    }

    @AfterEach
    void cleanup() throws CacheException {
        view1.close();
        view2.close();
    }

    // TODO to be removed
    @Test
    public void test1() throws CacheException {
        LayeredCache lc = newLayeredCache();
        try (IndexedCache cache = lc.view()) {
            List<Artwork> pieces = cache.select(Selector.of(Artwork.class).limit(500)).scan().asList();
            for (Artwork piece : pieces) {
                assertTrue(cache.contains(piece));
            }
        }
    }
}
