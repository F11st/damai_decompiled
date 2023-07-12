package com.alibaba.pictures.bricks.component.home.feed;

import com.alibaba.pictures.bricks.bean.CircleCard;
import com.youku.arch.v3.view.IContract;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public interface CircleGroupContract extends IContract {

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface Model {
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface Present {
        void onClick();
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface View {
        void bindView(@NotNull CircleCard circleCard);
    }
}
