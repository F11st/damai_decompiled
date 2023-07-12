package com.ali.user.mobile.login.presenter;

import com.ali.user.mobile.rpc.login.model.WSecurityData;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class ScanFaceWSecurityData extends WSecurityData {
    public String deviceBrand;
    public String deviceModel;
    public String deviceName;
    public ExtRiskData extRiskData;

    public ScanFaceWSecurityData() {
        String brand = Build.getBRAND();
        this.deviceBrand = brand;
        String model = Build.getMODEL();
        this.deviceModel = model;
        this.deviceName = brand + jn1.BRACKET_START_STR + model + jn1.BRACKET_END_STR;
    }
}
