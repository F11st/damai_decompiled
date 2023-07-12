package com.alibaba.yymidservice.popup.popupcenter.view;

import android.app.Activity;
import io.flutter.wpkbridge.WPKFactory;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class MiddlePriortyDefaultHandle extends PopupViewHandle {
    @NotNull
    private Activity b;

    public MiddlePriortyDefaultHandle(@NotNull Activity activity) {
        b41.i(activity, WPKFactory.INIT_KEY_CONTEXT);
        this.b = activity;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    @Override // com.alibaba.yymidservice.popup.popupcenter.view.PopupViewHandleCallback
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <T, K> java.lang.Object popHandle(@org.jetbrains.annotations.Nullable T r5, @org.jetbrains.annotations.Nullable K r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super tb.kt1> r7) {
        /*
            r4 = this;
            boolean r6 = r7 instanceof com.alibaba.yymidservice.popup.popupcenter.view.MiddlePriortyDefaultHandle$popHandle$1
            if (r6 == 0) goto L13
            r6 = r7
            com.alibaba.yymidservice.popup.popupcenter.view.MiddlePriortyDefaultHandle$popHandle$1 r6 = (com.alibaba.yymidservice.popup.popupcenter.view.MiddlePriortyDefaultHandle$popHandle$1) r6
            int r0 = r6.label
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r0 & r1
            if (r2 == 0) goto L13
            int r0 = r0 - r1
            r6.label = r0
            goto L18
        L13:
            com.alibaba.yymidservice.popup.popupcenter.view.MiddlePriortyDefaultHandle$popHandle$1 r6 = new com.alibaba.yymidservice.popup.popupcenter.view.MiddlePriortyDefaultHandle$popHandle$1
            r6.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.a.d()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L3c
            if (r1 == r3) goto L38
            if (r1 != r2) goto L30
            java.lang.Object r5 = r6.L$0
            com.alibaba.yymidservice.popup.popupcenter.view.MiddlePriortyDefaultHandle$popHandle$1 r5 = (com.alibaba.yymidservice.popup.popupcenter.view.MiddlePriortyDefaultHandle$popHandle$1) r5
            tb.i32.b(r7)
            goto L80
        L30:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L38:
            tb.i32.b(r7)
            goto L54
        L3c:
            tb.i32.b(r7)
            boolean r7 = r5 instanceof com.alibaba.yymidservice.popup.request.bean.PopupResponseBean
            if (r7 == 0) goto L46
            com.alibaba.yymidservice.popup.request.bean.PopupResponseBean r5 = (com.alibaba.yymidservice.popup.request.bean.PopupResponseBean) r5
            goto L47
        L46:
            r5 = 0
        L47:
            if (r5 == 0) goto L58
            android.app.Activity r7 = r4.b
            r6.label = r3
            java.lang.Object r7 = com.alibaba.yymidservice.popup.popupcenter.view.PopupDialogKt.a(r7, r5, r6)
            if (r7 != r0) goto L54
            return r0
        L54:
            tb.kt1 r7 = (tb.kt1) r7
            if (r7 != 0) goto L82
        L58:
            r6.L$0 = r6
            r6.label = r2
            tb.o52 r5 = new tb.o52
            kotlin.coroutines.Continuation r7 = kotlin.coroutines.intrinsics.a.c(r6)
            r5.<init>(r7)
            kotlin.Result$a r7 = kotlin.Result.Companion
            tb.kt1$c r7 = tb.kt1.c.INSTANCE
            java.lang.Object r7 = kotlin.Result.m1271constructorimpl(r7)
            r5.resumeWith(r7)
            java.lang.Object r7 = r5.a()
            java.lang.Object r5 = kotlin.coroutines.intrinsics.a.d()
            if (r7 != r5) goto L7d
            tb.n40.c(r6)
        L7d:
            if (r7 != r0) goto L80
            return r0
        L80:
            tb.kt1 r7 = (tb.kt1) r7
        L82:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.yymidservice.popup.popupcenter.view.MiddlePriortyDefaultHandle.popHandle(java.lang.Object, java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
