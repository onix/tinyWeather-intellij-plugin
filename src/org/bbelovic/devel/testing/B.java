package org.bbelovic.devel.testing;

public class B {

    public void methodInB() {
        A a = new A();
        a.methodA();
    }
    
    public void methodX() {
        this.methodInB();
    }
}
