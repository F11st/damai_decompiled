package cn.damai.tetris.componentplugin;

import cn.damai.musicfestival.view.MusicFestivalMapView;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class MusicFestivalEvent implements Serializable {
    public static final int TYPE_MAP_VIEW = 1;
    public MusicFestivalMapView mapView;
    public int type;

    public MusicFestivalEvent() {
    }

    public MusicFestivalEvent(MusicFestivalMapView musicFestivalMapView) {
        this.type = 1;
        this.mapView = musicFestivalMapView;
    }
}
