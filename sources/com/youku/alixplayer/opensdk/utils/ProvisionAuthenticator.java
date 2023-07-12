package com.youku.alixplayer.opensdk.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.drm.DrmInfo;
import android.drm.DrmInfoRequest;
import android.drm.DrmManagerClient;
import android.media.MediaDrm;
import android.media.NotProvisionedException;
import android.media.ResourceBusyException;
import android.media.UnsupportedSchemeException;
import android.os.Build;
import android.util.Log;
import com.taobao.android.dinamicx.widget.DXRecyclerLayout;
import com.youku.alixplayer.opensdk.drm.DrmType;
import com.youku.media.arch.instruments.ConfigFetcher;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ProvisionAuthenticator {
    private static final String PROVISION_URL = "https://www.googleapis.cn/certificateprovisioning/v1/devicecertificates/create";
    private static final String TAG = "ProvisionAuthenticator";
    private static boolean sPermanentDisableWidevine;
    private static final UUID WIDEVINE_UUID = new UUID(-1301668207276963122L, -6645017420763422227L);
    private static boolean sIsProvisioned = false;
    private static boolean sCencSupported = false;
    private static boolean sCbcsSupported = false;
    private static WidevineLevel sWidevineLevel = WidevineLevel.L3;
    private static int sWidevineStatus = 0;
    private static boolean sHasChecked = false;
    private static MediaDrm mMediaDrm = null;
    private static ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public enum DrmSupport {
        WV_SUPPORT_L1,
        WV_SUPPORT_L2,
        WV_SUPPORT_L3,
        WV_NO_PLUGIN,
        WV_PROVISION,
        WV_OS_VERSION,
        WV_CODEC_LIST,
        WV_BLACK_LIST,
        WV_CODEC_ERROR;

        int getBit() {
            return 1 << ordinal();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public enum WidevineLevel {
        L1,
        L2,
        L3;

        int getBit() {
            return 1 << ordinal();
        }
    }

    public static void checkProvision() {
        if (sHasChecked) {
            return;
        }
        sHasChecked = true;
        fixedThreadPool.execute(new Runnable() { // from class: com.youku.alixplayer.opensdk.utils.ProvisionAuthenticator.1
            @Override // java.lang.Runnable
            public void run() {
                Logger.d(ProvisionAuthenticator.TAG, "start checkProvision");
                ProvisionAuthenticator.checkWideVine();
                ProvisionAuthenticator.checkWideVineLevel();
                boolean unused = ProvisionAuthenticator.sCencSupported = ProvisionAuthenticator.isWidevineDrmSupported(DrmType.WV_CENC);
                boolean unused2 = ProvisionAuthenticator.sCbcsSupported = ProvisionAuthenticator.isWidevineDrmSupported(DrmType.WV_CBCS);
                ProvisionAuthenticator.checkWidevineStatus();
                Logger.d(ProvisionAuthenticator.TAG, "end checkProvision");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(19)
    public static void checkWideVine() {
        if (Build.VERSION.SDK_INT < 18) {
            return;
        }
        try {
            MediaDrm mediaDrm = new MediaDrm(WIDEVINE_UUID);
            mMediaDrm = mediaDrm;
            byte[] openSession = mediaDrm.openSession();
            if (openSession != null) {
                mMediaDrm.closeSession(openSession);
                sIsProvisioned = true;
            }
        } catch (NotProvisionedException unused) {
            Logger.d("checkWideVine NotProvisionedException");
            try {
                doProvision();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (ResourceBusyException unused2) {
            Logger.d("checkWideVine ResourceBusyException");
        } catch (UnsupportedSchemeException unused3) {
            Logger.d("checkWideVine UnsupportedSchemeException");
        } catch (Throwable unused4) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void checkWideVineLevel() {
        try {
            MediaDrm mediaDrm = new MediaDrm(WIDEVINE_UUID);
            sWidevineLevel = WidevineLevel.valueOf(mediaDrm.getPropertyString("securityLevel"));
            mediaDrm.release();
        } catch (UnsupportedSchemeException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
        } catch (Throwable unused) {
        }
        Logger.d("WIDEVINE_DETECT", "widevine level:" + sWidevineLevel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void checkWidevineStatus() {
        sWidevineStatus |= getWidevineLevel().getBit();
        if (!hardwareRendererSupported()) {
            sWidevineStatus |= DrmSupport.WV_CODEC_LIST.getBit();
        }
        int i = Build.VERSION.SDK_INT;
        if (i < 18 || !MediaDrm.isCryptoSchemeSupported(WIDEVINE_UUID)) {
            sWidevineStatus |= DrmSupport.WV_NO_PLUGIN.getBit();
        }
        if (!isProvisioned()) {
            sWidevineStatus |= DrmSupport.WV_PROVISION.getBit();
        }
        if (i <= 19) {
            sWidevineStatus |= DrmSupport.WV_OS_VERSION.getBit();
        }
        if (isInBlackList()) {
            sWidevineStatus |= DrmSupport.WV_BLACK_LIST.getBit();
        }
        if (isWidevinePermanentDisabled()) {
            sWidevineStatus |= DrmSupport.WV_CODEC_ERROR.getBit();
        }
    }

    @TargetApi(19)
    private static void doProvision() {
        Logger.d("doProvision");
        byte[] doQuest = doQuest(true);
        if (doQuest == null) {
            doQuest = doQuest(false);
        }
        if (doQuest != null) {
            try {
                mMediaDrm.provideProvisionResponse(doQuest);
                sIsProvisioned = true;
            } catch (Throwable th) {
                Logger.d("doProvision exception=" + th.getMessage());
            }
        }
    }

    @TargetApi(19)
    private static byte[] doQuest(boolean z) {
        MediaDrm.ProvisionRequest provisionRequest;
        HttpURLConnection httpURLConnection;
        String str;
        HttpURLConnection httpURLConnection2;
        int indexOf;
        HttpURLConnection httpURLConnection3 = null;
        byte[] bArr = null;
        try {
            String defaultUrl = mMediaDrm.getProvisionRequest().getDefaultUrl();
            if (z) {
                if (defaultUrl.indexOf(63) > 0) {
                    str = (PROVISION_URL + defaultUrl.substring(indexOf)) + '&';
                } else {
                    str = PROVISION_URL + jn1.CONDITION_IF;
                }
            } else {
                str = defaultUrl + "&";
            }
            httpURLConnection2 = (HttpURLConnection) new URL(str + "signedRequest=" + new String(provisionRequest.getData(), "UTF-8")).openConnection();
        } catch (Exception e) {
            e = e;
            httpURLConnection = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            httpURLConnection2.setRequestMethod("POST");
            httpURLConnection2.setDoOutput(true);
            httpURLConnection2.setUseCaches(false);
            httpURLConnection2.setConnectTimeout(5000);
            httpURLConnection2.connect();
            bArr = httpURLConnection2.getResponseCode() == 200 ? inputStreamTOByte(httpURLConnection2.getInputStream()) : null;
            httpURLConnection2.disconnect();
        } catch (Exception e2) {
            httpURLConnection = httpURLConnection2;
            e = e2;
            try {
                e.printStackTrace();
                httpURLConnection.disconnect();
                return bArr;
            } catch (Throwable th2) {
                th = th2;
                httpURLConnection3 = httpURLConnection;
                httpURLConnection3.disconnect();
                throw th;
            }
        } catch (Throwable th3) {
            httpURLConnection3 = httpURLConnection2;
            th = th3;
            httpURLConnection3.disconnect();
            throw th;
        }
        return bArr;
    }

    @TargetApi(18)
    public static WidevineLevel getWidevineLevel() {
        return sWidevineLevel;
    }

    public static int getWidevineStats() {
        return sWidevineStatus;
    }

    private static boolean hardwareRendererSupported() {
        return "HW".equals(ConfigFetcher.getInstance().getConfig("player_config", "decode_mode", "HW"));
    }

    private static byte[] inputStreamTOByte(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[20480];
        while (true) {
            int read = inputStream.read(bArr, 0, 20480);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public static boolean isCbcsSupported() {
        return sCbcsSupported && !sPermanentDisableWidevine;
    }

    public static boolean isCencSupported() {
        return sCencSupported && !sPermanentDisableWidevine;
    }

    public static boolean isInBlackList() {
        return "1".equals(ConfigFetcher.getInstance().getConfig("widevine_config", "widevine_blacklist", "0"));
    }

    public static boolean isProvisioned() {
        return sIsProvisioned;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(18)
    public static boolean isWidevineDrmSupported(DrmType drmType) {
        int i;
        if (!isInBlackList() && (i = Build.VERSION.SDK_INT) >= 18 && hardwareRendererSupported() && MediaDrm.isCryptoSchemeSupported(WIDEVINE_UUID) && isProvisioned()) {
            return drmType == DrmType.WV_CENC ? i >= 21 : drmType == DrmType.WV_CBCS && i >= 25;
        }
        return false;
    }

    public static boolean isWidevineL1(Context context) {
        Object obj;
        int i = -1;
        try {
            DrmInfo acquireDrmInfo = new DrmManagerClient(context).acquireDrmInfo(new DrmInfoRequest(1, DXRecyclerLayout.LOAD_MORE_EMPTY));
            if (acquireDrmInfo != null && (obj = acquireDrmInfo.get("WVDrmInfoRequestStatusKey")) != null) {
                i = Integer.parseInt((String) obj);
            }
        } catch (ClassCastException e) {
            e.printStackTrace();
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("widevine Level 1 support:");
        sb.append(i == 0 ? "true" : "false");
        Log.d("WIDEVINE_DETECT", sb.toString());
        return i == 0;
    }

    public static boolean isWidevinePermanentDisabled() {
        return sPermanentDisableWidevine;
    }

    public static void setPermanentDisableWidevine(boolean z) {
        sPermanentDisableWidevine = z;
    }
}
