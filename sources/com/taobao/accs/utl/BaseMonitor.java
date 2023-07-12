package com.taobao.accs.utl;

import anet.channel.statist.StatObject;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public abstract class BaseMonitor extends StatObject {
    public static final String ALARM_MSG_ROUTING_RATE = "ele_routing_rate";
    public static final String ALARM_POINT_AUTH = "auth";
    public static final String ALARM_POINT_BIND = "bind";
    public static final String ALARM_POINT_CONNECT = "connect";
    public static final String ALARM_POINT_REQUEST = "Request_Success_Rate";
    public static final String ALARM_POINT_REQ_ERROR = "send_fail";
    public static final String ALARM_REMOVE_ALIAS = "agoo_rm_alias";
    public static final String ALARM_SET_ALIAS = "agoo_set_alias";
    public static final String ARG_NET_FINE_NO_CONNECT = "conn_err_01";
    public static final String BACKGROUND_RECV_MSG = "bg_recv_msg";
    public static final String COUNT_ACK = "ack";
    public static final String COUNT_AGOO_ACK = "agoo_ack";
    public static final String COUNT_AGOO_ARRIVE = "agoo_arrive";
    public static final String COUNT_AGOO_ARRIVE_ID = "agoo_arrive_id";
    public static final String COUNT_AGOO_ARRIVE_REAL_ID = "agoo_arrive_real_id";
    public static final String COUNT_AGOO_CLICK = "agoo_click";
    public static final String COUNT_AGOO_FAIL_ACK = "agoo_fail_ack";
    public static final String COUNT_AGOO_REPORT_ID = "agoo_report_id";
    public static final String COUNT_AGOO_SUCCESS_ACK = "agoo_success_ack";
    public static final String COUNT_AGOO_TOTAL_ARRIVE = "agoo_total_arrive";
    public static final String COUNT_APPKEY_CHANGED = "appkey_change_cnt";
    public static final String COUNT_BUSINESS_ACK_FAIL = "bizAckFail";
    public static final String COUNT_BUSINESS_ACK_SUCC = "bizAckSucc";
    public static final String COUNT_CHANNEL_ENABLED = "channel_enabled";
    public static final String COUNT_COLD_LAUNCH_TIME = "cold_launch_time";
    public static final String COUNT_ERROR = "error";
    public static final String COUNT_FAKE_CONN = "accs_fake_connection";
    public static final String COUNT_FORE_BG = "fore_bg_cnt";
    public static final String COUNT_HB_DELAY = "accs_heartbeat_delay";
    public static final String COUNT_POINT_DNS = "dns";
    public static final String COUNT_POINT_REGID_DISABLE = "regId_disable";
    public static final String COUNT_POINT_REGID_EXCEPTION = "regId_exception";
    public static final String COUNT_POINT_REGID_NATIVE = "regId_native";
    public static final String COUNT_POINT_REGID_ONLINE = "regId_online";
    public static final String COUNT_POINT_RESEND = "resend";
    public static final String COUNT_POINT_SOFAIL = "sofail";
    public static final String COUNT_POINT_TO_BUSS = "to_buss";
    public static final String COUNT_POINT_TO_BUSS_SUCCESS = "to_buss_success";
    public static final String COUNT_SERVICE_ALIVE = "service_alive";
    public static final String COUNT_SESSION_ERROR = "session_error";
    public static final String MODULE = "accs";
    private boolean isCommitted = false;

    @Override // anet.channel.statist.StatObject
    public boolean beforeCommit() {
        if (this.isCommitted) {
            return false;
        }
        this.isCommitted = true;
        return true;
    }

    public String checkString(String str) {
        return str == null ? "none" : str;
    }
}
