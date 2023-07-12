package cn.damai.tetris.component.girl.mvp;

import cn.damai.tetris.component.girl.bean.ProjectViewModel;
import cn.damai.tetris.component.girl.bean.StepBean;
import cn.damai.tetris.component.girl.mvp.ColumnContract$View;
import cn.damai.tetris.core.BaseNode;
import cn.damai.tetris.core.IModel;
import cn.damai.tetris.core.IPresenter;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
interface ColumnContract$Presenter<M extends IModel, V extends ColumnContract$View, N extends BaseNode> extends IPresenter<M, V, N> {
    void allBtnClick(StepBean stepBean, String str);

    void projectItemClick(ProjectViewModel projectViewModel, int i, int i2, String str, String str2);
}
