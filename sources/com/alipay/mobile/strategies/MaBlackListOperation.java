package com.alipay.mobile.strategies;

import android.text.TextUtils;
import com.alipay.ma.MaBuryRecord;
import com.alipay.ma.MaLogger;
import com.alipay.ma.strategies.MaInterceptOperation;
import com.alipay.ma.util.StringEncodeUtils;
import com.alipay.mobile.mascanengine.MaScanResult;
import com.alipay.mobile.mascanengine.MultiMaScanResult;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class MaBlackListOperation extends MaInterceptOperation {
    public static final String MA_STRING_BLACK_LISTS = "scan_black_list";
    public static final String MA_SYNC_BLACK_LISTS = "sync_black_list";
    public static final String SCAN_LAZY_RECOGNIZE_TIME = "scan_lazy_recognize_time";
    public static final String TAG = "MaBlackListOperation";
    private long b;
    private long c;
    public boolean hitBlackList;
    public boolean recentCandidate = false;
    public long firstScanBlackCodeTime = 0;
    public String lastBlackCode = null;
    private List<String> a = new ArrayList();

    public void addToBlackList(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            str2 = ";";
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        MaLogger.d(TAG, "addToBlackList() : " + str);
        String[] split = str.split(str2);
        if (split == null || split.length == 0) {
            return;
        }
        for (String str3 : split) {
            String trim = str3.toLowerCase().trim();
            if (!TextUtils.isEmpty(trim) && !this.a.contains(trim)) {
                this.a.add(trim);
            }
        }
    }

    public boolean inBlackLists(String str) {
        List<String> list;
        boolean z = false;
        if (this.c < 0) {
            return false;
        }
        if (!TextUtils.isEmpty(str) && (list = this.a) != null && !list.isEmpty()) {
            String lowerCase = str.toLowerCase();
            for (String str2 : this.a) {
                if (!lowerCase.startsWith(str2)) {
                    if (!lowerCase.startsWith("http://" + str2)) {
                        if (lowerCase.startsWith("https://" + str2)) {
                        }
                    }
                }
                z = true;
            }
            if (z) {
                this.hitBlackList = true;
            }
        }
        return z;
    }

    public boolean isDelayEnd() {
        if (this.c <= 0) {
            return true;
        }
        return this.b > 0 && System.currentTimeMillis() - this.b > this.c * 1000;
    }

    @Override // com.alipay.ma.strategies.MaInterceptOperation
    public boolean isIntercepted(byte[] bArr) {
        String str;
        List<String> list;
        boolean z = false;
        String stringEncode = StringEncodeUtils.getStringEncode(bArr, false);
        try {
            if (TextUtils.isEmpty(stringEncode)) {
                str = new String(bArr, "utf-8");
            } else {
                str = new String(bArr, stringEncode);
            }
        } catch (UnsupportedEncodingException e) {
            MaLogger.d(TAG, "UnsupportedEncodingException : " + e.getMessage());
            str = null;
        }
        if (!TextUtils.isEmpty(str) && (list = this.a) != null && !list.isEmpty()) {
            String lowerCase = str.toLowerCase();
            for (String str2 : this.a) {
                if (!lowerCase.startsWith(str2)) {
                    if (!lowerCase.startsWith("http://" + str2)) {
                        if (lowerCase.startsWith("https://" + str2)) {
                        }
                    }
                }
                z = true;
            }
        }
        return z;
    }

    public MultiMaScanResult preOperateResults(MultiMaScanResult multiMaScanResult) {
        MaScanResult[] maScanResultArr;
        MaScanResult[] maScanResultArr2;
        if (multiMaScanResult != null && (maScanResultArr = multiMaScanResult.maScanResults) != null && maScanResultArr.length != 0) {
            ArrayList arrayList = new ArrayList();
            for (MaScanResult maScanResult : multiMaScanResult.maScanResults) {
                if (maScanResult != null && !inBlackLists(maScanResult.text)) {
                    arrayList.add(maScanResult);
                }
            }
            if (multiMaScanResult.maScanResults.length >= 2 && arrayList.size() > 0 && arrayList.size() != multiMaScanResult.maScanResults.length) {
                MaBuryRecord.recordTwoCodeHasBlackList(((MaScanResult) arrayList.get(0)).text);
            }
            if (arrayList.isEmpty() && this.b == 0) {
                this.b = System.currentTimeMillis();
            }
            long currentTimeMillis = this.b > 0 ? System.currentTimeMillis() - this.b : -1L;
            long j = this.c;
            if (j > 0 && currentTimeMillis <= j * 1000) {
                if (!arrayList.isEmpty()) {
                    multiMaScanResult.maScanResults = (MaScanResult[]) arrayList.toArray(new MaScanResult[arrayList.size()]);
                    return multiMaScanResult;
                }
                multiMaScanResult.candidate = true;
                this.recentCandidate = true;
                if (this.firstScanBlackCodeTime <= 0) {
                    this.firstScanBlackCodeTime = System.currentTimeMillis();
                }
                this.lastBlackCode = multiMaScanResult.maScanResults[0].text;
                return multiMaScanResult;
            }
            if (arrayList.isEmpty()) {
                arrayList.add(multiMaScanResult.maScanResults[0]);
            }
            multiMaScanResult.maScanResults = (MaScanResult[]) arrayList.toArray(new MaScanResult[arrayList.size()]);
        }
        return multiMaScanResult;
    }

    public void setEnableFunction(String str) {
        if (TextUtils.isEmpty(str)) {
            this.c = 0L;
            return;
        }
        try {
            int parseInt = Integer.parseInt(str);
            if (parseInt > 0) {
                this.c = parseInt;
                MaLogger.d(TAG, "enable frames delay: framesDelay is " + str);
            }
        } catch (Exception e) {
            MaLogger.e(TAG, e.getMessage());
            this.c = 0L;
        }
    }
}
