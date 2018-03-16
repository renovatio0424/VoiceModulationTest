package com.example.renov.voicemodulationtest;

import android.app.Application;

import net.voicemod.android.voicemodsdk.VoicemodSDK;

/**
 * Created by renov on 2018-03-16.
 */

public class MyAplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        VoicemodSDK.enableDebugMode();
        VoicemodSDK.start(this);
    }
}
