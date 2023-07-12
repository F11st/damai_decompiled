package com.taobao.weex.ui.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.VideoView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.taobao.weex.ui.view.gesture.WXGesture;
import com.taobao.weex.ui.view.gesture.WXGestureObservable;
import com.taobao.weex.utils.WXResourceUtils;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WXVideoView extends VideoView implements WXGestureObservable {
    private VideoPlayListener mVideoPauseListener;
    private WXGesture wxGesture;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface VideoPlayListener {
        void onPause();

        void onStart();
    }

    public WXVideoView(Context context) {
        super(context);
    }

    @Override // com.taobao.weex.ui.view.gesture.WXGestureObservable
    public WXGesture getGestureListener() {
        return this.wxGesture;
    }

    @Override // android.widget.VideoView, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        WXGesture wXGesture = this.wxGesture;
        return wXGesture != null ? onTouchEvent | wXGesture.onTouch(this, motionEvent) : onTouchEvent;
    }

    @Override // android.widget.VideoView, android.widget.MediaController.MediaPlayerControl
    public void pause() {
        super.pause();
        VideoPlayListener videoPlayListener = this.mVideoPauseListener;
        if (videoPlayListener != null) {
            videoPlayListener.onPause();
        }
    }

    @Override // com.taobao.weex.ui.view.gesture.WXGestureObservable
    public void registerGestureListener(WXGesture wXGesture) {
        this.wxGesture = wXGesture;
    }

    public void setOnVideoPauseListener(VideoPlayListener videoPlayListener) {
        this.mVideoPauseListener = videoPlayListener;
    }

    @Override // android.widget.VideoView, android.widget.MediaController.MediaPlayerControl
    public void start() {
        super.start();
        VideoPlayListener videoPlayListener = this.mVideoPauseListener;
        if (videoPlayListener != null) {
            videoPlayListener.onStart();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class Wrapper extends FrameLayout implements ViewTreeObserver.OnGlobalLayoutListener {
        private boolean mControls;
        private MediaController mMediaController;
        private MediaPlayer.OnCompletionListener mOnCompletionListener;
        private MediaPlayer.OnErrorListener mOnErrorListener;
        private MediaPlayer.OnPreparedListener mOnPreparedListener;
        private ProgressBar mProgressBar;
        private Uri mUri;
        private VideoPlayListener mVideoPlayListener;
        private WXVideoView mVideoView;

        public Wrapper(Context context) {
            super(context);
            this.mControls = true;
            init(context);
        }

        private synchronized void createVideoView() {
            if (this.mVideoView != null) {
                return;
            }
            Context context = getContext();
            WXVideoView wXVideoView = new WXVideoView(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            wXVideoView.setLayoutParams(layoutParams);
            addView(wXVideoView, 0);
            wXVideoView.setOnErrorListener(this.mOnErrorListener);
            wXVideoView.setOnPreparedListener(this.mOnPreparedListener);
            wXVideoView.setOnCompletionListener(this.mOnCompletionListener);
            wXVideoView.setOnVideoPauseListener(this.mVideoPlayListener);
            MediaController mediaController = new MediaController(context);
            mediaController.setAnchorView(this);
            wXVideoView.setMediaController(mediaController);
            mediaController.setMediaPlayer(wXVideoView);
            if (!this.mControls) {
                mediaController.setVisibility(8);
            } else {
                mediaController.setVisibility(0);
            }
            this.mMediaController = mediaController;
            this.mVideoView = wXVideoView;
            wXVideoView.setZOrderOnTop(true);
            Uri uri = this.mUri;
            if (uri != null) {
                setVideoURI(uri);
            }
        }

        private void init(Context context) {
            setBackgroundColor(WXResourceUtils.getColor("#ee000000"));
            this.mProgressBar = new ProgressBar(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            this.mProgressBar.setLayoutParams(layoutParams);
            layoutParams.gravity = 17;
            addView(this.mProgressBar);
            getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        @SuppressLint({"NewApi"})
        private void removeSelfFromViewTreeObserver() {
            if (Build.VERSION.SDK_INT >= 16) {
                getViewTreeObserver().removeOnGlobalLayoutListener(this);
            } else {
                getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        }

        @NonNull
        public WXVideoView createIfNotExist() {
            if (this.mVideoView == null) {
                createVideoView();
            }
            return this.mVideoView;
        }

        public boolean createVideoViewIfVisible() {
            Rect rect = new Rect();
            if (this.mVideoView != null) {
                return true;
            }
            if (!getGlobalVisibleRect(rect) || rect.isEmpty()) {
                return false;
            }
            createVideoView();
            return true;
        }

        @Nullable
        public MediaController getMediaController() {
            return this.mMediaController;
        }

        public ProgressBar getProgressBar() {
            return this.mProgressBar;
        }

        @Nullable
        public WXVideoView getVideoView() {
            return this.mVideoView;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (createVideoViewIfVisible()) {
                removeSelfFromViewTreeObserver();
            }
        }

        public void pause() {
            WXVideoView wXVideoView = this.mVideoView;
            if (wXVideoView != null) {
                wXVideoView.pause();
            }
        }

        public void resume() {
            WXVideoView wXVideoView = this.mVideoView;
            if (wXVideoView != null) {
                wXVideoView.resume();
            }
        }

        public void setControls(boolean z) {
            MediaController mediaController;
            this.mControls = z;
            if (this.mVideoView == null || (mediaController = this.mMediaController) == null) {
                return;
            }
            if (!z) {
                mediaController.setVisibility(8);
            } else {
                mediaController.setVisibility(0);
            }
        }

        public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
            this.mOnCompletionListener = onCompletionListener;
            WXVideoView wXVideoView = this.mVideoView;
            if (wXVideoView != null) {
                wXVideoView.setOnCompletionListener(onCompletionListener);
            }
        }

        public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
            this.mOnErrorListener = onErrorListener;
            WXVideoView wXVideoView = this.mVideoView;
            if (wXVideoView != null) {
                wXVideoView.setOnErrorListener(onErrorListener);
            }
        }

        public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
            this.mOnPreparedListener = onPreparedListener;
            WXVideoView wXVideoView = this.mVideoView;
            if (wXVideoView != null) {
                wXVideoView.setOnPreparedListener(onPreparedListener);
            }
        }

        public void setOnVideoPauseListener(VideoPlayListener videoPlayListener) {
            this.mVideoPlayListener = videoPlayListener;
            WXVideoView wXVideoView = this.mVideoView;
            if (wXVideoView != null) {
                wXVideoView.setOnVideoPauseListener(videoPlayListener);
            }
        }

        public void setVideoURI(Uri uri) {
            this.mUri = uri;
            WXVideoView wXVideoView = this.mVideoView;
            if (wXVideoView != null) {
                wXVideoView.setVideoURI(uri);
            }
        }

        public void start() {
            WXVideoView wXVideoView = this.mVideoView;
            if (wXVideoView != null) {
                wXVideoView.start();
            }
        }

        public void stopPlayback() {
            WXVideoView wXVideoView = this.mVideoView;
            if (wXVideoView != null) {
                wXVideoView.stopPlayback();
            }
        }

        public Wrapper(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.mControls = true;
            init(context);
        }

        public Wrapper(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.mControls = true;
            init(context);
        }
    }
}
