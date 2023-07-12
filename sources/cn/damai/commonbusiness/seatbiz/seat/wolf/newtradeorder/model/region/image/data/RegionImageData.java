package cn.damai.commonbusiness.seatbiz.seat.wolf.newtradeorder.model.region.image.data;

import android.graphics.Bitmap;
import cn.damai.commonbusiness.seatbiz.view.model.BaseSVG;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class RegionImageData {
    private static transient /* synthetic */ IpChange $ipChange;
    public String failReason;
    private RegionImageStatus mLoadRegionImageStatus = RegionImageStatus.INIT;
    private BaseSVG mRainbowSVG;
    private Bitmap mRegionImageBitmap;
    private String mRegionImageUrl;
    private BaseSVG mRegionSVG;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public enum RegionImageStatus {
        INIT,
        SUCCESS,
        LOAD_FAILED,
        PARSE_FAILED,
        UN_KNOWN
    }

    public BaseSVG getRainbowSVG() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1508761662") ? (BaseSVG) ipChange.ipc$dispatch("-1508761662", new Object[]{this}) : this.mRainbowSVG;
    }

    public Bitmap getRegionImageBitmap() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1645884014") ? (Bitmap) ipChange.ipc$dispatch("1645884014", new Object[]{this}) : this.mRegionImageBitmap;
    }

    public RegionImageStatus getRegionImageStatus() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1538126378") ? (RegionImageStatus) ipChange.ipc$dispatch("-1538126378", new Object[]{this}) : this.mLoadRegionImageStatus;
    }

    public String getRegionImageUrl() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1300479004") ? (String) ipChange.ipc$dispatch("-1300479004", new Object[]{this}) : this.mRegionImageUrl;
    }

    public BaseSVG getRegionSVG() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "411705282") ? (BaseSVG) ipChange.ipc$dispatch("411705282", new Object[]{this}) : this.mRegionSVG;
    }

    public void setRainbowSVG(BaseSVG baseSVG) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1220764276")) {
            ipChange.ipc$dispatch("-1220764276", new Object[]{this, baseSVG});
        } else {
            this.mRainbowSVG = baseSVG;
        }
    }

    public void setRegionImageBitmap(Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1902133010")) {
            ipChange.ipc$dispatch("1902133010", new Object[]{this, bitmap});
        } else {
            this.mRegionImageBitmap = bitmap;
        }
    }

    public void setRegionImageStatus(RegionImageStatus regionImageStatus) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-953952672")) {
            ipChange.ipc$dispatch("-953952672", new Object[]{this, regionImageStatus});
        } else {
            this.mLoadRegionImageStatus = regionImageStatus;
        }
    }

    public void setRegionImageUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-777250182")) {
            ipChange.ipc$dispatch("-777250182", new Object[]{this, str});
        } else {
            this.mRegionImageUrl = str;
        }
    }

    public void setRegionSVG(BaseSVG baseSVG) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1951492572")) {
            ipChange.ipc$dispatch("-1951492572", new Object[]{this, baseSVG});
        } else {
            this.mRegionSVG = baseSVG;
        }
    }
}
