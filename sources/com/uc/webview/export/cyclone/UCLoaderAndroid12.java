package com.uc.webview.export.cyclone;

import android.os.Build;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class UCLoaderAndroid12 {
    private static final String TAG = "UCLoaderAndroid12";

    public static String avoidAndroid12PreVerifyError(String str) {
        if (Build.VERSION.SDK_INT < 26) {
            return str;
        }
        int lastIndexOf = str.lastIndexOf(".jar");
        String str2 = str.substring(0, lastIndexOf) + "jar";
        if (new File(str2).exists()) {
            return str2;
        }
        try {
            Files.createSymbolicLink(Paths.get(str2, new String[0]), Paths.get(str, new String[0]), new FileAttribute[0]);
        } catch (FileAlreadyExistsException unused) {
        } catch (IOException e) {
            android.util.Log.e(TAG, "failed to create symblic file: " + str + ", and use the default dex path: " + str, e);
            return str;
        }
        return str2;
    }
}
