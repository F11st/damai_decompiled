package com.youku.playerservice.axp.item;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.youku.playerservice.axp.utils.TLogUtil;
import com.youku.playerservice.axp.utils.Utils;
import com.youku.vpm.constants.TableField;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class SliceItem {
    private long mStartPos;
    private String mStreamType;
    private int mTotalDuration;
    private double mTsDurSeconds;
    private String tsSeqNum;
    private String tsUrl;

    private SliceItem(String str, double d) {
        this.tsUrl = str;
        this.mTsDurSeconds = d;
    }

    public static SliceItem createSliceItem(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Uri parse = Uri.parse(str);
            String queryParameter = parse.getQueryParameter(TableField.STREAM_TYPE);
            int parseInt = Utils.parseInt(parse.getQueryParameter("zpms"), 0);
            int parseInt2 = Utils.parseInt(parse.getQueryParameter("fpseconds"), 0);
            int parseInt3 = Utils.parseInt(parse.getQueryParameter("point"), 0);
            double d = parseInt2;
            SliceItem sliceItem = new SliceItem(str, d);
            sliceItem.mStartPos = parseInt3;
            sliceItem.mTsDurSeconds = d;
            sliceItem.mTotalDuration = parseInt;
            sliceItem.mStreamType = queryParameter;
            return sliceItem;
        } catch (Exception e) {
            e.printStackTrace();
            TLogUtil.playLog(Log.getStackTraceString(e));
            return null;
        }
    }

    public static SliceItem createSliceItemByLiveJson(String str) {
        JSONObject parseObject;
        if (TextUtils.isEmpty(str) || (parseObject = JSON.parseObject(str)) == null) {
            return null;
        }
        String string = parseObject.getString("firstSliceTS");
        String string2 = parseObject.getString("firstSliceSeqNum");
        if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
            double doubleValue = parseObject.getDoubleValue("duration");
            if (doubleValue == 0.0d) {
                doubleValue = parseObject.getIntValue("duration");
            }
            SliceItem sliceItem = new SliceItem(string, doubleValue);
            sliceItem.tsSeqNum = string2;
            return sliceItem;
        }
        return null;
    }

    public long getStartPos() {
        return this.mStartPos;
    }

    public String getStreamType() {
        return this.mStreamType;
    }

    public int getTotalDuration() {
        return this.mTotalDuration;
    }

    public double getTsDurSeconds() {
        return this.mTsDurSeconds;
    }

    public String getTsSeqNum() {
        return this.tsSeqNum;
    }

    public String getTsUrl() {
        return this.tsUrl;
    }
}
