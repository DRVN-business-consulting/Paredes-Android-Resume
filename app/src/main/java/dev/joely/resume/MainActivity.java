package dev.joely.resume;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    boolean shouldBeImmovalbe = true;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        CheckBox checkBoxLineOfWork = findViewById(R.id.checkBoxLineOfWork);
        CheckBox checkBoxSkills = findViewById(R.id.checkBoxSkills);
        CheckBox checkBoxAchievement = findViewById(R.id.checkBoxAchievement);
        final LinearLayout works = findViewById(R.id.Works);
        final LinearLayout skills = findViewById(R.id.Skills);
        final LinearLayout Achievement = findViewById(R.id.Achievement);


        SeekBar seekBarJava = findViewById(R.id.SeekBarJava);
        SeekBar seekBarJavaScript = findViewById(R.id.SeekBarJavaScript);
        SeekBar seekBarPython = findViewById(R.id.SeekBarPython);


        makeSeekBarImmovalbe(seekBarJava);
        makeSeekBarImmovalbe(seekBarJavaScript);
        makeSeekBarImmovalbe(seekBarPython);


        works.setVisibility(checkBoxLineOfWork.isChecked() ? View.VISIBLE : View.GONE);
        skills.setVisibility(checkBoxSkills.isChecked() ? View.VISIBLE : View.GONE);
        Achievement.setVisibility(checkBoxAchievement.isChecked() ? View.VISIBLE : View.GONE);


        checkBoxLineOfWork.setOnCheckedChangeListener((buttonView, isChecked) -> {
            works.setVisibility(isChecked ? View.VISIBLE : View.GONE);
        });

        checkBoxSkills.setOnCheckedChangeListener((buttonView, isChecked) -> {
            skills.setVisibility(isChecked ? View.VISIBLE : View.GONE);
        });

        checkBoxAchievement.setOnCheckedChangeListener((buttonView, isChecked) -> {
            Achievement.setVisibility(isChecked ? View.VISIBLE : View.GONE);
        });
    }

    private void makeSeekBarImmovalbe(SeekBar seekBar) {
        if (shouldBeImmovalbe) {
            seekBar.setOnTouchListener((v, event) -> true);
        } else {
            seekBar.setOnTouchListener(null);
        }
    }
}
