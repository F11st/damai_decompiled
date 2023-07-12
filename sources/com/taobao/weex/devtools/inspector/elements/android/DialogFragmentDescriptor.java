package com.taobao.weex.devtools.inspector.elements.android;

import android.view.View;
import com.taobao.weex.devtools.common.Accumulator;
import com.taobao.weex.devtools.common.LogUtil;
import com.taobao.weex.devtools.common.Util;
import com.taobao.weex.devtools.common.android.DialogFragmentAccessor;
import com.taobao.weex.devtools.common.android.FragmentCompat;
import com.taobao.weex.devtools.inspector.elements.AttributeAccumulator;
import com.taobao.weex.devtools.inspector.elements.ChainedDescriptor;
import com.taobao.weex.devtools.inspector.elements.Descriptor;
import com.taobao.weex.devtools.inspector.elements.DescriptorMap;
import com.taobao.weex.devtools.inspector.elements.NodeType;
import com.taobao.weex.devtools.inspector.elements.StyleAccumulator;
import javax.annotation.Nullable;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
final class DialogFragmentDescriptor extends Descriptor implements ChainedDescriptor, HighlightableDescriptor {
    private final DialogFragmentAccessor mAccessor;
    private Descriptor mSuper;

    private DialogFragmentDescriptor(FragmentCompat fragmentCompat) {
        this.mAccessor = fragmentCompat.forDialogFragment();
    }

    private static void maybeRegister(DescriptorMap descriptorMap, @Nullable FragmentCompat fragmentCompat) {
        if (fragmentCompat != null) {
            Class<?> dialogFragmentClass = fragmentCompat.getDialogFragmentClass();
            LogUtil.d("Adding support for %s", dialogFragmentClass);
            descriptorMap.register(dialogFragmentClass, new DialogFragmentDescriptor(fragmentCompat));
        }
    }

    public static DescriptorMap register(DescriptorMap descriptorMap) {
        maybeRegister(descriptorMap, FragmentCompat.getSupportLibInstance());
        maybeRegister(descriptorMap, FragmentCompat.getFrameworkInstance());
        return descriptorMap;
    }

    @Override // com.taobao.weex.devtools.inspector.elements.NodeDescriptor
    public void getAttributes(Object obj, AttributeAccumulator attributeAccumulator) {
        this.mSuper.getAttributes(obj, attributeAccumulator);
    }

    @Override // com.taobao.weex.devtools.inspector.elements.NodeDescriptor
    public void getChildren(Object obj, Accumulator<Object> accumulator) {
        accumulator.store(this.mAccessor.getDialog(obj));
    }

    @Override // com.taobao.weex.devtools.inspector.elements.NodeDescriptor
    public String getLocalName(Object obj) {
        return this.mSuper.getLocalName(obj);
    }

    @Override // com.taobao.weex.devtools.inspector.elements.NodeDescriptor
    public String getNodeName(Object obj) {
        return this.mSuper.getNodeName(obj);
    }

    @Override // com.taobao.weex.devtools.inspector.elements.NodeDescriptor
    public NodeType getNodeType(Object obj) {
        return this.mSuper.getNodeType(obj);
    }

    @Override // com.taobao.weex.devtools.inspector.elements.NodeDescriptor
    @Nullable
    public String getNodeValue(Object obj) {
        return this.mSuper.getNodeValue(obj);
    }

    @Override // com.taobao.weex.devtools.inspector.elements.NodeDescriptor
    public void getStyles(Object obj, StyleAccumulator styleAccumulator) {
    }

    @Override // com.taobao.weex.devtools.inspector.elements.android.HighlightableDescriptor
    @Nullable
    public View getViewForHighlighting(Object obj) {
        Descriptor.Host host = getHost();
        if (host instanceof AndroidDescriptorHost) {
            return ((AndroidDescriptorHost) host).getHighlightingView(this.mAccessor.getDialog(obj));
        }
        return null;
    }

    @Override // com.taobao.weex.devtools.inspector.elements.NodeDescriptor
    public void hook(Object obj) {
        this.mSuper.hook(obj);
    }

    @Override // com.taobao.weex.devtools.inspector.elements.NodeDescriptor
    public void setAttributesAsText(Object obj, String str) {
        this.mSuper.setAttributesAsText(obj, str);
    }

    @Override // com.taobao.weex.devtools.inspector.elements.ChainedDescriptor
    public void setSuper(Descriptor descriptor) {
        Util.throwIfNull(descriptor);
        Descriptor descriptor2 = this.mSuper;
        if (descriptor != descriptor2) {
            if (descriptor2 == null) {
                this.mSuper = descriptor;
                return;
            }
            throw new IllegalStateException();
        }
    }

    @Override // com.taobao.weex.devtools.inspector.elements.NodeDescriptor
    public void unhook(Object obj) {
        this.mSuper.unhook(obj);
    }
}
