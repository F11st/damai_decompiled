package com.uc.webview.export.internal.update;

import android.content.Context;
import com.uc.webview.export.cyclone.UCCyclone;
import com.uc.webview.export.cyclone.update.UpdateFlagMarker;
import com.uc.webview.export.extension.SettingKeys;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.extension.UCSettings;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.utility.Log;
import com.uc.webview.export.internal.utility.p;
import java.io.File;
import java.io.FileWriter;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class a {
    private static volatile String a;
    private static volatile boolean b;

    public static boolean a(File file) {
        if (file == null || p.a(a)) {
            return false;
        }
        return (file.getAbsolutePath() + "/").equals(a);
    }

    public static File b(Context context) {
        try {
            File a2 = b.a(context);
            String str = context.getApplicationContext().getApplicationInfo().nativeLibraryDir;
            if (str != null && str.equals(a2.getAbsolutePath())) {
                a2 = p.a(context, "rep_apollo");
                File file = new File(str);
                Log.d("UCPlayer", "lnkUCPlayerLibs libDir:" + file.getAbsolutePath() + ", ucPlayerDir:" + a2.getAbsolutePath());
                a(file, a2, "libffmpeg.so");
                a(file, a2, "libu3player.so");
                a(file, a2, "librotate.so");
                a(file, a2, "libinitHelper.so");
            }
            return a(a2, null);
        } catch (Throwable th) {
            Log.e("UCPlayer", "getUCPlayerDir", th);
            return null;
        }
    }

    public static void a(Map<String, Object> map) {
        com.uc.webview.export.internal.utility.i a2 = com.uc.webview.export.internal.utility.i.a();
        if (map != null) {
            Object obj = map.get(UCCore.OPTION_UC_PLAYER_ROOT);
            if (obj != null) {
                a2.a(UCCore.OPTION_UC_PLAYER_ROOT, obj);
            }
            Boolean bool = (Boolean) map.get(UCCore.OPTION_USE_UC_PLAYER);
            a2.a(UCCore.OPTION_USE_UC_PLAYER, Boolean.valueOf(bool != null ? bool.booleanValue() : true));
        }
        Log.d("UCPlayer", "setUCPlayerOptions use:" + a2.b(UCCore.OPTION_USE_UC_PLAYER) + ", soDir:" + a2.a(UCCore.OPTION_UC_PLAYER_ROOT));
    }

    public static void a(Context context) {
        if (!com.uc.webview.export.internal.utility.i.a().b(UCCore.OPTION_USE_UC_PLAYER) || b || !SDKFactory.b() || 2 == SDKFactory.e()) {
            return;
        }
        File b2 = b(context);
        Log.d("UCPlayer", "setupUCPlayer ucPlayerDir:" + b2);
        if (b2 == null) {
            return;
        }
        FileWriter fileWriter = null;
        try {
            String str = b2.getAbsolutePath() + "/";
            UCSettings.setGlobalStringValue(SettingKeys.MediaPlayerPlugin, "so_dir: " + str);
            try {
                File file = new File(b2, ".lock");
                if (!file.exists()) {
                    FileWriter fileWriter2 = new FileWriter(file);
                    try {
                        fileWriter2.write("2.6.0.167");
                        fileWriter = fileWriter2;
                    } catch (Throwable unused) {
                        fileWriter = fileWriter2;
                    }
                }
            } catch (Throwable unused2) {
            }
            UCCyclone.close(fileWriter);
            a = str;
            b = true;
        } catch (Throwable th) {
            try {
                Log.e("UCPlayer", "setupForUCPlayer: " + SDKFactory.c, th);
            } finally {
                UCCyclone.close(fileWriter);
            }
        }
    }

    private static File a(File file, File file2) {
        if (file.exists() && file.isDirectory()) {
            File file3 = new File(file, "libu3player.so");
            if (file3.exists() && UpdateFlagMarker.isFinished(file, "libu3player.so")) {
                File file4 = file2 == null ? null : new File(file2, "libu3player.so");
                if (file4 == null || file3.lastModified() > file4.lastModified()) {
                    file2 = file;
                }
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file5 : listFiles) {
                    if (file5.isDirectory()) {
                        file2 = a(file5, file2);
                    }
                }
            }
        }
        return file2;
    }

    private static void a(File file, File file2, String str) {
        File file3 = new File(file, str);
        File file4 = new File(file2, str);
        p.a(file3, file4, file4);
    }
}
