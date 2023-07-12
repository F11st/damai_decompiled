package cn.damai.common.db.db.converter;

import android.database.Cursor;
import cn.damai.common.db.db.sqlite.ColumnDbType;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public interface ColumnConverter<T> {
    Object fieldValue2DbValue(T t);

    ColumnDbType getColumnDbType();

    T getFieldValue(Cursor cursor, int i);
}
