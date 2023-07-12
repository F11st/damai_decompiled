package com.youku.alixplugin.layer;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public abstract class LMParentViewGroupLayer implements ILMLayer<ViewGroup> {
    protected Context context;
    protected LMLayerInfo layerInfo;
    protected List<String> receivedMsgs = new ArrayList();
    protected ViewGroup rootViewGroup;

    public LMParentViewGroupLayer(Context context, LMLayerInfo lMLayerInfo) {
        this.context = context;
        this.layerInfo = lMLayerInfo;
    }

    @Override // com.youku.alixplugin.layer.ILMLayer
    public LMLayerInfo getLayerInfo() {
        return this.layerInfo;
    }

    @Override // com.youku.alixplugin.layer.ILMLayer
    public void onAdded() {
        registerMsgs(this.receivedMsgs);
    }

    @Override // com.youku.alixplugin.layer.ILMLayer
    public void onCreate(Map map) {
    }

    @Override // com.youku.alixplugin.layer.ILMLayer
    public void onHide() {
    }

    public abstract void onReceiveMsg(Bundle bundle, String str);

    @Override // com.youku.alixplugin.layer.ILMLayer
    public void onRemove() {
        unregisterMsgs();
    }

    @Override // com.youku.alixplugin.layer.ILMLayer
    public void onShow() {
    }

    public abstract void registerMsgs(List<String> list);

    public abstract void sendMsg(Bundle bundle, String str);

    public abstract void unregisterMsgs();

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.youku.alixplugin.layer.ILMLayer
    public ViewGroup getUIContainer() {
        return this.rootViewGroup;
    }
}
