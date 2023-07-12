package cn.damai.tetris.component.online.mvp;

import cn.damai.tetris.component.online.bean.ArtistBean;
import cn.damai.tetris.component.online.mvp.HeaderContract$Presenter;
import cn.damai.tetris.core.IView;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
interface HeaderContract$View<P extends HeaderContract$Presenter> extends IView<P> {
    void setData(ArtistBean artistBean);
}
