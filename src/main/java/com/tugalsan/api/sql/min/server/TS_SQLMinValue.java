package com.tugalsan.api.sql.min.server;

import com.tugalsan.api.log.server.*;
import com.tugalsan.api.sql.count.server.TS_SQLCountUtils;
import com.tugalsan.api.time.client.*;
import com.tugalsan.api.union.client.TGS_UnionExcuse;
import com.tugalsan.api.validator.client.*;

public class TS_SQLMinValue {

    final private static TS_Log d = TS_Log.of(TS_SQLMinValue.class);

    public TS_SQLMinValue(TS_SQLMinExecutor executor) {
        this.executor = executor;
    }
    final private TS_SQLMinExecutor executor;

    public TGS_UnionExcuse<TGS_Time> time(TGS_ValidatorType1<Long> optionalValidator) {
        var u_val = val();
        if (u_val.isExcuse()) {
            u_val.toExcuse();
        }
        var val = u_val.value();
        if (optionalValidator != null && !optionalValidator.validate(val)) {
            return TGS_UnionExcuse.ofExcuse(d.className, "date", "optionalValidator != null && !optionalValidator.validate(val)");
        }
        var time =  TGS_Time.ofTime(val);
        d.ci("time", () -> time.toString_timeOnly());
        return TGS_UnionExcuse.of(time);
    }

    public TGS_UnionExcuse<TGS_Time> date(TGS_ValidatorType1<Long> optionalValidator) {
        var u_val = val();
        if (u_val.isExcuse()) {
            u_val.toExcuse();
        }
        var val = u_val.value();
        if (optionalValidator != null && !optionalValidator.validate(val)) {
            return TGS_UnionExcuse.ofExcuse(d.className, "date", "optionalValidator != null && !optionalValidator.validate(val)");
        }
        var date = TGS_Time.ofDate(val);
        d.ci("date", () -> date.toString_dateOnly());
        return TGS_UnionExcuse.of(date);
    }

    public TGS_UnionExcuse<Long> val() {
        var val = executor.run();
        if (val.isExcuse()) {//if count 0 return 1;
            var count = TS_SQLCountUtils.count(executor.anchor, executor.tableName).where(executor.where);
            if (count.isExcuse()) {
                return count;
            }
            if (count.value() == 0L) {
                return TGS_UnionExcuse.of(1L);
            }
        }
        d.ci("val", val);
        return val;
    }
}
