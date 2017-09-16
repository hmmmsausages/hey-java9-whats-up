package me.andremueller.heyjava9whatsup.extensions;

public interface PrivateInterfaceMethod {

    default void doSomethingCool(){
        printSomething();
        System.out.println("Cool");
    }

    default void doSomethingElse(){
        printSomething();
        System.out.println("Else");
    }

    // private interface methods to reuse code that is used by default interface methods
    private void printSomething(){
        System.out.println("Something");
    }
}

class Test implements PrivateInterfaceMethod {

}
