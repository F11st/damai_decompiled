package com.taobao.monitor.adapter.logger;

import com.taobao.monitor.logger.IDataLogger;
import com.taobao.tao.log.TLog;
import java.util.Map;
import org.json.JSONObject;
import tb.vm2;
import tb.xu1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class LoggerAdapter implements IDataLogger {
    /* JADX INFO: Access modifiers changed from: private */
    public String b(Object... objArr) {
        String obj;
        if (objArr == null || objArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Object obj2 : objArr) {
            if (obj2 != null) {
                if (obj2 instanceof Map) {
                    obj = c((Map) obj2);
                } else {
                    obj = obj2.toString();
                }
                sb.append("->");
                sb.append(obj);
            }
        }
        return sb.toString();
    }

    private String c(Map map) {
        return new JSONObject(map).toString();
    }

    @Override // com.taobao.monitor.logger.IDataLogger
    public void log(final String str, final Object... objArr) {
        vm2.d(new Runnable() { // from class: com.taobao.monitor.adapter.logger.LoggerAdapter.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    TLog.loge(xu1.DEFAULT_SAVE_DIR, str, LoggerAdapter.this.b(objArr));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
