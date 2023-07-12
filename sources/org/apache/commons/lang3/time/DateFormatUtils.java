package org.apache.commons.lang3.time;

import com.alimm.xadsdk.base.expose.RetryMonitorDbHelper;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DateFormatUtils {
    public static final FastDateFormat ISO_8601_EXTENDED_DATETIME_FORMAT;
    public static final FastDateFormat ISO_8601_EXTENDED_DATETIME_TIME_ZONE_FORMAT;
    public static final FastDateFormat ISO_8601_EXTENDED_DATE_FORMAT;
    public static final FastDateFormat ISO_8601_EXTENDED_TIME_FORMAT;
    public static final FastDateFormat ISO_8601_EXTENDED_TIME_TIME_ZONE_FORMAT;
    @Deprecated
    public static final FastDateFormat ISO_DATETIME_FORMAT;
    @Deprecated
    public static final FastDateFormat ISO_DATETIME_TIME_ZONE_FORMAT;
    @Deprecated
    public static final FastDateFormat ISO_DATE_FORMAT;
    @Deprecated
    public static final FastDateFormat ISO_DATE_TIME_ZONE_FORMAT;
    @Deprecated
    public static final FastDateFormat ISO_TIME_FORMAT;
    @Deprecated
    public static final FastDateFormat ISO_TIME_NO_T_FORMAT;
    @Deprecated
    public static final FastDateFormat ISO_TIME_NO_T_TIME_ZONE_FORMAT;
    @Deprecated
    public static final FastDateFormat ISO_TIME_TIME_ZONE_FORMAT;
    public static final FastDateFormat SMTP_DATETIME_FORMAT;
    private static final TimeZone UTC_TIME_ZONE = FastTimeZone.getGmtTimeZone();

    static {
        FastDateFormat fastDateFormat = FastDateFormat.getInstance("yyyy-MM-dd'T'HH:mm:ss");
        ISO_8601_EXTENDED_DATETIME_FORMAT = fastDateFormat;
        ISO_DATETIME_FORMAT = fastDateFormat;
        FastDateFormat fastDateFormat2 = FastDateFormat.getInstance("yyyy-MM-dd'T'HH:mm:ssZZ");
        ISO_8601_EXTENDED_DATETIME_TIME_ZONE_FORMAT = fastDateFormat2;
        ISO_DATETIME_TIME_ZONE_FORMAT = fastDateFormat2;
        FastDateFormat fastDateFormat3 = FastDateFormat.getInstance(RetryMonitorDbHelper.DATE_FORMAT);
        ISO_8601_EXTENDED_DATE_FORMAT = fastDateFormat3;
        ISO_DATE_FORMAT = fastDateFormat3;
        ISO_DATE_TIME_ZONE_FORMAT = FastDateFormat.getInstance("yyyy-MM-ddZZ");
        ISO_TIME_FORMAT = FastDateFormat.getInstance("'T'HH:mm:ss");
        ISO_TIME_TIME_ZONE_FORMAT = FastDateFormat.getInstance("'T'HH:mm:ssZZ");
        FastDateFormat fastDateFormat4 = FastDateFormat.getInstance("HH:mm:ss");
        ISO_8601_EXTENDED_TIME_FORMAT = fastDateFormat4;
        ISO_TIME_NO_T_FORMAT = fastDateFormat4;
        FastDateFormat fastDateFormat5 = FastDateFormat.getInstance("HH:mm:ssZZ");
        ISO_8601_EXTENDED_TIME_TIME_ZONE_FORMAT = fastDateFormat5;
        ISO_TIME_NO_T_TIME_ZONE_FORMAT = fastDateFormat5;
        SMTP_DATETIME_FORMAT = FastDateFormat.getInstance("EEE, dd MMM yyyy HH:mm:ss Z", Locale.US);
    }

    public static String format(long j, String str) {
        return format(new Date(j), str, (TimeZone) null, (Locale) null);
    }

    public static String formatUTC(long j, String str) {
        return format(new Date(j), str, UTC_TIME_ZONE, (Locale) null);
    }

    public static String format(Date date, String str) {
        return format(date, str, (TimeZone) null, (Locale) null);
    }

    public static String formatUTC(Date date, String str) {
        return format(date, str, UTC_TIME_ZONE, (Locale) null);
    }

    public static String format(Calendar calendar, String str) {
        return format(calendar, str, (TimeZone) null, (Locale) null);
    }

    public static String formatUTC(long j, String str, Locale locale) {
        return format(new Date(j), str, UTC_TIME_ZONE, locale);
    }

    public static String format(long j, String str, TimeZone timeZone) {
        return format(new Date(j), str, timeZone, (Locale) null);
    }

    public static String formatUTC(Date date, String str, Locale locale) {
        return format(date, str, UTC_TIME_ZONE, locale);
    }

    public static String format(Date date, String str, TimeZone timeZone) {
        return format(date, str, timeZone, (Locale) null);
    }

    public static String format(Calendar calendar, String str, TimeZone timeZone) {
        return format(calendar, str, timeZone, (Locale) null);
    }

    public static String format(long j, String str, Locale locale) {
        return format(new Date(j), str, (TimeZone) null, locale);
    }

    public static String format(Date date, String str, Locale locale) {
        return format(date, str, (TimeZone) null, locale);
    }

    public static String format(Calendar calendar, String str, Locale locale) {
        return format(calendar, str, (TimeZone) null, locale);
    }

    public static String format(long j, String str, TimeZone timeZone, Locale locale) {
        return format(new Date(j), str, timeZone, locale);
    }

    public static String format(Date date, String str, TimeZone timeZone, Locale locale) {
        return FastDateFormat.getInstance(str, timeZone, locale).format(date);
    }

    public static String format(Calendar calendar, String str, TimeZone timeZone, Locale locale) {
        return FastDateFormat.getInstance(str, timeZone, locale).format(calendar);
    }
}
