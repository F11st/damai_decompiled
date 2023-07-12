package com.youku.live.dago.widgetlib.ailproom.protocol;

import android.view.View;
import com.youku.live.widgets.protocol.IDestroyable;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface AILPLikeViewProtocol extends IDestroyable {
    @Override // com.youku.live.widgets.protocol.IDestroyable
    void destroy();

    View getView();

    void setFlow(int i);

    void setlikeViewSrc(Map map);
}
