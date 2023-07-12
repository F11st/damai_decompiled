package com.taobao.weex.devtools.inspector.elements.android;

import android.app.Application;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.devtools.common.Accumulator;
import com.taobao.weex.devtools.common.Util;
import com.taobao.weex.devtools.inspector.elements.AbstractChainedDescriptor;
import com.taobao.weex.devtools.inspector.elements.NodeType;
import com.taobao.weex.devtools.inspector.protocol.module.DOM;
import com.taobao.weex.ui.WXRenderManager;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class AndroidDocumentRoot extends AbstractChainedDescriptor<AndroidDocumentRoot> {
    private Application mApplication;

    public AndroidDocumentRoot(Application application) {
        this.mApplication = (Application) Util.throwIfNull(application);
    }

    @Override // com.taobao.weex.devtools.inspector.elements.AbstractChainedDescriptor
    protected /* bridge */ /* synthetic */ void onGetChildren(AndroidDocumentRoot androidDocumentRoot, Accumulator accumulator) {
        onGetChildren2(androidDocumentRoot, (Accumulator<Object>) accumulator);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.devtools.inspector.elements.AbstractChainedDescriptor
    public String onGetNodeName(AndroidDocumentRoot androidDocumentRoot) {
        return "root";
    }

    /* renamed from: onGetChildren  reason: avoid collision after fix types in other method */
    protected void onGetChildren2(AndroidDocumentRoot androidDocumentRoot, Accumulator<Object> accumulator) {
        List<WXSDKInstance> allInstances;
        if (DOM.isNativeMode()) {
            accumulator.store(this.mApplication);
            return;
        }
        WXRenderManager G = WXSDKManager.v().G();
        if (G == null || (allInstances = G.getAllInstances()) == null || allInstances.isEmpty()) {
            return;
        }
        for (WXSDKInstance wXSDKInstance : allInstances) {
            accumulator.store(wXSDKInstance);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.devtools.inspector.elements.AbstractChainedDescriptor
    public NodeType onGetNodeType(AndroidDocumentRoot androidDocumentRoot) {
        return NodeType.DOCUMENT_NODE;
    }
}
