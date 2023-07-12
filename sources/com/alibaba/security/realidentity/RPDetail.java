package com.alibaba.security.realidentity;

import android.graphics.Bitmap;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class RPDetail {
    private String code;
    private Bitmap faceImage;
    private String msg;
    private String subCode;

    public RPDetail(String str, String str2, String str3, Bitmap bitmap) {
        this.code = str;
        this.subCode = str2;
        this.msg = str3;
        this.faceImage = bitmap;
    }

    public String getCode() {
        return this.code;
    }

    public Bitmap getFaceImage() {
        return this.faceImage;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getSubCode() {
        return this.subCode;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setFaceImage(Bitmap bitmap) {
        this.faceImage = bitmap;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setSubCode(String str) {
        this.subCode = str;
    }
}
