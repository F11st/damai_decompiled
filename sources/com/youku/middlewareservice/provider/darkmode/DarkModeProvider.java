package com.youku.middlewareservice.provider.darkmode;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public interface DarkModeProvider {
    String getDarkModeStatus();

    boolean isDarkMode();

    void onConfigureChanged();

    boolean showdDarkmodeSwitch();
}
