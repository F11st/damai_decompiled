package com.taobao.weex.ui.flat;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import com.taobao.weex.common.Constants;
import com.taobao.weex.common.Destroyable;
import com.taobao.weex.dom.WXAttr;
import com.taobao.weex.dom.WXStyle;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.flat.widget.AndroidViewWidget;
import com.taobao.weex.ui.flat.widget.Widget;
import java.util.Map;

/* compiled from: Taobao */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes11.dex */
public class FlatGUIContext implements Destroyable {
    private Map<WXComponent, WidgetContainer> mWidgetRegistry = new ArrayMap();
    private Map<WXComponent, AndroidViewWidget> mViewWidgetRegistry = new ArrayMap();
    private Map<Widget, WXComponent> widgetToComponent = new ArrayMap();

    private boolean checkComponent(@NonNull WXComponent wXComponent) {
        if (wXComponent != null) {
            WXStyle styles = wXComponent.getStyles();
            WXAttr attrs = wXComponent.getAttrs();
            if (styles.containsKey("opacity") || styles.containsKey("transform") || styles.containsKey("visibility") || attrs.containsKey("elevation") || attrs.containsKey(Constants.Name.ARIA_HIDDEN) || attrs.containsKey(Constants.Name.ARIA_LABEL) || attrs.containsKey(WXComponent.PROP_FIXED_SIZE) || attrs.containsKey("disabled") || styles.isFixed() || styles.isSticky() || !styles.getPesudoStyles().isEmpty() || wXComponent.getEvents().size() > 0) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    private WXComponent getComponent(@NonNull Widget widget) {
        return this.widgetToComponent.get(widget);
    }

    @Override // com.taobao.weex.common.Destroyable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void destroy() {
        this.widgetToComponent.clear();
        for (Map.Entry<WXComponent, AndroidViewWidget> entry : this.mViewWidgetRegistry.entrySet()) {
            entry.getValue().destroy();
        }
        this.mViewWidgetRegistry.clear();
        for (Map.Entry<WXComponent, WidgetContainer> entry2 : this.mWidgetRegistry.entrySet()) {
            entry2.getValue().unmountFlatGUI();
        }
        this.mWidgetRegistry.clear();
    }

    @Nullable
    public AndroidViewWidget getAndroidViewWidget(@NonNull WXComponent wXComponent) {
        return this.mViewWidgetRegistry.get(wXComponent);
    }

    @Nullable
    public WidgetContainer getFlatComponentAncestor(@NonNull WXComponent wXComponent) {
        return this.mWidgetRegistry.get(wXComponent);
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [android.view.View] */
    @Nullable
    public View getWidgetContainerView(Widget widget) {
        WidgetContainer flatComponentAncestor;
        WXComponent component = getComponent(widget);
        if (component == null || (flatComponentAncestor = getFlatComponentAncestor(component)) == null) {
            return null;
        }
        return flatComponentAncestor.getHostView();
    }

    public boolean isFlatUIEnabled(WXComponent wXComponent) {
        return false;
    }

    public boolean promoteToView(@NonNull WXComponent wXComponent, boolean z, @NonNull Class<? extends WXComponent<?>> cls) {
        return !isFlatUIEnabled(wXComponent) || !cls.equals(wXComponent.getClass()) || TextUtils.equals(wXComponent.getRef(), WXComponent.ROOT) || (z && getFlatComponentAncestor(wXComponent) == null) || checkComponent(wXComponent);
    }

    public void register(@NonNull WXComponent wXComponent, @NonNull WidgetContainer widgetContainer) {
        if (!(widgetContainer instanceof FlatComponent) || ((FlatComponent) widgetContainer).promoteToView(true)) {
            this.mWidgetRegistry.put(wXComponent, widgetContainer);
        }
    }

    public void register(@NonNull WXComponent wXComponent, @NonNull AndroidViewWidget androidViewWidget) {
        this.mViewWidgetRegistry.put(wXComponent, androidViewWidget);
    }

    public void register(@NonNull Widget widget, @NonNull WXComponent wXComponent) {
        this.widgetToComponent.put(widget, wXComponent);
    }
}
