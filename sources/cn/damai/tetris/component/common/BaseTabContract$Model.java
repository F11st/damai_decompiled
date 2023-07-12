package cn.damai.tetris.component.common;

import cn.damai.tetris.component.common.bean.BaseTabResultItem;
import cn.damai.tetris.core.BaseNode;
import cn.damai.tetris.core.IModel;
import com.alibaba.fastjson.JSONObject;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
interface BaseTabContract$Model<D extends BaseNode> extends IModel {
    List<BaseTabResultItem> getTabLists();

    JSONObject getTrackInfoAction();
}
