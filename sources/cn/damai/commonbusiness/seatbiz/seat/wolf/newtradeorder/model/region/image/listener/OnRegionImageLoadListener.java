package cn.damai.commonbusiness.seatbiz.seat.wolf.newtradeorder.model.region.image.listener;

import cn.damai.commonbusiness.seatbiz.seat.wolf.newtradeorder.model.region.image.data.RegionImageData;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface OnRegionImageLoadListener {
    void onLoadRegionImageFailed(RegionImageData regionImageData);

    void onLoadRegionImageSuccess(RegionImageData regionImageData);
}
