package com.alibaba.pictures.bricks.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import java.lang.ref.WeakReference;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class AttachFrameLayout extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final C3563a Companion = new C3563a(null);
    @Nullable
    private static WeakReference<View> weakAttachView;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.bricks.view.AttachFrameLayout$a */
    /* loaded from: classes7.dex */
    public static final class C3563a {
        private static transient /* synthetic */ IpChange $ipChange;

        private C3563a() {
        }

        public /* synthetic */ C3563a(k50 k50Var) {
            this();
        }

        public final int a() {
            View view;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1125939106")) {
                return ((Integer) ipChange.ipc$dispatch("1125939106", new Object[]{this})).intValue();
            }
            WeakReference<View> b = b();
            if (b == null || (view = b.get()) == null) {
                return -10000;
            }
            return view.getTop();
        }

        @Nullable
        public final WeakReference<View> b() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "992307063") ? (WeakReference) ipChange.ipc$dispatch("992307063", new Object[]{this}) : AttachFrameLayout.weakAttachView;
        }

        public final void c(@Nullable WeakReference<View> weakReference) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "880645409")) {
                ipChange.ipc$dispatch("880645409", new Object[]{this, weakReference});
            } else {
                AttachFrameLayout.weakAttachView = weakReference;
            }
        }

        public final void d(boolean z, @NotNull View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-362630082")) {
                ipChange.ipc$dispatch("-362630082", new Object[]{this, Boolean.valueOf(z), view});
                return;
            }
            b41.i(view, "view");
            if (z) {
                c(new WeakReference<>(view));
                return;
            }
            WeakReference<View> b = b();
            if (b41.d(view, b != null ? b.get() : null)) {
                c(null);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AttachFrameLayout(@NotNull Context context) {
        this(context, null, 2, null);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    public /* synthetic */ AttachFrameLayout(Context context, AttributeSet attributeSet, int i, k50 k50Var) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2021950957")) {
            ipChange.ipc$dispatch("-2021950957", new Object[]{this});
            return;
        }
        super.onAttachedToWindow();
        Companion.d(true, this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1615763574")) {
            ipChange.ipc$dispatch("1615763574", new Object[]{this});
            return;
        }
        super.onDetachedFromWindow();
        Companion.d(false, this);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AttachFrameLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }
}
