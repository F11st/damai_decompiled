package cn.damai.seat.bean;

import android.graphics.Bitmap;
import cn.damai.commonbusiness.seatbiz.view.model.BaseSVG;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class VenueImage {
    private static transient /* synthetic */ IpChange $ipChange;
    private Bitmap jpg;
    private BaseSVG rainBowSvg;
    private BaseSVG regionSvg;

    public Bitmap getJpg() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-639924372") ? (Bitmap) ipChange.ipc$dispatch("-639924372", new Object[]{this}) : this.jpg;
    }

    public BaseSVG getRainBowSvg() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1158259509") ? (BaseSVG) ipChange.ipc$dispatch("-1158259509", new Object[]{this}) : this.rainBowSvg;
    }

    public BaseSVG getRegionSvg() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1893089863") ? (BaseSVG) ipChange.ipc$dispatch("-1893089863", new Object[]{this}) : this.regionSvg;
    }

    public void setJpg(Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "432481492")) {
            ipChange.ipc$dispatch("432481492", new Object[]{this, bitmap});
        } else {
            this.jpg = bitmap;
        }
    }

    public void setRainBowSvg(BaseSVG baseSVG) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1054867875")) {
            ipChange.ipc$dispatch("1054867875", new Object[]{this, baseSVG});
        } else {
            this.rainBowSvg = baseSVG;
        }
    }

    public void setRegionSvg(BaseSVG baseSVG) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-385698035")) {
            ipChange.ipc$dispatch("-385698035", new Object[]{this, baseSVG});
        } else {
            this.regionSvg = baseSVG;
        }
    }
}
