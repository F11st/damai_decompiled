package cn.damai.commonbusiness.seatbiz.seat.wolf.newtradeorder.model.region.image.loader;

import cn.damai.commonbusiness.seatbiz.seat.wolf.newtradeorder.model.region.image.data.RegionImageData;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface IRegionImageCallback {
    void onLoadRegionImageFailed(RegionImageData regionImageData);

    void onLoadRegionImageSuccess(RegionImageData regionImageData);
}
