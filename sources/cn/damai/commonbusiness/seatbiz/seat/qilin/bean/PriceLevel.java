package cn.damai.commonbusiness.seatbiz.seat.qilin.bean;

import androidx.annotation.Nullable;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.SubPrice;
import java.util.HashSet;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface PriceLevel extends PriceLine {
    @Nullable
    String getDiscountTip();

    int getPriceType();

    String getShowPriceText();

    long getSkuId();

    HashSet<Long> getSubPriceIds();

    List<SubPrice> getSubPriceList();

    @Nullable
    String getTagDesc(String str);

    boolean isFreeCombineTiaoPiao();

    boolean isSalable();

    boolean isSinglePrice();

    boolean isTaoPiao();

    float skuPriceValue();
}
