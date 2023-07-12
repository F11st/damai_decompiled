package com.youku.skinmanager.impl;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.alibaba.fastjson.JSON;
import com.youku.skinmanager.download.DownloadManager;
import com.youku.skinmanager.download.IDownloadListener;
import com.youku.skinmanager.entity.SkinDTO;
import mtopsdk.mtop.common.MtopCallback;
import mtopsdk.mtop.common.MtopFinishEvent;
import mtopsdk.mtop.domain.MtopResponse;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
class SkinMtopListener implements MtopCallback.MtopFinishListener {
    public static final String TAG = "SkinMtopListener";
    private IDownloadListener listener;

    public SkinMtopListener(@Nullable IDownloadListener iDownloadListener) {
        this.listener = iDownloadListener;
    }

    @Override // mtopsdk.mtop.common.MtopCallback.MtopFinishListener
    public void onFinished(MtopFinishEvent mtopFinishEvent, Object obj) {
        MtopResponse mtopResponse = mtopFinishEvent.getMtopResponse();
        if (mtopResponse.isApiSuccess()) {
            Log.e(TAG, "mTop api success!");
            SkinDTO skinDTO = (SkinDTO) JSON.parseObject(mtopResponse.getDataJsonObject().toString(), SkinDTO.class);
            if (TextUtils.isEmpty(skinDTO.getId())) {
                Log.e(TAG, "onFinished skin is null");
                IDownloadListener iDownloadListener = this.listener;
                if (iDownloadListener != null) {
                    iDownloadListener.onFail(null);
                    return;
                }
                return;
            }
            DownloadManager.getInstance().startDownload(skinDTO, this.listener);
            return;
        }
        Log.e(TAG, "other error");
        IDownloadListener iDownloadListener2 = this.listener;
        if (iDownloadListener2 != null) {
            iDownloadListener2.onFail(null);
        }
    }
}
