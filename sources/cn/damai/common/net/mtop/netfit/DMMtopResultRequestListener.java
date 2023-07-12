package cn.damai.common.net.mtop.netfit;

import android.text.TextUtils;
import cn.damai.common.app.base.BaseErrorBean;
import cn.damai.common.net.mtop.Util;
import cn.damai.common.net.mtop.netfit.DMMtopResultBaseData;
import com.alibaba.fastjson.JSON;
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
public abstract class DMMtopResultRequestListener<T> implements IRemoteBaseListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private Class<T> clazz;
    public boolean isShowLoginUI;

    public DMMtopResultRequestListener(Class<T> cls) {
        this.clazz = cls;
    }

    private void XFlushUtilFail(String str, String str2, String str3, String str4, String str5, String str6) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1348286739")) {
            ipChange.ipc$dispatch("1348286739", new Object[]{this, str, str2, str3, str4, str5, str6});
            return;
        }
        b23.c(str, "mtop", str2 + " 自定义code=" + str3 + AltriaXLaunchTime.SPACE + str4, str5, str6);
    }

    private void errorLog(int i, MtopResponse mtopResponse, String str) {
        String str2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1336955509")) {
            ipChange.ipc$dispatch("-1336955509", new Object[]{this, Integer.valueOf(i), mtopResponse, str});
            return;
        }
        String str3 = "   requestType=" + i + "  DMMtopRequestListener   fromError= " + str;
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
        if (AndroidInstantRuntime.support(ipChange, "1390638174")) {
            return (String) ipChange.ipc$dispatch("1390638174", new Object[]{this, mtopResponse});
        }
        if (mtopResponse == null) {
            return null;
        }
        return Util.getApiParam(mtopResponse.getApi(), mtopResponse.getMtopStat() != null ? mtopResponse.getMtopStat().url : "");
    }

    @Override // com.taobao.tao.remotebusiness.IRemoteListener
    public void onError(int i, MtopResponse mtopResponse, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1299024442")) {
            ipChange.ipc$dispatch("-1299024442", new Object[]{this, Integer.valueOf(i), mtopResponse, obj});
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
        String name;
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-634911439")) {
            ipChange.ipc$dispatch("-634911439", new Object[]{this, Integer.valueOf(i), mtopResponse, baseOutDo, obj});
        } else if (mtopResponse != null) {
            try {
                String str2 = new String(mtopResponse.getBytedata(), "UTF-8");
                String alarmApiName = getAlarmApiName(mtopResponse);
                DMMtopResultBaseData.BaseMtopResponseData baseMtopResponseData = (DMMtopResultBaseData.BaseMtopResponseData) m61.a(str2, DMMtopResultBaseData.BaseMtopResponseData.class);
                if (baseMtopResponseData != null && baseMtopResponseData.getData() != null) {
                    String result = baseMtopResponseData.getData().getResult();
                    if (TextUtils.isEmpty(result)) {
                        onFail("1000", "result为空");
                        Class<T> cls = this.clazz;
                        name = cls != null ? cls.getName() : null;
                        XFlushUtilFail(alarmApiName, b23.i(name, mtopResponse.getApi(), mtopResponse.getRetCode(), mtopResponse.getRetMsg(), m61.e(mtopResponse) + " DMMtopResultRequestListener "), "-1000000", "result为空", mtopResponse.getRetCode(), mtopResponse.getRetMsg());
                        return;
                    }
                    BaseErrorBean baseErrorBean = (BaseErrorBean) m61.a(result, BaseErrorBean.class);
                    if (baseErrorBean != null && (str = baseErrorBean.errorCode) != null) {
                        onFail(str, baseErrorBean.errorMsg);
                        Class<T> cls2 = this.clazz;
                        name = cls2 != null ? cls2.getName() : null;
                        XFlushUtilFail(alarmApiName, b23.i(name, mtopResponse.getApi(), mtopResponse.getRetCode() + " " + baseErrorBean.errorCode, mtopResponse.getRetMsg() + AltriaXLaunchTime.SPACE + baseErrorBean.errorMsg, m61.e(mtopResponse) + " DMMtopResultRequestListener "), ERROR.MTOP_XFLUSH_PARSE_CODE, "result解析异常", mtopResponse.getRetCode(), mtopResponse.getRetMsg());
                        return;
                    }
                    onSuccess(JSON.parseObject(result, this.clazz));
                    b23.f(alarmApiName, "mtop", "2000", "-", "traceId = " + Util.getTraceId(mtopResponse));
                    return;
                }
                onFail("1000", "data为空");
                Class<T> cls3 = this.clazz;
                name = cls3 != null ? cls3.getName() : null;
                XFlushUtilFail(alarmApiName, b23.i(name, mtopResponse.getApi(), mtopResponse.getRetCode(), mtopResponse.getRetMsg(), m61.e(mtopResponse) + "  DMMtopResultRequestListener "), "-1000000", "data为空", mtopResponse.getRetCode(), mtopResponse.getRetMsg());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }

    public abstract void onSuccess(T t);

    @Override // com.taobao.tao.remotebusiness.IRemoteBaseListener
    public void onSystemError(int i, MtopResponse mtopResponse, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1731620201")) {
            ipChange.ipc$dispatch("-1731620201", new Object[]{this, Integer.valueOf(i), mtopResponse, obj});
            return;
        }
        if (mtopResponse != null) {
            DMMtopErrorHelper.instance().setIsShowLoginUI(this.isShowLoginUI).error(mtopResponse);
            onFail(mtopResponse.getRetCode(), Util.getErrorMsg(mtopResponse));
        } else {
            onFail("", "");
        }
        errorLog(i, mtopResponse, "onSystemError");
    }

    public void setShowLoginUI(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1000902993")) {
            ipChange.ipc$dispatch("-1000902993", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.isShowLoginUI = z;
        }
    }
}
