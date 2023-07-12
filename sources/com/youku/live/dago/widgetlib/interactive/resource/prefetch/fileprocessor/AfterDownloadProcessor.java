package com.youku.live.dago.widgetlib.interactive.resource.prefetch.fileprocessor;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.interactive.resource.prefetch.Config;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class AfterDownloadProcessor {
    private static transient /* synthetic */ IpChange $ipChange;
    private static Map<String, Processor> SUFFIX_PROCESSORS = new HashMap();
    private static Map<String, Processor> NAMESPACE_PROCESSORS = new HashMap();

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class ProcessedResource {
        String[] mFilePath;

        public ProcessedResource(String... strArr) {
            this.mFilePath = strArr;
        }

        public String[] getProcessedFilePath() {
            return this.mFilePath;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface Processor {
        boolean interruptable();

        ProcessedResource process(Config config, String str, String str2);
    }

    static {
        SUFFIX_PROCESSORS.put("zip", new ZipFileProcessor());
    }

    public static ProcessedResource process(Config config, String str, String str2) {
        Processor processor;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-951886573")) {
            return (ProcessedResource) ipChange.ipc$dispatch("-951886573", new Object[]{config, str, str2});
        }
        File file = new File(str2);
        if (file.exists()) {
            ProcessedResource processedResource = null;
            if (config.getNamespace() != null && config.getNamespace().length() != 0 && (processor = NAMESPACE_PROCESSORS.get(config.getNamespace())) != null) {
                processedResource = processor.process(config, str, str2);
                if (processor.interruptable()) {
                    return processedResource;
                }
            }
            if (processedResource != null) {
                str2 = processedResource.getProcessedFilePath()[0];
                file = new File(str2);
            }
            String substring = file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf(46) + 1);
            if (substring != null && SUFFIX_PROCESSORS.containsKey(substring)) {
                return SUFFIX_PROCESSORS.get(substring).process(config, str, str2);
            }
        }
        return processDefaultFile(str2);
    }

    private static ProcessedResource processDefaultFile(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "315788372") ? (ProcessedResource) ipChange.ipc$dispatch("315788372", new Object[]{str}) : new ProcessedResource(str);
    }

    public static void registerNamespaceProcessor(String str, Processor processor) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1573437434")) {
            ipChange.ipc$dispatch("-1573437434", new Object[]{str, processor});
        } else {
            NAMESPACE_PROCESSORS.put(str, processor);
        }
    }

    public static void registerSuffixProcessor(String str, Processor processor) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1744649274")) {
            ipChange.ipc$dispatch("1744649274", new Object[]{str, processor});
        } else {
            SUFFIX_PROCESSORS.put(str, processor);
        }
    }
}
