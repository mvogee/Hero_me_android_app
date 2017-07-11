package com.matthewvogee.herome.Activities;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentController;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.matthewvogee.herome.Fragments.BackStoryFragment;
import com.matthewvogee.herome.Fragments.MainFragment;
import com.matthewvogee.herome.Fragments.PickPowerFragment;
import com.matthewvogee.herome.R;

public class MainActivity extends AppCompatActivity implements MainFragment.MainFragmentInteractionListener,
        PickPowerFragment.PickOnFragmentInteractionListener, BackStoryFragment.StoryOnFragmentInteractionListener {

    public enum powersAcquired{
        ACCIDENT,
        GENETICMUTATION,
        BORNWITH
    }
    public enum powerType {
        TURTLEPOWERS,
        FLIGHT,
        LIGHTNING,
        WEBSLINGING,
        LASERVISION,
        SUPERSTRENGTH
    }

    static powerType type;
    static powersAcquired acquired;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager manager = getSupportFragmentManager();
        Fragment fragment = manager.findFragmentById(R.id.fragment_container);
        if (fragment == null) {
            fragment = new MainFragment();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.add(R.id.fragment_container, fragment);
            transaction.commit();
        }
    }

    public void setType(powerType type) {
        this.type = type;
    }
    public void setAcquired(powersAcquired method) {
        this.acquired = method;
    }
    public powerType getType() {
        return type;
    }
    public powersAcquired getAcquired() {
        return acquired;
    }

    @Override
    public void onMainFragmentInteraction(Uri uri) {

    }

    @Override
    public void onPickPowerFragmentInteraction(Uri uri) {

    }

    @Override
    public void onBackStoryFragmentInteraction(Uri uri) {

    }

    public void loadPickPowerFragment() {
        PickPowerFragment pickPowerFragment = new PickPowerFragment();
        this.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, pickPowerFragment).addToBackStack(null).commit();
    }

    public void loadBackstoryFragment() {
        BackStoryFragment backStoryFragment = new BackStoryFragment();
        this.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, backStoryFragment).addToBackStack(null).commit();
    }
}
