package tb;

import androidx.annotation.NonNull;
import cn.damai.commonbusiness.seatbiz.view.svgview.core.helper.parser.model.Shape;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class j50 extends g52 {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // tb.g52
    @NonNull
    public void d(@NonNull int[] iArr, @NonNull Shape shape) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1091290702")) {
            ipChange.ipc$dispatch("-1091290702", new Object[]{this, iArr, shape});
        } else {
            e(shape);
        }
    }
}
