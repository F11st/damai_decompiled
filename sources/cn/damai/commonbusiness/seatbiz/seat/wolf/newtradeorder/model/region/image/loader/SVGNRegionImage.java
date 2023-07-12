package cn.damai.commonbusiness.seatbiz.seat.wolf.newtradeorder.model.region.image.loader;

import android.text.TextUtils;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.ImageData;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.RequestListener;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.SVGRequest;
import cn.damai.commonbusiness.seatbiz.seat.wolf.newtradeorder.model.region.image.data.RegionImageData;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.j52;
import tb.kn1;
import tb.l11;
import tb.r11;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class SVGNRegionImage implements IRegionImage, RequestListener<ImageData, l11> {
    private static transient /* synthetic */ IpChange $ipChange;
    private j52 assist;
    private boolean isRainBowUrl;
    private IRegionImageCallback listener;
    private SVGRequest mRequest;
    private String url;

    public SVGNRegionImage(IRegionImageCallback iRegionImageCallback, j52 j52Var, boolean z) {
        this.listener = iRegionImageCallback;
        this.assist = j52Var;
        this.isRainBowUrl = z;
    }

    public void cancel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1989288779")) {
            ipChange.ipc$dispatch("1989288779", new Object[]{this});
            return;
        }
        try {
            SVGRequest sVGRequest = this.mRequest;
            if (sVGRequest != null) {
                sVGRequest.a();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getUrl() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-674012428") ? (String) ipChange.ipc$dispatch("-674012428", new Object[]{this}) : this.url;
    }

    @Override // cn.damai.commonbusiness.seatbiz.seat.wolf.newtradeorder.model.region.image.loader.IRegionImage
    public void loadRegionImage(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "304812046")) {
            ipChange.ipc$dispatch("304812046", new Object[]{this, str});
            return;
        }
        this.url = str;
        j52 j52Var = this.assist;
        boolean z = this.isRainBowUrl;
        if (z) {
            j52Var = null;
        }
        SVGRequest sVGRequest = new SVGRequest(new r11(false, str, -1L, true, z, j52Var));
        this.mRequest = sVGRequest;
        sVGRequest.d(this);
    }

    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.RequestListener
    public void onFail(kn1<l11> kn1Var, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-281806460")) {
            ipChange.ipc$dispatch("-281806460", new Object[]{this, kn1Var, str, str2});
        } else if (this.listener != null) {
            RegionImageData.RegionImageStatus regionImageStatus = RegionImageData.RegionImageStatus.LOAD_FAILED;
            if (TextUtils.equals(str, ImageData.CODE_SVG_BUILD_FAIL)) {
                regionImageStatus = RegionImageData.RegionImageStatus.PARSE_FAILED;
            }
            RegionImageData regionImageData = new RegionImageData();
            regionImageData.setRegionImageUrl(kn1Var.d());
            regionImageData.setRegionImageStatus(regionImageStatus);
            regionImageData.failReason = "svg:" + str2;
            this.listener.onLoadRegionImageFailed(regionImageData);
        }
    }

    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.RequestListener
    public void onSuccess(kn1<l11> kn1Var, ImageData imageData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-812422482")) {
            ipChange.ipc$dispatch("-812422482", new Object[]{this, kn1Var, imageData});
        } else if (this.listener != null) {
            RegionImageData regionImageData = new RegionImageData();
            regionImageData.setRegionImageUrl(kn1Var.d());
            regionImageData.setRegionImageStatus(RegionImageData.RegionImageStatus.SUCCESS);
            regionImageData.setRegionSVG(imageData.getSVG());
            this.listener.onLoadRegionImageSuccess(regionImageData);
        }
    }
}
