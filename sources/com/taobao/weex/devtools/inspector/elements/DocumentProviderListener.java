package com.taobao.weex.devtools.inspector.elements;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface DocumentProviderListener {
    void onAttributeModified(Object obj, String str, String str2);

    void onAttributeRemoved(Object obj, String str);

    void onInspectRequested(Object obj);

    void onPossiblyChanged();
}
