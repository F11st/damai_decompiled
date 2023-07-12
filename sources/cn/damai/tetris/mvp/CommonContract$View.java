package cn.damai.tetris.mvp;

import cn.damai.tetris.core.IView;
import cn.damai.tetris.core.NodeData;
import cn.damai.tetris.core.TrackInfo;
import cn.damai.tetris.mvp.CommonContract$Presenter;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
interface CommonContract$View<P extends CommonContract$Presenter> extends IView<P> {
    boolean rebindAble();

    void rebindData(NodeData nodeData);

    void setCommonPresenter(CommonPresenter commonPresenter);

    void setData(NodeData nodeData, String str, TrackInfo trackInfo);

    void setMessage(int i, Object obj);
}
