package cn.damai.tetris.component.ip;

import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.imagebrowse.bean.VideoInfo;
import cn.damai.player.listener.OnPlayerUTReportListener;
import cn.damai.tetris.core.BaseNode;
import cn.damai.tetris.core.IModel;
import cn.damai.tetris.core.IPresenter;
import cn.damai.tetris.core.IView;
import tb.ys;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public interface IpVideoHeaderContract {

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface Model<D extends BaseNode> extends IModel {
        VideoInfo getVideoInfo();
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface Presenter<M extends IModel, V extends View, N extends BaseNode> extends IPresenter<M, V, N> {
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface View<P extends Presenter> extends IView<P> {
        ys getManager();

        void hideTip();

        void setMuteIcon(int i);

        void setStateListener(OnPlayerUTReportListener onPlayerUTReportListener);

        void setVideoInfo(VideoInfo videoInfo);

        void showTip();

        void toogleAnim(RecyclerView recyclerView);
    }
}
