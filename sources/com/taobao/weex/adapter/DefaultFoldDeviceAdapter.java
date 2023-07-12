package com.taobao.weex.adapter;

import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.taobao.weex.utils.WXLogUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DefaultFoldDeviceAdapter implements IWXFoldDeviceAdapter {
    private static final String HUAWEI_BRAND = "HUAWEI";
    private static final List<String> HUAWEI_FOLD_DEVICES = new ArrayList<String>() { // from class: com.taobao.weex.adapter.DefaultFoldDeviceAdapter.1
        {
            add("unknownRLI");
            add("HWTAH");
            add("MRX-AL09");
            add("HWMRX");
            add("TAH-AN00m");
            add("HWTAH-C");
            add("RHA-AN00m");
            add("unknownRHA");
        }
    };
    private static final String SAMSUNG_BRAND = "samsung";
    private static final String TAG = "TBDeviceUtils";

    @Override // com.taobao.weex.adapter.IWXFoldDeviceAdapter
    public boolean isFoldDevice() {
        String brand = Build.getBRAND();
        if (SAMSUNG_BRAND.equalsIgnoreCase(brand) && TextUtils.equals("SM-F9000", Build.getMODEL())) {
            return true;
        }
        if (HUAWEI_BRAND.equalsIgnoreCase(brand) && HUAWEI_FOLD_DEVICES.contains(android.os.Build.DEVICE)) {
            WXLogUtils.e(TAG, "is HUAWEI Fold Device");
            return true;
        }
        return false;
    }

    @Override // com.taobao.weex.adapter.IWXFoldDeviceAdapter
    public boolean isGalaxyFold() {
        return SAMSUNG_BRAND.equalsIgnoreCase(Build.getBRAND()) && "SM-F9000".equalsIgnoreCase(Build.getMODEL());
    }

    @Override // com.taobao.weex.adapter.IWXFoldDeviceAdapter
    public boolean isMateX() {
        if (HUAWEI_BRAND.equalsIgnoreCase(Build.getBRAND()) && HUAWEI_FOLD_DEVICES.contains(android.os.Build.DEVICE)) {
            WXLogUtils.e(TAG, "is HUAWEI Fold Device");
            return true;
        }
        return false;
    }
}
