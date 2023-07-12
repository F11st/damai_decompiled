package com.alipay.mobile.mascanengine.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import com.alipay.ma.MaLogger;
import com.alipay.ma.analyze.api.MaAnalyzeAPI;
import com.alipay.ma.analyze.helper.MaResultTypeHelper;
import com.alipay.ma.decode.DecodeResult;
import com.alipay.ma.decode.DecodeType;
import com.alipay.ma.strategies.MaInterceptOperation;
import com.alipay.mobile.mascanengine.MaPictureEngineService;
import com.alipay.mobile.mascanengine.MaScanResult;
import com.alipay.mobile.mascanengine.MultiMaScanResult;
import java.lang.reflect.Method;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class MaPictureEngineServiceImpl extends MaPictureEngineService {
    public static final int PICTURE_RECOG_TYPE = (DecodeType.ONECODE.getCodeType() | DecodeType.ALLQRCODE.getCodeType()) | DecodeType.HMCODE.getCodeType();

    private void a() {
        try {
            Method declaredMethod = Class.forName("com.alipay.ma.aiboost.DynamicCodeConfig").getDeclaredMethod("cleanAlbum", new Class[0]);
            if (declaredMethod != null) {
                declaredMethod.invoke(null, new Object[0]);
            }
        } catch (Exception e) {
            MaLogger.d("MaPictureEngineServiceImpl", "cleanAlbumUseDynamicCodeConfig, " + e.getMessage());
        }
    }

    private void b() {
        try {
            Method declaredMethod = Class.forName("com.alipay.ma.aiboost.DynamicCodeConfig").getDeclaredMethod("updateAlbum", new Class[0]);
            if (declaredMethod != null) {
                declaredMethod.invoke(null, new Object[0]);
            }
        } catch (Exception e) {
            MaLogger.d("MaPictureEngineServiceImpl", "updateAlbumUseDynamicCodeConfig, " + e.getMessage());
        }
    }

    @Override // com.alipay.mobile.mascanengine.MaPictureEngineService
    public void destroy() {
    }

    @Override // com.alipay.mobile.mascanengine.MaPictureEngineService
    public MaScanResult process(String str) {
        return process(str, false);
    }

    @Override // com.alipay.mobile.mascanengine.MaPictureEngineService
    public MaScanResult processARCode(byte[] bArr, int i, int i2, int i3) {
        DecodeResult[] decode;
        if (bArr == null || i2 <= 0 || i3 <= 0 || (decode = MaAnalyzeAPI.decode(bArr, i2, i3, (Rect) null, DecodeType.ARCODE)) == null || decode.length <= 0 || decode[0] == null) {
            return null;
        }
        decode[0].resultMaType = MaResultTypeHelper.getMaType(decode[0]);
        return MaScanResultUtils.fromMaResult(decode[0]);
    }

    @Override // com.alipay.mobile.mascanengine.MaPictureEngineService
    public MaScanResult processByFd(String str, Context context) {
        return processByFd(str, context, false);
    }

    @Override // com.alipay.mobile.mascanengine.MaPictureEngineService
    public MultiMaScanResult processMultiMa(String str) {
        return processMultiMa(str, 4, false);
    }

    @Override // com.alipay.mobile.mascanengine.MaPictureEngineService
    public MultiMaScanResult processMultiMaByFd(String str, Context context) {
        return processMultiMaByFd(str, context, 4, false);
    }

    @Override // com.alipay.mobile.mascanengine.MaPictureEngineService
    public MaScanResult process(String str, boolean z) {
        if (str == null) {
            return null;
        }
        b();
        DecodeResult[] decode = MaAnalyzeAPI.decode(str, PICTURE_RECOG_TYPE, z);
        a();
        if (decode == null || decode.length == 0) {
            return null;
        }
        DecodeResult decodeResult = decode[0];
        decodeResult.resultMaType = MaResultTypeHelper.getMaType(decodeResult);
        return MaScanResultUtils.fromMaResult(decodeResult);
    }

    @Override // com.alipay.mobile.mascanengine.MaPictureEngineService
    public MaScanResult processByFd(String str, Context context, boolean z) {
        if (str == null || context == null) {
            return null;
        }
        b();
        DecodeResult[] decode = MaAnalyzeAPI.decode(str, context, PICTURE_RECOG_TYPE, z);
        a();
        if (decode == null || decode.length == 0) {
            return null;
        }
        DecodeResult decodeResult = decode[0];
        decodeResult.resultMaType = MaResultTypeHelper.getMaType(decodeResult);
        return MaScanResultUtils.fromMaResult(decodeResult);
    }

    @Override // com.alipay.mobile.mascanengine.MaPictureEngineService
    public MultiMaScanResult processMultiMa(String str, int i, boolean z, MaInterceptOperation maInterceptOperation) {
        if (str == null) {
            return null;
        }
        b();
        DecodeResult[] decode = MaAnalyzeAPI.decode(str, PICTURE_RECOG_TYPE, i, z, maInterceptOperation);
        a();
        if (decode == null || decode.length == 0) {
            return null;
        }
        for (int i2 = 0; i2 < decode.length; i2++) {
            decode[i2].resultMaType = MaResultTypeHelper.getMaType(decode[i2]);
        }
        return MaScanResultUtils.fromMaResults(decode, null);
    }

    @Override // com.alipay.mobile.mascanengine.MaPictureEngineService
    public MultiMaScanResult processMultiMaByFd(String str, Context context, int i, boolean z) {
        return processMultiMaByFd(str, context, i, z, null);
    }

    @Override // com.alipay.mobile.mascanengine.MaPictureEngineService
    public MultiMaScanResult processMultiMaByFd(String str, Context context, int i, boolean z, MaInterceptOperation maInterceptOperation) {
        if (str == null || context == null) {
            return null;
        }
        b();
        DecodeResult[] decode = MaAnalyzeAPI.decode(str, context, PICTURE_RECOG_TYPE, i, z, maInterceptOperation);
        a();
        if (decode == null || decode.length == 0) {
            return null;
        }
        for (int i2 = 0; i2 < decode.length; i2++) {
            decode[i2].resultMaType = MaResultTypeHelper.getMaType(decode[i2]);
        }
        return MaScanResultUtils.fromMaResults(decode, null);
    }

    @Override // com.alipay.mobile.mascanengine.MaPictureEngineService
    public MaScanResult process(Bitmap bitmap) {
        return process(bitmap, false);
    }

    @Override // com.alipay.mobile.mascanengine.MaPictureEngineService
    public MultiMaScanResult processMultiMa(String str, int i, boolean z) {
        return processMultiMa(str, i, z, null);
    }

    @Override // com.alipay.mobile.mascanengine.MaPictureEngineService
    public MaScanResult process(Bitmap bitmap, boolean z) {
        if (bitmap != null && !bitmap.isRecycled()) {
            b();
            DecodeResult[] decode = MaAnalyzeAPI.decode(bitmap, PICTURE_RECOG_TYPE, z);
            a();
            if (decode != null && decode.length != 0) {
                DecodeResult decodeResult = decode[0];
                decodeResult.resultMaType = MaResultTypeHelper.getMaType(decodeResult);
                return MaScanResultUtils.fromMaResult(decodeResult);
            }
        }
        return null;
    }

    @Override // com.alipay.mobile.mascanengine.MaPictureEngineService
    public MultiMaScanResult processMultiMa(Bitmap bitmap) {
        return processMultiMa(bitmap, 4, false);
    }

    @Override // com.alipay.mobile.mascanengine.MaPictureEngineService
    public MultiMaScanResult processMultiMa(Bitmap bitmap, int i, boolean z) {
        if (bitmap != null && !bitmap.isRecycled()) {
            b();
            DecodeResult[] decode = MaAnalyzeAPI.decode(bitmap, PICTURE_RECOG_TYPE, i, z);
            a();
            if (decode != null && decode.length != 0) {
                for (int i2 = 0; i2 < decode.length; i2++) {
                    decode[i2].resultMaType = MaResultTypeHelper.getMaType(decode[i2]);
                }
                return MaScanResultUtils.fromMaResults(decode, null);
            }
        }
        return null;
    }
}
