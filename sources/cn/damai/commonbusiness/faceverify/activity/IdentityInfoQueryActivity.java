package cn.damai.commonbusiness.faceverify.activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import cn.damai.common.app.widget.DMDialog;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.R$string;
import cn.damai.commonbusiness.R$style;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.contacts.ui.view.WheelView;
import cn.damai.commonbusiness.contacts.view.RealNameTipView;
import cn.damai.commonbusiness.faceverify.bean.CertificateTypeBean;
import cn.damai.commonbusiness.faceverify.bean.IdentityInfoQueryBean;
import cn.damai.commonbusiness.faceverify.contract.IdentityInfoQueryContract;
import cn.damai.commonbusiness.faceverify.manager.DMFaceVerifyManager;
import cn.damai.commonbusiness.faceverify.presenter.IdentityInfoQueryPresenter;
import cn.damai.im.AliMeUtil;
import cn.damai.login.LoginManager;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.cs;
import tb.kg2;
import tb.t60;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class IdentityInfoQueryActivity extends DamaiBaseActivity<IdentityInfoQueryPresenter, IdentityInfoQueryContract.Model> implements IdentityInfoQueryContract.View {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView certTypeNameTv;
    private EditText idCardEdit;
    private ClickableSpan mClickableSpan;
    private int mCurrentTypePosition;
    private HandlerC0687i mHandler;
    private List<String> mIdTypeNames;
    private List<CertificateTypeBean.ResultBean> mIdTypes;
    private TextView mSubmitBtn;
    private EditText realNameEdit;
    private String scence;
    private RealNameTipView tipView;
    private String certTypeCode = "";
    private final String mProtocolStr = "请您认真阅读并同意《实名须知》的全部条款，接受后可开始使用我们的服务";
    private final int mProtocolStart = 9;
    private final int mProtocolEnd = 15;
    private WheelView.C0631b OnWheelViewListener = new C0686h();

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.faceverify.activity.IdentityInfoQueryActivity$a */
    /* loaded from: classes14.dex */
    public class C0678a implements TextWatcher {
        private static transient /* synthetic */ IpChange $ipChange;

        C0678a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1061402593")) {
                ipChange.ipc$dispatch("1061402593", new Object[]{this, editable});
            } else {
                IdentityInfoQueryActivity.this.changeSubmitBtnBackground();
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1983826178")) {
                ipChange.ipc$dispatch("1983826178", new Object[]{this, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-420917598")) {
                ipChange.ipc$dispatch("-420917598", new Object[]{this, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.faceverify.activity.IdentityInfoQueryActivity$b */
    /* loaded from: classes14.dex */
    public class C0679b implements TextWatcher {
        private static transient /* synthetic */ IpChange $ipChange;

        C0679b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-121944704")) {
                ipChange.ipc$dispatch("-121944704", new Object[]{this, editable});
            } else {
                IdentityInfoQueryActivity.this.changeSubmitBtnBackground();
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1177950525")) {
                ipChange.ipc$dispatch("-1177950525", new Object[]{this, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1550021859")) {
                ipChange.ipc$dispatch("1550021859", new Object[]{this, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.faceverify.activity.IdentityInfoQueryActivity$c */
    /* loaded from: classes14.dex */
    public class View$OnFocusChangeListenerC0680c implements View.OnFocusChangeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnFocusChangeListenerC0680c() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-197953220")) {
                ipChange.ipc$dispatch("-197953220", new Object[]{this, view, Boolean.valueOf(z)});
            } else {
                IdentityInfoQueryActivity.this.idCardEdit.setText(IdentityInfoQueryActivity.this.idCardEdit.getText().toString().toUpperCase());
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.faceverify.activity.IdentityInfoQueryActivity$d */
    /* loaded from: classes14.dex */
    public class C0681d extends ClickableSpan {
        private static transient /* synthetic */ IpChange $ipChange;

        C0681d() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-136587847")) {
                ipChange.ipc$dispatch("-136587847", new Object[]{this, view});
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("url", "https://m.damai.cn/damai/mine/audience-notice/index.html");
            DMNav.from(IdentityInfoQueryActivity.this).withExtras(bundle).toUri(NavUri.b(cs.t));
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1383520098")) {
                ipChange.ipc$dispatch("-1383520098", new Object[]{this, textPaint});
                return;
            }
            super.updateDrawState(textPaint);
            textPaint.setColor(Color.parseColor("#ff1268"));
            textPaint.setUnderlineText(false);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.faceverify.activity.IdentityInfoQueryActivity$e */
    /* loaded from: classes14.dex */
    public class DialogInterface$OnClickListenerC0682e implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;
        final /* synthetic */ String b;

        DialogInterface$OnClickListenerC0682e(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2089835659")) {
                ipChange.ipc$dispatch("-2089835659", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            IdentityInfoQueryActivity.this.tipView.updateCheckState(true);
            IdentityInfoQueryActivity.this.mSubmitBtn.setClickable(false);
            IdentityInfoQueryActivity identityInfoQueryActivity = IdentityInfoQueryActivity.this;
            ((IdentityInfoQueryPresenter) identityInfoQueryActivity.mPresenter).queryIdentityInfo(this.a, this.b, identityInfoQueryActivity.certTypeCode);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.faceverify.activity.IdentityInfoQueryActivity$f */
    /* loaded from: classes14.dex */
    public class DialogInterface$OnClickListenerC0683f implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        DialogInterface$OnClickListenerC0683f(IdentityInfoQueryActivity identityInfoQueryActivity) {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1120254636")) {
                ipChange.ipc$dispatch("-1120254636", new Object[]{this, dialogInterface, Integer.valueOf(i)});
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.faceverify.activity.IdentityInfoQueryActivity$g */
    /* loaded from: classes4.dex */
    public class C0684g implements AliMeUtil.UserCodeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        /* compiled from: Taobao */
        /* renamed from: cn.damai.commonbusiness.faceverify.activity.IdentityInfoQueryActivity$g$a */
        /* loaded from: classes4.dex */
        public class C0685a implements AliMeUtil.AliMeTokenListener {
            private static transient /* synthetic */ IpChange $ipChange;

            C0685a() {
            }

            @Override // cn.damai.im.AliMeUtil.AliMeTokenListener
            public void onFailed() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1499482596")) {
                    ipChange.ipc$dispatch("-1499482596", new Object[]{this});
                } else {
                    AliMeUtil.o();
                }
            }

            @Override // cn.damai.im.AliMeUtil.AliMeTokenListener
            public void onSuccess(String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1085274280")) {
                    ipChange.ipc$dispatch("-1085274280", new Object[]{this, str});
                } else {
                    AliMeUtil.b(IdentityInfoQueryActivity.this, AliMeUtil.c(AliMeUtil.FROM_REALNAME_AUTH, str));
                }
            }
        }

        C0684g() {
        }

        @Override // cn.damai.im.AliMeUtil.UserCodeListener
        public void onFailed() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2106440497")) {
                ipChange.ipc$dispatch("-2106440497", new Object[]{this});
            } else {
                AliMeUtil.o();
            }
        }

        @Override // cn.damai.im.AliMeUtil.UserCodeListener
        public void onSuccess(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1367474537")) {
                ipChange.ipc$dispatch("1367474537", new Object[]{this, Long.valueOf(j)});
            } else {
                AliMeUtil.e(j, AliMeUtil.FROM_REALNAME_AUTH, new C0685a());
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.faceverify.activity.IdentityInfoQueryActivity$h */
    /* loaded from: classes4.dex */
    public class C0686h extends WheelView.C0631b {
        private static transient /* synthetic */ IpChange $ipChange;

        C0686h() {
        }

        @Override // cn.damai.commonbusiness.contacts.ui.view.WheelView.C0631b
        public void a(int i, String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "195336923")) {
                ipChange.ipc$dispatch("195336923", new Object[]{this, Integer.valueOf(i), str});
                return;
            }
            super.a(i, str);
            int i2 = i - 1;
            IdentityInfoQueryActivity.this.mCurrentTypePosition = i2;
            IdentityInfoQueryActivity.this.certTypeNameTv.setTag(IdentityInfoQueryActivity.this.mIdTypes.get(i2));
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.faceverify.activity.IdentityInfoQueryActivity$i */
    /* loaded from: classes14.dex */
    public class HandlerC0687i extends Handler {
        private static transient /* synthetic */ IpChange $ipChange;

        HandlerC0687i() {
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-521592087")) {
                ipChange.ipc$dispatch("-521592087", new Object[]{this, message});
                return;
            }
            super.dispatchMessage(message);
            if (message.what != 0) {
                return;
            }
            CertificateTypeBean.ResultBean resultBean = (CertificateTypeBean.ResultBean) IdentityInfoQueryActivity.this.certTypeNameTv.getTag();
            if (resultBean == null) {
                resultBean = wh2.e(IdentityInfoQueryActivity.this.mIdTypes) > 0 ? (CertificateTypeBean.ResultBean) IdentityInfoQueryActivity.this.mIdTypes.get(0) : null;
                IdentityInfoQueryActivity.this.certTypeNameTv.setTag(resultBean);
            }
            if (resultBean != null) {
                IdentityInfoQueryActivity.this.certTypeNameTv.setText(resultBean.getIdentufyName());
                IdentityInfoQueryActivity.this.certTypeCode = resultBean.getIdentifyCode();
            }
            IdentityInfoQueryActivity.this.changeSubmitBtnBackground();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.faceverify.activity.IdentityInfoQueryActivity$j */
    /* loaded from: classes14.dex */
    public class View$OnClickListenerC0688j implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        private Dialog a;

        public View$OnClickListenerC0688j(Dialog dialog) {
            this.a = dialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1204061136")) {
                ipChange.ipc$dispatch("-1204061136", new Object[]{this, view});
                return;
            }
            int id = view.getId();
            if (id == R$id.add_contacts_cancel_btn) {
                Dialog dialog = this.a;
                if (dialog != null) {
                    dialog.dismiss();
                }
            } else if (id == R$id.add_contacts_confirm_btn) {
                IdentityInfoQueryActivity.this.mHandler.sendEmptyMessage(0);
                Dialog dialog2 = this.a;
                if (dialog2 != null) {
                    dialog2.dismiss();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeSubmitBtnBackground() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "413324976")) {
            ipChange.ipc$dispatch("413324976", new Object[]{this});
            return;
        }
        String trim = this.idCardEdit.getText().toString().trim();
        String trim2 = this.realNameEdit.getText().toString().trim();
        String trim3 = this.certTypeNameTv.getText().toString().trim();
        if (!TextUtils.isEmpty(trim) && !TextUtils.isEmpty(trim2) && !TextUtils.isEmpty(trim3)) {
            this.mSubmitBtn.setBackgroundResource(R$drawable.bg_submit_button_roud);
            this.mSubmitBtn.setClickable(true);
        } else {
            this.mSubmitBtn.setBackgroundResource(R$drawable.bg_submit_button_90ffffff_mask);
            this.mSubmitBtn.setClickable(false);
        }
        if (!TextUtils.isEmpty(trim)) {
            int i = R$id.idcard_clear_btn;
            findViewById(i).setVisibility(0);
            findViewById(i).setOnClickListener(this);
        } else {
            findViewById(R$id.idcard_clear_btn).setVisibility(8);
        }
        if (!TextUtils.isEmpty(trim2)) {
            int i2 = R$id.realname_clear_btn;
            findViewById(i2).setVisibility(0);
            findViewById(i2).setOnClickListener(this);
            return;
        }
        findViewById(R$id.realname_clear_btn).setVisibility(8);
    }

    private void chooseCertType() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1436044125")) {
            ipChange.ipc$dispatch("-1436044125", new Object[]{this});
            return;
        }
        if (this.mHandler == null) {
            this.mHandler = new HandlerC0687i();
        }
        View inflate = LayoutInflater.from(this).inflate(R$layout.add_contacts_select_id_type_layout, (ViewGroup) null);
        WheelView wheelView = (WheelView) inflate.findViewById(R$id.add_contacts_idtype_list);
        wheelView.setOffset(1);
        wheelView.setItems(this.mIdTypeNames);
        wheelView.setSeletion(this.mCurrentTypePosition);
        wheelView.setOnWheelViewListener(this.OnWheelViewListener);
        Dialog dialog = new Dialog(this, R$style.ActionSheetDialogStyle);
        dialog.setContentView(inflate);
        Window window = dialog.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        window.setGravity(80);
        attributes.width = DisplayMetrics.getwidthPixels(t60.b(this));
        attributes.height = t60.a(this, 245.0f);
        window.setAttributes(attributes);
        dialog.setCanceledOnTouchOutside(true);
        ((TextView) inflate.findViewById(R$id.add_contacts_cancel_btn)).setOnClickListener(new View$OnClickListenerC0688j(dialog));
        ((TextView) inflate.findViewById(R$id.add_contacts_confirm_btn)).setOnClickListener(new View$OnClickListenerC0688j(dialog));
        dialog.show();
    }

    private void fetchCertificateType() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "700379777")) {
            ipChange.ipc$dispatch("700379777", new Object[]{this});
            return;
        }
        this.mIdTypeNames = new ArrayList();
        this.mIdTypes = new ArrayList();
        this.mIdTypeNames.clear();
        this.mIdTypes.clear();
        ((IdentityInfoQueryPresenter) this.mPresenter).fetchCertificateType("faceVerify");
    }

    private void goBack() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1811496407")) {
            ipChange.ipc$dispatch("-1811496407", new Object[]{this});
        } else {
            DMFaceVerifyManager.n().r();
        }
    }

    private void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "525153320")) {
            ipChange.ipc$dispatch("525153320", new Object[]{this});
            return;
        }
        this.mSubmitBtn = (TextView) findViewById(R$id.realname_auth_btn);
        this.realNameEdit = (EditText) findViewById(R$id.realname_edit);
        this.idCardEdit = (EditText) findViewById(R$id.realname_cernum_text);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.scence = extras.getString("scence");
        }
        ((TextView) findViewById(R$id.mine_base_header_title)).setText("输入证件");
        this.certTypeNameTv = (TextView) findViewById(R$id.certificate_typename);
        changeSubmitBtnBackground();
        RealNameTipView realNameTipView = (RealNameTipView) findViewById(R$id.realname_auth_tips);
        this.tipView = realNameTipView;
        realNameTipView.setText("我已阅读并同意《实名须知》", "《实名须知》");
        this.tipView.updateIconVis(true);
        this.tipView.updateCheckState(false);
    }

    private void initTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1230406294")) {
            ipChange.ipc$dispatch("-1230406294", new Object[]{this});
            return;
        }
        this.realNameEdit.setText("");
        this.idCardEdit.setText("");
    }

    private void initTitleStatusBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "94279391")) {
            ipChange.ipc$dispatch("94279391", new Object[]{this});
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

    private void setListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1468834980")) {
            ipChange.ipc$dispatch("-1468834980", new Object[]{this});
            return;
        }
        findViewById(R$id.realname_auth_btn).setOnClickListener(this);
        findViewById(R$id.realname_auth_back).setOnClickListener(this);
        findViewById(R$id.realname_center_certype_layout).setOnClickListener(this);
        this.realNameEdit.addTextChangedListener(new C0678a());
        this.idCardEdit.addTextChangedListener(new C0679b());
        this.idCardEdit.setOnFocusChangeListener(new View$OnFocusChangeListenerC0680c());
        this.mClickableSpan = new C0681d();
    }

    private void submitRealNameAuth() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1876804239")) {
            ipChange.ipc$dispatch("1876804239", new Object[]{this});
        } else if (LoginManager.k().q()) {
            String trim = this.idCardEdit.getText().toString().toUpperCase().trim();
            String trim2 = this.realNameEdit.getText().toString().trim();
            String trim3 = this.certTypeNameTv.getText().toString().trim();
            if (TextUtils.isEmpty(trim2)) {
                ToastUtil.i("请输入姓名");
            } else if (TextUtils.isEmpty(trim)) {
                ToastUtil.i("请输入证件号码");
            } else if (TextUtils.isEmpty(trim3)) {
                ToastUtil.i("请选择证件类型");
            } else if (!this.tipView.getCheckState()) {
                new DMDialog(this).s("请您认真阅读并同意《实名须知》的全部条款，接受后可开始使用我们的服务", 9, 15, this.mClickableSpan).i("不同意", new DialogInterface$OnClickListenerC0683f(this)).n("同意", new DialogInterface$OnClickListenerC0682e(trim, trim2)).show();
            } else {
                this.mSubmitBtn.setClickable(false);
                ((IdentityInfoQueryPresenter) this.mPresenter).queryIdentityInfo(trim, trim2, this.certTypeCode);
            }
        } else {
            LoginManager.k().v(this);
        }
    }

    @Override // cn.damai.commonbusiness.faceverify.contract.IdentityInfoQueryContract.View
    public void closeSelf() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-994241106")) {
            ipChange.ipc$dispatch("-994241106", new Object[]{this});
            return;
        }
        goBack();
        finish();
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-337644320")) {
            ipChange.ipc$dispatch("-337644320", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.commonbusiness.faceverify.contract.IdentityInfoQueryContract.View
    public void fetchCertificateTypeFailed(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-837958888")) {
            ipChange.ipc$dispatch("-837958888", new Object[]{this, str, str2});
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = getString(R$string.net_error);
        }
        ToastUtil.i(str2);
        this.certTypeNameTv.setText("身份证");
        this.certTypeCode = "1";
    }

    @Override // cn.damai.commonbusiness.faceverify.contract.IdentityInfoQueryContract.View
    public void fetchCertificateTypeSuccess(CertificateTypeBean certificateTypeBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2128076151")) {
            ipChange.ipc$dispatch("-2128076151", new Object[]{this, certificateTypeBean});
        } else if (certificateTypeBean != null) {
            List<CertificateTypeBean.ResultBean> result = certificateTypeBean.getResult();
            this.mIdTypes = result;
            if (wh2.e(result) > 0) {
                this.certTypeNameTv.setText(result.get(0).getIdentufyName());
                this.certTypeCode = result.get(0).getIdentifyCode();
                for (CertificateTypeBean.ResultBean resultBean : result) {
                    this.mIdTypeNames.add(resultBean.getIdentufyName());
                }
            }
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "956756234") ? ((Integer) ipChange.ipc$dispatch("956756234", new Object[]{this})).intValue() : R$layout.activity_faceverify_realname_auth_layout;
    }

    public void gotoAliMe() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1434530689")) {
            ipChange.ipc$dispatch("-1434530689", new Object[]{this});
        } else {
            AliMeUtil.j(new C0684g());
        }
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2027640753")) {
            ipChange.ipc$dispatch("2027640753", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-196784998")) {
            ipChange.ipc$dispatch("-196784998", new Object[]{this});
        } else {
            ((IdentityInfoQueryPresenter) this.mPresenter).setVM(this, (IdentityInfoQueryContract.Model) this.mModel);
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2137375171")) {
            ipChange.ipc$dispatch("2137375171", new Object[]{this});
            return;
        }
        hideBaseLayout();
        init();
        initTitle();
        initTitleStatusBar();
        setListener();
        fetchCertificateType();
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "160754614")) {
            ipChange.ipc$dispatch("160754614", new Object[]{this});
            return;
        }
        goBack();
        super.onBackPressed();
    }

    @Override // cn.damai.common.app.base.BaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1951719191")) {
            ipChange.ipc$dispatch("-1951719191", new Object[]{this, view});
            return;
        }
        super.onClick(view);
        int id = view.getId();
        if (id == R$id.realname_auth_btn) {
            this.idCardEdit.clearFocus();
            submitRealNameAuth();
        } else if (id == R$id.realname_auth_back) {
            goBack();
            finish();
        } else if (id == R$id.realname_right_icon) {
            gotoAliMe();
        } else if (id == R$id.realname_clear_btn) {
            EditText editText = this.realNameEdit;
            if (editText != null) {
                editText.setText("");
            }
        } else if (id == R$id.idcard_clear_btn) {
            EditText editText2 = this.idCardEdit;
            if (editText2 != null) {
                editText2.setText("");
            }
        } else if (id != R$id.realname_center_certype_layout || wh2.e(this.mIdTypeNames) <= 0) {
        } else {
            chooseCertType();
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1024775968")) {
            ipChange.ipc$dispatch("-1024775968", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-120862411")) {
            ipChange.ipc$dispatch("-120862411", new Object[]{this});
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "776410290")) {
            ipChange.ipc$dispatch("776410290", new Object[]{this, intent});
            return;
        }
        super.onNewIntent(intent);
        setIntent(intent);
        initTitle();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-932398565")) {
            ipChange.ipc$dispatch("-932398565", new Object[]{this});
            return;
        }
        super.onPause();
        this.mSubmitBtn.setClickable(true);
    }

    @Override // cn.damai.commonbusiness.faceverify.contract.IdentityInfoQueryContract.View
    public void queryIdentityInfoFailed(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-851626763")) {
            ipChange.ipc$dispatch("-851626763", new Object[]{this, str, str2});
            return;
        }
        TextView textView = this.mSubmitBtn;
        if (textView != null) {
            textView.setClickable(true);
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = getString(R$string.net_error);
        }
        ToastUtil.i(str2);
    }

    @Override // cn.damai.commonbusiness.faceverify.contract.IdentityInfoQueryContract.View
    public void queryIdentityInfoSuccess(IdentityInfoQueryBean identityInfoQueryBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1718639579")) {
            ipChange.ipc$dispatch("1718639579", new Object[]{this, identityInfoQueryBean});
            return;
        }
        TextView textView = this.mSubmitBtn;
        if (textView != null) {
            textView.setClickable(true);
        }
        if (identityInfoQueryBean != null && identityInfoQueryBean.isNeedFaceVerify()) {
            DMFaceVerifyManager.n().w(this, this.idCardEdit.getText().toString(), this.certTypeCode, this.realNameEdit.getText().toString(), this.scence);
            return;
        }
        ToastUtil.i("人脸信息已存在");
        DMFaceVerifyManager.n().u(identityInfoQueryBean);
        finish();
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "953236990")) {
            return (String) ipChange.ipc$dispatch("953236990", new Object[]{this});
        }
        return null;
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showEmptyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1423907875")) {
            ipChange.ipc$dispatch("-1423907875", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showErrorTips(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-654398119")) {
            ipChange.ipc$dispatch("-654398119", new Object[]{this, str});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showLoading(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-840087171")) {
            ipChange.ipc$dispatch("-840087171", new Object[]{this, str});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void stopLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2076385592")) {
            ipChange.ipc$dispatch("2076385592", new Object[]{this});
        }
    }
}
