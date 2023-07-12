package com.uc.webview.export.internal.setup;

import android.content.Context;
import android.util.Pair;
import com.uc.webview.export.cyclone.UCCyclone;
import com.uc.webview.export.internal.utility.C7334h;
import com.uc.webview.export.internal.utility.C7349p;
import io.flutter.stat.StatServices;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class bt {
    public static final String ASSETS_DIR = "assets";
    public static final String RES_PAKS_DIR_NAME = "paks";
    private static final String[] a = {"webviewuc"};
    private static final String[] b = {"imagehelper"};
    private Context c;
    public String coreCode;
    public final Pair<String, String> coreImplModule;
    public final String dataDir;
    public final String disabledFilePath;
    public String mainLibrary;
    public final String pkgName;
    public final String resDirPath;
    public final Pair<String, String> sdkShellModule;
    public final String soDirPath;
    public boolean isFromDisk = false;
    public ClassLoader mSdkShellClassLoader = null;
    public ClassLoader mCoreClassLoader = null;
    private HashMap<String, String> d = new HashMap<>();

    /* JADX WARN: Code restructure failed: missing block: B:55:0x018e, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public bt(android.content.Context r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, boolean r26, boolean r27) throws com.uc.webview.export.internal.setup.UCSetupException {
        /*
            Method dump skipped, instructions count: 514
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.webview.export.internal.setup.bt.<init>(android.content.Context, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, boolean):void");
    }

    public String getDirAlias(Context context) {
        Object obj;
        String str;
        Pair<String, String> pair = this.coreImplModule;
        return (pair == null || (obj = pair.first) == null || (str = (String) obj) == null) ? "nul" : str.startsWith(C7349p.a(context, "decompresses2").getAbsolutePath()) ? "dec" : str.startsWith(C7349p.a(context, "updates").getAbsolutePath()) ? "upd" : str.startsWith(C7349p.a(context, "kjlinks").getAbsolutePath()) ? "kjl" : str.startsWith(C7349p.a(context, "kjcopies").getAbsolutePath()) ? "kjc" : str.startsWith(C7349p.a(context, "repairs").getAbsolutePath()) ? "rep" : "oth";
    }

    public Map<String, String> getFileHashs() {
        HashMap hashMap = new HashMap(16);
        Pair<String, String> pair = this.coreImplModule;
        if (pair != null && pair.first != null) {
            File file = new File((String) this.coreImplModule.first);
            hashMap.put(file.getName(), UCCyclone.hashFileContents(file, UCCyclone.MessageDigestType.MD5));
        } else {
            hashMap.put(StatServices.CATEGORY, "null");
        }
        Pair<String, String> pair2 = this.sdkShellModule;
        if (pair2 != null && pair2.first != null) {
            File file2 = new File((String) this.sdkShellModule.first);
            hashMap.put(file2.getName(), UCCyclone.hashFileContents(file2, UCCyclone.MessageDigestType.MD5));
        } else {
            hashMap.put("sdk_shell", "null");
        }
        String str = this.soDirPath;
        if (C7349p.a(str)) {
            str = this.c.getApplicationInfo().nativeLibraryDir;
        }
        if (str != null) {
            File file3 = new File(str);
            if (file3.isDirectory()) {
                String[][] d = C7334h.d(this.mSdkShellClassLoader);
                if (d != null) {
                    for (String[] strArr : d) {
                        String str2 = strArr[0];
                        C7349p.d(strArr[1]);
                        String str3 = strArr[2];
                        String hashFileContents = UCCyclone.hashFileContents(new File(file3, str2), UCCyclone.MessageDigestType.MD5);
                        if (!C7349p.a(str3) && !str3.equals(hashFileContents)) {
                            hashMap.put(str2, hashFileContents);
                        } else {
                            hashMap.put(str2, "ok");
                        }
                    }
                } else {
                    hashMap.put("NativeLibraries", "null");
                }
            } else {
                hashMap.put("so_dir", "null");
            }
        } else {
            hashMap.put("so_path", "null");
        }
        return hashMap;
    }

    public String getInitInfo(String str) {
        String str2;
        synchronized (this.d) {
            str2 = this.d.get(str);
        }
        return str2;
    }

    public boolean quickPathReady() {
        return this.isFromDisk;
    }

    public bt setInitInfo(String str, String str2) {
        synchronized (this.d) {
            this.d.put(str, str2);
        }
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("quick=" + this.isFromDisk);
        sb.append("\npkgName=" + this.pkgName);
        sb.append("\ndisbaledPath=" + this.disabledFilePath);
        sb.append("\nsoDir=" + this.soDirPath);
        sb.append("\nassetsDir=" + this.resDirPath);
        sb.append("\ndataDir=" + this.dataDir);
        sb.append("\nmainLib=" + this.mainLibrary);
        sb.append("\ncore=" + this.coreCode);
        sb.append("\n\nucbsLoader=" + bt.class.getClassLoader());
        sb.append("\n\nshellLoader=" + this.mSdkShellClassLoader);
        StringBuilder sb2 = new StringBuilder("\n\ncoreLoader=");
        ClassLoader classLoader = this.mCoreClassLoader;
        if (classLoader == null) {
            classLoader = af.e();
        }
        sb2.append(classLoader);
        sb.append(sb2.toString());
        sb.append(StringUtils.LF);
        if (this.sdkShellModule != null) {
            sb.append("\nshellPath=[");
            sb.append((String) this.sdkShellModule.first);
            sb.append(":");
            sb.append((String) this.sdkShellModule.second);
            sb.append(jn1.ARRAY_END_STR);
        } else {
            sb.append("\nshellPath=[null]");
        }
        if (this.coreImplModule != null) {
            sb.append("\ncorePath=[");
            sb.append((String) this.coreImplModule.first);
            sb.append(":");
            sb.append((String) this.coreImplModule.second);
            sb.append(jn1.ARRAY_END_STR);
        } else {
            sb.append("\ncorePath=[null]");
        }
        return sb.toString();
    }
}
