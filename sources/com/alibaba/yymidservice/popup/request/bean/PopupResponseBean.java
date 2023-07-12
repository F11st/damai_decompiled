package com.alibaba.yymidservice.popup.request.bean;

import com.alibaba.fastjson.JSONObject;
import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class PopupResponseBean implements Serializable {
    private static final long serialVersionUID = 1;
    public JSONObject globalConfig;
    public ArrayList<String> sceneTypes;
    public Long serverTime;
    public ArrayList<PopupDetailBean> show;
    public String spmab;
    public ArrayList<PopupDetailBean> trigger;
}
