package tb;

import android.database.Cursor;
import cn.damai.common.db.db.converter.ColumnConverter;
import cn.damai.common.db.db.sqlite.ColumnDbType;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.sql.Date;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class mf2 implements ColumnConverter<Date> {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.common.db.db.converter.ColumnConverter
    /* renamed from: a */
    public Object fieldValue2DbValue(Date date) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1951010576")) {
            return ipChange.ipc$dispatch("-1951010576", new Object[]{this, date});
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
        if (AndroidInstantRuntime.support(ipChange, "-1662623549")) {
            return (Date) ipChange.ipc$dispatch("-1662623549", new Object[]{this, cursor, Integer.valueOf(i)});
        }
        if (cursor.isNull(i)) {
            return null;
        }
        return new Date(cursor.getLong(i));
    }

    @Override // cn.damai.common.db.db.converter.ColumnConverter
    public ColumnDbType getColumnDbType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "366584372") ? (ColumnDbType) ipChange.ipc$dispatch("366584372", new Object[]{this}) : ColumnDbType.INTEGER;
    }
}
