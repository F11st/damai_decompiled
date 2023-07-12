package tb;

import android.content.Context;
import com.alibaba.pictures.cornerstone.protocol.IInitProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class hb<T> {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private T a;
    private IInitProxy<T> b;
    private boolean c;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ hb f(hb hbVar, Object obj, IInitProxy iInitProxy, int i, Object obj2) {
        if (obj2 == null) {
            if ((i & 2) != 0) {
                iInitProxy = null;
            }
            return hbVar.e(obj, iInitProxy);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: registerImpl");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public T a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-513870161")) {
            return (T) ipChange.ipc$dispatch("-513870161", new Object[]{this});
        }
        if (this.a != null) {
            if (!d()) {
                ab1.INSTANCE.w(this + " 该服务需要初始化，但是此次调用时还没有被初始化");
                if (t6.INSTANCE.debugable()) {
                    StringBuilder sb = new StringBuilder("堆栈:\n");
                    Thread currentThread = Thread.currentThread();
                    b41.h(currentThread, "Thread.currentThread()");
                    StackTraceElement[] stackTrace = currentThread.getStackTrace();
                    b41.h(stackTrace, "Thread.currentThread().stackTrace");
                    ArrayList arrayList = new ArrayList(stackTrace.length);
                    for (StackTraceElement stackTraceElement : stackTrace) {
                        sb.append(stackTraceElement.toString());
                        sb.append(StringUtils.LF);
                        arrayList.add(sb);
                    }
                    ab1.INSTANCE.w("堆栈:" + ((Object) sb));
                }
            }
            try {
                return this.a;
            } catch (Exception e) {
                throw new RuntimeException(this + " 服务获取失败，类型不匹配！", e);
            }
        }
        throw new RuntimeException(this + " 该服务没有被注册,实例没有挂载生成!");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final T b() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "303326609") ? (T) ipChange.ipc$dispatch("303326609", new Object[]{this}) : this.a;
    }

    public final boolean c(@Nullable Context context) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "1210456508")) {
            return ((Boolean) ipChange.ipc$dispatch("1210456508", new Object[]{this, context})).booleanValue();
        }
        IInitProxy<T> iInitProxy = this.b;
        if (iInitProxy != null && iInitProxy.init(context, this)) {
            z = true;
        }
        this.c = z;
        return z;
    }

    public final boolean d() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1513498741") ? ((Boolean) ipChange.ipc$dispatch("-1513498741", new Object[]{this})).booleanValue() : this.b == null || this.c;
    }

    @NotNull
    public final hb<T> e(T t, @Nullable IInitProxy<T> iInitProxy) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1564930466")) {
            return (hb) ipChange.ipc$dispatch("1564930466", new Object[]{this, t, iInitProxy});
        }
        this.a = t;
        this.b = iInitProxy;
        return this;
    }
}
