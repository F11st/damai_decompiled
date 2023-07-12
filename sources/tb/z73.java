package tb;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class z73 {
    private static z73 h;
    private static long i;
    private File b;
    private String c;
    private Context d;
    private boolean e;
    private LinkedHashMap<String, Long> a = new LinkedHashMap<>();
    String f = "";
    String g = null;

    private z73(Context context) {
        this.c = null;
        Context applicationContext = context.getApplicationContext();
        this.d = applicationContext;
        String path = applicationContext.getFilesDir().getPath();
        if (this.c == null) {
            this.c = com.loc.m1.e0(this.d);
        }
        try {
            this.b = new File(path, "reportRecorder");
        } catch (Throwable th) {
            b73.a(th);
        }
        f();
    }

    public static synchronized z73 a(Context context) {
        z73 z73Var;
        synchronized (z73.class) {
            if (h == null) {
                h = new z73(context);
            }
            z73Var = h;
        }
        return z73Var;
    }

    private boolean e(Context context) {
        if (this.g == null) {
            this.g = a83.e(context, "pref", "lastavedate", "0");
        }
        if (this.g.equals(this.f)) {
            return false;
        }
        SharedPreferences.Editor c = a83.c(context, "pref");
        a83.j(c, "lastavedate", this.f);
        a83.f(c);
        this.g = this.f;
        return true;
    }

    private synchronized void f() {
        LinkedHashMap<String, Long> linkedHashMap = this.a;
        if (linkedHashMap == null || linkedHashMap.size() <= 0) {
            this.f = new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis()));
            for (String str : com.loc.m1.l(this.b)) {
                try {
                    String[] split = new String(com.loc.e1.h(com.loc.p1.g(str), this.c), "UTF-8").split(",");
                    if (split != null && split.length > 1) {
                        this.a.put(split[0], Long.valueOf(Long.parseLong(split[1])));
                    }
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void g() {
        try {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, Long> entry : this.a.entrySet()) {
                try {
                    String str = entry.getKey() + "," + entry.getValue();
                    sb.append(com.loc.p1.f(com.loc.e1.e(str.getBytes("UTF-8"), this.c)) + StringUtils.LF);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            String sb2 = sb.toString();
            if (TextUtils.isEmpty(sb2)) {
                return;
            }
            com.loc.m1.m(this.b, sb2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final synchronized void b() {
        if (this.e) {
            g();
            this.e = false;
        }
    }

    public final synchronized void c(AMapLocation aMapLocation) {
        try {
            if ((!this.a.containsKey(this.f) && this.a.size() >= 8) || (this.a.containsKey(this.f) && this.a.size() >= 9)) {
                ArrayList<String> arrayList = new ArrayList();
                for (Map.Entry<String, Long> entry : this.a.entrySet()) {
                    arrayList.add(entry.getKey());
                    if (arrayList.size() == this.a.size() - 7) {
                        break;
                    }
                }
                for (String str : arrayList) {
                    this.a.remove(str);
                }
            }
            if (aMapLocation.getErrorCode() != 0) {
                return;
            }
            if (aMapLocation.getLocationType() != 6 && aMapLocation.getLocationType() != 5) {
                if (this.a.containsKey(this.f)) {
                    long longValue = this.a.get(this.f).longValue() + 1;
                    i = longValue;
                    this.a.put(this.f, Long.valueOf(longValue));
                } else {
                    this.a.put(this.f, 1L);
                    i = 1L;
                }
                long j = i;
                if (j != 0 && j % 100 == 0) {
                    b();
                }
                this.e = true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final synchronized void d() {
        try {
            if (e(this.d)) {
                for (Map.Entry<String, Long> entry : this.a.entrySet()) {
                    if (!this.f.equals(entry.getKey())) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("param_long_first", entry.getKey());
                        jSONObject.put("param_long_second", entry.getValue());
                        com.loc.l1.n(this.d, "O023", jSONObject);
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
