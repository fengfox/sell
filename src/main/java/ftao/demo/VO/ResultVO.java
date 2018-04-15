package ftao.demo.VO;

import lombok.Data;

import java.util.List;
@Data
public class ResultVO<T> {
    private String msg;
    private Integer code;
    private T data;

}
