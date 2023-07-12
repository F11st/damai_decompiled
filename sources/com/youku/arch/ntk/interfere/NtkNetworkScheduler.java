package com.youku.arch.ntk.interfere;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.player.networkscheduler.INetworkScheduleInterface;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class NtkNetworkScheduler implements INetworkScheduleInterface {
    private static transient /* synthetic */ IpChange $ipChange;
    private Map<String, String> a;
    private Mode b;

    /* compiled from: Taobao */
    /* renamed from: com.youku.arch.ntk.interfere.NtkNetworkScheduler$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Mode.values().length];
            a = iArr;
            try {
                iArr[Mode.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Mode.LOCAL_DNS_FIRST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Mode.DOMAIN_MAPPING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public enum Mode {
        NONE,
        LOCAL_DNS_FIRST,
        DOMAIN_MAPPING
    }

    /* compiled from: Taobao */
    /* renamed from: com.youku.arch.ntk.interfere.NtkNetworkScheduler$a */
    /* loaded from: classes2.dex */
    private static class C7860a {
        private static final NtkNetworkScheduler a = new NtkNetworkScheduler(null);
    }

    private NtkNetworkScheduler() {
        this.a = new HashMap();
        this.b = Mode.NONE;
    }

    /* synthetic */ NtkNetworkScheduler(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static NtkNetworkScheduler a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1845021455") ? (NtkNetworkScheduler) ipChange.ipc$dispatch("-1845021455", new Object[0]) : C7860a.a;
    }

    public void a(Mode mode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-276529302")) {
            ipChange.ipc$dispatch("-276529302", new Object[]{this, mode});
        } else {
            this.b = mode;
        }
    }

    public void a(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-956471706")) {
            ipChange.ipc$dispatch("-956471706", new Object[]{this, str, str2});
        } else {
            this.a.put(str, str2);
        }
    }
}
