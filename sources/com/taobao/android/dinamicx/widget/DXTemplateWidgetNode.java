package com.taobao.android.dinamicx.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.analysis.v3.FalcoContainerSpan;
import com.taobao.android.dinamicx.DXRemoteChildTemplateManager;
import com.taobao.android.dinamicx.DXRootView;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.DXTemplateManager;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.model.DXJSONObjectForVM;
import com.taobao.android.dinamicx.template.download.DXTemplateItem;
import com.taobao.android.dinamicx.template.download.DXTemplatePackageInfo;
import com.taobao.weex.annotation.JSMethod;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import tb.az;
import tb.hy;
import tb.j10;
import tb.nz;
import tb.ry;
import tb.s00;
import tb.wt;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DXTemplateWidgetNode extends DXLinearLayoutWidgetNode {
    public static final long DXTEMPLATE_BINDSLOT = 1454898352104842311L;
    public static final long DXTEMPLATE_CELLTYPE = 1744786664651967082L;
    public static final long DXTEMPLATE_COLSPAN = 4730601489860228727L;
    public static final long DXTEMPLATE_HASPARAMS = -1664973152736847703L;
    public static final long DXTEMPLATE_HASSLOT = 4914428794176997221L;
    public static final long DXTEMPLATE_IF = 795925;
    public static final int DXTEMPLATE_IF_FALSE = 0;
    public static final int DXTEMPLATE_IF_TRUE = 1;
    public static final long DXTEMPLATE_NAME = 36442092789L;
    public static final long DXTEMPLATE_ONSTICKYCHANGE = 2228800223520853672L;
    public static final long DXTEMPLATE_REUSEIDENTIFIER = 7681326167334452278L;
    public static final long DXTEMPLATE_SLOTID = 10150200245776565L;
    public static final long DXTEMPLATE_STICKY = 10152462037879005L;
    public static final long DXTEMPLATE_STICKYOFFSET = 2669229465858660874L;
    public static final int DXTEMPLATE_STICKY_FALSE = 0;
    public static final int DXTEMPLATE_STICKY_TRUE = 1;
    public static final long DXTEMPLATE_TEMPLATE = -2672413305820574652L;
    public static final long DXTEMPLATE_URL = 528128262;
    public static final long DXTEMPLATE_VERSION = 5435381891761953165L;
    public static final long DXTEMPLATE__SLOTINFOLIST = 7864077457524918358L;
    public static final long DXTEMPLATE__TEMPLATEDATA = 324196793780517186L;
    public static final long DXTEMPLATE___STORAGETYPE = -4416109363904538046L;
    public static final int STORAGE_TYPE_RESULT_TYPE_CONSTANT_DESCRIPTION = 2;
    public static final int STORAGE_TYPE_RESULT_TYPE_DYNAMIC_DESCRIPTION = 3;
    public static final int STORAGE_TYPE_RESULT_TYPE_INLINE = 1;
    private int __StorageType;
    private JSONArray _slotInfoList;
    private JSONObject _templateData;
    private boolean appearing;
    private int attrIf;
    private String bindSlot;
    private String celltype;
    private int colspan;
    private Object data;
    int dataIndex;
    private int hasParams;
    private boolean hasProcessContainsSlotIdTemplate;
    private boolean hasSlot;
    private String name;
    private JSONObject parsedTemplateData;
    private String reuseIdentifier;
    private String slotId;
    private JSONObject slotInfoJObj;
    private FalcoContainerSpan span;
    private int sticky;
    private int stickyOffset;
    private String url;
    private String version;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class a implements IDXBuilderWidgetNode {
        @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
        public DXWidgetNode build(Object obj) {
            return new DXTemplateWidgetNode();
        }
    }

    public DXTemplateWidgetNode() {
        this.disableFlatten = true;
    }

    private DXRemoteChildTemplateManager getDXRemoteChildTemplateManager() {
        DXTemplateItem dxTemplateItem;
        if (getDXRuntimeContext() == null || getDXRuntimeContext().getEngineContext() == null || getDXRuntimeContext().getEngineContext().e() == null) {
            return null;
        }
        DinamicXEngine e = getDXRuntimeContext().getEngineContext().e();
        DXRootView rootView = getDXRuntimeContext().getRootView();
        if (rootView == null || (dxTemplateItem = rootView.getDxTemplateItem()) == null) {
            return null;
        }
        DXRemoteChildTemplateManager dXRemoteChildTemplateManager = e.l().get(dxTemplateItem.getIdentifier());
        if (dXRemoteChildTemplateManager == null) {
            DXRemoteChildTemplateManager dXRemoteChildTemplateManager2 = new DXRemoteChildTemplateManager();
            e.l().put(dxTemplateItem.getIdentifier(), dXRemoteChildTemplateManager2);
            return dXRemoteChildTemplateManager2;
        }
        return dXRemoteChildTemplateManager;
    }

    private JSONObject processSlotInfo(DXWidgetNode dXWidgetNode) {
        if (dXWidgetNode == null) {
            return null;
        }
        DXWidgetNode queryRootWidgetNode = dXWidgetNode.queryRootWidgetNode();
        if (queryRootWidgetNode != null) {
            DXWidgetNode dXWidgetNode2 = queryRootWidgetNode.parentWidget;
            if (dXWidgetNode2 instanceof DXTemplateWidgetNode) {
                DXTemplateWidgetNode dXTemplateWidgetNode = (DXTemplateWidgetNode) dXWidgetNode2;
                JSONObject jSONObject = dXTemplateWidgetNode.slotInfoJObj;
                if (jSONObject != null) {
                    String name = getDXRuntimeContext().getDxTemplateItem().getName();
                    JSONObject jSONObject2 = jSONObject.getJSONObject(name);
                    if (jSONObject2 == null) {
                        s00.b("对应的父节点 " + name + "找不到slot信息");
                        return null;
                    }
                    JSONObject jSONObject3 = jSONObject2.getJSONObject(this.slotId);
                    if (jSONObject3 == null) {
                        s00.b("对应的slotId " + this.slotId + " 找不到slot信息");
                    }
                    nz.a("找到slot信息" + JSON.toJSONString(jSONObject3));
                    return jSONObject3;
                }
                return processSlotInfo(dXTemplateWidgetNode);
            }
        }
        nz.c("坑位 " + this.slotId + " 发生错误 找不到slot信息");
        return null;
    }

    private JSONObject processSlotInfoOld(DXWidgetNode dXWidgetNode) {
        DXWidgetNode queryRootWidgetNode;
        if (dXWidgetNode == null || (queryRootWidgetNode = dXWidgetNode.queryRootWidgetNode()) == null) {
            return null;
        }
        JSONObject slotInfoJObj = queryRootWidgetNode.getSlotInfoJObj();
        if (slotInfoJObj != null) {
            return slotInfoJObj.getJSONObject(getDXRuntimeContext().getDxTemplateItem().getName()).getJSONObject(this.slotId);
        }
        if (queryRootWidgetNode.parentWidget instanceof DXTemplateWidgetNode) {
            return processSlotInfoOld(queryRootWidgetNode.getParentWidget());
        }
        return null;
    }

    private void processTemplateData(JSONObject jSONObject) {
        this.parsedTemplateData = null;
        if (jSONObject == null) {
            return;
        }
        this._templateData = jSONObject;
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void bindRuntimeContext(DXRuntimeContext dXRuntimeContext, boolean z) {
        int i;
        if (dXRuntimeContext == null) {
            return;
        }
        Object obj = null;
        if (z) {
            obj = this.dXRuntimeContext.getSubData();
            i = this.dXRuntimeContext.getSubdataIndex();
        } else {
            i = 0;
        }
        DXRuntimeContext dXRuntimeContext2 = this.dXRuntimeContext;
        if (dXRuntimeContext2 != dXRuntimeContext) {
            Map<String, az> env = dXRuntimeContext2.getEnv();
            DXRuntimeContext cloneWithWidgetNode = dXRuntimeContext.cloneWithWidgetNode(this);
            this.dXRuntimeContext = cloneWithWidgetNode;
            cloneWithWidgetNode.setEnv(env);
            if (z) {
                this.dXRuntimeContext.setSubData(obj);
                this.dXRuntimeContext.setSubdataIndex(i);
            }
        }
        DXWidgetNode childAt = getChildAt(0);
        if (childAt != null && childAt.getDXRuntimeContext() != null) {
            DXRuntimeContext cloneWithWidgetNode2 = childAt.getDXRuntimeContext().cloneWithWidgetNode(childAt);
            if (obj instanceof JSONObject) {
                cloneWithWidgetNode2.setData((JSONObject) obj);
            } else if (dXRuntimeContext.supportDataProxy() && (dXRuntimeContext.getSubData() instanceof Object)) {
                DXJSONObjectForVM dXJSONObjectForVM = new DXJSONObjectForVM();
                dXJSONObjectForVM.setData(dXRuntimeContext.getSubData());
                cloneWithWidgetNode2.setData(dXJSONObjectForVM);
                setData(dXJSONObjectForVM);
            }
            DXTemplateItem dXTemplateItem = new DXTemplateItem();
            dXTemplateItem.name = this.name;
            dXTemplateItem.version = Long.parseLong(this.version);
            cloneWithWidgetNode2.setDxTemplateItem(dXTemplateItem);
            childAt.bindRuntimeContext(cloneWithWidgetNode2, z);
            return;
        }
        nz.g(nz.TAG, "template deepCopyChildNode child or child runtimeContext is null!!!");
    }

    @Override // com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode, com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
    public DXWidgetNode build(Object obj) {
        return new DXTemplateWidgetNode();
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public DXWidgetNode deepClone(DXRuntimeContext dXRuntimeContext) {
        DXWidgetNode dXWidgetNode = (DXWidgetNode) shallowClone(dXRuntimeContext, true);
        DXRuntimeContext cloneWithWidgetNode = dXRuntimeContext.cloneWithWidgetNode(this);
        DXTemplateItem dXTemplateItem = new DXTemplateItem();
        dXTemplateItem.name = this.name;
        try {
            if (!TextUtils.isEmpty(this.version)) {
                dXTemplateItem.version = Long.valueOf(this.version).longValue();
            }
        } catch (NumberFormatException e) {
            ry.b(e);
        }
        dXTemplateItem.templateUrl = this.url;
        if (dXRuntimeContext.getDxTemplateItem() != null && dXRuntimeContext.getDxTemplateItem().packageInfo != null) {
            DXTemplatePackageInfo dXTemplatePackageInfo = new DXTemplatePackageInfo();
            dXTemplatePackageInfo.mainFilePath = dXRuntimeContext.getDxTemplateItem().packageInfo.mainFilePath;
            dXTemplatePackageInfo.subFilePathDict = dXRuntimeContext.getDxTemplateItem().packageInfo.subFilePathDict;
            dXTemplateItem.packageInfo = dXTemplatePackageInfo;
            nz.s("DXTemplateWidgetNode deepClone 写packageinfo信息");
        }
        cloneWithWidgetNode.setDxTemplateItem(dXTemplateItem);
        if (this.children != null) {
            dXWidgetNode.children = new ArrayList();
            for (int i = 0; i < this.children.size(); i++) {
                dXWidgetNode.addChild(this.children.get(i).deepClone(cloneWithWidgetNode), false);
            }
        }
        return dXWidgetNode;
    }

    public DXWidgetNode deepCopyChildNode(DXRuntimeContext dXRuntimeContext) {
        DXWidgetNode childAt;
        DXWidgetNode dXWidgetNode = (DXWidgetNode) shallowClone(dXRuntimeContext, true);
        dXWidgetNode.setSourceWidget(getSourceWidget());
        g.a(dXWidgetNode);
        if (!isRemote() && (childAt = getChildAt(0)) != null && childAt.getDXRuntimeContext() != null) {
            DXRuntimeContext cloneWithWidgetNode = childAt.getDXRuntimeContext().cloneWithWidgetNode(childAt);
            if (dXRuntimeContext.getSubData() instanceof JSONObject) {
                cloneWithWidgetNode.setData((JSONObject) dXRuntimeContext.getSubData());
            } else if (dXRuntimeContext.supportDataProxy() && (dXRuntimeContext.getSubData() instanceof Object)) {
                DXJSONObjectForVM dXJSONObjectForVM = new DXJSONObjectForVM();
                dXJSONObjectForVM.setData(dXRuntimeContext.getSubData());
                cloneWithWidgetNode.setData(dXJSONObjectForVM);
                setData(dXJSONObjectForVM);
            }
            dXWidgetNode.addChild(g.c(childAt, cloneWithWidgetNode, false), false);
        }
        return dXWidgetNode;
    }

    public String getCelltype() {
        return this.celltype;
    }

    public boolean getHasSlot() {
        return this.hasSlot;
    }

    public String getName() {
        return this.name;
    }

    public JSONObject getParsedTemplateData() {
        return this.parsedTemplateData;
    }

    public String getReuseIdentifier() {
        return this.reuseIdentifier;
    }

    public String getSlotId() {
        return this.slotId;
    }

    public FalcoContainerSpan getSpan() {
        return this.span;
    }

    public int getStickyOffset() {
        return this.stickyOffset;
    }

    public String getTemplateInfo() {
        return this.name + JSMethod.NOT_SET + this.version;
    }

    public String getUrl() {
        return this.url;
    }

    public String getVersion() {
        return this.version;
    }

    public int get__StorageType() {
        return this.__StorageType;
    }

    public JSONObject get_templateData() {
        return this._templateData;
    }

    public boolean isFullSpan() {
        return this.colspan > 1 || isSticky();
    }

    public boolean isKeepInRecyclerLru() {
        return isSticky() || this.appearing;
    }

    public boolean isRemote() {
        return this.__StorageType == 3;
    }

    public boolean isSticky() {
        return this.sticky == 1;
    }

    @Override // com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onBeforeBindChildData() {
        super.onBeforeBindChildData();
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onBeginParser(boolean z) {
        this.parsedTemplateData = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onBindEvent(Context context, View view, long j) {
        super.onBindEvent(context, view, j);
    }

    @Override // com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onClone(DXWidgetNode dXWidgetNode, boolean z) {
        if (dXWidgetNode == null || !(dXWidgetNode instanceof DXTemplateWidgetNode)) {
            return;
        }
        super.onClone(dXWidgetNode, z);
        DXTemplateWidgetNode dXTemplateWidgetNode = (DXTemplateWidgetNode) dXWidgetNode;
        this.celltype = dXTemplateWidgetNode.celltype;
        this.colspan = dXTemplateWidgetNode.colspan;
        this.attrIf = dXTemplateWidgetNode.attrIf;
        this.name = dXTemplateWidgetNode.name;
        this.sticky = dXTemplateWidgetNode.sticky;
        this.stickyOffset = dXTemplateWidgetNode.stickyOffset;
        this.url = dXTemplateWidgetNode.url;
        this.version = dXTemplateWidgetNode.version;
        this.__StorageType = dXTemplateWidgetNode.__StorageType;
        this.span = dXTemplateWidgetNode.span;
        this._templateData = dXTemplateWidgetNode._templateData;
        this.parsedTemplateData = dXTemplateWidgetNode.parsedTemplateData;
        this.bindSlot = dXTemplateWidgetNode.bindSlot;
        this.hasParams = dXTemplateWidgetNode.hasParams;
        this.hasSlot = dXTemplateWidgetNode.hasSlot;
        this.slotId = dXTemplateWidgetNode.slotId;
        this._slotInfoList = dXTemplateWidgetNode._slotInfoList;
        this.slotInfoJObj = dXTemplateWidgetNode.slotInfoJObj;
        this.hasProcessContainsSlotIdTemplate = dXTemplateWidgetNode.hasProcessContainsSlotIdTemplate;
        this.reuseIdentifier = dXTemplateWidgetNode.reuseIdentifier;
        if (wt.r0()) {
            this.dataIndex = dXTemplateWidgetNode.dataIndex;
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    protected View onCreateView(Context context) {
        return super.onCreateView(context);
    }

    @Override // com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public final void onProcessRemoteTemplate(int i) {
        try {
            if (isRemote() && getChildrenCount() <= 0) {
                if (!TextUtils.isEmpty(this.slotId)) {
                    processContainsSlotIdTemplate();
                }
                removeAllChild();
                DXTemplateItem dXTemplateItem = new DXTemplateItem();
                dXTemplateItem.name = getName();
                if (!TextUtils.isEmpty(getVersion())) {
                    dXTemplateItem.version = Long.parseLong(getVersion());
                }
                dXTemplateItem.templateUrl = getUrl();
                DXRemoteChildTemplateManager dXRemoteChildTemplateManager = getDXRemoteChildTemplateManager();
                if (dXRemoteChildTemplateManager == null) {
                    return;
                }
                DXTemplateManager h = dXRemoteChildTemplateManager.h(getDXRuntimeContext());
                if (h == null) {
                    s00.b("dxRemoteChildTemplateManager.getTemplateManger(getDXRuntimeContext()) == null");
                }
                DXTemplateItem g = dXRemoteChildTemplateManager.g(h, dXTemplateItem);
                if (dXRemoteChildTemplateManager.i(g, dXTemplateItem)) {
                    DXWidgetNode e = dXRemoteChildTemplateManager.e(g, getDXRuntimeContext(), h, i);
                    if (e != null) {
                        addChild(e, false);
                        return;
                    }
                    s00.b("同步获取模版失败" + dXTemplateItem.getIdentifier());
                    return;
                }
                if (g != null) {
                    DXWidgetNode e2 = dXRemoteChildTemplateManager.e(g, getDXRuntimeContext(), h, i);
                    if (e2 != null) {
                        addChild(e2, false);
                    } else {
                        s00.b("同步获取模版失败" + dXTemplateItem.getIdentifier());
                    }
                }
                if (getDXRuntimeContext().getEngineContext().b().j() == 1) {
                    dXRemoteChildTemplateManager.f(dXTemplateItem, getDXRuntimeContext(), this, h);
                } else {
                    dXRemoteChildTemplateManager.j(dXTemplateItem, getDXRuntimeContext(), this, h, i);
                }
            }
        } catch (Throwable th) {
            if (DinamicXEngine.x()) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXWidgetNode
    protected void onRenderView(Context context, View view) {
        super.onRenderView(context, view);
        if (!isSticky() || getDXRuntimeContext().getRootView().getDxNestedScrollerView() == null) {
            return;
        }
        getDXRuntimeContext().getRootView().getDxNestedScrollerView().setStickyHeight(getMeasuredHeight());
    }

    @Override // com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetIntAttribute(long j, int i) {
        if (j == DXTEMPLATE___STORAGETYPE) {
            nz.a("onSetIntAttribute");
            this.__StorageType = i;
        } else if (j == 4730601489860228727L) {
            this.colspan = i;
        } else if (j == DXTEMPLATE_IF) {
            this.attrIf = i;
        } else if (j == DXTEMPLATE_STICKY) {
            this.sticky = i;
        } else if (j == DXTEMPLATE_STICKYOFFSET) {
            this.stickyOffset = i;
        } else if (j == DXTEMPLATE_HASPARAMS) {
            this.hasParams = i;
        } else if (j == DXTEMPLATE_HASSLOT) {
            this.hasSlot = i == 1;
        } else {
            super.onSetIntAttribute(j, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetListAttribute(long j, JSONArray jSONArray) {
        if (j == DXTEMPLATE__SLOTINFOLIST) {
            this._slotInfoList = jSONArray;
            this.slotInfoJObj = j10.b(jSONArray);
            return;
        }
        super.onSetListAttribute(j, jSONArray);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetMapAttribute(long j, JSONObject jSONObject) {
        if (j == DXTEMPLATE__TEMPLATEDATA) {
            processTemplateData(jSONObject);
        } else {
            super.onSetMapAttribute(j, jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetStringAttribute(long j, String str) {
        if (j == DXTEMPLATE_CELLTYPE) {
            this.celltype = str;
        } else if (j == DXTEMPLATE_NAME) {
            this.name = str;
        } else if (j == DXTEMPLATE_URL) {
            this.url = str;
        } else if (j == DXTEMPLATE_VERSION) {
            this.version = str;
        } else if (j == DXTEMPLATE_BINDSLOT) {
            this.bindSlot = str;
        } else if (j == DXTEMPLATE_SLOTID) {
            this.slotId = str;
        } else if (j == DXTEMPLATE_REUSEIDENTIFIER) {
            this.reuseIdentifier = str;
        } else {
            super.onSetStringAttribute(j, str);
        }
    }

    public void processContainsSlotIdTemplate() {
        if (this.hasProcessContainsSlotIdTemplate && DinamicXEngine.x()) {
            nz.c("hasProcessContainsSlotIdTemplate: " + getTemplateInfo());
        }
        JSONObject processSlotInfo = processSlotInfo(this);
        if (processSlotInfo != null) {
            this.name = j10.a(getDXRuntimeContext(), "name", processSlotInfo);
            this.version = j10.a(getDXRuntimeContext(), "version", processSlotInfo);
            this.url = j10.a(getDXRuntimeContext(), "url", processSlotInfo);
            this._templateData = processSlotInfo;
        }
        this.hasProcessContainsSlotIdTemplate = true;
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    void processUserId() {
        if (TextUtils.isEmpty(this.userId)) {
            return;
        }
        DXWidgetNode queryRootWidgetNode = queryRootWidgetNode();
        if (queryRootWidgetNode instanceof f) {
            Map<String, WeakReference<DXWidgetNode>> dxUserIdMap = ((f) queryRootWidgetNode).getDxUserIdMap();
            WeakReference<DXWidgetNode> weakReference = dxUserIdMap.get(this.userId);
            if (weakReference != null) {
                DXWidgetNode dXWidgetNode = weakReference.get();
                if (dXWidgetNode == null || !(getParentWidget() instanceof DXAbsContainerBaseLayout)) {
                    return;
                }
                DXAbsContainerBaseLayout dXAbsContainerBaseLayout = (DXAbsContainerBaseLayout) getParentWidget();
                if (dXAbsContainerBaseLayout.getItemWidgetNodes() == null || dXAbsContainerBaseLayout.getItemWidgetNodes().indexOf(dXWidgetNode) == -1) {
                    dxUserIdMap.put(this.userId, new WeakReference<>(this));
                    return;
                }
                return;
            }
            dxUserIdMap.put(this.userId, new WeakReference<>(this));
        }
    }

    public void setAppearing(boolean z) {
        this.appearing = z;
    }

    public void setData(Object obj) {
    }

    public void setDataIndex(int i) {
        this.dataIndex = i;
    }

    public void setParsedTemplateData(JSONObject jSONObject) {
        this.parsedTemplateData = jSONObject;
    }

    public void setSpan(FalcoContainerSpan falcoContainerSpan) {
        this.span = falcoContainerSpan;
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public Object shallowClone(@NonNull DXRuntimeContext dXRuntimeContext, boolean z) {
        DXWidgetNode build = build(null);
        if (build == null) {
            return null;
        }
        if (dXRuntimeContext != null) {
            build.dXRuntimeContext = dXRuntimeContext.cloneWithWidgetNode(build);
        }
        build.onClone(this, z);
        return build;
    }

    public void triggerOnStickyChange(int i, boolean z) {
        hy hyVar = new hy(2228800223520853672L);
        HashMap hashMap = new HashMap();
        hashMap.put("index", az.J(i));
        hashMap.put("sticky", az.F(z));
        hyVar.d(hashMap);
        postEvent(hyVar);
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void updateRefreshType(int i) {
        DXRuntimeContext dXRuntimeContext = this.dXRuntimeContext;
        if (dXRuntimeContext != null) {
            dXRuntimeContext.setRefreshType(i);
        }
        if (getChildrenCount() > 0) {
            for (DXWidgetNode dXWidgetNode : this.children) {
                dXWidgetNode.updateRefreshType(i);
            }
        }
    }
}
