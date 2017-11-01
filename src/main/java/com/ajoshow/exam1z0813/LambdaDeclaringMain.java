package com.ajoshow.exam1z0813;

import java.util.function.Predicate;

public class LambdaDeclaringMain {

    public static void main(String[] args) {
        Validator v = new Validator(true);

        // First statement result compile error
//        System.out.println(new LambdaDeclaringMain().validate(v, v->v.isValid()));
        System.out.println(new LambdaDeclaringMain().validate(v, x->x.isValid()));
    }

    public boolean validate(Validator validator, Predicate<Validator> p){
        return p.test(validator);
    }

    public static class Validator{
        private boolean valid;

        public Validator(boolean valid){
            this.valid = valid;
        }

        public void setValid(boolean valid) {
            this.valid = valid;
        }

        public boolean isValid() {
            return valid;
        }
    }

}
