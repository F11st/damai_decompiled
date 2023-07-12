package com.taobao.weex.devtools.inspector.elements;

import com.taobao.weex.devtools.common.Accumulator;
import com.taobao.weex.devtools.common.Util;
import javax.annotation.Nullable;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class AbstractChainedDescriptor<E> extends Descriptor implements ChainedDescriptor {
    private Descriptor mSuper;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.taobao.weex.devtools.inspector.elements.NodeDescriptor
    public final void getAttributes(Object obj, AttributeAccumulator attributeAccumulator) {
        this.mSuper.getAttributes(obj, attributeAccumulator);
        onGetAttributes(obj, attributeAccumulator);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.taobao.weex.devtools.inspector.elements.NodeDescriptor
    public final void getChildren(Object obj, Accumulator<Object> accumulator) {
        this.mSuper.getChildren(obj, accumulator);
        onGetChildren(obj, accumulator);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.taobao.weex.devtools.inspector.elements.NodeDescriptor
    public final String getLocalName(Object obj) {
        return onGetLocalName(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.taobao.weex.devtools.inspector.elements.NodeDescriptor
    public final String getNodeName(Object obj) {
        return onGetNodeName(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.taobao.weex.devtools.inspector.elements.NodeDescriptor
    public final NodeType getNodeType(Object obj) {
        return onGetNodeType(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.taobao.weex.devtools.inspector.elements.NodeDescriptor
    public final String getNodeValue(Object obj) {
        return onGetNodeValue(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.taobao.weex.devtools.inspector.elements.NodeDescriptor
    public final void getStyles(Object obj, StyleAccumulator styleAccumulator) {
        this.mSuper.getStyles(obj, styleAccumulator);
        onGetStyles(obj, styleAccumulator);
    }

    public final Descriptor getSuper() {
        return this.mSuper;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.taobao.weex.devtools.inspector.elements.NodeDescriptor
    public final void hook(Object obj) {
        verifyThreadAccess();
        this.mSuper.hook(obj);
        onHook(obj);
    }

    protected void onGetAttributes(E e, AttributeAccumulator attributeAccumulator) {
    }

    protected void onGetChildren(E e, Accumulator<Object> accumulator) {
    }

    protected String onGetLocalName(E e) {
        return this.mSuper.getLocalName(e);
    }

    protected String onGetNodeName(E e) {
        return this.mSuper.getNodeName(e);
    }

    protected NodeType onGetNodeType(E e) {
        return this.mSuper.getNodeType(e);
    }

    @Nullable
    public String onGetNodeValue(E e) {
        return this.mSuper.getNodeValue(e);
    }

    protected void onGetStyles(E e, StyleAccumulator styleAccumulator) {
    }

    protected void onHook(E e) {
    }

    protected void onSetAttributesAsText(E e, String str) {
        this.mSuper.setAttributesAsText(e, str);
    }

    protected void onUnhook(E e) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.taobao.weex.devtools.inspector.elements.NodeDescriptor
    public final void setAttributesAsText(Object obj, String str) {
        onSetAttributesAsText(obj, str);
    }

    @Override // com.taobao.weex.devtools.inspector.elements.ChainedDescriptor
    public void setSuper(Descriptor descriptor) {
        Util.throwIfNull(descriptor);
        if (descriptor.equals(this.mSuper)) {
            return;
        }
        if (this.mSuper == null) {
            this.mSuper = descriptor;
            return;
        }
        throw new IllegalStateException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.taobao.weex.devtools.inspector.elements.NodeDescriptor
    public final void unhook(Object obj) {
        verifyThreadAccess();
        onUnhook(obj);
        this.mSuper.unhook(obj);
    }
}
