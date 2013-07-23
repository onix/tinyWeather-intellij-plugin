package org.bbelovic.devel.testing;

public class A {

    public void methodA() {
        this.privateMethodA();
    }
    
    public void methodB() {
        
    }
    
    private void privateMethodA() {
        privateMethodB();
    }

    private void privateMethodB() {
        System.out.println("I am private method B");
    }
}
