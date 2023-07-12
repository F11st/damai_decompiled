package com.ali.user.mobile.verify.model;

import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class OpenBiometricApiRequest implements Serializable {
    public String appKey;
    public String biometricType = "fingerprint";
    public String havanaIvToken;
    public String loginToken;
    public String requestScene;
    public int site;
}
