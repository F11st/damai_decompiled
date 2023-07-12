package com.alibaba.security.biometrics.service.model.params;

import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class BiometricsConfig implements Serializable {
    public int adjustStep = -1;
    public int actionCount = -1;
    public String actions = null;
    public int lessImageMode = -1;
    public int bigImageSize = -1;
    public int detectWrongAction = -1;
    public int detectOcclusion = -1;
    public int imageCount = -1;
    public int imageIntervals = -1;
    public int enableRecap = -1;
    public int recapMode = -1;
    public float recapThreshold = -1.0f;
    @Deprecated
    public int recognizeEnable = -1;
    @Deprecated
    public String recognizeModelPath = null;
    public String recognizeTargetData = null;
    public String recognizeTemplateFeature = null;
    public int displayWaitingView = -1;
    public int reflectILThreshold = -1;
    public float reflectDistanceThreshold = -1.0f;
    public int reflectPrevFailThreshold = -1;
    public int actionWhileCheckFail = -1;
    public String strategyWhileCheckFail = null;
    public int bgDetectTimeIntervals = -1;
    public int bgDetectColorThreshold = -1;
    public int needSuccessVideo = -1;
    public int needFailVideo = -1;
    public String licenseData = null;
    public String licenseTimeData = null;
}
