package cn.damai.tetris.component.live.mvp;

import cn.damai.tetris.component.live.bean.LiveHeaderCardItemBean;
import cn.damai.tetris.component.live.mvp.BannerContract$View;
import cn.damai.tetris.core.BaseNode;
import cn.damai.tetris.core.IModel;
import cn.damai.tetris.core.IPresenter;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
interface BannerContract$Presenter<M extends IModel, V extends BannerContract$View, N extends BaseNode> extends IPresenter<M, V, N> {
    void itemClick(LiveHeaderCardItemBean liveHeaderCardItemBean, int i);
}
