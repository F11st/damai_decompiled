package cn.damai.homepage.util.window;

import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public interface PopupCallback {
    void cityChangeRefresh();

    void evaluateOnUserReject(@NotNull String str);

    boolean isHomePageTab();

    void loadFloat();

    void showLottie();
}
