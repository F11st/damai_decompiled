package mtopsdk.mtop.util;

import com.alibaba.fastjson.JSON;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.domain.BaseOutDo;
import mtopsdk.mtop.domain.IMTOPDataObject;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.MtopResponse;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class MtopConvert {
    private static final String TAG = "mtopsdk.MtopConvert";

    public static <T> T convertJsonToOutputDO(byte[] bArr, Class<T> cls) {
        if (cls != null && bArr != null && bArr.length != 0) {
            try {
                return (T) JSON.parseObject(new String(bArr, "UTF-8"), cls);
            } catch (Throwable th) {
                TBSdkLog.e(TAG, "[jsonToOutputDO]invoke JSON.parseObject error ---Class=" + cls.getName(), th);
                return null;
            }
        }
        TBSdkLog.e(TAG, "[jsonToOutputDO]outputClass is null or jsonData is blank");
        return null;
    }

    public static <T> T convertMtopResponseToOutputDO(MtopResponse mtopResponse, Class<T> cls) {
        if (cls != null && mtopResponse != null) {
            return (T) convertJsonToOutputDO(mtopResponse.getBytedata(), cls);
        }
        TBSdkLog.e(TAG, "outputClass is null or mtopResponse is null");
        return null;
    }

    public static MtopRequest inputDoToMtopRequest(IMTOPDataObject iMTOPDataObject) {
        if (iMTOPDataObject == null) {
            return null;
        }
        return ReflectUtil.convertToMtopRequest(iMTOPDataObject);
    }

    @Deprecated
    public static BaseOutDo jsonToOutputDO(byte[] bArr, Class<?> cls) {
        if (cls != null && bArr != null && bArr.length != 0) {
            try {
                return (BaseOutDo) JSON.parseObject(new String(bArr, "UTF-8"), cls);
            } catch (Throwable th) {
                TBSdkLog.e(TAG, "[jsonToOutputDO]invoke JSON.parseObject error ---Class=" + cls.getName(), th);
                return null;
            }
        }
        TBSdkLog.e(TAG, "[jsonToOutputDO]outClass is null or jsonData is blank");
        return null;
    }

    @Deprecated
    public static BaseOutDo mtopResponseToOutputDO(MtopResponse mtopResponse, Class<?> cls) {
        if (cls != null && mtopResponse != null) {
            return jsonToOutputDO(mtopResponse.getBytedata(), cls);
        }
        TBSdkLog.e(TAG, "outClass is null or response is null");
        return null;
    }

    public static MtopRequest inputDoToMtopRequest(Object obj) {
        if (obj == null) {
            return null;
        }
        return ReflectUtil.convertToMtopRequest(obj);
    }
}
