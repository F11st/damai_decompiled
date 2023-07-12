package com.youku.arch.solid;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.edge.pcdn.UniversalDownloader;
import com.youku.arch.solid.log.SLog;
import com.youku.arch.solid.monitor.SolidMonitor;
import com.youku.arch.solid.util.FileUtil;
import com.youku.arch.solid.util.LibPathUtil;
import java.io.File;
import java.io.FilenameFilter;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class SoInfoManager {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String CONFIG_KEY_IS_LOCAL = "isLocal";
    private static final String CONFIG_KEY_SO_GROUPS = "soGroups";
    private static final String SO_INFO_FILE_NAME_32 = "solid-info-armeabi.json";
    private static final String SO_INFO_FILE_NAME_32_v7a = "solid-info-armeabi-v7a.json";
    private static final String SO_INFO_FILE_NAME_64 = "solid-info-arm64-v8a.json";
    private static final String TAG = "SoInfoManager";
    private boolean isLocal = false;
    HashMap<String, SoInfoWrapper> soInfoMap = new HashMap<>();
    HashMap<String, SoGroupWrapper> soGroupMap = new HashMap<>();

    private void checkAndCopyOldSo(final File file) {
        File[] listFiles;
        SoInfoWrapper soInfoWithSoName;
        File file2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1990385677")) {
            ipChange.ipc$dispatch("-1990385677", new Object[]{this, file});
        } else if (file != null && file.exists()) {
            File parentFile = file.getParentFile();
            if (parentFile != null && parentFile.exists()) {
                File[] listFiles2 = parentFile.listFiles(new FilenameFilter() { // from class: com.youku.arch.solid.SoInfoManager.2
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // java.io.FilenameFilter
                    public boolean accept(File file3, String str) {
                        IpChange ipChange2 = $ipChange;
                        return AndroidInstantRuntime.support(ipChange2, "2093537498") ? ((Boolean) ipChange2.ipc$dispatch("2093537498", new Object[]{this, file3, str})).booleanValue() : str.startsWith("solid-") && !str.equals(file.getName());
                    }
                });
                if (listFiles2 != null && listFiles2.length > 0) {
                    File file3 = listFiles2[0];
                    if (file3 != null) {
                        for (File file4 : file3.listFiles()) {
                            if (file4 != null && file4.exists() && (soInfoWithSoName = getSoInfoWithSoName(file4.getName())) != null && TextUtils.equals(FileUtil.computeFileMD5(file4), soInfoWithSoName.md5())) {
                                if (file4.renameTo(new File(file.getPath() + File.separator + file4.getName()))) {
                                    SLog.d(TAG, "copy old so success, new so -> " + file2.getPath());
                                }
                            }
                        }
                    }
                    for (File file5 : listFiles2) {
                        LibPathUtil.deleteDirectory(file5);
                        SLog.d(TAG, "clear oldSoDir");
                    }
                    return;
                }
                SLog.e(TAG, "no oldSoDirs");
                return;
            }
            SLog.e(TAG, "no parentFile");
        } else {
            SLog.e(TAG, "no currentSoDir");
        }
    }

    private void checkLocalFileAndUpdateStatus() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-490168504")) {
            ipChange.ipc$dispatch("-490168504", new Object[]{this});
            return;
        }
        LibPathUtil.deleteDirectory(ensureSolidDirReady(Solid.getInstance().getConfig().getZipPath()));
        File ensureSolidDirReady = ensureSolidDirReady(Solid.getInstance().getConfig().getLibInstallPath());
        checkAndCopyOldSo(ensureSolidDirReady);
        File[] listFiles = ensureSolidDirReady.listFiles();
        if (listFiles == null || listFiles.length <= 0) {
            return;
        }
        for (File file : listFiles) {
            if (file.isDirectory()) {
                file.delete();
            } else {
                String name = file.getName();
                if (name.startsWith(SolidMonitor.CHECK_TYPE_LIB) && name.endsWith(".so")) {
                    SoInfoWrapper soInfoWithSoName = getSoInfoWithSoName(name);
                    if (soInfoWithSoName == null) {
                        file.delete();
                    } else if (TextUtils.equals(FileUtil.computeFileMD5(file), soInfoWithSoName.md5())) {
                        soInfoWithSoName.setLocalFile(file);
                        soInfoWithSoName.updateStatus(Status.DOWNLOADED);
                    } else {
                        file.delete();
                        soInfoWithSoName.updateStatus(Status.WAIT_TO_DOWNLOAD);
                        try {
                            UniversalDownloader.remove(file.getName());
                        } catch (Throwable unused) {
                        }
                    }
                }
            }
        }
    }

    private File ensureSolidDirReady(@NonNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1431941323")) {
            return (File) ipChange.ipc$dispatch("1431941323", new Object[]{this, str});
        }
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            return file;
        }
        if (file.exists() && file.isFile() && !file.delete()) {
            throw new RuntimeException("can't delete solid file.");
        }
        if (file.mkdirs()) {
            return file;
        }
        throw new RuntimeException("can't create solid dir.");
    }

    private void printSoInfo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "45361220")) {
            ipChange.ipc$dispatch("45361220", new Object[]{this});
            return;
        }
        for (SoGroupWrapper soGroupWrapper : this.soGroupMap.values()) {
            SLog.e("PrintSoGroup", soGroupWrapper.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SoGroupWrapper getSoGroupWithName(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1636673869") ? (SoGroupWrapper) ipChange.ipc$dispatch("-1636673869", new Object[]{this, str}) : this.soGroupMap.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SoInfoWrapper getSoInfoWithSoName(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1750907405") ? (SoInfoWrapper) ipChange.ipc$dispatch("1750907405", new Object[]{this, str}) : this.soInfoMap.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isLocal() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1592858846") ? ((Boolean) ipChange.ipc$dispatch("1592858846", new Object[]{this})).booleanValue() : this.isLocal;
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x01ed A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean prepare() {
        /*
            Method dump skipped, instructions count: 500
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.arch.solid.SoInfoManager.prepare():boolean");
    }
}
