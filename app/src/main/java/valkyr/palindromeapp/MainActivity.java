package valkyr.palindromeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {

    TextView resultLabel;
    EditText palindromeField;
    TextView palindromeLabel;
    Button testButton;

    MethodPackage mthd = new MethodPackage();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultLabel = (TextView)findViewById(R.id.resultLabel);
        palindromeField = (EditText)findViewById(R.id.enterPalindromeField);
        palindromeLabel = (TextView)findViewById(R.id.palindromeLabel);
        testButton = (Button)findViewById(R.id.testButton);


        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if  (palindromeField.getText().length()==0 || palindromeField.getText().equals("")){
                    mthd.setAlertDialog("noCancel", "Sie haben leider keinen Text eingegeben. Bitte versuchen Sie es erneut.","Ok", "Ok", MainActivity.this);
                } else if (palindromeField.getText().length()>0 && palindromeField.getText().length()<5 ){
                    mthd.setAlertDialog("noCancel", "Sie haben leider einen zu kurzen Text eingegeben. Bitte versuchen Sie es erneut mit mindestens 5 Buchstaben.","Ok", "Ok", MainActivity.this);
                } else {
                    if (isPalindrome(palindromeField.getText().toString())){
                        resultLabel.setText("Gratulation, Sie haben ein Palindrom gefunden/eingegeben.");
                    } else {
                        resultLabel.setText("der Palindrom Überprüfer 3000 hat leider keine Rose für Sie.");
                    }
                }
            }
        });
    }

    public static boolean isPalindrome(String str)	{
        String localstr = str.toLowerCase();
        return localstr.equals(new StringBuilder(localstr).reverse().toString());
    }

}
