package com.youku.ntpsync;

import android.util.Log;
import com.youku.media.arch.instruments.ConfigFetcher;
import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketException;
import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.TimeInfo;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class NtpSyncUtils {
    private static final String DEFAULT_NTP_SERVER = "ntp6.aliyun.com";
    private static long NTPOffset = 0;
    private static final String TAG = "NtpSyncUtils";
    private static boolean isSyncDone;

    public static long getOffset() {
        if (!isSyncDone) {
            startNTPSync();
        }
        return NTPOffset;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long query(String str) throws IOException, SocketException {
        NTPUDPClient nTPUDPClient = new NTPUDPClient();
        nTPUDPClient.setDefaultTimeout(10000);
        try {
            nTPUDPClient.open();
            InetAddress byName = InetAddress.getByName(str);
            Log.d(TAG, "Trying to get time from " + byName.getHostName() + "/" + byName.getHostAddress());
            TimeInfo time = nTPUDPClient.getTime(byName);
            nTPUDPClient.close();
            time.computeDetails();
            return time.getOffset().longValue();
        } catch (Throwable th) {
            nTPUDPClient.close();
            throw th;
        }
    }

    public static void startNTPSync() {
        if (isSyncDone) {
            return;
        }
        new Thread(new Runnable() { // from class: com.youku.ntpsync.NtpSyncUtils.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    long unused = NtpSyncUtils.NTPOffset = NtpSyncUtils.query(ConfigFetcher.getInstance().getConfig("ntp_server_config", "ntp_server_host", NtpSyncUtils.DEFAULT_NTP_SERVER));
                    boolean unused2 = NtpSyncUtils.isSyncDone = true;
                } catch (Exception unused3) {
                    Log.e(NtpSyncUtils.TAG, "query ntpserver error");
                }
            }
        }).start();
    }
}
