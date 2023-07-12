package cn.damai.login.havana;

import android.app.Activity;
import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.nq;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class DamaiProtocolView extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context mContext;
    private String mNegativeText;
    private String mPositiveText;
    private String mRegTip;

    public DamaiProtocolView(Context context) {
        super(context);
        this.mContext = context;
        initView();
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1759216358")) {
            ipChange.ipc$dispatch("1759216358", new Object[]{this});
            return;
        }
        View inflate = LayoutInflater.from(this.mContext).inflate(R$layout.dm_user_protocol, this);
        TextView textView = (TextView) inflate.findViewById(R$id.aliuser_protocal_tip);
        TextView textView2 = (TextView) inflate.findViewById(R$id.aliuser_reg_tip);
        if (TextUtils.isEmpty(this.mRegTip)) {
            textView2.setVisibility(8);
        } else {
            if (this.mRegTip.length() > 10) {
                textView2.setTextSize(2, 18.0f);
            } else {
                textView2.setTextSize(2, 24.0f);
            }
            textView2.setText(this.mRegTip);
        }
        String charSequence = textView.getText().toString();
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        SpannableString spannableString = new SpannableString(charSequence);
        if (charSequence.contains("《大麦用户服务协议》")) {
            int indexOf = charSequence.indexOf("《大麦用户服务协议》");
            int i = indexOf + 10;
            spannableString.setSpan(new StyleSpan(0), indexOf, i, 17);
            spannableString.setSpan(new nq((Activity) this.mContext, 0), indexOf, i, 17);
        }
        if (charSequence.contains("《隐私权政策》")) {
            int indexOf2 = charSequence.indexOf("《隐私权政策》");
            int i2 = indexOf2 + 7;
            spannableString.setSpan(new StyleSpan(0), indexOf2, i2, 17);
            spannableString.setSpan(new nq((Activity) this.mContext, 1), indexOf2, i2, 17);
        }
        if (charSequence.contains("《订票服务条款》")) {
            int indexOf3 = charSequence.indexOf("《订票服务条款》");
            int i3 = indexOf3 + 8;
            spannableString.setSpan(new StyleSpan(0), indexOf3, i3, 17);
            spannableString.setSpan(new nq((Activity) this.mContext, 2), indexOf3, i3, 17);
        }
        textView.setText(spannableString);
        textView.setHighlightColor(0);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public void setNegativeText(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1679836331")) {
            ipChange.ipc$dispatch("-1679836331", new Object[]{this, str});
        } else {
            this.mNegativeText = str;
        }
    }

    public void setPositive(String str, View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1255033157")) {
            ipChange.ipc$dispatch("-1255033157", new Object[]{this, str, onClickListener});
        } else {
            this.mPositiveText = str;
        }
    }

    public void setRegTip(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1999906288")) {
            ipChange.ipc$dispatch("-1999906288", new Object[]{this, str});
        } else {
            this.mRegTip = str;
        }
    }

    public DamaiProtocolView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initView();
    }

    public DamaiProtocolView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        initView();
    }
}
