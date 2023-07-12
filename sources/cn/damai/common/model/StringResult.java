package cn.damai.common.model;

import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class StringResult implements Serializable {
    public String data;
    public String error;
    public int errorCode = -1;

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public static class Weather {
        public String errMsg;
        public int errNum;
        public WeatherInfo retData;
    }

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public static class WeatherInfo {
        public String city;
        public int temp;
        public String weather;
        public String week;
    }
}
