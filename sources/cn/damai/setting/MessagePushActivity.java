package cn.damai.setting;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.user.C0529c;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.base.PermissionsHelper;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.homepage.R$string;
import cn.damai.login.havana.HavanaProxy;
import cn.damai.setting.bean.MessagePushConfigBean;
import cn.damai.setting.bean.MessagePushGetBean;
import cn.damai.setting.net.MessagePushConfigRequest;
import cn.damai.setting.net.MessagePushGettingRequest;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.uikit.switchbutton.SwitchButton;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import tb.gb2;
import tb.kg2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class MessagePushActivity extends DamaiBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int REQUEST_PUSH_OPEN = 100;
    private static final String SMS_MARKETING = "SMS_MARKETING";
    private LinearLayout ll_push;
    private TextView mTitleTV;
    private DMIconFontTextView mTvTitleBack;
    MessagePushActivity mainActivity;
    private SwitchButton sms_switch;
    private TextView sms_tip;
    private TextView tv_push_content;
    private TextView tv_push_status;
    private String localErrorMsg = "操作失败，请重试";
    private HashMap<String, Boolean> switchRecode = new HashMap<>();

    private void initTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-58012457")) {
            ipChange.ipc$dispatch("-58012457", new Object[]{this});
            return;
        }
        hideBaseLayout();
        this.mTvTitleBack = (DMIconFontTextView) findViewById(R$id.mine_title_left_icon_font_tv);
        TextView textView = (TextView) findViewById(R$id.mine_title_tv);
        this.mTitleTV = textView;
        textView.setText(getResources().getString(R$string.mine_setting_message_tips));
        this.mTvTitleBack.setOnClickListener(this);
    }

    private void initTitleStatusBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2047562258")) {
            ipChange.ipc$dispatch("2047562258", new Object[]{this});
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
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "440849435")) {
            ipChange.ipc$dispatch("440849435", new Object[]{this});
            return;
        }
        this.mainActivity = this;
        this.ll_push = (LinearLayout) findViewById(R$id.ll_push);
        this.tv_push_status = (TextView) findViewById(R$id.mine_tv_push_status);
        this.tv_push_content = (TextView) findViewById(R$id.mine_tv_push_content);
        SwitchButton switchButton = (SwitchButton) findViewById(R$id.rl_sms_switch_btn);
        this.sms_switch = switchButton;
        switchButton.setChecked(true);
        this.sms_tip = (TextView) findViewById(R$id.mine_tv_sms_content);
        String string = getResources().getString(R$string.mine_setting_push_content_tip);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R$color.main_color)), string.length() - 3, string.length(), 33);
        this.tv_push_content.setText(spannableString);
        if (TextUtils.isEmpty(HavanaProxy.v().w())) {
            str = "";
        } else {
            str = "（" + HavanaProxy.v().w() + "）";
        }
        this.sms_tip.setText(getResources().getString(R$string.mine_setting_sms_content_tip, str));
        this.tv_push_content.setOnClickListener(this);
        this.ll_push.setOnClickListener(this);
    }

    private void pushStatusCtrl() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1757509780")) {
            ipChange.ipc$dispatch("1757509780", new Object[]{this});
        } else if (PermissionsHelper.a(this)) {
            setPushOpen();
        } else {
            setPushClose();
        }
    }

    private void requestConfig() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "885906350")) {
            ipChange.ipc$dispatch("885906350", new Object[]{this});
        } else {
            new MessagePushGettingRequest().request(new DMMtopRequestListener<MessagePushGetBean>(MessagePushGetBean.class) { // from class: cn.damai.setting.MessagePushActivity.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str, String str2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1499897456")) {
                        ipChange2.ipc$dispatch("-1499897456", new Object[]{this, str, str2});
                    }
                }

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onSuccess(MessagePushGetBean messagePushGetBean) {
                    ArrayList<String> arrayList;
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1183517006")) {
                        ipChange2.ipc$dispatch("-1183517006", new Object[]{this, messagePushGetBean});
                    } else if (messagePushGetBean != null && (arrayList = messagePushGetBean.off) != null && arrayList.size() > 0) {
                        for (int i = 0; i < messagePushGetBean.off.size(); i++) {
                            if (MessagePushActivity.SMS_MARKETING.equals(messagePushGetBean.off.get(i))) {
                                MessagePushActivity.this.sms_switch.setChecked(false);
                                return;
                            }
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestSwitch(boolean z, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1888281694")) {
            ipChange.ipc$dispatch("-1888281694", new Object[]{this, Boolean.valueOf(z), str});
            return;
        }
        MessagePushConfigRequest messagePushConfigRequest = new MessagePushConfigRequest();
        if (z) {
            messagePushConfigRequest.off = str;
        } else {
            messagePushConfigRequest.on = str;
        }
        messagePushConfigRequest.request(new DMMtopRequestListener<MessagePushConfigBean>(MessagePushConfigBean.class) { // from class: cn.damai.setting.MessagePushActivity.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str2, String str3) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1507656815")) {
                    ipChange2.ipc$dispatch("-1507656815", new Object[]{this, str2, str3});
                    return;
                }
                ToastUtil.f(str3);
                MessagePushActivity.this.setSwitchRecode(false);
                MessagePushActivity.this.switchRecode.clear();
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(MessagePushConfigBean messagePushConfigBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-267060185")) {
                    ipChange2.ipc$dispatch("-267060185", new Object[]{this, messagePushConfigBean});
                    return;
                }
                if (messagePushConfigBean == null) {
                    ToastUtil.f(MessagePushActivity.this.localErrorMsg);
                    MessagePushActivity.this.setSwitchRecode(false);
                } else {
                    C0529c.e().x(gb2.g().j());
                    if (messagePushConfigBean.result) {
                        MessagePushActivity.this.setSwitchRecode(true);
                    } else if (!TextUtils.isEmpty(messagePushConfigBean.message)) {
                        ToastUtil.f(messagePushConfigBean.message);
                        MessagePushActivity.this.setSwitchRecode(false);
                    }
                }
                MessagePushActivity.this.switchRecode.clear();
            }
        });
    }

    private void setPush() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "375692131")) {
            ipChange.ipc$dispatch("375692131", new Object[]{this});
            return;
        }
        C0529c.e().x(gb2.g().h());
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.parse("package:" + getPackageName()));
        startActivityForResult(intent, 100);
    }

    private void setPushClose() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1851884399")) {
            ipChange.ipc$dispatch("1851884399", new Object[]{this});
        } else {
            this.tv_push_status.setText(getResources().getString(R$string.mine_setting_push_status_close));
        }
    }

    private void setPushOpen() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1532185017")) {
            ipChange.ipc$dispatch("1532185017", new Object[]{this});
        } else {
            this.tv_push_status.setText(getResources().getString(R$string.mine_setting_push_status_open));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSwitchRecode(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1646917291")) {
            ipChange.ipc$dispatch("1646917291", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        for (String str : this.switchRecode.keySet()) {
            if (SMS_MARKETING.equals(str)) {
                if (z) {
                    this.sms_switch.setChecked(!this.switchRecode.get(str).booleanValue());
                    return;
                } else {
                    this.sms_switch.setChecked(this.switchRecode.get(str).booleanValue());
                    return;
                }
            }
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "781705427")) {
            ipChange.ipc$dispatch("781705427", new Object[]{this, Integer.valueOf(i)});
        } else if (i == 10003) {
            finish();
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1949165257") ? ((Integer) ipChange.ipc$dispatch("-1949165257", new Object[]{this})).intValue() : R$layout.mine_message_push_layout;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2138387748")) {
            ipChange.ipc$dispatch("2138387748", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1058595449")) {
            ipChange.ipc$dispatch("-1058595449", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1066815670")) {
            ipChange.ipc$dispatch("1066815670", new Object[]{this});
            return;
        }
        initTitle();
        initTitleStatusBar();
        initViewContent();
        registerListener();
        pushStatusCtrl();
        requestConfig();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2045166819")) {
            ipChange.ipc$dispatch("-2045166819", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        if (i == 100) {
            pushStatusCtrl();
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1523513628")) {
            ipChange.ipc$dispatch("1523513628", new Object[]{this, view});
            return;
        }
        super.onClick(view);
        int id = view.getId();
        if (id == R$id.mine_title_left_icon_font_tv) {
            finish();
        } else if (id == R$id.ll_push || id == R$id.mine_tv_push_content) {
            setPush();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "907040708")) {
            ipChange.ipc$dispatch("907040708", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setDamaiUTKeyBuilder(gb2.g().i());
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1880513626")) {
            return ((Boolean) ipChange.ipc$dispatch("1880513626", new Object[]{this, Integer.valueOf(i), keyEvent})).booleanValue();
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
        if (AndroidInstantRuntime.support(ipChange, "-914028973")) {
            ipChange.ipc$dispatch("-914028973", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1268183394")) {
            ipChange.ipc$dispatch("1268183394", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1737642559")) {
            ipChange.ipc$dispatch("1737642559", new Object[]{this});
        } else {
            super.onResume();
        }
    }

    public void registerListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1354262228")) {
            ipChange.ipc$dispatch("1354262228", new Object[]{this});
        } else {
            this.sms_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: cn.damai.setting.MessagePushActivity.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1342357497")) {
                        ipChange2.ipc$dispatch("-1342357497", new Object[]{this, compoundButton, Boolean.valueOf(z)});
                        return;
                    }
                    MessagePushActivity.this.switchRecode.put(MessagePushActivity.SMS_MARKETING, Boolean.valueOf(!z));
                    MessagePushActivity.this.requestSwitch(!z, MessagePushActivity.SMS_MARKETING);
                }
            });
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1619530603") ? (String) ipChange.ipc$dispatch("1619530603", new Object[]{this}) : "";
    }
}
