package com.youku.arch.probe.plugins;

import android.content.Context;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public abstract class BasePlugin {
    public static String a = "BasePlugin";
    protected Context b;
    private boolean c;
    private volatile a d;

    /* compiled from: Taobao */
    /* renamed from: com.youku.arch.probe.plugins.BasePlugin$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass1 implements Runnable {
        private static transient /* synthetic */ IpChange $ipChange;

        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1410553310")) {
                ipChange.ipc$dispatch("1410553310", new Object[]{this});
                return;
            }
            while (BasePlugin.this.c) {
                try {
                    try {
                        int i = AnonymousClass2.a[BasePlugin.this.d.a.ordinal()];
                        if (i == 1) {
                            synchronized (BasePlugin.this.d) {
                                BasePlugin.this.d.wait();
                            }
                        } else if (i == 2) {
                            BasePlugin basePlugin = BasePlugin.this;
                            basePlugin.a(basePlugin.d.a);
                            synchronized (BasePlugin.this.d) {
                                BasePlugin.this.d.wait();
                            }
                        } else if (i == 3) {
                            BasePlugin basePlugin2 = BasePlugin.this;
                            basePlugin2.a(basePlugin2.d.a);
                            synchronized (BasePlugin.this.d) {
                                BasePlugin.this.d.wait(BasePlugin.this.d.b);
                            }
                        } else if (i == 4) {
                            BasePlugin.this.c = false;
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } finally {
                    BasePlugin.this.a();
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.youku.arch.probe.plugins.BasePlugin$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[NotiType.values().length];
            a = iArr;
            try {
                iArr[NotiType.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[NotiType.ONCE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[NotiType.LOOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[NotiType.CANCEL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    protected enum NotiType {
        IDLE,
        ONCE,
        LOOP,
        CANCEL
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    private static class a {
        public NotiType a;
        public long b;
    }

    public abstract com.youku.arch.analysis.net.a a(com.youku.arch.analysis.net.a aVar);

    public abstract void a();

    public abstract void a(NotiType notiType);
}
