package com.taobao.weex.ui.component.list.template;

import android.view.View;
import androidx.core.view.ViewCompat;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.dom.WXAttr;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.WXVContainer;
import com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.m80;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class TemplateDom {
    public static final String ATTACH_CELL_SLOT = "_attach_slot";
    public static final String ATTRS_KEY_REF = "ref";
    public static final String DETACH_CELL_SLOT = "_detach_slot";
    public static final String KEY_ATTRS = "attrs";
    public static final String KEY_RESET_ANIMATION = "resetAnimation";
    public static final String KEY_TYPE = "type";
    public static final String KEY_VIRTUAL_DOM_REF = "ref";
    public static final char SEPARATOR = '@';
    public static final String VIRTUAL_DOM_IDENTIFY = "[[VirtualElement]]";

    public static Map<String, Object> findAllComponentRefs(String str, int i, WXComponent wXComponent) {
        HashMap hashMap = new HashMap();
        findAllComponentRefs(str, i, wXComponent, hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("refs", hashMap);
        hashMap2.put("position", Integer.valueOf(i));
        hashMap2.put("listRef", str);
        return hashMap2;
    }

    private static WXComponent findChildByAttrsRef(WXComponent wXComponent, String str) {
        if (wXComponent.getAttrs() == null || !str.equals(wXComponent.getAttrs().get("ref"))) {
            if (wXComponent instanceof WXVContainer) {
                WXVContainer wXVContainer = (WXVContainer) wXComponent;
                for (int i = 0; i < wXVContainer.getChildCount(); i++) {
                    WXComponent findChildByAttrsRef = findChildByAttrsRef(wXVContainer.getChild(i), str);
                    if (findChildByAttrsRef != null) {
                        return findChildByAttrsRef;
                    }
                }
                return null;
            }
            return null;
        }
        return wXComponent;
    }

    public static final WXComponent findComponentByViewTreeKey(WXComponent wXComponent, String str) {
        if (wXComponent.getViewTreeKey().equals(str)) {
            return wXComponent;
        }
        if (wXComponent instanceof WXVContainer) {
            WXVContainer wXVContainer = (WXVContainer) wXComponent;
            for (int i = 0; i < wXVContainer.getChildCount(); i++) {
                WXComponent child = wXVContainer.getChild(i);
                if (findComponentByViewTreeKey(child, str) != null) {
                    return child;
                }
            }
            return null;
        }
        return null;
    }

    public static WXComponent findVirtualComponentByVRef(String str, String str2) {
        String[] split;
        WXComponent wXComponent;
        try {
            split = str2.split(m80.DINAMIC_PREFIX_AT);
            wXComponent = WXSDKManager.v().G().getWXComponent(str, split[0]);
        } catch (Exception unused) {
        }
        if (wXComponent instanceof WXRecyclerTemplateList) {
            WXRecyclerTemplateList wXRecyclerTemplateList = (WXRecyclerTemplateList) wXComponent;
            if (wXRecyclerTemplateList.getHostView() != 0 && ((BounceRecyclerView) wXRecyclerTemplateList.getHostView()).getInnerView() != null) {
                TemplateViewHolder templateViewHolder = (TemplateViewHolder) ((BounceRecyclerView) wXRecyclerTemplateList.getHostView()).getInnerView().findViewHolderForAdapterPosition(Integer.parseInt(split[1]));
                if (templateViewHolder == null) {
                    return null;
                }
                return findComponentByViewTreeKey(templateViewHolder.getTemplate(), split[2]);
            }
            return null;
        }
        return null;
    }

    public static String genKeyVirtualDomRef(String str, int i, String str2) {
        return str + '@' + i + '@' + str2;
    }

    public static boolean isVirtualDomRef(String str) {
        return str != null && str.indexOf(64) > 0;
    }

    public static void resetAnimaiton(View view) {
        if (view == null) {
            return;
        }
        if (ViewCompat.getTranslationX(view) != 0.0f) {
            ViewCompat.setTranslationX(view, 0.0f);
        }
        if (ViewCompat.getTranslationY(view) != 0.0f) {
            ViewCompat.setTranslationY(view, 0.0f);
        }
        if (ViewCompat.getTranslationZ(view) != 0.0f) {
            ViewCompat.setTranslationZ(view, 0.0f);
        }
        if (ViewCompat.getScaleX(view) != 1.0f) {
            ViewCompat.setScaleX(view, 1.0f);
        }
        if (ViewCompat.getScaleY(view) != 1.0f) {
            ViewCompat.setScaleY(view, 1.0f);
        }
        if (ViewCompat.getRotationX(view) != 0.0f) {
            ViewCompat.setRotationX(view, 0.0f);
        }
        if (ViewCompat.getRotationY(view) != 0.0f) {
            ViewCompat.setRotationY(view, 0.0f);
        }
        if (ViewCompat.getElevation(view) != 0.0f) {
            ViewCompat.setElevation(view, 0.0f);
        }
    }

    public static Map toMap(String str, int i, WXComponent wXComponent) {
        HashMap hashMap = new HashMap();
        hashMap.put(KEY_ATTRS, wXComponent.getAttrs());
        hashMap.put("type", wXComponent.getComponentType());
        hashMap.put("ref", genKeyVirtualDomRef(str, i, wXComponent.getViewTreeKey()));
        hashMap.put(VIRTUAL_DOM_IDENTIFY, Boolean.TRUE);
        return hashMap;
    }

    private static void findAllComponentRefs(String str, int i, WXComponent wXComponent, Map<String, Object> map) {
        if (wXComponent.isWaste()) {
            return;
        }
        if (wXComponent instanceof WXVContainer) {
            WXVContainer wXVContainer = (WXVContainer) wXComponent;
            for (int i2 = 0; i2 < wXVContainer.getChildCount(); i2++) {
                findAllComponentRefs(str, i, wXVContainer.getChild(i2), map);
            }
        }
        WXAttr attrs = wXComponent.getAttrs();
        if (attrs == null || attrs.get("ref") != null) {
            String obj = attrs.get("ref").toString();
            List list = (List) map.get(obj);
            if (list == null) {
                list = new ArrayList();
                map.put(obj, list);
            }
            list.add(toMap(str, i, wXComponent));
        }
    }
}
