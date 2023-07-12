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
    public static final a Companion = new a(null);

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class a {
        private static transient /* synthetic */ IpChange $ipChange;

        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }

        public final boolean a(@Nullable State state) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1597417240") ? ((Boolean) ipChange.ipc$dispatch("1597417240", new Object[]{this, state})).booleanValue() : State.LOTTIE_SUCCESS == state || State.PIC_SUCCESS == state;
        }
    }
}
