package com.taobao.weex.ui.action;

import androidx.collection.ArrayMap;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.bridge.WXBridgeManager;
import com.taobao.weex.common.Constants;
import com.taobao.weex.dom.CSSShorthand;
import com.taobao.weex.dom.transition.WXTransition;
import com.taobao.weex.ui.component.WXComponent;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class GraphicActionUpdateStyle extends BasicGraphicAction {
    private WXComponent component;
    private boolean mIsBorderSet;
    private boolean mIsCausedByPesudo;
    private Map<String, Object> mStyle;

    public GraphicActionUpdateStyle(WXSDKInstance wXSDKInstance, String str, Map<String, Object> map, Map<String, String> map2, Map<String, String> map3, Map<String, String> map4) {
        this(wXSDKInstance, str, map, map2, map3, map4, false);
    }

    @Override // com.taobao.weex.ui.action.IExecutable
    public void executeAction() {
        WXComponent wXComponent = this.component;
        if (wXComponent == null) {
            return;
        }
        if (this.mStyle != null) {
            if (wXComponent.getTransition() != null) {
                this.component.getTransition().updateTranstionParams(this.mStyle);
                if (this.component.getTransition().hasTransitionProperty(this.mStyle)) {
                    this.component.getTransition().startTransition(this.mStyle);
                    return;
                }
                return;
            }
            WXComponent wXComponent2 = this.component;
            wXComponent2.setTransition(WXTransition.fromMap(this.mStyle, wXComponent2));
            this.component.updateStyles(this.mStyle);
        } else if (this.mIsBorderSet) {
            wXComponent.updateStyles(wXComponent);
        }
    }

    public GraphicActionUpdateStyle(WXSDKInstance wXSDKInstance, String str, Map<String, Object> map, CSSShorthand cSSShorthand, CSSShorthand cSSShorthand2, CSSShorthand cSSShorthand3, boolean z) {
        super(wXSDKInstance, str);
        this.mStyle = map;
        this.mIsCausedByPesudo = z;
        WXComponent wXComponent = WXSDKManager.v().G().getWXComponent(getPageId(), getRef());
        this.component = wXComponent;
        if (wXComponent == null) {
            return;
        }
        Map<String, Object> map2 = this.mStyle;
        if (map2 != null) {
            wXComponent.updateStyle(map2, this.mIsCausedByPesudo);
            if (map.containsKey("transform") && this.component.getTransition() == null) {
                ArrayMap arrayMap = new ArrayMap(2);
                arrayMap.put("transform", map.get("transform"));
                arrayMap.put(Constants.Name.TRANSFORM_ORIGIN, map.get(Constants.Name.TRANSFORM_ORIGIN));
                this.component.addAnimationForElement(arrayMap);
            }
        }
        if (cSSShorthand != null) {
            this.component.setPaddings(cSSShorthand);
        }
        if (cSSShorthand2 != null) {
            this.component.setMargins(cSSShorthand2);
        }
        if (cSSShorthand3 != null) {
            this.mIsBorderSet = true;
            this.component.setBorders(cSSShorthand3);
        }
    }

    public GraphicActionUpdateStyle(WXSDKInstance wXSDKInstance, String str, Map<String, Object> map, Map<String, String> map2, Map<String, String> map3, Map<String, String> map4, boolean z) {
        super(wXSDKInstance, str);
        this.mStyle = map;
        this.mIsCausedByPesudo = z;
        WXComponent wXComponent = WXSDKManager.v().G().getWXComponent(getPageId(), getRef());
        this.component = wXComponent;
        if (wXComponent == null) {
            return;
        }
        Map<String, Object> map5 = this.mStyle;
        if (map5 != null) {
            wXComponent.addStyle(map5, this.mIsCausedByPesudo);
            if (map.containsKey("transform") && this.component.getTransition() == null) {
                ArrayMap arrayMap = new ArrayMap(2);
                arrayMap.put("transform", map.get("transform"));
                arrayMap.put(Constants.Name.TRANSFORM_ORIGIN, map.get(Constants.Name.TRANSFORM_ORIGIN));
                this.component.addAnimationForElement(arrayMap);
                WXBridgeManager.getInstance().markDirty(this.component.getInstanceId(), this.component.getRef(), true);
            }
        }
        if (map2 != null) {
            this.component.addShorthand(map2);
        }
        if (map3 != null) {
            this.component.addShorthand(map3);
        }
        if (map4 != null) {
            this.mIsBorderSet = true;
            this.component.addShorthand(map4);
        }
    }
}
