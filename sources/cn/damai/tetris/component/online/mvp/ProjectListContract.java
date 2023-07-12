package cn.damai.tetris.component.online.mvp;

import cn.damai.tetris.component.online.bean.ProjectInfoBean;
import cn.damai.tetris.component.online.bean.ProjectList;
import cn.damai.tetris.core.BaseNode;
import cn.damai.tetris.core.IModel;
import cn.damai.tetris.core.IPresenter;
import cn.damai.tetris.core.IView;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public interface ProjectListContract {

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface Model<D extends BaseNode> extends IModel {
        ProjectList getBean();
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface Presenter<M extends IModel, V extends View, N extends BaseNode> extends IPresenter<M, V, N> {
        void expose(android.view.View view, ProjectInfoBean projectInfoBean, int i, String str);

        void itemClick(View view, ProjectInfoBean projectInfoBean, int i, String str);
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface View<P extends Presenter> extends IView<P> {
        void setData(ProjectList projectList, int i);
    }
}
