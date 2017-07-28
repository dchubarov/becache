/**
 * Contains various helper classes supporting tests.
 * @author Dmitry Chubarov
 */
module org.twowls.becache.testkit {
    requires org.twowls.becache.api;
    requires org.junit.jupiter.api;
    exports org.twowls.becache.testkit.model;
    exports org.twowls.becache.testkit.multilayer;
}