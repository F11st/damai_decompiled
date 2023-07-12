package com.taobao.orange.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.alibaba.fastjson.JSON;
import com.taobao.orange.GlobalOrange;
import com.taobao.orange.OConstant;
import com.taobao.orange.OThreadFactory;
import com.taobao.orange.model.ConfigAckDO;
import com.taobao.orange.model.IndexAckDO;
import com.taobao.orange.sync.BaseAuthRequest;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import tb.x6;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ReportAckUtils {
    static final int MSG_REPORT_CONFIGACKS = 1;
    static final int MSG_WAIT_CONFIGACKS = 0;
    static final String TAG = "ReportAck";
    private static Handler handler = new ConfigHandler(Looper.getMainLooper());
    static final Set<ConfigAckDO> mConfigAckDOSet = new HashSet();

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    static class ConfigHandler extends Handler {
        ConfigHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                if (OLog.isPrintLog(1)) {
                    OLog.d(ReportAckUtils.TAG, "wait config acks", new Object[0]);
                }
                sendEmptyMessageDelayed(1, 30000L);
            } else if (i != 1) {
            } else {
                Set<ConfigAckDO> set = ReportAckUtils.mConfigAckDOSet;
                synchronized (set) {
                    if (OLog.isPrintLog(1)) {
                        OLog.d(ReportAckUtils.TAG, "report config acks", "size", Integer.valueOf(set.size()));
                    }
                    HashSet hashSet = new HashSet();
                    hashSet.addAll(set);
                    ReportAckUtils.reportConfigAcks(hashSet);
                    set.clear();
                }
            }
        }
    }

    public static void reportConfigAck(ConfigAckDO configAckDO) {
        x6.b().commitStat(configAckDO);
        if (!GlobalOrange.reportUpdateAck || configAckDO == null) {
            return;
        }
        Set<ConfigAckDO> set = mConfigAckDOSet;
        synchronized (set) {
            if (set.size() == 0) {
                handler.sendEmptyMessage(0);
            }
            set.add(configAckDO);
        }
    }

    static void reportConfigAcks(final Set<ConfigAckDO> set) {
        if (!GlobalOrange.reportUpdateAck || set.size() == 0) {
            return;
        }
        OThreadFactory.execute(new Runnable() { // from class: com.taobao.orange.util.ReportAckUtils.1
            @Override // java.lang.Runnable
            public void run() {
                if (GlobalOrange.reportUpdateAck) {
                    new BaseAuthRequest(null, true, OConstant.REQTYPE_ACK_CONFIG_UPDATE) { // from class: com.taobao.orange.util.ReportAckUtils.1.1
                        @Override // com.taobao.orange.sync.BaseAuthRequest
                        protected Map<String, String> getReqParams() {
                            return null;
                        }

                        @Override // com.taobao.orange.sync.BaseAuthRequest
                        protected String getReqPostBody() {
                            return JSON.toJSONString(set);
                        }

                        @Override // com.taobao.orange.sync.BaseAuthRequest
                        protected Object parseResContent(String str) {
                            return null;
                        }
                    }.syncRequest();
                }
            }
        }, GlobalOrange.randomDelayAckInterval);
    }

    public static void reportIndexAck(final IndexAckDO indexAckDO) {
        x6.b().commitStat(indexAckDO);
        if (GlobalOrange.reportUpdateAck) {
            if (OLog.isPrintLog(1)) {
                OLog.d(TAG, "report index ack", indexAckDO);
            }
            OThreadFactory.execute(new Runnable() { // from class: com.taobao.orange.util.ReportAckUtils.2
                @Override // java.lang.Runnable
                public void run() {
                    if (GlobalOrange.reportUpdateAck) {
                        new BaseAuthRequest(null, true, OConstant.REQTYPE_ACK_INDEX_UPDATE) { // from class: com.taobao.orange.util.ReportAckUtils.2.1
                            @Override // com.taobao.orange.sync.BaseAuthRequest
                            protected Map<String, String> getReqParams() {
                                return null;
                            }

                            @Override // com.taobao.orange.sync.BaseAuthRequest
                            protected String getReqPostBody() {
                                return JSON.toJSONString(IndexAckDO.this);
                            }

                            @Override // com.taobao.orange.sync.BaseAuthRequest
                            protected Object parseResContent(String str) {
                                return null;
                            }
                        }.syncRequest();
                    }
                }
            }, GlobalOrange.randomDelayAckInterval);
        }
    }
}
