package com.android.ui.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.ui.R;

public class CalculatorActivity extends Activity {


    private EditText et_input;
    private TextView bt_calculate;
    private int signPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        et_input = findViewById(R.id.et_input);

        bt_calculate = findViewById(R.id.bt_calculate);
        bt_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = et_input.getText().toString().trim();
                Operation operation = null;
                int index = -1;
                if (content.contains("+")) {
                    index = content.indexOf("+");
                    operation = OptionerFactory2.creatOperation(OperationAdd.class);
                }
                if (content.contains("-")) {
                    index = content.indexOf("-");
                    operation = OptionerFactory2.creatOperation(OperationSub.class);
                }
                if (content.contains("*")) {
                    index = content.indexOf("*");
                    operation = OptionerFactory2.creatOperation(OperationSub.class);
                }
                if (content.contains("/")) {
                    index = content.indexOf("/");
                    operation = OptionerFactory2.creatOperation(OperationDiv.class);
                }

                int num1 = Integer.parseInt(content.substring(0, index));
                int num2 = Integer.parseInt(content.substring(index + 1, content.length()));
                operation.setX(num1);
                operation.setY(num2);

                String result = content + "=" + operation.getResult();

                et_input.setText(result);
                et_input.setSelection(result.length());
            }
        });

    }

}