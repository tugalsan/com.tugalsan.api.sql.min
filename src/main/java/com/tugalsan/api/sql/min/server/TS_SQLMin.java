package com.tugalsan.api.sql.min.server;


import com.tugalsan.api.callable.client.TGS_CallableType1Void;
import com.tugalsan.api.sql.conn.server.*;
import com.tugalsan.api.sql.where.server.*;

public class TS_SQLMin {

    public TS_SQLMin(TS_SQLConnAnchor anchor, CharSequence tableName, CharSequence columnName) {
        this.executor = new TS_SQLMinExecutor(anchor, tableName, columnName);
    }
    final private TS_SQLMinExecutor executor;

     public TS_SQLMinValue whereGroupAnd(TGS_CallableType1Void<TS_SQLWhereGroups> groups) {
        executor.where = TS_SQLWhereUtils.where();
        executor.where.groupsAnd(groups);
        return new TS_SQLMinValue(executor);
    }

    public TS_SQLMinValue whereGroupOr(TGS_CallableType1Void<TS_SQLWhereGroups> groups) {
        executor.where = TS_SQLWhereUtils.where();
        executor.where.groupsOr(groups);
        return new TS_SQLMinValue(executor);
    }

    public TS_SQLMinValue whereConditionAnd(TGS_CallableType1Void<TS_SQLWhereConditions> conditions) {
        return whereGroupAnd(where -> where.conditionsAnd(conditions));
    }

    public TS_SQLMinValue whereConditionOr(TGS_CallableType1Void<TS_SQLWhereConditions> conditions) {
        return whereGroupOr(where -> where.conditionsOr(conditions));
    }

    public TS_SQLMinValue whereConditionNone() {
        return new TS_SQLMinValue(executor);
    }
}
