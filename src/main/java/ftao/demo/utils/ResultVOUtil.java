package ftao.demo.utils;

import ftao.demo.VO.ResultVO;

public class ResultVOUtil {
    public static ResultVO success(Object object)
    {
        ResultVO resultVO=new ResultVO();
        resultVO.setData(object);
        resultVO.setMsg("成功");
        resultVO.setCode(0);
        return resultVO;
    }
}
