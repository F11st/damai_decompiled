package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.maps.model.LatLng;
import java.lang.ref.WeakReference;
import java.util.Hashtable;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class ea {
    private static boolean a;
    private static volatile ea d;
    private Hashtable<String, String> b = new Hashtable<>();
    private WeakReference<Context> c = null;

    private ea() {
    }

    public static ea a() {
        if (d == null) {
            synchronized (ea.class) {
                if (d == null) {
                    d = new ea();
                }
            }
        }
        return d;
    }

    public static void b() {
        if (d != null) {
            if (d.b != null && d.b.size() > 0) {
                synchronized (d.b) {
                    d.c();
                    if (d.c != null) {
                        d.c.clear();
                    }
                }
            }
            d = null;
        }
        a(false);
    }

    private void c() {
        WeakReference<Context> weakReference;
        if (!a) {
            this.b.clear();
        } else if (this.b != null) {
            StringBuffer stringBuffer = new StringBuffer();
            int i = 0;
            int size = this.b.size();
            if (size > 0) {
                stringBuffer.append(jn1.ARRAY_START_STR);
                for (String str : this.b.values()) {
                    i++;
                    stringBuffer.append(str);
                    if (i < size) {
                        stringBuffer.append(",");
                    }
                }
                stringBuffer.append(jn1.ARRAY_END_STR);
                String stringBuffer2 = stringBuffer.toString();
                if (!TextUtils.isEmpty(stringBuffer2) && (weakReference = this.c) != null && weakReference.get() != null) {
                    ip.a(stringBuffer2, this.c.get());
                }
            }
            this.b.clear();
        }
    }

    private boolean d() {
        Hashtable<String, String> hashtable = this.b;
        return hashtable != null && hashtable.size() > 20;
    }

    public static void a(boolean z) {
        a = z;
    }

    public static void a(int i) {
        if (a) {
            a(i < 1000);
        }
    }

    public void a(Context context) {
        if (context != null) {
            this.c = new WeakReference<>(context);
        }
    }

    public void a(LatLng latLng, String str, String str2) {
        if (!a) {
            this.b.clear();
        } else if (latLng == null || TextUtils.isEmpty(str)) {
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(jn1.BLOCK_START_STR);
            stringBuffer.append("\"lon\":");
            stringBuffer.append(latLng.longitude);
            stringBuffer.append(",");
            stringBuffer.append("\"lat\":");
            stringBuffer.append(latLng.latitude);
            stringBuffer.append(",");
            stringBuffer.append("\"title\":");
            stringBuffer.append("\"");
            stringBuffer.append(str);
            stringBuffer.append("\"");
            stringBuffer.append(",");
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            stringBuffer.append("\"snippet\":");
            stringBuffer.append("\"");
            stringBuffer.append(str2);
            stringBuffer.append("\"");
            stringBuffer.append("}");
            a(stringBuffer.toString());
        }
    }

    private void a(String str) {
        Hashtable<String, String> hashtable;
        if (str == null || (hashtable = this.b) == null) {
            return;
        }
        synchronized (hashtable) {
            String b = gk.b(str);
            Hashtable<String, String> hashtable2 = this.b;
            if (hashtable2 != null && !hashtable2.contains(b)) {
                this.b.put(b, str);
            }
            if (d()) {
                c();
            }
        }
    }
}
