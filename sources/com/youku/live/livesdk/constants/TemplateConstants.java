package com.youku.live.livesdk.constants;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class TemplateConstants {
    private static transient /* synthetic */ IpChange $ipChange;

    public static String getLaifengTemplate20200309() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1330274110")) {
            return (String) ipChange.ipc$dispatch("1330274110", new Object[0]);
        }
        return "{\"id\":\"laifeng_watch\",\"playType\":\"interact\",\"version\":\"1.2\",\"standardWidth\":750,\"plugins\":[{\"name\":\"LiveChannel\",\"extra\":{}},{\"name\":\"LaifengRoomInfo\",\"extra\":{}},{\"name\":\"LiveFullInfoV3\",\"extra\":{}}],\"widget\":{\"name\":\"Stack\",\"id\":\"stack\",\"atts\":{\"portrait\":{\"margin\":{\"t\":0,\"l\":0,\"b\":0,\"r\":0}},\"landscape\":{\"margin\":{\"t\":0,\"l\":0,\"b\":0,\"r\":0}}},\"children\":[{\"name\":\"Background\",\"atts\":{\"portrait\":{\"margin\":{\"t\":0,\"l\":0,\"b\":0,\"r\":0}}},\"id\":\"background\"},{\"name\":\"InteractPlayback\",\"atts\":{\"portrait\":{\"margin\":{\"t\":0,\"l\":0,\"b\":0,\"r\":0}},\"landscape\":{\"margin\":{\"t\":0,\"l\":0,\"b\":0,\"r\":0}}},\"id\":\"InteractPlayback\"},{\"name\":\"Slide\",\"atts\":{\"portrait\":{\"margin\":{\"t\":0,\"l\":0,\"b\":0,\"r\":0}},\"landscape\":{\"margin\":{\"t\":0,\"l\":0,\"b\":0,\"r\":0}}},\"id\":\"slide\",\"children\":[{\"name\":\"LiveWeex\",\"atts\":{\"portrait\":{\"margin\":{\"t\":0,\"l\":0,\"b\":0,\"r\":0}},\"landscape\":{\"margin\":{\"t\":0,\"l\":0,\"b\":0,\"r\":0}},\"extra\":{\"config\":{}}},\"id\":\"live-weex\"}]}]}}";
    }
}
