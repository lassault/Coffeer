package com.lassa97.coffeer.Object;

public class PruebaREST {

    private String err;
    private String msg;

    public PruebaREST (String err, String msg) {
        this.err = err;
        this.msg = msg;
    }

    public String getErr() {
        return err;
    }

    public void setErr(String err) {
        this.err = err;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
