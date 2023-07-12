package com.youku.live.dago.widgetlib.protocol;

import android.view.View;
import com.youku.live.dago.widgetlib.interactive.gift.bean.GiftLinkInfoBean;
import com.youku.live.dago.widgetlib.interactive.gift.bean.GiftPropBean;
import com.youku.live.dago.widgetlib.interactive.gift.callback.IGiftBoardCallback;
import com.youku.live.dago.widgetlib.interactive.gift.config.GiftTheme;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface YKLGiftBoardProtocol {
    void addPropItem(int i, GiftPropBean giftPropBean);

    void changeToGiftTab(int i);

    void close();

    void deletePropItem(String str);

    View getView();

    void notifyGiftDataChange();

    void notifyLinkDataChange(List<GiftLinkInfoBean> list);

    void notifyPropDataChange();

    void notifyTargetChange();

    void open();

    void openMultiSendMode(boolean z);

    void setCallback(IGiftBoardCallback iGiftBoardCallback);

    void setCoinIcon(String str);

    void setCoins(String str);

    void setCountdownTime(String str);

    void setFirstRecharge(boolean z);

    void setGiftTrackXY(Map<String, String> map);

    void setHasPack(boolean z);

    void setHasPackTip(boolean z);

    void setLandscape(boolean z);

    void setMultipleText(String str);

    void setPackTabName(String str);

    void setRoomId(String str);

    void setRowNum(String str);

    void setSelectGid(String str);

    void setSelectNum(int i);

    void setSelectPid(String str);

    void setSelectTid(String str);

    void setShowPack(boolean z);

    void setShowTargetDetails(boolean z);

    void setSpm(Map<String, Object> map);

    void setStarGift(boolean z);

    void switchVirtualCoinsExchange(boolean z, String str, String str2);

    void updatePropItem(GiftPropBean giftPropBean);

    void updateTheme(GiftTheme giftTheme);
}
