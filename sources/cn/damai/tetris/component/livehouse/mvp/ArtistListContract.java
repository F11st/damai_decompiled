package cn.damai.tetris.component.livehouse.mvp;

import cn.damai.tetris.component.livehouse.bean.ArtistItemBean;
import cn.damai.tetris.component.livehouse.bean.ArtistList;
import cn.damai.tetris.core.BaseNode;
import cn.damai.tetris.core.IModel;
import cn.damai.tetris.core.IPresenter;
import cn.damai.tetris.core.IView;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public interface ArtistListContract {

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface Model<D extends BaseNode> extends IModel {
        ArtistList getBean();
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface Presenter<M extends IModel, V extends View, N extends BaseNode> extends IPresenter<M, V, N> {
        void onArtistAvatarItemViewClick(View view, ArtistItemBean artistItemBean, int i, String str);

        void onArtistAvatarItemViewExpose(android.view.View view, ArtistItemBean artistItemBean, int i, String str);

        void userTrackClick(String str, int i, String str2, String str3);

        void userTrackExpose(android.view.View view, int i, String str, String str2, String str3, String str4);
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface View<P extends Presenter> extends IView<P> {
        void setData(ArtistList artistList, int i);
    }
}
