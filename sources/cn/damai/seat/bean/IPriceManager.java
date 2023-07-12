package cn.damai.seat.bean;

import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.PriceLevel;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.PriceLine;
import cn.damai.seat.bean.biz.Price;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public interface IPriceManager {
    @Nullable
    PriceLevel findSalablePackagePriceLevel(long j);

    @Nullable
    PriceLine findSalablePriceLine(long j);

    @Nullable
    Price firstPriceLevel();

    long getBuySkuId(long j);

    List<Price> getFullPriceList();

    LongSparseArray<PriceLine> getPid2PriceLineMap();
}
