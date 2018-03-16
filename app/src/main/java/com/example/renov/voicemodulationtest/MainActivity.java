package com.example.renov.voicemodulationtest;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import net.voicemod.android.voicemodsdk.VoicemodSDK;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.spinner_voice_mod)
    Spinner spinnerVoiceMod;
    @BindView(R.id.btn_play)
    Button btnPlay;
//    @BindView(R.id.btn_record_start)
//    Button btnRecordStart;
//    @BindView(R.id.btn_record_stop)
//    Button btnrecordStop;
//    @BindView(R.id.btn_clear)
//    Button btnClear;


    String voiceMod;

    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);

        spinnerVoiceMod.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                voiceMod = (String) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });
    }

    @OnClick(R.id.btn_play)
    public void onClickPlay() {

        String voiceUrl = "file:///android_asset/sample_voice.m4a";
        Uri voiceUri = Uri.parse(voiceUrl);
        VoicemodSDK.convertAudio(voiceUri, voiceMod, new VoicemodSDK.ConvertListener() {
            @Override
            public void onCompleted(String error, Uri uri) {
                if (error == null)
                    Log.d("SUCCESS","voice convert to " + voiceMod + " successfully");
                else
                    Log.e("ERROR", error);
            }
        });
    }

//    @OnClick(R.id.btn_clear)
//    public void onClickClear(){
//        VoicemodSDK.clearRecording();
//    }
//
//    @OnClick(R.id.btn_record_start)
//    public void onClickRecordStart(){
//        VoicemodSDK.startRecording();
//    }
//
//    @OnClick(R.id.btn_record_stop)
//    public void onClickRecordStop(){
//        VoicemodSDK.stopRecording();
//    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}

/**
 * http://s3-ap-northeast-1.amazonaws.com/pesofts-image/voiceChat/20180221/3357241519203621472.m4a
 */
