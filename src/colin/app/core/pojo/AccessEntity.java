package colin.app.core.pojo;
import javax.persistence.*;

/**
 * Created by joker on 15-2-16.
 * POJO类 AccessEntity
 */
@Entity
@Table(name="access")
public class AccessEntity{

/*
 * 用户访问Id
*/
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
@Column(name ="access_id")
private int access_id;

/*
 * 访问日期
*/
@Column(name ="access_date")
private String access_date;

/*
 * 访问次数
*/
@Column(name ="access_time")
private int access_time;


public void setAccess_id(int access_id){
this.access_id=access_id;
}
public int getAccess_id(){
return this.access_id;
}

public void setAccess_date(String access_date){
this.access_date=access_date;
}
public String getAccess_date(){
return this.access_date;
}

public void setAccess_time(int access_time){
this.access_time=access_time;
}
public int getAccess_time(){
return this.access_time;
}

}
