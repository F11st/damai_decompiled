package cn.damai.trade.newtradeorder.ui.projectdetail.robticketstrategy;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.user.C0529c;
import cn.damai.commonbusiness.base.SimpleBaseActivity;
import cn.damai.commonbusiness.model.UserBaseInfoBean;
import cn.damai.commonbusiness.model.UserData;
import cn.damai.im.UserInfoUtil;
import cn.damai.im.request.PersonalInfoRequest;
import cn.damai.login.LoginManager;
import cn.damai.trade.R$array;
import cn.damai.trade.R$color;
import cn.damai.trade.R$drawable;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.cs;
import tb.kg2;
import tb.pp2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class TicketGuidePreFillActity extends SimpleBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int LOGIN_FOR_ADD_ADDRESS = 4119;
    private static final int LOGIN_FOR_ADD_CUSTOMER = 4118;
    private static final int LOGIN_FOR_ADD_EMAIL = 4119;
    private LinearLayout mContainerLayout;
    private String mEmailContent;
    private String mProjectId;
    private String[] ticketGuideContent;
    private String[] ticketGuideTitle;
    private int[] ids = {R$drawable.icon_pre_custom, R$drawable.icon_pre_address, R$drawable.icon_pre_email};
    private boolean visEmail = false;
    View.OnClickListener itemClickListener = new View$OnClickListenerC2419b();

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.robticketstrategy.TicketGuidePreFillActity$a */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC2418a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC2418a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1596118939")) {
                ipChange.ipc$dispatch("-1596118939", new Object[]{this, view});
            } else {
                TicketGuidePreFillActity.this.finish();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.robticketstrategy.TicketGuidePreFillActity$b */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC2419b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC2419b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "515171430")) {
                ipChange.ipc$dispatch("515171430", new Object[]{this, view});
                return;
            }
            int intValue = ((Integer) view.getTag()).intValue();
            if (intValue == 0) {
                TicketGuidePreFillActity.this.toCustomerList();
            } else if (intValue == 1) {
                TicketGuidePreFillActity.this.toAddressList();
            } else if (intValue != 2) {
            } else {
                TicketGuidePreFillActity.this.toEmailPage();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.robticketstrategy.TicketGuidePreFillActity$c */
    /* loaded from: classes8.dex */
    public class C2420c implements UserInfoUtil.OnUserInfoListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C2420c() {
        }

        @Override // cn.damai.im.UserInfoUtil.OnUserInfoListener
        public void onFailed(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1011425202")) {
                ipChange.ipc$dispatch("-1011425202", new Object[]{this, str, str2});
            } else {
                TicketGuidePreFillActity.this.mEmailContent = "";
            }
        }

        @Override // cn.damai.im.UserInfoUtil.OnUserInfoListener
        public void onSuccess(UserData userData) {
            UserBaseInfoBean userBaseInfo;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "727988571")) {
                ipChange.ipc$dispatch("727988571", new Object[]{this, userData});
                return;
            }
            TicketGuidePreFillActity.this.mEmailContent = "";
            if (userData == null || (userBaseInfo = userData.getUserBaseInfo()) == null) {
                return;
            }
            TicketGuidePreFillActity.this.mEmailContent = userBaseInfo.getMaskEmail();
        }
    }

    private void getAuthStatus() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1765388653")) {
            ipChange.ipc$dispatch("-1765388653", new Object[]{this});
        } else if (LoginManager.k().q()) {
            PersonalInfoRequest personalInfoRequest = new PersonalInfoRequest();
            personalInfoRequest.needUserBaseInfo = "true";
            personalInfoRequest.needCertificationBaseInfo = "true";
            personalInfoRequest.canAcceptDelay = "false";
            UserInfoUtil.b(personalInfoRequest, new C2420c());
        }
    }

    private void initData() {
        Bundle extras;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "705537741")) {
            ipChange.ipc$dispatch("705537741", new Object[]{this});
            return;
        }
        Intent intent = getIntent();
        if (intent != null && (extras = intent.getExtras()) != null) {
            this.visEmail = extras.getBoolean("visEmail", false);
            this.mProjectId = extras.getString("projectId", "0");
        }
        if (!this.visEmail) {
            this.ticketGuideTitle = getResources().getStringArray(R$array.ticket_guide_title);
            this.ticketGuideContent = getResources().getStringArray(R$array.ticket_guide_content);
            return;
        }
        this.ticketGuideTitle = getResources().getStringArray(R$array.ticket_guide_titleE);
        this.ticketGuideContent = getResources().getStringArray(R$array.ticket_guide_contentE);
    }

    private void initStateBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-538696523")) {
            ipChange.ipc$dispatch("-538696523", new Object[]{this});
            return;
        }
        View findViewById = findViewById(R$id.status_bar);
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

    private void initTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1034063643")) {
            ipChange.ipc$dispatch("1034063643", new Object[]{this});
            return;
        }
        TextView textView = (TextView) findViewById(R$id.ticket_rob_title_tv);
        textView.setText("预填信息");
        int i = R$color.color_000000;
        textView.setTextColor(ContextCompat.getColor(this, i));
        textView.setTextSize(1, 20.0f);
        DMIconFontTextView dMIconFontTextView = (DMIconFontTextView) findViewById(R$id.ticket_rob_title_back_tv);
        dMIconFontTextView.setTextColor(ContextCompat.getColor(this, i));
        dMIconFontTextView.setOnClickListener(new View$OnClickListenerC2418a());
    }

    private void loadData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1127290313")) {
            ipChange.ipc$dispatch("-1127290313", new Object[]{this});
            return;
        }
        String[] strArr = this.ticketGuideTitle;
        int length = strArr != null ? strArr.length : 0;
        String[] strArr2 = this.ticketGuideContent;
        int length2 = strArr2 != null ? strArr2.length : 0;
        if (length2 != length) {
            finish();
        }
        this.mContainerLayout.removeAllViews();
        for (int i = 0; i < length2; i++) {
            View inflate = LayoutInflater.from(this).inflate(R$layout.layout_ticket_guide_prefill, (ViewGroup) null);
            ((TextView) inflate.findViewById(R$id.tv_ticket_guide_title)).setText(this.ticketGuideTitle[i]);
            ((TextView) inflate.findViewById(R$id.tv_ticket_guide_desc)).setText(this.ticketGuideContent[i]);
            ((ImageView) inflate.findViewById(R$id.iv_image)).setImageResource(this.ids[i]);
            this.mContainerLayout.addView(inflate);
            inflate.setTag(Integer.valueOf(i));
            inflate.setOnClickListener(this.itemClickListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toAddressList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1475513260")) {
            ipChange.ipc$dispatch("1475513260", new Object[]{this});
            return;
        }
        C0529c.e().x(pp2.u().A2(this.mProjectId));
        if (LoginManager.k().q()) {
            Bundle bundle = new Bundle();
            bundle.putString("type", "morenpeisong");
            DMNav.from(this).withExtras(bundle).toUri(cs.g());
            return;
        }
        DMNav.from(this).forResult(4119).toUri(cs.f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toCustomerList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1162544816")) {
            ipChange.ipc$dispatch("-1162544816", new Object[]{this});
            return;
        }
        C0529c.e().x(pp2.u().B2(this.mProjectId));
        if (LoginManager.k().q()) {
            DMNav.from(this).toUri(NavUri.b(cs.R));
        } else {
            DMNav.from(this).forResult(LOGIN_FOR_ADD_CUSTOMER).toUri(cs.f());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toEmailPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "927703475")) {
            ipChange.ipc$dispatch("927703475", new Object[]{this});
            return;
        }
        C0529c.e().x(pp2.u().C2(this.mProjectId));
        if (LoginManager.k().q()) {
            if (TextUtils.isEmpty(this.mEmailContent)) {
                LoginManager.k().d(this);
                return;
            } else {
                LoginManager.k().e(this);
                return;
            }
        }
        DMNav.from(this).forResult(4119).toUri(cs.f());
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-436053381") ? ((Integer) ipChange.ipc$dispatch("-436053381", new Object[]{this})).intValue() : R$layout.activity_ticket_guide_prefill;
    }

    @Override // cn.damai.commonbusiness.base.SimpleBaseActivity, cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-283429390")) {
            ipChange.ipc$dispatch("-283429390", new Object[]{this});
            return;
        }
        hideBaseLayout();
        this.mContainerLayout = (LinearLayout) findViewById(R$id.ll_container);
        initStateBar();
        initTitle();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1391579481")) {
            ipChange.ipc$dispatch("1391579481", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        if (LoginManager.k().q()) {
            if (i == LOGIN_FOR_ADD_CUSTOMER) {
                toCustomerList();
            } else if (i == 4119) {
                toAddressList();
            } else if (i == 4119) {
                toEmailPage();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1094872824")) {
            ipChange.ipc$dispatch("-1094872824", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        initData();
        loadData();
        setDamaiUTKeyBuilder(pp2.u().d1(this.mProjectId));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "387397499")) {
            ipChange.ipc$dispatch("387397499", new Object[]{this});
            return;
        }
        super.onResume();
        getAuthStatus();
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1157968465") ? (String) ipChange.ipc$dispatch("-1157968465", new Object[]{this}) : "";
    }
}
