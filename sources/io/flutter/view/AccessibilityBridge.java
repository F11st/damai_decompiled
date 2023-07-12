package io.flutter.view;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ContentResolver;
import android.database.ContentObserver;
import android.graphics.Rect;
import android.net.Uri;
import android.opengl.Matrix;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.LocaleSpan;
import android.text.style.TtsSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import io.flutter.FlutterInjector;
import io.flutter.Log;
import io.flutter.embedding.android.SystemProperties;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.systemchannels.AccessibilityChannel;
import io.flutter.plugin.platform.PlatformViewsAccessibilityDelegate;
import io.flutter.stat.StatServices;
import io.flutter.util.Predicate;
import io.flutter.util.ViewUtils;
import io.flutter.view.AccessibilityBridge;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mtopsdk.common.util.SymbolExpUtil;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class AccessibilityBridge extends AccessibilityNodeProvider {
    private static final int ACTION_SHOW_ON_SCREEN = 16908342;
    private static int FIRST_RESOURCE_ID = 267386881;
    private static final int MIN_ENGINE_GENERATED_NODE_ID = 65536;
    private static final int ROOT_NODE_ID = 0;
    private static final float SCROLL_EXTENT_FOR_INFINITY = 100000.0f;
    private static final float SCROLL_POSITION_CAP_FOR_INFINITY = 70000.0f;
    private static final String TAG = "AccessibilityBridge";
    private static boolean sForceEnableByLocal;
    private static boolean sHasDetectLocalFlag;
    @NonNull
    private final AccessibilityChannel accessibilityChannel;
    private int accessibilityFeatureFlags;
    @Nullable
    private SemanticsNode accessibilityFocusedSemanticsNode;
    @NonNull
    private final AccessibilityManager accessibilityManager;
    private final AccessibilityChannel.AccessibilityMessageHandler accessibilityMessageHandler;
    private final AccessibilityManager.AccessibilityStateChangeListener accessibilityStateChangeListener;
    @NonNull
    private final AccessibilityViewEmbedder accessibilityViewEmbedder;
    private final ContentObserver animationScaleObserver;
    @NonNull
    private final ContentResolver contentResolver;
    @NonNull
    private final Map<Integer, CustomAccessibilityAction> customAccessibilityActions;
    private Integer embeddedAccessibilityFocusedNodeId;
    private Integer embeddedInputFocusedNodeId;
    @NonNull
    private final List<Integer> flutterNavigationStack;
    @NonNull
    private final Map<Integer, SemanticsNode> flutterSemanticsTree;
    @Nullable
    private SemanticsNode hoveredObject;
    @Nullable
    private SemanticsNode inputFocusedSemanticsNode;
    private boolean isReleased;
    @Nullable
    private SemanticsNode lastInputFocusedSemanticsNode;
    @NonNull
    private Integer lastLeftFrameInset;
    @Nullable
    private OnAccessibilityChangeListener onAccessibilityChangeListener;
    @NonNull
    private final PlatformViewsAccessibilityDelegate platformViewsAccessibilityDelegate;
    private int previousRouteId;
    @NonNull
    private final View rootAccessibilityView;
    @RequiresApi(19)
    @TargetApi(19)
    private final AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: io.flutter.view.AccessibilityBridge$5  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] $SwitchMap$io$flutter$view$AccessibilityBridge$StringAttributeType;

        static {
            int[] iArr = new int[StringAttributeType.values().length];
            $SwitchMap$io$flutter$view$AccessibilityBridge$StringAttributeType = iArr;
            try {
                iArr[StringAttributeType.SPELLOUT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$flutter$view$AccessibilityBridge$StringAttributeType[StringAttributeType.LOCALE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public enum AccessibilityFeature {
        ACCESSIBLE_NAVIGATION(1),
        INVERT_COLORS(2),
        DISABLE_ANIMATIONS(4);
        
        final int value;

        AccessibilityFeature(int i) {
            this.value = i;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public enum Action {
        TAP(1),
        LONG_PRESS(2),
        SCROLL_LEFT(4),
        SCROLL_RIGHT(8),
        SCROLL_UP(16),
        SCROLL_DOWN(32),
        INCREASE(64),
        DECREASE(128),
        SHOW_ON_SCREEN(256),
        MOVE_CURSOR_FORWARD_BY_CHARACTER(512),
        MOVE_CURSOR_BACKWARD_BY_CHARACTER(1024),
        SET_SELECTION(2048),
        COPY(4096),
        CUT(8192),
        PASTE(16384),
        DID_GAIN_ACCESSIBILITY_FOCUS(32768),
        DID_LOSE_ACCESSIBILITY_FOCUS(65536),
        CUSTOM_ACTION(131072),
        DISMISS(262144),
        MOVE_CURSOR_FORWARD_BY_WORD(524288),
        MOVE_CURSOR_BACKWARD_BY_WORD(1048576),
        SET_TEXT(2097152);
        
        public final int value;

        Action(int i) {
            this.value = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static class CustomAccessibilityAction {
        private String hint;
        private String label;
        private int resourceId = -1;
        private int id = -1;
        private int overrideId = -1;

        CustomAccessibilityAction() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public enum Flag {
        HAS_CHECKED_STATE(1),
        IS_CHECKED(2),
        IS_SELECTED(4),
        IS_BUTTON(8),
        IS_TEXT_FIELD(16),
        IS_FOCUSED(32),
        HAS_ENABLED_STATE(64),
        IS_ENABLED(128),
        IS_IN_MUTUALLY_EXCLUSIVE_GROUP(256),
        IS_HEADER(512),
        IS_OBSCURED(1024),
        SCOPES_ROUTE(2048),
        NAMES_ROUTE(4096),
        IS_HIDDEN(8192),
        IS_IMAGE(16384),
        IS_LIVE_REGION(32768),
        HAS_TOGGLED_STATE(65536),
        IS_TOGGLED(131072),
        HAS_IMPLICIT_SCROLLING(262144),
        IS_READ_ONLY(1048576),
        IS_FOCUSABLE(2097152),
        IS_LINK(4194304),
        IS_SLIDER(8388608),
        IS_KEYBOARD_KEY(16777216);
        
        final int value;

        Flag(int i) {
            this.value = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static class LocaleStringAttribute extends StringAttribute {
        String locale;

        private LocaleStringAttribute() {
            super();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public interface OnAccessibilityChangeListener {
        void onAccessibilityChanged(boolean z, boolean z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static class SemanticsNode {
        final AccessibilityBridge accessibilityBridge;
        private int actions;
        private float bottom;
        private int currentValueLength;
        private List<CustomAccessibilityAction> customAccessibilityActions;
        private String decreasedValue;
        private List<StringAttribute> decreasedValueAttributes;
        private int flags;
        private Rect globalRect;
        private float[] globalTransform;
        private String hint;
        private List<StringAttribute> hintAttributes;
        private String increasedValue;
        private List<StringAttribute> increasedValueAttributes;
        private float[] inverseTransform;
        private String label;
        private List<StringAttribute> labelAttributes;
        private float left;
        private int maxValueLength;
        private CustomAccessibilityAction onLongPressOverride;
        private CustomAccessibilityAction onTapOverride;
        private SemanticsNode parent;
        private int platformViewId;
        private int previousActions;
        private int previousFlags;
        private String previousLabel;
        private float previousScrollExtentMax;
        private float previousScrollExtentMin;
        private float previousScrollPosition;
        private int previousTextSelectionBase;
        private int previousTextSelectionExtent;
        private String previousValue;
        private float right;
        private int scrollChildren;
        private float scrollExtentMax;
        private float scrollExtentMin;
        private int scrollIndex;
        private float scrollPosition;
        private TextDirection textDirection;
        private int textSelectionBase;
        private int textSelectionExtent;
        private float top;
        private float[] transform;
        private String value;
        private List<StringAttribute> valueAttributes;
        private int id = -1;
        private int previousNodeId = -1;
        private boolean hadPreviousConfig = false;
        private List<SemanticsNode> childrenInTraversalOrder = new ArrayList();
        private List<SemanticsNode> childrenInHitTestOrder = new ArrayList();
        private boolean inverseTransformDirty = true;
        private boolean globalGeometryDirty = true;

        SemanticsNode(@NonNull AccessibilityBridge accessibilityBridge) {
            this.accessibilityBridge = accessibilityBridge;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void collectRoutes(List<SemanticsNode> list) {
            if (hasFlag(Flag.SCOPES_ROUTE)) {
                list.add(this);
            }
            for (SemanticsNode semanticsNode : this.childrenInTraversalOrder) {
                semanticsNode.collectRoutes(list);
            }
        }

        @RequiresApi(21)
        @TargetApi(21)
        private SpannableString createSpannableString(String str, List<StringAttribute> list) {
            if (str == null) {
                return null;
            }
            SpannableString spannableString = new SpannableString(str);
            if (list != null) {
                for (StringAttribute stringAttribute : list) {
                    int i = AnonymousClass5.$SwitchMap$io$flutter$view$AccessibilityBridge$StringAttributeType[stringAttribute.type.ordinal()];
                    if (i == 1) {
                        spannableString.setSpan(new TtsSpan.Builder("android.type.verbatim").build(), stringAttribute.start, stringAttribute.end, 0);
                    } else if (i == 2) {
                        spannableString.setSpan(new LocaleSpan(Locale.forLanguageTag(((LocaleStringAttribute) stringAttribute).locale)), stringAttribute.start, stringAttribute.end, 0);
                    }
                }
            }
            return spannableString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean didChangeLabel() {
            String str;
            String str2 = this.label;
            if (str2 == null && this.previousLabel == null) {
                return false;
            }
            return str2 == null || (str = this.previousLabel) == null || !str2.equals(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean didScroll() {
            return (Float.isNaN(this.scrollPosition) || Float.isNaN(this.previousScrollPosition) || this.previousScrollPosition == this.scrollPosition) ? false : true;
        }

        private void ensureInverseTransform() {
            if (this.inverseTransformDirty) {
                this.inverseTransformDirty = false;
                if (this.inverseTransform == null) {
                    this.inverseTransform = new float[16];
                }
                if (Matrix.invertM(this.inverseTransform, 0, this.transform, 0)) {
                    return;
                }
                Arrays.fill(this.inverseTransform, 0.0f);
            }
        }

        private SemanticsNode getAncestor(Predicate<SemanticsNode> predicate) {
            for (SemanticsNode semanticsNode = this.parent; semanticsNode != null; semanticsNode = semanticsNode.parent) {
                if (predicate.test(semanticsNode)) {
                    return semanticsNode;
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Rect getGlobalRect() {
            return this.globalRect;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String getRouteName() {
            String str;
            if (hasFlag(Flag.NAMES_ROUTE) && (str = this.label) != null && !str.isEmpty()) {
                return this.label;
            }
            for (SemanticsNode semanticsNode : this.childrenInTraversalOrder) {
                String routeName = semanticsNode.getRouteName();
                if (routeName != null && !routeName.isEmpty()) {
                    return routeName;
                }
            }
            return null;
        }

        private List<StringAttribute> getStringAttributesFromBuffer(@NonNull ByteBuffer byteBuffer, @NonNull ByteBuffer[] byteBufferArr) {
            int i = byteBuffer.getInt();
            if (i == -1) {
                return null;
            }
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 < i; i2++) {
                int i3 = byteBuffer.getInt();
                int i4 = byteBuffer.getInt();
                StringAttributeType stringAttributeType = StringAttributeType.values()[byteBuffer.getInt()];
                int i5 = AnonymousClass5.$SwitchMap$io$flutter$view$AccessibilityBridge$StringAttributeType[stringAttributeType.ordinal()];
                if (i5 == 1) {
                    byteBuffer.getInt();
                    SpellOutStringAttribute spellOutStringAttribute = new SpellOutStringAttribute();
                    spellOutStringAttribute.start = i3;
                    spellOutStringAttribute.end = i4;
                    spellOutStringAttribute.type = stringAttributeType;
                    arrayList.add(spellOutStringAttribute);
                } else if (i5 == 2) {
                    ByteBuffer byteBuffer2 = byteBufferArr[byteBuffer.getInt()];
                    LocaleStringAttribute localeStringAttribute = new LocaleStringAttribute();
                    localeStringAttribute.start = i3;
                    localeStringAttribute.end = i4;
                    localeStringAttribute.type = stringAttributeType;
                    localeStringAttribute.locale = Charset.forName("UTF-8").decode(byteBuffer2).toString();
                    arrayList.add(localeStringAttribute);
                }
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public CharSequence getValueLabelHint() {
            CharSequence[] charSequenceArr;
            CharSequence charSequence = null;
            for (CharSequence charSequence2 : Build.VERSION.SDK_INT < 21 ? new CharSequence[]{this.value, this.label, this.hint} : new CharSequence[]{createSpannableString(this.value, this.valueAttributes), createSpannableString(this.label, this.labelAttributes), createSpannableString(this.hint, this.hintAttributes)}) {
                if (charSequence2 != null && charSequence2.length() > 0) {
                    charSequence = (charSequence == null || charSequence.length() == 0) ? charSequence2 : TextUtils.concat(charSequence, AVFSCacheConstants.COMMA_SEP, charSequence2);
                }
            }
            return charSequence;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean hadAction(@NonNull Action action) {
            return (action.value & this.previousActions) != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean hadFlag(@NonNull Flag flag) {
            return (flag.value & this.previousFlags) != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean hasAction(@NonNull Action action) {
            return (action.value & this.actions) != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean hasFlag(@NonNull Flag flag) {
            return (flag.value & this.flags) != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public SemanticsNode hitTest(float[] fArr) {
            float f = fArr[3];
            float f2 = fArr[0] / f;
            float f3 = fArr[1] / f;
            if (f2 < this.left || f2 >= this.right || f3 < this.top || f3 >= this.bottom) {
                return null;
            }
            float[] fArr2 = new float[4];
            for (SemanticsNode semanticsNode : this.childrenInHitTestOrder) {
                if (!semanticsNode.hasFlag(Flag.IS_HIDDEN)) {
                    semanticsNode.ensureInverseTransform();
                    Matrix.multiplyMV(fArr2, 0, semanticsNode.inverseTransform, 0, fArr, 0);
                    SemanticsNode hitTest = semanticsNode.hitTest(fArr2);
                    if (hitTest != null) {
                        return hitTest;
                    }
                }
            }
            if (isFocusable()) {
                return this;
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isFocusable() {
            String str;
            String str2;
            String str3;
            if (hasFlag(Flag.SCOPES_ROUTE)) {
                return false;
            }
            if (hasFlag(Flag.IS_FOCUSABLE)) {
                return true;
            }
            return (((~(((Action.SCROLL_RIGHT.value | Action.SCROLL_LEFT.value) | Action.SCROLL_UP.value) | Action.SCROLL_DOWN.value)) & this.actions) == 0 && this.flags == 0 && ((str = this.label) == null || str.isEmpty()) && (((str2 = this.value) == null || str2.isEmpty()) && ((str3 = this.hint) == null || str3.isEmpty()))) ? false : true;
        }

        private void log(@NonNull String str, boolean z) {
        }

        private float max(float f, float f2, float f3, float f4) {
            return Math.max(f, Math.max(f2, Math.max(f3, f4)));
        }

        private float min(float f, float f2, float f3, float f4) {
            return Math.min(f, Math.min(f2, Math.min(f3, f4)));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean nullableHasAncestor(SemanticsNode semanticsNode, Predicate<SemanticsNode> predicate) {
            return (semanticsNode == null || semanticsNode.getAncestor(predicate) == null) ? false : true;
        }

        private void transformPoint(float[] fArr, float[] fArr2, float[] fArr3) {
            Matrix.multiplyMV(fArr, 0, fArr2, 0, fArr3, 0);
            float f = fArr[3];
            fArr[0] = fArr[0] / f;
            fArr[1] = fArr[1] / f;
            fArr[2] = fArr[2] / f;
            fArr[3] = 0.0f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void updateRecursively(float[] fArr, Set<SemanticsNode> set, boolean z) {
            set.add(this);
            if (this.globalGeometryDirty) {
                z = true;
            }
            if (z) {
                if (this.globalTransform == null) {
                    this.globalTransform = new float[16];
                }
                if (fArr == null) {
                    Log.e(AccessibilityBridge.TAG, "Expected ancestorTransform to not be null.");
                } else if (fArr.length != 16) {
                    Log.e(AccessibilityBridge.TAG, "Expected ancestorTransform to be 16.");
                }
                float[] fArr2 = this.transform;
                if (fArr2 == null) {
                    Log.e(AccessibilityBridge.TAG, "Expected transform to not be null.");
                } else if (fArr2.length != 16) {
                    Log.e(AccessibilityBridge.TAG, "Expected transform to be 16.");
                }
                try {
                    Matrix.multiplyMM(this.globalTransform, 0, fArr, 0, this.transform, 0);
                } catch (Throwable unused) {
                }
                float[] fArr3 = {this.left, this.top, 0.0f, 1.0f};
                float[] fArr4 = new float[4];
                float[] fArr5 = new float[4];
                float[] fArr6 = new float[4];
                float[] fArr7 = new float[4];
                transformPoint(fArr4, this.globalTransform, fArr3);
                fArr3[0] = this.right;
                fArr3[1] = this.top;
                transformPoint(fArr5, this.globalTransform, fArr3);
                fArr3[0] = this.right;
                fArr3[1] = this.bottom;
                transformPoint(fArr6, this.globalTransform, fArr3);
                fArr3[0] = this.left;
                fArr3[1] = this.bottom;
                transformPoint(fArr7, this.globalTransform, fArr3);
                if (this.globalRect == null) {
                    this.globalRect = new Rect();
                }
                this.globalRect.set(Math.round(min(fArr4[0], fArr5[0], fArr6[0], fArr7[0])), Math.round(min(fArr4[1], fArr5[1], fArr6[1], fArr7[1])), Math.round(max(fArr4[0], fArr5[0], fArr6[0], fArr7[0])), Math.round(max(fArr4[1], fArr5[1], fArr6[1], fArr7[1])));
                this.globalGeometryDirty = false;
            }
            int i = -1;
            for (SemanticsNode semanticsNode : this.childrenInTraversalOrder) {
                semanticsNode.previousNodeId = i;
                i = semanticsNode.id;
                semanticsNode.updateRecursively(this.globalTransform, set, z);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void updateWith(@NonNull ByteBuffer byteBuffer, @NonNull String[] strArr, @NonNull ByteBuffer[] byteBufferArr) {
            this.hadPreviousConfig = true;
            this.previousValue = this.value;
            this.previousLabel = this.label;
            this.previousFlags = this.flags;
            this.previousActions = this.actions;
            this.previousTextSelectionBase = this.textSelectionBase;
            this.previousTextSelectionExtent = this.textSelectionExtent;
            this.previousScrollPosition = this.scrollPosition;
            this.previousScrollExtentMax = this.scrollExtentMax;
            this.previousScrollExtentMin = this.scrollExtentMin;
            this.flags = byteBuffer.getInt();
            this.actions = byteBuffer.getInt();
            this.maxValueLength = byteBuffer.getInt();
            this.currentValueLength = byteBuffer.getInt();
            this.textSelectionBase = byteBuffer.getInt();
            this.textSelectionExtent = byteBuffer.getInt();
            this.platformViewId = byteBuffer.getInt();
            this.scrollChildren = byteBuffer.getInt();
            this.scrollIndex = byteBuffer.getInt();
            this.scrollPosition = byteBuffer.getFloat();
            this.scrollExtentMax = byteBuffer.getFloat();
            this.scrollExtentMin = byteBuffer.getFloat();
            int i = byteBuffer.getInt();
            this.label = i == -1 ? null : strArr[i];
            this.labelAttributes = getStringAttributesFromBuffer(byteBuffer, byteBufferArr);
            int i2 = byteBuffer.getInt();
            this.value = i2 == -1 ? null : strArr[i2];
            this.valueAttributes = getStringAttributesFromBuffer(byteBuffer, byteBufferArr);
            int i3 = byteBuffer.getInt();
            this.increasedValue = i3 == -1 ? null : strArr[i3];
            this.increasedValueAttributes = getStringAttributesFromBuffer(byteBuffer, byteBufferArr);
            int i4 = byteBuffer.getInt();
            this.decreasedValue = i4 == -1 ? null : strArr[i4];
            this.decreasedValueAttributes = getStringAttributesFromBuffer(byteBuffer, byteBufferArr);
            int i5 = byteBuffer.getInt();
            this.hint = i5 == -1 ? null : strArr[i5];
            this.hintAttributes = getStringAttributesFromBuffer(byteBuffer, byteBufferArr);
            this.textDirection = TextDirection.fromInt(byteBuffer.getInt());
            this.left = byteBuffer.getFloat();
            this.top = byteBuffer.getFloat();
            this.right = byteBuffer.getFloat();
            this.bottom = byteBuffer.getFloat();
            if (this.transform == null) {
                this.transform = new float[16];
            }
            for (int i6 = 0; i6 < 16; i6++) {
                this.transform[i6] = byteBuffer.getFloat();
            }
            this.inverseTransformDirty = true;
            this.globalGeometryDirty = true;
            int i7 = byteBuffer.getInt();
            this.childrenInTraversalOrder.clear();
            this.childrenInHitTestOrder.clear();
            for (int i8 = 0; i8 < i7; i8++) {
                SemanticsNode orCreateSemanticsNode = this.accessibilityBridge.getOrCreateSemanticsNode(byteBuffer.getInt());
                orCreateSemanticsNode.parent = this;
                this.childrenInTraversalOrder.add(orCreateSemanticsNode);
            }
            for (int i9 = 0; i9 < i7; i9++) {
                SemanticsNode orCreateSemanticsNode2 = this.accessibilityBridge.getOrCreateSemanticsNode(byteBuffer.getInt());
                orCreateSemanticsNode2.parent = this;
                this.childrenInHitTestOrder.add(orCreateSemanticsNode2);
            }
            int i10 = byteBuffer.getInt();
            if (i10 == 0) {
                this.customAccessibilityActions = null;
                return;
            }
            List<CustomAccessibilityAction> list = this.customAccessibilityActions;
            if (list == null) {
                this.customAccessibilityActions = new ArrayList(i10);
            } else {
                list.clear();
            }
            for (int i11 = 0; i11 < i10; i11++) {
                CustomAccessibilityAction orCreateAccessibilityAction = this.accessibilityBridge.getOrCreateAccessibilityAction(byteBuffer.getInt());
                if (orCreateAccessibilityAction.overrideId != Action.TAP.value) {
                    if (orCreateAccessibilityAction.overrideId == Action.LONG_PRESS.value) {
                        this.onLongPressOverride = orCreateAccessibilityAction;
                    } else {
                        this.customAccessibilityActions.add(orCreateAccessibilityAction);
                    }
                } else {
                    this.onTapOverride = orCreateAccessibilityAction;
                }
                this.customAccessibilityActions.add(orCreateAccessibilityAction);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static class SpellOutStringAttribute extends StringAttribute {
        private SpellOutStringAttribute() {
            super();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static class StringAttribute {
        int end;
        int start;
        StringAttributeType type;

        private StringAttribute() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public enum StringAttributeType {
        SPELLOUT,
        LOCALE
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public enum TextDirection {
        UNKNOWN,
        LTR,
        RTL;

        public static TextDirection fromInt(int i) {
            if (i != 1) {
                if (i != 2) {
                    return UNKNOWN;
                }
                return LTR;
            }
            return RTL;
        }
    }

    public AccessibilityBridge(@NonNull View view, @NonNull AccessibilityChannel accessibilityChannel, @NonNull AccessibilityManager accessibilityManager, @NonNull ContentResolver contentResolver, PlatformViewsAccessibilityDelegate platformViewsAccessibilityDelegate) {
        this(view, accessibilityChannel, accessibilityManager, contentResolver, new AccessibilityViewEmbedder(view, 65536), platformViewsAccessibilityDelegate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean computeAXEnabledFlag() {
        List<AccessibilityServiceInfo> list;
        String[] split;
        if (!sHasDetectLocalFlag) {
            sForceEnableByLocal = SystemProperties.getBoolean("debug.uc.ax.enable", false);
            sHasDetectLocalFlag = true;
        }
        if (sForceEnableByLocal) {
            Log.e(TAG, "force enable AX support by local");
            return true;
        }
        try {
            list = this.accessibilityManager.getEnabledAccessibilityServiceList(-1);
        } catch (Throwable th) {
            Log.e(TAG, "getEnabledAccessibilityServiceList error: " + th);
            list = null;
        }
        if (list != null || list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("com.dianming");
            arrayList.add("com.bjbyhd");
            arrayList.add("com.nirenr.talkman/.TalkManAccessibilityService");
            String nativeGetAXServiceWhiteList = FlutterJNI.nativeGetAXServiceWhiteList();
            if (nativeGetAXServiceWhiteList != null && nativeGetAXServiceWhiteList.length() > 0) {
                for (String str : nativeGetAXServiceWhiteList.split(SymbolExpUtil.SYMBOL_VERTICALBAR)) {
                    if (str != null && str.length() > 0) {
                        arrayList.add(str);
                    }
                }
            }
            HashSet hashSet = new HashSet();
            for (AccessibilityServiceInfo accessibilityServiceInfo : list) {
                String id = accessibilityServiceInfo.getId();
                if (id != null && id.length() > 0 && !hashSet.contains(id)) {
                    Log.w(TAG, "system accessibility service is enabled: " + id);
                    hashSet.add(id);
                    if (id.endsWith("TalkBackService")) {
                        Log.w(TAG, "enable AX support because of: " + id);
                        return true;
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (id.startsWith((String) it.next())) {
                            Log.w(TAG, "enable AX support because of: " + id);
                            return true;
                        }
                    }
                    continue;
                }
            }
            Log.w(TAG, "AX support is disabled because of AX services not in white list");
            return false;
        }
        return false;
    }

    private AccessibilityEvent createTextChangedEvent(int i, String str, String str2) {
        AccessibilityEvent obtainAccessibilityEvent = obtainAccessibilityEvent(i, 16);
        obtainAccessibilityEvent.setBeforeText(str);
        obtainAccessibilityEvent.getText().add(str2);
        int i2 = 0;
        while (i2 < str.length() && i2 < str2.length() && str.charAt(i2) == str2.charAt(i2)) {
            i2++;
        }
        if (i2 < str.length() || i2 < str2.length()) {
            obtainAccessibilityEvent.setFromIndex(i2);
            int length = str.length() - 1;
            int length2 = str2.length() - 1;
            while (length >= i2 && length2 >= i2 && str.charAt(length) == str2.charAt(length2)) {
                length--;
                length2--;
            }
            obtainAccessibilityEvent.setRemovedCount((length - i2) + 1);
            obtainAccessibilityEvent.setAddedCount((length2 - i2) + 1);
            return obtainAccessibilityEvent;
        }
        return null;
    }

    @RequiresApi(28)
    @TargetApi(28)
    private boolean doesLayoutInDisplayCutoutModeRequireLeftInset() {
        Activity activity = ViewUtils.getActivity(this.rootAccessibilityView.getContext());
        if (activity == null || activity.getWindow() == null) {
            return false;
        }
        int i = activity.getWindow().getAttributes().layoutInDisplayCutoutMode;
        return i == 2 || i == 0;
    }

    private Rect getBoundsInScreen(Rect rect) {
        Rect rect2 = new Rect(rect);
        int[] iArr = new int[2];
        this.rootAccessibilityView.getLocationOnScreen(iArr);
        rect2.offset(iArr[0], iArr[1]);
        return rect2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CustomAccessibilityAction getOrCreateAccessibilityAction(int i) {
        CustomAccessibilityAction customAccessibilityAction = this.customAccessibilityActions.get(Integer.valueOf(i));
        if (customAccessibilityAction == null) {
            CustomAccessibilityAction customAccessibilityAction2 = new CustomAccessibilityAction();
            customAccessibilityAction2.id = i;
            customAccessibilityAction2.resourceId = FIRST_RESOURCE_ID + i;
            this.customAccessibilityActions.put(Integer.valueOf(i), customAccessibilityAction2);
            return customAccessibilityAction2;
        }
        return customAccessibilityAction;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SemanticsNode getOrCreateSemanticsNode(int i) {
        SemanticsNode semanticsNode = this.flutterSemanticsTree.get(Integer.valueOf(i));
        if (semanticsNode == null) {
            SemanticsNode semanticsNode2 = new SemanticsNode(this);
            semanticsNode2.id = i;
            this.flutterSemanticsTree.put(Integer.valueOf(i), semanticsNode2);
            return semanticsNode2;
        }
        return semanticsNode;
    }

    private SemanticsNode getRootSemanticsNode() {
        return this.flutterSemanticsTree.get(0);
    }

    private void handleTouchExploration(float f, float f2) {
        SemanticsNode hitTest;
        if (this.flutterSemanticsTree.isEmpty() || (hitTest = getRootSemanticsNode().hitTest(new float[]{f, f2, 0.0f, 1.0f})) == this.hoveredObject) {
            return;
        }
        if (hitTest != null) {
            sendAccessibilityEvent(hitTest.id, 128);
        }
        SemanticsNode semanticsNode = this.hoveredObject;
        if (semanticsNode != null) {
            sendAccessibilityEvent(semanticsNode.id, 256);
        }
        this.hoveredObject = hitTest;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$shouldSetCollectionInfo$0(SemanticsNode semanticsNode, SemanticsNode semanticsNode2) {
        return semanticsNode2 == semanticsNode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$shouldSetCollectionInfo$1(SemanticsNode semanticsNode) {
        return semanticsNode.hasFlag(Flag.HAS_IMPLICIT_SCROLLING);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AccessibilityEvent obtainAccessibilityEvent(int i, int i2) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i2);
        obtain.setPackageName(this.rootAccessibilityView.getContext().getPackageName());
        obtain.setSource(this.rootAccessibilityView, i);
        return obtain;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onTouchExplorationExit() {
        SemanticsNode semanticsNode = this.hoveredObject;
        if (semanticsNode != null) {
            sendAccessibilityEvent(semanticsNode.id, 256);
            this.hoveredObject = null;
        }
    }

    private void onWindowNameChange(@NonNull SemanticsNode semanticsNode) {
        String routeName = semanticsNode.getRouteName();
        if (routeName == null) {
            routeName = " ";
        }
        if (Build.VERSION.SDK_INT < 28) {
            AccessibilityEvent obtainAccessibilityEvent = obtainAccessibilityEvent(semanticsNode.id, 32);
            obtainAccessibilityEvent.getText().add(routeName);
            sendAccessibilityEvent(obtainAccessibilityEvent);
            return;
        }
        setAccessibilityPaneTitle(routeName);
    }

    @RequiresApi(18)
    @TargetApi(18)
    private boolean performCursorMoveAction(@NonNull SemanticsNode semanticsNode, int i, @NonNull Bundle bundle, boolean z) {
        int i2 = bundle.getInt(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT);
        boolean z2 = bundle.getBoolean(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN);
        predictCursorMovement(semanticsNode, i2, z, z2);
        if (i2 == 1) {
            if (z) {
                Action action = Action.MOVE_CURSOR_FORWARD_BY_CHARACTER;
                if (semanticsNode.hasAction(action)) {
                    this.accessibilityChannel.dispatchSemanticsAction(i, action, Boolean.valueOf(z2));
                    return true;
                }
            }
            if (z) {
                return false;
            }
            Action action2 = Action.MOVE_CURSOR_BACKWARD_BY_CHARACTER;
            if (semanticsNode.hasAction(action2)) {
                this.accessibilityChannel.dispatchSemanticsAction(i, action2, Boolean.valueOf(z2));
                return true;
            }
            return false;
        } else if (i2 != 2) {
            return i2 == 4 || i2 == 8 || i2 == 16;
        } else {
            if (z) {
                Action action3 = Action.MOVE_CURSOR_FORWARD_BY_WORD;
                if (semanticsNode.hasAction(action3)) {
                    this.accessibilityChannel.dispatchSemanticsAction(i, action3, Boolean.valueOf(z2));
                    return true;
                }
            }
            if (z) {
                return false;
            }
            Action action4 = Action.MOVE_CURSOR_BACKWARD_BY_WORD;
            if (semanticsNode.hasAction(action4)) {
                this.accessibilityChannel.dispatchSemanticsAction(i, action4, Boolean.valueOf(z2));
                return true;
            }
            return false;
        }
    }

    @RequiresApi(21)
    @TargetApi(21)
    private boolean performSetText(SemanticsNode semanticsNode, int i, @NonNull Bundle bundle) {
        String string = (bundle == null || !bundle.containsKey(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE)) ? "" : bundle.getString(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE);
        this.accessibilityChannel.dispatchSemanticsAction(i, Action.SET_TEXT, string);
        semanticsNode.value = string;
        return true;
    }

    private void predictCursorMovement(@NonNull SemanticsNode semanticsNode, int i, boolean z, boolean z2) {
        if (semanticsNode.textSelectionExtent < 0 || semanticsNode.textSelectionBase < 0) {
            return;
        }
        if (i != 1) {
            if (i != 2) {
                if (i != 4) {
                    if (i == 8 || i == 16) {
                        if (z) {
                            semanticsNode.textSelectionExtent = semanticsNode.value.length();
                        } else {
                            semanticsNode.textSelectionExtent = 0;
                        }
                    }
                } else if (!z || semanticsNode.textSelectionExtent >= semanticsNode.value.length()) {
                    if (!z && semanticsNode.textSelectionExtent > 0) {
                        Matcher matcher = Pattern.compile("(?s:.*)(\\n)").matcher(semanticsNode.value.substring(0, semanticsNode.textSelectionExtent));
                        if (matcher.find()) {
                            semanticsNode.textSelectionExtent = matcher.start(1);
                        } else {
                            semanticsNode.textSelectionExtent = 0;
                        }
                    }
                } else {
                    Matcher matcher2 = Pattern.compile("(?!^)(\\n)").matcher(semanticsNode.value.substring(semanticsNode.textSelectionExtent));
                    if (matcher2.find()) {
                        semanticsNode.textSelectionExtent += matcher2.start(1);
                    } else {
                        semanticsNode.textSelectionExtent = semanticsNode.value.length();
                    }
                }
            } else if (!z || semanticsNode.textSelectionExtent >= semanticsNode.value.length()) {
                if (!z && semanticsNode.textSelectionExtent > 0) {
                    Matcher matcher3 = Pattern.compile("(?s:.*)(\\b)\\p{L}").matcher(semanticsNode.value.substring(0, semanticsNode.textSelectionExtent));
                    if (matcher3.find()) {
                        semanticsNode.textSelectionExtent = matcher3.start(1);
                    }
                }
            } else {
                Matcher matcher4 = Pattern.compile("\\p{L}(\\b)").matcher(semanticsNode.value.substring(semanticsNode.textSelectionExtent));
                matcher4.find();
                if (matcher4.find()) {
                    semanticsNode.textSelectionExtent += matcher4.start(1);
                } else {
                    semanticsNode.textSelectionExtent = semanticsNode.value.length();
                }
            }
        } else if (!z || semanticsNode.textSelectionExtent >= semanticsNode.value.length()) {
            if (!z && semanticsNode.textSelectionExtent > 0) {
                semanticsNode.textSelectionExtent--;
            }
        } else {
            semanticsNode.textSelectionExtent++;
        }
        if (z2) {
            return;
        }
        semanticsNode.textSelectionBase = semanticsNode.textSelectionExtent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendAccessibilityEvent(int i, int i2) {
        if (this.accessibilityManager.isEnabled()) {
            sendAccessibilityEvent(obtainAccessibilityEvent(i, i2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendLatestAccessibilityFlagsToFlutter() {
        this.accessibilityChannel.setAccessibilityFeatures(this.accessibilityFeatureFlags);
    }

    private void sendWindowContentChangeEvent(int i) {
        AccessibilityEvent obtainAccessibilityEvent = obtainAccessibilityEvent(i, 2048);
        if (Build.VERSION.SDK_INT >= 19) {
            obtainAccessibilityEvent.setContentChangeTypes(1);
        }
        sendAccessibilityEvent(obtainAccessibilityEvent);
    }

    @RequiresApi(28)
    @TargetApi(28)
    private void setAccessibilityPaneTitle(String str) {
        this.rootAccessibilityView.setAccessibilityPaneTitle(str);
    }

    private boolean shouldSetCollectionInfo(final SemanticsNode semanticsNode) {
        return semanticsNode.scrollChildren > 0 && (SemanticsNode.nullableHasAncestor(this.accessibilityFocusedSemanticsNode, new Predicate() { // from class: io.flutter.view.a
            @Override // io.flutter.util.Predicate
            public final boolean test(Object obj) {
                boolean lambda$shouldSetCollectionInfo$0;
                lambda$shouldSetCollectionInfo$0 = AccessibilityBridge.lambda$shouldSetCollectionInfo$0(AccessibilityBridge.SemanticsNode.this, (AccessibilityBridge.SemanticsNode) obj);
                return lambda$shouldSetCollectionInfo$0;
            }
        }) || !SemanticsNode.nullableHasAncestor(this.accessibilityFocusedSemanticsNode, new Predicate() { // from class: io.flutter.view.b
            @Override // io.flutter.util.Predicate
            public final boolean test(Object obj) {
                boolean lambda$shouldSetCollectionInfo$1;
                lambda$shouldSetCollectionInfo$1 = AccessibilityBridge.lambda$shouldSetCollectionInfo$1((AccessibilityBridge.SemanticsNode) obj);
                return lambda$shouldSetCollectionInfo$1;
            }
        }));
    }

    @RequiresApi(19)
    @TargetApi(19)
    private void willRemoveSemanticsNode(SemanticsNode semanticsNode) {
        View platformViewById;
        Integer num;
        semanticsNode.parent = null;
        if (semanticsNode.platformViewId != -1 && (num = this.embeddedAccessibilityFocusedNodeId) != null && this.accessibilityViewEmbedder.platformViewOfNode(num.intValue()) == this.platformViewsAccessibilityDelegate.getPlatformViewById(semanticsNode.platformViewId)) {
            sendAccessibilityEvent(this.embeddedAccessibilityFocusedNodeId.intValue(), 65536);
            this.embeddedAccessibilityFocusedNodeId = null;
        }
        if (semanticsNode.platformViewId != -1 && (platformViewById = this.platformViewsAccessibilityDelegate.getPlatformViewById(semanticsNode.platformViewId)) != null) {
            platformViewById.setImportantForAccessibility(4);
        }
        SemanticsNode semanticsNode2 = this.accessibilityFocusedSemanticsNode;
        if (semanticsNode2 == semanticsNode) {
            sendAccessibilityEvent(semanticsNode2.id, 65536);
            this.accessibilityFocusedSemanticsNode = null;
        }
        if (this.inputFocusedSemanticsNode == semanticsNode) {
            this.inputFocusedSemanticsNode = null;
        }
        if (this.hoveredObject == semanticsNode) {
            this.hoveredObject = null;
        }
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    @SuppressLint({"NewApi"})
    public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
        CharSequence valueLabelHint;
        int i2;
        SemanticsNode semanticsNode;
        if (i >= 65536) {
            return this.accessibilityViewEmbedder.createAccessibilityNodeInfo(i);
        }
        boolean z = false;
        if (i == -1) {
            AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain(this.rootAccessibilityView);
            this.rootAccessibilityView.onInitializeAccessibilityNodeInfo(obtain);
            if (this.flutterSemanticsTree.containsKey(0)) {
                obtain.addChild(this.rootAccessibilityView, 0);
            }
            return obtain;
        }
        SemanticsNode semanticsNode2 = this.flutterSemanticsTree.get(Integer.valueOf(i));
        if (semanticsNode2 == null) {
            return null;
        }
        AccessibilityNodeInfo obtainAccessibilityNodeInfo = obtainAccessibilityNodeInfo(this.rootAccessibilityView, i);
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 18) {
            obtainAccessibilityNodeInfo.setViewIdResourceName("");
        }
        obtainAccessibilityNodeInfo.setPackageName(this.rootAccessibilityView.getContext().getPackageName());
        obtainAccessibilityNodeInfo.setClassName("android.view.View");
        obtainAccessibilityNodeInfo.setSource(this.rootAccessibilityView, i);
        obtainAccessibilityNodeInfo.setFocusable(semanticsNode2.isFocusable());
        SemanticsNode semanticsNode3 = this.inputFocusedSemanticsNode;
        if (semanticsNode3 != null) {
            obtainAccessibilityNodeInfo.setFocused(semanticsNode3.id == i);
        }
        SemanticsNode semanticsNode4 = this.accessibilityFocusedSemanticsNode;
        if (semanticsNode4 != null) {
            obtainAccessibilityNodeInfo.setAccessibilityFocused(semanticsNode4.id == i);
        }
        Flag flag = Flag.IS_TEXT_FIELD;
        if (semanticsNode2.hasFlag(flag)) {
            obtainAccessibilityNodeInfo.setPassword(semanticsNode2.hasFlag(Flag.IS_OBSCURED));
            Flag flag2 = Flag.IS_READ_ONLY;
            if (!semanticsNode2.hasFlag(flag2)) {
                obtainAccessibilityNodeInfo.setClassName("android.widget.EditText");
            }
            if (i3 >= 18) {
                obtainAccessibilityNodeInfo.setEditable(!semanticsNode2.hasFlag(flag2));
                if (semanticsNode2.textSelectionBase != -1 && semanticsNode2.textSelectionExtent != -1) {
                    obtainAccessibilityNodeInfo.setTextSelection(semanticsNode2.textSelectionBase, semanticsNode2.textSelectionExtent);
                }
                if (i3 > 18 && (semanticsNode = this.accessibilityFocusedSemanticsNode) != null && semanticsNode.id == i) {
                    obtainAccessibilityNodeInfo.setLiveRegion(1);
                }
            }
            if (semanticsNode2.hasAction(Action.MOVE_CURSOR_FORWARD_BY_CHARACTER)) {
                obtainAccessibilityNodeInfo.addAction(256);
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (semanticsNode2.hasAction(Action.MOVE_CURSOR_BACKWARD_BY_CHARACTER)) {
                obtainAccessibilityNodeInfo.addAction(512);
                i2 |= 1;
            }
            if (semanticsNode2.hasAction(Action.MOVE_CURSOR_FORWARD_BY_WORD)) {
                obtainAccessibilityNodeInfo.addAction(256);
                i2 |= 2;
            }
            if (semanticsNode2.hasAction(Action.MOVE_CURSOR_BACKWARD_BY_WORD)) {
                obtainAccessibilityNodeInfo.addAction(512);
                i2 |= 2;
            }
            obtainAccessibilityNodeInfo.setMovementGranularities(i2);
            if (i3 >= 21 && semanticsNode2.maxValueLength >= 0) {
                int length = semanticsNode2.value == null ? 0 : semanticsNode2.value.length();
                int unused = semanticsNode2.currentValueLength;
                int unused2 = semanticsNode2.maxValueLength;
                obtainAccessibilityNodeInfo.setMaxTextLength((length - semanticsNode2.currentValueLength) + semanticsNode2.maxValueLength);
            }
        }
        if (i3 > 18) {
            if (semanticsNode2.hasAction(Action.SET_SELECTION)) {
                obtainAccessibilityNodeInfo.addAction(131072);
            }
            if (semanticsNode2.hasAction(Action.COPY)) {
                obtainAccessibilityNodeInfo.addAction(16384);
            }
            if (semanticsNode2.hasAction(Action.CUT)) {
                obtainAccessibilityNodeInfo.addAction(65536);
            }
            if (semanticsNode2.hasAction(Action.PASTE)) {
                obtainAccessibilityNodeInfo.addAction(32768);
            }
        }
        if (i3 >= 21 && semanticsNode2.hasAction(Action.SET_TEXT)) {
            obtainAccessibilityNodeInfo.addAction(2097152);
        }
        if (semanticsNode2.hasFlag(Flag.IS_BUTTON) || semanticsNode2.hasFlag(Flag.IS_LINK)) {
            obtainAccessibilityNodeInfo.setClassName("android.widget.Button");
        }
        if (semanticsNode2.hasFlag(Flag.IS_IMAGE)) {
            obtainAccessibilityNodeInfo.setClassName("android.widget.ImageView");
        }
        if (i3 > 18 && semanticsNode2.hasAction(Action.DISMISS)) {
            obtainAccessibilityNodeInfo.setDismissable(true);
            obtainAccessibilityNodeInfo.addAction(1048576);
        }
        if (semanticsNode2.parent != null) {
            obtainAccessibilityNodeInfo.setParent(this.rootAccessibilityView, semanticsNode2.parent.id);
        } else {
            obtainAccessibilityNodeInfo.setParent(this.rootAccessibilityView);
        }
        if (semanticsNode2.previousNodeId != -1 && i3 >= 22) {
            obtainAccessibilityNodeInfo.setTraversalAfter(this.rootAccessibilityView, semanticsNode2.previousNodeId);
        }
        Rect globalRect = semanticsNode2.getGlobalRect();
        if (semanticsNode2.parent != null) {
            Rect globalRect2 = semanticsNode2.parent.getGlobalRect();
            Rect rect = new Rect(globalRect);
            rect.offset(-globalRect2.left, -globalRect2.top);
            obtainAccessibilityNodeInfo.setBoundsInParent(rect);
        } else {
            obtainAccessibilityNodeInfo.setBoundsInParent(globalRect);
        }
        obtainAccessibilityNodeInfo.setBoundsInScreen(getBoundsInScreen(globalRect));
        obtainAccessibilityNodeInfo.setVisibleToUser(true);
        obtainAccessibilityNodeInfo.setEnabled(!semanticsNode2.hasFlag(Flag.HAS_ENABLED_STATE) || semanticsNode2.hasFlag(Flag.IS_ENABLED));
        if (semanticsNode2.hasAction(Action.TAP)) {
            if (i3 >= 21 && semanticsNode2.onTapOverride != null) {
                obtainAccessibilityNodeInfo.addAction(new AccessibilityNodeInfo.AccessibilityAction(16, semanticsNode2.onTapOverride.hint));
                obtainAccessibilityNodeInfo.setClickable(true);
            } else {
                obtainAccessibilityNodeInfo.addAction(16);
                obtainAccessibilityNodeInfo.setClickable(true);
            }
        }
        if (semanticsNode2.hasAction(Action.LONG_PRESS)) {
            if (i3 >= 21 && semanticsNode2.onLongPressOverride != null) {
                obtainAccessibilityNodeInfo.addAction(new AccessibilityNodeInfo.AccessibilityAction(32, semanticsNode2.onLongPressOverride.hint));
                obtainAccessibilityNodeInfo.setLongClickable(true);
            } else {
                obtainAccessibilityNodeInfo.addAction(32);
                obtainAccessibilityNodeInfo.setLongClickable(true);
            }
        }
        Action action = Action.SCROLL_LEFT;
        if (semanticsNode2.hasAction(action) || semanticsNode2.hasAction(Action.SCROLL_UP) || semanticsNode2.hasAction(Action.SCROLL_RIGHT) || semanticsNode2.hasAction(Action.SCROLL_DOWN)) {
            obtainAccessibilityNodeInfo.setScrollable(true);
            if (semanticsNode2.hasFlag(Flag.HAS_IMPLICIT_SCROLLING)) {
                if (!semanticsNode2.hasAction(action) && !semanticsNode2.hasAction(Action.SCROLL_RIGHT)) {
                    if (i3 > 18 && shouldSetCollectionInfo(semanticsNode2)) {
                        obtainAccessibilityNodeInfo.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(semanticsNode2.scrollChildren, 0, false));
                    } else {
                        obtainAccessibilityNodeInfo.setClassName("android.widget.ScrollView");
                    }
                } else if (i3 > 19 && shouldSetCollectionInfo(semanticsNode2)) {
                    obtainAccessibilityNodeInfo.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(0, semanticsNode2.scrollChildren, false));
                } else {
                    obtainAccessibilityNodeInfo.setClassName("android.widget.HorizontalScrollView");
                }
            }
            if (semanticsNode2.hasAction(action) || semanticsNode2.hasAction(Action.SCROLL_UP)) {
                obtainAccessibilityNodeInfo.addAction(4096);
            }
            if (semanticsNode2.hasAction(Action.SCROLL_RIGHT) || semanticsNode2.hasAction(Action.SCROLL_DOWN)) {
                obtainAccessibilityNodeInfo.addAction(8192);
            }
        }
        Action action2 = Action.INCREASE;
        if (semanticsNode2.hasAction(action2) || semanticsNode2.hasAction(Action.DECREASE)) {
            obtainAccessibilityNodeInfo.setClassName("android.widget.SeekBar");
            if (semanticsNode2.hasAction(action2)) {
                obtainAccessibilityNodeInfo.addAction(4096);
            }
            if (semanticsNode2.hasAction(Action.DECREASE)) {
                obtainAccessibilityNodeInfo.addAction(8192);
            }
        }
        if (semanticsNode2.hasFlag(Flag.IS_LIVE_REGION) && i3 > 18) {
            obtainAccessibilityNodeInfo.setLiveRegion(1);
        }
        if (semanticsNode2.hasFlag(flag)) {
            obtainAccessibilityNodeInfo.setText(semanticsNode2.getValueLabelHint());
        } else if (!semanticsNode2.hasFlag(Flag.SCOPES_ROUTE) && (valueLabelHint = semanticsNode2.getValueLabelHint()) != null) {
            obtainAccessibilityNodeInfo.setContentDescription(valueLabelHint);
        }
        boolean hasFlag = semanticsNode2.hasFlag(Flag.HAS_CHECKED_STATE);
        boolean hasFlag2 = semanticsNode2.hasFlag(Flag.HAS_TOGGLED_STATE);
        obtainAccessibilityNodeInfo.setCheckable((hasFlag || hasFlag2) ? true : true);
        if (hasFlag) {
            obtainAccessibilityNodeInfo.setChecked(semanticsNode2.hasFlag(Flag.IS_CHECKED));
            if (semanticsNode2.hasFlag(Flag.IS_IN_MUTUALLY_EXCLUSIVE_GROUP)) {
                obtainAccessibilityNodeInfo.setClassName("android.widget.RadioButton");
            } else {
                obtainAccessibilityNodeInfo.setClassName("android.widget.CheckBox");
            }
        } else if (hasFlag2) {
            obtainAccessibilityNodeInfo.setChecked(semanticsNode2.hasFlag(Flag.IS_TOGGLED));
            obtainAccessibilityNodeInfo.setClassName("android.widget.Switch");
        }
        obtainAccessibilityNodeInfo.setSelected(semanticsNode2.hasFlag(Flag.IS_SELECTED));
        if (i3 >= 28) {
            obtainAccessibilityNodeInfo.setHeading(semanticsNode2.hasFlag(Flag.IS_HEADER));
        }
        SemanticsNode semanticsNode5 = this.accessibilityFocusedSemanticsNode;
        if (semanticsNode5 != null && semanticsNode5.id == i) {
            obtainAccessibilityNodeInfo.addAction(128);
        } else {
            obtainAccessibilityNodeInfo.addAction(64);
        }
        if (i3 >= 21 && semanticsNode2.customAccessibilityActions != null) {
            for (CustomAccessibilityAction customAccessibilityAction : semanticsNode2.customAccessibilityActions) {
                obtainAccessibilityNodeInfo.addAction(new AccessibilityNodeInfo.AccessibilityAction(customAccessibilityAction.resourceId, customAccessibilityAction.label));
            }
        }
        for (SemanticsNode semanticsNode6 : semanticsNode2.childrenInTraversalOrder) {
            if (!semanticsNode6.hasFlag(Flag.IS_HIDDEN)) {
                if (semanticsNode6.platformViewId == -1) {
                    obtainAccessibilityNodeInfo.addChild(this.rootAccessibilityView, semanticsNode6.id);
                } else {
                    obtainAccessibilityNodeInfo.addChild(this.platformViewsAccessibilityDelegate.getPlatformViewById(semanticsNode6.platformViewId));
                }
            }
        }
        return obtainAccessibilityNodeInfo;
    }

    public boolean externalViewRequestSendAccessibilityEvent(View view, View view2, AccessibilityEvent accessibilityEvent) {
        Integer recordFlutterId;
        if (this.accessibilityViewEmbedder.requestSendAccessibilityEvent(view, view2, accessibilityEvent) && (recordFlutterId = this.accessibilityViewEmbedder.getRecordFlutterId(view, accessibilityEvent)) != null) {
            int eventType = accessibilityEvent.getEventType();
            if (eventType == 8) {
                this.embeddedInputFocusedNodeId = recordFlutterId;
                this.inputFocusedSemanticsNode = null;
                return true;
            } else if (eventType == 128) {
                this.hoveredObject = null;
                return true;
            } else if (eventType == 32768) {
                this.embeddedAccessibilityFocusedNodeId = recordFlutterId;
                this.accessibilityFocusedSemanticsNode = null;
                return true;
            } else if (eventType != 65536) {
                return true;
            } else {
                this.embeddedInputFocusedNodeId = null;
                this.embeddedAccessibilityFocusedNodeId = null;
                return true;
            }
        }
        return false;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public AccessibilityNodeInfo findFocus(int i) {
        if (i == 1) {
            SemanticsNode semanticsNode = this.inputFocusedSemanticsNode;
            if (semanticsNode != null) {
                return createAccessibilityNodeInfo(semanticsNode.id);
            }
            Integer num = this.embeddedInputFocusedNodeId;
            if (num != null) {
                return createAccessibilityNodeInfo(num.intValue());
            }
        } else if (i != 2) {
            return null;
        }
        SemanticsNode semanticsNode2 = this.accessibilityFocusedSemanticsNode;
        if (semanticsNode2 != null) {
            return createAccessibilityNodeInfo(semanticsNode2.id);
        }
        Integer num2 = this.embeddedAccessibilityFocusedNodeId;
        if (num2 != null) {
            return createAccessibilityNodeInfo(num2.intValue());
        }
        return null;
    }

    @VisibleForTesting
    public int getHoveredObjectId() {
        return this.hoveredObject.id;
    }

    public boolean isAccessibilityEnabled() {
        return this.accessibilityManager.isEnabled();
    }

    public boolean isTouchExplorationEnabled() {
        return this.accessibilityManager.isTouchExplorationEnabled();
    }

    @VisibleForTesting
    public AccessibilityNodeInfo obtainAccessibilityNodeInfo(View view, int i) {
        return AccessibilityNodeInfo.obtain(view, i);
    }

    public boolean onAccessibilityHoverEvent(MotionEvent motionEvent) {
        if (this.accessibilityManager.isTouchExplorationEnabled() && !this.flutterSemanticsTree.isEmpty()) {
            SemanticsNode hitTest = getRootSemanticsNode().hitTest(new float[]{motionEvent.getX(), motionEvent.getY(), 0.0f, 1.0f});
            if (hitTest != null && hitTest.platformViewId != -1) {
                return this.accessibilityViewEmbedder.onAccessibilityHoverEvent(hitTest.id, motionEvent);
            }
            if (motionEvent.getAction() != 9 && motionEvent.getAction() != 7) {
                if (motionEvent.getAction() == 10) {
                    onTouchExplorationExit();
                } else {
                    Log.d(StatServices.EVENTCATEGORY, "unexpected accessibility hover event: " + motionEvent);
                    return false;
                }
            } else {
                handleTouchExploration(motionEvent.getX(), motionEvent.getY());
            }
            return true;
        }
        return false;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public boolean performAction(int i, int i2, @Nullable Bundle bundle) {
        if (i >= 65536) {
            boolean performAction = this.accessibilityViewEmbedder.performAction(i, i2, bundle);
            if (performAction && i2 == 128) {
                this.embeddedAccessibilityFocusedNodeId = null;
            }
            return performAction;
        }
        SemanticsNode semanticsNode = this.flutterSemanticsTree.get(Integer.valueOf(i));
        boolean z = false;
        if (semanticsNode == null) {
            return false;
        }
        switch (i2) {
            case 16:
                this.accessibilityChannel.dispatchSemanticsAction(i, Action.TAP);
                return true;
            case 32:
                this.accessibilityChannel.dispatchSemanticsAction(i, Action.LONG_PRESS);
                return true;
            case 64:
                this.accessibilityChannel.dispatchSemanticsAction(i, Action.DID_GAIN_ACCESSIBILITY_FOCUS);
                sendAccessibilityEvent(i, 32768);
                if (this.accessibilityFocusedSemanticsNode == null) {
                    this.rootAccessibilityView.invalidate();
                }
                this.accessibilityFocusedSemanticsNode = semanticsNode;
                if (semanticsNode.hasAction(Action.INCREASE) || semanticsNode.hasAction(Action.DECREASE)) {
                    sendAccessibilityEvent(i, 4);
                }
                return true;
            case 128:
                this.accessibilityChannel.dispatchSemanticsAction(i, Action.DID_LOSE_ACCESSIBILITY_FOCUS);
                sendAccessibilityEvent(i, 65536);
                this.accessibilityFocusedSemanticsNode = null;
                this.embeddedAccessibilityFocusedNodeId = null;
                return true;
            case 256:
                if (Build.VERSION.SDK_INT < 18) {
                    return false;
                }
                return performCursorMoveAction(semanticsNode, i, bundle, true);
            case 512:
                if (Build.VERSION.SDK_INT < 18) {
                    return false;
                }
                return performCursorMoveAction(semanticsNode, i, bundle, false);
            case 4096:
                Action action = Action.SCROLL_UP;
                if (semanticsNode.hasAction(action)) {
                    this.accessibilityChannel.dispatchSemanticsAction(i, action);
                } else {
                    Action action2 = Action.SCROLL_LEFT;
                    if (semanticsNode.hasAction(action2)) {
                        this.accessibilityChannel.dispatchSemanticsAction(i, action2);
                    } else {
                        Action action3 = Action.INCREASE;
                        if (!semanticsNode.hasAction(action3)) {
                            return false;
                        }
                        semanticsNode.value = semanticsNode.increasedValue;
                        semanticsNode.valueAttributes = semanticsNode.increasedValueAttributes;
                        sendAccessibilityEvent(i, 4);
                        this.accessibilityChannel.dispatchSemanticsAction(i, action3);
                    }
                }
                return true;
            case 8192:
                Action action4 = Action.SCROLL_DOWN;
                if (semanticsNode.hasAction(action4)) {
                    this.accessibilityChannel.dispatchSemanticsAction(i, action4);
                } else {
                    Action action5 = Action.SCROLL_RIGHT;
                    if (semanticsNode.hasAction(action5)) {
                        this.accessibilityChannel.dispatchSemanticsAction(i, action5);
                    } else {
                        Action action6 = Action.DECREASE;
                        if (!semanticsNode.hasAction(action6)) {
                            return false;
                        }
                        semanticsNode.value = semanticsNode.decreasedValue;
                        semanticsNode.valueAttributes = semanticsNode.decreasedValueAttributes;
                        sendAccessibilityEvent(i, 4);
                        this.accessibilityChannel.dispatchSemanticsAction(i, action6);
                    }
                }
                return true;
            case 16384:
                this.accessibilityChannel.dispatchSemanticsAction(i, Action.COPY);
                return true;
            case 32768:
                this.accessibilityChannel.dispatchSemanticsAction(i, Action.PASTE);
                return true;
            case 65536:
                this.accessibilityChannel.dispatchSemanticsAction(i, Action.CUT);
                return true;
            case 131072:
                if (Build.VERSION.SDK_INT < 18) {
                    return false;
                }
                HashMap hashMap = new HashMap();
                if (bundle != null && bundle.containsKey(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SELECTION_START_INT) && bundle.containsKey(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SELECTION_END_INT)) {
                    z = true;
                }
                if (!z) {
                    hashMap.put("base", Integer.valueOf(semanticsNode.textSelectionExtent));
                    hashMap.put("extent", Integer.valueOf(semanticsNode.textSelectionExtent));
                } else {
                    hashMap.put("base", Integer.valueOf(bundle.getInt(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SELECTION_START_INT)));
                    hashMap.put("extent", Integer.valueOf(bundle.getInt(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SELECTION_END_INT)));
                }
                this.accessibilityChannel.dispatchSemanticsAction(i, Action.SET_SELECTION, hashMap);
                SemanticsNode semanticsNode2 = this.flutterSemanticsTree.get(Integer.valueOf(i));
                semanticsNode2.textSelectionBase = ((Integer) hashMap.get("base")).intValue();
                semanticsNode2.textSelectionExtent = ((Integer) hashMap.get("extent")).intValue();
                return true;
            case 1048576:
                this.accessibilityChannel.dispatchSemanticsAction(i, Action.DISMISS);
                return true;
            case 2097152:
                if (Build.VERSION.SDK_INT < 21) {
                    return false;
                }
                return performSetText(semanticsNode, i, bundle);
            case ACTION_SHOW_ON_SCREEN /* 16908342 */:
                this.accessibilityChannel.dispatchSemanticsAction(i, Action.SHOW_ON_SCREEN);
                return true;
            default:
                CustomAccessibilityAction customAccessibilityAction = this.customAccessibilityActions.get(Integer.valueOf(i2 - FIRST_RESOURCE_ID));
                if (customAccessibilityAction != null) {
                    this.accessibilityChannel.dispatchSemanticsAction(i, Action.CUSTOM_ACTION, Integer.valueOf(customAccessibilityAction.id));
                    return true;
                }
                return false;
        }
    }

    public void release() {
        this.isReleased = true;
        PlatformViewsAccessibilityDelegate platformViewsAccessibilityDelegate = this.platformViewsAccessibilityDelegate;
        if (platformViewsAccessibilityDelegate != null) {
            platformViewsAccessibilityDelegate.detachAccessibiltyBridge();
        }
        setOnAccessibilityChangeListener(null);
        this.accessibilityManager.removeAccessibilityStateChangeListener(this.accessibilityStateChangeListener);
        if (Build.VERSION.SDK_INT >= 19) {
            this.accessibilityManager.removeTouchExplorationStateChangeListener(this.touchExplorationStateChangeListener);
        }
        this.contentResolver.unregisterContentObserver(this.animationScaleObserver);
        this.accessibilityChannel.setAccessibilityMessageHandler(null);
    }

    public void reset() {
        this.flutterSemanticsTree.clear();
        SemanticsNode semanticsNode = this.accessibilityFocusedSemanticsNode;
        if (semanticsNode != null) {
            sendAccessibilityEvent(semanticsNode.id, 65536);
        }
        this.accessibilityFocusedSemanticsNode = null;
        this.hoveredObject = null;
        sendWindowContentChangeEvent(0);
    }

    public void setOnAccessibilityChangeListener(@Nullable OnAccessibilityChangeListener onAccessibilityChangeListener) {
        this.onAccessibilityChangeListener = onAccessibilityChangeListener;
    }

    void updateCustomAccessibilityActions(@NonNull ByteBuffer byteBuffer, @NonNull String[] strArr) {
        while (byteBuffer.hasRemaining()) {
            CustomAccessibilityAction orCreateAccessibilityAction = getOrCreateAccessibilityAction(byteBuffer.getInt());
            orCreateAccessibilityAction.overrideId = byteBuffer.getInt();
            int i = byteBuffer.getInt();
            String str = null;
            orCreateAccessibilityAction.label = i == -1 ? null : strArr[i];
            int i2 = byteBuffer.getInt();
            if (i2 != -1) {
                str = strArr[i2];
            }
            orCreateAccessibilityAction.hint = str;
        }
    }

    void updateSemantics(@NonNull ByteBuffer byteBuffer, @NonNull String[] strArr, @NonNull ByteBuffer[] byteBufferArr) {
        SemanticsNode semanticsNode;
        SemanticsNode semanticsNode2;
        float f;
        float f2;
        WindowInsets rootWindowInsets;
        Integer valueOf;
        View platformViewById;
        ArrayList arrayList = new ArrayList();
        while (byteBuffer.hasRemaining()) {
            SemanticsNode orCreateSemanticsNode = getOrCreateSemanticsNode(byteBuffer.getInt());
            orCreateSemanticsNode.updateWith(byteBuffer, strArr, byteBufferArr);
            if (!orCreateSemanticsNode.hasFlag(Flag.IS_HIDDEN)) {
                if (orCreateSemanticsNode.hasFlag(Flag.IS_FOCUSED)) {
                    this.inputFocusedSemanticsNode = orCreateSemanticsNode;
                }
                if (orCreateSemanticsNode.hadPreviousConfig) {
                    arrayList.add(orCreateSemanticsNode);
                }
                if (orCreateSemanticsNode.platformViewId != -1 && (platformViewById = this.platformViewsAccessibilityDelegate.getPlatformViewById(orCreateSemanticsNode.platformViewId)) != null) {
                    platformViewById.setImportantForAccessibility(0);
                }
            }
        }
        HashSet hashSet = new HashSet();
        SemanticsNode rootSemanticsNode = getRootSemanticsNode();
        ArrayList<SemanticsNode> arrayList2 = new ArrayList();
        if (rootSemanticsNode != null) {
            float[] fArr = new float[16];
            Matrix.setIdentityM(fArr, 0);
            int i = Build.VERSION.SDK_INT;
            if (i >= 23) {
                if ((i >= 28 ? doesLayoutInDisplayCutoutModeRequireLeftInset() : true) && (rootWindowInsets = this.rootAccessibilityView.getRootWindowInsets()) != null) {
                    if (!this.lastLeftFrameInset.equals(Integer.valueOf(rootWindowInsets.getSystemWindowInsetLeft()))) {
                        rootSemanticsNode.globalGeometryDirty = true;
                        rootSemanticsNode.inverseTransformDirty = true;
                    }
                    this.lastLeftFrameInset = Integer.valueOf(rootWindowInsets.getSystemWindowInsetLeft());
                    Matrix.translateM(fArr, 0, valueOf.intValue(), 0.0f, 0.0f);
                }
            }
            rootSemanticsNode.updateRecursively(fArr, hashSet, false);
            rootSemanticsNode.collectRoutes(arrayList2);
        }
        SemanticsNode semanticsNode3 = null;
        for (SemanticsNode semanticsNode4 : arrayList2) {
            if (!this.flutterNavigationStack.contains(Integer.valueOf(semanticsNode4.id))) {
                semanticsNode3 = semanticsNode4;
            }
        }
        if (semanticsNode3 == null && arrayList2.size() > 0) {
            semanticsNode3 = (SemanticsNode) arrayList2.get(arrayList2.size() - 1);
        }
        if (semanticsNode3 != null && (semanticsNode3.id != this.previousRouteId || arrayList2.size() != this.flutterNavigationStack.size())) {
            this.previousRouteId = semanticsNode3.id;
            onWindowNameChange(semanticsNode3);
        }
        this.flutterNavigationStack.clear();
        for (SemanticsNode semanticsNode5 : arrayList2) {
            this.flutterNavigationStack.add(Integer.valueOf(semanticsNode5.id));
        }
        Iterator<Map.Entry<Integer, SemanticsNode>> it = this.flutterSemanticsTree.entrySet().iterator();
        while (it.hasNext()) {
            SemanticsNode value = it.next().getValue();
            if (!hashSet.contains(value)) {
                willRemoveSemanticsNode(value);
                it.remove();
            }
        }
        sendWindowContentChangeEvent(0);
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            SemanticsNode semanticsNode6 = (SemanticsNode) it2.next();
            if (semanticsNode6.didScroll()) {
                AccessibilityEvent obtainAccessibilityEvent = obtainAccessibilityEvent(semanticsNode6.id, 4096);
                float f3 = semanticsNode6.scrollPosition;
                float f4 = semanticsNode6.scrollExtentMax;
                if (Float.isInfinite(semanticsNode6.scrollExtentMax)) {
                    if (f3 > SCROLL_POSITION_CAP_FOR_INFINITY) {
                        f3 = SCROLL_POSITION_CAP_FOR_INFINITY;
                    }
                    f4 = SCROLL_EXTENT_FOR_INFINITY;
                }
                if (Float.isInfinite(semanticsNode6.scrollExtentMin)) {
                    f = f4 + SCROLL_EXTENT_FOR_INFINITY;
                    if (f3 < -70000.0f) {
                        f3 = -70000.0f;
                    }
                    f2 = f3 + SCROLL_EXTENT_FOR_INFINITY;
                } else {
                    f = f4 - semanticsNode6.scrollExtentMin;
                    f2 = f3 - semanticsNode6.scrollExtentMin;
                }
                if (!semanticsNode6.hadAction(Action.SCROLL_UP) && !semanticsNode6.hadAction(Action.SCROLL_DOWN)) {
                    if (semanticsNode6.hadAction(Action.SCROLL_LEFT) || semanticsNode6.hadAction(Action.SCROLL_RIGHT)) {
                        obtainAccessibilityEvent.setScrollX((int) f2);
                        obtainAccessibilityEvent.setMaxScrollX((int) f);
                    }
                } else {
                    obtainAccessibilityEvent.setScrollY((int) f2);
                    obtainAccessibilityEvent.setMaxScrollY((int) f);
                }
                if (semanticsNode6.scrollChildren > 0) {
                    obtainAccessibilityEvent.setItemCount(semanticsNode6.scrollChildren);
                    obtainAccessibilityEvent.setFromIndex(semanticsNode6.scrollIndex);
                    int i2 = 0;
                    for (SemanticsNode semanticsNode7 : semanticsNode6.childrenInHitTestOrder) {
                        if (!semanticsNode7.hasFlag(Flag.IS_HIDDEN)) {
                            i2++;
                        }
                    }
                    obtainAccessibilityEvent.setToIndex((semanticsNode6.scrollIndex + i2) - 1);
                }
                sendAccessibilityEvent(obtainAccessibilityEvent);
            }
            if (semanticsNode6.hasFlag(Flag.IS_LIVE_REGION) && semanticsNode6.didChangeLabel()) {
                sendWindowContentChangeEvent(semanticsNode6.id);
            }
            SemanticsNode semanticsNode8 = this.accessibilityFocusedSemanticsNode;
            if (semanticsNode8 != null && semanticsNode8.id == semanticsNode6.id) {
                Flag flag = Flag.IS_SELECTED;
                if (!semanticsNode6.hadFlag(flag) && semanticsNode6.hasFlag(flag)) {
                    AccessibilityEvent obtainAccessibilityEvent2 = obtainAccessibilityEvent(semanticsNode6.id, 4);
                    obtainAccessibilityEvent2.getText().add(semanticsNode6.label);
                    sendAccessibilityEvent(obtainAccessibilityEvent2);
                }
            }
            SemanticsNode semanticsNode9 = this.inputFocusedSemanticsNode;
            if (semanticsNode9 != null && semanticsNode9.id == semanticsNode6.id && ((semanticsNode2 = this.lastInputFocusedSemanticsNode) == null || semanticsNode2.id != this.inputFocusedSemanticsNode.id)) {
                this.lastInputFocusedSemanticsNode = this.inputFocusedSemanticsNode;
                sendAccessibilityEvent(obtainAccessibilityEvent(semanticsNode6.id, 8));
            } else if (this.inputFocusedSemanticsNode == null) {
                this.lastInputFocusedSemanticsNode = null;
            }
            SemanticsNode semanticsNode10 = this.inputFocusedSemanticsNode;
            if (semanticsNode10 != null && semanticsNode10.id == semanticsNode6.id) {
                Flag flag2 = Flag.IS_TEXT_FIELD;
                if (semanticsNode6.hadFlag(flag2) && semanticsNode6.hasFlag(flag2) && ((semanticsNode = this.accessibilityFocusedSemanticsNode) == null || semanticsNode.id == this.inputFocusedSemanticsNode.id)) {
                    String str = semanticsNode6.previousValue != null ? semanticsNode6.previousValue : "";
                    String str2 = semanticsNode6.value != null ? semanticsNode6.value : "";
                    AccessibilityEvent createTextChangedEvent = createTextChangedEvent(semanticsNode6.id, str, str2);
                    if (createTextChangedEvent != null) {
                        sendAccessibilityEvent(createTextChangedEvent);
                    }
                    if (semanticsNode6.previousTextSelectionBase != semanticsNode6.textSelectionBase || semanticsNode6.previousTextSelectionExtent != semanticsNode6.textSelectionExtent) {
                        AccessibilityEvent obtainAccessibilityEvent3 = obtainAccessibilityEvent(semanticsNode6.id, 8192);
                        obtainAccessibilityEvent3.getText().add(str2);
                        obtainAccessibilityEvent3.setFromIndex(semanticsNode6.textSelectionBase);
                        obtainAccessibilityEvent3.setToIndex(semanticsNode6.textSelectionExtent);
                        obtainAccessibilityEvent3.setItemCount(str2.length());
                        sendAccessibilityEvent(obtainAccessibilityEvent3);
                    }
                }
            }
        }
    }

    @VisibleForTesting
    public AccessibilityBridge(@NonNull View view, @NonNull AccessibilityChannel accessibilityChannel, @NonNull final AccessibilityManager accessibilityManager, @NonNull ContentResolver contentResolver, @NonNull AccessibilityViewEmbedder accessibilityViewEmbedder, PlatformViewsAccessibilityDelegate platformViewsAccessibilityDelegate) {
        this.flutterSemanticsTree = new HashMap();
        this.customAccessibilityActions = new HashMap();
        this.accessibilityFeatureFlags = 0;
        this.flutterNavigationStack = new ArrayList();
        this.previousRouteId = 0;
        this.lastLeftFrameInset = 0;
        this.isReleased = false;
        this.accessibilityMessageHandler = new AccessibilityChannel.AccessibilityMessageHandler() { // from class: io.flutter.view.AccessibilityBridge.1
            @Override // io.flutter.embedding.engine.systemchannels.AccessibilityChannel.AccessibilityMessageHandler
            public void announce(@NonNull String str) {
                AccessibilityBridge.this.rootAccessibilityView.announceForAccessibility(str);
            }

            @Override // io.flutter.embedding.engine.systemchannels.AccessibilityChannel.AccessibilityMessageHandler
            public void onLongPress(int i) {
                AccessibilityBridge.this.sendAccessibilityEvent(i, 2);
            }

            @Override // io.flutter.embedding.engine.systemchannels.AccessibilityChannel.AccessibilityMessageHandler
            public void onTap(int i) {
                AccessibilityBridge.this.sendAccessibilityEvent(i, 1);
            }

            @Override // io.flutter.embedding.engine.systemchannels.AccessibilityChannel.AccessibilityMessageHandler
            public void onTooltip(@NonNull String str) {
                AccessibilityEvent obtainAccessibilityEvent = AccessibilityBridge.this.obtainAccessibilityEvent(0, 32);
                obtainAccessibilityEvent.getText().add(str);
                AccessibilityBridge.this.sendAccessibilityEvent(obtainAccessibilityEvent);
            }

            @Override // io.flutter.embedding.engine.FlutterJNI.AccessibilityDelegate
            public void updateCustomAccessibilityActions(ByteBuffer byteBuffer, String[] strArr) {
                byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
                AccessibilityBridge.this.updateCustomAccessibilityActions(byteBuffer, strArr);
            }

            @Override // io.flutter.embedding.engine.FlutterJNI.AccessibilityDelegate
            public void updateSemantics(ByteBuffer byteBuffer, String[] strArr, ByteBuffer[] byteBufferArr) {
                byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
                for (ByteBuffer byteBuffer2 : byteBufferArr) {
                    byteBuffer2.order(ByteOrder.LITTLE_ENDIAN);
                }
                AccessibilityBridge.this.updateSemantics(byteBuffer, strArr, byteBufferArr);
            }
        };
        AccessibilityManager.AccessibilityStateChangeListener accessibilityStateChangeListener = new AccessibilityManager.AccessibilityStateChangeListener() { // from class: io.flutter.view.AccessibilityBridge.2
            @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
            public void onAccessibilityStateChanged(boolean z) {
                if (AccessibilityBridge.this.isReleased) {
                    return;
                }
                if (z && FlutterInjector.instance().flutterLoader().initialized()) {
                    z = AccessibilityBridge.this.computeAXEnabledFlag();
                }
                if (z) {
                    AccessibilityBridge.this.accessibilityChannel.setAccessibilityMessageHandler(AccessibilityBridge.this.accessibilityMessageHandler);
                    AccessibilityBridge.this.accessibilityChannel.onAndroidAccessibilityEnabled();
                } else {
                    AccessibilityBridge.this.accessibilityChannel.setAccessibilityMessageHandler(null);
                    AccessibilityBridge.this.accessibilityChannel.onAndroidAccessibilityDisabled();
                }
                if (AccessibilityBridge.this.onAccessibilityChangeListener != null) {
                    AccessibilityBridge.this.onAccessibilityChangeListener.onAccessibilityChanged(z, AccessibilityBridge.this.accessibilityManager.isTouchExplorationEnabled());
                }
            }
        };
        this.accessibilityStateChangeListener = accessibilityStateChangeListener;
        ContentObserver contentObserver = new ContentObserver(new Handler()) { // from class: io.flutter.view.AccessibilityBridge.3
            @Override // android.database.ContentObserver
            public void onChange(boolean z) {
                onChange(z, null);
            }

            @Override // android.database.ContentObserver
            public void onChange(boolean z, Uri uri) {
                if (AccessibilityBridge.this.isReleased) {
                    return;
                }
                String string = Build.VERSION.SDK_INT < 17 ? null : Settings.Global.getString(AccessibilityBridge.this.contentResolver, "transition_animation_scale");
                if (string != null && string.equals("0")) {
                    AccessibilityBridge.this.accessibilityFeatureFlags |= AccessibilityFeature.DISABLE_ANIMATIONS.value;
                } else {
                    AccessibilityBridge.this.accessibilityFeatureFlags &= ~AccessibilityFeature.DISABLE_ANIMATIONS.value;
                }
                AccessibilityBridge.this.sendLatestAccessibilityFlagsToFlutter();
            }
        };
        this.animationScaleObserver = contentObserver;
        this.rootAccessibilityView = view;
        this.accessibilityChannel = accessibilityChannel;
        this.accessibilityManager = accessibilityManager;
        this.contentResolver = contentResolver;
        this.accessibilityViewEmbedder = accessibilityViewEmbedder;
        this.platformViewsAccessibilityDelegate = platformViewsAccessibilityDelegate;
        accessibilityStateChangeListener.onAccessibilityStateChanged(accessibilityManager.isEnabled());
        accessibilityManager.addAccessibilityStateChangeListener(accessibilityStateChangeListener);
        int i = Build.VERSION.SDK_INT;
        if (i >= 19) {
            AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener = new AccessibilityManager.TouchExplorationStateChangeListener() { // from class: io.flutter.view.AccessibilityBridge.4
                @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
                public void onTouchExplorationStateChanged(boolean z) {
                    if (AccessibilityBridge.this.isReleased) {
                        return;
                    }
                    if (!z) {
                        AccessibilityBridge.this.onTouchExplorationExit();
                        AccessibilityBridge.this.accessibilityFeatureFlags &= ~AccessibilityFeature.ACCESSIBLE_NAVIGATION.value;
                    } else {
                        AccessibilityBridge.this.accessibilityFeatureFlags |= AccessibilityFeature.ACCESSIBLE_NAVIGATION.value;
                    }
                    AccessibilityBridge.this.sendLatestAccessibilityFlagsToFlutter();
                    if (AccessibilityBridge.this.onAccessibilityChangeListener != null) {
                        AccessibilityBridge.this.onAccessibilityChangeListener.onAccessibilityChanged(accessibilityManager.isEnabled(), z);
                    }
                }
            };
            this.touchExplorationStateChangeListener = touchExplorationStateChangeListener;
            touchExplorationStateChangeListener.onTouchExplorationStateChanged(accessibilityManager.isTouchExplorationEnabled());
            accessibilityManager.addTouchExplorationStateChangeListener(touchExplorationStateChangeListener);
        } else {
            this.touchExplorationStateChangeListener = null;
        }
        if (i >= 17) {
            contentObserver.onChange(false);
            contentResolver.registerContentObserver(Settings.Global.getUriFor("transition_animation_scale"), false, contentObserver);
        }
        if (platformViewsAccessibilityDelegate != null) {
            platformViewsAccessibilityDelegate.attachAccessibilityBridge(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
        if (this.accessibilityManager.isEnabled()) {
            this.rootAccessibilityView.getParent().requestSendAccessibilityEvent(this.rootAccessibilityView, accessibilityEvent);
        }
    }
}
