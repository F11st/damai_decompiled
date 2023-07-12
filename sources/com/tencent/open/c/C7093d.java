package com.tencent.open.c;

import android.content.Context;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import com.tencent.open.log.SLog;
import com.tencent.open.web.security.C7130a;
import com.tencent.open.web.security.SecureJsInterface;

/* compiled from: Taobao */
/* renamed from: com.tencent.open.c.d */
/* loaded from: classes11.dex */
public class C7093d extends C7091b {
    public static boolean a;
    private KeyEvent b;
    private C7130a c;

    public C7093d(Context context) {
        super(context);
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int unicodeChar;
        SLog.d("openSDK_LOG.SecureWebView", "-->dispatchKeyEvent, is device support: " + a);
        if (!a) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 4) {
                if (keyCode != 66) {
                    if (keyCode != 67) {
                        if (keyEvent.getUnicodeChar() == 0) {
                            return super.dispatchKeyEvent(keyEvent);
                        }
                        if (SecureJsInterface.isPWDEdit && (((unicodeChar = keyEvent.getUnicodeChar()) >= 33 && unicodeChar <= 95) || (unicodeChar >= 97 && unicodeChar <= 125))) {
                            KeyEvent keyEvent2 = new KeyEvent(0, 17);
                            this.b = keyEvent2;
                            return super.dispatchKeyEvent(keyEvent2);
                        }
                        return super.dispatchKeyEvent(keyEvent);
                    }
                    C7130a.b = true;
                    return super.dispatchKeyEvent(keyEvent);
                }
                return super.dispatchKeyEvent(keyEvent);
            }
            return super.dispatchKeyEvent(keyEvent);
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.webkit.WebView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        SLog.i("openSDK_LOG.SecureWebView", "-->create input connection, is edit: " + SecureJsInterface.isPWDEdit);
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        SLog.v("openSDK_LOG.SecureWebView", "-->onCreateInputConnection, inputConn is " + onCreateInputConnection);
        if (onCreateInputConnection != null) {
            a = true;
            C7130a c7130a = new C7130a(super.onCreateInputConnection(editorInfo), false);
            this.c = c7130a;
            return c7130a;
        }
        a = false;
        return onCreateInputConnection;
    }

    @Override // android.webkit.WebView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        int unicodeChar;
        SLog.d("openSDK_LOG.SecureWebView", "-->onKeyDown, is device support: " + a);
        if (!a) {
            return super.onKeyDown(i, keyEvent);
        }
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 4) {
                if (keyCode != 66) {
                    if (keyCode != 67) {
                        if (keyEvent.getUnicodeChar() == 0) {
                            return super.onKeyDown(i, keyEvent);
                        }
                        if (SecureJsInterface.isPWDEdit && (((unicodeChar = keyEvent.getUnicodeChar()) >= 33 && unicodeChar <= 95) || (unicodeChar >= 97 && unicodeChar <= 125))) {
                            KeyEvent keyEvent2 = new KeyEvent(0, 17);
                            this.b = keyEvent2;
                            return super.onKeyDown(keyEvent2.getKeyCode(), this.b);
                        }
                        return super.onKeyDown(i, keyEvent);
                    }
                    C7130a.b = true;
                    return super.onKeyDown(i, keyEvent);
                }
                return super.onKeyDown(i, keyEvent);
            }
            return super.onKeyDown(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }
}
