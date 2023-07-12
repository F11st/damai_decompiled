package com.youku.live.dago.widgetlib.interactive.resource.prefetch;

import android.net.Uri;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class ResourceEntity {
    public List<Resource> resourceList = new ArrayList();

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class Resource {
        public final String key;
        public final long outdated;
        public final String path;
        public final Uri uri;

        public Resource(String str, String str2, Uri uri) {
            this(str, str2, uri, 0L);
        }

        public Resource(String str, String str2, Uri uri, long j) {
            this.key = str;
            this.path = str2;
            this.uri = uri;
            this.outdated = j;
        }
    }
}
