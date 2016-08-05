package com.github.ojh.reflectionsample;

/**
 * Created by 01071724654 on 2016-08-04.
 */
public class ReflectionTest extends ReflectionSuper implements ReflectionInterface {

    public String text;

    public ReflectionTest() {
    }

    public ReflectionTest(String text) {
        this.text = text;
    }

    @ReflectionAnnotation
    public void methodOne(int num) {

    }

    private void methodTwo(String str) {

    }



}
