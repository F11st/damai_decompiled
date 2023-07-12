package cn.damai.homepage.util.window.handle;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import cn.damai.common.app.base.BaseActivity;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.nav.DMNav;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.user.c;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.coupondialog.net.CouponListResponse;
import cn.damai.homepage.MainAlertEntity;
import cn.damai.homepage.R$string;
import cn.damai.homepage.bean.HomeWantSeeBean;
import cn.damai.homepage.bean.SetPrivacyPermissionBean;
import cn.damai.homepage.request.SetupPermissionListRequest;
import cn.damai.homepage.ui.view.HomepageEvaluateDialog;
import cn.damai.homepage.util.MemberGuideDialogManger;
import cn.damai.homepage.util.window.PopupCallback;
import cn.damai.homepage.util.window.UTHelperCallback;
import cn.damai.rank.view.WantSeePosterTips;
import cn.damai.uikit.util.DialogUtil;
import cn.damai.uikit.util.TDialog;
import cn.damai.uikit.view.DMProtocolDialog;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.yymidservice.popup.popupcenter.ut.UTHelperPopupCallback;
import com.alibaba.yymidservice.popup.popupcenter.view.PopupViewHandle;
import com.alibaba.yymidservice.popup.request.bean.PopupDetailBean;
import com.alibaba.yymidservice.popup.request.bean.PopupResponseBean;
import com.alimm.xadsdk.base.expose.MonitorType;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.d23;
import tb.kt1;
import tb.lt1;
import tb.m61;
import tb.mt1;
import tb.n40;
import tb.nk;
import tb.o52;
import tb.py0;
import tb.ws2;
import tb.ya0;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public final class MiddlePriortyHandle extends PopupViewHandle {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private BaseActivity<?, ?> b;
    @Nullable
    private WantSeePosterTips c;
    @Nullable
    private PopupCallback d;

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public static final class a implements DialogInterface.OnDismissListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Continuation<kt1> a;

        /* JADX WARN: Multi-variable type inference failed */
        a(Continuation<? super kt1> continuation) {
            this.a = continuation;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1219256782")) {
                ipChange.ipc$dispatch("-1219256782", new Object[]{this, dialogInterface});
                return;
            }
            Continuation<kt1> continuation = this.a;
            Result.a aVar = Result.Companion;
            continuation.resumeWith(Result.m1271constructorimpl(kt1.c.INSTANCE));
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public static final class b implements UTHelperCallback {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ws2 a;
        final /* synthetic */ Map<String, JSONObject> b;

        /* JADX WARN: Multi-variable type inference failed */
        b(ws2 ws2Var, Map<String, ? extends JSONObject> map) {
            this.a = ws2Var;
            this.b = map;
        }

        @Override // cn.damai.homepage.util.window.UTHelperCallback
        public void closeUt() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "497491354")) {
                ipChange.ipc$dispatch("497491354", new Object[]{this});
            } else {
                UTHelperPopupCallback.a.a(this.a, d23.f(), this.b, false, 4, null);
            }
        }

        @Override // cn.damai.homepage.util.window.UTHelperCallback
        public void confirmUt(@NotNull String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1311050780")) {
                ipChange.ipc$dispatch("1311050780", new Object[]{this, str});
                return;
            }
            b41.i(str, "content");
            this.a.confirmUt(d23.f(), this.b, true);
        }

        @Override // cn.damai.homepage.util.window.UTHelperCallback
        public void exposureUt(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "902076209")) {
                ipChange.ipc$dispatch("902076209", new Object[]{this, Long.valueOf(j)});
            } else {
                UTHelperPopupCallback.a.b(this.a, j, d23.f(), this.b, false, 8, null);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public static final class c implements UTHelperCallback {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ws2 a;
        final /* synthetic */ Map<String, JSONObject> b;

        /* JADX WARN: Multi-variable type inference failed */
        c(ws2 ws2Var, Map<String, ? extends JSONObject> map) {
            this.a = ws2Var;
            this.b = map;
        }

        @Override // cn.damai.homepage.util.window.UTHelperCallback
        public void closeUt() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-13042823")) {
                ipChange.ipc$dispatch("-13042823", new Object[]{this});
            } else {
                UTHelperPopupCallback.a.a(this.a, d23.f(), this.b, false, 4, null);
            }
        }

        @Override // cn.damai.homepage.util.window.UTHelperCallback
        public void confirmUt(@NotNull String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1033616261")) {
                ipChange.ipc$dispatch("-1033616261", new Object[]{this, str});
                return;
            }
            b41.i(str, "content");
            this.a.confirmUt(d23.f(), this.b, true);
        }

        @Override // cn.damai.homepage.util.window.UTHelperCallback
        public void exposureUt(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "493251984")) {
                ipChange.ipc$dispatch("493251984", new Object[]{this, Long.valueOf(j)});
            } else {
                UTHelperPopupCallback.a.b(this.a, j, d23.f(), this.b, false, 8, null);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public static final class d implements MemberGuideDialogManger.IMemberDialogDispatcher {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Continuation<kt1> b;

        /* compiled from: Taobao */
        /* loaded from: classes14.dex */
        public static final class a implements DialogInterface.OnDismissListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ Continuation<kt1> a;

            /* JADX WARN: Multi-variable type inference failed */
            a(Continuation<? super kt1> continuation) {
                this.a = continuation;
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1992916676")) {
                    ipChange.ipc$dispatch("1992916676", new Object[]{this, dialogInterface});
                    return;
                }
                Continuation<kt1> continuation = this.a;
                Result.a aVar = Result.Companion;
                continuation.resumeWith(Result.m1271constructorimpl(kt1.c.INSTANCE));
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        d(Continuation<? super kt1> continuation) {
            this.b = continuation;
        }

        @Override // cn.damai.homepage.util.MemberGuideDialogManger.IMemberDialogDispatcher
        public final void dialogToShow(Dialog dialog) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "3960873")) {
                ipChange.ipc$dispatch("3960873", new Object[]{this, dialog});
                return;
            }
            dialog.setOnDismissListener(new a(this.b));
            if (!MiddlePriortyHandle.this.b.isFinishing()) {
                dialog.show();
                return;
            }
            Continuation<kt1> continuation = this.b;
            Result.a aVar = Result.Companion;
            continuation.resumeWith(Result.m1271constructorimpl(kt1.c.INSTANCE));
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public static final class e implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Continuation<kt1> a;

        /* JADX WARN: Multi-variable type inference failed */
        e(Continuation<? super kt1> continuation) {
            this.a = continuation;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public final void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "351610111")) {
                ipChange.ipc$dispatch("351610111", new Object[]{this, dVar});
                return;
            }
            Continuation<kt1> continuation = this.a;
            Result.a aVar = Result.Companion;
            continuation.resumeWith(Result.m1271constructorimpl(kt1.c.INSTANCE));
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public static final class f implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Ref$ObjectRef<Dialog> b;
        final /* synthetic */ boolean c;
        final /* synthetic */ String d;
        final /* synthetic */ Continuation<kt1> e;
        final /* synthetic */ MainAlertEntity.MainAlertModel f;
        final /* synthetic */ Map<String, JSONObject> g;
        final /* synthetic */ ws2 h;
        final /* synthetic */ MainAlertEntity i;

        /* compiled from: Taobao */
        /* loaded from: classes14.dex */
        public static final class a implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ MainAlertEntity.MainAlertModel a;
            final /* synthetic */ MiddlePriortyHandle b;
            final /* synthetic */ Map<String, JSONObject> c;
            final /* synthetic */ Ref$ObjectRef<Dialog> d;
            final /* synthetic */ ws2 e;
            final /* synthetic */ MainAlertEntity f;

            /* JADX WARN: Multi-variable type inference failed */
            a(MainAlertEntity.MainAlertModel mainAlertModel, MiddlePriortyHandle middlePriortyHandle, Map<String, ? extends JSONObject> map, Ref$ObjectRef<Dialog> ref$ObjectRef, ws2 ws2Var, MainAlertEntity mainAlertEntity) {
                this.a = mainAlertModel;
                this.b = middlePriortyHandle;
                this.c = map;
                this.d = ref$ObjectRef;
                this.e = ws2Var;
                this.f = mainAlertEntity;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "2048369883")) {
                    ipChange.ipc$dispatch("2048369883", new Object[]{this, view});
                    return;
                }
                if (this.a != null) {
                    Bundle bundle = new Bundle();
                    bundle.putBoolean(MonitorType.SKIP, true);
                    bundle.putString("from_page", "homepage");
                    DMNav.from(this.b.b).withExtras(bundle).toUri(this.a.schema);
                    boolean d = b41.d(MainAlertEntity.PICK_TYPE_CALLBACK, this.a.pkType);
                    Map<String, JSONObject> map = this.c;
                    if (map != null) {
                        this.e.confirmUt(d23.f(), map, true);
                    } else {
                        MainAlertEntity.MainAlertModel mainAlertModel = this.a;
                        MainAlertEntity mainAlertEntity = this.f;
                        if (d) {
                            cn.damai.common.user.c.e().x(py0.I().z(String.valueOf(mainAlertModel.circleId), "0", 0, mainAlertModel.imageUrl));
                        } else {
                            cn.damai.common.user.c.e().x(py0.I().y(mainAlertModel.schema, mainAlertModel.scm, mainAlertEntity.id, String.valueOf(mainAlertModel.circleId), mainAlertModel.imageUrl));
                        }
                    }
                }
                Dialog dialog = this.d.element;
                if (dialog != null) {
                    dialog.dismiss();
                }
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes14.dex */
        public static final class b implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ Ref$ObjectRef<Dialog> a;
            final /* synthetic */ MainAlertEntity.MainAlertModel b;
            final /* synthetic */ Map<String, JSONObject> c;
            final /* synthetic */ ws2 d;

            /* JADX WARN: Multi-variable type inference failed */
            b(Ref$ObjectRef<Dialog> ref$ObjectRef, MainAlertEntity.MainAlertModel mainAlertModel, Map<String, ? extends JSONObject> map, ws2 ws2Var) {
                this.a = ref$ObjectRef;
                this.b = mainAlertModel;
                this.c = map;
                this.d = ws2Var;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-135307044")) {
                    ipChange.ipc$dispatch("-135307044", new Object[]{this, view});
                } else if (this.a.element == null || !b41.d(MainAlertEntity.PICK_TYPE_CALLBACK, this.b.pkType)) {
                } else {
                    Map<String, JSONObject> map = this.c;
                    if (map != null) {
                        UTHelperPopupCallback.a.a(this.d, d23.f(), map, false, 4, null);
                        return;
                    }
                    MainAlertEntity.MainAlertModel mainAlertModel = this.b;
                    cn.damai.common.user.c.e().x(py0.I().z(String.valueOf(mainAlertModel.circleId), "0", 1, mainAlertModel.imageUrl));
                }
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes5.dex */
        public static final class c implements TDialog.OnDialogShowTimeListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ Map<String, JSONObject> a;
            final /* synthetic */ ws2 b;
            final /* synthetic */ MainAlertEntity.MainAlertModel c;

            /* JADX WARN: Multi-variable type inference failed */
            c(Map<String, ? extends JSONObject> map, ws2 ws2Var, MainAlertEntity.MainAlertModel mainAlertModel) {
                this.a = map;
                this.b = ws2Var;
                this.c = mainAlertModel;
            }

            @Override // cn.damai.uikit.util.TDialog.OnDialogShowTimeListener
            public final void exposureTime(long j) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "2119512972")) {
                    ipChange.ipc$dispatch("2119512972", new Object[]{this, Long.valueOf(j)});
                    return;
                }
                Map<String, JSONObject> map = this.a;
                if (map != null) {
                    UTHelperPopupCallback.a.b(this.b, j, d23.f(), map, false, 8, null);
                    return;
                }
                MainAlertEntity.MainAlertModel mainAlertModel = this.c;
                if (b41.d(MainAlertEntity.PICK_TYPE_CALLBACK, mainAlertModel.pkType)) {
                    py0.p(j, mainAlertModel.schema, String.valueOf(mainAlertModel.circleId), "0", mainAlertModel.imageUrl);
                } else {
                    py0.o(j, mainAlertModel.schema, mainAlertModel.scm, mainAlertModel.imageUrl);
                }
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes14.dex */
        public static final class d implements DialogInterface.OnDismissListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ Continuation<kt1> a;

            /* JADX WARN: Multi-variable type inference failed */
            d(Continuation<? super kt1> continuation) {
                this.a = continuation;
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-319958220")) {
                    ipChange.ipc$dispatch("-319958220", new Object[]{this, dialogInterface});
                    return;
                }
                Continuation<kt1> continuation = this.a;
                Result.a aVar = Result.Companion;
                continuation.resumeWith(Result.m1271constructorimpl(kt1.c.INSTANCE));
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        f(Ref$ObjectRef<Dialog> ref$ObjectRef, boolean z, String str, Continuation<? super kt1> continuation, MainAlertEntity.MainAlertModel mainAlertModel, Map<String, ? extends JSONObject> map, ws2 ws2Var, MainAlertEntity mainAlertEntity) {
            this.b = ref$ObjectRef;
            this.c = z;
            this.d = str;
            this.e = continuation;
            this.f = mainAlertModel;
            this.g = map;
            this.h = ws2Var;
            this.i = mainAlertEntity;
        }

        /* JADX WARN: Type inference failed for: r11v3, types: [T, android.app.Dialog] */
        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public final void onSuccess(DMImageCreator.e eVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-352117932")) {
                ipChange.ipc$dispatch("-352117932", new Object[]{this, eVar});
            } else if (!MiddlePriortyHandle.this.b.isActivityFinsihed() && MiddlePriortyHandle.this.b.isActivityForeground() && eVar.b != null) {
                this.b.element = DialogUtil.a(MiddlePriortyHandle.this.b, eVar.b, new a(this.f, MiddlePriortyHandle.this, this.g, this.b, this.h, this.i), new b(this.b, this.f, this.g, this.h), new c(this.g, this.h, this.f));
                Dialog dialog = this.b.element;
                if (dialog != null) {
                    dialog.setOnDismissListener(new d(this.e));
                }
                if (!MiddlePriortyHandle.this.b.isFinishing()) {
                    Dialog dialog2 = this.b.element;
                    if (dialog2 != null) {
                        dialog2.show();
                    }
                    if (!this.c || TextUtils.isEmpty(this.d)) {
                        return;
                    }
                    MiddlePriortyHandle.this.h(this.d);
                    return;
                }
                Continuation<kt1> continuation = this.e;
                Result.a aVar = Result.Companion;
                continuation.resumeWith(Result.m1271constructorimpl(kt1.c.INSTANCE));
            } else {
                Continuation<kt1> continuation2 = this.e;
                Result.a aVar2 = Result.Companion;
                continuation2.resumeWith(Result.m1271constructorimpl(kt1.c.INSTANCE));
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public static final class g implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Continuation<kt1> a;

        /* JADX WARN: Multi-variable type inference failed */
        g(Continuation<? super kt1> continuation) {
            this.a = continuation;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public final void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1252707684")) {
                ipChange.ipc$dispatch("-1252707684", new Object[]{this, dVar});
                return;
            }
            Continuation<kt1> continuation = this.a;
            Result.a aVar = Result.Companion;
            continuation.resumeWith(Result.m1271constructorimpl(kt1.c.INSTANCE));
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public static final class h implements UTHelperCallback {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ws2 a;
        final /* synthetic */ Map<String, JSONObject> b;

        /* JADX WARN: Multi-variable type inference failed */
        h(ws2 ws2Var, Map<String, ? extends JSONObject> map) {
            this.a = ws2Var;
            this.b = map;
        }

        @Override // cn.damai.homepage.util.window.UTHelperCallback
        public void closeUt() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-656878881")) {
                ipChange.ipc$dispatch("-656878881", new Object[]{this});
            } else {
                UTHelperPopupCallback.a.a(this.a, d23.f(), this.b, false, 4, null);
            }
        }

        @Override // cn.damai.homepage.util.window.UTHelperCallback
        public void confirmUt(@NotNull String str) {
            boolean s;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "295988449")) {
                ipChange.ipc$dispatch("295988449", new Object[]{this, str});
                return;
            }
            b41.i(str, "score");
            HashMap<String, String> f = d23.f();
            s = o.s(str);
            if (!s) {
                b41.h(f, "map");
                f.put("titlelabel", str);
            }
            this.a.confirmUt(f, this.b, true);
        }

        @Override // cn.damai.homepage.util.window.UTHelperCallback
        public void exposureUt(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-354409994")) {
                ipChange.ipc$dispatch("-354409994", new Object[]{this, Long.valueOf(j)});
            } else {
                UTHelperPopupCallback.a.b(this.a, j, d23.f(), this.b, false, 8, null);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public static final class i implements HomepageEvaluateDialog.OnUserRejectListener {
        private static transient /* synthetic */ IpChange $ipChange;

        i() {
        }

        @Override // cn.damai.homepage.ui.view.HomepageEvaluateDialog.OnUserRejectListener
        public final void onUserReject(CouponListResponse.ContentList contentList) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1223165888")) {
                ipChange.ipc$dispatch("1223165888", new Object[]{this, contentList});
                return;
            }
            PopupCallback popupCallback = MiddlePriortyHandle.this.d;
            if (popupCallback != null) {
                String str = contentList.targetId;
                b41.h(str, "data.targetId");
                popupCallback.evaluateOnUserReject(str);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public static final class j implements DialogInterface.OnDismissListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Continuation<kt1> a;

        /* JADX WARN: Multi-variable type inference failed */
        j(Continuation<? super kt1> continuation) {
            this.a = continuation;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-438180872")) {
                ipChange.ipc$dispatch("-438180872", new Object[]{this, dialogInterface});
                return;
            }
            Continuation<kt1> continuation = this.a;
            Result.a aVar = Result.Companion;
            continuation.resumeWith(Result.m1271constructorimpl(kt1.c.INSTANCE));
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public static final class k implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Continuation<kt1> a;

        /* JADX WARN: Multi-variable type inference failed */
        k(Continuation<? super kt1> continuation) {
            this.a = continuation;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public final void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1090597406")) {
                ipChange.ipc$dispatch("-1090597406", new Object[]{this, dVar});
                return;
            }
            Continuation<kt1> continuation = this.a;
            Result.a aVar = Result.Companion;
            continuation.resumeWith(Result.m1271constructorimpl(kt1.c.INSTANCE));
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public static final class l implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Ref$ObjectRef<Dialog> b;
        final /* synthetic */ boolean c;
        final /* synthetic */ String d;
        final /* synthetic */ Continuation<kt1> e;
        final /* synthetic */ MainAlertEntity.MainAlertModel f;
        final /* synthetic */ Map<String, JSONObject> g;
        final /* synthetic */ ws2 h;

        /* compiled from: Taobao */
        /* loaded from: classes14.dex */
        public static final class a implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ MainAlertEntity.MainAlertModel a;
            final /* synthetic */ MiddlePriortyHandle b;
            final /* synthetic */ Map<String, JSONObject> c;
            final /* synthetic */ Ref$ObjectRef<Dialog> d;
            final /* synthetic */ ws2 e;

            /* JADX WARN: Multi-variable type inference failed */
            a(MainAlertEntity.MainAlertModel mainAlertModel, MiddlePriortyHandle middlePriortyHandle, Map<String, ? extends JSONObject> map, Ref$ObjectRef<Dialog> ref$ObjectRef, ws2 ws2Var) {
                this.a = mainAlertModel;
                this.b = middlePriortyHandle;
                this.c = map;
                this.d = ref$ObjectRef;
                this.e = ws2Var;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1569006462")) {
                    ipChange.ipc$dispatch("1569006462", new Object[]{this, view});
                    return;
                }
                if (this.a != null) {
                    Bundle bundle = new Bundle();
                    bundle.putBoolean(MonitorType.SKIP, true);
                    bundle.putString("from_page", "homepage");
                    DMNav.from(this.b.b).withExtras(bundle).toUri(this.a.schema);
                    Map<String, JSONObject> map = this.c;
                    if (map != null) {
                        this.e.confirmUt(d23.f(), map, true);
                    }
                }
                Dialog dialog = this.d.element;
                if (dialog != null) {
                    dialog.dismiss();
                }
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes14.dex */
        public static final class b implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ Ref$ObjectRef<Dialog> a;
            final /* synthetic */ Map<String, JSONObject> b;
            final /* synthetic */ ws2 c;

            /* JADX WARN: Multi-variable type inference failed */
            b(Ref$ObjectRef<Dialog> ref$ObjectRef, Map<String, ? extends JSONObject> map, ws2 ws2Var) {
                this.a = ref$ObjectRef;
                this.b = map;
                this.c = ws2Var;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Map<String, JSONObject> map;
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-614670465")) {
                    ipChange.ipc$dispatch("-614670465", new Object[]{this, view});
                } else if (this.a.element == null || (map = this.b) == null) {
                } else {
                    UTHelperPopupCallback.a.a(this.c, d23.f(), map, false, 4, null);
                }
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes5.dex */
        public static final class c implements TDialog.OnDialogShowTimeListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ Map<String, JSONObject> a;
            final /* synthetic */ ws2 b;

            /* JADX WARN: Multi-variable type inference failed */
            c(Map<String, ? extends JSONObject> map, ws2 ws2Var) {
                this.a = map;
                this.b = ws2Var;
            }

            @Override // cn.damai.uikit.util.TDialog.OnDialogShowTimeListener
            public final void exposureTime(long j) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1506781193")) {
                    ipChange.ipc$dispatch("1506781193", new Object[]{this, Long.valueOf(j)});
                    return;
                }
                Map<String, JSONObject> map = this.a;
                if (map != null) {
                    UTHelperPopupCallback.a.b(this.b, j, d23.f(), map, false, 8, null);
                }
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes14.dex */
        public static final class d implements DialogInterface.OnDismissListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ Continuation<kt1> a;

            /* JADX WARN: Multi-variable type inference failed */
            d(Continuation<? super kt1> continuation) {
                this.a = continuation;
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1304931287")) {
                    ipChange.ipc$dispatch("1304931287", new Object[]{this, dialogInterface});
                    return;
                }
                Continuation<kt1> continuation = this.a;
                Result.a aVar = Result.Companion;
                continuation.resumeWith(Result.m1271constructorimpl(kt1.c.INSTANCE));
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        l(Ref$ObjectRef<Dialog> ref$ObjectRef, boolean z, String str, Continuation<? super kt1> continuation, MainAlertEntity.MainAlertModel mainAlertModel, Map<String, ? extends JSONObject> map, ws2 ws2Var) {
            this.b = ref$ObjectRef;
            this.c = z;
            this.d = str;
            this.e = continuation;
            this.f = mainAlertModel;
            this.g = map;
            this.h = ws2Var;
        }

        /* JADX WARN: Type inference failed for: r10v3, types: [T, android.app.Dialog] */
        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public final void onSuccess(DMImageCreator.e eVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "693456375")) {
                ipChange.ipc$dispatch("693456375", new Object[]{this, eVar});
            } else if (!MiddlePriortyHandle.this.b.isActivityFinsihed() && MiddlePriortyHandle.this.b.isActivityForeground() && eVar.b != null) {
                this.b.element = DialogUtil.a(MiddlePriortyHandle.this.b, eVar.b, new a(this.f, MiddlePriortyHandle.this, this.g, this.b, this.h), new b(this.b, this.g, this.h), new c(this.g, this.h));
                Dialog dialog = this.b.element;
                if (dialog != null) {
                    dialog.setOnDismissListener(new d(this.e));
                }
                if (!MiddlePriortyHandle.this.b.isFinishing()) {
                    Dialog dialog2 = this.b.element;
                    if (dialog2 != null) {
                        dialog2.show();
                    }
                    if (!this.c || TextUtils.isEmpty(this.d)) {
                        return;
                    }
                    MiddlePriortyHandle.this.h(this.d);
                    return;
                }
                Continuation<kt1> continuation = this.e;
                Result.a aVar = Result.Companion;
                continuation.resumeWith(Result.m1271constructorimpl(kt1.c.INSTANCE));
            } else {
                Continuation<kt1> continuation2 = this.e;
                Result.a aVar2 = Result.Companion;
                continuation2.resumeWith(Result.m1271constructorimpl(kt1.c.INSTANCE));
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public static final class m implements WantSeePosterTips.ActionListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ boolean a;
        final /* synthetic */ String b;
        final /* synthetic */ MiddlePriortyHandle c;
        final /* synthetic */ ws2 d;
        final /* synthetic */ Map<String, JSONObject> e;
        final /* synthetic */ Continuation<kt1> f;

        /* JADX WARN: Multi-variable type inference failed */
        m(boolean z, String str, MiddlePriortyHandle middlePriortyHandle, ws2 ws2Var, Map<String, ? extends JSONObject> map, Continuation<? super kt1> continuation) {
            this.a = z;
            this.b = str;
            this.c = middlePriortyHandle;
            this.d = ws2Var;
            this.e = map;
            this.f = continuation;
        }

        @Override // cn.damai.rank.view.WantSeePosterTips.ActionListener
        public void click() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1436706143")) {
                ipChange.ipc$dispatch("-1436706143", new Object[]{this});
                return;
            }
            HashMap<String, String> f = d23.f();
            b41.h(f, "getUserCodeAndCityMap()");
            this.d.confirmUt(f, this.e, true);
        }

        @Override // cn.damai.rank.view.WantSeePosterTips.ActionListener
        public void hide(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "176605157")) {
                ipChange.ipc$dispatch("176605157", new Object[]{this, Long.valueOf(j)});
                return;
            }
            if (this.a && !TextUtils.isEmpty(this.b)) {
                this.c.h(this.b);
            }
            HashMap<String, String> f = d23.f();
            b41.h(f, "getUserCodeAndCityMap()");
            UTHelperPopupCallback.a.b(this.d, j, f, this.e, false, 8, null);
            try {
                Continuation<kt1> continuation = this.f;
                Result.a aVar = Result.Companion;
                continuation.resumeWith(Result.m1271constructorimpl(kt1.c.INSTANCE));
            } catch (Exception e) {
                System.out.println((Object) ("suspendCoroutine 执行失败 返回异常：" + e));
            }
        }
    }

    public MiddlePriortyHandle(@NotNull BaseActivity<?, ?> baseActivity) {
        b41.i(baseActivity, "mContext");
        this.b = baseActivity;
    }

    private final Object f(ArrayList<PopupDetailBean> arrayList, Continuation<? super kt1> continuation) {
        Continuation c2;
        Object d2;
        Continuation c3;
        Object d3;
        JSONObject jSONObject;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1724858914")) {
            return ipChange.ipc$dispatch("1724858914", new Object[]{this, arrayList, continuation});
        }
        if (arrayList != null && arrayList.size() > 0) {
            PopupDetailBean popupDetailBean = arrayList.get(0);
            if (popupDetailBean != null) {
                PopupDetailBean.PopupItem popupItem = popupDetailBean.item;
                Object obj = (popupItem == null || (jSONObject = popupItem.value) == null) ? null : jSONObject.get("action");
                Map<String, ? extends JSONObject> map = obj instanceof Map ? (Map) obj : null;
                String str = popupDetailBean.sceneType + '_' + popupDetailBean.eventType;
                if (b41.d(str, mt1.WANT_SEE_UPDATE)) {
                    PopupDetailBean.PopupItem popupItem2 = popupDetailBean.item;
                    return o(HomeWantSeeBean.getValidBean(popupItem2 != null ? popupItem2.value : null), popupDetailBean.pkId, popupDetailBean.needReport, map, continuation);
                } else if (b41.d(str, mt1.NEW_PERSON_POPUP)) {
                    PopupDetailBean.PopupItem popupItem3 = popupDetailBean.item;
                    MainAlertEntity.MainAlertModel mainAlertModel = (MainAlertEntity.MainAlertModel) m61.d(popupItem3 != null ? popupItem3.value : null, MainAlertEntity.MainAlertModel.class);
                    b41.h(mainAlertModel, "validBean");
                    return n(mainAlertModel, popupDetailBean.pkId, popupDetailBean.needReport, map, continuation);
                } else {
                    PopupDetailBean.PopupItem popupItem4 = popupDetailBean.item;
                    MainAlertEntity mainAlertEntity = (MainAlertEntity) m61.d(popupItem4 != null ? popupItem4.value : null, MainAlertEntity.class);
                    if (mainAlertEntity != null) {
                        if (b41.d("3", mainAlertEntity.type)) {
                            CouponListResponse.ContentList contentList = mainAlertEntity.content;
                            b41.h(contentList, "alertEntity.content");
                            return m(contentList, map, continuation);
                        } else if (!b41.d("4", mainAlertEntity.type) && !b41.d("6", mainAlertEntity.type) && !b41.d("5", mainAlertEntity.type)) {
                            return k(mainAlertEntity, popupDetailBean.pkId, popupDetailBean.needReport, map, continuation);
                        } else {
                            return g(mainAlertEntity, map, continuation);
                        }
                    }
                }
            }
            c3 = IntrinsicsKt__IntrinsicsJvmKt.c(continuation);
            o52 o52Var = new o52(c3);
            Result.a aVar = Result.Companion;
            o52Var.resumeWith(Result.m1271constructorimpl(kt1.c.INSTANCE));
            Object a2 = o52Var.a();
            d3 = kotlin.coroutines.intrinsics.b.d();
            if (a2 == d3) {
                n40.c(continuation);
            }
            return a2;
        }
        c2 = IntrinsicsKt__IntrinsicsJvmKt.c(continuation);
        o52 o52Var2 = new o52(c2);
        Result.a aVar2 = Result.Companion;
        o52Var2.resumeWith(Result.m1271constructorimpl(kt1.c.INSTANCE));
        Object a3 = o52Var2.a();
        d2 = kotlin.coroutines.intrinsics.b.d();
        if (a3 == d2) {
            n40.c(continuation);
        }
        return a3;
    }

    private final Object g(MainAlertEntity mainAlertEntity, Map<String, ? extends JSONObject> map, Continuation<? super kt1> continuation) {
        Continuation c2;
        Object d2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-583349386")) {
            return ipChange.ipc$dispatch("-583349386", new Object[]{this, mainAlertEntity, map, continuation});
        }
        ws2 ws2Var = new ws2(this.b);
        c2 = IntrinsicsKt__IntrinsicsJvmKt.c(continuation);
        o52 o52Var = new o52(c2);
        MemberGuideDialogManger memberGuideDialogManger = new MemberGuideDialogManger(this.b, new d(o52Var));
        memberGuideDialogManger.h(mainAlertEntity, new a(o52Var));
        if (b41.d("4", mainAlertEntity.type)) {
            if (map != null) {
                memberGuideDialogManger.l(new b(ws2Var, map));
            }
        } else if (b41.d("6", mainAlertEntity.type) && map != null) {
            memberGuideDialogManger.l(new c(ws2Var, map));
        }
        Object a2 = o52Var.a();
        d2 = kotlin.coroutines.intrinsics.b.d();
        if (a2 == d2) {
            n40.c(continuation);
        }
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-612574370")) {
            ipChange.ipc$dispatch("-612574370", new Object[]{this, str});
            return;
        }
        lt1 a2 = lt1.Companion.a();
        BaseActivity<?, ?> baseActivity = this.b;
        String c2 = z20.c();
        b41.h(c2, "getCityId()");
        a2.q(baseActivity, c2, str, null);
    }

    private final Object j(MainAlertEntity.MainAlertModel mainAlertModel, MainAlertEntity mainAlertEntity, String str, boolean z, Map<String, ? extends JSONObject> map, Continuation<? super kt1> continuation) {
        Continuation c2;
        Object d2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1309682930")) {
            return ipChange.ipc$dispatch("-1309682930", new Object[]{this, mainAlertModel, mainAlertEntity, str, Boolean.valueOf(z), map, continuation});
        }
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ws2 ws2Var = new ws2(this.b);
        c2 = IntrinsicsKt__IntrinsicsJvmKt.c(continuation);
        o52 o52Var = new o52(c2);
        cn.damai.common.image.a.b().c(mainAlertModel.imageUrl).e(new e(o52Var)).n(new f(ref$ObjectRef, z, str, o52Var, mainAlertModel, map, ws2Var, mainAlertEntity)).f();
        Object a2 = o52Var.a();
        d2 = kotlin.coroutines.intrinsics.b.d();
        if (a2 == d2) {
            n40.c(continuation);
        }
        return a2;
    }

    private final Object k(MainAlertEntity mainAlertEntity, String str, boolean z, Map<String, ? extends JSONObject> map, Continuation<? super kt1> continuation) {
        Continuation c2;
        Object d2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1893841364")) {
            return ipChange.ipc$dispatch("-1893841364", new Object[]{this, mainAlertEntity, str, Boolean.valueOf(z), map, continuation});
        }
        MainAlertEntity.MainAlertModel mainAlertModel = mainAlertEntity.item;
        if (mainAlertModel != null) {
            b41.h(mainAlertModel, "mMainAlertEntity.item");
            if (b41.d("7", mainAlertEntity.type)) {
                return l(mainAlertModel, str, z, map, continuation);
            }
            return j(mainAlertModel, mainAlertEntity, str, z, map, continuation);
        }
        c2 = IntrinsicsKt__IntrinsicsJvmKt.c(continuation);
        o52 o52Var = new o52(c2);
        Result.a aVar = Result.Companion;
        o52Var.resumeWith(Result.m1271constructorimpl(kt1.c.INSTANCE));
        Object a2 = o52Var.a();
        d2 = kotlin.coroutines.intrinsics.b.d();
        if (a2 == d2) {
            n40.c(continuation);
        }
        return a2;
    }

    private final Object l(final MainAlertEntity.MainAlertModel mainAlertModel, final String str, final boolean z, final Map<String, ? extends JSONObject> map, Continuation<? super kt1> continuation) {
        Continuation c2;
        Object d2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "723373816")) {
            return ipChange.ipc$dispatch("723373816", new Object[]{this, mainAlertModel, str, Boolean.valueOf(z), map, continuation});
        }
        final ws2 ws2Var = new ws2(this.b);
        c2 = IntrinsicsKt__IntrinsicsJvmKt.c(continuation);
        final o52 o52Var = new o52(c2);
        cn.damai.common.image.a.b().c(mainAlertModel.imageUrl).e(new g(o52Var)).n(new DMImageCreator.DMImageSuccListener() { // from class: cn.damai.homepage.util.window.handle.MiddlePriortyHandle$showDnaProtocolDialog$2$2
            private static transient /* synthetic */ IpChange $ipChange;

            /* compiled from: Taobao */
            /* loaded from: classes5.dex */
            public static final class a implements DMProtocolDialog.OnDialogShowTimeListener {
                private static transient /* synthetic */ IpChange $ipChange;
                final /* synthetic */ Map<String, JSONObject> a;
                final /* synthetic */ ws2 b;
                final /* synthetic */ MainAlertEntity.MainAlertModel c;

                /* JADX WARN: Multi-variable type inference failed */
                a(Map<String, ? extends JSONObject> map, ws2 ws2Var, MainAlertEntity.MainAlertModel mainAlertModel) {
                    this.a = map;
                    this.b = ws2Var;
                    this.c = mainAlertModel;
                }

                @Override // cn.damai.uikit.view.DMProtocolDialog.OnDialogShowTimeListener
                public final void exposureTime(long j) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "547072977")) {
                        ipChange.ipc$dispatch("547072977", new Object[]{this, Long.valueOf(j)});
                        return;
                    }
                    Map<String, JSONObject> map = this.a;
                    if (map != null) {
                        UTHelperPopupCallback.a.b(this.b, j, d23.f(), map, false, 8, null);
                        return;
                    }
                    MainAlertEntity.MainAlertModel mainAlertModel = this.c;
                    py0.p(j, mainAlertModel.schema, String.valueOf(mainAlertModel.circleId), "1", null);
                }
            }

            /* compiled from: Taobao */
            /* loaded from: classes14.dex */
            public static final class b implements DialogInterface.OnDismissListener {
                private static transient /* synthetic */ IpChange $ipChange;
                final /* synthetic */ Continuation<kt1> a;

                /* JADX WARN: Multi-variable type inference failed */
                b(Continuation<? super kt1> continuation) {
                    this.a = continuation;
                }

                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1755013873")) {
                        ipChange.ipc$dispatch("-1755013873", new Object[]{this, dialogInterface});
                        return;
                    }
                    Continuation<kt1> continuation = this.a;
                    Result.a aVar = Result.Companion;
                    continuation.resumeWith(Result.m1271constructorimpl(kt1.c.INSTANCE));
                }
            }

            @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
            public final void onSuccess(DMImageCreator.e eVar) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-443039951")) {
                    ipChange2.ipc$dispatch("-443039951", new Object[]{this, eVar});
                } else if (!MiddlePriortyHandle.this.b.isActivityFinsihed() && MiddlePriortyHandle.this.b.isActivityForeground() && eVar.b != null) {
                    List<MainAlertEntity.MainAlertContentListItem> list = mainAlertModel.contentList;
                    if (list != null && list.size() > 0) {
                        ArrayList arrayList = new ArrayList();
                        int size = mainAlertModel.contentList.size();
                        for (int i2 = 0; i2 < size; i2++) {
                            ya0 ya0Var = new ya0();
                            ya0Var.h(nk.b(mainAlertModel.titleColor));
                            ya0Var.g(mainAlertModel.contentList.get(i2).content);
                            if (b41.d("1", mainAlertModel.contentList.get(i2).contentType)) {
                                ya0Var.i(true);
                                ya0Var.l(mainAlertModel.protocolName);
                                ya0Var.j(nk.b(mainAlertModel.protocolColor));
                                ya0Var.k(mainAlertModel.protocolLink);
                            }
                            arrayList.add(ya0Var);
                        }
                        DMProtocolDialog m2 = new DMProtocolDialog(MiddlePriortyHandle.this.b).r(DMProtocolDialog.DMDialogTheme.THEME_DNA).o(arrayList).m(eVar.b);
                        final Map<String, JSONObject> map2 = map;
                        final MiddlePriortyHandle middlePriortyHandle = MiddlePriortyHandle.this;
                        final ws2 ws2Var2 = ws2Var;
                        final MainAlertEntity.MainAlertModel mainAlertModel2 = mainAlertModel;
                        DMProtocolDialog n = m2.p(new DMProtocolDialog.OnClickListener() { // from class: cn.damai.homepage.util.window.handle.MiddlePriortyHandle$showDnaProtocolDialog$2$2$dialog$1
                            private static transient /* synthetic */ IpChange $ipChange;

                            @Override // cn.damai.uikit.view.DMProtocolDialog.OnClickListener
                            public void onClickNegative() {
                                IpChange ipChange3 = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange3, "-1916639941")) {
                                    ipChange3.ipc$dispatch("-1916639941", new Object[]{this});
                                    return;
                                }
                                Map<String, JSONObject> map3 = map2;
                                if (map3 != null) {
                                    UTHelperPopupCallback.a.a(ws2Var2, d23.f(), map3, false, 4, null);
                                } else {
                                    c.e().x(py0.I().z(String.valueOf(mainAlertModel2.circleId), "1", 1, null));
                                }
                            }

                            @Override // cn.damai.uikit.view.DMProtocolDialog.OnClickListener
                            public void onClickPositive(@NotNull final DialogInterface dialogInterface, boolean z2) {
                                IpChange ipChange3 = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange3, "403995749")) {
                                    ipChange3.ipc$dispatch("403995749", new Object[]{this, dialogInterface, Boolean.valueOf(z2)});
                                    return;
                                }
                                b41.i(dialogInterface, "dialog");
                                if (z2) {
                                    Map<String, JSONObject> map3 = map2;
                                    if (map3 != null) {
                                        ws2Var2.confirmUt(d23.f(), map3, true);
                                    } else {
                                        c.e().x(py0.I().z(String.valueOf(mainAlertModel2.circleId), "1", 0, null));
                                    }
                                    SetupPermissionListRequest setupPermissionListRequest = new SetupPermissionListRequest();
                                    HashMap hashMap = new HashMap();
                                    hashMap.put("2", "1");
                                    setupPermissionListRequest.setupPermissionMap = hashMap;
                                    final MainAlertEntity.MainAlertModel mainAlertModel3 = mainAlertModel2;
                                    final MiddlePriortyHandle middlePriortyHandle2 = middlePriortyHandle;
                                    setupPermissionListRequest.request(new DMMtopRequestListener<SetPrivacyPermissionBean>(SetPrivacyPermissionBean.class) { // from class: cn.damai.homepage.util.window.handle.MiddlePriortyHandle$showDnaProtocolDialog$2$2$dialog$1$onClickPositive$3
                                        private static transient /* synthetic */ IpChange $ipChange;

                                        @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                                        public void onFail(@NotNull String str2, @NotNull String str3) {
                                            IpChange ipChange4 = $ipChange;
                                            if (AndroidInstantRuntime.support(ipChange4, "-1594606859")) {
                                                ipChange4.ipc$dispatch("-1594606859", new Object[]{this, str2, str3});
                                                return;
                                            }
                                            b41.i(str2, "errorCode");
                                            b41.i(str3, "errorMsg");
                                            dialogInterface.dismiss();
                                            ToastUtil.f("竟然失败了…请前往“设置-隐私设置”开启～");
                                        }

                                        @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                                        public void onSuccess(@Nullable SetPrivacyPermissionBean setPrivacyPermissionBean) {
                                            IpChange ipChange4 = $ipChange;
                                            if (AndroidInstantRuntime.support(ipChange4, "-589293733")) {
                                                ipChange4.ipc$dispatch("-589293733", new Object[]{this, setPrivacyPermissionBean});
                                                return;
                                            }
                                            if (MainAlertEntity.MainAlertModel.this != null) {
                                                Bundle bundle = new Bundle();
                                                bundle.putBoolean(MonitorType.SKIP, true);
                                                bundle.putString("from_page", "homepage");
                                                DMNav.from(middlePriortyHandle2.b).withExtras(bundle).toUri(MainAlertEntity.MainAlertModel.this.schema);
                                            }
                                            dialogInterface.dismiss();
                                        }
                                    });
                                    return;
                                }
                                ToastUtil.i(middlePriortyHandle.b.getString(R$string.homepage_dna_dialog_tip));
                            }

                            @Override // cn.damai.uikit.view.DMProtocolDialog.OnClickListener
                            public void onProtocolClick(@NotNull String str2) {
                                IpChange ipChange3 = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange3, "1587078194")) {
                                    ipChange3.ipc$dispatch("1587078194", new Object[]{this, str2});
                                    return;
                                }
                                b41.i(str2, "linkUrl");
                                DMNav.from(middlePriortyHandle.b).toUri(str2);
                            }
                        }).n(false);
                        n.q(new a(map, ws2Var, mainAlertModel));
                        n.setOnDismissListener(new b(o52Var));
                        if (!MiddlePriortyHandle.this.b.isFinishing()) {
                            n.show();
                            if (!z || TextUtils.isEmpty(str)) {
                                return;
                            }
                            MiddlePriortyHandle.this.h(str);
                            return;
                        }
                        Continuation<kt1> continuation2 = o52Var;
                        Result.a aVar = Result.Companion;
                        continuation2.resumeWith(Result.m1271constructorimpl(kt1.c.INSTANCE));
                        return;
                    }
                    Continuation<kt1> continuation3 = o52Var;
                    Result.a aVar2 = Result.Companion;
                    continuation3.resumeWith(Result.m1271constructorimpl(kt1.c.INSTANCE));
                } else {
                    Continuation<kt1> continuation4 = o52Var;
                    Result.a aVar3 = Result.Companion;
                    continuation4.resumeWith(Result.m1271constructorimpl(kt1.c.INSTANCE));
                }
            }
        }).f();
        Object a2 = o52Var.a();
        d2 = kotlin.coroutines.intrinsics.b.d();
        if (a2 == d2) {
            n40.c(continuation);
        }
        return a2;
    }

    private final Object m(CouponListResponse.ContentList contentList, Map<String, ? extends JSONObject> map, Continuation<? super kt1> continuation) {
        Continuation c2;
        Object d2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1657177776")) {
            return ipChange.ipc$dispatch("-1657177776", new Object[]{this, contentList, map, continuation});
        }
        ws2 ws2Var = new ws2(this.b);
        c2 = IntrinsicsKt__IntrinsicsJvmKt.c(continuation);
        o52 o52Var = new o52(c2);
        HomepageEvaluateDialog homepageEvaluateDialog = new HomepageEvaluateDialog(this.b, contentList, 1010, new j(o52Var));
        if (map != null) {
            homepageEvaluateDialog.t(new h(ws2Var, map));
        }
        homepageEvaluateDialog.s(new i());
        if (!this.b.isFinishing()) {
            homepageEvaluateDialog.show();
        } else {
            Result.a aVar = Result.Companion;
            o52Var.resumeWith(Result.m1271constructorimpl(kt1.c.INSTANCE));
        }
        Object a2 = o52Var.a();
        d2 = kotlin.coroutines.intrinsics.b.d();
        if (a2 == d2) {
            n40.c(continuation);
        }
        return a2;
    }

    private final Object n(MainAlertEntity.MainAlertModel mainAlertModel, String str, boolean z, Map<String, ? extends JSONObject> map, Continuation<? super kt1> continuation) {
        Continuation c2;
        Object d2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1425423810")) {
            return ipChange.ipc$dispatch("-1425423810", new Object[]{this, mainAlertModel, str, Boolean.valueOf(z), map, continuation});
        }
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ws2 ws2Var = new ws2(this.b);
        if (mainAlertModel == null) {
            return kt1.c.INSTANCE;
        }
        c2 = IntrinsicsKt__IntrinsicsJvmKt.c(continuation);
        o52 o52Var = new o52(c2);
        cn.damai.common.image.a.b().c(mainAlertModel.imageUrl).e(new k(o52Var)).n(new l(ref$ObjectRef, z, str, o52Var, mainAlertModel, map, ws2Var)).f();
        Object a2 = o52Var.a();
        d2 = kotlin.coroutines.intrinsics.b.d();
        if (a2 == d2) {
            n40.c(continuation);
        }
        return a2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x007b, code lost:
        if (r10 == null) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.Object o(cn.damai.homepage.bean.HomeWantSeeBean r10, java.lang.String r11, boolean r12, java.util.Map<java.lang.String, ? extends com.alibaba.fastjson.JSONObject> r13, kotlin.coroutines.Continuation<? super tb.kt1> r14) {
        /*
            r9 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = cn.damai.homepage.util.window.handle.MiddlePriortyHandle.$ipChange
            java.lang.String r1 = "1454710023"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            if (r2 == 0) goto L28
            r2 = 6
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r9
            r3 = 1
            r2[r3] = r10
            r10 = 2
            r2[r10] = r11
            r10 = 3
            java.lang.Boolean r11 = java.lang.Boolean.valueOf(r12)
            r2[r10] = r11
            r10 = 4
            r2[r10] = r13
            r10 = 5
            r2[r10] = r14
            java.lang.Object r10 = r0.ipc$dispatch(r1, r2)
            return r10
        L28:
            tb.ws2 r4 = new tb.ws2
            cn.damai.common.app.base.BaseActivity<?, ?> r0 = r9.b
            r4.<init>(r0)
            tb.o52 r7 = new tb.o52
            kotlin.coroutines.Continuation r0 = kotlin.coroutines.intrinsics.a.c(r14)
            r7.<init>(r0)
            if (r10 == 0) goto L7d
            cn.damai.rank.view.WantSeePosterTips$b$b r0 = cn.damai.rank.view.WantSeePosterTips.b.C0064b.INSTANCE
            java.lang.String r1 = r10.title
            r0.u(r1)
            java.lang.String r1 = r10.titleSuffix
            r0.v(r1)
            java.lang.String r1 = r10.subTitle
            r0.t(r1)
            java.lang.String r1 = r10.verticalPic
            r0.r(r1)
            java.lang.String r10 = r10.schema
            r0.p(r10)
            cn.damai.rank.view.WantSeePosterTips r10 = r9.c
            if (r10 == 0) goto L6e
            r10.setPageSource(r0)
            cn.damai.homepage.util.window.handle.MiddlePriortyHandle$m r8 = new cn.damai.homepage.util.window.handle.MiddlePriortyHandle$m
            r0 = r8
            r1 = r12
            r2 = r11
            r3 = r9
            r5 = r13
            r6 = r7
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r10.setListener(r8)
            r10.showAnim()
            goto L7b
        L6e:
            kotlin.Result$a r10 = kotlin.Result.Companion
            tb.kt1$c r10 = tb.kt1.c.INSTANCE
            java.lang.Object r10 = kotlin.Result.m1271constructorimpl(r10)
            r7.resumeWith(r10)
            tb.wt2 r10 = tb.wt2.INSTANCE
        L7b:
            if (r10 != 0) goto L8a
        L7d:
            kotlin.Result$a r10 = kotlin.Result.Companion
            tb.kt1$c r10 = tb.kt1.c.INSTANCE
            java.lang.Object r10 = kotlin.Result.m1271constructorimpl(r10)
            r7.resumeWith(r10)
            tb.wt2 r10 = tb.wt2.INSTANCE
        L8a:
            java.lang.Object r10 = r7.a()
            java.lang.Object r11 = kotlin.coroutines.intrinsics.a.d()
            if (r10 != r11) goto L97
            tb.n40.c(r14)
        L97:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.homepage.util.window.handle.MiddlePriortyHandle.o(cn.damai.homepage.bean.HomeWantSeeBean, java.lang.String, boolean, java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void i(@Nullable PopupCallback popupCallback, @Nullable WantSeePosterTips wantSeePosterTips) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-764211596")) {
            ipChange.ipc$dispatch("-764211596", new Object[]{this, popupCallback, wantSeePosterTips});
            return;
        }
        this.d = popupCallback;
        this.c = wantSeePosterTips;
    }

    @Override // com.alibaba.yymidservice.popup.popupcenter.view.PopupViewHandleCallback
    @Nullable
    public <T, K> Object popHandle(@Nullable T t, @Nullable K k2, @NotNull Continuation<? super kt1> continuation) {
        ArrayList<PopupDetailBean> arrayList;
        Object d2;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-328498497")) {
            return ipChange.ipc$dispatch("-328498497", new Object[]{this, t, k2, continuation});
        }
        PopupResponseBean popupResponseBean = t instanceof PopupResponseBean ? (PopupResponseBean) t : null;
        if (popupResponseBean != null) {
            PopupCallback popupCallback = this.d;
            if (popupCallback != null) {
                popupCallback.showLottie();
            }
            PopupCallback popupCallback2 = this.d;
            if (((popupCallback2 == null || true != popupCallback2.isHomePageTab()) ? false : false) && (arrayList = popupResponseBean.show) != null) {
                Object f2 = f(arrayList, continuation);
                d2 = kotlin.coroutines.intrinsics.b.d();
                return f2 == d2 ? f2 : (kt1) f2;
            }
            return kt1.c.INSTANCE;
        }
        return kt1.c.INSTANCE;
    }
}
