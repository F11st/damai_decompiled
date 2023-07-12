package com.youku.arch.v3.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ConfigManager;
import com.youku.arch.v3.core.EventDispatcher;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.event.ArchExceptionEvent;
import com.youku.arch.v3.util.ArchMontior;
import com.youku.arch.v3.util.ArchMontiorManager;
import com.youku.arch.v3.util.LogUtil;
import com.youku.arch.v3.util.PageUtil;
import com.youku.arch.v3.util.PerformanceLogUtil;
import com.youku.arch.v3.util.Util;
import com.youku.arch.v3.view.render.AbsRenderPlugin;
import com.youku.arch.v3.view.render.GenericRenderConfig;
import com.youku.arch.v3.view.render.RenderPluginConfigCenter;
import com.youku.arch.v3.view.render.RenderPluginFactory;
import com.youku.middlewareservice.provider.analytics.AnalyticsProviderProxy;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import io.flutter.wpkbridge.WPKFactory;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;
import tb.wt2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \u001a2&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00050\u00040\u0001:\u0002\u001a\u001bB\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0007\u001a\u00020\u0006H\u0016J*\u0010\u000b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u0012\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\n\u001a\u00020\u0006H\u0016J*\u0010\u0011\u001a\u00020\u00102\u0018\u0010\u000e\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u000f\u001a\u00020\u0006H\u0016J\"\u0010\u0012\u001a\u00020\u00102\u0018\u0010\u000e\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\"\u0010\u0013\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\n\u001a\u00020\u0006H\u0016¨\u0006\u001c"}, d2 = {"Lcom/youku/arch/v3/adapter/VDefaultAdapter;", "Lcom/youku/arch/v3/adapter/VBaseAdapter;", "Lcom/youku/arch/v3/IItem;", "Lcom/youku/arch/v3/core/ItemValue;", "Lcom/youku/arch/v3/adapter/VBaseHolder;", "Lcom/youku/arch/v3/view/render/GenericRenderConfig;", "", "getItemCount", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "", "getPageName", "holder", "position", "Ltb/wt2;", "onBindViewHolder", "onViewRecycled", "getSafetyViewHolder", "Lcom/youku/arch/v3/adapter/ViewTypeConfig;", "getViewTypeConfig", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "<init>", "(Landroid/content/Context;)V", "Companion", "PlaceHolderViewHolder", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public class VDefaultAdapter extends VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final String TAG = "OneArch.VDefaultAdapter";

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/youku/arch/v3/adapter/VDefaultAdapter$Companion;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0006\u001a\u00020\u0005H\u0014J\b\u0010\u0007\u001a\u00020\u0005H\u0014¨\u0006\f"}, d2 = {"Lcom/youku/arch/v3/adapter/VDefaultAdapter$PlaceHolderViewHolder;", "Lcom/youku/arch/v3/adapter/VBaseHolder;", "Lcom/youku/arch/v3/IItem;", "Lcom/youku/arch/v3/core/ItemValue;", "Lcom/youku/arch/v3/view/render/GenericRenderConfig;", "Ltb/wt2;", "initData", "refreshData", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "konearch_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class PlaceHolderViewHolder extends VBaseHolder<IItem<ItemValue>, GenericRenderConfig> {
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PlaceHolderViewHolder(@NotNull View view) {
            super(view);
            b41.i(view, "itemView");
        }

        @Override // com.youku.arch.v3.adapter.VBaseHolder
        protected void initData() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1242551482")) {
                ipChange.ipc$dispatch("1242551482", new Object[]{this});
            }
        }

        @Override // com.youku.arch.v3.adapter.VBaseHolder
        protected void refreshData() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1755712369")) {
                ipChange.ipc$dispatch("1755712369", new Object[]{this});
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VDefaultAdapter(@NotNull Context context) {
        super(context);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    @Override // com.youku.arch.v3.adapter.VBaseAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1186715423")) {
            return ((Integer) ipChange.ipc$dispatch("-1186715423", new Object[]{this})).intValue();
        }
        int i = getRenderCount().get() == 0 ? this.dataCount : getRenderCount().get();
        List list = this.data;
        List list2 = null;
        if (!(list != null)) {
            list = null;
        }
        if (list != null) {
            if (i > list.size()) {
                i = list.size();
            }
            list2 = list;
        }
        if (list2 == null) {
            return 0;
        }
        return i;
    }

    @Nullable
    public String getPageName(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-383834461")) {
            return (String) ipChange.ipc$dispatch("-383834461", new Object[]{this, Integer.valueOf(i)});
        }
        ConfigManager configManager = getPageContext().getConfigManager();
        if (configManager == null) {
            return null;
        }
        return configManager.getPathConfig(ConfigManager.COMPONENT_CONFIG_FILE);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.youku.arch.v3.adapter.VBaseHolder<com.youku.arch.v3.IItem<com.youku.arch.v3.core.ItemValue>, com.youku.arch.v3.view.render.GenericRenderConfig> getSafetyViewHolder(int r11) {
        /*
            r10 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = com.youku.arch.v3.adapter.VDefaultAdapter.$ipChange
            java.lang.String r1 = "-2138911631"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L1e
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r4] = r10
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r2[r3] = r11
            java.lang.Object r11 = r0.ipc$dispatch(r1, r2)
            com.youku.arch.v3.adapter.VBaseHolder r11 = (com.youku.arch.v3.adapter.VBaseHolder) r11
            return r11
        L1e:
            r0 = 0
            com.youku.arch.v3.view.render.DefaultViewHolder r1 = new com.youku.arch.v3.view.render.DefaultViewHolder     // Catch: java.lang.Throwable -> L3e
            android.widget.FrameLayout r2 = new android.widget.FrameLayout     // Catch: java.lang.Throwable -> L3e
            android.content.Context r5 = r10.getContext()     // Catch: java.lang.Throwable -> L3e
            r2.<init>(r5)     // Catch: java.lang.Throwable -> L3e
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L3e
            com.youku.arch.v3.core.IContext r0 = r10.getPageContext()     // Catch: java.lang.Throwable -> L3c
            r1.setPageContext(r0)     // Catch: java.lang.Throwable -> L3c
            android.content.Context r0 = r10.getContext()     // Catch: java.lang.Throwable -> L3c
            r1.setContext(r0)     // Catch: java.lang.Throwable -> L3c
            goto L98
        L3c:
            r0 = move-exception
            goto L42
        L3e:
            r1 = move-exception
            r9 = r1
            r1 = r0
            r0 = r9
        L42:
            java.lang.Object[] r2 = new java.lang.Object[r3]
            java.lang.String r3 = r0.getMessage()
            java.lang.String r5 = "getSafetyViewHolder: "
            java.lang.String r3 = tb.b41.r(r5, r3)
            r2[r4] = r3
            java.lang.String r3 = "OneArch.VDefaultAdapter"
            com.youku.arch.v3.util.LogUtil.e(r3, r2)
            com.youku.arch.v3.adapter.ViewTypeConfig r2 = r10.getViewTypeConfig(r11)
            java.util.HashMap r8 = new java.util.HashMap
            r8.<init>()
            java.lang.String r0 = r0.getMessage()
            java.lang.String r3 = "error"
            r8.put(r3, r0)
            java.lang.String r0 = "null"
            if (r2 != 0) goto L6d
        L6b:
            r2 = r0
            goto L74
        L6d:
            java.lang.String r2 = r2.toLogString()
            if (r2 != 0) goto L74
            goto L6b
        L74:
            java.lang.String r3 = "config"
            r8.put(r3, r2)
            if (r1 != 0) goto L7c
            goto L84
        L7c:
            java.lang.Class r0 = r1.getClass()
            java.lang.String r0 = r0.getName()
        L84:
            java.lang.String r2 = "holder"
            r8.put(r2, r0)
            r4 = 19999(0x4e1f, float:2.8025E-41)
            java.lang.String r7 = java.lang.String.valueOf(r11)
            java.lang.String r3 = "NULL_VIEW_HOLDER"
            java.lang.String r5 = "GOT_ERROR"
            java.lang.String r6 = ""
            com.youku.middlewareservice.provider.analytics.AnalyticsProviderProxy.utCustomEvent(r3, r4, r5, r6, r7, r8)
        L98:
            if (r1 != 0) goto La8
            com.youku.arch.v3.adapter.VDefaultAdapter$PlaceHolderViewHolder r1 = new com.youku.arch.v3.adapter.VDefaultAdapter$PlaceHolderViewHolder
            android.widget.FrameLayout r11 = new android.widget.FrameLayout
            android.content.Context r0 = r10.getContext()
            r11.<init>(r0)
            r1.<init>(r11)
        La8:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.arch.v3.adapter.VDefaultAdapter.getSafetyViewHolder(int):com.youku.arch.v3.adapter.VBaseHolder");
    }

    @Nullable
    public ViewTypeConfig getViewTypeConfig(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1421036115")) {
            return (ViewTypeConfig) ipChange.ipc$dispatch("1421036115", new Object[]{this, Integer.valueOf(i)});
        }
        ViewTypeSupport viewTypeSupport = getViewTypeSupport();
        if (viewTypeSupport == null) {
            return null;
        }
        return viewTypeSupport.getViewTypeConfig(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull VBaseHolder<IItem<ItemValue>, GenericRenderConfig> vBaseHolder, int i) {
        ArchMontior archMontior;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2085180497")) {
            ipChange.ipc$dispatch("-2085180497", new Object[]{this, vBaseHolder, Integer.valueOf(i)});
            return;
        }
        b41.i(vBaseHolder, "holder");
        List<DATA> list = this.data;
        if (list != 0) {
            IItem<ItemValue> iItem = (IItem) list.get((i + getRenderStart()) % list.size());
            Util.throwIfNull(iItem);
            iItem.setEventHandler(vBaseHolder);
            long currentTimeMillis = System.currentTimeMillis();
            String pageName = getPageContext().getPageName();
            if (AppInfoProviderProxy.isDebuggable()) {
                PerformanceLogUtil.INSTANCE.markStartPoint(b41.r("bindData type=", Integer.valueOf(PageUtil.INSTANCE.getItemType(iItem))));
            }
            vBaseHolder.setPageContext(getPageContext());
            vBaseHolder.setContext(getContext());
            vBaseHolder.setData(iItem);
            if (AppInfoProviderProxy.isDebuggable()) {
                PerformanceLogUtil.INSTANCE.markEndPoint(b41.r("bindData type=", Integer.valueOf(PageUtil.INSTANCE.getItemType(iItem))));
            }
            if (pageName != null && (archMontior = ArchMontiorManager.Companion.get(pageName)) != null) {
                archMontior.setBindTime(String.valueOf(vBaseHolder.getItemViewType()), System.currentTimeMillis() - currentTimeMillis);
            }
        }
        AnalyticsProviderProxy.scanView(vBaseHolder.itemView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public VBaseHolder<IItem<ItemValue>, GenericRenderConfig> onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        ArchMontior archMontior;
        VBaseHolder<IItem<ItemValue>, GenericRenderConfig> vBaseHolder;
        ArchMontior archMontior2;
        VBaseHolder<IItem<ItemValue>, GenericRenderConfig> vBaseHolder2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1114686951")) {
            return (VBaseHolder) ipChange.ipc$dispatch("1114686951", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        b41.i(viewGroup, "parent");
        ViewTypeConfig viewTypeConfig = getViewTypeConfig(i);
        VBaseHolder<IItem<ItemValue>, GenericRenderConfig> vBaseHolder3 = null;
        if (viewTypeConfig != null) {
            GenericRenderConfig genericRenderConfig = new GenericRenderConfig();
            genericRenderConfig.setType(String.valueOf(i));
            genericRenderConfig.setMClassName(viewTypeConfig.getModel());
            genericRenderConfig.setMClassNameOpt(viewTypeConfig.getModelOpt());
            genericRenderConfig.setVClassName(viewTypeConfig.getView());
            genericRenderConfig.setVClassNameOpt(viewTypeConfig.getViewOpt());
            genericRenderConfig.setPClassName(viewTypeConfig.getPresenter());
            genericRenderConfig.setPClassNameOpt(viewTypeConfig.getPresenterOpt());
            genericRenderConfig.setLayoutId(viewTypeConfig.getLayoutResId());
            genericRenderConfig.setLayoutIdOpt(viewTypeConfig.getLayoutResIdOpt());
            genericRenderConfig.setLayoutStr(viewTypeConfig.getLayoutResString());
            genericRenderConfig.setLayoutStrOpt(viewTypeConfig.getLayoutResStringOpt());
            genericRenderConfig.setExtra(viewTypeConfig.wrapParams(genericRenderConfig.getExtra()));
            String pageName = getPageName(i);
            if (AppInfoProviderProxy.isDebuggable()) {
                PerformanceLogUtil.INSTANCE.markStartPoint(b41.r("createViewHolder type: ", Integer.valueOf(PageUtil.INSTANCE.getItemTypeByConfig(genericRenderConfig))));
            }
            RenderPluginConfigCenter.Companion companion = RenderPluginConfigCenter.Companion;
            if (companion.getInstance().isSupportRenderPlugin(getPageContext(), pageName, String.valueOf(i))) {
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    RenderPluginFactory renderPluginFactory = companion.getInstance().getRenderPluginFactory(pageName, String.valueOf(i));
                    AbsRenderPlugin<IItem<ItemValue>, GenericRenderConfig> create = renderPluginFactory == null ? null : renderPluginFactory.create();
                    AbsRenderPlugin<IItem<ItemValue>, GenericRenderConfig> absRenderPlugin = create instanceof AbsRenderPlugin ? create : null;
                    if (absRenderPlugin != null) {
                        absRenderPlugin.attachContext(getPageContext());
                    }
                    View createView = absRenderPlugin == null ? null : absRenderPlugin.createView(getContext(), genericRenderConfig, viewGroup);
                    Class<?> viewHolderClass = viewTypeConfig.getViewHolderClass();
                    Constructor<?> constructor = viewHolderClass == null ? null : viewHolderClass.getConstructor(View.class);
                    if (!(constructor instanceof Constructor)) {
                        constructor = null;
                    }
                    if (constructor != null && (vBaseHolder2 = (VBaseHolder) constructor.newInstance(createView)) != null) {
                        vBaseHolder2.setPageContext(getPageContext());
                        vBaseHolder2.setContext(getContext());
                        vBaseHolder2.setRenderPlugin(absRenderPlugin);
                        wt2 wt2Var = wt2.INSTANCE;
                        vBaseHolder3 = vBaseHolder2;
                    }
                } catch (Exception unused) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("type", Integer.valueOf(i));
                    hashMap.put("mvp", "layoutStr " + ((Object) genericRenderConfig.getLayoutStr()) + " mClassName " + ((Object) genericRenderConfig.getMClassName()) + " pClassName " + ((Object) genericRenderConfig.getPClassName()) + " vClassName " + ((Object) genericRenderConfig.getVClassName()));
                    if (AppInfoProviderProxy.isDebuggable()) {
                        LogUtil.e(TAG, hashMap.toString());
                    } else {
                        EventDispatcher eventDispatcher = getPageContext().getEventDispatcher();
                        if (eventDispatcher != null) {
                            eventDispatcher.dispatchEvent(ArchExceptionEvent.COMPONENT_RENDER_FAILED, hashMap);
                        }
                    }
                }
                String pageName2 = getPageContext().getPageName();
                if (pageName2 != null && (archMontior2 = ArchMontiorManager.Companion.get(pageName2)) != null) {
                    archMontior2.setRenderTime(String.valueOf(i), System.currentTimeMillis() - currentTimeMillis);
                }
            } else {
                long currentTimeMillis2 = System.currentTimeMillis();
                try {
                    Integer layoutId = genericRenderConfig.getLayoutId();
                    if (!(layoutId != null && layoutId.intValue() > 0)) {
                        layoutId = null;
                    }
                    if (layoutId != null) {
                        View inflate = LayoutInflater.from(getContext()).inflate(layoutId.intValue(), viewGroup, false);
                        Class<?> viewHolderClass2 = viewTypeConfig.getViewHolderClass();
                        Constructor<?> constructor2 = viewHolderClass2 == null ? null : viewHolderClass2.getConstructor(View.class);
                        if (!(constructor2 instanceof Constructor)) {
                            constructor2 = null;
                        }
                        if (constructor2 != null && (vBaseHolder = (VBaseHolder) constructor2.newInstance(inflate)) != null) {
                            vBaseHolder.setPageContext(getPageContext());
                            vBaseHolder.setContext(getContext());
                            wt2 wt2Var2 = wt2.INSTANCE;
                            vBaseHolder3 = vBaseHolder;
                        }
                    }
                } catch (Exception unused2) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("type", Integer.valueOf(i));
                    hashMap2.put("viewHolderClass", b41.r("viewHolderClass ", viewTypeConfig.getViewHolderClass()));
                    if (AppInfoProviderProxy.isDebuggable()) {
                        LogUtil.e(TAG, hashMap2.toString());
                    } else {
                        EventDispatcher eventDispatcher2 = getPageContext().getEventDispatcher();
                        if (eventDispatcher2 != null) {
                            eventDispatcher2.dispatchEvent(ArchExceptionEvent.COMPONENT_RENDER_FAILED, hashMap2);
                        }
                    }
                }
                String pageName3 = getPageContext().getPageName();
                if (pageName3 != null && (archMontior = ArchMontiorManager.Companion.get(pageName3)) != null) {
                    archMontior.setRenderTime(String.valueOf(i), System.currentTimeMillis() - currentTimeMillis2);
                }
            }
            if (AppInfoProviderProxy.isDebuggable()) {
                PerformanceLogUtil.INSTANCE.markEndPoint(b41.r("createViewHolder type: ", Integer.valueOf(PageUtil.INSTANCE.getItemTypeByConfig(genericRenderConfig))));
            }
        } else {
            if (AppInfoProviderProxy.isDebuggable()) {
                Toast.makeText(getContext(), b41.r("not support viewType：", Integer.valueOf(i)), 0).show();
            }
            HashMap hashMap3 = new HashMap();
            hashMap3.put("type", Integer.valueOf(i));
            EventDispatcher eventDispatcher3 = getPageContext().getEventDispatcher();
            if (eventDispatcher3 != null) {
                eventDispatcher3.dispatchEvent(ArchExceptionEvent.COMPONENT_NOT_SUPPORT, hashMap3);
            }
        }
        if (vBaseHolder3 != null) {
            vBaseHolder3.setContext(getContext());
        }
        if (vBaseHolder3 != null) {
            vBaseHolder3.onCreate();
        }
        return vBaseHolder3 == null ? getSafetyViewHolder(i) : vBaseHolder3;
    }

    @Override // com.youku.arch.v3.adapter.VBaseAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(@NotNull VBaseHolder<IItem<ItemValue>, GenericRenderConfig> vBaseHolder) {
        IItem<ItemValue> data;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-822954756")) {
            ipChange.ipc$dispatch("-822954756", new Object[]{this, vBaseHolder});
            return;
        }
        b41.i(vBaseHolder, "holder");
        super.onViewRecycled((VDefaultAdapter) vBaseHolder);
        if (vBaseHolder.getData() == null || (data = vBaseHolder.getData()) == null) {
            return;
        }
        data.setEventHandler(null);
    }
}
