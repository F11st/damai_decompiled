package com.youku.live.dago.widgetlib.interactive.resource.resource;

import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.interactive.resource.prefetch.Config;
import com.youku.live.dago.widgetlib.interactive.resource.prefetch.fileprocessor.AfterDownloadProcessor;
import java.io.File;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class YKLProcessor implements AfterDownloadProcessor.Processor {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01b2 A[Catch: IOException -> 0x01ae, TryCatch #4 {IOException -> 0x01ae, blocks: (B:59:0x01aa, B:63:0x01b2, B:65:0x01b7), top: B:86:0x01aa }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01b7 A[Catch: IOException -> 0x01ae, TRY_LEAVE, TryCatch #4 {IOException -> 0x01ae, blocks: (B:59:0x01aa, B:63:0x01b2, B:65:0x01b7), top: B:86:0x01aa }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01cf A[Catch: IOException -> 0x01cb, TryCatch #5 {IOException -> 0x01cb, blocks: (B:74:0x01c7, B:78:0x01cf, B:80:0x01d4), top: B:88:0x01c7 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01d4 A[Catch: IOException -> 0x01cb, TRY_LEAVE, TryCatch #5 {IOException -> 0x01cb, blocks: (B:74:0x01c7, B:78:0x01cf, B:80:0x01d4), top: B:88:0x01c7 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01aa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01c7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v12, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v5, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r11v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.youku.live.dago.widgetlib.interactive.resource.prefetch.fileprocessor.AfterDownloadProcessor.ProcessedResource unZipFile(com.youku.live.dago.widgetlib.interactive.resource.prefetch.Config r17, java.lang.String r18, java.lang.String r19) {
        /*
            Method dump skipped, instructions count: 476
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.live.dago.widgetlib.interactive.resource.resource.YKLProcessor.unZipFile(com.youku.live.dago.widgetlib.interactive.resource.prefetch.Config, java.lang.String, java.lang.String):com.youku.live.dago.widgetlib.interactive.resource.prefetch.fileprocessor.AfterDownloadProcessor$ProcessedResource");
    }

    @Override // com.youku.live.dago.widgetlib.interactive.resource.prefetch.fileprocessor.AfterDownloadProcessor.Processor
    public boolean interruptable() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-816794514")) {
            return ((Boolean) ipChange.ipc$dispatch("-816794514", new Object[]{this})).booleanValue();
        }
        return true;
    }

    @Override // com.youku.live.dago.widgetlib.interactive.resource.prefetch.fileprocessor.AfterDownloadProcessor.Processor
    public AfterDownloadProcessor.ProcessedResource process(Config config, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-911601299")) {
            return (AfterDownloadProcessor.ProcessedResource) ipChange.ipc$dispatch("-911601299", new Object[]{this, config, str, str2});
        }
        Log.d("YKLPrefetchManager", "process file name = " + str + "  file = " + str2);
        if (!str2.endsWith(".zip")) {
            Log.d("YKLPrefetchManager", "modify file name" + str);
            String str3 = str2 + ".zip";
            new File(str2).renameTo(new File(str3));
            str2 = str3;
        }
        return unZipFile(config, str, str2);
    }
}
