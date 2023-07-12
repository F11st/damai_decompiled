package cn.damai.tetris.component.common;

import cn.damai.tetris.component.common.HeaderVideoContract$Presenter;
import cn.damai.tetris.core.IView;
import cn.damai.tetris.core.TrackInfo;
import cn.damai.tetris.mvp.CommonBean;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
interface HeaderVideoContract$View<P extends HeaderVideoContract$Presenter> extends IView<P> {
    void setData(CommonBean commonBean, String str, TrackInfo trackInfo, boolean z);

    void setMessage(int i, Object obj);
}
