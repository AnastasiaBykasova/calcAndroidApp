package com.example.lab6_7_2calcTabLayout;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.lab6_7_2calcTabLayout.databinding.FragmentBinding;

public class CalcFragment extends Fragment {
    private static final String LOG_TAG = "MyApp";
    private int pageNumber;

    public static CalcFragment newInstance(int page) {
        CalcFragment fragment = new CalcFragment();
        Bundle args = new Bundle();
        args.putInt("num", page);
        fragment.setArguments(args);
        return fragment;
    }

    public interface onInputEventListener {
        public void inputEvent(String unit, double weight);
    }
    onInputEventListener inputEventListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            inputEventListener = (onInputEventListener) context;
        }
        catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement on-inputEventListener");
        }
    }

    private FragmentBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        binding.btnConvert.setEnabled(false);

        binding.enterMass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkButtonAvailability();
            }
            @Override
            public void afterTextChanged(Editable s) {}
        });

        RadioGroup radioGroup = binding.radioGroup;
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                checkButtonAvailability();
            }
        });

        binding.btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isNumeric(getWeight())) {
//                    Log.d(LOG_TAG, "Кнопка нажата");
                    double weight = Double.parseDouble(getWeight());
                    inputEventListener.inputEvent(getUnit(), weight);
                }

            }
        });

        binding.btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.enterMass.setText("");
                binding.radioGroup.clearCheck();
            }
        });

        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageNumber = getArguments() != null ? getArguments().getInt("num") : 1;
    }


    private void checkButtonAvailability() {
        String enteredText = binding.enterMass.getText().toString();
        binding.btnConvert.setEnabled(!enteredText.isEmpty() && binding.radioGroup.getCheckedRadioButtonId() != -1);
    }

    private String getWeight() {
        String enteredText = binding.enterMass.getText().toString();

        return enteredText;
    }

    private String getUnit() {
        int selectedId = binding.radioGroup.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = binding.getRoot().findViewById(selectedId);
        String selectedValue = selectedRadioButton.getText().toString();

        return selectedValue;
    }

    public boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }
}