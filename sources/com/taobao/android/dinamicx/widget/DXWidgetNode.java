package com.taobao.android.dinamicx.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.collection.LongSparseArray;
import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.dinamic.R$id;
import com.taobao.android.dinamicx.DXDarkModeCenter;
import com.taobao.android.dinamicx.DXRenderPipeline;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.e;
import com.taobao.android.dinamicx.model.DXLongSparseArray;
import com.taobao.android.dinamicx.monitor.DXAppMonitor;
import com.taobao.android.dinamicx.template.download.DXTemplateItem;
import com.taobao.weex.common.Constants;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.b10;
import tb.bu;
import tb.f00;
import tb.f10;
import tb.fz;
import tb.gt;
import tb.hy;
import tb.jn1;
import tb.lz;
import tb.m80;
import tb.nt;
import tb.nz;
import tb.p62;
import tb.pa1;
import tb.py;
import tb.qy;
import tb.r10;
import tb.ry;
import tb.wt;
import tb.wy;
import tb.x10;
import tb.y10;
import tb.z00;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DXWidgetNode implements IDXBuilderWidgetNode {
    public static final int ACCESSIBILITY_AUTO = 3;
    public static final int ACCESSIBILITY_DEF = -1;
    public static final int ACCESSIBILITY_OFF = 0;
    public static final int ACCESSIBILITY_OFF_CHILD = 2;
    public static final int ACCESSIBILITY_ON = 1;
    public static final int BORDER_TYPE_DASH = 1;
    public static final int BORDER_TYPE_NORMAL = 0;
    public static final int DIRECTION_NOT_SET = -1;
    public static final int DXGRAVITY_RLT_DELTA = 6;
    public static final int DXGravityCenter = 4;
    public static final int DXGravityCenterBottom = 5;
    public static final int DXGravityCenterTop = 3;
    public static final int DXGravityLeftBottom = 2;
    public static final int DXGravityLeftCenter = 1;
    public static final int DXGravityLeftTop = 0;
    public static final int DXGravityRightBottom = 8;
    public static final int DXGravityRightCenter = 7;
    public static final int DXGravityRightTop = 6;
    public static final long DXVIEW_ONCREATEVIEW = 188822591186414296L;
    private static final long DXVIEW_TBORDERJSON = -1688385493169466985L;
    public static final int DX_VIEW_EVENTRESPONSEMODE_DISABLE_ALL = 3;
    public static final int DX_VIEW_EVENTRESPONSEMODE_DISABLE_CHILD = 2;
    public static final int DX_VIEW_EVENTRESPONSEMODE_DISABLE_SELF = 1;
    public static final int DX_VIEW_EVENTRESPONSEMODE_NORMAL = 0;
    public static final int DX_WIDGET_NODE_ATTR_PARSED = 2;
    public static final int DX_WIDGET_NODE_BIND_CHILD_CALLED = 4096;
    public static final int DX_WIDGET_NODE_FLATTEND = 128;
    public static final int DX_WIDGET_NODE_FORCE_LAYOUT = 16384;
    public static final int DX_WIDGET_NODE_IS_PRE_RENDERED = 8192;
    public static final int DX_WIDGET_NODE_LAID_OUT = 32;
    public static final int DX_WIDGET_NODE_MEASURED = 8;
    public static final int DX_WIDGET_NODE_NEED_FLATTEN = 64;
    public static final int DX_WIDGET_NODE_NEED_LAYOUT = 16;
    public static final int DX_WIDGET_NODE_NEED_MEASURE = 4;
    public static final int DX_WIDGET_NODE_NEED_PARSE = 1;
    public static final int DX_WIDGET_NODE_NEED_RENDER = 256;
    public static final int DX_WIDGET_NODE_PARSED = 32768;
    public static final int DX_WIDGET_NODE_PARSE_IN_MEASURE = 1024;
    public static final int DX_WIDGET_NODE_RENDERED = 512;
    public static final int DX_WIDGET_NODE_VISIBILITY_PARSED = 2048;
    public static final int GONE = 2;
    public static final int INVISIBLE = 1;
    public static final int IS_ACCESSIBILITY_FALSE = 0;
    public static final int IS_ACCESSIBILITY_TRUE = 1;
    public static final int LAYOUT_DIRECTION_LTR = 0;
    public static final int LAYOUT_DIRECTION_RTL = 1;
    public static final int LAYOUT_GRAVITY_INIT_MASK = 1;
    public static final int LISTDATA_INIT_MASK = 2;
    public static final int MATCH_CONTENT = -2;
    public static final int MATCH_PARENT = -1;
    public static final int MEASURED_HEIGHT_STATE_SHIFT = 16;
    public static final int MEASURED_SIZE_MASK = 16777215;
    public static final int MEASURED_STATE_MASK = -16777216;
    public static final int MEASURED_STATE_TOO_SMALL = 16777216;
    public static final int NO = 0;
    public static final int VISIBLE = 0;
    public static final int YES = 1;
    String accessibilityText;
    float alpha;
    String animation;
    private gt animationHolder;
    private int autoId;
    private d backgroundGradient;
    Map<String, nt> bindingXExecutingMap;
    Map<String, nt> bindingXSpecMap;
    int bottom;
    int childGravity;
    List<DXWidgetNode> children;
    private int childrenCount;
    DXRuntimeContext dXRuntimeContext;
    private HashMap<String, Integer> darkModeColorMap;
    private DXLongSparseArray<wy> dataParsersExprNode;
    private py dxEventChains;
    private byte[] dxExprBytes;
    private DXWidgetNode dxRootWidgetCache;
    private DXLongSparseArray<Map<String, Integer>> enumMap;
    private DXLongSparseArray<wy> eventHandlersExprNode;
    int eventResponseMode;
    private JSONArray exportMethods;
    private boolean hasHandleDark;
    boolean isFlatten;
    private int lastAutoId;
    int layoutGravity;
    int layoutHeight;
    int layoutWidth;
    int left;
    private DXLongSparseArray<wy> mCodeMap;
    int marginBottom;
    int marginLeft;
    int marginRight;
    int marginTop;
    int measuredHeight;
    int measuredWidth;
    int minHeight;
    int minWidth;
    boolean needSetBackground;
    int paddingBottom;
    int paddingLeft;
    int paddingRight;
    int paddingTop;
    private JSONObject paramsInfo;
    DXWidgetNode parentWidget;
    int privateFlags;
    int propertyInitFlag;
    private lz realLayoutAttribute;
    String ref;
    private WeakReference<DXWidgetNode> referenceNode;
    int right;
    private JSONArray slotInfo;
    private JSONObject slotInfoJObj;
    private WeakReference<DXWidgetNode> sourceWidgetWR;
    private JSONObject tborderJson;
    int top;
    String userId;
    private WeakReference<View> weakView;
    double weight;
    public static final int TAG_WIDGET_NODE = R$id.dinamicXWidgetNodeTag;
    private static boolean sAlwaysRemeasureExactly = false;
    private static ThreadLocal<lz> attributeThreadLocal = new ThreadLocal<>();
    int cornerRadius = 0;
    int cornerRadiusLeftTop = 0;
    int cornerRadiusRightTop = 0;
    int cornerRadiusLeftBottom = 0;
    int cornerRadiusRightBottom = 0;
    int borderWidth = -1;
    int borderColor = 0;
    int borderType = 0;
    int dashWidth = -1;
    int dashGap = -1;
    int backGroundColor = 0;
    private boolean openNewFastReturnLogic = false;
    boolean clipChildren = true;
    private boolean softwareRender = false;
    private int DEFAULT = 0;
    float translateX = 0;
    float translateY = 0;
    float scaleX = 1.0f;
    float scaleY = 1.0f;
    float rotationX = 0;
    float rotationY = 0;
    float rotationZ = 0;
    private boolean disableDarkMode = false;
    int oldWidthMeasureSpec = Integer.MIN_VALUE;
    int oldHeightMeasureSpec = Integer.MIN_VALUE;
    int visibility = 0;
    private int direction = -1;
    int accessibility = -1;
    int enabled = 1;

    /* compiled from: Taobao */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes12.dex */
    public @interface DXGravity {
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class DXMeasureSpec {
        public static final int AT_MOST = Integer.MIN_VALUE;
        public static final int EXACTLY = 1073741824;
        public static final int UNSPECIFIED = 0;

        /* compiled from: Taobao */
        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes12.dex */
        public @interface MeasureSpecMode {
        }

        @SuppressLint({"WrongConstant"})
        public static int a(int i) {
            return i & (-1073741824);
        }

        public static int b(int i) {
            return i & pa1.MAX_CAPACITY_MASK;
        }

        public static int c(@IntRange(from = 0, to = 1073741823) int i, int i2) {
            return (i & pa1.MAX_CAPACITY_MASK) | (i2 & (-1073741824));
        }
    }

    /* compiled from: Taobao */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes12.dex */
    public @interface DXNodePropertyInitMask {
    }

    /* compiled from: Taobao */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes12.dex */
    public @interface DXWidgetNodeStatFlag {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DXWidgetNode.this.onTapEvent();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public class b implements View.OnLongClickListener {
        b() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            DXWidgetNode.this.onLongTap();
            return true;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class c implements IDXBuilderWidgetNode {
        @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
        public DXWidgetNode build(Object obj) {
            return new DXWidgetNode();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class d {
        private int a = -1;
        private GradientDrawable.Orientation b;
        private int[] c;

        public int a() {
            return this.a;
        }

        public int[] b() {
            return this.c;
        }

        public GradientDrawable.Orientation c() {
            return this.b;
        }

        public void d(int i) {
            this.a = i;
        }

        public void e(int[] iArr) {
            this.c = iArr;
        }

        public void f(GradientDrawable.Orientation orientation) {
            this.b = orientation;
        }
    }

    public DXWidgetNode() {
        this.layoutGravity = 0;
        this.childGravity = 0;
        this.alpha = 1.0f;
        this.eventResponseMode = 0;
        this.layoutGravity = 0;
        this.childGravity = 0;
        this.alpha = 1.0f;
        this.eventResponseMode = 0;
    }

    private void bindChildrenMeasureFlag(DXWidgetRefreshOption dXWidgetRefreshOption) {
        if (isMarkContainerLayout()) {
            if (dXWidgetRefreshOption.a() == 0) {
                return;
            }
            if (1 == dXWidgetRefreshOption.a()) {
                r1 = this instanceof DXScrollLayoutBase ? ((DXScrollLayoutBase) this).itemWidgetNodes : null;
                if (this instanceof DXAbsContainerBaseLayout) {
                    r1 = ((DXAbsContainerBaseLayout) this).getItemWidgetNodes();
                }
            } else if (2 == dXWidgetRefreshOption.a()) {
                return;
            }
        } else {
            r1 = getChildren();
        }
        if (r1 == null) {
            return;
        }
        int size = r1.size();
        for (int i = 0; i < size; i++) {
            DXWidgetNode dXWidgetNode = r1.get(i);
            dXWidgetNode.setStatFlag(16384);
            dXWidgetNode.setStatFlag(4);
            dXWidgetNode.unsetStatFlag(8);
            dXWidgetNode.unsetStatFlag(32);
            dXWidgetNode.bindChildrenParseFlag(dXWidgetRefreshOption);
        }
    }

    private void bindChildrenParseFlag(DXWidgetRefreshOption dXWidgetRefreshOption) {
        if (isMarkContainerLayout()) {
            if (dXWidgetRefreshOption.a() == 0) {
                return;
            }
            if (1 == dXWidgetRefreshOption.a()) {
                r4 = this instanceof DXScrollLayoutBase ? ((DXScrollLayoutBase) this).itemWidgetNodes : null;
                if (this instanceof DXAbsContainerBaseLayout) {
                    r4 = ((DXAbsContainerBaseLayout) this).getItemWidgetNodes();
                }
            } else if (2 == dXWidgetRefreshOption.a()) {
                unsetStatFlag(4096);
                return;
            }
        } else if (this instanceof DXScrollLayoutBase) {
            r4 = ((DXScrollLayoutBase) this).itemWidgetNodes;
        } else if (this instanceof DXAbsContainerBaseLayout) {
            r4 = ((DXAbsContainerBaseLayout) this).getItemWidgetNodes();
        } else {
            r4 = getChildren();
        }
        if (r4 == null) {
            return;
        }
        int size = r4.size();
        for (int i = 0; i < size; i++) {
            DXWidgetNode dXWidgetNode = r4.get(i);
            if (dXWidgetRefreshOption.a() != 0 || !dXWidgetNode.isMarkContainerLayout()) {
                dXWidgetNode.setStatFlag(1);
                dXWidgetNode.unsetStatFlag(2);
                dXWidgetNode.setStatFlag(16384);
                dXWidgetNode.setStatFlag(4);
                dXWidgetNode.unsetStatFlag(8);
                dXWidgetNode.unsetStatFlag(32);
                dXWidgetNode.setStatFlag(256);
                if (!dXWidgetNode.isMarkContainerLayout()) {
                    dXWidgetNode.unsetStatFlag(4096);
                }
                dXWidgetNode.bindChildrenParseFlag(dXWidgetRefreshOption);
            }
        }
    }

    private void bindParentMeasureFlag(boolean z, boolean z2) {
        int i = this.privateFlags | 16384;
        this.privateFlags = i;
        this.privateFlags = i & (-41);
        if (wt.A0() && (this.parentWidget instanceof DXRecyclerLayout)) {
            updateRefreshType(1);
            if (z) {
                setStatFlag(1);
            } else {
                setStatFlag(4);
            }
            ((DXRecyclerLayout) this.parentWidget).refreshCurrentNode(this);
            return;
        }
        DXWidgetNode dXWidgetNode = this.parentWidget;
        if (dXWidgetNode != null) {
            dXWidgetNode.bindParentMeasureFlag(z, z2);
        } else if (z) {
            sendPartParserEvent(z2);
        } else {
            sendPartMeasureLayoutEvent(z2);
        }
    }

    public static int combineMeasuredStates(int i, int i2) {
        return i | i2;
    }

    public static int getAbsoluteGravity(int i, int i2) {
        return (i2 != 0 && i2 == 1) ? (i == 0 || i == 1 || i == 2) ? i + 6 : (i == 6 || i == 7 || i == 8) ? i - 6 : i : i;
    }

    public static int getDefaultSize(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? View.MeasureSpec.getSize(i2) : i;
    }

    private View getRealView() {
        WeakReference<View> weakReference = this.weakView;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    private boolean isMarkContainerLayout() {
        if ((this instanceof DXAbsContainerBaseLayout) || (this instanceof DXScrollLayoutBase)) {
            return ((f) this).isMarkContainer();
        }
        return false;
    }

    private void parseTreeInfo(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        List<DXWidgetNode> list = this.children;
        if (list != null) {
            for (DXWidgetNode dXWidgetNode : list) {
                dXWidgetNode.parseTreeInfo(jSONObject2);
            }
        }
        jSONObject.put(toSelfWidgetNodeInfo(), (Object) jSONObject2);
    }

    private void prePareBindEvent(long j) {
        hy hyVar = new hy(j);
        hyVar.e(true);
        postEvent(hyVar);
    }

    private DXWidgetNode queryWidgetNodeByUserIdFromMap(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.equals(getUserId())) {
            return this;
        }
        DXWidgetNode queryRootWidgetNode = queryRootWidgetNode();
        if (queryRootWidgetNode instanceof f) {
            Map<String, WeakReference<DXWidgetNode>> dxUserIdMap = ((f) queryRootWidgetNode).getDxUserIdMap();
            if (dxUserIdMap == null) {
                return queryWTByUserId(str);
            }
            WeakReference<DXWidgetNode> weakReference = dxUserIdMap.get(str);
            if (weakReference == null) {
                return queryWTByUserId(str);
            }
            DXWidgetNode dXWidgetNode = weakReference.get();
            return dXWidgetNode == null ? queryWTByUserId(str) : dXWidgetNode;
        }
        return null;
    }

    private void refreshRecyclerLayout() {
        if (this instanceof DXRecyclerLayout) {
            DXRecyclerLayout dXRecyclerLayout = (DXRecyclerLayout) this;
            fz fzVar = new fz();
            fzVar.i(DXRecyclerLayout.MSG_METHOD_REFRESH_DATA);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("data", (Object) dXRecyclerLayout.getDataSource());
            fzVar.j(jSONObject);
            dXRecyclerLayout.postEvent(fzVar);
        }
    }

    public static int resolveSize(int i, int i2) {
        return resolveSizeAndState(i, i2, 0) & 16777215;
    }

    public static int resolveSizeAndState(int i, int i2, int i3) {
        int a2 = DXMeasureSpec.a(i2);
        int b2 = DXMeasureSpec.b(i2);
        if (a2 != Integer.MIN_VALUE) {
            if (a2 == 1073741824) {
                i = b2;
            }
        } else if (b2 < i) {
            i = 16777216 | b2;
        }
        return i | ((-16777216) & i3);
    }

    private void sendPartMeasureLayoutEvent(boolean z) {
        DXRuntimeContext dXRuntimeContext = getDXRuntimeContext();
        if (dXRuntimeContext == null) {
            return;
        }
        DXRenderPipeline dxRenderPipeline = dXRuntimeContext.getDxRenderPipeline();
        bu dxControlEventCenter = dXRuntimeContext.getDxControlEventCenter();
        if (dxRenderPipeline == null || dxControlEventCenter == null) {
            return;
        }
        com.taobao.android.dinamicx.h j = dxRenderPipeline.j();
        if (j != null) {
            j.j(dXRuntimeContext.getCacheIdentify());
        }
        f00 f00Var = new f00();
        f00Var.d = 3;
        f00Var.a = this;
        f00Var.e = 1;
        f00Var.f = z;
        if (z) {
            dxControlEventCenter.a(f00Var);
        } else {
            dxControlEventCenter.b(f00Var);
        }
    }

    private void sendPartParserEvent(boolean z) {
        DXRuntimeContext dXRuntimeContext = getDXRuntimeContext();
        if (dXRuntimeContext == null) {
            return;
        }
        DXRenderPipeline dxRenderPipeline = dXRuntimeContext.getDxRenderPipeline();
        bu dxControlEventCenter = dXRuntimeContext.getDxControlEventCenter();
        if (dxRenderPipeline == null || dxControlEventCenter == null) {
            return;
        }
        com.taobao.android.dinamicx.h j = dxRenderPipeline.j();
        if (j != null) {
            j.j(dXRuntimeContext.getCacheIdentify());
        }
        f00 f00Var = new f00();
        f00Var.d = 2;
        f00Var.e = 1;
        f00Var.a = this;
        f00Var.f = z;
        if (z) {
            dxControlEventCenter.a(f00Var);
        } else {
            dxControlEventCenter.b(f00Var);
        }
    }

    public final void addChild(DXWidgetNode dXWidgetNode) {
        addChild(dXWidgetNode, true);
    }

    public void applyTransform(View view, Object obj) {
        List<Animator> list;
        float f;
        float f2;
        if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            String string = jSONObject.getString("transform");
            String string2 = jSONObject.getString("transition");
            try {
                List<x10.a> b2 = x10.b(string);
                float f3 = 1.0f;
                if (b2 != null) {
                    f = 1.0f;
                    for (x10.a aVar : b2) {
                        int i = aVar.a;
                        if (i == 6) {
                            float[] fArr = aVar.b;
                            f3 *= fArr[0];
                            f2 = fArr[1];
                        } else if (i == 7) {
                            f3 *= aVar.b[0];
                        } else if (i == 8) {
                            f2 = aVar.b[0];
                        } else {
                            throw new IllegalArgumentException("Invalid Transform method: " + aVar.a);
                        }
                        f *= f2;
                    }
                } else {
                    f = 1.0f;
                }
                view.setScaleX(f3);
                view.setScaleY(f);
                List<y10.e> e = y10.e(string2, null, null, null, null);
                float floatValue = jSONObject.getFloatValue("opacity");
                String string3 = jSONObject.getString("backgroundColor");
                list = y10.g(e, view, floatValue, TextUtils.isEmpty(string3) ? 0 : Color.parseColor(string3));
            } catch (Throwable unused) {
                list = null;
            }
            if (list != null && !list.isEmpty()) {
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.setStartDelay(0L);
                animatorSet.playTogether(list);
                ArrayList arrayList = new ArrayList();
                arrayList.add(animatorSet);
                gt gtVar = new gt(arrayList);
                this.animationHolder = gtVar;
                gtVar.c();
                return;
            }
            gt gtVar2 = this.animationHolder;
            if (gtVar2 != null) {
                gtVar2.d();
                this.animationHolder = null;
            }
        }
    }

    public final void beginParser(boolean z) {
        onBeginParser();
        onBeginParser(z);
    }

    void bindDataEvent() {
        postEvent(new hy(2683803675109176030L));
    }

    public final void bindEvent(Context context) {
        if (this.eventHandlersExprNode == null) {
            return;
        }
        View realView = getRealView();
        for (int i = 0; i < this.eventHandlersExprNode.size(); i++) {
            getReferenceNode().onBindEvent(context, realView, this.eventHandlersExprNode.keyAt(i));
        }
    }

    public void bindRuntimeContext(DXRuntimeContext dXRuntimeContext) {
        bindRuntimeContext(dXRuntimeContext, false);
    }

    @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
    public DXWidgetNode build(Object obj) {
        return new DXWidgetNode();
    }

    public boolean containsExecutingAnimationSpec(String str) {
        Map<String, nt> map = this.bindingXExecutingMap;
        if (map == null || map.size() == 0 || TextUtils.isEmpty(str)) {
            return false;
        }
        return this.bindingXExecutingMap.containsKey(str);
    }

    public final View createView(Context context) {
        View realView = getRealView();
        if (realView == null) {
            realView = getReferenceNode().onCreateView(context);
            this.privateFlags |= 256;
            if (realView == null && wt.j0(this)) {
                return null;
            }
            realView.setTag(TAG_WIDGET_NODE, this);
            this.weakView = new WeakReference<>(realView);
            if (this.softwareRender) {
                realView.setLayerType(1, null);
            }
            postEvent(new hy(DXVIEW_ONCREATEVIEW));
        }
        return realView;
    }

    public DXWidgetNode deepClone(DXRuntimeContext dXRuntimeContext) {
        DXWidgetNode dXWidgetNode = (DXWidgetNode) shallowClone(dXRuntimeContext, true);
        if (this.children != null) {
            dXWidgetNode.children = new ArrayList();
            for (int i = 0; i < this.children.size(); i++) {
                dXWidgetNode.addChild(this.children.get(i).deepClone(dXRuntimeContext));
            }
        }
        return dXWidgetNode;
    }

    public final void endParser(boolean z) {
        if (wt.P0(getDXRuntimeContext())) {
            processUserId();
        }
        onEndParser();
        onEndParser(z);
    }

    public JSONArray exportMethods() {
        if (this.exportMethods == null) {
            this.exportMethods = new JSONArray() { // from class: com.taobao.android.dinamicx.widget.DXWidgetNode.1
                {
                    add("render");
                    add("refresh");
                    add("getBoundingClientRect");
                    add("commit");
                }
            };
        }
        return this.exportMethods;
    }

    protected boolean extraHandleDark() {
        return false;
    }

    public int getAccessibility() {
        return this.accessibility;
    }

    public String getAccessibilityText() {
        return this.accessibilityText;
    }

    public float getAlpha() {
        return this.alpha;
    }

    public String getAnimation() {
        return this.animation;
    }

    public int getAutoId() {
        return this.autoId;
    }

    public int getBackGroundColor() {
        return this.backGroundColor;
    }

    public d getBackgroundGradient() {
        return this.backgroundGradient;
    }

    public Map<String, nt> getBindingXExecutingMap() {
        return this.bindingXExecutingMap;
    }

    public Map<String, nt> getBindingXSpecMap() {
        return this.bindingXSpecMap;
    }

    public int getBorderColor() {
        return this.borderColor;
    }

    public int getBorderType() {
        return this.borderType;
    }

    public int getBorderWidth() {
        return this.borderWidth;
    }

    public int getBottom() {
        return this.bottom;
    }

    public DXWidgetNode getChildAt(int i) {
        List<DXWidgetNode> list;
        if (i < 0 || i >= this.childrenCount || (list = this.children) == null) {
            return null;
        }
        return list.get(i);
    }

    public int getChildGravity() {
        return this.childGravity;
    }

    public List<DXWidgetNode> getChildren() {
        return this.children;
    }

    public int getChildrenCount() {
        return this.childrenCount;
    }

    public DXLongSparseArray<wy> getCodeMap() {
        return this.mCodeMap;
    }

    public int getCornerRadius() {
        return this.cornerRadius;
    }

    public int getCornerRadiusLeftBottom() {
        return this.cornerRadiusLeftBottom;
    }

    public int getCornerRadiusLeftTop() {
        return this.cornerRadiusLeftTop;
    }

    public int getCornerRadiusRightBottom() {
        return this.cornerRadiusRightBottom;
    }

    public int getCornerRadiusRightTop() {
        return this.cornerRadiusRightTop;
    }

    public DXRuntimeContext getDXRuntimeContext() {
        return this.dXRuntimeContext;
    }

    public LongSparseArray<wy> getDataParsersExprNode() {
        return this.dataParsersExprNode;
    }

    public Object getDefaultValueForAttr(long j) {
        return null;
    }

    public double getDefaultValueForDoubleAttr(long j) {
        return 0.0d;
    }

    public int getDefaultValueForIntAttr(long j) {
        if (20052926345925L == j || 9346582897824575L == j || -916628110244908525L == j || -4674119579031497081L == j || -2641581645694792774L == j || 6506044224063169535L == j || -378913133726214547L == j || 3229586316762092001L == j || -2632461973017864940L == j || -4745829179314597287L == j || 4879707785646574221L == j || -3218010051991756042L == j || 7504432960089273802L == j || 5802348655878590802L == j || -8019934667170236535L == j || -8020113231441560440L == j || 1844153004063100714L == j || -6579663421190292502L == j || -5241271604340946425L == j || 3998176004939777025L == j) {
            return 0;
        }
        return (16887479372907L == j || 4804789929613330386L == j) ? 1 : 0;
    }

    public JSONArray getDefaultValueForListAttr(long j) {
        return null;
    }

    public long getDefaultValueForLongAttr(long j) {
        return 0L;
    }

    public JSONObject getDefaultValueForMapAttr(long j) {
        return null;
    }

    public Object getDefaultValueForObjectAttr(long j) {
        return null;
    }

    public String getDefaultValueForStringAttr(long j) {
        return "";
    }

    public int getDirection() {
        int i = this.direction;
        if (i == -1) {
            DXRuntimeContext dXRuntimeContext = this.dXRuntimeContext;
            if (dXRuntimeContext != null) {
                return dXRuntimeContext.getParentDirectionSpec();
            }
            return 0;
        }
        return i;
    }

    public py getDxEventChains() {
        return this.dxEventChains;
    }

    public byte[] getDxExprBytes() {
        return this.dxExprBytes;
    }

    public int getEnabled() {
        return this.enabled;
    }

    public DXLongSparseArray<Map<String, Integer>> getEnumMap() {
        return this.enumMap;
    }

    public LongSparseArray<wy> getEventHandlersExprNode() {
        return this.eventHandlersExprNode;
    }

    public int getEventResponseMode() {
        return this.eventResponseMode;
    }

    public int getHeight() {
        return this.bottom - this.top;
    }

    public int getLastAutoId() {
        return this.lastAutoId;
    }

    protected int getLayoutDirection() {
        return getDirection();
    }

    public int getLayoutGravity() {
        return this.layoutGravity;
    }

    public int getLayoutHeight() {
        return this.layoutHeight;
    }

    public int getLayoutWidth() {
        return this.layoutWidth;
    }

    public int getLeft() {
        return this.left;
    }

    public int getLeftMarginWithDirection() {
        if (getDirection() == 1) {
            return this.marginRight;
        }
        return this.marginLeft;
    }

    public int getMarginBottom() {
        return this.marginBottom;
    }

    public int getMarginLeft() {
        return this.marginLeft;
    }

    public int getMarginRight() {
        return this.marginRight;
    }

    public int getMarginTop() {
        return this.marginTop;
    }

    public final int getMeasuredHeight() {
        return this.measuredHeight & 16777215;
    }

    public final int getMeasuredHeightAndState() {
        return this.measuredHeight;
    }

    public final int getMeasuredState() {
        return (this.measuredWidth & (-16777216)) | ((this.measuredHeight >> 16) & InputDeviceCompat.SOURCE_ANY);
    }

    public final int getMeasuredWidth() {
        return this.measuredWidth & 16777215;
    }

    public final int getMeasuredWidthAndState() {
        return this.measuredWidth;
    }

    public int getMinHeight() {
        return this.minHeight;
    }

    public int getMinWidth() {
        return this.minWidth;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getNextLocationOffset(DXWidgetNode dXWidgetNode) {
        return 0;
    }

    public int getPaddingBottom() {
        return this.paddingBottom;
    }

    public int getPaddingLeft() {
        return this.paddingLeft;
    }

    public int getPaddingLeftWithDirection() {
        if (getDirection() == 1) {
            return this.paddingRight;
        }
        return this.paddingLeft;
    }

    public int getPaddingRight() {
        return this.paddingRight;
    }

    public int getPaddingRightWithDirection() {
        if (getDirection() == 1) {
            return this.paddingLeft;
        }
        return this.paddingRight;
    }

    public int getPaddingTop() {
        return this.paddingTop;
    }

    public JSONObject getParamsInfo() {
        return this.paramsInfo;
    }

    public DXWidgetNode getParentWidget() {
        return this.parentWidget;
    }

    public String getRef() {
        return this.ref;
    }

    public DXWidgetNode getReferenceNode() {
        WeakReference<DXWidgetNode> weakReference = this.referenceNode;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public int getRight() {
        return this.right;
    }

    public int getRightMarginWithDirection() {
        if (getDirection() == 1) {
            return this.marginLeft;
        }
        return this.marginRight;
    }

    public float getRotationX() {
        return this.rotationX;
    }

    public float getRotationY() {
        return this.rotationY;
    }

    public float getRotationZ() {
        return this.rotationZ;
    }

    public float getScaleX() {
        return this.scaleX;
    }

    public float getScaleY() {
        return this.scaleY;
    }

    public JSONArray getSlotInfo() {
        return this.slotInfo;
    }

    public JSONObject getSlotInfoJObj() {
        return this.slotInfoJObj;
    }

    public DXWidgetNode getSourceWidget() {
        WeakReference<DXWidgetNode> weakReference = this.sourceWidgetWR;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public boolean getStatInPrivateFlags(int i) {
        return (this.privateFlags & i) == i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getSuggestedMinimumHeight() {
        return this.minHeight;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int getSuggestedMinimumWidth() {
        return this.minWidth;
    }

    public JSONObject getTborderJson() {
        return this.tborderJson;
    }

    public int getTop() {
        return this.top;
    }

    public float getTranslateX() {
        return this.translateX;
    }

    public float getTranslateY() {
        return this.translateY;
    }

    public String getUserId() {
        return this.userId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final DXWidgetNode getVirtualChildAt(int i) {
        return getChildAt(i);
    }

    public int getVirtualChildCount() {
        return this.childrenCount;
    }

    public int getVisibility() {
        return this.visibility;
    }

    public WeakReference<View> getWRView() {
        return this.weakView;
    }

    public double getWeight() {
        return this.weight;
    }

    public int getWidth() {
        return this.right - this.left;
    }

    public boolean hasAccessibilityAuto() {
        return this.accessibility == 3;
    }

    public boolean hasAccessibilityOn() {
        return this.accessibility == 1;
    }

    public boolean hasCornerRadius() {
        return this.cornerRadiusLeftTop > 0 || this.cornerRadiusRightBottom > 0 || this.cornerRadiusLeftBottom > 0 || this.cornerRadiusRightTop > 0 || this.cornerRadius > 0;
    }

    public boolean hasExecutingAnimationSpec() {
        Map<String, nt> map = this.bindingXExecutingMap;
        return map != null && map.size() > 0;
    }

    public int indexOf(DXWidgetNode dXWidgetNode) {
        if (dXWidgetNode == null) {
            return -1;
        }
        for (int i = 0; i < getChildrenCount(); i++) {
            if (getChildAt(i).getAutoId() == dXWidgetNode.getAutoId()) {
                return i;
            }
        }
        return -1;
    }

    public void insertChild(DXWidgetNode dXWidgetNode, int i) {
        insertChild(dXWidgetNode, i, true);
    }

    public final void invalidateLayoutCache() {
        int i = this.privateFlags | 16384;
        this.privateFlags = i;
        this.privateFlags = i & (-41);
        DXWidgetNode dXWidgetNode = this.parentWidget;
        if (dXWidgetNode != null) {
            dXWidgetNode.invalidateLayoutCache();
        }
    }

    public final void invalidateParseCache() {
        int i = this.privateFlags & (-3);
        this.privateFlags = i;
        this.privateFlags = i | 1;
        DXWidgetNode dXWidgetNode = this.parentWidget;
        if (dXWidgetNode != null) {
            dXWidgetNode.invalidateParseCache();
        }
    }

    @UiThread
    @Deprecated
    public JSONObject invokeRefMethod(String str, JSONArray jSONArray) {
        View nativeView;
        if ("getBoundingClientRect".equals(str)) {
            if (getDXRuntimeContext() == null || (nativeView = getDXRuntimeContext().getNativeView()) == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            int measuredWidth = nativeView.getMeasuredWidth();
            int measuredHeight = nativeView.getMeasuredHeight();
            int[] iArr = new int[2];
            nativeView.getLocationOnScreen(iArr);
            float c2 = p62.c(getDXRuntimeContext().getContext()) / 375.0f;
            jSONObject.put(Constants.Name.X, (Object) Float.valueOf(iArr[0] / c2));
            jSONObject.put(Constants.Name.Y, (Object) Float.valueOf(iArr[1] / c2));
            jSONObject.put("left", (Object) Float.valueOf(iArr[0] / c2));
            jSONObject.put("top", (Object) Float.valueOf(iArr[1] / c2));
            jSONObject.put("width", (Object) Float.valueOf(measuredWidth / c2));
            jSONObject.put("height", (Object) Float.valueOf(measuredHeight / c2));
            jSONObject.put("right", (Object) Float.valueOf((iArr[0] + measuredWidth) / c2));
            jSONObject.put("bottom", (Object) Float.valueOf((iArr[1] + measuredHeight) / c2));
            return jSONObject;
        } else if (!"commit".equals(str) || getDXRuntimeContext() == null || getDXRuntimeContext().getNativeView() == null) {
            return null;
        } else {
            try {
                applyTransform(getDXRuntimeContext().getNativeView(), jSONArray.get(0));
                return null;
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
    }

    public boolean isChildResponseEvent() {
        int i = this.eventResponseMode;
        return i == 0 || i == 1;
    }

    public boolean isChildWidgetNode() {
        DXWidgetNode queryRootWidgetNode = queryRootWidgetNode();
        return queryRootWidgetNode != null && (queryRootWidgetNode.getParentWidget() instanceof DXTemplateWidgetNode);
    }

    public boolean isClipChildren() {
        return this.clipChildren;
    }

    public boolean isDisableDarkMode() {
        return this.disableDarkMode;
    }

    public boolean isFlatten() {
        return this.isFlatten;
    }

    public boolean isNeedSetBackground() {
        return this.needSetBackground;
    }

    public boolean isOpenNewFastReturnLogic() {
        return this.openNewFastReturnLogic;
    }

    public boolean isSelfResponseEvent() {
        int i = this.eventResponseMode;
        return i == 0 || i == 2;
    }

    public final void layout(int i, int i2, int i3, int i4) {
        try {
            if ((this.privateFlags & 4) != 0) {
                onMeasure(this.oldWidthMeasureSpec, this.oldHeightMeasureSpec);
                int i5 = this.privateFlags & (-5);
                this.privateFlags = i5;
                this.privateFlags = i5 | 8;
            }
            boolean frame = setFrame(i, i2, i3, i4);
            if (frame || (this.privateFlags & 16) == 16) {
                onLayout(frame, i, i2, i3, i4);
                this.privateFlags &= -17;
                DXRuntimeContext dXRuntimeContext = this.dXRuntimeContext;
                if (dXRuntimeContext != null && dXRuntimeContext.isRefreshPart()) {
                    this.privateFlags |= 256;
                }
            }
            int i6 = this.privateFlags & (-16385);
            this.privateFlags = i6;
            this.privateFlags = i6 | 32;
        } catch (Exception e) {
            ry.b(e);
            DXRuntimeContext dXRuntimeContext2 = getDXRuntimeContext();
            if (dXRuntimeContext2 == null || dXRuntimeContext2.getDxError() == null) {
                return;
            }
            e.a aVar = new e.a("Pipeline_Detail", "Pipeline_Detail_PerformLayout", com.taobao.android.dinamicx.e.DXERROR_DETAIL_ON_LAYOUT_ERROR);
            aVar.e = ry.a(e);
            dXRuntimeContext2.getDxError().c.add(aVar);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x0079, code lost:
        if (r2 != false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x007b, code lost:
        if (r6 == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:?, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void measure(int r9, int r10) {
        /*
            r8 = this;
            int r0 = r8.privateFlags     // Catch: java.lang.Throwable -> L8f
            r1 = 16384(0x4000, float:2.2959E-41)
            r0 = r0 & r1
            r2 = 1
            r3 = 0
            if (r0 != r1) goto Lb
            r0 = 1
            goto Lc
        Lb:
            r0 = 0
        Lc:
            int r1 = r8.oldWidthMeasureSpec     // Catch: java.lang.Throwable -> L8f
            if (r9 != r1) goto L17
            int r1 = r8.oldHeightMeasureSpec     // Catch: java.lang.Throwable -> L8f
            if (r10 == r1) goto L15
            goto L17
        L15:
            r1 = 0
            goto L18
        L17:
            r1 = 1
        L18:
            int r4 = com.taobao.android.dinamicx.widget.DXWidgetNode.DXMeasureSpec.a(r9)     // Catch: java.lang.Throwable -> L8f
            r5 = 1073741824(0x40000000, float:2.0)
            if (r4 != r5) goto L28
            int r4 = com.taobao.android.dinamicx.widget.DXWidgetNode.DXMeasureSpec.a(r10)     // Catch: java.lang.Throwable -> L8f
            if (r4 != r5) goto L28
            r4 = 1
            goto L29
        L28:
            r4 = 0
        L29:
            int r5 = r8.getMeasuredWidth()     // Catch: java.lang.Throwable -> L8f
            int r6 = com.taobao.android.dinamicx.widget.DXWidgetNode.DXMeasureSpec.b(r9)     // Catch: java.lang.Throwable -> L8f
            if (r5 != r6) goto L3f
            int r5 = r8.getMeasuredHeight()     // Catch: java.lang.Throwable -> L8f
            int r6 = com.taobao.android.dinamicx.widget.DXWidgetNode.DXMeasureSpec.b(r10)     // Catch: java.lang.Throwable -> L8f
            if (r5 != r6) goto L3f
            r5 = 1
            goto L40
        L3f:
            r5 = 0
        L40:
            com.taobao.android.dinamicx.DXRuntimeContext r6 = r8.dXRuntimeContext     // Catch: java.lang.Throwable -> L8f
            if (r6 == 0) goto L50
            boolean r6 = r6.isRefreshPart()     // Catch: java.lang.Throwable -> L8f
            if (r6 == 0) goto L50
            r6 = 4
            boolean r6 = r8.getStatInPrivateFlags(r6)     // Catch: java.lang.Throwable -> L8f
            goto L51
        L50:
            r6 = 0
        L51:
            r8.oldWidthMeasureSpec = r9     // Catch: java.lang.Throwable -> L8f
            r8.oldHeightMeasureSpec = r10     // Catch: java.lang.Throwable -> L8f
            if (r4 == 0) goto L6b
            r7 = 1024(0x400, float:1.435E-42)
            boolean r7 = r8.getStatInPrivateFlags(r7)     // Catch: java.lang.Throwable -> L8f
            if (r7 == 0) goto L6b
            int r9 = com.taobao.android.dinamicx.widget.DXWidgetNode.DXMeasureSpec.b(r9)     // Catch: java.lang.Throwable -> L8f
            int r10 = com.taobao.android.dinamicx.widget.DXWidgetNode.DXMeasureSpec.b(r10)     // Catch: java.lang.Throwable -> L8f
            r8.setMeasuredDimension(r9, r10)     // Catch: java.lang.Throwable -> L8f
            return
        L6b:
            if (r1 == 0) goto L76
            boolean r1 = com.taobao.android.dinamicx.widget.DXWidgetNode.sAlwaysRemeasureExactly     // Catch: java.lang.Throwable -> L8f
            if (r1 != 0) goto L77
            if (r4 == 0) goto L77
            if (r5 != 0) goto L76
            goto L77
        L76:
            r2 = 0
        L77:
            if (r0 != 0) goto L7d
            if (r2 != 0) goto L7d
            if (r6 == 0) goto Lba
        L7d:
            r8.onMeasure(r9, r10)     // Catch: java.lang.Throwable -> L8f
            int r9 = r8.privateFlags     // Catch: java.lang.Throwable -> L8f
            r9 = r9 & (-5)
            r8.privateFlags = r9     // Catch: java.lang.Throwable -> L8f
            r9 = r9 | 16
            r8.privateFlags = r9     // Catch: java.lang.Throwable -> L8f
            r9 = r9 | 8
            r8.privateFlags = r9     // Catch: java.lang.Throwable -> L8f
            goto Lba
        L8f:
            r9 = move-exception
            tb.ry.b(r9)
            com.taobao.android.dinamicx.DXRuntimeContext r10 = r8.getDXRuntimeContext()
            if (r10 == 0) goto Lba
            com.taobao.android.dinamicx.e r0 = r10.getDxError()
            if (r0 == 0) goto Lba
            com.taobao.android.dinamicx.e$a r0 = new com.taobao.android.dinamicx.e$a
            r1 = 80006(0x13886, float:1.12112E-40)
            java.lang.String r2 = "Pipeline_Detail"
            java.lang.String r3 = "Pipeline_Detail_PerformMeasure"
            r0.<init>(r2, r3, r1)
            java.lang.String r9 = tb.ry.a(r9)
            r0.e = r9
            com.taobao.android.dinamicx.e r9 = r10.getDxError()
            java.util.List<com.taobao.android.dinamicx.e$a> r9 = r9.c
            r9.add(r0)
        Lba:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.android.dinamicx.widget.DXWidgetNode.measure(int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean needHandleDark() {
        return DXDarkModeCenter.d() && DXDarkModeCenter.c() && !isDisableDarkMode();
    }

    public void newDataParsersExprNode(int i) {
        this.dataParsersExprNode = new DXLongSparseArray<>(i);
    }

    public void newEnumMap() {
        this.enumMap = new DXLongSparseArray<>();
    }

    public void newEventHandlersExprNode(int i) {
        this.eventHandlersExprNode = new DXLongSparseArray<>(i);
    }

    public void onBeforeBindChildData() {
    }

    public void onBeginParser() {
    }

    public void onBeginParser(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onBindEvent(Context context, View view, long j) {
        if (this.enabled == 1) {
            if (j == 18903999933159L) {
                view.setOnClickListener(new a());
            } else if (j == -6544685697300501093L) {
                view.setOnLongClickListener(new b());
            }
        }
        if (j == 2683803675109176030L) {
            bindDataEvent();
        }
        prePareBindEvent(j);
    }

    public void onClone(DXWidgetNode dXWidgetNode, boolean z) {
        this.userId = dXWidgetNode.userId;
        this.autoId = dXWidgetNode.autoId;
        this.eventHandlersExprNode = dXWidgetNode.eventHandlersExprNode;
        this.dataParsersExprNode = dXWidgetNode.dataParsersExprNode;
        this.enumMap = dXWidgetNode.enumMap;
        this.privateFlags = dXWidgetNode.privateFlags;
        this.isFlatten = dXWidgetNode.isFlatten;
        this.needSetBackground = dXWidgetNode.needSetBackground;
        this.animation = dXWidgetNode.animation;
        this.propertyInitFlag = dXWidgetNode.propertyInitFlag;
        this.layoutWidth = dXWidgetNode.layoutWidth;
        this.layoutHeight = dXWidgetNode.layoutHeight;
        this.measuredWidth = dXWidgetNode.measuredWidth;
        this.measuredHeight = dXWidgetNode.measuredHeight;
        this.left = dXWidgetNode.left;
        this.top = dXWidgetNode.top;
        this.right = dXWidgetNode.right;
        this.bottom = dXWidgetNode.bottom;
        this.weight = dXWidgetNode.weight;
        this.marginLeft = dXWidgetNode.marginLeft;
        this.marginTop = dXWidgetNode.marginTop;
        this.marginRight = dXWidgetNode.marginRight;
        this.marginBottom = dXWidgetNode.marginBottom;
        this.paddingLeft = dXWidgetNode.paddingLeft;
        this.paddingTop = dXWidgetNode.paddingTop;
        this.paddingRight = dXWidgetNode.paddingRight;
        this.paddingBottom = dXWidgetNode.paddingBottom;
        this.visibility = dXWidgetNode.visibility;
        this.layoutGravity = dXWidgetNode.layoutGravity;
        this.childGravity = dXWidgetNode.childGravity;
        this.direction = dXWidgetNode.direction;
        this.alpha = dXWidgetNode.alpha;
        this.cornerRadius = dXWidgetNode.cornerRadius;
        this.cornerRadiusLeftTop = dXWidgetNode.cornerRadiusLeftTop;
        this.cornerRadiusRightTop = dXWidgetNode.cornerRadiusRightTop;
        this.cornerRadiusLeftBottom = dXWidgetNode.cornerRadiusLeftBottom;
        this.cornerRadiusRightBottom = dXWidgetNode.cornerRadiusRightBottom;
        this.borderWidth = dXWidgetNode.borderWidth;
        this.borderColor = dXWidgetNode.borderColor;
        this.borderType = dXWidgetNode.borderType;
        this.dashWidth = dXWidgetNode.dashWidth;
        this.dashGap = dXWidgetNode.dashGap;
        this.backGroundColor = dXWidgetNode.backGroundColor;
        this.accessibility = dXWidgetNode.accessibility;
        this.accessibilityText = dXWidgetNode.accessibilityText;
        this.enabled = dXWidgetNode.enabled;
        this.minHeight = dXWidgetNode.minHeight;
        this.minWidth = dXWidgetNode.minWidth;
        this.translateX = dXWidgetNode.translateX;
        this.translateY = dXWidgetNode.translateY;
        this.scaleX = dXWidgetNode.scaleX;
        this.scaleY = dXWidgetNode.scaleY;
        this.rotationX = dXWidgetNode.rotationX;
        this.bindingXSpecMap = dXWidgetNode.bindingXSpecMap;
        this.bindingXExecutingMap = dXWidgetNode.bindingXExecutingMap;
        this.lastAutoId = dXWidgetNode.lastAutoId;
        this.sourceWidgetWR = dXWidgetNode.sourceWidgetWR;
        this.clipChildren = dXWidgetNode.clipChildren;
        this.backgroundGradient = dXWidgetNode.backgroundGradient;
        this.darkModeColorMap = dXWidgetNode.darkModeColorMap;
        this.disableDarkMode = dXWidgetNode.disableDarkMode;
        this.eventResponseMode = dXWidgetNode.eventResponseMode;
        this.tborderJson = dXWidgetNode.tborderJson;
        this.softwareRender = dXWidgetNode.softwareRender;
        this.ref = dXWidgetNode.ref;
        if (!wt.k0()) {
            py pyVar = dXWidgetNode.dxEventChains;
            if (pyVar != null) {
                if (z) {
                    pyVar = pyVar.a();
                }
                this.dxEventChains = pyVar;
            }
        } else {
            this.dxEventChains = dXWidgetNode.dxEventChains;
        }
        byte[] bArr = dXWidgetNode.dxExprBytes;
        if (bArr != null) {
            this.dxExprBytes = bArr;
        }
        this.openNewFastReturnLogic = dXWidgetNode.openNewFastReturnLogic;
        this.mCodeMap = dXWidgetNode.mCodeMap;
        this.slotInfo = dXWidgetNode.slotInfo;
        this.paramsInfo = dXWidgetNode.paramsInfo;
        this.slotInfoJObj = dXWidgetNode.slotInfoJObj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View onCreateView(Context context) {
        return new View(context);
    }

    public void onEndParser() {
    }

    public void onEndParser(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean onEvent(hy hyVar) {
        DXTemplateItem dXTemplateItem;
        String str;
        wy wyVar;
        wy wyVar2;
        try {
            DXLongSparseArray<wy> dXLongSparseArray = this.eventHandlersExprNode;
            if (dXLongSparseArray == null || hyVar == null || (wyVar2 = dXLongSparseArray.get(hyVar.b())) == null) {
                return false;
            }
            if ((getDXRuntimeContext() == null || !getDXRuntimeContext().isOpenNewFastReturnLogic()) && !(wyVar2 instanceof qy) && !(wyVar2 instanceof f10) && !(wyVar2 instanceof b10)) {
                DXRuntimeContext dXRuntimeContext = getDXRuntimeContext();
                if (dXRuntimeContext != null && dXRuntimeContext.getDxError() != null) {
                    new e.a("Event", "Event_Cast_Exception", com.taobao.android.dinamicx.e.EVENT_DXEXPRNODE_CAST_ERROR, "eventid" + hyVar.b() + " exprNode id " + wyVar2.b + " exprNode name " + wyVar2.d);
                }
                return false;
            }
            wyVar2.b(hyVar, getDXRuntimeContext());
            return true;
        } catch (Exception e) {
            ry.b(e);
            if (getDXRuntimeContext() != null) {
                str = getDXRuntimeContext().getBizType();
                dXTemplateItem = getDXRuntimeContext().getDxTemplateItem();
            } else {
                dXTemplateItem = null;
                str = r10.DB_NAME;
            }
            String str2 = "";
            if (hyVar != null) {
                str2 = "eventId : " + hyVar.b();
                DXLongSparseArray<wy> dXLongSparseArray2 = this.eventHandlersExprNode;
                if (dXLongSparseArray2 != null && (wyVar = dXLongSparseArray2.get(hyVar.b())) != null) {
                    str2 = str2 + " exprNode id " + wyVar.b + " exprNode name " + wyVar.d;
                }
            }
            DXAppMonitor.q(str, dXTemplateItem, "Pipeline", "Pipeline_Stage_ON_EVENT", com.taobao.android.dinamicx.e.ONEVENT_CRASH, str2 + " crash stack: " + ry.a(e));
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    void onLongTap() {
        postEvent(new hy(-6544685697300501093L));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(getDefaultSize(getSuggestedMinimumWidth(), i), getDefaultSize(getSuggestedMinimumHeight(), i2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onRenderView(Context context, View view) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSetDoubleAttribute(long j, double d2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSetIntAttribute(long j, int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSetListAttribute(long j, JSONArray jSONArray) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSetLongAttribute(long j, long j2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSetMapAttribute(long j, JSONObject jSONObject) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSetObjAttribute(long j, Object obj) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSetStringAttribute(long j, String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSetUserDefinedListAttribute(long j, List<Object> list) {
    }

    final void onTapEvent() {
        postEvent(new hy(18903999933159L));
    }

    public final boolean postEvent(hy hyVar) {
        if (isSelfResponseEvent()) {
            if (!this.isFlatten) {
                return onEvent(hyVar);
            }
            return getReferenceNode().onEvent(hyVar);
        }
        return false;
    }

    void processUserId() {
        if (TextUtils.isEmpty(this.userId)) {
            return;
        }
        DXWidgetNode queryRootWidgetNode = queryRootWidgetNode();
        if (queryRootWidgetNode instanceof f) {
            Map<String, WeakReference<DXWidgetNode>> dxUserIdMap = ((f) queryRootWidgetNode).getDxUserIdMap();
            WeakReference<DXWidgetNode> weakReference = dxUserIdMap.get(this.userId);
            if (weakReference == null || weakReference.get() == null) {
                dxUserIdMap.put(this.userId, new WeakReference<>(this));
            }
        }
    }

    public void putBindingXExecutingSpec(nt ntVar) {
        if (ntVar == null || TextUtils.isEmpty(ntVar.a)) {
            return;
        }
        if (this.bindingXExecutingMap == null) {
            this.bindingXExecutingMap = new HashMap();
        }
        this.bindingXExecutingMap.put(ntVar.a, ntVar);
    }

    public DXWidgetNode queryRootWidgetNode() {
        if (this.dxRootWidgetCache != null && wt.P0(getDXRuntimeContext())) {
            return this.dxRootWidgetCache;
        }
        DXWidgetNode dXWidgetNode = this;
        while (dXWidgetNode.getParentWidget() != null) {
            DXWidgetNode parentWidget = dXWidgetNode.getParentWidget();
            if (parentWidget instanceof DXTemplateWidgetNode) {
                return dXWidgetNode;
            }
            dXWidgetNode = parentWidget;
        }
        this.dxRootWidgetCache = dXWidgetNode;
        return dXWidgetNode;
    }

    public DXWidgetNode queryWTByAutoId(int i) {
        if (this.autoId == i) {
            return this;
        }
        if (getChildrenCount() > 0) {
            for (DXWidgetNode dXWidgetNode : getChildren()) {
                DXWidgetNode queryWTByAutoId = dXWidgetNode.queryWTByAutoId(i);
                if (queryWTByAutoId != null) {
                    return queryWTByAutoId;
                }
            }
            return null;
        }
        return null;
    }

    public DXWidgetNode queryWTByUserId(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.equals(this.userId)) {
            return this;
        }
        if (getChildrenCount() > 0) {
            if (wt.P0(getDXRuntimeContext()) && (this instanceof DXTemplateWidgetNode)) {
                for (DXWidgetNode dXWidgetNode : getChildren()) {
                    DXWidgetNode queryWidgetNodeByUserIdFromMap = dXWidgetNode.queryWidgetNodeByUserIdFromMap(str, false);
                    if (queryWidgetNodeByUserIdFromMap != null) {
                        return queryWidgetNodeByUserIdFromMap;
                    }
                }
            } else {
                for (DXWidgetNode dXWidgetNode2 : getChildren()) {
                    DXWidgetNode queryWTByUserId = dXWidgetNode2.queryWTByUserId(str);
                    if (queryWTByUserId != null) {
                        return queryWTByUserId;
                    }
                }
            }
        }
        return null;
    }

    public DXWidgetNode queryWidgetNodeByAutoId(int i) {
        return queryRootWidgetNode().queryWTByAutoId(i);
    }

    public DXWidgetNode queryWidgetNodeByUserId(String str) {
        if (wt.P0(getDXRuntimeContext())) {
            DXWidgetNode queryWidgetNodeByUserIdFromMap = queryWidgetNodeByUserIdFromMap(str, true);
            if (queryWidgetNodeByUserIdFromMap == null && DinamicXEngine.x()) {
                nz.c(str + " queryWidgetNodeByUserId 没有找到");
            }
            return queryWidgetNodeByUserIdFromMap;
        }
        return queryRootWidgetNode().queryWTByUserId(str);
    }

    public void removeAllChild() {
        List<DXWidgetNode> list = this.children;
        if (list == null) {
            this.childrenCount = 0;
            return;
        }
        list.clear();
        this.childrenCount = 0;
    }

    public void removeBindingXSpec(nt ntVar) {
        if (this.bindingXExecutingMap == null || ntVar == null || TextUtils.isEmpty(ntVar.a)) {
            return;
        }
        this.bindingXExecutingMap.remove(ntVar.a);
    }

    public void removeChildWithAutoId(int i) {
        if (this.children == null || this.childrenCount == 0) {
            return;
        }
        for (int i2 = 0; i2 < this.childrenCount; i2++) {
            if (this.children.get(i2).autoId == i) {
                this.children.remove(i2);
                this.childrenCount--;
                return;
            }
        }
    }

    void renderTransformedProperty(View view) {
        if (this.translateX != view.getTranslationX()) {
            view.setTranslationX(this.translateX);
        }
        if (this.translateY != view.getTranslationY()) {
            view.setTranslationY(this.translateY);
        }
        if (this.rotationX != view.getRotationX()) {
            view.setRotationX(this.rotationX);
        }
        if (this.rotationY != view.getRotationY()) {
            view.setRotationY(this.rotationY);
        }
        if (this.rotationZ != view.getRotation()) {
            view.setRotation(this.rotationZ);
        }
        if (this.scaleX != view.getScaleX()) {
            view.setScaleX(this.scaleX);
        }
        if (this.scaleY != view.getScaleY()) {
            view.setScaleY(this.scaleY);
        }
    }

    public final void renderView(Context context) {
        try {
            View realView = getRealView();
            if (realView == null) {
                return;
            }
            if ((this.privateFlags & 256) != 0) {
                setRealViewVisibility(realView, this.visibility);
                float alpha = realView.getAlpha();
                float f = this.alpha;
                if (alpha != f) {
                    realView.setAlpha(f);
                }
                boolean z = this.enabled == 1;
                if (realView.isEnabled() != z) {
                    realView.setEnabled(z);
                }
                renderTransformedProperty(realView);
                setAccessibility(realView);
                DXWidgetNode referenceNode = getReferenceNode();
                referenceNode.setBackground(realView);
                referenceNode.onRenderView(context, realView);
                if (Build.VERSION.SDK_INT >= 17 && (realView instanceof ViewGroup)) {
                    realView.setLayoutDirection(getDirection());
                }
                referenceNode.setForceDark(realView);
            }
            int i = this.privateFlags & (-257);
            this.privateFlags = i;
            this.privateFlags = i | 512;
        } catch (Exception e) {
            ry.b(e);
            DXRuntimeContext dXRuntimeContext = getDXRuntimeContext();
            if (dXRuntimeContext == null || dXRuntimeContext.getDxError() == null) {
                return;
            }
            e.a aVar = new e.a("Render", "Pipeline_Detail_Render_Detail", 90002);
            aVar.e = ry.a(e);
            dXRuntimeContext.getDxError().c.add(aVar);
        }
    }

    public int replaceChild(DXWidgetNode dXWidgetNode, DXWidgetNode dXWidgetNode2) {
        if (!(this instanceof f) || dXWidgetNode2 == null) {
            return -1;
        }
        int i = 0;
        while (true) {
            if (i >= getChildrenCount()) {
                i = -1;
                break;
            } else if (getChildAt(i).getAutoId() == dXWidgetNode2.getAutoId()) {
                break;
            } else {
                i++;
            }
        }
        if (i != -1) {
            removeChildWithAutoId(dXWidgetNode2.getAutoId());
            insertChild(dXWidgetNode, i);
        }
        return i;
    }

    public final void requestLayout() {
        requestLayout(false);
    }

    public void sendBroadcastEvent(hy hyVar) {
        if (hyVar == null) {
            return;
        }
        if (getReferenceNode() != null && isSelfResponseEvent()) {
            postEvent(hyVar);
        }
        if (getChildrenCount() > 0) {
            for (DXWidgetNode dXWidgetNode : getChildren()) {
                if (isChildResponseEvent()) {
                    dXWidgetNode.sendBroadcastEvent(hyVar);
                }
            }
        }
    }

    void setAccessibility(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            int i = this.accessibility;
            if (i == -1 || i == 3) {
                return;
            }
            String str = this.accessibilityText;
            if (str != null) {
                view.setContentDescription(str);
            }
            int i2 = this.accessibility;
            if (i2 == 1) {
                view.setImportantForAccessibility(1);
                view.setFocusable(true);
                return;
            } else if (i2 == 2) {
                view.setImportantForAccessibility(4);
                return;
            } else {
                view.setImportantForAccessibility(2);
                return;
            }
        }
        view.setContentDescription("");
    }

    public void setAccessibilityText(String str) {
        this.accessibilityText = str;
    }

    public void setAlpha(float f) {
        this.alpha = f;
    }

    public void setAnimation(String str) {
        this.animation = str;
    }

    public void setAutoId(int i) {
        this.autoId = i;
    }

    public void setBackGroundColor(int i) {
        if (i != this.backGroundColor) {
            this.backGroundColor = i;
            this.needSetBackground = true;
        }
    }

    public void setBackground(View view) {
        int i;
        int i2;
        if (this.needSetBackground) {
            int tryFetchDarkModeColor = tryFetchDarkModeColor("backgroundColor", 1, this.backGroundColor);
            int tryFetchDarkModeColor2 = tryFetchDarkModeColor("borderColor", 2, this.borderColor);
            Drawable background = view.getBackground();
            if (this.borderType == 1) {
                if (this.dashWidth <= -1 && DinamicXEngine.i() != null) {
                    this.dashWidth = z00.b(DinamicXEngine.i(), 6.0f);
                }
                if (this.dashGap <= -1 && DinamicXEngine.i() != null) {
                    this.dashGap = z00.b(DinamicXEngine.i(), 4.0f);
                }
                i = this.dashWidth;
                i2 = this.dashGap;
            } else {
                i = 0;
                i2 = 0;
            }
            if (background != null && (background instanceof GradientDrawable)) {
                GradientDrawable gradientDrawable = (GradientDrawable) background;
                gradientDrawable.setColor(tryFetchDarkModeColor);
                int i3 = this.cornerRadius;
                if (i3 > 0) {
                    gradientDrawable.setCornerRadius(i3);
                } else {
                    int i4 = this.cornerRadiusLeftTop;
                    int i5 = this.cornerRadiusRightTop;
                    int i6 = this.cornerRadiusRightBottom;
                    int i7 = this.cornerRadiusLeftBottom;
                    gradientDrawable.setCornerRadii(new float[]{i4, i4, i5, i5, i6, i6, i7, i7});
                }
                int i8 = this.borderWidth;
                if (i8 > 0 && tryFetchDarkModeColor2 != 0) {
                    gradientDrawable.setStroke(i8, tryFetchDarkModeColor2, i, i2);
                } else if (i8 > 0 && tryFetchDarkModeColor2 == 0) {
                    gradientDrawable.setStroke(0, 0, 0.0f, 0.0f);
                }
                d dVar = this.backgroundGradient;
                if (dVar == null || dVar.a() != 0) {
                    return;
                }
                gradientDrawable.setGradientType(this.backgroundGradient.a());
                if (Build.VERSION.SDK_INT >= 16) {
                    gradientDrawable.setOrientation(this.backgroundGradient.c());
                    gradientDrawable.setColors(this.backgroundGradient.b());
                }
            } else if (!hasCornerRadius() && tryFetchDarkModeColor2 == 0 && this.borderWidth <= 0 && this.backgroundGradient == null) {
                view.setBackgroundColor(tryFetchDarkModeColor);
            } else {
                GradientDrawable gradientDrawable2 = new GradientDrawable();
                int i9 = this.cornerRadius;
                if (i9 > 0) {
                    gradientDrawable2.setCornerRadius(i9);
                } else {
                    int i10 = this.cornerRadiusLeftTop;
                    int i11 = this.cornerRadiusRightTop;
                    int i12 = this.cornerRadiusRightBottom;
                    int i13 = this.cornerRadiusLeftBottom;
                    gradientDrawable2.setCornerRadii(new float[]{i10, i10, i11, i11, i12, i12, i13, i13});
                }
                gradientDrawable2.setShape(0);
                gradientDrawable2.setColor(tryFetchDarkModeColor);
                int i14 = this.borderWidth;
                if (i14 > 0 && tryFetchDarkModeColor2 != 0) {
                    gradientDrawable2.setStroke(i14, tryFetchDarkModeColor2, i, i2);
                } else if (i14 > 0 && tryFetchDarkModeColor2 == 0) {
                    gradientDrawable2.setStroke(0, 0, 0.0f, 0.0f);
                }
                d dVar2 = this.backgroundGradient;
                if (dVar2 != null && dVar2.a() == 0) {
                    gradientDrawable2.setGradientType(this.backgroundGradient.a());
                    if (Build.VERSION.SDK_INT >= 16) {
                        gradientDrawable2.setOrientation(this.backgroundGradient.c());
                        gradientDrawable2.setColors(this.backgroundGradient.b());
                    }
                }
                if (Build.VERSION.SDK_INT >= 16) {
                    view.setBackground(gradientDrawable2);
                } else {
                    view.setBackgroundDrawable(gradientDrawable2);
                }
            }
        }
    }

    public void setBackgroundGradient(d dVar) {
        this.backgroundGradient = dVar;
    }

    public void setBindingXExecutingMap(Map<String, nt> map) {
        this.bindingXExecutingMap = map;
    }

    public void setBindingXSpecMap(Map<String, nt> map) {
        this.bindingXSpecMap = map;
    }

    public void setBorderColor(int i) {
        if (i != this.borderColor) {
            this.borderColor = i;
            this.needSetBackground = true;
        }
    }

    public void setBorderType(int i) {
    }

    public void setBorderWidth(int i) {
        if (this.borderWidth != i) {
            this.borderWidth = i;
            this.needSetBackground = true;
        }
    }

    public void setBottom(int i) {
        this.bottom = i;
    }

    public void setChildGravity(int i) {
        this.childGravity = i;
    }

    public void setCodeMap(DXLongSparseArray<wy> dXLongSparseArray) {
        this.mCodeMap = dXLongSparseArray;
    }

    public void setCornerRadius(int i) {
        if (this.cornerRadius != i) {
            this.cornerRadius = i;
            this.needSetBackground = true;
        }
    }

    public void setCornerRadiusLeftBottom(int i) {
        this.cornerRadiusLeftBottom = i;
    }

    public void setCornerRadiusLeftTop(int i) {
        this.cornerRadiusLeftTop = i;
    }

    public void setCornerRadiusRightBottom(int i) {
        this.cornerRadiusRightBottom = i;
    }

    public void setCornerRadiusRightTop(int i) {
        this.cornerRadiusRightTop = i;
    }

    public void setDXRuntimeContext(DXRuntimeContext dXRuntimeContext) {
        this.dXRuntimeContext = dXRuntimeContext;
    }

    public void setDataParsersExprNode(DXLongSparseArray<wy> dXLongSparseArray) {
        this.dataParsersExprNode = dXLongSparseArray;
    }

    public void setDirection(int i) {
        this.direction = i;
    }

    public void setDisableDarkMode(boolean z) {
        this.disableDarkMode = z;
    }

    public void setDoubleAttribute(long j, double d2) {
        if (10439708918555150L == j) {
            this.weight = d2;
        } else if (16887479372907L == j) {
            this.alpha = (float) d2;
        } else {
            onSetDoubleAttribute(j, d2);
        }
    }

    public void setDxEventChains(py pyVar) {
        this.dxEventChains = pyVar;
    }

    public void setDxExprBytes(byte[] bArr) {
        this.dxExprBytes = bArr;
    }

    public void setEnabled(int i) {
        this.enabled = i;
    }

    public void setEnumMap(DXLongSparseArray<Map<String, Integer>> dXLongSparseArray) {
        this.enumMap = dXLongSparseArray;
    }

    public void setEventHandlersExprNode(DXLongSparseArray<wy> dXLongSparseArray) {
        this.eventHandlersExprNode = dXLongSparseArray;
    }

    public void setEventResponseMode(int i) {
        this.eventResponseMode = i;
    }

    public void setFlatten(boolean z) {
        this.isFlatten = z;
    }

    protected void setForceDark(View view) {
        if (DXDarkModeCenter.d() && DXDarkModeCenter.c()) {
            if (this.disableDarkMode) {
                DXDarkModeCenter.a(view);
            } else if (extraHandleDark() || this.hasHandleDark) {
                DXDarkModeCenter.a(view);
            }
        }
    }

    protected boolean setFrame(int i, int i2, int i3, int i4) {
        if (this.left == i && this.right == i3 && this.top == i2 && this.bottom == i4) {
            return false;
        }
        this.left = i;
        this.top = i2;
        this.right = i3;
        this.bottom = i4;
        return true;
    }

    public final void setIntAttribute(long j, int i) {
        if (20052926345925L == j) {
            this.layoutWidth = i;
        } else if (9346582897824575L == j) {
            this.layoutHeight = i;
        } else if (-916628110244908525L == j) {
            this.marginLeft = i;
        } else if (-4674119579031497081L == j) {
            this.marginRight = i;
        } else if (-2641581645694792774L == j) {
            this.marginTop = i;
        } else if (6506044224063169535L == j) {
            this.marginBottom = i;
        } else if (-378913133726214547L == j) {
            this.paddingLeft = i;
        } else if (3229586316762092001L == j) {
            this.paddingRight = i;
        } else if (-2632461973017864940L == j) {
            this.paddingTop = i;
        } else if (-4745829179314597287L == j) {
            this.paddingBottom = i;
        } else {
            if (4879707785646574221L == j && i >= 0 && i <= 8) {
                this.layoutGravity = i;
                this.propertyInitFlag |= 1;
            } else if (-3218010051991756042L == j && i >= 0 && i <= 8) {
                this.childGravity = i;
            } else if (7504432960089273802L == j && (i == 0 || i == 1)) {
                setDirection(i);
            } else if (5802348655878590802L == j && (i == 0 || i == 1 || i == 2)) {
                this.visibility = i;
            } else if (6313115730157071869L == j) {
                this.cornerRadius = i;
                this.needSetBackground = true;
            } else if (-7043958449911898942L == j) {
                this.cornerRadiusLeftTop = i;
                this.needSetBackground = true;
            } else if (8679583519247168310L == j) {
                this.cornerRadiusRightTop = i;
                this.needSetBackground = true;
            } else if (-3738348576243028217L == j) {
                this.cornerRadiusLeftBottom = i;
                this.needSetBackground = true;
            } else if (1691221861925381243L == j) {
                this.cornerRadiusRightBottom = i;
                this.needSetBackground = true;
            } else if (-8019934667170236535L == j) {
                this.borderWidth = i;
                this.needSetBackground = true;
            } else if (-8020113231441560440L == j) {
                this.borderColor = i;
                this.needSetBackground = true;
            } else if (1844153004063100714L == j) {
                this.borderType = i;
                this.needSetBackground = true;
            } else if (3657130712798351885L == j) {
                this.dashWidth = i;
            } else if (5384687760714897699L == j) {
                this.dashGap = i;
            } else if (-6716070147120443019L == j) {
                this.accessibility = i;
            } else if (-2819959685970048978L == j) {
                this.backGroundColor = i;
                this.needSetBackground = true;
            } else if (4804789929613330386L == j) {
                this.enabled = i;
            } else if (2051502660558186662L == j) {
                this.minHeight = i;
            } else if (j == 3998176004939777025L) {
                this.softwareRender = i != 0;
            } else if (4694181495334893900L == j) {
                this.minWidth = i;
            } else if (j == -8044124925891189930L) {
                this.clipChildren = i == 1;
            } else if (j == -6579663421190292502L) {
                this.disableDarkMode = i != 0;
            } else if (j == -5241271604340946425L) {
                this.eventResponseMode = i;
            } else if (j == 9037937761546515694L) {
                this.openNewFastReturnLogic = i == 1;
            } else {
                onSetIntAttribute(j, i);
            }
        }
    }

    public void setLastAutoId(int i) {
        this.lastAutoId = i;
    }

    public void setLayoutGravity(int i) {
        this.layoutGravity = i;
        this.propertyInitFlag |= 1;
    }

    public void setLayoutHeight(int i) {
        this.layoutHeight = i;
    }

    public void setLayoutWidth(int i) {
        this.layoutWidth = i;
    }

    public void setLeft(int i) {
        this.left = i;
    }

    public void setListAttribute(long j, JSONArray jSONArray) {
        onSetListAttribute(j, jSONArray);
    }

    public void setLongAttribute(long j, long j2) {
        onSetLongAttribute(j, j2);
    }

    public void setMapAttribute(long j, JSONObject jSONObject) {
        onSetMapAttribute(j, jSONObject);
    }

    public void setMarginBottom(int i) {
        this.marginBottom = i;
    }

    public void setMarginLeft(int i) {
        this.marginLeft = i;
    }

    public void setMarginRight(int i) {
        this.marginRight = i;
    }

    public void setMarginTop(int i) {
        this.marginTop = i;
    }

    public final void setMeasuredDimension(int i, int i2) {
        this.measuredWidth = i;
        this.measuredHeight = i2;
    }

    public void setMinHeight(int i) {
        this.minHeight = i;
    }

    public void setMinWidth(int i) {
        this.minWidth = i;
    }

    public void setNeedLayout(DXWidgetRefreshOption dXWidgetRefreshOption) {
        if (dXWidgetRefreshOption == null) {
            dXWidgetRefreshOption = new DXWidgetRefreshOption();
        }
        setStatFlag(16384);
        setStatFlag(4);
        unsetStatFlag(8);
        unsetStatFlag(32);
        if (dXWidgetRefreshOption.b()) {
            bindChildrenMeasureFlag(dXWidgetRefreshOption);
        }
        DXWidgetNode dXWidgetNode = this.parentWidget;
        if (dXWidgetNode != null) {
            dXWidgetNode.bindParentMeasureFlag(false, dXWidgetRefreshOption.c());
        } else {
            sendPartMeasureLayoutEvent(dXWidgetRefreshOption.c());
        }
    }

    public final void setNeedParse() {
        int i = this.privateFlags & (-3);
        this.privateFlags = i;
        this.privateFlags = i | 1;
        if (!wt.A0()) {
            if (this instanceof DXRecyclerLayout) {
                refreshRecyclerLayout();
                return;
            }
        } else {
            DXWidgetNode dXWidgetNode = this.parentWidget;
            if (dXWidgetNode instanceof DXRecyclerLayout) {
                ((DXRecyclerLayout) dXWidgetNode).updateCurrent(this);
            }
        }
        DXWidgetNode dXWidgetNode2 = this.parentWidget;
        if (dXWidgetNode2 != null) {
            dXWidgetNode2.setNeedParse();
            return;
        }
        DXRuntimeContext dXRuntimeContext = getDXRuntimeContext();
        if (dXRuntimeContext == null) {
            return;
        }
        DXRenderPipeline dxRenderPipeline = dXRuntimeContext.getDxRenderPipeline();
        bu dxControlEventCenter = dXRuntimeContext.getDxControlEventCenter();
        if (dxRenderPipeline == null || dxControlEventCenter == null) {
            return;
        }
        com.taobao.android.dinamicx.h j = dxRenderPipeline.j();
        if (j != null) {
            j.j(dXRuntimeContext.getCacheIdentify());
        }
        f00 f00Var = new f00();
        f00Var.d = 2;
        f00Var.a = this;
        dxControlEventCenter.b(f00Var);
    }

    public final void setNeedRender(Context context) {
        this.privateFlags |= 256;
        renderView(context);
    }

    public void setNeedSetBackground(boolean z) {
        this.needSetBackground = z;
    }

    public final void setObjAttribute(long j, Object obj) {
        if (obj == null) {
            return;
        }
        if (j == 3436950829494956384L) {
            this.backgroundGradient = (d) obj;
            this.needSetBackground = true;
        } else if (j == -396946557348092076L) {
            this.darkModeColorMap = (HashMap) obj;
        } else {
            onSetObjAttribute(j, obj);
        }
    }

    public void setPaddingBottom(int i) {
        this.paddingBottom = i;
    }

    public void setPaddingLeft(int i) {
        this.paddingLeft = i;
    }

    public void setPaddingRight(int i) {
        this.paddingRight = i;
    }

    public void setPaddingTop(int i) {
        this.paddingTop = i;
    }

    public void setParamsInfo(JSONObject jSONObject) {
        this.paramsInfo = jSONObject;
    }

    public void setParentWidget(DXWidgetNode dXWidgetNode) {
        this.parentWidget = dXWidgetNode;
    }

    public void setRealViewLayoutParam(View view) {
        ViewGroup.LayoutParams generateLayoutParams;
        if (view == null) {
            return;
        }
        DXWidgetNode dXWidgetNode = this.parentWidget;
        if (dXWidgetNode != null && (dXWidgetNode instanceof f)) {
            lz lzVar = attributeThreadLocal.get();
            this.realLayoutAttribute = lzVar;
            if (lzVar == null) {
                lz lzVar2 = new lz();
                this.realLayoutAttribute = lzVar2;
                attributeThreadLocal.set(lzVar2);
            }
            this.realLayoutAttribute.a = getMeasuredWidth();
            this.realLayoutAttribute.b = getMeasuredHeight();
            f fVar = (f) this.parentWidget;
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                generateLayoutParams = fVar.generateLayoutParams(this.realLayoutAttribute);
            } else {
                generateLayoutParams = fVar.generateLayoutParams(this.realLayoutAttribute, layoutParams);
            }
            view.setLayoutParams(generateLayoutParams);
            return;
        }
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams2 = new ViewGroup.LayoutParams(getMeasuredWidth(), getMeasuredHeight());
        } else {
            layoutParams2.width = getMeasuredWidth();
            layoutParams2.height = getMeasuredHeight();
        }
        view.setLayoutParams(layoutParams2);
    }

    void setRealViewVisibility(View view, int i) {
        if (view == null) {
            return;
        }
        int i2 = 0;
        if (i != 0) {
            if (i == 1) {
                i2 = 4;
            } else if (i == 2) {
                i2 = 8;
            }
        }
        if (view.getVisibility() != i2) {
            view.setVisibility(i2);
        }
    }

    public void setReferenceNode(DXWidgetNode dXWidgetNode) {
        if (dXWidgetNode == null) {
            this.referenceNode = null;
        } else {
            this.referenceNode = new WeakReference<>(dXWidgetNode);
        }
    }

    public void setRight(int i) {
        this.right = i;
    }

    public void setRotationX(float f) {
        this.rotationX = f;
    }

    public void setRotationY(float f) {
        this.rotationY = f;
    }

    public void setRotationZ(float f) {
        this.rotationZ = f;
    }

    public void setScaleX(float f) {
        this.scaleX = f;
    }

    public void setScaleY(float f) {
        this.scaleY = f;
    }

    public void setSlotInfo(JSONArray jSONArray) {
        this.slotInfo = jSONArray;
    }

    public void setSlotInfoJObj(JSONObject jSONObject) {
        this.slotInfoJObj = jSONObject;
    }

    public void setSourceWidget(DXWidgetNode dXWidgetNode) {
        if (dXWidgetNode == null) {
            return;
        }
        this.sourceWidgetWR = new WeakReference<>(dXWidgetNode);
    }

    public void setStatFlag(int i) {
        this.privateFlags = i | this.privateFlags;
    }

    public void setStringAttribute(long j, String str) {
        if (10297924263834610L == j) {
            this.userId = str;
        } else if (6301829145275697438L == j) {
            this.accessibilityText = str;
        } else if (j == DXOverlayWidgetNode.DXOVERLAY_ANIMATION) {
            this.animation = str;
        } else if (j != DXVIEW_TBORDERJSON) {
            if (j == 526314816) {
                this.ref = str;
            } else {
                onSetStringAttribute(j, str);
            }
        } else {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                this.tborderJson = JSON.parseObject(str);
            } catch (Exception e) {
                ry.b(e);
            }
        }
    }

    public void setTop(int i) {
        this.top = i;
    }

    public void setTranslateX(float f) {
        this.translateX = f;
    }

    public void setTranslateY(float f) {
        this.translateY = f;
    }

    public final void setUserDefinedListAttribute(long j, List<Object> list) {
        onSetUserDefinedListAttribute(j, list);
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public void setVisibility(int i) {
        this.visibility = i;
    }

    public void setWRView(WeakReference<View> weakReference) {
        this.weakView = weakReference;
    }

    public void setWeight(double d2) {
        this.weight = d2;
    }

    public Object shallowClone(@NonNull DXRuntimeContext dXRuntimeContext, boolean z) {
        DXWidgetNode build = build(null);
        if (build == null) {
            return null;
        }
        if (dXRuntimeContext != null) {
            build.dXRuntimeContext = dXRuntimeContext.cloneWithWidgetNode(build);
        }
        build.onClone(this, z);
        return build;
    }

    public String toSelfWidgetNodeInfo() {
        return getClass().getName() + m80.DINAMIC_PREFIX_AT + hashCode() + "_[w: " + getMeasuredWidth() + "]_[h: " + getMeasuredHeight() + jn1.ARRAY_END_STR;
    }

    public String toTreeInfo() {
        DXWidgetNode queryRootWidgetNode = queryRootWidgetNode();
        if (queryRootWidgetNode != this) {
            return queryRootWidgetNode.toTreeInfo();
        }
        JSONObject jSONObject = new JSONObject(true);
        parseTreeInfo(jSONObject);
        return jSONObject.toJSONString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int tryFetchDarkModeColor(String str, int i, @ColorInt int i2) {
        Integer num;
        if (needHandleDark()) {
            HashMap<String, Integer> hashMap = this.darkModeColorMap;
            if (hashMap != null && (num = hashMap.get(str)) != null) {
                this.hasHandleDark = true;
                return num.intValue();
            } else if (DXDarkModeCenter.b()) {
                this.hasHandleDark = true;
                return DXDarkModeCenter.e(i, i2);
            } else {
                return i2;
            }
        }
        return i2;
    }

    public void unsetStatFlag(int i) {
        this.privateFlags = (~i) & this.privateFlags;
    }

    public void updateRefreshType(int i) {
        DXRuntimeContext dXRuntimeContext = this.dXRuntimeContext;
        if (dXRuntimeContext == null) {
            return;
        }
        dXRuntimeContext.setRefreshType(i);
        if (this.childrenCount > 0) {
            for (DXWidgetNode dXWidgetNode : this.children) {
                dXWidgetNode.updateRefreshType(i);
            }
        }
    }

    public final void addChild(DXWidgetNode dXWidgetNode, boolean z) {
        if (dXWidgetNode == null || dXWidgetNode == this) {
            return;
        }
        if (this.children == null) {
            this.children = new ArrayList();
            this.childrenCount = 0;
        }
        this.children.add(dXWidgetNode);
        this.childrenCount++;
        dXWidgetNode.parentWidget = this;
        DXRuntimeContext dXRuntimeContext = this.dXRuntimeContext;
        if (dXRuntimeContext == null || !z) {
            return;
        }
        dXWidgetNode.dXRuntimeContext = dXRuntimeContext.cloneWithWidgetNode(dXWidgetNode);
    }

    public void bindRuntimeContext(DXRuntimeContext dXRuntimeContext, boolean z) {
        if (dXRuntimeContext == null) {
            return;
        }
        Object obj = null;
        int i = 0;
        if (z) {
            obj = this.dXRuntimeContext.getSubData();
            i = this.dXRuntimeContext.getSubdataIndex();
        }
        if (this.dXRuntimeContext != dXRuntimeContext) {
            DXRuntimeContext cloneWithWidgetNode = dXRuntimeContext.cloneWithWidgetNode(this);
            this.dXRuntimeContext = cloneWithWidgetNode;
            if (z) {
                cloneWithWidgetNode.setSubData(obj);
                this.dXRuntimeContext.setSubdataIndex(i);
            }
        }
        if (this.childrenCount > 0) {
            for (DXWidgetNode dXWidgetNode : this.children) {
                dXWidgetNode.bindRuntimeContext(dXRuntimeContext, z);
            }
        }
    }

    public void insertChild(DXWidgetNode dXWidgetNode, int i, boolean z) {
        if (dXWidgetNode == null || dXWidgetNode == this || i > this.childrenCount) {
            return;
        }
        if (this.children == null) {
            this.children = new ArrayList();
            this.childrenCount = 0;
        }
        this.children.add(i, dXWidgetNode);
        this.childrenCount++;
        dXWidgetNode.parentWidget = this;
        DXRuntimeContext dXRuntimeContext = this.dXRuntimeContext;
        if (dXRuntimeContext == null || !z) {
            return;
        }
        dXWidgetNode.dXRuntimeContext = dXRuntimeContext.cloneWithWidgetNode(dXWidgetNode);
    }

    public final void requestLayout(boolean z) {
        int i = this.privateFlags | 16384;
        this.privateFlags = i;
        this.privateFlags = i & (-41);
        DXWidgetNode dXWidgetNode = this.parentWidget;
        if (dXWidgetNode != null) {
            dXWidgetNode.requestLayout(z);
            return;
        }
        DXRuntimeContext dXRuntimeContext = getDXRuntimeContext();
        if (dXRuntimeContext == null) {
            return;
        }
        DXRenderPipeline dxRenderPipeline = dXRuntimeContext.getDxRenderPipeline();
        bu dxControlEventCenter = dXRuntimeContext.getDxControlEventCenter();
        if (dxRenderPipeline == null || dxControlEventCenter == null) {
            return;
        }
        com.taobao.android.dinamicx.h j = dxRenderPipeline.j();
        if (j != null) {
            j.j(dXRuntimeContext.getCacheIdentify());
        }
        f00 f00Var = new f00();
        f00Var.d = 3;
        f00Var.a = this;
        if (z) {
            f00Var.e = 1;
        } else {
            f00Var.e = 0;
        }
        dxControlEventCenter.a(f00Var);
    }

    public void setCornerRadius(int i, int i2, int i3, int i4) {
        this.cornerRadiusLeftTop = i;
        this.cornerRadiusRightTop = i2;
        this.cornerRadiusLeftBottom = i3;
        this.cornerRadiusRightBottom = i4;
        this.needSetBackground = true;
    }

    public void setAccessibility(int i) {
        this.accessibility = i;
    }

    public final void setNeedLayout() {
        setNeedLayout(false);
    }

    public final void setNeedLayout(boolean z) {
        int i = this.privateFlags | 16384;
        this.privateFlags = i;
        this.privateFlags = i & (-41);
        if (wt.A0()) {
            DXWidgetNode dXWidgetNode = this.parentWidget;
            if (dXWidgetNode instanceof DXRecyclerLayout) {
                if (z) {
                    updateRefreshType(1);
                    ((DXRecyclerLayout) this.parentWidget).refreshCurrentNode(this);
                    return;
                }
                ((DXRecyclerLayout) dXWidgetNode).updateCurrent(this);
                return;
            }
        }
        DXWidgetNode dXWidgetNode2 = this.parentWidget;
        if (dXWidgetNode2 != null) {
            dXWidgetNode2.setNeedLayout(z);
            return;
        }
        DXRuntimeContext dXRuntimeContext = getDXRuntimeContext();
        if (dXRuntimeContext == null) {
            return;
        }
        DXRenderPipeline dxRenderPipeline = dXRuntimeContext.getDxRenderPipeline();
        bu dxControlEventCenter = dXRuntimeContext.getDxControlEventCenter();
        if (dxRenderPipeline == null || dxControlEventCenter == null) {
            return;
        }
        com.taobao.android.dinamicx.h j = dxRenderPipeline.j();
        if (j != null) {
            j.j(dXRuntimeContext.getCacheIdentify());
        }
        f00 f00Var = new f00();
        f00Var.d = 3;
        f00Var.a = this;
        if (z) {
            f00Var.e = 1;
        } else {
            f00Var.e = 0;
        }
        dxControlEventCenter.b(f00Var);
    }

    public void setNeedParse(DXWidgetRefreshOption dXWidgetRefreshOption) {
        if (dXWidgetRefreshOption == null) {
            dXWidgetRefreshOption = new DXWidgetRefreshOption();
        }
        int i = this.privateFlags & (-3);
        this.privateFlags = i;
        this.privateFlags = i | 1;
        if (!isMarkContainerLayout()) {
            unsetStatFlag(4096);
        }
        this.privateFlags |= 4;
        if (dXWidgetRefreshOption.b()) {
            bindChildrenParseFlag(dXWidgetRefreshOption);
        }
        DXWidgetNode dXWidgetNode = this.parentWidget;
        if (dXWidgetNode != null) {
            dXWidgetNode.bindParentMeasureFlag(true, dXWidgetRefreshOption.c());
        } else {
            sendPartParserEvent(dXWidgetRefreshOption.c());
        }
    }

    public final void setNeedParse(boolean z) {
        if (!z) {
            setNeedParse();
            return;
        }
        int i = this.privateFlags & (-3);
        this.privateFlags = i;
        int i2 = i | 1;
        this.privateFlags = i2;
        this.privateFlags = i2 | 4;
        DXWidgetNode dXWidgetNode = this.parentWidget;
        if (dXWidgetNode != null) {
            dXWidgetNode.bindParentMeasureFlag(true, false);
        } else {
            sendPartParserEvent(false);
        }
    }
}
