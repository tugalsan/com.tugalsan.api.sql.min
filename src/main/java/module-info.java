module com.tugalsan.api.sql.min {
    requires java.sql;
    requires com.tugalsan.api.time;
    requires com.tugalsan.api.tuple;
    requires com.tugalsan.api.validator;
    requires com.tugalsan.api.callable;
    requires com.tugalsan.api.runnable;
    requires com.tugalsan.api.log;
    requires com.tugalsan.api.sql.sanitize;
    requires com.tugalsan.api.sql.select;
    requires com.tugalsan.api.sql.where;
    requires com.tugalsan.api.sql.conn;
    requires com.tugalsan.api.sql.resultset;
    exports com.tugalsan.api.sql.min.server;
}
