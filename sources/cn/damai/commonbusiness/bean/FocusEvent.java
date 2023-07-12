package cn.damai.commonbusiness.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class FocusEvent implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String EVENT_NAME_NOTE_FOCUS_CHANGED = "EVENT_NAME_NOTE_FOCUS_CHANGED";
    public static final String EVENT_NAME_PROJECT_FOCUS_CHANGED = "EVENT_NAME_PROJECT_FOCUS_CHANGED";
    public final String type;

    private FocusEvent(String str) {
        this.type = str;
    }

    public static FocusEvent noteFocusChanged() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1360908704") ? (FocusEvent) ipChange.ipc$dispatch("1360908704", new Object[0]) : new FocusEvent(EVENT_NAME_NOTE_FOCUS_CHANGED);
    }

    public static FocusEvent projectFocusChanged() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2112835943") ? (FocusEvent) ipChange.ipc$dispatch("-2112835943", new Object[0]) : new FocusEvent(EVENT_NAME_PROJECT_FOCUS_CHANGED);
    }
}
