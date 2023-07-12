package com.alibaba.security.biometrics.service.model.result;

import com.alibaba.analytics.core.sync.UploadQueueMgr;
import com.alibaba.security.biometrics.service.common.ABLogRecorderKeys;
import com.alibaba.security.common.c.C3800a;
import com.alimm.xadsdk.request.builder.IRequestConst;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tb.b90;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ALBiometricsResult implements Serializable {
    public static final int DIGETS_TYPE_HMACMD5 = 1;
    public static final int DIGETS_TYPE_HMACSHA1 = 2;
    public static final int DIGETS_TYPE_MD5 = 0;
    public static final int FAIL = 0;
    public static final int SUCCESS = 1;
    private static final String TAG = "ALBiometricsResult";
    public static final int UNDEFINED = -1;
    private static final long serialVersionUID = 1;
    protected String aid;
    protected String bh;
    protected long bt;
    protected DazzleCollectDataConfig dazzleDataConfigs;
    private String dazzleVideoOssUrl;
    protected String dazzleVideoPath;
    protected String did;
    protected String displayImagePath;
    protected long et;
    protected HashMap<String, String> ex;
    protected ALFaceDetectResult faceDetectResult;
    protected String failedVideoPath;
    protected ABImageResult gi;
    protected String isid;
    protected String k;
    protected ABImageResult li;
    protected String lid;
    protected String m;
    private String mCollectedData;
    protected ABImageResult oi;
    protected String os;
    protected ABImageResult qi;
    protected int recapAvgTime;
    protected int recapFrames;
    protected String recapLog;
    protected float[] recapScore;
    protected String reflectImgDigest;
    protected String reflectImgPath;
    protected String resultData;
    protected String sid;
    protected String successfulVideoPath;
    protected String uid;
    private String videoHash;
    protected int reflectImgDigestType = 0;
    protected int r = 0;
    protected String v = "1.0";
    protected int rt = 0;
    protected ArrayList<ABImageResult> continueImages = new ArrayList<>();
    protected List<ABActionResult> as = new ArrayList();
    protected float iso = -1.0f;
    protected float illuminance = -1.0f;
    protected int recapResult = -1;
    protected int recognizeResult = -1;
    protected float recognizeResultScore = -1.0f;
    protected ABActionResult adjustAction = new ABActionResult();

    public void addActionResult(ABActionResult aBActionResult) {
        this.as.add(aBActionResult);
    }

    public void addDazzleCollectConfigs(List<? extends DazzleDataConfigItem> list) {
        if (this.dazzleDataConfigs == null) {
            this.dazzleDataConfigs = new DazzleCollectDataConfig();
        }
        if (list != null) {
            for (DazzleDataConfigItem dazzleDataConfigItem : list) {
                this.dazzleDataConfigs.addUIConfig(dazzleDataConfigItem);
            }
        }
    }

    public ABActionResult getAdjustAction() {
        return this.adjustAction;
    }

    public String getAid() {
        return this.aid;
    }

    public List<ABActionResult> getAs() {
        return this.as;
    }

    public String getBgDetectResult() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.adjustAction.getEcResult());
        for (ABActionResult aBActionResult : this.as) {
            stringBuffer.append(b90.TokenSEM);
            stringBuffer.append(aBActionResult.getEcResult());
        }
        return stringBuffer.toString();
    }

    public String getBh() {
        return this.bh;
    }

    public long getBt() {
        return this.bt;
    }

    public String getCollectedData() {
        return this.mCollectedData;
    }

    public ArrayList<ABImageResult> getContinueImages() {
        return this.continueImages;
    }

    public DazzleCollectDataConfig getDazzleDataConfigs() {
        return this.dazzleDataConfigs;
    }

    public String getDazzleVideoOssUrl() {
        return this.dazzleVideoOssUrl;
    }

    public String getDazzleVideoPath() {
        return this.dazzleVideoPath;
    }

    public String getDid() {
        return this.did;
    }

    public String getDisplayImagePath() {
        return this.displayImagePath;
    }

    public long getEt() {
        return this.et;
    }

    public HashMap<String, String> getEx() {
        return this.ex;
    }

    public ALFaceDetectResult getFaceResult() {
        if (this.faceDetectResult == null) {
            this.faceDetectResult = new ALFaceDetectResult();
        }
        return this.faceDetectResult;
    }

    public ABImageResult getGi() {
        return this.gi;
    }

    public float getIlluminance() {
        return this.illuminance;
    }

    public float getIso() {
        return this.iso;
    }

    public String getK() {
        return this.k;
    }

    public ABImageResult getLi() {
        return this.li;
    }

    public String getLid() {
        return this.lid;
    }

    public String getM() {
        return this.m;
    }

    public ABImageResult getOi() {
        return this.oi;
    }

    public String getOs() {
        return this.os;
    }

    public ABImageResult getQi() {
        return this.qi;
    }

    public int getR() {
        return this.r;
    }

    public int getRecapAvgTime() {
        return this.recapAvgTime;
    }

    public int getRecapFrames() {
        return this.recapFrames;
    }

    public String getRecapLog() {
        return this.recapLog;
    }

    public int getRecapResult() {
        return this.recapResult;
    }

    public float getRecapScore() {
        float[] fArr = this.recapScore;
        if (fArr == null || fArr.length < 0) {
            return 0.0f;
        }
        return fArr[0];
    }

    public int getRecognizeResult() {
        return this.recognizeResult;
    }

    public float getRecognizeResultScore() {
        return this.recognizeResultScore;
    }

    public String getReflectImgDigest() {
        return this.reflectImgDigest;
    }

    public int getReflectImgDigestType() {
        return this.reflectImgDigestType;
    }

    public String getReflectImgPath() {
        return this.reflectImgPath;
    }

    public String getResultData() {
        return this.resultData;
    }

    public int getRt() {
        return this.rt;
    }

    public String getSid() {
        return this.sid;
    }

    public String getUid() {
        return this.uid;
    }

    public String getV() {
        return this.v;
    }

    public String getVideoF() {
        return this.failedVideoPath;
    }

    public String getVideoHash() {
        return this.videoHash;
    }

    public String getVideoS() {
        return this.successfulVideoPath;
    }

    public void increaseRetryTime() {
        this.rt++;
    }

    public void setAid(String str) {
        this.aid = str;
    }

    public void setAs(List<ABActionResult> list) {
        this.as = list;
    }

    public void setBh(String str) {
        this.bh = str;
    }

    public void setBt(long j) {
        this.bt = j;
    }

    public void setCollectedData(String str) {
        this.mCollectedData = str;
    }

    public void setContinueImages(ArrayList<ABImageResult> arrayList) {
        this.continueImages = arrayList;
    }

    public void setDazzleCollectRotate(int i) {
        if (this.dazzleDataConfigs == null) {
            this.dazzleDataConfigs = new DazzleCollectDataConfig();
        }
        this.dazzleDataConfigs.setRotate(i);
    }

    public void setDazzleVideoOssUrl(String str) {
        this.dazzleVideoOssUrl = str;
    }

    public void setDazzleVideoPath(String str) {
        this.dazzleVideoPath = str;
    }

    public void setDid(String str) {
        this.did = str;
    }

    public ALBiometricsResult setDisplayImagePath(String str) {
        this.displayImagePath = str;
        return this;
    }

    public void setEt(long j) {
        this.et = j;
    }

    public void setEx(HashMap<String, String> hashMap) {
        this.ex = hashMap;
    }

    public void setFaceResult(ALFaceDetectResult aLFaceDetectResult) {
        this.faceDetectResult = aLFaceDetectResult;
    }

    public ALBiometricsResult setGi(ABImageResult aBImageResult) {
        this.gi = aBImageResult;
        return this;
    }

    public ALBiometricsResult setIlluminance(float f) {
        this.illuminance = f;
        return this;
    }

    public ALBiometricsResult setIso(float f) {
        this.iso = f;
        return this;
    }

    public void setK(String str) {
        this.k = str;
    }

    public ALBiometricsResult setLi(ABImageResult aBImageResult) {
        this.li = aBImageResult;
        return this;
    }

    public ALBiometricsResult setLid(String str) {
        this.lid = str;
        return this;
    }

    public void setM(String str) {
        this.m = str;
    }

    public ALBiometricsResult setOi(ABImageResult aBImageResult) {
        this.oi = aBImageResult;
        return this;
    }

    public void setOs(String str) {
        this.os = str;
    }

    public void setQi(ABImageResult aBImageResult) {
        this.qi = aBImageResult;
    }

    public void setR(int i) {
        this.r = i;
    }

    public ALBiometricsResult setRecapAvgTime(int i) {
        this.recapAvgTime = i;
        return this;
    }

    public ALBiometricsResult setRecapFrames(int i) {
        this.recapFrames = i;
        return this;
    }

    public ALBiometricsResult setRecapLog(String str) {
        this.recapLog = str;
        return this;
    }

    public ALBiometricsResult setRecapResult(int i) {
        this.recapResult = i;
        return this;
    }

    public ALBiometricsResult setRecapScore(float[] fArr) {
        this.recapScore = fArr;
        return this;
    }

    public void setRecognizeResult(int i) {
        this.recognizeResult = i;
    }

    public void setRecognizeResultScore(float f) {
        this.recognizeResultScore = f;
    }

    public void setReflectImgDigest(String str) {
        this.reflectImgDigest = str;
    }

    public void setReflectImgDigestType(int i) {
        this.reflectImgDigestType = i;
    }

    public void setReflectImgPath(String str) {
        this.reflectImgPath = str;
    }

    public void setResultData(String str) {
        this.resultData = str;
    }

    public void setRt(int i) {
        this.rt = i;
    }

    public void setSid(String str) {
        this.sid = str;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void setV(String str) {
        this.v = str;
    }

    public void setVideoF(String str) {
        this.failedVideoPath = str;
    }

    public void setVideoHash(String str) {
        this.videoHash = str;
    }

    public void setVideoS(String str) {
        this.successfulVideoPath = str;
    }

    public String toJson() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("version", 2);
            jSONObject.put("os", "android");
            jSONObject.put(UploadQueueMgr.MSGTYPE_REALTIME, this.r);
            jSONObject.put(IRequestConst.BT, this.bt);
            jSONObject.put("et", this.et);
            jSONObject.put("rt", this.rt);
            jSONObject.put(ABLogRecorderKeys.FieldIlluminance, this.illuminance);
            jSONObject.put("recapResult", this.recapResult);
            float[] fArr = this.recapScore;
            int i = 0;
            jSONObject.put("recapScore", (fArr == null || fArr.length <= 0) ? "-1" : Float.valueOf(fArr[0]));
            Object obj = this.successfulVideoPath;
            if (obj == null) {
                obj = JSONObject.NULL;
            }
            jSONObject.put("videoS", obj);
            Object obj2 = this.failedVideoPath;
            if (obj2 == null) {
                obj2 = JSONObject.NULL;
            }
            jSONObject.put("videoF", obj2);
            ABImageResult aBImageResult = this.qi;
            if (aBImageResult != null && aBImageResult.landmarks != null) {
                StringBuffer stringBuffer = new StringBuffer();
                int i2 = 0;
                while (true) {
                    float[] fArr2 = this.qi.landmarks;
                    if (i2 >= fArr2.length) {
                        break;
                    }
                    stringBuffer.append(fArr2[i2]);
                    if (i2 < this.qi.landmarks.length - 1) {
                        stringBuffer.append(",");
                    }
                    i2++;
                }
                jSONObject.put("landmarks", stringBuffer.toString());
            }
            ABImageResult aBImageResult2 = this.qi;
            if (aBImageResult2 != null && aBImageResult2.fr != null) {
                StringBuffer stringBuffer2 = new StringBuffer();
                while (true) {
                    int[] iArr = this.qi.fr;
                    if (i >= iArr.length) {
                        break;
                    }
                    stringBuffer2.append(iArr[i]);
                    if (i < this.qi.fr.length - 1) {
                        stringBuffer2.append(",");
                    }
                    i++;
                }
                jSONObject.put("faceRect", stringBuffer2.toString());
            }
            return jSONObject.toString();
        } catch (JSONException unused) {
            C3800a.b();
            return "";
        }
    }

    public String toString() {
        return "ALBiometricsResult{r=" + this.r + ", v='" + this.v + "', bt=" + this.bt + ", et=" + this.et + ", aid='" + this.aid + "', did='" + this.did + "', uid='" + this.uid + "', sid='" + this.sid + "', isid='" + this.isid + "', rt=" + this.rt + ", oi=" + this.oi + ", qi=" + this.qi + ", gi=" + this.gi + ", li=" + this.li + ", k='" + this.k + "', os='" + this.os + "', m='" + this.m + "', as=" + this.as + ", reflectImgPath='" + this.reflectImgPath + "', reflectImgDigest='" + this.reflectImgDigest + "', displayImagePath='" + this.displayImagePath + "', resultData='" + this.resultData + "', iso=" + this.iso + ", illuminance=" + this.illuminance + ", lid='" + this.lid + "', recapResult=" + this.recapResult + ", recapScore=" + Arrays.toString(this.recapScore) + ", recapFrames=" + this.recapFrames + ", recapAvgTime=" + this.recapAvgTime + ", recapLog='" + this.recapLog + "', recognizeResult=" + this.recognizeResult + ", recognizeResultScore=" + this.recognizeResultScore + ", reflectImgDigestType=" + this.reflectImgDigestType + ", videoS=" + this.successfulVideoPath + ", videoF=" + this.failedVideoPath + ", ex=" + this.ex + '}';
    }
}
