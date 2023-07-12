package com.youku.arch.v3.view.config;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.util.SparseArray;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.bridge.WXBridgeManager;
import com.youku.arch.v3.util.ConfigParser;
import com.youku.arch.v3.view.config.ComponentConfigBean;
import com.youku.arch.v3.view.render.GenericRenderPluginFactory;
import com.youku.arch.v3.view.render.RenderPluginConfigCenter;
import com.youku.arch.v3.view.render.RenderPluginFactory;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import io.flutter.wpkbridge.WPKFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.b;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joor.a;
import tb.b41;
import tb.k50;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 &2\u00020\u0001:\u0001&B\t\b\u0002¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0006J\u001e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0006R\"\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00020\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R(\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR$\u0010\u001e\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006'"}, d2 = {"Lcom/youku/arch/v3/view/config/ComponentConfigManager;", "", "Lcom/youku/arch/v3/view/config/ComponentConfigBean;", "componentConfig", "Ltb/wt2;", "addUniversallyComponentConfigs", "", "page", WXBridgeManager.METHOD_REGISTER_COMPONENTS, "Lcom/youku/arch/v3/view/config/ComponentConfigBean$ComponentBean$ItemBean;", "itemBean", "", "isContainer", "setSupportRenderPlugin", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "componentConfigPath", "getComponentConfig", "Landroid/util/SparseArray;", "Lcom/youku/arch/v3/view/config/ComponentConfigBean$ComponentBean;", "getComponentConfigs", "Ljava/util/concurrent/ConcurrentHashMap;", "componentConfigMap", "Ljava/util/concurrent/ConcurrentHashMap;", "componentMap", "Lcom/youku/arch/v3/view/render/RenderPluginFactory;", "renderPluginFactory", "Lcom/youku/arch/v3/view/render/RenderPluginFactory;", "universallyComponentConfig", "Lcom/youku/arch/v3/view/config/ComponentConfigBean;", "universallyComponentConfigPath", "Ljava/lang/String;", "getUniversallyComponentConfigPath", "()Ljava/lang/String;", "setUniversallyComponentConfigPath", "(Ljava/lang/String;)V", "<init>", "()V", "Companion", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class ComponentConfigManager {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final String UNIVERSALLY_COMPONENT_CONFIG_PATH = "android.resource://onecomponent/raw/universally_component_config";
    @NotNull
    private static final Lazy<ComponentConfigManager> instance$delegate;
    @NotNull
    private final ConcurrentHashMap<String, ComponentConfigBean> componentConfigMap;
    @NotNull
    private final ConcurrentHashMap<String, SparseArray<ComponentConfigBean.ComponentBean>> componentMap;
    @NotNull
    private final RenderPluginFactory renderPluginFactory;
    @Nullable
    private ComponentConfigBean universallyComponentConfig;
    @Nullable
    private String universallyComponentConfigPath;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR\u001d\u0010\u0007\u001a\u00020\u00028F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/youku/arch/v3/view/config/ComponentConfigManager$Companion;", "", "Lcom/youku/arch/v3/view/config/ComponentConfigManager;", "instance$delegate", "Lkotlin/Lazy;", "getInstance", "()Lcom/youku/arch/v3/view/config/ComponentConfigManager;", "instance", "", "UNIVERSALLY_COMPONENT_CONFIG_PATH", "Ljava/lang/String;", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private static transient /* synthetic */ IpChange $ipChange;

        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }

        @NotNull
        public final ComponentConfigManager getInstance() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "2128147299") ? (ComponentConfigManager) ipChange.ipc$dispatch("2128147299", new Object[]{this}) : (ComponentConfigManager) ComponentConfigManager.instance$delegate.getValue();
        }
    }

    static {
        Lazy<ComponentConfigManager> a;
        a = b.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0<ComponentConfigManager>() { // from class: com.youku.arch.v3.view.config.ComponentConfigManager$Companion$instance$2
            private static transient /* synthetic */ IpChange $ipChange;

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ComponentConfigManager invoke() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "-1012405247") ? (ComponentConfigManager) ipChange.ipc$dispatch("-1012405247", new Object[]{this}) : new ComponentConfigManager(null);
            }
        });
        instance$delegate = a;
    }

    private ComponentConfigManager() {
        this.componentConfigMap = new ConcurrentHashMap<>();
        this.componentMap = new ConcurrentHashMap<>();
        this.renderPluginFactory = new GenericRenderPluginFactory();
        this.universallyComponentConfigPath = UNIVERSALLY_COMPONENT_CONFIG_PATH;
    }

    public /* synthetic */ ComponentConfigManager(k50 k50Var) {
        this();
    }

    private final void addUniversallyComponentConfigs(ComponentConfigBean componentConfigBean) {
        List<ComponentConfigBean.ComponentBean> components;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-928424070")) {
            ipChange.ipc$dispatch("-928424070", new Object[]{this, componentConfigBean});
            return;
        }
        if (this.universallyComponentConfig == null) {
            ConfigParser configParser = new ConfigParser();
            Application application = AppInfoProviderProxy.getApplication();
            b41.h(application, "getApplication()");
            this.universallyComponentConfig = (ComponentConfigBean) configParser.parse(application, Uri.parse(this.universallyComponentConfigPath), ComponentConfigBean.class);
        }
        HashMap hashMap = new HashMap();
        ComponentConfigBean componentConfigBean2 = this.universallyComponentConfig;
        if (componentConfigBean2 != null && (components = componentConfigBean2.getComponents()) != null) {
            if (!(!components.isEmpty())) {
                components = null;
            }
            if (components != null) {
                for (ComponentConfigBean.ComponentBean componentBean : components) {
                    Integer type = componentBean.getType();
                    b41.h(type, "componentBean.type");
                    b41.h(componentBean, "componentBean");
                    hashMap.put(type, componentBean);
                }
            }
        }
        List<ComponentConfigBean.ComponentBean> components2 = componentConfigBean.getComponents();
        if (components2 != null) {
            List<ComponentConfigBean.ComponentBean> list = true ^ components2.isEmpty() ? components2 : null;
            if (list != null) {
                for (ComponentConfigBean.ComponentBean componentBean2 : list) {
                    Integer type2 = componentBean2.getType();
                    b41.h(type2, "componentBean.type");
                    b41.h(componentBean2, "componentBean");
                    hashMap.put(type2, componentBean2);
                }
            }
        }
        componentConfigBean.setComponents(new ArrayList(hashMap.values()));
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x007c, code lost:
        if (tb.b41.d(com.youku.arch.v3.data.Constants.LayoutType.PAGER, r5 != null ? r5.getLayoutType() : null) != false) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void registerComponents(java.lang.String r9) {
        /*
            r8 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = com.youku.arch.v3.view.config.ComponentConfigManager.$ipChange
            java.lang.String r1 = "-1983205628"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L17
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r4] = r8
            r2[r3] = r9
            r0.ipc$dispatch(r1, r2)
            return
        L17:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.youku.arch.v3.view.config.ComponentConfigBean> r0 = r8.componentConfigMap
            java.lang.Object r0 = r0.get(r9)
            com.youku.arch.v3.view.config.ComponentConfigBean r0 = (com.youku.arch.v3.view.config.ComponentConfigBean) r0
            if (r0 != 0) goto L23
            goto Lb0
        L23:
            java.util.List r0 = r0.getComponents()
            if (r0 != 0) goto L2b
            goto Lb0
        L2b:
            java.util.Iterator r0 = r0.iterator()
        L2f:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto Lb0
            java.lang.Object r1 = r0.next()
            com.youku.arch.v3.view.config.ComponentConfigBean$ComponentBean r1 = (com.youku.arch.v3.view.config.ComponentConfigBean.ComponentBean) r1
            com.youku.arch.v3.view.config.ComponentConfigBean$ComponentBean$ItemBean r2 = r1.getContainer()
            if (r2 != 0) goto L42
            goto L81
        L42:
            com.youku.arch.v3.view.config.ComponentConfigBean$ComponentBean$LayoutBean r5 = r1.getLayout()
            r6 = 0
            if (r5 != 0) goto L4b
            r5 = r6
            goto L4f
        L4b:
            java.lang.String r5 = r5.getLayoutType()
        L4f:
            java.lang.String r7 = "list"
            boolean r5 = tb.b41.d(r7, r5)
            if (r5 != 0) goto L7e
            com.youku.arch.v3.view.config.ComponentConfigBean$ComponentBean$LayoutBean r5 = r1.getLayout()
            if (r5 != 0) goto L5f
            r5 = r6
            goto L63
        L5f:
            java.lang.String r5 = r5.getLayoutType()
        L63:
            java.lang.String r7 = "raw_list"
            boolean r5 = tb.b41.d(r7, r5)
            if (r5 != 0) goto L7e
            com.youku.arch.v3.view.config.ComponentConfigBean$ComponentBean$LayoutBean r5 = r1.getLayout()
            if (r5 != 0) goto L72
            goto L76
        L72:
            java.lang.String r6 = r5.getLayoutType()
        L76:
            java.lang.String r5 = "pager"
            boolean r5 = tb.b41.d(r5, r6)
            if (r5 == 0) goto L81
        L7e:
            r8.setSupportRenderPlugin(r9, r2, r3)
        L81:
            java.util.List r2 = r1.getViewTypes()
            if (r2 == 0) goto L90
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L8e
            goto L90
        L8e:
            r2 = 0
            goto L91
        L90:
            r2 = 1
        L91:
            if (r2 != 0) goto L2f
            java.util.List r1 = r1.getViewTypes()
            java.util.Iterator r1 = r1.iterator()
        L9b:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L2f
            java.lang.Object r2 = r1.next()
            com.youku.arch.v3.view.config.ComponentConfigBean$ComponentBean$ItemBean r2 = (com.youku.arch.v3.view.config.ComponentConfigBean.ComponentBean.ItemBean) r2
            java.lang.String r5 = "item"
            tb.b41.h(r2, r5)
            r8.setSupportRenderPlugin(r9, r2, r4)
            goto L9b
        Lb0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.arch.v3.view.config.ComponentConfigManager.registerComponents(java.lang.String):void");
    }

    private final void setSupportRenderPlugin(String str, ComponentConfigBean.ComponentBean.ItemBean itemBean, boolean z) {
        Integer type;
        IpChange ipChange = $ipChange;
        boolean z2 = true;
        if (AndroidInstantRuntime.support(ipChange, "-1106421635")) {
            ipChange.ipc$dispatch("-1106421635", new Object[]{this, str, itemBean, Boolean.valueOf(z)});
            return;
        }
        if (z) {
            Integer type2 = itemBean.getType();
            type = type2 == null ? null : Integer.valueOf(type2.intValue() << 16);
        } else {
            type = itemBean.getType();
        }
        String valueOf = String.valueOf(type);
        if (itemBean.isMVPArchitecture()) {
            RenderPluginConfigCenter.Companion.getInstance().setSupportRenderPlugin(str, valueOf, this.renderPluginFactory);
            return;
        }
        String renderPluginFactory = itemBean.getRenderPluginFactory();
        if (renderPluginFactory != null && renderPluginFactory.length() != 0) {
            z2 = false;
        }
        if (z2) {
            return;
        }
        Object f = a.j(itemBean.getRenderPluginFactory()).b().f();
        RenderPluginFactory renderPluginFactory2 = f instanceof RenderPluginFactory ? (RenderPluginFactory) f : null;
        if (renderPluginFactory2 == null) {
            return;
        }
        RenderPluginConfigCenter.Companion.getInstance().setSupportRenderPlugin(str, valueOf, renderPluginFactory2);
    }

    @Nullable
    public final synchronized ComponentConfigBean getComponentConfig(@NotNull Context context, @NotNull String str) {
        ComponentConfigBean componentConfigBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-188408358")) {
            return (ComponentConfigBean) ipChange.ipc$dispatch("-188408358", new Object[]{this, context, str});
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(str, "componentConfigPath");
        if (!this.componentConfigMap.containsKey(str) && (componentConfigBean = (ComponentConfigBean) new ConfigParser().parse(context, Uri.parse(str), ComponentConfigBean.class)) != null) {
            addUniversallyComponentConfigs(componentConfigBean);
            this.componentConfigMap.put(str, componentConfigBean);
            registerComponents(str);
        }
        return this.componentConfigMap.get(str);
    }

    @Nullable
    public final synchronized SparseArray<ComponentConfigBean.ComponentBean> getComponentConfigs(@NotNull Context context, @NotNull String str) {
        ComponentConfigBean componentConfig;
        List<ComponentConfigBean.ComponentBean> components;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-553244556")) {
            return (SparseArray) ipChange.ipc$dispatch("-553244556", new Object[]{this, context, str});
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(str, "componentConfigPath");
        if (!this.componentMap.containsKey(str) && (componentConfig = getComponentConfig(context, str)) != null && (components = componentConfig.getComponents()) != null) {
            SparseArray<ComponentConfigBean.ComponentBean> sparseArray = new SparseArray<>();
            for (ComponentConfigBean.ComponentBean componentBean : components) {
                Integer type = componentBean.getType();
                if (type != null) {
                    sparseArray.put(type.intValue(), componentBean);
                }
            }
            this.componentMap.put(str, sparseArray);
        }
        return this.componentMap.get(str);
    }

    @Nullable
    public final String getUniversallyComponentConfigPath() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "634577387") ? (String) ipChange.ipc$dispatch("634577387", new Object[]{this}) : this.universallyComponentConfigPath;
    }

    public final void setUniversallyComponentConfigPath(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1922291027")) {
            ipChange.ipc$dispatch("1922291027", new Object[]{this, str});
        } else {
            this.universallyComponentConfigPath = str;
        }
    }
}
