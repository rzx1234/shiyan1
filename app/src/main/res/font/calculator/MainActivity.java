package font.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.peanuo.calculator.R;

import java.util.ArrayDeque;
import java.util.Deque;

public class MainActivity extends AppCompatActivity {

    public double num1 = 0, num2 = 0, result = 0;
    private double memory = 0;

    Button butmc, butmr, butmAdd, butmSub, butms;
    Button but0, but1, but2, but3, but4, but5, but6, but7, but8, but9;
    Button butadd, butsub, butmul, butdiv, butp, buteq, butce, butc, butper, buttwice, butcube, butfra, butdel, butsqrt, butpls;
    private TextView res, fml;

    //对同一输入的数字进行连续操作（按下等号按钮时），即方法continueCalculate()所用的参数
    public boolean isContinuous = false;
    public double conBase;
    public String conOpe;

    private Deque<Double> number = new ArrayDeque<>();
    private Deque<String> operator = new ArrayDeque<>();

    //将运算符放入符号队列，乘号及除号在此先运算
    public void pushOperator(String ope) {
        if (operator.size() == 0) {
            operator.push(ope);
            return;
        } else if (operator.peek().equals("*") || operator.peek().equals("/")) {
            num2 = number.pop();
            num1 = number.pop();
            String peek = operator.pop();
            if (peek.equals("*")) {
                result = num1 * num2;
            }
            if (peek.equals("/")) {
                result = num1 / num2;
            }
            number.push(result);
        }
        operator.push(ope);
    }

    //将当前的数字队列及符号队列的数据进行计算
    public void calculate() {
        while (operator.size() > 0) {
            num1 = number.removeLast();
            num2 = number.removeLast();
            String cal = operator.removeLast();
            switch (cal) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    result = num1 / num2;
                    break;
            }
            number.addLast(result);
        }
        result = number.peek();
    }

    //对同一输入的数字进行连续操作（按下等号按钮时）
    public void continuousCalculate(){
        if (number.size() > 1)
            calculate();
        if(res.length() == 0){
            conOpe = operator.pop();
            if (number.size() == 1)
                result = conBase = number.pop();
        }
        switch (conOpe){
            case "+":
                result += conBase;
                break;
            case "-":
                result -= conBase;
                break;
            case "*":
                result *= conBase;
                break;
            case "/":
                result /= conBase;
                break;
        }
        res.setText(doubleTranslate(result));
        fml.setText(null);
    }

    //将double类型转化为String，同时若是整数，去掉小数位
    public String doubleTranslate(double d){
        if (Math.round(d) - d == 0){
            return String.valueOf((long)d);
        }
        else
            return String.valueOf(d);
    }

    class buttonListener implements View.OnClickListener {
        public void onClick(View v) {
            switch (v.getId()) {

                //数字输入按钮
                case R.id.zero:
                    if (fml.getText().toString().contains("=")) {
                        fml.setText(null);
                        res.setText(null);
                        number.clear();
                        operator.clear();
                    }
                    String str0 = res.getText().toString();
                    str0 += "0";
                    res.setText(str0);
                    break;
                case R.id.one:
                    if (fml.getText().toString().contains("=")) {
                        fml.setText(null);
                        res.setText(null);
                        number.clear();
                        operator.clear();
                    }
                    String str1 = res.getText().toString();
                    str1 += "1";
                    res.setText(str1);
                    break;
                case R.id.two:
                    if (fml.getText().toString().contains("=")) {
                        fml.setText(null);
                        res.setText(null);
                        number.clear();
                        operator.clear();
                    }
                    String str2 = res.getText().toString();
                    str2 += "2";
                    res.setText(str2);
                    break;
                case R.id.three:
                    if (fml.getText().toString().contains("=")) {
                        fml.setText(null);
                        res.setText(null);
                        number.clear();
                        operator.clear();
                    }
                    String str3 = res.getText().toString();
                    str3 += "3";
                    res.setText(str3);
                    break;
                case R.id.four:
                    if (fml.getText().toString().contains("=")) {
                        fml.setText(null);
                        res.setText(null);
                        number.clear();
                        operator.clear();
                    }
                    String str4 = res.getText().toString();
                    str4 += "4";
                    res.setText(str4);
                    break;
                case R.id.five:
                    if (fml.getText().toString().contains("=")) {
                        fml.setText(null);
                        res.setText(null);
                        number.clear();
                        operator.clear();
                    }
                    String str5 = res.getText().toString();
                    str5 += "5";
                    res.setText(str5);
                    break;
                case R.id.six:
                    if (fml.getText().toString().contains("=")) {
                        fml.setText(null);
                        res.setText(null);
                        number.clear();
                        operator.clear();
                    }
                    String str6 = res.getText().toString();
                    str6 += "6";
                    res.setText(str6);
                    break;
                case R.id.seven:
                    if (fml.getText().toString().contains("=")) {
                        fml.setText(null);
                        res.setText(null);
                        number.clear();
                        operator.clear();
                    }
                    String str7 = res.getText().toString();
                    str7 += "7";
                    res.setText(str7);
                    break;
                case R.id.eight:
                    if (fml.getText().toString().contains("=")) {
                        fml.setText(null);
                        res.setText(null);
                        number.clear();
                        operator.clear();
                    }
                    String str8 = res.getText().toString();
                    str8 += "8";
                    res.setText(str8);
                    break;
                case R.id.nine:
                    if (fml.getText().toString().contains("=")) {
                        fml.setText(null);
                        res.setText(null);
                        number.clear();
                        operator.clear();
                    }
                    String str9 = res.getText().toString();
                    str9 += "9";
                    res.setText(str9);
                    break;
                case R.id.point:
                    String strpoint = res.getText().toString();
                    if ((strpoint.length() > 0) && (!strpoint.contains("."))) {
                        if (fml.getText().toString().contains("=")) {
                            fml.setText(null);
                            res.setText(null);
                            number.clear();
                            operator.clear();
                        }
                        strpoint += ".";
                        res.setText(strpoint);
                    }
                    break;

                //运算符按钮
                case R.id.addition:
                    if (res.length() > 0) {
                        if (fml.getText().toString().contains("=")){
                            fml.setText(null);
                            number.clear();
                        }

                        String stradd = res.getText().toString();
                        String stradd2 = fml.getText().toString();

                        num1 = Double.parseDouble(stradd);
                        number.push(num1);
                        pushOperator("+");

                        //如果输入的数字为负数，则加上括号
                        if (stradd.contains("-")) {
                            stradd = "(" + stradd + ")";
                        }

                        stradd += "+";
                        stradd2 += stradd;
                        fml.setText(stradd2);
                        res.setText(null);
                        isContinuous = false;
                    }
                    break;
                case R.id.subtraction:
                    if (res.length() > 0) {
                        if (fml.getText().toString().contains("=")){
                            fml.setText(null);
                            number.clear();
                        }

                        String strsub = res.getText().toString();
                        String strsub2 = fml.getText().toString();

                        num1 = Double.parseDouble(strsub);
                        number.push(num1);
                        pushOperator("-");

                        //如果输入的数字为负数，则加上括号
                        if (strsub.contains("-")) {
                            strsub = "(" + strsub + ")";
                        }
                        strsub += "-";
                        strsub2 += strsub;
                        fml.setText(strsub2);
                        res.setText(null);
                        isContinuous = false;
                    }
                    break;
                case R.id.multiplication:
                    if (res.length() > 0) {
                        if (fml.getText().toString().contains("=")){
                            fml.setText(null);
                            number.clear();
                        }

                        String strmul = res.getText().toString();
                        String strmul2 = fml.getText().toString();

                        num1 = Double.parseDouble(strmul);
                        number.push(num1);
                        pushOperator("*");

                        //如果输入的数字为负数，则加上括号\n" +
                                    "                        if (strmul.contains(\"-\")) {\n" +
                                    "                            strmul = \"(\" + strmul + \")";
                        }

                        strmul += "×";
                        strmul2 += strmul;
                        fml.setText(strmul2);
                        res.setText(null);
                        isContinuous = false;
                    }
                    break;
                case R.id.division:
                    if (res.length() > 0) {
                        if (fml.getText().toString().contains("=")){
                            fml.setText(null);
                            number.clear();
                        }

                        String strdiv = res.getText().toString();
                        String strdiv2 = fml.getText().toString();

                        num1 = Double.parseDouble(strdiv);
                        number.push(num1);
                        pushOperator("/");

                        //如果输入的数字为负数，则加上括号
                        if (strdiv.contains("-")) {
                            strdiv = "(" + strdiv + ")";
                        }

                        strdiv += "÷";
                        strdiv2 += strdiv;
                        fml.setText(strdiv2);
                        res.setText(null);
                        isContinuous = false;
                    }
                    break;

                //清除按钮
                case R.id.clear:
                    fml.setText(null);
                    res.setText(null);
                    number.clear();
                    operator.clear();
                    isContinuous = false;
                    result = 0;
                    break;
                case R.id.delete:
                    if (res.length() > 0) {
                        String strdel = res.getText().toString();
                        strdel = strdel.substring(0, strdel.length() - 1);
                        res.setText(strdel);
                    } else fml.setText(null);
                    break;
                case R.id.clearError:
                    res.setText(null);
                    break;

                //正负号、平方等对于正在输入的数字的运算
                case R.id.plusMinus:
                    if (res.length() > 0) {
                        if (fml.getText().toString().contains("=")){
                            fml.setText(null);
                            number.clear();
                        }

                        String strpls = res.getText().toString();
                        if (strpls.contains("-")) {
                            strpls = strpls.substring(1);
                            res.setText(strpls);
                        } else {
                            StringBuilder strtemp = new StringBuilder(strpls);
                            strtemp.insert(0, "-");
                            res.setText(strtemp);
                        }
                        isContinuous = false;
                    }
                    break;
                case R.id.fraction:
                    if (res.length() > 0) {
                        if (fml.getText().toString().contains("=")){
                            fml.setText(null);
                            number.clear();
                        }

                        String strfra = res.getText().toString();
                        Double fra = Double.parseDouble(strfra);
                        if ((fra != 0)) {
                            fra = 1 / fra;
                            res.setText(doubleTranslate(fra));
                        }
                        else Toast.makeText(getApplicationContext(),"0无法进行此运算",Toast.LENGTH_LONG).show();
                        isContinuous = false;
                    }
                    break;
                case R.id.sqr:
                    if (res.length() > 0) {
                        if (fml.getText().toString().contains("=")){
                            fml.setText(null);
                            number.clear();
                        }

                        String strsqr = res.getText().toString();
                        Double sqr = Double.parseDouble(strsqr);
                        sqr = sqr * sqr;
                        res.setText(doubleTranslate(sqr));
                        isContinuous = false;
                    }
                    break;
                case R.id.sqrt:
                    if (res.length() > 0) {
                        if (fml.getText().toString().contains("=")){
                            fml.setText(null);
                            number.clear();
                        }

                        String strsqrt = res.getText().toString();
                        Double sqrt = Double.parseDouble(strsqrt);
                        if (sqrt >= 0) {
                            sqrt = Math.sqrt(sqrt);
                            res.setText(doubleTranslate(sqrt));
                        }
                        else Toast.makeText(getApplicationContext(),"负数无法进行此运算",Toast.LENGTH_LONG).show();
                        isContinuous = false;
                    }
                    break;
                case R.id.cube:
                    if (res.length() > 0) {
                        if (fml.getText().toString().contains("=")){
                            fml.setText(null);
                            number.clear();
                        }

                        String strcub = res.getText().toString();
                        Double cub = Double.parseDouble(strcub);
                        cub = cub * cub * cub;
                        res.setText(doubleTranslate(cub));
                        isContinuous = false;
                    }
                    break;
                case R.id.percent:
                    if (res.length() > 0) {
                        if (fml.getText().toString().contains("=")){
                            fml.setText(null);
                            number.clear();
                        }

                        String strper = res.getText().toString();
                        Double per = Double.parseDouble(strper);
                        per = per / 100;
                        res.setText(doubleTranslate(per));
                        isContinuous = false;
                    }
                    break;

                case R.id.equator:
                    if ((!fml.getText().toString().contains("=")) && (fml.length() > 0 || isContinuous)){
                        if (res.length() == 0)
                            isContinuous = true;
                        if (isContinuous)
                            continuousCalculate();
                        else {
                            String strequ = res.getText().toString();
                            String strequ2 = fml.getText().toString();
                            num2 = Double.parseDouble(strequ);
                            number.push(num2);

                            //若等号的上一个运算符是乘号或者除号，先进行运算
                            if (operator.peek().equals("*") || operator.peek().equals("/")){
                                String peek = operator.pop();
                                num2 = number.pop();
                                num1 = number.pop();
                                if (peek.equals("*")){
                                    result = num1 * num2;
                                }
                                if (peek.equals("/")){
                                    result = num1 / num2;
                                }
                                number.push(result);
                            }

                            calculate();

                            //如果输入的数字为负数，则加上括号
                            if (strequ.contains("-")) {
                                strequ = "(" + strequ + ")";
                            }

                            strequ2 = strequ2 + strequ + "=";
                            fml.setText(strequ2);
                            res.setText(doubleTranslate(result));
                        }
                    }
                    break;

                //内存器按钮
                case R.id.memoryAdd:
                    if (res.length() > 0){
                        memory = memory + Double.parseDouble(res.getText().toString());
                        butmc.setEnabled(true);
                        butmr.setEnabled(true);
                    }
                    break;
                case R.id.memorySub:
                    if (res.length() > 0){
                        memory = memory - Double.parseDouble(res.getText().toString());
                        butmc.setEnabled(true);
                        butmr.setEnabled(true);
                    }
                    break;
                case R.id.memoryClear:
                    memory = 0;
                    butmc.setEnabled(false);
                    butmr.setEnabled(false);
                    break;
                case R.id.memorySave:
                    if (res.length() > 0){
                        memory = Double.parseDouble(res.getText().toString());
                        butmc.setEnabled(true);
                        butmr.setEnabled(true);
                    }
                    break;
                case R.id.memoryReuse:
                    res.setText(doubleTranslate(memory));
                    break;
            }
        }
    }

    @Override
    //1
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//运用布局文件

        //将按钮和文本与界面关联
        res = findViewById(R.id.result);
        fml = findViewById(R.id.formula);
        butmc = findViewById(R.id.memoryClear);
        butmr = findViewById(R.id.memoryReuse);
        butmAdd = findViewById(R.id.memoryAdd);
        butmSub = findViewById(R.id.memorySub);
        butms = findViewById(R.id.memorySave);
        but0 = findViewById(R.id.zero);
        but1 = findViewById(R.id.one);
        but2 = findViewById(R.id.two);
        but3 = findViewById(R.id.three);
        but4 = findViewById(R.id.four);
        but5 = findViewById(R.id.five);
        but6 = findViewById(R.id.six);
        but7 = findViewById(R.id.seven);
        but8 = findViewById(R.id.eight);
        but9 = findViewById(R.id.nine);
        butadd = findViewById(R.id.addition);
        butsub = findViewById(R.id.subtraction);
        butmul = findViewById(R.id.multiplication);
        butdiv = findViewById(R.id.division);
        butp = findViewById(R.id.point);
        buteq = findViewById(R.id.equator);
        butper = findViewById(R.id.percent);
        butfra = findViewById(R.id.fraction);
        butpls = findViewById(R.id.plusMinus);
        buttwice = findViewById(R.id.sqr);
        butcube = findViewById(R.id.cube);
        butsqrt = findViewById(R.id.sqrt);
        butce = findViewById(R.id.clearError);
        butc = findViewById(R.id.clear);
        butdel = findViewById(R.id.delete);

        butmr.setEnabled(false);
        butmc.setEnabled(false);

        //给按钮设置监听 监听按钮
        butms.setOnClickListener(new buttonListener());
        butmSub.setOnClickListener(new buttonListener());
        butmAdd.setOnClickListener(new buttonListener());
        butmr.setOnClickListener(new buttonListener());
        butmc.setOnClickListener(new buttonListener());
        but0.setOnClickListener(new buttonListener());
        but1.setOnClickListener(new buttonListener());
        but2.setOnClickListener(new buttonListener());
        but3.setOnClickListener(new buttonListener());
        but4.setOnClickListener(new buttonListener());
        but5.setOnClickListener(new buttonListener());
        but6.setOnClickListener(new buttonListener());
        but7.setOnClickListener(new buttonListener());
        but8.setOnClickListener(new buttonListener());
        but9.setOnClickListener(new buttonListener());
        butadd.setOnClickListener(new buttonListener());
        butsub.setOnClickListener(new buttonListener());
        butmul.setOnClickListener(new buttonListener());
        butdiv.setOnClickListener(new buttonListener());
        butp.setOnClickListener(new buttonListener());
        buteq.setOnClickListener(new buttonListener());
        butper.setOnClickListener(new buttonListener());
        butfra.setOnClickListener(new buttonListener());
        butpls.setOnClickListener(new buttonListener());
        buttwice.setOnClickListener(new buttonListener());
        butcube.setOnClickListener(new buttonListener());
        butsqrt.setOnClickListener(new buttonListener());
        butce.setOnClickListener(new buttonListener());
        butc.setOnClickListener(new buttonListener());
        butdel.setOnClickListener(new buttonListener());

    }
}
