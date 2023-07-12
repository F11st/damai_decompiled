package cn.damai.tetris.component.discover.mvp;

import cn.damai.commonbusiness.discover.bean.CircleBean;
import cn.damai.commonbusiness.discover.bean.CircleListWrapBean;
import cn.damai.tetris.core.BaseNode;
import cn.damai.tetris.core.IModel;
import cn.damai.tetris.core.IPresenter;
import cn.damai.tetris.core.IView;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public interface CircleHotHorContract {

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface Model<D extends BaseNode> extends IModel {
        CircleListWrapBean getBean();
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface Presenter<M extends IModel, V extends View, N extends BaseNode> extends IPresenter<M, V, N> {
        void exposeItem(android.view.View view, CircleBean circleBean, int i);

        void itemClick(CircleBean circleBean, int i);
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface View<P extends Presenter> extends IView<P> {
        void setData(CircleListWrapBean circleListWrapBean, int i);
    }
}
