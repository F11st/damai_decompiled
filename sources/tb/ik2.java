package tb;

import android.app.Application;
import android.content.Context;
import cn.damai.common.AppConfig;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.tlog.message.TLogTaobaoMessage;
import com.taobao.android.tlog.uploader.TLogUploader;
import com.taobao.tao.log.LogLevel;
import com.taobao.tao.log.TLogInitializer;
import com.taobao.tlog.remote.TLogConfigSwitchReceiver;
import com.taobao.tlog.remote.TLogRemoteMonitor;
import com.ut.device.UTDevice;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class ik2 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static String a = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCPmw8R0nmonh3CIwJykLffiU3di50hE/P9cbNmP8OtV3cQn3mA/HWK1AKoWv6J9fFdqo1xcTW7Mb9Njb4TzWJAhn41mZyr5vUiUKKQkIRIhf0FmSD6G8p6W0J1rU6qvKLspVnTg5Sp4wLVCjg1M00W09w0cUVimZ/dXkOiWbHsowIDAQAB";

    public static void a(Context context, Application application, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-307066635")) {
            ipChange.ipc$dispatch("-307066635", new Object[]{context, application, str});
            return;
        }
        try {
            LogLevel logLevel = LogLevel.E;
            String g = wh2.g(32);
            TLogInitializer.getInstance().accsServiceId = "ha-remote-debug";
            TLogInitializer.getInstance().ossBucketName = "motu-debug-log";
            TLogInitializer.getInstance().changeRsaPublishKey(a);
            TLogInitializer.getInstance().builder(context, logLevel, "logs", str, AppConfig.c(), AppConfig.q()).setApplication(application).setSecurityKey(g).setUserNick(z20.E()).setUtdid(UTDevice.getUtdid(context)).init();
            TLogInitializer.getInstance().setLogUploader(new TLogUploader());
            TLogInitializer.getInstance().setMessageSender(new TLogTaobaoMessage());
            TLogConfigSwitchReceiver.init(context);
            TLogRemoteMonitor tLogRemoteMonitor = new TLogRemoteMonitor();
            tLogRemoteMonitor.init(context);
            TLogInitializer.getInstance().settLogMonitor(tLogRemoteMonitor);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void b(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1371146266")) {
            ipChange.ipc$dispatch("-1371146266", new Object[]{str});
        } else {
            TLogInitializer.getInstance().setUserNick(str);
        }
    }
}
