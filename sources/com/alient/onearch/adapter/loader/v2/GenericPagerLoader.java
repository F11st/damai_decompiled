package com.alient.onearch.adapter.loader.v2;

import android.app.Activity;
import android.util.SparseArray;
import com.alibaba.android.ultron.trade.event.OpenSimplePopupSubscriber;
import com.alibaba.fastjson.JSONObject;
import com.alient.onearch.adapter.BaseFragment;
import com.alient.onearch.adapter.PageInfoBean;
import com.alient.onearch.adapter.decorate.ComponentDecorateItem;
import com.alient.onearch.adapter.decorate.ComponentDecorator;
import com.alient.onearch.adapter.loader.ComponentItemDisplayLimiter;
import com.youku.arch.v3.adapter.ViewTypeConfig;
import com.youku.arch.v3.adapter.ViewTypeSupport;
import com.youku.arch.v3.core.ConfigManager;
import com.youku.arch.v3.core.ModelValue;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.core.PageContainer;
import com.youku.arch.v3.creator.ComponentCreatorManager;
import com.youku.arch.v3.data.Constants;
import com.youku.arch.v3.io.IResponse;
import com.youku.arch.v3.loader.PageLoader;
import com.youku.arch.v3.page.GenericFragment;
import com.youku.arch.v3.page.state.IStateView;
import com.youku.arch.v3.page.state.PageStateManager;
import com.youku.arch.v3.page.state.StateView;
import com.youku.arch.v3.view.config.ComponentConfigBean;
import com.youku.arch.v3.view.config.ComponentConfigManager;
import com.youku.kubus.IdGenerator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import kotlin.C8177b;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.C8212k;
import kotlin.jvm.functions.Function0;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;
import tb.wt2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010+\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 L2\u00020\u0001:\u0001LB\u0015\u0012\f\u0010I\u001a\b\u0012\u0004\u0012\u00020H0G¢\u0006\u0004\bJ\u0010KJ\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J \u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000bH\u0002J\u001e\u0010\u000e\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u001e\u0010\u000f\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b2\u0006\u0010\b\u001a\u00020\u0007H\u0002J&\u0010\u0014\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011H\u0016J\u0018\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0016\u001a\u00020\u0011H\u0016J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0007H\u0016J\u001e\u0010\u001f\u001a\u00020\u00052\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b2\u0006\u0010\u001e\u001a\u00020\u0007H\u0016J\u001e\u0010 \u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u001e\u0010#\u001a\u00020\u00052\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b2\u0006\u0010\"\u001a\u00020\u0007H\u0016J\u001e\u0010$\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010%\u001a\u00020\u00172\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010&\u001a\u00020\u00172\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u001e\u0010'\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010(\u001a\u00020\u00172\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010)\u001a\u00020\u00172\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010*\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0007H\u0016J\u0018\u0010+\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0007H\u0016J&\u0010.\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010-\u001a\u00020,H\u0016J\u0018\u0010.\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010-\u001a\u00020,H\u0016J\u0018\u00100\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010/\u001a\u00020\tH\u0014J\u0016\u00103\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u00172\u0006\u00102\u001a\u00020\u0017J\u0016\u00106\u001a\u00020\u00052\u0006\u00104\u001a\u00020\u00172\u0006\u00105\u001a\u00020,J\u0016\u00107\u001a\u00020\u00052\u0006\u00104\u001a\u00020\u00172\u0006\u00105\u001a\u00020,R\u001d\u0010=\u001a\u0002088B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\u001d\u0010B\u001a\u00020>8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b?\u0010:\u001a\u0004\b@\u0010AR\u001e\u0010E\u001a\n\u0012\u0004\u0012\u00020D\u0018\u00010C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010F¨\u0006M"}, d2 = {"Lcom/alient/onearch/adapter/loader/v2/GenericPagerLoader;", "Lcom/youku/arch/v3/loader/PageLoader;", "", "utPageName", "spmAB", "Ltb/wt2;", "handlePageUTParams", "Lcom/youku/arch/v3/core/Node;", "componentNode", "", "isFilterComponent", "", "componentIterator", "tryCreateDecorateComponentNode", "handleCreateBeforeDecorateComponentNode", "handleCreateAfterDecorateComponentNode", "source", "Lcom/alibaba/fastjson/JSONObject;", "top", "bottom", "handlePageBaseInfo", "Lcom/youku/arch/v3/io/IResponse;", "response", "", "index", "handleLoadSuccess", "parseNode", "node", "handleNode", "itemIterator", "itemNode", "handleItemNode", "handleComponentNode", "moduleIterator", "moduleNode", "handleModuleNode", "handleCreateFooterComponentNode", "handleCreateFooterComponentNodeType", "handleCreateFooterItemNodeType", "handleCreateHeaderComponentNode", "handleCreateHeaderComponentNodeType", "handleCreateHeaderItemNodeType", "handleFooterItemProperty", "handleHeaderItemProperty", "Lcom/alient/onearch/adapter/decorate/ComponentDecorateItem;", "componentDecorateItemNode", "createDecorateComponent", "hasItem", "setLoadingViewState", OpenSimplePopupSubscriber.KEY_COMPONENT_TYPE, "limitSize", "addComponentDisplayLimit", "componentId", "decorate", "addComponentDecorate", "removeComponentDecorate", "Lcom/alient/onearch/adapter/loader/ComponentItemDisplayLimiter;", "componentItemDisplayLimiter$delegate", "Lkotlin/Lazy;", "getComponentItemDisplayLimiter", "()Lcom/alient/onearch/adapter/loader/ComponentItemDisplayLimiter;", "componentItemDisplayLimiter", "Lcom/alient/onearch/adapter/decorate/ComponentDecorator;", "componentDecorator$delegate", "getComponentDecorator", "()Lcom/alient/onearch/adapter/decorate/ComponentDecorator;", "componentDecorator", "Landroid/util/SparseArray;", "Lcom/youku/arch/v3/view/config/ComponentConfigBean$ComponentBean;", "componentConfigs", "Landroid/util/SparseArray;", "Lcom/youku/arch/v3/core/PageContainer;", "Lcom/youku/arch/v3/core/ModelValue;", "pageContainer", "<init>", "(Lcom/youku/arch/v3/core/PageContainer;)V", "Companion", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes10.dex */
public class GenericPagerLoader extends PageLoader {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String PAGE_BOTTOM_DATA = "bottom";
    @NotNull
    public static final String PAGE_TOP_DATA = "top";
    @NotNull
    public static final String UT_PAGE_NAME = "pageName";
    @NotNull
    public static final String UT_SPM_AB = "spmab";
    @Nullable
    private SparseArray<ComponentConfigBean.ComponentBean> componentConfigs;
    @NotNull
    private final Lazy componentDecorator$delegate;
    @NotNull
    private final Lazy componentItemDisplayLimiter$delegate;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004¨\u0006\n"}, d2 = {"Lcom/alient/onearch/adapter/loader/v2/GenericPagerLoader$Companion;", "", "", "PAGE_BOTTOM_DATA", "Ljava/lang/String;", "PAGE_TOP_DATA", "UT_PAGE_NAME", "UT_SPM_AB", "<init>", "()V", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes12.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GenericPagerLoader(@NotNull PageContainer<ModelValue> pageContainer) {
        super(pageContainer);
        Lazy a;
        Lazy a2;
        ConfigManager configManager;
        String pathConfig;
        b41.i(pageContainer, "pageContainer");
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        a = C8177b.a(lazyThreadSafetyMode, new Function0<ComponentItemDisplayLimiter>() { // from class: com.alient.onearch.adapter.loader.v2.GenericPagerLoader$componentItemDisplayLimiter$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ComponentItemDisplayLimiter invoke() {
                return new ComponentItemDisplayLimiter();
            }
        });
        this.componentItemDisplayLimiter$delegate = a;
        a2 = C8177b.a(lazyThreadSafetyMode, new Function0<ComponentDecorator>() { // from class: com.alient.onearch.adapter.loader.v2.GenericPagerLoader$componentDecorator$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ComponentDecorator invoke() {
                return new ComponentDecorator();
            }
        });
        this.componentDecorator$delegate = a2;
        Activity activity = getHost().getPageContext().getActivity();
        if (activity == null || (configManager = getHost().getPageContext().getConfigManager()) == null || (pathConfig = configManager.getPathConfig(ConfigManager.COMPONENT_CONFIG_FILE)) == null) {
            return;
        }
        this.componentConfigs = ComponentConfigManager.Companion.getInstance().getComponentConfigs(activity, pathConfig);
    }

    private final ComponentDecorator getComponentDecorator() {
        return (ComponentDecorator) this.componentDecorator$delegate.getValue();
    }

    private final ComponentItemDisplayLimiter getComponentItemDisplayLimiter() {
        return (ComponentItemDisplayLimiter) this.componentItemDisplayLimiter$delegate.getValue();
    }

    private final void handleCreateAfterDecorateComponentNode(ListIterator<Node> listIterator, Node node) {
        ComponentDecorateItem componentDecorate = getComponentDecorator().getComponentDecorate(node.getType(), ComponentDecorateItem.Indexer.After);
        if (componentDecorate == null) {
            return;
        }
        createDecorateComponent(listIterator, node, componentDecorate);
    }

    private final void handleCreateBeforeDecorateComponentNode(ListIterator<Node> listIterator, Node node) {
        ComponentDecorateItem componentDecorate = getComponentDecorator().getComponentDecorate(node.getType(), ComponentDecorateItem.Indexer.Before);
        if (componentDecorate == null) {
            return;
        }
        createDecorateComponent(listIterator, node, componentDecorate);
    }

    private final void handlePageUTParams(String str, String str2) {
        List t0;
        GenericFragment fragment = getHost().getPageContext().getFragment();
        BaseFragment baseFragment = fragment instanceof BaseFragment ? (BaseFragment) fragment : null;
        if (baseFragment == null) {
            return;
        }
        boolean z = false;
        if (!(str2 == null || str2.length() == 0)) {
            t0 = StringsKt__StringsKt.t0(str2, new String[]{"."}, false, 0, 6, null);
            if (!(t0 == null || t0.isEmpty()) && t0.size() > 1) {
                baseFragment.getTrackInfo().setSpma((String) t0.get(0));
                baseFragment.getTrackInfo().setSpmb((String) t0.get(1));
            }
        }
        if (str == null || str.length() == 0) {
            return;
        }
        String spmb = baseFragment.getTrackInfo().getSpmb();
        if ((spmb == null || spmb.length() == 0) ? true : true) {
            return;
        }
        String spmb2 = baseFragment.getTrackInfo().getSpmb();
        b41.h(spmb2, "it.trackInfo.spmb");
        baseFragment.updateUTPageNameFromRemote(str, spmb2);
    }

    private final boolean isFilterComponent(Node node) {
        JSONObject data = node.getData();
        if (!b41.d(data == null ? null : data.get("isFilterEmpty"), "false")) {
            List<Node> children = node.getChildren();
            if (children == null || children.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    private final void tryCreateDecorateComponentNode(Node node, ListIterator<Node> listIterator) {
        boolean z;
        boolean z2;
        Integer valueOf;
        Integer geComponentLimitSize;
        Node node2;
        ComponentCreatorManager componentCreatorManager;
        JSONObject data = node.getData();
        if (data == null) {
            return;
        }
        List<Node> children = node.getChildren();
        boolean z3 = false;
        if (children == null || (node2 = (Node) C8212k.P(children)) == null) {
            z = false;
            z2 = false;
        } else {
            if (node2.getLevel() == 2) {
                List<Node> children2 = node.getChildren();
                if (children2 == null) {
                    z2 = false;
                } else {
                    z2 = false;
                    for (Node node3 : children2) {
                        if (node3.getLevel() == 2) {
                            SparseArray<ComponentConfigBean.ComponentBean> sparseArray = this.componentConfigs;
                            if (sparseArray != null && sparseArray.get(node3.getType()) != null) {
                                wt2 wt2Var = wt2.INSTANCE;
                                z2 = true;
                            }
                            if (!z2 && (componentCreatorManager = getHost().getPageContext().getComponentCreatorManager()) != null) {
                                z2 = componentCreatorManager.isSupport(node3.getType());
                                wt2 wt2Var2 = wt2.INSTANCE;
                            }
                        }
                    }
                    wt2 wt2Var3 = wt2.INSTANCE;
                }
                z = true;
            } else {
                z = false;
                z2 = false;
            }
            wt2 wt2Var4 = wt2.INSTANCE;
        }
        if (!z) {
            z2 = true;
        }
        if (listIterator != null) {
            boolean z4 = getComponentDecorator().getComponentDecorate(node.getType(), ComponentDecorateItem.Indexer.Before) != null;
            if (z2) {
                String string = data.getString("title");
                if (!(string == null || string.length() == 0) && !b41.d(data.getString("hiddenTitle"), "true")) {
                    z3 = true;
                }
            }
            if (z4 || z3) {
                listIterator.remove();
            }
            if (z4) {
                handleCreateBeforeDecorateComponentNode(listIterator, node);
            }
            if (z3) {
                handleCreateHeaderComponentNode(listIterator, node);
            }
            if (z4 || z3) {
                listIterator.add(node);
            }
            wt2 wt2Var5 = wt2.INSTANCE;
        }
        if (!b41.d(data.getString("hiddenFooter"), "true")) {
            Object obj = data.get(Constants.DISPLAY_NUM);
            String str = obj instanceof String ? (String) obj : null;
            if (str == null) {
                valueOf = null;
            } else {
                valueOf = Integer.valueOf(Integer.parseInt(str));
                int intValue = valueOf.intValue();
                List<Node> children3 = node.getChildren();
                Integer valueOf2 = children3 == null ? null : Integer.valueOf(children3.size());
                Object obj2 = data.get(Constants.TOTAL_NUM);
                String str2 = obj2 instanceof String ? (String) obj2 : null;
                if (str2 != null) {
                    valueOf2 = Integer.valueOf(Integer.valueOf(Integer.parseInt(str2)).intValue());
                    wt2 wt2Var6 = wt2.INSTANCE;
                }
                if (valueOf2 != null) {
                    if (intValue < valueOf2.intValue() && listIterator != null) {
                        handleCreateFooterComponentNode(listIterator, node);
                        wt2 wt2Var7 = wt2.INSTANCE;
                    }
                    wt2 wt2Var8 = wt2.INSTANCE;
                }
                wt2 wt2Var9 = wt2.INSTANCE;
            }
            if (valueOf == null && (geComponentLimitSize = getComponentItemDisplayLimiter().geComponentLimitSize(node.getType())) != null) {
                int intValue2 = geComponentLimitSize.intValue();
                List<Node> children4 = node.getChildren();
                Integer valueOf3 = children4 == null ? null : Integer.valueOf(children4.size());
                Object obj3 = data.get(Constants.TOTAL_NUM);
                String str3 = obj3 instanceof String ? (String) obj3 : null;
                if (str3 != null) {
                    valueOf3 = Integer.valueOf(Integer.valueOf(Integer.parseInt(str3)).intValue());
                    wt2 wt2Var10 = wt2.INSTANCE;
                }
                if (valueOf3 != null) {
                    if (intValue2 < valueOf3.intValue() && listIterator != null) {
                        data.put((JSONObject) Constants.DISPLAY_NUM, (String) Integer.valueOf(intValue2));
                        handleCreateFooterComponentNode(listIterator, node);
                        wt2 wt2Var11 = wt2.INSTANCE;
                    }
                    wt2 wt2Var12 = wt2.INSTANCE;
                }
                wt2 wt2Var13 = wt2.INSTANCE;
            }
        }
        if (getComponentDecorator().getComponentDecorate(node.getType(), ComponentDecorateItem.Indexer.After) != null && listIterator != null) {
            handleCreateAfterDecorateComponentNode(listIterator, node);
            wt2 wt2Var14 = wt2.INSTANCE;
        }
        wt2 wt2Var15 = wt2.INSTANCE;
    }

    public final void addComponentDecorate(int i, @NotNull ComponentDecorateItem componentDecorateItem) {
        b41.i(componentDecorateItem, "decorate");
        getComponentDecorator().addComponentDecorate(i, componentDecorateItem);
    }

    public final void addComponentDisplayLimit(int i, int i2) {
        getComponentItemDisplayLimiter().addComponentLimitSize(i, i2);
    }

    public void createDecorateComponent(@NotNull ListIterator<Node> listIterator, @NotNull Node node, @NotNull ComponentDecorateItem componentDecorateItem) {
        b41.i(listIterator, "componentIterator");
        b41.i(node, "componentNode");
        b41.i(componentDecorateItem, "componentDecorateItemNode");
        Node node2 = new Node();
        node2.setId(IdGenerator.getId());
        node2.setType(componentDecorateItem.getComponentType());
        node2.setLevel(2);
        node2.setParent(node.getParent());
        ArrayList arrayList = new ArrayList();
        Node node3 = new Node();
        node3.setId(IdGenerator.getId());
        node3.setType(componentDecorateItem.getItemType());
        node3.setLevel(3);
        node3.setData(componentDecorateItem.getData());
        node3.setParent(node2);
        wt2 wt2Var = wt2.INSTANCE;
        arrayList.add(node3);
        node2.setChildren(arrayList);
        listIterator.add(node2);
    }

    public void handleComponentNode(@NotNull ListIterator<Node> listIterator, @NotNull Node node) {
        ComponentCreatorManager componentCreatorManager;
        ComponentCreatorManager componentCreatorManager2;
        b41.i(listIterator, "componentIterator");
        b41.i(node, "componentNode");
        if (isFilterComponent(node)) {
            listIterator.remove();
            return;
        }
        SparseArray<ComponentConfigBean.ComponentBean> sparseArray = this.componentConfigs;
        boolean z = true;
        boolean z2 = (sparseArray == null || sparseArray.get(node.getType()) == null) ? false : true;
        if (!z2 && (componentCreatorManager2 = getHost().getPageContext().getComponentCreatorManager()) != null) {
            z2 = componentCreatorManager2.isSupport(node.getType());
        }
        if (z2) {
            List<Node> children = node.getChildren();
            if (children != null) {
                ListIterator<Node> listIterator2 = children.listIterator();
                while (listIterator2.hasNext()) {
                    Node next = listIterator2.next();
                    if (next.getLevel() == 2) {
                        List<Node> children2 = next.getChildren();
                        if (children2 == null || children2.isEmpty()) {
                            listIterator2.remove();
                        } else {
                            SparseArray<ComponentConfigBean.ComponentBean> sparseArray2 = this.componentConfigs;
                            boolean z3 = (sparseArray2 == null || sparseArray2.get(next.getType()) == null) ? false : true;
                            if (!z3 && (componentCreatorManager = getHost().getPageContext().getComponentCreatorManager()) != null) {
                                z3 = componentCreatorManager.isSupport(next.getType());
                            }
                            if (!z3) {
                                listIterator2.remove();
                            }
                        }
                    }
                }
            }
            if (isFilterComponent(node)) {
                listIterator.remove();
                return;
            }
            Node parent = node.getParent();
            if (parent == null || parent.getLevel() == 2) {
                return;
            }
            List<Node> children3 = node.getChildren();
            if (children3 != null && !children3.isEmpty()) {
                z = false;
            }
            if (z) {
                return;
            }
            tryCreateDecorateComponentNode(node, listIterator);
            return;
        }
        listIterator.remove();
    }

    public void handleCreateFooterComponentNode(@NotNull ListIterator<Node> listIterator, @NotNull Node node) {
        b41.i(listIterator, "componentIterator");
        b41.i(node, "componentNode");
        Node node2 = new Node();
        node2.setId(IdGenerator.getId());
        node2.setLevel(2);
        node2.setType(handleCreateFooterComponentNodeType(node));
        node2.setParent(node.getParent());
        node2.setData(node.getData());
        node2.setRawJson(node.getRawJson());
        ArrayList arrayList = new ArrayList();
        Node node3 = new Node();
        node3.setId(IdGenerator.getId());
        node3.setLevel(3);
        node3.setType(handleCreateFooterItemNodeType(node));
        node3.setData(node.getData());
        node3.setRawJson(node.getRawJson());
        handleFooterItemProperty(node, node3);
        node3.setParent(node2);
        wt2 wt2Var = wt2.INSTANCE;
        arrayList.add(node3);
        node2.setChildren(arrayList);
        listIterator.add(node2);
    }

    public int handleCreateFooterComponentNodeType(@NotNull Node node) {
        b41.i(node, "componentNode");
        return 9995;
    }

    public int handleCreateFooterItemNodeType(@NotNull Node node) {
        b41.i(node, "componentNode");
        return 9995;
    }

    public void handleCreateHeaderComponentNode(@NotNull ListIterator<Node> listIterator, @NotNull Node node) {
        b41.i(listIterator, "componentIterator");
        b41.i(node, "componentNode");
        Node node2 = new Node();
        node2.setId(IdGenerator.getId());
        node2.setType(handleCreateHeaderComponentNodeType(node));
        node2.setLevel(2);
        node2.setParent(node.getParent());
        node2.setData(node.getData());
        node2.setRawJson(node.getRawJson());
        node2.setStyle(node.getStyle());
        ArrayList arrayList = new ArrayList();
        Node node3 = new Node();
        node3.setId(IdGenerator.getId());
        node3.setLevel(3);
        node3.setType(handleCreateHeaderItemNodeType(node));
        node3.setData(node.getData());
        node3.setRawJson(node.getRawJson());
        node3.setStyle(node.getStyle());
        handleHeaderItemProperty(node, node3);
        node3.setParent(node2);
        wt2 wt2Var = wt2.INSTANCE;
        arrayList.add(node3);
        node2.setChildren(arrayList);
        listIterator.add(node2);
    }

    public int handleCreateHeaderComponentNodeType(@NotNull Node node) {
        b41.i(node, "componentNode");
        return 9999;
    }

    public int handleCreateHeaderItemNodeType(@NotNull Node node) {
        b41.i(node, "componentNode");
        return 9999;
    }

    public void handleFooterItemProperty(@NotNull Node node, @NotNull Node node2) {
        b41.i(node, "componentNode");
        b41.i(node2, "itemNode");
    }

    public void handleHeaderItemProperty(@NotNull Node node, @NotNull Node node2) {
        b41.i(node, "componentNode");
        b41.i(node2, "itemNode");
    }

    public void handleItemNode(@NotNull ListIterator<Node> listIterator, @NotNull Node node) {
        ViewTypeConfig viewTypeConfig;
        HashMap<String, Object> params;
        Object obj;
        b41.i(listIterator, "itemIterator");
        b41.i(node, "itemNode");
        JSONObject data = node.getData();
        if (data == null || data.isEmpty()) {
            listIterator.remove();
            return;
        }
        if (node.getConfig() == null) {
            node.setConfig(new JSONObject());
        }
        ViewTypeSupport viewTypeSupport = getHost().getPageContext().getViewTypeSupport();
        if (viewTypeSupport == null || (viewTypeConfig = viewTypeSupport.getViewTypeConfig(node.getType())) == null || (params = viewTypeConfig.getParams()) == null || (obj = params.get("bean")) == null) {
            return;
        }
        JSONObject config = node.getConfig();
        b41.f(config);
        config.put((JSONObject) "bean", (String) obj);
    }

    @Override // com.youku.arch.v3.loader.PageLoader, com.youku.arch.v3.loader.AbsLoader, com.youku.arch.v3.loader.PagingLoader
    public void handleLoadSuccess(@NotNull IResponse iResponse, int i) {
        JSONObject jSONObject;
        b41.i(iResponse, "response");
        JSONObject jsonObject = iResponse.getJsonObject();
        if (jsonObject != null) {
            JSONObject jSONObject2 = findRootDataNode(jsonObject).containsKey("data") ? jsonObject.getJSONObject("data") : null;
            if (jSONObject2 != null && (jSONObject = jSONObject2.getJSONObject("data")) != null) {
                handlePageBaseInfo(iResponse.getSource(), jSONObject.getJSONObject("top"), jSONObject.getJSONObject("bottom"));
                if (b41.d(iResponse.getSource(), "remote") || b41.d(iResponse.getSource(), Constants.ResponseSource.REMOTE_FILE)) {
                    handlePageUTParams(jSONObject.getString("pageName"), jSONObject.getString(UT_SPM_AB));
                }
            }
        }
        super.handleLoadSuccess(iResponse, i);
    }

    public void handleModuleNode(@NotNull ListIterator<Node> listIterator, @NotNull Node node) {
        b41.i(listIterator, "moduleIterator");
        b41.i(node, "moduleNode");
        List<Node> children = node.getChildren();
        boolean z = false;
        if (children == null || children.isEmpty()) {
            listIterator.remove();
            return;
        }
        List<Node> children2 = node.getChildren();
        if (children2 != null) {
            ListIterator<Node> listIterator2 = children2.listIterator();
            while (listIterator2.hasNext()) {
                if (isFilterComponent(listIterator2.next())) {
                    listIterator2.remove();
                }
            }
        }
        List<Node> children3 = node.getChildren();
        if ((children3 == null || children3.isEmpty()) ? true : true) {
            listIterator.remove();
        }
    }

    public void handleNode(@NotNull Node node) {
        b41.i(node, "node");
        List<Node> children = node.getChildren();
        if (!(!(children == null || children.isEmpty()))) {
            children = null;
        }
        if (children == null) {
            return;
        }
        ListIterator<Node> listIterator = children.listIterator();
        while (listIterator.hasNext()) {
            Node next = listIterator.next();
            int level = next.getLevel();
            if (level == 1) {
                handleModuleNode(listIterator, next);
            } else if (level == 2) {
                handleComponentNode(listIterator, next);
            } else if (level == 3) {
                handleItemNode(listIterator, next);
            }
            handleNode(next);
        }
    }

    public void handlePageBaseInfo(@Nullable String str, @Nullable JSONObject jSONObject, @Nullable JSONObject jSONObject2) {
        GenericFragment fragment = getHost().getPageContext().getFragment();
        BaseFragment baseFragment = fragment instanceof BaseFragment ? (BaseFragment) fragment : null;
        if (baseFragment == null) {
            return;
        }
        baseFragment.setTopBasePageInfo(jSONObject == null ? null : (PageInfoBean) jSONObject.toJavaObject(PageInfoBean.class));
        baseFragment.setBottomBasePageInfo(jSONObject2 != null ? (PageInfoBean) jSONObject2.toJavaObject(PageInfoBean.class) : null);
    }

    @Override // com.youku.arch.v3.loader.PageLoader
    @Nullable
    public Node parseNode(@NotNull JSONObject jSONObject) {
        b41.i(jSONObject, "response");
        Node parseNode = super.parseNode(jSONObject);
        if (parseNode == null) {
            return null;
        }
        handleNode(parseNode);
        GenericFragment fragment = getHost().getPageContext().getFragment();
        BaseFragment baseFragment = fragment instanceof BaseFragment ? (BaseFragment) fragment : null;
        if (baseFragment == null) {
            return parseNode;
        }
        baseFragment.updateABBucket(parseNode);
        return parseNode;
    }

    public final void removeComponentDecorate(int i, @NotNull ComponentDecorateItem componentDecorateItem) {
        b41.i(componentDecorateItem, "decorate");
        getComponentDecorator().removeComponentDecorate(i, componentDecorateItem);
    }

    @Override // com.youku.arch.v3.loader.PageLoader
    protected void setLoadingViewState(@NotNull final IResponse iResponse, boolean z) {
        final PageStateManager pageStateManager;
        b41.i(iResponse, "response");
        super.setLoadingViewState(iResponse, z);
        GenericFragment fragment = getHost().getPageContext().getFragment();
        if (fragment == null || (pageStateManager = fragment.getPageStateManager()) == null || !pageStateManager.isStateViewEnable()) {
            return;
        }
        getHost().getPageContext().runOnUIThread(new Function0<wt2>() { // from class: com.alient.onearch.adapter.loader.v2.GenericPagerLoader$setLoadingViewState$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final wt2 invoke() {
                StateView stateView = PageStateManager.this.stateView;
                if (stateView == null) {
                    return null;
                }
                IResponse iResponse2 = iResponse;
                IStateView stateView2 = stateView.getStateView(stateView.getCurrentState());
                if (stateView2 == null) {
                    return null;
                }
                stateView2.update(iResponse2.getRetCode(), iResponse2.getRetMessage());
                return wt2.INSTANCE;
            }
        });
    }

    public void createDecorateComponent(@NotNull Node node, @NotNull ComponentDecorateItem componentDecorateItem) {
        b41.i(node, "moduleNode");
        b41.i(componentDecorateItem, "componentDecorateItemNode");
        List<Node> children = node.getChildren();
        if (children == null) {
            return;
        }
        Node node2 = new Node();
        node2.setId(IdGenerator.getId());
        node2.setType(componentDecorateItem.getComponentType());
        node2.setLevel(2);
        node2.setParent(node);
        ArrayList arrayList = new ArrayList();
        Node node3 = new Node();
        node3.setId(IdGenerator.getId());
        node3.setType(componentDecorateItem.getItemType());
        node3.setLevel(3);
        node3.setData(componentDecorateItem.getData());
        node3.setParent(node2);
        wt2 wt2Var = wt2.INSTANCE;
        arrayList.add(node3);
        node2.setChildren(arrayList);
        children.add(node2);
    }
}
