package com.idlefish.flutterboost.containers;

import android.app.Activity;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public interface FlutterViewContainer {
    void detachFromEngineIfNeeded();

    void finishContainer(Map<String, Object> map);

    Activity getContextActivity();

    String getUniqueId();

    String getUrl();

    Map<String, Object> getUrlParams();

    boolean isOpaque();

    boolean isPausing();
}
