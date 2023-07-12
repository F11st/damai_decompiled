package com.alibaba.pictures.dolores.time;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import com.alibaba.pictures.dolores.request.DoloresRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.uc.webview.export.extension.UCCore;
import io.flutter.wpkbridge.WPKFactory;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$LongRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.dc0;
import tb.rb0;
import tb.rq;
import tb.wt2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class TimeSyncer {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final TimeSyncer INSTANCE = new TimeSyncer();
    private static final String a;
    private static final AtomicBoolean b;
    private static long c;
    private static final AppTimeChangeReceiver d;
    private static boolean e;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/alibaba/pictures/dolores/time/TimeSyncer$AppTimeChangeReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "dolores_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes7.dex */
    public static final class AppTimeChangeReceiver extends BroadcastReceiver {
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.content.BroadcastReceiver
        public void onReceive(@NotNull Context context, @NotNull Intent intent) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2116163874")) {
                ipChange.ipc$dispatch("-2116163874", new Object[]{this, context, intent});
                return;
            }
            b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
            b41.i(intent, CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
            TimeSyncer timeSyncer = TimeSyncer.INSTANCE;
            String b = TimeSyncer.b(timeSyncer);
            rq.a(b, "onReceive " + intent.getAction());
            TimeSyncer.d(timeSyncer).set(false);
            timeSyncer.f();
        }
    }

    static {
        String simpleName = TimeSyncer.class.getSimpleName();
        b41.h(simpleName, "TimeSyncer::class.java.simpleName");
        a = simpleName;
        b = new AtomicBoolean(false);
        d = new AppTimeChangeReceiver();
    }

    private TimeSyncer() {
    }

    public static final /* synthetic */ String b(TimeSyncer timeSyncer) {
        return a;
    }

    public static final /* synthetic */ AtomicBoolean d(TimeSyncer timeSyncer) {
        return b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1175741835")) {
            ipChange.ipc$dispatch("1175741835", new Object[]{this});
            return;
        }
        rq.a(a, "sync time start ...");
        b.set(true);
        final Ref$LongRef ref$LongRef = new Ref$LongRef();
        ref$LongRef.element = System.currentTimeMillis();
        rb0.Companion.b(new SyncTimeRequest()).a().doOnKTStart(new Function1<DoloresRequest<SyncTimeResponse>, wt2>() { // from class: com.alibaba.pictures.dolores.time.TimeSyncer$asyncTime$1
            private static transient /* synthetic */ IpChange $ipChange;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ wt2 invoke(DoloresRequest<SyncTimeResponse> doloresRequest) {
                invoke2(doloresRequest);
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable DoloresRequest<SyncTimeResponse> doloresRequest) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-657713570")) {
                    ipChange2.ipc$dispatch("-657713570", new Object[]{this, doloresRequest});
                    return;
                }
                String b2 = TimeSyncer.b(TimeSyncer.INSTANCE);
                rq.a(b2, "prepareTime=" + (System.currentTimeMillis() - Ref$LongRef.this.element));
                Ref$LongRef.this.element = System.currentTimeMillis();
            }
        }).doOnKTSuccess(new Function1<SyncTimeResponse, wt2>() { // from class: com.alibaba.pictures.dolores.time.TimeSyncer$asyncTime$2
            private static transient /* synthetic */ IpChange $ipChange;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ wt2 invoke(SyncTimeResponse syncTimeResponse) {
                invoke2(syncTimeResponse);
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull SyncTimeResponse syncTimeResponse) {
                long j;
                IpChange ipChange2 = $ipChange;
                boolean z = true;
                if (AndroidInstantRuntime.support(ipChange2, "-1320046325")) {
                    ipChange2.ipc$dispatch("-1320046325", new Object[]{this, syncTimeResponse});
                    return;
                }
                b41.i(syncTimeResponse, "bizResponse");
                try {
                    long currentTimeMillis = (System.currentTimeMillis() - Ref$LongRef.this.element) >> 1;
                    String t = syncTimeResponse.getT();
                    if (t != null) {
                        if (t.length() <= 0) {
                            z = false;
                        }
                        if (!z) {
                            t = null;
                        }
                        if (t != null) {
                            TimeSyncer timeSyncer = TimeSyncer.INSTANCE;
                            TimeSyncer.c = (Long.parseLong(t) + currentTimeMillis) - System.currentTimeMillis();
                            if (currentTimeMillis > 500) {
                                TimeSyncer.d(timeSyncer).set(false);
                            }
                            String b2 = TimeSyncer.b(timeSyncer);
                            StringBuilder sb = new StringBuilder();
                            sb.append("sync time success timeDiff=");
                            j = TimeSyncer.c;
                            sb.append(j);
                            rq.a(b2, sb.toString());
                            return;
                        }
                    }
                    TimeSyncer timeSyncer2 = TimeSyncer.INSTANCE;
                    rq.a(TimeSyncer.b(timeSyncer2), "sync time fail resp or resp.t is null");
                    TimeSyncer.d(timeSyncer2).set(false);
                    wt2 wt2Var = wt2.INSTANCE;
                } catch (Exception e2) {
                    TimeSyncer timeSyncer3 = TimeSyncer.INSTANCE;
                    String b3 = TimeSyncer.b(timeSyncer3);
                    rq.a(b3, "sync time fail " + e2.getMessage());
                    TimeSyncer.d(timeSyncer3).set(false);
                }
            }
        }).doOnKTFail(new Function1<dc0<SyncTimeResponse>, wt2>() { // from class: com.alibaba.pictures.dolores.time.TimeSyncer$asyncTime$3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ wt2 invoke(dc0<SyncTimeResponse> dc0Var) {
                invoke2(dc0Var);
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull dc0<SyncTimeResponse> dc0Var) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-92285548")) {
                    ipChange2.ipc$dispatch("-92285548", new Object[]{this, dc0Var});
                    return;
                }
                b41.i(dc0Var, AdvanceSetting.NETWORK_TYPE);
                TimeSyncer timeSyncer = TimeSyncer.INSTANCE;
                rq.a(TimeSyncer.b(timeSyncer), "sync time return fail");
                TimeSyncer.d(timeSyncer).set(false);
            }
        });
    }

    private final void i(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-189605327")) {
            ipChange.ipc$dispatch("-189605327", new Object[]{this, context});
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.DATE_CHANGED");
        intentFilter.addAction("android.intent.action.TIME_SET");
        if (context != null) {
            context.registerReceiver(d, intentFilter);
        }
    }

    public final long g() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "899598519") ? ((Long) ipChange.ipc$dispatch("899598519", new Object[]{this})).longValue() : System.currentTimeMillis() + c;
    }

    public final void h(@Nullable Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1794158686")) {
            ipChange.ipc$dispatch("-1794158686", new Object[]{this, context});
        } else if (e) {
            Log.d(a, "has init = true,return");
        } else {
            Log.d(a, UCCore.LEGACY_EVENT_INIT);
            i(context);
            e = true;
        }
    }

    public final void j() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1894495445")) {
            ipChange.ipc$dispatch("-1894495445", new Object[]{this});
        } else if (b.get()) {
        } else {
            rq.a(a, "syncTime");
            f();
        }
    }
}
