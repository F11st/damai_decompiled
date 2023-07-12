package com.amap.api.mapcore.util;

import android.content.Context;
import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.interfaces.IMapConfig;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public interface jo {
    Object a(String str);

    void a();

    void a(Context context, IAMapDelegate iAMapDelegate, boolean z);

    void a(IGLMapState iGLMapState, IMapConfig iMapConfig);

    void a(String str, Object obj);

    void a(GL10 gl10, int i, int i2);

    void a(GL10 gl10, EGLConfig eGLConfig);

    void a(JSONObject jSONObject);

    String b();
}
