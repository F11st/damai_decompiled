package com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago;

import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model.DagoCell;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface IDagoChatListView {
    void add(DagoCell dagoCell);

    void clear();

    void setFontSize(int i);

    void setGroupName(String str);

    void setLimitSize(String str);

    void setNewMsgTipStyle(String str, String str2, String str3, String str4, String str5);

    void setOnCellClickListener(OnCellClickListener onCellClickListener);

    void updateLast(DagoCell dagoCell);
}
