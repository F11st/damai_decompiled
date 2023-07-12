package com.alibaba.pictures.bricks.component.home.feed;

import com.alibaba.pictures.bricks.bean.VoteBean;
import com.alibaba.pictures.bricks.bean.VoteInfoBean;
import com.youku.arch.v3.view.IContract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public interface VoteContract extends IContract {

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface Model {
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface Present {
        void ut4CancelVoteClick(@Nullable VoteInfoBean voteInfoBean);

        void ut4VoteCardExposure(@Nullable android.view.View view, @Nullable VoteInfoBean voteInfoBean, int i);

        void ut4VoteClick(@Nullable VoteInfoBean voteInfoBean, @Nullable VoteBean voteBean, int i);
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface View {
        void bindView(@NotNull VoteInfoBean voteInfoBean);
    }
}
