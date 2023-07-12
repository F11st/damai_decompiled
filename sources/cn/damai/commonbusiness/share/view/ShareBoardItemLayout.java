package cn.damai.commonbusiness.share.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.t60;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class ShareBoardItemLayout extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private int width;

    public ShareBoardItemLayout(Context context) {
        super(context);
        initWidth(context);
    }

    private void initWidth(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-854386458")) {
            ipChange.ipc$dispatch("-854386458", new Object[]{this, context});
        } else {
            this.width = (DisplayMetrics.getwidthPixels(t60.b(context)) - t60.a(context, 42.0f)) / 5;
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1458610873")) {
            ipChange.ipc$dispatch("1458610873", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        int i3 = this.width;
        if (i3 > 0) {
            i = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    public ShareBoardItemLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        initWidth(context);
    }

    public ShareBoardItemLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initWidth(context);
    }
}
