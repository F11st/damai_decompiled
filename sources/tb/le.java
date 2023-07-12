package tb;

import android.database.Cursor;
import cn.damai.common.db.db.converter.ColumnConverter;
import cn.damai.common.db.db.sqlite.ColumnDbType;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class le implements ColumnConverter<Byte> {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.common.db.db.converter.ColumnConverter
    /* renamed from: a */
    public Object fieldValue2DbValue(Byte b) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-393744432") ? ipChange.ipc$dispatch("-393744432", new Object[]{this, b}) : b;
    }

    @Override // cn.damai.common.db.db.converter.ColumnConverter
    /* renamed from: b */
    public Byte getFieldValue(Cursor cursor, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2135663111")) {
            return (Byte) ipChange.ipc$dispatch("2135663111", new Object[]{this, cursor, Integer.valueOf(i)});
        }
        if (cursor.isNull(i)) {
            return null;
        }
        return Byte.valueOf((byte) cursor.getInt(i));
    }

    @Override // cn.damai.common.db.db.converter.ColumnConverter
    public ColumnDbType getColumnDbType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1961358808") ? (ColumnDbType) ipChange.ipc$dispatch("-1961358808", new Object[]{this}) : ColumnDbType.INTEGER;
    }
}
