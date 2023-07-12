package com.youku.arch.solid.util;

import android.content.Context;
import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.File;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class LibPathUtil {
    private static transient /* synthetic */ IpChange $ipChange;

    public static void deleteDirectory(File file) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "543609018")) {
            ipChange.ipc$dispatch("543609018", new Object[]{file});
            return;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            Log.e("delete", file.getAbsolutePath());
            for (int i = 0; i < listFiles.length; i++) {
                if (listFiles[i].isDirectory()) {
                    deleteDirectory(listFiles[i]);
                } else {
                    listFiles[i].delete();
                }
            }
            file.delete();
        }
    }

    public static String getDefaultLibPath(Context context) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1201322242") ? (String) ipChange.ipc$dispatch("-1201322242", new Object[]{context}) : context.getFilesDir().getPath();
    }

    public static String getSpaceName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "376231820")) {
            return (String) ipChange.ipc$dispatch("376231820", new Object[]{str});
        }
        return "solid-" + str;
    }
}
