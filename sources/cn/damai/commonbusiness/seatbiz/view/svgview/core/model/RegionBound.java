package cn.damai.commonbusiness.seatbiz.view.svgview.core.model;

import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.cb2;
import tb.mz1;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class RegionBound {
    private static transient /* synthetic */ IpChange $ipChange;
    public Path pathBounds;
    public List<PointLocation> pointBounds;
    public String regionVid;
    private RectF temp;

    public RegionBound(String str, List<PointLocation> list) {
        this.regionVid = str;
        this.pointBounds = list;
    }

    private boolean checkPoint(float f, float f2) {
        float f3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1604308333")) {
            return ((Boolean) ipChange.ipc$dispatch("-1604308333", new Object[]{this, Float.valueOf(f), Float.valueOf(f2)})).booleanValue();
        }
        if (cb2.d(this.pointBounds)) {
            return false;
        }
        int size = this.pointBounds.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            PointLocation pointLocation = this.pointBounds.get(i);
            int i3 = i + 1;
            PointLocation pointLocation2 = this.pointBounds.get(i3 % size);
            float f4 = pointLocation.x;
            float f5 = pointLocation.y;
            float f6 = pointLocation2.x;
            float f7 = pointLocation2.y;
            if (this.pointBounds.size() != 2) {
                f3 = f7;
            } else if (mz1.a(f, f2, f4, f5, f6, f7)) {
                return true;
            } else {
                f3 = f7;
            }
            if (f5 != f3 && f2 >= Math.min(f5, f3) && f2 < Math.max(f5, f3) && (((f2 - f5) * (f6 - f4)) / (f3 - f5)) + f4 > f) {
                i2++;
            }
            i = i3;
        }
        return i2 % 2 == 1;
    }

    public boolean isPoint(float f, float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "150029809")) {
            return ((Boolean) ipChange.ipc$dispatch("150029809", new Object[]{this, Float.valueOf(f), Float.valueOf(f2)})).booleanValue();
        }
        if (this.pathBounds != null) {
            if (this.temp == null) {
                this.temp = new RectF();
            }
            Region region = new Region();
            this.pathBounds.computeBounds(this.temp, true);
            Path path = this.pathBounds;
            RectF rectF = this.temp;
            region.setPath(path, new Region((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom));
            return region.contains((int) f, (int) f2);
        }
        return checkPoint(f, f2);
    }

    public RegionBound(String str, Path path, List<PointLocation> list) {
        this.regionVid = str;
        this.pointBounds = list;
        this.pathBounds = path;
    }
}
