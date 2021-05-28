package com.example.android1;
import android.os.Bundle;

public interface FragmentChanger {
    void changeFragment (String tag, Bundle args, boolean addToBackStack);
}
