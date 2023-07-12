package cn.damai.seat.listener.seatui;

import android.graphics.Bitmap;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.Region;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.PriceLevel;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public interface OnJpgRegionUiListener extends ApiType {
    void showRegionUi(Bitmap bitmap, List<Region> list, PriceLevel priceLevel, boolean z);
}
