package com.taobao.weex.ui.flat;

import android.util.Pair;
import android.view.ViewGroup;
import androidx.annotation.RestrictTo;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.ui.action.BasicComponentData;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.WXVContainer;
import com.taobao.weex.ui.flat.widget.AndroidViewWidget;
import com.taobao.weex.ui.flat.widget.Widget;
import java.util.LinkedList;
import java.util.List;

/* compiled from: Taobao */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes11.dex */
public abstract class WidgetContainer<T extends ViewGroup> extends WXVContainer<T> {
    protected List<Widget> widgets;

    public WidgetContainer(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
    }

    private void addFlatChild(Widget widget, int i) {
        if (this.widgets == null) {
            this.widgets = new LinkedList();
        }
        if (i >= this.widgets.size()) {
            this.widgets.add(widget);
        } else {
            this.widgets.add(i, widget);
        }
        mountFlatGUI();
    }

    @Override // com.taobao.weex.ui.component.WXVContainer
    public void createChildViewAt(int i) {
        Widget widget;
        if (intendToBeFlatContainer()) {
            Pair<WXComponent, Integer> rearrangeIndexAndGetChild = rearrangeIndexAndGetChild(i);
            Object obj = rearrangeIndexAndGetChild.first;
            if (obj != null) {
                WXComponent wXComponent = (WXComponent) obj;
                FlatGUIContext flatUIContext = getInstance().getFlatUIContext();
                WidgetContainer<T> flatComponentAncestor = flatUIContext.getFlatComponentAncestor(this);
                if (flatComponentAncestor == null || flatUIContext.getAndroidViewWidget(this) != null) {
                    flatComponentAncestor = this;
                }
                flatUIContext.register(wXComponent, flatComponentAncestor);
                if (wXComponent instanceof FlatComponent) {
                    FlatComponent flatComponent = (FlatComponent) wXComponent;
                    if (!flatComponent.promoteToView(false)) {
                        widget = flatComponent.getOrCreateFlatWidget();
                        flatUIContext.register(widget, wXComponent);
                        addFlatChild(widget, ((Integer) rearrangeIndexAndGetChild.second).intValue());
                        return;
                    }
                }
                AndroidViewWidget androidViewWidget = new AndroidViewWidget(flatUIContext);
                flatUIContext.register(wXComponent, androidViewWidget);
                wXComponent.createView();
                androidViewWidget.setContentView(wXComponent.getHostView());
                flatComponentAncestor.addSubView(wXComponent.getHostView(), -1);
                widget = androidViewWidget;
                flatUIContext.register(widget, wXComponent);
                addFlatChild(widget, ((Integer) rearrangeIndexAndGetChild.second).intValue());
                return;
            }
            return;
        }
        super.createChildViewAt(i);
    }

    public boolean intendToBeFlatContainer() {
        return false;
    }

    protected abstract void mountFlatGUI();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void unmountFlatGUI();
}
