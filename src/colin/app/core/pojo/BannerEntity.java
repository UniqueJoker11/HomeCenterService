package colin.app.core.pojo;
import javax.persistence.*;

/**
 * Created by joker on 15-2-16.
 * POJO类 BannerEntity
 */
@Entity
@Table(name="banner")
public class BannerEntity{

/*
 * banner_id
*/
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
@Column(name ="banner_id")
private int banner_id;

/*
 * 图片序号
*/
@Column(name ="banner_index")
private int banner_index;

/*
 * 图片地址
*/
@Column(name ="banner_img")
private String banner_img;

/*
 * banner改变时间
*/
@Column(name ="banner_modify_time")
private String banner_modify_time;


public void setBanner_id(int banner_id){
this.banner_id=banner_id;
}
public int getBanner_id(){
return this.banner_id;
}

public void setBanner_index(int banner_index){
this.banner_index=banner_index;
}
public int getBanner_index(){
return this.banner_index;
}

public void setBanner_img(String banner_img){
this.banner_img=banner_img;
}
public String getBanner_img(){
return this.banner_img;
}

public void setBanner_modify_time(String banner_modify_time){
this.banner_modify_time=banner_modify_time;
}
public String getBanner_modify_time(){
return this.banner_modify_time;
}

}
