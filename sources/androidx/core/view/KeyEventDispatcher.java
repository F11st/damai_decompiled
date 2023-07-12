package androidx.core.view;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: Taobao */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class KeyEventDispatcher {
    private static boolean sActionBarFieldsFetched;
    private static Method sActionBarOnMenuKeyMethod;
    private static boolean sDialogFieldsFetched;
    private static Field sDialogKeyListenerField;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public interface Component {
        boolean superDispatchKeyEvent(KeyEvent keyEvent);
    }

    private KeyEventDispatcher() {
    }

    private static boolean actionBarOnMenuKeyEventPre28(ActionBar actionBar, KeyEvent keyEvent) {
        if (!sActionBarFieldsFetched) {
            try {
                sActionBarOnMenuKeyMethod = actionBar.getClass().getMethod("onMenuKeyEvent", KeyEvent.class);
            } catch (NoSuchMethodException unused) {
            }
            sActionBarFieldsFetched = true;
        }
        Method method = sActionBarOnMenuKeyMethod;
        if (method != null) {
            try {
                return ((Boolean) method.invoke(actionBar, keyEvent)).booleanValue();
            } catch (IllegalAccessException | InvocationTargetException unused2) {
            }
        }
        return false;
    }

    private static boolean activitySuperDispatchKeyEventPre28(Activity activity, KeyEvent keyEvent) {
        activity.onUserInteraction();
        Window window = activity.getWindow();
        if (window.hasFeature(8)) {
            ActionBar actionBar = activity.getActionBar();
            if (keyEvent.getKeyCode() == 82 && actionBar != null && actionBarOnMenuKeyEventPre28(actionBar, keyEvent)) {
                return true;
            }
        }
        if (window.superDispatchKeyEvent(keyEvent)) {
            return true;
        }
        View decorView = window.getDecorView();
        if (ViewCompat.dispatchUnhandledKeyEventBeforeCallback(decorView, keyEvent)) {
            return true;
        }
        return keyEvent.dispatch(activity, decorView != null ? decorView.getKeyDispatcherState() : null, activity);
    }

    private static boolean dialogSuperDispatchKeyEventPre28(Dialog dialog, KeyEvent keyEvent) {
        DialogInterface.OnKeyListener dialogKeyListenerPre28 = getDialogKeyListenerPre28(dialog);
        if (dialogKeyListenerPre28 == null || !dialogKeyListenerPre28.onKey(dialog, keyEvent.getKeyCode(), keyEvent)) {
            Window window = dialog.getWindow();
            if (window.superDispatchKeyEvent(keyEvent)) {
                return true;
            }
            View decorView = window.getDecorView();
            if (ViewCompat.dispatchUnhandledKeyEventBeforeCallback(decorView, keyEvent)) {
                return true;
            }
            return keyEvent.dispatch(dialog, decorView != null ? decorView.getKeyDispatcherState() : null, dialog);
        }
        return true;
    }

    public static boolean dispatchBeforeHierarchy(@NonNull View view, @NonNull KeyEvent keyEvent) {
        return ViewCompat.dispatchUnhandledKeyEventBeforeHierarchy(view, keyEvent);
    }

    public static boolean dispatchKeyEvent(@NonNull Component component, @Nullable View view, @Nullable Window.Callback callback, @NonNull KeyEvent keyEvent) {
        if (component == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            return component.superDispatchKeyEvent(keyEvent);
        }
        if (callback instanceof Activity) {
            return activitySuperDispatchKeyEventPre28((Activity) callback, keyEvent);
        }
        if (callback instanceof Dialog) {
            return dialogSuperDispatchKeyEventPre28((Dialog) callback, keyEvent);
        }
        return (view != null && ViewCompat.dispatchUnhandledKeyEventBeforeCallback(view, keyEvent)) || component.superDispatchKeyEvent(keyEvent);
    }

    private static DialogInterface.OnKeyListener getDialogKeyListenerPre28(Dialog dialog) {
        if (!sDialogFieldsFetched) {
            try {
                Field declaredField = Dialog.class.getDeclaredField("mOnKeyListener");
                sDialogKeyListenerField = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            sDialogFieldsFetched = true;
        }
        Field field = sDialogKeyListenerField;
        if (field != null) {
            try {
                return (DialogInterface.OnKeyListener) field.get(dialog);
            } catch (IllegalAccessException unused2) {
                return null;
            }
        }
        return null;
    }
}
