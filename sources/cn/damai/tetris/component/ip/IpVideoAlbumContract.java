package cn.damai.tetris.component.ip;

import cn.damai.tetris.component.ip.bean.VideoAlbum;
import cn.damai.tetris.component.ip.bean.VideoAlbumBean;
import cn.damai.tetris.core.BaseNode;
import cn.damai.tetris.core.IModel;
import cn.damai.tetris.core.IPresenter;
import cn.damai.tetris.core.IView;
import java.util.List;
import tb.mg;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public interface IpVideoAlbumContract {

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface Model<D extends BaseNode> extends IModel {
        VideoAlbumBean getVideoInfo();
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface Presenter<M extends IModel, V extends View, N extends BaseNode> extends IPresenter<M, V, N> {
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface View<P extends Presenter> extends IView<P> {
        mg getTitle();

        void initAblum(List<VideoAlbum> list);
    }
}
