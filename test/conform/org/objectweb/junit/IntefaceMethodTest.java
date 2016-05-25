package org.objectweb.junit;

/**
 * desc:
 * author:  ljt
 * time:    2016/5/16 10:28
 */
public class IntefaceMethodTest {

    private Fly fly;

    public String get(){
        return fly.run(100);
    }

    public interface Fly{
        public String run(int speed);
    }
}
