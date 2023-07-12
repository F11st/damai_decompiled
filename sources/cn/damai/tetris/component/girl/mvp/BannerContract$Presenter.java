package cn.damai.tetris.component.girl.mvp;

import android.view.View;
import cn.damai.tetris.component.girl.bean.BannerBean;
import cn.damai.tetris.component.girl.mvp.BannerContract$View;
import cn.damai.tetris.core.BaseNode;
import cn.damai.tetris.core.IModel;
import cn.damai.tetris.core.IPresenter;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
interface BannerContract$Presenter<M extends IModel, V extends BannerContract$View, N extends BaseNode> extends IPresenter<M, V, N> {
    void exposeItemView(View view, BannerBean bannerBean, int i);

    void itemClick(BannerBean bannerBean, int i, String str);
}
