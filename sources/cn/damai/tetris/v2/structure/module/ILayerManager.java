package cn.damai.tetris.v2.structure.module;

import cn.damai.tetris.v2.common.Node;
import cn.damai.tetris.v2.common.OnChildAttachStateChangeListener;
import cn.damai.tetris.v2.structure.layer.ILayer;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public interface ILayerManager {
    void addLayer(int i, ILayer iLayer);

    void addLayer(int i, ILayer iLayer, OnChildAttachStateChangeListener onChildAttachStateChangeListener);

    void addLayer(int i, ILayer iLayer, boolean z);

    void clearLayerList();

    ILayer createLayer(Node node);

    void createLayerList(List<Node> list);

    List<ILayer> getLayerList();

    void removeLayer(ILayer iLayer);

    void removeLayer(ILayer iLayer, OnChildAttachStateChangeListener onChildAttachStateChangeListener);

    void removeLayer(ILayer iLayer, boolean z);

    void updateChildIndex();
}
