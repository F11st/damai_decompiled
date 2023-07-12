package com.youku.live.dago.widgetlib.ailproom.protocol;

import android.view.View;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.ailp.OnCellClickListener;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface AILPChatListProtocol {
    public static final String NICK = "nick";
    public static final String RICH = "rich";
    public static final String TEXT = "text";

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface INewMsgTipStyle {
        int getTipBgColor();

        int getTipBorderColor();

        int getTipTextColor();
    }

    void clearMessage();

    View getView();

    void insert(Map<String, Object> map);

    void mergeLastMessage(Map<String, Object> map);

    void setLimitSize(String str);

    void setMaskLayer(String str, String str2);

    void setMessageDelay(String str);

    void setNewMsgTipStyle(INewMsgTipStyle iNewMsgTipStyle);

    void setOnCellClickListener(OnCellClickListener onCellClickListener);
}
