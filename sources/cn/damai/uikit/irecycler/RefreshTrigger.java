package cn.damai.uikit.irecycler;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public interface RefreshTrigger {
    void onComplete();

    void onMove(boolean z, boolean z2, int i);

    void onRefresh();

    void onRelease();

    void onReset();

    void onStart(boolean z, int i, int i2);
}
