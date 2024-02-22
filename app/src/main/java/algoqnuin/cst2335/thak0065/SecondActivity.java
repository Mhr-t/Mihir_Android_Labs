package algoqnuin.cst2335.thak0065;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        TextView textviewMain = findViewById(R.id.mainText);
        EditText phoneNumber = findViewById(R.id.editTextPhone);
        Button callButton = findViewById(R.id.callbtn);
        ImageView image = findViewById(R.id.imageView);
        Button imagebtn = findViewById(R.id.imagebtn);

        Intent fromPrevious = getIntent();
        String emailAddress = fromPrevious.getStringExtra("Email Address");
        textviewMain.setText("Welcome back " + emailAddress);

        callButton.setOnClickListener(v -> {
            Intent call = new Intent(Intent.ACTION_DIAL);
            call.setData(Uri.parse("tel:" + phoneNumber.getText().toString()));
            startActivity(call);
        });

        imagebtn.setOnClickListener(v -> {

            Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

            ActivityResultLauncher<Intent> cameraResult = registerForActivityResult(
                    new ActivityResultContracts.StartActivityForResult(),
                    new ActivityResultCallback<ActivityResult>() {
                        @Override
                        public void onActivityResult(ActivityResult result) {
                            if (result.getResultCode() == Activity.RESULT_OK) {

                                Intent data = result.getData();
                                Bitmap thumbnail = data.getParcelableExtra("data");
                                image.setImageBitmap(thumbnail);
                            }
                        }
                    });
            cameraResult.launch(cameraIntent);

        });
    }
}