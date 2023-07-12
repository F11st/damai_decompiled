package com.youku.uplayer;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.TelephonyManager;
import com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager;
import com.youku.e.C7901a;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class SystemInfoWrap {
    public static final int NET_2G = 2;
    public static final int NET_3G = 3;
    public static final int NET_4G = 4;
    public static final int NET_NONE = 0;
    public static final int NET_WIFI = 1;

    @TargetApi(18)
    public static int getDbmForCellInfoWcdma(CellInfo cellInfo, int i) {
        return cellInfo instanceof CellInfoWcdma ? ((CellInfoWcdma) cellInfo).getCellSignalStrength().getDbm() : i;
    }

    public static int getMobileNetDbm() {
        List<CellInfo> allCellInfo;
        Context context = C7901a.a;
        int i = 1;
        if (context == null) {
            return 1;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (Build.VERSION.SDK_INT >= 17 && (allCellInfo = com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager.getAllCellInfo(telephonyManager)) != null) {
                for (CellInfo cellInfo : allCellInfo) {
                    if (cellInfo instanceof CellInfoGsm) {
                        i = ((CellInfoGsm) cellInfo).getCellSignalStrength().getDbm();
                    } else if (cellInfo instanceof CellInfoCdma) {
                        i = ((CellInfoCdma) cellInfo).getCellSignalStrength().getDbm();
                    } else if (cellInfo instanceof CellInfoLte) {
                        i = ((CellInfoLte) cellInfo).getCellSignalStrength().getDbm();
                    } else if (Build.VERSION.SDK_INT >= 18) {
                        i = getDbmForCellInfoWcdma(cellInfo, i);
                    }
                }
            }
        } catch (SecurityException | Exception unused) {
        }
        return i;
    }

    @SuppressLint({"MissingPermission"})
    public static int getNetType() {
        Context context = C7901a.a;
        if (context == null) {
            return -1;
        }
        try {
            NetworkInfo activeNetworkInfo = ConnectivityManager.getActiveNetworkInfo((android.net.ConnectivityManager) context.getSystemService("connectivity"));
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected()) {
                int type = activeNetworkInfo.getType();
                if (type == 1) {
                    return 1;
                }
                if (type == 0) {
                    TelephonyManager telephonyManager = (TelephonyManager) C7901a.a.getSystemService("phone");
                    return getNetworkClassByType(Build.VERSION.SDK_INT < 30 ? com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager.getNetworkType(telephonyManager) : com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager.getDataNetworkType(telephonyManager));
                }
                return -1;
            }
            return 0;
        } catch (Exception unused) {
            return -1;
        }
    }

    private static int getNetworkClassByType(int i) {
        switch (i) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return 2;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return 3;
            case 13:
            default:
                return 4;
        }
    }

    public static int getSimOperatorInfo() {
        Context context = C7901a.a;
        if (context == null) {
            return -1;
        }
        try {
            String simOperator = com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager.getSimOperator((TelephonyManager) context.getSystemService("phone"));
            if (simOperator != null) {
                if (!simOperator.equals("46000") && !simOperator.equals("46002") && !simOperator.equals("46007")) {
                    if (simOperator.equals("46001")) {
                        return 3;
                    }
                    if (simOperator.equals("46003")) {
                        return 2;
                    }
                }
                return 1;
            }
        } catch (Exception unused) {
        }
        return -1;
    }

    public static int getWifiSignalStrength() {
        Context context = C7901a.a;
        if (context == null) {
            return 1;
        }
        try {
            return ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getRssi();
        } catch (Exception unused) {
            return 1;
        }
    }
}
