package com.efs.sdk.base.a.d;

import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import com.alibaba.security.common.track.model.C3834a;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.efs.sdk.base.Constants;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.a.c.a.C4783c;
import com.efs.sdk.base.a.d.a.RunnableC4787a;
import com.efs.sdk.base.a.e.C4794f;
import com.efs.sdk.base.a.e.HandlerC4788a;
import com.efs.sdk.base.a.g.C4796d;
import com.efs.sdk.base.protocol.ILogProtocol;
import com.taobao.weex.annotation.JSMethod;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;
import io.flutter.wpkbridge.WPKFactory;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;
import tb.a53;
import tb.f33;
import tb.g83;
import tb.i43;
import tb.j43;
import tb.j83;
import tb.k83;
import tb.m73;
import tb.n73;
import tb.o43;
import tb.r33;
import tb.u23;
import tb.v43;
import tb.w63;
import tb.x53;

/* compiled from: Taobao */
/* renamed from: com.efs.sdk.base.a.d.a */
/* loaded from: classes10.dex */
public final class C4786a implements Handler.Callback {
    public static f33 e;
    private int a = 0;
    private volatile boolean b = false;
    private RunnableC4787a c;
    private Handler d;

    public C4786a(EfsReporter.Builder builder) {
        e = builder.e();
        Handler handler = new Handler(r33.a.getLooper(), this);
        this.d = handler;
        handler.sendEmptyMessage(0);
    }

    @NonNull
    public static f33 a() {
        return e;
    }

    private void c() {
        if (this.c == null) {
            this.c = new RunnableC4787a();
        }
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION);
            e.c.registerReceiver(this.c, intentFilter);
        } catch (Throwable th) {
            w63.b(Constants.TAG, "register network change receiver error", th);
            int i = this.a + 1;
            this.a = i;
            if (i < 3) {
                this.d.sendEmptyMessageDelayed(3, 6000L);
            }
        }
    }

    static /* synthetic */ void d(ILogProtocol iLogProtocol) {
        for (ValueCallback<Pair<Message, Message>> valueCallback : e.a(9)) {
            HashMap hashMap = new HashMap(4);
            hashMap.put(WPKFactory.INSTANCE_KEY_LOG_TYPE, iLogProtocol.getLogType());
            hashMap.put("log_data", iLogProtocol.generateString());
            hashMap.put("link_key", iLogProtocol.getLinkKey());
            hashMap.put("link_id", iLogProtocol.getLinkId());
            Message obtain = Message.obtain(null, 9, hashMap);
            Message obtain2 = Message.obtain();
            valueCallback.onReceiveValue(new Pair<>(obtain, obtain2));
            obtain.recycle();
            obtain2.recycle();
        }
    }

    private void e(final ILogProtocol iLogProtocol) {
        if (iLogProtocol == null) {
            return;
        }
        x53.a(new Runnable() { // from class: com.efs.sdk.base.a.d.a.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    iLogProtocol.insertGlobal(v43.C9807a.a().a);
                    if (!Constants.LOG_TYPE_WA.equalsIgnoreCase(iLogProtocol.getLogType())) {
                        C4786a.d(iLogProtocol);
                    }
                    if (C4786a.a().e) {
                        final j43 b = j43.b(iLogProtocol);
                        final C4796d a = C4796d.C4797a.a();
                        x53.a(new Runnable() { // from class: com.efs.sdk.base.a.g.d.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                a.a.b(b);
                            }
                        });
                    }
                } catch (Throwable th) {
                    w63.c(Constants.TAG, "log send error", th);
                }
            }
        });
    }

    public final void b(ILogProtocol iLogProtocol) {
        if (this.b) {
            e(iLogProtocol);
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.obj = iLogProtocol;
        this.d.sendMessage(obtain);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(@NonNull Message message) {
        String str;
        int i = message.what;
        if (i == 0) {
            v43 a = v43.C9807a.a();
            i43 i43Var = new i43();
            a.a = i43Var;
            i43Var.b("appid", e.a);
            int myPid = Process.myPid();
            a.a.b("pid", Integer.valueOf(myPid));
            a.a.b(IRequestConst.PS, j83.a(myPid));
            String a2 = k83.a(a.b);
            a.a.b("wid", a2);
            if (TextUtils.isEmpty(e.i)) {
                a.a.b("uid", a2);
            } else {
                a.a.b("uid", e.i);
            }
            i43 i43Var2 = a.a;
            u23.c();
            i43Var2.b("stime", Long.valueOf(u23.e() - Process.getElapsedCpuTime()));
            a.a.b("pkg", a.b.getPackageName());
            a.a.b("ver", g83.a(a.b));
            a.a.b("vcode", g83.b(a.b));
            a.a.b("sdk_ver", "1.3.1");
            a.a.b("brand", Build.getBRAND().toLowerCase());
            i43 i43Var3 = a.a;
            String model = Build.getMODEL();
            i43Var3.b("model", model == null ? "unknown" : model.replace(" ", "-").replace(JSMethod.NOT_SET, "-").toLowerCase());
            DisplayMetrics displayMetrics = a.b.getResources().getDisplayMetrics();
            a.a.b("dsp_w", Integer.valueOf(com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics)));
            a.a.b("dsp_h", Integer.valueOf(com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics)));
            a.a.b("fr", "android");
            a.a.b("rom", Build.VERSION.getRELEASE());
            a.a.b(C3834a.C3835a.a, Integer.valueOf(Build.VERSION.SDK_INT));
            a.a.b("lang", Locale.getDefault().getLanguage());
            a.a.b("tzone", TimeZone.getDefault().getID());
            a.a.b("net", m73.b(a.b));
            C4794f.C4795a.a();
            C4783c.a().h();
            c();
            n73 a3 = n73.C9462a.a();
            boolean z = e.j;
            a53 a53Var = a3.a;
            if (z) {
                a53Var.a = "https://gjapplog.ucweb.com/collect";
                str = "4ea4e41a3993";
            } else {
                a53Var.a = "https://applog.uc.cn/collect";
                str = "28ef1713347d";
            }
            a53Var.b = str;
            a3.b = this;
            a3.c.a = this;
            a3.d.a = this;
            this.b = true;
            HandlerC4788a.a().sendEmptyMessageDelayed(0, e.l);
            n73 a4 = n73.C9462a.a();
            if (a4.b != null && e.d) {
                a4.b.b(new o43("efs_core", "pvuv", a4.a.c));
            }
        } else if (i == 1) {
            Object obj = message.obj;
            if (obj != null && (obj instanceof ILogProtocol)) {
                e((ILogProtocol) obj);
            }
        } else if (i == 3) {
            c();
        }
        return true;
    }
}
