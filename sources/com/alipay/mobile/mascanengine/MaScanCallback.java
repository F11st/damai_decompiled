package com.alipay.mobile.mascanengine;

import com.alipay.mobile.bqcscanservice.BQCScanEngine;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public interface MaScanCallback extends BQCScanEngine.EngineCallback {

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class MaScanResultType {
        public static final int MA_SCAN_RESULT_BLACK = 1;
        public static final int MA_SCAN_RESULT_NOT_BLACK = 2;
        public static final int MA_SCAN_RESULT_NULL = 0;
    }

    boolean onMaCodeInterceptor(List<String> list);

    void onResultMa(MultiMaScanResult multiMaScanResult);

    void onScanResultType(int i, MultiMaScanResult multiMaScanResult);
}
