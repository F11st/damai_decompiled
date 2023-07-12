package com.alient.oneservice.ut;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import java.io.Serializable;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class TrackInfo implements Serializable {
    public static final String TRACK_INFO_AB_BUCKET = "ABTrackInfo";
    public static final String TRACK_INFO_AB_PREAB = "PreABTrackInfo";
    private JSONObject abBucket;
    private HashMap<String, String> args;
    private String clickEventName;
    private String exposeEventName;
    private String originSpmd;
    private JSONObject pabBucket;
    private String spma;
    private String spmb;
    private String spmc;
    private String spmd;

    public JSONObject getAbBucket() {
        return this.abBucket;
    }

    public HashMap<String, String> getArgs() {
        return this.args;
    }

    public String getClickEventName() {
        return this.clickEventName;
    }

    public String getExposeEventName() {
        return this.exposeEventName;
    }

    public String getOriginSpmd() {
        return this.originSpmd;
    }

    public JSONObject getPabBucket() {
        return this.pabBucket;
    }

    public String getSpm() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.spma)) {
            sb.append(this.spma);
            sb.append(".");
        }
        if (!TextUtils.isEmpty(this.spmb)) {
            sb.append(this.spmb);
            sb.append(".");
        }
        if (!TextUtils.isEmpty(this.spmc)) {
            sb.append(this.spmc);
            sb.append(".");
        }
        if (!TextUtils.isEmpty(this.spmd)) {
            sb.append(this.spmd);
            sb.append(".");
        }
        if (!TextUtils.isEmpty(sb) && sb.toString().endsWith(".")) {
            return sb.toString().substring(0, sb.toString().length() - 1);
        }
        return sb.toString();
    }

    public String getSpma() {
        return this.spma;
    }

    public String getSpmb() {
        return this.spmb;
    }

    public String getSpmc() {
        return this.spmc;
    }

    public String getSpmd() {
        return this.spmd;
    }

    public void setAbBucket(JSONObject jSONObject) {
        this.abBucket = jSONObject;
    }

    public void setArgs(HashMap<String, String> hashMap) {
        this.args = hashMap;
    }

    public void setClickEventName(String str) {
        this.clickEventName = str;
    }

    public void setExposeEventName(String str) {
        this.exposeEventName = str;
    }

    public void setOriginSpmd(String str) {
        this.originSpmd = str;
    }

    public void setPabBucket(JSONObject jSONObject) {
        this.pabBucket = jSONObject;
    }

    public void setSpma(String str) {
        this.spma = str;
    }

    public void setSpmb(String str) {
        this.spmb = str;
    }

    public void setSpmc(String str) {
        this.spmc = str;
    }

    public void setSpmd(String str) {
        this.spmd = str;
    }
}
