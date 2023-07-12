package com.alibaba.yymidservice.popup.popupcenter;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.yymidservice.popup.popupcenter.view.MiddlePriortyDefaultHandle;
import com.alibaba.yymidservice.popup.popupcenter.view.PopupViewHandle;
import com.alibaba.yymidservice.popup.request.PopupListener;
import com.alibaba.yymidservice.popup.request.bean.PopupResponseBean;
import io.flutter.wpkbridge.WPKFactory;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.C8234b;
import kotlinx.coroutines.C8690g;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.AbstractC9710ta;
import tb.b41;
import tb.cq1;
import tb.i23;
import tb.kt1;
import tb.lt1;
import tb.mt1;
import tb.nt1;
import tb.pt1;
import tb.wt2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class PopupPriorityManager {
    @NotNull
    private Activity a;
    @Nullable
    private PopupViewHandle b;
    @Nullable
    private PopupViewHandle c;
    @Nullable
    private MiddlePriortyDefaultHandle d;
    @Nullable
    private PopupViewHandle e;
    @NotNull
    private HashMap<String, PopupViewHandle> f;
    @NotNull
    private nt1<PopupResponseBean> g;
    @NotNull
    private nt1<JSONObject> h;
    @NotNull
    private nt1<JSONObject> i;
    @NotNull
    private AtomicBoolean j;

    public PopupPriorityManager(@NotNull Activity activity) {
        b41.i(activity, WPKFactory.INIT_KEY_CONTEXT);
        this.a = activity;
        this.f = new HashMap<>();
        this.g = new nt1<>();
        this.h = new nt1<>();
        this.i = new nt1<>();
        this.j = new AtomicBoolean(false);
    }

    private final Object e(PopupViewHandle popupViewHandle, Object obj, kt1 kt1Var, Continuation<? super wt2> continuation) {
        Object d;
        Object popHandle = popupViewHandle.popHandle(obj, kt1Var, continuation);
        d = C8234b.d();
        if (popHandle == d) {
            return popHandle;
        }
        kt1 kt1Var2 = (kt1) popHandle;
        return wt2.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0067, code lost:
        if (tb.b41.d(r11, r6) != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x009c, code lost:
        if (r6 != null) goto L14;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object g(tb.kt1 r11, kotlin.coroutines.Continuation<? super tb.kt1> r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof com.alibaba.yymidservice.popup.popupcenter.PopupPriorityManager$lastHandle$1
            if (r0 == 0) goto L13
            r0 = r12
            com.alibaba.yymidservice.popup.popupcenter.PopupPriorityManager$lastHandle$1 r0 = (com.alibaba.yymidservice.popup.popupcenter.PopupPriorityManager$lastHandle$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.alibaba.yymidservice.popup.popupcenter.PopupPriorityManager$lastHandle$1 r0 = new com.alibaba.yymidservice.popup.popupcenter.PopupPriorityManager$lastHandle$1
            r0.<init>(r10, r12)
        L18:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.C8233a.d()
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L45
            if (r2 == r5) goto L39
            if (r2 != r4) goto L31
            java.lang.Object r11 = r0.L$0
            com.alibaba.yymidservice.popup.popupcenter.PopupPriorityManager r11 = (com.alibaba.yymidservice.popup.popupcenter.PopupPriorityManager) r11
            tb.i32.b(r12)
            goto L98
        L31:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L39:
            java.lang.Object r11 = r0.L$1
            tb.kt1 r11 = (tb.kt1) r11
            java.lang.Object r2 = r0.L$0
            com.alibaba.yymidservice.popup.popupcenter.PopupPriorityManager r2 = (com.alibaba.yymidservice.popup.popupcenter.PopupPriorityManager) r2
            tb.i32.b(r12)
            goto L58
        L45:
            tb.i32.b(r12)
            tb.nt1<com.alibaba.fastjson.JSONObject> r12 = r10.i
            r0.L$0 = r10
            r0.L$1 = r11
            r0.label = r5
            java.lang.Object r12 = r12.a(r0)
            if (r12 != r1) goto L57
            return r1
        L57:
            r2 = r10
        L58:
            com.alibaba.fastjson.JSONObject r12 = (com.alibaba.fastjson.JSONObject) r12
            java.util.HashMap r5 = new java.util.HashMap
            r5.<init>()
            if (r11 == 0) goto L69
            tb.kt1$c r6 = tb.kt1.C9377c.INSTANCE
            boolean r7 = tb.b41.d(r11, r6)
            if (r7 == 0) goto La0
        L69:
            com.alibaba.yymidservice.popup.popupcenter.view.PopupViewHandle r6 = r2.e
            if (r6 == 0) goto L9e
            java.lang.String r7 = "head_task"
            java.lang.String r8 = "执行尾部任务"
            r5.put(r7, r8)
            android.app.Activity r7 = r2.a
            java.lang.Class r7 = r7.getClass()
            java.lang.String r7 = r7.getSimpleName()
            java.lang.String r8 = "mContent::class.java.simpleName"
            tb.b41.h(r7, r8)
            java.lang.String r8 = "popup"
            java.lang.String r9 = "lastHandle"
            tb.pt1.g(r7, r8, r9, r5)
            r0.L$0 = r2
            r0.L$1 = r3
            r0.label = r4
            java.lang.Object r12 = r6.popHandle(r12, r11, r0)
            if (r12 != r1) goto L97
            return r1
        L97:
            r11 = r2
        L98:
            r6 = r12
            tb.kt1 r6 = (tb.kt1) r6
            r2 = r11
            if (r6 != 0) goto La0
        L9e:
            tb.kt1$c r6 = tb.kt1.C9377c.INSTANCE
        La0:
            r2.e = r3
            tb.nt1 r11 = new tb.nt1
            r11.<init>()
            r2.i = r11
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.yymidservice.popup.popupcenter.PopupPriorityManager.g(tb.kt1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0183, code lost:
        if (tb.b41.d(r5, r7) != false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x01db, code lost:
        if (r7 == null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x01e2, code lost:
        r9 = r2;
        r2 = r11;
        r11 = r9;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x013c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0154 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0259 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:89:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object i(tb.kt1 r11, kotlin.coroutines.Continuation<? super tb.kt1> r12) {
        /*
            Method dump skipped, instructions count: 630
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.yymidservice.popup.popupcenter.PopupPriorityManager.i(tb.kt1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ void l(PopupPriorityManager popupPriorityManager, boolean z, String str, String str2, ArrayList arrayList, JSONObject jSONObject, PopupListener popupListener, int i, Object obj) {
        if ((i & 2) != 0) {
            str = lt1.Companion.a().e();
        }
        popupPriorityManager.k(z, str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : arrayList, (i & 16) != 0 ? null : jSONObject, (i & 32) != 0 ? null : popupListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m() {
        this.j.set(false);
        this.f.clear();
    }

    public static /* synthetic */ void q(PopupPriorityManager popupPriorityManager, String str, String str2, ArrayList arrayList, JSONObject jSONObject, PopupListener popupListener, int i, Object obj) {
        if ((i & 1) != 0) {
            str = lt1.Companion.a().e();
        }
        popupPriorityManager.p(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : arrayList, (i & 8) != 0 ? null : jSONObject, (i & 16) == 0 ? popupListener : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object r(kotlin.coroutines.Continuation<? super tb.kt1> r11) {
        /*
            r10 = this;
            boolean r0 = r11 instanceof com.alibaba.yymidservice.popup.popupcenter.PopupPriorityManager$topHandle$1
            if (r0 == 0) goto L13
            r0 = r11
            com.alibaba.yymidservice.popup.popupcenter.PopupPriorityManager$topHandle$1 r0 = (com.alibaba.yymidservice.popup.popupcenter.PopupPriorityManager$topHandle$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.alibaba.yymidservice.popup.popupcenter.PopupPriorityManager$topHandle$1 r0 = new com.alibaba.yymidservice.popup.popupcenter.PopupPriorityManager$topHandle$1
            r0.<init>(r10, r11)
        L18:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.C8233a.d()
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L41
            if (r2 == r5) goto L39
            if (r2 != r4) goto L31
            java.lang.Object r0 = r0.L$0
            com.alibaba.yymidservice.popup.popupcenter.PopupPriorityManager r0 = (com.alibaba.yymidservice.popup.popupcenter.PopupPriorityManager) r0
            tb.i32.b(r11)
            goto L86
        L31:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L39:
            java.lang.Object r2 = r0.L$0
            com.alibaba.yymidservice.popup.popupcenter.PopupPriorityManager r2 = (com.alibaba.yymidservice.popup.popupcenter.PopupPriorityManager) r2
            tb.i32.b(r11)
            goto L52
        L41:
            tb.i32.b(r11)
            tb.nt1<com.alibaba.fastjson.JSONObject> r11 = r10.h
            r0.L$0 = r10
            r0.label = r5
            java.lang.Object r11 = r11.a(r0)
            if (r11 != r1) goto L51
            return r1
        L51:
            r2 = r10
        L52:
            com.alibaba.fastjson.JSONObject r11 = (com.alibaba.fastjson.JSONObject) r11
            java.util.HashMap r5 = new java.util.HashMap
            r5.<init>()
            com.alibaba.yymidservice.popup.popupcenter.view.PopupViewHandle r6 = r2.b
            if (r6 == 0) goto L8b
            java.lang.String r7 = "head_task"
            java.lang.String r8 = "执行头部任务"
            r5.put(r7, r8)
            android.app.Activity r7 = r2.a
            java.lang.Class r7 = r7.getClass()
            java.lang.String r7 = r7.getSimpleName()
            java.lang.String r8 = "mContent::class.java.simpleName"
            tb.b41.h(r7, r8)
            java.lang.String r8 = "popup"
            java.lang.String r9 = "topHandle"
            tb.pt1.g(r7, r8, r9, r5)
            r0.L$0 = r2
            r0.label = r4
            java.lang.Object r11 = r6.popHandle(r11, r3, r0)
            if (r11 != r1) goto L85
            return r1
        L85:
            r0 = r2
        L86:
            tb.kt1 r11 = (tb.kt1) r11
            if (r11 != 0) goto L8e
            r2 = r0
        L8b:
            tb.kt1$c r11 = tb.kt1.C9377c.INSTANCE
            r0 = r2
        L8e:
            r0.b = r3
            tb.nt1 r1 = new tb.nt1
            r1.<init>()
            r0.h = r1
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.yymidservice.popup.popupcenter.PopupPriorityManager.r(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final boolean f() {
        return !this.j.get();
    }

    public final void h(@Nullable JSONObject jSONObject) {
        i23.INSTANCE.a(mt1.TAG, "lastTriggerNotify");
        this.i.b(jSONObject);
    }

    public final void j(@Nullable PopupResponseBean popupResponseBean) {
        i23.INSTANCE.a(mt1.TAG, "middleTriggerNotify");
        this.g.b(popupResponseBean);
    }

    public final void k(boolean z, @NotNull String str, @Nullable String str2, @Nullable ArrayList<String> arrayList, @Nullable JSONObject jSONObject, @Nullable PopupListener popupListener) {
        b41.i(str, "comboCityId");
        if (this.j.compareAndSet(false, true)) {
            i23 i23Var = i23.INSTANCE;
            i23Var.a(mt1.TAG, "PopupPriorityManager 开始执行弹窗逻辑 fromStartToEnd=true");
            Activity activity = this.a;
            if (activity != null) {
                if (activity instanceof FragmentActivity) {
                    if (z) {
                        q(this, str, str2, arrayList, jSONObject, null, 16, null);
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("isPopRequest", z ? "true" : "false");
                    String simpleName = this.a.getClass().getSimpleName();
                    b41.h(simpleName, "mContent::class.java.simpleName");
                    pt1.g(simpleName, AgooConstants.MESSAGE_POPUP, "start", hashMap);
                    this.d = new MiddlePriortyDefaultHandle(activity);
                    C8690g.b(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) activity), null, null, new PopupPriorityManager$popupLaunch$1$1(this, null), 3, null);
                    return;
                }
                i23Var.a(mt1.TAG, "PopupPriorityManager 弹窗逻辑非FragmentActivity fromStartToEnd 设置false");
                m();
                return;
            }
            return;
        }
        i23.INSTANCE.a(mt1.TAG, "弹窗逻辑正在执行中 fromStartToEnd");
    }

    public final void n(@Nullable PopupViewHandle popupViewHandle, @Nullable PopupViewHandle popupViewHandle2, @Nullable PopupViewHandle popupViewHandle3) {
        i23.INSTANCE.a(mt1.TAG, "setHandleViewHandle");
        this.b = popupViewHandle;
        this.c = popupViewHandle2;
        this.e = popupViewHandle3;
    }

    public final void o(@Nullable PopupViewHandle popupViewHandle, @NotNull PopupViewHandle.InterceptType interceptType) {
        b41.i(interceptType, "type");
        i23 i23Var = i23.INSTANCE;
        i23Var.a(mt1.TAG, "setInterceptHandle 并且InterceptType=" + interceptType);
        if (popupViewHandle != null) {
            popupViewHandle.b(interceptType);
            this.f.put(interceptType.toString(), popupViewHandle);
        }
    }

    public final void p(@NotNull String str, @Nullable String str2, @Nullable ArrayList<String> arrayList, @Nullable JSONObject jSONObject, @Nullable PopupListener popupListener) {
        b41.i(str, "comboCityId");
        i23.INSTANCE.a(mt1.TAG, "startRequest");
        cq1 cq1Var = new cq1();
        cq1Var.d(this);
        cq1Var.c(new WeakReference<>(this.a));
        AbstractC9710ta.f(cq1Var, str, str2, arrayList, jSONObject, null, 16, null);
    }

    public final void s(@Nullable JSONObject jSONObject) {
        i23.INSTANCE.a(mt1.TAG, "topTriggerNotify");
        this.h.b(jSONObject);
    }
}
