package io.flutter.plugin.platform;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.annotation.VisibleForTesting;
import io.flutter.Log;
import io.flutter.embedding.android.AndroidTouchProcessor;
import io.flutter.embedding.android.FlutterImageView;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.android.MotionEventTracker;
import io.flutter.embedding.engine.FlutterOverlaySurface;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.mutatorsstack.FlutterMutatorView;
import io.flutter.embedding.engine.mutatorsstack.FlutterMutatorsStack;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.systemchannels.PlatformViewsChannel;
import io.flutter.plugin.editing.TextInputPlugin;
import io.flutter.plugin.platform.PlatformViewsController;
import io.flutter.view.AccessibilityBridge;
import io.flutter.view.TextureRegistry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class PlatformViewsController implements PlatformViewsAccessibilityDelegate {
    private static final String TAG = "PlatformViewsController";
    private AndroidTouchProcessor androidTouchProcessor;
    private Context context;
    private View flutterView;
    private PlatformViewsChannel platformViewsChannel;
    @Nullable
    private TextInputPlugin textInputPlugin;
    private TextureRegistry textureRegistry;
    private int nextOverlayLayerId = 0;
    private boolean flutterViewConvertedToImageView = false;
    private boolean synchronizeToNativeViewHierarchy = true;
    private final PlatformViewsChannel.PlatformViewsHandler channelHandler = new AnonymousClass1();
    private PenetratedDisplayController penetratedDisplayController = new PenetratedDisplayController();
    private final PlatformViewRegistryImpl registry = new PlatformViewRegistryImpl();
    private final AccessibilityEventsDelegate accessibilityEventsDelegate = new AccessibilityEventsDelegate();
    private final SparseArray<FlutterImageView> overlayLayerViews = new SparseArray<>();
    private HashSet<Integer> currentFrameUsedOverlayLayerIds = new HashSet<>();
    private HashSet<Integer> currentFrameUsedPlatformViewIds = new HashSet<>();
    private final SparseArray<PlatformViewWrapper> viewWrappers = new SparseArray<>();
    private final SparseArray<PlatformView> platformViews = new SparseArray<>();
    private final SparseArray<FlutterMutatorView> platformViewParent = new SparseArray<>();
    private final MotionEventTracker motionEventTracker = MotionEventTracker.getInstance();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: io.flutter.plugin.platform.PlatformViewsController$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 implements PlatformViewsChannel.PlatformViewsHandler {
        AnonymousClass1() {
        }

        private void ensureValidAndroidVersion(int i) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= i) {
                return;
            }
            throw new IllegalStateException("Trying to use platform views with API " + i2 + ", required API level is: " + i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$createForTextureLayer$0(int i, View view, boolean z) {
            if (z) {
                PlatformViewsController.this.platformViewsChannel.invokeViewFocused(i);
            } else if (PlatformViewsController.this.textInputPlugin != null) {
                PlatformViewsController.this.textInputPlugin.clearPlatformViewClient(i);
            }
        }

        @Override // io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewsHandler
        public void clearFocus(int i) {
            if (PlatformViewsController.this.penetratedDisplayController.clearFocus(i)) {
                return;
            }
            PlatformView platformView = (PlatformView) PlatformViewsController.this.platformViews.get(i);
            if (platformView == null) {
                Log.e(PlatformViewsController.TAG, "Clearing focus on an unknown view with id: " + i);
                return;
            }
            platformView.getView().clearFocus();
        }

        @Override // io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewsHandler
        @TargetApi(19)
        public void createForPlatformViewLayer(@NonNull PlatformViewsChannel.PlatformViewCreationRequest platformViewCreationRequest) {
            ensureValidAndroidVersion(19);
            if (PlatformViewsController.validateDirection(platformViewCreationRequest.direction)) {
                PlatformViewFactory factory = PlatformViewsController.this.registry.getFactory(platformViewCreationRequest.viewType);
                if (factory != null) {
                    PlatformViewsController.this.platformViews.put(platformViewCreationRequest.viewId, factory.create(PlatformViewsController.this.context, platformViewCreationRequest.viewId, platformViewCreationRequest.params != null ? factory.getCreateArgsCodec().decodeMessage(platformViewCreationRequest.params) : null));
                    return;
                }
                throw new IllegalStateException("Trying to create a platform view of unregistered type: " + platformViewCreationRequest.viewType);
            }
            throw new IllegalStateException("Trying to create a view with unknown direction value: " + platformViewCreationRequest.direction + "(view id: " + platformViewCreationRequest.viewId + jn1.BRACKET_END_STR);
        }

        @Override // io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewsHandler
        @TargetApi(23)
        public long createForTextureLayer(@NonNull PlatformViewsChannel.PlatformViewCreationRequest platformViewCreationRequest) {
            if (platformViewCreationRequest.renderType == PlatformViewsChannel.PlatformViewRenderType.penetratedDisplay) {
                return PlatformViewsController.this.penetratedDisplayController.createPlatformView(platformViewCreationRequest);
            }
            final int i = platformViewCreationRequest.viewId;
            if (PlatformViewsController.this.viewWrappers.get(i) == null) {
                if (PlatformViewsController.validateDirection(platformViewCreationRequest.direction)) {
                    if (PlatformViewsController.this.textureRegistry != null) {
                        if (PlatformViewsController.this.flutterView != null) {
                            PlatformViewFactory factory = PlatformViewsController.this.registry.getFactory(platformViewCreationRequest.viewType);
                            if (factory != null) {
                                PlatformView create = factory.create(PlatformViewsController.this.context, i, platformViewCreationRequest.params != null ? factory.getCreateArgsCodec().decodeMessage(platformViewCreationRequest.params) : null);
                                PlatformViewsController.this.platformViews.put(i, create);
                                TextureRegistry.SurfaceTextureEntry createSurfaceTexture = PlatformViewsController.this.textureRegistry.createSurfaceTexture();
                                PlatformViewWrapper platformViewWrapper = new PlatformViewWrapper(PlatformViewsController.this.context, createSurfaceTexture);
                                platformViewWrapper.setTouchProcessor(PlatformViewsController.this.androidTouchProcessor);
                                int physicalPixels = PlatformViewsController.this.toPhysicalPixels(platformViewCreationRequest.logicalWidth);
                                int physicalPixels2 = PlatformViewsController.this.toPhysicalPixels(platformViewCreationRequest.logicalHeight);
                                platformViewWrapper.setBufferSize(physicalPixels, physicalPixels2);
                                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(physicalPixels, physicalPixels2);
                                int physicalPixels3 = PlatformViewsController.this.toPhysicalPixels(platformViewCreationRequest.logicalTop);
                                int physicalPixels4 = PlatformViewsController.this.toPhysicalPixels(platformViewCreationRequest.logicalLeft);
                                layoutParams.topMargin = physicalPixels3;
                                layoutParams.leftMargin = physicalPixels4;
                                platformViewWrapper.setLayoutParams(layoutParams);
                                platformViewWrapper.setLayoutDirection(platformViewCreationRequest.direction);
                                platformViewWrapper.addView(create.getView());
                                platformViewWrapper.setOnDescendantFocusChangeListener(new View.OnFocusChangeListener() { // from class: io.flutter.plugin.platform.a
                                    @Override // android.view.View.OnFocusChangeListener
                                    public final void onFocusChange(View view, boolean z) {
                                        PlatformViewsController.AnonymousClass1.this.lambda$createForTextureLayer$0(i, view, z);
                                    }
                                });
                                ((ViewGroup) PlatformViewsController.this.flutterView).addView(platformViewWrapper);
                                PlatformViewsController.this.viewWrappers.append(i, platformViewWrapper);
                                return createSurfaceTexture.id();
                            }
                            throw new IllegalStateException("Trying to create a platform view of unregistered type: " + platformViewCreationRequest.viewType);
                        }
                        throw new IllegalStateException("Flutter view is null. This means the platform views controller doesn't have an attached view, view id: " + i);
                    }
                    throw new IllegalStateException("Texture registry is null. This means that platform views controller was detached, view id: " + i);
                }
                throw new IllegalStateException("Trying to create a view with unknown direction value: " + platformViewCreationRequest.direction + "(view id: " + i + jn1.BRACKET_END_STR);
            }
            throw new IllegalStateException("Trying to create an already created platform view, view id: " + i);
        }

        @Override // io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewsHandler
        public void dispose(int i) {
            if (PlatformViewsController.this.penetratedDisplayController.disposePlatformView(i)) {
                return;
            }
            PlatformView platformView = (PlatformView) PlatformViewsController.this.platformViews.get(i);
            if (platformView != null) {
                ViewGroup viewGroup = (ViewGroup) platformView.getView().getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(platformView.getView());
                }
                PlatformViewsController.this.platformViews.remove(i);
                platformView.dispose();
            }
            PlatformViewWrapper platformViewWrapper = (PlatformViewWrapper) PlatformViewsController.this.viewWrappers.get(i);
            if (platformViewWrapper == null) {
                FlutterMutatorView flutterMutatorView = (FlutterMutatorView) PlatformViewsController.this.platformViewParent.get(i);
                if (flutterMutatorView != null) {
                    flutterMutatorView.unsetOnDescendantFocusChangeListener();
                    ViewGroup viewGroup2 = (ViewGroup) flutterMutatorView.getParent();
                    if (viewGroup2 != null) {
                        viewGroup2.removeView(flutterMutatorView);
                    }
                    PlatformViewsController.this.platformViewParent.remove(i);
                    return;
                }
                return;
            }
            platformViewWrapper.release();
            platformViewWrapper.unsetOnDescendantFocusChangeListener();
            ViewGroup viewGroup3 = (ViewGroup) platformViewWrapper.getParent();
            if (viewGroup3 != null) {
                viewGroup3.removeView(platformViewWrapper);
            }
            PlatformViewsController.this.viewWrappers.remove(i);
        }

        @Override // io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewsHandler
        public void offset(int i, double d, double d2) {
            if (PlatformViewsController.this.penetratedDisplayController.isAvailableId(i)) {
                return;
            }
            PlatformViewWrapper platformViewWrapper = (PlatformViewWrapper) PlatformViewsController.this.viewWrappers.get(i);
            if (platformViewWrapper != null) {
                int physicalPixels = PlatformViewsController.this.toPhysicalPixels(d);
                int physicalPixels2 = PlatformViewsController.this.toPhysicalPixels(d2);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) platformViewWrapper.getLayoutParams();
                layoutParams.topMargin = physicalPixels;
                layoutParams.leftMargin = physicalPixels2;
                platformViewWrapper.setLayoutParams(layoutParams);
                return;
            }
            Log.e(PlatformViewsController.TAG, "Setting offset for unknown platform view with id: " + i);
        }

        @Override // io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewsHandler
        public void onTouch(@NonNull PlatformViewsChannel.PlatformViewTouch platformViewTouch) {
            if (PlatformViewsController.this.penetratedDisplayController.handleOnTouchEvent(platformViewTouch)) {
                return;
            }
            int i = platformViewTouch.viewId;
            PlatformView platformView = (PlatformView) PlatformViewsController.this.platformViews.get(i);
            if (platformView == null) {
                Log.e(PlatformViewsController.TAG, "Sending touch to an unknown view with id: " + i);
                return;
            }
            ensureValidAndroidVersion(20);
            platformView.getView().dispatchTouchEvent(PlatformViewsController.this.toMotionEvent(PlatformViewsController.this.context.getResources().getDisplayMetrics().density, platformViewTouch));
        }

        @Override // io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewsHandler
        public PlatformViewsChannel.PlatformViewBufferSize resize(@NonNull PlatformViewsChannel.PlatformViewResizeRequest platformViewResizeRequest) {
            int i = platformViewResizeRequest.viewId;
            if (PlatformViewsController.this.penetratedDisplayController.isAvailableId(i)) {
                return null;
            }
            PlatformViewWrapper platformViewWrapper = (PlatformViewWrapper) PlatformViewsController.this.viewWrappers.get(i);
            if (platformViewWrapper != null) {
                int physicalPixels = PlatformViewsController.this.toPhysicalPixels(platformViewResizeRequest.newLogicalWidth);
                int physicalPixels2 = PlatformViewsController.this.toPhysicalPixels(platformViewResizeRequest.newLogicalHeight);
                if (physicalPixels > platformViewWrapper.getBufferWidth() || physicalPixels2 > platformViewWrapper.getBufferHeight()) {
                    platformViewWrapper.setBufferSize(physicalPixels, physicalPixels2);
                }
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) platformViewWrapper.getLayoutParams();
                layoutParams.width = physicalPixels;
                layoutParams.height = physicalPixels2;
                platformViewWrapper.setLayoutParams(layoutParams);
                return new PlatformViewsChannel.PlatformViewBufferSize(PlatformViewsController.this.toLogicalPixels(platformViewWrapper.getBufferWidth()), PlatformViewsController.this.toLogicalPixels(platformViewWrapper.getBufferHeight()));
            }
            Log.e(PlatformViewsController.TAG, "Resizing unknown platform view with id: " + i);
            return null;
        }

        @Override // io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewsHandler
        @TargetApi(17)
        public void setDirection(int i, int i2) {
            if (PlatformViewsController.this.penetratedDisplayController.isAvailableId(i)) {
                return;
            }
            if (PlatformViewsController.validateDirection(i2)) {
                if (((PlatformView) PlatformViewsController.this.platformViews.get(i)) == null) {
                    Log.e(PlatformViewsController.TAG, "Setting direction to an unknown view with id: " + i);
                    return;
                }
                ensureValidAndroidVersion(20);
                ((PlatformView) PlatformViewsController.this.platformViews.get(i)).getView().setLayoutDirection(i2);
                return;
            }
            throw new IllegalStateException("Trying to set unknown direction value: " + i2 + "(view id: " + i + jn1.BRACKET_END_STR);
        }

        @Override // io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewsHandler
        public void synchronizeToNativeViewHierarchy(boolean z) {
            PlatformViewsController.this.synchronizeToNativeViewHierarchy = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public class PenetratedDisplayController {
        private ArrayList<Integer> activeCompositionOrder;
        private ArrayList<Integer> compositionOrder;
        private final HashMap<Integer, EmbeddedViewContainer> viewIdToPlatformView = new HashMap<>();
        private final SparseArray<BackgroundContainer> backgroundContainers = new SparseArray<>();

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: Taobao */
        /* loaded from: classes3.dex */
        public class BackgroundContainer extends FrameLayout {
            public BackgroundContainer(Context context) {
                super(context);
            }

            @Override // android.view.ViewGroup, android.view.View
            public boolean dispatchTouchEvent(MotionEvent motionEvent) {
                return false;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: Taobao */
        /* loaded from: classes3.dex */
        public class EmbeddedViewContainer extends FrameLayout {
            private View flutterView;
            private PlatformView platformView;
            private float viewAlpha;
            public final int viewId;
            private Rect viewRect;

            public EmbeddedViewContainer(Context context, PlatformView platformView, int i, View view) {
                super(context);
                this.platformView = platformView;
                this.viewId = i;
                this.flutterView = view;
                setBackgroundColor(0);
                if (getEmbeddedView() != null) {
                    addView(getEmbeddedView(), new FrameLayout.LayoutParams(-1, -1, 17));
                }
            }

            @Override // android.view.ViewGroup, android.view.View
            public boolean dispatchTouchEvent(MotionEvent motionEvent) {
                return false;
            }

            public View getEmbeddedView() {
                return this.platformView.getView();
            }

            public View getFlutterView() {
                return this.flutterView;
            }

            public PlatformView getPlatformView() {
                return this.platformView;
            }

            public boolean handleDispatchTouchEvent(MotionEvent motionEvent) {
                return super.dispatchTouchEvent(motionEvent);
            }

            public boolean updateViewDisplay() {
                if (this.viewRect == null || getEmbeddedView() == null) {
                    return false;
                }
                getEmbeddedView().setAlpha(this.viewAlpha);
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                if (layoutParams == null) {
                    return false;
                }
                if (getX() == this.viewRect.left) {
                    float y = getY();
                    Rect rect = this.viewRect;
                    if (y == rect.top && layoutParams.width == com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(rect) && layoutParams.height == com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(this.viewRect)) {
                        return false;
                    }
                }
                setX(this.viewRect.left);
                setY(this.viewRect.top);
                layoutParams.width = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(this.viewRect);
                layoutParams.height = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(this.viewRect);
                requestLayout();
                return true;
            }

            public void updatedDisplayedInfo(Rect rect, float f) {
                this.viewRect = rect;
                this.viewAlpha = f;
            }
        }

        public PenetratedDisplayController() {
        }

        private BackgroundContainer addBackgroundContainerIfNeeded(View view) {
            int hashCode = view.hashCode();
            BackgroundContainer backgroundContainer = this.backgroundContainers.get(hashCode);
            if (backgroundContainer == null) {
                Context context = PlatformViewsController.this.context;
                if (context == null) {
                    context = view.getContext();
                }
                BackgroundContainer backgroundContainer2 = new BackgroundContainer(context);
                ((ViewGroup) view).addView(backgroundContainer2, 0);
                this.backgroundContainers.put(hashCode, backgroundContainer2);
                return backgroundContainer2;
            }
            return backgroundContainer;
        }

        private boolean attachActiveEmbeddedViews() {
            if (this.compositionOrder == null) {
                return false;
            }
            boolean z = false;
            for (int i = 0; i < this.compositionOrder.size(); i++) {
                EmbeddedViewContainer embeddedViewContainer = this.viewIdToPlatformView.get(Integer.valueOf(this.compositionOrder.get(i).intValue()));
                if (embeddedViewContainer != null) {
                    attachEmbeddedView(embeddedViewContainer, i);
                    boolean updateViewDisplay = embeddedViewContainer.updateViewDisplay();
                    if (!z) {
                        z = updateViewDisplay;
                    }
                }
            }
            this.activeCompositionOrder = (ArrayList) this.compositionOrder.clone();
            this.compositionOrder.clear();
            return z;
        }

        private boolean attachEmbeddedView(EmbeddedViewContainer embeddedViewContainer, int i) {
            if (PlatformViewsController.this.flutterView == null || embeddedViewContainer == null) {
                return false;
            }
            BackgroundContainer backgroundContainer = this.backgroundContainers.get(embeddedViewContainer.getFlutterView().hashCode());
            if (backgroundContainer == null) {
                return false;
            }
            if (embeddedViewContainer.getParent() == null) {
                backgroundContainer.addView(embeddedViewContainer, i);
                return true;
            } else if (embeddedViewContainer.getParent() != backgroundContainer) {
                return false;
            } else {
                if (i == backgroundContainer.indexOfChild(embeddedViewContainer)) {
                    return true;
                }
                backgroundContainer.removeView(embeddedViewContainer);
                backgroundContainer.addView(embeddedViewContainer, i);
                return true;
            }
        }

        private boolean dettachEmbeddedView(int i) {
            EmbeddedViewContainer embeddedViewContainer = this.viewIdToPlatformView.get(Integer.valueOf(i));
            if (embeddedViewContainer == null) {
                return false;
            }
            if (embeddedViewContainer.getFlutterView() != PlatformViewsController.this.flutterView || embeddedViewContainer.getParent() == null) {
                return true;
            }
            ((ViewGroup) embeddedViewContainer.getParent()).removeView(embeddedViewContainer);
            return true;
        }

        private void dettachUnusedEmbeddedViews() {
            boolean z;
            if (this.compositionOrder == null || this.activeCompositionOrder == null) {
                return;
            }
            for (int i = 0; i < this.activeCompositionOrder.size(); i++) {
                int i2 = 0;
                while (true) {
                    if (i2 >= this.compositionOrder.size()) {
                        z = true;
                        break;
                    } else if (this.activeCompositionOrder.get(i) == this.compositionOrder.get(i2)) {
                        z = false;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (z) {
                    dettachEmbeddedView(this.activeCompositionOrder.get(i).intValue());
                }
            }
        }

        private void removeBackgroundContainer(View view) {
            int hashCode = view.hashCode();
            BackgroundContainer backgroundContainer = this.backgroundContainers.get(hashCode);
            if (backgroundContainer == null || backgroundContainer.getChildCount() != 0) {
                return;
            }
            ((ViewGroup) view).removeView(backgroundContainer);
            this.backgroundContainers.remove(hashCode);
        }

        private void resetCurrentFrame() {
            ArrayList<Integer> arrayList = this.compositionOrder;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        private void tryRecordCompositionOrder(int i) {
            if (this.compositionOrder == null) {
                this.compositionOrder = new ArrayList<>();
            }
            for (int i2 = 0; i2 < this.compositionOrder.size(); i2++) {
                if (this.compositionOrder.get(i2).intValue() == i) {
                    return;
                }
            }
            this.compositionOrder.add(Integer.valueOf(i));
        }

        public void attachToView() {
        }

        public boolean clearFocus(int i) {
            EmbeddedViewContainer embeddedViewContainer = this.viewIdToPlatformView.get(Integer.valueOf(i));
            if (embeddedViewContainer == null) {
                return false;
            }
            embeddedViewContainer.clearFocus();
            embeddedViewContainer.getEmbeddedView().clearFocus();
            return true;
        }

        public long createPlatformView(@NonNull PlatformViewsChannel.PlatformViewCreationRequest platformViewCreationRequest) {
            if (PlatformViewsController.this.flutterView != null) {
                ((FlutterView) PlatformViewsController.this.flutterView).fallbackRenderSurfaceForPlatformView(true);
            }
            if (!this.viewIdToPlatformView.containsKey(Integer.valueOf(platformViewCreationRequest.viewId))) {
                PlatformViewFactory factory = PlatformViewsController.this.registry.getFactory(platformViewCreationRequest.viewType);
                if (factory != null) {
                    EmbeddedViewContainer embeddedViewContainer = new EmbeddedViewContainer(PlatformViewsController.this.context, factory.create(PlatformViewsController.this.context, platformViewCreationRequest.viewId, platformViewCreationRequest.params != null ? factory.getCreateArgsCodec().decodeMessage(platformViewCreationRequest.params) : null), platformViewCreationRequest.viewId, PlatformViewsController.this.flutterView);
                    this.viewIdToPlatformView.put(Integer.valueOf(platformViewCreationRequest.viewId), embeddedViewContainer);
                    BackgroundContainer addBackgroundContainerIfNeeded = addBackgroundContainerIfNeeded(PlatformViewsController.this.flutterView);
                    if (addBackgroundContainerIfNeeded != null) {
                        addBackgroundContainerIfNeeded.addView(embeddedViewContainer, new FrameLayout.LayoutParams(PlatformViewsController.this.toPhysicalPixels(platformViewCreationRequest.logicalWidth), PlatformViewsController.this.toPhysicalPixels(platformViewCreationRequest.logicalHeight)));
                    }
                    return platformViewCreationRequest.viewId;
                }
                throw new IllegalStateException("Trying to create a platform view of unregistered type: " + platformViewCreationRequest.viewType);
            }
            throw new IllegalStateException("Trying to create an already created platform view, view id: " + platformViewCreationRequest.viewId);
        }

        public void detachFromView() {
        }

        public boolean disposePlatformView(int i) {
            if (dettachEmbeddedView(i)) {
                EmbeddedViewContainer embeddedViewContainer = this.viewIdToPlatformView.get(Integer.valueOf(i));
                embeddedViewContainer.getPlatformView().dispose();
                removeBackgroundContainer(embeddedViewContainer.getFlutterView());
                this.viewIdToPlatformView.remove(Integer.valueOf(i));
                return true;
            }
            return false;
        }

        public void flushAllViews() {
            this.viewIdToPlatformView.clear();
        }

        public PlatformView getPlatformViewById(Integer num) {
            EmbeddedViewContainer embeddedViewContainer = this.viewIdToPlatformView.get(num);
            if (embeddedViewContainer != null) {
                return embeddedViewContainer.getPlatformView();
            }
            return null;
        }

        public boolean handleOnTouchEvent(@NonNull PlatformViewsChannel.PlatformViewTouch platformViewTouch) {
            EmbeddedViewContainer embeddedViewContainer = this.viewIdToPlatformView.get(Integer.valueOf(platformViewTouch.viewId));
            if (embeddedViewContainer == null) {
                return false;
            }
            float f = PlatformViewsController.this.context.getResources().getDisplayMetrics().density;
            embeddedViewContainer.handleDispatchTouchEvent(MotionEvent.obtain(platformViewTouch.downTime.longValue(), platformViewTouch.eventTime.longValue(), platformViewTouch.action, platformViewTouch.pointerCount, (MotionEvent.PointerProperties[]) PlatformViewsController.parsePointerPropertiesList(platformViewTouch.rawPointerPropertiesList).toArray(new MotionEvent.PointerProperties[platformViewTouch.pointerCount]), (MotionEvent.PointerCoords[]) PlatformViewsController.parsePointerCoordsList(platformViewTouch.rawPointerCoords, f).toArray(new MotionEvent.PointerCoords[platformViewTouch.pointerCount]), platformViewTouch.metaState, platformViewTouch.buttonState, platformViewTouch.xPrecision, platformViewTouch.yPrecision, platformViewTouch.deviceId, platformViewTouch.edgeFlags, platformViewTouch.source, platformViewTouch.flags));
            return true;
        }

        public boolean isAvailableId(int i) {
            return this.viewIdToPlatformView.get(Integer.valueOf(i)) != null;
        }

        public void onBeginFrame() {
            resetCurrentFrame();
        }

        public void onCancelFrame() {
            resetCurrentFrame();
        }

        public void onPlatformViewDisplayedUpdated(int i, Rect rect, float f) {
            EmbeddedViewContainer embeddedViewContainer = this.viewIdToPlatformView.get(Integer.valueOf(i));
            if (embeddedViewContainer == null) {
                return;
            }
            tryRecordCompositionOrder(i);
            embeddedViewContainer.updatedDisplayedInfo(rect, f);
        }

        public boolean onSubmitFrame() {
            dettachUnusedEmbeddedViews();
            return attachActiveEmbeddedViews();
        }
    }

    private void finishFrame(boolean z) {
        for (int i = 0; i < this.overlayLayerViews.size(); i++) {
            int keyAt = this.overlayLayerViews.keyAt(i);
            FlutterImageView valueAt = this.overlayLayerViews.valueAt(i);
            if (this.currentFrameUsedOverlayLayerIds.contains(Integer.valueOf(keyAt))) {
                ((FlutterView) this.flutterView).attachOverlaySurfaceToRender(valueAt);
                z &= valueAt.acquireLatestImage();
            } else {
                if (!this.flutterViewConvertedToImageView) {
                    valueAt.detachFromRenderer();
                }
                valueAt.setVisibility(8);
            }
        }
        for (int i2 = 0; i2 < this.platformViewParent.size(); i2++) {
            int keyAt2 = this.platformViewParent.keyAt(i2);
            FlutterMutatorView flutterMutatorView = this.platformViewParent.get(keyAt2);
            if (this.currentFrameUsedPlatformViewIds.contains(Integer.valueOf(keyAt2)) && (z || !this.synchronizeToNativeViewHierarchy)) {
                flutterMutatorView.setVisibility(0);
            } else {
                flutterMutatorView.setVisibility(8);
            }
        }
    }

    private void flushAllViews() {
        while (this.platformViews.size() > 0) {
            this.channelHandler.dispose(this.platformViews.keyAt(0));
        }
        this.penetratedDisplayController.flushAllViews();
    }

    private float getDisplayDensity() {
        return this.context.getResources().getDisplayMetrics().density;
    }

    private void initializeRootImageViewIfNeeded() {
        if (!this.synchronizeToNativeViewHierarchy || this.flutterViewConvertedToImageView) {
            return;
        }
        ((FlutterView) this.flutterView).convertToImageView();
        this.flutterViewConvertedToImageView = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initializePlatformViewIfNeeded$0(int i, View view, boolean z) {
        if (z) {
            this.platformViewsChannel.invokeViewFocused(i);
            return;
        }
        TextInputPlugin textInputPlugin = this.textInputPlugin;
        if (textInputPlugin != null) {
            textInputPlugin.clearPlatformViewClient(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onEndFrame$1() {
        finishFrame(false);
    }

    private static MotionEvent.PointerCoords parsePointerCoords(Object obj, float f) {
        List list = (List) obj;
        MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
        pointerCoords.orientation = (float) ((Double) list.get(0)).doubleValue();
        pointerCoords.pressure = (float) ((Double) list.get(1)).doubleValue();
        pointerCoords.size = (float) ((Double) list.get(2)).doubleValue();
        pointerCoords.toolMajor = ((float) ((Double) list.get(3)).doubleValue()) * f;
        pointerCoords.toolMinor = ((float) ((Double) list.get(4)).doubleValue()) * f;
        pointerCoords.touchMajor = ((float) ((Double) list.get(5)).doubleValue()) * f;
        pointerCoords.touchMinor = ((float) ((Double) list.get(6)).doubleValue()) * f;
        pointerCoords.x = ((float) ((Double) list.get(7)).doubleValue()) * f;
        pointerCoords.y = ((float) ((Double) list.get(8)).doubleValue()) * f;
        return pointerCoords;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<MotionEvent.PointerCoords> parsePointerCoordsList(Object obj, float f) {
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : (List) obj) {
            arrayList.add(parsePointerCoords(obj2, f));
        }
        return arrayList;
    }

    private static MotionEvent.PointerProperties parsePointerProperties(Object obj) {
        List list = (List) obj;
        MotionEvent.PointerProperties pointerProperties = new MotionEvent.PointerProperties();
        pointerProperties.id = ((Integer) list.get(0)).intValue();
        pointerProperties.toolType = ((Integer) list.get(1)).intValue();
        return pointerProperties;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<MotionEvent.PointerProperties> parsePointerPropertiesList(Object obj) {
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : (List) obj) {
            arrayList.add(parsePointerProperties(obj2));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int toLogicalPixels(double d) {
        return (int) Math.round(d / getDisplayDensity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int toPhysicalPixels(double d) {
        return (int) Math.round(d * getDisplayDensity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean validateDirection(int i) {
        return i == 0 || i == 1;
    }

    public void attach(Context context, TextureRegistry textureRegistry, @NonNull DartExecutor dartExecutor) {
        if (this.context == null) {
            this.context = context;
            this.textureRegistry = textureRegistry;
            PlatformViewsChannel platformViewsChannel = new PlatformViewsChannel(dartExecutor);
            this.platformViewsChannel = platformViewsChannel;
            platformViewsChannel.setPlatformViewsHandler(this.channelHandler);
            return;
        }
        throw new AssertionError("A PlatformViewsController can only be attached to a single output target.\nattach was called while the PlatformViewsController was already attached.");
    }

    @Override // io.flutter.plugin.platform.PlatformViewsAccessibilityDelegate
    public void attachAccessibilityBridge(AccessibilityBridge accessibilityBridge) {
        this.accessibilityEventsDelegate.setAccessibilityBridge(accessibilityBridge);
    }

    public void attachTextInputPlugin(TextInputPlugin textInputPlugin) {
        this.textInputPlugin = textInputPlugin;
    }

    public void attachToFlutterRenderer(FlutterRenderer flutterRenderer) {
        this.androidTouchProcessor = new AndroidTouchProcessor(flutterRenderer, true);
    }

    public void attachToView(@NonNull View view) {
        this.flutterView = view;
        this.penetratedDisplayController.attachToView();
        for (int i = 0; i < this.platformViews.size(); i++) {
            this.platformViews.valueAt(i).onFlutterViewAttached(view);
        }
    }

    @TargetApi(19)
    @VisibleForTesting
    public FlutterOverlaySurface createOverlaySurface(@NonNull FlutterImageView flutterImageView) {
        int i = this.nextOverlayLayerId;
        this.nextOverlayLayerId = i + 1;
        this.overlayLayerViews.put(i, flutterImageView);
        return new FlutterOverlaySurface(i, flutterImageView.getSurface());
    }

    public void destroyOverlaySurfaces() {
        for (int i = 0; i < this.overlayLayerViews.size(); i++) {
            this.overlayLayerViews.keyAt(i);
            FlutterImageView valueAt = this.overlayLayerViews.valueAt(i);
            valueAt.detachFromRenderer();
            View view = this.flutterView;
            if (view != null) {
                ((FlutterView) view).removeView(valueAt);
            }
        }
        this.overlayLayerViews.clear();
    }

    @UiThread
    public void detach() {
        PlatformViewsChannel platformViewsChannel = this.platformViewsChannel;
        if (platformViewsChannel != null) {
            platformViewsChannel.setPlatformViewsHandler(null);
        }
        destroyOverlaySurfaces();
        this.platformViewsChannel = null;
        this.context = null;
        this.textureRegistry = null;
    }

    @Override // io.flutter.plugin.platform.PlatformViewsAccessibilityDelegate
    public void detachAccessibiltyBridge() {
        this.accessibilityEventsDelegate.setAccessibilityBridge(null);
    }

    public void detachFromView() {
        this.penetratedDisplayController.detachFromView();
        for (int i = 0; i < this.platformViews.size(); i++) {
            this.platformViews.valueAt(i).onFlutterViewDetached();
        }
        destroyOverlaySurfaces();
        this.flutterView = null;
        this.flutterViewConvertedToImageView = false;
    }

    public void detachTextInputPlugin() {
        this.textInputPlugin = null;
    }

    @Override // io.flutter.plugin.platform.PlatformViewsAccessibilityDelegate
    public View getPlatformViewById(int i) {
        PlatformView platformViewById = this.penetratedDisplayController.getPlatformViewById(Integer.valueOf(i));
        if (platformViewById != null) {
            return platformViewById.getView();
        }
        PlatformView platformView = this.platformViews.get(i);
        if (platformView == null) {
            return null;
        }
        return platformView.getView();
    }

    public PlatformViewRegistry getRegistry() {
        return this.registry;
    }

    @VisibleForTesting
    void initializePlatformViewIfNeeded(final int i) {
        PlatformView platformView = this.platformViews.get(i);
        if (platformView != null) {
            if (this.platformViewParent.get(i) != null) {
                return;
            }
            if (platformView.getView() != null) {
                if (platformView.getView().getParent() == null) {
                    Context context = this.context;
                    FlutterMutatorView flutterMutatorView = new FlutterMutatorView(context, context.getResources().getDisplayMetrics().density, this.androidTouchProcessor);
                    flutterMutatorView.setOnDescendantFocusChangeListener(new View.OnFocusChangeListener() { // from class: tb.xs1
                        @Override // android.view.View.OnFocusChangeListener
                        public final void onFocusChange(View view, boolean z) {
                            PlatformViewsController.this.lambda$initializePlatformViewIfNeeded$0(i, view, z);
                        }
                    });
                    this.platformViewParent.put(i, flutterMutatorView);
                    flutterMutatorView.addView(platformView.getView());
                    ((FlutterView) this.flutterView).addView(flutterMutatorView);
                    return;
                }
                throw new IllegalStateException("The Android view returned from PlatformView#getView() was already added to a parent view.");
            }
            throw new IllegalStateException("PlatformView#getView() returned null, but an Android view reference was expected.");
        }
        throw new IllegalStateException("Platform view hasn't been initialized from the platform view channel.");
    }

    public void onAttachedToJNI() {
    }

    public void onBeginFrame() {
        this.currentFrameUsedOverlayLayerIds.clear();
        this.currentFrameUsedPlatformViewIds.clear();
        this.penetratedDisplayController.onBeginFrame();
    }

    public void onCancelFrame() {
        this.penetratedDisplayController.onCancelFrame();
    }

    public void onDetachedFromJNI() {
        flushAllViews();
    }

    public void onDisplayOverlaySurface(int i, int i2, int i3, int i4, int i5) {
        if (this.overlayLayerViews.get(i) != null) {
            initializeRootImageViewIfNeeded();
            FlutterImageView flutterImageView = this.overlayLayerViews.get(i);
            if (flutterImageView.getParent() == null) {
                ((FlutterView) this.flutterView).addView(flutterImageView);
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i4, i5);
            layoutParams.leftMargin = i2;
            layoutParams.topMargin = i3;
            flutterImageView.setLayoutParams(layoutParams);
            flutterImageView.setVisibility(0);
            flutterImageView.bringToFront();
            this.currentFrameUsedOverlayLayerIds.add(Integer.valueOf(i));
            return;
        }
        throw new IllegalStateException("The overlay surface (id:" + i + ") doesn't exist");
    }

    public void onDisplayPlatformView(int i, int i2, int i3, int i4, int i5, int i6, int i7, FlutterMutatorsStack flutterMutatorsStack) {
        initializeRootImageViewIfNeeded();
        initializePlatformViewIfNeeded(i);
        FlutterMutatorView flutterMutatorView = this.platformViewParent.get(i);
        flutterMutatorView.readyToDisplay(flutterMutatorsStack, i2, i3, i4, i5);
        flutterMutatorView.setVisibility(0);
        flutterMutatorView.bringToFront();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i6, i7);
        View view = this.platformViews.get(i).getView();
        if (view != null) {
            view.setLayoutParams(layoutParams);
            view.bringToFront();
        }
        this.currentFrameUsedPlatformViewIds.add(Integer.valueOf(i));
    }

    public void onEndFrame() {
        FlutterView flutterView = (FlutterView) this.flutterView;
        boolean z = false;
        if (this.flutterViewConvertedToImageView && this.currentFrameUsedPlatformViewIds.isEmpty()) {
            this.flutterViewConvertedToImageView = false;
            flutterView.revertImageView(new Runnable() { // from class: tb.ys1
                @Override // java.lang.Runnable
                public final void run() {
                    PlatformViewsController.this.lambda$onEndFrame$1();
                }
            });
            return;
        }
        if (this.flutterViewConvertedToImageView && flutterView.acquireLatestImageViewFrame()) {
            z = true;
        }
        finishFrame(z);
    }

    public void onPlatformViewDisplayedUpdated(int i, Rect rect, float f) {
        this.penetratedDisplayController.onPlatformViewDisplayedUpdated(i, rect, f);
    }

    public void onPreEngineRestart() {
        flushAllViews();
    }

    public boolean onSubmitFrame() {
        return this.penetratedDisplayController.onSubmitFrame();
    }

    @VisibleForTesting
    public MotionEvent toMotionEvent(float f, PlatformViewsChannel.PlatformViewTouch platformViewTouch) {
        MotionEvent pop = this.motionEventTracker.pop(MotionEventTracker.MotionEventId.from(platformViewTouch.motionEventId));
        MotionEvent.PointerProperties[] pointerPropertiesArr = (MotionEvent.PointerProperties[]) parsePointerPropertiesList(platformViewTouch.rawPointerPropertiesList).toArray(new MotionEvent.PointerProperties[platformViewTouch.pointerCount]);
        MotionEvent.PointerCoords[] pointerCoordsArr = (MotionEvent.PointerCoords[]) parsePointerCoordsList(platformViewTouch.rawPointerCoords, f).toArray(new MotionEvent.PointerCoords[platformViewTouch.pointerCount]);
        if (pop != null) {
            return MotionEvent.obtain(pop.getDownTime(), pop.getEventTime(), pop.getAction(), platformViewTouch.pointerCount, pointerPropertiesArr, pointerCoordsArr, pop.getMetaState(), pop.getButtonState(), pop.getXPrecision(), pop.getYPrecision(), pop.getDeviceId(), pop.getEdgeFlags(), pop.getSource(), pop.getFlags());
        }
        return MotionEvent.obtain(platformViewTouch.downTime.longValue(), platformViewTouch.eventTime.longValue(), platformViewTouch.action, platformViewTouch.pointerCount, pointerPropertiesArr, pointerCoordsArr, platformViewTouch.metaState, platformViewTouch.buttonState, platformViewTouch.xPrecision, platformViewTouch.yPrecision, platformViewTouch.deviceId, platformViewTouch.edgeFlags, platformViewTouch.source, platformViewTouch.flags);
    }

    @TargetApi(19)
    public FlutterOverlaySurface createOverlaySurface() {
        return createOverlaySurface(new FlutterImageView(this.flutterView.getContext(), this.flutterView.getWidth(), this.flutterView.getHeight(), FlutterImageView.SurfaceKind.overlay));
    }
}
