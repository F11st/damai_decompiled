package com.alibaba.yymidservice.popup.request.bean;

import com.alibaba.fastjson.JSONObject;
import com.alient.oneservice.nav.Action;
import java.io.Serializable;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class PopupDetailBean implements Serializable {
    private static final long serialVersionUID = 1;
    public PopupDisplay display;
    public String eventType;
    public PopupItem item;
    public boolean needReport;
    public String pkId;
    public String sceneType;
    private String tag = PopupDetailBean.class.getSimpleName();

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class PopupDisplay implements Serializable {
        private static final long serialVersionUID = 1;
        public String beforePage;
        public String expression;
        public String fromPage;
        public int limit;
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class PopupItem implements Serializable {
        private static final long serialVersionUID = 1;
        public String templateId;
        public String templateUrl;
        public JSONObject value;
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class PopupItemValue implements Serializable {
        private static final long serialVersionUID = 1;
        public Map<String, Action> action;
        public JSONObject ext;
        public String imageUrl;
        public String lottie;
        public String schema;
        public String title;
    }
}
