package com.youku.arch.v3.view.render;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.IModule;
import com.youku.arch.v3.adapter.VBaseAdapter;
import com.youku.arch.v3.adapter.VBaseHolder;
import com.youku.arch.v3.core.Coordinate;
import com.youku.arch.v3.core.EventDispatcher;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.ModuleValue;
import com.youku.arch.v3.data.Constants;
import com.youku.arch.v3.event.ArchExceptionEvent;
import com.youku.arch.v3.event.ViewHolderEvent;
import com.youku.arch.v3.recyclerview.layouthelper.StaggeredGridLayoutHelper;
import com.youku.arch.v3.util.LogUtil;
import com.youku.arch.v3.util.PageUtil;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;
import tb.wt2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 42\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u00012\u00020\u0005:\u00014B\u000f\u0012\u0006\u00101\u001a\u00020\u0013¢\u0006\u0004\b2\u00103J$\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bH\u0002J\b\u0010\r\u001a\u00020\u000bH\u0014J\b\u0010\u000e\u001a\u00020\u000bH\u0016J&\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0016J$\u0010\u0015\u001a\u00020\u000b2\u0010\u0010\u0012\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J4\u0010\u001a\u001a\u00020\u000b2\u0010\u0010\u0012\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J.\u0010\u001d\u001a\u00020\u000b2\u0010\u0010\u0012\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J4\u0010\u001e\u001a\u00020\u000b2\u0010\u0010\u0012\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0016JB\u0010 \u001a\u00020\u000b2\u0010\u0010\u0012\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001f\u001a\u00020\u00062\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0016J4\u0010\u001a\u001a\u00020\u000b2\u0010\u0010\u0012\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00112\b\u0010\"\u001a\u0004\u0018\u00010!2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J\b\u0010#\u001a\u00020\u000bH\u0016J\b\u0010$\u001a\u00020\u000bH\u0016J\b\u0010%\u001a\u00020\u000bH\u0016J\b\u0010&\u001a\u00020\u000bH\u0016J\b\u0010'\u001a\u00020\u000bH\u0016RL\u0010\u0012\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00112\u001a\u0010\u0012\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00118V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001b\u00100\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,8F@\u0006¢\u0006\u0006\u001a\u0004\b.\u0010/¨\u00065"}, d2 = {"Lcom/youku/arch/v3/view/render/DefaultViewHolder;", "Lcom/youku/arch/v3/adapter/VBaseHolder;", "Lcom/youku/arch/v3/IItem;", "Lcom/youku/arch/v3/core/ItemValue;", "Lcom/youku/arch/v3/view/render/GenericRenderConfig;", "Lcom/youku/arch/v3/view/render/OnRenderListener;", "", "type", "", "", "params", "Ltb/wt2;", "dispatchEvent", "initData", "refreshData", "", "onMessage", "Lcom/youku/arch/v3/view/render/AbsRenderPlugin;", "renderPlugin", "Landroid/view/View;", "instance", "onRenderStart", "renderView", "", "width", "height", "onRenderSuccess", "Lcom/youku/arch/v3/view/render/RenderError;", "error", "onRenderFailed", "onLayoutChanged", "eventName", "onReceiveEvent", "Landroidx/fragment/app/Fragment;", "renderFragment", "onRenderDestroy", "onCreate", ViewHolderEvent.ON_VIEW_ATTACHED_TO_WINDOW, ViewHolderEvent.ON_VIEW_DETACHED_FROM_WINDOW, ViewHolderEvent.ON_RECYCLED, "getRenderPlugin", "()Lcom/youku/arch/v3/view/render/AbsRenderPlugin;", "setRenderPlugin", "(Lcom/youku/arch/v3/view/render/AbsRenderPlugin;)V", "Lcom/youku/arch/v3/IModule;", "Lcom/youku/arch/v3/core/ModuleValue;", "getModule", "()Lcom/youku/arch/v3/IModule;", "module", "itemView", "<init>", "(Landroid/view/View;)V", "Companion", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public class DefaultViewHolder extends VBaseHolder<IItem<ItemValue>, GenericRenderConfig> implements OnRenderListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final String TAG = "OneArch.DefaultViewHolder";

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ0\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002R\u0016\u0010\f\u001a\u00020\u00058\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/youku/arch/v3/view/render/DefaultViewHolder$Companion;", "", "Lcom/youku/arch/v3/IItem;", "Lcom/youku/arch/v3/core/ItemValue;", "item", "", "scope", "", "indexes", "", "Lcom/youku/arch/v3/core/Coordinate;", "getTargetCoordinate", "TAG", "Ljava/lang/String;", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private static transient /* synthetic */ IpChange $ipChange;

        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<Coordinate> getTargetCoordinate(IItem<ItemValue> iItem, String str, int[] iArr) {
            IpChange ipChange = $ipChange;
            int i = 0;
            if (AndroidInstantRuntime.support(ipChange, "1684854477")) {
                return (List) ipChange.ipc$dispatch("1684854477", new Object[]{this, iItem, str, iArr});
            }
            ArrayList arrayList = new ArrayList();
            int hashCode = str.hashCode();
            if (hashCode == -1399907075) {
                if (str.equals("component")) {
                    if (iArr != null && iItem != null) {
                        int length = iArr.length;
                        while (i < length) {
                            int i2 = iArr[i];
                            i++;
                            Coordinate coordinate = new Coordinate(iItem.getCoordinate());
                            coordinate.setItemIndex(-2);
                            coordinate.setComponentIndex(i2);
                            arrayList.add(coordinate);
                        }
                    }
                }
                arrayList.add(new Coordinate(-2, -2, -2));
            } else if (hashCode == -1068784020) {
                if (str.equals("module")) {
                    if (iArr != null) {
                        int length2 = iArr.length;
                        while (i < length2) {
                            int i3 = iArr[i];
                            i++;
                            arrayList.add(new Coordinate(i3, -2, -2));
                        }
                    }
                }
                arrayList.add(new Coordinate(-2, -2, -2));
            } else {
                if (hashCode == 3242771 && str.equals("item")) {
                    if (iArr != null && iItem != null) {
                        int length3 = iArr.length;
                        while (i < length3) {
                            int i4 = iArr[i];
                            i++;
                            Coordinate coordinate2 = new Coordinate(iItem.getCoordinate());
                            coordinate2.setItemIndex(i4);
                            arrayList.add(coordinate2);
                        }
                    }
                }
                arrayList.add(new Coordinate(-2, -2, -2));
            }
            return arrayList;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultViewHolder(@NotNull View view) {
        super(view);
        b41.i(view, "itemView");
    }

    private final void dispatchEvent(String str, Map<String, ? extends Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-10177980")) {
            ipChange.ipc$dispatch("-10177980", new Object[]{this, str, map});
            return;
        }
        String valueOf = map.get(Constants.RouterProtocol.SCOPE) != null ? String.valueOf(map.get(Constants.RouterProtocol.SCOPE)) : "container";
        Object obj = map.get(Constants.RouterProtocol.INDEXES);
        int[] iArr = obj instanceof int[] ? (int[]) obj : null;
        Object obj2 = map.get(Constants.RouterProtocol.DATA);
        IItem iItem = obj2 instanceof IItem ? (IItem) obj2 : null;
        if (iItem == null) {
            return;
        }
        List<Coordinate> targetCoordinate = Companion.getTargetCoordinate(iItem, valueOf, iArr);
        EventDispatcher eventDispatcher = iItem.getPageContext().getEventDispatcher();
        if (eventDispatcher == null) {
            return;
        }
        eventDispatcher.dispatchEvent(targetCoordinate, str, map);
    }

    @Nullable
    public final IModule<ModuleValue> getModule() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-768477794")) {
            return (IModule) ipChange.ipc$dispatch("-768477794", new Object[]{this});
        }
        IItem<ItemValue> data = getData();
        if (data == null) {
            return null;
        }
        return data.getModule();
    }

    @Override // com.youku.arch.v3.adapter.VBaseHolder
    @Nullable
    public AbsRenderPlugin<IItem<ItemValue>, GenericRenderConfig> getRenderPlugin() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-46739158") ? (AbsRenderPlugin) ipChange.ipc$dispatch("-46739158", new Object[]{this}) : super.getRenderPlugin();
    }

    @Override // com.youku.arch.v3.adapter.VBaseHolder
    protected void initData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1903896775")) {
            ipChange.ipc$dispatch("-1903896775", new Object[]{this});
            return;
        }
        IItem<ItemValue> data = getData();
        if (data == null) {
            return;
        }
        try {
            AbsRenderPlugin<IItem<ItemValue>, GenericRenderConfig> renderPlugin = getRenderPlugin();
            if (renderPlugin == null) {
                return;
            }
            renderPlugin.bindData(getContext(), data);
            wt2 wt2Var = wt2.INSTANCE;
        } catch (Throwable th) {
            VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter = data.getComponent().getAdapter();
            if ((adapter == null ? null : adapter.getLayoutHelper()) instanceof StaggeredGridLayoutHelper) {
                removeItem();
            } else {
                removeComponent();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("page name: ");
            sb.append((Object) data.getPageContext().getPageName());
            sb.append(", item type: ");
            PageUtil pageUtil = PageUtil.INSTANCE;
            sb.append(pageUtil.getItemType(data));
            sb.append(", bindData occur exception：");
            sb.append((Object) LogUtil.getStackTrace(th));
            String sb2 = sb.toString();
            if (AppInfoProviderProxy.isDebuggable()) {
                LogUtil.e(TAG, sb2);
                wt2 wt2Var2 = wt2.INSTANCE;
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("type", Integer.valueOf(pageUtil.getItemType(data)));
            hashMap.put("scope", "item");
            hashMap.put("errorMsg", sb2);
            EventDispatcher eventDispatcher = getPageContext().getEventDispatcher();
            if (eventDispatcher == null) {
                return;
            }
            eventDispatcher.dispatchEvent(ArchExceptionEvent.COMPONENT_RENDER_FAILED, hashMap);
            wt2 wt2Var3 = wt2.INSTANCE;
        }
    }

    @Override // com.youku.arch.v3.adapter.VBaseHolder
    public void onCreate() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "195406008")) {
            ipChange.ipc$dispatch("195406008", new Object[]{this});
        } else {
            onMessage(ViewHolderEvent.ON_VIEW_CREATE, null);
        }
    }

    @Override // com.youku.arch.v3.view.render.OnRenderListener
    public void onLayoutChanged(@Nullable AbsRenderPlugin<?, ?> absRenderPlugin, @Nullable View view, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-452687684")) {
            ipChange.ipc$dispatch("-452687684", new Object[]{this, absRenderPlugin, view, Integer.valueOf(i), Integer.valueOf(i2)});
        }
    }

    @Override // com.youku.arch.v3.adapter.VBaseHolder, com.youku.arch.v3.event.EventHandler
    public boolean onMessage(@NotNull String str, @Nullable Map<String, ? extends Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2067839952")) {
            return ((Boolean) ipChange.ipc$dispatch("-2067839952", new Object[]{this, str, map})).booleanValue();
        }
        b41.i(str, "type");
        AbsRenderPlugin<IItem<ItemValue>, GenericRenderConfig> renderPlugin = getRenderPlugin();
        if (renderPlugin != null) {
            renderPlugin.fireEvent(str, map);
        }
        return false;
    }

    @Override // com.youku.arch.v3.view.render.OnRenderListener
    public void onReceiveEvent(@Nullable AbsRenderPlugin<?, ?> absRenderPlugin, @Nullable View view, @NotNull String str, @Nullable Map<String, ? extends Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-63839666")) {
            ipChange.ipc$dispatch("-63839666", new Object[]{this, absRenderPlugin, view, str, map});
            return;
        }
        b41.i(str, "eventName");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (map != null) {
            linkedHashMap.putAll(map);
        }
        IItem<ItemValue> data = getData();
        if (data != null) {
            linkedHashMap.put(Constants.RouterProtocol.DATA, data);
        }
        dispatchEvent(str, linkedHashMap);
    }

    @Override // com.youku.arch.v3.adapter.VBaseHolder
    public void onRecycled() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "725298595")) {
            ipChange.ipc$dispatch("725298595", new Object[]{this});
            return;
        }
        onMessage(ViewHolderEvent.ON_RECYCLED, null);
        AbsRenderPlugin<IItem<ItemValue>, GenericRenderConfig> renderPlugin = getRenderPlugin();
        if (renderPlugin == null) {
            return;
        }
        renderPlugin.destroyRenderPlugin();
    }

    @Override // com.youku.arch.v3.view.render.OnRenderListener
    public void onRenderDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1840928466")) {
            ipChange.ipc$dispatch("1840928466", new Object[]{this});
        } else if (AppInfoProviderProxy.isDebuggable()) {
            LogUtil.d(TAG, "onRenderDestroy");
        }
    }

    @Override // com.youku.arch.v3.view.render.OnRenderListener
    public void onRenderFailed(@Nullable AbsRenderPlugin<?, ?> absRenderPlugin, @Nullable View view, @Nullable RenderError renderError) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1420613958")) {
            ipChange.ipc$dispatch("-1420613958", new Object[]{this, absRenderPlugin, view, renderError});
        } else if (AppInfoProviderProxy.isDebuggable()) {
            Object[] objArr = new Object[1];
            objArr[0] = b41.r("onRenderFailed ", renderError == null ? null : renderError.getErrorMsg());
            LogUtil.d(TAG, objArr);
        }
    }

    @Override // com.youku.arch.v3.view.render.OnRenderListener
    public void onRenderStart(@Nullable AbsRenderPlugin<?, ?> absRenderPlugin, @Nullable View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "193013914")) {
            ipChange.ipc$dispatch("193013914", new Object[]{this, absRenderPlugin, view});
        }
    }

    @Override // com.youku.arch.v3.view.render.OnRenderListener
    public void onRenderSuccess(@Nullable AbsRenderPlugin<?, ?> absRenderPlugin, @Nullable View view, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-721742343")) {
            ipChange.ipc$dispatch("-721742343", new Object[]{this, absRenderPlugin, view, Integer.valueOf(i), Integer.valueOf(i2)});
        }
    }

    @Override // com.youku.arch.v3.view.render.OnRenderListener
    public void onRenderSuccess(@Nullable AbsRenderPlugin<?, ?> absRenderPlugin, @Nullable Fragment fragment, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "435605873")) {
            ipChange.ipc$dispatch("435605873", new Object[]{this, absRenderPlugin, fragment, Integer.valueOf(i), Integer.valueOf(i2)});
        }
    }

    @Override // com.youku.arch.v3.adapter.VBaseHolder
    public void onViewAttachedToWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-35536992")) {
            ipChange.ipc$dispatch("-35536992", new Object[]{this});
        } else {
            onMessage(ViewHolderEvent.ON_VIEW_ATTACHED_TO_WINDOW, null);
        }
    }

    @Override // com.youku.arch.v3.adapter.VBaseHolder
    public void onViewDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-700862781")) {
            ipChange.ipc$dispatch("-700862781", new Object[]{this});
        } else {
            onMessage(ViewHolderEvent.ON_VIEW_DETACHED_FROM_WINDOW, null);
        }
    }

    @Override // com.youku.arch.v3.adapter.VBaseHolder
    public void refreshData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-718044014")) {
            ipChange.ipc$dispatch("-718044014", new Object[]{this});
        } else {
            initData();
        }
    }

    @Override // com.youku.arch.v3.adapter.VBaseHolder
    public void setRenderPlugin(@Nullable AbsRenderPlugin<IItem<ItemValue>, GenericRenderConfig> absRenderPlugin) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1077287702")) {
            ipChange.ipc$dispatch("1077287702", new Object[]{this, absRenderPlugin});
            return;
        }
        super.setRenderPlugin(absRenderPlugin);
        if (absRenderPlugin == null) {
            return;
        }
        absRenderPlugin.setOnRenderListener(this);
    }
}
