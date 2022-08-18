package com.tugalsan.api.sql.min.server;

import com.tugalsan.api.log.server.*;
import com.tugalsan.api.time.client.*;
import com.tugalsan.api.validator.client.*;

public class TS_SQLMinValue {

    final private static TS_Log d = TS_Log.of(TS_SQLMinValue.class.getSimpleName());

    public TS_SQLMinValue(TS_SQLMinExecutor executor) {
        this.executor = executor;
    }
    final private TS_SQLMinExecutor executor;

    public TGS_Time time(TGS_ValidatorType1<Long> optionalValidator) {
        var val = val();
        if (val == null) {
            return null;
        }
        if (optionalValidator != null && !optionalValidator.validate(val)) {
            return null;
        }
        return TGS_Time.ofTime(val);
    }

    public TGS_Time date(TGS_ValidatorType1<Long> optionalValidator) {
        var val = val();
        if (val == null) {
            d.ci("date", "val == null");
            return null;
        }
        if (optionalValidator != null && !optionalValidator.validate(val)) {
            d.ci("date", "optionalValidator != null && !optionalValidator.validate(val)", optionalValidator.validate(val));
            return null;
        }
        var date = TGS_Time.ofDate(val);
        d.ci("date", () -> date.toString_dateOnly());
        return date;
    }

    public Long val() {
        var val = executor.execute();
        d.ci("val", val);
        return val;
    }
}
