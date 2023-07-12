package com.youku.alixplugin;

import android.content.Context;
import android.os.Bundle;
import com.youku.alixplugin.layer.LMLayerInfo;
import com.youku.alixplugin.layer.LMParentViewGroupLayer;
import com.youku.kubus.NoProguard;
import java.util.List;

/* compiled from: Taobao */
@NoProguard
/* loaded from: classes7.dex */
public class ParentViewGroupLayer extends LMParentViewGroupLayer {
    public ParentViewGroupLayer(Context context, LMLayerInfo lMLayerInfo) {
        super(context, lMLayerInfo);
    }

    @Override // com.youku.alixplugin.layer.LMParentViewGroupLayer
    public void onReceiveMsg(Bundle bundle, String str) {
    }

    @Override // com.youku.alixplugin.layer.LMParentViewGroupLayer
    public void registerMsgs(List<String> list) {
    }

    @Override // com.youku.alixplugin.layer.LMParentViewGroupLayer
    public void sendMsg(Bundle bundle, String str) {
    }

    @Override // com.youku.alixplugin.layer.LMParentViewGroupLayer
    public void unregisterMsgs() {
    }
}
