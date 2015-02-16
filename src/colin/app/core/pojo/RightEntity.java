package colin.app.core.pojo;
import javax.persistence.*;

/**
 * Created by joker on 15-2-16.
 * POJO类 RightEntity
 */
@Entity
@Table(name="right")
public class RightEntity{

/*
 * 权限编号
*/
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
@Column(name ="right_id")
private int right_id;

/*
 * 权限名称
*/
@Column(name ="right_name")
private String right_name;

/*
 * 权限分栏号
*/
@Column(name ="right_column_id")
private int right_column_id;

/*
 * 权限编号
*/
@Column(name ="right")
private String right;


public void setRight_id(int right_id){
this.right_id=right_id;
}
public int getRight_id(){
return this.right_id;
}

public void setRight_name(String right_name){
this.right_name=right_name;
}
public String getRight_name(){
return this.right_name;
}

public void setRight_column_id(int right_column_id){
this.right_column_id=right_column_id;
}
public int getRight_column_id(){
return this.right_column_id;
}

public void setRight(String right){
this.right=right;
}
public String getRight(){
return this.right;
}

}
