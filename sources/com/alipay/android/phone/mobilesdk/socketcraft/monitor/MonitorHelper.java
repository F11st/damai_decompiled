package com.alipay.android.phone.mobilesdk.socketcraft.monitor;

import com.alipay.android.phone.mobilesdk.socketcraft.api.DefaultWebSocketClient;
import com.alipay.android.phone.mobilesdk.socketcraft.platform.monitor.MonitorPrinterFactory;
import com.alipay.android.phone.mobilesdk.socketcraft.util.StringUtils;
import com.taobao.weex.annotation.JSMethod;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class MonitorHelper {
    private DefaultWebSocketClient a;
    private SimpleStatistical b;

    public MonitorHelper(DefaultWebSocketClient defaultWebSocketClient) {
        this.a = defaultWebSocketClient;
    }

    public MonitorModel createMonitorModel(String str) {
        MonitorModel monitorModel = new MonitorModel();
        monitorModel.logTitle = str;
        monitorModel.appendAppId(this.a.getBizUniqId());
        monitorModel.appendUrl(this.a.getUrl());
        return monitorModel;
    }

    public SimpleStatistical getSimpleStatistical() {
        SimpleStatistical simpleStatistical = this.b;
        if (simpleStatistical != null) {
            return simpleStatistical;
        }
        SimpleStatistical simpleStatistical2 = new SimpleStatistical();
        this.b = simpleStatistical2;
        return simpleStatistical2;
    }

    public final void noteTraficConsume(DataflowMonitorModel dataflowMonitorModel) {
        MonitorPrinterFactory.getInstance().noteTraficConsume(dataflowMonitorModel);
    }

    public void printConnMonitorLog() {
        getSimpleStatistical().endConnAllTime = System.currentTimeMillis();
        MonitorModel createMonitorModel = createMonitorModel(MonitorItemConstants.WS_MONITOR_TITLE_CONN);
        createMonitorModel.appendDnsTime(String.valueOf(getSimpleStatistical().dnsTime));
        createMonitorModel.appendTcpTime(String.valueOf(getSimpleStatistical().tcpTime));
        createMonitorModel.appendSSLTime(String.valueOf(getSimpleStatistical().sslTime));
        createMonitorModel.appendWsHsTime(String.valueOf(getSimpleStatistical().wsHsTime));
        createMonitorModel.appendTargetHost(getSimpleStatistical().targetHost);
        createMonitorModel.appendAllTime(String.valueOf(getSimpleStatistical().getConnAllTime()));
        createMonitorModel.appendResult(true);
        MonitorPrinterFactory.getInstance().print(createMonitorModel);
    }

    public void printDisconnMonitorLog() {
        getSimpleStatistical().disconnectedTime = System.currentTimeMillis();
        MonitorModel createMonitorModel = createMonitorModel(MonitorItemConstants.WS_MONITOR_TITLE_DISCONN);
        createMonitorModel.appendDownMsgCount(String.valueOf(getSimpleStatistical().recvMsgCount));
        createMonitorModel.appendDownMsgLens(String.valueOf(getSimpleStatistical().recvMsgLenArray));
        createMonitorModel.appendUpMsgCount(String.valueOf(getSimpleStatistical().sendMsgCount));
        createMonitorModel.appendUpMsgLens(String.valueOf(getSimpleStatistical().sendMsgLenArray));
        createMonitorModel.appendLiveTime(String.valueOf(getSimpleStatistical().getLinkLiveTime()));
        MonitorPrinterFactory.getInstance().print(createMonitorModel);
        this.b = null;
    }

    public void printErrorMonitorLog(String str, String str2) {
        MonitorModel createMonitorModel = createMonitorModel("error");
        createMonitorModel.appendCode(str);
        createMonitorModel.appendErrMsg(str2);
        MonitorPrinterFactory.getInstance().print(createMonitorModel);
    }

    public void recordConnectedTime() {
        getSimpleStatistical().connectedTime = System.currentTimeMillis();
    }

    public void recordDnsTime(long j) {
        if (j <= 0) {
            return;
        }
        getSimpleStatistical().dnsTime = j;
    }

    public void recordMonitorOfRecvMsg(int i) {
        SimpleStatistical simpleStatistical = getSimpleStatistical();
        simpleStatistical.recvMsgCount++;
        String str = simpleStatistical.recvMsgLenArray;
        if (str != null && str.length() > 0) {
            simpleStatistical.recvMsgLenArray += JSMethod.NOT_SET + i;
            return;
        }
        simpleStatistical.recvMsgLenArray = String.valueOf(i);
    }

    public void recordMonitorOfSndMsg(int i) {
        SimpleStatistical simpleStatistical = getSimpleStatistical();
        simpleStatistical.sendMsgCount++;
        String str = simpleStatistical.sendMsgLenArray;
        if (str != null && str.length() > 0) {
            simpleStatistical.sendMsgLenArray += JSMethod.NOT_SET + i;
            return;
        }
        simpleStatistical.sendMsgLenArray = String.valueOf(i);
    }

    public void recordSSLTime(long j) {
        if (j <= 0) {
            return;
        }
        getSimpleStatistical().sslTime = j;
    }

    public void recordStartConnAllTime() {
        getSimpleStatistical().startConnAllTime = System.currentTimeMillis();
    }

    public void recordTargetHost(String str) {
        if (StringUtils.isEmpty(str) || "null".equals(str)) {
            return;
        }
        getSimpleStatistical().targetHost = str;
    }

    public void recordTcpTime(long j) {
        if (j <= 0) {
            return;
        }
        getSimpleStatistical().tcpTime = j;
    }

    public void recordWsHsTime(long j) {
        if (j <= 0) {
            return;
        }
        getSimpleStatistical().wsHsTime = j;
    }
}
