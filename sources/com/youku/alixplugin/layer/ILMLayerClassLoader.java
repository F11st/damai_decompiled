package com.youku.alixplugin.layer;

import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public interface ILMLayerClassLoader<T> {
    List<LMLayerInfo> getLayerInfos();

    List<LMLayerInfo> getLayers() throws LMLayerDataSourceException;

    T getMapedLayer(LMLayerInfo lMLayerInfo);

    T getMapedLayer(String str) throws LMLayerDataSourceException;

    LMLayerInfo getMapedLayerInfo(String str) throws LMLayerDataSourceException;

    void release();

    void release(int i);
}
