package com.alibaba.pictures.component.artist;

import cn.damai.player.video.ProxyVideoView;
import com.alibaba.pictures.bean.ArtistHeadBean;
import com.alibaba.pictures.bricks.view.FollowView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public interface ArtistHeaderContract {

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
        void bind(@Nullable ArtistHeadBean artistHeadBean, @NotNull ArtistUserAction artistUserAction);

        @NotNull
        android.view.View getFansView();

        @NotNull
        FollowView getFollowView();

        @Nullable
        ProxyVideoView getVideoView();
    }
}
