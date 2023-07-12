package anetwork.channel.cache;

import anetwork.channel.cache.Cache;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import mtopsdk.common.util.HttpHeaderConstant;
import org.apache.commons.lang3.time.TimeZones;
import tb.h01;

/* compiled from: Taobao */
/* renamed from: anetwork.channel.cache.a */
/* loaded from: classes.dex */
public class C0242a {
    private static final TimeZone a = TimeZone.getTimeZone(TimeZones.GMT_ID);
    private static final ThreadLocal<SimpleDateFormat> b = new ThreadLocal<>();

    private static SimpleDateFormat a() {
        ThreadLocal<SimpleDateFormat> threadLocal = b;
        SimpleDateFormat simpleDateFormat = threadLocal.get();
        if (simpleDateFormat == null) {
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            simpleDateFormat2.setTimeZone(a);
            threadLocal.set(simpleDateFormat2);
            return simpleDateFormat2;
        }
        return simpleDateFormat;
    }

    public static Cache.Entry b(Map<String, List<String>> map) {
        long j;
        long j2;
        long currentTimeMillis = System.currentTimeMillis();
        String d = h01.d(map, "Cache-Control");
        boolean z = true;
        int i = 0;
        if (d != null) {
            String[] split = d.split(",");
            j = 0;
            while (true) {
                if (i >= split.length) {
                    break;
                }
                String trim = split[i].trim();
                if (trim.equals("no-store")) {
                    return null;
                }
                if (trim.equals(HttpHeaderConstant.NO_CACHE)) {
                    j = 0;
                    break;
                }
                if (trim.startsWith("max-age=")) {
                    try {
                        j = Long.parseLong(trim.substring(8));
                    } catch (Exception unused) {
                    }
                }
                i++;
            }
        } else {
            j = 0;
            z = false;
        }
        String d2 = h01.d(map, HttpHeaderConstant.DATE);
        long c = d2 != null ? c(d2) : 0L;
        String d3 = h01.d(map, "Expires");
        long c2 = d3 != null ? c(d3) : 0L;
        String d4 = h01.d(map, "Last-Modified");
        long c3 = d4 != null ? c(d4) : 0L;
        String d5 = h01.d(map, "ETag");
        if (z) {
            currentTimeMillis += j * 1000;
        } else if (c <= 0 || c2 < c) {
            j2 = c3;
            if (j2 <= 0) {
                currentTimeMillis = 0;
            }
            if (currentTimeMillis == 0 || d5 != null) {
                Cache.Entry entry = new Cache.Entry();
                entry.etag = d5;
                entry.ttl = currentTimeMillis;
                entry.serverDate = c;
                entry.lastModified = j2;
                entry.responseHeaders = map;
                return entry;
            }
            return null;
        } else {
            currentTimeMillis += c2 - c;
        }
        j2 = c3;
        if (currentTimeMillis == 0) {
        }
        Cache.Entry entry2 = new Cache.Entry();
        entry2.etag = d5;
        entry2.ttl = currentTimeMillis;
        entry2.serverDate = c;
        entry2.lastModified = j2;
        entry2.responseHeaders = map;
        return entry2;
    }

    private static long c(String str) {
        if (str.length() == 0) {
            return 0L;
        }
        try {
            ParsePosition parsePosition = new ParsePosition(0);
            Date parse = a().parse(str, parsePosition);
            if (parsePosition.getIndex() == str.length()) {
                return parse.getTime();
            }
        } catch (Exception unused) {
        }
        return 0L;
    }

    public static String d(long j) {
        return a().format(new Date(j));
    }
}
