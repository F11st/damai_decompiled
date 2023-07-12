package com.alibaba.appmonitor.model;

import com.alibaba.analytics.core.model.LogField;
import com.alibaba.appmonitor.pool.C3316a;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import java.util.Map;
import tb.oq1;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class UTDimensionValueSet extends DimensionValueSet {
    public static UTDimensionValueSet create(Map<String, String> map) {
        return (UTDimensionValueSet) C3316a.a().poll(UTDimensionValueSet.class, map);
    }

    @Override // com.alibaba.mtl.appmonitor.model.DimensionValueSet, com.alibaba.appmonitor.pool.Reusable
    public void clean() {
        super.clean();
    }

    @Override // com.alibaba.mtl.appmonitor.model.DimensionValueSet, com.alibaba.appmonitor.pool.Reusable
    public void fill(Object... objArr) {
        super.fill(objArr);
    }

    public Integer getEventId() {
        int i;
        String str;
        Map<String, String> map = this.map;
        if (map != null && (str = map.get(LogField.EVENTID.toString())) != null) {
            try {
                i = oq1.a(str);
            } catch (NumberFormatException unused) {
            }
            return Integer.valueOf(i);
        }
        i = 0;
        return Integer.valueOf(i);
    }
}
