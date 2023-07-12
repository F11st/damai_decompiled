package com.youku.upsplayer.module;

import com.ali.user.mobile.login.model.LoginConstant;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class FirstSlice {
    @JSONField(name = "encodeType")
    public String encodeType;
    @JSONField(name = "firstSlice")
    public String firstSlice;
    @JSONField(name = "firstSliceCLeanStream")
    public boolean firstSliceCLeanStream;
    @JSONField(name = "firstSliceDiscontinueNum")
    public long firstSliceDiscontinueNum;
    @JSONField(name = "firstSliceDur")
    public long firstSliceDur;
    @JSONField(name = "firstSlicePos")
    public long firstSlicePos;
    @JSONField(name = "firstSliceSequenceNum")
    public long firstSliceSequenceNum;
    @JSONField(name = "firstSliceSize")
    public long firstSliceSize;
    @JSONField(name = "historySlice")
    public String historySlice;
    @JSONField(name = "historySliceDiscontinueNum")
    public Long historySliceDiscontinueNum;
    @JSONField(name = "historySliceDuration")
    public Long historySliceDuration;
    @JSONField(name = "historySlicePos")
    public Long historySlicePos;
    @JSONField(name = "historySliceSequenceNum")
    public Long historySliceSequenceNum;
    @JSONField(name = "historySliceSize")
    public Long historySliceSize;
    @JSONField(name = "langCode")
    public String langCode;
    @JSONField(name = "openingSlice")
    public String openingSlice;
    @JSONField(name = "openingSliceCleanStream")
    public boolean openingSliceCleanStream;
    @JSONField(name = "openingSliceDiscontinueNum")
    public long openingSliceDiscontinueNum;
    @JSONField(name = "openingSliceDur")
    public int openingSliceDur;
    @JSONField(name = "openingSliceDuration")
    public long openingSliceDuration;
    @JSONField(name = "openingSlicePos")
    public long openingSlicePos;
    @JSONField(name = "openingSliceSequenceNum")
    public long openingSliceSequenceNum;
    @JSONField(name = "openingSliceSize")
    public long openingSliceSize;
    @JSONField(name = "playConfig")
    public JSONObject playConf;
    @JSONField(name = LoginConstant.START_TIME)
    public double startTime = -1.0d;
    @JSONField(name = "stream_type")
    public String stream_type;
}
