package cn.damai.commonbusiness.calendar.remind;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import cn.damai.common.util.ToastUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.tencent.open.SocialConstants;
import com.ut.mini.behavior.edgecomputing.datacollector.core.UTDataCollectorNodeColumn;
import java.util.TimeZone;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class CalendarsResolver {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static String c = "DamaiMemberCalendar";
    private static String d = "项目提醒";
    private static String e = "cn.damai.member";
    private static String f = "优先选座提醒";
    private static CalendarsResolver g;
    private int a = 5;
    private RemindMeListener b;

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public interface RemindMeListener {
        void addRemindmeSuccess();

        void candelRemindmeSuccess();
    }

    private long a(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1127595860")) {
            return ((Long) ipChange.ipc$dispatch("1127595860", new Object[]{this, context})).longValue();
        }
        TimeZone timeZone = TimeZone.getDefault();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", c);
        contentValues.put("account_name", d);
        contentValues.put("account_type", e);
        contentValues.put("calendar_displayName", f);
        contentValues.put("visible", (Integer) 1);
        contentValues.put("calendar_color", (Integer) (-16776961));
        contentValues.put("calendar_access_level", (Integer) 700);
        contentValues.put("sync_events", (Integer) 1);
        contentValues.put("calendar_timezone", timeZone.getID());
        contentValues.put("ownerAccount", d);
        contentValues.put("canOrganizerRespond", (Integer) 0);
        Uri uri = null;
        try {
            uri = context.getContentResolver().insert(Uri.parse("content://com.android.calendar/calendars").buildUpon().appendQueryParameter("caller_is_syncadapter", "true").appendQueryParameter("account_name", d).appendQueryParameter("account_type", e).build(), contentValues);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (uri == null) {
            return -1L;
        }
        return ContentUris.parseId(uri);
    }

    private int f(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-733748766")) {
            return ((Integer) ipChange.ipc$dispatch("-733748766", new Object[]{this, context})).intValue();
        }
        int g2 = g(context);
        if (g2 >= 0) {
            return g2;
        }
        if (a(context) >= 0) {
            return g(context);
        }
        return -1;
    }

    private static int g(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-784718644")) {
            return ((Integer) ipChange.ipc$dispatch("-784718644", new Object[]{context})).intValue();
        }
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.android.calendar/calendars"), null, null, null, null);
        if (query == null) {
            if (query != null) {
            }
            return -1;
        }
        try {
            if (query.getCount() > 0) {
                query.moveToFirst();
                return query.getInt(query.getColumnIndex("_id"));
            }
            return -1;
        } finally {
            query.close();
        }
    }

    public static CalendarsResolver i() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "633812156")) {
            return (CalendarsResolver) ipChange.ipc$dispatch("633812156", new Object[0]);
        }
        if (g == null) {
            g = new CalendarsResolver();
        }
        return g;
    }

    public void b(Context context, String str, String str2, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1115758083")) {
            ipChange.ipc$dispatch("1115758083", new Object[]{this, context, str, str2, Long.valueOf(j)});
        } else {
            e(context, str, "NULL_FLAG", str2, j, 0L, 0);
        }
    }

    public void c(Context context, String str, String str2, long j, long j2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1497334270")) {
            ipChange.ipc$dispatch("-1497334270", new Object[]{this, context, str, str2, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)});
        } else {
            e(context, str, "NULL_FLAG", str2, j, j2, i);
        }
    }

    public void d(Context context, String str, String str2, String str3, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "991132601")) {
            ipChange.ipc$dispatch("991132601", new Object[]{this, context, str, str2, str3, Long.valueOf(j)});
        } else {
            e(context, str, str2, str3, j, 0L, 0);
        }
    }

    public void e(Context context, String str, String str2, String str3, long j, long j2, int i) {
        Uri uri;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1003338184")) {
            ipChange.ipc$dispatch("-1003338184", new Object[]{this, context, str, str2, str3, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)});
            return;
        }
        int i2 = -1;
        try {
            i2 = f(context);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (i2 < 0) {
            ToastUtil.a().e(context, "亲，无法获取到您的手机日历请手动设置提醒～");
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", str);
        contentValues.put(SocialConstants.PARAM_COMMENT, str3);
        if (!"NULL_FLAG".equals(str2)) {
            contentValues.put("eventLocation", str2);
        }
        contentValues.put("calendar_id", Integer.valueOf(i2));
        if (j == 0) {
            ToastUtil.a().e(context, "亲，添加日历数据错误～");
            return;
        }
        if (j2 == 0) {
            j2 = j;
        }
        contentValues.put("dtstart", Long.valueOf(j));
        contentValues.put("dtend", Long.valueOf(j2));
        contentValues.put("hasAlarm", (Integer) 1);
        contentValues.put("eventTimezone", "Asia/Shanghai");
        Uri uri2 = null;
        try {
            uri = context.getContentResolver().insert(Uri.parse("content://com.android.calendar/events"), contentValues);
        } catch (Exception e3) {
            e3.printStackTrace();
            uri = null;
        }
        if (uri == null) {
            ToastUtil.a().e(context, "亲，无法获取到您的手机日历请手动设置提醒～");
            return;
        }
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put(UTDataCollectorNodeColumn.EVENT_ID, Long.valueOf(ContentUris.parseId(uri)));
        if (i <= 0) {
            contentValues2.put("minutes", Integer.valueOf(this.a));
        } else {
            contentValues2.put("minutes", Integer.valueOf(i));
        }
        contentValues2.put("method", (Integer) 1);
        try {
            uri2 = context.getContentResolver().insert(Uri.parse("content://com.android.calendar/reminders"), contentValues2);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        if (uri2 == null) {
            ToastUtil.a().e(context, "设置提醒失败");
            return;
        }
        RemindMeListener remindMeListener = this.b;
        if (remindMeListener != null) {
            remindMeListener.addRemindmeSuccess();
        }
    }

    public void h(Context context, String str, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-516252171")) {
            ipChange.ipc$dispatch("-516252171", new Object[]{this, context, str, Long.valueOf(j)});
            return;
        }
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.android.calendar/events"), null, null, null, null);
        if (query == null) {
            if (query != null) {
                return;
            }
            return;
        }
        try {
            if (query.getCount() > 0) {
                query.moveToFirst();
                while (!query.isAfterLast()) {
                    String string = query.getString(query.getColumnIndex("title"));
                    if (j == query.getLong(query.getColumnIndex("dtstart")) && !TextUtils.isEmpty(str) && str.equals(string)) {
                        if (context.getContentResolver().delete(ContentUris.withAppendedId(Uri.parse("content://com.android.calendar/events"), query.getInt(query.getColumnIndex("_id"))), null, null) == -1) {
                            ToastUtil.a().e(context, "取消失败");
                            return;
                        }
                        RemindMeListener remindMeListener = this.b;
                        if (remindMeListener != null) {
                            remindMeListener.candelRemindmeSuccess();
                        }
                    }
                    query.moveToNext();
                }
            }
        } finally {
            query.close();
        }
    }

    public boolean j(Context context, String str, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-710275704")) {
            return ((Boolean) ipChange.ipc$dispatch("-710275704", new Object[]{this, context, str, Long.valueOf(j)})).booleanValue();
        }
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.android.calendar/events"), null, "  (deleted != 1)", null, null);
        if (query == null) {
            if (query != null) {
            }
            return false;
        }
        try {
            if (query.getCount() > 0) {
                query.moveToFirst();
                while (!query.isAfterLast()) {
                    String string = query.getString(query.getColumnIndex("title"));
                    if (j == query.getLong(query.getColumnIndex("dtstart")) && !TextUtils.isEmpty(str) && str.equals(string)) {
                        return true;
                    }
                    query.moveToNext();
                }
            }
            return false;
        } finally {
            query.close();
        }
    }

    public void k(RemindMeListener remindMeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1414185172")) {
            ipChange.ipc$dispatch("1414185172", new Object[]{this, remindMeListener});
        } else {
            this.b = remindMeListener;
        }
    }

    public CalendarsResolver l(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2071741297")) {
            return (CalendarsResolver) ipChange.ipc$dispatch("2071741297", new Object[]{this, Integer.valueOf(i)});
        }
        this.a = i;
        return i();
    }
}
