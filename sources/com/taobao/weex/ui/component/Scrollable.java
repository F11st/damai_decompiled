package com.taobao.weex.ui.component;

import android.view.ViewGroup;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface Scrollable {
    void bindAppearEvent(WXComponent wXComponent);

    void bindDisappearEvent(WXComponent wXComponent);

    void bindStickStyle(WXComponent wXComponent);

    int getOrientation();

    String getRef();

    int getScrollX();

    int getScrollY();

    ViewGroup getView();

    boolean isScrollable();

    void scrollTo(WXComponent wXComponent, Map<String, Object> map);

    void unbindAppearEvent(WXComponent wXComponent);

    void unbindDisappearEvent(WXComponent wXComponent);

    void unbindStickStyle(WXComponent wXComponent);
}
