package com.alibaba.pictures.bricks.component.home.calendar;

import com.alibaba.pictures.bricks.bean.HomeCalendarBean;
import com.youku.arch.v3.view.IContract;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public interface HomeCalendarContract extends IContract {

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface Model {
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface Present {
        void expose(@NotNull HomeCalendarBean homeCalendarBean);

        void onClick(@NotNull HomeCalendarBean homeCalendarBean);
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface View {
        void bindView(@NotNull HomeCalendarBean homeCalendarBean);

        void changeScreenMode(boolean z);
    }
}
