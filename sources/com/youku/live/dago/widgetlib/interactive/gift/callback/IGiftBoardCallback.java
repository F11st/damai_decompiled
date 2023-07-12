package com.youku.live.dago.widgetlib.interactive.gift.callback;

import com.youku.live.dago.widgetlib.interactive.gift.bean.GiftInfoBean;
import com.youku.live.dago.widgetlib.interactive.gift.bean.GiftPropBean;
import com.youku.live.dago.widgetlib.interactive.gift.bean.GiftTargetInfoBean;
import com.youku.live.dago.widgetlib.interactive.gift.view.GestureGiftWindow;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface IGiftBoardCallback {
    void clickLink(String str);

    void close(Map<String, Object> map);

    void morePropBtnClick();

    void onDoMission(GiftPropBean giftPropBean);

    void onGestureBoardAppear();

    void onGestureBoardDisappear();

    void onRecharge();

    void onSendGestureGift(int i, int i2, List<GestureGiftWindow.Coord> list, long j, List<GiftTargetInfoBean> list2);

    void onSendGift(long j, GiftInfoBean giftInfoBean, List<GiftTargetInfoBean> list);

    void onSendProp(long j, GiftPropBean giftPropBean, List<GiftTargetInfoBean> list);

    void openExchangeBroad();

    void openUserCard(String str);

    void refresh(boolean z);

    void switchToProp(boolean z);
}
