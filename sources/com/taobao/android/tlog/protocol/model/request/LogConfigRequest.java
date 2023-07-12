package com.taobao.android.tlog.protocol.model.request;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.tlog.protocol.model.CommandInfo;
import com.taobao.android.tlog.protocol.model.request.base.Logger;
import com.taobao.android.tlog.protocol.model.request.base.RollingFileAppender;
import com.taobao.android.tlog.protocol.model.request.base.RollingPolicy;
import com.taobao.weex.common.Constants;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class LogConfigRequest {
    private String TAG = "TLOG.Protocol.LogConfigRequest";
    public Map<String, RollingFileAppender> appenders;
    public Boolean destroy;
    public Boolean enable;
    public String level;
    public Map<String, Logger> loggers;
    public String module;

    private Map<String, RollingFileAppender> appendersParse(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, Object> entry : jSONObject.entrySet()) {
            String key = entry.getKey();
            JSONObject jSONObject2 = (JSONObject) entry.getValue();
            RollingFileAppender rollingFileAppender = new RollingFileAppender();
            if (jSONObject2 != null) {
                if (jSONObject2.containsKey("fileName")) {
                    rollingFileAppender.fileName = jSONObject2.getString("fileName");
                }
                if (jSONObject2.containsKey("filePattern")) {
                    rollingFileAppender.filePattern = jSONObject2.getString("filePattern");
                }
                if (jSONObject2.containsKey("level")) {
                    rollingFileAppender.level = jSONObject2.getString("level");
                }
                if (jSONObject2.containsKey("name")) {
                    rollingFileAppender.name = jSONObject2.getString("name");
                }
                if (jSONObject2.containsKey("pattern")) {
                    rollingFileAppender.pattern = jSONObject2.getString("pattern");
                }
                if (jSONObject2.containsKey("rollingPolicy")) {
                    JSONObject jSONObject3 = jSONObject2.getJSONObject("rollingPolicy");
                    RollingPolicy rollingPolicy = new RollingPolicy();
                    if (jSONObject3.containsKey("maxHistory")) {
                        rollingPolicy.maxHistory = jSONObject3.getInteger("maxHistory").intValue();
                    }
                    if (jSONObject3.containsKey("totalSizeCap")) {
                        rollingPolicy.totalSizeCap = jSONObject3.getString("totalSizeCap");
                    }
                    rollingFileAppender.rollingPolicy = rollingPolicy;
                }
                hashMap.put(key, rollingFileAppender);
            }
        }
        return hashMap;
    }

    private Map<String, Logger> loggerParse(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, Object> entry : jSONObject.entrySet()) {
            String key = entry.getKey();
            JSONObject jSONObject2 = (JSONObject) entry.getValue();
            Logger logger = new Logger();
            if (jSONObject2 != null) {
                if (jSONObject2.containsKey("appender")) {
                    logger.appender = jSONObject2.getString("appender");
                }
                if (jSONObject2.containsKey("level")) {
                    logger.level = jSONObject2.getString("level");
                }
                if (jSONObject2.containsKey("module")) {
                    logger.module = jSONObject2.getString("module");
                }
                if (jSONObject2.containsKey("tag")) {
                    logger.tag = jSONObject2.getString("tag");
                }
            }
            hashMap.put(key, logger);
        }
        return hashMap;
    }

    public void parse(JSON json, CommandInfo commandInfo) throws Exception {
        JSONObject jSONObject = (JSONObject) json;
        if (jSONObject.containsKey("enable")) {
            this.enable = jSONObject.getBoolean("enable");
        }
        if (jSONObject.containsKey(Constants.Event.SLOT_LIFECYCLE.DESTORY)) {
            this.destroy = jSONObject.getBoolean(Constants.Event.SLOT_LIFECYCLE.DESTORY);
        }
        if (jSONObject.containsKey("level")) {
            this.level = jSONObject.getString("level");
        }
        if (jSONObject.containsKey("module")) {
            this.module = jSONObject.getString("module");
        }
        if (jSONObject.containsKey("appenders")) {
            this.appenders = appendersParse(jSONObject.getJSONObject("appenders"));
        }
        if (jSONObject.containsKey("loggers")) {
            this.loggers = loggerParse(jSONObject.getJSONObject("loggers"));
        }
    }
}
