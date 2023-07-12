package cn.damai.tetris.component.live.mvp;

import cn.damai.tetris.component.live.bean.LiveHeaderPicBean;
import cn.damai.tetris.component.live.mvp.HeaderContract$View;
import cn.damai.tetris.core.BaseNode;
import cn.damai.tetris.core.IModel;
import cn.damai.tetris.core.IPresenter;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
interface HeaderContract$Presenter<M extends IModel, V extends HeaderContract$View, N extends BaseNode> extends IPresenter<M, V, N> {
    void headerClick(LiveHeaderPicBean liveHeaderPicBean);
}
