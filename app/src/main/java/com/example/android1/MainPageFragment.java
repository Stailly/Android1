package com.example.android1;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MainPageFragment extends Fragment {
    FragmentChanger fragmentChanger;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_page, container, false);
        final EditText cityEditText =  view.findViewById(R.id.enter_city);
        final Switch pressure = view.findViewById(R.id.show_pressure);
        final Switch windSpeed = view.findViewById(R.id.show_wind);
        Button button = view.findViewById(R.id.button_add);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle args = new Bundle();
                args.putString("city", cityEditText.getText().toString());
                args.putBoolean("Pressure", pressure.isChecked());
                args.putBoolean("Wind", windSpeed.isChecked());
                fragmentChanger.changeFragment("Weather", args, true);
            }
        });
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof FragmentChanger)
            fragmentChanger = (FragmentChanger) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        fragmentChanger = null;

    }
}
