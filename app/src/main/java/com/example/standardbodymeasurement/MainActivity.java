package com.example.standardbodymeasurement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity
{
    private EditText et1,et2,et3,et4;
    private TextView t1,t2,t3;
    private AppCompatButton button;
    private RadioButton cms,feet;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView sbm=findViewById(R.id.layout);
        AnimationDrawable animationDrawable=(AnimationDrawable) sbm.getBackground();
        animationDrawable.setEnterFadeDuration(1500);
        animationDrawable.setExitFadeDuration(2000);
        animationDrawable.start();

        et1=findViewById(R.id.editTextNumber);
        et2=findViewById(R.id.editTextNumber2);
        et3=findViewById(R.id.editTextNumber3);
        et4=findViewById(R.id.heightcm);

        t3=findViewById(R.id.textView2);

        t1=findViewById(R.id.tv);
        t2=findViewById(R.id.textView);
        button=findViewById(R.id.bu);

        AnimationDrawable animationDrawablee=(AnimationDrawable) button.getBackground();
        animationDrawablee.setEnterFadeDuration(2500);
        animationDrawablee.setExitFadeDuration(2000);
        animationDrawablee.start();

        radioGroup=findViewById(R.id.rg);

        et2.setVisibility(View.INVISIBLE);
        et3.setVisibility(View.INVISIBLE);
        button.setVisibility(View.INVISIBLE);
        et4.setVisibility(View.INVISIBLE);
        t3.setVisibility(View.INVISIBLE);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                button.setVisibility(View.VISIBLE);
                switch (i)
                {
                    case R.id.Cmbutton:
                        et2.setVisibility(View.INVISIBLE);
                        et3.setVisibility(View.INVISIBLE);
                        et4.setVisibility(View.VISIBLE);
                        t3.setVisibility(View.VISIBLE);
                        t2.setText("");
                        t1.setText("Enter the height");
                        button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                t2.setText("");
                                String s1 = et1.getText().toString().trim();
                                String scm= et4.getText().toString().trim();
                                if (s1.equals("") || scm.equals(""))
                                {
                                    t1.setText("Height :");
                                    Snackbar.make(view,"Please fill up all the fields",Snackbar.LENGTH_LONG).setAction("Action",null).setBackgroundTint(Color.CYAN).setTextColor(Color.BLUE).show();
                                }
                                else if(Integer.parseInt(scm)>193)
                                {
                                    Snackbar.make(view,"Enter height less than or equals to 193cm",Snackbar.LENGTH_LONG).setAction("Action",null).setBackgroundTint(Color.CYAN).setTextColor(Color.BLUE).show();
                                }
                                else if(Integer.parseInt(scm)<148)
                                {
                                    Snackbar.make(view,"Enter height greater than or equals to 148cm",Snackbar.LENGTH_LONG).setAction("Action",null).setBackgroundTint(Color.CYAN).setTextColor(Color.BLUE).show();
                                }
                                else if(Integer.parseInt(s1)>65 || Integer.parseInt(s1)<18)
                                {
                                    Snackbar.make(view,"Age limit : 18 to 65 and Height limit : 148cm to 193cm",Snackbar.LENGTH_LONG).setAction("Action",null).setBackgroundTint(Color.CYAN).setTextColor(Color.BLUE).show();
                                }
                                else {
                                    cm(s1,scm);
                                }
                            }
                        });
                        break;

                    case R.id.feet:
                        et4.setVisibility(View.INVISIBLE);
                        t3.setVisibility(View.INVISIBLE);
                        et2.setVisibility(View.VISIBLE);
                        et3.setVisibility(View.VISIBLE);
                        t2.setText("");
                        t1.setText("Enter the height");
                        button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                t2.setText("");
                                String s1 = et1.getText().toString();
                                String s2 = et2.getText().toString();
                                String s3 = et3.getText().toString();

                                if(s3.equals("00") || s3.equals("000") || s3.equals("0000") || s3.equals("0000") || s3.equals("00000"))
                                    s3="0";

                                if (s1.equals("") || s2.equals("") || s3.equals(""))
                                {
                                    t1.setText("Height : ");
                                    Snackbar.make(view,"Please fill up all the fields",Snackbar.LENGTH_LONG).setAction("Action",null).setBackgroundTint(Color.CYAN).setTextColor(Color.BLUE).show();
                                }
                                else if(Integer.parseInt(s3)>11)
                                {
                                    Snackbar.make(view,"Inches cannot be more than 11",Snackbar.LENGTH_LONG).setAction("Action",null).setBackgroundTint(Color.CYAN).setTextColor(Color.BLUE).show();
                                }
                                else if(Integer.parseInt(s1)>65 || Integer.parseInt(s2)>6 || Integer.parseInt(s1)<17 || (Integer.parseInt(s2)==6 && Integer.parseInt(s3)>3) || Integer.parseInt(s2)<4 || (Integer.parseInt(s2)==4 && Integer.parseInt(s3)<10))
                                {
                                    Snackbar.make(view,"Age limit : 18 to 65 and Height limit : 4'10\" to 6'3\"",Snackbar.LENGTH_LONG).setAction("Action",null).setBackgroundTint(Color.CYAN).setTextColor(Color.BLUE).show();
                                }
                                else {
                                    feet(s1,s2,s3);
                                }
                            }
                        });
                        break;
                }
            }
        });
    }

    void feet(String s1,String s2,String s3)
    {
        String[][] arr = {{"", "18 22", "23 27", "28 32", "33 37", "38 42", "43 47", "48 52", "53 57", "58 65"},
                {"4.10", "45/67/77/82", "46/69/79/84", "48/70/80/85", "49/71/81/86", "50/72/82/87", "51/73/83/88", "52/73/83/88", "53/73/83/88", "54/73/83/88"},
                {"4.11", "47/68/78/83", "48/70/80/85", "49/71/81/86", "50/71/81/86", "51/72/82/87", "52/73/83/88", "53/74/84/89", "54/74/84/89", "55/74/84/89"},
                {"5.0", "48/69/79/84", "49/70/80/85", "50/72/82/87", "51/73/83/88", "52/73/83/88", "53/74/84/89", "54/75/85/90", "55/75/85/90", "56/75/85/90"},
                {"5.1", "49/70/80/85", "51/71/81/86", "52/73/83/88", "53/73/83/88", "54/74/84/89", "55/75/85/90", "56/76/86/91", "57/76/86/91", "58/76/86/91"},
                {"5.2", "50/70/80/85", "52/71/81/86", "53/73/83/88", "54/74/84/89", "55/75/85/90", "56/76/86/91", "56/76/86/91", "57/76/86/91", "58/76/86/91"},
                {"5.3", "51/71/81/86", "53/73/83/88", "54/74/84/89", "55/75/85/90", "56/76/86/91", "57/77/87/92", "57/77/87/92", "57/77/87/92", "58/78/89/94"},
                {"5.4", "52/71/81/86", "54/73/83/88", "55/74/84/89", "57/76/86/91", "58/76/86/91", "58/77/87/92", "59/77/87/92", "59/78/88/93", "59/78/88/93"},
                {"5.5", "54/71/81/86", "56/73/83/88", "58/74/84/89", "60/76/86/91", "61/76/86/91", "61/78/88/93", "62/79/89/94", "62/79/89/94", "62/80/90/95"},
                {"5.6", "56/72/82/87", "58/74/84/89", "60/75/85/90", "60/77/87/92", "61/79/89/94", "63/79/89/94", "63/80/89/94", "63/80/89/94", "64/81/90/95"},
                {"5.7", "57/72/82/87", "59/74/84/89", "61/76/86/91", "63/78/88/93", "64/80/90/95", "64/80/90/95", "65/80/90/95", "65/80/90/95", "66/81/91/96"},
                {"5.8", "58/72/82/87", "61/75/85/90", "63/76/86/91", "64/79/89/94", "65/81/91/96", "66/81/91/96", "67/82/92/97", "67/82/92/97", "68/83/93/98"},
                {"5.9", "61/73/83/88", "62/76/86/91", "64/77/87/92", "66/80/90/95", "67/82/92/97", "68/83/93/98", "68/84/94/99", "69/84/94/99", "69/85/94/99"},
                {"5.10", "63/74/84/89", "65/77/87/92", "68/78/88/93", "70/81/91/96", "70/82/92/97", "71/84/94/99", "72/84/94/99", "72/84/94/99", "73/85/94/99"},
                {"5.11", "65/75/85/90", "67/77/87/93", "69/79/89/94", "71/81/91/96", "72/82/92/97", "73/74/94/99", "74/85/95/100", "74/85/95/100", "75/85/95/100"},
                {"6.0", "66/75/85/90", "69/78/88/93", "71/79/89/94", "73/83/93/98", "74/84/94/99", "75/85/95/100", "76/86/96/101", "76/87/97/102", "76/87/97/102"},
                {"6.1", "69/76/86/91", "72/79/89/94", "74/83/93/98", "76/84/94/99", "77/85/95/100", "78/86/96/101", "79/87/97/102", "80/87/97/102", "80/88/98/103"},
                {"6.2", "71/77/87/92", "74/79/89/94", "76/83/93/98", "79/84/94/99", "79/85/95/100", "80/86/96/101", "81/88/98/103", "82/88/98/103", "82/88/98/103"},
                {"6.3", "73/78/88/93", "75/80/90/95", "78/83/93/98", "80/85/95/100", "81/86/96/101", "82/87/97/102", "82/88/98/103", "83/89/99/104", "83/89/99/104"}
        };
        int i = 0, j = 0;
        for (int loop1 = 1; loop1 < 19; loop1++) {
            String height = arr[loop1][0] + " ";
            String a = height.substring(0, 1);
            String b = height.substring(2, height.lastIndexOf(" "));
            if (s2.equals(a) && s3.equals(b)) {
                i = loop1;
                break;
            }
        }
        for (int loop2 = 1; loop2 < 10; loop2++) {
            int a = Integer.parseInt(arr[0][loop2].substring(0, arr[0][loop2].indexOf(" ")));
            int b = Integer.parseInt(arr[0][loop2].substring(arr[0][loop2].indexOf(" ") + 1));
            if (Integer.parseInt(s1) >= a && Integer.parseInt(s1) <= b) {
                j = loop2;
                break;
            }
        }
        String disp="";
        String data = arr[i][j];
        String d1 = " Weight : " + data.substring(0, data.indexOf("/")) + " kg";
        String d2 = " \n\n Waist : " + data.substring(data.indexOf("/") + 1, data.indexOf("/") + 3)+" cm";
        disp=d1 + d2;
        String d3 = " \n\n Expanded chest : " + data.substring(data.lastIndexOf("/") + 1)+" cm";
        String d4 = " \n\n Minimum chest : " + data.substring(6, 8)+" cm";
        disp+=d4 +d3;
        t2.setText(disp);
        double a1=Double.parseDouble(s2)*30.48;
        double a2=Double.parseDouble(s3)*2.54;
        t1.setText("Height is : "+(a1+a2)+" cm");
    }

    void cm(String s1,String scm)
    {
        double feet=Math.floor(Double.parseDouble(scm)/30.48);
        double inches=(Double.parseDouble(scm)/30.48-feet)*12;

        String f=String.valueOf(feet);
        f=f.substring(0,f.indexOf('.'));
        String in=String.valueOf(inches);
        in=in.substring(0,in.indexOf('.'));

        String[][] arr = {{"", "18 22", "23 27", "28 32", "33 37", "38 42", "43 47", "48 52", "53 57", "58 65"},
                {"4.10", "45/67/77/82", "46/69/79/84", "48/70/80/85", "49/71/81/86", "50/72/82/87", "51/73/83/88", "52/73/83/88", "53/73/83/88", "54/73/83/88"},
                {"4.11", "47/68/78/83", "48/70/80/85", "49/71/81/86", "50/71/81/86", "51/72/82/87", "52/73/83/88", "53/74/84/89", "54/74/84/89", "55/74/84/89"},
                {"5.0", "48/69/79/84", "49/70/80/85", "50/72/82/87", "51/73/83/88", "52/73/83/88", "53/74/84/89", "54/75/85/90", "55/75/85/90", "56/75/85/90"},
                {"5.1", "49/70/80/85", "51/71/81/86", "52/73/83/88", "53/73/83/88", "54/74/84/89", "55/75/85/90", "56/76/86/91", "57/76/86/91", "58/76/86/91"},
                {"5.2", "50/70/80/85", "52/71/81/86", "53/73/83/88", "54/74/84/89", "55/75/85/90", "56/76/86/91", "56/76/86/91", "57/76/86/91", "58/76/86/91"},
                {"5.3", "51/71/81/86", "53/73/83/88", "54/74/84/89", "55/75/85/90", "56/76/86/91", "57/77/87/92", "57/77/87/92", "57/77/87/92", "58/78/89/94"},
                {"5.4", "52/71/81/86", "54/73/83/88", "55/74/84/89", "57/76/86/91", "58/76/86/91", "58/77/87/92", "59/77/87/92", "59/78/88/93", "59/78/88/93"},
                {"5.5", "54/71/81/86", "56/73/83/88", "58/74/84/89", "60/76/86/91", "61/76/86/91", "61/78/88/93", "62/79/89/94", "62/79/89/94", "62/80/90/95"},
                {"5.6", "56/72/82/87", "58/74/84/89", "60/75/85/90", "60/77/87/92", "61/79/89/94", "63/79/89/94", "63/80/89/94", "63/80/89/94", "64/81/90/95"},
                {"5.7", "57/72/82/87", "59/74/84/89", "61/76/86/91", "63/78/88/93", "64/80/90/95", "64/80/90/95", "65/80/90/95", "65/80/90/95", "66/81/91/96"},
                {"5.8", "58/72/82/87", "61/75/85/90", "63/76/86/91", "64/79/89/94", "65/81/91/96", "66/81/91/96", "67/82/92/97", "67/82/92/97", "68/83/93/98"},
                {"5.9", "61/73/83/88", "62/76/86/91", "64/77/87/92", "66/80/90/95", "67/82/92/97", "68/83/93/98", "68/84/94/99", "69/84/94/99", "69/85/94/99"},
                {"5.10", "63/74/84/89", "65/77/87/92", "68/78/88/93", "70/81/91/96", "70/82/92/97", "71/84/94/99", "72/84/94/99", "72/84/94/99", "73/85/94/99"},
                {"5.11", "65/75/85/90", "67/77/87/93", "69/79/89/94", "71/81/91/96", "72/82/92/97", "73/74/94/99", "74/85/95/100", "74/85/95/100", "75/85/95/100"},
                {"6.0", "66/75/85/90", "69/78/88/93", "71/79/89/94", "73/83/93/98", "74/84/94/99", "75/85/95/100", "76/86/96/101", "76/87/97/102", "76/87/97/102"},
                {"6.1", "69/76/86/91", "72/79/89/94", "74/83/93/98", "76/84/94/99", "77/85/95/100", "78/86/96/101", "79/87/97/102", "80/87/97/102", "80/88/98/103"},
                {"6.2", "71/77/87/92", "74/79/89/94", "76/83/93/98", "79/84/94/99", "79/85/95/100", "80/86/96/101", "81/88/98/103", "82/88/98/103", "82/88/98/103"},
                {"6.3", "73/78/88/93", "75/80/90/95", "78/83/93/98", "80/85/95/100", "81/86/96/101", "82/87/97/102", "82/88/98/103", "83/89/99/104", "83/89/99/104"}
        };

        int i = 0, j = 0;
        for (int loop1 = 1; loop1 < 19; loop1++) {
            String height = arr[loop1][0] + " ";
            String a = height.substring(0, 1);
            String b = height.substring(2, height.lastIndexOf(" "));
            if (f.equals(a) && in.equals(b)) {
                i = loop1;
                break;
            }
        }
        for (int loop2 = 1; loop2 < 10; loop2++) {
            int a = Integer.parseInt(arr[0][loop2].substring(0, arr[0][loop2].indexOf(" ")));
            int b = Integer.parseInt(arr[0][loop2].substring(arr[0][loop2].indexOf(" ") + 1));
            if (Integer.parseInt(s1) >= a && Integer.parseInt(s1) <= b) {
                j = loop2;
                break;
            }
        }
        String disp="";
        String data = arr[i][j];
        String d1 = " Weight : " + data.substring(0, data.indexOf("/")) + " kg";
        String d2 = " \n\n Waist : " + data.substring(data.indexOf("/") + 1, data.indexOf("/") + 3)+" cm";
        disp=d1 + d2;
        String d3 = " \n\n Expanded chest : " + data.substring(data.lastIndexOf("/") + 1)+" cm";
        String d4 = " \n\n Minimum chest : " + data.substring(6, 8)+" cm";
        disp+=d4 +d3;
        t2.setText(disp);

        t1.setText("Height : "+f+" feet,"+in+" inches");
    }
}
