package cn.damai.uikit.flowlayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class SameHeightFlowLayout extends FlowLayout {
    private static transient /* synthetic */ IpChange $ipChange;

    public SameHeightFlowLayout(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.uikit.flowlayout.FlowLayout, android.view.View
    public void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-296571294")) {
            ipChange.ipc$dispatch("-296571294", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        super.onMeasure(i, i2);
        for (int i3 = 0; i3 < this.lines.size(); i3++) {
            List<View> j = this.lines.get(i3).j();
            int i4 = 0;
            for (int i5 = 0; i5 < j.size(); i5++) {
                if (i4 < j.get(i5).getMeasuredHeight()) {
                    i4 = j.get(i5).getMeasuredHeight();
                }
            }
            for (int i6 = 0; i6 < j.size(); i6++) {
                j.get(i6).getLayoutParams().height = i4;
            }
        }
        super.onMeasure(i, i2);
    }

    public SameHeightFlowLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SameHeightFlowLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
