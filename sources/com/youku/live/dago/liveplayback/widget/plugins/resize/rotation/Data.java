package com.youku.live.dago.liveplayback.widget.plugins.resize.rotation;

import androidx.annotation.Keep;
import com.alibaba.fastjson.annotation.JSONField;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.caverock.androidsvg.SVGParser;
import java.util.HashMap;
import tb.jn1;

/* compiled from: Taobao */
@Keep
/* loaded from: classes2.dex */
public class Data {
    @JSONField(name = "conf")
    public Frame[] frames;
    @JSONField(name = "persons")
    public Person[] persons;
    @JSONField(name = "timebase")
    public String timebase;
    @JSONField(name = "version")
    public String version;

    /* compiled from: Taobao */
    @Keep
    /* loaded from: classes2.dex */
    public class Frame {
        private static transient /* synthetic */ IpChange $ipChange;
        @JSONField(name = SVGParser.XML_STYLESHEET_ATTR_MEDIA)
        public Media media;
        @JSONField(name = "pts")
        public long pts;
        @JSONField(name = "t")
        public double t;

        /* compiled from: Taobao */
        @Keep
        /* loaded from: classes2.dex */
        public class Media {
            @JSONField(name = "centerpoint")
            public float centerPoint;
            @JSONField(name = "onlyyou")
            public HashMap<String, Float> onlyYou;

            public Media() {
            }
        }

        public Frame() {
        }

        public String toString() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1517751871")) {
                return (String) ipChange.ipc$dispatch("-1517751871", new Object[]{this});
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(jn1.ARRAY_START_STR);
            stringBuffer.append("pts=");
            stringBuffer.append(this.pts);
            stringBuffer.append(",");
            stringBuffer.append("t=");
            stringBuffer.append(this.t);
            stringBuffer.append(",");
            stringBuffer.append("point=");
            stringBuffer.append(this.media.centerPoint);
            stringBuffer.append(",");
            stringBuffer.append("onlyYou=");
            stringBuffer.append(this.media.onlyYou);
            stringBuffer.append(jn1.ARRAY_END_STR);
            return stringBuffer.toString();
        }
    }

    /* compiled from: Taobao */
    @Keep
    /* loaded from: classes2.dex */
    public class Person {
        @JSONField(name = "id")
        public String id;
        @JSONField(name = "name")
        public String name;
        @JSONField(name = "url")
        public String url;

        public Person() {
        }
    }
}
