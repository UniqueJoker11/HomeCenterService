package colin.app.core.pojo;
import javax.persistence.*;

/**
 * Created by joker on 15-2-16.
 * POJO类 UserRightEntity
 */
@Entity
@Table(name="userright")
public class UserRightEntity{

/*
 * 用户编号Id
*/
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
@Column(name ="user_right_id")
private int user_right_id;

/*
 * 用户编号Id
*/
@Column(name ="user_id")
private int user_id;

/*
 * 用户名称
*/
@Column(name ="username")
private String username;

/*
 * 修改者编号
*/
@Column(name ="right_id")
private int right_id;

/*
 * 修改者名称
*/
@Column(name ="user_name2")
private String user_name2;

/*
 * 修改时间
*/
@Column(name ="createdate")
private String createdate;


public void setUser_right_id(int user_right_id){
this.user_right_id=user_right_id;
}
public int getUser_right_id(){
return this.user_right_id;
}

public void setUser_id(int user_id){
this.user_id=user_id;
}
public int getUser_id(){
return this.user_id;
}

public void setUsername(String username){
this.username=username;
}
public String getUsername(){
return this.username;
}

public void setRight_id(int right_id){
this.right_id=right_id;
}
public int getRight_id(){
return this.right_id;
}

public void setUser_name2(String user_name2){
this.user_name2=user_name2;
}
public String getUser_name2(){
return this.user_name2;
}

public void setCreatedate(String createdate){
this.createdate=createdate;
}
public String getCreatedate(){
return this.createdate;
}

}
