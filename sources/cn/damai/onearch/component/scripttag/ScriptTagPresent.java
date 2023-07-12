package cn.damai.onearch.component.scripttag;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import cn.damai.common.AppConfig;
import cn.damai.common.util.ToastUtil;
import cn.damai.live.LiveActivity;
import cn.damai.onearch.component.scripttag.ScriptTagContract;
import cn.damai.onearch.component.scripttag.ScriptTagPresent;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alient.onearch.adapter.request.DRParam;
import com.alient.onearch.adapter.view.AbsPresenter;
import com.alient.oneservice.nav.Action;
import com.alient.oneservice.ut.TrackInfo;
import com.alient.oneservice.ut.UserTrackProviderProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.common.Constants;
import com.ut.device.UTDevice;
import com.youku.arch.v3.IComponent;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.adapter.VBaseAdapter;
import com.youku.arch.v3.adapter.VBaseHolder;
import com.youku.arch.v3.core.ComponentValue;
import com.youku.arch.v3.core.Config;
import com.youku.arch.v3.core.Constants;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.core.component.GenericComponent;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.data.Repository;
import com.youku.arch.v3.data.Request;
import com.youku.arch.v3.event.EventHandler;
import com.youku.arch.v3.io.Callback;
import com.youku.arch.v3.io.IRequest;
import com.youku.arch.v3.io.IResponse;
import com.youku.arch.v3.io.RequestBuilder;
import com.youku.arch.v3.loader.NodeParser;
import com.youku.arch.v3.util.IdGenerator;
import com.youku.arch.v3.view.render.GenericRenderConfig;
import com.youku.live.livesdk.model.mtop.LiveFullInfo;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.C8212k;
import kotlin.collections.C8214m;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.ir1;
import tb.jn1;
import tb.k50;
import tb.mr1;
import tb.wt2;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class ScriptTagPresent extends AbsPresenter<GenericItem<ItemValue>, ScriptTagModel, ScriptTagContract.View> implements ScriptTagContract.Presenter {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final C1489a Companion = new C1489a(null);
    public static final boolean NEED_ENCODE = false;
    public static final boolean NEED_SESSION = false;
    @NotNull
    public static final String VERSION = "2.0";
    private int currentSelectTagPosition;
    @Nullable
    private String storeId;
    @Nullable
    private IComponent<ComponentValue> targetComponent;

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public final class ScriptRequestBuilder implements RequestBuilder {
        private static transient /* synthetic */ IpChange $ipChange;
        @NotNull
        private Map<String, Object> params = new LinkedHashMap();
        private long strategy = 2;
        private final int tabPosition;

        public ScriptRequestBuilder(int i) {
            this.tabPosition = i;
        }

        @Override // com.youku.arch.v3.io.RequestBuilder
        @NotNull
        public IRequest build(@NotNull Map<String, ? extends Object> map) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "453821724")) {
                return (IRequest) ipChange.ipc$dispatch("453821724", new Object[]{this, map});
            }
            b41.i(map, Constants.CONFIG);
            this.params.put("patternName", "dm_app_script_store");
            this.params.put("patternVersion", LiveFullInfo.VER);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Activity activity = ((GenericItem) ScriptTagPresent.this.getItem()).getPageContext().getActivity();
            if (activity != null) {
                String utdid = UTDevice.getUtdid(activity);
                b41.h(utdid, "getUtdid(this)");
                linkedHashMap.put("utdid", utdid);
            }
            String c = z20.c();
            b41.h(c, "getCityId()");
            linkedHashMap.put("comboDamaiCityId", c);
            if (ir1.i(mr1.LOCATION)) {
                linkedHashMap.put("latitude", Double.valueOf(z20.n()));
                linkedHashMap.put("longitude", Double.valueOf(z20.o()));
            }
            String p = AppConfig.p();
            b41.h(p, "getTtid()");
            linkedHashMap.put(LiveActivity.OPTION_TTID, p);
            linkedHashMap.put("comboChannel", "1");
            linkedHashMap.put("pageNo", "1");
            linkedHashMap.put(Constants.Name.PAGE_SIZE, 10);
            String str = ScriptTagPresent.this.storeId;
            if (str != null) {
                linkedHashMap.put("storeId", str);
            }
            JSONObject jSONObject = new JSONObject();
            ArrayList arrayList = new ArrayList();
            String tagValue = ((ScriptTagModel) ScriptTagPresent.this.getModel()).getTagValue(this.tabPosition);
            if (!(tagValue.length() > 0)) {
                tagValue = null;
            }
            if (tagValue != null) {
                arrayList.add(tagValue);
            }
            jSONObject.put((JSONObject) ((ScriptTagModel) ScriptTagPresent.this.getModel()).getTagsOption(), (String) arrayList);
            String jSONString = JSON.toJSONString(jSONObject);
            b41.h(jSONString, "toJSONString(option)");
            linkedHashMap.put("option", jSONString);
            IComponent iComponent = ScriptTagPresent.this.targetComponent;
            if (iComponent != null) {
                JSONObject data = iComponent.getModule().getProperty().getData();
                String str2 = (String) (data != null ? data.get("nodeId") : null);
                JSONObject data2 = iComponent.getProperty().getData();
                DRParam dRParam = new DRParam(str2, (String) (data2 != null ? data2.get("nodeId") : null), JSON.toJSONString(linkedHashMap));
                this.params.put("dr", jn1.ARRAY_START + JSON.toJSONString(dRParam) + jn1.ARRAY_END);
            }
            Map<String, Object> map2 = this.params;
            String jSONString2 = JSON.toJSONString(linkedHashMap);
            b41.h(jSONString2, "toJSONString(args)");
            map2.put("args", jSONString2);
            return new Request.Builder().setApiName("mtop.damai.mec.aristotle.get").setVersion("2.0").setNeedECode(false).setNeedSession(false).setTimeout(10000).setStrategy(this.strategy).setRequestId(IdGenerator.getId()).setDataParams(new HashMap(this.params)).build();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public final class ScriptRequestCallBack implements Callback {
        private static transient /* synthetic */ IpChange $ipChange;

        public ScriptRequestCallBack() {
        }

        @Override // com.youku.arch.v3.io.Callback
        public void onResponse(@NotNull IResponse iResponse) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1341427889")) {
                ipChange.ipc$dispatch("-1341427889", new Object[]{this, iResponse});
                return;
            }
            b41.i(iResponse, "response");
            if (iResponse.isSuccess()) {
                ScriptTagPresent.this.handleLoadSuccess(iResponse);
            } else {
                ScriptTagPresent.this.handleLoadFailure();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.onearch.component.scripttag.ScriptTagPresent$a */
    /* loaded from: classes15.dex */
    public static final class C1489a {
        private C1489a() {
        }

        public /* synthetic */ C1489a(k50 k50Var) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScriptTagPresent(@NotNull String str, @NotNull String str2, @Nullable View view, @NotNull EventHandler eventHandler, @Nullable String str3) {
        super(str, str2, view, eventHandler, str3);
        b41.i(str, "mClassName");
        b41.i(str2, "vClassName");
        b41.i(eventHandler, "eventHandler");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void createItems(Node node) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "40932415")) {
            ipChange.ipc$dispatch("40932415", new Object[]{this, node});
            return;
        }
        IComponent<ComponentValue> iComponent = this.targetComponent;
        final GenericComponent genericComponent = iComponent instanceof GenericComponent ? (GenericComponent) iComponent : null;
        if (genericComponent == null || node.getType() != genericComponent.getType()) {
            return;
        }
        genericComponent.initProperties(node);
        try {
            genericComponent.childItems.clear();
            List<Node> children = genericComponent.getProperty().getChildren();
            if (children != null) {
                for (Object obj : children) {
                    int i2 = i + 1;
                    if (i < 0) {
                        C8214m.p();
                    }
                    Node node2 = (Node) obj;
                    try {
                        IItem<ItemValue> createItem = genericComponent.createItem(new Config<>(genericComponent.getPageContext(), node2.getType(), node2, 0, false, 24, null));
                        if (createItem != null) {
                            genericComponent.childItems.add(createItem);
                            createItem.setIndex(i);
                            createItem.onAdd();
                            genericComponent.getChildIndexUpdater().onChildAdded(createItem);
                        }
                    } catch (Exception e) {
                        if (AppInfoProviderProxy.isDebuggable()) {
                            throw e;
                        }
                    }
                    i = i2;
                }
            }
            genericComponent.getPageContext().runOnUIThreadLocked(new Function0<wt2>() { // from class: cn.damai.onearch.component.scripttag.ScriptTagPresent$createItems$1$2
                private static transient /* synthetic */ IpChange $ipChange;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final wt2 invoke() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-2112761877")) {
                        return (wt2) ipChange2.ipc$dispatch("-2112761877", new Object[]{this});
                    }
                    VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> innerAdapter = genericComponent.getInnerAdapter();
                    if (innerAdapter != null) {
                        innerAdapter.dataCount = genericComponent.getChildCount();
                    }
                    VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter = genericComponent.getAdapter();
                    if (adapter != null) {
                        adapter.notifyItemChanged(0);
                        return wt2.INSTANCE;
                    }
                    return null;
                }
            });
        } catch (Exception e2) {
            if (AppInfoProviderProxy.isDebuggable()) {
                throw e2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Node parseNode(JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1845772560")) {
            return (Node) ipChange.ipc$dispatch("1845772560", new Object[]{this, jSONObject});
        }
        if (jSONObject.containsKey("data")) {
            jSONObject = jSONObject.getJSONObject("data");
            b41.h(jSONObject, "dataJsonObject.getJSONObject(Constants.DATA)");
        }
        return NodeParser.INSTANCE.parse(null, jSONObject);
    }

    public final void handleLoadFailure() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1891737445")) {
            ipChange.ipc$dispatch("1891737445", new Object[]{this});
        } else {
            ((GenericItem) getItem()).getPageContext().runOnUIThreadLocked(new Function0<wt2>() { // from class: cn.damai.onearch.component.scripttag.ScriptTagPresent$handleLoadFailure$1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ wt2 invoke() {
                    invoke2();
                    return wt2.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-910580362")) {
                        ipChange2.ipc$dispatch("-910580362", new Object[]{this});
                    } else {
                        ToastUtil.b("网络开小差了哦，请稍后重试", 0);
                    }
                }
            });
        }
    }

    public final void handleLoadSuccess(@NotNull final IResponse iResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1140371405")) {
            ipChange.ipc$dispatch("1140371405", new Object[]{this, iResponse});
            return;
        }
        b41.i(iResponse, "response");
        ((GenericItem) getItem()).getPageContext().runOnLoaderThreadLocked(new Function0<JSONObject>() { // from class: cn.damai.onearch.component.scripttag.ScriptTagPresent$handleLoadSuccess$1
            private static transient /* synthetic */ IpChange $ipChange;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final JSONObject invoke() {
                Node parseNode;
                Node node;
                List<Node> children;
                Node node2;
                IpChange ipChange2 = $ipChange;
                boolean z = false;
                if (AndroidInstantRuntime.support(ipChange2, "102865743")) {
                    return (JSONObject) ipChange2.ipc$dispatch("102865743", new Object[]{this});
                }
                JSONObject jsonObject = IResponse.this.getJsonObject();
                if (!(jsonObject != null)) {
                    jsonObject = null;
                }
                if (jsonObject != null) {
                    ScriptTagPresent scriptTagPresent = this;
                    try {
                        parseNode = scriptTagPresent.parseNode(jsonObject);
                        if (parseNode != null) {
                            List<Node> children2 = parseNode.getChildren();
                            if ((children2 == null || children2.isEmpty()) ? true : true) {
                                children2 = null;
                            }
                            if (children2 != null && (node = (Node) C8212k.b0(children2)) != null && (children = node.getChildren()) != null) {
                                List<Node> list = children.isEmpty() ? null : children;
                                if (list != null && (node2 = (Node) C8212k.b0(list)) != null) {
                                    scriptTagPresent.createItems(node2);
                                }
                            }
                        }
                    } catch (Exception e) {
                        if (AppInfoProviderProxy.isDebuggable()) {
                            throw e;
                        }
                    }
                    return jsonObject;
                }
                return null;
            }
        });
    }

    @Override // cn.damai.onearch.component.scripttag.ScriptTagContract.Presenter
    public void selectTag(final int i) {
        TrackInfo trackInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "119963072")) {
            ipChange.ipc$dispatch("119963072", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.currentSelectTagPosition = i;
        Action itemAction = getItemAction();
        if (itemAction != null && (trackInfo = itemAction.getTrackInfo()) != null) {
            HashMap<String, String> args = trackInfo.getArgs();
            if (args != null) {
                b41.h(args, "args");
                args.put("tagId", ((ScriptTagModel) getModel()).getTagValue(i));
            }
            UserTrackProviderProxy.click(trackInfo, false);
        }
        ((GenericItem) getItem()).getPageContext().runOnLoaderThread(new Function0<wt2>() { // from class: cn.damai.onearch.component.scripttag.ScriptTagPresent$selectTag$2
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
                if (AndroidInstantRuntime.support(ipChange2, "1359181561")) {
                    ipChange2.ipc$dispatch("1359181561", new Object[]{this});
                } else {
                    Repository.Companion.getInstance().request(new ScriptTagPresent.ScriptRequestBuilder(i).build(new LinkedHashMap()), new ScriptTagPresent.ScriptRequestCallBack());
                }
            }
        });
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.youku.arch.v3.view.AbsPresenter, com.youku.arch.v3.view.IContract.Presenter
    public void init(@NotNull GenericItem<ItemValue> genericItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-401499849")) {
            ipChange.ipc$dispatch("-401499849", new Object[]{this, genericItem});
            return;
        }
        b41.i(genericItem, "item");
        super.init((ScriptTagPresent) genericItem);
        Bundle bundle = genericItem.getPageContext().getBundle();
        this.storeId = bundle != null ? bundle.getString("storeId") : null;
        for (IComponent<ComponentValue> iComponent : genericItem.getComponent().getModule().getComponents()) {
            if (iComponent.getType() == Integer.parseInt(((ScriptTagModel) getModel()).getTargetComponentType())) {
                this.targetComponent = iComponent;
            }
        }
        ((ScriptTagContract.View) getView()).renderTags(((ScriptTagModel) getModel()).getTags(), this.currentSelectTagPosition);
    }
}
