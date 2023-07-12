package cn.damai.common.net.mtop.netfit;

import cn.damai.common.net.mtop.Util;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.tao.remotebusiness.IRemoteBaseListener;
import com.taobao.tao.remotebusiness.IRemoteCacheListener;
import java.io.UnsupportedEncodingException;
import mtopsdk.mtop.common.MtopCacheEvent;
import mtopsdk.mtop.domain.BaseOutDo;
import mtopsdk.mtop.domain.MtopResponse;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public abstract class DMMtopCacheListener<T> implements IRemoteBaseListener, IRemoteCacheListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private Class<T> clazz;

    public DMMtopCacheListener(Class<T> cls) {
        this.clazz = cls;
    }

    public abstract void onCache(T t);

    @Override // com.taobao.tao.remotebusiness.IRemoteCacheListener
    public void onCached(MtopCacheEvent mtopCacheEvent, BaseOutDo baseOutDo, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1222940143")) {
            ipChange.ipc$dispatch("1222940143", new Object[]{this, mtopCacheEvent, baseOutDo, obj});
            return;
        }
        try {
            DMMtopBaseData dMMtopBaseData = (DMMtopBaseData) JSON.parseObject(new String(mtopCacheEvent.mtopResponse.getBytedata(), "UTF-8"), DMMtopBaseData.class);
            if (dMMtopBaseData != null) {
                String data = dMMtopBaseData.getData();
                Object obj2 = JSON.parseObject(data).get("result");
                if (obj2 != null) {
                    onCache(JSON.parseObject(obj2.toString(), this.clazz));
                } else if (!data.equalsIgnoreCase("")) {
                    onCache(JSON.parseObject(data, this.clazz));
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Override // com.taobao.tao.remotebusiness.IRemoteListener
    public void onError(int i, MtopResponse mtopResponse, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "451214742")) {
            ipChange.ipc$dispatch("451214742", new Object[]{this, Integer.valueOf(i), mtopResponse, obj});
        } else if (mtopResponse != null) {
            onFail(mtopResponse.getRetCode(), Util.getErrorMsg(mtopResponse));
        } else {
            onFail("", "");
        }
    }

    public abstract void onFail(String str, String str2);

    @Override // com.taobao.tao.remotebusiness.IRemoteListener
    public void onSuccess(int i, MtopResponse mtopResponse, BaseOutDo baseOutDo, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1370376351")) {
            ipChange.ipc$dispatch("-1370376351", new Object[]{this, Integer.valueOf(i), mtopResponse, baseOutDo, obj});
            return;
        }
        try {
            DMMtopBaseData dMMtopBaseData = (DMMtopBaseData) JSON.parseObject(new String(mtopResponse.getBytedata(), "UTF-8"), DMMtopBaseData.class);
            if (dMMtopBaseData != null) {
                String data = dMMtopBaseData.getData();
                Object obj2 = JSON.parseObject(data).get("result");
                if (obj2 != null) {
                    onSuccess(JSON.parseObject(obj2.toString(), this.clazz));
                } else if (!data.equalsIgnoreCase("")) {
                    onSuccess(JSON.parseObject(data, this.clazz));
                } else {
                    onFail("", "麦麦开小差了");
                }
            } else {
                onFail("", "麦麦开小差了");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public abstract void onSuccess(T t);

    @Override // com.taobao.tao.remotebusiness.IRemoteBaseListener
    public void onSystemError(int i, MtopResponse mtopResponse, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1609236071")) {
            ipChange.ipc$dispatch("1609236071", new Object[]{this, Integer.valueOf(i), mtopResponse, obj});
        } else if (mtopResponse != null) {
            onFail(mtopResponse.getRetCode(), Util.getErrorMsg(mtopResponse));
        } else {
            onFail("", "");
        }
    }
}
