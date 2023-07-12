package com.youku.live.dago.widgetlib.interactive.resource.prefetch.fileprocessor;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.interactive.resource.prefetch.Config;
import com.youku.live.dago.widgetlib.interactive.resource.prefetch.fileprocessor.AfterDownloadProcessor;
import com.youku.live.dago.widgetlib.interactive.resource.prefetch.utils.FileUtil;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class ZipFileProcessor implements AfterDownloadProcessor.Processor {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.youku.live.dago.widgetlib.interactive.resource.prefetch.fileprocessor.AfterDownloadProcessor.Processor
    public boolean interruptable() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2036677057")) {
            return ((Boolean) ipChange.ipc$dispatch("2036677057", new Object[]{this})).booleanValue();
        }
        return true;
    }

    @Override // com.youku.live.dago.widgetlib.interactive.resource.prefetch.fileprocessor.AfterDownloadProcessor.Processor
    public AfterDownloadProcessor.ProcessedResource process(Config config, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "400913914")) {
            return (AfterDownloadProcessor.ProcessedResource) ipChange.ipc$dispatch("400913914", new Object[]{this, config, str, str2});
        }
        File file = new File(str2);
        String substring = file.getAbsolutePath().substring(0, file.getAbsolutePath().lastIndexOf(46));
        File file2 = new File(substring);
        FileUtil.deleteDir(file2);
        file2.mkdirs();
        try {
            ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(new FileInputStream(str2)));
            byte[] bArr = new byte[1024];
            while (true) {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry != null) {
                    String name = nextEntry.getName();
                    if (!nextEntry.isDirectory()) {
                        File file3 = new File(substring + "/" + name);
                        file3.deleteOnExit();
                        FileOutputStream fileOutputStream = new FileOutputStream(file3);
                        while (true) {
                            int read = zipInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                        }
                        fileOutputStream.close();
                        zipInputStream.closeEntry();
                    } else {
                        File file4 = new File(substring + "/" + name);
                        file4.deleteOnExit();
                        file4.mkdirs();
                    }
                } else {
                    zipInputStream.close();
                    return new AfterDownloadProcessor.ProcessedResource(substring);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            FileUtil.deleteDir(file2);
            return null;
        }
    }
}
