package cn.damai.trade.newtradeorder.ui.orderdetail.helper;

import android.text.TextUtils;
import cn.damai.common.net.mtop.netfit.DMMtopBaseData;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.UnsupportedEncodingException;
import mtopsdk.mtop.domain.BaseOutDo;
import mtopsdk.mtop.domain.MtopResponse;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public abstract class OrderPayListener<T> extends DMMtopRequestListener<T> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Class<T> clazzT;

    public OrderPayListener(Class<T> cls) {
        super(cls);
        this.clazzT = cls;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener, com.taobao.tao.remotebusiness.IRemoteListener
    public void onSuccess(int i, MtopResponse mtopResponse, BaseOutDo baseOutDo, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1159114056")) {
            ipChange.ipc$dispatch("1159114056", new Object[]{this, Integer.valueOf(i), mtopResponse, baseOutDo, obj});
        } else if (mtopResponse != null) {
            try {
                DMMtopBaseData dMMtopBaseData = (DMMtopBaseData) JSON.parseObject(new String(mtopResponse.getBytedata(), "UTF-8"), DMMtopBaseData.class);
                if (dMMtopBaseData != null) {
                    String data = dMMtopBaseData.getData();
                    JSONObject parseObject = JSON.parseObject(data);
                    if (!data.equalsIgnoreCase("")) {
                        String string = parseObject.getString("errorCode");
                        String string2 = parseObject.getString("errorMsg");
                        if (!TextUtils.isEmpty(string)) {
                            onFail(string, string2);
                        } else {
                            onSuccess(JSON.parseObject(parseObject.getString("result"), this.clazzT));
                        }
                    } else {
                        onFail("", "解析错误");
                    }
                } else {
                    onFail("", "解析错误");
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }
}
