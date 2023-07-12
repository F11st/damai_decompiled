package tb;

import com.alibaba.pictures.dolores.cache.ICacheDataFilter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class bf {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final C8960a Companion = new C8960a(null);
    @Nullable
    private String a;
    private long b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    @Nullable
    private ICacheDataFilter g;

    /* compiled from: Taobao */
    /* renamed from: tb.bf$a */
    /* loaded from: classes7.dex */
    public static final class C8960a {
        private static transient /* synthetic */ IpChange $ipChange;

        private C8960a() {
        }

        public /* synthetic */ C8960a(k50 k50Var) {
            this();
        }
    }

    @Nullable
    public final String a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1309908018") ? (String) ipChange.ipc$dispatch("1309908018", new Object[]{this}) : this.a;
    }

    public final long b() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-595811455") ? ((Long) ipChange.ipc$dispatch("-595811455", new Object[]{this})).longValue() : this.b;
    }

    public final boolean c() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "143462676") ? ((Boolean) ipChange.ipc$dispatch("143462676", new Object[]{this})).booleanValue() : this.f;
    }

    public final boolean d() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1334269150") ? ((Boolean) ipChange.ipc$dispatch("1334269150", new Object[]{this})).booleanValue() : this.d;
    }

    public final boolean e() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "486948725") ? ((Boolean) ipChange.ipc$dispatch("486948725", new Object[]{this})).booleanValue() : this.e;
    }

    @Nullable
    public final ICacheDataFilter f() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-806162411") ? (ICacheDataFilter) ipChange.ipc$dispatch("-806162411", new Object[]{this}) : this.g;
    }

    public final boolean g() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "324617109") ? ((Boolean) ipChange.ipc$dispatch("324617109", new Object[]{this})).booleanValue() : this.c;
    }
}
