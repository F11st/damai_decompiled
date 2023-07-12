package com.alibaba.pictures.responsive.state;

import android.content.Context;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import java.util.HashMap;
import kotlin.C8177b;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.c32;
import tb.k50;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class ResponsivePageStateCache {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final C3627a Companion = new C3627a(null);
    @NotNull
    private static final HashMap<Integer, c32> a = new HashMap<>();
    @NotNull
    private static final Lazy<ResponsivePageStateCache> b;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.responsive.state.ResponsivePageStateCache$a */
    /* loaded from: classes7.dex */
    public static final class C3627a {
        private static transient /* synthetic */ IpChange $ipChange;

        private C3627a() {
        }

        public /* synthetic */ C3627a(k50 k50Var) {
            this();
        }

        @NotNull
        public final ResponsivePageStateCache a() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-825988061") ? (ResponsivePageStateCache) ipChange.ipc$dispatch("-825988061", new Object[]{this}) : (ResponsivePageStateCache) ResponsivePageStateCache.b.getValue();
        }
    }

    static {
        Lazy<ResponsivePageStateCache> a2;
        a2 = C8177b.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0<ResponsivePageStateCache>() { // from class: com.alibaba.pictures.responsive.state.ResponsivePageStateCache$Companion$instance$2
            private static transient /* synthetic */ IpChange $ipChange;

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ResponsivePageStateCache invoke() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "-826521919") ? (ResponsivePageStateCache) ipChange.ipc$dispatch("-826521919", new Object[]{this}) : new ResponsivePageStateCache();
            }
        });
        b = a2;
    }

    public final void b(@NotNull Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1698169755")) {
            ipChange.ipc$dispatch("-1698169755", new Object[]{this, context});
            return;
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        a.remove(Integer.valueOf(context.hashCode()));
    }

    public final int c(@NotNull Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "780832584")) {
            return ((Integer) ipChange.ipc$dispatch("780832584", new Object[]{this, context})).intValue();
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        int hashCode = context.hashCode();
        HashMap<Integer, c32> hashMap = a;
        c32 c32Var = hashMap.get(Integer.valueOf(hashCode));
        if (c32Var == null) {
            c32Var = new c32();
            hashMap.put(Integer.valueOf(hashCode), c32Var);
        }
        return c32Var.a();
    }

    public final int d(@NotNull Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "704124457")) {
            return ((Integer) ipChange.ipc$dispatch("704124457", new Object[]{this, context})).intValue();
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        int hashCode = context.hashCode();
        HashMap<Integer, c32> hashMap = a;
        c32 c32Var = hashMap.get(Integer.valueOf(hashCode));
        if (c32Var == null) {
            c32Var = new c32();
            hashMap.put(Integer.valueOf(hashCode), c32Var);
        }
        return c32Var.b();
    }

    public final int e(@NotNull Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1068552616")) {
            return ((Integer) ipChange.ipc$dispatch("-1068552616", new Object[]{this, context})).intValue();
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        int hashCode = context.hashCode();
        HashMap<Integer, c32> hashMap = a;
        c32 c32Var = hashMap.get(Integer.valueOf(hashCode));
        if (c32Var == null) {
            c32Var = new c32();
            hashMap.put(Integer.valueOf(hashCode), c32Var);
        }
        return c32Var.c();
    }

    public final int f(@Nullable Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1817621137")) {
            return ((Integer) ipChange.ipc$dispatch("-1817621137", new Object[]{this, context})).intValue();
        }
        if (context == null) {
            return 1000;
        }
        int hashCode = context.hashCode();
        HashMap<Integer, c32> hashMap = a;
        c32 c32Var = hashMap.get(Integer.valueOf(hashCode));
        if (c32Var == null) {
            c32Var = new c32();
            hashMap.put(Integer.valueOf(hashCode), c32Var);
        }
        return c32Var.d();
    }

    public final void g(@NotNull Context context, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1602779133")) {
            ipChange.ipc$dispatch("-1602779133", new Object[]{this, context, Integer.valueOf(i)});
            return;
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        int hashCode = context.hashCode();
        HashMap<Integer, c32> hashMap = a;
        c32 c32Var = hashMap.get(Integer.valueOf(hashCode));
        if (c32Var == null) {
            c32Var = new c32();
            hashMap.put(Integer.valueOf(hashCode), c32Var);
        }
        c32Var.e(i);
    }

    public final void h(@NotNull Context context, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1251741678")) {
            ipChange.ipc$dispatch("1251741678", new Object[]{this, context, Integer.valueOf(i)});
            return;
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        int hashCode = context.hashCode();
        HashMap<Integer, c32> hashMap = a;
        c32 c32Var = hashMap.get(Integer.valueOf(hashCode));
        if (c32Var == null) {
            c32Var = new c32();
            hashMap.put(Integer.valueOf(hashCode), c32Var);
        }
        c32Var.f(i);
    }

    public final void i(@NotNull Context context, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1495781907")) {
            ipChange.ipc$dispatch("-1495781907", new Object[]{this, context, Integer.valueOf(i)});
            return;
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        int hashCode = context.hashCode();
        HashMap<Integer, c32> hashMap = a;
        c32 c32Var = hashMap.get(Integer.valueOf(hashCode));
        if (c32Var == null) {
            c32Var = new c32();
            hashMap.put(Integer.valueOf(hashCode), c32Var);
        }
        c32Var.g(i);
    }

    public final void j(@Nullable Context context, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2143213805")) {
            ipChange.ipc$dispatch("-2143213805", new Object[]{this, context, Integer.valueOf(i)});
        } else if (context == null) {
        } else {
            int hashCode = context.hashCode();
            HashMap<Integer, c32> hashMap = a;
            c32 c32Var = hashMap.get(Integer.valueOf(hashCode));
            if (c32Var == null) {
                c32Var = new c32();
                hashMap.put(Integer.valueOf(hashCode), c32Var);
            }
            c32Var.h(i);
        }
    }
}
