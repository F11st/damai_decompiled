package com.alibaba.pictures.bricks.component.home;

import com.alibaba.pictures.bricks.bean.HomeProjectItemBean;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public interface HomeProjectItemContract {

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface Model {
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface Present {
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface View {
        void bindView(@NotNull HomeProjectItemBean homeProjectItemBean);

        void updateWantSeeBtn(boolean z);
    }
}
