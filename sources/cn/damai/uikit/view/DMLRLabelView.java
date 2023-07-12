package cn.damai.uikit.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.uikit.R$color;
import cn.damai.uikit.R$drawable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.l62;
import tb.q60;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class DMLRLabelView extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int BRAND = 2;
    public static final int STAR = 1;
    private DMLabelView labelView;
    private TextView mTagView;

    public DMLRLabelView(@NonNull Context context) {
        super(context);
        initView(context);
    }

    private void initView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "136599032")) {
            ipChange.ipc$dispatch("136599032", new Object[]{this, context});
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.height = q60.a(context, 16.0f);
        layoutParams.setMargins(q60.a(context, 1.0f), 0, 0, 0);
        TextView textView = new TextView(context);
        this.mTagView = textView;
        textView.setGravity(16);
        this.mTagView.setPadding(q60.a(context, 20.0f), 0, q60.a(context, 6.0f), 0);
        this.mTagView.setBackgroundResource(R$drawable.common_lr_tag_bg);
        this.mTagView.setTextColor(getContext().getResources().getColor(R$color.white));
        this.mTagView.setTextSize(1, 10.0f);
        addView(this.mTagView, layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.height = q60.a(context, 16.0f);
        DMLabelView dMLabelView = new DMLabelView(context);
        this.labelView = dMLabelView;
        dMLabelView.setLabelHeight(l62.a(getContext(), 16.0f));
        this.labelView.setPaddingLeft(q60.a(context, 5.0f));
        this.labelView.setPaddingRight(q60.a(context, 5.0f));
        this.labelView.setLabelType(DMLabelType.LABEL_TYPE_CUSTOM);
        setColor(1);
        addView(this.labelView, layoutParams2);
    }

    public DMLabelView getLabelView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1228223237") ? (DMLabelView) ipChange.ipc$dispatch("1228223237", new Object[]{this}) : this.labelView;
    }

    public DMLRLabelView setColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1955792040")) {
            return (DMLRLabelView) ipChange.ipc$dispatch("1955792040", new Object[]{this, Integer.valueOf(i)});
        }
        if (i == 1) {
            this.labelView.setBgColor("#F2C351", "#CE9712");
        } else if (i == 2) {
            this.labelView.setBgColor("#30AEFF", "#7A6EFF");
        }
        return this;
    }

    public DMLRLabelView setContent(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1175156011")) {
            return (DMLRLabelView) ipChange.ipc$dispatch("1175156011", new Object[]{this, str, str2});
        }
        if (TextUtils.isEmpty(str)) {
            setVisibility(8);
            return this;
        }
        setVisibility(0);
        this.labelView.setLabelName(str);
        if (TextUtils.isEmpty(str2)) {
            this.mTagView.setVisibility(8);
        } else {
            this.mTagView.setVisibility(0);
            this.mTagView.setText(str2);
        }
        return this;
    }

    public DMLRLabelView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(context);
    }

    public DMLRLabelView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView(context);
    }
}
