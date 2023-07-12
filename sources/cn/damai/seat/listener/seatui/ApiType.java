package cn.damai.seat.listener.seatui;

import androidx.annotation.StringRes;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.PriceLevel;
import cn.damai.seat.bean.HeadBean;
import java.util.List;
import tb.g92;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public interface ApiType {
    public static final int API_DYNAMIC = 444;
    public static final int API_IMAGE = 111;
    public static final int API_SEAT = 222;
    public static final int API_SEAT_STATE = 333;

    void onFail(int i, String str, String str2, String str3);

    void showHeadView(HeadBean headBean);

    void showPriceList(List<? extends PriceLevel> list, PriceLevel priceLevel, g92 g92Var);

    void toast(@StringRes int i);
}
