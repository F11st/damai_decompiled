package cn.damai.tetris.component.drama.mvp;

import cn.damai.tetris.component.drama.bean.AnchorBean;
import cn.damai.tetris.component.drama.bean.AnchorList;
import cn.damai.tetris.core.BaseNode;
import cn.damai.tetris.core.IModel;
import cn.damai.tetris.core.IPresenter;
import cn.damai.tetris.core.IView;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public interface AnchorFloatingContract {

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface Model<D extends BaseNode> extends IModel {
        AnchorList getBean();
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface Presenter<M extends IModel, V extends View, N extends BaseNode> extends IPresenter<M, V, N> {
        void utClick(View view, AnchorBean anchorBean, int i);
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface View<P extends Presenter> extends IView<P> {
        void setData(AnchorList anchorList, int i);
    }
}
