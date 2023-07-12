package cn.damai.login.havana;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.R$string;
import com.ali.user.mobile.register.ProtocolModel;
import com.ali.user.mobile.register.ui.AliUserMobileRegisterFragment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import tb.ew0;
import tb.wu0;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class DamaiRegisterFragment extends AliUserMobileRegisterFragment {
    private static transient /* synthetic */ IpChange $ipChange;
    private CheckBox mProtocolCb;
    private View mRegBtn;
    private LinearLayout rootView;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.login.havana.DamaiRegisterFragment$a */
    /* loaded from: classes15.dex */
    public class C1330a implements TextWatcher {
        private static transient /* synthetic */ IpChange $ipChange;

        C1330a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-117866968")) {
                ipChange.ipc$dispatch("-117866968", new Object[]{this, editable});
            } else {
                DamaiRegisterFragment.this.changeSmsBtnBackGround(editable.toString());
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-564340965")) {
                ipChange.ipc$dispatch("-564340965", new Object[]{this, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1676431675")) {
                ipChange.ipc$dispatch("1676431675", new Object[]{this, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.login.havana.DamaiRegisterFragment$b */
    /* loaded from: classes15.dex */
    public class View$OnClickListenerC1331b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC1331b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-590417904")) {
                ipChange.ipc$dispatch("-590417904", new Object[]{this, view});
            } else if (DamaiRegisterFragment.this.mProtocolCb.isChecked()) {
                DamaiRegisterFragment.super.onClick(view);
            } else {
                DamaiRegisterFragment.this.toast("请阅读并同意相关协议", 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeSmsBtnBackGround(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1394896902")) {
            ipChange.ipc$dispatch("-1394896902", new Object[]{this, str});
        } else if (!TextUtils.isEmpty(str)) {
            this.mSendSMSCodeBtn.setTextColor(getResources().getColor(R$color.main_color));
        } else {
            this.mSendSMSCodeBtn.setTextColor(getResources().getColor(R$color.main_color_disable_state));
        }
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1850489500")) {
            ipChange.ipc$dispatch("1850489500", new Object[]{this});
            return;
        }
        if (this.mAttachedActivity.getToolbar() != null) {
            this.mAttachedActivity.getToolbar().setTitle("新用户注册");
        }
        if (this.mAttachedActivity.getToolbar() != null) {
            this.mAttachedActivity.getToolbar().setNavigationIcon(R$drawable.icon_back_black_normal);
        }
        this.mSendSMSCodeBtn.setTextColor(getResources().getColor(R$color.main_color_disable_state));
        this.mMobileET.addTextChangedListener(new C1330a());
        this.mRegBtn.setOnClickListener(new View$OnClickListenerC1331b());
        this.mProtocolCb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: cn.damai.login.havana.DamaiRegisterFragment.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-2051926801")) {
                    ipChange2.ipc$dispatch("-2051926801", new Object[]{this, compoundButton, Boolean.valueOf(z)});
                } else if (z) {
                    ew0.f().k("agree", DamaiRegisterFragment.class.getSimpleName(), "0");
                } else {
                    ew0.f().k("disagree", DamaiRegisterFragment.class.getSimpleName(), "0");
                }
            }
        });
    }

    @Override // com.ali.user.mobile.register.ui.AliUserMobileRegisterFragment, com.ali.user.mobile.base.ui.BaseFragment
    protected int getLayoutContent() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-118385237") ? ((Integer) ipChange.ipc$dispatch("-118385237", new Object[]{this})).intValue() : R$layout.dm_aliuser_fragment_mobile_register;
    }

    @Override // com.ali.user.mobile.register.ui.AliUserMobileRegisterFragment
    protected ProtocolModel getProtocolModel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1648574110")) {
            return (ProtocolModel) ipChange.ipc$dispatch("-1648574110", new Object[]{this});
        }
        ProtocolModel protocolModel = new ProtocolModel();
        protocolModel.protocolTitle = getString(R$string.aliuser_damai_protocol_text);
        HashMap hashMap = new HashMap();
        hashMap.put(getString(R$string.aliuser_damai_protocal), getString(R$string.aliuser_damai_protocol_url_new));
        hashMap.put(getString(R$string.aliuser_damai_policy_protocal), getString(R$string.aliuser_damai_policy_protocol_url_new));
        hashMap.put(getString(R$string.aliuser_damai_book_protocal), getString(R$string.aliuser_damai_book_policy_protocol_url));
        protocolModel.protocolItems = hashMap;
        protocolModel.protocolItemColor = R$color.aliuser_damai_protocol_color;
        return protocolModel;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "465794517")) {
            ipChange.ipc$dispatch("465794517", new Object[]{this, bundle});
            return;
        }
        super.onActivityCreated(bundle);
        initView();
        wu0.g(getActivity(), (getActivity() == null || getActivity().getWindow() == null) ? this.rootView : getActivity().getWindow().getDecorView());
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "389798199")) {
            ipChange.ipc$dispatch("389798199", new Object[]{this, view, bundle});
            return;
        }
        super.onViewCreated(view, bundle);
        this.mProtocolCb = (CheckBox) view.findViewById(R$id.dm_cb_register_pro);
        this.mRegBtn = view.findViewById(R$id.aliuser_register_reg_btn);
        this.rootView = (LinearLayout) view.findViewById(R$id.dm_aliuser_root_region);
    }
}
