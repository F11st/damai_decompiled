package com.youku.arch.v3.adapter;

import android.app.Application;
import android.content.Context;
import android.util.SparseArray;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.TypeRange;
import com.youku.arch.v3.data.Constants;
import com.youku.arch.v3.util.LogUtil;
import com.youku.arch.v3.util.PerformanceLogUtil;
import com.youku.arch.v3.util.ReflectionUtil;
import com.youku.arch.v3.util.ViewUtil;
import com.youku.arch.v3.view.config.ComponentConfigBean;
import com.youku.arch.v3.view.config.ComponentConfigManager;
import com.youku.middlewareservice.provider.config.OneConfigProviderProxy;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import io.flutter.wpkbridge.WPKFactory;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;
import tb.wt2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0016\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0011\b\u0016\u0012\u0006\u0010(\u001a\u00020'¢\u0006\u0004\b)\u0010*B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b)\u0010+J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J4\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0016\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016R\u0016\u0010\u0019\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001c\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u001eR\u001f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000f0\u001f8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0016\u0010%\u001a\u00020$8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006-"}, d2 = {"Lcom/youku/arch/v3/adapter/ViewTypeSupport;", "", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Lcom/youku/arch/v3/view/config/ComponentConfigBean;", "componentConfig", "Ltb/wt2;", "initViewConfig", "Lcom/youku/arch/v3/view/config/ComponentConfigBean$ComponentBean;", "componentBean", "Lcom/youku/arch/v3/view/config/ComponentConfigBean$ComponentBean$ItemBean;", "itemBean", "", "isComponent", "isEnableLazyParser", "Lcom/youku/arch/v3/adapter/ViewTypeConfig;", "createViewTypeConfig", "", "type", "getViewTypeConfig", "Lcom/youku/arch/v3/core/TypeRange;", "typeRange", "Lcom/youku/arch/v3/adapter/ViewTypeConfigCreator;", "viewTypeConfigCreator", "registerViewTypeConfigCreator", "defaultLayoutResId", "I", "Ljava/lang/Class;", "defaultHolderClass", "Ljava/lang/Class;", "Lcom/youku/arch/v3/view/config/ComponentConfigBean;", "Landroid/util/SparseArray;", "viewTypeConfigs", "Landroid/util/SparseArray;", "getViewTypeConfigs", "()Landroid/util/SparseArray;", "Lcom/youku/arch/v3/adapter/ViewTypeConfigCreatorManager;", "viewTypeConfigCreatorManager", "Lcom/youku/arch/v3/adapter/ViewTypeConfigCreatorManager;", "", "componentConfigPath", "<init>", "(Ljava/lang/String;)V", "(Lcom/youku/arch/v3/view/config/ComponentConfigBean;)V", "Companion", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public class ViewTypeSupport {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final HashMap<String, ViewTypeSupport> instances = new HashMap<>();
    @Nullable
    private ComponentConfigBean componentConfig;
    @Nullable
    private Class<?> defaultHolderClass;
    private int defaultLayoutResId;
    @NotNull
    private final ViewTypeConfigCreatorManager viewTypeConfigCreatorManager;
    @NotNull
    private final SparseArray<ViewTypeConfig> viewTypeConfigs;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0013\u0010\u0007\u001a\u00020\u00068F@\u0006¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR2\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\tj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004`\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/youku/arch/v3/adapter/ViewTypeSupport$Companion;", "", "", "componentConfigPath", "Lcom/youku/arch/v3/adapter/ViewTypeSupport;", "getInstance", "", "isEnableViewTypeConfigLazyParser", "()Z", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "instances", "Ljava/util/HashMap;", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private static transient /* synthetic */ IpChange $ipChange;

        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }

        @Nullable
        public final ViewTypeSupport getInstance(@NotNull String str) {
            Object obj;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "745236463")) {
                return (ViewTypeSupport) ipChange.ipc$dispatch("745236463", new Object[]{this, str});
            }
            b41.i(str, "componentConfigPath");
            synchronized (ViewTypeSupport.instances) {
                obj = ViewTypeSupport.instances.get(str);
                if (obj == null) {
                    obj = new ViewTypeSupport(str);
                    ViewTypeSupport.instances.put(str, obj);
                    wt2 wt2Var = wt2.INSTANCE;
                }
                wt2 wt2Var2 = wt2.INSTANCE;
            }
            return (ViewTypeSupport) obj;
        }

        public final boolean isEnableViewTypeConfigLazyParser() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "30902251")) {
                return ((Boolean) ipChange.ipc$dispatch("30902251", new Object[]{this})).booleanValue();
            }
            boolean config = OneConfigProviderProxy.getConfig("onearch_configures", "lazyTranslateResourceId", true);
            if (AppInfoProviderProxy.isDebuggable()) {
                LogUtil.w("createViewConfig", b41.r("isEnableViewTypeConfigLazyParser: v = ", Boolean.valueOf(config)));
            }
            return config;
        }
    }

    public ViewTypeSupport(@NotNull String str) {
        b41.i(str, "componentConfigPath");
        this.viewTypeConfigs = new SparseArray<>(160);
        this.viewTypeConfigCreatorManager = new ViewTypeConfigCreatorManager();
        Application application = AppInfoProviderProxy.getApplication();
        b41.h(application, "getApplication()");
        this.defaultLayoutResId = ViewUtil.getIdentifier(application, Constants.RES_DEFAULT_LAYOUT, "layout");
        this.defaultHolderClass = ReflectionUtil.INSTANCE.tryGetClassForName(Constants.CLASS_DEFAULT_VIEW_HOLDER);
        ComponentConfigBean componentConfig = ComponentConfigManager.Companion.getInstance().getComponentConfig(application, str);
        if (componentConfig == null) {
            return;
        }
        this.componentConfig = componentConfig;
        initViewConfig(application, componentConfig);
    }

    private final ViewTypeConfig createViewTypeConfig(Context context, ComponentConfigBean.ComponentBean componentBean, ComponentConfigBean.ComponentBean.ItemBean itemBean, boolean z, boolean z2) {
        IpChange ipChange = $ipChange;
        boolean z3 = true;
        if (AndroidInstantRuntime.support(ipChange, "544068787")) {
            return (ViewTypeConfig) ipChange.ipc$dispatch("544068787", new Object[]{this, context, componentBean, itemBean, Boolean.valueOf(z), Boolean.valueOf(z2)});
        }
        if (itemBean == null || itemBean.getType() == null) {
            return null;
        }
        ViewTypeConfig viewTypeConfig = new ViewTypeConfig();
        viewTypeConfig.setDefaultLayoutResId(this.defaultLayoutResId);
        Integer valueOf = z ? Integer.valueOf(itemBean.getType().intValue() << 16) : itemBean.getType();
        b41.h(valueOf, "viewType");
        viewTypeConfig.setViewType(valueOf.intValue());
        viewTypeConfig.setLayoutHelper(componentBean.getLayout().getLayoutType());
        String viewHolder = componentBean.getLayout().getViewHolder();
        String viewHolder2 = itemBean.getViewHolder();
        if (!(viewHolder2 == null || viewHolder2.length() == 0)) {
            viewHolder = itemBean.getViewHolder();
        }
        viewTypeConfig.setViewHolderClassName(viewHolder);
        viewTypeConfig.setDefaultHolderClass(this.defaultHolderClass);
        if (!z2) {
            Class<?> cls = this.defaultHolderClass;
            if (!(viewHolder == null || viewHolder.length() == 0)) {
                cls = ReflectionUtil.INSTANCE.tryGetClassForName(viewHolder);
            }
            viewTypeConfig.setViewHolderClass(cls);
        }
        String layoutID = itemBean.getLayoutID();
        viewTypeConfig.setLayoutResString(layoutID);
        if (!z2) {
            int i = this.defaultLayoutResId;
            if (!(layoutID == null || layoutID.length() == 0)) {
                i = ViewUtil.getIdentifier(context, layoutID, "layout");
            }
            viewTypeConfig.setLayoutResId(Integer.valueOf(i));
        }
        String layoutIDOpt = itemBean.getLayoutIDOpt();
        viewTypeConfig.setLayoutResStringOpt(layoutIDOpt);
        if (!z2) {
            int i2 = this.defaultLayoutResId;
            if (!(layoutIDOpt == null || layoutIDOpt.length() == 0)) {
                i2 = ViewUtil.getIdentifier(context, layoutIDOpt, "layout");
            }
            viewTypeConfig.setLayoutResIdOpt(Integer.valueOf(i2));
        }
        viewTypeConfig.setModel(itemBean.getModel());
        viewTypeConfig.setModelOpt(itemBean.getModelOpt());
        viewTypeConfig.setPresenter(itemBean.getPresent());
        viewTypeConfig.setPresenterOpt(itemBean.getPresentOpt());
        viewTypeConfig.setView(itemBean.getView());
        viewTypeConfig.setViewOpt(itemBean.getViewOpt());
        viewTypeConfig.setParams(itemBean.getParams());
        viewTypeConfig.setPreRenderClassName(itemBean.getPreRender());
        if (!z2) {
            String preRender = itemBean.getPreRender();
            if (preRender != null && preRender.length() != 0) {
                z3 = false;
            }
            viewTypeConfig.setPreRenderClass(z3 ? null : ReflectionUtil.INSTANCE.tryGetClassForName(itemBean.getPreRender()));
        }
        return viewTypeConfig;
    }

    private final void initViewConfig(Context context, ComponentConfigBean componentConfigBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1812513597")) {
            ipChange.ipc$dispatch("-1812513597", new Object[]{this, context, componentConfigBean});
            return;
        }
        if (AppInfoProviderProxy.isDebuggable()) {
            PerformanceLogUtil.INSTANCE.markStartPoint("initViewConfig");
        }
        boolean isEnableViewTypeConfigLazyParser = Companion.isEnableViewTypeConfigLazyParser();
        for (ComponentConfigBean.ComponentBean componentBean : componentConfigBean.getComponents()) {
            ComponentConfigBean.ComponentBean.ItemBean container = componentBean.getContainer();
            if (container != null) {
                b41.h(componentBean, "componentBean");
                ViewTypeConfig createViewTypeConfig = createViewTypeConfig(context, componentBean, container, true, isEnableViewTypeConfigLazyParser);
                if (createViewTypeConfig != null) {
                    getViewTypeConfigs().put(createViewTypeConfig.getViewType(), createViewTypeConfig);
                }
            }
            List<ComponentConfigBean.ComponentBean.ItemBean> viewTypes = componentBean.getViewTypes();
            if (viewTypes != null) {
                for (ComponentConfigBean.ComponentBean.ItemBean itemBean : viewTypes) {
                    b41.h(componentBean, "componentBean");
                    ViewTypeConfig createViewTypeConfig2 = createViewTypeConfig(context, componentBean, itemBean, false, isEnableViewTypeConfigLazyParser);
                    if (createViewTypeConfig2 != null) {
                        getViewTypeConfigs().put(createViewTypeConfig2.getViewType(), createViewTypeConfig2);
                    }
                }
            }
        }
        if (AppInfoProviderProxy.isDebuggable()) {
            PerformanceLogUtil.INSTANCE.markEndPoint("initViewConfig");
        }
    }

    @Nullable
    public ViewTypeConfig getViewTypeConfig(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "575197287")) {
            return (ViewTypeConfig) ipChange.ipc$dispatch("575197287", new Object[]{this, Integer.valueOf(i)});
        }
        if (this.viewTypeConfigs.get(i) != null) {
            return this.viewTypeConfigs.get(i);
        }
        return this.viewTypeConfigCreatorManager.create(i);
    }

    @NotNull
    public final SparseArray<ViewTypeConfig> getViewTypeConfigs() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-712367019") ? (SparseArray) ipChange.ipc$dispatch("-712367019", new Object[]{this}) : this.viewTypeConfigs;
    }

    public final void registerViewTypeConfigCreator(@NotNull TypeRange typeRange, @NotNull ViewTypeConfigCreator viewTypeConfigCreator) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-747662574")) {
            ipChange.ipc$dispatch("-747662574", new Object[]{this, typeRange, viewTypeConfigCreator});
            return;
        }
        b41.i(typeRange, "typeRange");
        b41.i(viewTypeConfigCreator, "viewTypeConfigCreator");
        this.viewTypeConfigCreatorManager.register(typeRange, viewTypeConfigCreator);
    }

    public ViewTypeSupport(@NotNull ComponentConfigBean componentConfigBean) {
        b41.i(componentConfigBean, "componentConfig");
        this.viewTypeConfigs = new SparseArray<>(160);
        this.viewTypeConfigCreatorManager = new ViewTypeConfigCreatorManager();
        this.componentConfig = componentConfigBean;
        Application application = AppInfoProviderProxy.getApplication();
        this.defaultLayoutResId = ViewUtil.getIdentifier(application, Constants.RES_DEFAULT_LAYOUT, "layout");
        this.defaultHolderClass = ReflectionUtil.INSTANCE.tryGetClassForName(Constants.CLASS_DEFAULT_VIEW_HOLDER);
        b41.h(application, WPKFactory.INIT_KEY_CONTEXT);
        initViewConfig(application, componentConfigBean);
    }
}
