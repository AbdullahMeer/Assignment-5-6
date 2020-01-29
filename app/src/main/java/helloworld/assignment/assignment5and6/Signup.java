package helloworld.assignment.assignment5and6;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Context;

public class Signup extends AppCompatActivity {
    DatabaseHelper db;
    EditText FirstName,LastName,Email,Password,ConformPassword;
    Button NextScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);



        FirstName = findViewById(R.id.name);
        LastName = findViewById(R.id.emails);
        Email = findViewById(R.id.pwd);
        Password = findViewById(R.id.dob);
        ConformPassword = findViewById(R.id.country);
        NextScreen = findViewById(R.id.signupp);
        db= new DatabaseHelper (this);//Calling database constructor


        NextScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean a =ValidatePassword();
                if(a == false) {
                    Intent intent = new Intent(Signup.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        });

    }
    boolean ValidatePassword()
    {
        if(Password.equals(ConformPassword)) {
            Toast Pass = Toast.makeText(Signup.this, "Password don't match", Toast.LENGTH_SHORT);
            Pass.show();
        }


        return false;
    }
    void insertData()
    {
        NextScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean Isinserted= db.insertion(FirstName.getText().toString()
                        ,LastName.getText().toString(),
                        Email.getText().toString(),
                        Password.getText().toString());
                if(Isinserted == true )
                {
                    Toast.makeText(Signup.this,"Data inserted",Toast.LENGTH_LONG);

                }
                else
                {
                    Toast.makeText(Signup.this,"Data inserted",Toast.LENGTH_LONG);

                }

            }
        });
    }
}
