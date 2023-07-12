package tb;

import com.alibaba.aliweex.adapter.module.WXCalendarModule;
import com.alimm.xadsdk.base.expose.RetryMonitorDbHelper;
import com.taobao.weex.utils.WXLogUtils;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Pattern;
import org.apache.commons.lang3.time.TimeZones;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class w30 {
    public static final long DAY = 86400000;
    public static final long WEEK = 604800000;
    private static final DateFormat[] a;
    private static final TimeZone b = TimeZone.getTimeZone("UTC");

    static {
        String[] strArr = {"EEE, dd MMM yy HH:mm:ss z", "EEE, dd MMM yyyy HH:mm:ss z", "EEE, dd MMM yy HH:mm:ss", "EEE, MMM dd yy HH:mm:ss", "EEE, dd MMM yy HH:mm z", "EEE dd MMM yyyy HH:mm:ss", "dd MMM yy HH:mm:ss z", "dd MMM yy HH:mm z", "yyyy-MM-dd'T'HH:mm:ssZ", "yyyy-MM-dd'T'HH:mm:ss'Z'", "yyyy-MM-dd'T'HH:mm:sszzzz", "yyyy-MM-dd'T'HH:mm:ss z", "yyyy-MM-dd'T'HH:mm:ssz", "yyyy-MM-dd'T'HH:mm:ss.SSSz", "yyyy-MM-dd'T'HHmmss.SSSz", "yyyy-MM-dd'T'HH:mm:ss", "yyyy-MM-dd'T'HH:mmZ", "yyyy-MM-dd'T'HH:mm'Z'", "dd MMM yyyy HH:mm:ss z", "dd MMM yyyy HH:mm z", RetryMonitorDbHelper.DATE_FORMAT, "MMM dd, yyyy"};
        a = new SimpleDateFormat[22];
        for (int i = 0; i < 22; i++) {
            DateFormat[] dateFormatArr = a;
            dateFormatArr[i] = new SimpleDateFormat(strArr[i], Locale.ENGLISH);
            dateFormatArr[i].setTimeZone(b);
        }
    }

    public static boolean a(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    public static Date b(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        String trim = str.trim();
        if (trim.length() == 14 && a(trim)) {
            try {
                return new SimpleDateFormat("yyyyMMddHHmmss").parse(trim);
            } catch (ParseException e) {
                WXLogUtils.w(WXCalendarModule.TAG, e);
            }
        } else if (trim.length() == 19 && trim.indexOf(" ") == 10) {
            try {
                return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(trim);
            } catch (ParseException e2) {
                WXLogUtils.w(WXCalendarModule.TAG, e2);
            }
        }
        int i = 0;
        if (trim.length() > 10) {
            if ((trim.substring(trim.length() - 5).indexOf(jn1.PLUS) == 0 || trim.substring(trim.length() - 5).indexOf("-") == 0) && trim.substring(trim.length() - 5).indexOf(":") == 2) {
                trim = trim.substring(0, trim.length() - 5) + trim.substring(trim.length() - 5, trim.length() - 4) + "0" + trim.substring(trim.length() - 4);
            }
            String substring = trim.substring(trim.length() - 6);
            if ((substring.indexOf("-") == 0 || substring.indexOf(jn1.PLUS) == 0) && substring.indexOf(":") == 3 && !TimeZones.GMT_ID.equals(trim.substring(trim.length() - 9, trim.length() - 6))) {
                trim = trim.substring(0, trim.length() - 6) + (substring.substring(0, 3) + substring.substring(4));
            }
        }
        synchronized (w30.class) {
            while (true) {
                DateFormat[] dateFormatArr = a;
                if (i >= dateFormatArr.length) {
                    return null;
                }
                try {
                    return dateFormatArr[i].parse(trim);
                } catch (NumberFormatException | ParseException unused) {
                    i++;
                }
            }
        }
    }
}
