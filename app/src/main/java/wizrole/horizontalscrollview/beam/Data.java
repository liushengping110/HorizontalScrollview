package wizrole.horizontalscrollview.beam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liushengping on 2017/11/3.
 * 何人执笔？
 */

public class Data {

    public List<Detail>  one(){
        List<Detail> details=new ArrayList<>();
        for (int i=0;i<10;i++){
            Detail detail=new Detail();
            detail.setDetailName("关注"+i);
            details.add(detail);
            detail=null;
         }
        return details;
    }

    public List<Detail>  two(){
        List<Detail> details=new ArrayList<>();
        for (int i=0;i<10;i++){
            Detail detail=new Detail();
            detail.setDetailName("推荐"+i);
            details.add(detail);
            detail=null;
        }
        return details;
    }

    public List<Detail>  three(){
        List<Detail> details=new ArrayList<>();
        for (int i=0;i<10;i++){
            Detail detail=new Detail();
            detail.setDetailName("热点"+i);
            details.add(detail);
            detail=null;
        }
        return details;
    }

    public List<Detail>  four(){
        List<Detail> details=new ArrayList<>();
        for (int i=0;i<10;i++){
            Detail detail=new Detail();
            detail.setDetailName("视频"+i);
            details.add(detail);
            detail=null;
        }
        return details;
    }

    public List<Detail>  five(){
        List<Detail> details=new ArrayList<>();
        for (int i=0;i<10;i++){
            Detail detail=new Detail();
            detail.setDetailName("社会"+i);
            details.add(detail);
            detail=null;
        }
        return details;
    }

    public List<Detail>  six(){
        List<Detail> details=new ArrayList<>();
        for (int i=0;i<10;i++){
            Detail detail=new Detail();
            detail.setDetailName("娱乐"+i);
            details.add(detail);
            detail=null;
        }
        return details;
    }

    public List<Detail>  seven(){
        List<Detail> details=new ArrayList<>();
        for (int i=0;i<10;i++){
            Detail detail=new Detail();
            detail.setDetailName("问答"+i);
            details.add(detail);
            detail=null;
        }
        return details;
    }

    public List<Detail>  eight(){
        List<Detail> details=new ArrayList<>();
        for (int i=0;i<10;i++){
            Detail detail=new Detail();
            detail.setDetailName("体育"+i);
            details.add(detail);
            detail=null;
        }
        return details;
    }

    public List<Content>  ten(){
        List<Content> contents=new ArrayList<>();
        for (int i=0;i<8;i++){
            Content content=new Content();
            switch (i){
                case 0:
                    content.setCate("关注");
                    content.setDetails(one());
                    contents.add(content);
                    content=null;
                    break;
                case 1:
                    content.setCate("推荐");
                    content.setDetails(two());
                    contents.add(content);
                    content=null;
                    break;
                case 2:
                    content.setCate("热点");
                    content.setDetails(three());
                    contents.add(content);
                    content=null;
                    break;
                case 3:
                    content.setCate("视频");
                    content.setDetails(four());
                    contents.add(content);
                    content=null;
                    break;
                case 4:
                    content.setCate("社会");
                    content.setDetails(five());
                    contents.add(content);
                    content=null;
                    break;
                case 5:
                    content.setCate("娱乐");
                    content.setDetails(six());
                    contents.add(content);
                    content=null;
                    break;
                case 6:
                    content.setCate("问答");
                    content.setDetails(seven());
                    contents.add(content);
                    content=null;
                    break;
                case 7:
                    content.setCate("体育");
                    content.setDetails(eight());
                    contents.add(content);
                    content=null;
                    break;
            }
        }
        return contents;
    }
}
