package com.youku.alixplugin.layer;

import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public interface ILMLayer<T> {
    LMLayerInfo getLayerInfo();

    T getUIContainer();

    void onAdded();

    void onCreate(Map map);

    void onHide();

    void onRemove();

    void onShow();
}
