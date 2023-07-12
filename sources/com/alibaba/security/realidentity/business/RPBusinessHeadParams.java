package com.alibaba.security.realidentity.business;

import com.alibaba.security.realidentity.business.base.chain.BusinessHeadParams;
import com.alibaba.security.realidentity.business.start.model.StepItem;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class RPBusinessHeadParams extends BusinessHeadParams {
    public boolean bSmallImageMode;
    public List<Integer> bioStepsEx;
    public String bizConf;
    public String fromSource;
    public IdentityInfoBean identityInfo;
    public String livenessConfig;
    public boolean localAccelerateOpen;
    public String localModelPath;
    public int maxRetry;
    public boolean needActionImage;
    public boolean needDisplayWaitingView;
    public boolean needFailVideo;
    public boolean needGaze;
    public boolean needOriginalImage;
    public boolean needSuccessVideo;
    public boolean needUserConfirm;
    public boolean onlyGaze;
    public int poseDetectInterval;
    public int retryCount;
    public int serviceType;
    public boolean sessionless;
    public boolean showNav;
    public int showTip;
    public String skinColor;
    public String statusCode;
    public List<StepItem> steps;
    public int type;
    public String userName;
    public Map<String, String> verifyConf;
    public String verifyToken;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class IdentityInfoBean implements Serializable {
        public String name;
    }
}
