package com.ut.mini.exposure;

import android.text.TextUtils;
import android.view.View;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ExposureView {
    public static final int INITIAL = 0;
    public static final int SEEN = 1;
    public static final int UNSEEN = 2;
    public String block;
    public String tag;
    public View view;
    public Map<String, Object> viewData;
    public long beginTime = 0;
    public long endTime = 0;
    public long lastCalTime = 0;
    public int lastState = 0;
    public double area = 0.0d;

    public ExposureView(View view) {
        this.view = view;
    }

    private String getState(int i) {
        return i == 1 ? "可见" : i == 2 ? "不可见" : "初始值";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof ExposureView)) {
            return TextUtils.equals(this.tag, ((ExposureView) obj).tag);
        }
        return false;
    }

    public int hashCode() {
        return this.tag.hashCode();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isSatisfyTimeRequired() {
        long currentTimeMillis = System.currentTimeMillis() - this.beginTime;
        ExpLogger.d(null, "tag", this.tag, "duration", Long.valueOf(currentTimeMillis));
        return currentTimeMillis > ((long) ExposureConfigMgr.timeThreshold) && currentTimeMillis < ((long) ExposureConfigMgr.maxTimeThreshold);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.view.getClass().getSimpleName());
        sb.append(":");
        sb.append(this.tag);
        sb.append(":");
        sb.append(TextUtils.isEmpty(this.view.getContentDescription()) ? "" : this.view.getContentDescription());
        sb.append(":");
        sb.append(getState(this.lastState));
        return sb.toString();
    }
}
