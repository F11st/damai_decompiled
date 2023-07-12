package tb;

import android.widget.FrameLayout;
import cn.damai.common.app.base.BaseActivity;
import cn.damai.homepage.util.TickletBusinessUtil;
import cn.damai.homepage.util.window.PopupCallback;
import cn.damai.homepage.util.window.handle.MiddlePriortyHandle;
import cn.damai.homepage.util.window.handle.TopPriortyHandle;
import cn.damai.rank.view.WantSeePosterTips;
import com.alibaba.yymidservice.popup.popupcenter.PopupPriorityManager;
import com.alibaba.yymidservice.popup.popupcenter.view.PopupViewHandle;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public final class mt1 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    public static final String EVENT_BACK_TO_HOME = "backToHome";
    @NotNull
    public static final String EVENT_NO_USED_HOME = "noUsedHome";
    @NotNull
    public static final String EVENT_USED_HOME = "usedHome";
    @NotNull
    public static final String NEW_PERSON_POPUP = "MainActivity_dm_new_person_popup";
    @NotNull
    public static final String TAG = "PopupManager";
    @NotNull
    public static final String WANT_SEE_UPDATE = "MainActivity_wantSeeFloat";
    @JvmField
    public static boolean k;
    @JvmField
    public static boolean l;
    @NotNull
    private BaseActivity<?, ?> a;
    @NotNull
    private PopupPriorityManager b;
    @Nullable
    private TopPriortyHandle c;
    @Nullable
    private h81 d;
    @Nullable
    private MiddlePriortyHandle e;
    @Nullable
    private u31 f;
    @Nullable
    private TickletBusinessUtil g;
    @Nullable
    private FrameLayout h;
    @Nullable
    private WantSeePosterTips i;
    @Nullable
    private PopupCallback j;

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }
    }

    public mt1(@NotNull BaseActivity<?, ?> baseActivity) {
        b41.i(baseActivity, "cxt");
        this.a = baseActivity;
        this.b = new PopupPriorityManager(baseActivity);
    }

    private final void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1374332067")) {
            ipChange.ipc$dispatch("1374332067", new Object[]{this});
            return;
        }
        this.c = new TopPriortyHandle(this.a);
        this.e = new MiddlePriortyHandle(this.a);
        this.d = new h81(this.a);
        this.f = new u31(this.a);
        TopPriortyHandle topPriortyHandle = this.c;
        if (topPriortyHandle != null) {
            topPriortyHandle.l(this.g, this.h, this.j);
        }
        MiddlePriortyHandle middlePriortyHandle = this.e;
        if (middlePriortyHandle != null) {
            middlePriortyHandle.i(this.j, this.i);
        }
        u31 u31Var = this.f;
        if (u31Var == null) {
            return;
        }
        u31Var.c(this.j);
    }

    public final void a(@Nullable TickletBusinessUtil tickletBusinessUtil, @Nullable FrameLayout frameLayout, @Nullable WantSeePosterTips wantSeePosterTips, @Nullable PopupCallback popupCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "204181394")) {
            ipChange.ipc$dispatch("204181394", new Object[]{this, tickletBusinessUtil, frameLayout, wantSeePosterTips, popupCallback});
            return;
        }
        this.g = tickletBusinessUtil;
        this.h = frameLayout;
        this.i = wantSeePosterTips;
        this.j = popupCallback;
    }

    public final void b(@NotNull String str, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1300749929")) {
            ipChange.ipc$dispatch("-1300749929", new Object[]{this, str, Boolean.valueOf(z)});
            return;
        }
        b41.i(str, "eventType");
        cb1.b(TAG, "PopupManager 开始执行弹窗逻辑 fromStartToEnd");
        if (this.b.f()) {
            c();
            this.b.s(null);
            this.b.h(null);
            if (z) {
                this.b.n(this.c, this.e, this.d);
            } else {
                this.b.n(null, this.e, this.d);
            }
            this.b.o(this.f, PopupViewHandle.InterceptType.SAMEAPPEAR);
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            PopupPriorityManager.l(this.b, true, null, null, arrayList, null, null, 54, null);
            return;
        }
        cb1.b(TAG, "PopupManager 弹窗逻辑正在执行中 fromStartToEnd");
    }
}
