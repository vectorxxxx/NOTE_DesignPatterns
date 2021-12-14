package com.vectorx.pattern.t12_template;

public class Client {
    public static void main(String[] args) {
        SoyaMilk peanutSoyaMilk = new PeanutSoyaMilk();
        peanutSoyaMilk.make();
        SoyaMilk redBeanSoyaMilk = new RedBeanSoyaMilk();
        redBeanSoyaMilk.make();
        SoyaMilk sesameSoyaMilk = new SesameSoyaMilk();
        sesameSoyaMilk.make();
        /*
        ============花生豆浆============
        >>>>>>豆浆制作开始<<<<<<
        Step1. 选用上好的黄豆.
        Step2. 加入上好的花生.
        Step3. 对黄豆和配料进行水洗浸泡.
        Step4. 将充分浸泡过的黄豆和配料放入豆浆机中，开始打豆浆.
        >>>>>>豆浆制作结束<<<<<<
        ============红豆豆浆============
        >>>>>>豆浆制作开始<<<<<<
        Step1. 选用上好的黄豆.
        Step2. 加入上好的红豆.
        Step3. 对黄豆和配料进行水洗浸泡.
        Step4. 将充分浸泡过的黄豆和配料放入豆浆机中，开始打豆浆.
        >>>>>>豆浆制作结束<<<<<<
        ============芝麻豆浆============
        >>>>>>豆浆制作开始<<<<<<
        Step1. 选用上好的黄豆.
        Step2. 加入上好的芝麻.
        Step3. 对黄豆和配料进行水洗浸泡.
        Step4. 将充分浸泡过的黄豆和配料放入豆浆机中，开始打豆浆.
        >>>>>>豆浆制作结束<<<<<<
        */

        SoyaMilk pureSoyaMilk = new PureSoyaMilk();
        pureSoyaMilk.make();
        /*
        ============纯豆浆============
        >>>>>>豆浆制作开始<<<<<<
        Step1. 选用上好的黄豆.
        Step3. 对黄豆和配料进行水洗浸泡.
        Step4. 将充分浸泡过的黄豆和配料放入豆浆机中，开始打豆浆.
        >>>>>>豆浆制作结束<<<<<<
         */
    }
}
