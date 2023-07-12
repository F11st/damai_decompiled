package cn.damai.seat.bean;

import cn.damai.seat.bean.biz.ItemSku;
import cn.damai.seat.bean.biz.SeatDynamic;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class HeadBean implements Serializable {
    private static final long serialVersionUID = 1432;
    public boolean isMultiplePerform;
    public boolean isShowPromotion;
    public String itemTitle;
    public String performName;

    @Deprecated
    public HeadBean(String str, String str2, boolean z, boolean z2) {
        this.itemTitle = str;
        this.performName = str2;
        this.isShowPromotion = z;
        this.isMultiplePerform = z2;
    }

    public HeadBean(SeatDynamic seatDynamic, boolean z) {
        ItemSku itemSku;
        if (seatDynamic != null && (itemSku = seatDynamic.performBasicInfo) != null) {
            this.itemTitle = itemSku.itemTitle;
            this.performName = itemSku.performName;
            this.isShowPromotion = seatDynamic.showPromotion();
        }
        this.isMultiplePerform = z;
    }
}
