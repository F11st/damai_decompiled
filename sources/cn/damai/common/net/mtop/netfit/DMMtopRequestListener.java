package cn.damai.common.net.mtop.netfit;

import android.text.TextUtils;
import android.util.Log;
import cn.damai.common.net.mtop.Util;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.tao.remotebusiness.IRemoteBaseListener;
import com.uc.webview.export.media.MessageID;
import java.io.UnsupportedEncodingException;
import me.ele.altriax.launcher.common.AltriaXLaunchTime;
import mtopsdk.mtop.domain.BaseOutDo;
import mtopsdk.mtop.domain.MtopResponse;
import tb.b23;
import tb.m61;
import tb.zm2;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public abstract class DMMtopRequestListener<T> implements IRemoteBaseListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private Class<T> clazz;
    public boolean isShowLoginUI;

    public DMMtopRequestListener(Class<T> cls) {
        this.clazz = cls;
    }

    private void XFlushUtilFail(String str, String str2, String str3, String str4, String str5, String str6) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "739589616")) {
            ipChange.ipc$dispatch("739589616", new Object[]{this, str, str2, str3, str4, str5, str6});
            return;
        }
        b23.c(str, "mtop", str2 + " 自定义code=" + str3 + AltriaXLaunchTime.SPACE + str4, str5, str6);
    }

    private void errorLog(int i, MtopResponse mtopResponse, String str) {
        String str2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1944008590")) {
            ipChange.ipc$dispatch("1944008590", new Object[]{this, Integer.valueOf(i), mtopResponse, str});
            return;
        }
        String str3 = "   requestType=" + i + "  DMMtopRequestListener  fromError= " + str;
        try {
            if (mtopResponse == null) {
                XFlushUtilFail("", "服务端返回response为null", ERROR.MTOP_XFLUSH_ERROR_CODE, str3, "", "");
            } else {
                String e = m61.e(mtopResponse);
                XFlushUtilFail(getAlarmApiName(mtopResponse), mtopResponse.getRetCode(), ERROR.MTOP_XFLUSH_ERROR_CODE, e + str3, mtopResponse.getRetCode(), mtopResponse.getRetMsg());
            }
        } catch (Exception e2) {
            String alarmApiName = getAlarmApiName(mtopResponse);
            if ((str3 + AltriaXLaunchTime.SPACE + e2) != null) {
                str2 = e2.getMessage() + " trace=" + zm2.a(e2);
            } else {
                str2 = null;
            }
            XFlushUtilFail(alarmApiName, "服务端异常trycatch", ERROR.MTOP_XFLUSH_ERROR_CODE, str2, mtopResponse == null ? "" : mtopResponse.getRetCode(), mtopResponse != null ? mtopResponse.getRetMsg() : "");
        }
    }

    private String getAlarmApiName(MtopResponse mtopResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-224873413")) {
            return (String) ipChange.ipc$dispatch("-224873413", new Object[]{this, mtopResponse});
        }
        if (mtopResponse == null) {
            return null;
        }
        return Util.getApiParam(mtopResponse.getApi(), mtopResponse.getMtopStat() != null ? mtopResponse.getMtopStat().url : "");
    }

    private void reloadNetworkErrorXFlushMonitor(String str, String str2, String str3, String str4, String str5, String str6) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-386507605")) {
            ipChange.ipc$dispatch("-386507605", new Object[]{this, str, str2, str3, str4, str5, str6});
            return;
        }
        XFlushUtilFail(str2, b23.i(str, str2, str4, str5, str6 + "  DMMtopRequestListener"), str3, str5, str4, str5);
    }

    public void dispatchStringResult(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1878220674")) {
            ipChange.ipc$dispatch("1878220674", new Object[]{this, str});
        }
    }

    @Override // com.taobao.tao.remotebusiness.IRemoteListener
    public void onError(int i, MtopResponse mtopResponse, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "330833763")) {
            ipChange.ipc$dispatch("330833763", new Object[]{this, Integer.valueOf(i), mtopResponse, obj});
            return;
        }
        if (mtopResponse != null) {
            DMMtopErrorHelper.instance().setIsShowLoginUI(this.isShowLoginUI).error(mtopResponse);
            onFail(mtopResponse.getRetCode(), Util.getErrorMsg(mtopResponse));
        } else {
            onFail("", "");
        }
        errorLog(i, mtopResponse, MessageID.onError);
    }

    public abstract void onFail(String str, String str2);

    @Override // com.taobao.tao.remotebusiness.IRemoteListener
    public void onSuccess(int i, MtopResponse mtopResponse, BaseOutDo baseOutDo, Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1721156404")) {
            ipChange.ipc$dispatch("1721156404", new Object[]{this, Integer.valueOf(i), mtopResponse, baseOutDo, obj});
        } else if (mtopResponse == null) {
        } else {
            try {
                String str5 = new String(mtopResponse.getBytedata(), "UTF-8");
                DMMtopBaseData dMMtopBaseData = (DMMtopBaseData) JSON.parseObject(str5, DMMtopBaseData.class);
                if (dMMtopBaseData != null) {
                    String data = dMMtopBaseData.getData();
                    JSONObject parseObject = JSON.parseObject(data);
                    if (!data.equalsIgnoreCase("")) {
                        String string = parseObject.getString("errorCode");
                        String string2 = parseObject.getString("errorMsg");
                        if (!TextUtils.isEmpty(string)) {
                            onFail(string, string2);
                            errorLog(i, mtopResponse, "onsuccess_to_error");
                            return;
                        }
                        Class<T> cls = this.clazz;
                        Object b = m61.b(data, cls, Util.getApiParam(dMMtopBaseData.getApi(), mtopResponse.getMtopStat() != null ? mtopResponse.getMtopStat().url : ""), ERROR.MTOP_XFLUSH_PARSE_CODE, string, string2 + "  DMMtopRequestListener");
                        try {
                            if (b != null) {
                                dispatchStringResult(data);
                                onSuccess(b);
                                b23.f(getAlarmApiName(mtopResponse), "mtop", "2000", "-", "traceId = " + Util.getTraceId(mtopResponse));
                                return;
                            }
                            Class<T> cls2 = this.clazz;
                            str = string2;
                            str2 = string;
                            str3 = data;
                            try {
                                reloadNetworkErrorXFlushMonitor(cls2 != null ? cls2.getName() : "class是null", TextUtils.isEmpty(getAlarmApiName(mtopResponse)) ? "apiName未正常获取" : getAlarmApiName(mtopResponse), "-1000000", "parse_0", "解析数据返回为null", str5);
                                onFail("parse_0", "麦麦开小差了");
                            } catch (Exception e) {
                                e = e;
                                e.printStackTrace();
                                Log.e("parse_1", e.getMessage());
                                Class<T> cls3 = this.clazz;
                                String name = cls3 != null ? cls3.getName() : "class是null";
                                String alarmApiName = TextUtils.isEmpty(getAlarmApiName(mtopResponse)) ? "apiName未正常获取" : getAlarmApiName(mtopResponse);
                                String str6 = TextUtils.isEmpty(str2) ? "parse_1" : str2;
                                if ((str3 + AltriaXLaunchTime.SPACE + "DMMtopRequestListener " + e) != null) {
                                    str4 = " trace=" + zm2.a(e);
                                } else {
                                    str4 = null;
                                }
                                reloadNetworkErrorXFlushMonitor(name, alarmApiName, "-1000000", str6, str, str4);
                                onFail("parse_1", "麦麦开小差了");
                            }
                        } catch (Exception e2) {
                            e = e2;
                            str = string2;
                            str2 = string;
                            str3 = data;
                        }
                    } else {
                        Class<T> cls4 = this.clazz;
                        reloadNetworkErrorXFlushMonitor(cls4 != null ? cls4.getName() : "class是null", TextUtils.isEmpty(getAlarmApiName(mtopResponse)) ? "apiName未正常获取" : getAlarmApiName(mtopResponse), "-1000000", "parse_2", "result为null", str5);
                        onFail("parse_2", "麦麦开小差了");
                    }
                } else {
                    Class<T> cls5 = this.clazz;
                    reloadNetworkErrorXFlushMonitor(cls5 != null ? cls5.getName() : "class是null", TextUtils.isEmpty(getAlarmApiName(mtopResponse)) ? "apiName未正常获取" : getAlarmApiName(mtopResponse), "-1000000", "parse_3", "mtopBaseData为null", str5);
                    onFail("parse_3", "麦麦开小差了");
                }
            } catch (UnsupportedEncodingException e3) {
                e3.printStackTrace();
                Class<T> cls6 = this.clazz;
                reloadNetworkErrorXFlushMonitor(cls6 != null ? cls6.getName() : "class是null", TextUtils.isEmpty(getAlarmApiName(mtopResponse)) ? "apiName未正常获取" : getAlarmApiName(mtopResponse), "-1000000", "parse_4", "result为null", zm2.a(e3));
                onFail("parse_4", "麦麦开小差了");
            }
        }
    }

    public abstract void onSuccess(T t);

    @Override // com.taobao.tao.remotebusiness.IRemoteBaseListener
    public void onSystemError(int i, MtopResponse mtopResponse, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "947835508")) {
            ipChange.ipc$dispatch("947835508", new Object[]{this, Integer.valueOf(i), mtopResponse, obj});
            return;
        }
        if (mtopResponse != null) {
            DMMtopErrorHelper.instance().setIsShowLoginUI(this.isShowLoginUI).error(mtopResponse);
            if (mtopResponse.isSessionInvalid() && this.isShowLoginUI) {
                onFail(mtopResponse.getRetCode(), "");
            } else {
                onFail(mtopResponse.getRetCode(), Util.getErrorMsg(mtopResponse));
            }
        } else {
            onFail("", "");
        }
        errorLog(i, mtopResponse, "onSystemError");
    }

    public void setShowLoginUI(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-864864782")) {
            ipChange.ipc$dispatch("-864864782", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.isShowLoginUI = z;
        }
    }
}
