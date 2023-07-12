package tb;

import android.text.TextUtils;
import com.alibaba.analytics.core.db.annotation.Column;
import com.alibaba.analytics.core.db.annotation.TableName;
import com.alibaba.fastjson.JSON;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;

/* compiled from: Taobao */
@TableName("stat_temp")
/* loaded from: classes6.dex */
public class ql2 extends pl2 {
    @Column("dimension_values")
    private String f;
    @Column("measure_values")
    private String g;

    public ql2() {
    }

    public DimensionValueSet a() {
        if (TextUtils.isEmpty(this.f)) {
            return null;
        }
        return (DimensionValueSet) JSON.parseObject(this.f, DimensionValueSet.class);
    }

    public MeasureValueSet b() {
        if (TextUtils.isEmpty(this.g)) {
            return null;
        }
        return (MeasureValueSet) JSON.parseObject(this.g, MeasureValueSet.class);
    }

    @Override // tb.pl2
    public String toString() {
        return "TempStat{module='" + this.a + "'monitorPoint='" + this.b + "'dimension_values='" + this.f + "', measure_values='" + this.g + "'}";
    }

    public ql2(String str, String str2, DimensionValueSet dimensionValueSet, MeasureValueSet measureValueSet, String str3, String str4) {
        super(str, str2, str3, str4);
        this.f = JSON.toJSONString(dimensionValueSet);
        this.g = JSON.toJSONString(measureValueSet);
    }
}
