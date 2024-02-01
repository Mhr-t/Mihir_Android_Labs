package algoqnuin.cst2335.thak0065.data;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView helloTextView = findViewById(R.id.helloTextView);
        helloTextView.setText("Hello, World!");
    }
}
