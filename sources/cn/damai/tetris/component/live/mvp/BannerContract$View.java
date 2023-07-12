package cn.damai.tetris.component.live.mvp;

import cn.damai.tetris.component.live.bean.LiveHeaderCardBean;
import cn.damai.tetris.component.live.mvp.BannerContract$Presenter;
import cn.damai.tetris.core.IView;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
interface BannerContract$View<P extends BannerContract$Presenter> extends IView<P> {
    void setData(LiveHeaderCardBean liveHeaderCardBean);
}
