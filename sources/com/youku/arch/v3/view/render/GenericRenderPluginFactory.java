package com.youku.arch.v3.view.render;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0003\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0002H\u0016¨\u0006\u0006"}, d2 = {"Lcom/youku/arch/v3/view/render/GenericRenderPluginFactory;", "Lcom/youku/arch/v3/view/render/RenderPluginFactory;", "Lcom/youku/arch/v3/view/render/AbsRenderPlugin;", "create", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class GenericRenderPluginFactory implements RenderPluginFactory {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.youku.arch.v3.view.render.RenderPluginFactory
    @NotNull
    public AbsRenderPlugin<?, ?> create() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-272779151") ? (AbsRenderPlugin) ipChange.ipc$dispatch("-272779151", new Object[]{this}) : new GenericRenderPlugin();
    }
}
