package com.alibaba.poplayer.layermanager.view.app;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.util.Log;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.Nullable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class c implements Window.Callback {
    public static final String TAG = c.class.getSimpleName();
    Window.Callback a;
    a b;

    public c(a aVar, Window.Callback callback) {
        this.b = aVar;
        this.a = callback;
    }

    @Override // android.view.Window.Callback
    @SuppressLint({"NewApi"})
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.a.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.a.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.Window.Callback
    @SuppressLint({"NewApi"})
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        Log.d(TAG, "dispatchKeyShortcutEvent ");
        return this.a.dispatchKeyShortcutEvent(keyEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.a.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation(0.0f, -this.b.b());
        if (this.a != null && this.b.a(obtain)) {
            return true;
        }
        return this.a.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.a.dispatchTrackballEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public void onActionModeFinished(ActionMode actionMode) {
        Log.d(TAG, "onActionModeFinished");
        this.a.onActionModeFinished(actionMode);
    }

    @Override // android.view.Window.Callback
    public void onActionModeStarted(ActionMode actionMode) {
        Log.d(TAG, "onActionModeStarted");
        this.a.onActionModeStarted(actionMode);
    }

    @Override // android.view.Window.Callback
    public void onAttachedToWindow() {
        Log.d(TAG, "onAttachedToWindow");
        this.a.onAttachedToWindow();
    }

    @Override // android.view.Window.Callback
    public void onContentChanged() {
        this.a.onContentChanged();
    }

    @Override // android.view.Window.Callback
    public boolean onCreatePanelMenu(int i, Menu menu) {
        return this.a.onCreatePanelMenu(i, menu);
    }

    @Override // android.view.Window.Callback
    public View onCreatePanelView(int i) {
        return this.a.onCreatePanelView(i);
    }

    @Override // android.view.Window.Callback
    public void onDetachedFromWindow() {
        Log.d(TAG, "onDetachedFromWindow");
        this.a.onDetachedFromWindow();
    }

    @Override // android.view.Window.Callback
    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        return this.a.onMenuItemSelected(i, menuItem);
    }

    @Override // android.view.Window.Callback
    public boolean onMenuOpened(int i, Menu menu) {
        return this.a.onMenuOpened(i, menu);
    }

    @Override // android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        Log.d(TAG, "onPanelClosed");
        this.a.onPanelClosed(i, menu);
    }

    @Override // android.view.Window.Callback
    public boolean onPreparePanel(int i, View view, Menu menu) {
        return this.a.onPreparePanel(i, view, menu);
    }

    @Override // android.view.Window.Callback
    public boolean onSearchRequested() {
        Log.d(TAG, "onSearchRequested");
        return this.a.onSearchRequested();
    }

    @Override // android.view.Window.Callback
    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        this.a.onWindowAttributesChanged(layoutParams);
    }

    @Override // android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        if (z) {
            this.b.g();
        } else {
            this.b.c();
        }
        String str = TAG;
        Log.d(str, "onWindowFocusChanged :" + z);
        this.a.onWindowFocusChanged(z);
    }

    @Override // android.view.Window.Callback
    @Nullable
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        Log.d(TAG, "onWindowStartingActionMode");
        return this.a.onWindowStartingActionMode(callback);
    }

    @Override // android.view.Window.Callback
    @TargetApi(23)
    public boolean onSearchRequested(SearchEvent searchEvent) {
        return this.a.onSearchRequested(searchEvent);
    }

    @Override // android.view.Window.Callback
    @Nullable
    @TargetApi(23)
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
        Log.d(TAG, "onWindowStartingActionMode");
        return this.a.onWindowStartingActionMode(callback, i);
    }
}
