package com.taobao.weex.ui.action;

import android.widget.ScrollView;
import androidx.annotation.NonNull;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.common.WXRenderStrategy;
import com.taobao.weex.dom.transition.WXTransition;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.WXScroller;
import com.taobao.weex.utils.WXLogUtils;
import java.util.Map;
import java.util.Set;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class GraphicActionCreateBody extends GraphicActionAbstractAddElement {
    private WXComponent component;

    public GraphicActionCreateBody(@NonNull WXSDKInstance wXSDKInstance, String str, String str2, Map<String, String> map, Map<String, String> map2, Set<String> set, float[] fArr, float[] fArr2, float[] fArr3) {
        super(wXSDKInstance, str);
        this.mComponentType = str2;
        this.mStyle = map;
        this.mAttributes = map2;
        this.mEvents = set;
        this.mMargins = fArr;
        this.mPaddings = fArr2;
        this.mBorders = fArr3;
        if (wXSDKInstance.getContext() == null) {
            return;
        }
        WXComponent createComponent = createComponent(wXSDKInstance, null, new BasicComponentData(getRef(), this.mComponentType, null));
        this.component = createComponent;
        if (createComponent == null) {
            return;
        }
        createComponent.setTransition(WXTransition.fromMap(createComponent.getStyles(), this.component));
    }

    @Override // com.taobao.weex.ui.action.GraphicActionAbstractAddElement, com.taobao.weex.ui.action.IExecutable
    public void executeAction() {
        super.executeAction();
        try {
            this.component.createView();
            WXComponent wXComponent = this.component;
            wXComponent.applyLayoutAndEvent(wXComponent);
            WXComponent wXComponent2 = this.component;
            wXComponent2.bindData(wXComponent2);
            WXSDKInstance wXSDKIntance = getWXSDKIntance();
            WXComponent wXComponent3 = this.component;
            if (wXComponent3 instanceof WXScroller) {
                WXScroller wXScroller = (WXScroller) wXComponent3;
                if (wXScroller.getInnerView() instanceof ScrollView) {
                    wXSDKIntance.setRootScrollView((ScrollView) wXScroller.getInnerView());
                }
            }
            wXSDKIntance.onRootCreated(this.component);
            if (wXSDKIntance.getRenderStrategy() != WXRenderStrategy.APPEND_ONCE) {
                wXSDKIntance.onCreateFinish();
            }
        } catch (Exception e) {
            WXLogUtils.e("create body failed.", e);
        }
    }
}
