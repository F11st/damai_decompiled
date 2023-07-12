package com.taobao.tao.log.logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.taobao.tao.log.logger.ILogger;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class ILogger {
    @JSONField(name = "data")
    protected Map<String, String> data = null;

    public Map<String, String> getData() {
        return this.data;
    }

    public abstract void log();

    public void log(Executor executor) {
        if (executor != null) {
            executor.execute(new Runnable() { // from class: tb.x01
                @Override // java.lang.Runnable
                public final void run() {
                    ILogger.this.log();
                }
            });
        }
    }

    public String toString() {
        return JSON.toJSONString(this);
    }
}
