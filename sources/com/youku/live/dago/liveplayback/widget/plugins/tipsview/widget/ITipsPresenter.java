package com.youku.live.dago.liveplayback.widget.plugins.tipsview.widget;

import android.content.Context;
import android.view.View;
import com.youku.live.dago.liveplayback.widget.plugins.tipsview.BaseTipsUiConfig;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface ITipsPresenter<T extends BaseTipsUiConfig> {
    void ignoredByHighLevel(int i, String str);

    boolean onControlShowChange(int i, boolean z);

    View onCreateTipsView(Context context);

    boolean onScreenModeChanged(Integer num, boolean z);

    void onTipsDidHide();

    void onTipsDidShow();

    void setTipsUiConfig(T t);

    void setTipsView(ITipsContainerView iTipsContainerView);
}
