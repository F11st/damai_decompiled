package com.taobao.orange.model;

import android.text.TextUtils;
import com.taobao.orange.GlobalOrange;
import com.taobao.orange.util.OLog;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ConfigDO implements CheckDO, Serializable {
    protected static final String TAG = "ConfigDO";
    private static final long serialVersionUID = 6057693726984967889L;
    public String appKey;
    public String appVersion;
    public CandidateDO candidate;
    private String changeVersion;
    public Map<String, String> content;
    public String createTime;
    public String id;
    public String loadLevel;
    public String name;
    public String resourceId;
    public String type;
    public String version;
    private int configStatus = 0;
    public transient boolean persisted = true;
    public volatile transient boolean monitored = false;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface ConfigStatus {
        public static final int DEFAULT = 0;
        public static final int NEED_UPDATE = 2;

        /* compiled from: Taobao */
        @Retention(RetentionPolicy.CLASS)
        /* loaded from: classes11.dex */
        public @interface Definition {
        }
    }

    @Override // com.taobao.orange.model.CheckDO
    public boolean checkValid() {
        Map<String, String> map;
        if (!TextUtils.isEmpty(this.appKey) && !TextUtils.isEmpty(this.appVersion) && !TextUtils.isEmpty(this.id) && !TextUtils.isEmpty(this.name) && !TextUtils.isEmpty(this.resourceId) && !TextUtils.isEmpty(this.type) && !TextUtils.isEmpty(this.loadLevel) && !TextUtils.isEmpty(this.version) && (map = this.content) != null && !map.isEmpty()) {
            boolean z = (jn1.MUL.equals(this.appVersion) || GlobalOrange.appVersion.equals(this.appVersion)) && GlobalOrange.appKey.equals(this.appKey);
            if (!z) {
                OLog.w(TAG, "invaild", new Object[0]);
            }
            return z;
        }
        OLog.w(TAG, "lack param", new Object[0]);
        return false;
    }

    public String getChangeVersion() {
        return this.changeVersion;
    }

    public int getConfigStatus() {
        return this.configStatus;
    }

    public String getCurVersion() {
        CandidateDO candidateDO = this.candidate;
        return candidateDO == null ? this.version : candidateDO.version;
    }

    public void setChangeVersion(String str) {
        this.changeVersion = str;
    }

    public void setConfigStatus(int i) {
        this.configStatus = i;
    }

    public String toString() {
        return String.format("ConfigDO{name:'%s', appVersion:'%s', verison:'%s', type:'%s'}", this.name, this.appVersion, this.version, this.type);
    }
}
