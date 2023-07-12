package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class rm {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final rm DEFAULT = new C9657b().e(3000).d();
    public static final int DURATION_INFINITE = -1;
    public static final int DURATION_LONG = 5000;
    public static final int DURATION_SHORT = 3000;
    final int a;
    final int b;
    final int c;

    /* compiled from: Taobao */
    /* renamed from: tb.rm$b */
    /* loaded from: classes4.dex */
    public static class C9657b {
        private static transient /* synthetic */ IpChange $ipChange;
        private int a = 3000;
        private int b = 0;
        private int c = 0;

        public rm d() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "497408257") ? (rm) ipChange.ipc$dispatch("497408257", new Object[]{this}) : new rm(this);
        }

        public C9657b e(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1823940573")) {
                return (C9657b) ipChange.ipc$dispatch("1823940573", new Object[]{this, Integer.valueOf(i)});
            }
            this.a = i;
            return this;
        }
    }

    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "683049235")) {
            return (String) ipChange.ipc$dispatch("683049235", new Object[]{this});
        }
        return "Configuration{durationInMilliseconds=" + this.a + ", inAnimationResId=" + this.b + ", outAnimationResId=" + this.c + '}';
    }

    private rm(C9657b c9657b) {
        this.a = c9657b.a;
        this.b = c9657b.b;
        this.c = c9657b.c;
    }
}
