package com.youku.live.messagechannel.message;

import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.orange.OrangeConfig;
import com.youku.live.messagechannel.conf.OrangeConfKey;
import com.youku.live.messagechannel.utils.MyLog;
import com.youku.live.messagechannel.utils.UTEvent;
import io.reactivex.AbstractC8149d;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.C8162a;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class MCMessageReporter {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int MAX_REPORT_MESSAGES_COUNT = 10000;
    private static final String TAG = "com.youku.live.messagechannel.message.MCMessageReporter";
    private static MCMessageReporter mcMessageReporter = new MCMessageReporter();
    private String closeDataReportSwitch;
    private String closeHighDiscardMsgDataReportSwitch;
    private Disposable mcMessageReportErrorQueueDisposable;
    private Disposable mcMessageReportQueueDisposable;
    private String reportDistributeInterval;
    private MCMessageStream<MCMessageDispatch4UTRecord> mcMessageReportQueue = new MCMessageStream<>();
    private MCMessageStream<MCMessage> mcMessageReportErrorQueue = new MCMessageStream<>();

    public MCMessageReporter() {
        OrangeConfig orangeConfig = OrangeConfig.getInstance();
        OrangeConfKey.KeyInfo keyInfo = OrangeConfKey.closeHighDiscardMsgDataReport;
        this.closeHighDiscardMsgDataReportSwitch = orangeConfig.getConfig(OrangeConfKey.Group.android_youku_messagechannel, keyInfo.name, keyInfo.def);
        OrangeConfig orangeConfig2 = OrangeConfig.getInstance();
        OrangeConfKey.KeyInfo keyInfo2 = OrangeConfKey.closeDataReport;
        this.closeDataReportSwitch = orangeConfig2.getConfig(OrangeConfKey.Group.android_youku_messagechannel, keyInfo2.name, keyInfo2.def);
        OrangeConfig orangeConfig3 = OrangeConfig.getInstance();
        OrangeConfKey.KeyInfo keyInfo3 = OrangeConfKey.reportDistributeInterval;
        this.reportDistributeInterval = orangeConfig3.getConfig(OrangeConfKey.Group.android_youku_messagechannel, keyInfo3.name, keyInfo3.def);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        this.mcMessageReportQueueDisposable = this.mcMessageReportQueue.getObservable().subscribeOn(C8162a.a()).filter(new Predicate<MCMessageDispatch4UTRecord>() { // from class: com.youku.live.messagechannel.message.MCMessageReporter.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // io.reactivex.functions.Predicate
            public boolean test(MCMessageDispatch4UTRecord mCMessageDispatch4UTRecord) throws Exception {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1126373235")) {
                    return ((Boolean) ipChange.ipc$dispatch("-1126373235", new Object[]{this, mCMessageDispatch4UTRecord})).booleanValue();
                }
                if ("1".equals(MCMessageReporter.this.closeDataReportSwitch)) {
                    return false;
                }
                return ("1".equals(MCMessageReporter.this.closeHighDiscardMsgDataReportSwitch) && QoS.isHigh(mCMessageDispatch4UTRecord.qos)) ? false : true;
            }
        }).buffer(Integer.valueOf(this.reportDistributeInterval).intValue(), timeUnit, 10000).subscribe(new Consumer<List<MCMessageDispatch4UTRecord>>() { // from class: com.youku.live.messagechannel.message.MCMessageReporter.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // io.reactivex.functions.Consumer
            public void accept(List<MCMessageDispatch4UTRecord> list) throws Exception {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-2004418247")) {
                    ipChange.ipc$dispatch("-2004418247", new Object[]{this, list});
                } else if (list == null || list.isEmpty()) {
                } else {
                    String jSONString = JSON.toJSONString(list);
                    HashMap hashMap = new HashMap(8);
                    hashMap.put("messages", jSONString);
                    UTEvent.record("dispatchMessages", hashMap);
                    MyLog.v(MCMessageReporter.TAG, "UT event dispatch record, msgsSerialized:", jSONString);
                }
            }
        });
        this.mcMessageReportErrorQueueDisposable = this.mcMessageReportErrorQueue.getObservable().subscribeOn(C8162a.a()).filter(new Predicate<MCMessage>() { // from class: com.youku.live.messagechannel.message.MCMessageReporter.4
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // io.reactivex.functions.Predicate
            public boolean test(MCMessage mCMessage) throws Exception {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "-1454267521") ? ((Boolean) ipChange.ipc$dispatch("-1454267521", new Object[]{this, mCMessage})).booleanValue() : !"1".equals(MCMessageReporter.this.closeDataReportSwitch);
            }
        }).buffer(Integer.valueOf(this.reportDistributeInterval).intValue(), timeUnit, 10000).subscribe(new Consumer<List<MCMessage>>() { // from class: com.youku.live.messagechannel.message.MCMessageReporter.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // io.reactivex.functions.Consumer
            public void accept(List<MCMessage> list) throws Exception {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-618214853")) {
                    ipChange.ipc$dispatch("-618214853", new Object[]{this, list});
                } else if (list == null || list.isEmpty()) {
                } else {
                    String jSONString = JSON.toJSONString(list);
                    HashMap hashMap = new HashMap(8);
                    hashMap.put("messages", jSONString);
                    UTEvent.record("dispatchErrorMessages", hashMap);
                    MyLog.v(MCMessageReporter.TAG, "UT event dispatch error record, msgsSerialized:", jSONString);
                }
            }
        });
    }

    public static MCMessageReporter getInstance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1744267737")) {
            return (MCMessageReporter) ipChange.ipc$dispatch("-1744267737", new Object[0]);
        }
        if (!mcMessageReporter.isAvailable()) {
            synchronized (MCMessageReporter.class) {
                if (!mcMessageReporter.isAvailable()) {
                    mcMessageReporter = new MCMessageReporter();
                    HashMap hashMap = new HashMap(8);
                    hashMap.put("event", "newInstance");
                    UTEvent.record("msgReporter", hashMap);
                    MyLog.w(TAG, "MCMessageReporter is not available, create new instance.");
                }
            }
        }
        return mcMessageReporter;
    }

    private boolean isAvailable() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1571124532")) {
            return ((Boolean) ipChange.ipc$dispatch("-1571124532", new Object[]{this})).booleanValue();
        }
        boolean isDisposed = this.mcMessageReportQueueDisposable.isDisposed();
        boolean isDisposed2 = this.mcMessageReportErrorQueueDisposable.isDisposed();
        if (isDisposed || isDisposed2) {
            HashMap hashMap = new HashMap(8);
            hashMap.put("event", "isNotAvailable");
            hashMap.put("reportDisposableAvailable", String.valueOf(isDisposed));
            hashMap.put("reportErrorDisposableAvailable", String.valueOf(isDisposed2));
            UTEvent.record("msgReporter", hashMap);
            MyLog.w(TAG, "MCMessageReporter is not available, reportDisposableAvailable: ", Boolean.valueOf(isDisposed), ", reportErrorDisposableAvailable: ", Boolean.valueOf(isDisposed2));
            return false;
        }
        return true;
    }

    public void reportErrorMessages(MCMessage mCMessage) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1798007691")) {
            ipChange.ipc$dispatch("-1798007691", new Object[]{this, mCMessage});
        } else {
            AbstractC8149d.just(mCMessage).subscribe(this.mcMessageReportErrorQueue);
        }
    }

    public void reportMessages(MCMessageDispatch4UTRecord mCMessageDispatch4UTRecord) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1971106643")) {
            ipChange.ipc$dispatch("-1971106643", new Object[]{this, mCMessageDispatch4UTRecord});
        } else {
            AbstractC8149d.just(mCMessageDispatch4UTRecord).subscribe(this.mcMessageReportQueue);
        }
    }
}
