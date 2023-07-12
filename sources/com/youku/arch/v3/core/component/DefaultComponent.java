package com.youku.arch.v3.core.component;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.adapter.VBaseAdapter;
import com.youku.arch.v3.adapter.VBaseHolder;
import com.youku.arch.v3.core.ComponentValue;
import com.youku.arch.v3.core.Constants;
import com.youku.arch.v3.core.IContext;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.event.ComponentEvent;
import com.youku.arch.v3.view.render.GenericRenderConfig;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import io.flutter.wpkbridge.WPKFactory;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ&\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016¨\u0006\u0010"}, d2 = {"Lcom/youku/arch/v3/core/component/DefaultComponent;", "Lcom/youku/arch/v3/core/component/GenericComponent;", "Lcom/youku/arch/v3/core/ComponentValue;", "", "type", "", "", "params", "", "onMessage", "Lcom/youku/arch/v3/core/IContext;", WPKFactory.INIT_KEY_CONTEXT, "Lcom/youku/arch/v3/core/Node;", Constants.CONFIG, "<init>", "(Lcom/youku/arch/v3/core/IContext;Lcom/youku/arch/v3/core/Node;)V", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class DefaultComponent extends GenericComponent<ComponentValue> {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultComponent(@NotNull IContext iContext, @NotNull Node node) {
        super(iContext, node);
        b41.i(iContext, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(node, Constants.CONFIG);
    }

    @Override // com.youku.arch.v3.core.component.GenericComponent, com.youku.arch.v3.event.EventHandler
    public boolean onMessage(@NotNull String str, @Nullable Map<String, ? extends Object> map) {
        Object obj;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "74407403")) {
            return ((Boolean) ipChange.ipc$dispatch("74407403", new Object[]{this, str, map})).booleanValue();
        }
        b41.i(str, "type");
        if (b41.d(str, ComponentEvent.ON_COMPONENT_CHANGE_CONTENT)) {
            if (map == null) {
                obj = null;
            } else {
                try {
                    obj = map.get(com.youku.arch.v3.data.Constants.DISPLAY_NUM);
                } catch (Exception e) {
                    if (AppInfoProviderProxy.isDebuggable()) {
                        e.printStackTrace();
                    }
                }
            }
            if (obj != null) {
                int intValue = ((Integer) obj).intValue();
                VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter = getAdapter();
                if (adapter != null) {
                    int i = adapter.getRenderCount().get();
                    adapter.setRenderCount(intValue);
                    adapter.setRenderStart(adapter.getRenderStart() + intValue);
                    adapter.notifyItemRangeInserted(i, adapter.getItemCount() - i);
                }
                return true;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
        return super.onMessage(str, map);
    }
}
