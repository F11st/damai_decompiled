package cn.damai.user.brand;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import cn.damai.common.app.widget.DMDialog;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.user.C0525a;
import cn.damai.common.user.C0528b;
import cn.damai.common.user.C0529c;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.SimpleBaseActivity;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.commonbusiness.share.ShareManager;
import cn.damai.commonbusiness.view.AttentionView;
import cn.damai.commonbusiness.view.DMGiftDialog;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.homepage.R$style;
import cn.damai.issue.tool.IssueConstants;
import cn.damai.login.LoginManager;
import cn.damai.tetris.component.brand.bean.ActivityInfo;
import cn.damai.tetris.component.brand.bean.BrandHeaderInfoBean;
import cn.damai.tetris.component.brand.bean.DrawReward;
import cn.damai.tetris.component.brand.bean.LotteryDrawResult;
import cn.damai.tetris.component.brand.bean.LotteryResponse;
import cn.damai.tetris.core.msg.Message;
import cn.damai.uikit.nav.NavProxy;
import cn.damai.uikit.view.DMAvatar;
import cn.damai.uikit.view.DMPosterView;
import cn.damai.user.brand.BrandFragment;
import cn.damai.user.star.view.ScrollAlphaListener;
import cn.damai.user.userprofile.UserIndexViewModel;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.purchase.core.utils.PurchaseConstants;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;
import com.youku.media.arch.instruments.statistics.ConfigReporter;
import java.util.List;
import java.util.Map;
import tb.db1;
import tb.kg2;
import tb.m91;
import tb.pl;
import tb.t60;
import tb.xr;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class BrandActivity extends SimpleBaseActivity implements AttentionView.StateListener, BrandFragment.OnInfoUpdate, ScrollAlphaListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int BRAND_REQUEST_LOGIN = 10002;
    public static final String PAGENAME = "brand";
    cn.damai.user.repertoite.view.AttentionView attentionView;
    private long dialogMillis;
    private BrandFragment fragment;
    UserIndexViewModel headerModel;
    private View navBar;
    NPopupWindow popupWindow;
    private long startDialogSeeTimeMillis;
    int alpha = 0;
    int status = 0;
    int lastState = -1;
    private boolean firstLoaded = true;
    int changedState = -1;

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public class NPopupWindow extends PopupWindow {
        private static transient /* synthetic */ IpChange $ipChange;
        Map args;

        public NPopupWindow(View view, int i, int i2) {
            super(view, i, i2);
        }

        @Override // android.widget.PopupWindow
        public void dismiss() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-446932802")) {
                ipChange.ipc$dispatch("-446932802", new Object[]{this});
            }
        }

        public void forceDismis() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "407798708")) {
                ipChange.ipc$dispatch("407798708", new Object[]{this});
                return;
            }
            super.dismiss();
            C0529c.e().C("item", "guide_alert", "brand", "1.0", System.currentTimeMillis() - BrandActivity.this.dialogMillis, this.args, 2201);
        }

        public void setMap(Map map) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1013831331")) {
                ipChange.ipc$dispatch("-1013831331", new Object[]{this, map});
            } else {
                this.args = map;
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.user.brand.BrandActivity$a */
    /* loaded from: classes17.dex */
    public class View$OnClickListenerC2664a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Map a;
        final /* synthetic */ ProjectItemBean b;

        View$OnClickListenerC2664a(Map map, ProjectItemBean projectItemBean) {
            this.a = map;
            this.b = projectItemBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-542155836")) {
                ipChange.ipc$dispatch("-542155836", new Object[]{this, view});
                return;
            }
            C0529c.e().x(new C0528b().e("brand", "guide_alert", "item", this.a, Boolean.TRUE));
            BrandActivity.this.popupWindow.forceDismis();
            if (!TextUtils.isEmpty(this.b.schema)) {
                NavProxy.from(BrandActivity.this).toUri(this.b.schema);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString(IssueConstants.ProjectID, this.b.id);
            DMNav.from(BrandActivity.this).withExtras(bundle).toUri(NavUri.b(pl.PROJECT_DETAIL_PAGE));
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.user.brand.BrandActivity$b */
    /* loaded from: classes17.dex */
    public class View$OnClickListenerC2665b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC2665b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1188025504")) {
                ipChange.ipc$dispatch("1188025504", new Object[]{this, view});
            } else {
                BrandFragment unused = BrandActivity.this.fragment;
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.user.brand.BrandActivity$c */
    /* loaded from: classes17.dex */
    public class View$OnClickListenerC2666c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC2666c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-995651423")) {
                ipChange.ipc$dispatch("-995651423", new Object[]{this, view});
            } else if (BrandActivity.this.fragment == null) {
            } else {
                BrandActivity.this.fragment.getActivity().finish();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.user.brand.BrandActivity$d */
    /* loaded from: classes17.dex */
    public class View$OnClickListenerC2667d implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ActivityInfo a;

        /* compiled from: Taobao */
        /* renamed from: cn.damai.user.brand.BrandActivity$d$a */
        /* loaded from: classes17.dex */
        public class DialogInterface$OnClickListenerC2668a implements DialogInterface.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            DialogInterface$OnClickListenerC2668a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1985526112")) {
                    ipChange.ipc$dispatch("1985526112", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                } else if (BrandActivity.this.attentionView.followed()) {
                    BrandActivity.this.attentionView.getRelationUpdateAndLogin();
                }
            }
        }

        /* compiled from: Taobao */
        /* renamed from: cn.damai.user.brand.BrandActivity$d$b */
        /* loaded from: classes17.dex */
        public class DialogInterface$OnClickListenerC2669b implements DialogInterface.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            DialogInterface$OnClickListenerC2669b(View$OnClickListenerC2667d view$OnClickListenerC2667d) {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1339860161")) {
                    ipChange.ipc$dispatch("-1339860161", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                } else {
                    dialogInterface.dismiss();
                }
            }
        }

        View$OnClickListenerC2667d(ActivityInfo activityInfo) {
            this.a = activityInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1115638946")) {
                ipChange.ipc$dispatch("1115638946", new Object[]{this, view});
            } else if (BrandActivity.this.attentionView.followed()) {
                new DMDialog(BrandActivity.this.mContext).o(false).v(PurchaseConstants.NORMAL_WARNING_TITLE).q("确认取消关注？取消后将无法获取厂牌号最新权益。").t(3).i("取消", new DialogInterface$OnClickListenerC2669b(this)).n("确定", new DialogInterface$OnClickListenerC2668a()).show();
            } else {
                ActivityInfo activityInfo = this.a;
                if (activityInfo != null && !TextUtils.isEmpty(activityInfo.couponId)) {
                    BrandActivity.this.autoFollow();
                } else {
                    BrandActivity.this.attentionView.getRelationUpdateAndLogin();
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.user.brand.BrandActivity$e */
    /* loaded from: classes9.dex */
    public class C2670e implements AttentionView.StateListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C2670e() {
        }

        @Override // cn.damai.commonbusiness.view.AttentionView.StateListener
        public void onStateChanged(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-429696397")) {
                ipChange.ipc$dispatch("-429696397", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            BrandActivity brandActivity = BrandActivity.this;
            if (i == brandActivity.lastState) {
                return;
            }
            brandActivity.lastState = i;
            if (brandActivity.fragment != null && i == 0) {
                BrandActivity.this.fragment.refreshByType(1);
                BrandActivity.this.attentionView.setStateListener(null);
            }
            BrandActivity.this.onStateChanged(i);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.user.brand.BrandActivity$f */
    /* loaded from: classes17.dex */
    public class DialogInterface$OnDismissListenerC2671f implements DialogInterface.OnDismissListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Map a;
        final /* synthetic */ String b;
        final /* synthetic */ DrawReward c;

        DialogInterface$OnDismissListenerC2671f(Map map, String str, DrawReward drawReward) {
            this.a = map;
            this.b = str;
            this.c = drawReward;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1959588613")) {
                ipChange.ipc$dispatch("-1959588613", new Object[]{this, dialogInterface});
                return;
            }
            ((DMGiftDialog) dialogInterface).setOnDismissListener(null);
            C0529c.e().C("use_btn", "redpaper", "brand", "1.0", System.currentTimeMillis() - BrandActivity.this.startDialogSeeTimeMillis, this.a, 2201);
            BrandActivity.this.requestProject(this.b, this.c.rewardId);
            dialogInterface.dismiss();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.user.brand.BrandActivity$g */
    /* loaded from: classes17.dex */
    public class View$OnClickListenerC2672g implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC2672g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "898479272")) {
                ipChange.ipc$dispatch("898479272", new Object[]{this, view});
            } else {
                BrandActivity.this.popupWindow.forceDismis();
            }
        }
    }

    private void followAndGetGift() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-972808638")) {
            ipChange.ipc$dispatch("-972808638", new Object[]{this});
            return;
        }
        if (!this.attentionView.followed()) {
            this.attentionView.getRelationUpdateAndLogin();
        }
        NewLotteryDrawRequest newLotteryDrawRequest = new NewLotteryDrawRequest();
        newLotteryDrawRequest.cityCode = z20.c();
        newLotteryDrawRequest.lotteryMixId = this.headerModel.couponId;
        newLotteryDrawRequest.request(new DMMtopRequestListener<LotteryResponse>(LotteryResponse.class) { // from class: cn.damai.user.brand.BrandActivity.5
            private static transient /* synthetic */ IpChange $ipChange;

            private void showGiftDialog(DrawReward drawReward) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1315014266")) {
                    ipChange2.ipc$dispatch("-1315014266", new Object[]{this, drawReward});
                    return;
                }
                BrandActivity brandActivity = BrandActivity.this;
                if (brandActivity == null || drawReward == null) {
                    return;
                }
                brandActivity.showPopDialog(drawReward);
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-662504182")) {
                    ipChange2.ipc$dispatch("-662504182", new Object[]{this, str, str2});
                } else {
                    BrandActivity.this.showErrorToast("抱歉来晚了～券已经发完了");
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(LotteryResponse lotteryResponse) {
                List<DrawReward> list;
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1164839490")) {
                    ipChange2.ipc$dispatch("1164839490", new Object[]{this, lotteryResponse});
                } else if (lotteryResponse == null || TextUtils.isEmpty(lotteryResponse.returnCode)) {
                    BrandActivity.this.showErrorToast("抱歉来晚了～券已经发完了");
                } else if ("0".equals(lotteryResponse.returnCode)) {
                    LotteryDrawResult lotteryDrawResult = lotteryResponse.returnValue;
                    if (lotteryDrawResult == null || (list = lotteryDrawResult.rewards) == null || list.size() == 0) {
                        BrandActivity.this.showErrorToast("抱歉来晚了～券已经发完了");
                        return;
                    }
                    showGiftDialog(lotteryResponse.returnValue.rewards.get(0));
                    BrandActivity.this.fragment.sendMsg(new Message(10244, BrandActivity.this.headerModel.couponId));
                } else if ("200016".equals(lotteryResponse.returnCode) || "200015".equals(lotteryResponse.returnCode)) {
                    BrandActivity.this.showErrorToast("你已经领取过该券了，快去'我的-优惠券'中使用吧");
                } else {
                    BrandActivity.this.showErrorToast("抱歉来晚了～券已经发完了");
                }
            }
        });
    }

    private void initFragment() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-252118110")) {
            ipChange.ipc$dispatch("-252118110", new Object[]{this});
            return;
        }
        UserIndexViewModel userIndexViewModel = (UserIndexViewModel) ViewModelProviders.of(this).get(UserIndexViewModel.class);
        this.headerModel = userIndexViewModel;
        if (!userIndexViewModel.initParams(getIntent())) {
            ToastUtil.i("请求数据出错.");
            return;
        }
        int i = R$id.fragment_container;
        onResponseSuccess(findViewById(i));
        findViewById(i).setVisibility(0);
        UserIndexViewModel userIndexViewModel2 = this.headerModel;
        this.fragment = BrandFragment.newInstance(userIndexViewModel2.userid, "4", userIndexViewModel2.followLottery ? 1 : 0, null);
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(i, this.fragment);
        beginTransaction.commitAllowingStateLoss();
        this.fragment.setScrollAlphaListener(this);
    }

    private void initTranslucentStatusBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "424814602")) {
            ipChange.ipc$dispatch("424814602", new Object[]{this});
            return;
        }
        Window window = getWindow();
        window.clearFlags(ConfigReporter.BIT_GETTER_IMP);
        window.addFlags(Integer.MIN_VALUE);
        window.getDecorView().setSystemUiVisibility(1024);
        if (Build.VERSION.SDK_INT >= 21) {
            window.setStatusBarColor(0);
        }
    }

    private void setDarkStatusBarFontColor() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-827850403")) {
            ipChange.ipc$dispatch("-827850403", new Object[]{this});
        } else {
            getWindow().getDecorView().setSystemUiVisibility(9216);
        }
    }

    private void setImmersionStyle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1719536800")) {
            ipChange.ipc$dispatch("-1719536800", new Object[]{this});
            return;
        }
        View findViewById = findViewById(R$id.status_bar_gap);
        if (findViewById != null) {
            findViewById.getLayoutParams().height = kg2.a(this);
            findViewById.setVisibility(0);
        }
        initTranslucentStatusBar();
        setLightStatusBarFontColor();
        this.status = 0;
    }

    private void setLightStatusBarFontColor() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "259133307")) {
            ipChange.ipc$dispatch("259133307", new Object[]{this});
        } else {
            getWindow().getDecorView().setSystemUiVisibility(1024);
        }
    }

    private void setProjectPrice(String str, String str2, String str3, boolean z, boolean z2, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1784582462")) {
            ipChange.ipc$dispatch("1784582462", new Object[]{this, str, str2, str3, Boolean.valueOf(z), Boolean.valueOf(z2), view});
            return;
        }
        int i = R$id.tv_project_price_unknow;
        view.findViewById(i).setVisibility(8);
        int i2 = R$id.tv_project_price_label;
        view.findViewById(i2).setVisibility(8);
        int i3 = R$id.tv_project_price;
        ((TextView) view.findViewById(i3)).setText("");
        if (TextUtils.isEmpty(str3) || !z2) {
            if (!TextUtils.isEmpty(str2)) {
                str = str2;
            }
            if (!TextUtils.isEmpty(str) && !str.equals("待定") && !str.equals("价格待定")) {
                view.findViewById(R$id.tv_fuhao).setVisibility(0);
                ((TextView) view.findViewById(i3)).setText(str);
                ((TextView) view.findViewById(i2)).setVisibility(z ? 0 : 8);
                return;
            }
            view.findViewById(R$id.tv_fuhao).setVisibility(8);
            view.findViewById(i).setVisibility(0);
        }
    }

    private void setTime(String str, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-42832017")) {
            ipChange.ipc$dispatch("-42832017", new Object[]{this, str, view});
        } else if (!TextUtils.isEmpty(str)) {
            ((TextView) view.findViewById(R$id.popproj_tv_project_date)).setText(str);
        } else {
            ((TextView) view.findViewById(R$id.popproj_tv_project_date)).setText("时间待定");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showErrorToast(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1813958352")) {
            ipChange.ipc$dispatch("1813958352", new Object[]{this, str});
        } else {
            ToastUtil.a().j(this, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showPopDialog(DrawReward drawReward) {
        String str;
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "39199224")) {
            ipChange.ipc$dispatch("39199224", new Object[]{this, drawReward});
            return;
        }
        DMGiftDialog dMGiftDialog = new DMGiftDialog(this);
        if (!TextUtils.isEmpty(drawReward.costPrice)) {
            try {
                i = Integer.parseInt(drawReward.costPrice);
                if (i < 100) {
                    str = (Double.parseDouble(drawReward.costPrice) * 0.01d) + "";
                } else {
                    str = (i / 100) + "";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (i <= 0 && !TextUtils.isEmpty(str)) {
                dMGiftDialog.d("恭喜您获得" + str + "元优惠券");
                dMGiftDialog.b(drawReward.rewardDesc);
                dMGiftDialog.c(str + "");
                dMGiftDialog.show();
                Map utArgs = this.headerModel.getUtArgs();
                utArgs.put("brand_id", this.headerModel.userid);
                utArgs.put("coupon_id", drawReward.rewardId);
                this.startDialogSeeTimeMillis = System.currentTimeMillis();
                dMGiftDialog.setOnDismissListener(new DialogInterface$OnDismissListenerC2671f(utArgs, str, drawReward));
                return;
            }
            showErrorToast("抱歉来晚了～券已经发完了");
        }
        str = "";
        if (i <= 0) {
        }
        showErrorToast("抱歉来晚了～券已经发完了");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showPopwindow(ProjectItemBean projectItemBean, String str) {
        String str2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-403887188")) {
            ipChange.ipc$dispatch("-403887188", new Object[]{this, projectItemBean, str});
            return;
        }
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this).inflate(R$layout.brand_pop_gift_project, (ViewGroup) null);
        int a = t60.a(this, 196.0f);
        NPopupWindow nPopupWindow = this.popupWindow;
        if (nPopupWindow != null && nPopupWindow.isShowing()) {
            this.popupWindow.forceDismis();
        }
        NPopupWindow nPopupWindow2 = new NPopupWindow(viewGroup, -1, a);
        this.popupWindow = nPopupWindow2;
        if (Build.VERSION.SDK_INT > 21) {
            nPopupWindow2.setClippingEnabled(false);
        }
        this.popupWindow.setBackgroundDrawable(new BitmapDrawable());
        this.popupWindow.setFocusable(false);
        this.popupWindow.setOutsideTouchable(false);
        this.popupWindow.setAnimationStyle(R$style.pop_animation);
        this.popupWindow.showAtLocation(findViewById(R$id.fragment_container), 80, 0, t60.a(this, 29.0f));
        this.dialogMillis = System.currentTimeMillis();
        Map utArgs = this.headerModel.getUtArgs();
        utArgs.put("brand_id", this.headerModel.userid);
        utArgs.put("item_id", projectItemBean.id);
        this.popupWindow.setMap(utArgs);
        new Handler().postDelayed(new Runnable() { // from class: cn.damai.user.brand.BrandActivity.8
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                NPopupWindow nPopupWindow3;
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1855257321")) {
                    ipChange2.ipc$dispatch("1855257321", new Object[]{this});
                    return;
                }
                BrandActivity brandActivity = BrandActivity.this;
                if (brandActivity == null || (nPopupWindow3 = brandActivity.popupWindow) == null || !nPopupWindow3.isShowing()) {
                    return;
                }
                BrandActivity.this.popupWindow.forceDismis();
            }
        }, DanmakuFactory.DEFAULT_DANMAKU_DURATION_V);
        ((FrameLayout.LayoutParams) viewGroup.getLayoutParams()).setMargins(t60.a(this, 0.0f), t60.a(this, 14.0f), t60.a(this, 0.0f), t60.a(this, 14.0f));
        if (TextUtils.isEmpty(projectItemBean.venueCity)) {
            str2 = "";
        } else {
            str2 = "【" + projectItemBean.venueCity + "】";
        }
        ((TextView) viewGroup.findViewById(R$id.popproj_tv_project_name)).setText(str2 + projectItemBean.name);
        ((DMPosterView) viewGroup.findViewById(R$id.popproj_poster)).setImageUrl(projectItemBean.verticalPic);
        String str3 = projectItemBean.venueCity;
        if (!TextUtils.isEmpty(str3)) {
            if (!TextUtils.isEmpty(projectItemBean.venueName)) {
                str3 = str3 + " | " + projectItemBean.venueName;
            }
        } else {
            str3 = projectItemBean.venueName;
        }
        if (!TextUtils.isEmpty(str3)) {
            ((TextView) viewGroup.findViewById(R$id.popproj_tv_project_vanue)).setText(str3);
        }
        ((TextView) viewGroup.findViewById(R$id.popproj_tv_project_count)).setText("用券更优惠");
        if (!TextUtils.isEmpty(projectItemBean.liveStartTime)) {
            setTime(projectItemBean.liveStartTime, viewGroup);
        } else {
            setTime(projectItemBean.showTime, viewGroup);
        }
        setProjectPrice(projectItemBean.priceLow, projectItemBean.promotionPrice, projectItemBean.displayStatus, true, projectItemBean.showStatus.colorGrey(), viewGroup);
        viewGroup.findViewById(R$id.popproj_close).setOnClickListener(new View$OnClickListenerC2672g());
        viewGroup.setOnClickListener(new View$OnClickListenerC2664a(utArgs, projectItemBean));
    }

    public void autoFollow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-149888990")) {
            ipChange.ipc$dispatch("-149888990", new Object[]{this});
        } else if (!LoginManager.k().q()) {
            DMNav.from(this).forResult(10002).toUri(NavUri.b("login"));
        } else {
            followAndGetGift();
        }
    }

    public String getFansNum(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1012276942")) {
            return (String) ipChange.ipc$dispatch("1012276942", new Object[]{this, Long.valueOf(j)});
        }
        String[] strArr = new String[2];
        try {
            if (j < 10000) {
                strArr[0] = j + "";
                strArr[1] = "粉丝";
                return strArr[0] + strArr[1];
            }
            strArr[0] = (((float) (j / 1000)) / 10.0f) + "";
            strArr[1] = "万粉丝";
            return strArr[0] + strArr[1];
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1693768480")) {
            return ((Integer) ipChange.ipc$dispatch("-1693768480", new Object[]{this})).intValue();
        }
        return 0;
    }

    @Override // cn.damai.commonbusiness.base.SimpleBaseActivity, cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1465753243")) {
            ipChange.ipc$dispatch("1465753243", new Object[]{this, Integer.valueOf(i)});
        } else {
            initFragment();
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-900138412")) {
            ipChange.ipc$dispatch("-900138412", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        ShareManager.E().r0(i, i2, intent);
    }

    @Override // cn.damai.user.star.view.ScrollAlphaListener
    public void onAlphaChanged(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1046282387")) {
            ipChange.ipc$dispatch("1046282387", new Object[]{this, Float.valueOf(f)});
            return;
        }
        if (f > 0.3d) {
            f = 1.0f;
        }
        View view = this.navBar;
        if (view != null) {
            view.setAlpha(f);
            if (f >= 1.0f) {
                setDarkStatusBarFontColor();
                this.status = 1;
                cn.damai.user.repertoite.view.AttentionView attentionView = this.attentionView;
                if (attentionView != null) {
                    attentionView.setVisibility(0);
                }
            } else if (f == 0.0f) {
                setLightStatusBarFontColor();
                this.status = 0;
                cn.damai.user.repertoite.view.AttentionView attentionView2 = this.attentionView;
                if (attentionView2 != null) {
                    attentionView2.setVisibility(8);
                }
            }
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-77889012")) {
            ipChange.ipc$dispatch("-77889012", new Object[]{this});
            return;
        }
        if (this.changedState > -1) {
            Bundle bundle = new Bundle();
            bundle.putString("brandId", this.headerModel.userid);
            bundle.putString("followState", this.changedState + "");
            xr.c("brand_state_changed", bundle);
        }
        super.onBackPressed();
    }

    @Override // cn.damai.user.brand.BrandFragment.OnInfoUpdate
    public void onBindFollowView(AttentionView attentionView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-115380227")) {
            ipChange.ipc$dispatch("-115380227", new Object[]{this, attentionView});
            return;
        }
        cn.damai.user.repertoite.view.AttentionView attentionView2 = this.attentionView;
        if (attentionView2 != null) {
            attentionView2.addAttentionView(attentionView);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1073148269")) {
            ipChange.ipc$dispatch("1073148269", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setContentView(R$layout.user_newbrand_activity_layout);
        C0529c.e().K(this);
        hideBaseLayout();
        setImmersionStyle();
        if (getIntent() == null || getIntent().getExtras() == null) {
            return;
        }
        setDamaiUTKeyBuilder(new C0525a.C0527b().i("brand"));
        View findViewById = findViewById(R$id.nav_bar);
        this.navBar = findViewById;
        findViewById.setAlpha(this.alpha);
        findViewById(R$id.ll_share).setOnClickListener(new View$OnClickListenerC2665b());
        findViewById(R$id.brand_back).setOnClickListener(new View$OnClickListenerC2666c());
        initFragment();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-181314579")) {
            ipChange.ipc$dispatch("-181314579", new Object[]{this});
            return;
        }
        super.onDestroy();
        cn.damai.user.repertoite.view.AttentionView attentionView = this.attentionView;
        if (attentionView != null) {
            attentionView.cleanAttenList();
            this.attentionView.setStateListener(null);
            this.attentionView = null;
        }
    }

    @Override // cn.damai.user.brand.BrandFragment.OnInfoUpdate
    public void onInfoUpdate(BrandHeaderInfoBean brandHeaderInfoBean, ActivityInfo activityInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "263691239")) {
            ipChange.ipc$dispatch("263691239", new Object[]{this, brandHeaderInfoBean, activityInfo});
        } else if (brandHeaderInfoBean == null) {
        } else {
            if (activityInfo != null && !TextUtils.isEmpty(activityInfo.couponId)) {
                this.headerModel.couponId = activityInfo.couponId;
            }
            TextView textView = (TextView) findViewById(R$id.user_desc);
            cn.damai.user.repertoite.view.AttentionView attentionView = (cn.damai.user.repertoite.view.AttentionView) this.navBar.findViewById(R$id.brand_navbar_attention);
            this.attentionView = attentionView;
            attentionView.setInitParams(brandHeaderInfoBean.getBid(), "4");
            this.attentionView.setVisibility(0);
            this.attentionView.setState(brandHeaderInfoBean.getFavoriteFlag());
            this.attentionView.setOnAttentionClickDelegate(new View$OnClickListenerC2667d(activityInfo));
            this.attentionView.setStateListener(new C2670e());
            ((DMAvatar) findViewById(R$id.user_icon)).setAvatar(brandHeaderInfoBean.getHeadImg());
            ((TextView) findViewById(R$id.user_name)).setText(brandHeaderInfoBean.getNickname());
            long j = 0;
            try {
                j = Long.parseLong(brandHeaderInfoBean.getFansNum());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            textView.setText(getFansNum(j));
            if (this.headerModel.followLottery && this.firstLoaded) {
                autoFollow();
                this.firstLoaded = false;
            }
        }
    }

    @Override // cn.damai.commonbusiness.view.AttentionView.StateListener
    public void onStateChanged(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-93975869")) {
            ipChange.ipc$dispatch("-93975869", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.changedState = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void requestProject(final String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "774665004")) {
            ipChange.ipc$dispatch("774665004", new Object[]{this, str, str2});
            return;
        }
        GetProjectInfoByLotteryRequest getProjectInfoByLotteryRequest = new GetProjectInfoByLotteryRequest();
        getProjectInfoByLotteryRequest.favourableId = str2;
        getProjectInfoByLotteryRequest.cityId = z20.c();
        getProjectInfoByLotteryRequest.request(new DMMtopRequestListener<GetProjectInfoByLotteryResponse>(GetProjectInfoByLotteryResponse.class) { // from class: cn.damai.user.brand.BrandActivity.7
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str3, String str4) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-678022900")) {
                    ipChange2.ipc$dispatch("-678022900", new Object[]{this, str3, str4});
                    return;
                }
                db1.b("BrandActivity", " GetProjectInfoByLotteryRequest fail : " + str3 + " , " + str4);
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(GetProjectInfoByLotteryResponse getProjectInfoByLotteryResponse) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "300280479")) {
                    ipChange2.ipc$dispatch("300280479", new Object[]{this, getProjectInfoByLotteryResponse});
                } else if (getProjectInfoByLotteryResponse != null && !m91.a(getProjectInfoByLotteryResponse.projectInfo) && getProjectInfoByLotteryResponse.projectInfo.size() <= 1 && getProjectInfoByLotteryResponse.projectInfo.get(0) != null) {
                    BrandActivity.this.showPopwindow(getProjectInfoByLotteryResponse.projectInfo.get(0), str);
                } else {
                    db1.b("BrandActivity", " GetProjectInfoByLotteryRequest fail response error .");
                }
            }
        });
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1754594476")) {
            return (String) ipChange.ipc$dispatch("-1754594476", new Object[]{this});
        }
        return null;
    }
}
