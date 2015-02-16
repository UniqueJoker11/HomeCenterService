package colin.app.core.pojo;
import javax.persistence.*;

/**
 * Created by joker on 15-2-16.
 * POJO类 RightColumnEntity
 */
@Entity
@Table(name="rightColumn")
public class RightColumnEntity{

/*
 * 权限分栏编号
*/
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
@Column(name ="right_column_id")
private int right_column_id;

/*
 * right_column_name
*/
@Column(name ="right_column_name")
private String right_column_name;


public void setRight_column_id(int right_column_id){
this.right_column_id=right_column_id;
}
public int getRight_column_id(){
return this.right_column_id;
}

public void setRight_column_name(String right_column_name){
this.right_column_name=right_column_name;
}
public String getRight_column_name(){
return this.right_column_name;
}

}
