package tb;

import android.database.Cursor;
import cn.damai.common.db.db.converter.ColumnConverter;
import cn.damai.common.db.db.sqlite.ColumnDbType;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class fk0 implements ColumnConverter<Float> {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.common.db.db.converter.ColumnConverter
    /* renamed from: a */
    public Object fieldValue2DbValue(Float f) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "545653212") ? ipChange.ipc$dispatch("545653212", new Object[]{this, f}) : f;
    }

    @Override // cn.damai.common.db.db.converter.ColumnConverter
    /* renamed from: b */
    public Float getFieldValue(Cursor cursor, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1918069801")) {
            return (Float) ipChange.ipc$dispatch("-1918069801", new Object[]{this, cursor, Integer.valueOf(i)});
        }
        if (cursor.isNull(i)) {
            return null;
        }
        return Float.valueOf(cursor.getFloat(i));
    }

    @Override // cn.damai.common.db.db.converter.ColumnConverter
    public ColumnDbType getColumnDbType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-163260172") ? (ColumnDbType) ipChange.ipc$dispatch("-163260172", new Object[]{this}) : ColumnDbType.REAL;
    }
}
