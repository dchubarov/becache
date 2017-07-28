package org.twowls.becache.api;

/**
 * A checked exception class for cache-specific errors.
 * @author Dmitry Chubarov
 */
public class CacheException extends Exception {

    /**
     * Constructs a new {@link CacheException} object without detail message.
     * @see Exception#Exception()
     */
    public CacheException() {
        super();
    }

    /**
     * Constructs a new {@link CacheException} with the specified cause.
     * @param cause the cause.
     * @see Exception#Exception(Throwable)
     */
    public CacheException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new {@link CacheException} with the specified detail message.
     * @param message the detail message.
     * @see Exception#Exception(String)
     */
    public CacheException(String message) {
        super(message);
    }

    /**
     * Constructs a new {@link CacheException} with the specified cause and a detail message.
     * @param message the detail message.
     * @param cause the cause.
     * @see Exception#Exception(String, Throwable)
     */
    public CacheException(String message, Throwable cause) {
        super(message, cause);
    }
}
