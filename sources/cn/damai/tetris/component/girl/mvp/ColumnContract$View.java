package cn.damai.tetris.component.girl.mvp;

import cn.damai.tetris.component.girl.bean.StepBean;
import cn.damai.tetris.component.girl.mvp.ColumnContract$Presenter;
import cn.damai.tetris.core.IView;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
interface ColumnContract$View<P extends ColumnContract$Presenter> extends IView<P> {
    void initScreenSize();

    void setData(StepBean stepBean, String str, ColumnContract$Model columnContract$Model);
}
