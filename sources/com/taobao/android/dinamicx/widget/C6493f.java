package com.taobao.android.dinamicx.widget;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.alibaba.fastjson.JSONArray;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.weex.common.Constants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.az;
import tb.lz;
import tb.mz;
import tb.wt;

/* compiled from: Taobao */
/* renamed from: com.taobao.android.dinamicx.widget.f */
/* loaded from: classes11.dex */
public class C6493f extends DXWidgetNode implements IDXNodePropProvider {
    public static final long DXLAYOUT_MARKCONTAINER = 8182691489212564827L;
    boolean disableFlatten;
    Map<String, WeakReference<DXWidgetNode>> dxUserIdMap;
    JSONArray listData;
    boolean markContainer = false;
    List<DXWidgetNode> originItems;

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0023, code lost:
        if (r7 == (-2)) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002c, code lost:
        if (r7 == (-2)) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003a, code lost:
        if (r7 == (-2)) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int getChildMeasureSpec(int r5, int r6, int r7) {
        /*
            int r0 = com.taobao.android.dinamicx.widget.DXWidgetNode.DXMeasureSpec.a(r5)
            int r5 = com.taobao.android.dinamicx.widget.DXWidgetNode.DXMeasureSpec.b(r5)
            int r5 = r5 - r6
            r6 = 0
            int r5 = java.lang.Math.max(r6, r5)
            r1 = -2
            r2 = -1
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = 1073741824(0x40000000, float:2.0)
            if (r0 == r3) goto L2f
            if (r0 == 0) goto L26
            if (r0 == r4) goto L1b
            goto L3d
        L1b:
            if (r7 < 0) goto L1e
            goto L31
        L1e:
            if (r7 != r2) goto L23
            r6 = 1073741824(0x40000000, float:2.0)
            goto L38
        L23:
            if (r7 != r1) goto L3d
            goto L36
        L26:
            if (r7 < 0) goto L29
            goto L31
        L29:
            if (r7 != r2) goto L2c
        L2b:
            goto L38
        L2c:
            if (r7 != r1) goto L3d
            goto L2b
        L2f:
            if (r7 < 0) goto L34
        L31:
            r6 = 1073741824(0x40000000, float:2.0)
            goto L3e
        L34:
            if (r7 != r2) goto L3a
        L36:
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
        L38:
            r7 = r5
            goto L3e
        L3a:
            if (r7 != r1) goto L3d
            goto L36
        L3d:
            r7 = 0
        L3e:
            int r5 = com.taobao.android.dinamicx.widget.DXWidgetNode.DXMeasureSpec.c(r7, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.android.dinamicx.widget.C6493f.getChildMeasureSpec(int, int, int):int");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bindContext(DXWidgetNode dXWidgetNode, Object obj, int i) {
        dXWidgetNode.getDXRuntimeContext().setSubData(obj);
        dXWidgetNode.getDXRuntimeContext().setSubdataIndex(i);
        HashMap hashMap = new HashMap();
        dXWidgetNode.getDXRuntimeContext().setEnv(hashMap);
        hashMap.put("i", az.J(i));
        hashMap.put(Constants.Name.Recycler.LIST_DATA, az.E(getListData()));
        if (wt.o0()) {
            dXWidgetNode.setSourceWidget(dXWidgetNode);
        } else if (dXWidgetNode.getSourceWidget() == null) {
            dXWidgetNode.setSourceWidget(dXWidgetNode);
        }
        List<DXWidgetNode> children = dXWidgetNode.getChildren();
        if (children == null || children.size() == 0) {
            return;
        }
        for (DXWidgetNode dXWidgetNode2 : children) {
            bindContext(dXWidgetNode2, obj, i);
        }
    }

    public ViewGroup.LayoutParams generateLayoutParams(@NonNull lz lzVar) {
        return new ViewGroup.LayoutParams(lzVar.a, lzVar.b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ArrayList<DXWidgetNode> generateWidgetNodeByData(int i, JSONArray jSONArray, List<DXWidgetNode> list) {
        ArrayList<DXWidgetNode> arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < jSONArray.size(); i2++) {
            Object obj = jSONArray.get(i2);
            int i3 = i2 + i;
            if (i3 == 0) {
                for (DXWidgetNode dXWidgetNode : list) {
                    bindContext(dXWidgetNode, obj, i3);
                }
            } else {
                for (DXWidgetNode dXWidgetNode2 : list) {
                    DXRuntimeContext cloneWithWidgetNode = dXWidgetNode2.getDXRuntimeContext().cloneWithWidgetNode(dXWidgetNode2);
                    cloneWithWidgetNode.setSubData(obj);
                    cloneWithWidgetNode.setSubdataIndex(i3);
                    HashMap hashMap = new HashMap();
                    cloneWithWidgetNode.setEnv(hashMap);
                    hashMap.put("i", az.J(i3));
                    hashMap.put(Constants.Name.Recycler.LIST_DATA, az.E(jSONArray));
                    DXWidgetNode b = C6494g.b(dXWidgetNode2, cloneWithWidgetNode);
                    b.setParentWidget(this);
                    arrayList.add(b);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, WeakReference<DXWidgetNode>> getDxUserIdMap() {
        if (this.dxUserIdMap == null) {
            this.dxUserIdMap = new HashMap();
        }
        return this.dxUserIdMap;
    }

    public JSONArray getListData() {
        return this.listData;
    }

    public Object getNodePropByKey(String str) {
        if (Constants.Name.Recycler.LIST_DATA.equals(str)) {
            return this.listData;
        }
        return null;
    }

    public List<DXWidgetNode> getOriginItems() {
        return this.originItems;
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public boolean isClipChildren() {
        return this.clipChildren;
    }

    public boolean isDisableFlatten() {
        return this.disableFlatten;
    }

    public boolean isHandleListData() {
        return (this.propertyInitFlag & 2) != 0;
    }

    public boolean isLayoutRtl() {
        return getDirection() == 1;
    }

    public boolean isMarkContainer() {
        return this.markContainer;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void measureChildWithMargins(DXWidgetNode dXWidgetNode, int i, int i2, int i3, int i4) {
        dXWidgetNode.measure(getChildMeasureSpec(i, this.paddingLeft + this.paddingRight + dXWidgetNode.marginLeft + dXWidgetNode.marginRight + i2, dXWidgetNode.layoutWidth), getChildMeasureSpec(i3, this.paddingTop + this.paddingBottom + dXWidgetNode.marginTop + dXWidgetNode.marginBottom + i4, dXWidgetNode.layoutHeight));
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onBeforeBindChildData() {
        if (!wt.w0() && getChildren() != null && this.originItems == null) {
            ArrayList arrayList = new ArrayList();
            this.originItems = arrayList;
            arrayList.addAll(getChildren());
        }
        if ((this.propertyInitFlag & 2) == 0) {
            return;
        }
        if (wt.w0() && getChildren() != null && this.originItems == null) {
            this.originItems = new ArrayList();
            for (DXWidgetNode dXWidgetNode : getChildren()) {
                this.originItems.add(dXWidgetNode.deepClone(getDXRuntimeContext()));
            }
        }
        JSONArray jSONArray = this.listData;
        if (jSONArray != null && !jSONArray.isEmpty() && getChildren() != null) {
            new ArrayList();
            if (wt.w0() && getDXRuntimeContext().isRefreshPart()) {
                removeAllChild();
                for (DXWidgetNode dXWidgetNode2 : this.originItems) {
                    addChild(dXWidgetNode2.deepClone(getDXRuntimeContext()));
                }
            }
            ArrayList<DXWidgetNode> generateWidgetNodeByData = generateWidgetNodeByData(0, getListData(), getChildren());
            for (int i = 0; i < generateWidgetNodeByData.size(); i++) {
                addChild(generateWidgetNodeByData.get(i), false);
            }
            return;
        }
        removeAllChild();
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onClone(DXWidgetNode dXWidgetNode, boolean z) {
        super.onClone(dXWidgetNode, z);
        if (dXWidgetNode instanceof C6493f) {
            C6493f c6493f = (C6493f) dXWidgetNode;
            this.disableFlatten = c6493f.disableFlatten;
            this.listData = c6493f.listData;
            this.originItems = c6493f.originItems;
            this.markContainer = c6493f.markContainer;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onRenderView(Context context, View view) {
        if (view == null) {
            return;
        }
        if (view instanceof ViewGroup) {
            if (Build.VERSION.SDK_INT >= 18) {
                ViewGroup viewGroup = (ViewGroup) view;
                boolean clipChildren = viewGroup.getClipChildren();
                boolean z = this.clipChildren;
                if (clipChildren != z) {
                    viewGroup.setClipChildren(z);
                }
            } else {
                ((ViewGroup) view).setClipChildren(this.clipChildren);
            }
        }
        super.onRenderView(context, view);
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetIntAttribute(long j, int i) {
        if (j == -7485666501444237648L) {
            this.disableFlatten = i == 1;
        } else if (j == DXLAYOUT_MARKCONTAINER) {
            this.markContainer = i != 0;
        } else {
            super.onSetIntAttribute(j, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetListAttribute(long j, JSONArray jSONArray) {
        if (mz.DX_PARSER_LISTDATA == j) {
            this.listData = jSONArray;
            this.propertyInitFlag |= 2;
            return;
        }
        super.onSetListAttribute(j, jSONArray);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetUserDefinedListAttribute(long j, List<Object> list) {
        if (mz.DX_PARSER_LISTDATA == j) {
            if (list != null && !list.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                for (Object obj : list) {
                    jSONArray.add(obj);
                }
                onSetListAttribute(j, jSONArray);
            }
            this.propertyInitFlag |= 2;
            return;
        }
        super.onSetUserDefinedListAttribute(j, list);
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    void setAccessibility(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            int i = this.accessibility;
            if (i == -1) {
                return;
            }
            if (i == 3) {
                view.setImportantForAccessibility(1);
                view.setContentDescription(null);
                return;
            }
            String str = this.accessibilityText;
            if (str != null) {
                view.setContentDescription(str);
            }
            int i2 = this.accessibility;
            if (i2 == 1) {
                view.setImportantForAccessibility(1);
                view.setFocusable(true);
                return;
            } else if (i2 == 2) {
                view.setImportantForAccessibility(4);
                return;
            } else {
                view.setImportantForAccessibility(2);
                return;
            }
        }
        view.setContentDescription("");
    }

    public void setClipChildren(boolean z) {
        this.clipChildren = z;
    }

    public void setDisableFlatten(boolean z) {
        this.disableFlatten = z;
    }

    public void setListData(JSONArray jSONArray) {
        this.listData = jSONArray;
        this.propertyInitFlag |= 2;
    }

    public void setMarkContainer(boolean z) {
        this.markContainer = z;
    }

    public ViewGroup.LayoutParams generateLayoutParams(@NonNull lz lzVar, @NonNull ViewGroup.LayoutParams layoutParams) {
        layoutParams.width = lzVar.a;
        layoutParams.height = lzVar.b;
        return layoutParams;
    }
}
