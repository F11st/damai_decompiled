package com.taobao.weex.devtools.inspector.elements.android;

import android.view.View;
import com.taobao.weex.devtools.inspector.elements.Descriptor;
import javax.annotation.Nullable;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
interface AndroidDescriptorHost extends Descriptor.Host {
    @Nullable
    View getHighlightingView(@Nullable Object obj);
}
