package tb;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.CalendarContract;
import android.text.TextUtils;
import com.tencent.open.SocialConstants;
import com.ut.mini.behavior.edgecomputing.datacollector.core.UTDataCollectorNodeColumn;
import java.util.Calendar;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class jf {
    @TargetApi(14)
    private static boolean a(Context context, String str, String str2, Calendar calendar, Calendar calendar2, int i) {
        if (d(context, str, str2, calendar, calendar2)) {
            return true;
        }
        long timeInMillis = calendar.getTimeInMillis();
        long timeInMillis2 = calendar2.getTimeInMillis();
        ContentResolver contentResolver = context.getContentResolver();
        ContentValues contentValues = new ContentValues();
        contentValues.put("dtstart", Long.valueOf(timeInMillis));
        contentValues.put("dtend", Long.valueOf(timeInMillis2));
        contentValues.put("title", str);
        contentValues.put(SocialConstants.PARAM_COMMENT, str2);
        contentValues.put("calendar_id", (Long) 1L);
        contentValues.put("eventTimezone", "GMT+8");
        Long valueOf = Long.valueOf(Long.parseLong(contentResolver.insert(CalendarContract.Events.CONTENT_URI, contentValues).getLastPathSegment()));
        Uri uri = CalendarContract.Events.CONTENT_URI;
        String[] strArr = {"_id", "title", SocialConstants.PARAM_COMMENT, "dtstart", "dtend"};
        if (contentResolver.query(uri, strArr, "_id=" + valueOf, null, null).moveToNext()) {
            ContentResolver contentResolver2 = context.getContentResolver();
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("minutes", Integer.valueOf(i));
            contentValues2.put(UTDataCollectorNodeColumn.EVENT_ID, valueOf);
            contentValues2.put("method", (Integer) 1);
            contentResolver2.insert(CalendarContract.Reminders.CONTENT_URI, contentValues2);
            return true;
        }
        return false;
    }

    private static boolean b(Context context, String str, String str2, Calendar calendar, Calendar calendar2, int i) {
        try {
            long timeInMillis = calendar.getTimeInMillis();
            long timeInMillis2 = calendar2.getTimeInMillis();
            ContentResolver contentResolver = context.getContentResolver();
            ContentValues contentValues = new ContentValues();
            contentValues.put("calendar_id", (Long) 1L);
            contentValues.put("title", str);
            contentValues.put(SocialConstants.PARAM_COMMENT, str2);
            contentValues.put("dtstart", Long.valueOf(timeInMillis));
            contentValues.put("dtend", Long.valueOf(timeInMillis2));
            contentValues.put("eventStatus", (Integer) 1);
            contentValues.put("hasAlarm", (Integer) 1);
            contentValues.put("eventTimezone", "GMT+8");
            Uri parse = Uri.parse("content://com.android.calendar/events");
            Long valueOf = Long.valueOf(Long.parseLong(contentResolver.insert(parse, contentValues).getLastPathSegment()));
            String[] strArr = {"_id", "title", SocialConstants.PARAM_COMMENT, "dtstart", "dtend"};
            if (contentResolver.query(parse, strArr, "_id=" + valueOf, null, null).moveToNext()) {
                ContentResolver contentResolver2 = context.getContentResolver();
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("minutes", Integer.valueOf(i));
                contentValues2.put(UTDataCollectorNodeColumn.EVENT_ID, valueOf);
                contentValues2.put("method", (Integer) 1);
                contentResolver2.insert(Uri.parse("content://com.android.calendar/reminders"), contentValues2);
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static boolean c(Context context, String str, String str2, Calendar calendar, Calendar calendar2, int i) {
        if (context == null || calendar == null || calendar2 == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 14) {
            return a(context, str, str2, calendar, calendar2, i);
        }
        return b(context, str, str2, calendar, calendar2, i);
    }

    public static boolean d(Context context, String str, String str2, Calendar calendar, Calendar calendar2) {
        long timeInMillis = calendar.getTimeInMillis();
        long timeInMillis2 = calendar2.getTimeInMillis();
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.android.calendar/events"), new String[]{"_id"}, "title= ? AND dtstart= ? AND dtend= ?", new String[]{str, timeInMillis + "", timeInMillis2 + ""}, null);
        return query != null && query.moveToNext();
    }

    public static boolean e(Context context, String str, Calendar calendar, Calendar calendar2) {
        long j;
        if (context != null && calendar != null && calendar2 != null) {
            ContentResolver contentResolver = context.getContentResolver();
            Uri parse = Uri.parse("content://com.android.calendar/events");
            Cursor query = contentResolver.query(parse, new String[]{"_id", "title", SocialConstants.PARAM_COMMENT, "dtstart", "dtend"}, null, null, null);
            while (true) {
                if (!query.moveToNext()) {
                    j = 0;
                    break;
                }
                Long valueOf = Long.valueOf(query.getLong(0));
                String string = query.getString(1);
                long j2 = query.getLong(3);
                long j3 = query.getLong(4);
                if (!TextUtils.isEmpty(string) && string.equals(str) && calendar.getTimeInMillis() >= j2 && calendar2.getTimeInMillis() <= j3) {
                    j = valueOf.longValue();
                    break;
                }
            }
            if (j == 0) {
                return false;
            }
            try {
                contentResolver.delete(parse, "_id= ?", new String[]{j + ""});
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }
}
