package tb;

import android.text.TextUtils;
import com.ali.ha.fulltrace.dump.DumpManager;
import com.alibaba.analytics.core.db.annotation.Column;
import com.alibaba.analytics.core.db.annotation.Ingore;
import com.alibaba.analytics.core.db.annotation.TableName;
import com.alibaba.analytics.core.model.LogField;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
@TableName(DumpManager.LOG_PATH)
/* loaded from: classes5.dex */
public class qa1 extends ve0 {
    @Ingore
    public static final String DEFAULT_PRIORITY = "3";
    @Ingore
    public static final String FIELD_NAME_PRIORITY = "priority";
    @Ingore
    public static final String FIELD_NAME_TIME = "time";
    @Column("eventId")
    public String a;
    @Column("priority")
    public String b;
    @Column("content")
    private String c;
    @Column("time")
    public String d;
    @Column("_index")
    public String e;
    @Ingore
    private Map<String, String> f;
    @Ingore
    private int g;

    public qa1() {
        this.b = "3";
        this.d = null;
        this.e = "";
        this.g = 0;
    }

    private String a(List<String> list) {
        if (list != null) {
            if (list.size() == 1) {
                return list.get(0);
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                if (i > 0) {
                    sb.append(",");
                }
                sb.append(list.get(i));
            }
            return sb.toString();
        }
        return "";
    }

    public String b() {
        try {
            byte[] a = ga.a(this.c.getBytes("UTF-8"), 2);
            if (a != null) {
                return new String(ly1.c(a));
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public int c() {
        return this.g;
    }

    public void d(String str) {
        if (str != null) {
            try {
                this.c = new String(ga.c(ly1.c(str.getBytes()), 2), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }

    public void e(int i) {
        this.g = i;
    }

    public String toString() {
        return "Log [eventId=" + this.a + ", index=" + this.e + jn1.ARRAY_END_STR;
    }

    public qa1(String str, List<String> list, String str2, Map<String, String> map) {
        this.b = "3";
        this.d = null;
        this.e = "";
        this.g = 0;
        this.b = str;
        a(list);
        this.a = str2;
        this.d = String.valueOf(System.currentTimeMillis());
        za2.a().d(str2, map);
        this.e = map.get(LogField.RESERVE3.toString());
        d(com.alibaba.analytics.core.logbuilder.a.a(map));
    }

    public qa1(String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
        this.b = "3";
        this.d = null;
        this.e = "";
        this.g = 0;
        this.a = str2;
        this.f = map;
        this.d = String.valueOf(System.currentTimeMillis());
        this.b = ya1.b().c(str2);
        HashMap hashMap = new HashMap();
        if (map != null) {
            hashMap.putAll(map);
        }
        if (!TextUtils.isEmpty(str)) {
            hashMap.put(LogField.PAGE.toString(), str);
        }
        hashMap.put(LogField.EVENTID.toString(), str2);
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put(LogField.ARG1.toString(), str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put(LogField.ARG2.toString(), str4);
        }
        if (!TextUtils.isEmpty(str5)) {
            hashMap.put(LogField.ARG3.toString(), str5);
        }
        if (!TextUtils.isEmpty(this.d)) {
            hashMap.put(LogField.RECORD_TIMESTAMP.toString(), this.d);
        }
        za2.a().d(str2, hashMap);
        this.e = (String) hashMap.get(LogField.RESERVE3.toString());
        d(com.alibaba.analytics.core.logbuilder.a.a(hashMap));
    }
}
