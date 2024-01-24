package algoqnuin.cst2335.thak0065.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import algoqnuin.cst2335.thak0065.data.MainViewModel;
import algoqnuin.cst2335.thak0065.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private MainViewModel model;

    private ActivityMainBinding variableBinding;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize ViewModel
        model = new ViewModelProvider(this).get(MainViewModel.class);

        // Set up View Binding
        variableBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(variableBinding.getRoot());

        // Display the value of model.editString in TextView
        variableBinding.textView.setText(model.EditString());



        // Using Lambda Function for setOnClickListener
        variableBinding.button.setOnClickListener(v -> {
            // Get text from EditText and set it in ViewModel
            String editString = variableBinding.myedit.getText().toString();
            model.setEditString(editString);

            // Update TextView with the new editString value
            variableBinding.mytext.setText("Your edit text has: " + model.getEditString());
        });
    }
}
