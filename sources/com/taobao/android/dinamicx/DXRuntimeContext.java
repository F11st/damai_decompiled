package com.taobao.android.dinamicx;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.alibaba.fastjson.JSONObject;
import com.taobao.analysis.v3.FalcoContainerSpan;
import com.taobao.android.dinamicx.C6368e;
import com.taobao.android.dinamicx.expression.parser.IDXDataParser;
import com.taobao.android.dinamicx.model.DXLongSparseArray;
import com.taobao.android.dinamicx.notification.DXNotificationCenter;
import com.taobao.android.dinamicx.template.download.DXTemplateItem;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode;
import com.taobao.weex.annotation.JSMethod;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tb.az;
import tb.bu;
import tb.c20;
import tb.d00;
import tb.my;
import tb.v01;
import tb.z00;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class DXRuntimeContext implements Cloneable {
    public static final int REFRESH_ALL = 0;
    public static final int REFRESH_PART = 1;
    protected String bizType;
    protected String cacheIdentify;
    protected DXEngineConfig config;
    protected WeakReference<Context> contextWeakReference;
    private JSONObject data;
    private WeakReference<JSONObject> dataWRef;
    protected WeakReference<bu> dxControlEventCenterWeakReference;
    protected C6368e dxError;
    protected WeakReference<DXNotificationCenter> dxNotificationCenterWeakReference;
    private d00 dxPerformInfo;
    private Map<String, String> dxPerformTrackerData;
    protected WeakReference<DXRenderPipeline> dxRenderPipelineWeakReference;
    protected DXTemplateItem dxTemplateItem;
    @Deprecated
    protected Object dxUserContext;
    protected C6367d engineContext;
    private Map<String, az> env;
    private my eventChainExpressionSourceContext;
    protected WeakReference<DXLongSparseArray<IDXEventHandler>> eventHandlerMapWeakReference;
    int instanceId;
    private FalcoContainerSpan openTracerSpan;
    protected DXLongSparseArray<IDXDataParser> parserMap;
    protected String pipelineIdentifier;
    int refreshType;
    int renderType;
    int rootHeightSpec;
    protected WeakReference<DXRootView> rootViewWeakReference;
    int rootWidthSpec;
    protected Object subData;
    protected int subdataIndex;
    protected c20 userContext;
    protected DXWidgetNode widgetNode;
    protected DXLongSparseArray<IDXBuilderWidgetNode> widgetNodeMap;
    private int parentDirectionSpec = 0;
    boolean needChildThread = true;
    private int defaultAutoId = 0;
    private int defaultAutoIdInterval = 100000000;
    public int createCount = 0;
    public int reuseCount = 0;
    public float reCountTime = 0.0f;
    public float reuseCountTime = 0.0f;
    public float countTime = 0.0f;
    public String createViewInfo = "";
    public String renderViewInfo = "";
    public boolean isHitCache = false;

    /* compiled from: Taobao */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes12.dex */
    public @interface DXRefreshType {
    }

    public DXRuntimeContext(@NonNull C6367d c6367d) {
        this.engineContext = c6367d;
        DXEngineConfig dXEngineConfig = c6367d.a;
        this.config = dXEngineConfig;
        this.bizType = dXEngineConfig.a;
    }

    private DXWidgetNode getFlatten() {
        DXWidgetNode dXWidgetNode = this.widgetNode;
        if (dXWidgetNode == null) {
            return null;
        }
        if (dXWidgetNode.isFlatten()) {
            return this.widgetNode;
        }
        return this.widgetNode.getReferenceNode();
    }

    public DXRuntimeContext cloneWithWidgetNode(DXWidgetNode dXWidgetNode) {
        DXRuntimeContext dXRuntimeContext = new DXRuntimeContext(this.engineContext);
        dXRuntimeContext.dxUserContext = this.dxUserContext;
        dXRuntimeContext.dxTemplateItem = this.dxTemplateItem;
        dXRuntimeContext.widgetNode = dXWidgetNode;
        dXRuntimeContext.dataWRef = this.dataWRef;
        dXRuntimeContext.contextWeakReference = this.contextWeakReference;
        dXRuntimeContext.subData = this.subData;
        dXRuntimeContext.subdataIndex = this.subdataIndex;
        dXRuntimeContext.widgetNodeMap = this.widgetNodeMap;
        dXRuntimeContext.eventHandlerMapWeakReference = this.eventHandlerMapWeakReference;
        dXRuntimeContext.parserMap = this.parserMap;
        dXRuntimeContext.dxControlEventCenterWeakReference = this.dxControlEventCenterWeakReference;
        dXRuntimeContext.dxRenderPipelineWeakReference = this.dxRenderPipelineWeakReference;
        dXRuntimeContext.dxNotificationCenterWeakReference = this.dxNotificationCenterWeakReference;
        dXRuntimeContext.rootViewWeakReference = this.rootViewWeakReference;
        dXRuntimeContext.dxError = this.dxError;
        dXRuntimeContext.setParentDirectionSpec(this.parentDirectionSpec);
        dXRuntimeContext.renderType = this.renderType;
        dXRuntimeContext.pipelineIdentifier = this.pipelineIdentifier;
        dXRuntimeContext.rootWidthSpec = this.rootWidthSpec;
        dXRuntimeContext.rootHeightSpec = this.rootHeightSpec;
        dXRuntimeContext.refreshType = this.refreshType;
        dXRuntimeContext.instanceId = this.instanceId;
        dXRuntimeContext.env = this.env;
        dXRuntimeContext.needChildThread = this.needChildThread;
        dXRuntimeContext.openTracerSpan = this.openTracerSpan;
        dXRuntimeContext.dxPerformTrackerData = this.dxPerformTrackerData;
        dXRuntimeContext.defaultAutoId = this.defaultAutoId;
        dXRuntimeContext.data = this.data;
        return dXRuntimeContext;
    }

    public String getBizType() {
        return this.bizType;
    }

    public String getCacheIdentify() {
        if (TextUtils.isEmpty(this.cacheIdentify) && this.dxTemplateItem != null && getData() != null) {
            this.cacheIdentify = this.dxTemplateItem.name + JSMethod.NOT_SET + this.dxTemplateItem.version + JSMethod.NOT_SET + System.identityHashCode(getData()) + "w:" + getRootWidthSpec() + "h:" + getRootHeightSpec();
        }
        return this.cacheIdentify;
    }

    public String getCacheIdentifyWithSubData() {
        if (TextUtils.isEmpty(this.cacheIdentify) && this.dxTemplateItem != null && getData() != null) {
            this.cacheIdentify = this.dxTemplateItem.name + JSMethod.NOT_SET + this.dxTemplateItem.version + JSMethod.NOT_SET + System.identityHashCode(getSubData()) + "w:" + getRootWidthSpec() + "h:" + getRootHeightSpec();
        }
        return this.cacheIdentify;
    }

    public DXEngineConfig getConfig() {
        return this.config;
    }

    public Context getContext() {
        WeakReference<Context> weakReference = this.contextWeakReference;
        if (weakReference != null && weakReference.get() != null) {
            return this.contextWeakReference.get();
        }
        return DinamicXEngine.i();
    }

    public JSONObject getData() {
        WeakReference<JSONObject> weakReference = this.dataWRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public v01 getDataProxy() {
        if (getEngineContext() == null) {
            return null;
        }
        return getEngineContext().f();
    }

    public bu getDxControlEventCenter() {
        WeakReference<bu> weakReference = this.dxControlEventCenterWeakReference;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public C6368e getDxError() {
        return this.dxError;
    }

    public DXNotificationCenter getDxNotificationCenter() {
        WeakReference<DXNotificationCenter> weakReference = this.dxNotificationCenterWeakReference;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public d00 getDxPerformInfo() {
        if (this.dxPerformInfo == null) {
            this.dxPerformInfo = new d00();
        }
        return this.dxPerformInfo;
    }

    public Map<String, String> getDxPerformTrackerData() {
        return this.dxPerformTrackerData;
    }

    public DXRenderPipeline getDxRenderPipeline() {
        WeakReference<DXRenderPipeline> weakReference = this.dxRenderPipelineWeakReference;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public DXTemplateItem getDxTemplateItem() {
        return this.dxTemplateItem;
    }

    public Object getDxUserContext() {
        return this.dxUserContext;
    }

    public C6367d getEngineContext() {
        return this.engineContext;
    }

    public Map<String, az> getEnv() {
        return this.env;
    }

    public my getEventChainExpressionSourceContext() {
        return this.eventChainExpressionSourceContext;
    }

    public DXLongSparseArray<IDXEventHandler> getEventHandlerMap() {
        WeakReference<DXLongSparseArray<IDXEventHandler>> weakReference = this.eventHandlerMapWeakReference;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public IDXEventHandler getEventHandlerWithId(long j) {
        WeakReference<DXLongSparseArray<IDXEventHandler>> weakReference = this.eventHandlerMapWeakReference;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return this.eventHandlerMapWeakReference.get().get(j);
    }

    public int getInstanceId() {
        return this.instanceId;
    }

    public View getNativeView() {
        DXWidgetNode flatten = getFlatten();
        if (flatten == null || flatten.getWRView() == null) {
            return null;
        }
        return flatten.getWRView().get();
    }

    public FalcoContainerSpan getOpenTracerSpan() {
        return this.openTracerSpan;
    }

    public int getParentDirectionSpec() {
        return this.parentDirectionSpec;
    }

    public DXLongSparseArray<IDXDataParser> getParserMap() {
        return this.parserMap;
    }

    public String getPipelineIdentifier() {
        return this.pipelineIdentifier;
    }

    public DXWidgetNode getRealRootExpandWidget() {
        if (getRootView() == null) {
            return null;
        }
        return getRootView().getExpandWidgetNode();
    }

    public int getRefreshType() {
        return this.refreshType;
    }

    public int getRenderType() {
        return this.renderType;
    }

    public int getRootHeightSpec() {
        int i = this.rootHeightSpec;
        return i == 0 ? z00.e() : i;
    }

    public DXRootView getRootView() {
        WeakReference<DXRootView> weakReference = this.rootViewWeakReference;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public int getRootWidthSpec() {
        int i = this.rootWidthSpec;
        return i == 0 ? z00.f() : i;
    }

    public Object getSubData() {
        return this.subData;
    }

    public int getSubdataIndex() {
        return this.subdataIndex;
    }

    public String getTemplateId() {
        DXTemplateItem dXTemplateItem = this.dxTemplateItem;
        return dXTemplateItem == null ? "tplNUll" : dXTemplateItem.getIdentifier();
    }

    public c20 getUserContext() {
        return this.userContext;
    }

    public DXWidgetNode getWidgetNode() {
        DXWidgetNode dXWidgetNode = this.widgetNode;
        if (dXWidgetNode == null) {
            return null;
        }
        if (!dXWidgetNode.isFlatten()) {
            return this.widgetNode;
        }
        return this.widgetNode.getReferenceNode();
    }

    public DXLongSparseArray<IDXBuilderWidgetNode> getWidgetNodeMap() {
        return this.widgetNodeMap;
    }

    public boolean hasError() {
        List<C6368e.C6369a> list;
        C6368e c6368e = this.dxError;
        return (c6368e == null || (list = c6368e.c) == null || list.size() <= 0) ? false : true;
    }

    public boolean isNeedChildThread() {
        return this.needChildThread;
    }

    public boolean isOpenNewFastReturnLogic() {
        if (getEngineContext() == null || getEngineContext().b() == null || !getEngineContext().b().r()) {
            return getWidgetNode() != null && getWidgetNode().isOpenNewFastReturnLogic();
        }
        return true;
    }

    public boolean isRefreshPart() {
        return this.refreshType == 1;
    }

    public DXRuntimeContext putPerformTrackerData(String str, String str2) {
        if (this.dxPerformTrackerData == null) {
            this.dxPerformTrackerData = new ConcurrentHashMap();
        }
        this.dxPerformTrackerData.put(str, str2);
        return this;
    }

    public void setData(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.dataWRef = new WeakReference<>(jSONObject);
        }
    }

    public void setDxError(C6368e c6368e) {
        this.dxError = c6368e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setDxRenderPipeline(WeakReference<DXRenderPipeline> weakReference) {
        this.dxRenderPipelineWeakReference = weakReference;
    }

    public void setDxTemplateItem(DXTemplateItem dXTemplateItem) {
        this.dxTemplateItem = dXTemplateItem;
    }

    public void setEnv(Map<String, az> map) {
        this.env = map;
    }

    public void setEventChainExpressionSourceContext(my myVar) {
        this.eventChainExpressionSourceContext = myVar;
    }

    public void setInstanceId(int i) {
        this.instanceId = i;
    }

    public void setNeedChildThread(boolean z) {
        this.needChildThread = z;
    }

    public void setOpenTracerSpan(FalcoContainerSpan falcoContainerSpan) {
        this.openTracerSpan = falcoContainerSpan;
    }

    public void setParentDirectionSpec(int i) {
        this.parentDirectionSpec = i;
    }

    public void setPipelineIdentifier(String str) {
        this.pipelineIdentifier = str;
    }

    public void setRefreshType(int i) {
        this.refreshType = i;
    }

    public void setSubData(Object obj) {
        this.subData = obj;
    }

    public void setSubdataIndex(int i) {
        this.subdataIndex = i;
    }

    public void setWidgetNode(DXWidgetNode dXWidgetNode) {
        this.widgetNode = dXWidgetNode;
    }

    public boolean supportDataProxy() {
        getDataProxy();
        return false;
    }

    public void updateRootHeightSpec(int i) {
        this.rootHeightSpec = i;
    }
}
