package cn.damai.seat.listener;

import androidx.annotation.Nullable;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.TicketMainUiModel;
import cn.damai.seat.bean.PriceBarInfo;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public interface OnPriceBarListener {
    void onPriceBarV2InfoChanged(PriceBarInfo priceBarInfo, @Nullable List<TicketMainUiModel> list);
}
