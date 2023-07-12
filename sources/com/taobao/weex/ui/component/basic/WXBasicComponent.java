package com.taobao.weex.ui.component.basic;

import android.view.View;
import androidx.annotation.NonNull;
import com.taobao.uikit.feature.features.FeatureFactory;
import com.taobao.weex.dom.CSSShorthand;
import com.taobao.weex.dom.WXAttr;
import com.taobao.weex.dom.WXEvent;
import com.taobao.weex.dom.WXStyle;
import com.taobao.weex.ui.action.BasicComponentData;
import com.taobao.weex.ui.action.GraphicPosition;
import com.taobao.weex.ui.action.GraphicSize;
import com.taobao.weex.ui.component.WXComponent;
import java.util.Map;
import java.util.Set;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class WXBasicComponent<T extends View> {
    private BasicComponentData mBasicComponentData;
    private String mComponentType;
    private Object mExtra;
    private boolean mIsLayoutRTL;
    private GraphicPosition mLayoutPosition;
    private GraphicSize mLayoutSize;
    private String mRef;
    private int mViewPortWidth = FeatureFactory.PRIORITY_ABOVE_NORMAL;

    public WXBasicComponent(BasicComponentData basicComponentData) {
        this.mBasicComponentData = basicComponentData;
        this.mRef = basicComponentData.mRef;
        this.mComponentType = basicComponentData.mComponentType;
    }

    public final void addAttr(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        this.mBasicComponentData.addAttr(map);
    }

    public final void addEvent(Set<String> set) {
        if (set == null || set.isEmpty()) {
            return;
        }
        this.mBasicComponentData.addEvent(set);
    }

    public final void addShorthand(Map<String, String> map) {
        BasicComponentData basicComponentData;
        if (map.isEmpty() || (basicComponentData = this.mBasicComponentData) == null) {
            return;
        }
        basicComponentData.addShorthand(map);
    }

    public final void addStyle(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        this.mBasicComponentData.addStyle(map);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bindComponent(WXComponent wXComponent) {
        this.mComponentType = wXComponent.getComponentType();
        this.mRef = wXComponent.getRef();
    }

    @NonNull
    public final WXAttr getAttrs() {
        return this.mBasicComponentData.getAttrs();
    }

    public BasicComponentData getBasicComponentData() {
        return this.mBasicComponentData;
    }

    @NonNull
    public CSSShorthand getBorder() {
        return this.mBasicComponentData.getBorder();
    }

    public float getCSSLayoutBottom() {
        GraphicPosition graphicPosition = this.mLayoutPosition;
        if (graphicPosition == null) {
            return 0.0f;
        }
        return graphicPosition.getBottom();
    }

    public float getCSSLayoutLeft() {
        GraphicPosition graphicPosition = this.mLayoutPosition;
        if (graphicPosition == null) {
            return 0.0f;
        }
        return graphicPosition.getLeft();
    }

    public float getCSSLayoutRight() {
        GraphicPosition graphicPosition = this.mLayoutPosition;
        if (graphicPosition == null) {
            return 0.0f;
        }
        return graphicPosition.getRight();
    }

    public float getCSSLayoutTop() {
        GraphicPosition graphicPosition = this.mLayoutPosition;
        if (graphicPosition == null) {
            return 0.0f;
        }
        return graphicPosition.getTop();
    }

    public String getComponentType() {
        return this.mComponentType;
    }

    @NonNull
    public final WXEvent getEvents() {
        return this.mBasicComponentData.getEvents();
    }

    public Object getExtra() {
        return this.mExtra;
    }

    public float getLayoutHeight() {
        GraphicSize graphicSize = this.mLayoutSize;
        if (graphicSize == null) {
            return 0.0f;
        }
        return graphicSize.getHeight();
    }

    public GraphicPosition getLayoutPosition() {
        if (this.mLayoutPosition == null) {
            this.mLayoutPosition = new GraphicPosition(0.0f, 0.0f, 0.0f, 0.0f);
        }
        return this.mLayoutPosition;
    }

    public GraphicSize getLayoutSize() {
        if (this.mLayoutSize == null) {
            this.mLayoutSize = new GraphicSize(0.0f, 0.0f);
        }
        return this.mLayoutSize;
    }

    public float getLayoutWidth() {
        GraphicSize graphicSize = this.mLayoutSize;
        if (graphicSize == null) {
            return 0.0f;
        }
        return graphicSize.getWidth();
    }

    @NonNull
    public final CSSShorthand getMargin() {
        return this.mBasicComponentData.getMargin();
    }

    @NonNull
    public final CSSShorthand getPadding() {
        return this.mBasicComponentData.getPadding();
    }

    public String getRef() {
        return this.mRef;
    }

    @NonNull
    public final WXStyle getStyles() {
        return this.mBasicComponentData.getStyles();
    }

    public int getViewPortWidth() {
        return this.mViewPortWidth;
    }

    public boolean isLayoutRTL() {
        return this.mIsLayoutRTL;
    }

    public final void setBorders(@NonNull CSSShorthand cSSShorthand) {
        this.mBasicComponentData.setBorders(cSSShorthand);
    }

    public void setIsLayoutRTL(boolean z) {
        this.mIsLayoutRTL = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setLayoutPosition(GraphicPosition graphicPosition) {
        this.mLayoutPosition = graphicPosition;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setLayoutSize(GraphicSize graphicSize) {
        this.mLayoutSize = graphicSize;
    }

    public final void setMargins(@NonNull CSSShorthand cSSShorthand) {
        this.mBasicComponentData.setMargins(cSSShorthand);
    }

    public final void setPaddings(@NonNull CSSShorthand cSSShorthand) {
        this.mBasicComponentData.setPaddings(cSSShorthand);
    }

    public void setViewPortWidth(int i) {
        this.mViewPortWidth = i;
    }

    public void updateExtra(Object obj) {
        this.mExtra = obj;
    }

    public final void updateStyle(Map<String, Object> map, boolean z) {
        if (map == null || map.isEmpty()) {
            return;
        }
        this.mBasicComponentData.getStyles().updateStyle(map, z);
    }

    public final void addStyle(Map<String, Object> map, boolean z) {
        if (map == null || map.isEmpty()) {
            return;
        }
        this.mBasicComponentData.addStyle(map, z);
    }
}
