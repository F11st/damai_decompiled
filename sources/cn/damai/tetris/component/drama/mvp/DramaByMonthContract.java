package cn.damai.tetris.component.drama.mvp;

import cn.damai.tetris.component.drama.bean.DramaMonthBean;
import cn.damai.tetris.component.drama.bean.DramaV1Bean;
import cn.damai.tetris.component.drama.bean.DramaWrapBean;
import cn.damai.tetris.core.BaseNode;
import cn.damai.tetris.core.IModel;
import cn.damai.tetris.core.IPresenter;
import cn.damai.tetris.core.IView;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public interface DramaByMonthContract {

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface Model<D extends BaseNode> extends IModel {
        DramaWrapBean getBean();
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface Presenter<M extends IModel, V extends View, N extends BaseNode> extends IPresenter<M, V, N> {
        void exposeDrama(android.view.View view, DramaV1Bean dramaV1Bean, int i);

        void itemClick(View view, DramaV1Bean dramaV1Bean, int i);

        void onAllClick(View view, String str);

        void onTabClick(View view, DramaMonthBean dramaMonthBean, int i);
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface View<P extends Presenter> extends IView<P> {
        void setData(DramaWrapBean dramaWrapBean, int i);
    }
}
