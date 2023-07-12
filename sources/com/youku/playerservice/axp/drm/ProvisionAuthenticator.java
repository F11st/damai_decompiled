package com.youku.playerservice.axp.drm;

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
import com.youku.media.arch.instruments.ConfigFetcher;
import com.youku.playerservice.axp.item.DrmType;
import com.youku.playerservice.axp.utils.TLogUtil;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class ProvisionAuthenticator {
    private static final String PROVISION_URL = "https://www.googleapis.cn/certificateprovisioning/v1/devicecertificates/create";
    private static boolean sCbcsSupported;
    private static boolean sCencSupported;
    private static boolean sIsProvisioned;
    private static boolean sPermanentDisableWidevine;
    private static WidevineLevel sWidevineLevel = WidevineLevel.L3;
    private static int sWidevineStatus = 0;
    private static boolean sHasChecked = false;
    private static MediaDrm mMediaDrm = null;
    private static ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);
    private static final UUID WIDEVINE_UUID = new UUID(-1301668207276963122L, -6645017420763422227L);
    private static final UUID WISEPLAY_UUID = new UUID(4422091961135677928L, -5169044695670406100L);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public enum DrmSupport {
        WV_SUPPORT_L1,
        WV_SUPPORT_L2,
        WV_SUPPORT_L3,
        WV_NO_PLUGIN,
        WV_PROVISION,
        WV_OS_VERSION,
        WV_CODEC_LIST,
        WV_BLACK_LIST,
        WV_CODEC_ERROR,
        WS_SUPPORT;

        int getBit() {
            return 1 << ordinal();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
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
        fixedThreadPool.execute(new Runnable() { // from class: com.youku.playerservice.axp.drm.ProvisionAuthenticator.1
            @Override // java.lang.Runnable
            public void run() {
                TLogUtil.playLog("start checkProvision");
                ProvisionAuthenticator.checkWideVine();
                ProvisionAuthenticator.checkWideVineLevel();
                boolean unused = ProvisionAuthenticator.sCencSupported = ProvisionAuthenticator.isWidevineDrmSupported(DrmType.WV_CENC);
                boolean unused2 = ProvisionAuthenticator.sCbcsSupported = ProvisionAuthenticator.isWidevineDrmSupported(DrmType.WV_CBCS);
                ProvisionAuthenticator.checkWidevineStatus();
                TLogUtil.playLog("end checkProvision");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(19)
    public static void checkWideVine() {
        String str;
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
            TLogUtil.playLog("checkWideVine NotProvisionedException");
            try {
                doProvision();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (ResourceBusyException unused2) {
            str = "checkWideVine ResourceBusyException";
            TLogUtil.playLog(str);
        } catch (UnsupportedSchemeException unused3) {
            str = "checkWideVine UnsupportedSchemeException";
            TLogUtil.playLog(str);
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void checkWidevineStatus() {
        sWidevineStatus |= getWidevineLevel().getBit();
        if (!hardwareRendererSupported()) {
            sWidevineStatus |= DrmSupport.WV_CODEC_LIST.getBit();
        }
        int i = Build.VERSION.SDK_INT;
        if (i < 18 || !isCryptoSchemeSupported(WIDEVINE_UUID)) {
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
        if (isSupportWisePlay()) {
            sWidevineStatus |= DrmSupport.WS_SUPPORT.getBit();
        }
    }

    @TargetApi(19)
    private static void doProvision() {
        TLogUtil.playLog("doProvision");
        byte[] doQuest = doQuest(true);
        if (doQuest == null) {
            doQuest = doQuest(false);
        }
        if (doQuest != null) {
            try {
                mMediaDrm.provideProvisionResponse(doQuest);
                sIsProvisioned = true;
            } catch (Throwable th) {
                TLogUtil.playLog("doProvision exception=" + th.getMessage());
            }
        }
    }

    @TargetApi(19)
    private static byte[] doQuest(boolean z) {
        MediaDrm.ProvisionRequest provisionRequest;
        HttpURLConnection httpURLConnection;
        String str;
        int indexOf;
        StringBuilder sb;
        HttpURLConnection httpURLConnection2 = null;
        byte[] bArr = null;
        try {
            String defaultUrl = mMediaDrm.getProvisionRequest().getDefaultUrl();
            if (z) {
                if (defaultUrl.indexOf(63) > 0) {
                    String str2 = PROVISION_URL + defaultUrl.substring(indexOf);
                    sb = new StringBuilder();
                    sb.append(str2);
                    sb.append('&');
                } else {
                    sb = new StringBuilder();
                    sb.append(PROVISION_URL);
                    sb.append(jn1.CONDITION_IF);
                }
                str = sb.toString();
            } else {
                str = defaultUrl + "&";
            }
            HttpURLConnection httpURLConnection3 = (HttpURLConnection) new URL(str + "signedRequest=" + new String(provisionRequest.getData(), "UTF-8")).openConnection();
            try {
                httpURLConnection3.setRequestMethod("POST");
                httpURLConnection3.setDoOutput(true);
                httpURLConnection3.setUseCaches(false);
                httpURLConnection3.setConnectTimeout(5000);
                httpURLConnection3.connect();
                bArr = httpURLConnection3.getResponseCode() == 200 ? inputStreamTOByte(httpURLConnection3.getInputStream()) : null;
                httpURLConnection3.disconnect();
            } catch (Exception e) {
                httpURLConnection = httpURLConnection3;
                e = e;
                try {
                    e.printStackTrace();
                    httpURLConnection.disconnect();
                    return bArr;
                } catch (Throwable th) {
                    th = th;
                    httpURLConnection2 = httpURLConnection;
                    httpURLConnection2.disconnect();
                    throw th;
                }
            } catch (Throwable th2) {
                httpURLConnection2 = httpURLConnection3;
                th = th2;
                httpURLConnection2.disconnect();
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            httpURLConnection = null;
        } catch (Throwable th3) {
            th = th3;
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

    private static byte[] inputStreamTOByte(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[20480];
        while (true) {
            int read = inputStream.read(bArr, 0, 20480);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public static boolean isCbcsSupported() {
        return sCbcsSupported && !sPermanentDisableWidevine;
    }

    public static boolean isCencSupported() {
        return sCencSupported && !sPermanentDisableWidevine;
    }

    @TargetApi(18)
    private static boolean isCryptoSchemeSupported(UUID uuid) {
        try {
            return MediaDrm.isCryptoSchemeSupported(uuid);
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static boolean isInBlackList() {
        return "1".equals(ConfigFetcher.getInstance().getConfig("widevine_config", "widevine_blacklist", "0"));
    }

    public static boolean isProvisioned() {
        return sIsProvisioned;
    }

    public static boolean isSupportWisePlay() {
        String str;
        UUID uuid = WISEPLAY_UUID;
        boolean z = false;
        if (isCryptoSchemeSupported(uuid)) {
            try {
                MediaDrm mediaDrm = new MediaDrm(uuid);
                z = true;
                mediaDrm.closeSession(mediaDrm.openSession());
                mediaDrm.release();
            } catch (NotProvisionedException unused) {
                str = "checkWisePlay NotProvisionedException";
                TLogUtil.playLog(str);
            } catch (ResourceBusyException unused2) {
                str = "checkWisePlay ResourceBusyException";
                TLogUtil.playLog(str);
            } catch (UnsupportedSchemeException unused3) {
                str = "checkWisePlay UnsupportedSchemeException";
                TLogUtil.playLog(str);
            } catch (Throwable unused4) {
            }
        }
        TLogUtil.playLog("isSupportWisePlay " + z);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(18)
    public static boolean isWidevineDrmSupported(DrmType drmType) {
        int i;
        if (!isInBlackList() && (i = Build.VERSION.SDK_INT) >= 18 && hardwareRendererSupported() && isCryptoSchemeSupported(WIDEVINE_UUID) && isProvisioned()) {
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
