package com.alibaba.android.umbrella.trace;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class UmbrellaInfo implements Serializable {
    public Map<String, String> args;
    @JSONField(name = "sceneName")
    public String childBizName;
    public String featureType;
    public String invokePage;
    public String invokePageUrl;
    @JSONField(name = "bizName")
    public String mainBizName;
    public String samplingRate;
    @JSONField(name = "serviceId")
    public String tagId;
    @JSONField(name = "version")
    public String tagVersion;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.android.umbrella.trace.UmbrellaInfo$b */
    /* loaded from: classes15.dex */
    public static final class C3276b {
        private String a;
        private String b;
        private String c;
        private String d;
        private String e;
        private String f;
        private String g;
        private String h;
        private Map<String, String> i;

        public C3276b(String str, String str2, String str3, String str4, String str5) {
            this.a = str;
            this.b = str2;
            this.e = str3;
            this.c = str4;
            this.d = str5;
        }

        public UmbrellaInfo a() {
            UmbrellaInfo umbrellaInfo = new UmbrellaInfo();
            umbrellaInfo.tagId = this.a;
            umbrellaInfo.tagVersion = this.b;
            umbrellaInfo.mainBizName = this.c;
            umbrellaInfo.childBizName = this.d;
            umbrellaInfo.featureType = this.e;
            umbrellaInfo.samplingRate = this.f;
            umbrellaInfo.invokePage = this.g;
            umbrellaInfo.invokePageUrl = this.h;
            umbrellaInfo.args = this.i;
            return umbrellaInfo;
        }

        public C3276b b(Map<String, String> map) {
            if (map == null) {
                return this;
            }
            if (this.i == null) {
                this.i = new HashMap();
            }
            this.i.putAll(map);
            return this;
        }

        public C3276b c(String str) {
            this.b = str;
            return this;
        }
    }

    public String toJsonString() {
        return JSON.toJSONString(this);
    }

    private UmbrellaInfo() {
    }
}
