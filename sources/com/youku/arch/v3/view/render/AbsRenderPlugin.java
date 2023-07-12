package com.youku.arch.v3.view.render;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.bridge.WXBridgeManager;
import com.youku.arch.v3.core.IContext;
import com.youku.arch.v3.data.Constants;
import com.youku.arch.v3.view.render.RenderConfig;
import io.flutter.wpkbridge.WPKFactory;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.wt2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u00020\u0001B\u0007¢\u0006\u0004\b+\u0010,J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H&J)\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00028\u00012\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0012\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0011\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0014\u001a\u00020\u0007H&J&\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00152\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0017H&R\"\u0010\u000b\u001a\u00028\u00018\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\u0011\u001a\u00028\u00008\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0011\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010%\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006-"}, d2 = {"Lcom/youku/arch/v3/view/render/AbsRenderPlugin;", "", "DATA", "Lcom/youku/arch/v3/view/render/RenderConfig;", "CONFIG", "Lcom/youku/arch/v3/core/IContext;", Constants.PAGE_CONTEXT, "Ltb/wt2;", "attachContext", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, com.youku.arch.v3.core.Constants.CONFIG, "Landroid/view/ViewGroup;", "parent", "Landroid/view/View;", "createView", "(Landroid/content/Context;Lcom/youku/arch/v3/view/render/RenderConfig;Landroid/view/ViewGroup;)Landroid/view/View;", "data", "bindData", "(Landroid/content/Context;Ljava/lang/Object;)V", "destroyRenderPlugin", "", "eventName", "", "params", WXBridgeManager.METHOD_FIRE_EVENT, "Lcom/youku/arch/v3/view/render/RenderConfig;", "getConfig", "()Lcom/youku/arch/v3/view/render/RenderConfig;", "setConfig", "(Lcom/youku/arch/v3/view/render/RenderConfig;)V", "Ljava/lang/Object;", "getData", "()Ljava/lang/Object;", "setData", "(Ljava/lang/Object;)V", "Lcom/youku/arch/v3/view/render/OnRenderListener;", "onRenderListener", "Lcom/youku/arch/v3/view/render/OnRenderListener;", "getOnRenderListener", "()Lcom/youku/arch/v3/view/render/OnRenderListener;", "setOnRenderListener", "(Lcom/youku/arch/v3/view/render/OnRenderListener;)V", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public abstract class AbsRenderPlugin<DATA, CONFIG extends RenderConfig> {
    private static transient /* synthetic */ IpChange $ipChange;
    public CONFIG config;
    public DATA data;
    @Nullable
    private OnRenderListener onRenderListener;

    public abstract void attachContext(@NotNull IContext iContext);

    public void bindData(@Nullable Context context, @NotNull DATA data) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1098347345")) {
            ipChange.ipc$dispatch("-1098347345", new Object[]{this, context, data});
            return;
        }
        b41.i(data, "data");
        setData(data);
    }

    @Nullable
    public abstract View createView(@NotNull Context context, @NotNull CONFIG config, @NotNull ViewGroup viewGroup);

    public abstract void destroyRenderPlugin();

    public abstract void fireEvent(@NotNull String str, @Nullable Map<String, ? extends Object> map);

    @NotNull
    public final CONFIG getConfig() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "331250299")) {
            return (CONFIG) ipChange.ipc$dispatch("331250299", new Object[]{this});
        }
        CONFIG config = this.config;
        if (config != null) {
            return config;
        }
        b41.A(com.youku.arch.v3.core.Constants.CONFIG);
        return null;
    }

    @NotNull
    public final DATA getData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2020159428")) {
            return (DATA) ipChange.ipc$dispatch("2020159428", new Object[]{this});
        }
        DATA data = this.data;
        if (data != null) {
            return data;
        }
        b41.A("data");
        return (DATA) wt2.INSTANCE;
    }

    @Nullable
    public final OnRenderListener getOnRenderListener() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-38516271") ? (OnRenderListener) ipChange.ipc$dispatch("-38516271", new Object[]{this}) : this.onRenderListener;
    }

    public final void setConfig(@NotNull CONFIG config) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1575629829")) {
            ipChange.ipc$dispatch("1575629829", new Object[]{this, config});
            return;
        }
        b41.i(config, "<set-?>");
        this.config = config;
    }

    public final void setData(@NotNull DATA data) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1688124930")) {
            ipChange.ipc$dispatch("-1688124930", new Object[]{this, data});
            return;
        }
        b41.i(data, "<set-?>");
        this.data = data;
    }

    public final void setOnRenderListener(@Nullable OnRenderListener onRenderListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-204363987")) {
            ipChange.ipc$dispatch("-204363987", new Object[]{this, onRenderListener});
        } else {
            this.onRenderListener = onRenderListener;
        }
    }
}
