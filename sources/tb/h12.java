package tb;

import android.graphics.RectF;
import cn.damai.commonbusiness.seatbiz.view.svgview.core.model.PointLocation;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class h12 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static RectF a(List<PointLocation> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1167182301")) {
            return (RectF) ipChange.ipc$dispatch("-1167182301", new Object[]{list});
        }
        if (cb2.d(list) || list.size() < 2) {
            return null;
        }
        RectF rectF = new RectF();
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        for (int i = 0; i < list.size(); i++) {
            PointLocation pointLocation = list.get(i);
            float f5 = pointLocation.y;
            float f6 = pointLocation.x;
            if (i == 0) {
                f = f6;
                f3 = f;
                f2 = f5;
                f4 = f2;
            } else {
                f2 = Math.min(f2, f5);
                f4 = Math.max(f4, f5);
                f = Math.min(f, f6);
                f3 = Math.max(f3, f6);
            }
        }
        rectF.set(f, f2, f3, f4);
        return rectF;
    }
}
