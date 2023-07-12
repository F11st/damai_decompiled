package com.taobao.accs.ut.monitor;

import anet.channel.statist.Dimension;
import anet.channel.statist.Measure;
import anet.channel.statist.Monitor;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.weex.common.Constants;

/* compiled from: Taobao */
@Monitor(module = "accs", monitorPoint = "netperformance")
/* loaded from: classes8.dex */
public class NetPerformanceMonitor extends BaseMonitor {
    @Dimension
    public int accs_sdk_version;
    @Dimension
    public int accs_type;
    public String data_id;
    private long enter_queue_date;
    @Dimension
    public int error_code;
    @Dimension
    public String fail_reasons;
    @Dimension
    public String host;
    @Measure(constantValue = 0.0d, max = 60000.0d, min = 0.0d)
    public long in_queue_time;
    @Measure(constantValue = 0.0d, max = 60000.0d, min = 0.0d)
    public long parse_to_ack_time;
    @Measure(constantValue = 0.0d, max = 60000.0d, min = 0.0d)
    public long rcv_to_parse_time;
    private long receive_ack_date;
    private long receive_unparse_date;
    @Dimension
    public String ret;
    @Dimension
    public int retry_times;
    @Measure(constantValue = 0.0d, max = 60000.0d, min = 0.0d)
    public long rtt;
    @Measure(constantValue = 0.0d, max = 60000.0d, min = 0.0d)
    public long send_to_rcv_time;
    @Dimension
    public String service_id = "none";
    @Dimension
    public String service_type;
    private long start_parse_date;
    private long start_send_date;
    @Measure(constantValue = 0.0d, max = 60000.0d, min = 0.0d)
    public long start_to_enter_queue_time;
    public long take_date;
    @Measure(constantValue = 0.0d, max = 60000.0d, min = 0.0d)
    public long take_to_send_time;
    public long to_tnet_date;
    @Measure(constantValue = 0.0d, max = 60000.0d, min = 0.0d)
    public long total_time;

    private long computeTime(long j, long j2) {
        if (j <= 0 || j2 <= 0) {
            return 0L;
        }
        return j2 - j;
    }

    @Override // com.taobao.accs.utl.BaseMonitor, anet.channel.statist.StatObject
    public boolean beforeCommit() {
        this.accs_sdk_version = Constants.SDK_VERSION_CODE;
        this.total_time = computeTime(this.start_send_date, this.receive_ack_date);
        this.rtt = computeTime(this.to_tnet_date, this.receive_ack_date);
        this.start_to_enter_queue_time = computeTime(this.start_send_date, this.enter_queue_date);
        this.in_queue_time = computeTime(this.enter_queue_date, this.take_date);
        this.take_to_send_time = computeTime(this.take_date, this.to_tnet_date);
        this.send_to_rcv_time = computeTime(this.to_tnet_date, this.receive_unparse_date);
        this.rcv_to_parse_time = computeTime(this.receive_unparse_date, this.start_parse_date);
        this.parse_to_ack_time = computeTime(this.start_parse_date, this.receive_ack_date);
        return super.beforeCommit();
    }

    public void onEnterQueueData() {
        this.enter_queue_date = System.currentTimeMillis();
    }

    public void onRecAck() {
        this.receive_ack_date = System.currentTimeMillis();
    }

    public void onRecUnParse(long j) {
        this.receive_unparse_date = j;
    }

    public void onSend() {
        this.start_send_date = System.currentTimeMillis();
    }

    public void onSendData() {
        this.to_tnet_date = System.currentTimeMillis();
    }

    public void onStartParse(long j) {
        this.start_parse_date = j;
    }

    public void onTakeFromQueue() {
        this.take_date = System.currentTimeMillis();
    }

    public void setConnType(int i) {
        this.accs_type = i;
    }

    public void setDataId(String str) {
        this.data_id = str;
    }

    public void setFailReason(String str) {
        this.fail_reasons = str;
    }

    public void setHost(String str) {
        this.host = str;
    }

    public void setRet(boolean z) {
        this.ret = z ? Constants.Name.Y : "n";
    }

    public void setServiceId(String str) {
        this.service_id = str;
    }

    public void setServiceType(String str) {
        this.service_type = str;
    }

    public void setFailReason(int i) {
        this.error_code = i;
        if (i == -4) {
            setFailReason("msg too large");
        } else if (i == -3) {
            setFailReason("service not available");
        } else if (i == -2) {
            setFailReason("param error");
        } else if (i == -1) {
            setFailReason("network fail");
        } else if (i != 200) {
            if (i != 300) {
                setFailReason(String.valueOf(i));
            } else {
                setFailReason("app not bind");
            }
        }
    }
}
