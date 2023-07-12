package com.youku.live.dago.widgetlib.interactive.resource.resource;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.interactive.resource.utils.FileUtils;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import java.io.File;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class YKLAfterDownloadProcessor {
    private static transient /* synthetic */ IpChange $ipChange;
    public YKLDownloadListener mDownloadListener;
    public String mUrl;

    public YKLAfterDownloadProcessor() {
    }

    public void copyFile(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1530089528")) {
            ipChange.ipc$dispatch("-1530089528", new Object[]{this, str});
        } else if (TextUtils.isEmpty(str)) {
        } else {
            String subStringFileName = FileUtils.subStringFileName(str);
            File file = new File(str);
            String name = file.getName();
            String str2 = str.substring(0, str.lastIndexOf("/") + 1) + subStringFileName + File.separator;
            File file2 = new File(str2);
            FileUtils.deleteDirectory(file2.getAbsolutePath());
            file2.mkdirs();
            ((ILog) Dsl.getService(ILog.class)).d("liulei-download", "Copy to  = " + file.renameTo(new File(str2 + name)));
        }
    }

    public void process(boolean z, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2006367986")) {
            ipChange.ipc$dispatch("2006367986", new Object[]{this, Boolean.valueOf(z), str});
        } else if (TextUtils.isEmpty(str)) {
        } else {
            if (z) {
                ((ILog) Dsl.getService(ILog.class)).d("liulei-download", "isZip file , unzip , filepathc = " + str);
                unZipFile(FileUtils.subStringFileName(str), str);
                return;
            }
            ((ILog) Dsl.getService(ILog.class)).d("liulei-download", "not zip file , copy to , filepathc = " + str);
            copyFile(str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:82:0x020e A[Catch: IOException -> 0x020a, TryCatch #0 {IOException -> 0x020a, blocks: (B:78:0x0206, B:82:0x020e, B:84:0x0213), top: B:88:0x0206 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0213 A[Catch: IOException -> 0x020a, TRY_LEAVE, TryCatch #0 {IOException -> 0x020a, blocks: (B:78:0x0206, B:82:0x020e, B:84:0x0213), top: B:88:0x0206 }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0206 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void unZipFile(java.lang.String r17, java.lang.String r18) {
        /*
            Method dump skipped, instructions count: 539
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.live.dago.widgetlib.interactive.resource.resource.YKLAfterDownloadProcessor.unZipFile(java.lang.String, java.lang.String):void");
    }

    public YKLAfterDownloadProcessor(String str, YKLDownloadListener yKLDownloadListener) {
        this.mUrl = str;
        this.mDownloadListener = yKLDownloadListener;
    }
}
