package com.gladysinc.gladys;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;

import com.gladysinc.gladys.CustomIntroFragment.ConfigIntroFragment;

import agency.tango.materialintroscreen.MaterialIntroActivity;
import agency.tango.materialintroscreen.SlideFragmentBuilder;

public class IntroActivity extends MaterialIntroActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addSlide(new SlideFragmentBuilder()
                .backgroundColor(R.color.colorPrimaryDark)
                .buttonsColor(R.color.colorAccent)
                .image(R.mipmap.ic_launcher_foreground)
                .title(getApplicationContext().getString(R.string.app_name))
                .description(getApplicationContext().getString(R.string.app_description))
                .build());

        addSlide(new SlideFragmentBuilder()
                .backgroundColor(R.color.colorPrimaryDark)
                .buttonsColor(R.color.colorAccent)
                .image(R.drawable.img_dashboard)
                .title(getApplicationContext().getString(R.string.dashboard))
                .description(getApplicationContext().getString(R.string.dashboard_description))
                .build());

        addSlide(new SlideFragmentBuilder()
                .backgroundColor(R.color.colorPrimaryDark)
                .buttonsColor(R.color.colorAccent)
                .image(R.drawable.img_map)
                .title(getApplicationContext().getString(R.string.and_more))
                .description(getApplicationContext().getString(R.string.app_functionalities_description))
                .build());

        addSlide(new ConfigIntroFragment());

    }

    @Override
    public void onFinish() {
        super.onFinish();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor edit = prefs.edit();
        edit.putBoolean("intro", true);
        edit.apply();

        Intent intent = new Intent(IntroActivity.this, MainActivity.class);
        startActivity(intent);
    }
}