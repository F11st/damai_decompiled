package tb;

import com.alibaba.analytics.core.Variables;
import com.alibaba.analytics.core.model.LogField;
import com.alibaba.analytics.utils.Logger;
import com.ta.audid.Constants;
import com.ut.device.UTDevice;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ct2 extends zs2 {
    private static ct2 d;
    private int a;
    private Random b;
    private Map<String, C9017b> c;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: tb.ct2$b */
    /* loaded from: classes5.dex */
    public static class C9017b {
        private int a;
        private Map<String, Integer> b;

        private C9017b() {
            this.a = 0;
            this.b = new HashMap();
        }

        private boolean d(int i, int i2) {
            return i != 0 && i2 < i;
        }

        public boolean c(String str, int i) {
            if (str != null) {
                try {
                    Iterator<String> it = this.b.keySet().iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (next.startsWith("%") && next.endsWith("%")) {
                            next = next.substring(1, next.length() - 1);
                        }
                        if (str.equals(next)) {
                            return d(this.b.get(next).intValue(), i);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
            return d(this.a, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: tb.ct2$c */
    /* loaded from: classes5.dex */
    public static class C9018c {
        private boolean a;
        private boolean b;

        private C9018c() {
            this.a = false;
            this.b = false;
        }

        public boolean a() {
            return this.a;
        }

        public boolean b() {
            return this.b;
        }

        public void c(boolean z) {
            this.b = z;
        }

        public void d(boolean z) {
            this.a = z;
        }
    }

    private ct2() {
        this.a = 0;
        this.b = null;
        this.c = null;
        String utdid = UTDevice.getUtdid(Variables.n().j());
        if (utdid != null && !utdid.equals(Constants.UTDID_INVALID)) {
            this.a = Math.abs(yh2.d(utdid)) % 10000;
        } else {
            this.a = 0;
        }
        Logger.f("UTSampleConfBiz", "deviceSample", Integer.valueOf(this.a));
        this.b = new Random();
        this.c = new HashMap();
    }

    public static ct2 d() {
        if (d == null) {
            d = new ct2();
        }
        return d;
    }

    private C9018c e(int i, String str, int i2) {
        String valueOf = String.valueOf(i);
        C9018c c9018c = new C9018c();
        if (this.c.containsKey(valueOf)) {
            c9018c.c(true);
            c9018c.d(this.c.get(valueOf).c(str, i2));
            return c9018c;
        }
        c9018c.d(false);
        return c9018c;
    }

    private static C9017b h(String str) {
        try {
            C9017b c9017b = new C9017b();
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("cp")) {
                c9017b.a = jSONObject.optInt("cp");
            }
            if (jSONObject.has("arg1")) {
                HashMap hashMap = new HashMap();
                JSONObject optJSONObject = jSONObject.optJSONObject("arg1");
                if (optJSONObject != null) {
                    Iterator<String> keys = optJSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        hashMap.put(next, Integer.valueOf(Integer.parseInt(optJSONObject.optString(next))));
                    }
                }
                c9017b.b = hashMap;
            }
            return c9017b;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // tb.zs2
    public String[] a() {
        return new String[]{"ut_sample"};
    }

    @Override // tb.zs2
    public void b(String str) {
        super.b(str);
    }

    @Override // tb.zs2
    public synchronized void c(String str, Map<String, String> map) {
        C9017b h;
        this.c.clear();
        for (String str2 : map.keySet()) {
            String str3 = map.get(str2);
            if (str3 != null && (h = h(str3)) != null) {
                this.c.put(str2, h);
            }
        }
    }

    public synchronized boolean f(int i, String str) {
        int i2;
        if (Variables.n().m()) {
            return true;
        }
        if (this.c.size() == 0) {
            return true;
        }
        if (i != 19998 && i != 19997) {
            i2 = this.b.nextInt(10000);
        } else {
            i2 = this.a;
        }
        C9018c e = e(i, str, i2);
        if (e.a()) {
            return true;
        }
        if (e.b()) {
            return false;
        }
        C9018c e2 = e(i - (i % 10), str, i2);
        if (e2.a()) {
            return true;
        }
        if (e2.b()) {
            return false;
        }
        C9018c e3 = e(i - (i % 100), str, i2);
        if (e3.a()) {
            return true;
        }
        if (e3.b()) {
            return false;
        }
        C9018c e4 = e(i - (i % 1000), str, i2);
        if (e4.a()) {
            return true;
        }
        if (e4.b()) {
            return false;
        }
        C9018c e5 = e(-1, str, i2);
        if (e5.a()) {
            return true;
        }
        return e5.b() ? false : false;
    }

    public synchronized boolean g(Map<String, String> map) {
        try {
        } catch (Exception e) {
            Logger.h("UTSampleConfBiz", e, new Object[0]);
            return false;
        }
        return f(Integer.parseInt(map.get(LogField.EVENTID.toString())), map.get(LogField.ARG1.toString()));
    }
}
