package tb;

import com.alibaba.pictures.dolores.DoloresKernel;
import com.alibaba.pictures.dolores.business.AsyncResult;
import com.alibaba.pictures.dolores.preload.PreloadState;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class iu1<T> {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private DoloresKernel<T> a;
    @Nullable
    private AsyncResult<T> b;
    private long c;
    @NotNull
    private PreloadState d = PreloadState.STATE_INIT;
    @Nullable
    private T e;
    @Nullable
    private dc0<T> f;
    @Nullable
    private final DoloresKernel<T> g;

    public iu1(@Nullable DoloresKernel<T> doloresKernel) {
        this.g = doloresKernel;
    }

    public final void a(@NotNull DoloresKernel<T> doloresKernel, @NotNull AsyncResult<T> asyncResult) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-739804760")) {
            ipChange.ipc$dispatch("-739804760", new Object[]{this, doloresKernel, asyncResult});
            return;
        }
        b41.i(doloresKernel, "bindKernel");
        b41.i(asyncResult, "asyncResult");
        this.a = doloresKernel;
        this.b = asyncResult;
    }

    @Nullable
    public final AsyncResult<T> b() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1287093290") ? (AsyncResult) ipChange.ipc$dispatch("-1287093290", new Object[]{this}) : this.b;
    }

    @Nullable
    public final DoloresKernel<T> c() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-898987587") ? (DoloresKernel) ipChange.ipc$dispatch("-898987587", new Object[]{this}) : this.a;
    }

    @Nullable
    public final T d() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-4800451") ? (T) ipChange.ipc$dispatch("-4800451", new Object[]{this}) : this.e;
    }

    public final long e() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "995751005") ? ((Long) ipChange.ipc$dispatch("995751005", new Object[]{this})).longValue() : this.c;
    }

    @Nullable
    public final DoloresKernel<T> f() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "224114225") ? (DoloresKernel) ipChange.ipc$dispatch("224114225", new Object[]{this}) : this.g;
    }

    @Nullable
    public final dc0<T> g() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "255391501") ? (dc0) ipChange.ipc$dispatch("255391501", new Object[]{this}) : this.f;
    }

    @NotNull
    public final PreloadState h() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1558947453") ? (PreloadState) ipChange.ipc$dispatch("1558947453", new Object[]{this}) : this.d;
    }

    public final void i(@Nullable T t) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1709819843")) {
            ipChange.ipc$dispatch("-1709819843", new Object[]{this, t});
        } else {
            this.e = t;
        }
    }

    public final void j(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-136611961")) {
            ipChange.ipc$dispatch("-136611961", new Object[]{this, Long.valueOf(j)});
        } else {
            this.c = j;
        }
    }

    public final void k(@Nullable dc0<T> dc0Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1944159619")) {
            ipChange.ipc$dispatch("1944159619", new Object[]{this, dc0Var});
        } else {
            this.f = dc0Var;
        }
    }

    public final void l(@NotNull PreloadState preloadState) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1099525279")) {
            ipChange.ipc$dispatch("-1099525279", new Object[]{this, preloadState});
            return;
        }
        b41.i(preloadState, "<set-?>");
        this.d = preloadState;
    }

    public final void m(@Nullable Long l) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-929994973")) {
            ipChange.ipc$dispatch("-929994973", new Object[]{this, l});
        }
    }
}
