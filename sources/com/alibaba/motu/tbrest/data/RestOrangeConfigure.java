package com.alibaba.motu.tbrest.data;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class RestOrangeConfigure {
    private static final int DEFAULT_MESSAGE_COUNT = 50;
    private static final float DEFAULT_SAMPLE = 1.0f;
    private static final int DEFAULT_SIZE = 40960;
    private static final int MAX_MESSAGE_COUNT = 500;
    private static final int MAX_SIZE = 1048576;
    private float allSample;
    private int dataSize;
    private final Map<String, Float> floatHashMap;
    private int messageCount;
    private boolean useOldLogic;

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    private static class Holder {
        static final RestOrangeConfigure INSTANCE = new RestOrangeConfigure();

        private Holder() {
        }
    }

    public static RestOrangeConfigure instance() {
        return Holder.INSTANCE;
    }

    public float getAllSample() {
        float f = this.allSample;
        if (f < 0.0f || f > 1.0f) {
            return 1.0f;
        }
        return f;
    }

    public int getDataSize() {
        int i = this.dataSize;
        return (i <= 0 || i > 1048576) ? DEFAULT_SIZE : i;
    }

    public int getMessageCount() {
        int i = this.messageCount;
        if (i <= 0 || i > 500) {
            return 50;
        }
        return i;
    }

    public float getSampleByEventID(String str) {
        Float f = this.floatHashMap.get(str);
        if (f != null) {
            return Math.min(f.floatValue(), this.allSample);
        }
        return Math.min(1.0f, this.allSample);
    }

    public boolean isUseOldLogic() {
        return this.useOldLogic;
    }

    public void setAllSample(float f) {
        if (f >= 0.0f && f <= 1.0f) {
            this.allSample = f;
        } else {
            this.allSample = 1.0f;
        }
    }

    public void setDataSize(int i) {
        if (i > 0 && i <= 1048576) {
            this.dataSize = i;
        } else {
            this.dataSize = DEFAULT_SIZE;
        }
    }

    public void setEventIDSample(String str, float f) {
        if (f >= 0.0f && f <= 1.0f) {
            this.floatHashMap.put(str, Float.valueOf(f));
        } else {
            this.floatHashMap.put(str, Float.valueOf(1.0f));
        }
    }

    public void setMessageCount(int i) {
        if (i > 0 && i <= 500) {
            this.messageCount = i;
        } else {
            this.messageCount = 50;
        }
    }

    public void setUseOldLogic(boolean z) {
        this.useOldLogic = z;
    }

    private RestOrangeConfigure() {
        this.dataSize = DEFAULT_SIZE;
        this.allSample = 1.0f;
        this.floatHashMap = new ConcurrentHashMap();
        this.useOldLogic = false;
        this.messageCount = 50;
    }
}
