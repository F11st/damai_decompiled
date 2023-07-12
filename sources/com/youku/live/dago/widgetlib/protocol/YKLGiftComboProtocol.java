package com.youku.live.dago.widgetlib.protocol;

import android.view.View;
import com.youku.live.dago.widgetlib.interactive.gift.bean.GiftComboSendInfo;
import com.youku.live.dago.widgetlib.interactive.gift.view.RoundGiftButton;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface YKLGiftComboProtocol {
    View getView();

    void setCallback(RoundGiftButton.Listener listener);

    void setComboInterval(int i);

    void setCountdownTime(int i);

    void setGiftInfo(GiftComboSendInfo giftComboSendInfo);

    void setSize(float f, float f2);

    void start();
}
