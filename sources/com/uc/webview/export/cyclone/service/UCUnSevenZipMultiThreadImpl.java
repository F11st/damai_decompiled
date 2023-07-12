package com.uc.webview.export.cyclone.service;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.taobao.weex.ui.component.WXComponent;
import com.uc.webview.export.cyclone.Constant;
import com.uc.webview.export.cyclone.UCCyclone;
import com.uc.webview.export.cyclone.UCKnownException;
import com.uc.webview.export.cyclone.UCLibrary;
import com.uc.webview.export.cyclone.UCLogger;
import com.uc.webview.export.cyclone.UCService;
import java.io.File;
import java.io.IOException;

/* compiled from: Taobao */
@Constant
/* loaded from: classes11.dex */
public class UCUnSevenZipMultiThreadImpl implements UCUnSevenZip {
    private static final String LOG_TAG = "UCUnSevenZipMultiThreadImplConstant";
    private static String mFailedFilePath = null;
    private static boolean mSoIsLoaded = false;
    private static UCKnownException mSoIsLoadedException = null;
    private static final boolean sSupportArm64 = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public enum ArchType {
        Arm,
        Arm64,
        Unknown
    }

    static {
        try {
            UCService.registerImpl(UCUnSevenZip.class, new UCUnSevenZipMultiThreadImpl());
        } catch (Throwable th) {
            UCLogger create = UCLogger.create(WXComponent.PROP_FS_WRAP_CONTENT, LOG_TAG);
            if (create != null) {
                create.print("UCUnSevenZipMultiThreadImplConstant register exception:", th);
            }
        }
    }

    private static native int dec7z(String str, String str2, String str3);

    private static ArchType getCurrentArch(String str) {
        ArchType archType = ArchType.Unknown;
        if (Build.VERSION.SDK_INT >= 23) {
            if (Process.is64Bit()) {
                return ArchType.Arm64;
            }
            return ArchType.Arm;
        } else if (str.indexOf("/lib/arm64/") > 0) {
            return ArchType.Arm64;
        } else {
            return str.indexOf("/lib/arm/") > 0 ? ArchType.Arm : archType;
        }
    }

    private static synchronized void loadSo(Context context, ArchType archType) {
        synchronized (UCUnSevenZipMultiThreadImpl.class) {
            if (mSoIsLoaded) {
                return;
            }
            UCKnownException uCKnownException = mSoIsLoadedException;
            if (uCKnownException == null) {
                ArchType archType2 = ArchType.Arm;
                if (archType2 != archType && ArchType.Arm64 != archType) {
                    try {
                        try {
                            loadSoImpl(context, archType2);
                        } catch (Throwable th) {
                            throw new UCKnownException(th);
                        }
                    } catch (Throwable unused) {
                        loadSoImpl(context, ArchType.Arm64);
                    }
                } else {
                    loadSoImpl(context, archType);
                }
                mSoIsLoaded = true;
                return;
            }
            throw uCKnownException;
        }
    }

    private static void loadSoImpl(Context context, ArchType archType) throws IOException {
        File genFile;
        try {
            if (ArchType.Arm == archType) {
                genFile = UCCyclone.genFile(context, null, "libdec7zmt-arm", ".so", 25977809L, "b815846a1a67c293fea7d09625a9ced1", UCUnSevenZipMultiThreadImplConstantArm.genCodes(), new Object[0]);
            } else {
                genFile = ArchType.Arm64 == archType ? UCCyclone.genFile(context, null, "libdec7zmt-arm64", ".so", 25936580L, "8e50b80c2ff7c7f2f62825e4e4ca4101", UCUnSevenZipMultiThreadImplConstantArm64.genCodes(), new Object[0]) : null;
            }
            if (genFile != null) {
                UCLibrary.load(context, genFile.getAbsolutePath(), null);
                return;
            }
            throw new UCKnownException("arch not support");
        } catch (IOException e) {
            throw e;
        }
    }

    public static void saveFailedFilePath(String str) {
        mFailedFilePath = str;
    }

    @Override // com.uc.webview.export.cyclone.service.UCUnSevenZip
    public int deccompress(Context context, String str, String str2) {
        loadSo(context, getCurrentArch(str));
        int dec7z = dec7z(str, str2, "");
        UCLogger create = !UCCyclone.enableDebugLog ? null : UCLogger.create("d", LOG_TAG);
        if (create != null) {
            create.print("UCUnSevenZipMultiThreadImpl.dec ret=" + dec7z, new Throwable[0]);
        }
        return dec7z;
    }

    @Override // com.uc.webview.export.cyclone.service.UCUnSevenZip
    public String failedFilePath() {
        return mFailedFilePath;
    }

    @Override // com.uc.webview.export.cyclone.service.UCServiceInterface
    public int getServiceVersion() {
        return 0;
    }

    @Override // com.uc.webview.export.cyclone.service.UCUnSevenZip
    public int deccompress(Context context, String str, String str2, String str3) {
        loadSo(context, getCurrentArch(str));
        int dec7z = dec7z(str, str2, str3);
        UCLogger create = !UCCyclone.enableDebugLog ? null : UCLogger.create("d", LOG_TAG);
        if (create != null) {
            create.print("UCUnSevenZipMultiThreadImpl.dec ret=" + dec7z, new Throwable[0]);
        }
        return dec7z;
    }
}
