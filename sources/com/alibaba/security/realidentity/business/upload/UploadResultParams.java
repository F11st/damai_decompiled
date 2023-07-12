package com.alibaba.security.realidentity.business.upload;

import android.text.TextUtils;
import com.alibaba.security.biometrics.jni.ALBiometricsJni;
import com.alibaba.security.biometrics.service.common.GetCacheDataManager;
import com.alibaba.security.biometrics.service.constants.GlobalErrorCode;
import com.alibaba.security.biometrics.service.model.result.ALBiometricsResult;
import com.alibaba.security.common.c.C3800a;
import com.alibaba.security.common.d.C3801a;
import com.alibaba.security.common.d.C3811h;
import com.alibaba.security.realidentity.RPResult;
import com.alibaba.security.realidentity.a.AbstractC3840a;
import com.alibaba.security.realidentity.business.C3873c;
import com.alibaba.security.realidentity.business.base.chain.BusinessHeadParams;
import com.alibaba.security.realidentity.business.bucket.BucketParams;
import com.alibaba.security.realidentity.business.bucket.HttpBucketParams;
import com.alibaba.security.realidentity.business.start.StartHttpParams;
import com.alibaba.security.realidentity.business.upload.UploadResultRequest;
import com.alibaba.security.realidentity.business.uploadresult.AbsUploadResultParams;
import com.alibaba.security.realidentity.http.base.BusinessHttpWrapper;
import com.alibaba.security.realidentity.http.base.BusinessRequest;
import com.alibaba.security.realidentity.http.model.HttpResponse;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class UploadResultParams extends AbsUploadResultParams {
    public ALBiometricsResult biometricsResult;
    private BusinessHeadParams mBusinessHeadParams;
    private StartHttpParams startHttpParams;
    public UploadResultResponse uploadResultResponse;
    private List<AsyncTaskC3885e> uploadTasks;
    private static final String TAG = UploadResultParams.class.getSimpleName();
    public static final String[] NUMERIC_STR_ARRAY = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class EdgeDetectResult implements Serializable {
        public String stare = null;
        public String actionZero = null;
        public String actionOne = null;
        public String actionTwo = null;
        public String actionThree = null;
        public String actionFour = null;
        public String actionFive = null;
        public String actionSix = null;
        public String actionSeven = null;
        public String actionEight = null;
        public String actionNine = null;
    }

    private String actionStringBaseOnActionType(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 10 ? i != 11 ? String.valueOf(i) : "KeepStill" : "RaiseHeadDown" : "ShakeHead" : "OpenMouth" : "Blink";
    }

    private UploadResultRequest assemable() {
        ArrayList arrayList = new ArrayList();
        UploadResultRequest.Elements elements = new UploadResultRequest.Elements();
        UploadResultRequest.Data data = new UploadResultRequest.Data();
        if (this.biometricsResult.getRecognizeResult() == 1 || this.biometricsResult.getRecognizeResult() == 0) {
            data.localRecognize = Integer.valueOf(this.biometricsResult.getRecognizeResult());
            data.recognizeResultScore = this.biometricsResult.getRecognizeResultScore();
        }
        data.bigImagePath = getUploadTaskByType(this.uploadTasks, AbstractC3840a.K);
        data.v = 2;
        data.isGaze = this.startHttpParams.mOnlyGaze;
        BusinessHeadParams businessHeadParams = this.mBusinessHeadParams;
        data.idCardAuthData = businessHeadParams == null ? null : businessHeadParams.getCtidParams();
        BusinessHeadParams businessHeadParams2 = this.mBusinessHeadParams;
        data.useCtid = businessHeadParams2 != null && businessHeadParams2.isCtidCalled();
        if (this.startHttpParams.mNeedActionImage) {
            for (int i = 0; i < this.biometricsResult.getAs().size(); i++) {
                String actionStringBaseOnActionType = actionStringBaseOnActionType(this.biometricsResult.getAs().get(i).getAt());
                UploadResultRequest.ActionType actionType = new UploadResultRequest.ActionType();
                actionType.type = actionStringBaseOnActionType;
                actionType.image_1 = getUploadTaskByType(this.uploadTasks, "action".concat(String.valueOf(i)));
                try {
                    UploadResultRequest.Data.class.getField(String.format("movement_%d", Integer.valueOf(i + 1))).set(data, actionType);
                } catch (IllegalAccessException unused) {
                    C3800a.b();
                } catch (NoSuchFieldException unused2) {
                    C3800a.b();
                }
            }
        }
        data.bigSmallPath = getUploadTaskByType(this.uploadTasks, AbstractC3840a.M);
        data.bigSmallLocalPath = getUploadTaskByType(this.uploadTasks, AbstractC3840a.L);
        data.originalImage = getUploadTaskByType(this.uploadTasks, AbstractC3840a.N);
        int[] fr = this.biometricsResult.getQi().getFr();
        if (fr != null && fr.length == 4) {
            data.faceRect = String.format("%d,%d,%d,%d", Integer.valueOf(fr[0]), Integer.valueOf(fr[1]), Integer.valueOf(fr[2]), Integer.valueOf(fr[3]));
        }
        String bgDetectResult = this.biometricsResult.getBgDetectResult();
        if (bgDetectResult != null) {
            EdgeDetectResult edgeDetectResult = new EdgeDetectResult();
            String[] split = bgDetectResult.split(";");
            for (int i2 = 0; i2 < split.length; i2++) {
                try {
                    EdgeDetectResult.class.getField(i2 == 0 ? "stare" : "action" + NUMERIC_STR_ARRAY[i2]).set(edgeDetectResult, split[i2]);
                } catch (IllegalAccessException unused3) {
                    C3800a.b();
                } catch (NoSuchFieldException unused4) {
                    C3800a.b();
                }
            }
            data.backgroundDetectResult = C3811h.a(edgeDetectResult);
        }
        data.processDetail = this.biometricsResult.toJson();
        UploadResultRequest uploadResultRequest = new UploadResultRequest();
        elements.value = data;
        uploadResultRequest.verifyToken = this.mVerifyToken;
        arrayList.add(elements);
        if (!TextUtils.isEmpty(this.biometricsResult.getDazzleVideoPath())) {
            UploadResultRequest.Elements elements2 = new UploadResultRequest.Elements();
            elements2.name = "BIOMETRIC_COLORFUL";
            UploadResultRequest.Data data2 = new UploadResultRequest.Data();
            UploadResultRequest.C3878a c3878a = new UploadResultRequest.C3878a();
            c3878a.a = this.biometricsResult.getDazzleVideoOssUrl();
            c3878a.c = this.biometricsResult.getVideoHash();
            UploadResultRequest.C3879b c3879b = new UploadResultRequest.C3879b();
            c3879b.a = this.biometricsResult.getDazzleDataConfigs();
            c3878a.b = c3879b;
            String a = C3811h.a(c3878a);
            if (a != null) {
                data2.data = C3801a.a(ALBiometricsJni.makeResult(a.getBytes(), String.valueOf(new Date().getTime()), GetCacheDataManager.getInstance().getUmidToken()));
            }
            elements2.value = data2;
            arrayList.add(elements2);
        }
        arrayList.add(getRiskActionElements());
        uploadResultRequest.elements = C3811h.a(arrayList);
        return uploadResultRequest;
    }

    private UploadResultRequest.Elements getRiskActionElements() {
        UploadResultRequest.Elements elements = new UploadResultRequest.Elements();
        elements.name = "RISK_ACTION";
        UploadResultRequest.Data data = new UploadResultRequest.Data();
        if (!TextUtils.isEmpty(this.biometricsResult.getCollectedData())) {
            data.sensorActionLog = this.biometricsResult.getCollectedData();
        }
        if (!TextUtils.isEmpty(this.biometricsResult.getBh())) {
            data.flActionLog = this.biometricsResult.getBh();
        }
        elements.value = data;
        return elements;
    }

    private String getUploadTaskByType(List<AsyncTaskC3885e> list, String str) {
        if (list != null) {
            for (AsyncTaskC3885e asyncTaskC3885e : list) {
                if (TextUtils.equals(str, asyncTaskC3885e.a)) {
                    return asyncTaskC3885e.a();
                }
            }
            return "";
        }
        return "";
    }

    @Override // com.alibaba.security.realidentity.business.bucket.HttpBucketParams
    public HttpBucketParams doTransform(HttpResponse httpResponse) {
        if (httpResponse instanceof UploadResultResponse) {
            this.uploadResultResponse = (UploadResultResponse) httpResponse;
        }
        return this;
    }

    @Override // com.alibaba.security.realidentity.business.bucket.BucketParams
    public BusinessHttpWrapper getRpcRequest() {
        return new BusinessHttpWrapper(UploadResultResponse.class, new BusinessRequest(UploadResultRequest.class, assemable()));
    }

    @Override // com.alibaba.security.realidentity.business.bucket.BucketParams
    public boolean onDelivering(C3873c c3873c) {
        this.startHttpParams = c3873c.c;
        this.biometricsResult = c3873c.d.biometricsResult;
        this.mBusinessHeadParams = c3873c.b;
        this.uploadTasks = c3873c.e.getUploadTaskList();
        return true;
    }

    @Override // com.alibaba.security.realidentity.business.bucket.BucketParams
    public BucketParams.ErrorCode parseErrorCode() {
        UploadResultResponse uploadResultResponse = this.uploadResultResponse;
        if (uploadResultResponse == null) {
            return new BucketParams.ErrorCode(RPResult.AUDIT_NOT, "-10300", "start api fail, response is null", GlobalErrorCode.ERROR_ONLINE_NET_ERROR);
        }
        if (uploadResultResponse.isSuccessful()) {
            return new BucketParams.ErrorCode(RPResult.AUDIT_PASS, "0", "upload result success", 0);
        }
        if (!TextUtils.isEmpty(this.uploadResultResponse.getRetCode())) {
            return new BucketParams.ErrorCode(RPResult.AUDIT_NOT, "-10303", this.uploadResultResponse.getRetMsg(), GlobalErrorCode.ERROR_UPLOAD_BIO_DATA);
        }
        return new BucketParams.ErrorCode(RPResult.AUDIT_NOT, "-10303", C3811h.a(this.uploadResultResponse), GlobalErrorCode.ERROR_UPLOAD_BIO_DATA);
    }
}
