package com.alibaba.security.realidentity.business.upload;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.security.realidentity.a.AbstractC3840a;
import com.alibaba.security.realidentity.http.annotation.Api;
import com.alibaba.security.realidentity.http.annotation.Body;
import com.alibaba.security.realidentity.http.model.HttpMethod;
import com.alibaba.security.realidentity.http.model.HttpRequest;
import com.taobao.weex.common.WXConfig;
import java.io.Serializable;

/* compiled from: Taobao */
@Api(method = HttpMethod.POST, name = "mtop.verifycenter.rp.upload")
@Body
/* loaded from: classes8.dex */
public class UploadResultRequest extends HttpRequest {
    public String elements;
    public String verifyToken;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class ActionType implements Serializable {
        @JSONField(name = "image_1")
        public String image_1;
        @JSONField(name = "type")
        public String type;
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class Data implements Serializable {
        @JSONField(name = AbstractC3840a.K)
        public String bigImagePath;
        @JSONField(name = AbstractC3840a.L)
        public String bigSmallLocalPath;
        @JSONField(name = "refImage")
        public String bigSmallPath;
        @JSONField(name = "data")
        public String data;
        @JSONField(name = "faceRect")
        public String faceRect;
        @JSONField(name = "flActionLog")
        public String flActionLog;
        @JSONField(name = "idCardAuthData")
        public String idCardAuthData;
        @JSONField(name = "isGaze")
        public boolean isGaze;
        @JSONField(name = AbstractC3840a.N)
        public String originalImage;
        @JSONField(name = "processDetail")
        public String processDetail;
        @JSONField(name = "sensorActionLog")
        public String sensorActionLog;
        @JSONField(name = "useCtid")
        public boolean useCtid;
        @JSONField(name = "smallImageMode")
        public int smallImageModel = 1;
        @JSONField(name = "K_FACE_R_ENABLE")
        public Integer localRecognize = null;
        @JSONField(name = "recognizeResultScore")
        public float recognizeResultScore = 0.0f;
        @JSONField(name = "v")
        public int v = 1;
        @JSONField(name = "backgroundDetectResult")
        public String backgroundDetectResult = "";
        @JSONField(name = "movement_1")
        public ActionType movement_1 = null;
        @JSONField(name = "movement_2")
        public ActionType movement_2 = null;
        @JSONField(name = "movement_3")
        public ActionType movement_3 = null;
        @JSONField(name = "movement_4")
        public ActionType movement_4 = null;
        @JSONField(name = "movement_5")
        public ActionType movement_5 = null;
        @JSONField(name = "movement_6")
        public ActionType movement_6 = null;
        @JSONField(name = "movement_7")
        public ActionType movement_7 = null;
        @JSONField(name = "movement_8")
        public ActionType movement_8 = null;
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class Elements implements Serializable {
        @JSONField(name = "value")
        public Data value;
        @JSONField(name = "name")
        public String name = "Biometric";
        @JSONField(name = "valueMeta")
        public String valueMeta = "JsonType";
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.security.realidentity.business.upload.UploadResultRequest$a */
    /* loaded from: classes8.dex */
    public static class C3878a {
        @JSONField(name = "url")
        public String a;
        @JSONField(name = "videoExtra")
        public C3879b b;
        @JSONField(name = "videoHash")
        public String c;
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.security.realidentity.business.upload.UploadResultRequest$b */
    /* loaded from: classes8.dex */
    public static class C3879b {
        @JSONField(name = "conf")
        public Object a;
        @JSONField(name = WXConfig.osName)
        public String b = "android";
    }
}
