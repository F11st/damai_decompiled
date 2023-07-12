package com.youku.alixplayer;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class VideoUriInfo {
    public int[] duration;
    public int[] endPos;
    public String[] id;
    public String[] uri;

    public void init(int i) {
        this.uri = new String[i];
        this.id = new String[i];
        this.duration = new int[i];
        this.endPos = new int[i];
    }
}
