package wizrole.horizontalscrollview.beam;

import java.util.List;

/**
 * Created by liushengping on 2017/11/3.
 * 何人执笔？
 */

public class Content {

    public String Cate;
    public List<Detail>  details;

    public List<Detail> getDetails() {
        return details;
    }

    public void setCate(String cate) {
        Cate = cate;
    }

    public String getCate() {
        return Cate;
    }

    public void setDetails(List<Detail> details) {
        this.details = details;
    }
}
