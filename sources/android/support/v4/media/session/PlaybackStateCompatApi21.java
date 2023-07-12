package android.support.v4.media.session;

import android.media.session.PlaybackState;
import android.os.Bundle;
import androidx.annotation.RequiresApi;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
@RequiresApi(21)
/* loaded from: classes12.dex */
class PlaybackStateCompatApi21 {

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    static final class CustomAction {
        private CustomAction() {
        }

        public static String getAction(Object obj) {
            return ((PlaybackState.CustomAction) obj).getAction();
        }

        public static Bundle getExtras(Object obj) {
            return ((PlaybackState.CustomAction) obj).getExtras();
        }

        public static int getIcon(Object obj) {
            return ((PlaybackState.CustomAction) obj).getIcon();
        }

        public static CharSequence getName(Object obj) {
            return ((PlaybackState.CustomAction) obj).getName();
        }

        public static Object newInstance(String str, CharSequence charSequence, int i, Bundle bundle) {
            PlaybackState.CustomAction.Builder builder = new PlaybackState.CustomAction.Builder(str, charSequence, i);
            builder.setExtras(bundle);
            return builder.build();
        }
    }

    private PlaybackStateCompatApi21() {
    }

    public static long getActions(Object obj) {
        return ((PlaybackState) obj).getActions();
    }

    public static long getActiveQueueItemId(Object obj) {
        return ((PlaybackState) obj).getActiveQueueItemId();
    }

    public static long getBufferedPosition(Object obj) {
        return ((PlaybackState) obj).getBufferedPosition();
    }

    public static List<Object> getCustomActions(Object obj) {
        return ((PlaybackState) obj).getCustomActions();
    }

    public static CharSequence getErrorMessage(Object obj) {
        return ((PlaybackState) obj).getErrorMessage();
    }

    public static long getLastPositionUpdateTime(Object obj) {
        return ((PlaybackState) obj).getLastPositionUpdateTime();
    }

    public static float getPlaybackSpeed(Object obj) {
        return ((PlaybackState) obj).getPlaybackSpeed();
    }

    public static long getPosition(Object obj) {
        return ((PlaybackState) obj).getPosition();
    }

    public static int getState(Object obj) {
        return ((PlaybackState) obj).getState();
    }

    public static Object newInstance(int i, long j, long j2, float f, long j3, CharSequence charSequence, long j4, List<Object> list, long j5) {
        PlaybackState.Builder builder = new PlaybackState.Builder();
        builder.setState(i, j, f, j4);
        builder.setBufferedPosition(j2);
        builder.setActions(j3);
        builder.setErrorMessage(charSequence);
        Iterator<Object> it = list.iterator();
        while (it.hasNext()) {
            builder.addCustomAction((PlaybackState.CustomAction) it.next());
        }
        builder.setActiveQueueItemId(j5);
        return builder.build();
    }
}
