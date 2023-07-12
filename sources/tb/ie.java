package tb;

import android.database.Cursor;
import cn.damai.common.db.db.converter.ColumnConverter;
import cn.damai.common.db.db.sqlite.ColumnDbType;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class ie implements ColumnConverter<byte[]> {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.common.db.db.converter.ColumnConverter
    /* renamed from: a */
    public Object fieldValue2DbValue(byte[] bArr) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2010730531") ? ipChange.ipc$dispatch("-2010730531", new Object[]{this, bArr}) : bArr;
    }

    @Override // cn.damai.common.db.db.converter.ColumnConverter
    /* renamed from: b */
    public byte[] getFieldValue(Cursor cursor, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1566576294")) {
            return (byte[]) ipChange.ipc$dispatch("-1566576294", new Object[]{this, cursor, Integer.valueOf(i)});
        }
        if (cursor.isNull(i)) {
            return null;
        }
        return cursor.getBlob(i);
    }

    @Override // cn.damai.common.db.db.converter.ColumnConverter
    public ColumnDbType getColumnDbType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-625107447") ? (ColumnDbType) ipChange.ipc$dispatch("-625107447", new Object[]{this}) : ColumnDbType.BLOB;
    }
}
