package cn.damai.tetris.gaiax;

import android.content.Context;
import cn.damai.tetris.core.IModel;
import com.alibaba.fastjson.JSONObject;
import com.youku.gaiax.LoadType;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public interface GaiaXModel extends IModel {
    boolean forceCreate();

    String getBiz();

    Float getDefaultDesireHeight(Context context);

    float getDefaultDesireWidth(Context context);

    JSONObject getDesireRawJson();

    LoadType getLoadType();

    int getType();

    String getVersion();

    boolean openMinHeight();

    void setContext(Context context);
}
