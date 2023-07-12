package cn.damai.commonbusiness.seatbiz.seat.wolf.newtradeorder.model.region.image.loader;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import cn.damai.common.image.C0504a;
import cn.damai.common.image.DMImageCreator;
import cn.damai.commonbusiness.seatbiz.seat.wolf.newtradeorder.model.region.image.RegionImageLoader;
import cn.damai.commonbusiness.seatbiz.seat.wolf.newtradeorder.model.region.image.data.RegionImageData;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class JPGRegionImage implements IRegionImage {
    private static transient /* synthetic */ IpChange $ipChange;
    private IRegionImageCallback mRegionImageCallback;
    private RegionImageLoader mRegionImageLoader;

    public JPGRegionImage(RegionImageLoader regionImageLoader, IRegionImageCallback iRegionImageCallback) {
        this.mRegionImageLoader = regionImageLoader;
        this.mRegionImageCallback = iRegionImageCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLoadRegionImageFailed(String str, RegionImageData.RegionImageStatus regionImageStatus, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1440754178")) {
            ipChange.ipc$dispatch("-1440754178", new Object[]{this, str, regionImageStatus, str2});
            return;
        }
        RegionImageData regionImageData = new RegionImageData();
        regionImageData.setRegionImageUrl(str);
        regionImageData.setRegionImageStatus(regionImageStatus);
        regionImageData.failReason = "jpg:" + str2;
        this.mRegionImageCallback.onLoadRegionImageFailed(regionImageData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLoadRegionImageSuccess(String str, Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-708166955")) {
            ipChange.ipc$dispatch("-708166955", new Object[]{this, str, bitmap});
            return;
        }
        RegionImageData regionImageData = new RegionImageData();
        regionImageData.setRegionImageUrl(str);
        regionImageData.setRegionImageStatus(RegionImageData.RegionImageStatus.SUCCESS);
        regionImageData.setRegionImageBitmap(bitmap);
        this.mRegionImageCallback.onLoadRegionImageSuccess(regionImageData);
    }

    @Override // cn.damai.commonbusiness.seatbiz.seat.wolf.newtradeorder.model.region.image.loader.IRegionImage
    public void loadRegionImage(final String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-502472733")) {
            ipChange.ipc$dispatch("-502472733", new Object[]{this, str});
        } else if (this.mRegionImageCallback == null) {
        } else {
            if (TextUtils.isEmpty(str)) {
                onLoadRegionImageFailed(str, RegionImageData.RegionImageStatus.LOAD_FAILED, "imgUrl=null");
            } else {
                C0504a.b().c(str).n(new DMImageCreator.DMImageSuccListener() { // from class: cn.damai.commonbusiness.seatbiz.seat.wolf.newtradeorder.model.region.image.loader.JPGRegionImage.2
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
                    public void onSuccess(DMImageCreator.C0502e c0502e) {
                        Drawable drawable;
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "-1266887595")) {
                            ipChange2.ipc$dispatch("-1266887595", new Object[]{this, c0502e});
                        } else if (c0502e == null || (drawable = c0502e.a) == null) {
                            JPGRegionImage.this.onLoadRegionImageFailed(str, RegionImageData.RegionImageStatus.LOAD_FAILED, "ImageLoader_getDrawable_failed");
                        } else {
                            try {
                                JPGRegionImage.this.onLoadRegionImageSuccess(str, ((BitmapDrawable) drawable).getBitmap());
                            } catch (Exception e) {
                                e.printStackTrace();
                                JPGRegionImage.this.onLoadRegionImageFailed(str, RegionImageData.RegionImageStatus.LOAD_FAILED, e.getMessage());
                            }
                        }
                    }
                }).e(new DMImageCreator.DMImageFailListener() { // from class: cn.damai.commonbusiness.seatbiz.seat.wolf.newtradeorder.model.region.image.loader.JPGRegionImage.1
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
                    public void onFail(DMImageCreator.C0501d c0501d) {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "-2039876928")) {
                            ipChange2.ipc$dispatch("-2039876928", new Object[]{this, c0501d});
                            return;
                        }
                        String str2 = "ImageLoader_download_fail";
                        if (c0501d != null) {
                            str2 = "ImageLoader_download_failresultCode=" + c0501d.a;
                        }
                        JPGRegionImage.this.onLoadRegionImageFailed(str, RegionImageData.RegionImageStatus.LOAD_FAILED, str2);
                    }
                }).f();
            }
        }
    }
}
