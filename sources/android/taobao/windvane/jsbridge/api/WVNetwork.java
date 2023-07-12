package android.taobao.windvane.jsbridge.api;

import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.taobao.windvane.config.WVCommonConfig;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import anet.channel.status.NetworkStatusHelper;
import com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager;
import com.taomai.android.h5container.api.TMNetworkPlugin;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class WVNetwork extends WVApiPlugin {
    public static final int NETWORK_TYPE_IWLAN = 18;
    public static final int NETWORK_TYPE_LTE_CA = 19;
    public static final int NETWORK_TYPE_TD_SCDMA = 17;
    private final int NETWORK_TYPE_GPRS = 1;
    private final int NETWORK_TYPE_EDGE = 2;
    private final int NETWORK_TYPE_UMTS = 3;
    private final int NETWORK_TYPE_CDMA = 4;
    private final int NETWORK_TYPE_EVDO_0 = 5;
    private final int NETWORK_TYPE_EVDO_A = 6;
    private final int NETWORK_TYPE_1xRTT = 7;
    private final int NETWORK_TYPE_HSDPA = 8;
    private final int NETWORK_TYPE_HSUPA = 9;
    private final int NETWORK_TYPE_HSPA = 10;
    private final int NETWORK_TYPE_IDEN = 11;
    private final int NETWORK_TYPE_EVDO_B = 12;
    private final int NETWORK_TYPE_LTE = 13;
    private final int NETWORK_TYPE_EHRPD = 14;
    private final int NETWORK_TYPE_HSPAP = 15;
    private final int NETWORK_TYPE_GSM = 16;
    private final int NETWORK_TYPE_NR = 20;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: android.taobao.windvane.jsbridge.api.WVNetwork$1  reason: invalid class name */
    /* loaded from: classes12.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$anet$channel$status$NetworkStatusHelper$NetworkStatus;

        static {
            int[] iArr = new int[NetworkStatusHelper.NetworkStatus.values().length];
            $SwitchMap$anet$channel$status$NetworkStatusHelper$NetworkStatus = iArr;
            try {
                iArr[NetworkStatusHelper.NetworkStatus.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$anet$channel$status$NetworkStatusHelper$NetworkStatus[NetworkStatusHelper.NetworkStatus.NO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$anet$channel$status$NetworkStatusHelper$NetworkStatus[NetworkStatusHelper.NetworkStatus.G2.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$anet$channel$status$NetworkStatusHelper$NetworkStatus[NetworkStatusHelper.NetworkStatus.G3.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$anet$channel$status$NetworkStatusHelper$NetworkStatus[NetworkStatusHelper.NetworkStatus.G4.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$anet$channel$status$NetworkStatusHelper$NetworkStatus[NetworkStatusHelper.NetworkStatus.WIFI.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$anet$channel$status$NetworkStatusHelper$NetworkStatus[NetworkStatusHelper.NetworkStatus.G5.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    private boolean getNetworkInfoBySystem(WVCallBackContext wVCallBackContext, WVResult wVResult) {
        NetworkInfo networkInfo;
        try {
            networkInfo = ConnectivityManager.getActiveNetworkInfo((android.net.ConnectivityManager) this.mContext.getSystemService("connectivity"));
        } catch (Throwable th) {
            wVResult.addData("msg", th.getMessage());
            wVCallBackContext.error(wVResult);
            networkInfo = null;
        }
        if (networkInfo == null) {
            wVResult.addData("type", "NONE");
            wVCallBackContext.success(wVResult);
            return false;
        } else if (networkInfo.getType() == 1) {
            wVResult.addData("type", "WIFI");
            wVCallBackContext.success(wVResult);
            return false;
        } else {
            switch (networkInfo.getSubtype()) {
                case 1:
                    wVResult.addData("message", "GPRS");
                    wVResult.addData("type", "2G");
                    break;
                case 2:
                    wVResult.addData("message", "EDGE");
                    wVResult.addData("type", "2G");
                    break;
                case 3:
                    wVResult.addData("message", "UMTS");
                    wVResult.addData("type", "3G");
                    break;
                case 4:
                    wVResult.addData("message", "CDMA");
                    wVResult.addData("type", "2G");
                    break;
                case 5:
                    wVResult.addData("message", "EVDO_0");
                    wVResult.addData("type", "3G");
                    break;
                case 6:
                    wVResult.addData("message", "EVDO_A");
                    wVResult.addData("type", "3G");
                    break;
                case 7:
                    wVResult.addData("message", "1xRTT");
                    wVResult.addData("type", "2G");
                    break;
                case 8:
                    wVResult.addData("message", "HSDPA");
                    wVResult.addData("type", "3G");
                    break;
                case 9:
                    wVResult.addData("message", "HSUPA");
                    wVResult.addData("type", "3G");
                    break;
                case 10:
                    wVResult.addData("message", "HSPA");
                    wVResult.addData("type", "3G");
                    break;
                case 11:
                    wVResult.addData("message", "IDEN");
                    wVResult.addData("type", "2G");
                    break;
                case 12:
                    wVResult.addData("message", "EVDO_B");
                    wVResult.addData("type", "3G");
                    break;
                case 13:
                    wVResult.addData("message", "LTE");
                    wVResult.addData("type", "4G");
                    break;
                case 14:
                    wVResult.addData("message", "EHRPD");
                    wVResult.addData("type", "3G");
                    break;
                case 15:
                    wVResult.addData("message", "HSPAP");
                    wVResult.addData("type", "3G");
                    break;
                case 16:
                    WVCommonConfig.getInstance();
                    if (WVCommonConfig.commonConfig.open5GAdapter) {
                        wVResult.addData("message", "GSM");
                        wVResult.addData("type", "2G");
                        break;
                    }
                case 17:
                    WVCommonConfig.getInstance();
                    if (WVCommonConfig.commonConfig.open5GAdapter) {
                        wVResult.addData("message", "TD_SCDMA");
                        wVResult.addData("type", "3G");
                        break;
                    }
                case 18:
                    WVCommonConfig.getInstance();
                    if (WVCommonConfig.commonConfig.open5GAdapter) {
                        wVResult.addData("message", "IWLAN");
                        wVResult.addData("type", "WIFI");
                        break;
                    }
                case 19:
                    WVCommonConfig.getInstance();
                    if (WVCommonConfig.commonConfig.open5GAdapter) {
                        wVResult.addData("message", "LTE_CA");
                        wVResult.addData("type", "4G");
                        break;
                    }
                case 20:
                    WVCommonConfig.getInstance();
                    if (WVCommonConfig.commonConfig.open5GAdapter) {
                        wVResult.addData("message", "NR");
                        wVResult.addData("type", "5G");
                        break;
                    }
                default:
                    wVResult.addData("type", "UNKNOWN");
                    break;
            }
            return true;
        }
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        if (TMNetworkPlugin.ACTION_NETWORK.equals(str)) {
            getNetworkType(str2, wVCallBackContext);
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0028 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x005e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void getNetworkType(java.lang.String r11, android.taobao.windvane.jsbridge.WVCallBackContext r12) {
        /*
            Method dump skipped, instructions count: 294
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.taobao.windvane.jsbridge.api.WVNetwork.getNetworkType(java.lang.String, android.taobao.windvane.jsbridge.WVCallBackContext):void");
    }

    public StringBuffer lookUpScan(List<ScanResult> list) {
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (i < list.size()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Index_");
            int i2 = i + 1;
            sb.append(new Integer(i2).toString());
            sb.append(":");
            stringBuffer.append(sb.toString());
            stringBuffer.append(list.get(i).SSID.toString());
            stringBuffer.append(StringUtils.LF);
            i = i2;
        }
        return stringBuffer;
    }
}
