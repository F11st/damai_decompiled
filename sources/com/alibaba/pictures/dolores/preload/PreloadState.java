package com.alibaba.pictures.dolores.preload;

import kotlin.Metadata;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/alibaba/pictures/dolores/preload/PreloadState;", "", "", "value", "<init>", "(Ljava/lang/String;II)V", "STATE_INIT", "STATE_START", "STATE_HIT_CACHE", "STATE_FINISH", "dolores_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public enum PreloadState {
    STATE_INIT(0),
    STATE_START(1),
    STATE_HIT_CACHE(2),
    STATE_FINISH(3);

    PreloadState(int i) {
    }
}
