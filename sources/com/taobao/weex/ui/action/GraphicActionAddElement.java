package com.taobao.weex.ui.action;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.common.WXErrorCode;
import com.taobao.weex.dom.transition.WXTransition;
import com.taobao.weex.performance.WXStateRecord;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.WXVContainer;
import com.taobao.weex.utils.WXExceptionUtils;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.WXUtils;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import tb.gz2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class GraphicActionAddElement extends GraphicActionAbstractAddElement {
    private WXComponent child;
    private boolean isLayoutRTL;
    private GraphicPosition layoutPosition;
    private GraphicSize layoutSize;
    private WXVContainer parent;

    public GraphicActionAddElement(@NonNull WXSDKInstance wXSDKInstance, String str, String str2, String str3, int i, Map<String, String> map, Map<String, String> map2, Set<String> set, float[] fArr, float[] fArr2, float[] fArr3) {
        super(wXSDKInstance, str);
        this.mComponentType = str2;
        this.mParentRef = str3;
        this.mIndex = i;
        this.mStyle = map;
        this.mAttributes = map2;
        this.mEvents = set;
        this.mPaddings = fArr2;
        this.mMargins = fArr;
        this.mBorders = fArr3;
        if (wXSDKInstance.getContext() == null) {
            return;
        }
        if (gz2.a()) {
            Log.d(gz2.INTERACTION_TAG, "[client][addelementStart]" + wXSDKInstance.getInstanceId() + "," + str2 + "," + str);
        }
        try {
            this.parent = (WXVContainer) WXSDKManager.v().G().getWXComponent(getPageId(), this.mParentRef);
            long fixUnixTime = WXUtils.getFixUnixTime();
            WXComponent createComponent = createComponent(wXSDKInstance, this.parent, new BasicComponentData(str, this.mComponentType, this.mParentRef));
            this.child = createComponent;
            createComponent.setTransition(WXTransition.fromMap(createComponent.getStyles(), this.child));
            wXSDKInstance.getApmForInstance().s += WXUtils.getFixUnixTime() - fixUnixTime;
            WXVContainer wXVContainer = this.parent;
            if (wXVContainer != null && wXVContainer.isIgnoreInteraction) {
                this.child.isIgnoreInteraction = true;
            }
            WXComponent wXComponent = this.child;
            if (!wXComponent.isIgnoreInteraction) {
                Object obj = wXComponent.getAttrs() != null ? this.child.getAttrs().get("ignoreInteraction") : null;
                if (!"false".equals(obj) && !"0".equals(obj)) {
                    if ("1".equals(obj) || "true".equals(obj) || this.child.isFixed()) {
                        this.child.isIgnoreInteraction = true;
                    }
                }
                this.child.isIgnoreInteraction = false;
            }
            WXStateRecord.d().i(wXSDKInstance.getInstanceId(), "addElement");
        } catch (ClassCastException unused) {
            ArrayMap arrayMap = new ArrayMap();
            WXComponent wXComponent2 = WXSDKManager.v().G().getWXComponent(getPageId(), this.mParentRef);
            Map<String, String> map3 = this.mStyle;
            if (map3 != null && !map3.isEmpty()) {
                arrayMap.put("child.style", this.mStyle.toString());
            }
            if (wXComponent2 != null && wXComponent2.getStyles() != null && !wXComponent2.getStyles().isEmpty()) {
                arrayMap.put("parent.style", wXComponent2.getStyles().toString());
            }
            Map<String, String> map4 = this.mAttributes;
            if (map4 != null && !map4.isEmpty()) {
                arrayMap.put("child.attr", this.mAttributes.toString());
            }
            if (wXComponent2 != null && wXComponent2.getAttrs() != null && !wXComponent2.getAttrs().isEmpty()) {
                arrayMap.put("parent.attr", wXComponent2.getAttrs().toString());
            }
            Set<String> set2 = this.mEvents;
            if (set2 != null && !set2.isEmpty()) {
                arrayMap.put("child.event", this.mEvents.toString());
            }
            if (wXComponent2 != null && wXComponent2.getEvents() != null && !wXComponent2.getEvents().isEmpty()) {
                arrayMap.put("parent.event", wXComponent2.getEvents().toString());
            }
            float[] fArr4 = this.mMargins;
            if (fArr4 != null && fArr4.length > 0) {
                arrayMap.put("child.margin", Arrays.toString(fArr4));
            }
            if (wXComponent2 != null && wXComponent2.getMargin() != null) {
                arrayMap.put("parent.margin", wXComponent2.getMargin().toString());
            }
            float[] fArr5 = this.mPaddings;
            if (fArr5 != null && fArr5.length > 0) {
                arrayMap.put("child.padding", Arrays.toString(fArr5));
            }
            if (wXComponent2 != null && wXComponent2.getPadding() != null) {
                arrayMap.put("parent.padding", wXComponent2.getPadding().toString());
            }
            float[] fArr6 = this.mBorders;
            if (fArr6 != null && fArr6.length > 0) {
                arrayMap.put("child.border", Arrays.toString(fArr6));
            }
            if (wXComponent2 != null && wXComponent2.getBorder() != null) {
                arrayMap.put("parent.border", wXComponent2.getBorder().toString());
            }
            WXExceptionUtils.commitCriticalExceptionRT(wXSDKInstance.getInstanceId(), WXErrorCode.WX_RENDER_ERR_CONTAINER_TYPE, "GraphicActionAddElement", String.format(Locale.ENGLISH, "You are trying to add a %s to a %2$s, which is illegal as %2$s is not a container", str2, WXSDKManager.v().G().getWXComponent(getPageId(), this.mParentRef).getComponentType()), arrayMap);
        }
    }

    @Override // com.taobao.weex.ui.action.GraphicActionAbstractAddElement, com.taobao.weex.ui.action.IExecutable
    public void executeAction() {
        GraphicSize graphicSize;
        super.executeAction();
        try {
            if (!TextUtils.equals(this.mComponentType, "video") && !TextUtils.equals(this.mComponentType, "videoplus")) {
                this.child.mIsAddElementToTree = true;
            }
            long fixUnixTime = WXUtils.getFixUnixTime();
            this.parent.addChild(this.child, this.mIndex);
            this.parent.createChildViewAt(this.mIndex);
            this.child.setIsLayoutRTL(this.isLayoutRTL);
            GraphicPosition graphicPosition = this.layoutPosition;
            if (graphicPosition != null && (graphicSize = this.layoutSize) != null) {
                this.child.setDemission(graphicSize, graphicPosition);
            }
            WXComponent wXComponent = this.child;
            wXComponent.applyLayoutAndEvent(wXComponent);
            WXComponent wXComponent2 = this.child;
            wXComponent2.bindData(wXComponent2);
            long fixUnixTime2 = WXUtils.getFixUnixTime() - fixUnixTime;
            if (getWXSDKIntance() != null) {
                getWXSDKIntance().getApmForInstance().u += fixUnixTime2;
            }
        } catch (Exception e) {
            WXLogUtils.e("add component failed.", e);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @WorkerThread
    public void setIndex(int i) {
        this.mIndex = i;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @WorkerThread
    public void setPosition(GraphicPosition graphicPosition) {
        this.layoutPosition = graphicPosition;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @WorkerThread
    public void setRTL(boolean z) {
        this.isLayoutRTL = z;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @WorkerThread
    public void setSize(GraphicSize graphicSize) {
        this.layoutSize = graphicSize;
    }
}
