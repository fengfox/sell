package ftao.demo.exception;

public class SellException extends RuntimeException{
    private Integer code;

    public SellException()
    {
        super("没有查到商品");
        this.code=901;
    }
}
