package com.ut.mini;

import com.ut.mini.module.appstatus.UTAppStatusMonitor;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class UTPvidHelper {
    private static final String UTBG = "utbg";
    private static final String UTPVID = "utpvid";
    private static final String UTPVID_B = "utpvid-b";
    private static long mUTPvid;
    private static long mUTPvidB;

    UTPvidHelper() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long getUtPvid() {
        long j;
        synchronized (UTPvidHelper.class) {
            j = mUTPvid;
        }
        return j;
    }

    public static void pageAppear() {
        synchronized (UTPvidHelper.class) {
            mUTPvid++;
        }
    }

    public static Map<String, String> processH5PagePvid(int i, Map<String, String> map) {
        if (i != 2001) {
            return map;
        }
        if (map == null) {
            return null;
        }
        synchronized (UTPvidHelper.class) {
            mUTPvid++;
            map.put(UTPVID, "" + mUTPvid);
            map.put(UTPVID_B, "" + mUTPvidB);
            mUTPvidB = mUTPvid;
        }
        return map;
    }

    public static Map<String, String> processOtherPvid(int i, Map<String, String> map) {
        if (map == null) {
            return null;
        }
        if (i != 19999 && i != 1010 && !UTAppStatusMonitor.getInstance().isInForeground()) {
            map.put(UTBG, "1");
        }
        if (i == 2001) {
            return map;
        }
        synchronized (UTPvidHelper.class) {
            if (i != 19999) {
                map.put(UTPVID, "" + mUTPvid);
                map.remove(UTPVID_B);
            } else {
                map.remove(UTPVID);
                map.remove(UTPVID_B);
            }
        }
        return map;
    }

    public static Map<String, String> processPagePvid(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        synchronized (UTPvidHelper.class) {
            map.put(UTPVID, "" + mUTPvid);
            map.put(UTPVID_B, "" + mUTPvidB);
            mUTPvidB = mUTPvid;
        }
        return map;
    }
}
