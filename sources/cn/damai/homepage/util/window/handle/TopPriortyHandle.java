package cn.damai.homepage.util.window.handle;

import android.app.Activity;
import android.app.Application;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import cn.damai.common.DamaiConstants;
import cn.damai.common.OrangeConfigCenter;
import cn.damai.common.app.widget.DMDialog;
import cn.damai.commonbusiness.city.model.SitesBean;
import cn.damai.commonbusiness.city.util.CityLocationUtil;
import cn.damai.homepage.MainActivity;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$string;
import cn.damai.homepage.util.TickletBusinessUtil;
import cn.damai.homepage.util.window.PopupCallback;
import cn.damai.login.LoginManager;
import cn.damai.uikit.view.DMThemeDialog;
import com.alibaba.pictures.picpermission.Permission;
import com.alibaba.pictures.picpermission.custom.IPermissionListener;
import com.alibaba.pictures.picpermission.manage.PermissionModel;
import com.alibaba.yymidservice.popup.popupcenter.view.PopupViewHandle;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;
import kotlin.Result;
import kotlin.collections.m;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.cb1;
import tb.gr1;
import tb.id;
import tb.ir1;
import tb.k50;
import tb.kr1;
import tb.kt1;
import tb.mr1;
import tb.mu0;
import tb.n40;
import tb.nt1;
import tb.o52;
import tb.on1;
import tb.us;
import tb.xr;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public final class TopPriortyHandle extends PopupViewHandle {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    public static final String NO_CITY_CHANGE = "no_city_change";
    @NotNull
    private Activity b;
    @Nullable
    private PopupCallback c;
    @Nullable
    private TickletBusinessUtil d;
    @Nullable
    private FrameLayout e;
    @Nullable
    private CityLocationUtil f;
    @NotNull
    private nt1<Boolean> g;
    @NotNull
    private nt1<String> h;
    @NotNull
    private nt1<String> i;
    @NotNull
    private nt1<String> j;
    @NotNull
    private final CityLocationUtil.LocaltionListener k;

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public static final class b implements CityLocationUtil.LocaltionListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // cn.damai.commonbusiness.city.util.CityLocationUtil.LocaltionListener
        public void onGetLocalFinsih() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-382193152")) {
                ipChange.ipc$dispatch("-382193152", new Object[]{this});
            } else {
                TopPriortyHandle.this.i().b(TopPriortyHandle.NO_CITY_CHANGE);
            }
        }

        @Override // cn.damai.commonbusiness.city.util.CityLocationUtil.LocaltionListener
        public void onGetLocalSuccess(@NotNull SitesBean sitesBean) {
            IpChange ipChange = $ipChange;
            boolean z = true;
            if (AndroidInstantRuntime.support(ipChange, "-1179040396")) {
                ipChange.ipc$dispatch("-1179040396", new Object[]{this, sitesBean});
                return;
            }
            b41.i(sitesBean, "sitesBean");
            if ((TextUtils.getTrimmedLength(sitesBean.getCityId()) <= 0 || b41.d(String.valueOf(mu0.b), sitesBean.getCityId())) && b41.d(z20.d(), sitesBean.getCityName())) {
                z = false;
            }
            String str = TopPriortyHandle.NO_CITY_CHANGE;
            if (z) {
                nt1<String> i = TopPriortyHandle.this.i();
                if (TextUtils.getTrimmedLength(sitesBean.getCityName()) > 0) {
                    str = sitesBean.getCityName();
                }
                b41.h(str, "if (TextUtils.getTrimmed…E else sitesBean.cityName");
                i.b(str);
                return;
            }
            TopPriortyHandle.this.i().b(TopPriortyHandle.NO_CITY_CHANGE);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public static final class c implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Continuation<kt1> b;

        /* JADX WARN: Multi-variable type inference failed */
        c(Continuation<? super kt1> continuation) {
            this.b = continuation;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-50536325")) {
                ipChange.ipc$dispatch("-50536325", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            CityLocationUtil cityLocationUtil = TopPriortyHandle.this.f;
            if (cityLocationUtil != null) {
                cityLocationUtil.q();
            }
            dialogInterface.dismiss();
            xr.c(DamaiConstants.CITY_CHANGED, "");
            PopupCallback popupCallback = TopPriortyHandle.this.c;
            if (popupCallback != null) {
                popupCallback.cityChangeRefresh();
            }
            Continuation<kt1> continuation = this.b;
            Result.a aVar = Result.Companion;
            continuation.resumeWith(Result.m1271constructorimpl(kt1.c.INSTANCE));
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public static final class d implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Continuation<kt1> a;

        /* JADX WARN: Multi-variable type inference failed */
        d(Continuation<? super kt1> continuation) {
            this.a = continuation;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-414685835")) {
                ipChange.ipc$dispatch("-414685835", new Object[]{this, view});
                return;
            }
            Continuation<kt1> continuation = this.a;
            Result.a aVar = Result.Companion;
            continuation.resumeWith(Result.m1271constructorimpl(kt1.c.INSTANCE));
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public static final class e implements IPermissionListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Continuation<kt1> a;
        final /* synthetic */ TopPriortyHandle b;

        /* compiled from: Taobao */
        /* loaded from: classes14.dex */
        public static final class a implements DialogInterface.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ TopPriortyHandle a;
            final /* synthetic */ Continuation<kt1> b;

            /* JADX WARN: Multi-variable type inference failed */
            a(TopPriortyHandle topPriortyHandle, Continuation<? super kt1> continuation) {
                this.a = topPriortyHandle;
                this.b = continuation;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "467558266")) {
                    ipChange.ipc$dispatch("467558266", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                    return;
                }
                dialogInterface.dismiss();
                kr1.f(this.a.b);
                Continuation<kt1> continuation = this.b;
                Result.a aVar = Result.Companion;
                continuation.resumeWith(Result.m1271constructorimpl(kt1.c.INSTANCE));
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes14.dex */
        public static final class b implements DialogInterface.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ Continuation<kt1> a;

            /* JADX WARN: Multi-variable type inference failed */
            b(Continuation<? super kt1> continuation) {
                this.a = continuation;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1437139289")) {
                    ipChange.ipc$dispatch("1437139289", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                    return;
                }
                dialogInterface.dismiss();
                Continuation<kt1> continuation = this.a;
                Result.a aVar = Result.Companion;
                continuation.resumeWith(Result.m1271constructorimpl(kt1.c.INSTANCE));
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        e(Continuation<? super kt1> continuation, TopPriortyHandle topPriortyHandle) {
            this.a = continuation;
            this.b = topPriortyHandle;
        }

        @Override // com.alibaba.pictures.picpermission.custom.IPermissionListener
        public void onPermissionDenied(@NotNull String[] strArr) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1599515272")) {
                ipChange.ipc$dispatch("1599515272", new Object[]{this, strArr});
                return;
            }
            b41.i(strArr, "permission");
            Continuation<kt1> continuation = this.a;
            Result.a aVar = Result.Companion;
            continuation.resumeWith(Result.m1271constructorimpl(kt1.c.INSTANCE));
        }

        @Override // com.alibaba.pictures.picpermission.custom.IPermissionListener
        public void onPermissionGranted() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1996618557")) {
                ipChange.ipc$dispatch("1996618557", new Object[]{this});
                return;
            }
            Continuation<kt1> continuation = this.a;
            Result.a aVar = Result.Companion;
            continuation.resumeWith(Result.m1271constructorimpl(kt1.c.INSTANCE));
        }

        @Override // com.alibaba.pictures.picpermission.custom.IPermissionListener
        public void onShowRationale(@NotNull String[] strArr) {
            List j;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2040909104")) {
                ipChange.ipc$dispatch("-2040909104", new Object[]{this, strArr});
                return;
            }
            b41.i(strArr, "deniedPermissions");
            Activity activity = this.b.b;
            j = m.j(Arrays.copyOf(strArr, strArr.length));
            gr1.a(activity, "获取你所在城市的演出赛事信息，帮助你找到附近的演出赛事", j, false, new a(this.b, this.a), new b(this.a));
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public static final class f implements DialogInterface.OnDismissListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Continuation<kt1> b;

        /* JADX WARN: Multi-variable type inference failed */
        f(Continuation<? super kt1> continuation) {
            this.b = continuation;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1510643456")) {
                ipChange.ipc$dispatch("1510643456", new Object[]{this, dialogInterface});
            } else {
                TopPriortyHandle.this.k(this.b, kt1.b.INSTANCE);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public static final class g implements TickletBusinessUtil.PopNoShow {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Continuation<kt1> b;

        /* JADX WARN: Multi-variable type inference failed */
        g(Continuation<? super kt1> continuation) {
            this.b = continuation;
        }

        @Override // cn.damai.homepage.util.TickletBusinessUtil.PopNoShow
        public final void popNoShow() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-208490207")) {
                ipChange.ipc$dispatch("-208490207", new Object[]{this});
            } else {
                TopPriortyHandle.this.k(this.b, kt1.c.INSTANCE);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public static final class h implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String b;
        final /* synthetic */ Continuation<kt1> c;

        /* JADX WARN: Multi-variable type inference failed */
        h(String str, Continuation<? super kt1> continuation) {
            this.b = str;
            this.c = continuation;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "40535165")) {
                ipChange.ipc$dispatch("40535165", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            us.b(TopPriortyHandle.this.b, this.b);
            Continuation<kt1> continuation = this.c;
            Result.a aVar = Result.Companion;
            continuation.resumeWith(Result.m1271constructorimpl(kt1.c.INSTANCE));
        }
    }

    public TopPriortyHandle(@NotNull Activity activity) {
        b41.i(activity, "mContext");
        this.b = activity;
        this.g = new nt1<>();
        this.h = new nt1<>();
        this.i = new nt1<>();
        this.j = new nt1<>();
        this.k = new b();
    }

    private final void g() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1973520481")) {
            ipChange.ipc$dispatch("-1973520481", new Object[]{this});
            return;
        }
        boolean i = ir1.i(mr1.LOCATION);
        String B = z20.B(MainActivity.SP_KEY_LOCATION_DIALOG_SHOWED);
        if (!i && TextUtils.isEmpty(B)) {
            this.g.b(Boolean.TRUE);
        } else {
            this.g.b(Boolean.FALSE);
        }
    }

    private final void h() {
        boolean K;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1933225797")) {
            ipChange.ipc$dispatch("-1933225797", new Object[]{this});
            return;
        }
        try {
            List asList = Arrays.asList(Arrays.copyOf(new String[]{"Asia/Chongqing", "Asia/Harbin", "Asia/Hong_Kong", "Asia/Macau", "Asia/Shanghai", "Asia/Taipei", "Asia/Urumqi"}, 7));
            String id = TimeZone.getDefault().getID();
            if (asList.contains(id)) {
                this.h.b("false");
                return;
            }
            String b2 = OrangeConfigCenter.c().b(on1.HOME_OTHER_TIME_ZONE_IN_CHINA, "otherzone", "");
            if (!TextUtils.isEmpty(b2)) {
                b41.h(b2, "otherTimeZone");
                b41.h(id, "currentId");
                K = StringsKt__StringsKt.K(b2, id, false, 2, null);
                if (K) {
                    this.h.b("false");
                    return;
                }
            }
            if (b41.d(us.a(this.b), id)) {
                this.h.b("false");
                return;
            }
            nt1<String> nt1Var = this.h;
            b41.h(id, "currentId");
            nt1Var.b(id);
        } catch (Exception e2) {
            this.h.b("false");
            cb1.b("checkTimeZone", e2.getMessage());
        }
    }

    private final void j() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "319498447")) {
            ipChange.ipc$dispatch("319498447", new Object[]{this});
        } else if (ir1.i(mr1.LOCATION)) {
            CityLocationUtil cityLocationUtil = new CityLocationUtil(this.b, this.k);
            this.f = cityLocationUtil;
            cityLocationUtil.p(true);
            cityLocationUtil.n();
        } else {
            this.i.b(NO_CITY_CHANGE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(Continuation<? super kt1> continuation, kt1 kt1Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1584210499")) {
            ipChange.ipc$dispatch("-1584210499", new Object[]{this, continuation, kt1Var});
        } else if (continuation != null) {
            try {
                Result.a aVar = Result.Companion;
                continuation.resumeWith(Result.m1271constructorimpl(kt1Var));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private final Object m(String str, Continuation<? super kt1> continuation) {
        Continuation c2;
        Object d2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1392878424")) {
            return ipChange.ipc$dispatch("-1392878424", new Object[]{this, str, continuation});
        }
        c2 = IntrinsicsKt__IntrinsicsJvmKt.c(continuation);
        o52 o52Var = new o52(c2);
        DMThemeDialog dMThemeDialog = new DMThemeDialog(this.b);
        dMThemeDialog.o("地理位置变更").r(DMThemeDialog.DMDialogTheme.THEME_LOCATION).k(this.b.getString(R$string.change_city_tip, new Object[]{str})).i(this.b.getString(R$string.change_city, new Object[]{str}), new c(o52Var)).g(true, new d(o52Var));
        if (!this.b.isFinishing()) {
            dMThemeDialog.show();
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

    private final Object n(Continuation<? super kt1> continuation) {
        Continuation c2;
        Object d2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "158527423")) {
            return ipChange.ipc$dispatch("158527423", new Object[]{this, continuation});
        }
        c2 = IntrinsicsKt__IntrinsicsJvmKt.c(continuation);
        o52 o52Var = new o52(c2);
        z20.T(MainActivity.SP_KEY_LOCATION_DIALOG_SHOWED, "locationExaDes");
        String[] strArr = mr1.LOCATION;
        b41.h(strArr, "LOCATION");
        PermissionModel permissionModel = new PermissionModel(strArr, "位置权限使用说明", id.c(R$drawable.permission_location_icon), "用于为你提供所在城市演出和场馆信息及帮助你找到附近的演出");
        Application a2 = mu0.a();
        b41.h(a2, "getApplication()");
        new Permission(a2, permissionModel).a(new e(o52Var, this)).b();
        Object a3 = o52Var.a();
        d2 = kotlin.coroutines.intrinsics.b.d();
        if (a3 == d2) {
            n40.c(continuation);
        }
        return a3;
    }

    private final Object o(Continuation<? super kt1> continuation) {
        Continuation c2;
        Object d2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-653995749")) {
            return ipChange.ipc$dispatch("-653995749", new Object[]{this, continuation});
        }
        c2 = IntrinsicsKt__IntrinsicsJvmKt.c(continuation);
        o52 o52Var = new o52(c2);
        if (LoginManager.k().q()) {
            TickletBusinessUtil tickletBusinessUtil = this.d;
            if (tickletBusinessUtil != null) {
                tickletBusinessUtil.d(new f(o52Var), new g(o52Var));
                tickletBusinessUtil.g(this.e, true);
            }
        } else {
            k(o52Var, kt1.c.INSTANCE);
        }
        Object a2 = o52Var.a();
        d2 = kotlin.coroutines.intrinsics.b.d();
        if (a2 == d2) {
            n40.c(continuation);
        }
        return a2;
    }

    private final Object p(String str, Continuation<? super kt1> continuation) {
        Continuation c2;
        Object d2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1353137369")) {
            return ipChange.ipc$dispatch("1353137369", new Object[]{this, str, continuation});
        }
        c2 = IntrinsicsKt__IntrinsicsJvmKt.c(continuation);
        o52 o52Var = new o52(c2);
        DMDialog dMDialog = new DMDialog(this.b);
        dMDialog.o(false);
        dMDialog.q("未特殊提示的，抢票和演出时间均为北京时间为准");
        dMDialog.n("知道了", new h(str, o52Var));
        if (!this.b.isFinishing()) {
            dMDialog.show();
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

    @NotNull
    public final nt1<String> i() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-800599381") ? (nt1) ipChange.ipc$dispatch("-800599381", new Object[]{this}) : this.i;
    }

    public final void l(@Nullable TickletBusinessUtil tickletBusinessUtil, @Nullable FrameLayout frameLayout, @Nullable PopupCallback popupCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "969201868")) {
            ipChange.ipc$dispatch("969201868", new Object[]{this, tickletBusinessUtil, frameLayout, popupCallback});
            return;
        }
        this.c = popupCallback;
        this.d = tickletBusinessUtil;
        this.e = frameLayout;
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x0109, code lost:
        if (r1 != false) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00f8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x012e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x013c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x013d A[PHI: r10 
      PHI: (r10v24 java.lang.Object) = (r10v23 java.lang.Object), (r10v1 java.lang.Object) binds: [B:65:0x013a, B:16:0x0049] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    @Override // com.alibaba.yymidservice.popup.popupcenter.view.PopupViewHandleCallback
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <T, K> java.lang.Object popHandle(@org.jetbrains.annotations.Nullable T r9, @org.jetbrains.annotations.Nullable K r10, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super tb.kt1> r11) {
        /*
            Method dump skipped, instructions count: 340
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.homepage.util.window.handle.TopPriortyHandle.popHandle(java.lang.Object, java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
