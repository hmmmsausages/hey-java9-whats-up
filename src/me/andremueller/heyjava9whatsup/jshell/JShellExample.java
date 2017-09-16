package me.andremueller.heyjava9whatsup.jshell;

import jdk.jshell.JShell;

public class JShellExample {
    public static void main(String[] args) {
        JShell jShell = JShell.create();
        jShell.eval("int x = 10;");
        jShell.eval("String something = \"Hello\";");
        jShell.eval("System.out.println(x);");
        jShell.variables().forEach(System.out::println);
    }
}
