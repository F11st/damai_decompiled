package com.taobao.weex.utils.tools;

import android.text.TextUtils;
import android.util.Log;
import com.alibaba.fastjson.annotation.JSONField;
import com.taobao.weex.WXEnvironment;
import java.util.Locale;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class LogDetail {
    public static final String KeyWords_Render = "Weex_Render";
    public static final String KeyWrod_Init = "Weex_Init";
    public String keyWords = KeyWords_Render;
    @JSONField(name = "time")
    public Time time = new Time();
    @JSONField(name = "Info")
    public Info info = new Info();

    public void keyWorkds(String str) {
        this.keyWords = str;
    }

    public void name(String str) {
        this.time.a();
        this.info.taskName = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String lowerCase = str.toLowerCase(Locale.ROOT);
        if (lowerCase.contains("module") || lowerCase.contains("component") || lowerCase.contains("framework")) {
            this.keyWords = KeyWrod_Init;
        }
    }

    public void println() {
        if (WXEnvironment.isPerf()) {
            Log.e(TimeCalculator.TIMELINE_TAG, " timeline " + this.keyWords + " java LogDetail: " + toString());
        }
    }

    public void taskEnd() {
        this.time.taskEnd();
        println();
    }

    public void taskStart() {
        this.time.taskStart();
    }

    public String toString() {
        return "taskName : " + this.info.taskName + " - LogDetail : {time = '" + this.time + "', info = '" + this.info + "'}";
    }
}
