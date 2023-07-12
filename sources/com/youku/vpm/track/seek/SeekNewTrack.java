package com.youku.vpm.track.seek;

import android.text.TextUtils;
import com.uc.webview.export.media.CommandID;
import com.youku.media.arch.instruments.utils.RemoteLogger;
import com.youku.vpm.BaseTrack;
import com.youku.vpm.constants.TableField;
import com.youku.vpm.framework.TableId;
import com.youku.vpm.param.CustomParams;
import com.youku.vpm.proxy.VpmProxy;
import com.youku.vpm.track.Track;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class SeekNewTrack extends BaseTrack {
    public static final String TAG = "SeekNewTrack";
    public String cdnExtrasInfo;
    public String cdnIp;
    public String decodingType;
    public String fileFormat;
    public String playerStatus;
    public String seekBufferBytes;
    public String seekBufferTime;
    public String seekFrom;
    public String seekInBuffer;
    public String seekResult;
    public String seekTime;
    public String seekTo;
    public String traces;
    public String tsUrl;

    public SeekNewTrack(Track track) {
        super(track);
    }

    public void commitSeek(boolean z, String str) {
        getTableWithCreate(TableId.ONECHANGE_SEEK);
        this.decodingType = getTable(TableId.ONEPLAY).getDimensions().get("decodingType");
        HashMap hashMap = new HashMap();
        hashMap.put("seekFrom", this.seekFrom);
        hashMap.put(CommandID.seekTo, this.seekTo);
        hashMap.put("seekTime", this.seekTime);
        hashMap.put("seekBufferTime", this.seekBufferTime);
        hashMap.put("seekBufferBytes", this.seekBufferBytes);
        hashMap.put("seekResult", this.seekResult);
        hashMap.put("playerStatus", this.playerStatus);
        hashMap.put("traces", this.traces);
        hashMap.put("decodingType", this.decodingType);
        hashMap.put("seekInBuffer", this.seekInBuffer);
        hashMap.put("m3u8Url", this.mTrack.getString("m3u8Url"));
        hashMap.put("tsUrl", this.tsUrl);
        hashMap.put(TableField.FILE_FORMAT, this.fileFormat);
        hashMap.put("cdnIp", this.cdnIp);
        hashMap.put("cdnExtrasInfo", this.cdnExtrasInfo);
        RemoteLogger.log(TAG, TAG + hashMap);
        VpmProxy.commitNewSeek(hashMap, new HashMap());
    }

    public synchronized void onInfoUpdate(String str) {
        if (!TextUtils.isEmpty(str)) {
            Map<String, String> data = new CustomParams(str, ";", "=").getData();
            if (!TextUtils.isEmpty(data.get("cdnIp"))) {
                this.cdnIp = data.get("cdnIp");
            }
            if (!TextUtils.isEmpty(data.get("url"))) {
                this.tsUrl = data.get("url");
            }
        }
    }

    public synchronized void onSeekCancel() {
        commitSeek(true, "back");
    }

    public synchronized void onSeekComplete() {
        commitSeek(true, "success");
    }

    public synchronized void onSeekFail() {
        commitSeek(false, "fail");
    }
}
