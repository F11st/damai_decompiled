package io.flutter.embedding.android;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.Log;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class FlutterSplashView extends FrameLayout {
    private static String TAG = "FlutterSplashView";
    @NonNull
    private final FlutterView.FlutterEngineAttachmentListener flutterEngineAttachmentListener;
    @NonNull
    private final FlutterUiDisplayListener flutterUiDisplayListener;
    @Nullable
    private FlutterView flutterView;
    @NonNull
    private final Runnable onTransitionComplete;
    @Nullable
    private String previousCompletedSplashIsolate;
    @Nullable
    private SplashScreen splashScreen;
    @Nullable
    private Bundle splashScreenState;
    @Nullable
    private View splashScreenView;
    @Nullable
    private String transitioningIsolateId;

    /* compiled from: Taobao */
    @Keep
    /* loaded from: classes3.dex */
    public static class SavedState extends View.BaseSavedState {
        public static Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: io.flutter.embedding.android.FlutterSplashView.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        private String previousCompletedSplashIsolate;
        private Bundle splashScreenState;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.previousCompletedSplashIsolate);
            parcel.writeBundle(this.splashScreenState);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.previousCompletedSplashIsolate = parcel.readString();
            this.splashScreenState = parcel.readBundle(getClass().getClassLoader());
        }
    }

    public FlutterSplashView(@NonNull Context context) {
        this(context, null, 0);
    }

    private boolean hasSplashCompleted() {
        FlutterView flutterView = this.flutterView;
        if (flutterView != null) {
            if (flutterView.isAttachedToFlutterEngine()) {
                return this.flutterView.getAttachedFlutterEngine().getDartExecutor().getIsolateServiceId() != null && this.flutterView.getAttachedFlutterEngine().getDartExecutor().getIsolateServiceId().equals(this.previousCompletedSplashIsolate);
            }
            throw new IllegalStateException("Cannot determine if splash has completed when no FlutterEngine is attached to our FlutterView. This question depends on an isolate ID to differentiate Flutter experiences.");
        }
        throw new IllegalStateException("Cannot determine if splash has completed when no FlutterView is set.");
    }

    private boolean isSplashScreenNeededNow() {
        FlutterView flutterView = this.flutterView;
        return (flutterView == null || !flutterView.isAttachedToFlutterEngine() || this.flutterView.hasRenderedFirstFrame() || hasSplashCompleted()) ? false : true;
    }

    private boolean isSplashScreenTransitionNeededNow() {
        SplashScreen splashScreen;
        FlutterView flutterView = this.flutterView;
        return flutterView != null && flutterView.isAttachedToFlutterEngine() && (splashScreen = this.splashScreen) != null && splashScreen.doesSplashViewRememberItsTransition() && wasPreviousSplashTransitionInterrupted();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void transitionToFlutter() {
        this.transitioningIsolateId = this.flutterView.getAttachedFlutterEngine().getDartExecutor().getIsolateServiceId();
        String str = TAG;
        Log.v(str, "Transitioning splash screen to a Flutter UI. Isolate: " + this.transitioningIsolateId);
        this.splashScreen.transitionToFlutter(this.onTransitionComplete);
    }

    private boolean wasPreviousSplashTransitionInterrupted() {
        FlutterView flutterView = this.flutterView;
        if (flutterView != null) {
            if (flutterView.isAttachedToFlutterEngine()) {
                return this.flutterView.hasRenderedFirstFrame() && !hasSplashCompleted();
            }
            throw new IllegalStateException("Cannot determine if previous splash transition was interrupted when no FlutterEngine is attached to our FlutterView. This question depends on an isolate ID to differentiate Flutter experiences.");
        }
        throw new IllegalStateException("Cannot determine if previous splash transition was interrupted when no FlutterView is set.");
    }

    public void displayFlutterViewWithSplash(@NonNull FlutterView flutterView, @Nullable SplashScreen splashScreen) {
        FlutterView flutterView2 = this.flutterView;
        if (flutterView2 != null) {
            flutterView2.removeOnFirstFrameRenderedListener(this.flutterUiDisplayListener);
            removeView(this.flutterView);
        }
        View view = this.splashScreenView;
        if (view != null) {
            removeView(view);
        }
        this.flutterView = flutterView;
        addView(flutterView);
        this.splashScreen = splashScreen;
        if (splashScreen != null) {
            if (isSplashScreenNeededNow()) {
                Log.v(TAG, "Showing splash screen UI.");
                View createSplashView = splashScreen.createSplashView(getContext(), this.splashScreenState);
                this.splashScreenView = createSplashView;
                addView(createSplashView);
                flutterView.addOnFirstFrameRenderedListener(this.flutterUiDisplayListener);
            } else if (isSplashScreenTransitionNeededNow()) {
                Log.v(TAG, "Showing an immediate splash transition to Flutter due to previously interrupted transition.");
                View createSplashView2 = splashScreen.createSplashView(getContext(), this.splashScreenState);
                this.splashScreenView = createSplashView2;
                addView(createSplashView2);
                transitionToFlutter();
            } else if (flutterView.isAttachedToFlutterEngine()) {
            } else {
                Log.v(TAG, "FlutterView is not yet attached to a FlutterEngine. Showing nothing until a FlutterEngine is attached.");
                flutterView.addFlutterEngineAttachmentListener(this.flutterEngineAttachmentListener);
            }
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.previousCompletedSplashIsolate = savedState.previousCompletedSplashIsolate;
        this.splashScreenState = savedState.splashScreenState;
    }

    @Override // android.view.View
    @Nullable
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.previousCompletedSplashIsolate = this.previousCompletedSplashIsolate;
        SplashScreen splashScreen = this.splashScreen;
        savedState.splashScreenState = splashScreen != null ? splashScreen.saveSplashScreenState() : null;
        return savedState;
    }

    public FlutterSplashView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlutterSplashView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.flutterEngineAttachmentListener = new FlutterView.FlutterEngineAttachmentListener() { // from class: io.flutter.embedding.android.FlutterSplashView.1
            @Override // io.flutter.embedding.android.FlutterView.FlutterEngineAttachmentListener
            public void onFlutterEngineAttachedToFlutterView(@NonNull FlutterEngine flutterEngine) {
                FlutterSplashView.this.flutterView.removeFlutterEngineAttachmentListener(this);
                FlutterSplashView flutterSplashView = FlutterSplashView.this;
                flutterSplashView.displayFlutterViewWithSplash(flutterSplashView.flutterView, FlutterSplashView.this.splashScreen);
            }

            @Override // io.flutter.embedding.android.FlutterView.FlutterEngineAttachmentListener
            public void onFlutterEngineDetachedFromFlutterView() {
            }
        };
        this.flutterUiDisplayListener = new FlutterUiDisplayListener() { // from class: io.flutter.embedding.android.FlutterSplashView.2
            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiDisplayed() {
                if (FlutterSplashView.this.splashScreen != null) {
                    FlutterSplashView.this.transitionToFlutter();
                }
            }

            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiNoLongerDisplayed() {
            }
        };
        this.onTransitionComplete = new Runnable() { // from class: io.flutter.embedding.android.FlutterSplashView.3
            @Override // java.lang.Runnable
            public void run() {
                FlutterSplashView flutterSplashView = FlutterSplashView.this;
                flutterSplashView.removeView(flutterSplashView.splashScreenView);
                FlutterSplashView flutterSplashView2 = FlutterSplashView.this;
                flutterSplashView2.previousCompletedSplashIsolate = flutterSplashView2.transitioningIsolateId;
            }
        };
        setSaveEnabled(true);
    }
}
