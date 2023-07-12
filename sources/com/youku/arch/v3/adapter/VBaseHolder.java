package com.youku.arch.v3.adapter;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IComponent;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ComponentValue;
import com.youku.arch.v3.core.IContext;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.data.Constants;
import com.youku.arch.v3.event.EventHandler;
import com.youku.arch.v3.event.ViewHolderEvent;
import com.youku.arch.v3.view.render.AbsRenderPlugin;
import com.youku.arch.v3.view.render.GenericRenderConfig;
import io.flutter.wpkbridge.WPKFactory;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.wt2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\u000e\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00020\u00020\u0001*\b\b\u0001\u0010\u0005*\u00020\u00042\u00020\u00062\u00020\u0007B\u000f\u0012\u0006\u00106\u001a\u000205¢\u0006\u0004\b7\u00108J\b\u0010\t\u001a\u00020\bH$J\u0015\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00028\u0000¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\r\u001a\u00020\bH$J\u0006\u0010\u000e\u001a\u00020\bJ\u0006\u0010\u000f\u001a\u00020\bJ&\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u00102\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012H\u0016J\b\u0010\u0017\u001a\u00020\bH\u0016J\b\u0010\u0018\u001a\u00020\bH\u0016J\b\u0010\u0019\u001a\u00020\bH\u0016J\b\u0010\u001a\u001a\u00020\bH\u0016R\"\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010#\u001a\u00020\"8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R.\u0010\n\u001a\u0004\u0018\u00018\u00002\b\u0010)\u001a\u0004\u0018\u00018\u00008\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010\fR0\u0010/\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010.8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104¨\u00069"}, d2 = {"Lcom/youku/arch/v3/adapter/VBaseHolder;", "Lcom/youku/arch/v3/IItem;", "Lcom/youku/arch/v3/core/ItemValue;", "D", "Lcom/youku/arch/v3/view/render/GenericRenderConfig;", "CONFIG", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/youku/arch/v3/event/EventHandler;", "Ltb/wt2;", "initData", "data", "resetData", "(Lcom/youku/arch/v3/IItem;)V", "refreshData", "removeComponent", "removeItem", "", "type", "", "", "params", "", "onMessage", "onCreate", ViewHolderEvent.ON_VIEW_ATTACHED_TO_WINDOW, ViewHolderEvent.ON_VIEW_DETACHED_FROM_WINDOW, ViewHolderEvent.ON_RECYCLED, "Lcom/youku/arch/v3/core/IContext;", Constants.PAGE_CONTEXT, "Lcom/youku/arch/v3/core/IContext;", "getPageContext", "()Lcom/youku/arch/v3/core/IContext;", "setPageContext", "(Lcom/youku/arch/v3/core/IContext;)V", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "value", "Lcom/youku/arch/v3/IItem;", "getData", "()Lcom/youku/arch/v3/IItem;", "setData", "Lcom/youku/arch/v3/view/render/AbsRenderPlugin;", "renderPlugin", "Lcom/youku/arch/v3/view/render/AbsRenderPlugin;", "getRenderPlugin", "()Lcom/youku/arch/v3/view/render/AbsRenderPlugin;", "setRenderPlugin", "(Lcom/youku/arch/v3/view/render/AbsRenderPlugin;)V", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public abstract class VBaseHolder<D extends IItem<ItemValue>, CONFIG extends GenericRenderConfig> extends RecyclerView.ViewHolder implements EventHandler {
    private static transient /* synthetic */ IpChange $ipChange;
    public Context context;
    @Nullable
    private D data;
    public IContext pageContext;
    @Nullable
    private AbsRenderPlugin<D, CONFIG> renderPlugin;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VBaseHolder(@NotNull View view) {
        super(view);
        b41.i(view, "itemView");
    }

    @NotNull
    public final Context getContext() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "142925026")) {
            return (Context) ipChange.ipc$dispatch("142925026", new Object[]{this});
        }
        Context context = this.context;
        if (context != null) {
            return context;
        }
        b41.A(WPKFactory.INIT_KEY_CONTEXT);
        return null;
    }

    @Nullable
    public final D getData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1468880535") ? (D) ipChange.ipc$dispatch("-1468880535", new Object[]{this}) : this.data;
    }

    @NotNull
    public final IContext getPageContext() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-231065503")) {
            return (IContext) ipChange.ipc$dispatch("-231065503", new Object[]{this});
        }
        IContext iContext = this.pageContext;
        if (iContext != null) {
            return iContext;
        }
        b41.A(Constants.PAGE_CONTEXT);
        return null;
    }

    @Nullable
    public AbsRenderPlugin<D, CONFIG> getRenderPlugin() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1316899334") ? (AbsRenderPlugin) ipChange.ipc$dispatch("-1316899334", new Object[]{this}) : this.renderPlugin;
    }

    protected abstract void initData();

    public void onCreate() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1189338648")) {
            ipChange.ipc$dispatch("-1189338648", new Object[]{this});
        }
    }

    public boolean onMessage(@NotNull String str, @Nullable Map<String, ? extends Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "268136800")) {
            return ((Boolean) ipChange.ipc$dispatch("268136800", new Object[]{this, str, map})).booleanValue();
        }
        b41.i(str, "type");
        return false;
    }

    public void onRecycled() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1425545939")) {
            ipChange.ipc$dispatch("1425545939", new Object[]{this});
        }
    }

    public void onViewAttachedToWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1932813520")) {
            ipChange.ipc$dispatch("1932813520", new Object[]{this});
        }
    }

    public void onViewDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1098369011")) {
            ipChange.ipc$dispatch("1098369011", new Object[]{this});
        }
    }

    protected abstract void refreshData();

    public final void removeComponent() {
        final IComponent<ComponentValue> component;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1096368174")) {
            ipChange.ipc$dispatch("1096368174", new Object[]{this});
            return;
        }
        D d = this.data;
        if (d == null || (component = d.getComponent()) == null) {
            return;
        }
        getPageContext().runOnUIThread(new Function0<wt2>() { // from class: com.youku.arch.v3.adapter.VBaseHolder$removeComponent$1$1
            private static transient /* synthetic */ IpChange $ipChange;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ wt2 invoke() {
                invoke2();
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-150704230")) {
                    ipChange2.ipc$dispatch("-150704230", new Object[]{this});
                } else {
                    component.getModule().removeComponent(component, true);
                }
            }
        });
    }

    public final void removeItem() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1408944404")) {
            ipChange.ipc$dispatch("-1408944404", new Object[]{this});
            return;
        }
        final D d = this.data;
        if (d == null) {
            return;
        }
        d.getPageContext().runOnLoaderThread(new Function0<wt2>() { // from class: com.youku.arch.v3.adapter.VBaseHolder$removeItem$1$1
            private static transient /* synthetic */ IpChange $ipChange;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Incorrect types in method signature: (TD;)V */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ wt2 invoke() {
                invoke2();
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1451453556")) {
                    ipChange2.ipc$dispatch("-1451453556", new Object[]{this});
                } else {
                    IItem.this.getComponent().removeItem(IItem.this, true);
                }
            }
        });
    }

    public final void resetData(@NotNull D d) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "443222532")) {
            ipChange.ipc$dispatch("443222532", new Object[]{this, d});
            return;
        }
        b41.i(d, "data");
        setData(d);
        refreshData();
    }

    public final void setContext(@NotNull Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-115006830")) {
            ipChange.ipc$dispatch("-115006830", new Object[]{this, context});
            return;
        }
        b41.i(context, "<set-?>");
        this.context = context;
    }

    public final void setData(@Nullable D d) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2137397097")) {
            ipChange.ipc$dispatch("-2137397097", new Object[]{this, d});
            return;
        }
        this.data = d;
        initData();
    }

    public final void setPageContext(@NotNull IContext iContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1167673581")) {
            ipChange.ipc$dispatch("-1167673581", new Object[]{this, iContext});
            return;
        }
        b41.i(iContext, "<set-?>");
        this.pageContext = iContext;
    }

    public void setRenderPlugin(@Nullable AbsRenderPlugin<D, CONFIG> absRenderPlugin) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "357027910")) {
            ipChange.ipc$dispatch("357027910", new Object[]{this, absRenderPlugin});
        } else {
            this.renderPlugin = absRenderPlugin;
        }
    }
}
