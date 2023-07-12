package com.youku.arch.v3.creator;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.alibaba.android.vlayout.layout.BaseLayoutHelper;
import com.alibaba.android.vlayout.layout.StickyLayoutHelper;
import com.alibaba.android.vlayout.layout.c;
import com.alibaba.android.vlayout.layout.e;
import com.alibaba.android.vlayout.layout.h;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.common.Constants;
import com.youku.arch.v3.ICreator;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.adapter.VBaseAdapter;
import com.youku.arch.v3.adapter.VBaseHolder;
import com.youku.arch.v3.adapter.VDefaultAdapter;
import com.youku.arch.v3.adapter.ViewTypeSupport;
import com.youku.arch.v3.core.Config;
import com.youku.arch.v3.core.Constants;
import com.youku.arch.v3.core.IContext;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.recyclerview.layouthelper.FeedStaggeredGridLayoutHelper;
import com.youku.arch.v3.recyclerview.layouthelper.GridFixAutoStatLayoutHelper;
import com.youku.arch.v3.recyclerview.layouthelper.StaggeredGridLayoutHelper;
import com.youku.arch.v3.util.ColorUtil;
import com.youku.arch.v3.util.DimenUtil;
import com.youku.arch.v3.util.LogUtil;
import com.youku.arch.v3.util.ViewUtil;
import com.youku.arch.v3.view.render.GenericRenderConfig;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import io.flutter.wpkbridge.WPKFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.m;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joor.a;
import tb.b41;
import tb.k50;
import tb.tq2;
import tb.ye2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 >2B\u0012*\u0012(\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u0002\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00070\u0001:\u0001>B\u000f\u0012\u0006\u00103\u001a\u000202¢\u0006\u0004\b<\u0010=JJ\u0010\f\u001a(\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u00022\u001a\u0010\u000b\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00070\nH\u0002JJ\u0010\r\u001a(\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u00022\u001a\u0010\u000b\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00070\nH\u0002JV\u0010\u0013\u001a&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0004\u0012\u00020\u00060\u00050\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\b2\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0011H\u0002JT\u0010\u0014\u001a&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0004\u0012\u00020\u00060\u00050\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\b2\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0011H\u0002JT\u0010\u0015\u001a&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0004\u0012\u00020\u00060\u00050\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\b2\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0011H\u0002JT\u0010\u0016\u001a&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0004\u0012\u00020\u00060\u00050\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\b2\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007H\u0002JT\u0010\u0017\u001a&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0004\u0012\u00020\u00060\u00050\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\b2\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007H\u0002JT\u0010\u0018\u001a&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0004\u0012\u00020\u00060\u00050\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\b2\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007H\u0002J^\u0010\u001a\u001a&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0004\u0012\u00020\u00060\u00050\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\b2\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007H\u0002JT\u0010\u001b\u001a&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0004\u0012\u00020\u00060\u00050\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\b2\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007H\u0002JT\u0010\u001c\u001a&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0004\u0012\u00020\u00060\u00050\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\b2\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007H\u0002J0\u0010 \u001a\u00020\u000e2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00112\u0006\u0010\u001f\u001a\u00020\bH\u0002J&\u0010$\u001a\u00020\u000e2\u0014\u0010\"\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010!2\u0006\u0010#\u001a\u00020\u000eH\u0002J&\u0010(\u001a\u00020'2\u0006\u0010&\u001a\u00020%2\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0011H\u0002J4\u0010*\u001a\u00020'2\u0006\u0010&\u001a\u00020%2\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00112\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J&\u0010,\u001a\u00020'2\u0006\u0010+\u001a\u00020%2\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0011H\u0002J4\u0010-\u001a\u00020'2\u0006\u0010+\u001a\u00020%2\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00112\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J&\u0010.\u001a\u00020'2\u0006\u0010+\u001a\u00020%2\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0011H\u0002J&\u0010/\u001a\u00020'2\u0006\u0010+\u001a\u00020%2\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0011H\u0002J,\u00100\u001a\u00020\u000e2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u000e\u0010\u0012\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00112\b\u0010\u001f\u001a\u0004\u0018\u00010\bH\u0002JJ\u00101\u001a(\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u00022\u001a\u0010\u000b\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00070\nH\u0016R\u0016\u00103\u001a\u0002028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001e\u00105R\u0018\u00107\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u00109\u001a\u00020\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010;\u001a\u00020\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010:¨\u0006?"}, d2 = {"Lcom/youku/arch/v3/creator/AdapterCreator;", "Lcom/youku/arch/v3/ICreator;", "Lcom/youku/arch/v3/adapter/VBaseAdapter;", "Lcom/youku/arch/v3/IItem;", "Lcom/youku/arch/v3/core/ItemValue;", "Lcom/youku/arch/v3/adapter/VBaseHolder;", "Lcom/youku/arch/v3/view/render/GenericRenderConfig;", "", "", "", "Lcom/youku/arch/v3/core/Config;", Constants.CONFIG, "createAdapter", "createAdapterFromConfigFile", "", "type", "adapterClass", "", "data", "createGridLayoutAdapter", "createStaggeredLayoutAdapter", "createFeedListLayoutAdapter", "createStickyLayoutAdapter", "createOnePlusNLayoutAdapter", "createSingleLayoutAdapter", "innerAdapterClass", "createSingleLayoutAdapterWithInnerAdapter", "createSingleLayoutAdapterWithRawListAdapter", "createLinearLayoutAdapter", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "paramName", "getDimenId", "", "dataList", "span", "updateSpanByData", "Lcom/alibaba/android/vlayout/layout/BaseLayoutHelper;", "gridLayoutHelper", "Ltb/wt2;", "handleGapParams", "iItem", "handleIntelligenceUiGapParams", "baseLayoutHelper", "handleMarginParams", "handleIntelligenceUiMarginParams", "handlePaddingParams", "handleBackground", "getResourceId", "create", "Lcom/youku/arch/v3/core/IContext;", com.youku.arch.v3.data.Constants.PAGE_CONTEXT, "Lcom/youku/arch/v3/core/IContext;", "Landroid/content/Context;", "Lcom/youku/arch/v3/adapter/ViewTypeSupport;", "viewTypeSupport", "Lcom/youku/arch/v3/adapter/ViewTypeSupport;", "defaultLayoutName", "Ljava/lang/String;", "defaultHolderClassName", "<init>", "(Lcom/youku/arch/v3/core/IContext;)V", "Companion", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class AdapterCreator implements ICreator<VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>>, Map<String, Object>> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final String TAG = "OneArch.AdapterCreator";
    private Context context;
    @NotNull
    private final String defaultHolderClassName;
    @NotNull
    private final String defaultLayoutName;
    @NotNull
    private final IContext pageContext;
    @Nullable
    private final ViewTypeSupport viewTypeSupport;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002R\u0016\u0010\n\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/youku/arch/v3/creator/AdapterCreator$Companion;", "", "", "type", "", "adapterClass", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Lcom/youku/arch/v3/adapter/VDefaultAdapter;", "innerCreateAdapter", "TAG", "Ljava/lang/String;", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private static transient /* synthetic */ IpChange $ipChange;

        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final VDefaultAdapter innerCreateAdapter(int i, String str, Context context) {
            VDefaultAdapter vDefaultAdapter;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1565390946")) {
                return (VDefaultAdapter) ipChange.ipc$dispatch("1565390946", new Object[]{this, Integer.valueOf(i), str, context});
            }
            if (!TextUtils.isEmpty(str)) {
                Object f = a.j(str).c(context).f();
                b41.h(f, "{\n                Reflec…text).get()\n            }");
                vDefaultAdapter = (VDefaultAdapter) f;
            } else {
                b41.f(context);
                vDefaultAdapter = new VDefaultAdapter(context);
            }
            LogUtil.d(AdapterCreator.TAG, b41.r("innerCreateAdapter for component type:", Integer.valueOf(i)));
            return vDefaultAdapter;
        }
    }

    public AdapterCreator(@NotNull IContext iContext) {
        Application application;
        b41.i(iContext, com.youku.arch.v3.data.Constants.PAGE_CONTEXT);
        this.pageContext = iContext;
        Activity activity = iContext.getActivity();
        Activity activity2 = null;
        activity = activity != null ? activity : null;
        if (activity != null) {
            this.context = activity;
            activity2 = activity;
        }
        if (activity2 == null && (application = iContext.getApplication()) != null) {
            this.context = application;
        }
        this.defaultLayoutName = com.youku.arch.v3.data.Constants.RES_DEFAULT_LAYOUT;
        this.defaultHolderClassName = com.youku.arch.v3.data.Constants.CLASS_DEFAULT_VIEW_HOLDER;
        this.viewTypeSupport = iContext.getViewTypeSupport();
    }

    private final VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> createAdapter(Config<Map<String, Object>> config) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1559262903")) {
            return (VBaseAdapter) ipChange.ipc$dispatch("-1559262903", new Object[]{this, config});
        }
        VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> vBaseAdapter = null;
        if (config.getData().containsKey(com.youku.arch.v3.data.Constants.LAYOUT_TYPE)) {
            String str = (String) config.getData().get(com.youku.arch.v3.data.Constants.LAYOUT_TYPE);
            if (b41.d(str, "grid")) {
                vBaseAdapter = createGridLayoutAdapter(config.getType(), null, config.getData());
            } else if (b41.d(str, "staggered")) {
                vBaseAdapter = createStaggeredLayoutAdapter(config.getType(), null, config.getData());
            }
        }
        if (vBaseAdapter != null) {
            Object obj = config.getData().get(com.youku.arch.v3.data.Constants.PAGE_CONTEXT);
            Objects.requireNonNull(obj, "null cannot be cast to non-null type com.youku.arch.v3.core.IContext");
            vBaseAdapter.setPageContext((IContext) obj);
        }
        return vBaseAdapter;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final com.youku.arch.v3.adapter.VBaseAdapter<com.youku.arch.v3.IItem<com.youku.arch.v3.core.ItemValue>, com.youku.arch.v3.adapter.VBaseHolder<com.youku.arch.v3.IItem<com.youku.arch.v3.core.ItemValue>, com.youku.arch.v3.view.render.GenericRenderConfig>> createAdapterFromConfigFile(com.youku.arch.v3.core.Config<java.util.Map<java.lang.String, java.lang.Object>> r7) {
        /*
            Method dump skipped, instructions count: 552
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.arch.v3.creator.AdapterCreator.createAdapterFromConfigFile(com.youku.arch.v3.core.Config):com.youku.arch.v3.adapter.VBaseAdapter");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> createFeedListLayoutAdapter(int i, String str, Map<String, ? extends Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1774616387")) {
            return (VBaseAdapter) ipChange.ipc$dispatch("-1774616387", new Object[]{this, Integer.valueOf(i), str, map});
        }
        Object obj = map.get("span");
        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) obj).intValue();
        Object obj2 = map.get("data");
        Context context = null;
        List list = tq2.m(obj2) ? (List) obj2 : null;
        FeedStaggeredGridLayoutHelper feedStaggeredGridLayoutHelper = new FeedStaggeredGridLayoutHelper(intValue);
        Activity activity = this.pageContext.getActivity();
        if (activity != null) {
            intValue = ye2.INSTANCE.d(activity, intValue);
        }
        feedStaggeredGridLayoutHelper.setLane(intValue);
        Context context2 = this.context;
        if (context2 == null) {
            b41.A(WPKFactory.INIT_KEY_CONTEXT);
            context2 = null;
        }
        int resourceId = getResourceId(context2, map, com.youku.arch.v3.data.Constants.V_GAP);
        if (resourceId != 0) {
            Context context3 = this.context;
            if (context3 == null) {
                b41.A(WPKFactory.INIT_KEY_CONTEXT);
                context3 = null;
            }
            feedStaggeredGridLayoutHelper.setVGap(context3.getResources().getDimensionPixelSize(resourceId));
        }
        Context context4 = this.context;
        if (context4 == null) {
            b41.A(WPKFactory.INIT_KEY_CONTEXT);
            context4 = null;
        }
        int resourceId2 = getResourceId(context4, map, com.youku.arch.v3.data.Constants.H_GAP);
        if (resourceId2 != 0) {
            Context context5 = this.context;
            if (context5 == null) {
                b41.A(WPKFactory.INIT_KEY_CONTEXT);
                context5 = null;
            }
            feedStaggeredGridLayoutHelper.setHGap(context5.getResources().getDimensionPixelSize(resourceId2));
        }
        Context context6 = this.context;
        if (context6 == null) {
            b41.A(WPKFactory.INIT_KEY_CONTEXT);
            context6 = null;
        }
        int resourceId3 = getResourceId(context6, map, com.youku.arch.v3.data.Constants.GAP);
        if (resourceId3 != 0) {
            Context context7 = this.context;
            if (context7 == null) {
                b41.A(WPKFactory.INIT_KEY_CONTEXT);
                context7 = null;
            }
            feedStaggeredGridLayoutHelper.setGap(context7.getResources().getDimensionPixelSize(resourceId3));
        }
        handleMarginParams(feedStaggeredGridLayoutHelper, map);
        handlePaddingParams(feedStaggeredGridLayoutHelper, map);
        handleBackground(feedStaggeredGridLayoutHelper, map);
        Companion companion = Companion;
        Context context8 = this.context;
        if (context8 == null) {
            b41.A(WPKFactory.INIT_KEY_CONTEXT);
        } else {
            context = context8;
        }
        return companion.innerCreateAdapter(i, str, context).setLayoutHelper((com.alibaba.android.vlayout.a) feedStaggeredGridLayoutHelper).setData(list).setViewTypeSupport(this.viewTypeSupport).setLevel(3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> createGridLayoutAdapter(int i, String str, Map<String, ? extends Object> map) {
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "-1153012589")) {
            return (VBaseAdapter) ipChange.ipc$dispatch("-1153012589", new Object[]{this, Integer.valueOf(i), str, map});
        }
        Context context = null;
        Object obj = map == null ? null : map.get("span");
        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) obj).intValue();
        Object obj2 = map.get("data");
        List list = tq2.m(obj2) ? (List) obj2 : null;
        int updateSpanByData = updateSpanByData(list, intValue);
        GridFixAutoStatLayoutHelper gridFixAutoStatLayoutHelper = new GridFixAutoStatLayoutHelper(updateSpanByData);
        Activity activity = this.pageContext.getActivity();
        if (activity != null) {
            updateSpanByData = ye2.INSTANCE.d(activity, updateSpanByData);
        }
        gridFixAutoStatLayoutHelper.setSpanCount(updateSpanByData);
        JSONArray jSONArray = (JSONArray) map.get("weights");
        if (jSONArray != null && jSONArray.size() > 0) {
            float[] fArr = new float[jSONArray.size()];
            int size = jSONArray.size() - 1;
            if (size >= 0) {
                while (true) {
                    int i3 = i2 + 1;
                    fArr[i2] = jSONArray.getFloatValue(i2);
                    if (i3 > size) {
                        break;
                    }
                    i2 = i3;
                }
            }
            gridFixAutoStatLayoutHelper.setWeights(fArr);
        }
        handleGapParams(gridFixAutoStatLayoutHelper, map);
        handleMarginParams(gridFixAutoStatLayoutHelper, map);
        gridFixAutoStatLayoutHelper.setSpanSizeLookup((GridFixAutoStatLayoutHelper.SpanSizeLookup) map.get("spanSizeLookup"));
        Companion companion = Companion;
        Context context2 = this.context;
        if (context2 == null) {
            b41.A(WPKFactory.INIT_KEY_CONTEXT);
        } else {
            context = context2;
        }
        return companion.innerCreateAdapter(i, str, context).setLayoutHelper((com.alibaba.android.vlayout.a) gridFixAutoStatLayoutHelper).setData(list).setLevel(3).setViewTypeSupport(this.viewTypeSupport);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> createLinearLayoutAdapter(int i, String str, Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "1847722324")) {
            return (VBaseAdapter) ipChange.ipc$dispatch("1847722324", new Object[]{this, Integer.valueOf(i), str, map});
        }
        Context context = this.context;
        Context context2 = null;
        if (context == null) {
            b41.A(WPKFactory.INIT_KEY_CONTEXT);
            context = null;
        }
        int dimenId = getDimenId(context, map, com.youku.arch.v3.data.Constants.DIVIDER_HEIGHT);
        if (dimenId != 0) {
            Context context3 = this.context;
            if (context3 == null) {
                b41.A(WPKFactory.INIT_KEY_CONTEXT);
                context3 = null;
            }
            i2 = context3.getResources().getDimensionPixelSize(dimenId);
        }
        Object obj = map.get("data");
        List list = tq2.m(obj) ? (List) obj : null;
        c cVar = new c(i2);
        handleMarginParams(cVar, map);
        handlePaddingParams(cVar, map);
        handleBackground(cVar, map);
        Companion companion = Companion;
        Context context4 = this.context;
        if (context4 == null) {
            b41.A(WPKFactory.INIT_KEY_CONTEXT);
        } else {
            context2 = context4;
        }
        return companion.innerCreateAdapter(i, str, context2).setLayoutHelper((com.alibaba.android.vlayout.a) cVar).setData(list).setViewTypeSupport(this.viewTypeSupport);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> createOnePlusNLayoutAdapter(int i, String str, Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1253053739")) {
            return (VBaseAdapter) ipChange.ipc$dispatch("1253053739", new Object[]{this, Integer.valueOf(i), str, map});
        }
        Object obj = map.get("data");
        Context context = null;
        List list = tq2.m(obj) ? (List) obj : null;
        b41.f(list);
        if (list.size() <= 3) {
            return createGridLayoutAdapter(i, str, map);
        }
        e eVar = new e();
        handleGapParams(eVar, map);
        handleMarginParams(eVar, map);
        Companion companion = Companion;
        Context context2 = this.context;
        if (context2 == null) {
            b41.A(WPKFactory.INIT_KEY_CONTEXT);
        } else {
            context = context2;
        }
        return companion.innerCreateAdapter(i, str, context).setLayoutHelper((com.alibaba.android.vlayout.a) eVar).setData(list).setViewTypeSupport(this.viewTypeSupport).setLevel(3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> createSingleLayoutAdapter(int i, String str, Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "854827409")) {
            return (VBaseAdapter) ipChange.ipc$dispatch("854827409", new Object[]{this, Integer.valueOf(i), str, map});
        }
        Object obj = map.get("data");
        Context context = null;
        List list = tq2.m(obj) ? (List) obj : null;
        h hVar = new h();
        handleMarginParams(hVar, map);
        handlePaddingParams(hVar, map);
        handleBackground(hVar, map);
        Companion companion = Companion;
        Context context2 = this.context;
        if (context2 == null) {
            b41.A(WPKFactory.INIT_KEY_CONTEXT);
        } else {
            context = context2;
        }
        return companion.innerCreateAdapter(i, str, context).setLayoutHelper((com.alibaba.android.vlayout.a) hVar).setData(list).setViewTypeSupport(this.viewTypeSupport);
    }

    /* JADX WARN: Type inference failed for: r8v4, types: [com.youku.arch.v3.core.ItemValue, com.youku.arch.v3.core.Node] */
    /* JADX WARN: Type inference failed for: r8v5, types: [com.youku.arch.v3.core.ItemValue, com.youku.arch.v3.core.Node] */
    private final VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> createSingleLayoutAdapterWithInnerAdapter(int i, String str, String str2, Map<String, Object> map) {
        List m;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-105273798")) {
            return (VBaseAdapter) ipChange.ipc$dispatch("-105273798", new Object[]{this, Integer.valueOf(i), str, str2, map});
        }
        Object obj = map.get("data");
        Context context = null;
        List list = tq2.m(obj) ? (List) obj : null;
        Companion companion = Companion;
        Context context2 = this.context;
        if (context2 == null) {
            b41.A(WPKFactory.INIT_KEY_CONTEXT);
            context2 = null;
        }
        VDefaultAdapter innerCreateAdapter = companion.innerCreateAdapter(i, str, context2);
        GenericItem genericItem = new GenericItem(this.pageContext);
        if (!(list == null || list.isEmpty())) {
            genericItem.setComponent(((IItem) list.get(0)).getComponent());
        }
        genericItem.setProperty(new ItemValue());
        genericItem.getProperty().setType(i);
        genericItem.getProperty().setData(new JSONObject());
        genericItem.setType(i);
        h hVar = new h();
        handleMarginParams(hVar, map);
        handlePaddingParams(hVar, map);
        handleBackground(hVar, map);
        m = m.m(genericItem);
        innerCreateAdapter.setData(m).setLayoutHelper((com.alibaba.android.vlayout.a) hVar).setRenderCount(1).setViewTypeSupport(this.viewTypeSupport);
        Context context3 = this.context;
        if (context3 == null) {
            b41.A(WPKFactory.INIT_KEY_CONTEXT);
        } else {
            context = context3;
        }
        VDefaultAdapter innerCreateAdapter2 = companion.innerCreateAdapter(i, str2, context);
        innerCreateAdapter2.setData(list).setLevel(3).setViewTypeSupport(this.viewTypeSupport).setPageContext(this.pageContext);
        innerCreateAdapter.setInnerAdapter(innerCreateAdapter2);
        return innerCreateAdapter;
    }

    /* JADX WARN: Type inference failed for: r5v4, types: [com.youku.arch.v3.core.ItemValue, com.youku.arch.v3.core.Node] */
    /* JADX WARN: Type inference failed for: r5v6, types: [com.youku.arch.v3.core.ItemValue, com.youku.arch.v3.core.Node] */
    private final VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> createSingleLayoutAdapterWithRawListAdapter(int i, String str, Map<String, Object> map) {
        List m;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "6651296")) {
            return (VBaseAdapter) ipChange.ipc$dispatch("6651296", new Object[]{this, Integer.valueOf(i), str, map});
        }
        Object obj = map.get("data");
        List<IItem> list = tq2.m(obj) ? (List) obj : null;
        Companion companion = Companion;
        Context context = this.context;
        if (context == null) {
            b41.A(WPKFactory.INIT_KEY_CONTEXT);
            context = null;
        }
        VDefaultAdapter innerCreateAdapter = companion.innerCreateAdapter(i, str, context);
        GenericItem genericItem = new GenericItem(this.pageContext);
        genericItem.setProperty(new ItemValue());
        genericItem.getProperty().setChildren(new ArrayList());
        genericItem.setType(i);
        if (!(list == null || list.isEmpty())) {
            genericItem.setComponent(((IItem) list.get(0)).getComponent());
            for (IItem iItem : list) {
                List<Node> children = genericItem.getProperty().getChildren();
                if (children != null) {
                    children.add(iItem.getProperty());
                }
            }
        }
        BaseLayoutHelper hVar = new h();
        Object obj2 = map.get("sticky");
        String str2 = obj2 instanceof String ? (String) obj2 : null;
        if (str2 != null && b41.d(str2, "true")) {
            hVar = new StickyLayoutHelper();
        }
        handleMarginParams(hVar, map);
        handlePaddingParams(hVar, map);
        handleBackground(hVar, map);
        m = m.m(genericItem);
        innerCreateAdapter.setData(m).setLayoutHelper((com.alibaba.android.vlayout.a) hVar).setViewTypeSupport(this.viewTypeSupport);
        return innerCreateAdapter;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> createStaggeredLayoutAdapter(int i, String str, Map<String, ? extends Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "496003275")) {
            return (VBaseAdapter) ipChange.ipc$dispatch("496003275", new Object[]{this, Integer.valueOf(i), str, map});
        }
        Object obj = map.get("span");
        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) obj).intValue();
        StaggeredGridLayoutHelper staggeredGridLayoutHelper = new StaggeredGridLayoutHelper(intValue);
        Activity activity = this.pageContext.getActivity();
        if (activity != null) {
            intValue = ye2.INSTANCE.d(activity, intValue);
        }
        staggeredGridLayoutHelper.setLane(intValue);
        Object obj2 = map.get("data");
        Context context = null;
        List list = tq2.m(obj2) ? (List) obj2 : null;
        Context context2 = this.context;
        if (context2 == null) {
            b41.A(WPKFactory.INIT_KEY_CONTEXT);
            context2 = null;
        }
        int resourceId = getResourceId(context2, map, com.youku.arch.v3.data.Constants.V_GAP);
        if (resourceId != 0) {
            Context context3 = this.context;
            if (context3 == null) {
                b41.A(WPKFactory.INIT_KEY_CONTEXT);
                context3 = null;
            }
            staggeredGridLayoutHelper.setVGap(context3.getResources().getDimensionPixelSize(resourceId));
        }
        Context context4 = this.context;
        if (context4 == null) {
            b41.A(WPKFactory.INIT_KEY_CONTEXT);
            context4 = null;
        }
        int resourceId2 = getResourceId(context4, map, com.youku.arch.v3.data.Constants.H_GAP);
        if (resourceId2 != 0) {
            Context context5 = this.context;
            if (context5 == null) {
                b41.A(WPKFactory.INIT_KEY_CONTEXT);
                context5 = null;
            }
            staggeredGridLayoutHelper.setHGap(context5.getResources().getDimensionPixelSize(resourceId2));
        }
        Context context6 = this.context;
        if (context6 == null) {
            b41.A(WPKFactory.INIT_KEY_CONTEXT);
            context6 = null;
        }
        int resourceId3 = getResourceId(context6, map, com.youku.arch.v3.data.Constants.GAP);
        if (resourceId3 != 0) {
            Context context7 = this.context;
            if (context7 == null) {
                b41.A(WPKFactory.INIT_KEY_CONTEXT);
                context7 = null;
            }
            staggeredGridLayoutHelper.setGap(context7.getResources().getDimensionPixelSize(resourceId3));
        }
        handleMarginParams(staggeredGridLayoutHelper, map);
        handlePaddingParams(staggeredGridLayoutHelper, map);
        handleBackground(staggeredGridLayoutHelper, map);
        Companion companion = Companion;
        Context context8 = this.context;
        if (context8 == null) {
            b41.A(WPKFactory.INIT_KEY_CONTEXT);
        } else {
            context = context8;
        }
        return companion.innerCreateAdapter(i, str, context).setLayoutHelper((com.alibaba.android.vlayout.a) staggeredGridLayoutHelper).setData(list).setViewTypeSupport(this.viewTypeSupport).setLevel(3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> createStickyLayoutAdapter(int i, String str, Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1072259856")) {
            return (VBaseAdapter) ipChange.ipc$dispatch("1072259856", new Object[]{this, Integer.valueOf(i), str, map});
        }
        StickyLayoutHelper stickyLayoutHelper = new StickyLayoutHelper();
        Object obj = map.get("data");
        Context context = null;
        List list = tq2.m(obj) ? (List) obj : null;
        handleMarginParams(stickyLayoutHelper, map);
        Object obj2 = map.get("offset");
        Integer num = obj2 instanceof Integer ? (Integer) obj2 : null;
        if (num != null) {
            stickyLayoutHelper.h(num.intValue());
        }
        Companion companion = Companion;
        Context context2 = this.context;
        if (context2 == null) {
            b41.A(WPKFactory.INIT_KEY_CONTEXT);
        } else {
            context = context2;
        }
        return companion.innerCreateAdapter(i, str, context).setLayoutHelper((com.alibaba.android.vlayout.a) stickyLayoutHelper).setData(list).setRenderCount(1).setViewTypeSupport(this.viewTypeSupport);
    }

    private final int getDimenId(Context context, Map<String, ? extends Object> map, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1742101766")) {
            return ((Integer) ipChange.ipc$dispatch("1742101766", new Object[]{this, context, map, str})).intValue();
        }
        if (map.containsKey(str)) {
            return ViewUtil.getIdentifier(context, (String) map.get(str), com.youku.arch.v3.data.Constants.DIMEN);
        }
        return 0;
    }

    private final int getResourceId(Context context, Map<?, ?> map, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1565511901")) {
            return ((Integer) ipChange.ipc$dispatch("-1565511901", new Object[]{this, context, map, str})).intValue();
        }
        Objects.requireNonNull(map, "null cannot be cast to non-null type kotlin.collections.Map<K, *>");
        if (map.containsKey(str)) {
            return ViewUtil.getIdentifier(context, (String) map.get(str), com.youku.arch.v3.data.Constants.DIMEN);
        }
        return 0;
    }

    private final void handleBackground(BaseLayoutHelper baseLayoutHelper, Map<String, ? extends Object> map) {
        int parseColorSafely;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-917092434")) {
            ipChange.ipc$dispatch("-917092434", new Object[]{this, baseLayoutHelper, map});
            return;
        }
        String str = (String) map.get("backgroundColor");
        if (str != null && str.length() != 0) {
            z = false;
        }
        if (z || (parseColorSafely = ColorUtil.parseColorSafely(str)) == 0) {
            return;
        }
        baseLayoutHelper.setBgColor(parseColorSafely);
    }

    private final void handleGapParams(BaseLayoutHelper baseLayoutHelper, Map<String, ? extends Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1083139722")) {
            ipChange.ipc$dispatch("-1083139722", new Object[]{this, baseLayoutHelper, map});
            return;
        }
        List list = (List) map.get("data");
        if (list == null || !(!list.isEmpty())) {
            return;
        }
        handleIntelligenceUiGapParams(baseLayoutHelper, map, (IItem) list.get(0));
    }

    private final void handleIntelligenceUiGapParams(BaseLayoutHelper baseLayoutHelper, Map<String, ? extends Object> map, IItem<ItemValue> iItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1692376759")) {
            ipChange.ipc$dispatch("-1692376759", new Object[]{this, baseLayoutHelper, map, iItem});
            return;
        }
        Context context = this.context;
        Context context2 = null;
        if (context == null) {
            b41.A(WPKFactory.INIT_KEY_CONTEXT);
            context = null;
        }
        int dimenId = getDimenId(context, map, com.youku.arch.v3.data.Constants.H_GAP);
        int type = iItem.getType();
        if (dimenId != 0) {
            if (AppInfoProviderProxy.isDebuggable()) {
                Object[] objArr = new Object[1];
                StringBuilder sb = new StringBuilder();
                sb.append("id!=0,type:");
                sb.append(type);
                sb.append(" ,setHGap:");
                Context context3 = this.context;
                if (context3 == null) {
                    b41.A(WPKFactory.INIT_KEY_CONTEXT);
                    context3 = null;
                }
                sb.append(DimenUtil.getDimensionPixelSize(context3, dimenId));
                objArr[0] = sb.toString();
                LogUtil.d(TAG, objArr);
            }
            if (baseLayoutHelper instanceof GridFixAutoStatLayoutHelper) {
                GridFixAutoStatLayoutHelper gridFixAutoStatLayoutHelper = (GridFixAutoStatLayoutHelper) baseLayoutHelper;
                Context context4 = this.context;
                if (context4 == null) {
                    b41.A(WPKFactory.INIT_KEY_CONTEXT);
                    context4 = null;
                }
                gridFixAutoStatLayoutHelper.setHGap(DimenUtil.getDimensionPixelSize(context4, dimenId));
            }
        }
        Context context5 = this.context;
        if (context5 == null) {
            b41.A(WPKFactory.INIT_KEY_CONTEXT);
            context5 = null;
        }
        int dimenId2 = getDimenId(context5, map, com.youku.arch.v3.data.Constants.V_GAP);
        if (dimenId2 != 0) {
            if (AppInfoProviderProxy.isDebuggable()) {
                Object[] objArr2 = new Object[1];
                StringBuilder sb2 = new StringBuilder();
                sb2.append("id!=0,type:");
                sb2.append(type);
                sb2.append(" ,setVGap:");
                Context context6 = this.context;
                if (context6 == null) {
                    b41.A(WPKFactory.INIT_KEY_CONTEXT);
                    context6 = null;
                }
                sb2.append(DimenUtil.getDimensionPixelSize(context6, dimenId2));
                objArr2[0] = sb2.toString();
                LogUtil.d(TAG, objArr2);
            }
            if (baseLayoutHelper instanceof GridFixAutoStatLayoutHelper) {
                GridFixAutoStatLayoutHelper gridFixAutoStatLayoutHelper2 = (GridFixAutoStatLayoutHelper) baseLayoutHelper;
                Context context7 = this.context;
                if (context7 == null) {
                    b41.A(WPKFactory.INIT_KEY_CONTEXT);
                } else {
                    context2 = context7;
                }
                gridFixAutoStatLayoutHelper2.setVGap(DimenUtil.getDimensionPixelSize(context2, dimenId2));
            }
        }
    }

    private final void handleIntelligenceUiMarginParams(BaseLayoutHelper baseLayoutHelper, Map<String, ? extends Object> map, IItem<ItemValue> iItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1416271421")) {
            ipChange.ipc$dispatch("1416271421", new Object[]{this, baseLayoutHelper, map, iItem});
            return;
        }
        int type = iItem.getType();
        Context context = this.context;
        Context context2 = null;
        if (context == null) {
            b41.A(WPKFactory.INIT_KEY_CONTEXT);
            context = null;
        }
        int dimenId = getDimenId(context, map, Constants.Name.MARGIN_LEFT);
        if (dimenId != 0) {
            Context context3 = this.context;
            if (context3 == null) {
                b41.A(WPKFactory.INIT_KEY_CONTEXT);
                context3 = null;
            }
            baseLayoutHelper.setMarginLeft(context3.getResources().getDimensionPixelSize(dimenId));
            if (AppInfoProviderProxy.isDebuggable()) {
                Object[] objArr = new Object[1];
                StringBuilder sb = new StringBuilder();
                sb.append("id!=0,type:");
                sb.append(type);
                sb.append(" ,marginLeft:");
                Context context4 = this.context;
                if (context4 == null) {
                    b41.A(WPKFactory.INIT_KEY_CONTEXT);
                    context4 = null;
                }
                sb.append(context4.getResources().getDimensionPixelSize(dimenId));
                objArr[0] = sb.toString();
                LogUtil.d(TAG, objArr);
            }
        }
        Context context5 = this.context;
        if (context5 == null) {
            b41.A(WPKFactory.INIT_KEY_CONTEXT);
            context5 = null;
        }
        int dimenId2 = getDimenId(context5, map, Constants.Name.MARGIN_RIGHT);
        if (dimenId2 != 0) {
            Context context6 = this.context;
            if (context6 == null) {
                b41.A(WPKFactory.INIT_KEY_CONTEXT);
                context6 = null;
            }
            baseLayoutHelper.setMarginRight(context6.getResources().getDimensionPixelSize(dimenId2));
            if (AppInfoProviderProxy.isDebuggable()) {
                Object[] objArr2 = new Object[1];
                StringBuilder sb2 = new StringBuilder();
                sb2.append("id!=0,type:");
                sb2.append(type);
                sb2.append(" ,marginRight:");
                Context context7 = this.context;
                if (context7 == null) {
                    b41.A(WPKFactory.INIT_KEY_CONTEXT);
                    context7 = null;
                }
                sb2.append(context7.getResources().getDimensionPixelSize(dimenId2));
                objArr2[0] = sb2.toString();
                LogUtil.d(TAG, objArr2);
            }
        }
        Context context8 = this.context;
        if (context8 == null) {
            b41.A(WPKFactory.INIT_KEY_CONTEXT);
            context8 = null;
        }
        int dimenId3 = getDimenId(context8, map, Constants.Name.MARGIN_TOP);
        if (dimenId3 != 0) {
            Context context9 = this.context;
            if (context9 == null) {
                b41.A(WPKFactory.INIT_KEY_CONTEXT);
                context9 = null;
            }
            int dimensionPixelSize = context9.getResources().getDimensionPixelSize(dimenId3);
            if (AppInfoProviderProxy.isDebuggable()) {
                LogUtil.d(TAG, "id!=0,type:" + type + " ,marginTop:" + dimensionPixelSize);
            }
            baseLayoutHelper.setMarginTop(dimensionPixelSize);
        }
        Context context10 = this.context;
        if (context10 == null) {
            b41.A(WPKFactory.INIT_KEY_CONTEXT);
            context10 = null;
        }
        int dimenId4 = getDimenId(context10, map, Constants.Name.MARGIN_BOTTOM);
        if (dimenId4 != 0) {
            Context context11 = this.context;
            if (context11 == null) {
                b41.A(WPKFactory.INIT_KEY_CONTEXT);
            } else {
                context2 = context11;
            }
            int dimensionPixelSize2 = context2.getResources().getDimensionPixelSize(dimenId4);
            if (AppInfoProviderProxy.isDebuggable()) {
                LogUtil.d(TAG, "id!=0,type:" + type + " ,marginBottom:" + dimensionPixelSize2);
            }
            baseLayoutHelper.setMarginBottom(dimensionPixelSize2);
        }
    }

    private final void handleMarginParams(BaseLayoutHelper baseLayoutHelper, Map<String, ? extends Object> map) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "38193160")) {
            ipChange.ipc$dispatch("38193160", new Object[]{this, baseLayoutHelper, map});
            return;
        }
        Object obj = map.get("data");
        List list = obj instanceof List ? (List) obj : null;
        if (list != null && !list.isEmpty()) {
            z = false;
        }
        if (z) {
            return;
        }
        handleIntelligenceUiMarginParams(baseLayoutHelper, map, (IItem) list.get(0));
    }

    private final void handlePaddingParams(BaseLayoutHelper baseLayoutHelper, Map<String, ? extends Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-721062245")) {
            ipChange.ipc$dispatch("-721062245", new Object[]{this, baseLayoutHelper, map});
            return;
        }
        Object obj = map.get("data");
        Context context = null;
        List list = obj instanceof List ? (List) obj : null;
        if (list == null || list.isEmpty()) {
            return;
        }
        int type = ((IItem) list.get(0)).getType();
        Context context2 = this.context;
        if (context2 == null) {
            b41.A(WPKFactory.INIT_KEY_CONTEXT);
            context2 = null;
        }
        int dimenId = getDimenId(context2, map, "paddingLeft");
        if (dimenId != 0) {
            Context context3 = this.context;
            if (context3 == null) {
                b41.A(WPKFactory.INIT_KEY_CONTEXT);
                context3 = null;
            }
            baseLayoutHelper.setPaddingLeft(context3.getResources().getDimensionPixelSize(dimenId));
            if (AppInfoProviderProxy.isDebuggable()) {
                Object[] objArr = new Object[1];
                StringBuilder sb = new StringBuilder();
                sb.append("id!=0,type:");
                sb.append(type);
                sb.append(" ,marginLeft:");
                Context context4 = this.context;
                if (context4 == null) {
                    b41.A(WPKFactory.INIT_KEY_CONTEXT);
                    context4 = null;
                }
                sb.append(context4.getResources().getDimensionPixelSize(dimenId));
                objArr[0] = sb.toString();
                LogUtil.d(TAG, objArr);
            }
        }
        Context context5 = this.context;
        if (context5 == null) {
            b41.A(WPKFactory.INIT_KEY_CONTEXT);
            context5 = null;
        }
        int dimenId2 = getDimenId(context5, map, "paddingRight");
        if (dimenId2 != 0) {
            Context context6 = this.context;
            if (context6 == null) {
                b41.A(WPKFactory.INIT_KEY_CONTEXT);
                context6 = null;
            }
            baseLayoutHelper.setPaddingRight(context6.getResources().getDimensionPixelSize(dimenId2));
            if (AppInfoProviderProxy.isDebuggable()) {
                Object[] objArr2 = new Object[1];
                StringBuilder sb2 = new StringBuilder();
                sb2.append("id!=0,type:");
                sb2.append(type);
                sb2.append(" ,paddingRight:");
                Context context7 = this.context;
                if (context7 == null) {
                    b41.A(WPKFactory.INIT_KEY_CONTEXT);
                    context7 = null;
                }
                sb2.append(context7.getResources().getDimensionPixelSize(dimenId2));
                objArr2[0] = sb2.toString();
                LogUtil.d(TAG, objArr2);
            }
        }
        Context context8 = this.context;
        if (context8 == null) {
            b41.A(WPKFactory.INIT_KEY_CONTEXT);
            context8 = null;
        }
        int dimenId3 = getDimenId(context8, map, "paddingTop");
        if (dimenId3 != 0) {
            Context context9 = this.context;
            if (context9 == null) {
                b41.A(WPKFactory.INIT_KEY_CONTEXT);
                context9 = null;
            }
            int dimensionPixelSize = context9.getResources().getDimensionPixelSize(dimenId3);
            if (AppInfoProviderProxy.isDebuggable()) {
                LogUtil.d(TAG, "id!=0,type:" + type + " ,paddingTop:" + dimensionPixelSize);
            }
            baseLayoutHelper.setPaddingTop(dimensionPixelSize);
        }
        Context context10 = this.context;
        if (context10 == null) {
            b41.A(WPKFactory.INIT_KEY_CONTEXT);
            context10 = null;
        }
        int dimenId4 = getDimenId(context10, map, "paddingBottom");
        if (dimenId4 != 0) {
            Context context11 = this.context;
            if (context11 == null) {
                b41.A(WPKFactory.INIT_KEY_CONTEXT);
            } else {
                context = context11;
            }
            int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(dimenId4);
            if (AppInfoProviderProxy.isDebuggable()) {
                LogUtil.d(TAG, "id!=0,type:" + type + " ,paddingBottom:" + dimensionPixelSize2);
            }
            baseLayoutHelper.setPaddingBottom(dimensionPixelSize2);
        }
    }

    private final int updateSpanByData(List<? extends IItem<ItemValue>> list, int i) {
        JSONObject layout;
        int intValue;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1990027735")) {
            return ((Integer) ipChange.ipc$dispatch("1990027735", new Object[]{this, list, Integer.valueOf(i)})).intValue();
        }
        if (list != null && !list.isEmpty()) {
            z = false;
        }
        return (z || (layout = list.get(0).getComponent().getProperty().getLayout()) == null || (intValue = layout.getIntValue(com.youku.arch.v3.data.Constants.COLUMN_NUM)) <= 0) ? i : intValue;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.youku.arch.v3.ICreator
    @Nullable
    public VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> create(@NotNull Config<Map<String, Object>> config) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1379637926")) {
            return (VBaseAdapter) ipChange.ipc$dispatch("-1379637926", new Object[]{this, config});
        }
        b41.i(config, com.youku.arch.v3.core.Constants.CONFIG);
        VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> createAdapter = createAdapter(config);
        return createAdapter == null ? createAdapterFromConfigFile(config) : createAdapter;
    }
}
