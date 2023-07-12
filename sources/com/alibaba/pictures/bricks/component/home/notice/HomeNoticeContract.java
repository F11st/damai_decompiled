package com.alibaba.pictures.bricks.component.home.notice;

import com.alibaba.pictures.bricks.bean.HomeNoticeBean;
import com.youku.arch.v3.view.IContract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public interface HomeNoticeContract extends IContract {

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface Model {
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface Present {
        void expose(@NotNull HomeNoticeBean homeNoticeBean);

        void onClick(@NotNull HomeNoticeBean homeNoticeBean);
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface View {
        void bindView(@NotNull HomeNoticeBean homeNoticeBean, @Nullable String str);
    }
}
