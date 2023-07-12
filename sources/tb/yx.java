package tb;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.expression.parser.AbstractC6375a;
import com.taobao.android.dinamicx.videoc.DXVideoControlConfig;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import java.util.Comparator;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class yx extends AbstractC6375a {
    public static final long DX_PARSER_VIDEOCONTROLCONFIG = -7801350391660369312L;
    public static final String LOOP_PLAY = "isLoop";
    public static final String MAX_PLATING_VIDEO = "maxParallelCount";
    public static final String PLAY_DELAY = "timeFactor";
    public static final String PLAY_ORDER = "playOrder";
    public static final String VIEW_AREA_PERCENT = "spaceFactor";
    public static final String WIDGET_CLASS = "widgetClass";

    private Comparator<by2> a(int i) {
        if (i == 0) {
            return new j20();
        }
        if (i == 1) {
            return new k20();
        }
        return new j20();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.taobao.android.dinamicx.expression.parser.AbstractC6375a, com.taobao.android.dinamicx.expression.parser.IDXDataParser
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        if (objArr == null || objArr.length == 0 || objArr.length != 1) {
            return null;
        }
        Object obj = objArr[0];
        if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject.containsKey(WIDGET_CLASS)) {
                DXVideoControlConfig<by2> j = DXVideoControlConfig.j();
                if (jSONObject.containsKey(VIEW_AREA_PERCENT)) {
                    j.i(jSONObject.getFloatValue(VIEW_AREA_PERCENT));
                }
                if (jSONObject.containsKey(MAX_PLATING_VIDEO)) {
                    j.b(jSONObject.getIntValue(MAX_PLATING_VIDEO));
                }
                if (jSONObject.containsKey(PLAY_DELAY)) {
                    j.c(jSONObject.getLongValue(PLAY_DELAY));
                }
                if (jSONObject.containsKey(LOOP_PLAY)) {
                    j.a(jSONObject.getBooleanValue(LOOP_PLAY));
                }
                if (jSONObject.containsKey(PLAY_ORDER)) {
                    j.h(a(jSONObject.getIntValue(PLAY_ORDER)));
                }
                j.e(true);
                try {
                    Object obj2 = jSONObject.get(WIDGET_CLASS);
                    JSONArray jSONArray = new JSONArray();
                    if (obj2 instanceof String) {
                        jSONArray.add(obj2);
                    }
                    if (obj2 instanceof JSONArray) {
                        jSONArray.addAll((JSONArray) obj2);
                    }
                    for (int i = 0; i < jSONArray.size(); i++) {
                        Class<?> cls = Class.forName(jSONArray.getString(i));
                        if (DXWidgetNode.class.isAssignableFrom(cls)) {
                            j.g(cls);
                        }
                    }
                    return j;
                } catch (Exception e) {
                    ry.b(e);
                    return null;
                }
            }
            return null;
        }
        return null;
    }
}
