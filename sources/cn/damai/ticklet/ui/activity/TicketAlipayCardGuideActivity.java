package cn.damai.ticklet.ui.activity;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import cn.damai.common.nav.DMNav;
import cn.damai.member.R$color;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import cn.damai.ticklet.bean.TicketAlipayCardBean;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.in2;
import tb.kg2;
import tb.py2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class TicketAlipayCardGuideActivity extends TickletBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;
    private TicketAlipayCardBean ecertTipsInfo;
    private View mViewStatusBarSpace;
    private TextView tvCardGoto;
    private TextView tvCardRoute;
    private TextView tvCardTip;
    private TextView tvRule;
    private TextView tvTitle;
    private DMIconFontTextView tvTitleBack;

    private void onBackPresss() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1278523661")) {
            ipChange.ipc$dispatch("-1278523661", new Object[]{this});
        } else {
            finish();
        }
    }

    private void returnAlipayData(TicketAlipayCardBean ticketAlipayCardBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-21578101")) {
            ipChange.ipc$dispatch("-21578101", new Object[]{this, ticketAlipayCardBean});
            return;
        }
        py2.F(this.tvCardRoute, ticketAlipayCardBean.mainTip);
        py2.F(this.tvCardTip, ticketAlipayCardBean.subTips);
    }

    private void setImmersionStyle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1612478617")) {
            ipChange.ipc$dispatch("1612478617", new Object[]{this});
        } else if (Build.VERSION.SDK_INT >= 23) {
            View view = this.mViewStatusBarSpace;
            if (view != null) {
                view.getLayoutParams().height = kg2.a(this);
                this.mViewStatusBarSpace.setVisibility(0);
            }
            kg2.f(this, true, R$color.black);
            kg2.d(true, this);
        } else {
            kg2.f(this, false, R$color.black);
            View view2 = this.mViewStatusBarSpace;
            if (view2 != null) {
                view2.setVisibility(8);
            }
        }
    }

    @Override // cn.damai.ticklet.ui.activity.TickletBaseActivity, cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1952205017") ? ((Integer) ipChange.ipc$dispatch("1952205017", new Object[]{this})).intValue() : R$layout.ticklet_alipay_card_layout;
    }

    @Override // cn.damai.ticklet.ui.activity.TickletBaseActivity, cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "79238228")) {
            ipChange.ipc$dispatch("79238228", new Object[]{this});
            return;
        }
        this.mViewStatusBarSpace = findViewById(R$id.ticklet_title_bar_space_view);
        this.tvTitleBack = (DMIconFontTextView) findViewById(R$id.ticklet_iv_left_icon);
        this.tvRule = (TextView) findViewById(R$id.ticklet_rule_text_url);
        this.tvTitle = (TextView) findViewById(R$id.ticklet_title_text);
        this.tvCardRoute = (TextView) findViewById(R$id.ticklet_alipay_card_route);
        this.tvCardTip = (TextView) findViewById(R$id.ticklet_alipay_card_tip);
        this.tvCardGoto = (TextView) findViewById(R$id.ticklet_alipay_card_goto);
        setImmersionStyle();
        this.tvTitleBack.setOnClickListener(this);
        this.tvCardGoto.setOnClickListener(this);
        this.tvRule.setVisibility(8);
        this.tvTitle.setText("使用实人认证服务");
    }

    @Override // cn.damai.common.app.base.BaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        TicketAlipayCardBean ticketAlipayCardBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1827712710")) {
            ipChange.ipc$dispatch("-1827712710", new Object[]{this, view});
        } else if (view.getId() == R$id.ticklet_iv_left_icon) {
            onBackPresss();
        } else if (view.getId() == R$id.ticklet_rule_text_url) {
            py2.f().n(this, in2.DAMAI_TRANSFER_RULE_URL);
        } else if (view.getId() != R$id.ticklet_alipay_card_goto || (ticketAlipayCardBean = this.ecertTipsInfo) == null || TextUtils.isEmpty(ticketAlipayCardBean.alipayOpenUrl)) {
        } else {
            DMNav.from(this).toUri(this.ecertTipsInfo.alipayOpenUrl);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.ticklet.ui.activity.TickletBaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "98239334")) {
            ipChange.ipc$dispatch("98239334", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        if (getIntent() != null) {
            TicketAlipayCardBean ticketAlipayCardBean = (TicketAlipayCardBean) getIntent().getSerializableExtra("ecertTipsInfo");
            this.ecertTipsInfo = ticketAlipayCardBean;
            if (ticketAlipayCardBean == null) {
                return;
            }
            returnAlipayData(ticketAlipayCardBean);
        }
        hideBaseLayout();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "61228668")) {
            return ((Boolean) ipChange.ipc$dispatch("61228668", new Object[]{this, Integer.valueOf(i), keyEvent})).booleanValue();
        }
        if (i == 4) {
            onBackPresss();
        }
        return super.onKeyDown(i, keyEvent);
    }
}
