package cn.damai.homepage.ui.view;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import cn.damai.common.DamaiConstants;
import cn.damai.common.badge.DMBadgeListener;
import cn.damai.common.badge.bean.BadgeNodeItem;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.user.C0529c;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$dimen;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.homepage.bean.KeyWord;
import cn.damai.homepage.ui.view.HomePageGuideBar;
import cn.damai.login.LoginManager;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.uikit.tag.DMCertInfoTagView;
import com.alibaba.fastjson.JSON;
import com.alibaba.pictures.bricks.view.DMUpMarqueeView;
import com.alibaba.pictures.picpermission.Permission;
import com.alibaba.pictures.picpermission.custom.IPermissionListener;
import com.alibaba.pictures.picpermission.manage.PermissionModel;
import com.alient.onearch.adapter.pom.OneArchConstants;
import com.alient.oneservice.nav.Action;
import com.alient.oneservice.ut.TrackInfo;
import com.alient.oneservice.ut.UserTrackProviderProxy;
import com.alimm.xadsdk.base.expose.MonitorType;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import com.youku.resource.widget.YKActionSheet;
import io.flutter.wpkbridge.WPKFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.C8214m;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.bv0;
import tb.cs;
import tb.fb2;
import tb.fy1;
import tb.gr1;
import tb.k50;
import tb.kg2;
import tb.lt1;
import tb.mr1;
import tb.py0;
import tb.uq;
import tb.xr;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public final class HomePageGuideBar extends LinearLayout implements LifecycleObserver {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    private static final String DM_MSGBOX = "DM_MSGBOX";
    private static final int REQUEST_CODE_OPEN_MESSAGE_CENTER = 111;
    @Nullable
    private Boolean isInTransBgState;
    @Nullable
    private uq mBadgManager;
    @NotNull
    private final DMBadgeListener mBadgeListener;
    @NotNull
    private final DMCertInfoTagView mCertInfoView;
    @NotNull
    private String mCurrentCity;
    @NotNull
    private xr mDMMessage;
    @NotNull
    private final FrameLayout mMessage;
    @NotNull
    private final DMIconFontTextView mMessageIcon;
    @NotNull
    private final TextView mMessageTip;
    @NotNull
    private final DMIconFontTextView mScan;
    @NotNull
    private TextView mSearchBtn;
    @NotNull
    private DMUpMarqueeView mSearchText;
    @NotNull
    private LinearLayout mSearchView;
    @NotNull
    private final TextView mSelectCity;
    @NotNull
    private final DMIconFontTextView mSelectCityIcon;
    @NotNull
    private final LinearLayout mSelectCityLayout;
    @NotNull
    private final LinearLayout mTitleBar;
    @Nullable
    private Map<String, ? extends Action> mTrackInfo;
    @NotNull
    private final View statusBarSpace;
    @NotNull
    public static final C1177a Companion = new C1177a(null);
    @NotNull
    private static List<String> SEARCH_TEXT_LIST = new ArrayList();
    @NotNull
    private static final HashMap<String, KeyWord> TEXT_MAPPING = new HashMap<>();

    /* compiled from: Taobao */
    /* renamed from: cn.damai.homepage.ui.view.HomePageGuideBar$a */
    /* loaded from: classes14.dex */
    public static final class C1177a {
        private static transient /* synthetic */ IpChange $ipChange;

        private C1177a() {
        }

        public /* synthetic */ C1177a(k50 k50Var) {
            this();
        }

        @NotNull
        public final List<String> a() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1872014659") ? (List) ipChange.ipc$dispatch("1872014659", new Object[]{this}) : HomePageGuideBar.SEARCH_TEXT_LIST;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.homepage.ui.view.HomePageGuideBar$b */
    /* loaded from: classes5.dex */
    public static final class C1178b implements IPermissionListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ List<String> b;
        final /* synthetic */ Activity c;

        C1178b(List<String> list, Activity activity) {
            this.b = list;
            this.c = activity;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(Activity activity, DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "726884229")) {
                ipChange.ipc$dispatch("726884229", new Object[]{activity, dialogInterface, Integer.valueOf(i)});
                return;
            }
            b41.i(activity, "$activity");
            dialogInterface.dismiss();
            fb2.e(activity);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1932721618")) {
                ipChange.ipc$dispatch("1932721618", new Object[]{dialogInterface, Integer.valueOf(i)});
            } else {
                dialogInterface.dismiss();
            }
        }

        @Override // com.alibaba.pictures.picpermission.custom.IPermissionListener
        public void onPermissionDenied(@NotNull String[] strArr) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2112456575")) {
                ipChange.ipc$dispatch("2112456575", new Object[]{this, strArr});
            } else {
                b41.i(strArr, "permission");
            }
        }

        @Override // com.alibaba.pictures.picpermission.custom.IPermissionListener
        public void onPermissionGranted() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "298842100")) {
                ipChange.ipc$dispatch("298842100", new Object[]{this});
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean(MonitorType.SKIP, true);
            DMNav.from(HomePageGuideBar.this.getContext()).withExtras(bundle).toUri(NavUri.b("home_scan"));
        }

        @Override // com.alibaba.pictures.picpermission.custom.IPermissionListener
        public void onShowRationale(@NotNull String[] strArr) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "765088057")) {
                ipChange.ipc$dispatch("765088057", new Object[]{this, strArr});
                return;
            }
            b41.i(strArr, "deniedPermissions");
            Context context = HomePageGuideBar.this.getContext();
            List<String> list = this.b;
            final Activity activity = this.c;
            gr1.a(context, "授权获取相机权限,用于提供扫码服务", list, false, new DialogInterface.OnClickListener() { // from class: tb.iy0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    HomePageGuideBar.C1178b.c(activity, dialogInterface, i);
                }
            }, new DialogInterface.OnClickListener() { // from class: tb.jy0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    HomePageGuideBar.C1178b.d(dialogInterface, i);
                }
            });
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.homepage.ui.view.HomePageGuideBar$c */
    /* loaded from: classes5.dex */
    public static final class C1179c implements DMBadgeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C1179c() {
        }

        @Override // cn.damai.common.badge.DMBadgeListener
        public void badgeChanged(@NotNull String str, @NotNull BadgeNodeItem badgeNodeItem) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-937534920")) {
                ipChange.ipc$dispatch("-937534920", new Object[]{this, str, badgeNodeItem});
                return;
            }
            b41.i(str, "nodeId");
            b41.i(badgeNodeItem, "badgeNodeItem");
            uq uqVar = HomePageGuideBar.this.mBadgManager;
            if (uqVar != null) {
                uqVar.i(str, this);
            }
            int count = badgeNodeItem.getCount();
            HomePageGuideBar.this.mMessageTip.setText(count > 9 ? "9+" : String.valueOf(count));
            HomePageGuideBar.this.mMessageTip.setVisibility(count <= 0 ? 8 : 0);
        }

        @Override // cn.damai.common.badge.DMBadgeListener
        public void badgeQueryFail(@NotNull List<String> list, @NotNull String str, @NotNull String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-55190272")) {
                ipChange.ipc$dispatch("-55190272", new Object[]{this, list, str, str2});
                return;
            }
            b41.i(list, "list");
            b41.i(str, "s");
            b41.i(str2, "s1");
            uq uqVar = HomePageGuideBar.this.mBadgManager;
            if (uqVar != null) {
                uqVar.j(list, this);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HomePageGuideBar(@NotNull Context context) {
        this(context, null, 2, null);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    public /* synthetic */ HomePageGuideBar(Context context, AttributeSet attributeSet, int i, k50 k50Var) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    private final View createView(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-948476998")) {
            return (View) ipChange.ipc$dispatch("-948476998", new Object[]{this, str});
        }
        View inflate = LayoutInflater.from(getContext()).inflate(R$layout.channel_page_bar_text, (ViewGroup) null);
        b41.h(inflate, "from(context)\n          …nnel_page_bar_text, null)");
        View findViewById = inflate.findViewById(R$id.channel_search_text);
        b41.h(findViewById, "view.findViewById(R.id.channel_search_text)");
        ((TextView) findViewById).setText(str);
        inflate.setTag(str);
        return inflate;
    }

    private final void initClickByActivity(final Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1533293935")) {
            ipChange.ipc$dispatch("1533293935", new Object[]{this, activity});
            return;
        }
        this.mCertInfoView.setOnClickListener(new View.OnClickListener() { // from class: tb.by0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomePageGuideBar.m43initClickByActivity$lambda5(activity, this, view);
            }
        });
        this.mSelectCityLayout.setOnClickListener(new View.OnClickListener() { // from class: tb.fy0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomePageGuideBar.m44initClickByActivity$lambda7(HomePageGuideBar.this, activity, view);
            }
        });
        this.mSearchText.setOnItemClickListener(new DMUpMarqueeView.OnItemClickListener() { // from class: tb.hy0
            @Override // com.alibaba.pictures.bricks.view.DMUpMarqueeView.OnItemClickListener
            public final void onItemClick(int i, View view) {
                HomePageGuideBar.m45initClickByActivity$lambda8(HomePageGuideBar.this, i, view);
            }
        });
        this.mSearchBtn.setOnClickListener(new View.OnClickListener() { // from class: tb.cy0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomePageGuideBar.m46initClickByActivity$lambda9(HomePageGuideBar.this, view);
            }
        });
        this.mMessage.setOnClickListener(new View.OnClickListener() { // from class: tb.ey0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomePageGuideBar.m41initClickByActivity$lambda11(HomePageGuideBar.this, activity, view);
            }
        });
        this.mScan.setOnClickListener(new View.OnClickListener() { // from class: tb.dy0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomePageGuideBar.m42initClickByActivity$lambda13(HomePageGuideBar.this, activity, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initClickByActivity$lambda-11  reason: not valid java name */
    public static final void m41initClickByActivity$lambda11(HomePageGuideBar homePageGuideBar, Activity activity, View view) {
        Action action;
        TrackInfo trackInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-922055184")) {
            ipChange.ipc$dispatch("-922055184", new Object[]{homePageGuideBar, activity, view});
            return;
        }
        b41.i(homePageGuideBar, "this$0");
        b41.i(activity, "$activity");
        Map<String, ? extends Action> map = homePageGuideBar.mTrackInfo;
        if (map != null && (action = map.get("message")) != null && (trackInfo = action.getTrackInfo()) != null) {
            UserTrackProviderProxy.click(trackInfo, true);
        }
        if (LoginManager.k().q()) {
            DMNav.from(activity).toUri(NavUri.b(cs.x));
        } else {
            LoginManager.k().x(activity, new Intent(), 111);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initClickByActivity$lambda-13  reason: not valid java name */
    public static final void m42initClickByActivity$lambda13(HomePageGuideBar homePageGuideBar, Activity activity, View view) {
        Action action;
        TrackInfo trackInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1692788750")) {
            ipChange.ipc$dispatch("-1692788750", new Object[]{homePageGuideBar, activity, view});
            return;
        }
        b41.i(homePageGuideBar, "this$0");
        b41.i(activity, "$activity");
        Map<String, ? extends Action> map = homePageGuideBar.mTrackInfo;
        if (map != null && (action = map.get(fy1.HOME_SCAN_PAGE)) != null && (trackInfo = action.getTrackInfo()) != null) {
            UserTrackProviderProxy.click(trackInfo, true);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("android.permission.CAMERA");
        String[] strArr = mr1.CAMERA;
        b41.h(strArr, "CAMERA");
        PermissionModel permissionModel = new PermissionModel(strArr, null, null, "授权获取相机权限,用于提供扫码服务");
        Application application = AppInfoProviderProxy.getApplication();
        b41.h(application, "getApplication()");
        new Permission(application, permissionModel).a(new C1178b(arrayList, activity)).b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initClickByActivity$lambda-5  reason: not valid java name */
    public static final void m43initClickByActivity$lambda5(Activity activity, HomePageGuideBar homePageGuideBar, View view) {
        Action action;
        TrackInfo trackInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1570570641")) {
            ipChange.ipc$dispatch("1570570641", new Object[]{activity, homePageGuideBar, view});
            return;
        }
        b41.i(activity, "$activity");
        b41.i(homePageGuideBar, "this$0");
        DMNav.from(activity).toUri("https://p.damai.cn/wow/act/act/license");
        Map<String, ? extends Action> map = homePageGuideBar.mTrackInfo;
        if (map == null || (action = map.get(IRequestConst.LICENSE)) == null || (trackInfo = action.getTrackInfo()) == null) {
            return;
        }
        UserTrackProviderProxy.click(trackInfo, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initClickByActivity$lambda-7  reason: not valid java name */
    public static final void m44initClickByActivity$lambda7(HomePageGuideBar homePageGuideBar, Activity activity, View view) {
        Action action;
        TrackInfo trackInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-406436269")) {
            ipChange.ipc$dispatch("-406436269", new Object[]{homePageGuideBar, activity, view});
            return;
        }
        b41.i(homePageGuideBar, "this$0");
        b41.i(activity, "$activity");
        Map<String, ? extends Action> map = homePageGuideBar.mTrackInfo;
        if (map != null && (action = map.get("city")) != null && (trackInfo = action.getTrackInfo()) != null) {
            UserTrackProviderProxy.click(trackInfo, true);
        }
        Bundle bundle = new Bundle();
        bundle.putString("data", "home");
        bundle.putBoolean(MonitorType.SKIP, true);
        DMNav.from(activity).withExtras(bundle).forResult(78).toUri(NavUri.b("home_cityselect"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initClickByActivity$lambda-8  reason: not valid java name */
    public static final void m45initClickByActivity$lambda8(HomePageGuideBar homePageGuideBar, int i, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1453761883")) {
            ipChange.ipc$dispatch("1453761883", new Object[]{homePageGuideBar, Integer.valueOf(i), view});
            return;
        }
        b41.i(homePageGuideBar, "this$0");
        homePageGuideBar.jumpSearch(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initClickByActivity$lambda-9  reason: not valid java name */
    public static final void m46initClickByActivity$lambda9(HomePageGuideBar homePageGuideBar, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "405486247")) {
            ipChange.ipc$dispatch("405486247", new Object[]{homePageGuideBar, view});
            return;
        }
        b41.i(homePageGuideBar, "this$0");
        b41.h(homePageGuideBar.mSearchText.getCurrentView(), "mSearchText.currentView");
        homePageGuideBar.jumpSearch(true);
    }

    private final void initStateBar(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "573774191")) {
            ipChange.ipc$dispatch("573774191", new Object[]{this, activity});
            return;
        }
        int a = bv0.INSTANCE.a(activity);
        if (Build.VERSION.SDK_INT >= 23) {
            this.statusBarSpace.getLayoutParams().height = kg2.a(activity);
            this.statusBarSpace.setVisibility(0);
            kg2.f(activity, true, R$color.black);
            kg2.d(true, activity);
        } else {
            kg2.f(activity, false, R$color.black);
            this.statusBarSpace.setVisibility(8);
        }
        this.mTitleBar.getLayoutParams().height = a;
        invalidate();
    }

    private final void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1993540838")) {
            ipChange.ipc$dispatch("-1993540838", new Object[]{this});
            return;
        }
        this.mCertInfoView.setPosition(1);
        this.mSearchText.setFlipInterval(5000);
        this.mSearchText.setAnimationDuration(500L);
    }

    private final void jumpSearch(boolean z) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "239071387")) {
            ipChange.ipc$dispatch("239071387", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        try {
            Object tag = this.mSearchText.getCurrentView().getTag();
            b41.g(tag, "null cannot be cast to non-null type kotlin.String");
            str = (String) tag;
        } catch (Exception e) {
            e.printStackTrace();
            str = "";
        }
        KeyWord keyWord = TEXT_MAPPING.get(str);
        Bundle bundle = new Bundle();
        if (z) {
            bundle.putString("autowords", str);
            C0529c.e().x(py0.I().E(str));
        } else {
            C0529c.e().x(py0.I().F(str, keyWord));
        }
        bundle.putString(OneArchConstants.LayoutKey.KEY_WORDS, str);
        bundle.putString(YKActionSheet.ACTION_STYLE_DESCRIBE, str);
        DMNav.from(getContext()).withExtras(bundle).toUri(NavUri.b(cs.o));
    }

    private final void listenDMMessage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1503618588")) {
            ipChange.ipc$dispatch("-1503618588", new Object[]{this});
        } else {
            this.mDMMessage.b(DamaiConstants.CITY_CHANGED, new cn.damai.message.observer.Action() { // from class: tb.gy0
                @Override // cn.damai.message.observer.Action
                public final void call(Object obj) {
                    HomePageGuideBar.m47listenDMMessage$lambda14(HomePageGuideBar.this, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: listenDMMessage$lambda-14  reason: not valid java name */
    public static final void m47listenDMMessage$lambda14(HomePageGuideBar homePageGuideBar, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1434032752")) {
            ipChange.ipc$dispatch("-1434032752", new Object[]{homePageGuideBar, obj});
            return;
        }
        b41.i(homePageGuideBar, "this$0");
        lt1 a = lt1.Companion.a();
        String c = z20.c();
        b41.h(c, "getCityId()");
        a.r(c);
        homePageGuideBar.updateShowCity();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private final void loadUnReadMsgCount() {
        List<String> j;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "892989996")) {
            ipChange.ipc$dispatch("892989996", new Object[]{this});
        } else if (LoginManager.k().q()) {
            if (this.mBadgManager == null) {
                this.mBadgManager = uq.a();
            }
            uq uqVar = this.mBadgManager;
            if (uqVar != null) {
                uqVar.g(DM_MSGBOX, this.mBadgeListener);
            }
            j = C8214m.j(DM_MSGBOX, uq.f);
            uq uqVar2 = this.mBadgManager;
            if (uqVar2 != null) {
                uqVar2.d(j);
            }
        }
    }

    private final void updateSearchText() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-352177231")) {
            ipChange.ipc$dispatch("-352177231", new Object[]{this});
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : SEARCH_TEXT_LIST) {
            arrayList.add(createView(str));
        }
        this.mSearchText.setItems(arrayList);
    }

    private final void updateShowCity() {
        Resources resources;
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1199898626")) {
            ipChange.ipc$dispatch("-1199898626", new Object[]{this});
            return;
        }
        String d = z20.d();
        b41.h(d, "getCityName()");
        this.mCurrentCity = d;
        this.mSelectCity.setText(d);
        TextView textView = this.mSelectCity;
        if (TextUtils.getTrimmedLength(this.mCurrentCity) >= 3) {
            resources = getResources();
            i = R$dimen.font_Subhead1_M;
        } else {
            resources = getResources();
            i = R$dimen.font_Headline2_M;
        }
        textView.setTextSize(0, resources.getDimension(i));
    }

    public final int getGuideLayoutHeight() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-387089589") ? ((Integer) ipChange.ipc$dispatch("-387089589", new Object[]{this})).intValue() : this.mTitleBar.getLayoutParams().height;
    }

    public final void initDefault(@Nullable FragmentActivity fragmentActivity, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "13247201")) {
            ipChange.ipc$dispatch("13247201", new Object[]{this, fragmentActivity, Boolean.valueOf(z)});
            return;
        }
        SEARCH_TEXT_LIST.add("搜索明星 演出 赛事 场馆");
        updateSearchText();
        this.mSelectCity.setText(this.mCurrentCity);
        this.mCertInfoView.setWhiteMode(z);
        if (fragmentActivity != null) {
            initClickByActivity(fragmentActivity);
            initStateBar(fragmentActivity);
            fragmentActivity.getLifecycle().addObserver(this);
        }
        py0.I().a0(this.mSearchView, JSON.toJSONString(SEARCH_TEXT_LIST), "home");
    }

    @Nullable
    public final Boolean isInTransBgState() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "344949145") ? (Boolean) ipChange.ipc$dispatch("344949145", new Object[]{this}) : this.isInTransBgState;
    }

    public final void logoutUpdateUI() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1640819048")) {
            ipChange.ipc$dispatch("1640819048", new Object[]{this});
            return;
        }
        TextView textView = this.mMessageTip;
        if (textView.getVisibility() == 0) {
            textView.setVisibility(8);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1178084004")) {
            ipChange.ipc$dispatch("1178084004", new Object[]{this});
            return;
        }
        super.onDetachedFromWindow();
        this.mDMMessage.a();
    }

    public final void setInTransBgState(@Nullable Boolean bool) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1530374749")) {
            ipChange.ipc$dispatch("1530374749", new Object[]{this, bool});
        } else {
            this.isInTransBgState = bool;
        }
    }

    public final void setSearchText(@NotNull List<String> list, @NotNull List<? extends KeyWord> list2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2027285594")) {
            ipChange.ipc$dispatch("-2027285594", new Object[]{this, list, list2});
            return;
        }
        b41.i(list, "keyword");
        b41.i(list2, "orgList");
        TEXT_MAPPING.clear();
        for (KeyWord keyWord : list2) {
            HashMap<String, KeyWord> hashMap = TEXT_MAPPING;
            String keyword = keyWord.getKeyword();
            b41.h(keyword, "it.keyword");
            hashMap.put(keyword, keyWord);
        }
        SEARCH_TEXT_LIST.clear();
        SEARCH_TEXT_LIST.addAll(list);
        updateSearchText();
    }

    public final void setTrackInfo(@Nullable Map<String, ? extends Action> map, @Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1665084233")) {
            ipChange.ipc$dispatch("-1665084233", new Object[]{this, map, str});
        } else if (map != null) {
            for (Map.Entry<String, ? extends Action> entry : map.entrySet()) {
                entry.getValue().getTrackInfo().setSpmb(str);
            }
            this.mTrackInfo = map;
        }
    }

    public final void setWhiteStyle(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "868771363")) {
            ipChange.ipc$dispatch("868771363", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mCertInfoView.setWhiteMode(z);
        if (z) {
            TextView textView = this.mSelectCity;
            Resources resources = getResources();
            int i = R$color.cg_7;
            textView.setTextColor(ResourcesCompat.getColor(resources, i, null));
            this.mSelectCityIcon.setTextColor(ResourcesCompat.getColor(getResources(), i, null));
            this.mMessageIcon.setTextColor(-1);
            return;
        }
        TextView textView2 = this.mSelectCity;
        Resources resources2 = getResources();
        int i2 = R$color.cg_0;
        textView2.setTextColor(ResourcesCompat.getColor(resources2, i2, null));
        this.mSelectCityIcon.setTextColor(ResourcesCompat.getColor(getResources(), i2, null));
        this.mMessageIcon.setTextColor(ResourcesCompat.getColor(getResources(), R$color.color_3C3F44, null));
    }

    public final void showTransBg(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-350535703")) {
            ipChange.ipc$dispatch("-350535703", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isInTransBgState = Boolean.valueOf(z);
        if (z) {
            this.mTitleBar.setBackground(ResourcesCompat.getDrawable(getResources(), R$drawable.transparent_bg, null));
            this.mSearchView.setBackground(ResourcesCompat.getDrawable(getResources(), R$drawable.home_guide_search_white_bg, null));
            setWhiteStyle(true);
            return;
        }
        setWhiteStyle(false);
        this.mSearchView.setBackground(ResourcesCompat.getDrawable(getResources(), R$drawable.home_guide_search_bg, null));
        this.mTitleBar.setBackground(ResourcesCompat.getDrawable(getResources(), R$drawable.home_guide_bar, null));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HomePageGuideBar(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        LayoutInflater.from(context).inflate(R$layout.homepage_guide_bar, (ViewGroup) this, true);
        View findViewById = findViewById(R$id.homepage_header_bar);
        b41.h(findViewById, "findViewById(R.id.homepage_header_bar)");
        this.mTitleBar = (LinearLayout) findViewById;
        View findViewById2 = findViewById(R$id.status_bar_space);
        b41.h(findViewById2, "findViewById(R.id.status_bar_space)");
        this.statusBarSpace = findViewById2;
        View findViewById3 = findViewById(R$id.homepage_header_cert_info);
        b41.h(findViewById3, "findViewById(R.id.homepage_header_cert_info)");
        this.mCertInfoView = (DMCertInfoTagView) findViewById3;
        View findViewById4 = findViewById(R$id.homepage_header_select_city_layout);
        b41.h(findViewById4, "findViewById(R.id.homepa…eader_select_city_layout)");
        this.mSelectCityLayout = (LinearLayout) findViewById4;
        View findViewById5 = findViewById(R$id.homepage_header_select_city);
        b41.h(findViewById5, "findViewById(R.id.homepage_header_select_city)");
        this.mSelectCity = (TextView) findViewById5;
        View findViewById6 = findViewById(R$id.homepage_header_select_city_icon);
        b41.h(findViewById6, "findViewById(R.id.homepa…_header_select_city_icon)");
        this.mSelectCityIcon = (DMIconFontTextView) findViewById6;
        String d = z20.d();
        b41.h(d, "getCityName()");
        this.mCurrentCity = d;
        this.mDMMessage = new xr();
        View findViewById7 = findViewById(R$id.homepage_header_search_layout);
        b41.h(findViewById7, "findViewById(R.id.homepage_header_search_layout)");
        this.mSearchView = (LinearLayout) findViewById7;
        View findViewById8 = findViewById(R$id.homepage_header_scan);
        b41.h(findViewById8, "findViewById(R.id.homepage_header_scan)");
        this.mScan = (DMIconFontTextView) findViewById8;
        View findViewById9 = findViewById(R$id.homepage_header_search);
        b41.h(findViewById9, "findViewById(R.id.homepage_header_search)");
        this.mSearchText = (DMUpMarqueeView) findViewById9;
        View findViewById10 = findViewById(R$id.homepage_header_search_btn);
        b41.h(findViewById10, "findViewById(R.id.homepage_header_search_btn)");
        this.mSearchBtn = (TextView) findViewById10;
        View findViewById11 = findViewById(R$id.homepage_header_message_layout);
        b41.h(findViewById11, "findViewById(R.id.homepage_header_message_layout)");
        this.mMessage = (FrameLayout) findViewById11;
        View findViewById12 = findViewById(R$id.homepage_header_message);
        b41.h(findViewById12, "findViewById(R.id.homepage_header_message)");
        this.mMessageIcon = (DMIconFontTextView) findViewById12;
        View findViewById13 = findViewById(R$id.homepage_header_message_tip_point);
        b41.h(findViewById13, "findViewById(R.id.homepa…header_message_tip_point)");
        this.mMessageTip = (TextView) findViewById13;
        initView();
        listenDMMessage();
        this.mBadgeListener = new C1179c();
    }
}
