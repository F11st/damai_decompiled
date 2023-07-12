package com.uc.webview.export.internal.utility;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.setup.af;
import com.uc.webview.export.internal.setup.bt;
import com.youku.live.dago.module.DagoPlayerInteract;
import com.youku.usercenter.passport.result.VerifyCookieResult;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class m {
    public static String a = "lastucm";
    public static String b = "SO_DIR_PATH";
    public static String c = "RES_DIR_PATH";
    public static String d = "DATA_DIR_PATH";
    public static String e = "BUILD.TIME";
    public static String f = "aarch";
    public static String g = "COREIMPL_FILE_PATH";
    public static String h = "COREIMPL_ODEX_DIR_PATH";
    public static boolean i = true;
    public static String j = "quickpath";
    public static String k = "PKG_NAME";
    public static boolean l = true;
    static bt n;
    public static final int[] m = {126, DagoPlayerInteract.UNIT_ANCHOR_INFO_WIDTH, 115, 241, 101, 198, 215, 134};
    static a o = a.NUndefined;
    static Object p = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public enum a {
        NUndefined,
        NDisable,
        NNoFile,
        NEmptyFile,
        NEmptyLast,
        NNewZip,
        NNewDex,
        NNewLib,
        NNewKrl,
        NNewUrl,
        NBadLast,
        NExceptions,
        YLastOK,
        NEmptyJSON,
        NMisMatchVersion,
        NNoLastWebViewFlag,
        NDiffArch
    }

    public static void a(bt btVar, ConcurrentHashMap<String, Object> concurrentHashMap) {
        if (btVar == null) {
            new Exception("info should not be null").printStackTrace();
            return;
        }
        if (concurrentHashMap.get(UCCore.OPTION_DEX_FILE_PATH) != null) {
            btVar.setInitInfo(UCCore.OPTION_DEX_FILE_PATH, (String) concurrentHashMap.get(UCCore.OPTION_DEX_FILE_PATH));
        }
        if (concurrentHashMap.get(UCCore.OPTION_SO_FILE_PATH) != null) {
            btVar.setInitInfo(UCCore.OPTION_SO_FILE_PATH, (String) concurrentHashMap.get(UCCore.OPTION_SO_FILE_PATH));
        }
        if (concurrentHashMap.get(UCCore.OPTION_RES_FILE_PATH) != null) {
            btVar.setInitInfo(UCCore.OPTION_RES_FILE_PATH, (String) concurrentHashMap.get(UCCore.OPTION_RES_FILE_PATH));
        }
        if (concurrentHashMap.get(UCCore.OPTION_UCM_ZIP_FILE) != null) {
            btVar.setInitInfo(UCCore.OPTION_UCM_ZIP_FILE, (String) concurrentHashMap.get(UCCore.OPTION_UCM_ZIP_FILE));
        }
        if (concurrentHashMap.get(UCCore.OPTION_UCM_LIB_DIR) != null) {
            btVar.setInitInfo(UCCore.OPTION_UCM_LIB_DIR, (String) concurrentHashMap.get(UCCore.OPTION_UCM_LIB_DIR));
        }
        if (concurrentHashMap.get(UCCore.OPTION_UCM_UPD_URL) != null) {
            btVar.setInitInfo(UCCore.OPTION_UCM_UPD_URL, (String) concurrentHashMap.get(UCCore.OPTION_UCM_UPD_URL));
        }
        if (concurrentHashMap.get(UCCore.OPTION_UCM_KRL_DIR) != null) {
            btVar.setInitInfo(UCCore.OPTION_UCM_KRL_DIR, (String) concurrentHashMap.get(UCCore.OPTION_UCM_KRL_DIR));
        }
    }

    public static String b(Context context) {
        return new File(context.getDir("ucmsdk", 0), a).getAbsolutePath();
    }

    public static void c(Context context) {
        if (context == null) {
            return;
        }
        a(context, b(context));
    }

    public static void d(Context context) {
        try {
            new File(b(context)).delete();
        } catch (Exception unused) {
        }
    }

    private static JSONObject b(String str) {
        if (p.a(str)) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean c() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 21) {
            return false;
        }
        if (i2 >= 23) {
            return Process.is64Bit();
        }
        if (i2 >= 21) {
            try {
                Object invoke = ClassLoader.class.getDeclaredMethod("findLibrary", String.class).invoke(m.class.getClassLoader(), "art");
                if (invoke != null) {
                    return ((String) invoke).contains("lib64");
                }
            } catch (Exception unused) {
            }
            String property = System.getProperty("os.arch");
            if (property != null) {
                property.contains("64");
            }
        }
        return false;
    }

    private static byte[] b(byte[] bArr, int[] iArr) {
        if (bArr.length >= 2 && iArr != null && iArr.length == 8) {
            int length = bArr.length - 2;
            try {
                byte[] bArr2 = new byte[length];
                byte b2 = 0;
                for (int i2 = 0; i2 < length; i2++) {
                    byte b3 = (byte) (bArr[i2] ^ iArr[i2 % 8]);
                    bArr2[i2] = b3;
                    b2 = (byte) (b2 ^ b3);
                }
                if (bArr[length] == ((byte) ((iArr[0] ^ b2) & 255)) && bArr[length + 1] == ((byte) ((iArr[1] ^ b2) & 255))) {
                    return bArr2;
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:95:0x01be, code lost:
        a(com.uc.webview.export.internal.utility.m.a.k);
     */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01ac A[Catch: all -> 0x01d1, TryCatch #0 {all -> 0x01d1, blocks: (B:5:0x0016, B:7:0x001c, B:9:0x0022, B:11:0x0026, B:12:0x0030, B:14:0x0034, B:16:0x0038, B:18:0x0040, B:20:0x00aa, B:23:0x00ed, B:26:0x00f7, B:29:0x0107, B:31:0x010e, B:35:0x0119, B:37:0x011f, B:40:0x0128, B:42:0x012e, B:45:0x0137, B:47:0x013d, B:50:0x0146, B:52:0x014c, B:55:0x0155, B:57:0x015b, B:60:0x0164, B:62:0x016a, B:65:0x0173, B:67:0x017d, B:71:0x0188, B:73:0x0192, B:86:0x01ac, B:88:0x01b2, B:90:0x01b6, B:95:0x01be, B:96:0x01c4, B:98:0x01ca), top: B:104:0x0016 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean c(android.content.Context r19, java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Object> r20) {
        /*
            Method dump skipped, instructions count: 476
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.webview.export.internal.utility.m.c(android.content.Context, java.util.concurrent.ConcurrentHashMap):boolean");
    }

    private static byte[] b(String str, boolean z) {
        try {
            File file = new File(str);
            if (file.exists()) {
                FileInputStream fileInputStream = new FileInputStream(str);
                byte[] bArr = new byte[(int) file.length()];
                fileInputStream.read(bArr);
                fileInputStream.close();
                return z ? b(bArr, m) : bArr;
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static boolean b() {
        bt btVar = n;
        return btVar != null && btVar.isFromDisk;
    }

    public static boolean b(Context context, ConcurrentHashMap<String, Object> concurrentHashMap) {
        if (!af.b()) {
            a aVar = a.NDisable;
            a(aVar);
            if (i) {
                String str = j;
                Log.d(str, "willReuseOldCore false. rz=" + aVar);
            }
            return false;
        } else if (!com.uc.webview.export.internal.setup.h.a(context)) {
            if (i) {
                Log.d(j, "willReuseOldCore false. no lastwebview flag");
            }
            a(a.NNoLastWebViewFlag);
            return false;
        } else {
            a aVar2 = o;
            a aVar3 = a.YLastOK;
            if (aVar2.equals(aVar3)) {
                if (i) {
                    Log.d(j, "willReuseOldCore true. rz=okincache");
                    return true;
                }
                return true;
            } else if (!o.equals(aVar3) && !o.equals(a.NUndefined)) {
                if (i) {
                    String str2 = j;
                    Log.d(str2, "willReuseOldCore false. rz=" + o);
                }
                return false;
            } else {
                boolean c2 = c(context, concurrentHashMap);
                i.a().a("gk_quick_path", Boolean.valueOf(c2));
                return c2;
            }
        }
    }

    public static void a(bt btVar, String str) {
        com.uc.webview.export.internal.uc.startup.b.a(324);
        if (btVar == null) {
            new Exception("info should not be null").printStackTrace();
            return;
        }
        if (i) {
            Log.d("quickpath", "saveInfoToJsonFile path=" + str + ",isFromDisk=" + btVar.isFromDisk);
        }
        if (btVar.isFromDisk) {
            return;
        }
        try {
            a(a(btVar).toString(), str, l);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        com.uc.webview.export.internal.uc.startup.b.a(325);
    }

    private static JSONObject a(bt btVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            a(jSONObject, UCCore.OPTION_DEX_FILE_PATH, btVar.getInitInfo(UCCore.OPTION_DEX_FILE_PATH));
            a(jSONObject, UCCore.OPTION_SO_FILE_PATH, btVar.getInitInfo(UCCore.OPTION_SO_FILE_PATH));
            a(jSONObject, UCCore.OPTION_RES_FILE_PATH, btVar.getInitInfo(UCCore.OPTION_RES_FILE_PATH));
            a(jSONObject, UCCore.OPTION_UCM_ZIP_FILE, btVar.getInitInfo(UCCore.OPTION_UCM_ZIP_FILE));
            a(jSONObject, UCCore.OPTION_UCM_LIB_DIR, btVar.getInitInfo(UCCore.OPTION_UCM_LIB_DIR));
            a(jSONObject, UCCore.OPTION_UCM_UPD_URL, btVar.getInitInfo(UCCore.OPTION_UCM_UPD_URL));
            a(jSONObject, UCCore.OPTION_UCM_KRL_DIR, btVar.getInitInfo(UCCore.OPTION_UCM_KRL_DIR));
            a(jSONObject, k, btVar.pkgName);
            a(jSONObject, b, btVar.soDirPath);
            a(jSONObject, c, btVar.resDirPath);
            a(jSONObject, d, btVar.dataDir);
            a(jSONObject, e, com.uc.webview.export.Build.TIME);
            Pair<String, String> pair = btVar.coreImplModule;
            if (pair != null) {
                a(jSONObject, g, (String) pair.first);
            }
            a(jSONObject, f, c() ? "1" : "0");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public static String a(Context context) {
        String b2 = b(context);
        StringBuilder sb = new StringBuilder();
        sb.append("path=");
        sb.append(b2);
        sb.append("\ncontent=");
        if (new File(b2).exists()) {
            sb.append(a(b2, l));
        } else {
            sb.append("[Not Exists]");
        }
        return sb.toString();
    }

    private static bt a(Context context, String str) {
        bt btVar = n;
        if (btVar != null) {
            return btVar;
        }
        synchronized (p) {
            com.uc.webview.export.internal.uc.startup.b.a(322);
            bt btVar2 = n;
            if (btVar2 != null) {
                com.uc.webview.export.internal.uc.startup.b.a(323);
                return btVar2;
            }
            JSONObject a2 = a(str);
            if (a2 == null) {
                a(a.NEmptyJSON);
                com.uc.webview.export.internal.uc.startup.b.a(323);
                return null;
            }
            bt a3 = a(context, a2);
            n = a3;
            if (a3 == null) {
                a(a.NEmptyLast);
            }
            com.uc.webview.export.internal.uc.startup.b.a(323);
            return n;
        }
    }

    private static JSONObject a(String str) {
        if (!new File(str).exists()) {
            a(a.NNoFile);
            return null;
        }
        try {
            String a2 = a(str, l);
            if (a2 == null) {
                a(a.NEmptyFile);
                return null;
            }
            com.uc.webview.export.internal.uc.startup.b.a(InputDeviceCompat.SOURCE_DPAD);
            JSONObject b2 = b(a2);
            com.uc.webview.export.internal.uc.startup.b.a(514);
            return b2;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static String a(JSONObject jSONObject, String str) {
        try {
            return jSONObject.getString(str);
        } catch (Exception unused) {
            return null;
        }
    }

    private static void a(JSONObject jSONObject, String str, String str2) {
        if (str2 == null || str == null) {
            return;
        }
        try {
            jSONObject.put(str, str2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static bt a(Context context, JSONObject jSONObject) {
        UCMPackageInfo uCMPackageInfo;
        UCMPackageInfo uCMPackageInfo2 = null;
        if (jSONObject == null) {
            return null;
        }
        try {
            com.uc.webview.export.internal.uc.startup.b.a(512);
            uCMPackageInfo = new UCMPackageInfo(context, a(jSONObject, k), a(jSONObject, b), a(jSONObject, c), a(jSONObject, d), null, null, a(jSONObject, g), null, false, true);
        } catch (Exception e2) {
            e = e2;
        }
        try {
            if (a(jSONObject, e) != null) {
                String str = e;
                uCMPackageInfo.setInitInfo(str, a(jSONObject, str));
            }
            if (a(jSONObject, UCCore.OPTION_DEX_FILE_PATH) != null) {
                uCMPackageInfo.setInitInfo(UCCore.OPTION_DEX_FILE_PATH, a(jSONObject, UCCore.OPTION_DEX_FILE_PATH));
            }
            if (a(jSONObject, UCCore.OPTION_SO_FILE_PATH) != null) {
                uCMPackageInfo.setInitInfo(UCCore.OPTION_SO_FILE_PATH, a(jSONObject, UCCore.OPTION_SO_FILE_PATH));
            }
            if (a(jSONObject, UCCore.OPTION_RES_FILE_PATH) != null) {
                uCMPackageInfo.setInitInfo(UCCore.OPTION_RES_FILE_PATH, a(jSONObject, UCCore.OPTION_RES_FILE_PATH));
            }
            if (a(jSONObject, UCCore.OPTION_UCM_ZIP_FILE) != null) {
                uCMPackageInfo.setInitInfo(UCCore.OPTION_UCM_ZIP_FILE, a(jSONObject, UCCore.OPTION_UCM_ZIP_FILE));
            }
            if (a(jSONObject, UCCore.OPTION_UCM_LIB_DIR) != null) {
                uCMPackageInfo.setInitInfo(UCCore.OPTION_UCM_LIB_DIR, a(jSONObject, UCCore.OPTION_UCM_LIB_DIR));
            }
            if (a(jSONObject, UCCore.OPTION_UCM_UPD_URL) != null) {
                uCMPackageInfo.setInitInfo(UCCore.OPTION_UCM_UPD_URL, a(jSONObject, UCCore.OPTION_UCM_UPD_URL));
            }
            if (a(jSONObject, UCCore.OPTION_UCM_KRL_DIR) != null) {
                uCMPackageInfo.setInitInfo(UCCore.OPTION_UCM_KRL_DIR, a(jSONObject, UCCore.OPTION_UCM_KRL_DIR));
            }
            if (a(jSONObject, f) != null) {
                String str2 = f;
                uCMPackageInfo.setInitInfo(str2, a(jSONObject, str2));
            }
            uCMPackageInfo.isFromDisk = true;
            com.uc.webview.export.internal.uc.startup.b.a(VerifyCookieResult.COOKIE_VERIFY_ERROR);
            return uCMPackageInfo;
        } catch (Exception e3) {
            e = e3;
            uCMPackageInfo2 = uCMPackageInfo;
            e.printStackTrace();
            return uCMPackageInfo2;
        }
    }

    private static byte[] a(byte[] bArr, int[] iArr) {
        byte[] bArr2 = null;
        if (bArr != null && iArr != null && iArr.length == 8) {
            int length = bArr.length;
            try {
                bArr2 = new byte[length + 2];
                byte b2 = 0;
                for (int i2 = 0; i2 < length; i2++) {
                    byte b3 = bArr[i2];
                    bArr2[i2] = (byte) (iArr[i2 % 8] ^ b3);
                    b2 = (byte) (b2 ^ b3);
                }
                bArr2[length] = (byte) (iArr[0] ^ b2);
                bArr2[length + 1] = (byte) (iArr[1] ^ b2);
            } catch (Exception unused) {
            }
        }
        return bArr2;
    }

    private static boolean a(String str, String str2, boolean z) {
        if (i) {
            String str3 = j;
            Log.d(str3, "saveStringToFile str=" + str);
        }
        try {
            a(str.getBytes("UTF-8"), str2, z);
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return true;
        }
    }

    private static String a(String str, boolean z) {
        byte[] b2 = b(str, z);
        if (b2 != null) {
            try {
                return new String(b2, "UTF-8");
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return null;
    }

    private static boolean a(byte[] bArr, String str, boolean z) {
        try {
            File file = new File(str);
            File file2 = new File(file.getParent());
            if (!file2.exists()) {
                file2.mkdirs();
            }
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            if (z) {
                bArr = a(bArr, m);
            }
            fileOutputStream.write(bArr);
            fileOutputStream.close();
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static bt a() {
        return n;
    }

    public static boolean a(Context context, ConcurrentHashMap<String, Object> concurrentHashMap) {
        if (context == null) {
            return true;
        }
        try {
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (af.b()) {
            if (o.equals(a.YLastOK) || o.equals(a.NUndefined)) {
                if (n == null) {
                    n = a(context, b(context));
                }
                bt btVar = n;
                if (btVar == null) {
                    return true;
                }
                String initInfo = btVar.getInitInfo(UCCore.OPTION_UCM_UPD_URL);
                String str = (String) concurrentHashMap.get(UCCore.OPTION_UCM_UPD_URL);
                if (str != null) {
                    return !str.equals(initInfo);
                }
                return false;
            }
            return true;
        }
        return true;
    }

    private static void a(a aVar) {
        o = aVar;
        if (i) {
            String str = j;
            Log.d(str, "statQuickPathStatus st=" + aVar);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(aVar.ordinal());
        com.uc.webview.export.internal.uc.startup.b.a(501, sb.toString());
    }
}
