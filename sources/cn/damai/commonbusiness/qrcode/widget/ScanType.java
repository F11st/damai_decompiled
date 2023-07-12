package cn.damai.commonbusiness.qrcode.widget;

import android.text.TextUtils;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public enum ScanType {
    SCAN_MA("MA");
    
    private String value;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.qrcode.widget.ScanType$a */
    /* loaded from: classes4.dex */
    static /* synthetic */ class C0791a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ScanType.values().length];
            a = iArr;
            try {
                iArr[ScanType.SCAN_MA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    ScanType(String str) {
        this.value = str;
    }

    public static ScanType getType(String str) {
        ScanType[] values;
        for (ScanType scanType : values()) {
            if (TextUtils.equals(scanType.value, str)) {
                return scanType;
            }
        }
        return SCAN_MA;
    }

    public String toBqcScanType() {
        int i = C0791a.a[ordinal()];
        return "MA";
    }
}
