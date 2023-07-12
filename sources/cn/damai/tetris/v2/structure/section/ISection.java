package cn.damai.tetris.v2.structure.section;

import androidx.annotation.Nullable;
import cn.damai.tetris.core.StyleInfo;
import cn.damai.tetris.core.TrackInfo;
import cn.damai.tetris.v2.common.Addressable;
import cn.damai.tetris.v2.structure.container.IContainer;
import cn.damai.tetris.v2.structure.layer.ILayer;
import cn.damai.tetris.v2.structure.module.IModule;
import com.alibaba.fastjson.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public interface ISection extends Addressable {
    void addItem(JSONObject jSONObject);

    String getComponentId();

    int getComponentType();

    IContainer getContainer();

    JSONObject getDxConfig();

    Object getExtra();

    JSONObject getExtraArgs();

    JSONObject getGaiaxConfig();

    JSONObject getItem();

    ILayer getLayer();

    IModule getModule();

    SectionProperty getProperty();

    JSONObject getRawData();

    String getSectionId();

    StyleInfo getStyleInfo();

    @Nullable
    TrackInfo getTrackInfo();

    int getType();

    void setExtra(Object obj);

    void setExtraArgs(JSONObject jSONObject);

    void setLayer(ILayer iLayer);
}
