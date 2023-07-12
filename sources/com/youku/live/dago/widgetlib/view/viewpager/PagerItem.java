package com.youku.live.dago.widgetlib.view.viewpager;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.dom.CSSConstants;
import com.taobao.weex.layout.ContentBoxMeasurement;
import com.taobao.weex.layout.MeasureMode;
import com.taobao.weex.ui.action.BasicComponentData;
import com.taobao.weex.ui.component.WXDiv;
import com.taobao.weex.ui.component.WXVContainer;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class PagerItem extends WXDiv {
    public static final String COMPONENT_TYPE = "yk-pager-item";

    public PagerItem(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
        setContentBoxMeasurement(new ContentBoxMeasurement() { // from class: com.youku.live.dago.widgetlib.view.viewpager.PagerItem.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.taobao.weex.layout.ContentBoxMeasurement
            public void layoutAfter(float f, float f2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "550865426")) {
                    ipChange.ipc$dispatch("550865426", new Object[]{this, Float.valueOf(f), Float.valueOf(f2)});
                }
            }

            @Override // com.taobao.weex.layout.ContentBoxMeasurement
            public void layoutBefore() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-290713539")) {
                    ipChange.ipc$dispatch("-290713539", new Object[]{this});
                }
            }

            @Override // com.taobao.weex.layout.ContentBoxMeasurement
            public void measureInternal(float f, float f2, int i, int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1338771223")) {
                    ipChange.ipc$dispatch("-1338771223", new Object[]{this, Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(i2)});
                    return;
                }
                this.mMeasureWidth = (CSSConstants.isUndefined(f) || i == MeasureMode.UNSPECIFIED) ? 0.0f : 0.0f;
                this.mMeasureHeight = f2;
            }
        });
    }
}
