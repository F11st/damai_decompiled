package com.ali.alihadeviceevaluator.network;

import android.util.Log;
import com.taobao.tao.remotebusiness.IRemoteBaseListener;
import com.taobao.tao.remotebusiness.IRemoteListener;
import com.taobao.tao.remotebusiness.MtopBusiness;
import com.uc.webview.export.media.MessageID;
import mtopsdk.mtop.domain.BaseOutDo;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.intf.Mtop;
import tb.gu0;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class RemoteDeviceManager implements IRemoteBaseListener {
    public static final String TAG = "RemoteDeviceManager";
    private DataCaptureListener dataCaptureListener;

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public interface DataCaptureListener {
        void onFailed();

        void onReceive(float f);
    }

    public RemoteDeviceManager(DataCaptureListener dataCaptureListener) {
        this.dataCaptureListener = dataCaptureListener;
    }

    public void fetchData() {
        MtopTaobaoHaQueryRequest mtopTaobaoHaQueryRequest = new MtopTaobaoHaQueryRequest();
        mtopTaobaoHaQueryRequest.setBizid("1");
        MtopBusiness.build(Mtop.instance(Mtop.Id.INNER, gu0.a), mtopTaobaoHaQueryRequest).registerListener((IRemoteListener) this).startRequest(MtopTaobaoHaQueryResponse.class);
    }

    @Override // com.taobao.tao.remotebusiness.IRemoteListener
    public void onError(int i, MtopResponse mtopResponse, Object obj) {
        Log.e(TAG, MessageID.onError + i);
        this.dataCaptureListener.onFailed();
    }

    @Override // com.taobao.tao.remotebusiness.IRemoteListener
    public void onSuccess(int i, MtopResponse mtopResponse, BaseOutDo baseOutDo, Object obj) {
        if (baseOutDo == null || !(baseOutDo instanceof MtopTaobaoHaQueryResponse)) {
            return;
        }
        try {
            this.dataCaptureListener.onReceive(Float.valueOf(((MtopTaobaoHaQueryResponse) baseOutDo).getData().score).floatValue());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    @Override // com.taobao.tao.remotebusiness.IRemoteBaseListener
    public void onSystemError(int i, MtopResponse mtopResponse, Object obj) {
        Log.e(TAG, "onSystemError:" + i);
        this.dataCaptureListener.onFailed();
    }
}
