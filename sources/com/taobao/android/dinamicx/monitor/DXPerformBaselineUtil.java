package com.taobao.android.dinamicx.monitor;

import com.alibaba.fastjson.JSONObject;
import com.taobao.android.dinamicx.template.download.DXTemplateItem;
import tb.nz;
import tb.y00;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class DXPerformBaselineUtil {
    private static boolean a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class Task implements Runnable {
        String baseLineName;
        long consumeTime;
        String templateName;
        long templateVersion;

        public Task(String str, long j, String str2, long j2) {
            this.baseLineName = str;
            this.consumeTime = j;
            this.templateName = str2;
            this.templateVersion = j2;
        }

        /* JADX WARN: Removed duplicated region for block: B:50:0x00d3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:54:0x00dd A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void sendMsg(java.lang.String r8) {
            /*
                Method dump skipped, instructions count: 230
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.taobao.android.dinamicx.monitor.DXPerformBaselineUtil.Task.sendMsg(java.lang.String):void");
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("templateName", (Object) this.templateName);
            jSONObject.put("templateVersion", (Object) Long.valueOf(this.templateVersion));
            jSONObject.put("consumeTime", (Object) Long.valueOf(this.consumeTime));
            jSONObject.put("protocolV", (Object) 1);
            jSONObject.put("perfName", (Object) this.baseLineName);
            jSONObject.put("name", (Object) this.baseLineName);
            jSONObject.put("platform", (Object) "Android");
            jSONObject.put("sdkVersion", (Object) "3.9.10.3");
            String jSONString = jSONObject.toJSONString();
            nz.l(jSONString);
            sendMsg(jSONString);
        }
    }

    public static void a(String str, long j, DXTemplateItem dXTemplateItem) {
        Task task;
        if (a) {
            if (dXTemplateItem != null) {
                task = new Task(str, j, dXTemplateItem.getName(), dXTemplateItem.getVersion());
            } else {
                task = new Task(str, j, "null", -1L);
            }
            y00.k(task);
        }
    }
}
