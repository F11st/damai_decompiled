package cn.damai.commonbusiness.scriptmurder;

import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public interface INavStatusBarFeature {
    void onHeaderInfoUpdate(@NotNull Object obj);

    void setDarkStatusBarFontColor();

    void setLightStatusBarFontColor();

    void setNavBarColor(int i);

    void setNavBarTitle(@NotNull String str);
}
