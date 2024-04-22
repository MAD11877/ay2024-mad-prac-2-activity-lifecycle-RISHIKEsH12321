package sg.edu.np.mad.madpractical2;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        User user = new User("John Doe", "MAD Dev", 1, false);
        TextView tvName = findViewById(R.id.promt);
        TextView tvDes = findViewById(R.id.lorem);
        Button btnFollow = findViewById(R.id.button1);

        btnFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(user.followed){
                    btnFollow.setText("Unfollow");
                    user.followed = false;
                }
                else{
                    btnFollow.setText("Follow");
                    user.followed = true;
                }
            }
        });

        tvName.setText(user.name);
        tvDes.setText(user.description);

    }

}