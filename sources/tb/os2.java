package tb;

import com.alibaba.analytics.version.IUTBuildInfo;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class os2 implements IUTBuildInfo {
    private static os2 a = null;
    private static String b = "6.5.10.6";

    private os2() {
    }

    public static synchronized os2 a() {
        os2 os2Var;
        synchronized (os2.class) {
            if (a == null) {
                a = new os2();
            }
            os2Var = a;
        }
        return os2Var;
    }

    @Override // com.alibaba.analytics.version.IUTBuildInfo
    public String getBuildID() {
        return "";
    }

    @Override // com.alibaba.analytics.version.IUTBuildInfo
    public String getFullSDKVersion() {
        return b;
    }

    @Override // com.alibaba.analytics.version.IUTBuildInfo
    public String getGitCommitID() {
        return "";
    }

    @Override // com.alibaba.analytics.version.IUTBuildInfo
    public String getShortSDKVersion() {
        return b;
    }

    @Override // com.alibaba.analytics.version.IUTBuildInfo
    public boolean isTestMode() {
        return false;
    }
}
