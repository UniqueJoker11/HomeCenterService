package colin.app.core.pojo;
import javax.persistence.*;

/**
 * Created by joker on 15-2-16.
 * POJO类 RightRoleEntity
 */
@Entity
@Table(name="rightRole")
public class RightRoleEntity{

/*
 * 权限映射id
*/
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
@Column(name ="right_role_id")
private int right_role_id;

/*
 * 权限名称
*/
@Column(name ="right")
private String right;

/*
 * 权限所属组编号，映射到groupmanager表，非空
*/
@Column(name ="groupid")
private int groupid;

/*
 * 创建者编号
*/
@Column(name ="masterid")
private int masterid;

/*
 * 创建者名称
*/
@Column(name ="mastername")
private String mastername;

/*
 * 创建者时间
*/
@Column(name ="createdate")
private String createdate;


public void setRight_role_id(int right_role_id){
this.right_role_id=right_role_id;
}
public int getRight_role_id(){
return this.right_role_id;
}

public void setRight(String right){
this.right=right;
}
public String getRight(){
return this.right;
}

public void setGroupid(int groupid){
this.groupid=groupid;
}
public int getGroupid(){
return this.groupid;
}

public void setMasterid(int masterid){
this.masterid=masterid;
}
public int getMasterid(){
return this.masterid;
}

public void setMastername(String mastername){
this.mastername=mastername;
}
public String getMastername(){
return this.mastername;
}

public void setCreatedate(String createdate){
this.createdate=createdate;
}
public String getCreatedate(){
return this.createdate;
}

}
