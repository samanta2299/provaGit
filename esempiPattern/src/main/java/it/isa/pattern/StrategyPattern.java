package it.isa.pattern;

// file Strategy.java
interface Strategy {
    public String doOp(String s);
}

// file ConvertLowerCase.java
class ConvertLowerCase implements Strategy {
    public String doOp(String s){
        return s.toLowerCase();
    }
}

// file ConvertUpperCase.java
class ConvertUpperCase implements Strategy {
    public String doOp(String s){
        return s.toUpperCase();
    }
}

// file Capitalize.java
class Capitalize implements Strategy {
    public String doOp(String s){
        return s.substring(0,1).toUpperCase() + s.substring(1);
    }
}

// file Context.java
class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public String doOp(String s) {
        return strategy.doOp(s);
    }
}

// 'client'
public class StrategyPattern {
    public static void esegui() {
        System.out.println("Strategy pattern");
        String s = "pRoVa";

        Context c = new Context(new ConvertLowerCase());
        System.out.println(c.doOp(s));

        c = new Context(new ConvertUpperCase());
        System.out.println(c.doOp(s));

        c = new Context(new Capitalize());
        System.out.println(c.doOp(s));
    }
}