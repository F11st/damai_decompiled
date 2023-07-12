package cn.damai.setting;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.damai.common.DamaiConstants;
import cn.damai.common.image.C0504a;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.user.C0529c;
import cn.damai.common.util.ACache;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.update.UpdateUtil;
import cn.damai.h5container.DamaiCookieManager;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.homepage.R$string;
import cn.damai.homepage.R$style;
import cn.damai.login.LoginManager;
import cn.damai.mine.activity.AccountSafeActivity;
import cn.damai.mine.view.LogoutDialog;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.wxapi.TencentUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.usercenter.passport.PassportManager;
import tb.cb1;
import tb.cm2;
import tb.cs;
import tb.gb2;
import tb.kg2;
import tb.p3;
import tb.tf1;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class SettingActivity extends DamaiBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;
    Handler handler = new HandlerC1759i();
    private RelativeLayout ll_push;
    private TextView logout_btn;
    private FrameLayout mFlBottomBtnContainer;
    private LinearLayout mLvFeedback;
    private RelativeLayout mPrivacyRl;
    private TextView mTitleTV;
    private DMIconFontTextView mTvTitleBack;
    SettingActivity mainActivity;
    private RelativeLayout rl_about;
    private RelativeLayout rl_account_safe;
    private RelativeLayout rl_clear;
    private RelativeLayout rl_help;
    private RelativeLayout rl_phone;
    private RelativeLayout rl_protocol;
    private RelativeLayout rl_update;
    private TextView tv_cache_size;
    private long usercode;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.setting.SettingActivity$a */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC1751a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC1751a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-3852948")) {
                ipChange.ipc$dispatch("-3852948", new Object[]{this, view});
                return;
            }
            C0529c.e().x(gb2.g().q());
            String str = "https://help.damai.cn/helpPageH5Catalog.htm";
            cb1.b("SettingActivity", "helpCenterUrl = " + str);
            DMNav.from(SettingActivity.this.mainActivity).toUri(str);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.setting.SettingActivity$b */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC1752b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC1752b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2107437421")) {
                ipChange.ipc$dispatch("2107437421", new Object[]{this, view});
            } else {
                SettingActivity.this.mainActivity.startActivity(new Intent(SettingActivity.this.mainActivity, ProtocolActivity.class));
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.setting.SettingActivity$c */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC1753c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC1753c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-76239506")) {
                ipChange.ipc$dispatch("-76239506", new Object[]{this, view});
                return;
            }
            C0529c.e().x(gb2.g().k());
            Intent intent = new Intent();
            intent.setClass(SettingActivity.this.mainActivity, AboutActivity.class);
            SettingActivity.this.startActivity(intent);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.setting.SettingActivity$d */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC1754d implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC1754d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2035050863")) {
                ipChange.ipc$dispatch("2035050863", new Object[]{this, view});
                return;
            }
            C0529c.e().x(gb2.g().o());
            try {
                SettingActivity.this.startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:10103721")));
            } catch (Exception e) {
                e.printStackTrace();
                ToastUtil.a().j(SettingActivity.this, "无法拨号，请手动拨打10103721");
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.setting.SettingActivity$e */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC1755e implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC1755e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-148626064")) {
                ipChange.ipc$dispatch("-148626064", new Object[]{this, view});
            } else {
                SettingActivity.this.Logout();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.setting.SettingActivity$f */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC1756f implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC1756f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1962664305")) {
                ipChange.ipc$dispatch("1962664305", new Object[]{this, view});
                return;
            }
            C0529c.e().x(gb2.g().p());
            SettingActivity.this.jumpToFaqActivity();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.setting.SettingActivity$g */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC1757g implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC1757g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-221012622")) {
                ipChange.ipc$dispatch("-221012622", new Object[]{this, view});
            } else {
                DMNav.from(SettingActivity.this).toUri(NavUri.b(cs.PRIVACY_SETTING));
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.setting.SettingActivity$h */
    /* loaded from: classes7.dex */
    public class C1758h implements LogoutDialog.OnDialogClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C1758h() {
        }

        @Override // cn.damai.mine.view.LogoutDialog.OnDialogClickListener
        public void onDismiss() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2128021565")) {
                ipChange.ipc$dispatch("2128021565", new Object[]{this});
            }
        }

        @Override // cn.damai.mine.view.LogoutDialog.OnDialogClickListener
        public void onFirstSel() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1870205529")) {
                ipChange.ipc$dispatch("1870205529", new Object[]{this});
            }
        }

        @Override // cn.damai.mine.view.LogoutDialog.OnDialogClickListener
        public void onSecondSel() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-473671295")) {
                ipChange.ipc$dispatch("-473671295", new Object[]{this});
                return;
            }
            LoginManager.k().u();
            C0529c.e().x(gb2.g().r());
            SettingActivity.this.logoutDM();
            DamaiCookieManager.getInstance().resetAll();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.setting.SettingActivity$i */
    /* loaded from: classes16.dex */
    public class HandlerC1759i extends Handler {
        private static transient /* synthetic */ IpChange $ipChange;

        HandlerC1759i() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "460516311")) {
                ipChange.ipc$dispatch("460516311", new Object[]{this, message});
                return;
            }
            int i = message.what;
            if (i == 0) {
                SettingActivity.this.setCacheSize();
                ToastUtil a = ToastUtil.a();
                SettingActivity settingActivity = SettingActivity.this;
                a.j(settingActivity.mainActivity, cm2.b(settingActivity, R$string.damai_more_empty_success_toast));
            } else if (i != 1) {
            } else {
                SettingActivity.this.setCacheSize();
                ToastUtil a2 = ToastUtil.a();
                SettingActivity settingActivity2 = SettingActivity.this;
                a2.j(settingActivity2.mainActivity, cm2.b(settingActivity2, R$string.damai_more_empty_failure_toast));
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.setting.SettingActivity$j */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC1760j implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC1760j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1931207161")) {
                ipChange.ipc$dispatch("1931207161", new Object[]{this, view});
            } else {
                DMNav.from(SettingActivity.this).toUri("https://market.m.taobao.com/app/msd/m-privacy-center/index.html#/policy/220");
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.setting.SettingActivity$k */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC1761k implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC1761k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-252469766")) {
                ipChange.ipc$dispatch("-252469766", new Object[]{this, view});
            } else {
                DMNav.from(SettingActivity.this).toUri("https://m.taopiaopiao.com/tickets/dianying/pages/alfheim/content.html?id=2114311&displayType=plain&hsb=yes&hideAuthorInfo=yes&interact=no&loading=false");
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.setting.SettingActivity$l */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC1762l implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC1762l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1858820603")) {
                ipChange.ipc$dispatch("1858820603", new Object[]{this, view});
            } else {
                SettingActivity.this.jumpToInformationCollectH5();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.setting.SettingActivity$m */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC1763m implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC1763m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-324856324")) {
                ipChange.ipc$dispatch("-324856324", new Object[]{this, view});
            } else {
                SettingActivity.this.startActivity(new Intent(SettingActivity.this, PermissionEntranceActivity.class));
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.setting.SettingActivity$n */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC1764n implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC1764n() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1786434045")) {
                ipChange.ipc$dispatch("1786434045", new Object[]{this, view});
                return;
            }
            C0529c.e().x(gb2.g().l());
            SettingActivity.this.turnAccountSafe();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.setting.SettingActivity$o */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC1765o implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC1765o(SettingActivity settingActivity) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1714047487")) {
                ipChange.ipc$dispatch("1714047487", new Object[]{this, view});
                return;
            }
            C0529c.e().x(gb2.g().m());
            UpdateUtil.d();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.setting.SettingActivity$p */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC1766p implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC1766p() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-469629440")) {
                ipChange.ipc$dispatch("-469629440", new Object[]{this, view});
            } else {
                SettingActivity.this.jumpMessagePushPage();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Logout() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "160650832")) {
            ipChange.ipc$dispatch("160650832", new Object[]{this});
            return;
        }
        LogoutDialog logoutDialog = new LogoutDialog(this, R$style.custom_dialog_style);
        logoutDialog.e(new C1758h());
        logoutDialog.show();
    }

    private void display() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1722730674")) {
            ipChange.ipc$dispatch("-1722730674", new Object[]{this});
        } else {
            setCacheSize();
        }
    }

    private void gotoHomeMainActivity() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-421294768")) {
            ipChange.ipc$dispatch("-421294768", new Object[]{this});
        } else {
            DMNav.from(this).toUri(NavUri.b(cs.n));
        }
    }

    private void initTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1147792488")) {
            ipChange.ipc$dispatch("1147792488", new Object[]{this});
            return;
        }
        hideBaseLayout();
        this.mTvTitleBack = (DMIconFontTextView) findViewById(R$id.mine_title_left_icon_font_tv);
        TextView textView = (TextView) findViewById(R$id.mine_title_tv);
        this.mTitleTV = textView;
        textView.setText("设置");
        this.mTvTitleBack.setOnClickListener(this);
    }

    private void initTitleStatusBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-547871327")) {
            ipChange.ipc$dispatch("-547871327", new Object[]{this});
            return;
        }
        View findViewById = findViewById(R$id.title_bar_space);
        if (Build.VERSION.SDK_INT >= 23) {
            if (findViewById != null) {
                findViewById.getLayoutParams().height = kg2.a(this);
                findViewById.setVisibility(0);
            }
            kg2.f(this, true, R$color.black);
            kg2.d(true, this);
            return;
        }
        kg2.f(this, false, R$color.black);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
    }

    private void initViewContent() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1770372372")) {
            ipChange.ipc$dispatch("-1770372372", new Object[]{this});
            return;
        }
        this.mainActivity = this;
        this.rl_clear = (RelativeLayout) findViewById(R$id.rl_clear);
        this.rl_update = (RelativeLayout) findViewById(R$id.rl_update);
        this.ll_push = (RelativeLayout) findViewById(R$id.ll_push);
        this.mPrivacyRl = (RelativeLayout) findViewById(R$id.rl_privacy);
        this.rl_help = (RelativeLayout) findViewById(R$id.rl_help);
        this.rl_protocol = (RelativeLayout) findViewById(R$id.rl_protocol);
        this.rl_about = (RelativeLayout) findViewById(R$id.rl_about);
        this.rl_phone = (RelativeLayout) findViewById(R$id.rl_phone);
        this.rl_account_safe = (RelativeLayout) findViewById(R$id.rl_account_safe);
        this.mLvFeedback = (LinearLayout) findViewById(R$id.mine_setting_feedback_lv);
        this.tv_cache_size = (TextView) findViewById(R$id.tv_cache_size);
        this.mFlBottomBtnContainer = (FrameLayout) findViewById(R$id.setting_bottom_btn_container_fl);
        this.logout_btn = (TextView) findViewById(R$id.logout_btn);
        findViewById(R$id.mine_setting_privacy_summary).setOnClickListener(new View$OnClickListenerC1760j());
        findViewById(R$id.rl_person_information_share_list).setOnClickListener(new View$OnClickListenerC1761k());
        findViewById(R$id.rl_person_information_collect_list).setOnClickListener(new View$OnClickListenerC1762l());
        findViewById(R$id.rl_system_permission).setOnClickListener(new View$OnClickListenerC1763m());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jumpMessagePushPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1080071086")) {
            ipChange.ipc$dispatch("1080071086", new Object[]{this});
        } else if (LoginManager.k().q()) {
            C0529c.e().x(gb2.g().s());
            DMNav.from(this).toUri(NavUri.b(cs.MESSAGE_PUSH_SETTING));
        } else {
            LoginManager.k().x(this.mainActivity, new Intent(), 1611);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jumpToFaqActivity() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "280116948")) {
            ipChange.ipc$dispatch("280116948", new Object[]{this});
        } else if (LoginManager.k().q()) {
            DMNav.from(this).toUri(NavUri.b("feedback_list"));
        } else {
            LoginManager.k().x(this, new Intent(), 1800);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jumpToInformationCollectH5() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2106657414")) {
            ipChange.ipc$dispatch("2106657414", new Object[]{this});
        } else if (LoginManager.k().q()) {
            Bundle bundle = new Bundle();
            bundle.putString("loading", "false");
            bundle.putString("url", "https://t.damai.cn/yep/page/m/gwrab7nnw9");
            DMNav.from(this).withExtras(bundle).toUri(NavUri.b(cs.t));
        } else {
            LoginManager.k().x(this, new Intent(), 1801);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logoutDM() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1874353529")) {
            ipChange.ipc$dispatch("-1874353529", new Object[]{this});
            return;
        }
        z20.W("");
        ACache.b(this).a();
        z20.r0("");
        z20.x0("");
        z20.k0("");
        z20.i0(true);
        z20.Y("");
        z20.Z("");
        z20.a();
        z20.j0("");
        PassportManager.getInstance().logout();
        try {
            new TencentUtil(this.mainActivity).qqLogout();
        } catch (Exception e) {
            e.printStackTrace();
        }
        z20.b0(false);
        this.mFlBottomBtnContainer.setVisibility(8);
        this.mainActivity.sendBroadcast(new Intent(tf1.REFRESH_USER_BROADCAST));
        this.mainActivity.sendBroadcast(new Intent(DamaiConstants.LOGOUT));
        try {
            Intent intent = new Intent();
            intent.setAction(DamaiConstants.TICKLET_EXTERNAL_CALL_BRODCAST_ACTION);
            intent.setPackage("cn.damai");
            intent.putExtra("type", 4);
            sendBroadcast(intent);
        } catch (Exception e2) {
            p3.a("damai_member", "member_service_start", "exit", e2.getMessage());
        }
        gotoHomeMainActivity();
        setResult(-1);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCacheSize() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2121057159")) {
            ipChange.ipc$dispatch("-2121057159", new Object[]{this});
        } else {
            this.tv_cache_size.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void turnAccountSafe() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-201986925")) {
            ipChange.ipc$dispatch("-201986925", new Object[]{this});
        } else if (LoginManager.k().q()) {
            Intent intent = new Intent(this, AccountSafeActivity.class);
            intent.putExtra("usercode", z20.E());
            startActivity(intent);
        } else {
            LoginManager.k().x(this.mainActivity, new Intent(), 1610);
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "953306146")) {
            ipChange.ipc$dispatch("953306146", new Object[]{this, Integer.valueOf(i)});
        } else if (i == 10003) {
            finish();
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1483184264") ? ((Integer) ipChange.ipc$dispatch("1483184264", new Object[]{this})).intValue() : R$layout.fragment_setting;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1167040499")) {
            ipChange.ipc$dispatch("1167040499", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1105589096")) {
            ipChange.ipc$dispatch("-1105589096", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1803781371")) {
            ipChange.ipc$dispatch("-1803781371", new Object[]{this});
            return;
        }
        this.usercode = getIntent().getLongExtra("userCode", 0L);
        initTitle();
        initTitleStatusBar();
        initViewContent();
        registerListener();
        display();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1842876844")) {
            ipChange.ipc$dispatch("1842876844", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 1610) {
                turnAccountSafe();
            } else if (i == 1800) {
                jumpToFaqActivity();
            } else if (i == 1801) {
                jumpToInformationCollectH5();
            } else if (i == 1611) {
                jumpMessagePushPage();
            }
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-304951893")) {
            ipChange.ipc$dispatch("-304951893", new Object[]{this, view});
            return;
        }
        super.onClick(view);
        if (view.getId() == R$id.mine_title_left_icon_font_tv) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "59184405")) {
            ipChange.ipc$dispatch("59184405", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setDamaiUTKeyBuilder(gb2.g().t());
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2086397717")) {
            return ((Boolean) ipChange.ipc$dispatch("-2086397717", new Object[]{this, Integer.valueOf(i), keyEvent})).booleanValue();
        }
        if (i == 4) {
            setResult(-1);
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1885376222")) {
            ipChange.ipc$dispatch("-1885376222", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "405565619")) {
            ipChange.ipc$dispatch("405565619", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1132954482")) {
            ipChange.ipc$dispatch("-1132954482", new Object[]{this});
            return;
        }
        if (LoginManager.k().q()) {
            this.mFlBottomBtnContainer.setVisibility(0);
        } else {
            this.mFlBottomBtnContainer.setVisibility(8);
        }
        this.mPrivacyRl.setVisibility(0);
        super.onResume();
    }

    public void registerListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1525862947")) {
            ipChange.ipc$dispatch("1525862947", new Object[]{this});
            return;
        }
        this.rl_account_safe.setOnClickListener(new View$OnClickListenerC1764n());
        this.rl_clear.setOnClickListener(new View.OnClickListener() { // from class: cn.damai.setting.SettingActivity.7
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-397242882")) {
                    ipChange2.ipc$dispatch("-397242882", new Object[]{this, view});
                } else {
                    new Thread() { // from class: cn.damai.setting.SettingActivity.7.1
                        private static transient /* synthetic */ IpChange $ipChange;

                        @Override // java.lang.Thread, java.lang.Runnable
                        public void run() {
                            IpChange ipChange3 = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange3, "1495041669")) {
                                ipChange3.ipc$dispatch("1495041669", new Object[]{this});
                                return;
                            }
                            C0529c.e().x(gb2.g().n());
                            C0504a.b().a();
                            SettingActivity.this.handler.sendEmptyMessage(0);
                        }
                    }.start();
                }
            }
        });
        this.rl_update.setOnClickListener(new View$OnClickListenerC1765o(this));
        this.ll_push.setOnClickListener(new View$OnClickListenerC1766p());
        this.rl_help.setOnClickListener(new View$OnClickListenerC1751a());
        this.rl_protocol.setOnClickListener(new View$OnClickListenerC1752b());
        this.rl_about.setOnClickListener(new View$OnClickListenerC1753c());
        this.rl_phone.setOnClickListener(new View$OnClickListenerC1754d());
        this.logout_btn.setOnClickListener(new View$OnClickListenerC1755e());
        this.mLvFeedback.setOnClickListener(new View$OnClickListenerC1756f());
        this.mPrivacyRl.setOnClickListener(new View$OnClickListenerC1757g());
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1283453180") ? (String) ipChange.ipc$dispatch("1283453180", new Object[]{this}) : "设置";
    }
}
