package com.alibaba.yymidservice.popup.popupcenter.view;

import android.app.Activity;
import android.content.DialogInterface;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.yymidservice.popup.popupcenter.view.PicDialog;
import com.alibaba.yymidservice.popup.request.bean.PopupDetailBean;
import com.alient.gaiax.container.gaiax.PictureGaiaXEventProvider;
import com.taobao.weex.WXGlobalEventReceiver;
import com.youku.gaiax.api.data.EventParams;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.C8234b;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.kt1;
import tb.lt1;
import tb.n40;
import tb.o52;
import tb.pt1;
import tb.ws2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class PopupDialogKt {

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.yymidservice.popup.popupcenter.view.PopupDialogKt$a */
    /* loaded from: classes8.dex */
    public static final class C4030a extends PictureGaiaXEventProvider {
        final /* synthetic */ PicDialog a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C4030a(Activity activity, PicDialog picDialog) {
            super(activity);
            this.a = picDialog;
        }

        @Override // com.alient.gaiax.container.gaiax.PictureGaiaXEventProvider, com.alient.gaiax.container.gaiax.PictureGaiaXDelegate
        public void onGaiaXEvent(@NotNull EventParams eventParams, @Nullable JSONObject jSONObject, int i) {
            b41.i(eventParams, WXGlobalEventReceiver.EVENT_PARAMS);
            this.a.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.yymidservice.popup.popupcenter.view.PopupDialogKt$b */
    /* loaded from: classes8.dex */
    public static final class DialogInterface$OnDismissListenerC4031b implements DialogInterface.OnDismissListener {
        final /* synthetic */ PopupDetailBean a;
        final /* synthetic */ Activity b;
        final /* synthetic */ Continuation<kt1> c;

        /* JADX WARN: Multi-variable type inference failed */
        DialogInterface$OnDismissListenerC4031b(PopupDetailBean popupDetailBean, Activity activity, Continuation<? super kt1> continuation) {
            this.a = popupDetailBean;
            this.b = activity;
            this.c = continuation;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            if (this.a.needReport) {
                lt1.C9421a c9421a = lt1.Companion;
                c9421a.a().q(this.b, c9421a.a().e(), this.a.pkId, null);
            }
            Continuation<kt1> continuation = this.c;
            Result.C8174a c8174a = Result.Companion;
            continuation.resumeWith(Result.m1271constructorimpl(kt1.C9377c.INSTANCE));
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.yymidservice.popup.popupcenter.view.PopupDialogKt$c */
    /* loaded from: classes8.dex */
    public static final class C4032c implements PicDialog.OnDialogShowTimeListener {
        final /* synthetic */ ws2 a;
        final /* synthetic */ Map<String, JSONObject> b;

        /* JADX WARN: Multi-variable type inference failed */
        C4032c(ws2 ws2Var, Map<String, ? extends JSONObject> map) {
            this.a = ws2Var;
            this.b = map;
        }

        @Override // com.alibaba.yymidservice.popup.popupcenter.view.PicDialog.OnDialogShowTimeListener
        public void exposureTime(long j) {
            this.a.exposureUt(j, null, this.b, true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object a(@org.jetbrains.annotations.NotNull android.app.Activity r5, @org.jetbrains.annotations.Nullable com.alibaba.yymidservice.popup.request.bean.PopupResponseBean r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super tb.kt1> r7) {
        /*
            boolean r0 = r7 instanceof com.alibaba.yymidservice.popup.popupcenter.view.PopupDialogKt$showDialog$1
            if (r0 == 0) goto L13
            r0 = r7
            com.alibaba.yymidservice.popup.popupcenter.view.PopupDialogKt$showDialog$1 r0 = (com.alibaba.yymidservice.popup.popupcenter.view.PopupDialogKt$showDialog$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.alibaba.yymidservice.popup.popupcenter.view.PopupDialogKt$showDialog$1 r0 = new com.alibaba.yymidservice.popup.popupcenter.view.PopupDialogKt$showDialog$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.C8233a.d()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            tb.i32.b(r7)
            goto L5e
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            java.lang.Object r5 = r0.L$0
            android.app.Activity r5 = (android.app.Activity) r5
            tb.i32.b(r7)
            goto L4e
        L3c:
            tb.i32.b(r7)
            if (r6 == 0) goto L52
            java.util.ArrayList<com.alibaba.yymidservice.popup.request.bean.PopupDetailBean> r6 = r6.show
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r7 = b(r5, r6, r0)
            if (r7 != r1) goto L4e
            return r1
        L4e:
            tb.kt1 r7 = (tb.kt1) r7
            if (r7 != 0) goto L60
        L52:
            r6 = 0
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r7 = d(r5, r0)
            if (r7 != r1) goto L5e
            return r1
        L5e:
            tb.kt1 r7 = (tb.kt1) r7
        L60:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.yymidservice.popup.popupcenter.view.PopupDialogKt.a(android.app.Activity, com.alibaba.yymidservice.popup.request.bean.PopupResponseBean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final Object b(Activity activity, ArrayList<PopupDetailBean> arrayList, Continuation<? super kt1> continuation) {
        PopupDetailBean popupDetailBean;
        if (arrayList != null && arrayList.size() > 0 && (popupDetailBean = arrayList.get(0)) != null) {
            return c(activity, popupDetailBean, continuation);
        }
        return d(activity, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01c1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final java.lang.Object c(android.app.Activity r23, com.alibaba.yymidservice.popup.request.bean.PopupDetailBean r24, kotlin.coroutines.Continuation<? super tb.kt1> r25) {
        /*
            Method dump skipped, instructions count: 453
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.yymidservice.popup.popupcenter.view.PopupDialogKt.c(android.app.Activity, com.alibaba.yymidservice.popup.request.bean.PopupDetailBean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final Object d(Activity activity, Continuation<? super kt1> continuation) {
        Continuation c;
        Object d;
        HashMap hashMap = new HashMap();
        hashMap.put("msg", "数据不满足需求");
        String simpleName = activity.getClass().getSimpleName();
        b41.h(simpleName, "context::class.java.simpleName");
        pt1.g(simpleName, "popupDialog", "fail", hashMap);
        c = IntrinsicsKt__IntrinsicsJvmKt.c(continuation);
        o52 o52Var = new o52(c);
        Result.C8174a c8174a = Result.Companion;
        o52Var.resumeWith(Result.m1271constructorimpl(kt1.C9377c.INSTANCE));
        Object a = o52Var.a();
        d = C8234b.d();
        if (a == d) {
            n40.c(continuation);
        }
        return a;
    }
}
