package com.efs.sdk.base.a.c.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import com.efs.sdk.base.Constants;
import com.efs.sdk.base.IConfigRefreshAction;
import com.efs.sdk.base.a.d.C4786a;
import com.efs.sdk.base.a.e.C4794f;
import com.efs.sdk.base.observer.IConfigCallback;
import com.efs.sdk.base.observer.IEfsReporterObserver;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import org.json.JSONObject;
import tb.g33;
import tb.jn1;
import tb.r33;
import tb.w63;

/* compiled from: Taobao */
/* renamed from: com.efs.sdk.base.a.c.a.c */
/* loaded from: classes10.dex */
public final class C4783c implements Handler.Callback {
    public static final Random a = new Random();
    public IConfigRefreshAction b;
    public boolean c;
    private Handler d;
    public C4781a e;
    private SharedPreferences$OnSharedPreferenceChangeListenerC4785d f;
    private long g;
    public Map<IConfigCallback, String[]> h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.efs.sdk.base.a.c.a.c$a */
    /* loaded from: classes10.dex */
    public static class C4784a {
        private static final C4783c a = new C4783c((byte) 0);
    }

    private C4783c() {
        this.c = true;
        this.h = new HashMap();
        this.d = new Handler(r33.a.getLooper(), this);
        this.f = new SharedPreferences$OnSharedPreferenceChangeListenerC4785d();
        this.e = C4781a.c();
        this.g = C4786a.e.k;
    }

    /* synthetic */ C4783c(byte b) {
        this();
    }

    public static C4783c a() {
        return C4784a.a;
    }

    private boolean f(C4781a c4781a) {
        if (this.e.a >= c4781a.a) {
            return true;
        }
        w63.a("efs.config", "current config version (" + this.e.a + ") is older than another (" + c4781a.a + jn1.BRACKET_END_STR);
        return false;
    }

    private void k() {
        C4794f c4794f;
        String str;
        c4794f = C4794f.C4795a.a;
        if (!c4794f.b()) {
            str = "has no permission to refresh config from remote";
        } else if (this.c) {
            String refresh = m().refresh();
            if (TextUtils.isEmpty(refresh)) {
                return;
            }
            e(refresh);
            return;
        } else {
            str = "disable refresh config from remote";
        }
        w63.a("efs.config", str);
    }

    private void l() {
        boolean z;
        try {
            z = this.f.b(this.e);
        } catch (Throwable unused) {
            z = false;
        }
        if (z) {
            return;
        }
        this.d.sendEmptyMessageDelayed(3, 3000L);
    }

    @NonNull
    private IConfigRefreshAction m() {
        IConfigRefreshAction iConfigRefreshAction = this.b;
        return iConfigRefreshAction == null ? g33.a() : iConfigRefreshAction;
    }

    private boolean n() {
        SharedPreferences$OnSharedPreferenceChangeListenerC4785d.c();
        long j = 0;
        try {
            SharedPreferences$OnSharedPreferenceChangeListenerC4785d sharedPreferences$OnSharedPreferenceChangeListenerC4785d = this.f;
            sharedPreferences$OnSharedPreferenceChangeListenerC4785d.d();
            if (sharedPreferences$OnSharedPreferenceChangeListenerC4785d.a != null) {
                j = sharedPreferences$OnSharedPreferenceChangeListenerC4785d.a.getLong("last_refresh_time", 0L);
            }
        } catch (Throwable unused) {
        }
        return System.currentTimeMillis() - j >= 28800000;
    }

    private void o() {
        try {
            for (ValueCallback<Pair<Message, Message>> valueCallback : C4786a.e.a(1)) {
                Message obtain = Message.obtain(null, 1, new JSONObject(this.e.f).toString());
                Message obtain2 = Message.obtain();
                valueCallback.onReceiveValue(new Pair<>(obtain, obtain2));
                obtain.recycle();
                obtain2.recycle();
            }
            for (IEfsReporterObserver iEfsReporterObserver : C4786a.e.q) {
                iEfsReporterObserver.onConfigChange();
            }
        } catch (Throwable th) {
            w63.c(Constants.TAG, "efs.config", th);
        }
    }

    public final String b(boolean z) {
        StringBuilder sb;
        if (z) {
            sb = new StringBuilder("https://");
        } else {
            sb = new StringBuilder();
            sb.append(this.e.b);
        }
        sb.append(this.e.a());
        return sb.toString();
    }

    public final void d(int i) {
        if (i <= this.e.a) {
            w63.a("efs.config", "current config version is " + i + ", no need to refresh");
            return;
        }
        Message obtain = Message.obtain();
        obtain.arg1 = i;
        obtain.what = 1;
        this.d.sendMessage(obtain);
    }

    public final void e(String str) {
        C4781a c = C4781a.c();
        if (!C4782b.d(str, c)) {
            this.d.sendEmptyMessageDelayed(1, 3000L);
        } else if (f(c)) {
        } else {
            this.e = c;
            l();
            o();
            j();
        }
    }

    public final void h() {
        this.d.sendEmptyMessage(0);
        this.d.sendEmptyMessageDelayed(2, this.g);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(@NonNull Message message) {
        C4781a c4781a;
        String str;
        C4794f c4794f;
        int i = message.what;
        if (i != 0) {
            if (i == 1) {
                int i2 = message.arg1;
                if (i2 <= this.e.a) {
                    w63.a("efs.config", "current config version is " + i2 + ", no need to refresh");
                    str = "current config version(" + this.e.a + ") is " + i2 + ", no need to refresh";
                    w63.a("efs.config", str);
                }
                k();
            } else if (i == 2) {
                c4794f = C4794f.C4795a.a;
                if (c4794f.b()) {
                    if (!n()) {
                        str = "No update is required, less than 8h since the last update";
                        w63.a("efs.config", str);
                    }
                    k();
                }
            } else if (i == 3) {
                l();
            }
        } else if (SharedPreferences$OnSharedPreferenceChangeListenerC4785d.a()) {
            this.d.sendEmptyMessage(1);
        } else {
            SharedPreferences$OnSharedPreferenceChangeListenerC4785d sharedPreferences$OnSharedPreferenceChangeListenerC4785d = this.f;
            sharedPreferences$OnSharedPreferenceChangeListenerC4785d.d();
            if (sharedPreferences$OnSharedPreferenceChangeListenerC4785d.a == null) {
                c4781a = null;
            } else {
                C4781a c = C4781a.c();
                c.a = sharedPreferences$OnSharedPreferenceChangeListenerC4785d.a.getInt("cver", -1);
                Set<String> keySet = sharedPreferences$OnSharedPreferenceChangeListenerC4785d.a.getAll().keySet();
                HashMap hashMap = new HashMap();
                for (String str2 : keySet) {
                    String string = sharedPreferences$OnSharedPreferenceChangeListenerC4785d.a.getString(str2, "");
                    if (!TextUtils.isEmpty(string)) {
                        hashMap.put(str2, string);
                    }
                }
                c.b(hashMap);
                c4781a = c;
            }
            if (c4781a != null && !f(c4781a)) {
                this.e = c4781a;
                String str3 = "load config from storage";
                if (-1 != c4781a.a) {
                    o();
                    j();
                    str3 = "load config from storage and notify observer";
                }
                w63.a("efs.config", str3);
            }
        }
        return true;
    }

    public final Map<String, String> i() {
        return new HashMap(this.e.f);
    }

    public final void j() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.efs.sdk.base.a.c.a.c.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    for (IConfigCallback iConfigCallback : C4783c.this.h.keySet()) {
                        String[] strArr = (String[]) C4783c.this.h.get(iConfigCallback);
                        HashMap hashMap = new HashMap();
                        if (strArr != null && strArr.length != 0) {
                            for (String str : strArr) {
                                if (C4783c.this.e.f.containsKey(str)) {
                                    hashMap.put(str, C4783c.this.i().get(str));
                                }
                            }
                        }
                        iConfigCallback.onChange(hashMap);
                    }
                    C4783c.this.h.clear();
                } catch (Throwable unused) {
                }
            }
        });
    }
}
