package com.alibaba.pictures.responsive;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.C8177b;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k50;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class ResponsiveManager {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final C3625a Companion = new C3625a(null);
    @NotNull
    private static final Lazy<ResponsiveManager> b;
    @Nullable
    private IConfig a;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.responsive.ResponsiveManager$a */
    /* loaded from: classes7.dex */
    public static final class C3625a {
        private static transient /* synthetic */ IpChange $ipChange;

        private C3625a() {
        }

        public /* synthetic */ C3625a(k50 k50Var) {
            this();
        }

        @NotNull
        public final ResponsiveManager a() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1950756675") ? (ResponsiveManager) ipChange.ipc$dispatch("-1950756675", new Object[]{this}) : (ResponsiveManager) ResponsiveManager.b.getValue();
        }
    }

    static {
        Lazy<ResponsiveManager> a;
        a = C8177b.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0<ResponsiveManager>() { // from class: com.alibaba.pictures.responsive.ResponsiveManager$Companion$instance$2
            private static transient /* synthetic */ IpChange $ipChange;

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ResponsiveManager invoke() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "981764511") ? (ResponsiveManager) ipChange.ipc$dispatch("981764511", new Object[]{this}) : new ResponsiveManager();
            }
        });
        b = a;
    }

    @Nullable
    public final IConfig b() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1605571974") ? (IConfig) ipChange.ipc$dispatch("1605571974", new Object[]{this}) : this.a;
    }
}
