package com.tugalsan.api.sql.min.server;

import com.tugalsan.api.sql.conn.server.TS_SQLConnAnchor;

public class TS_SQLMinUtils {

    public static TS_SQLMin min(TS_SQLConnAnchor anchor, CharSequence tableName, CharSequence columnName) {
        return new TS_SQLMin(anchor, tableName, columnName);
    }

//    public static void test() {
//        var min = TS_SQLMinUtils
//                .min(null, "tn", "cn")
//                .whereConditionAnd(conditions -> conditions.lngEq("", 0));
//    }
}
