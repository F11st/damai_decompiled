package cn.damai.tetris.component.girl.mvp;

import cn.damai.tetris.component.girl.bean.BannerBean;
import cn.damai.tetris.core.BaseNode;
import cn.damai.tetris.core.IModel;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
interface BannerContract$Model<D extends BaseNode> extends IModel {
    List<BannerBean> getBannerList();

    String getTitle();
}
