package com.alibaba.pictures.responsive.page.orientation;

import android.app.Activity;
import android.view.OrientationEventListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k50;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class OrientationListener extends OrientationEventListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final C3626a Companion = new C3626a(null);
    public static final int ORIENTATION_LANDSCAPE = 1002;
    public static final int ORIENTATION_PORTRAIT = 1001;
    public static final int ORIENTATION_REVERSE_LANDSCAPE = 1003;
    public static final int ORIENTATION_REVERSE_PORTRAIT = 1004;
    public static final int UN_KNOWN = 1000;
    @Nullable
    private OrientationChangeCallback a;
    private int b;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0002H&¨\u0006\u0007"}, d2 = {"Lcom/alibaba/pictures/responsive/page/orientation/OrientationListener$OrientationChangeCallback;", "", "Ltb/wt2;", "port", "land", "reverseLand", "reversePort", "app_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes7.dex */
    public interface OrientationChangeCallback {
        void land();

        void port();

        void reverseLand();

        void reversePort();
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.responsive.page.orientation.OrientationListener$a */
    /* loaded from: classes7.dex */
    public static final class C3626a {
        private C3626a() {
        }

        public /* synthetic */ C3626a(k50 k50Var) {
            this();
        }
    }

    public OrientationListener(@Nullable Activity activity, @Nullable OrientationChangeCallback orientationChangeCallback) {
        super(activity, 3);
        this.b = 1000;
        this.a = orientationChangeCallback;
    }

    public final void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "263938802")) {
            ipChange.ipc$dispatch("263938802", new Object[]{this});
            return;
        }
        disable();
        this.b = 1000;
    }

    public final void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1503388443")) {
            ipChange.ipc$dispatch("-1503388443", new Object[]{this});
        } else if (canDetectOrientation()) {
            enable();
        }
    }

    public final void c(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "532609390")) {
            ipChange.ipc$dispatch("532609390", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.b = i;
        }
    }

    @Override // android.view.OrientationEventListener
    public void onOrientationChanged(int i) {
        OrientationChangeCallback orientationChangeCallback;
        OrientationChangeCallback orientationChangeCallback2;
        OrientationChangeCallback orientationChangeCallback3;
        OrientationChangeCallback orientationChangeCallback4;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "2020310442")) {
            ipChange.ipc$dispatch("2020310442", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        if (!(i >= 0 && i <= 30)) {
            if (!(330 <= i && i <= 360)) {
                if (60 <= i && i <= 120) {
                    if (this.b != 1003 && (orientationChangeCallback4 = this.a) != null) {
                        orientationChangeCallback4.reverseLand();
                    }
                    this.b = 1003;
                    return;
                }
                if (150 <= i && i <= 210) {
                    if (this.b != 1004 && (orientationChangeCallback3 = this.a) != null) {
                        orientationChangeCallback3.reversePort();
                    }
                    this.b = 1004;
                    return;
                }
                if ((240 > i || i > 300) ? false : false) {
                    if (this.b != 1002 && (orientationChangeCallback2 = this.a) != null) {
                        orientationChangeCallback2.land();
                    }
                    this.b = 1002;
                    return;
                }
                return;
            }
        }
        if (this.b != 1001 && (orientationChangeCallback = this.a) != null) {
            orientationChangeCallback.port();
        }
        this.b = 1001;
    }
}
