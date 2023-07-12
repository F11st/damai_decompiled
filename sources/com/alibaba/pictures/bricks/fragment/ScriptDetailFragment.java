package com.alibaba.pictures.bricks.fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.live.LiveActivity;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.R$color;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$layout;
import com.alibaba.pictures.bricks.bean.ShareInfoBean;
import com.alibaba.pictures.bricks.component.script.ScriptInfoHeaderBean;
import com.alibaba.pictures.bricks.component.script.ScriptInfoPresent;
import com.alibaba.pictures.bricks.fragment.ScriptDetailFragment;
import com.alibaba.pictures.bricks.util.share.ShareProxy;
import com.alibaba.pictures.bricks.util.toast.BricksToastUtil;
import com.alient.onearch.adapter.BaseFragment;
import com.alient.onearch.adapter.GenericPageContainer;
import com.alient.onearch.adapter.component.divider.DividerModel;
import com.alient.onearch.adapter.component.footer.v2.GenericFooterPresent;
import com.alient.onearch.adapter.component.header.sticky.StickyHeaderFeature;
import com.alient.onearch.adapter.decorate.ComponentDecorateItem;
import com.alient.onearch.adapter.loader.v2.GenericPagerLoader;
import com.alient.onearch.adapter.state.StateViewManager;
import com.alient.onearch.adapter.style.StyleConstant;
import com.alient.oneservice.image.FailEvent;
import com.alient.oneservice.image.IImageFailListener;
import com.alient.oneservice.image.IImageSuccListener;
import com.alient.oneservice.image.ImageLoaderProviderProxy;
import com.alient.oneservice.image.SuccessEvent;
import com.alient.oneservice.nav.Action;
import com.alient.oneservice.nav.NavProviderProxy;
import com.alient.oneservice.ut.TrackInfo;
import com.alient.oneservice.ut.UserTrackProviderProxy;
import com.amap.api.location.AMapLocation;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.scwang.smartrefresh.layout.api.RefreshInternal;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.taobao.weex.common.Constants;
import com.ut.device.UTDevice;
import com.youku.arch.v3.core.ModelValue;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.core.PageContainer;
import com.youku.arch.v3.data.Constants;
import com.youku.arch.v3.data.Request;
import com.youku.arch.v3.io.IRequest;
import com.youku.arch.v3.io.IResponse;
import com.youku.arch.v3.io.RequestBuilder;
import com.youku.arch.v3.page.state.State;
import com.youku.arch.v3.util.ColorUtil;
import com.youku.arch.v3.util.DisplayUtils;
import com.youku.arch.v3.util.IdGenerator;
import com.youku.kubus.Event;
import com.youku.kubus.Subscribe;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ap2;
import tb.b41;
import tb.gm;
import tb.ia1;
import tb.k50;
import tb.oj1;
import tb.wt2;
import tb.y11;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class ScriptDetailFragment extends BaseFragment implements StickyHeaderFeature {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final a Companion = new a(null);
    public static final boolean NEED_ENCODE = false;
    public static final boolean NEED_SESSION = false;
    @NotNull
    public static final String SCRIPT_ID = "scriptId";
    @NotNull
    public static final String STORE_ID = "storeId";
    @NotNull
    public static final String VERSION = "2.0";
    public Action actionAuth;
    public Action actionShare;
    @Nullable
    private Bitmap blurBit;
    public View mAppNavbar;
    public ImageView mAppTopBg;
    @Nullable
    private String scriptId;
    @Nullable
    private ScriptInfoHeaderBean scriptInfo;
    @Nullable
    private View stickyHeader;
    @Nullable
    private String storeId;
    @NotNull
    private final String pageName = "ScriptDetail";
    @NotNull
    private final String configPath = "://bricks/raw/script_murder_script_detail_component_config";

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public final class ScriptDetailLoader extends GenericPagerLoader {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ScriptDetailFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ScriptDetailLoader(@NotNull ScriptDetailFragment scriptDetailFragment, PageContainer<ModelValue> pageContainer) {
            super(pageContainer);
            b41.i(pageContainer, "pageContainer");
            this.this$0 = scriptDetailFragment;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put((JSONObject) DividerModel.DIVIDER_COLOR, "#00000000");
            jSONObject.put((JSONObject) DividerModel.DIVIDER_HEIGHT, (String) Integer.valueOf(DisplayUtils.dp2px(18)));
            addComponentDecorate(9996, new ComponentDecorateItem(9993, 9993, jSONObject, ComponentDecorateItem.Indexer.Before));
        }

        @Override // com.alient.onearch.adapter.loader.v2.GenericPagerLoader
        public void handleComponentNode(@NotNull ListIterator<Node> listIterator, @NotNull Node node) {
            IpChange ipChange = $ipChange;
            boolean z = true;
            if (AndroidInstantRuntime.support(ipChange, "-1285743929")) {
                ipChange.ipc$dispatch("-1285743929", new Object[]{this, listIterator, node});
                return;
            }
            b41.i(listIterator, "componentIterator");
            b41.i(node, "componentNode");
            if (node.getType() == 9996 && node.getData() == null) {
                node.setData(new JSONObject());
            }
            super.handleComponentNode(listIterator, node);
            List<Node> children = node.getChildren();
            if (children != null && !children.isEmpty()) {
                z = false;
            }
            if (z || node.getType() != 7503) {
                return;
            }
            handleCreateFooterComponentNode(listIterator, node);
        }

        @Override // com.alient.onearch.adapter.loader.v2.GenericPagerLoader
        public void handleFooterItemProperty(@NotNull Node node, @NotNull Node node2) {
            List<Node> children;
            JSONObject data;
            JSONObject data2;
            JSONObject data3;
            wt2 wt2Var;
            Object obj;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2014341046")) {
                ipChange.ipc$dispatch("2014341046", new Object[]{this, node, node2});
                return;
            }
            b41.i(node, "componentNode");
            b41.i(node2, "itemNode");
            if (node.getType() == 7503) {
                if (node.getChildren() == null || (data3 = node2.getData()) == null) {
                    return;
                }
                JSONObject data4 = node.getData();
                if (data4 == null || (obj = data4.get(Constants.TOTAL_NUM)) == null) {
                    wt2Var = null;
                } else {
                    data3.put((JSONObject) GenericFooterPresent.KEY_EXPEND_CONTENT, "查看全部" + obj + "条评价");
                    wt2Var = wt2.INSTANCE;
                }
                if (wt2Var == null) {
                    data3.put((JSONObject) GenericFooterPresent.KEY_EXPEND_CONTENT, "查看全部" + data3.size() + "条评价");
                }
                data3.put((JSONObject) StyleConstant.FOOTER_BG_START_COLOR, "#F4F5F6");
                data3.put((JSONObject) StyleConstant.FOOTER_BG_END_COLOR, "#F4F5F6");
                data3.put((JSONObject) StyleConstant.FOOTER_TEXT_COLOR, "#30AEFF");
            } else if (node.getType() == 7514) {
                List<Node> children2 = node.getChildren();
                if (children2 == null || (data2 = node2.getData()) == null) {
                    return;
                }
                data2.put((JSONObject) GenericFooterPresent.KEY_EXPEND_CONTENT, "展开全部" + children2.size() + "个门店");
                data2.put((JSONObject) GenericFooterPresent.KEY_COLLAPSE_CONTENT, "收起");
                data2.put((JSONObject) StyleConstant.FOOTER_BG_START_COLOR, "#F4F5F6");
                data2.put((JSONObject) StyleConstant.FOOTER_BG_END_COLOR, "#F4F5F6");
                data2.put((JSONObject) StyleConstant.FOOTER_TEXT_COLOR, "#30AEFF");
            } else if (node.getType() != 7520 || (children = node.getChildren()) == null || (data = node2.getData()) == null) {
            } else {
                data.put((JSONObject) GenericFooterPresent.KEY_EXPEND_CONTENT, "展开全部" + children.size() + "个商品");
                data.put((JSONObject) GenericFooterPresent.KEY_COLLAPSE_CONTENT, "收起");
                data.put((JSONObject) StyleConstant.FOOTER_BG_START_COLOR, "#F4F5F6");
                data.put((JSONObject) StyleConstant.FOOTER_BG_END_COLOR, "#F4F5F6");
                data.put((JSONObject) StyleConstant.FOOTER_TEXT_COLOR, "#30AEFF");
            }
        }

        @Override // com.alient.onearch.adapter.loader.v2.GenericPagerLoader
        public void handleHeaderItemProperty(@NotNull Node node, @NotNull Node node2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1603746564")) {
                ipChange.ipc$dispatch("1603746564", new Object[]{this, node, node2});
                return;
            }
            b41.i(node, "componentNode");
            b41.i(node2, "itemNode");
            int type = node.getType();
            if (type != 7503 && type != 7520) {
                switch (type) {
                    case 7512:
                    case 7513:
                        JSONObject data = node2.getData();
                        if (data != null) {
                            data.put((JSONObject) StyleConstant.HEADER_BG_START_COLOR, "#00000000");
                            data.put((JSONObject) StyleConstant.HEADER_BG_END_COLOR, "#00000000");
                            data.put((JSONObject) StyleConstant.HEADER_TEXT_COLOR, "#FFFFFF");
                            data.put((JSONObject) StyleConstant.HEADER_RIGHT_TEXT_COLOR, "#B3FFFFFF");
                            return;
                        }
                        return;
                    case 7514:
                    case 7515:
                        break;
                    default:
                        return;
                }
            }
            JSONObject data2 = node2.getData();
            if (data2 != null) {
                data2.put((JSONObject) StyleConstant.HEADER_BG_START_COLOR, "#F4F5F6");
                data2.put((JSONObject) StyleConstant.HEADER_BG_END_COLOR, "#F4F5F6");
                data2.put((JSONObject) StyleConstant.HEADER_TEXT_COLOR, "#000000");
                data2.put((JSONObject) StyleConstant.HEADER_RIGHT_TEXT_COLOR, "#999999");
            }
        }

        @Override // com.youku.arch.v3.loader.PageLoader, com.youku.arch.v3.loader.AbsLoader, com.youku.arch.v3.loader.PagingLoader
        public void handleLoadFailure(@NotNull final IResponse iResponse) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "72606926")) {
                ipChange.ipc$dispatch("72606926", new Object[]{this, iResponse});
                return;
            }
            b41.i(iResponse, "response");
            super.handleLoadFailure(iResponse);
            if (this.this$0.getActivity() != null) {
                final ScriptDetailFragment scriptDetailFragment = this.this$0;
                scriptDetailFragment.getPageContext().runOnUIThread(new Function0<wt2>() { // from class: com.alibaba.pictures.bricks.fragment.ScriptDetailFragment$ScriptDetailLoader$handleLoadFailure$1$1
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
                        if (AndroidInstantRuntime.support(ipChange2, "-1912054693")) {
                            ipChange2.ipc$dispatch("-1912054693", new Object[]{this});
                            return;
                        }
                        ScriptDetailFragment scriptDetailFragment2 = ScriptDetailFragment.this;
                        scriptDetailFragment2.hideLoadingDialog(scriptDetailFragment2.getActivity());
                        String a = oj1.a(iResponse.getRetCode(), iResponse.getRetMessage());
                        if (ScriptDetailFragment.this.getPageLoader().getRealItemCount() > 0) {
                            BricksToastUtil.INSTANCE.b(a);
                        } else {
                            ScriptDetailFragment.this.getPageStateManager().setState(State.FAILED);
                        }
                    }
                });
            }
        }

        @Override // com.alient.onearch.adapter.loader.v2.GenericPagerLoader, com.youku.arch.v3.loader.PageLoader, com.youku.arch.v3.loader.AbsLoader, com.youku.arch.v3.loader.PagingLoader
        public void handleLoadSuccess(@NotNull IResponse iResponse, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1191587310")) {
                ipChange.ipc$dispatch("1191587310", new Object[]{this, iResponse, Integer.valueOf(i)});
                return;
            }
            b41.i(iResponse, "response");
            FragmentActivity activity = this.this$0.getActivity();
            if (activity != null) {
                ScriptDetailFragment scriptDetailFragment = this.this$0;
                scriptDetailFragment.getPageContext().runOnUIThread(new ScriptDetailFragment$ScriptDetailLoader$handleLoadSuccess$1$1(scriptDetailFragment, activity));
            }
            super.handleLoadSuccess(iResponse, i);
        }

        @Override // com.youku.arch.v3.loader.AbsLoader, com.youku.arch.v3.loader.PagingLoader
        public void load(@NotNull Map<String, ? extends Object> map) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "84570538")) {
                ipChange.ipc$dispatch("84570538", new Object[]{this, map});
                return;
            }
            b41.i(map, com.youku.arch.v3.core.Constants.CONFIG);
            super.load(map);
            Object obj = map.get("reload");
            if (!b41.d(obj instanceof Boolean ? (Boolean) obj : null, Boolean.TRUE)) {
                ScriptDetailFragment scriptDetailFragment = this.this$0;
                StateViewManager.IStateFeature.DefaultImpls.showLoadingDialog$default(scriptDetailFragment, scriptDetailFragment.getActivity(), null, false, 6, null);
            }
            this.this$0.setBlurBit(null);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public final class ScriptDetailRequestBuilder implements RequestBuilder {
        private static transient /* synthetic */ IpChange $ipChange;
        @NotNull
        private Map<String, Object> params = new LinkedHashMap();
        private long strategy = 2;

        public ScriptDetailRequestBuilder() {
        }

        @Override // com.youku.arch.v3.io.RequestBuilder
        @NotNull
        public IRequest build(@NotNull Map<String, ? extends Object> map) {
            IpChange ipChange = $ipChange;
            boolean z = true;
            if (AndroidInstantRuntime.support(ipChange, "-63061582")) {
                return (IRequest) ipChange.ipc$dispatch("-63061582", new Object[]{this, map});
            }
            b41.i(map, com.youku.arch.v3.core.Constants.CONFIG);
            this.params.put("patternName", "dm_app_script_detail");
            this.params.put("patternVersion", "1.0");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            String utdid = UTDevice.getUtdid(ScriptDetailFragment.this.getContext());
            b41.h(utdid, "getUtdid(context)");
            linkedHashMap.put("utdid", utdid);
            linkedHashMap.put("comboDamaiCityId", gm.INSTANCE.a().getCityId());
            Context context = ScriptDetailFragment.this.getContext();
            if ((context == null || !ap2.INSTANCE.e(context)) ? false : false) {
                ia1 ia1Var = ia1.INSTANCE;
                AMapLocation lastKnownLocation = ia1Var.c().getLastKnownLocation();
                linkedHashMap.put("latitude", String.valueOf(lastKnownLocation != null ? Double.valueOf(lastKnownLocation.getLatitude()) : null));
                AMapLocation lastKnownLocation2 = ia1Var.c().getLastKnownLocation();
                linkedHashMap.put("longitude", String.valueOf(lastKnownLocation2 != null ? Double.valueOf(lastKnownLocation2.getLongitude()) : null));
            }
            String ttid = AppInfoProviderProxy.getTTID();
            b41.h(ttid, "getTTID()");
            linkedHashMap.put(LiveActivity.OPTION_TTID, ttid);
            linkedHashMap.put("comboChannel", "1");
            Object obj = map.get("index");
            if (obj != null) {
                linkedHashMap.put("pageNo", obj);
            }
            linkedHashMap.put(Constants.Name.PAGE_SIZE, 15);
            String str = ScriptDetailFragment.this.scriptId;
            if (str != null) {
                linkedHashMap.put("scriptId", str);
            }
            String str2 = ScriptDetailFragment.this.storeId;
            if (str2 != null) {
                linkedHashMap.put("storeId", str2);
            }
            Map<String, Object> map2 = this.params;
            String jSONString = JSON.toJSONString(linkedHashMap);
            b41.h(jSONString, "toJSONString(args)");
            map2.put("args", jSONString);
            return new Request.Builder().setApiName("mtop.damai.mec.aristotle.get").setVersion("2.0").setNeedECode(false).setNeedSession(false).setTimeout(10000).setStrategy(this.strategy).setRequestId(IdGenerator.getId()).setDataParams(new HashMap(this.params)).build();
        }

        @NotNull
        public final Map<String, Object> getParams() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-2014200215") ? (Map) ipChange.ipc$dispatch("-2014200215", new Object[]{this}) : this.params;
        }

        public final long getStrategy() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1258167515") ? ((Long) ipChange.ipc$dispatch("1258167515", new Object[]{this})).longValue() : this.strategy;
        }

        public final void setParams(@NotNull Map<String, Object> map) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "500465373")) {
                ipChange.ipc$dispatch("500465373", new Object[]{this, map});
                return;
            }
            b41.i(map, "<set-?>");
            this.params = map;
        }

        public final void setStrategy(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1259270601")) {
                ipChange.ipc$dispatch("1259270601", new Object[]{this, Long.valueOf(j)});
            } else {
                this.strategy = j;
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }
    }

    private final Bitmap getTransparentBitmap(Bitmap bitmap, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1874518572")) {
            return (Bitmap) ipChange.ipc$dispatch("1874518572", new Object[]{this, bitmap, Integer.valueOf(i)});
        }
        int width = bitmap.getWidth() * bitmap.getHeight();
        int[] iArr = new int[width];
        bitmap.getPixels(iArr, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        int i2 = (i * 255) / 100;
        for (int i3 = 0; i3 < width; i3++) {
            iArr[i3] = (i2 << 24) | (iArr[i3] & 16777215);
        }
        Bitmap createBitmap = Bitmap.createBitmap(iArr, bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        b41.h(createBitmap, "createBitmap(\n          …onfig.ARGB_8888\n        )");
        return createBitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-0  reason: not valid java name */
    public static final void m174onViewCreated$lambda0(ScriptDetailFragment scriptDetailFragment, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "746801426")) {
            ipChange.ipc$dispatch("746801426", new Object[]{scriptDetailFragment, view});
            return;
        }
        b41.i(scriptDetailFragment, "this$0");
        scriptDetailFragment.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-1  reason: not valid java name */
    public static final void m175onViewCreated$lambda1(ScriptDetailFragment scriptDetailFragment, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1530180401")) {
            ipChange.ipc$dispatch("1530180401", new Object[]{scriptDetailFragment, view});
            return;
        }
        b41.i(scriptDetailFragment, "this$0");
        scriptDetailFragment.share();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-2  reason: not valid java name */
    public static final void m176onViewCreated$lambda2(ScriptDetailFragment scriptDetailFragment, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1981407920")) {
            ipChange.ipc$dispatch("-1981407920", new Object[]{scriptDetailFragment, view});
            return;
        }
        b41.i(scriptDetailFragment, "this$0");
        scriptDetailFragment.report();
    }

    private final void setDefaultHeaderBg() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-30329325")) {
            ipChange.ipc$dispatch("-30329325", new Object[]{this});
            return;
        }
        View realView = getRealView();
        ImageView imageView = realView != null ? (ImageView) realView.findViewById(R$id.scriptkill_top_gaussimg) : null;
        b41.f(imageView);
        setMAppTopBg(imageView);
        View realView2 = getRealView();
        View findViewById = realView2 != null ? realView2.findViewById(R$id.nav_bar) : null;
        b41.f(findViewById);
        setMAppNavbar(findViewById);
        getMAppNavbar().setBackgroundColor(getResources().getColor(R$color.transparent));
        RecyclerView recyclerView = getRecyclerView();
        if (recyclerView != null) {
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.alibaba.pictures.bricks.fragment.ScriptDetailFragment$setDefaultHeaderBg$1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrolled(@NotNull RecyclerView recyclerView2, int i, int i2) {
                    TextView textView;
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "654749714")) {
                        ipChange2.ipc$dispatch("654749714", new Object[]{this, recyclerView2, Integer.valueOf(i), Integer.valueOf(i2)});
                        return;
                    }
                    b41.i(recyclerView2, "recyclerView");
                    super.onScrolled(recyclerView2, i, i2);
                    int computeVerticalScrollOffset = recyclerView2.computeVerticalScrollOffset();
                    View realView3 = ScriptDetailFragment.this.getRealView();
                    FrameLayout frameLayout = realView3 != null ? (FrameLayout) realView3.findViewById(R$id.scriptkill_top_gaussimg_cover) : null;
                    if (frameLayout != null) {
                        frameLayout.setTranslationY(-computeVerticalScrollOffset);
                    }
                    if (computeVerticalScrollOffset == 0) {
                        ScriptDetailFragment.this.getMAppNavbar().setBackgroundColor(ScriptDetailFragment.this.getResources().getColor(R$color.transparent));
                        View realView4 = ScriptDetailFragment.this.getRealView();
                        textView = realView4 != null ? (TextView) realView4.findViewById(R$id.title_navbar_title) : null;
                        if (textView == null) {
                            return;
                        }
                        textView.setVisibility(8);
                        return;
                    }
                    ScriptDetailFragment.this.getMAppNavbar().setBackgroundColor(Color.parseColor("#211616"));
                    View realView5 = ScriptDetailFragment.this.getRealView();
                    textView = realView5 != null ? (TextView) realView5.findViewById(R$id.title_navbar_title) : null;
                    if (textView == null) {
                        return;
                    }
                    textView.setVisibility(0);
                }
            });
        }
    }

    private final void updateHeaderBg(Event event) {
        String url;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-392812533")) {
            ipChange.ipc$dispatch("-392812533", new Object[]{this, event});
            return;
        }
        Object obj = event.data;
        HashMap hashMap = obj instanceof HashMap ? (HashMap) obj : null;
        Object obj2 = hashMap != null ? hashMap.get("value") : null;
        ScriptInfoHeaderBean scriptInfoHeaderBean = obj2 instanceof ScriptInfoHeaderBean ? (ScriptInfoHeaderBean) obj2 : null;
        if (scriptInfoHeaderBean == null || (url = scriptInfoHeaderBean.getUrl()) == null) {
            return;
        }
        ImageLoaderProviderProxy.getProxy().load(url, 0, new IImageSuccListener() { // from class: tb.y62
            @Override // com.alient.oneservice.image.IImageSuccListener
            public final void onSuccess(SuccessEvent successEvent) {
                ScriptDetailFragment.m177updateHeaderBg$lambda8$lambda6(ScriptDetailFragment.this, successEvent);
            }
        }, new IImageFailListener() { // from class: tb.x62
            @Override // com.alient.oneservice.image.IImageFailListener
            public final void onFail(FailEvent failEvent) {
                ScriptDetailFragment.m178updateHeaderBg$lambda8$lambda7(failEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: updateHeaderBg$lambda-8$lambda-6  reason: not valid java name */
    public static final void m177updateHeaderBg$lambda8$lambda6(ScriptDetailFragment scriptDetailFragment, SuccessEvent successEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1686441351")) {
            ipChange.ipc$dispatch("1686441351", new Object[]{scriptDetailFragment, successEvent});
            return;
        }
        b41.i(scriptDetailFragment, "this$0");
        Bitmap a2 = y11.a(scriptDetailFragment.getActivity(), successEvent.bitmap, 2, 20);
        scriptDetailFragment.blurBit = a2;
        if (a2 != null) {
            scriptDetailFragment.getMAppTopBg().setImageBitmap(scriptDetailFragment.getTransparentBitmap(a2, 40));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: updateHeaderBg$lambda-8$lambda-7  reason: not valid java name */
    public static final void m178updateHeaderBg$lambda8$lambda7(FailEvent failEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1416195365")) {
            ipChange.ipc$dispatch("-1416195365", new Object[]{failEvent});
        }
    }

    @Override // com.alient.onearch.adapter.BaseFragment
    @NotNull
    public GenericPagerLoader createPageLoader(@NotNull GenericPageContainer genericPageContainer) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-132458835")) {
            return (GenericPagerLoader) ipChange.ipc$dispatch("-132458835", new Object[]{this, genericPageContainer});
        }
        b41.i(genericPageContainer, "container");
        ScriptDetailLoader scriptDetailLoader = new ScriptDetailLoader(this, genericPageContainer);
        scriptDetailLoader.addComponentDisplayLimit(7502, 5);
        return scriptDetailLoader;
    }

    @Override // com.alient.onearch.adapter.BaseFragment
    @Nullable
    protected RequestBuilder createRequestBuilder(@Nullable Map<String, ? extends Object> map) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-221021518") ? (RequestBuilder) ipChange.ipc$dispatch("-221021518", new Object[]{this, map}) : new ScriptDetailRequestBuilder();
    }

    @NotNull
    public final Action getActionAuth() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-306924059")) {
            return (Action) ipChange.ipc$dispatch("-306924059", new Object[]{this});
        }
        Action action = this.actionAuth;
        if (action != null) {
            return action;
        }
        b41.A("actionAuth");
        return null;
    }

    @NotNull
    public final Action getActionShare() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-935003834")) {
            return (Action) ipChange.ipc$dispatch("-935003834", new Object[]{this});
        }
        Action action = this.actionShare;
        if (action != null) {
            return action;
        }
        b41.A("actionShare");
        return null;
    }

    @Nullable
    public final Bitmap getBlurBit() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "835714290") ? (Bitmap) ipChange.ipc$dispatch("835714290", new Object[]{this}) : this.blurBit;
    }

    @Override // com.youku.arch.v3.page.GenericFragment
    @NotNull
    protected String getConfigPath() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1277538857") ? (String) ipChange.ipc$dispatch("-1277538857", new Object[]{this}) : this.configPath;
    }

    @Override // com.alient.onearch.adapter.BaseFragment, com.youku.arch.v3.page.GenericFragment
    protected int getLayoutResId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-711620100") ? ((Integer) ipChange.ipc$dispatch("-711620100", new Object[]{this})).intValue() : R$layout.bricks_fragment_script_murder_script_detail;
    }

    @NotNull
    public final View getMAppNavbar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1121428718")) {
            return (View) ipChange.ipc$dispatch("1121428718", new Object[]{this});
        }
        View view = this.mAppNavbar;
        if (view != null) {
            return view;
        }
        b41.A("mAppNavbar");
        return null;
    }

    @NotNull
    public final ImageView getMAppTopBg() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2048926844")) {
            return (ImageView) ipChange.ipc$dispatch("2048926844", new Object[]{this});
        }
        ImageView imageView = this.mAppTopBg;
        if (imageView != null) {
            return imageView;
        }
        b41.A("mAppTopBg");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.youku.arch.v3.page.GenericFragment
    @NotNull
    public String getPageName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "738736842") ? (String) ipChange.ipc$dispatch("738736842", new Object[]{this}) : this.pageName;
    }

    @Nullable
    public final ScriptInfoHeaderBean getScriptInfo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "165183684") ? (ScriptInfoHeaderBean) ipChange.ipc$dispatch("165183684", new Object[]{this}) : this.scriptInfo;
    }

    @Override // com.alient.onearch.adapter.component.header.sticky.StickyHeaderFeature
    @Nullable
    public View getStickyView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1490610852") ? (View) ipChange.ipc$dispatch("1490610852", new Object[]{this}) : this.stickyHeader;
    }

    public final void initActionData(@NotNull Object obj) {
        Object obj2;
        Object obj3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1530043344")) {
            ipChange.ipc$dispatch("-1530043344", new Object[]{this, obj});
            return;
        }
        b41.i(obj, "bean");
        boolean z = obj instanceof HashMap;
        HashMap hashMap = z ? (HashMap) obj : null;
        if (hashMap != null && (obj3 = hashMap.get("report")) != null) {
            Action action = obj3 instanceof Action ? (Action) obj3 : null;
            if (action != null) {
                setActionAuth(action);
                View realView = getRealView();
                View findViewById = realView != null ? realView.findViewById(R$id.title_navbar_report) : null;
                if (findViewById != null) {
                    findViewById.setVisibility(0);
                }
            }
        }
        HashMap hashMap2 = z ? (HashMap) obj : null;
        if (hashMap2 == null || (obj2 = hashMap2.get("share")) == null) {
            return;
        }
        Action action2 = obj2 instanceof Action ? (Action) obj2 : null;
        if (action2 != null) {
            setActionShare(action2);
            View realView2 = getRealView();
            View findViewById2 = realView2 != null ? realView2.findViewById(R$id.title_navbar_share) : null;
            if (findViewById2 == null) {
                return;
            }
            findViewById2.setVisibility(0);
        }
    }

    public final void onBackPressed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1340980694")) {
            ipChange.ipc$dispatch("-1340980694", new Object[]{this});
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    @Override // com.alient.onearch.adapter.BaseFragment, com.youku.arch.v3.page.GenericFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1785453301")) {
            ipChange.ipc$dispatch("-1785453301", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.scriptId = arguments != null ? arguments.getString("scriptId") : null;
        Bundle arguments2 = getArguments();
        this.storeId = arguments2 != null ? arguments2.getString("storeId") : null;
    }

    public final void onInfoUpdate(@NotNull Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1552184714")) {
            ipChange.ipc$dispatch("1552184714", new Object[]{this, obj});
            return;
        }
        b41.i(obj, "bean");
        HashMap hashMap = obj instanceof HashMap ? (HashMap) obj : null;
        Object obj2 = hashMap != null ? hashMap.get("value") : null;
        ScriptInfoHeaderBean scriptInfoHeaderBean = obj2 instanceof ScriptInfoHeaderBean ? (ScriptInfoHeaderBean) obj2 : null;
        if (scriptInfoHeaderBean != null) {
            this.scriptInfo = scriptInfoHeaderBean;
        }
    }

    public final void onInfoget(@NotNull Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1650164999")) {
            ipChange.ipc$dispatch("-1650164999", new Object[]{this, obj});
            return;
        }
        b41.i(obj, "bean");
        initActionData(obj);
        onInfoUpdate(obj);
    }

    @Subscribe(eventType = {ScriptInfoPresent.MSG_SCRIPT_BG_UPDATE})
    public final void onMessageGet(@NotNull Event event) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1476355070")) {
            ipChange.ipc$dispatch("1476355070", new Object[]{this, event});
            return;
        }
        b41.i(event, "event");
        if (b41.d(event.type, ScriptInfoPresent.MSG_SCRIPT_BG_UPDATE)) {
            if (this.blurBit == null) {
                updateHeaderBg(event);
            }
            Object obj = event.data;
            HashMap hashMap = obj instanceof HashMap ? (HashMap) obj : null;
            if (hashMap != null) {
                onInfoget(hashMap);
            }
        }
    }

    public final void onShareClick() {
        Window window;
        ShareInfoBean shareDO;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "652034588")) {
            ipChange.ipc$dispatch("652034588", new Object[]{this});
        } else if (this.scriptInfo == null) {
        } else {
            Bundle bundle = new Bundle();
            ScriptInfoHeaderBean scriptInfoHeaderBean = this.scriptInfo;
            if (scriptInfoHeaderBean != null && (shareDO = scriptInfoHeaderBean.getShareDO()) != null) {
                bundle.putString("title", shareDO.getShareTitle());
                bundle.putString("message", shareDO.getShareSubTitle());
                bundle.putString("imageurl", shareDO.getShareImage());
                bundle.putString("producturl", shareDO.getShareUrl());
            }
            ShareProxy.IShareProxy a2 = ShareProxy.a();
            FragmentActivity activity = getActivity();
            FragmentActivity activity2 = getActivity();
            a2.share(activity, bundle, (activity2 == null || (window = activity2.getWindow()) == null) ? null : window.getDecorView());
        }
    }

    @Override // com.alient.onearch.adapter.BaseFragment, com.youku.arch.v3.page.GenericFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        View findViewById;
        View findViewById2;
        View findViewById3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1448402724")) {
            ipChange.ipc$dispatch("1448402724", new Object[]{this, view, bundle});
            return;
        }
        b41.i(view, "view");
        super.onViewCreated(view, bundle);
        RefreshLayout refreshLayout = getRefreshLayout();
        if (refreshLayout != null) {
            refreshLayout.setEnableLoadMore(false);
        }
        View realView = getRealView();
        this.stickyHeader = realView != null ? realView.findViewById(R$id.sticky_header) : null;
        RefreshInternal refreshHeader = getRefreshHeader();
        ViewGroup viewGroup = refreshHeader instanceof ViewGroup ? (ViewGroup) refreshHeader : null;
        if (viewGroup != null) {
            viewGroup.setBackgroundColor(ColorUtil.parseColorSafely("#211616"));
        }
        load(new LinkedHashMap());
        RefreshLayout refreshLayout2 = getRefreshLayout();
        if (refreshLayout2 != null) {
            refreshLayout2.setEnableRefresh(true);
        }
        setDefaultHeaderBg();
        View realView2 = getRealView();
        if (realView2 != null && (findViewById3 = realView2.findViewById(R$id.common_navbar_back)) != null) {
            findViewById3.setOnClickListener(new View.OnClickListener() { // from class: tb.v62
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ScriptDetailFragment.m174onViewCreated$lambda0(ScriptDetailFragment.this, view2);
                }
            });
        }
        View realView3 = getRealView();
        if (realView3 != null && (findViewById2 = realView3.findViewById(R$id.title_navbar_share)) != null) {
            findViewById2.setOnClickListener(new View.OnClickListener() { // from class: tb.u62
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ScriptDetailFragment.m175onViewCreated$lambda1(ScriptDetailFragment.this, view2);
                }
            });
        }
        View realView4 = getRealView();
        if (realView4 == null || (findViewById = realView4.findViewById(R$id.title_navbar_report)) == null) {
            return;
        }
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: tb.w62
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ScriptDetailFragment.m176onViewCreated$lambda2(ScriptDetailFragment.this, view2);
            }
        });
    }

    public final void report() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1027473200")) {
            ipChange.ipc$dispatch("-1027473200", new Object[]{this});
        } else if (this.actionAuth != null) {
            Action actionAuth = getActionAuth();
            Action action = new Action();
            action.setActionType(1);
            action.setActionUrl(actionAuth.getActionUrl());
            NavProviderProxy.getProxy().toUri(getActivity(), action);
            TrackInfo trackInfo = actionAuth.getTrackInfo();
            if (trackInfo != null) {
                b41.h(trackInfo, "trackInfo");
                TrackInfo trackInfo2 = new TrackInfo();
                trackInfo2.setSpmb(trackInfo.getSpmb());
                trackInfo2.setSpmc(trackInfo.getSpmc());
                trackInfo2.setSpmd(trackInfo.getSpmd());
                trackInfo2.setArgs(trackInfo.getArgs());
                UserTrackProviderProxy.getProxy().click(trackInfo2, true);
            }
        }
    }

    public final void setActionAuth(@NotNull Action action) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "279857703")) {
            ipChange.ipc$dispatch("279857703", new Object[]{this, action});
            return;
        }
        b41.i(action, "<set-?>");
        this.actionAuth = action;
    }

    public final void setActionShare(@NotNull Action action) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1589120638")) {
            ipChange.ipc$dispatch("1589120638", new Object[]{this, action});
            return;
        }
        b41.i(action, "<set-?>");
        this.actionShare = action;
    }

    public final void setBlurBit(@Nullable Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1925416462")) {
            ipChange.ipc$dispatch("1925416462", new Object[]{this, bitmap});
        } else {
            this.blurBit = bitmap;
        }
    }

    public final void setMAppNavbar(@NotNull View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1823489714")) {
            ipChange.ipc$dispatch("1823489714", new Object[]{this, view});
            return;
        }
        b41.i(view, "<set-?>");
        this.mAppNavbar = view;
    }

    public final void setMAppTopBg(@NotNull ImageView imageView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-598964134")) {
            ipChange.ipc$dispatch("-598964134", new Object[]{this, imageView});
            return;
        }
        b41.i(imageView, "<set-?>");
        this.mAppTopBg = imageView;
    }

    public final void setScriptInfo(@Nullable ScriptInfoHeaderBean scriptInfoHeaderBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-351892014")) {
            ipChange.ipc$dispatch("-351892014", new Object[]{this, scriptInfoHeaderBean});
        } else {
            this.scriptInfo = scriptInfoHeaderBean;
        }
    }

    public final void share() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1312650823")) {
            ipChange.ipc$dispatch("1312650823", new Object[]{this});
            return;
        }
        onShareClick();
        shareUt();
    }

    public final void shareUt() {
        TrackInfo trackInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1219194200")) {
            ipChange.ipc$dispatch("-1219194200", new Object[]{this});
        } else if (this.actionShare == null || (trackInfo = getActionShare().getTrackInfo()) == null) {
        } else {
            b41.h(trackInfo, "trackInfo");
            TrackInfo trackInfo2 = new TrackInfo();
            trackInfo2.setSpmb(trackInfo.getSpmb());
            String spmc = trackInfo.getSpmc();
            if (spmc == null) {
                spmc = "top";
            }
            trackInfo2.setSpmc(spmc);
            String spmd = trackInfo.getSpmd();
            if (spmd == null) {
                spmd = "share";
            }
            trackInfo2.setSpmd(spmd);
            trackInfo2.setArgs(trackInfo.getArgs());
            UserTrackProviderProxy.getProxy().click(trackInfo2, false);
        }
    }
}
