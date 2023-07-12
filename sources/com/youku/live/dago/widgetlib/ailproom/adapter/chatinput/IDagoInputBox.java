package com.youku.live.dago.widgetlib.ailproom.adapter.chatinput;

import android.content.Context;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface IDagoInputBox {
    boolean canClose();

    void close();

    CharSequence getInputText();

    void initData(Context context, Map<String, Object> map);

    boolean isShowExpressionPanel();

    boolean isShowPanelContainer();

    void setOnInputBoxListener(OnInputBoxListener onInputBoxListener);

    void show();

    void updatePanelContainerHeight(int i);

    boolean useBarrage();
}
