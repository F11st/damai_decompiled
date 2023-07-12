package cn.damai.tetris.core;

import cn.damai.tetris.core.BaseNode;
import com.alibaba.fastjson.JSONObject;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public interface IModel<D extends BaseNode> extends Serializable {
    JSONObject getABBucket();

    String getItemValue(String str);

    int getOffset();

    JSONObject getRawJson();

    StyleInfo getStyleInfo();

    String getStyleValue(String str);

    TrackInfo getTrackInfo();

    void parseModelData(D d);

    void setOffset(int i);
}
