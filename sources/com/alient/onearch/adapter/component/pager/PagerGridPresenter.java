package com.alient.onearch.adapter.component.pager;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import com.alient.onearch.adapter.component.pager.PagerGridContract;
import com.alient.onearch.adapter.view.AbsPresenter;
import com.google.common.collect.Lists;
import com.taobao.weex.common.Constants;
import com.uc.webview.export.extension.UCCore;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.adapter.VBaseAdapter;
import com.youku.arch.v3.adapter.VBaseHolder;
import com.youku.arch.v3.adapter.VDefaultAdapter;
import com.youku.arch.v3.core.ConfigManager;
import com.youku.arch.v3.core.Constants;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.event.EventHandler;
import com.youku.arch.v3.util.PageUtil;
import com.youku.arch.v3.util.ViewUtil;
import com.youku.arch.v3.view.config.ComponentConfigBean;
import com.youku.arch.v3.view.config.ComponentConfigManager;
import com.youku.arch.v3.view.render.GenericRenderConfig;
import io.flutter.wpkbridge.WPKFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.wt2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00012\u00020\u0006B3\u0012\u0006\u0010\u001c\u001a\u00020\n\u0012\u0006\u0010\u001d\u001a\u00020\n\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\u0006\u0010!\u001a\u00020 \u0012\b\u0010\"\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b#\u0010$J0\u0010\u000f\u001a\u00020\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\t2\u0006\u0010\r\u001a\u00020\nH\u0002J\u0016\u0010\u0012\u001a\u00020\u00112\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016R@\u0010\u0018\u001a,\u0012(\u0012&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0015\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0015\u0012\u0004\u0012\u00020\u00170\u00160\u00140\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006%"}, d2 = {"Lcom/alient/onearch/adapter/component/pager/PagerGridPresenter;", "Lcom/alient/onearch/adapter/view/AbsPresenter;", "Lcom/youku/arch/v3/core/item/GenericItem;", "Lcom/youku/arch/v3/core/ItemValue;", "Lcom/alient/onearch/adapter/component/pager/PagerGridModel;", "Lcom/alient/onearch/adapter/component/pager/PagerGridView;", "Lcom/alient/onearch/adapter/component/pager/PagerGridContract$Presenter;", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "", "", "", "data", "paramName", "", "getDimenId", "item", "Ltb/wt2;", UCCore.LEGACY_EVENT_INIT, "", "Lcom/youku/arch/v3/adapter/VBaseAdapter;", "Lcom/youku/arch/v3/IItem;", "Lcom/youku/arch/v3/adapter/VBaseHolder;", "Lcom/youku/arch/v3/view/render/GenericRenderConfig;", "childAdapters", "Ljava/util/List;", "historyItem", "Lcom/youku/arch/v3/core/item/GenericItem;", "mClassName", "vClassName", "Landroid/view/View;", "renderView", "Lcom/youku/arch/v3/event/EventHandler;", "eventHandler", Constants.CONFIG, "<init>", "(Ljava/lang/String;Ljava/lang/String;Landroid/view/View;Lcom/youku/arch/v3/event/EventHandler;Ljava/lang/String;)V", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes10.dex */
public class PagerGridPresenter extends AbsPresenter<GenericItem<ItemValue>, PagerGridModel, PagerGridView> implements PagerGridContract.Presenter {
    @NotNull
    private List<VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>>> childAdapters;
    @Nullable
    private GenericItem<ItemValue> historyItem;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PagerGridPresenter(@NotNull String str, @NotNull String str2, @Nullable View view, @NotNull EventHandler eventHandler, @Nullable String str3) {
        super(str, str2, view, eventHandler, str3);
        b41.i(str, "mClassName");
        b41.i(str2, "vClassName");
        b41.i(eventHandler, "eventHandler");
        this.childAdapters = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getDimenId(Context context, Map<String, ? extends Object> map, String str) {
        if (map.containsKey(str)) {
            return ViewUtil.getIdentifier(context, (String) map.get(str), com.youku.arch.v3.data.Constants.DIMEN);
        }
        return 0;
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.youku.arch.v3.view.AbsPresenter, com.youku.arch.v3.view.IContract.Presenter
    public void init(@NotNull final GenericItem<ItemValue> genericItem) {
        final Activity activity;
        b41.i(genericItem, "item");
        super.init((PagerGridPresenter) genericItem);
        if (b41.d(this.historyItem, genericItem) || (activity = genericItem.getPageContext().getActivity()) == null) {
            return;
        }
        this.historyItem = genericItem;
        this.childAdapters.clear();
        genericItem.getPageContext().runOnLoaderThread(new Function0<String>() { // from class: com.alient.onearch.adapter.component.pager.PagerGridPresenter$init$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r6v6, types: [T, java.lang.Integer] */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final String invoke() {
                String pathConfig;
                ComponentConfigBean.ComponentBean componentBean;
                ComponentConfigBean.ComponentBean.LayoutBean layout;
                HashMap<String, Object> params;
                int dimenId;
                int dimenId2;
                int dimenId3;
                int dimenId4;
                List<IItem<ItemValue>> list;
                List list2;
                ConfigManager configManager = genericItem.getPageContext().getConfigManager();
                if (configManager == null || (pathConfig = configManager.getPathConfig(ConfigManager.COMPONENT_CONFIG_FILE)) == null) {
                    return null;
                }
                Activity activity2 = activity;
                GenericItem<ItemValue> genericItem2 = genericItem;
                final PagerGridPresenter pagerGridPresenter = this;
                SparseArray<ComponentConfigBean.ComponentBean> componentConfigs = ComponentConfigManager.Companion.getInstance().getComponentConfigs(activity2, pathConfig);
                if (componentConfigs != null && (componentBean = componentConfigs.get(PageUtil.INSTANCE.getItemType(genericItem2))) != null && (layout = componentBean.getLayout()) != null && (params = layout.getParams()) != null) {
                    final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                    dimenId = pagerGridPresenter.getDimenId(activity2, params, "rowHeight");
                    if (dimenId != 0) {
                        ref$ObjectRef.element = Integer.valueOf(activity2.getResources().getDimensionPixelSize(dimenId));
                    }
                    final Ref$IntRef ref$IntRef = new Ref$IntRef();
                    dimenId2 = pagerGridPresenter.getDimenId(activity2, params, com.youku.arch.v3.data.Constants.GAP);
                    if (dimenId2 != 0) {
                        ref$IntRef.element = activity2.getResources().getDimensionPixelSize(dimenId2);
                    }
                    final Ref$IntRef ref$IntRef2 = new Ref$IntRef();
                    final Ref$IntRef ref$IntRef3 = new Ref$IntRef();
                    dimenId3 = pagerGridPresenter.getDimenId(activity2, params, "listMarginLeft");
                    if (dimenId3 != 0) {
                        ref$IntRef2.element = activity2.getResources().getDimensionPixelSize(dimenId3);
                    }
                    dimenId4 = pagerGridPresenter.getDimenId(activity2, params, "listMarginRight");
                    if (dimenId4 != 0) {
                        ref$IntRef3.element = activity2.getResources().getDimensionPixelSize(dimenId4);
                    }
                    Object obj = params.get("rowCount");
                    Integer num = obj instanceof Integer ? (Integer) obj : null;
                    Object obj2 = params.get(Constants.Name.COLUMN_COUNT);
                    final Integer num2 = obj2 instanceof Integer ? (Integer) obj2 : null;
                    VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> innerAdapter = genericItem2.getComponent().getInnerAdapter();
                    if (ref$ObjectRef.element != 0 && num != null && num2 != null && innerAdapter != null && (list = innerAdapter.data) != null) {
                        List<List> n = Lists.n(list, num.intValue() * num2.intValue());
                        b41.h(n, "partition(this, rowCount * columnCount)");
                        for (List list3 : n) {
                            Activity activity3 = genericItem2.getPageContext().getActivity();
                            b41.f(activity3);
                            VDefaultAdapter vDefaultAdapter = new VDefaultAdapter(activity3);
                            vDefaultAdapter.setPageContext(innerAdapter.getPageContext());
                            vDefaultAdapter.m1252setViewTypeSupport(innerAdapter.getViewTypeSupport());
                            vDefaultAdapter.setData(list3);
                            list2 = pagerGridPresenter.childAdapters;
                            list2.add(vDefaultAdapter);
                        }
                        genericItem2.getPageContext().runOnUIThreadLocked(new Function0<wt2>() { // from class: com.alient.onearch.adapter.component.pager.PagerGridPresenter$init$1$1$1$1$2
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
                                List<? extends VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>>> list4;
                                PagerGridView pagerGridView = (PagerGridView) PagerGridPresenter.this.getView();
                                int i = ref$IntRef.element;
                                int i2 = ref$IntRef2.element;
                                int i3 = ref$IntRef3.element;
                                int intValue = ref$ObjectRef.element.intValue();
                                int intValue2 = num2.intValue();
                                list4 = PagerGridPresenter.this.childAdapters;
                                pagerGridView.renderPagerInView(i, i2, i3, intValue, intValue2, list4);
                            }
                        });
                    }
                }
                return pathConfig;
            }
        });
    }
}
