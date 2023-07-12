package com.youku.alixplugin.layer;

import android.content.Context;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public interface ILMLayerManager<T> {
    void addLayer(ILMLayer<T> iLMLayer);

    int getChildCount();

    ILMLayer<T> getLayerById(String str, Context context) throws LMLayerDataSourceException;

    ILMLayer<T> getLayerById(String str, Context context, Map<String, Object> map) throws LMLayerDataSourceException;

    T getRootUIContainer();

    void hideLayer(String str) throws LMLayerDataSourceException;

    T loadAllConfigLayers() throws LMLayerException;

    T loadLayersByConfig() throws LMLayerDataSourceException;

    T loadLayersByIds(List<String> list) throws LMLayerDataSourceException;

    void release();

    void removeAllLayers();

    void removeLayer(String str) throws LMLayerDataSourceException;

    void removeLayerAt(int i);

    void setDebugLogEnable(boolean z);

    void showLayer(String str) throws LMLayerDataSourceException;
}
