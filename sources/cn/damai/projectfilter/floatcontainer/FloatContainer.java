package cn.damai.projectfilter.floatcontainer;

import androidx.annotation.Nullable;
import cn.damai.projectfilter.filterbtn.FilterBtn;
import cn.damai.projectfilter.floatview.FloatLayer;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public interface FloatContainer {
    @Nullable
    FilterBtn getShowAnchor();

    void hide();

    boolean isShowing();

    void show(FilterBtn filterBtn, FloatLayer floatLayer, int i);
}
