package cn.damai.tetris.component.drama.mvp;

import cn.damai.tetris.component.drama.bean.ProjectListBean;
import cn.damai.tetris.component.drama.bean.ProjectShowBean;
import cn.damai.tetris.core.BaseNode;
import cn.damai.tetris.core.IModel;
import cn.damai.tetris.core.IPresenter;
import cn.damai.tetris.core.IView;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public interface ProjectBroadcastListContract {

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface Model<D extends BaseNode> extends IModel {
        ProjectListBean getBean();
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface Presenter<M extends IModel, V extends View, N extends BaseNode> extends IPresenter<M, V, N> {
        void allClick(View view, String str);

        void exposeItem(android.view.View view, ProjectShowBean projectShowBean, int i, String str);

        void itemClick(View view, ProjectShowBean projectShowBean, int i);
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface View<P extends Presenter> extends IView<P> {
        void setData(ProjectListBean projectListBean, int i);
    }
}
