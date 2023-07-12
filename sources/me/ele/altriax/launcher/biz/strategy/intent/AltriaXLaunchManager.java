package me.ele.altriax.launcher.biz.strategy.intent;

import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import androidx.annotation.NonNull;
import com.taobao.weex.ui.component.AbstractEditComponent;
import java.lang.reflect.Field;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class AltriaXLaunchManager {
    private static Field messageNextField;
    private static Field messagesField;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private static class Lazy {
        static final AltriaXLaunchManager param = AltriaXLaunchManager.create();

        private Lazy() {
        }
    }

    static {
        try {
            Field declaredField = MessageQueue.class.getDeclaredField("mMessages");
            messagesField = declaredField;
            declaredField.setAccessible(true);
        } catch (Exception unused) {
        }
        try {
            Field declaredField2 = Message.class.getDeclaredField(AbstractEditComponent.ReturnTypes.NEXT);
            messageNextField = declaredField2;
            declaredField2.setAccessible(true);
        } catch (Exception unused2) {
        }
    }

    static AltriaXLaunchManager create() {
        if (Build.VERSION.SDK_INT < 28) {
            return new AltriaXLaunchManagerUnder9();
        }
        return new AltriaXLaunchManager9OrAbove();
    }

    public static AltriaXLaunchContext resolveStartupContext() {
        try {
            for (Message message = (Message) messagesField.get(Looper.myQueue()); message != null; message = (Message) messageNextField.get(message)) {
                AltriaXLaunchContext resolveMessage = Lazy.param.resolveMessage(message);
                if (resolveMessage != null) {
                    return resolveMessage;
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    protected abstract AltriaXLaunchContext resolveMessage(@NonNull Message message);
}
