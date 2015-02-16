package colin.app.core.pojo;
import javax.persistence.*;

/**
 * Created by joker on 15-2-16.
 * POJO类 SysRoleEntity
 */
@Entity
@Table(name="sysrole")
public class SysRoleEntity{

/*
 * 系统角色编号
*/
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
@Column(name ="role_id")
private int role_id;

/*
 * 角色名称
*/
@Column(name ="role_name")
private String role_name;

/*
 * 角色信息
*/
@Column(name ="role_info")
private String role_info;

/*
 * 创建者编号
*/
@Column(name ="user_id")
private int user_id;

/*
 * 创建者名称
*/
@Column(name ="user_name")
private String user_name;

/*
 * 角色创建时间
*/
@Column(name ="createdate")
private String createdate;


public void setRole_id(int role_id){
this.role_id=role_id;
}
public int getRole_id(){
return this.role_id;
}

public void setRole_name(String role_name){
this.role_name=role_name;
}
public String getRole_name(){
return this.role_name;
}

public void setRole_info(String role_info){
this.role_info=role_info;
}
public String getRole_info(){
return this.role_info;
}

public void setUser_id(int user_id){
this.user_id=user_id;
}
public int getUser_id(){
return this.user_id;
}

public void setUser_name(String user_name){
this.user_name=user_name;
}
public String getUser_name(){
return this.user_name;
}

public void setCreatedate(String createdate){
this.createdate=createdate;
}
public String getCreatedate(){
return this.createdate;
}

}
