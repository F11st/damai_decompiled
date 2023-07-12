package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.autofittext;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import cn.damai.trade.R$styleable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.WeakHashMap;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class AutoFitLayout extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean mEnabled;
    private WeakHashMap<View, AutoFitHelper> mHelpers;
    private float mMinTextSize;
    private float mPrecision;

    public AutoFitLayout(Context context) {
        super(context);
        this.mHelpers = new WeakHashMap<>();
        init(context, null, 0);
    }

    private void init(Context context, AttributeSet attributeSet, int i) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-569584454")) {
            ipChange.ipc$dispatch("-569584454", new Object[]{this, context, attributeSet, Integer.valueOf(i)});
            return;
        }
        int i2 = -1;
        float f = -1.0f;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.AutoFitTextView, i, 0);
            z = obtainStyledAttributes.getBoolean(R$styleable.AutoFitTextView_sizeToFit, true);
            i2 = obtainStyledAttributes.getDimensionPixelSize(R$styleable.AutoFitTextView_minTextSize, -1);
            f = obtainStyledAttributes.getFloat(R$styleable.AutoFitTextView_precision, -1.0f);
            obtainStyledAttributes.recycle();
        }
        this.mEnabled = z;
        this.mMinTextSize = i2;
        this.mPrecision = f;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "488663835")) {
            ipChange.ipc$dispatch("488663835", new Object[]{this, view, Integer.valueOf(i), layoutParams});
            return;
        }
        super.addView(view, i, layoutParams);
        TextView textView = (TextView) view;
        AutoFitHelper o = AutoFitHelper.e(textView).o(this.mEnabled);
        float f = this.mPrecision;
        if (f > 0.0f) {
            o.t(f);
        }
        float f2 = this.mMinTextSize;
        if (f2 > 0.0f) {
            o.s(0, f2);
        }
        this.mHelpers.put(textView, o);
    }

    public AutoFitHelper getAutofitHelper(TextView textView) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2063596290") ? (AutoFitHelper) ipChange.ipc$dispatch("2063596290", new Object[]{this, textView}) : this.mHelpers.get(textView);
    }

    public AutoFitHelper getAutofitHelper(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2030961921") ? (AutoFitHelper) ipChange.ipc$dispatch("2030961921", new Object[]{this, Integer.valueOf(i)}) : this.mHelpers.get(getChildAt(i));
    }

    public AutoFitLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHelpers = new WeakHashMap<>();
        init(context, attributeSet, 0);
    }

    public AutoFitLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHelpers = new WeakHashMap<>();
        init(context, attributeSet, i);
    }
}
