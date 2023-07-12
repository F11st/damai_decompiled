package com.youku.arch.solid;

import android.app.Application;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.solid.download.DefaultDownloaderImpl;
import com.youku.arch.solid.download.IDownloader;
import com.youku.arch.solid.execuror.DefaultExecutor;
import com.youku.arch.solid.log.DefaultLoggerImpl;
import com.youku.arch.solid.log.ILogger;
import com.youku.arch.solid.log.SLog;
import com.youku.arch.solid.monitor.DefaultMonitorImpl;
import com.youku.arch.solid.monitor.IMonitor;
import com.youku.arch.solid.util.AbiUtils;
import com.youku.arch.solid.util.LibPathUtil;
import com.youku.arch.solid.util.TimeUtil;
import java.io.File;
import java.util.concurrent.Executor;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class SolidConfig {
    private static transient /* synthetic */ IpChange $ipChange;
    private Application application;
    private IDownloader downloader;
    private Executor executor;
    private String libInstallPath;
    private ILogger logger;
    private IMonitor monitor;
    private boolean openLog;
    private String versionName;
    private long launchTimeMillions = -1;
    private boolean useCompress = true;
    private AbiUtils.AbiType abiType = AbiUtils.AbiType.UN_KNOW;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class Builder {
        private static transient /* synthetic */ IpChange $ipChange;
        private SolidConfig mSolidConfig;

        public Builder(Application application) {
            SolidConfig solidConfig = new SolidConfig();
            this.mSolidConfig = solidConfig;
            solidConfig.application = application;
        }

        public SolidConfig build() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1651187435")) {
                return (SolidConfig) ipChange.ipc$dispatch("-1651187435", new Object[]{this});
            }
            SolidConfig solidConfig = this.mSolidConfig;
            if (solidConfig == null) {
                return null;
            }
            if (solidConfig.launchTimeMillions < 0) {
                this.mSolidConfig.launchTimeMillions = TimeUtil.getCurTimeStamp();
            }
            if (TextUtils.isEmpty(this.mSolidConfig.versionName) && this.mSolidConfig.application != null) {
                try {
                    this.mSolidConfig.versionName = this.mSolidConfig.application.getPackageManager().getPackageInfo(this.mSolidConfig.application.getPackageName(), 0).versionName;
                } catch (Exception unused) {
                    this.mSolidConfig.versionName = "";
                }
            }
            if (this.mSolidConfig.logger != null) {
                SLog.setLogger(this.mSolidConfig.logger);
            } else {
                SLog.setLogger(new DefaultLoggerImpl(this.mSolidConfig.openLog));
            }
            if (this.mSolidConfig.executor == null) {
                this.mSolidConfig.executor = new DefaultExecutor();
            }
            if (this.mSolidConfig.monitor == null) {
                this.mSolidConfig.monitor = new DefaultMonitorImpl();
            }
            if (TextUtils.isEmpty(this.mSolidConfig.libInstallPath)) {
                SolidConfig solidConfig2 = this.mSolidConfig;
                solidConfig2.libInstallPath = LibPathUtil.getDefaultLibPath(solidConfig2.application);
            }
            SolidConfig solidConfig3 = this.mSolidConfig;
            solidConfig3.libInstallPath = this.mSolidConfig.libInstallPath + File.separator + LibPathUtil.getSpaceName(this.mSolidConfig.versionName);
            if (this.mSolidConfig.downloader == null) {
                this.mSolidConfig.downloader = new DefaultDownloaderImpl();
            }
            SolidConfig solidConfig4 = this.mSolidConfig;
            this.mSolidConfig = null;
            return solidConfig4;
        }

        public Builder openLog(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-196218122")) {
                return (Builder) ipChange.ipc$dispatch("-196218122", new Object[]{this, Boolean.valueOf(z)});
            }
            SolidConfig solidConfig = this.mSolidConfig;
            if (solidConfig == null) {
                return this;
            }
            solidConfig.openLog = z;
            return this;
        }

        public Builder setAbiType(AbiUtils.AbiType abiType) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1212452726")) {
                return (Builder) ipChange.ipc$dispatch("1212452726", new Object[]{this, abiType});
            }
            SolidConfig solidConfig = this.mSolidConfig;
            if (solidConfig != null && abiType != null) {
                solidConfig.abiType = abiType;
            }
            return this;
        }

        public Builder setDownloader(IDownloader iDownloader) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1013033004")) {
                return (Builder) ipChange.ipc$dispatch("1013033004", new Object[]{this, iDownloader});
            }
            SolidConfig solidConfig = this.mSolidConfig;
            if (solidConfig != null && iDownloader != null) {
                solidConfig.downloader = iDownloader;
            }
            return this;
        }

        public Builder setExecutor(Executor executor) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-928445991")) {
                return (Builder) ipChange.ipc$dispatch("-928445991", new Object[]{this, executor});
            }
            SolidConfig solidConfig = this.mSolidConfig;
            if (solidConfig != null && executor != null) {
                solidConfig.executor = executor;
            }
            return this;
        }

        public Builder setLaunchTimeMillions(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1386010743")) {
                return (Builder) ipChange.ipc$dispatch("1386010743", new Object[]{this, Long.valueOf(j)});
            }
            SolidConfig solidConfig = this.mSolidConfig;
            if (solidConfig != null && j > 0) {
                solidConfig.launchTimeMillions = j;
            }
            return this;
        }

        public Builder setLibPath(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1227996072")) {
                return (Builder) ipChange.ipc$dispatch("-1227996072", new Object[]{this, str});
            }
            if (this.mSolidConfig != null && str != null && !str.isEmpty()) {
                this.mSolidConfig.libInstallPath = str;
            }
            return this;
        }

        public Builder setLogger(ILogger iLogger) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1161836136")) {
                return (Builder) ipChange.ipc$dispatch("-1161836136", new Object[]{this, iLogger});
            }
            SolidConfig solidConfig = this.mSolidConfig;
            if (solidConfig != null && iLogger != null) {
                solidConfig.logger = iLogger;
            }
            return this;
        }

        public Builder setMonitor(IMonitor iMonitor) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-925920048")) {
                return (Builder) ipChange.ipc$dispatch("-925920048", new Object[]{this, iMonitor});
            }
            SolidConfig solidConfig = this.mSolidConfig;
            if (solidConfig != null && iMonitor != null) {
                solidConfig.monitor = iMonitor;
            }
            return this;
        }

        public Builder setVersionName(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2108519343")) {
                return (Builder) ipChange.ipc$dispatch("-2108519343", new Object[]{this, str});
            }
            if (this.mSolidConfig != null && !TextUtils.isEmpty(str)) {
                this.mSolidConfig.versionName = str;
            }
            return this;
        }

        public Builder useCompress(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1320486041")) {
                return (Builder) ipChange.ipc$dispatch("-1320486041", new Object[]{this, Boolean.valueOf(z)});
            }
            SolidConfig solidConfig = this.mSolidConfig;
            if (solidConfig == null) {
                return this;
            }
            solidConfig.useCompress = z;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbiUtils.AbiType getAbiType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "496707117") ? (AbiUtils.AbiType) ipChange.ipc$dispatch("496707117", new Object[]{this}) : this.abiType;
    }

    public Application getApplication() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1673628206") ? (Application) ipChange.ipc$dispatch("1673628206", new Object[]{this}) : this.application;
    }

    public IDownloader getDownloader() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1162732137") ? (IDownloader) ipChange.ipc$dispatch("-1162732137", new Object[]{this}) : this.downloader;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Executor getExecutor() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "161601998") ? (Executor) ipChange.ipc$dispatch("161601998", new Object[]{this}) : this.executor;
    }

    public long getLaunchTimeMillions() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1936604984") ? ((Long) ipChange.ipc$dispatch("-1936604984", new Object[]{this})).longValue() : this.launchTimeMillions;
    }

    public String getLibInstallPath() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1010688736") ? (String) ipChange.ipc$dispatch("-1010688736", new Object[]{this}) : this.libInstallPath;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IMonitor getMonitor() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2004270999") ? (IMonitor) ipChange.ipc$dispatch("2004270999", new Object[]{this}) : this.monitor;
    }

    public String getVersionName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "367611348") ? (String) ipChange.ipc$dispatch("367611348", new Object[]{this}) : this.versionName;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getZipPath() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1174341815")) {
            return (String) ipChange.ipc$dispatch("1174341815", new Object[]{this});
        }
        return this.libInstallPath + File.separator + "zip";
    }

    public boolean isOpenLog() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-908770139") ? ((Boolean) ipChange.ipc$dispatch("-908770139", new Object[]{this})).booleanValue() : this.openLog;
    }

    public void setDownloader(IDownloader iDownloader) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-796135705")) {
            ipChange.ipc$dispatch("-796135705", new Object[]{this, iDownloader});
        } else {
            this.downloader = iDownloader;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean useCompress() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-287569652") ? ((Boolean) ipChange.ipc$dispatch("-287569652", new Object[]{this})).booleanValue() : this.useCompress;
    }
}
