package cn.damai.tetris.component.star.header;

import android.view.ViewGroup;
import cn.damai.tetris.component.star.bean.StarHeaderData;
import cn.damai.tetris.core.BaseNode;
import cn.damai.tetris.core.IModel;
import cn.damai.tetris.core.IPresenter;
import cn.damai.tetris.core.IView;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public interface StarHeaderContract {

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface Model<D extends BaseNode> extends IModel {
        StarHeaderData getData();

        int getFragmentType();

        void setData(StarHeaderData starHeaderData);

        void setFragmentType(int i);
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface Presenter<M extends IModel, V extends View, N extends BaseNode> extends IPresenter<M, V, N> {
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface View<P extends Presenter> extends IView<P> {
        ViewGroup getHeaderView();
    }
}
