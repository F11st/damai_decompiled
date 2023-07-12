package com.ut.mini.extend;

import android.app.Activity;
import android.net.Uri;
import com.taobao.ju.track.JTrack;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class JTrackExtend {
    public static Map<String, String> getArgsMap(String str, Uri uri) {
        return JTrack.Page.getArgsMap(str, uri);
    }

    public static String getPageName(String str) {
        return JTrack.Page.getPageName(str);
    }

    public static Map<String, String> getArgsMap(Activity activity, Uri uri) {
        return JTrack.Page.getArgsMap(activity, uri);
    }
}
