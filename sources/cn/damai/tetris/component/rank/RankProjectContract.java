package cn.damai.tetris.component.rank;

import cn.damai.commonbusiness.search.bean.FollowDataBean;
import cn.damai.tetris.component.rank.bean.RankItemBean;
import cn.damai.tetris.core.BaseNode;
import cn.damai.tetris.core.IModel;
import cn.damai.tetris.core.IPresenter;
import cn.damai.tetris.core.IView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public interface RankProjectContract {

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface Model<D extends BaseNode> extends IModel<D> {
        @Nullable
        RankItemBean getBean();
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface Presenter<M extends RankProjectModel, V extends RankProjectView, N extends BaseNode> extends IPresenter<M, V, N> {
        void itemClick(@Nullable RankProjectView rankProjectView, @Nullable RankItemBean rankItemBean, int i);

        void wantSeeClick(@Nullable RankProjectView rankProjectView, @Nullable RankItemBean rankItemBean, int i, @NotNull FollowDataBean followDataBean);
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface View<P extends RankProjectPresenter> extends IView<P> {
        void setData(@Nullable RankItemBean rankItemBean, int i);

        void updateFollowState(@Nullable FollowDataBean followDataBean);
    }
}
