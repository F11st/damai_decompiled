package com.youku.live.dago.widgetlib.ailproom.protocol;

import android.content.Context;
import com.youku.live.dago.widgetlib.ailproom.callback.AILPScreenCallback;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface AILPScreenProtocol {
    void init(Context context);

    void onDestroy();

    boolean setFullScreen(boolean z);

    boolean setOrientation(String str);

    void setScreenCallback(AILPScreenCallback aILPScreenCallback);
}
