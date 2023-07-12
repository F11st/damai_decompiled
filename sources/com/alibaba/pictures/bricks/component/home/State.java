package com.alibaba.pictures.bricks.component.home;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k50;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public enum State {
    NONE,
    INIT,
    LOTTIE_SUCCESS,
    PIC_SUCCESS,
    INVALID;
    
    @NotNull
    public static final C3462a Companion = new C3462a(null);

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.bricks.component.home.State$a */
    /* loaded from: classes7.dex */
    public static final class C3462a {
        private static transient /* synthetic */ IpChange $ipChange;

        private C3462a() {
        }

        public /* synthetic */ C3462a(k50 k50Var) {
            this();
        }

        public final boolean a(@Nullable State state) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1597417240") ? ((Boolean) ipChange.ipc$dispatch("1597417240", new Object[]{this, state})).booleanValue() : State.LOTTIE_SUCCESS == state || State.PIC_SUCCESS == state;
        }
    }
}
