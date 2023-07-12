package com.taobao.weex.devtools.inspector.elements;

import com.taobao.weex.devtools.common.Accumulator;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class ObjectDescriptor extends Descriptor {
    @Override // com.taobao.weex.devtools.inspector.elements.NodeDescriptor
    public void getAttributes(Object obj, AttributeAccumulator attributeAccumulator) {
    }

    @Override // com.taobao.weex.devtools.inspector.elements.NodeDescriptor
    public void getChildren(Object obj, Accumulator<Object> accumulator) {
    }

    @Override // com.taobao.weex.devtools.inspector.elements.NodeDescriptor
    public String getLocalName(Object obj) {
        return getNodeName(obj);
    }

    @Override // com.taobao.weex.devtools.inspector.elements.NodeDescriptor
    public String getNodeName(Object obj) {
        return obj.getClass().getName();
    }

    @Override // com.taobao.weex.devtools.inspector.elements.NodeDescriptor
    public NodeType getNodeType(Object obj) {
        return NodeType.ELEMENT_NODE;
    }

    @Override // com.taobao.weex.devtools.inspector.elements.NodeDescriptor
    public String getNodeValue(Object obj) {
        return null;
    }

    @Override // com.taobao.weex.devtools.inspector.elements.NodeDescriptor
    public void getStyles(Object obj, StyleAccumulator styleAccumulator) {
    }

    @Override // com.taobao.weex.devtools.inspector.elements.NodeDescriptor
    public void hook(Object obj) {
    }

    @Override // com.taobao.weex.devtools.inspector.elements.NodeDescriptor
    public void setAttributesAsText(Object obj, String str) {
    }

    @Override // com.taobao.weex.devtools.inspector.elements.NodeDescriptor
    public void unhook(Object obj) {
    }
}
