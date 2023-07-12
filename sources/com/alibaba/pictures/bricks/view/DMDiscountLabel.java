package com.alibaba.pictures.bricks.view;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class DMDiscountLabel extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private DMDigitTextView number;

    public DMDiscountLabel(@NonNull Context context) {
        this(context, null);
    }

    private void initView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2123181052")) {
            ipChange.ipc$dispatch("-2123181052", new Object[]{this, context});
            return;
        }
        LinearLayout.inflate(context, R$layout.bricks_dm_discount_label, this);
        this.number = (DMDigitTextView) findViewById(R$id.dm_discount_balel);
    }

    public void setDiscount(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "834453464")) {
            ipChange.ipc$dispatch("834453464", new Object[]{this, str});
        } else if (this.number != null && !TextUtils.isEmpty(str)) {
            if (str.contains(".")) {
                int indexOf = str.indexOf(".");
                int length = str.length();
                SpannableString spannableString = new SpannableString(str);
                spannableString.setSpan(new AbsoluteSizeSpan(12, true), indexOf, length, 33);
                this.number.setText(spannableString);
                return;
            }
            this.number.setText(str);
        } else {
            setVisibility(8);
        }
    }

    public DMDiscountLabel(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DMDiscountLabel(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView(context);
    }
}
