package com.ali.user.mobile.utils;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.app.dataprovider.StringOrangeResult;
import com.ali.user.mobile.base.ui.BaseFragment;
import com.ali.user.mobile.info.AppInfo;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.register.ProtocolModel;
import com.ali.user.mobile.register.old.TaoUrlSpan;
import com.ali.user.mobile.ui.R;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.login4android.config.LoginSwitch;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class ProtocolHelper {
    private static final String OPERATIONAL_TEXT = "reg_operational_text_v3";

    public static void generateProtocol(ProtocolModel protocolModel, Context context, TextView textView, String str, boolean z) {
        generateProtocol(protocolModel, context, textView, str, "", z);
    }

    public static ProtocolModel getProtocolModel(Context context, String str, String str2) {
        return getProtocolModel(context, str, str2, false);
    }

    public static void setCheckBox(CheckBox checkBox, String str, String str2, boolean z, boolean z2) {
        setCheckBox(null, checkBox, str, str2, z, z2);
    }

    public static void setRegOperationText(TextView textView) {
        if (textView != null) {
            if (Math.abs(AppInfo.getInstance().getUtdid().hashCode()) % 10000 <= LoginSwitch.getSwitch("red_packet_percent_v3", -1)) {
                String config = LoginSwitch.getConfig(OPERATIONAL_TEXT, "新注册用户领取最高30元红包");
                if (TextUtils.isEmpty(config)) {
                    textView.setVisibility(8);
                    return;
                }
                textView.setText(config);
                textView.setVisibility(0);
                return;
            }
            textView.setVisibility(8);
        }
    }

    public static void generateProtocol(final ProtocolModel protocolModel, Context context, TextView textView, final String str, final String str2, final boolean z) {
        if (textView == null || protocolModel == null || TextUtils.isEmpty(protocolModel.protocolTitle)) {
            return;
        }
        try {
            final Context applicationContext = context.getApplicationContext();
            SpannableString spannableString = new SpannableString(protocolModel.protocolTitle);
            Map<String, String> map = protocolModel.protocolItems;
            if (map != null) {
                for (String str3 : map.keySet()) {
                    int indexOf = protocolModel.protocolTitle.indexOf(str3);
                    int length = indexOf + str3.length();
                    if (length > indexOf) {
                        spannableString.setSpan(new TaoUrlSpan(protocolModel.protocolItems.get(str3)), indexOf, length, 33);
                        spannableString.setSpan(new ClickableSpan() { // from class: com.ali.user.mobile.utils.ProtocolHelper.2
                            @Override // android.text.style.ClickableSpan
                            public void onClick(View view) {
                                UserTrackAdapter.control(str, str2, "agreement");
                            }

                            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                            public void updateDrawState(TextPaint textPaint) {
                                super.updateDrawState(textPaint);
                                int i = ProtocolModel.this.protocolItemColor;
                                if (i > 0) {
                                    textPaint.setColor(ContextCompat.getColor(applicationContext, i));
                                }
                                textPaint.setUnderlineText(z);
                            }
                        }, indexOf, length, 33);
                    }
                    if (protocolModel.protocolTitle.length() != length) {
                        spannableString.setSpan(new ClickableSpan() { // from class: com.ali.user.mobile.utils.ProtocolHelper.3
                            @Override // android.text.style.ClickableSpan
                            public void onClick(View view) {
                                UserTrackAdapter.control(str, str2, "agreement");
                            }

                            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                            public void updateDrawState(TextPaint textPaint) {
                                super.updateDrawState(textPaint);
                                int i = ProtocolModel.this.protocolItemColor;
                                if (i > 0) {
                                    textPaint.setColor(ContextCompat.getColor(applicationContext, i));
                                }
                                textPaint.setUnderlineText(false);
                            }
                        }, length, length + 1, 33);
                    }
                }
            }
            textView.setText(spannableString);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            textView.setVisibility(0);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static ProtocolModel getProtocolModel(Context context, String str, String str2, boolean z) {
        ProtocolModel protocolModel = new ProtocolModel();
        StringBuilder sb = new StringBuilder(context.getString(R.string.aliuser_protocal_text));
        HashMap hashMap = new HashMap();
        StringOrangeResult customProtocol = DataProviderFactory.getOrangeConfig().customProtocol();
        if (customProtocol.orangeExist) {
            try {
                JSONArray parseArray = JSON.parseArray(customProtocol.value);
                for (int i = 0; i < parseArray.size(); i++) {
                    JSONObject jSONObject = parseArray.getJSONObject(i);
                    sb.append(jSONObject.getString("title"));
                    sb.append(" ");
                    hashMap.put(jSONObject.getString("title"), jSONObject.getString("url"));
                }
            } catch (Throwable unused) {
            }
        }
        if (hashMap.size() == 0) {
            int i2 = R.string.aliuser_tb_protocal;
            hashMap.put(context.getString(i2), context.getString(R.string.aliuser_tb_protocal_url));
            int i3 = R.string.aliuser_policy_protocal;
            hashMap.put(context.getString(i3), context.getString(R.string.aliuser_policy_protocal_url));
            String string = context.getString(R.string.aliuser_alipay_protocal);
            sb.append(context.getString(i2));
            sb.append(" ");
            sb.append(context.getString(i3));
            sb.append(" ");
            sb.append(string);
            hashMap.put(string, context.getString(R.string.aliuser_alipay_protocal_url));
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            sb.append("《");
            sb.append(str);
            sb.append("》");
            hashMap.put(str, str2);
        }
        if (z) {
            sb.append(context.getString(R.string.aliuser_reg_protocol_autoreg));
        }
        protocolModel.protocolTitle = sb.toString();
        protocolModel.protocolItems = hashMap;
        protocolModel.protocolItemColor = R.color.aliuser_new_edit_text_color;
        return protocolModel;
    }

    public static void setCheckBox(BaseFragment baseFragment, CheckBox checkBox, final String str, final String str2, boolean z, boolean z2) {
        if (checkBox != null) {
            if (DataProviderFactory.getDataProvider().enableElder() && baseFragment != null && baseFragment.needAdaptElder) {
                ElderUtil.viewScale(checkBox, 1.2f, ScreenUtil.dip2px(baseFragment.getContext(), 2.0f));
            }
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.ali.user.mobile.utils.ProtocolHelper.1
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                    if (z3) {
                        UserTrackAdapter.control(str, str2, "AgreementClick");
                    } else {
                        UserTrackAdapter.control(str, str2, "Agreement_Button_Cancel");
                    }
                }
            });
            if (z) {
                checkBox.setVisibility(0);
                if (z2) {
                    checkBox.setChecked(z2);
                }
                if (DataProviderFactory.getDataProvider().getCheckBoxDrawable() != -1) {
                    checkBox.setButtonDrawable(DataProviderFactory.getDataProvider().getCheckBoxDrawable());
                    return;
                }
                return;
            }
            checkBox.setVisibility(8);
        }
    }
}
