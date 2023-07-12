package com.youku.playerservice.axp.utils;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.youku.playerservice.axp.item.BitStream;
import com.youku.playerservice.axp.item.Codec;
import com.youku.playerservice.axp.item.MediaMap;
import com.youku.playerservice.axp.item.Quality;
import com.youku.playerservice.axp.item.SliceItem;
import com.youku.playerservice.axp.playparams.PlayParams;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class BitStreamUtil {
    public static final String TAG = "BitStreamUtil";

    public static BitStream createBitStreamByRefer(PlayParams playParams, String str) {
        BitStream bitStream = null;
        try {
            Uri parse = Uri.parse(str);
            String queryParameter = parse.getQueryParameter("streamurl");
            if (!TextUtils.isEmpty(parse.getQueryParameter("fastTsUrl"))) {
                queryParameter = parse.getQueryParameter("fastTsUrl");
            }
            if (TextUtils.isEmpty(queryParameter)) {
                return null;
            }
            String sessionId = playParams.getSessionId();
            TLogUtil.flowLog(sessionId, "fastTsUrl=" + queryParameter);
            SliceItem createSliceItem = SliceItem.createSliceItem(queryParameter);
            String streamType = createSliceItem.getStreamType();
            int totalDuration = createSliceItem.getTotalDuration();
            MediaMap.MediaFormat media = MediaMap.getMedia(streamType);
            Quality requestQuality = playParams.getPlayIdParams().getRequestQuality();
            Codec codec = Codec.H264;
            if (media != null) {
                requestQuality = media.getQuality();
                codec = media.getCodec();
            }
            BitStream bitStream2 = new BitStream(requestQuality, streamType, codec, totalDuration);
            try {
                bitStream2.setSliceItem(createSliceItem);
                playParams.putString("pagePlayMode", parse.getQueryParameter("playMode"));
                return bitStream2;
            } catch (Exception e) {
                e = e;
                bitStream = bitStream2;
                e.printStackTrace();
                TLogUtil.flowLog(playParams.getSessionId(), Log.getStackTraceString(e));
                playParams.putString("fastTsUrlRetry", "27007");
                return bitStream;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }
}
