package com.youku.alixplayer.instances.System.model;

import android.text.TextUtils;
import com.youku.alixplayer.ISource;
import com.youku.alixplayer.util.Destructable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class SystemSource implements ISource, Destructable {
    private double mDuration;
    private long mNativeId;
    private String mUrl;

    public SystemSource() {
        this.mNativeId = init("", 0.0d);
    }

    private SystemSource(long j) {
        this.mNativeId = j;
    }

    public SystemSource(String str) {
        this(str, 0.0d);
    }

    public SystemSource(String str, double d) {
        this.mUrl = str;
        this.mDuration = d;
        this.mNativeId = init(str, d);
    }

    private void deinit() {
    }

    private long init(String str, double d) {
        return TextUtils.isEmpty(str) ? System.currentTimeMillis() : str.hashCode();
    }

    public void addUrl(String str) {
        addUrl(str, 0.0d);
    }

    public void addUrl(String str, double d) {
    }

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

    public void removeUrl(int i) {
    }

    public void setDuration(double d) {
        this.mDuration = d;
    }

    public void setMediaType(String str) {
    }

    public String toString() {
        return "duration=" + this.mDuration + " url=" + this.mUrl;
    }
}
