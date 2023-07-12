package com.alimm.xadsdk.base.ut;

import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class UserTracker implements IUserTracker {
    private static final String DEFAULT_TRACK_PAGE = "xad_trace";
    private IUserTracker mTrackerImpl;

    public UserTracker(IUserTracker iUserTracker) {
        this.mTrackerImpl = iUserTracker;
    }

    public void track(int i, String str, String str2, String str3) {
        track(DEFAULT_TRACK_PAGE, i, str, str2, str3, null);
    }

    public void track(int i, String str, String str2, String str3, Map<String, String> map) {
        track(DEFAULT_TRACK_PAGE, i, str, str2, str3, map);
    }

    public void track(String str, int i, String str2, String str3, String str4) {
        track(str, i, str2, str3, str4, null);
    }

    @Override // com.alimm.xadsdk.base.ut.IUserTracker
    public void track(String str, int i, String str2, String str3, String str4, Map<String, String> map) {
        IUserTracker iUserTracker = this.mTrackerImpl;
        if (iUserTracker != null) {
            iUserTracker.track(str, i, str2, str3, str4, map);
        }
    }

    public void track(String str, String str2, String str3, Map<String, String> map) {
        track(DEFAULT_TRACK_PAGE, 19999, str, str2, str3, map);
    }
}
