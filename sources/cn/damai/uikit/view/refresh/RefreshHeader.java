package cn.damai.uikit.view.refresh;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public interface RefreshHeader {
    void complete();

    void onPositionChange(float f, float f2, float f3, boolean z, State state);

    void pull();

    void refreshing();

    void reset();
}
