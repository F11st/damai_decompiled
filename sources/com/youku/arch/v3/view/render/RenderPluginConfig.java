package com.youku.arch.v3.view.render;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.adapter.ViewTypeConfig;
import com.youku.arch.v3.adapter.ViewTypeSupport;
import com.youku.arch.v3.core.IContext;
import io.flutter.wpkbridge.WPKFactory;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joor.a;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002J\u0016\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002R2\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u000ej\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004`\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R2\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000ej\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0016\u0010\u0005\u001a\u00020\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/youku/arch/v3/view/render/RenderPluginConfig;", "", "", "type", "Lcom/youku/arch/v3/view/render/RenderPluginFactory;", "renderPluginFactory", "Ltb/wt2;", "setSupportRenderPlugin", "renderPluginClassName", "Lcom/youku/arch/v3/core/IContext;", WPKFactory.INIT_KEY_CONTEXT, "", "isSupportRenderPlugin", "getRenderPluginFactory", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "renderPluginFactoryMap", "Ljava/util/HashMap;", "renderPluginFactoryClassNameMap", "Lcom/youku/arch/v3/view/render/GenericRenderPluginFactory;", "Lcom/youku/arch/v3/view/render/GenericRenderPluginFactory;", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class RenderPluginConfig {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final HashMap<String, RenderPluginFactory> renderPluginFactoryMap = new HashMap<>();
    @NotNull
    private final HashMap<String, String> renderPluginFactoryClassNameMap = new HashMap<>();
    @NotNull
    private final GenericRenderPluginFactory renderPluginFactory = new GenericRenderPluginFactory();

    @Nullable
    public final RenderPluginFactory getRenderPluginFactory(@NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1381654329")) {
            return (RenderPluginFactory) ipChange.ipc$dispatch("-1381654329", new Object[]{this, str});
        }
        b41.i(str, "type");
        if (this.renderPluginFactoryMap.containsKey(str)) {
            return this.renderPluginFactoryMap.get(str);
        }
        if (this.renderPluginFactoryClassNameMap.containsKey(str)) {
            String str2 = this.renderPluginFactoryClassNameMap.get(str);
            if (str2 == null) {
                str2 = null;
            } else {
                a.j(str2).b().f();
            }
            if (str2 instanceof RenderPluginFactory) {
                return (RenderPluginFactory) str2;
            }
            return null;
        }
        return null;
    }

    public final boolean isSupportRenderPlugin(@NotNull IContext iContext, @NotNull String str) {
        ViewTypeSupport viewTypeSupport;
        ViewTypeConfig viewTypeConfig;
        IpChange ipChange = $ipChange;
        boolean z = false;
        boolean z2 = true;
        if (AndroidInstantRuntime.support(ipChange, "443253574")) {
            return ((Boolean) ipChange.ipc$dispatch("443253574", new Object[]{this, iContext, str})).booleanValue();
        }
        b41.i(iContext, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(str, "type");
        boolean z3 = this.renderPluginFactoryMap.containsKey(str) || this.renderPluginFactoryClassNameMap.containsKey(str);
        if (z3 || (viewTypeSupport = iContext.getViewTypeSupport()) == null || (viewTypeConfig = viewTypeSupport.getViewTypeConfig(Integer.parseInt(str))) == null) {
            return z3;
        }
        String renderPluginFactory = viewTypeConfig.getRenderPluginFactory();
        if ((renderPluginFactory == null || renderPluginFactory.length() == 0) ? true : true) {
            z2 = z3;
        } else {
            this.renderPluginFactoryMap.put(str, this.renderPluginFactory);
        }
        return z2;
    }

    public final void setSupportRenderPlugin(@NotNull String str, @NotNull RenderPluginFactory renderPluginFactory) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "736813164")) {
            ipChange.ipc$dispatch("736813164", new Object[]{this, str, renderPluginFactory});
            return;
        }
        b41.i(str, "type");
        b41.i(renderPluginFactory, "renderPluginFactory");
        this.renderPluginFactoryMap.put(str, renderPluginFactory);
    }

    public final void setSupportRenderPlugin(@NotNull String str, @NotNull String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "518625882")) {
            ipChange.ipc$dispatch("518625882", new Object[]{this, str, str2});
            return;
        }
        b41.i(str, "type");
        b41.i(str2, "renderPluginClassName");
        this.renderPluginFactoryClassNameMap.put(str, str2);
    }
}
