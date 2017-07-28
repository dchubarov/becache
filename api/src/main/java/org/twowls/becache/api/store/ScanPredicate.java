package org.twowls.becache.api.store;

import org.twowls.becache.api.Cacheable;

/**
 * <p>TODO add documentation...</p>
 * @author Dmitry Chubarov
 */
public interface ScanPredicate<C extends Cacheable> {

    boolean eval(C obj, ScanContext<C> sc);

}
