package tb;

import android.database.Cursor;
import cn.damai.common.db.db.converter.ColumnConverter;
import cn.damai.common.db.db.sqlite.ColumnDbType;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Date;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class s30 implements ColumnConverter<Date> {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.common.db.db.converter.ColumnConverter
    /* renamed from: a */
    public Object fieldValue2DbValue(Date date) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-709171064")) {
            return ipChange.ipc$dispatch("-709171064", new Object[]{this, date});
        }
        if (date == null) {
            return null;
        }
        return Long.valueOf(date.getTime());
    }

    @Override // cn.damai.common.db.db.converter.ColumnConverter
    /* renamed from: b */
    public Date getFieldValue(Cursor cursor, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-833518385")) {
            return (Date) ipChange.ipc$dispatch("-833518385", new Object[]{this, cursor, Integer.valueOf(i)});
        }
        if (cursor.isNull(i)) {
            return null;
        }
        return new Date(cursor.getLong(i));
    }

    @Override // cn.damai.common.db.db.converter.ColumnConverter
    public ColumnDbType getColumnDbType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-585445810") ? (ColumnDbType) ipChange.ipc$dispatch("-585445810", new Object[]{this}) : ColumnDbType.INTEGER;
    }
}
