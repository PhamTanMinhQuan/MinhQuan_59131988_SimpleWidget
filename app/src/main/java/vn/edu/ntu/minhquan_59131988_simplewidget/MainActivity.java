package vn.edu.ntu.minhquan_59131988_simplewidget;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    String textConfirm;
    EditText name, date, otherHobbies;
    RadioGroup rdgGender;
    CheckBox checkFilm, checkMusic, checkCafe, checkAlone, checkCook;
    Button btnConfirm;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addView();
        addEvents();
    }
    private void addView(){
        name = findViewById(R.id.editName);
        date = findViewById(R.id.editDate);
        rdgGender = findViewById(R.id.rdgGender);
        checkFilm = findViewById(R.id.checkFilm);
        checkMusic = findViewById(R.id.checkMusic);
        checkCafe = findViewById(R.id.checkCafe);
        checkAlone = findViewById(R.id.checkAlone);
        checkCook = findViewById(R.id.checkCook);
        otherHobbies = findViewById(R.id.txtOtherHobbies);
        btnConfirm = findViewById(R.id.btnConfirm);
    }
    private void addEvents(){
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getInformation();
            }
        });
    }
    private void getInformation(){
        textConfirm = name.getText().toString() + "\n" +
                "Ngày sinh: " + date.getText().toString() + "\n" +
                "Giới tính: ";
        if (rdgGender.getCheckedRadioButtonId() == R.id.btnMale)
            textConfirm += "Nam" + "\n" + "Sở thích: ";
        else
            textConfirm += "Nữ" + "\n" + "Sở thích: ";

        if (checkFilm.isChecked()){
            textConfirm += "Xem phim; ";
        }
        if (checkMusic.isChecked()){
            textConfirm += "Nghe nhac; ";
        }
        if (checkCafe.isChecked()){
            textConfirm += "Đi cafe với bạn bè";
        }
        if (checkAlone.isChecked()){
            textConfirm += "Ở nhà một mình; ";
        }
        if (checkCook.isChecked()){
            textConfirm += "Vào bếp nấu ăn; ";
        }
        textConfirm += otherHobbies.getText().toString();

        Toast.makeText(getApplicationContext(), textConfirm, Toast.LENGTH_LONG).show();
    }
}
