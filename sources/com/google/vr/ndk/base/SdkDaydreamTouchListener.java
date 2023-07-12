package com.google.vr.ndk.base;

import android.content.Context;
import android.os.AsyncTask;
import android.os.RemoteException;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import com.google.common.logging.nano.Vr$VREvent;
import com.google.vr.cardboard.VrParamsProvider;
import com.google.vr.sdk.proto.nano.CardboardDevice;
import com.google.vr.sdk.proto.nano.Phone;
import com.google.vr.vrcore.logging.api.VREventParcelable;
import tb.az2;
import tb.ga0;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class SdkDaydreamTouchListener extends AbstractDaydreamTouchListener implements View.OnTouchListener {
    private final GvrApi gvrApi;
    private final GvrLayoutImpl gvrLayout;
    private final boolean isDaydreamImageAlignmentEnabled;
    private final VrParamsProvider vrParamsProvider;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    class FinishInitilizationTask extends AsyncTask<Void, Void, Phone.PhoneParams> {
        public Display display;

        private FinishInitilizationTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onProgressUpdate(Void... voidArr) {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Phone.PhoneParams doInBackground(Void... voidArr) {
            return SdkDaydreamTouchListener.this.vrParamsProvider.readPhoneParams();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Phone.PhoneParams phoneParams) {
            SdkDaydreamTouchListener.this.init(ga0.d(this.display, phoneParams), phoneParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public class RefreshViewerProfileTask extends AsyncTask<Void, Void, CardboardDevice.DeviceParams> {
        private RefreshViewerProfileTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onProgressUpdate(Void... voidArr) {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public CardboardDevice.DeviceParams doInBackground(Void... voidArr) {
            return SdkDaydreamTouchListener.this.vrParamsProvider.readDeviceParams();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(CardboardDevice.DeviceParams deviceParams) {
            SdkDaydreamTouchListener.this.setDeviceParams(deviceParams);
        }
    }

    public SdkDaydreamTouchListener(GvrLayoutImpl gvrLayoutImpl) {
        this.gvrLayout = gvrLayoutImpl;
        GvrApi gvrApi = gvrLayoutImpl.getGvrApi();
        this.gvrApi = gvrApi;
        boolean z = true;
        this.isDaydreamImageAlignmentEnabled = (gvrApi.getSdkConfigurationParams().daydreamImageAlignment.intValue() == 1 || gvrApi.getSdkConfigurationParams().touchOverlayEnabled.booleanValue()) ? false : false;
        Context context = gvrLayoutImpl.getContext();
        this.vrParamsProvider = az2.a(context);
        FinishInitilizationTask finishInitilizationTask = new FinishInitilizationTask();
        finishInitilizationTask.display = ga0.b(context);
        finishInitilizationTask.execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void init(DisplayMetrics displayMetrics, Phone.PhoneParams phoneParams) {
        initWithPhoneParams(displayMetrics, phoneParams);
        refreshViewerProfile();
    }

    @Override // com.google.vr.ndk.base.AbstractDaydreamTouchListener
    protected boolean isDaydreamImageAlignmentEnabled() {
        return this.isDaydreamImageAlignmentEnabled;
    }

    @Override // com.google.vr.ndk.base.AbstractDaydreamTouchListener
    protected void logEvent(int i, Vr$VREvent vr$VREvent) {
        if (this.gvrLayout.getVrCoreSdkClient() != null && this.gvrLayout.getVrCoreSdkClient().getLoggingService() != null) {
            try {
                this.gvrLayout.getVrCoreSdkClient().getLoggingService().log(new VREventParcelable(2012, vr$VREvent));
                return;
            } catch (RemoteException unused) {
                Log.w("SdkDaydreamTouchListener", "Unable to log alignment event");
                return;
            }
        }
        Log.w("SdkDaydreamTouchListener", "Unable to log alignment event; logging service not available.");
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return handleTouch(motionEvent, 0.0f, 0.0f);
    }

    public void refreshViewerProfile() {
        new RefreshViewerProfileTask().execute(new Void[0]);
    }

    @Override // com.google.vr.ndk.base.AbstractDaydreamTouchListener
    protected void setLensOffset(float f, float f2, float f3) {
        this.gvrApi.setLensOffset(f, f2, 0.0f);
    }

    public void shutdown() {
        this.vrParamsProvider.close();
    }
}
