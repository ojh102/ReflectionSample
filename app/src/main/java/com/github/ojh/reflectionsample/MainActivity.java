package com.github.ojh.reflectionsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity implements ReflectionInterface {

    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Class cls = ReflectionTest.class;
        Log.d(TAG,"-------------------- Class -------------------- ");
        Log.d(TAG, "class name : " + cls.getName());
        Log.d(TAG, "super name : " + cls.getSuperclass().getName());
        for(Class inter : cls.getInterfaces()) {
            Log.d(TAG, "interface name : "+inter.getName());
        }

        Field[] fields = cls.getFields();
        Log.d(TAG,"-------------------- Field -------------------- ");
        for (Field field : fields) {
            Log.d(TAG, "feild : " + field.getType().getName() + " " + field.getName());
        }
        Log.d(TAG,"-------------------- Field -------------------- ");

        Log.d(TAG,"-------------------- Constructor -------------------- ");
        for (Constructor constructor : cls.getConstructors()) {
            Log.d(TAG, "construct name : " + constructor.getName());
            loggingParameter(constructor.getParameterTypes());
        }
        Log.d(TAG,"-------------------- Constructor -------------------- ");

        Log.d(TAG,"-------------------- Method -------------------- ");
        for (Method method : cls.getMethods()) {
            Log.d(TAG, "method name : " + method.getName());

            for (Annotation annotation : method.getAnnotations()) {
                Log.d(TAG, "annotation : " + annotation.toString());
            }

            loggingParameter(method.getParameterTypes());

            Log.d(TAG, "return type : " + method.getReturnType().getName());
        }
        Log.d(TAG,"-------------------- Method -------------------- ");

        Log.d(TAG,"-------------------- Class -------------------- ");
    }


    private void loggingParameter(Class<?>[] params) {
        Log.d(TAG,"-------------------- Parameter -------------------- ");
        for (Class param : params) {
            Log.d(TAG, "param : " + param.getName());
        }
        Log.d(TAG,"-------------------- Parameter -------------------- ");
    }
}
