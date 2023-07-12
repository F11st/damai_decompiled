package com.youku.arch.v3.view.render;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0003\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0002H&¨\u0006\u0004"}, d2 = {"Lcom/youku/arch/v3/view/render/RenderPluginFactory;", "", "Lcom/youku/arch/v3/view/render/AbsRenderPlugin;", "create", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public interface RenderPluginFactory {
    @Nullable
    AbsRenderPlugin<?, ?> create();
}
