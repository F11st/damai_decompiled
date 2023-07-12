package com.youku.upsplayer.module;

import com.alibaba.fastjson.annotation.JSONField;
import com.youku.live.dago.liveplayback.widget.PluginName;
import com.youku.upsplayer.util.YKUpsConvert;
import java.util.Arrays;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class Segs {
    @JSONField(name = PluginName.AD)
    public int ad;
    @JSONField(name = "cdn_backup")
    public String[] cdn_backup;
    @JSONField(name = "cdn_backup_template")
    public String cdn_backup_template;
    @JSONField(name = "cdn_url")
    public String cdn_url;
    @JSONField(name = "cdn_url_template")
    public String cdn_url_template;
    @JSONField(name = YKUpsConvert.FILEID)
    public String fileid;
    @JSONField(name = "key")
    public Object key = null;
    @JSONField(name = "md5")
    public String md5;
    @JSONField(name = "rtmp_url")
    public String rtmp_url;
    @JSONField(name = "rtmp_url_template")
    public String rtmp_url_template;
    @JSONField(name = "size")
    public long size;
    @JSONField(name = "tma")
    public int tma;
    @JSONField(name = "tmv")
    public int tmv;
    @JSONField(name = "total_milliseconds_audio")
    public int total_milliseconds_audio;
    @JSONField(name = "total_milliseconds_video")
    public int total_milliseconds_video;

    public String toString() {
        return "Segs{total_milliseconds_video=" + this.total_milliseconds_video + ", total_milliseconds_audio=" + this.total_milliseconds_audio + ", size=" + this.size + ", fileid='" + this.fileid + "', md5='" + this.md5 + "', cdn_url='" + this.cdn_url + "', cdn_backup=" + Arrays.toString(this.cdn_backup) + ", rtmp_url='" + this.rtmp_url + "', ad=" + this.ad + ", key=" + this.key + ", tmv=" + this.tmv + ", tma=" + this.tma + ", cdn_url_template='" + this.cdn_url_template + "', rtmp_url_template='" + this.rtmp_url_template + "', cdn_backup_template='" + this.cdn_backup_template + "'}";
    }
}
