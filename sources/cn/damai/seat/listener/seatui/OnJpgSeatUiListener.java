package cn.damai.seat.listener.seatui;

import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.PriceLevel;
import cn.damai.seat.bean.SeatProfile;
import tb.g92;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public interface OnJpgSeatUiListener extends ApiType {
    void onSelectSeatChanged();

    void showSeatUi(SeatProfile seatProfile, g92 g92Var, PriceLevel priceLevel, boolean z);
}
