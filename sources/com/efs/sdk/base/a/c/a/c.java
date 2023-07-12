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
import com.efs.sdk.base.a.e.f;
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
/* loaded from: classes10.dex */
public final class c implements Handler.Callback {
    public static final Random a = new Random();
    public IConfigRefreshAction b;
    public boolean c;
    private Handler d;
    public com.efs.sdk.base.a.c.a.a e;
    private d f;
    private long g;
    public Map<IConfigCallback, String[]> h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class a {
        private static final c a = new c((byte) 0);
    }

    private c() {
        this.c = true;
        this.h = new HashMap();
        this.d = new Handler(r33.a.getLooper(), this);
        this.f = new d();
        this.e = com.efs.sdk.base.a.c.a.a.c();
        this.g = com.efs.sdk.base.a.d.a.e.k;
    }

    /* synthetic */ c(byte b) {
        this();
    }

    public static c a() {
        return a.a;
    }

    private boolean f(com.efs.sdk.base.a.c.a.a aVar) {
        if (this.e.a >= aVar.a) {
            return true;
        }
        w63.a("efs.config", "current config version (" + this.e.a + ") is older than another (" + aVar.a + jn1.BRACKET_END_STR);
        return false;
    }

    private void k() {
        f fVar;
        String str;
        fVar = f.a.a;
        if (!fVar.b()) {
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
        d.c();
        long j = 0;
        try {
            d dVar = this.f;
            dVar.d();
            if (dVar.a != null) {
                j = dVar.a.getLong("last_refresh_time", 0L);
            }
        } catch (Throwable unused) {
        }
        return System.currentTimeMillis() - j >= 28800000;
    }

    private void o() {
        try {
            for (ValueCallback<Pair<Message, Message>> valueCallback : com.efs.sdk.base.a.d.a.e.a(1)) {
                Message obtain = Message.obtain(null, 1, new JSONObject(this.e.f).toString());
                Message obtain2 = Message.obtain();
                valueCallback.onReceiveValue(new Pair<>(obtain, obtain2));
                obtain.recycle();
                obtain2.recycle();
            }
            for (IEfsReporterObserver iEfsReporterObserver : com.efs.sdk.base.a.d.a.e.q) {
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
        com.efs.sdk.base.a.c.a.a c = com.efs.sdk.base.a.c.a.a.c();
        if (!b.d(str, c)) {
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
        com.efs.sdk.base.a.c.a.a aVar;
        String str;
        f fVar;
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
                fVar = f.a.a;
                if (fVar.b()) {
                    if (!n()) {
                        str = "No update is required, less than 8h since the last update";
                        w63.a("efs.config", str);
                    }
                    k();
                }
            } else if (i == 3) {
                l();
            }
        } else if (d.a()) {
            this.d.sendEmptyMessage(1);
        } else {
            d dVar = this.f;
            dVar.d();
            if (dVar.a == null) {
                aVar = null;
            } else {
                com.efs.sdk.base.a.c.a.a c = com.efs.sdk.base.a.c.a.a.c();
                c.a = dVar.a.getInt("cver", -1);
                Set<String> keySet = dVar.a.getAll().keySet();
                HashMap hashMap = new HashMap();
                for (String str2 : keySet) {
                    String string = dVar.a.getString(str2, "");
                    if (!TextUtils.isEmpty(string)) {
                        hashMap.put(str2, string);
                    }
                }
                c.b(hashMap);
                aVar = c;
            }
            if (aVar != null && !f(aVar)) {
                this.e = aVar;
                String str3 = "load config from storage";
                if (-1 != aVar.a) {
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
                    for (IConfigCallback iConfigCallback : c.this.h.keySet()) {
                        String[] strArr = (String[]) c.this.h.get(iConfigCallback);
                        HashMap hashMap = new HashMap();
                        if (strArr != null && strArr.length != 0) {
                            for (String str : strArr) {
                                if (c.this.e.f.containsKey(str)) {
                                    hashMap.put(str, c.this.i().get(str));
                                }
                            }
                        }
                        iConfigCallback.onChange(hashMap);
                    }
                    c.this.h.clear();
                } catch (Throwable unused) {
                }
            }
        });
    }
}
