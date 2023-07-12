package com.taobao.android.nav;

import android.net.Uri;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class NavUri {
    protected Uri.Builder mBuilder = new Uri.Builder();

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface Schemed {
        NavUri host(String str);
    }

    private NavUri() {
    }

    public static NavUri host(String str) {
        NavUri navUri = new NavUri();
        navUri.mBuilder.scheme("http").authority(str);
        return navUri;
    }

    public static Schemed scheme(String str) {
        NavUri navUri = new NavUri();
        navUri.mBuilder.scheme(str);
        return new Schemed() { // from class: com.taobao.android.nav.NavUri.1
            @Override // com.taobao.android.nav.NavUri.Schemed
            public NavUri host(String str2) {
                NavUri.this.mBuilder.authority(str2);
                return NavUri.this;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Uri build() {
        return this.mBuilder.build();
    }

    public NavUri fragment(String str) {
        this.mBuilder.fragment(str);
        return this;
    }

    public NavUri param(String str, String str2) {
        this.mBuilder.appendQueryParameter(str, str2);
        return this;
    }

    public NavUri path(String str) {
        this.mBuilder.path(str);
        return this;
    }

    public NavUri segment(String str) {
        this.mBuilder.appendEncodedPath(str);
        return this;
    }

    public NavUri param(String str, long j) {
        this.mBuilder.appendQueryParameter(str, String.valueOf(j));
        return this;
    }

    public NavUri segment(long j) {
        this.mBuilder.appendEncodedPath(String.valueOf(j));
        return this;
    }

    public NavUri param(String str, int i) {
        this.mBuilder.appendQueryParameter(str, String.valueOf(i));
        return this;
    }

    public NavUri segment(int i) {
        this.mBuilder.appendEncodedPath(String.valueOf(i));
        return this;
    }
}
