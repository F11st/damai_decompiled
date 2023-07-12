package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.interfaces.IMapConfig;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import java.util.ArrayList;
import java.util.List;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class jp {
    private static List<jo> a = new ArrayList();

    public jp(Context context, IAMapDelegate iAMapDelegate, boolean z) {
        synchronized (jp.class) {
            for (jo joVar : a) {
                if (joVar != null) {
                    joVar.a(context, iAMapDelegate, z);
                }
            }
        }
    }

    public void a(GL10 gl10, EGLConfig eGLConfig) {
        synchronized (jp.class) {
            for (jo joVar : a) {
                if (joVar != null) {
                    joVar.a(gl10, eGLConfig);
                }
            }
        }
    }

    public String b() {
        String stringBuffer;
        synchronized (jp.class) {
            StringBuffer stringBuffer2 = new StringBuffer();
            for (jo joVar : a) {
                if (joVar != null) {
                    String b = joVar.b();
                    if (!TextUtils.isEmpty(b)) {
                        stringBuffer2.append(b);
                        if (!b.endsWith(";")) {
                            stringBuffer2.append(";");
                        }
                    }
                }
            }
            stringBuffer = stringBuffer2.toString();
        }
        return stringBuffer;
    }

    public void a(GL10 gl10, int i, int i2) {
        synchronized (jp.class) {
            for (jo joVar : a) {
                if (joVar != null) {
                    joVar.a(gl10, i, i2);
                }
            }
        }
    }

    public void a(IGLMapState iGLMapState, IMapConfig iMapConfig) {
        synchronized (jp.class) {
            for (jo joVar : a) {
                if (joVar != null) {
                    joVar.a(iGLMapState, iMapConfig);
                }
            }
        }
    }

    public void a() {
        synchronized (jp.class) {
            for (jo joVar : a) {
                if (joVar != null) {
                    joVar.a();
                }
            }
            a.clear();
        }
    }

    public void a(JSONObject jSONObject) {
        synchronized (jp.class) {
            for (jo joVar : a) {
                if (joVar != null) {
                    joVar.a(jSONObject);
                }
            }
        }
    }

    public void a(String str, Object obj) {
        synchronized (jp.class) {
            for (jo joVar : a) {
                if (joVar != null) {
                    joVar.a(str, obj);
                }
            }
        }
    }

    public Object a(String str) {
        Object a2;
        synchronized (jp.class) {
            for (jo joVar : a) {
                if (joVar != null && (a2 = joVar.a(str)) != null) {
                    return a2;
                }
            }
            return null;
        }
    }
}
