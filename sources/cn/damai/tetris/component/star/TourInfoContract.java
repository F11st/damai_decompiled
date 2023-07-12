package cn.damai.tetris.component.star;

import android.view.ViewGroup;
import cn.damai.player.video.ProxyVideoView;
import cn.damai.tetris.component.star.bean.TourInfoBean;
import cn.damai.tetris.core.BaseNode;
import cn.damai.tetris.core.IModel;
import cn.damai.tetris.core.IPresenter;
import cn.damai.tetris.core.IView;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public interface TourInfoContract {

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface Model<D extends BaseNode> extends IModel {
        TourInfoBean getData();
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface Presenter<M extends IModel, V extends View, N extends BaseNode> extends IPresenter<M, V, N> {
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface View<P extends Presenter> extends IView<P> {
        ViewGroup getKVInfoView();

        ViewGroup getNKVInfoView();

        ViewGroup getTourCityView();

        ProxyVideoView getVideoView();
    }
}
