package com.alibaba.emas.publish.channel.mtop;

import androidx.annotation.Keep;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
@Keep
/* loaded from: classes15.dex */
public class PublishMtopRequest implements Serializable {
    public List<String> bizTypes;
    public String API_NAME = "mtop.alibaba.emas.publish.update.get";
    public String VERSION = "1.0";
    public boolean NEED_ECODE = false;
    public boolean NEED_SESSION = true;
    public String appVersion = null;
    public String model = null;
    public String locale = null;
    public String md5Sum = null;
    public String channel = null;
    public long apiLevel = 0;
    public Map<String, String> versions = null;
    public String brand = null;
    public String identifier = null;
    public Map<String, String> args = null;
}
