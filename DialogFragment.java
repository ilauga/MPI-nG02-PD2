package lv.lauris.pd2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DialogFragment extends androidx.fragment.app.DialogFragment {

    private CheckBox member1, member2, member3;
    private Button closeButton, okButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_fragment, container, false);

        member1 = view.findViewById(R.id.member1);
        member2 = view.findViewById(R.id.member2);
        member3 = view.findViewById(R.id.member3);
        closeButton = view.findViewById(R.id.close);
        okButton = view.findViewById(R.id.ok);

        member1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(getActivity(), "Ieva Lauga checked", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), "Ieva Lauga unchecked", Toast.LENGTH_SHORT).show();
                }
            }
        });
        member2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(getActivity(), "Kristaps Josts checked", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), "Kristaps Josts unchecked", Toast.LENGTH_SHORT).show();
                }
            }
        });
        member3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(getActivity(), "Lauris Miķelsons checked", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), "Lauris Miķelsons unchecked", Toast.LENGTH_SHORT).show();
                }
            }
        });

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "You clicked OK", Toast.LENGTH_SHORT).show();
            }
        });
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "You closed dialog", Toast.LENGTH_SHORT).show();
                getDialog().dismiss();
            }
        });

        return view;
    }
}
