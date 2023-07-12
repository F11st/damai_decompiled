package cn.damai.search.ui.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.ViewFlipper;
import cn.damai.homepage.R$styleable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class TextBannerView extends ViewFlipper {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<String> mDatas;
    private int mTextColor;
    private int mTextSize;

    public TextBannerView(Context context) {
        this(context, null);
    }

    private void init(Context context, AttributeSet attributeSet, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-422412528")) {
            ipChange.ipc$dispatch("-422412528", new Object[]{this, context, attributeSet, Integer.valueOf(i)});
        } else if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.TextBannerViewStyle, i, i);
            this.mTextColor = obtainStyledAttributes.getColor(R$styleable.TextBannerViewStyle_tbv_textColor, this.mTextColor);
            int i2 = R$styleable.TextBannerViewStyle_tbv_textSize;
            if (obtainStyledAttributes.hasValue(i2)) {
                this.mTextSize = obtainStyledAttributes.getInteger(i2, this.mTextSize);
            }
            obtainStyledAttributes.recycle();
        }
    }

    private void setTextView(TextView textView, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "860038872")) {
            ipChange.ipc$dispatch("860038872", new Object[]{this, textView, Integer.valueOf(i)});
            return;
        }
        textView.setText(this.mDatas.get(i));
        textView.setSingleLine(true);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setTextColor(this.mTextColor);
        textView.setTextSize(1, this.mTextSize);
    }

    public void setDatas(List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2001498265")) {
            ipChange.ipc$dispatch("-2001498265", new Object[]{this, list});
            return;
        }
        this.mDatas = list;
        if (list == null || list.size() <= 0) {
            return;
        }
        removeAllViews();
        for (int i = 0; i < this.mDatas.size(); i++) {
            TextView textView = new TextView(getContext());
            setTextView(textView, i);
            addView(textView, i);
        }
    }

    public TextBannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTextColor = -16777216;
        this.mTextSize = 12;
        init(context, attributeSet, 0);
    }
}
