package cn.damai.tetris.component.star;

import android.view.ViewGroup;
import cn.damai.tetris.component.star.bean.FansRankingBean;
import cn.damai.tetris.component.star.bean.TopFans;
import cn.damai.tetris.core.BaseNode;
import cn.damai.tetris.core.IModel;
import cn.damai.tetris.core.IPresenter;
import cn.damai.tetris.core.IView;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public interface FansRankingContract {

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface Model<D extends BaseNode> extends IModel {
        String getBannerImg();

        List<TopFans> getFansList();

        FansRankingBean getRankingData();

        String getUrl();
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface Presenter<M extends IModel, V extends View, N extends BaseNode> extends IPresenter<M, V, N> {
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface View<P extends Presenter> extends IView<P> {
        ViewGroup getFansView();
    }
}
