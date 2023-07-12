package cn.damai.tetris.component.star.content.base;

import android.util.Pair;
import android.view.ViewGroup;
import cn.damai.tetris.component.star.content.base.bean.ContentFreeRootBean;
import cn.damai.tetris.component.star.content.base.bean.ContentItemBean;
import cn.damai.tetris.componentplugin.OnBizListener;
import cn.damai.tetris.core.BaseNode;
import cn.damai.tetris.core.IModel;
import cn.damai.tetris.core.IPresenter;
import cn.damai.tetris.core.IView;
import cn.damai.tetris.core.mtop.BaseResponse;
import cn.damai.tetris.request.TetrisRequest;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public interface ContentBaseContract {

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface Model<D extends BaseNode> extends IModel {
        ContentFreeRootBean allData();

        boolean hasNext();

        List<ContentItemBean> listData();

        void load(OnBizListener<Pair<BaseResponse, ContentFreeRootBean>> onBizListener, String str, TetrisRequest tetrisRequest);
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface Presenter<M extends IModel, V extends View, N extends BaseNode> extends IPresenter<M, V, N> {
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface View<P extends Presenter> extends IView<P> {
        ViewGroup getProjectsView();
    }
}
