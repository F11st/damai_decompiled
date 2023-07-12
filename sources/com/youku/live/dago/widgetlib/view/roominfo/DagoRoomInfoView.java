package com.youku.live.dago.widgetlib.view.roominfo;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DagoRoomInfoView extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;

    public DagoRoomInfoView(Context context) {
        super(context);
        init();
    }

    private void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-403543459")) {
            ipChange.ipc$dispatch("-403543459", new Object[]{this});
        }
    }

    public DagoRoomInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public DagoRoomInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }
}
