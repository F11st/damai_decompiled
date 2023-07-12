package com.taobao.weex.devtools.inspector.elements;

import com.taobao.weex.devtools.common.ThreadBound;
import javax.annotation.Nullable;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface DocumentProvider extends ThreadBound {
    void dispose();

    @Nullable
    NodeDescriptor getNodeDescriptor(@Nullable Object obj);

    @Nullable
    Object getRootElement();

    void hideHighlight();

    void highlightElement(Object obj, int i);

    void setAttributesAsText(Object obj, String str);

    void setInspectModeEnabled(boolean z);

    void setListener(DocumentProviderListener documentProviderListener);
}
