package com.taobao.weex.ui.component.binding;

import android.os.Looper;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.bridge.EventResult;
import com.taobao.weex.bridge.WXBridgeManager;
import com.taobao.weex.dom.WXAttr;
import com.taobao.weex.dom.WXEvent;
import com.taobao.weex.dom.WXStyle;
import com.taobao.weex.dom.binding.ELUtils;
import com.taobao.weex.dom.binding.JSONUtils;
import com.taobao.weex.dom.binding.WXStatement;
import com.taobao.weex.ui.action.BasicComponentData;
import com.taobao.weex.ui.action.GraphicPosition;
import com.taobao.weex.ui.action.GraphicSize;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.WXComponentFactory;
import com.taobao.weex.ui.component.WXImage;
import com.taobao.weex.ui.component.WXVContainer;
import com.taobao.weex.ui.component.list.WXCell;
import com.taobao.weex.ui.component.list.template.CellDataManager;
import com.taobao.weex.ui.component.list.template.CellRenderContext;
import com.taobao.weex.ui.component.list.template.TemplateDom;
import com.taobao.weex.ui.component.list.template.VirtualComponentLifecycle;
import com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList;
import com.taobao.weex.ui.component.list.template.jni.NativeRenderObjectUtils;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.WXUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import tb.jn1;
import tb.x7;
import tb.zo2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class Statements {
    private static final ThreadLocal<Map<String, Object>> dynamicLocal = new ThreadLocal<>();

    public static WXComponent copyComponentTree(WXComponent wXComponent) {
        return copyComponentTree(wXComponent, wXComponent.getParent());
    }

    private static void doBindingAttrsEventAndRenderChildNode(WXComponent wXComponent, CellRenderContext cellRenderContext, List<WXComponent> list) {
        boolean z;
        String str;
        Map<String, Object> map;
        Map<String, Object> map2;
        Map<String, Object> map3;
        WXAttr attrs = wXComponent.getAttrs();
        x7 x7Var = cellRenderContext.stack;
        if (attrs.get(ELUtils.IS_COMPONENT_ROOT) == null || !WXUtils.getBoolean(attrs.get(ELUtils.IS_COMPONENT_ROOT), Boolean.FALSE).booleanValue() || attrs.get(ELUtils.COMPONENT_PROPS) == null || !JSONUtils.isJSON(attrs.get(ELUtils.COMPONENT_PROPS))) {
            z = false;
            str = null;
        } else {
            String str2 = (String) attrs.get(CellDataManager.SUB_COMPONENT_TEMPLATE_ID);
            if (!TextUtils.isEmpty(str2)) {
                String str3 = cellRenderContext.getRenderState().getVirtualComponentIds().get(wXComponent.getViewTreeKey());
                if (str3 == null) {
                    str3 = CellDataManager.createVirtualComponentId(cellRenderContext.templateList.getRef(), wXComponent.getViewTreeKey(), cellRenderContext.templateList.getItemId(cellRenderContext.position));
                    Map<String, Object> renderProps = renderProps(JSONUtils.toJSON(attrs.get(ELUtils.COMPONENT_PROPS)), cellRenderContext.stack);
                    EventResult syncCallJSEventWithResult = WXBridgeManager.getInstance().syncCallJSEventWithResult(WXBridgeManager.METHD_COMPONENT_HOOK_SYNC, wXComponent.getInstanceId(), null, str2, "lifecycle", "create", new Object[]{str3, renderProps}, null);
                    if (syncCallJSEventWithResult != null && syncCallJSEventWithResult.getResult() != null && (syncCallJSEventWithResult.getResult() instanceof Map)) {
                        renderProps.putAll((Map) syncCallJSEventWithResult.getResult());
                    }
                    cellRenderContext.getRenderState().getVirtualComponentIds().put(wXComponent.getViewTreeKey(), str3);
                    cellRenderContext.templateList.getCellDataManager().createVirtualComponentData(cellRenderContext.position, str3, renderProps);
                    z = true;
                    map3 = renderProps;
                } else {
                    Object obj = cellRenderContext.getRenderState().getVirtualComponentDatas().get(str3);
                    if (cellRenderContext.getRenderState().isHasDataUpdate()) {
                        Map<String, Object> renderProps2 = renderProps((JSONObject) attrs.get(ELUtils.COMPONENT_PROPS), cellRenderContext.stack);
                        EventResult syncCallJSEventWithResult2 = WXBridgeManager.getInstance().syncCallJSEventWithResult(WXBridgeManager.METHD_COMPONENT_HOOK_SYNC, wXComponent.getInstanceId(), null, str3, "lifecycle", VirtualComponentLifecycle.SYNSTATE, new Object[]{str3, renderProps2}, null);
                        if (syncCallJSEventWithResult2 != null && syncCallJSEventWithResult2.getResult() != null && (syncCallJSEventWithResult2.getResult() instanceof Map)) {
                            renderProps2.putAll((Map) syncCallJSEventWithResult2.getResult());
                            cellRenderContext.templateList.getCellDataManager().updateVirtualComponentData(str3, renderProps2);
                            map2 = renderProps2;
                            z = false;
                            map3 = map2;
                        }
                    }
                    map2 = obj;
                    z = false;
                    map3 = map2;
                }
                wXComponent.getAttrs().put(CellDataManager.VIRTUAL_COMPONENT_ID, (Object) str3);
                str = str3;
                map = map3;
            } else {
                z = false;
                str = null;
                map = renderProps((JSONObject) attrs.get(ELUtils.COMPONENT_PROPS), cellRenderContext.stack);
            }
            x7 x7Var2 = new x7();
            cellRenderContext.stack = x7Var2;
            if (map != null) {
                x7Var2.g(map);
            }
        }
        if ((attrs.getStatement() != null ? attrs.getStatement().get(WXStatement.WX_ONCE) : null) != null) {
            x7 x7Var3 = cellRenderContext.getRenderState().getOnceComponentStates().get(wXComponent.getViewTreeKey());
            if (x7Var3 == null) {
                x7Var3 = cellRenderContext.templateList.copyStack(cellRenderContext, x7Var);
                cellRenderContext.getRenderState().getOnceComponentStates().put(wXComponent.getViewTreeKey(), x7Var3);
            }
            cellRenderContext.stack = x7Var3;
        }
        doRenderBindingAttrsAndEvent(wXComponent, cellRenderContext);
        if (wXComponent instanceof WXVContainer) {
            if (wXComponent.isWaste() && !(wXComponent instanceof WXCell)) {
                return;
            }
            WXVContainer wXVContainer = (WXVContainer) wXComponent;
            int i = 0;
            while (i < wXVContainer.getChildCount()) {
                i += doRenderComponent(wXVContainer.getChild(i), cellRenderContext, list);
            }
        }
        if (x7Var != cellRenderContext.stack) {
            cellRenderContext.stack = x7Var;
        }
        if (!z || str == null) {
            return;
        }
        WXBridgeManager.getInstance().asyncCallJSEventVoidResult(WXBridgeManager.METHD_COMPONENT_HOOK_SYNC, wXComponent.getInstanceId(), null, str, "lifecycle", "attach", new Object[]{TemplateDom.findAllComponentRefs(cellRenderContext.templateList.getRef(), cellRenderContext.position, wXComponent)});
    }

    public static final void doInitCompontent(List<WXComponent> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        for (WXComponent wXComponent : list) {
            if (wXComponent.getParent() != null) {
                WXVContainer parent = wXComponent.getParent();
                int indexOf = parent.indexOf(wXComponent);
                if (indexOf >= 0) {
                    parent.createChildViewAt(indexOf);
                    wXComponent.applyLayoutAndEvent(wXComponent);
                    wXComponent.bindData(wXComponent);
                } else {
                    throw new IllegalArgumentException("render node cann't find");
                }
            } else {
                throw new IllegalArgumentException("render node parent cann't find");
            }
        }
    }

    public static final List<WXComponent> doRender(WXComponent wXComponent, CellRenderContext cellRenderContext) {
        ArrayList arrayList = new ArrayList(4);
        try {
            doRenderComponent(wXComponent, cellRenderContext, arrayList);
        } catch (Exception e) {
            WXLogUtils.e("WeexStatementRender", e);
        }
        return arrayList;
    }

    private static void doRenderBindingAttrsAndEvent(WXComponent wXComponent, CellRenderContext cellRenderContext) {
        x7 x7Var = cellRenderContext.stack;
        wXComponent.setWaste(false);
        WXAttr attrs = wXComponent.getAttrs();
        if (attrs != null && attrs.getBindingAttrs() != null && attrs.getBindingAttrs().size() > 0) {
            Map<String, Object> renderBindingAttrs = renderBindingAttrs(wXComponent.getAttrs().getBindingAttrs(), x7Var);
            Iterator<Map.Entry<String, Object>> it = renderBindingAttrs.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, Object> next = it.next();
                Object value = next.getValue();
                Object obj = attrs.get(next.getKey());
                if (value == null) {
                    if (obj == null) {
                        it.remove();
                    }
                } else if (value.equals(obj)) {
                    it.remove();
                }
            }
            if (renderBindingAttrs.size() > 0) {
                if (renderBindingAttrs.size() == 1 && renderBindingAttrs.get("src") != null && (wXComponent instanceof WXImage)) {
                    wXComponent.getAttrs().put("src", renderBindingAttrs.get("src"));
                } else {
                    wXComponent.nativeUpdateAttrs(renderBindingAttrs);
                }
                if (isMainThread()) {
                    wXComponent.updateProperties(renderBindingAttrs);
                }
                renderBindingAttrs.clear();
            }
        }
        WXStyle styles = wXComponent.getStyles();
        if (styles != null && styles.getBindingStyle() != null) {
            Map<String, Object> renderBindingAttrs2 = renderBindingAttrs(styles.getBindingStyle(), x7Var);
            Iterator<Map.Entry<String, Object>> it2 = renderBindingAttrs2.entrySet().iterator();
            while (it2.hasNext()) {
                Map.Entry<String, Object> next2 = it2.next();
                Object value2 = next2.getValue();
                Object obj2 = styles.get(next2.getKey());
                if (value2 == null) {
                    if (obj2 == null) {
                        it2.remove();
                    }
                } else if (value2.equals(obj2)) {
                    it2.remove();
                }
            }
            if (renderBindingAttrs2.size() > 0) {
                wXComponent.updateNativeStyles(renderBindingAttrs2);
                if (isMainThread()) {
                    wXComponent.updateProperties(renderBindingAttrs2);
                }
            }
        }
        WXEvent events = wXComponent.getEvents();
        if (events == null || events.getEventBindingArgs() == null) {
            return;
        }
        for (Map.Entry entry : events.getEventBindingArgs().entrySet()) {
            List<Object> bindingEventArgs = getBindingEventArgs(x7Var, entry.getValue());
            if (bindingEventArgs != null) {
                events.putEventBindingArgsValue((String) entry.getKey(), bindingEventArgs);
            }
        }
    }

    private static final int doRenderComponent(WXComponent wXComponent, CellRenderContext cellRenderContext, List<WXComponent> list) {
        int i;
        Collection keySet;
        Map map;
        Object obj;
        boolean z;
        WXComponent wXComponent2;
        Map map2;
        String str;
        Iterator it;
        String str2;
        WXVContainer parent = wXComponent.getParent();
        WXStatement statement = wXComponent.getAttrs().getStatement();
        if (statement != null) {
            zo2 zo2Var = statement.get(WXStatement.WX_IF) instanceof zo2 ? (zo2) statement.get(WXStatement.WX_IF) : null;
            String str3 = WXStatement.WX_FOR;
            JSONObject jSONObject = statement.get(WXStatement.WX_FOR) instanceof JSONObject ? (JSONObject) statement.get(WXStatement.WX_FOR) : null;
            if (jSONObject != null) {
                int indexOf = parent.indexOf(wXComponent);
                if (jSONObject.get(WXStatement.WX_FOR_LIST) instanceof zo2) {
                    zo2 zo2Var2 = (zo2) jSONObject.get(WXStatement.WX_FOR_LIST);
                    String string = jSONObject.getString(WXStatement.WX_FOR_INDEX);
                    String string2 = jSONObject.getString(WXStatement.WX_FOR_ITEM);
                    Object a = zo2Var2 != null ? zo2Var2.a(cellRenderContext.stack) : null;
                    boolean z2 = a instanceof List;
                    if (z2 || (a instanceof Map)) {
                        if (z2) {
                            keySet = (List) a;
                            map = null;
                        } else {
                            Map map3 = (Map) a;
                            keySet = map3.keySet();
                            map = map3;
                        }
                        HashMap hashMap = new HashMap();
                        Iterator it2 = keySet.iterator();
                        int i2 = 0;
                        while (it2.hasNext()) {
                            Object next = it2.next();
                            if (map == null) {
                                Integer valueOf = Integer.valueOf(i2);
                                i2++;
                                obj = next;
                                next = valueOf;
                            } else {
                                obj = map.get(next);
                            }
                            int i3 = i2;
                            if (string != null) {
                                hashMap.put(string, next);
                            }
                            if (string2 != null) {
                                hashMap.put(string2, obj);
                            } else {
                                cellRenderContext.stack.g(obj);
                            }
                            if (hashMap.size() > 0) {
                                cellRenderContext.stack.g(hashMap);
                            }
                            if (zo2Var == null || jn1.k(zo2Var.a(cellRenderContext.stack))) {
                                if (indexOf < parent.getChildCount()) {
                                    wXComponent2 = parent.getChild(indexOf);
                                    if (!isCreateFromNodeStatement(wXComponent2, wXComponent)) {
                                        wXComponent2 = null;
                                    }
                                    if (wXComponent2 == null || !wXComponent2.isWaste()) {
                                        z = false;
                                    } else {
                                        z = false;
                                        wXComponent2.setWaste(false);
                                    }
                                } else {
                                    z = false;
                                    wXComponent2 = null;
                                }
                                if (wXComponent2 == null) {
                                    long currentTimeMillis = System.currentTimeMillis();
                                    wXComponent2 = copyComponentTree(wXComponent, parent);
                                    wXComponent2.setWaste(z);
                                    if (wXComponent2.getAttrs().getStatement() != null) {
                                        wXComponent2.getAttrs().getStatement().remove(str3);
                                        wXComponent2.getAttrs().getStatement().remove(WXStatement.WX_IF);
                                    }
                                    parent.addChild(wXComponent2, indexOf);
                                    map2 = map;
                                    str = str3;
                                    it = it2;
                                    str2 = string;
                                    NativeRenderObjectUtils.nativeAddChildRenderObject(parent.getRenderObjectPtr(), wXComponent2.getRenderObjectPtr());
                                    list.add(wXComponent2);
                                    if (WXEnvironment.isApkDebugable()) {
                                        WXLogUtils.d(WXRecyclerTemplateList.TAG, Thread.currentThread().getName() + wXComponent2.getRef() + wXComponent2.getComponentType() + "statements copy component tree used " + (System.currentTimeMillis() - currentTimeMillis));
                                    }
                                } else {
                                    map2 = map;
                                    str = str3;
                                    it = it2;
                                    str2 = string;
                                }
                                doBindingAttrsEventAndRenderChildNode(wXComponent2, cellRenderContext, list);
                                indexOf++;
                                if (hashMap.size() > 0) {
                                    cellRenderContext.stack.g(hashMap);
                                }
                                if (string2 == null) {
                                    cellRenderContext.stack.f();
                                }
                                str3 = str;
                                i2 = i3;
                                map = map2;
                                string = str2;
                                it2 = it;
                            } else {
                                i2 = i3;
                            }
                        }
                    }
                } else {
                    WXLogUtils.e(WXRecyclerTemplateList.TAG, jSONObject.toJSONString() + " not call vfor block, for pre compile");
                }
                while (indexOf < parent.getChildCount()) {
                    WXComponent child = parent.getChild(indexOf);
                    if (!isCreateFromNodeStatement(child, wXComponent)) {
                        break;
                    }
                    child.setWaste(true);
                    indexOf++;
                }
                return indexOf - parent.indexOf(wXComponent);
            } else if (zo2Var != null) {
                if (!jn1.k(zo2Var.a(cellRenderContext.stack))) {
                    wXComponent.setWaste(true);
                    return 1;
                }
                i = 1;
                wXComponent.setWaste(false);
                doBindingAttrsEventAndRenderChildNode(wXComponent, cellRenderContext, list);
                return i;
            }
        }
        i = 1;
        doBindingAttrsEventAndRenderChildNode(wXComponent, cellRenderContext, list);
        return i;
    }

    public static List<Object> getBindingEventArgs(x7 x7Var, Object obj) {
        ArrayList arrayList = new ArrayList(4);
        if (obj instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj;
            for (int i = 0; i < jSONArray.size(); i++) {
                Object obj2 = jSONArray.get(i);
                if (obj2 instanceof JSONObject) {
                    JSONObject jSONObject = (JSONObject) obj2;
                    if (jSONObject.get(ELUtils.BINDING) instanceof zo2) {
                        arrayList.add(((zo2) jSONObject.get(ELUtils.BINDING)).a(x7Var));
                    }
                }
                arrayList.add(obj2);
            }
        } else if (obj instanceof JSONObject) {
            JSONObject jSONObject2 = (JSONObject) obj;
            if (jSONObject2.get(ELUtils.BINDING) instanceof zo2) {
                arrayList.add(((zo2) jSONObject2.get(ELUtils.BINDING)).a(x7Var));
            } else {
                arrayList.add(obj.toString());
            }
        } else {
            arrayList.add(obj.toString());
        }
        return arrayList;
    }

    public static String getComponentId(WXComponent wXComponent) {
        if ((wXComponent instanceof WXCell) || wXComponent == null) {
            return null;
        }
        WXAttr attrs = wXComponent.getAttrs();
        if (attrs.get(ELUtils.IS_COMPONENT_ROOT) != null && WXUtils.getBoolean(attrs.get(ELUtils.IS_COMPONENT_ROOT), Boolean.FALSE).booleanValue() && attrs.get(ELUtils.COMPONENT_PROPS) != null && (attrs.get(ELUtils.COMPONENT_PROPS) instanceof JSONObject)) {
            Object obj = attrs.get(CellDataManager.VIRTUAL_COMPONENT_ID);
            if (obj == null) {
                return null;
            }
            return obj.toString();
        }
        return getComponentId(wXComponent.getParent());
    }

    public static void initLazyComponent(WXComponent wXComponent, WXVContainer wXVContainer) {
        if (wXComponent.isLazy() || wXComponent.getHostView() == null) {
            wXComponent.lazy(false);
            if (wXVContainer != null) {
                wXVContainer.createChildViewAt(wXVContainer.indexOf(wXComponent));
            } else {
                wXComponent.createView();
            }
            wXComponent.applyLayoutAndEvent(wXComponent);
            wXComponent.bindData(wXComponent);
        }
    }

    private static boolean isCreateFromNodeStatement(WXComponent wXComponent, WXComponent wXComponent2) {
        return wXComponent.getRef() != null && wXComponent.getRef().equals(wXComponent2.getRef());
    }

    private static boolean isMainThread() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    public static void parseStatementsToken(WXComponent wXComponent) {
        if (wXComponent.getBasicComponentData().isRenderPtrEmpty()) {
            wXComponent.getBasicComponentData().setRenderObjectPr(wXComponent.getRenderObjectPtr());
        }
        if (wXComponent.getBasicComponentData() != null) {
            BasicComponentData basicComponentData = wXComponent.getBasicComponentData();
            basicComponentData.getAttrs().parseStatements();
            basicComponentData.getStyles().parseStatements();
            basicComponentData.getEvents().parseStatements();
        }
        if (wXComponent instanceof WXVContainer) {
            WXVContainer wXVContainer = (WXVContainer) wXComponent;
            int childCount = wXVContainer.getChildCount();
            for (int i = 0; i < childCount; i++) {
                parseStatementsToken(wXVContainer.getChild(i));
            }
        }
    }

    public static Map<String, Object> renderBindingAttrs(ArrayMap arrayMap, x7 x7Var) {
        Set<Map.Entry> entrySet = arrayMap.entrySet();
        ThreadLocal<Map<String, Object>> threadLocal = dynamicLocal;
        Map<String, Object> map = threadLocal.get();
        if (map == null) {
            map = new HashMap<>();
            threadLocal.set(map);
        }
        if (map.size() > 0) {
            map.clear();
        }
        for (Map.Entry entry : entrySet) {
            Object value = entry.getValue();
            String str = (String) entry.getKey();
            if (value instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) value;
                if (jSONObject.get(ELUtils.BINDING) instanceof zo2) {
                    map.put(str, ((zo2) jSONObject.get(ELUtils.BINDING)).a(x7Var));
                }
            }
            if (value instanceof JSONArray) {
                JSONArray jSONArray = (JSONArray) value;
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < jSONArray.size(); i++) {
                    Object obj = jSONArray.get(i);
                    if (obj instanceof CharSequence) {
                        sb.append(obj);
                    } else if (obj instanceof JSONObject) {
                        JSONObject jSONObject2 = (JSONObject) obj;
                        if (jSONObject2.get(ELUtils.BINDING) instanceof zo2) {
                            Object a = ((zo2) jSONObject2.get(ELUtils.BINDING)).a(x7Var);
                            if (a == null) {
                                a = "";
                            }
                            sb.append(a);
                        }
                    }
                }
                String sb2 = sb.toString();
                if (sb2.length() > 256 && WXEnvironment.isApkDebugable()) {
                    WXLogUtils.w(WXRecyclerTemplateList.TAG, " warn too big string " + sb2);
                }
                map.put(str, sb2);
            }
        }
        return map;
    }

    public static Map<String, Object> renderProps(JSONObject jSONObject, x7 x7Var) {
        Set<Map.Entry<String, Object>> entrySet = jSONObject.entrySet();
        ArrayMap arrayMap = new ArrayMap(4);
        for (Map.Entry<String, Object> entry : entrySet) {
            Object value = entry.getValue();
            String key = entry.getKey();
            if (value instanceof JSONObject) {
                JSONObject jSONObject2 = (JSONObject) value;
                if (jSONObject2.get(ELUtils.BINDING) instanceof zo2) {
                    arrayMap.put(key, ((zo2) jSONObject2.get(ELUtils.BINDING)).a(x7Var));
                }
            }
            arrayMap.put(key, value);
        }
        return arrayMap;
    }

    private static final WXComponent copyComponentTree(WXComponent wXComponent, WXVContainer wXVContainer) {
        BasicComponentData basicComponentData;
        try {
            basicComponentData = wXComponent.getBasicComponentData().m581clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            basicComponentData = null;
        }
        WXComponent newInstance = WXComponentFactory.newInstance(wXComponent.getInstance(), wXVContainer, basicComponentData);
        GraphicPosition layoutPosition = wXComponent.getLayoutPosition();
        GraphicSize layoutSize = wXComponent.getLayoutSize();
        newInstance.updateDemission(layoutPosition.getTop(), layoutPosition.getBottom(), layoutPosition.getLeft(), layoutPosition.getRight(), layoutSize.getHeight(), layoutSize.getWidth());
        newInstance.updateExtra(wXComponent.getExtra());
        if (wXComponent instanceof WXVContainer) {
            WXVContainer wXVContainer2 = (WXVContainer) wXComponent;
            WXVContainer wXVContainer3 = (WXVContainer) newInstance;
            int childCount = wXVContainer2.getChildCount();
            for (int i = 0; i < childCount; i++) {
                WXComponent child = wXVContainer2.getChild(i);
                if (child != null) {
                    WXComponent copyComponentTree = copyComponentTree(child, wXVContainer3);
                    wXVContainer3.addChild(copyComponentTree);
                    NativeRenderObjectUtils.nativeAddChildRenderObject(wXVContainer3.getRenderObjectPtr(), copyComponentTree.getRenderObjectPtr());
                }
            }
        }
        if (wXComponent.isWaste()) {
            newInstance.setWaste(true);
        }
        return newInstance;
    }
}
