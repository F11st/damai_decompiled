package cn.damai.tetris.component.rank;

import cn.damai.tetris.component.rank.bean.RankSelectBean;
import cn.damai.tetris.component.rank.bean.RankSelectItemBean;
import cn.damai.tetris.core.BaseNode;
import cn.damai.tetris.core.IModel;
import cn.damai.tetris.core.IPresenter;
import cn.damai.tetris.core.IView;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public interface RankSelectContract {

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface Model<D extends BaseNode> extends IModel<D> {
        @Nullable
        RankSelectBean getBean();
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface Presenter<M extends RankSelectModel, V extends RankSelectView, N extends BaseNode> extends IPresenter<M, V, N> {
        void expose(@Nullable android.view.View view, @Nullable RankSelectItemBean rankSelectItemBean, int i);

        void itemClick(@Nullable RankSelectView rankSelectView, @Nullable RankSelectItemBean rankSelectItemBean, int i);
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface View<P extends RankSelectPresenter> extends IView<P> {
        void setData(@Nullable RankSelectBean rankSelectBean, int i);
    }
}
