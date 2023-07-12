package cn.damai.login.havana;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import cn.damai.common.app.widget.DMDialog;
import cn.damai.common.user.C0529c;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.base.ui.BaseFragment;
import com.ali.user.mobile.login.action.LoginResActions;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.sns4android.SNSAuth;
import com.taobao.android.sns4android.SNSPlatform;
import com.taobao.android.sso.v2.launch.ui.GuideFragment;
import com.tencent.connect.common.Constants;
import tb.ew0;
import tb.nq;
import tb.wu0;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class DamaiGuideFragment extends GuideFragment {
    private static transient /* synthetic */ IpChange $ipChange;
    private CheckBox ckProSelect;
    private LinearLayout llProSelect;
    private LinearLayout llUserbg;
    private ImageView mBtnMore;
    private ImageView mBtnQQ;
    private ImageView mBtnWeChat;
    private ImageView mBtnWeiBo;
    private BroadcastReceiver mLoginReceiver;
    private TextView tvProDesc;
    private String middleProDesc = "已阅读并同意《大麦用户服务协议》、《隐私权政策》、《订票服务条款》中全部条款。\n第三方账号首次登录需绑定手机号。";
    private String alertProDesc = "为了更好地保障您的合法权益，请您阅读并同意以下协议《大麦用户服务协议》《隐私权政策》《订票服务条款》。第三方账号首次登录需绑定手机号。";

    /* compiled from: Taobao */
    /* renamed from: cn.damai.login.havana.DamaiGuideFragment$a */
    /* loaded from: classes15.dex */
    public class View$OnClickListenerC1323a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC1323a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-159653793")) {
                ipChange.ipc$dispatch("-159653793", new Object[]{this, view});
            } else if (DamaiGuideFragment.this.ckProSelect.isChecked()) {
                DamaiGuideFragment.this.ckProSelect.setChecked(false);
            } else {
                DamaiGuideFragment.this.ckProSelect.setChecked(true);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.login.havana.DamaiGuideFragment$b */
    /* loaded from: classes15.dex */
    public class DialogInterface$OnClickListenerC1324b implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        DialogInterface$OnClickListenerC1324b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1579492882")) {
                ipChange.ipc$dispatch("-1579492882", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            DamaiGuideFragment.this.ckProSelect.setChecked(false);
            ew0.f().k("disagree", DamaiGuideFragment.class.getSimpleName(), "1");
            dialogInterface.dismiss();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.login.havana.DamaiGuideFragment$c */
    /* loaded from: classes15.dex */
    public class DialogInterface$OnClickListenerC1325c implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ View a;

        DialogInterface$OnClickListenerC1325c(View view) {
            this.a = view;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-609911859")) {
                ipChange.ipc$dispatch("-609911859", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            DamaiGuideFragment.this.ckProSelect.setChecked(true);
            ew0.f().k("agree", DamaiGuideFragment.class.getSimpleName(), "1");
            if (this.a.getId() == R$id.login_third_tb_btn) {
                HavanaProxy.v().q(DamaiGuideFragment.this);
            } else if (this.a.getId() == R$id.login_third_account_btn) {
                DamaiGuideFragment.this.onAccountLoginClick(this.a);
            } else if (this.a.getId() == R$id.login_third_zhifubao_btn) {
                HavanaProxy.v().n(DamaiGuideFragment.this);
            } else if (this.a.getId() == R$id.login_third_platform_weibo_btn) {
                HavanaProxy.v().r(DamaiGuideFragment.this);
            } else if (this.a.getId() == R$id.login_third_platform_qq_btn) {
                HavanaProxy.v().o(DamaiGuideFragment.this);
            } else if (this.a.getId() == R$id.login_platform_wechat_btn) {
                HavanaProxy.v().s(DamaiGuideFragment.this);
            }
            dialogInterface.dismiss();
        }
    }

    private SpannableString getSpannableString(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1800237159")) {
            return (SpannableString) ipChange.ipc$dispatch("1800237159", new Object[]{this, str});
        }
        SpannableString spannableString = new SpannableString(str);
        if (!TextUtils.isEmpty(str)) {
            if (str.contains("《大麦用户服务协议》")) {
                int indexOf = str.indexOf("《大麦用户服务协议》");
                int i = indexOf + 10;
                spannableString.setSpan(new StyleSpan(0), indexOf, i, 17);
                spannableString.setSpan(new nq(this.mAttachedActivity, 0), indexOf, i, 17);
            }
            if (str.contains("《隐私权政策》")) {
                int indexOf2 = str.indexOf("《隐私权政策》");
                int i2 = indexOf2 + 7;
                spannableString.setSpan(new StyleSpan(0), indexOf2, i2, 17);
                spannableString.setSpan(new nq(this.mAttachedActivity, 1), indexOf2, i2, 17);
            }
            if (str.contains("《订票服务条款》")) {
                int indexOf3 = str.indexOf("《订票服务条款》");
                int i3 = indexOf3 + 8;
                spannableString.setSpan(new StyleSpan(0), indexOf3, i3, 17);
                spannableString.setSpan(new nq(this.mAttachedActivity, 2), indexOf3, i3, 17);
            }
        }
        return spannableString;
    }

    private void threeLoginPro(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1486045206")) {
            ipChange.ipc$dispatch("-1486045206", new Object[]{this, view});
            return;
        }
        TextView textView = new TextView(this.mAttachedActivity);
        textView.setLineSpacing(0.0f, 1.2f);
        textView.setTextColor(-16777216);
        textView.setTextSize(1, 14.0f);
        textView.setText(getSpannableString(this.alertProDesc));
        textView.setTextColor(Color.parseColor("#9c9ca5"));
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setHighlightColor(0);
        DMDialog dMDialog = new DMDialog(this.mAttachedActivity);
        dMDialog.setCancelable(false);
        dMDialog.i("不同意", new DialogInterface$OnClickListenerC1324b());
        dMDialog.n("同意", new DialogInterface$OnClickListenerC1325c(view));
        dMDialog.u(textView);
        wu0.g(getActivity(), dMDialog.c());
        dMDialog.show();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1298225372")) {
            ipChange.ipc$dispatch("-1298225372", new Object[]{this, bundle});
            return;
        }
        super.onActivityCreated(bundle);
        if (this.mAttachedActivity.getToolbar() != null) {
            this.mAttachedActivity.getToolbar().setNavigationIcon(R$drawable.dm_aliuser_taobaox_actionbar_back);
        }
        wu0.g(getActivity(), (getActivity() == null || getActivity().getWindow() == null) ? this.llUserbg : getActivity().getWindow().getDecorView());
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1613765230")) {
            ipChange.ipc$dispatch("-1613765230", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        SNSAuth.onActivityResult(SNSPlatform.PLATFORM_QQ, i, i2, intent);
        SNSAuth.onActivityResult(SNSPlatform.PLATFORM_WEIBO, i, i2, intent);
        SNSAuth.onActivityResult(SNSPlatform.PLATFORM_WEIXIN, i, i2, intent);
        SNSAuth.onActivityResult(SNSPlatform.PLATFORM_ALIPAY, i, i2, intent);
    }

    @Override // com.taobao.android.sso.v2.launch.ui.GuideFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1916064367")) {
            ipChange.ipc$dispatch("-1916064367", new Object[]{this, view});
            return;
        }
        int id = view.getId();
        if (id == R$id.login_third_tb_btn) {
            C0529c.e().x(ew0.f().h("手淘", 1));
            if (this.ckProSelect.isChecked()) {
                HavanaProxy.v().q(this);
            } else {
                threeLoginPro(view);
            }
        } else if (id == R$id.login_third_account_btn) {
            C0529c.e().x(ew0.f().h("账号", 5));
            if (this.ckProSelect.isChecked()) {
                onAccountLoginClick(view);
            } else {
                threeLoginPro(view);
            }
        } else if (id == R$id.login_third_zhifubao_btn) {
            C0529c.e().x(ew0.f().h("支付宝", 0));
            if (this.ckProSelect.isChecked()) {
                HavanaProxy.v().n(this);
            } else {
                threeLoginPro(view);
            }
        } else if (id == R$id.login_third_more_btn) {
            this.mBtnMore.setVisibility(8);
            this.mBtnWeiBo.setVisibility(0);
            this.mBtnQQ.setVisibility(0);
            this.mBtnWeChat.setVisibility(0);
        } else if (id == R$id.login_third_platform_weibo_btn) {
            C0529c.e().x(ew0.f().h("新浪微博", 2));
            if (this.ckProSelect.isChecked()) {
                HavanaProxy.v().r(this);
            } else {
                threeLoginPro(view);
            }
        } else if (id == R$id.login_third_platform_qq_btn) {
            C0529c.e().x(ew0.f().h(Constants.SOURCE_QQ, 4));
            if (this.ckProSelect.isChecked()) {
                HavanaProxy.v().o(this);
            } else {
                threeLoginPro(view);
            }
        } else if (id == R$id.login_platform_wechat_btn) {
            C0529c.e().x(ew0.f().h("微信", 3));
            if (this.ckProSelect.isChecked()) {
                HavanaProxy.v().s(this);
            } else {
                threeLoginPro(view);
            }
        } else {
            super.onClick(view);
        }
    }

    @Override // com.ali.user.mobile.base.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-290440651")) {
            return (View) ipChange.ipc$dispatch("-290440651", new Object[]{this, layoutInflater, viewGroup, bundle});
        }
        HavanaProxy.v().y();
        View inflate = LayoutInflater.from(getContext()).inflate(R$layout.dm_ali_user_sso_guide_activity, (ViewGroup) null);
        inflate.findViewById(R$id.login_third_tb_btn).setOnClickListener(this);
        inflate.findViewById(R$id.login_third_account_btn).setOnClickListener(this);
        inflate.findViewById(R$id.login_third_zhifubao_btn).setOnClickListener(this);
        this.llUserbg = (LinearLayout) inflate.findViewById(R$id.ali_userbg);
        ImageView imageView = (ImageView) inflate.findViewById(R$id.login_third_more_btn);
        this.mBtnMore = imageView;
        imageView.setOnClickListener(this);
        this.mBtnMore.setVisibility(0);
        ImageView imageView2 = (ImageView) inflate.findViewById(R$id.login_third_platform_weibo_btn);
        this.mBtnWeiBo = imageView2;
        imageView2.setOnClickListener(this);
        this.mBtnWeiBo.setVisibility(8);
        ImageView imageView3 = (ImageView) inflate.findViewById(R$id.login_third_platform_qq_btn);
        this.mBtnQQ = imageView3;
        imageView3.setOnClickListener(this);
        this.mBtnQQ.setVisibility(8);
        ImageView imageView4 = (ImageView) inflate.findViewById(R$id.login_platform_wechat_btn);
        this.mBtnWeChat = imageView4;
        imageView4.setOnClickListener(this);
        this.mBtnWeChat.setVisibility(8);
        this.mLoginReceiver = new BroadcastReceiver() { // from class: cn.damai.login.havana.DamaiGuideFragment.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "320642476")) {
                    ipChange2.ipc$dispatch("320642476", new Object[]{this, context, intent});
                } else if (!LoginResActions.LOGIN_SUCCESS_ACTION.equals(intent.getAction()) || ((BaseFragment) DamaiGuideFragment.this).mAttachedActivity == null) {
                } else {
                    ((BaseFragment) DamaiGuideFragment.this).mAttachedActivity.finish();
                }
            }
        };
        LocalBroadcastManager.getInstance(DataProviderFactory.getApplicationContext()).registerReceiver(this.mLoginReceiver, new IntentFilter(LoginResActions.LOGIN_SUCCESS_ACTION));
        this.mAttachedActivity.supportTaobaoOrAlipay = true;
        this.llProSelect = (LinearLayout) inflate.findViewById(R$id.dm_ll_login_pro);
        this.tvProDesc = (TextView) inflate.findViewById(R$id.dm_tv_login_pro_desc);
        this.ckProSelect = (CheckBox) inflate.findViewById(R$id.dm_cb_login_pro);
        this.tvProDesc.setText(getSpannableString(this.middleProDesc));
        this.tvProDesc.setHighlightColor(0);
        this.tvProDesc.setMovementMethod(LinkMovementMethod.getInstance());
        this.ckProSelect.setChecked(false);
        this.llProSelect.setOnClickListener(new View$OnClickListenerC1323a());
        this.ckProSelect.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: cn.damai.login.havana.DamaiGuideFragment.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "995708926")) {
                    ipChange2.ipc$dispatch("995708926", new Object[]{this, compoundButton, Boolean.valueOf(z)});
                } else if (z) {
                    ew0.f().k("agree", DamaiGuideFragment.class.getSimpleName(), "0");
                } else {
                    ew0.f().k("disagree", DamaiGuideFragment.class.getSimpleName(), "0");
                }
            }
        });
        return inflate;
    }

    @Override // com.taobao.android.sso.v2.launch.ui.GuideFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "473274607")) {
            ipChange.ipc$dispatch("473274607", new Object[]{this});
            return;
        }
        super.onDestroy();
        if (this.mLoginReceiver != null) {
            LocalBroadcastManager.getInstance(DataProviderFactory.getApplicationContext()).unregisterReceiver(this.mLoginReceiver);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "377225224")) {
            ipChange.ipc$dispatch("377225224", new Object[]{this, view, bundle});
        } else {
            super.onViewCreated(view, bundle);
        }
    }
}
