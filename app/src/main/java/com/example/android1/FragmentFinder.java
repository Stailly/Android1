package com.example.android1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class FragmentFinder {
    public static Fragment findFragment (String tag, Bundle args, FragmentManager fragmentManager) {
        Fragment fragment = fragmentManager.findFragmentByTag(tag);
        if (fragment == null) {
            return null;
        }
        fragment.setArguments(args);
        return fragment;
    }
}
