package com.youku.playerservice.axp.cache.local.db.converter;

import androidx.room.TypeConverter;
import java.util.Date;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class DateConverter {
    @TypeConverter
    public static Date toDate(Long l) {
        if (l == null) {
            return null;
        }
        return new Date(l.longValue());
    }

    @TypeConverter
    public static Long toTimestamp(Date date) {
        if (date == null) {
            return null;
        }
        return Long.valueOf(date.getTime());
    }
}
