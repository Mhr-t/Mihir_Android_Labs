package algoqnuin.cst2335.thak0065.ui;


import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import algoqnuin.cst2335.thak0065.data.MainViewModel;
import algoqnuin.cst2335.thak0065.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding variableBinding;
    private MainViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        model = new ViewModelProvider(this).get(MainViewModel.class);

        variableBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(variableBinding.getRoot());

        variableBinding.button.setOnClickListener(click->{

            model.editString.observe(this,s -> {
                variableBinding.textView.setText("your edit text has : "+s);
            });


            model.editString.postValue(variableBinding.myedittext.getText().toString());
        });

        model.isSelected.observe(this,selected->{
            variableBinding.checkbox.setChecked(selected);
            variableBinding.radiobutton.setChecked(selected);
            variableBinding.myswitch.setChecked(selected);

            Toast.makeText(this,
                            "The value is now: " + selected,
                            Toast.LENGTH_SHORT)
                    .show();
        });


        variableBinding.checkbox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            model.isSelected.postValue(isChecked);
        });

        variableBinding.radiobutton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            model.isSelected.postValue(isChecked);
        });
        variableBinding.myswitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            model.isSelected.postValue(isChecked);
        });

        variableBinding.imagebutton.setOnClickListener(v ->{
            Toast.makeText(this,"The width = " + variableBinding.imageview.getWidth() + " and height = "
                    + variableBinding.imageview.getHeight(),Toast.LENGTH_SHORT).show();
        });

    }
}