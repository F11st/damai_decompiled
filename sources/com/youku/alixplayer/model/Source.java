package com.youku.alixplayer.model;

import android.text.TextUtils;
import androidx.annotation.Keep;
import com.youku.alixplayer.ISource;
import com.youku.alixplayer.util.Destructable;
import com.youku.alixplayer.util.SystemSoLoader;

/* compiled from: Taobao */
@Keep
/* loaded from: classes.dex */
public class Source implements ISource, Destructable {
    private double mDuration;
    private long mNativeId;
    private String mUrl;

    static {
        SystemSoLoader.load("alixplayer");
    }

    public Source() {
        this.mNativeId = init("", 0.0d);
    }

    private Source(long j) {
        this.mNativeId = j;
    }

    public Source(String str) {
        this(str, 0.0d);
    }

    public Source(String str, double d) {
        this.mUrl = str;
        this.mDuration = d;
        this.mNativeId = init(str, d);
    }

    private native void deinit();

    private native long init(String str, double d);

    public void addUrl(String str) {
        addUrl(str, 0.0d);
    }

    public native void addUrl(String str, double d);

    public void appendUrl(String str) {
        if (TextUtils.isEmpty(this.mUrl) || TextUtils.isEmpty(str) || !str.startsWith("&")) {
            return;
        }
        this.mUrl += str;
    }

    @Override // com.youku.alixplayer.util.Destructable
    public void destruct() {
        deinit();
    }

    public void finalize() {
        destruct();
    }

    @Override // com.youku.alixplayer.ISource
    public double getDuration() {
        return this.mDuration;
    }

    @Override // com.youku.alixplayer.ISource
    public String getUrl() {
        return this.mUrl;
    }

    public native void removeUrl(int i);

    public native void setDuration(double d);

    public native void setMediaType(String str);

    public String toString() {
        return "duration=" + this.mDuration + " url=" + this.mUrl;
    }
}
