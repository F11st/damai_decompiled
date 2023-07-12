package com.alibaba.motu.crashreporter;

import com.alibaba.motu.crashreporter.Options;
import com.alibaba.motu.tbrest.rest.RestConstants;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class Configuration extends Options<Options.Option> {
    public static final String adashxServerHost = "Configuration.adashxServerHost";
    public static final String disableJitCompilation = "Configuration.disableJitCompilation";
    public static final String enableANRCatch = "Configuration.enableANRCatch";
    public static final String enableAllThreadCollection = "Configuration.enableAllThreadCollection";
    public static final String enableDumpHprof = "Configuration.enableDumpHprof";
    public static final String enableEventsLogCollection = "Configuration.enableEventsLogCollection";
    public static final String enableExternalLinster = "Configuration.enableExternalLinster";
    public static final String enableFinalizeFake = "Configuration.enableFinalizeFake";
    public static final String enableLogcatCollection = "Configuration.enableLogcatCollection";
    public static final String enableMainLoopBlockCatch = "Configuration.enableMainLoopBlockCatch";
    public static final String enableNativeExceptionCatch = "Configuration.enableNativeExceptionCatch";
    public static final String enableReportContentCompress = "Configuration.enableReportContentCompress";
    public static final String enableSafeGuard = "Configuration.enableSafeGuard";
    public static final String enableSecuritySDK = "Configuration.enableSecuritySDK";
    public static final String enableUCNativeExceptionCatch = "Configuration.enableUCNativeExceptionCatch";
    public static final String enableUIProcessSafeGuard = "Configuration.enableUIProcessSafeGuard";
    public static final String enableUncaughtExceptionCatch = "Configuration.enableUncaughtExceptionCatch";
    public static final String enableUncaughtExceptionIgnore = "Configuration.enableUncaughtExceptionIgnore";
    public static final String eventsLogLineLimit = "Configuration.eventsLogLineLimit";
    public static final String fileDescriptorLimit = "Configuration.fileDescriptorLimit";
    public static final String mainLogLineLimit = "Configuration.mainLogLineLimit";

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    private static class SingleInstanceHolder {
        public static final Configuration INSTANCE = new Configuration();

        private SingleInstanceHolder() {
        }
    }

    public static final Configuration getInstance() {
        return SingleInstanceHolder.INSTANCE;
    }

    private Configuration() {
        super(false);
        Boolean bool = Boolean.TRUE;
        add(new Options.Option(enableUncaughtExceptionCatch, bool));
        add(new Options.Option(enableUncaughtExceptionIgnore, bool));
        add(new Options.Option(enableNativeExceptionCatch, bool));
        add(new Options.Option(enableUCNativeExceptionCatch, bool));
        add(new Options.Option(enableANRCatch, bool));
        add(new Options.Option(enableMainLoopBlockCatch, bool));
        add(new Options.Option(enableAllThreadCollection, bool));
        add(new Options.Option(enableLogcatCollection, bool));
        add(new Options.Option(enableEventsLogCollection, bool));
        Boolean bool2 = Boolean.FALSE;
        add(new Options.Option(enableDumpHprof, bool2));
        add(new Options.Option(enableExternalLinster, bool));
        add(new Options.Option(enableSafeGuard, bool));
        add(new Options.Option(enableUIProcessSafeGuard, bool2));
        add(new Options.Option(enableFinalizeFake, bool));
        add(new Options.Option(disableJitCompilation, bool));
        add(new Options.Option(fileDescriptorLimit, 900));
        add(new Options.Option(mainLogLineLimit, 2000));
        add(new Options.Option(eventsLogLineLimit, 200));
        add(new Options.Option(enableReportContentCompress, bool));
        add(new Options.Option(enableSecuritySDK, bool));
        add(new Options.Option(adashxServerHost, RestConstants.G_DEFAULT_ADASHX_HOST));
    }
}
