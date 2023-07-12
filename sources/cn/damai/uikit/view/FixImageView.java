package cn.damai.uikit.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class FixImageView extends AppCompatImageView {
    private static transient /* synthetic */ IpChange $ipChange;

    public FixImageView(Context context) {
        super(context);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-403013079")) {
            ipChange.ipc$dispatch("-403013079", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        Drawable drawable = getDrawable();
        if (drawable != null && drawable.getIntrinsicWidth() > 0 && mode == 1073741824 && size > 0) {
            setMeasuredDimension(size, (int) ((drawable.getIntrinsicHeight() * size) / drawable.getIntrinsicWidth()));
        } else {
            super.onMeasure(i, i2);
        }
    }

    public FixImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FixImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
