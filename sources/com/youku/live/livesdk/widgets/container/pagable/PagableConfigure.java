package com.youku.live.livesdk.widgets.container.pagable;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class PagableConfigure {
    private static transient /* synthetic */ IpChange $ipChange;
    private static PagableConfigure sInstance;
    private volatile PreloadMode mCurrentLayoutMode;
    private volatile PreloadMode mCurrentWidgetMode;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public enum PreloadMode {
        TOP_BOTTOM("top_bottom"),
        BOTTOM("bottom"),
        NONE("none");
        
        String value;

        PreloadMode(String str) {
            this.value = str;
        }

        public static PreloadMode get(String str) {
            int length = values().length;
            PreloadMode preloadMode = NONE;
            for (int i = 0; i < length; i++) {
                if (values()[i].getValue().equals(str)) {
                    return values()[i];
                }
            }
            return preloadMode;
        }

        public String getValue() {
            return this.value;
        }
    }

    private PagableConfigure() {
        PreloadMode preloadMode = PreloadMode.BOTTOM;
        this.mCurrentLayoutMode = preloadMode;
        this.mCurrentWidgetMode = preloadMode;
        updateLayoutMode(preloadMode);
        updateWidgetMode(preloadMode);
    }

    public static PagableConfigure getInstance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1552019251")) {
            return (PagableConfigure) ipChange.ipc$dispatch("-1552019251", new Object[0]);
        }
        if (sInstance == null) {
            synchronized (PagableConfigure.class) {
                if (sInstance == null) {
                    sInstance = new PagableConfigure();
                }
            }
        }
        return sInstance;
    }

    public PreloadMode getCurrentModeForLayout() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-139215197") ? (PreloadMode) ipChange.ipc$dispatch("-139215197", new Object[]{this}) : this.mCurrentLayoutMode;
    }

    public PreloadMode getCurrentModeForWidget() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "376309449") ? (PreloadMode) ipChange.ipc$dispatch("376309449", new Object[]{this}) : this.mCurrentWidgetMode;
    }

    public void updateLayoutMode(PreloadMode preloadMode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1431771252")) {
            ipChange.ipc$dispatch("-1431771252", new Object[]{this, preloadMode});
        } else {
            this.mCurrentLayoutMode = preloadMode;
        }
    }

    public void updateWidgetMode(PreloadMode preloadMode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-839661786")) {
            ipChange.ipc$dispatch("-839661786", new Object[]{this, preloadMode});
        } else {
            this.mCurrentWidgetMode = preloadMode;
        }
    }
}
