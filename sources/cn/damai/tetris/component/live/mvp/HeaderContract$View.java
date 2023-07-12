package cn.damai.tetris.component.live.mvp;

import cn.damai.tetris.component.live.bean.LiveHeaderPicBean;
import cn.damai.tetris.component.live.mvp.HeaderContract$Presenter;
import cn.damai.tetris.core.IView;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
interface HeaderContract$View<P extends HeaderContract$Presenter> extends IView<P> {
    void setData(LiveHeaderPicBean liveHeaderPicBean);
}
