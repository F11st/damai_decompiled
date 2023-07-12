package cn.damai.homepage;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import cn.damai.comment.bean.CommentOptrBean;
import cn.damai.common.AppConfig;
import cn.damai.common.DamaiConstants;
import cn.damai.common.OrangeConfigCenter;
import cn.damai.common.app.widget.DMDialog;
import cn.damai.common.image.C0504a;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.nav.DMNav;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.user.C0525a;
import cn.damai.common.user.C0529c;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.base.PermissionsHelper;
import cn.damai.commonbusiness.city.model.SitesBean;
import cn.damai.commonbusiness.city.util.CityLocationUtil;
import cn.damai.commonbusiness.coupondialog.net.CouponListResponse;
import cn.damai.commonbusiness.home.bean.HomeContentFloatBean;
import cn.damai.commonbusiness.home.bean.HomeFloatResBean;
import cn.damai.commonbusiness.home.bean.TabExtraBean;
import cn.damai.commonbusiness.home.request.HomeFloatLayerRequest;
import cn.damai.commonbusiness.pageut.C0726a;
import cn.damai.commonbusiness.pageut.PageUtExecutor;
import cn.damai.commonbusiness.screenshot.ScreenShotDetector;
import cn.damai.commonbusiness.tab.BottomSheetBean;
import cn.damai.commonbusiness.tab.C0938a;
import cn.damai.commonbusiness.tab.DamaiTabViewHelper;
import cn.damai.commonbusiness.tab.DamaiTabbarManager;
import cn.damai.commonbusiness.tab.TabItem;
import cn.damai.commonbusiness.tab.TabbarDataManager;
import cn.damai.commonbusiness.tab.TabbarLayout;
import cn.damai.commonbusiness.tab.download.ImageDownLoader;
import cn.damai.commonbusiness.update.UpdateUtil;
import cn.damai.evaluate.request.CommentListOptrRequest;
import cn.damai.homepage.MainAlertEntity;
import cn.damai.homepage.bean.HomeZhibotiaoBean;
import cn.damai.homepage.bean.SetPrivacyPermissionBean;
import cn.damai.homepage.bean.TabExtra;
import cn.damai.homepage.request.BottomSheetRequest;
import cn.damai.homepage.request.PopUpAdvertCallBackRequest;
import cn.damai.homepage.request.PopUpAdvertRequest;
import cn.damai.homepage.request.SetupPermissionListRequest;
import cn.damai.homepage.ui.fragment.HomeCmsFragment;
import cn.damai.homepage.ui.fragment.HomeFragmentAgent;
import cn.damai.homepage.ui.fragment.HomeTabFragment;
import cn.damai.homepage.ui.view.ContentPopTipPanel;
import cn.damai.homepage.ui.view.HomeLottieView;
import cn.damai.homepage.ui.view.HomepageEvaluateDialog;
import cn.damai.homepage.ui.view.ZhiboView;
import cn.damai.homepage.util.LoginLogoutBroadcastReceiver;
import cn.damai.homepage.util.MemberGuideDialogManger;
import cn.damai.homepage.util.TickletBusinessUtil;
import cn.damai.homepage.util.window.PopupCallback;
import cn.damai.homepage.v2.HomePageFragment;
import cn.damai.launcher.splash.SplashMainActivity;
import cn.damai.login.LoginManager;
import cn.damai.message.observer.Action;
import cn.damai.rank.view.WantSeePosterTips;
import cn.damai.rank.view.WantSeeTips;
import cn.damai.tetris.component.home.HomeData;
import cn.damai.tetris.component.home.bean.HomePageRecentBean;
import cn.damai.uikit.util.DialogUtil;
import cn.damai.uikit.util.TDialog;
import cn.damai.uikit.view.DMProtocolDialog;
import cn.damai.uikit.view.DMThemeDialog;
import cn.damai.wantsee.GuideUtProvider;
import cn.damai.wantsee.StartConfig;
import com.alibaba.fastjson.JSON;
import com.alibaba.pictures.bricks.component.home.notice.HomeNoticeView;
import com.alibaba.pictures.picpermission.Permission;
import com.alibaba.pictures.picpermission.custom.IPermissionListener;
import com.alibaba.pictures.picpermission.manage.PermissionModel;
import com.alibaba.pictures.responsive.page.IResponsivePage;
import com.alibaba.poplayer.PopLayer;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.alimm.xadsdk.base.expose.MonitorType;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.login4android.Login;
import com.taobao.uikit.feature.features.FeatureFactory;
import com.taobao.wireless.security.sdk.SecurityGuardManager;
import com.taobao.wireless.security.sdk.staticdatastore.IStaticDataStoreComponent;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.jetbrains.annotations.NotNull;
import tb.C9021d;
import tb.ay0;
import tb.b03;
import tb.c80;
import tb.cb1;
import tb.cb2;
import tb.cm2;
import tb.d23;
import tb.g03;
import tb.gr1;
import tb.gz0;
import tb.ir1;
import tb.ja1;
import tb.k3;
import tb.kg2;
import tb.ko;
import tb.kr1;
import tb.ky0;
import tb.m61;
import tb.mr1;
import tb.mt1;
import tb.mu0;
import tb.n3;
import tb.nk;
import tb.ns2;
import tb.on1;
import tb.py0;
import tb.rg0;
import tb.rr2;
import tb.ru1;
import tb.s22;
import tb.t60;
import tb.tr2;
import tb.tx0;
import tb.us;
import tb.vb1;
import tb.wh2;
import tb.wu0;
import tb.xr;
import tb.ya0;
import tb.yy0;
import tb.z20;

/* compiled from: Taobao */
@PopLayer.PopupAllowedFromFragment
/* loaded from: classes5.dex */
public class MainActivity extends DamaiBaseActivity implements DamaiConstants, PageUtExecutor.FragmentPropertiesProvider, DamaiTabViewHelper.OnHomeIconTabStateChangedListener, TabbarLayout.TabBarListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static String APP_GOTO_OTHER_PAGE = "home_app_goto_other_page";
    public static final int HOMEPAGE_EVALUATE_RESULT = 1010;
    public static final String KEY_G_ID = "groupId";
    public static final String KEY_ID = "id";
    public static final String KEY_REF_ITEM_ID = "referItemId";
    public static final String KEY_TYPE = "type";
    public static final int REQUEST_CODE_CITY = 78;
    public static final String SHOW_SPLASH_AD = "show_splash_ad";
    public static final String SP_KEY_LOCATION_DIALOG_SHOWED = "locationExaKey";
    static boolean showed;
    private boolean canShowLottie;
    boolean checkedSuccess;
    private boolean homeIsOnPause;
    private String lottieFilePath;
    private boolean lottieIsShowed;
    private boolean lottieLoadSuccess;
    private Dialog mAdView;
    private HomeLottieView mAnimationView;
    private CityLocationUtil mCityLocationUtil;
    private String mCurrentCity;
    private HomeData mHomeData;
    private HomeFragmentAgent mHomeTabFragment;
    private boolean mIsUseNewHome;
    private LoginLogoutBroadcastReceiver mLoginReceiver;
    private MemberGuideDialogManger mMemberDialogManger;
    private ContentPopTipPanel mPopTipPanel;
    private TabExtra mTabExtra;
    private TabbarLayout mTabbarLayout;
    private DamaiTabbarManager mTabbarManager;
    private FrameLayout mTickletContainer;
    private ZhiboView mZhiboView;
    private HomeZhibotiaoBean mZhibotiaoBean;
    private s22 responsiveActivityStateManager;
    private DMDialog timeZoneDialog;
    boolean uncheckSuccess;
    private WantSeePosterTips wantSeeProjectTips;
    private WantSeeTips wantSeeTips;
    private mt1 windowStart;
    private final int SETTING_RESULT = 1009;
    private final int LOGIN_RESULT = 1008;
    private TickletBusinessUtil tickletBusinessUtil = new TickletBusinessUtil(this);
    private boolean isFirstStart = true;
    int index = 0;
    boolean reCheckSuccess = true;
    long mExitTime = -1;
    public MainAlertEntity mMainAlertEntity = null;
    Map<String, Map> fragmentPropertiesMap = new HashMap();
    private CityLocationUtil.LocaltionListener mLocaltionListener = new C1124p();

    /* compiled from: Taobao */
    /* renamed from: cn.damai.homepage.MainActivity$25  reason: invalid class name */
    /* loaded from: classes5.dex */
    public class AnonymousClass25 implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ MainAlertEntity.MainAlertModel a;

        /* compiled from: Taobao */
        /* renamed from: cn.damai.homepage.MainActivity$25$a */
        /* loaded from: classes5.dex */
        public class C1103a implements DMProtocolDialog.OnDialogShowTimeListener {
            private static transient /* synthetic */ IpChange $ipChange;

            C1103a() {
            }

            @Override // cn.damai.uikit.view.DMProtocolDialog.OnDialogShowTimeListener
            public void exposureTime(long j) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1703792724")) {
                    ipChange.ipc$dispatch("1703792724", new Object[]{this, Long.valueOf(j)});
                    return;
                }
                MainAlertEntity.MainAlertModel mainAlertModel = MainActivity.this.mMainAlertEntity.item;
                py0.p(j, mainAlertModel.schema, String.valueOf(mainAlertModel.circleId), "1", null);
            }
        }

        /* compiled from: Taobao */
        /* renamed from: cn.damai.homepage.MainActivity$25$b */
        /* loaded from: classes14.dex */
        public class DialogInterface$OnDismissListenerC1104b implements DialogInterface.OnDismissListener {
            private static transient /* synthetic */ IpChange $ipChange;

            DialogInterface$OnDismissListenerC1104b() {
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1338979476")) {
                    ipChange.ipc$dispatch("-1338979476", new Object[]{this, dialogInterface});
                } else {
                    MainActivity.this.checkUpdate();
                }
            }
        }

        AnonymousClass25(MainAlertEntity.MainAlertModel mainAlertModel) {
            this.a = mainAlertModel;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.C0502e c0502e) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1816009613")) {
                ipChange.ipc$dispatch("1816009613", new Object[]{this, c0502e});
            } else if (MainActivity.this.isActivityFinsihed() || !MainActivity.this.isActivityForeground() || c0502e.b == null) {
                MainActivity.this.checkUpdate();
            } else {
                List<MainAlertEntity.MainAlertContentListItem> list = this.a.contentList;
                if (list == null || list.size() <= 0) {
                    MainActivity.this.checkUpdate();
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < this.a.contentList.size(); i++) {
                    ya0 ya0Var = new ya0();
                    ya0Var.h(nk.b(this.a.titleColor));
                    ya0Var.g(this.a.contentList.get(i).content);
                    if ("1".equals(this.a.contentList.get(i).contentType)) {
                        ya0Var.i(true);
                        ya0Var.l(this.a.protocolName);
                        ya0Var.j(nk.b(this.a.protocolColor));
                        ya0Var.k(this.a.protocolLink);
                    }
                    arrayList.add(ya0Var);
                }
                DMProtocolDialog n = new DMProtocolDialog(MainActivity.this).r(DMProtocolDialog.DMDialogTheme.THEME_DNA).o(arrayList).m(c0502e.b).p(new DMProtocolDialog.OnClickListener() { // from class: cn.damai.homepage.MainActivity.25.1
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // cn.damai.uikit.view.DMProtocolDialog.OnClickListener
                    public void onClickNegative() {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "337640841")) {
                            ipChange2.ipc$dispatch("337640841", new Object[]{this});
                        } else {
                            C0529c.e().x(py0.I().z(String.valueOf(MainActivity.this.mMainAlertEntity.item.circleId), "1", 1, null));
                        }
                    }

                    @Override // cn.damai.uikit.view.DMProtocolDialog.OnClickListener
                    public void onClickPositive(final DialogInterface dialogInterface, boolean z) {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "-820608717")) {
                            ipChange2.ipc$dispatch("-820608717", new Object[]{this, dialogInterface, Boolean.valueOf(z)});
                        } else if (z) {
                            C0529c.e().x(py0.I().z(String.valueOf(MainActivity.this.mMainAlertEntity.item.circleId), "1", 0, null));
                            SetupPermissionListRequest setupPermissionListRequest = new SetupPermissionListRequest();
                            HashMap hashMap = new HashMap();
                            hashMap.put("2", "1");
                            setupPermissionListRequest.setupPermissionMap = hashMap;
                            setupPermissionListRequest.request(new DMMtopRequestListener<SetPrivacyPermissionBean>(SetPrivacyPermissionBean.class) { // from class: cn.damai.homepage.MainActivity.25.1.1
                                private static transient /* synthetic */ IpChange $ipChange;

                                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                                public void onFail(String str, String str2) {
                                    IpChange ipChange3 = $ipChange;
                                    if (AndroidInstantRuntime.support(ipChange3, "129206663")) {
                                        ipChange3.ipc$dispatch("129206663", new Object[]{this, str, str2});
                                        return;
                                    }
                                    dialogInterface.dismiss();
                                    ToastUtil.f("竟然失败了…请前往“设置-隐私设置”开启～");
                                }

                                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                                public void onSuccess(SetPrivacyPermissionBean setPrivacyPermissionBean) {
                                    IpChange ipChange3 = $ipChange;
                                    if (AndroidInstantRuntime.support(ipChange3, "-1474035219")) {
                                        ipChange3.ipc$dispatch("-1474035219", new Object[]{this, setPrivacyPermissionBean});
                                        return;
                                    }
                                    MainAlertEntity mainAlertEntity = MainActivity.this.mMainAlertEntity;
                                    if (mainAlertEntity != null && mainAlertEntity.item != null) {
                                        Bundle bundle = new Bundle();
                                        bundle.putBoolean(MonitorType.SKIP, true);
                                        bundle.putString("from_page", "homepage");
                                        DMNav.from(MainActivity.this).withExtras(bundle).toUri(MainActivity.this.mMainAlertEntity.item.schema);
                                    }
                                    dialogInterface.dismiss();
                                }
                            });
                        } else {
                            ToastUtil.i(MainActivity.this.getString(R$string.homepage_dna_dialog_tip));
                        }
                    }

                    @Override // cn.damai.uikit.view.DMProtocolDialog.OnClickListener
                    public void onProtocolClick(String str) {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "-1146469120")) {
                            ipChange2.ipc$dispatch("-1146469120", new Object[]{this, str});
                        } else {
                            DMNav.from(MainActivity.this).toUri(str);
                        }
                    }
                }).n(false);
                n.q(new C1103a());
                n.setOnDismissListener(new DialogInterface$OnDismissListenerC1104b());
                n.show();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.homepage.MainActivity$a */
    /* loaded from: classes5.dex */
    public class C1105a implements MemberGuideDialogManger.IMemberDialogDispatcher {
        private static transient /* synthetic */ IpChange $ipChange;

        /* compiled from: Taobao */
        /* renamed from: cn.damai.homepage.MainActivity$a$a */
        /* loaded from: classes14.dex */
        public class DialogInterface$OnDismissListenerC1106a implements DialogInterface.OnDismissListener {
            private static transient /* synthetic */ IpChange $ipChange;

            DialogInterface$OnDismissListenerC1106a() {
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "831350854")) {
                    ipChange.ipc$dispatch("831350854", new Object[]{this, dialogInterface});
                } else {
                    MainActivity.this.checkUpdate();
                }
            }
        }

        C1105a() {
        }

        @Override // cn.damai.homepage.util.MemberGuideDialogManger.IMemberDialogDispatcher
        public void dialogToShow(Dialog dialog) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "176229547")) {
                ipChange.ipc$dispatch("176229547", new Object[]{this, dialog});
                return;
            }
            dialog.setOnDismissListener(new DialogInterface$OnDismissListenerC1106a());
            dialog.show();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.homepage.MainActivity$b */
    /* loaded from: classes5.dex */
    public class C1107b implements Action<HomePageRecentBean.Labels.HomePageRecentItems> {
        private static transient /* synthetic */ IpChange $ipChange;

        C1107b() {
        }

        @Override // cn.damai.message.observer.Action
        /* renamed from: a */
        public void call(HomePageRecentBean.Labels.HomePageRecentItems homePageRecentItems) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "605651819")) {
                ipChange.ipc$dispatch("605651819", new Object[]{this, homePageRecentItems});
            } else {
                MainActivity.this.wantActionShow(homePageRecentItems.projectId);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.homepage.MainActivity$c */
    /* loaded from: classes5.dex */
    public class C1108c implements GuideUtProvider {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;

        C1108c(MainActivity mainActivity, String str) {
            this.a = str;
        }

        @Override // cn.damai.wantsee.GuideUtProvider
        @NonNull
        public Map<String, String> getGuideCloseBtnArgMap() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "237467129") ? (Map) ipChange.ipc$dispatch("237467129", new Object[]{this}) : getGuideExposeArgMap();
        }

        @Override // cn.damai.wantsee.GuideUtProvider
        @NonNull
        public Map<String, String> getGuideExposeArgMap() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1715362233")) {
                return (Map) ipChange.ipc$dispatch("1715362233", new Object[]{this});
            }
            HashMap<String, String> f = d23.f();
            f.put("item_id", this.a);
            return f;
        }

        @Override // cn.damai.wantsee.GuideUtProvider
        @NonNull
        public Map<String, String> getGuideGoMineBtnArgMap() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "626234378") ? (Map) ipChange.ipc$dispatch("626234378", new Object[]{this}) : getGuideExposeArgMap();
        }

        @Override // cn.damai.wantsee.GuideUtProvider
        @NonNull
        public String getSpmB() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "2065753298") ? (String) ipChange.ipc$dispatch("2065753298", new Object[]{this}) : "home";
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.homepage.MainActivity$d */
    /* loaded from: classes5.dex */
    public class C1109d implements ImageDownLoader.AsyncImageLoaderListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ BottomSheetBean a;
        final /* synthetic */ ImageDownLoader b;

        C1109d(BottomSheetBean bottomSheetBean, ImageDownLoader imageDownLoader) {
            this.a = bottomSheetBean;
            this.b = imageDownLoader;
        }

        @Override // cn.damai.commonbusiness.tab.download.ImageDownLoader.AsyncImageLoaderListener
        public void onImageLoader(Bitmap bitmap) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1614907892")) {
                ipChange.ipc$dispatch("-1614907892", new Object[]{this, bitmap});
                return;
            }
            MainActivity mainActivity = MainActivity.this;
            mainActivity.reCheckSuccess = true;
            if (mainActivity.checkedSuccess && mainActivity.uncheckSuccess) {
                mainActivity.loadImage(this.a, this.b);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.homepage.MainActivity$e */
    /* loaded from: classes5.dex */
    public class C1110e implements ImageDownLoader.AsyncImageLoaderListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ BottomSheetBean a;
        final /* synthetic */ ImageDownLoader b;

        C1110e(BottomSheetBean bottomSheetBean, ImageDownLoader imageDownLoader) {
            this.a = bottomSheetBean;
            this.b = imageDownLoader;
        }

        @Override // cn.damai.commonbusiness.tab.download.ImageDownLoader.AsyncImageLoaderListener
        public void onImageLoader(Bitmap bitmap) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "979318925")) {
                ipChange.ipc$dispatch("979318925", new Object[]{this, bitmap});
                return;
            }
            MainActivity mainActivity = MainActivity.this;
            mainActivity.checkedSuccess = true;
            if (mainActivity.uncheckSuccess && mainActivity.reCheckSuccess) {
                mainActivity.loadImage(this.a, this.b);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.homepage.MainActivity$f */
    /* loaded from: classes5.dex */
    public class C1111f implements ImageDownLoader.AsyncImageLoaderListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ BottomSheetBean a;
        final /* synthetic */ ImageDownLoader b;

        C1111f(BottomSheetBean bottomSheetBean, ImageDownLoader imageDownLoader) {
            this.a = bottomSheetBean;
            this.b = imageDownLoader;
        }

        @Override // cn.damai.commonbusiness.tab.download.ImageDownLoader.AsyncImageLoaderListener
        public void onImageLoader(Bitmap bitmap) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-721421554")) {
                ipChange.ipc$dispatch("-721421554", new Object[]{this, bitmap});
                return;
            }
            MainActivity mainActivity = MainActivity.this;
            mainActivity.uncheckSuccess = true;
            if (mainActivity.checkedSuccess && mainActivity.reCheckSuccess) {
                mainActivity.loadImage(this.a, this.b);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.homepage.MainActivity$g */
    /* loaded from: classes5.dex */
    public class C1112g implements IResponsivePage {
        private static transient /* synthetic */ IpChange $ipChange;

        C1112g(MainActivity mainActivity) {
        }

        @Override // com.alibaba.pictures.responsive.page.IResponsivePage
        public void onResponsiveLayout(@Nullable Configuration configuration, int i, boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2140388562")) {
                ipChange.ipc$dispatch("-2140388562", new Object[]{this, configuration, Integer.valueOf(i), Boolean.valueOf(z)});
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.homepage.MainActivity$h */
    /* loaded from: classes14.dex */
    public class DialogInterface$OnClickListenerC1113h implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;
        final /* synthetic */ boolean b;

        DialogInterface$OnClickListenerC1113h(String str, boolean z) {
            this.a = str;
            this.b = z;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "337447021")) {
                ipChange.ipc$dispatch("337447021", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            us.b(MainActivity.this, this.a);
            if (this.b) {
                MainActivity.this.checkRecentTicket();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.homepage.MainActivity$i */
    /* loaded from: classes14.dex */
    public class DialogInterface$OnDismissListenerC1114i implements DialogInterface.OnDismissListener {
        private static transient /* synthetic */ IpChange $ipChange;

        DialogInterface$OnDismissListenerC1114i() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1264598502")) {
                ipChange.ipc$dispatch("-1264598502", new Object[]{this, dialogInterface});
            } else {
                MainActivity.this.checkUpdate();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.homepage.MainActivity$j */
    /* loaded from: classes5.dex */
    public class C1115j implements HomepageEvaluateDialog.OnUserRejectListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C1115j() {
        }

        @Override // cn.damai.homepage.ui.view.HomepageEvaluateDialog.OnUserRejectListener
        public void onUserReject(CouponListResponse.ContentList contentList) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-992827980")) {
                ipChange.ipc$dispatch("-992827980", new Object[]{this, contentList});
                return;
            }
            MainActivity mainActivity = MainActivity.this;
            mainActivity.showEvaluateTips(mainActivity.getString(R$string.damai_homepage_comment_await_comment_tips));
            MainActivity.this.reportUserOperation(contentList.targetId, 1);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.homepage.MainActivity$k */
    /* loaded from: classes5.dex */
    public class C1116k implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C1116k() {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.C0501d c0501d) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-762690310")) {
                ipChange.ipc$dispatch("-762690310", new Object[]{this, c0501d});
            } else {
                MainActivity.this.checkUpdate();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.homepage.MainActivity$l */
    /* loaded from: classes5.dex */
    public class C1117l implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ MainAlertEntity.MainAlertModel a;

        /* compiled from: Taobao */
        /* renamed from: cn.damai.homepage.MainActivity$l$a */
        /* loaded from: classes14.dex */
        public class View$OnClickListenerC1118a implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            View$OnClickListenerC1118a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1550059607")) {
                    ipChange.ipc$dispatch("1550059607", new Object[]{this, view});
                } else if (MainActivity.this.mAdView == null || !MainAlertEntity.PICK_TYPE_CALLBACK.equals(MainActivity.this.mMainAlertEntity.item.pkType)) {
                } else {
                    C0529c.e().x(py0.I().z(String.valueOf(MainActivity.this.mMainAlertEntity.item.circleId), "0", 1, C1117l.this.a.imageUrl));
                }
            }
        }

        /* compiled from: Taobao */
        /* renamed from: cn.damai.homepage.MainActivity$l$b */
        /* loaded from: classes5.dex */
        public class C1119b implements TDialog.OnDialogShowTimeListener {
            private static transient /* synthetic */ IpChange $ipChange;

            C1119b() {
            }

            @Override // cn.damai.uikit.util.TDialog.OnDialogShowTimeListener
            public void exposureTime(long j) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-115408847")) {
                    ipChange.ipc$dispatch("-115408847", new Object[]{this, Long.valueOf(j)});
                } else if (MainAlertEntity.PICK_TYPE_CALLBACK.equals(MainActivity.this.mMainAlertEntity.item.pkType)) {
                    MainAlertEntity.MainAlertModel mainAlertModel = MainActivity.this.mMainAlertEntity.item;
                    py0.p(j, mainAlertModel.schema, String.valueOf(mainAlertModel.circleId), "0", C1117l.this.a.imageUrl);
                } else {
                    C1117l c1117l = C1117l.this;
                    MainAlertEntity.MainAlertModel mainAlertModel2 = MainActivity.this.mMainAlertEntity.item;
                    py0.o(j, mainAlertModel2.schema, mainAlertModel2.scm, c1117l.a.imageUrl);
                }
            }
        }

        /* compiled from: Taobao */
        /* renamed from: cn.damai.homepage.MainActivity$l$c */
        /* loaded from: classes14.dex */
        public class DialogInterface$OnDismissListenerC1120c implements DialogInterface.OnDismissListener {
            private static transient /* synthetic */ IpChange $ipChange;

            DialogInterface$OnDismissListenerC1120c() {
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "2060592303")) {
                    ipChange.ipc$dispatch("2060592303", new Object[]{this, dialogInterface});
                } else {
                    MainActivity.this.checkUpdate();
                }
            }
        }

        C1117l(MainAlertEntity.MainAlertModel mainAlertModel) {
            this.a = mainAlertModel;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.C0502e c0502e) {
            Bitmap bitmap;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-8220976")) {
                ipChange.ipc$dispatch("-8220976", new Object[]{this, c0502e});
            } else if (MainActivity.this.isActivityFinsihed() || !MainActivity.this.isActivityForeground() || (bitmap = c0502e.b) == null) {
                MainActivity.this.checkUpdate();
            } else {
                MainActivity mainActivity = MainActivity.this;
                mainActivity.mAdView = DialogUtil.a(mainActivity, bitmap, new View$OnClickListenerC1137z(), new View$OnClickListenerC1118a(), new C1119b());
                MainActivity.this.mAdView.setOnDismissListener(new DialogInterface$OnDismissListenerC1120c());
                MainActivity.this.mAdView.show();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.homepage.MainActivity$m */
    /* loaded from: classes5.dex */
    public class C1121m implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C1121m() {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.C0501d c0501d) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "32188029")) {
                ipChange.ipc$dispatch("32188029", new Object[]{this, c0501d});
            } else {
                MainActivity.this.checkUpdate();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.homepage.MainActivity$n */
    /* loaded from: classes5.dex */
    public class C1122n implements HomeTabFragment.OnTabClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C1122n() {
        }

        @Override // cn.damai.homepage.ui.fragment.HomeTabFragment.OnTabClickListener
        public void onTabSelect(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "841777020")) {
                ipChange.ipc$dispatch("841777020", new Object[]{this, Integer.valueOf(i)});
            } else if (i != 0) {
                MainActivity.this.mZhiboView.f(8);
            } else if (MainActivity.this.mZhiboView.e()) {
                MainActivity.this.mZhiboView.f(0);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.homepage.MainActivity$o */
    /* loaded from: classes5.dex */
    public class C1123o implements PopupCallback {
        private static transient /* synthetic */ IpChange $ipChange;

        C1123o() {
        }

        @Override // cn.damai.homepage.util.window.PopupCallback
        public void cityChangeRefresh() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1812334617")) {
                ipChange.ipc$dispatch("1812334617", new Object[]{this});
            } else if (MainActivity.this.mHomeTabFragment != null) {
                MainActivity.this.mHomeTabFragment.refreshAllFragment();
            }
        }

        @Override // cn.damai.homepage.util.window.PopupCallback
        public void evaluateOnUserReject(@NonNull String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1492243975")) {
                ipChange.ipc$dispatch("-1492243975", new Object[]{this, str});
                return;
            }
            MainActivity mainActivity = MainActivity.this;
            mainActivity.showEvaluateTips(mainActivity.getString(R$string.damai_homepage_comment_await_comment_tips));
            MainActivity.this.reportUserOperation(str, 1);
        }

        @Override // cn.damai.homepage.util.window.PopupCallback
        public boolean isHomePageTab() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "866043200") ? ((Boolean) ipChange.ipc$dispatch("866043200", new Object[]{this})).booleanValue() : MainActivity.this.isHomePage();
        }

        @Override // cn.damai.homepage.util.window.PopupCallback
        public void loadFloat() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "742992035")) {
                ipChange.ipc$dispatch("742992035", new Object[]{this});
            } else {
                MainActivity.this.loadFloatInfo();
            }
        }

        @Override // cn.damai.homepage.util.window.PopupCallback
        public void showLottie() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-868955275")) {
                ipChange.ipc$dispatch("-868955275", new Object[]{this});
            } else {
                MainActivity.this.showLottieBeforeAlertDialog();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.homepage.MainActivity$p */
    /* loaded from: classes5.dex */
    public class C1124p implements CityLocationUtil.LocaltionListener {
        private static transient /* synthetic */ IpChange $ipChange;

        /* compiled from: Taobao */
        /* renamed from: cn.damai.homepage.MainActivity$p$a */
        /* loaded from: classes14.dex */
        public class DialogInterface$OnDismissListenerC1125a implements DialogInterface.OnDismissListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ boolean a;
            final /* synthetic */ SitesBean b;

            DialogInterface$OnDismissListenerC1125a(boolean z, SitesBean sitesBean) {
                this.a = z;
                this.b = sitesBean;
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "341104774")) {
                    ipChange.ipc$dispatch("341104774", new Object[]{this, dialogInterface});
                } else if (this.a) {
                    MainActivity.this.showCityChange(this.b.getCityName());
                } else {
                    MainActivity.this.checkRecentTicket();
                }
            }
        }

        C1124p() {
        }

        @Override // cn.damai.commonbusiness.city.util.CityLocationUtil.LocaltionListener
        public void onGetLocalFinsih() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-400375401")) {
                ipChange.ipc$dispatch("-400375401", new Object[]{this});
            } else {
                MainActivity.this.checkRecentTicket();
            }
        }

        @Override // cn.damai.commonbusiness.city.util.CityLocationUtil.LocaltionListener
        public void onGetLocalSuccess(SitesBean sitesBean) {
            IpChange ipChange = $ipChange;
            boolean z = true;
            if (AndroidInstantRuntime.support(ipChange, "947933437")) {
                ipChange.ipc$dispatch("947933437", new Object[]{this, sitesBean});
                return;
            }
            if ((sitesBean == null || TextUtils.getTrimmedLength(sitesBean.getCityId()) <= 0 || String.valueOf(mu0.b).equals(sitesBean.getCityId())) && MainActivity.this.mCurrentCity.equals(sitesBean.getCityName())) {
                z = false;
            }
            if (MainActivity.this.timeZoneDialog != null && MainActivity.this.timeZoneDialog.isShowing()) {
                MainActivity.this.timeZoneDialog.setOnDismissListener(new DialogInterface$OnDismissListenerC1125a(z, sitesBean));
            } else if (z) {
                MainActivity.this.showCityChange(sitesBean.getCityName());
            } else {
                MainActivity.this.checkRecentTicket();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.homepage.MainActivity$q */
    /* loaded from: classes14.dex */
    public class View$OnClickListenerC1126q implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC1126q() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1713450012")) {
                ipChange.ipc$dispatch("-1713450012", new Object[]{this, view});
            } else {
                MainActivity.this.checkRecentTicket();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.homepage.MainActivity$r */
    /* loaded from: classes14.dex */
    public class DialogInterface$OnClickListenerC1127r implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        DialogInterface$OnClickListenerC1127r() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-86955542")) {
                ipChange.ipc$dispatch("-86955542", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            if (MainActivity.this.mCityLocationUtil != null) {
                MainActivity.this.mCityLocationUtil.q();
            }
            dialogInterface.dismiss();
            xr.c(DamaiConstants.CITY_CHANGED, "");
            if (MainActivity.this.mHomeTabFragment != null) {
                MainActivity.this.mHomeTabFragment.refreshAllFragment();
            }
            MainActivity.this.checkRecentTicket();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.homepage.MainActivity$s */
    /* loaded from: classes5.dex */
    public class C1128s implements IPermissionListener {
        private static transient /* synthetic */ IpChange $ipChange;

        /* compiled from: Taobao */
        /* renamed from: cn.damai.homepage.MainActivity$s$a */
        /* loaded from: classes14.dex */
        public class DialogInterface$OnClickListenerC1129a implements DialogInterface.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            DialogInterface$OnClickListenerC1129a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1745332892")) {
                    ipChange.ipc$dispatch("1745332892", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                    return;
                }
                dialogInterface.dismiss();
                kr1.f(MainActivity.this);
                MainActivity.this.checkTimeZone(true);
            }
        }

        /* compiled from: Taobao */
        /* renamed from: cn.damai.homepage.MainActivity$s$b */
        /* loaded from: classes14.dex */
        public class DialogInterface$OnClickListenerC1130b implements DialogInterface.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            DialogInterface$OnClickListenerC1130b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1580053381")) {
                    ipChange.ipc$dispatch("-1580053381", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                    return;
                }
                dialogInterface.dismiss();
                MainActivity.this.checkTimeZone(true);
            }
        }

        C1128s() {
        }

        @Override // com.alibaba.pictures.picpermission.custom.IPermissionListener
        public void onPermissionDenied(@NotNull String[] strArr) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-684363117")) {
                ipChange.ipc$dispatch("-684363117", new Object[]{this, strArr});
            } else {
                MainActivity.this.checkTimeZone(true);
            }
        }

        @Override // com.alibaba.pictures.picpermission.custom.IPermissionListener
        public void onPermissionGranted() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "835600392")) {
                ipChange.ipc$dispatch("835600392", new Object[]{this});
                return;
            }
            MainActivity.this.checkTimeZone(false);
            MainActivity mainActivity = MainActivity.this;
            mainActivity.mCityLocationUtil = new CityLocationUtil(mainActivity, mainActivity.mLocaltionListener);
            MainActivity.this.mCityLocationUtil.p(true);
            MainActivity.this.mCityLocationUtil.n();
        }

        @Override // com.alibaba.pictures.picpermission.custom.IPermissionListener
        public void onShowRationale(@NotNull String[] strArr) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-139960667")) {
                ipChange.ipc$dispatch("-139960667", new Object[]{this, strArr});
            } else {
                gr1.a(MainActivity.this, "获取你所在城市的演出赛事信息，帮助你找到附近的演出赛事", Arrays.asList(strArr), false, new DialogInterface$OnClickListenerC1129a(), new DialogInterface$OnClickListenerC1130b());
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.homepage.MainActivity$t */
    /* loaded from: classes5.dex */
    public class C1131t implements LoginLogoutBroadcastReceiver.LoginCallback {
        private static transient /* synthetic */ IpChange $ipChange;

        C1131t() {
        }

        @Override // cn.damai.homepage.util.LoginLogoutBroadcastReceiver.LoginCallback
        public void loginLogout() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-858411520")) {
                ipChange.ipc$dispatch("-858411520", new Object[]{this});
                return;
            }
            C9021d.f().doNotifyUserLogout();
            MainActivity.this.mHomeTabFragment.logoutRefreshUI();
        }

        @Override // cn.damai.homepage.util.LoginLogoutBroadcastReceiver.LoginCallback
        public void loginSuccess() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1074546979")) {
                ipChange.ipc$dispatch("-1074546979", new Object[]{this});
            } else {
                C9021d.f().doNotifyUserLogin(Login.getUserId());
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.homepage.MainActivity$u */
    /* loaded from: classes14.dex */
    public class DialogInterface$OnClickListenerC1132u implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        DialogInterface$OnClickListenerC1132u() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1949252308")) {
                ipChange.ipc$dispatch("-1949252308", new Object[]{this, dialogInterface, Integer.valueOf(i)});
            } else {
                MainActivity.this.exitApp();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.homepage.MainActivity$v */
    /* loaded from: classes5.dex */
    public class C1133v implements Action<String> {
        private static transient /* synthetic */ IpChange $ipChange;

        C1133v() {
        }

        @Override // cn.damai.message.observer.Action
        /* renamed from: a */
        public void call(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1160692255")) {
                ipChange.ipc$dispatch("-1160692255", new Object[]{this, str});
            } else if (!TextUtils.isEmpty(str)) {
                MainActivity.this.lottieFilePath = str;
                MainActivity.this.lottieLoadSuccess = true;
                if (!MainActivity.this.canShowLottie || MainActivity.this.homeIsOnPause) {
                    return;
                }
                MainActivity.this.showLottie();
            } else {
                MainActivity.this.lottieLoadSuccess = false;
                cb1.b("LottieDownLoad", "营销动画下载失败！");
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.homepage.MainActivity$w */
    /* loaded from: classes14.dex */
    public class DialogInterface$OnDismissListenerC1134w implements DialogInterface.OnDismissListener {
        private static transient /* synthetic */ IpChange $ipChange;

        DialogInterface$OnDismissListenerC1134w() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "846647613")) {
                ipChange.ipc$dispatch("846647613", new Object[]{this, dialogInterface});
            } else {
                MainActivity.this.checkUpdate();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.homepage.MainActivity$x */
    /* loaded from: classes5.dex */
    public class C1135x implements TickletBusinessUtil.PopNoShow {
        private static transient /* synthetic */ IpChange $ipChange;

        C1135x() {
        }

        @Override // cn.damai.homepage.util.TickletBusinessUtil.PopNoShow
        public void popNoShow() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-333379772")) {
                ipChange.ipc$dispatch("-333379772", new Object[]{this});
            } else {
                MainActivity.this.checkAlertDialog();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.homepage.MainActivity$y */
    /* loaded from: classes14.dex */
    public class View$OnClickListenerC1136y implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC1136y() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1698595049")) {
                ipChange.ipc$dispatch("1698595049", new Object[]{this, view});
            } else if (MainActivity.this.isFinishing() || MainActivity.this.mTabbarManager == null) {
            } else {
                MainActivity.this.mTabbarManager.m(DamaiConstants.TAB_FIND);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.homepage.MainActivity$z */
    /* loaded from: classes14.dex */
    public class View$OnClickListenerC1137z implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC1137z() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-49825495")) {
                ipChange.ipc$dispatch("-49825495", new Object[]{this, view});
                return;
            }
            MainAlertEntity mainAlertEntity = MainActivity.this.mMainAlertEntity;
            if (mainAlertEntity != null && mainAlertEntity.item != null) {
                Bundle bundle = new Bundle();
                bundle.putBoolean(MonitorType.SKIP, true);
                bundle.putString("from_page", "homepage");
                DMNav.from(MainActivity.this).withExtras(bundle).toUri(MainActivity.this.mMainAlertEntity.item.schema);
                if (MainAlertEntity.PICK_TYPE_CALLBACK.equals(MainActivity.this.mMainAlertEntity.item.pkType)) {
                    C0529c.e().x(py0.I().z(String.valueOf(MainActivity.this.mMainAlertEntity.item.circleId), "0", 0, MainActivity.this.mMainAlertEntity.item.imageUrl));
                } else {
                    C0529c e = C0529c.e();
                    py0 I = py0.I();
                    MainAlertEntity mainAlertEntity2 = MainActivity.this.mMainAlertEntity;
                    MainAlertEntity.MainAlertModel mainAlertModel = mainAlertEntity2.item;
                    e.x(I.y(mainAlertModel.schema, mainAlertModel.scm, mainAlertEntity2.id, String.valueOf(mainAlertModel.circleId), MainActivity.this.mMainAlertEntity.item.imageUrl));
                }
            }
            MainActivity.this.mAdView.dismiss();
        }
    }

    private void addFragment(Fragment fragment) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1397994226")) {
            ipChange.ipc$dispatch("-1397994226", new Object[]{this, fragment});
            return;
        }
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R$id.homepage_fragment_container, fragment);
        beginTransaction.commitAllowingStateLoss();
        showPoplayer("HomeMainFragment", "");
    }

    private void backHome() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2088216515")) {
            ipChange.ipc$dispatch("-2088216515", new Object[]{this});
        } else if (!mt1.k) {
            newPopup(mt1.EVENT_BACK_TO_HOME);
        } else {
            mt1.k = false;
        }
    }

    private boolean checkKeyStore() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-573763551")) {
            return ((Boolean) ipChange.ipc$dispatch("-573763551", new Object[]{this})).booleanValue();
        }
        String keyStoreInfo = getKeyStoreInfo(this);
        String keyFromInner = getKeyFromInner(this);
        if (keyFromInner == null) {
            keyFromInner = "";
        }
        if (TextUtils.isEmpty(keyStoreInfo)) {
            return true;
        }
        return keyStoreInfo.equals(keyFromInner);
    }

    private void checkLocation() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-476326582")) {
            ipChange.ipc$dispatch("-476326582", new Object[]{this});
            return;
        }
        String[] strArr = mr1.LOCATION;
        if (ir1.i(strArr)) {
            checkTimeZone(false);
            CityLocationUtil cityLocationUtil = new CityLocationUtil(this, this.mLocaltionListener);
            this.mCityLocationUtil = cityLocationUtil;
            cityLocationUtil.p(true);
            this.mCityLocationUtil.n();
        } else if (!TextUtils.isEmpty(z20.B(SP_KEY_LOCATION_DIALOG_SHOWED))) {
            checkTimeZone(true);
        } else {
            z20.T(SP_KEY_LOCATION_DIALOG_SHOWED, "locationExaDes");
            new Permission(mu0.a(), new PermissionModel(strArr, "位置权限使用说明", Integer.valueOf(R$drawable.permission_location_icon), "用于为你提供所在城市演出和场馆信息及帮助你找到附近的演出")).a(new C1128s()).b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkRecentTicket() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1125932680")) {
            ipChange.ipc$dispatch("-1125932680", new Object[]{this});
        } else if (LoginManager.k().q()) {
            TickletBusinessUtil tickletBusinessUtil = this.tickletBusinessUtil;
            if (tickletBusinessUtil != null) {
                tickletBusinessUtil.g(this.mTickletContainer, true);
            }
        } else {
            checkAlertDialog();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkUpdate() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "646321718")) {
            ipChange.ipc$dispatch("646321718", new Object[]{this});
        } else {
            UpdateUtil.e();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0041 A[Catch: Exception -> 0x0097, TryCatch #0 {Exception -> 0x0097, blocks: (B:7:0x0018, B:10:0x0026, B:12:0x002d, B:14:0x0039, B:16:0x0041, B:18:0x0047, B:20:0x004b, B:22:0x0059, B:23:0x0078), top: B:28:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0078 A[Catch: Exception -> 0x0097, TRY_LEAVE, TryCatch #0 {Exception -> 0x0097, blocks: (B:7:0x0018, B:10:0x0026, B:12:0x002d, B:14:0x0039, B:16:0x0041, B:18:0x0047, B:20:0x004b, B:22:0x0059, B:23:0x0078), top: B:28:0x0018 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void eventShowAlterTimer(cn.damai.homepage.MainAlertEntity.MainAlertModel r10) {
        /*
            r9 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = cn.damai.homepage.MainActivity.$ipChange
            java.lang.String r1 = "1642292678"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 1
            r4 = 0
            r5 = 2
            if (r2 == 0) goto L17
            java.lang.Object[] r2 = new java.lang.Object[r5]
            r2[r4] = r9
            r2[r3] = r10
            r0.ipc$dispatch(r1, r2)
            return
        L17:
            r0 = 0
            java.lang.String r1 = tb.z20.J()     // Catch: java.lang.Exception -> L97
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Exception -> L97
            r6 = 0
            java.lang.String r8 = ","
            if (r2 != 0) goto L38
            java.lang.String[] r1 = r1.split(r8)     // Catch: java.lang.Exception -> L97
            int r2 = r1.length     // Catch: java.lang.Exception -> L97
            if (r2 != r5) goto L38
            r0 = r1[r4]     // Catch: java.lang.Exception -> L97
            r1 = r1[r3]     // Catch: java.lang.Exception -> L97
            r2 = -1
            long r1 = tb.jm1.k(r1, r2)     // Catch: java.lang.Exception -> L97
            goto L39
        L38:
            r1 = r6
        L39:
            java.lang.String r3 = r10.pkid     // Catch: java.lang.Exception -> L97
            boolean r0 = android.text.TextUtils.equals(r3, r0)     // Catch: java.lang.Exception -> L97
            if (r0 == 0) goto L78
            long r3 = r10.nextAlert     // Catch: java.lang.Exception -> L97
            int r0 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r0 != 0) goto L4b
            r9.checkUpdate()     // Catch: java.lang.Exception -> L97
            return
        L4b:
            long r3 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> L97
            long r3 = r3 - r1
            r0 = 1000(0x3e8, double:4.94E-321)
            long r3 = r3 / r0
            long r0 = r10.nextAlert     // Catch: java.lang.Exception -> L97
            int r2 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r2 <= 0) goto L9b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L97
            r0.<init>()     // Catch: java.lang.Exception -> L97
            java.lang.String r1 = r10.pkid     // Catch: java.lang.Exception -> L97
            r0.append(r1)     // Catch: java.lang.Exception -> L97
            r0.append(r8)     // Catch: java.lang.Exception -> L97
            long r1 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> L97
            r0.append(r1)     // Catch: java.lang.Exception -> L97
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> L97
            tb.z20.D0(r0)     // Catch: java.lang.Exception -> L97
            r9.showADOrNewFunctionDialog(r10)     // Catch: java.lang.Exception -> L97
            goto L9b
        L78:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L97
            r0.<init>()     // Catch: java.lang.Exception -> L97
            java.lang.String r1 = r10.pkid     // Catch: java.lang.Exception -> L97
            r0.append(r1)     // Catch: java.lang.Exception -> L97
            r0.append(r8)     // Catch: java.lang.Exception -> L97
            long r1 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> L97
            r0.append(r1)     // Catch: java.lang.Exception -> L97
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> L97
            tb.z20.D0(r0)     // Catch: java.lang.Exception -> L97
            r9.showADOrNewFunctionDialog(r10)     // Catch: java.lang.Exception -> L97
            goto L9b
        L97:
            r10 = move-exception
            r10.printStackTrace()
        L9b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.homepage.MainActivity.eventShowAlterTimer(cn.damai.homepage.MainAlertEntity$MainAlertModel):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void exitApp() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "539468228")) {
            ipChange.ipc$dispatch("539468228", new Object[]{this});
            return;
        }
        z20.l0(false);
        on1.d();
        onDestroy();
        finish();
        rg0.a();
        Process.killProcess(Process.myPid());
        System.exit(0);
    }

    private void initBundle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-317346319")) {
            ipChange.ipc$dispatch("-317346319", new Object[]{this});
        } else if (getIntent() != null) {
            this.mTabExtra = TabExtra.fromIntent(getIntent());
            if (AppConfig.v()) {
                cb1.c("IntentTest", "onCreate-initBundle tabExtra :" + m61.e(this.mTabExtra));
            }
        }
    }

    private void initLater() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1780274027")) {
            ipChange.ipc$dispatch("1780274027", new Object[]{this});
        } else {
            new Handler().postDelayed(new Runnable() { // from class: cn.damai.homepage.MainActivity.5
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-695840661")) {
                        ipChange2.ipc$dispatch("-695840661", new Object[]{this});
                        return;
                    }
                    try {
                        ko.d().startCheckAndUpdateCacheableKV();
                    } catch (Exception e) {
                        cb1.a(e.getMessage());
                    }
                }
            }, 2000L);
        }
    }

    private void initLottieView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "91522383")) {
            ipChange.ipc$dispatch("91522383", new Object[]{this});
            return;
        }
        this.mAnimationView = (HomeLottieView) findViewById(R$id.homepage_lottie_animation);
        this.mDMMessage.b("LottieDownLoadSuccess", new C1133v());
    }

    private void initPopUpLine() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-594564713")) {
            ipChange.ipc$dispatch("-594564713", new Object[]{this});
            return;
        }
        cb1.b(mt1.TAG, "initPopUpLine");
        if (this.isFirstStart) {
            if (isNewPopupAble()) {
                newPopup(isGotoOtherPage() ? mt1.EVENT_USED_HOME : mt1.EVENT_NO_USED_HOME);
            } else {
                checkLocation();
            }
            mt1.k = false;
            this.isFirstStart = false;
            return;
        }
        backHome();
    }

    private void initTabBarLayout() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2026750251")) {
            ipChange.ipc$dispatch("2026750251", new Object[]{this});
            return;
        }
        this.mTabbarLayout = (TabbarLayout) findViewById(R$id.homemain_tabbar);
        DamaiTabbarManager damaiTabbarManager = new DamaiTabbarManager(this, this.mTabbarLayout, this);
        this.mTabbarManager = damaiTabbarManager;
        damaiTabbarManager.j(DamaiConstants.TAB_HOME);
        this.mTabbarManager.h().d(this);
    }

    private void initTicklet(DialogInterface.OnDismissListener onDismissListener, TickletBusinessUtil.PopNoShow popNoShow) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1655333053")) {
            ipChange.ipc$dispatch("1655333053", new Object[]{this, onDismissListener, popNoShow});
            return;
        }
        if (this.tickletBusinessUtil == null) {
            this.tickletBusinessUtil = new TickletBusinessUtil(this);
        }
        this.tickletBusinessUtil.i();
        this.tickletBusinessUtil.d(onDismissListener, popNoShow);
    }

    private void initWantSee() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1310976500")) {
            ipChange.ipc$dispatch("1310976500", new Object[]{this});
            return;
        }
        WantSeePosterTips wantSeePosterTips = (WantSeePosterTips) findViewById(R$id.want_see_project_tips);
        this.wantSeeProjectTips = wantSeePosterTips;
        wantSeePosterTips.setPageSource(WantSeePosterTips.AbstractC1555b.C1557b.INSTANCE);
        registerWantSee();
    }

    private void initZhibotiao() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-870566228")) {
            ipChange.ipc$dispatch("-870566228", new Object[]{this});
        } else {
            this.mZhiboView = new ZhiboView(this, findViewById(R$id.layout_zhibotiao));
        }
    }

    private boolean isGotoOtherPage() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-368963847") ? ((Boolean) ipChange.ipc$dispatch("-368963847", new Object[]{this})).booleanValue() : "true".equals(z20.B(APP_GOTO_OTHER_PAGE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHomePage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1303350927")) {
            return ((Boolean) ipChange.ipc$dispatch("1303350927", new Object[]{this})).booleanValue();
        }
        HomeFragmentAgent homeFragmentAgent = this.mHomeTabFragment;
        return homeFragmentAgent != null && homeFragmentAgent.getCurIndex() == 0;
    }

    private boolean isNewPopupAble() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "645165879") ? ((Boolean) ipChange.ipc$dispatch("645165879", new Object[]{this})).booleanValue() : StartConfig.isPopupOpenAble() && this.mIsUseNewHome;
    }

    private void leftHome() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1990919907")) {
            ipChange.ipc$dispatch("-1990919907", new Object[]{this});
        } else if (!mt1.l) {
            z20.T(APP_GOTO_OTHER_PAGE, "true");
        } else {
            mt1.l = false;
        }
    }

    private void loadConfigInfo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-655065715")) {
            ipChange.ipc$dispatch("-655065715", new Object[]{this});
            return;
        }
        BottomSheetRequest bottomSheetRequest = new BottomSheetRequest();
        bottomSheetRequest.cityId = z20.c();
        bottomSheetRequest.request(new DMMtopRequestListener<BottomSheetBean>(BottomSheetBean.class) { // from class: cn.damai.homepage.MainActivity.13
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "257507340")) {
                    ipChange2.ipc$dispatch("257507340", new Object[]{this, str, str2});
                    return;
                }
                z20.T(DamaiTabbarManager.TabBar_SERVER_DATA, null);
                MainActivity.this.returnBottomSheetError();
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(BottomSheetBean bottomSheetBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1265340943")) {
                    ipChange2.ipc$dispatch("1265340943", new Object[]{this, bottomSheetBean});
                    return;
                }
                z20.T(DamaiTabbarManager.TabBar_SERVER_DATA, JSON.toJSONString(bottomSheetBean));
                MainActivity.this.returnBottomSheet(bottomSheetBean);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadFloatInfo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-532858397")) {
            ipChange.ipc$dispatch("-532858397", new Object[]{this});
            return;
        }
        this.mZhibotiaoBean = null;
        new HomeFloatLayerRequest().request(new DMMtopRequestListener<HomeFloatResBean>(HomeFloatResBean.class) { // from class: cn.damai.homepage.MainActivity.14
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "249747981")) {
                    ipChange2.ipc$dispatch("249747981", new Object[]{this, str, str2});
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(HomeFloatResBean homeFloatResBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-957139532")) {
                    ipChange2.ipc$dispatch("-957139532", new Object[]{this, homeFloatResBean});
                } else if (homeFloatResBean == null || !homeFloatResBean.isValid()) {
                } else {
                    MainActivity.this.updateFloatUi(homeFloatResBean);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadImage(BottomSheetBean bottomSheetBean, ImageDownLoader imageDownLoader) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2114753937")) {
            ipChange.ipc$dispatch("2114753937", new Object[]{this, bottomSheetBean, imageDownLoader});
            return;
        }
        List<BottomSheetBean.Result> list = bottomSheetBean.content;
        if (wh2.e(list) > 0) {
            this.checkedSuccess = false;
            this.uncheckSuccess = false;
            this.reCheckSuccess = true;
            if (this.index >= wh2.e(list)) {
                z20.T(DamaiTabbarManager.TabBar, JSON.toJSONString(bottomSheetBean));
                refreshTabBarLayout();
                return;
            }
            BottomSheetBean.Result result = list.get(this.index);
            if (result != null) {
                if (TextUtils.equals(result.type, "1")) {
                    this.reCheckSuccess = false;
                    this.checkedSuccess = true;
                    imageDownLoader.j(result.reCheckedPic, 135, 135, new C1109d(bottomSheetBean, imageDownLoader));
                }
                imageDownLoader.j(result.checkedPic, 135, 135, new C1110e(bottomSheetBean, imageDownLoader));
                imageDownLoader.j(result.defaultPic, 135, 135, new C1111f(bottomSheetBean, imageDownLoader));
            }
            this.index++;
        }
    }

    private void newPopup(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-74038271")) {
            ipChange.ipc$dispatch("-74038271", new Object[]{this, str});
            return;
        }
        cb1.b(mt1.TAG, "newPopup eventType=" + str);
        if (this.isFirstStart) {
            mt1 mt1Var = new mt1(this);
            this.windowStart = mt1Var;
            mt1Var.a(this.tickletBusinessUtil, this.mTickletContainer, this.wantSeeProjectTips, new C1123o());
        }
        if (this.windowStart != null) {
            cb1.b(mt1.TAG, "isFirstStart=" + this.isFirstStart + "  eventType=" + str);
            this.windowStart.b(str, this.isFirstStart);
        }
    }

    private void refreshTabBarLayout() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1690046620")) {
            ipChange.ipc$dispatch("-1690046620", new Object[]{this});
        } else if (this.mTabbarLayout == null) {
        } else {
            DamaiTabbarManager damaiTabbarManager = new DamaiTabbarManager(this, this.mTabbarLayout, this);
            this.mTabbarManager = damaiTabbarManager;
            damaiTabbarManager.j(DamaiConstants.TAB_HOME);
            this.mTabbarManager.h().d(this);
        }
    }

    private void registerLoginLogoutBroadcastReceiver() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1699523741")) {
            ipChange.ipc$dispatch("-1699523741", new Object[]{this});
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(vb1.BROADCAST_LOGIN_SUCCESS);
        intentFilter.addAction(vb1.BROADCAST_LOGOUT_SUCCESS);
        LoginLogoutBroadcastReceiver loginLogoutBroadcastReceiver = new LoginLogoutBroadcastReceiver(new Runnable() { // from class: cn.damai.homepage.MainActivity.36
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "2104824745")) {
                    ipChange2.ipc$dispatch("2104824745", new Object[]{this});
                } else if (MainActivity.this.mHomeTabFragment != null) {
                    cb1.c("HomeUI", "do refreshFragment");
                    MainActivity.this.mHomeTabFragment.refreshHomeFragment(false);
                }
            }
        }, new C1131t());
        this.mLoginReceiver = loginLogoutBroadcastReceiver;
        registerReceiver(loginLogoutBroadcastReceiver, intentFilter);
    }

    private void registerWantSee() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-167403833")) {
            ipChange.ipc$dispatch("-167403833", new Object[]{this});
            return;
        }
        WantSeeTips wantSeeTips = (WantSeeTips) findViewById(R$id.want_see_tips);
        this.wantSeeTips = wantSeeTips;
        wantSeeTips.setPageSource(WantSeeTips.AbstractC1562a.C1565c.INSTANCE);
        new xr().b("showFollowTips", new C1107b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportUserOperation(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1768522842")) {
            ipChange.ipc$dispatch("1768522842", new Object[]{this, str, Integer.valueOf(i)});
            return;
        }
        CommentListOptrRequest commentListOptrRequest = new CommentListOptrRequest();
        commentListOptrRequest.mecPerformId = str;
        commentListOptrRequest.operType = i;
        commentListOptrRequest.request(new DMMtopRequestListener<CommentOptrBean>(CommentOptrBean.class) { // from class: cn.damai.homepage.MainActivity.24
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str2, String str3) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "9207852")) {
                    ipChange2.ipc$dispatch("9207852", new Object[]{this, str2, str3});
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(CommentOptrBean commentOptrBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "465209334")) {
                    ipChange2.ipc$dispatch("465209334", new Object[]{this, commentOptrBean});
                } else {
                    Boolean.valueOf(commentOptrBean.model);
                }
            }
        });
    }

    private void setPushUt() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1718674444")) {
            ipChange.ipc$dispatch("1718674444", new Object[]{this});
        } else if (PermissionsHelper.a(this)) {
            C0529c.e().A(py0.I().J("1", "", ""), py0.CUSTOM_PUSH, py0.PUSH_PAGE);
        } else {
            C0529c.e().A(py0.I().J("0", "", ""), py0.CUSTOM_PUSH, py0.PUSH_PAGE);
        }
    }

    private void showADOrNewFunctionDialog(MainAlertEntity.MainAlertModel mainAlertModel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-565532625")) {
            ipChange.ipc$dispatch("-565532625", new Object[]{this, mainAlertModel});
            return;
        }
        C0504a.b().c(mainAlertModel.imageUrl).e(new C1121m()).n(new C1117l(mainAlertModel)).f();
        if (MainAlertEntity.PICK_TYPE_CALLBACK.equals(this.mMainAlertEntity.item.pkType)) {
            PopUpAdvertCallBackRequest popUpAdvertCallBackRequest = new PopUpAdvertCallBackRequest();
            MainAlertEntity.MainAlertModel mainAlertModel2 = this.mMainAlertEntity.item;
            popUpAdvertCallBackRequest.pkId = mainAlertModel2.pkid;
            popUpAdvertCallBackRequest.pkType = mainAlertModel2.pkType;
            popUpAdvertCallBackRequest.request(new DMMtopRequestListener(Object.class) { // from class: cn.damai.homepage.MainActivity.30
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str, String str2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-200294841")) {
                        ipChange2.ipc$dispatch("-200294841", new Object[]{this, str, str2});
                    } else {
                        Log.d("debug", "log onFail");
                    }
                }

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onSuccess(Object obj) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "2070712914")) {
                        ipChange2.ipc$dispatch("2070712914", new Object[]{this, obj});
                    } else {
                        Log.d("debug", "log onSuccess");
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showCityChange(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-513580011")) {
            ipChange.ipc$dispatch("-513580011", new Object[]{this, str});
        } else if (TextUtils.getTrimmedLength(str) <= 0) {
            checkRecentTicket();
        } else {
            DMThemeDialog dMThemeDialog = new DMThemeDialog(this);
            dMThemeDialog.o("地理位置变更").r(DMThemeDialog.DMDialogTheme.THEME_LOCATION).k(getString(R$string.change_city_tip, new Object[]{str})).i(getString(R$string.change_city, new Object[]{str}), new DialogInterface$OnClickListenerC1127r()).g(true, new View$OnClickListenerC1126q());
            if (isFinishing()) {
                return;
            }
            dMThemeDialog.show();
        }
    }

    private void showDnaProtocolDialog(MainAlertEntity.MainAlertModel mainAlertModel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1709700814")) {
            ipChange.ipc$dispatch("-1709700814", new Object[]{this, mainAlertModel});
            return;
        }
        C0504a.b().c(mainAlertModel.imageUrl).e(new C1116k()).n(new AnonymousClass25(mainAlertModel)).f();
        if (MainAlertEntity.PICK_HID_TYPE_CALLBACK.equals(this.mMainAlertEntity.item.pkType)) {
            PopUpAdvertCallBackRequest popUpAdvertCallBackRequest = new PopUpAdvertCallBackRequest();
            MainAlertEntity.MainAlertModel mainAlertModel2 = this.mMainAlertEntity.item;
            popUpAdvertCallBackRequest.pkId = mainAlertModel2.pkid;
            popUpAdvertCallBackRequest.pkType = mainAlertModel2.pkType;
            popUpAdvertCallBackRequest.request(new DMMtopRequestListener(Object.class) { // from class: cn.damai.homepage.MainActivity.27
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str, String str2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-14070225")) {
                        ipChange2.ipc$dispatch("-14070225", new Object[]{this, str, str2});
                    } else {
                        Log.d("debug", "log onFail");
                    }
                }

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onSuccess(Object obj) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1066258582")) {
                        ipChange2.ipc$dispatch("-1066258582", new Object[]{this, obj});
                    } else {
                        Log.d("debug", "log onSuccess");
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showEvaluateDialog(CouponListResponse.ContentList contentList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1490210138")) {
            ipChange.ipc$dispatch("1490210138", new Object[]{this, contentList});
            return;
        }
        HomepageEvaluateDialog homepageEvaluateDialog = new HomepageEvaluateDialog(this, contentList, 1010, new DialogInterface$OnDismissListenerC1114i());
        homepageEvaluateDialog.s(new C1115j());
        homepageEvaluateDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showEvaluateTips(String str) {
        final View findViewById;
        TextView textView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2094038815")) {
            ipChange.ipc$dispatch("2094038815", new Object[]{this, str});
        } else if (this.mZhiboView == null || this.mZhibotiaoBean == null) {
            ContentPopTipPanel contentPopTipPanel = this.mPopTipPanel;
            if ((contentPopTipPanel != null && contentPopTipPanel.c()) || (findViewById = findViewById(R$id.layout_homepage_evaluate_tips)) == null || (textView = (TextView) findViewById.findViewById(R$id.tv_homepage_evaluate_tips)) == null) {
                return;
            }
            textView.setText(str);
            findViewById.setVisibility(0);
            findViewById.postDelayed(new Runnable() { // from class: cn.damai.homepage.MainActivity.16
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1403760167")) {
                        ipChange2.ipc$dispatch("1403760167", new Object[]{this});
                    } else {
                        findViewById.setVisibility(8);
                    }
                }
            }, DanmakuFactory.MIN_DANMAKU_DURATION_V);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    public void showLottie() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "506495591")) {
            ipChange.ipc$dispatch("506495591", new Object[]{this});
            return;
        }
        this.lottieIsShowed = true;
        HomeData homeData = this.mHomeData;
        if (homeData == null || TextUtils.isEmpty(homeData.lottieType)) {
            return;
        }
        int i = DisplayMetrics.getwidthPixels(t60.b(this));
        int i2 = (i * 1624) / FeatureFactory.PRIORITY_ABOVE_NORMAL;
        int i3 = i2 - DisplayMetrics.getheightPixels(t60.b(this));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i2);
        String str = this.mHomeData.lottieType;
        if (!"1".equals(str)) {
            if ("2".equals(str)) {
                if (i3 > 0) {
                    this.mAnimationView.setTranslationY(i3 / 2);
                } else {
                    layoutParams.gravity = 17;
                }
            } else if ("3".equals(str)) {
                if (i3 > 0) {
                    this.mAnimationView.setTranslationY(i3);
                } else {
                    layoutParams.gravity = 80;
                }
            }
        }
        this.mAnimationView.setLayoutParams(layoutParams);
        if (TextUtils.isEmpty(this.lottieFilePath)) {
            return;
        }
        ky0.d().j(this.mAnimationView, this.lottieFilePath);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLottieBeforeAlertDialog() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-551032834")) {
            ipChange.ipc$dispatch("-551032834", new Object[]{this});
            return;
        }
        this.canShowLottie = true;
        if (this.mAnimationView == null || !this.lottieLoadSuccess || this.homeIsOnPause) {
            return;
        }
        showLottie();
    }

    private void showPoplayer(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-779597158")) {
            ipChange.ipc$dispatch("-779597158", new Object[]{this, str, str2});
            return;
        }
        Intent intent = new Intent(PopLayer.ACTION_FRAGMENT_SWITCH);
        intent.putExtra(PopLayer.EXTRA_KEY_FRAGMENT_NAME, str);
        intent.putExtra(PopLayer.EXTRA_KEY_FRAGMENT_PARAM, str2);
        intent.putExtra(PopLayer.EXTRA_KEY_FRAGMENT_NEED_ACTIVITY_PARAM, true);
        LocalBroadcastManager.getInstance(this.mContext).sendBroadcast(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitIsFoldScreenUt() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "211384533")) {
            ipChange.ipc$dispatch("211384533", new Object[]{this});
            return;
        }
        try {
            boolean g = c80.g(this);
            HashMap<String, String> f = d23.f();
            C0525a.C0527b c0527b = new C0525a.C0527b();
            c0527b.i("home").f("screen_type").l(g ? "fold_screen" : "normal_screen").g(false).j(f);
            C0529c.e().x(c0527b);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateFloatUi(HomeFloatResBean homeFloatResBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1615865052")) {
            ipChange.ipc$dispatch("-1615865052", new Object[]{this, homeFloatResBean});
        } else if (isFinishing()) {
        } else {
            if (homeFloatResBean.isPopContent()) {
                TabExtraBean validBean = HomeContentFloatBean.getValidBean(homeFloatResBean.item);
                if (validBean != null) {
                    this.mPopTipPanel.d(validBean);
                    TabbarDataManager.e().i(DamaiConstants.TAB_FIND, validBean);
                }
                this.mZhiboView.i(null, this.mHomeTabFragment);
            } else if (homeFloatResBean.isZhiBo()) {
                final HomeZhibotiaoBean validBean2 = HomeZhibotiaoBean.getValidBean(homeFloatResBean.item);
                this.mZhibotiaoBean = validBean2;
                new Handler().postDelayed(new Runnable() { // from class: cn.damai.homepage.MainActivity.15
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // java.lang.Runnable
                    public void run() {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "1600273672")) {
                            ipChange2.ipc$dispatch("1600273672", new Object[]{this});
                        } else {
                            MainActivity.this.mZhiboView.i(validBean2, MainActivity.this.mHomeTabFragment);
                        }
                    }
                }, 1000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wantActionShow(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "148810826")) {
            ipChange.ipc$dispatch("148810826", new Object[]{this, str});
        } else if ((isNewPopupAble() && new b03().c(this, str, this.wantSeeTips, this.wantSeeProjectTips)) || g03.INSTANCE.e(this, new C1108c(this, str)) || this.wantSeeTips == null || this.wantSeeProjectTips.getVisibility() != 8) {
        } else {
            this.wantSeeTips.setPageSource(WantSeeTips.AbstractC1562a.C1565c.INSTANCE);
            this.wantSeeTips.showAnim();
        }
    }

    public void checkAlertDialog() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1896631623")) {
            ipChange.ipc$dispatch("1896631623", new Object[]{this});
            return;
        }
        showLottieBeforeAlertDialog();
        PopUpAdvertRequest popUpAdvertRequest = new PopUpAdvertRequest();
        if (AppConfig.g().equals(AppConfig.EnvMode.prepare) && z20.j()) {
            popUpAdvertRequest.viewDate = z20.k();
        }
        popUpAdvertRequest.request(new DMMtopRequestListener<MainAlertEntity>(MainAlertEntity.class) { // from class: cn.damai.homepage.MainActivity.21
            private static transient /* synthetic */ IpChange $ipChange;

            /* compiled from: Taobao */
            /* renamed from: cn.damai.homepage.MainActivity$21$a */
            /* loaded from: classes14.dex */
            public class DialogInterface$OnDismissListenerC1102a implements DialogInterface.OnDismissListener {
                private static transient /* synthetic */ IpChange $ipChange;

                DialogInterface$OnDismissListenerC1102a() {
                }

                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1561255834")) {
                        ipChange.ipc$dispatch("-1561255834", new Object[]{this, dialogInterface});
                    } else {
                        MainActivity.this.checkUpdate();
                    }
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "32485929")) {
                    ipChange2.ipc$dispatch("32485929", new Object[]{this, str, str2});
                } else {
                    MainActivity.this.checkUpdate();
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(MainAlertEntity mainAlertEntity) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1930616813")) {
                    ipChange2.ipc$dispatch("1930616813", new Object[]{this, mainAlertEntity});
                } else if (mainAlertEntity == null) {
                    MainActivity.this.checkUpdate();
                } else if (!MainActivity.this.isHomePage()) {
                    MainActivity.this.checkUpdate();
                } else if ("3".equals(mainAlertEntity.type)) {
                    MainActivity.this.showEvaluateDialog(mainAlertEntity.content);
                } else if (MainActivity.this.mMemberDialogManger != null && MainActivity.this.mMemberDialogManger.k(mainAlertEntity)) {
                    MainActivity.this.mMemberDialogManger.h(mainAlertEntity, new DialogInterface$OnDismissListenerC1102a());
                } else {
                    MainActivity.this.showCycleDisplayRequiredDialog(mainAlertEntity);
                }
            }
        });
    }

    public void checkTimeZone(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-632041170")) {
            ipChange.ipc$dispatch("-632041170", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        try {
            List asList = Arrays.asList("Asia/Chongqing", "Asia/Harbin", "Asia/Hong_Kong", "Asia/Macau", "Asia/Shanghai", "Asia/Taipei", "Asia/Urumqi");
            String id = TimeZone.getDefault().getID();
            if (asList.contains(id)) {
                if (z) {
                    checkRecentTicket();
                    return;
                }
                return;
            }
            String b = OrangeConfigCenter.c().b(on1.HOME_OTHER_TIME_ZONE_IN_CHINA, "otherzone", "");
            if (!TextUtils.isEmpty(b) && b.contains(id)) {
                if (z) {
                    checkRecentTicket();
                }
            } else if (us.a(this).equals(id)) {
                if (z) {
                    checkRecentTicket();
                }
            } else {
                DMDialog dMDialog = new DMDialog(this);
                this.timeZoneDialog = dMDialog;
                dMDialog.o(false);
                this.timeZoneDialog.q("未特殊提示的，抢票和演出时间均为北京时间为准");
                this.timeZoneDialog.n("知道了", new DialogInterface$OnClickListenerC1113h(id, z));
                this.timeZoneDialog.show();
            }
        } catch (Exception e) {
            if (z) {
                checkRecentTicket();
            }
            cb1.b("checkTimeZone", e.getMessage());
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1844896629")) {
            ipChange.ipc$dispatch("-1844896629", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.commonbusiness.pageut.PageUtExecutor.FragmentPropertiesProvider
    public Map get(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2129234640")) {
            return (Map) ipChange.ipc$dispatch("-2129234640", new Object[]{this, str});
        }
        Log.e("abtest", " ==================== acvitivty get : " + str);
        if (TextUtils.isEmpty(str)) {
            return new HashMap();
        }
        return this.fragmentPropertiesMap.get(str);
    }

    public HomeData getData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-842551284") ? (HomeData) ipChange.ipc$dispatch("-842551284", new Object[]{this}) : this.mHomeData;
    }

    public String getKeyFromInner(Context context) {
        IStaticDataStoreComponent staticDataStoreComp;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-630236900")) {
            return (String) ipChange.ipc$dispatch("-630236900", new Object[]{this, context});
        }
        SecurityGuardManager securityGuardManager = SecurityGuardManager.getInstance(context);
        if (securityGuardManager == null || (staticDataStoreComp = securityGuardManager.getStaticDataStoreComp()) == null) {
            return null;
        }
        return staticDataStoreComp.getExtraData("KEYSTORE_MD5_KEY");
    }

    public String getKeyStoreInfo(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1656759705")) {
            return (String) ipChange.ipc$dispatch("1656759705", new Object[]{this, context});
        }
        try {
            byte[] digest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5).digest(context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                String upperCase = Integer.toHexString(b & 255).toUpperCase(Locale.US);
                if (upperCase.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(upperCase);
                stringBuffer.append(":");
            }
            String stringBuffer2 = stringBuffer.toString();
            return stringBuffer2.substring(0, stringBuffer2.length() - 1);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2106092159") ? ((Integer) ipChange.ipc$dispatch("2106092159", new Object[]{this})).intValue() : R$layout.homepage_activity;
    }

    public DamaiTabbarManager getTabbarManager() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-686764831") ? (DamaiTabbarManager) ipChange.ipc$dispatch("-686764831", new Object[]{this}) : this.mTabbarManager;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-997651236")) {
            ipChange.ipc$dispatch("-997651236", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "508443855")) {
            ipChange.ipc$dispatch("508443855", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-134560658")) {
            ipChange.ipc$dispatch("-134560658", new Object[]{this});
            return;
        }
        hideBaseLayout();
        this.mTickletContainer = (FrameLayout) findViewById(R$id.homepage_ticklet_container);
        this.mCurrentCity = z20.d();
        initTicklet(new DialogInterface$OnDismissListenerC1134w(), new C1135x());
        boolean isShowHomeDependOnOrange = StartConfig.isShowHomeDependOnOrange();
        if (isShowHomeDependOnOrange) {
            this.mIsUseNewHome = !StartConfig.isUseOldHomeCMSFragment();
        } else {
            this.mIsUseNewHome = tx0.INSTANCE.e();
        }
        String str = isShowHomeDependOnOrange ? "by orange" : "by ab helper";
        String str2 = this.mIsUseNewHome ? "New home" : "Old home";
        cb1.c("ShowHome", "show home " + str + " ; final use " + str2);
        initZhibotiao();
        initWantSee();
        this.mPopTipPanel = new ContentPopTipPanel(this, new View$OnClickListenerC1136y());
        this.mMemberDialogManger = new MemberGuideDialogManger(this, new C1105a());
        n3.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1869267157")) {
            ipChange.ipc$dispatch("1869267157", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        if (i == 1008) {
            if (i2 != -1) {
                return;
            }
            if (LoginManager.k().q()) {
                onResume();
                tr2.b().q((Activity) this.mContext, tr2.SCHEME_MINEPAGE);
            }
            sendBroadcast(new Intent(DamaiConstants.NOTIFY_REFRESH_MESSAGE));
        } else if (i == 1009) {
            if (i2 != -1) {
                return;
            }
            if (LoginManager.k().q()) {
                tr2.b().q((Activity) this.mContext, tr2.SCHEME_MINEPAGE);
            } else {
                tr2.b().q((Activity) this.mContext, tr2.SCHEME_HOMEPAGE);
            }
        } else if (i == 100 && i2 == 101) {
            tr2.b().q((Activity) this.mContext, "damai://V1/CategoryPage?id=100");
        } else if (i == 78 && i2 == -1) {
            cb1.c("CityChanged", "CityChanged  onAc");
            this.mHomeTabFragment.refreshAllFragment();
        } else if (i != 1010 || i2 != -1 || intent == null || wh2.j(intent.getStringExtra("tip"))) {
        } else {
            showEvaluateTips(intent.getStringExtra("tip"));
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "865983467")) {
            ipChange.ipc$dispatch("865983467", new Object[]{this});
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.mExitTime;
        if (currentTimeMillis - j <= 2000 && j >= 0) {
            super.onBackPressed();
            k3.b().a();
            return;
        }
        ToastUtil.a().e(this, cm2.b(this, R$string.damai_main_quit_damai_toast));
        this.mExitTime = System.currentTimeMillis();
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2058626762")) {
            ipChange.ipc$dispatch("2058626762", new Object[]{this, configuration});
            return;
        }
        s22 s22Var = this.responsiveActivityStateManager;
        if (s22Var != null) {
            s22Var.c(configuration);
        }
        super.onConfigurationChanged(configuration);
        s22 s22Var2 = this.responsiveActivityStateManager;
        if (s22Var2 != null) {
            s22Var2.e(configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1791695116")) {
            ipChange.ipc$dispatch("1791695116", new Object[]{this, bundle});
            return;
        }
        wu0.b();
        super.onCreate(bundle);
        C0726a.i(this);
        this.mHomeData = new HomeData();
        ScreenShotDetector.k().A(this);
        C0529c.e().K(this);
        ja1.c();
        initLottieView();
        initTabBarLayout();
        loadConfigInfo();
        initBundle();
        if (this.mIsUseNewHome) {
            HomeNoticeView.Companion.a();
            this.mHomeTabFragment = new ay0(HomePageFragment.Companion.a());
            this.responsiveActivityStateManager = new s22(this, new C1112g(this));
        } else {
            this.mHomeTabFragment = new HomeTabFragment();
        }
        Bundle bundle2 = new Bundle();
        TabExtra tabExtra = this.mTabExtra;
        if (tabExtra != null && tabExtra.isValidExtra()) {
            bundle2.putParcelable("extra_key", this.mTabExtra);
        }
        this.mHomeTabFragment.setArguments(bundle2);
        addFragment(this.mHomeTabFragment.self());
        this.mHomeTabFragment.setOnTabClickListener(new C1122n());
        this.isFromHome = true;
        setPushUt();
        if (!checkKeyStore() && !AppConfig.v()) {
            DMDialog dMDialog = new DMDialog(this);
            dMDialog.o(false).q("应用签名冲突,为了保证您的使用安全,请使用官方渠道下载的APP").setCancelable(false);
            dMDialog.n("我知道了", new DialogInterface$OnClickListenerC1132u()).show();
        }
        registerLoginLogoutBroadcastReceiver();
        initLater();
        new Handler().postDelayed(new Runnable() { // from class: cn.damai.homepage.MainActivity.4
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-499327156")) {
                    ipChange2.ipc$dispatch("-499327156", new Object[]{this});
                } else {
                    MainActivity.this.submitIsFoldScreenUt();
                }
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1462861132")) {
            ipChange.ipc$dispatch("1462861132", new Object[]{this});
            return;
        }
        super.onDestroy();
        this.tickletBusinessUtil.e();
        this.tickletBusinessUtil = null;
        ScreenShotDetector.k().B();
        z20.l0(false);
        C0726a.j(this);
        z20.T(DamaiTabbarManager.TabBar_SERVER_DATA, null);
        unregisterReceiver(this.mLoginReceiver);
        s22 s22Var = this.responsiveActivityStateManager;
        if (s22Var != null) {
            s22Var.d();
        }
        try {
            ko.d().stopCheckAndUpdateCacheableKV();
        } catch (Exception e) {
            cb1.a(e.getMessage());
        }
    }

    @Override // cn.damai.commonbusiness.tab.DamaiTabViewHelper.OnHomeIconTabStateChangedListener
    public void onHomeIconTabStateChanged(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1789921731")) {
            ipChange.ipc$dispatch("-1789921731", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        HomeFragmentAgent homeFragmentAgent = this.mHomeTabFragment;
        if (homeFragmentAgent != null) {
            if (i == 1) {
                homeFragmentAgent.scrollToTop();
            } else if (i == 2) {
                homeFragmentAgent.scrollToRecommend();
            }
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "244899339")) {
            ipChange.ipc$dispatch("244899339", new Object[]{this});
        } else {
            hideLoadingTip((ViewGroup) findViewById(R$id.layout_main));
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1028473514")) {
            ipChange.ipc$dispatch("1028473514", new Object[]{this});
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        if (Build.VERSION.SDK_INT >= 23) {
            layoutParams.topMargin = ((int) getResources().getDimension(R$dimen.main_title_height)) + kg2.a(this);
        } else {
            layoutParams.topMargin = (int) getResources().getDimension(R$dimen.main_title_height);
        }
        showLoadingTip((ViewGroup) findViewById(R$id.layout_main), layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2118172455")) {
            ipChange.ipc$dispatch("2118172455", new Object[]{this, intent});
            return;
        }
        super.onNewIntent(intent);
        setIntent(intent);
        if (intent != null) {
            TabExtra fromIntent = TabExtra.fromIntent(intent);
            this.mTabExtra = fromIntent;
            if (fromIntent.isValidExtra()) {
                this.mHomeTabFragment.setSelectTab(this.mTabExtra);
            }
            if (AppConfig.v()) {
                cb1.c("IntentTest", "onNewIntent tabExtra :" + m61.e(this.mTabExtra));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "656881168")) {
            ipChange.ipc$dispatch("656881168", new Object[]{this});
            return;
        }
        super.onPause();
        this.homeIsOnPause = true;
        if (this.mAnimationView.isAnimating()) {
            this.mAnimationView.cancelAnimation();
        }
        C0726a.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        String uri;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "536266231")) {
            ipChange.ipc$dispatch("536266231", new Object[]{this});
            return;
        }
        super.onResume();
        ns2.a().c();
        this.homeIsOnPause = false;
        if (getIntent().getBooleanExtra("home_preview", false)) {
            checkAlertDialog();
        }
        if (!this.lottieIsShowed && this.lottieLoadSuccess) {
            showLottie();
        }
        C0726a.b(this);
        DamaiTabbarManager damaiTabbarManager = this.mTabbarManager;
        if (damaiTabbarManager != null) {
            damaiTabbarManager.l();
        }
        if (rr2.c) {
            UpdateUtil.d();
            rr2.c = false;
        }
        initPopUpLine();
        if (getIntent() == null || getIntent().getData() == null) {
            return;
        }
        try {
            if (!TextUtils.isEmpty(getIntent().getStringExtra(SplashMainActivity.HOMEPAGE_OUTER_URL))) {
                uri = getIntent().getStringExtra(SplashMainActivity.HOMEPAGE_OUTER_URL);
            } else {
                uri = getIntent().getData().toString();
            }
            if (!ru1.d()) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.putExtra(SplashMainActivity.HOMEPAGE_OUTER_URL, uri);
                intent.setData(Uri.parse("damai://launcher"));
                startActivity(intent);
                finish();
            } else if (!uri.startsWith(tr2.SCHEME)) {
                if ("damai://home".equals(uri) && (this.mHomeTabFragment.getCurFragment() instanceof HomeCmsFragment) && "openExhibition".equals(getIntent().getStringExtra("action"))) {
                    ((HomeCmsFragment) this.mHomeTabFragment.getCurFragment()).showExhibitionTab();
                    getIntent().setData(null);
                }
            } else if (uri.contains(tr2.SCHEME_HOMEPAGE)) {
                setUt(uri);
                Log.d("applink", "same as homepage ");
            } else {
                if (!uri.startsWith("damai://V1/skuPage") && !uri.startsWith("damai://V1/OrderCheckPage")) {
                    Log.d("applink", " uri : " + getIntent().getData());
                    Bundle extras = getIntent().getExtras();
                    if (extras == null) {
                        extras = new Bundle();
                    }
                    extras.putBoolean("fromQr", true);
                    extras.putBoolean("backtohome", true);
                    extras.putString("from_page", "homepage");
                    DMNav.from(this).withExtras(extras).toUri(Uri.parse(uri));
                    getIntent().setData(null);
                    setUt(uri);
                    return;
                }
                Log.d("DMNav", "home v1 interrupt ");
                if (showed) {
                    return;
                }
                ToastUtil.i("页面跳转非法，请通过正常路径打开哦");
                showed = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-374838771")) {
            ipChange.ipc$dispatch("-374838771", new Object[]{this, bundle});
        } else {
            super.onSaveInstanceState(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "728113602")) {
            ipChange.ipc$dispatch("728113602", new Object[]{this});
            return;
        }
        super.onStop();
        leftHome();
    }

    @Override // cn.damai.commonbusiness.tab.TabbarLayout.TabBarListener
    public void onTabClicked(TabItem tabItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1514721654")) {
            ipChange.ipc$dispatch("-1514721654", new Object[]{this, tabItem});
            return;
        }
        ContentPopTipPanel contentPopTipPanel = this.mPopTipPanel;
        if (contentPopTipPanel != null) {
            contentPopTipPanel.b();
        }
    }

    @Override // cn.damai.commonbusiness.tab.TabbarLayout.TabBarListener
    public void onTabLongClicked(TabItem tabItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2119141998")) {
            ipChange.ipc$dispatch("2119141998", new Object[]{this, tabItem});
        }
    }

    @Override // cn.damai.commonbusiness.tab.TabbarLayout.TabBarListener
    public void onTabReselected(TabItem tabItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-852381127")) {
            ipChange.ipc$dispatch("-852381127", new Object[]{this, tabItem});
        } else if (tabItem.tab.equals(DamaiConstants.TAB_HOME)) {
            this.mTabbarManager.h().g();
        }
    }

    @Override // cn.damai.commonbusiness.tab.TabbarLayout.TabBarListener
    public void onTabSelected(TabItem tabItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "894768902")) {
            ipChange.ipc$dispatch("894768902", new Object[]{this, tabItem});
        }
    }

    @Override // cn.damai.commonbusiness.pageut.PageUtExecutor.FragmentPropertiesProvider
    public void put(String str, Map map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1079225565")) {
            ipChange.ipc$dispatch("-1079225565", new Object[]{this, str, map});
            return;
        }
        Log.e("abtest", " ==================== acvitivty putttt : " + str + " , map : " + map);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.fragmentPropertiesMap.put(str, map);
    }

    public void returnBottomSheet(BottomSheetBean bottomSheetBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1400043453")) {
            ipChange.ipc$dispatch("1400043453", new Object[]{this, bottomSheetBean});
            return;
        }
        BottomSheetBean bottomSheetBean2 = new BottomSheetBean();
        if (bottomSheetBean != null && !cb2.d(bottomSheetBean.content)) {
            bottomSheetBean2.content = new ArrayList(bottomSheetBean.content);
        }
        boolean d = C0938a.d(bottomSheetBean);
        if (!d && !yy0.g(bottomSheetBean)) {
            String b = C0938a.b(bottomSheetBean2);
            if (!TextUtils.isEmpty(b)) {
                gz0.c(b);
            }
        }
        if (bottomSheetBean == null || wh2.e(bottomSheetBean.content) <= 0) {
            z20.T(DamaiTabbarManager.TabBar, JSON.toJSONString(bottomSheetBean));
            refreshTabBarLayout();
        } else if (d) {
            ImageDownLoader imageDownLoader = new ImageDownLoader(this);
            this.index = 0;
            loadImage(bottomSheetBean, imageDownLoader);
        }
    }

    public void returnBottomSheetError() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1281652639")) {
            ipChange.ipc$dispatch("1281652639", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void setDamaiUTKeyBuilder(C0525a.C0527b c0527b) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-780297163")) {
            ipChange.ipc$dispatch("-780297163", new Object[]{this, c0527b});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-837646669")) {
            return (String) ipChange.ipc$dispatch("-837646669", new Object[]{this});
        }
        return null;
    }

    public void setTitle(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1728128489")) {
            ipChange.ipc$dispatch("-1728128489", new Object[]{this, str});
        } else {
            getSupportActionBar().setTitle(str);
        }
    }

    public void setUt(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1847484592")) {
            ipChange.ipc$dispatch("-1847484592", new Object[]{this, str});
        } else if (TextUtils.isEmpty(str)) {
        } else {
            String queryParameter = Uri.parse(str).getQueryParameter("utm");
            if (!TextUtils.isEmpty(queryParameter)) {
                C0529c.e().H("utm", queryParameter);
            }
            C0529c.e().D("home", "applink", str, "homepage", null, 1013);
        }
    }

    public void showCycleDisplayRequiredDialog(MainAlertEntity mainAlertEntity) {
        MainAlertEntity.MainAlertModel mainAlertModel;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1064833474")) {
            ipChange.ipc$dispatch("-1064833474", new Object[]{this, mainAlertEntity});
            return;
        }
        this.mMainAlertEntity = mainAlertEntity;
        if (mainAlertEntity != null && (mainAlertModel = mainAlertEntity.item) != null) {
            if ("7".equals(mainAlertEntity.type)) {
                showDnaProtocolDialog(mainAlertModel);
                return;
            } else {
                eventShowAlterTimer(mainAlertModel);
                return;
            }
        }
        checkUpdate();
    }

    public void showWantSee(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "468680491")) {
            ipChange.ipc$dispatch("468680491", new Object[]{this, str});
            return;
        }
        WantSeeTips wantSeeTips = (WantSeeTips) findViewById(R$id.want_see_tips);
        this.wantSeeTips = wantSeeTips;
        wantSeeTips.setPageSource(WantSeeTips.AbstractC1562a.C1565c.INSTANCE);
        wantActionShow(str);
    }
}
