package com.alient.onearch.adapter.view;

import android.taobao.windvane.connect.api.ApiResponse;
import android.view.View;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.alient.onearch.adapter.BaseFragment;
import com.alient.onearch.adapter.pom.BasicItemValue;
import com.alient.onearch.adapter.view.BaseViewHolder;
import com.alient.oneservice.nav.Action;
import com.youku.arch.v3.IContainer;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.adapter.VBaseAdapter;
import com.youku.arch.v3.adapter.VBaseHolder;
import com.youku.arch.v3.core.EventDispatcher;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.ModelValue;
import com.youku.arch.v3.event.ArchExceptionEvent;
import com.youku.arch.v3.event.ViewHolderEvent;
import com.youku.arch.v3.page.GenericFragment;
import com.youku.arch.v3.recyclerview.layouthelper.StaggeredGridLayoutHelper;
import com.youku.arch.v3.util.LogUtil;
import com.youku.arch.v3.util.PageUtil;
import com.youku.arch.v3.view.render.AbsRenderPlugin;
import com.youku.arch.v3.view.render.GenericRenderConfig;
import com.youku.arch.v3.view.render.OnRenderListener;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;
import tb.wt2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b$\b&\u0018\u0000 a*\b\b\u0000\u0010\u0002*\u00020\u00012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00060\u00032\u00020\u0007:\u0001aB\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b_\u0010`J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\bH\u0004J\u0016\u0010\f\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&J\b\u0010\r\u001a\u00020\bH\u0014J4\u0010\u0015\u001a\u00020\u00142\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000e2\u0006\u0010\u0013\u001a\u00020\u0012H\u0014J\u0016\u0010\u0016\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0014J\u0016\u0010\u0017\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0014J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001a\u001a\u00020\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u0018H\u0016J\b\u0010\u001c\u001a\u00020\u0018H\u0016J\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u00102\b\u0010\u001d\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u001f\u001a\u00020\bH\u0016J\b\u0010 \u001a\u00020\bH\u0016J\b\u0010!\u001a\u00020\bH\u0016J&\u0010$\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u000f2\u0014\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000eH\u0016J\u0010\u0010&\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u0012H\u0016J\u0010\u0010'\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u0012H\u0016J\b\u0010(\u001a\u00020\u0018H\u0016J\u0010\u0010*\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u0018H\u0016R\"\u0010+\u001a\u00020\u00148\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R$\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u00101R0\u00102\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u00101\u001a\u0004\b3\u00104\"\u0004\b5\u00106R$\u00108\u001a\u0004\u0018\u0001078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u0016\u0010?\u001a\u00020>8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\"\u0010A\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bA\u0010C\"\u0004\bD\u0010ER\"\u0010F\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bF\u0010B\u001a\u0004\bF\u0010C\"\u0004\bG\u0010ER\"\u0010H\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bH\u0010B\u001a\u0004\bH\u0010C\"\u0004\bI\u0010ER\"\u0010J\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bJ\u0010B\u001a\u0004\bJ\u0010C\"\u0004\bK\u0010ER\"\u0010L\u001a\u00028\u00008\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u0018\u0010T\u001a\u0004\u0018\u00010\u00108V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\bR\u0010SR\u0016\u0010W\u001a\u00020>8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\bU\u0010VR\u0016\u0010Y\u001a\u00020>8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\bX\u0010VR\u0016\u0010[\u001a\u00020>8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\bZ\u0010VR\u0016\u0010\\\u001a\u00020\u00188V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\\\u0010CR\u0016\u0010]\u001a\u00020\u00188V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b]\u0010CR\u0016\u0010^\u001a\u00020\u00188V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b^\u0010C¨\u0006b"}, d2 = {"Lcom/alient/onearch/adapter/view/BaseViewHolder;", "", ApiResponse.VALUE, "Lcom/youku/arch/v3/adapter/VBaseHolder;", "Lcom/youku/arch/v3/IItem;", "Lcom/youku/arch/v3/core/ItemValue;", "Lcom/youku/arch/v3/view/render/GenericRenderConfig;", "Lcom/alient/onearch/adapter/view/ViewCard;", "Ltb/wt2;", "initResponsiveLayoutState", "initData", "item", "bindData", "refreshData", "", "", "Lcom/alient/oneservice/nav/Action;", "actions", "Landroid/view/View;", "itemView", "Lcom/alient/onearch/adapter/view/GenericViewCard;", "createViewCard", "parseTrackInfo", "parseModelImpl", "", "enableRankInAll", "enableAutoExposeTrack", "enableAutoClickTrack", "enableAutoAction", "key", "getAction", ViewHolderEvent.ON_VIEW_ATTACHED_TO_WINDOW, ViewHolderEvent.ON_VIEW_DETACHED_FROM_WINDOW, ViewHolderEvent.ON_RECYCLED, "type", "params", "onMessage", "view", "onItemClick", "onItemLongClick", "isDegrade", "changed", "responsiveLayoutStateChanged", "viewCard", "Lcom/alient/onearch/adapter/view/GenericViewCard;", "getViewCard", "()Lcom/alient/onearch/adapter/view/GenericViewCard;", "setViewCard", "(Lcom/alient/onearch/adapter/view/GenericViewCard;)V", "Ljava/util/Map;", "componentActions", "getComponentActions", "()Ljava/util/Map;", "setComponentActions", "(Ljava/util/Map;)V", "Lcom/youku/arch/v3/view/render/OnRenderListener;", "onRenderListener", "Lcom/youku/arch/v3/view/render/OnRenderListener;", "getOnRenderListener", "()Lcom/youku/arch/v3/view/render/OnRenderListener;", "setOnRenderListener", "(Lcom/youku/arch/v3/view/render/OnRenderListener;)V", "", "currentResponsiveLayoutState", "I", "isVisible", "Z", "()Z", "setVisible", "(Z)V", "isRecycled", "setRecycled", "isSelected", "setSelected", "isPreload", "setPreload", "value", "Ljava/lang/Object;", "getValue", "()Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;)V", "getItemAction", "()Lcom/alient/oneservice/nav/Action;", "itemAction", "getModuleRank", "()I", "moduleRank", "getRankInModule", "rankInModule", "getRankInAll", "rankInAll", "isOnlyChild", "isFirstChild", "isLastChild", "<init>", "(Landroid/view/View;)V", "Companion", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes10.dex */
public abstract class BaseViewHolder<VALUE> extends VBaseHolder<IItem<ItemValue>, GenericRenderConfig> implements ViewCard {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String TAG = "OneArch.BaseViewHolder";
    @Nullable
    private Map<String, ? extends Action> actions;
    @Nullable
    private Map<String, ? extends Action> componentActions;
    private int currentResponsiveLayoutState;
    private boolean isPreload;
    private boolean isRecycled;
    private boolean isSelected;
    private boolean isVisible;
    @Nullable
    private OnRenderListener onRenderListener;
    public VALUE value;
    public GenericViewCard viewCard;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/alient/onearch/adapter/view/BaseViewHolder$Companion;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes12.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseViewHolder(@NotNull final View view) {
        super(view);
        b41.i(view, "itemView");
        view.setOnClickListener(new View.OnClickListener() { // from class: tb.qb
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BaseViewHolder.m208_init_$lambda5(BaseViewHolder.this, view, view2);
            }
        });
        view.setOnLongClickListener(new View.OnLongClickListener() { // from class: tb.rb
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view2) {
                boolean m209_init_$lambda6;
                m209_init_$lambda6 = BaseViewHolder.m209_init_$lambda6(BaseViewHolder.this, view, view2);
                return m209_init_$lambda6;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: _init_$lambda-5  reason: not valid java name */
    public static final void m208_init_$lambda5(BaseViewHolder baseViewHolder, View view, View view2) {
        b41.i(baseViewHolder, "this$0");
        b41.i(view, "$itemView");
        baseViewHolder.getViewCard().onItemClick(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: _init_$lambda-6  reason: not valid java name */
    public static final boolean m209_init_$lambda6(BaseViewHolder baseViewHolder, View view, View view2) {
        b41.i(baseViewHolder, "this$0");
        b41.i(view, "$itemView");
        baseViewHolder.getViewCard().onItemLongClick(view);
        return true;
    }

    private final void initResponsiveLayoutState() {
        GenericFragment fragment = getPageContext().getFragment();
        BaseFragment baseFragment = fragment instanceof BaseFragment ? (BaseFragment) fragment : null;
        if (baseFragment == null) {
            return;
        }
        if (this.currentResponsiveLayoutState != baseFragment.getResponsiveFragmentStateManager().a()) {
            this.currentResponsiveLayoutState = baseFragment.getResponsiveFragmentStateManager().a();
            responsiveLayoutStateChanged(true);
            return;
        }
        responsiveLayoutStateChanged(false);
    }

    public abstract void bindData(@NotNull IItem<ItemValue> iItem);

    @NotNull
    protected GenericViewCard createViewCard(@NotNull IItem<ItemValue> iItem, @Nullable Map<String, ? extends Action> map, @NotNull View view) {
        b41.i(iItem, "item");
        b41.i(view, "itemView");
        return new GenericViewCard(this, iItem, map, view);
    }

    public boolean enableAutoAction() {
        return true;
    }

    public boolean enableAutoClickTrack() {
        return true;
    }

    public boolean enableAutoExposeTrack() {
        return true;
    }

    @Override // com.alient.onearch.adapter.view.ViewCard
    public boolean enableRankInAll() {
        return false;
    }

    @Override // com.alient.onearch.adapter.view.ViewCard
    @Nullable
    public Action getAction(@Nullable String str) {
        return getViewCard().getAction(str);
    }

    @Nullable
    public final Map<String, Action> getComponentActions() {
        return this.componentActions;
    }

    @Override // com.alient.onearch.adapter.view.ViewCard
    @Nullable
    public Action getItemAction() {
        return getViewCard().getItemAction();
    }

    @Override // com.alient.onearch.adapter.view.ViewCard
    public int getModuleRank() {
        return getViewCard().getModuleRank();
    }

    @Nullable
    public final OnRenderListener getOnRenderListener() {
        return this.onRenderListener;
    }

    @Override // com.alient.onearch.adapter.view.ViewCard
    public int getRankInAll() {
        return getViewCard().getRankInAll();
    }

    @Override // com.alient.onearch.adapter.view.ViewCard
    public int getRankInModule() {
        return getViewCard().getRankInModule();
    }

    @NotNull
    public final VALUE getValue() {
        VALUE value = this.value;
        if (value != null) {
            return value;
        }
        b41.A("value");
        return (VALUE) wt2.INSTANCE;
    }

    @NotNull
    public final GenericViewCard getViewCard() {
        GenericViewCard genericViewCard = this.viewCard;
        if (genericViewCard != null) {
            return genericViewCard;
        }
        b41.A("viewCard");
        return null;
    }

    @Override // com.youku.arch.v3.adapter.VBaseHolder
    protected final void initData() {
        ItemValue property;
        JSONObject data;
        IItem<ItemValue> data2 = getData();
        if (data2 == null) {
            return;
        }
        try {
            setRecycled(false);
            parseTrackInfo(data2);
            parseModelImpl(data2);
            Map<String, ? extends Action> map = this.actions;
            View view = this.itemView;
            b41.h(view, "itemView");
            setViewCard(createViewCard(data2, map, view));
            initResponsiveLayoutState();
            bindData(data2);
            AbsRenderPlugin<IItem<ItemValue>, GenericRenderConfig> renderPlugin = getRenderPlugin();
            if (renderPlugin == null) {
                return;
            }
            renderPlugin.bindData(getContext(), data2);
        } catch (Throwable th) {
            if (!AppInfoProviderProxy.isDebuggable()) {
                VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter = data2.getComponent().getAdapter();
                String str = null;
                if ((adapter == null ? null : adapter.getLayoutHelper()) instanceof StaggeredGridLayoutHelper) {
                    removeItem();
                } else {
                    removeComponent();
                }
                StringBuilder sb = new StringBuilder();
                sb.append("initData exception type：");
                sb.append(data2.getType());
                sb.append(" data:");
                IItem<ItemValue> data3 = getData();
                if (data3 != null && (property = data3.getProperty()) != null && (data = property.getData()) != null) {
                    str = data.toJSONString();
                }
                sb.append((Object) str);
                String sb2 = sb.toString();
                LogUtil.e(TAG, sb2);
                String str2 = "page name: " + ((Object) data2.getPageContext().getPageName()) + ", item type: " + PageUtil.INSTANCE.getItemType(data2) + ", bindData occur exception：" + ((Object) LogUtil.getStackTrace(th));
                HashMap hashMap = new HashMap();
                hashMap.put("type", Integer.valueOf(data2.getType()));
                hashMap.put("errorMsg", sb2);
                hashMap.put("errorMsg", str2);
                hashMap.put("scope", "item");
                EventDispatcher eventDispatcher = data2.getPageContext().getEventDispatcher();
                if (eventDispatcher == null) {
                    return;
                }
                eventDispatcher.dispatchEvent(ArchExceptionEvent.COMPONENT_RENDER_FAILED, hashMap);
                return;
            }
            throw th;
        }
    }

    @Override // com.alient.onearch.adapter.view.ViewCard
    public boolean isDegrade() {
        IContainer<ModelValue> container;
        ModelValue property;
        JSONObject data;
        String string;
        IItem<ItemValue> data2 = getData();
        if (data2 != null && (container = data2.getContainer()) != null && (property = container.getProperty()) != null && (data = property.getData()) != null && (string = data.getString("comboDegrade")) != null) {
            try {
                if (!(string.length() == 0)) {
                    return Boolean.parseBoolean(string);
                }
            } catch (Exception e) {
                if (AppInfoProviderProxy.isDebuggable()) {
                    throw e;
                }
            }
        }
        return false;
    }

    @Override // com.alient.onearch.adapter.view.ViewCard
    public boolean isFirstChild() {
        return getViewCard().isFirstChild();
    }

    @Override // com.alient.onearch.adapter.view.ViewCard
    public boolean isLastChild() {
        return getViewCard().isLastChild();
    }

    @Override // com.alient.onearch.adapter.view.ViewCard
    public boolean isOnlyChild() {
        return getViewCard().isOnlyChild();
    }

    public final boolean isPreload() {
        return this.isPreload;
    }

    public final boolean isRecycled() {
        return this.isRecycled;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final boolean isVisible() {
        return this.isVisible;
    }

    public void onItemClick(@NotNull View view) {
        b41.i(view, "view");
    }

    @Override // com.alient.onearch.adapter.view.ViewCard
    public void onItemLongClick(@NotNull View view) {
        b41.i(view, "view");
    }

    @Override // com.youku.arch.v3.adapter.VBaseHolder, com.youku.arch.v3.event.EventHandler
    public boolean onMessage(@NotNull String str, @Nullable Map<String, ? extends Object> map) {
        Boolean bool;
        b41.i(str, "type");
        if (b41.d(ViewHolderEvent.ON_VIEW_SELECTED, str) && map != null && (bool = (Boolean) map.get("selected")) != null) {
            setSelected(bool.booleanValue());
            return true;
        }
        return super.onMessage(str, map);
    }

    @Override // com.youku.arch.v3.adapter.VBaseHolder
    public void onRecycled() {
        super.onRecycled();
        this.isRecycled = true;
    }

    @Override // com.youku.arch.v3.adapter.VBaseHolder
    public void onViewAttachedToWindow() {
        super.onViewAttachedToWindow();
        this.isVisible = true;
    }

    @Override // com.youku.arch.v3.adapter.VBaseHolder
    public void onViewDetachedFromWindow() {
        super.onViewDetachedFromWindow();
        this.isVisible = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void parseModelImpl(@NotNull IItem<ItemValue> iItem) {
        b41.i(iItem, "item");
        if (!(iItem.getProperty() instanceof BasicItemValue) || ((BasicItemValue) iItem.getProperty()).getValue() == null) {
            return;
        }
        try {
            Object value = ((BasicItemValue) iItem.getProperty()).getValue();
            if (value == null) {
                throw new NullPointerException("null cannot be cast to non-null type VALUE of com.alient.onearch.adapter.view.BaseViewHolder");
            }
            setValue(value);
        } catch (Exception e) {
            if (AppInfoProviderProxy.isDebuggable()) {
                throw new RuntimeException(e);
            }
        }
    }

    protected void parseTrackInfo(@NotNull IItem<ItemValue> iItem) {
        b41.i(iItem, "item");
        JSONObject data = iItem.getProperty().getData();
        JSONObject jSONObject = data == null ? null : data.getJSONObject("action");
        if (jSONObject != null) {
            try {
                this.actions = (Map) JSON.parseObject(jSONObject.toJSONString(), new TypeReference<HashMap<String, Action>>() { // from class: com.alient.onearch.adapter.view.BaseViewHolder$parseTrackInfo$1
                }, new Feature[0]);
            } catch (Exception e) {
                if (AppInfoProviderProxy.isDebuggable()) {
                    throw new RuntimeException(e);
                }
            }
        }
        JSONObject data2 = iItem.getComponent().getProperty().getData();
        JSONObject jSONObject2 = data2 != null ? data2.getJSONObject("action") : null;
        if (jSONObject2 != null) {
            try {
                this.componentActions = (Map) JSON.parseObject(jSONObject2.toJSONString(), new TypeReference<HashMap<String, Action>>() { // from class: com.alient.onearch.adapter.view.BaseViewHolder$parseTrackInfo$2
                }, new Feature[0]);
            } catch (Exception e2) {
                if (AppInfoProviderProxy.isDebuggable()) {
                    throw new RuntimeException(e2);
                }
            }
        }
    }

    @Override // com.youku.arch.v3.adapter.VBaseHolder
    protected void refreshData() {
        initData();
    }

    public void responsiveLayoutStateChanged(boolean z) {
    }

    public final void setComponentActions(@Nullable Map<String, ? extends Action> map) {
        this.componentActions = map;
    }

    public final void setOnRenderListener(@Nullable OnRenderListener onRenderListener) {
        this.onRenderListener = onRenderListener;
    }

    public final void setPreload(boolean z) {
        this.isPreload = z;
    }

    public final void setRecycled(boolean z) {
        this.isRecycled = z;
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }

    public final void setValue(@NotNull VALUE value) {
        b41.i(value, "<set-?>");
        this.value = value;
    }

    public final void setViewCard(@NotNull GenericViewCard genericViewCard) {
        b41.i(genericViewCard, "<set-?>");
        this.viewCard = genericViewCard;
    }

    public final void setVisible(boolean z) {
        this.isVisible = z;
    }
}
