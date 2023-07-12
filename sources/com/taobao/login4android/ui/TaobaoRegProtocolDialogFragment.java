package com.taobao.login4android.ui;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.app.dataprovider.StringOrangeResult;
import com.ali.user.mobile.register.ProtocolModel;
import com.ali.user.mobile.ui.R;
import com.ali.user.mobile.utils.ElderUtil;
import com.ali.user.mobile.utils.ProtocolHelper;
import com.ali.user.mobile.utils.UTConstans;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.wireless.security.aopsdk.replace.android.view.Display;
import java.util.HashMap;

/* loaded from: classes11.dex */
public class TaobaoRegProtocolDialogFragment extends DialogFragment {
    protected View aliuser_protocal_inset_ll;
    private Activity mAttachedActivity;
    protected View.OnClickListener mCancelListener;
    protected TextView mContentTV;
    protected CharSequence mContextText;
    protected String mLogoUrl;
    protected View.OnClickListener mNagetiveListener;
    protected String mNegativeBtnText;
    protected String mOneKeyProtocol;
    protected String mOneKeyProtocolUrl;
    protected String mPageSpm;
    protected View.OnClickListener mPositiveListener;
    protected String mPostiveBtnText;
    protected TextView mTitleTV;
    protected CharSequence mTitleText;
    protected boolean needAdaptElder;
    protected boolean useOrangeColor;
    protected boolean negativeVisible = true;
    public boolean contentVisible = true;
    protected int height = 0;
    protected String mPageName = UTConstans.PageName.UT_PAGE_ONEKEY_REG_NEW;
    protected boolean first = false;

    /* renamed from: com.taobao.login4android.ui.TaobaoRegProtocolDialogFragment$a */
    /* loaded from: classes11.dex */
    class View$OnClickListenerC6732a implements View.OnClickListener {
        View$OnClickListenerC6732a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TaobaoRegProtocolDialogFragment taobaoRegProtocolDialogFragment = TaobaoRegProtocolDialogFragment.this;
            View.OnClickListener onClickListener = taobaoRegProtocolDialogFragment.mCancelListener;
            if (onClickListener != null) {
                onClickListener.onClick(view);
                return;
            }
            View.OnClickListener onClickListener2 = taobaoRegProtocolDialogFragment.mNagetiveListener;
            if (onClickListener2 != null) {
                onClickListener2.onClick(view);
            }
        }
    }

    /* renamed from: com.taobao.login4android.ui.TaobaoRegProtocolDialogFragment$b */
    /* loaded from: classes11.dex */
    class View$OnClickListenerC6733b implements View.OnClickListener {
        View$OnClickListenerC6733b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TaobaoRegProtocolDialogFragment.this.dismissAllowingStateLoss();
            View.OnClickListener onClickListener = TaobaoRegProtocolDialogFragment.this.mPositiveListener;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    /* renamed from: com.taobao.login4android.ui.TaobaoRegProtocolDialogFragment$c */
    /* loaded from: classes11.dex */
    class View$OnClickListenerC6734c implements View.OnClickListener {
        View$OnClickListenerC6734c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TaobaoRegProtocolDialogFragment.this.dismissAllowingStateLoss();
            View.OnClickListener onClickListener = TaobaoRegProtocolDialogFragment.this.mNagetiveListener;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    protected void generateContent(View view) {
        int i;
        int i2;
        int i3;
        ProtocolModel protocolModel = new ProtocolModel();
        String string = getString(R.string.aliuser_reg_potocol_content);
        HashMap hashMap = new HashMap();
        StringOrangeResult customProtocol = DataProviderFactory.getOrangeConfig().customProtocol();
        if (customProtocol.orangeExist) {
            try {
                JSONArray parseArray = JSON.parseArray(customProtocol.value);
                for (int i4 = 0; i4 < parseArray.size(); i4++) {
                    JSONObject jSONObject = parseArray.getJSONObject(i4);
                    string = string + jSONObject.getString("title") + " ";
                    hashMap.put(jSONObject.getString("title"), jSONObject.getString("url"));
                }
            } catch (Throwable unused) {
            }
        }
        if (hashMap.size() == 0) {
            hashMap.put(getString(R.string.aliuser_tb_protocal), getString(R.string.aliuser_tb_protocal_url));
            hashMap.put(getString(R.string.aliuser_policy_protocal), getString(R.string.aliuser_policy_protocal_url));
            hashMap.put(getString(R.string.aliuser_alipay_protocal), getString(R.string.aliuser_alipay_protocal_url));
            string = string + getString(i) + " " + getString(i2) + " " + getString(i3);
        }
        if (!TextUtils.isEmpty(this.mOneKeyProtocol) && !TextUtils.isEmpty(this.mOneKeyProtocolUrl)) {
            string = string + "《" + this.mOneKeyProtocol + "》";
            hashMap.put(this.mOneKeyProtocol, this.mOneKeyProtocolUrl);
        }
        if (this.first) {
            string = string + getString(R.string.aliuser_reg_protocol_autoreg);
        }
        protocolModel.protocolTitle = string;
        protocolModel.protocolItems = hashMap;
        if (this.useOrangeColor) {
            protocolModel.protocolItemColor = R.C2963color.aliuser_edittext_bg_color_activated;
        } else {
            protocolModel.protocolItemColor = R.C2963color.aliuser_new_edit_text_color;
        }
        ProtocolHelper.generateProtocol(protocolModel, this.mAttachedActivity, this.mContentTV, this.mPageName, this.mPageSpm, false);
    }

    public View.OnClickListener getCancelListener() {
        return this.mCancelListener;
    }

    protected int getLayoutContent() {
        return R.C2965layout.aliuser_reg_protocol_dialog;
    }

    public String getLogoUrl() {
        return this.mLogoUrl;
    }

    protected void initViews(View view) {
    }

    public boolean isNeedAdaptElder() {
        return this.needAdaptElder;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mAttachedActivity = activity;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.C2967style.AliUserDialogTheme);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().requestWindowFeature(1);
        View inflate = layoutInflater.inflate(getLayoutContent(), viewGroup);
        View findViewById = inflate.findViewById(R.id.aliuser_protocal_inset_ll);
        this.aliuser_protocal_inset_ll = findViewById;
        if (findViewById != null) {
            findViewById.setOnClickListener(new View$OnClickListenerC6732a());
        }
        TextView textView = (TextView) inflate.findViewById(R.id.aliuser_operation_tip);
        this.mTitleTV = textView;
        if (textView != null) {
            textView.setMovementMethod(ScrollingMovementMethod.getInstance());
            if (!TextUtils.isEmpty(this.mTitleText)) {
                this.mTitleTV.setText(this.mTitleText);
            }
        }
        TextView textView2 = (TextView) inflate.findViewById(R.id.aliuser_operation_sencondary_tip);
        this.mContentTV = textView2;
        if (this.contentVisible) {
            if (!TextUtils.isEmpty(this.mContextText)) {
                this.mContentTV.setText(this.mContextText);
            } else {
                generateContent(inflate);
            }
        } else {
            textView2.setVisibility(8);
        }
        Button button = (Button) inflate.findViewById(R.id.aliuser_operation_agree);
        if (button != null) {
            button.requestFocus();
            button.setOnClickListener(new View$OnClickListenerC6733b());
            if (!TextUtils.isEmpty(this.mPostiveBtnText)) {
                button.setText(this.mPostiveBtnText);
            }
            if (DataProviderFactory.getDataProvider().getBtnDrawable() != -1) {
                button.setBackgroundResource(DataProviderFactory.getDataProvider().getBtnDrawable());
            }
            if (DataProviderFactory.getDataProvider().getBtnTextColor() != -1) {
                button.setTextColor(getResources().getColor(DataProviderFactory.getDataProvider().getBtnTextColor()));
            }
        }
        Button button2 = (Button) inflate.findViewById(R.id.aliuser_operation_disagree);
        if (button2 != null) {
            button2.setOnClickListener(new View$OnClickListenerC6734c());
            if (this.negativeVisible) {
                button2.setVisibility(0);
            } else {
                button2.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.mNegativeBtnText)) {
                button2.setText(this.mNegativeBtnText);
            }
            if (DataProviderFactory.getDataProvider().getCancelBtnDrawable() != -1) {
                button2.setBackgroundResource(DataProviderFactory.getDataProvider().getCancelBtnDrawable());
            }
            if (DataProviderFactory.getDataProvider().getCancelBtnTextColor() != -1) {
                button2.setTextColor(getResources().getColor(DataProviderFactory.getDataProvider().getCancelBtnTextColor()));
            }
        }
        if (this.needAdaptElder) {
            ElderUtil.scaleTextSize(this.mTitleTV, this.mContentTV, button, button2);
        }
        setCancelable(false);
        initViews(inflate);
        return inflate;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            Display.getMetrics(getActivity().getWindowManager().getDefaultDisplay(), displayMetrics);
            int i = (int) (this.height * displayMetrics.density);
            Window window = dialog.getWindow();
            int i2 = (int) (com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics) * 0.78d);
            if (this.height == 0) {
                i = -2;
            }
            window.setLayout(i2, i);
        }
    }

    public void setCancelListener(View.OnClickListener onClickListener) {
        this.mCancelListener = onClickListener;
    }

    public void setContent(CharSequence charSequence) {
        this.mContextText = charSequence;
    }

    public void setFirst(boolean z) {
        this.first = z;
    }

    public void setLogoUrl(String str) {
        this.mLogoUrl = str;
    }

    public void setNagetive(View.OnClickListener onClickListener) {
        this.mNagetiveListener = onClickListener;
    }

    public void setNeedAdaptElder(boolean z) {
        this.needAdaptElder = z;
    }

    public void setNegativeBtnText(String str) {
        this.mNegativeBtnText = str;
    }

    public void setNegativeVisible(boolean z) {
        this.negativeVisible = z;
    }

    public void setOneKeyProtocol(String str) {
        this.mOneKeyProtocol = str;
    }

    public void setOneKeyProtocolUrl(String str) {
        this.mOneKeyProtocolUrl = str;
    }

    public void setPageNameSpm(String str, String str2) {
        this.mPageName = str;
        this.mPageSpm = str2;
    }

    public void setPositive(View.OnClickListener onClickListener) {
        this.mPositiveListener = onClickListener;
    }

    public void setPostiveBtnText(String str) {
        this.mPostiveBtnText = str;
    }

    public void setTitle(CharSequence charSequence) {
        this.mTitleText = charSequence;
    }

    public void setUseOrangeColor(boolean z) {
        this.useOrangeColor = z;
    }

    @Override // androidx.fragment.app.DialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        try {
            super.show(fragmentManager, str);
        } catch (IllegalStateException unused) {
        }
    }
}
