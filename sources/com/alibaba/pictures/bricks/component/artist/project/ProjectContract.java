package com.alibaba.pictures.bricks.component.artist.project;

import com.youku.arch.v3.view.IContract;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class ProjectContract implements IContract {

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface Model {
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface Presenter {
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface View {
        void renderBackground(boolean z);

        void renderCityName(@Nullable String str);

        void renderPoster(@Nullable String str);

        void renderPrice(@Nullable String str);

        void renderShowTime(@Nullable String str);

        void renderTitle(@Nullable String str);

        void renderVenueName(@Nullable String str);
    }
}
