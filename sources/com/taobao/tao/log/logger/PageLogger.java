package com.taobao.tao.log.logger;

import android.text.TextUtils;
import androidx.annotation.Keep;
import com.alibaba.fastjson.annotation.JSONField;
import com.taobao.tao.log.LogCategory;
import com.taobao.tao.log.LogLevel;
import com.taobao.tao.log.TLogNative;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
@Keep
/* loaded from: classes11.dex */
public class PageLogger extends ILogger implements Serializable {
    public static final int PAGE_STATUS_APPEAR = 2;
    public static final int PAGE_STATUS_DISAPPEAR = 3;
    public static final int PAGE_STATUS_ENTER = 1;
    public static final int PAGE_STATUS_LEAVE = 4;
    public static final int PAGE_TYPE_ACTIVITY = 1;
    public static final int PAGE_TYPE_FRAGMENT = 2;
    public static final int PAGE_TYPE_UNKNOWN = 0;
    private static final String TAG = "PageLog";
    @JSONField(name = "id")
    private String pageID;
    @JSONField(name = "status")
    private int pageStatus;
    @JSONField(name = "name")
    private String pageName = null;
    @JSONField(name = "type")
    private int pageType = 0;
    @JSONField(name = "url")
    private String pageUrl = null;

    private PageLogger(int i, String str) {
        this.pageStatus = i;
        this.pageID = str;
    }

    public static PageLogger builder(int i, String str) {
        return new PageLogger(i, str);
    }

    public String getPageID() {
        return this.pageID;
    }

    public String getPageName() {
        return this.pageName;
    }

    public int getPageStatus() {
        return this.pageStatus;
    }

    public int getPageType() {
        return this.pageType;
    }

    public String getPageUrl() {
        return this.pageUrl;
    }

    @Override // com.taobao.tao.log.logger.ILogger
    public void log() {
        TLogNative.writeLog(LogCategory.PageLog, LogLevel.I, TAG, "", toString());
    }

    public PageLogger setData(Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            if (this.data == null) {
                this.data = new HashMap();
            }
            this.data.putAll(map);
        }
        return this;
    }

    public PageLogger setPageID(String str) {
        this.pageID = str;
        return this;
    }

    public PageLogger setPageName(String str) {
        this.pageName = str;
        return this;
    }

    public PageLogger setPageType(int i) {
        this.pageType = i;
        return this;
    }

    public PageLogger setPageUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            this.pageUrl = null;
        } else if (str.length() > 20480) {
            this.pageUrl = str.substring(0, 20480);
        }
        this.pageUrl = str;
        return this;
    }

    public PageLogger setData(String str, String str2) {
        if (this.data == null) {
            this.data = new HashMap();
        }
        this.data.put(str, str2);
        return this;
    }

    public PageLogger setData(Map.Entry<String, String> entry) {
        if (this.data == null) {
            this.data = new HashMap();
        }
        this.data.put(entry.getKey(), entry.getValue());
        return this;
    }
}
